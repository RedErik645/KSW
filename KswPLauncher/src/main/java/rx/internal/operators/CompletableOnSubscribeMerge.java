package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Completable;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMerge implements Completable.CompletableOnSubscribe {
    final boolean delayErrors;
    final int maxConcurrency;
    final Observable<Completable> source;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.Observable<? extends rx.Completable> */
    /* JADX WARN: Multi-variable type inference failed */
    public CompletableOnSubscribeMerge(Observable<? extends Completable> source2, int maxConcurrency2, boolean delayErrors2) {
        this.source = source2;
        this.maxConcurrency = maxConcurrency2;
        this.delayErrors = delayErrors2;
    }

    public void call(Completable.CompletableSubscriber s) {
        CompletableMergeSubscriber parent = new CompletableMergeSubscriber(s, this.maxConcurrency, this.delayErrors);
        s.onSubscribe(parent);
        this.source.subscribe((Subscriber<? super Completable>) parent);
    }

    /* access modifiers changed from: package-private */
    public static final class CompletableMergeSubscriber extends Subscriber<Completable> {
        final Completable.CompletableSubscriber actual;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Queue<Throwable>> errors = new AtomicReference<>();
        final int maxConcurrency;
        final AtomicBoolean once = new AtomicBoolean();
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger(1);

        public CompletableMergeSubscriber(Completable.CompletableSubscriber actual2, int maxConcurrency2, boolean delayErrors2) {
            this.actual = actual2;
            this.maxConcurrency = maxConcurrency2;
            this.delayErrors = delayErrors2;
            if (maxConcurrency2 == Integer.MAX_VALUE) {
                request(LongCompanionObject.MAX_VALUE);
            } else {
                request((long) maxConcurrency2);
            }
        }

        /* access modifiers changed from: package-private */
        public Queue<Throwable> getOrCreateErrors() {
            Queue<Throwable> q = this.errors.get();
            if (q != null) {
                return q;
            }
            Queue<Throwable> q2 = new ConcurrentLinkedQueue<>();
            if (this.errors.compareAndSet(null, q2)) {
                return q2;
            }
            return this.errors.get();
        }

        public void onNext(Completable t) {
            if (!this.done) {
                this.wip.getAndIncrement();
                t.unsafeSubscribe(new Completable.CompletableSubscriber() {
                    /* class rx.internal.operators.CompletableOnSubscribeMerge.CompletableMergeSubscriber.AnonymousClass1 */
                    Subscription d;
                    boolean innerDone;

                    @Override // rx.Completable.CompletableSubscriber
                    public void onSubscribe(Subscription d2) {
                        this.d = d2;
                        CompletableMergeSubscriber.this.set.add(d2);
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onError(Throwable e) {
                        if (this.innerDone) {
                            RxJavaHooks.onError(e);
                            return;
                        }
                        this.innerDone = true;
                        CompletableMergeSubscriber.this.set.remove(this.d);
                        CompletableMergeSubscriber.this.getOrCreateErrors().offer(e);
                        CompletableMergeSubscriber.this.terminate();
                        if (CompletableMergeSubscriber.this.delayErrors && !CompletableMergeSubscriber.this.done) {
                            CompletableMergeSubscriber.this.request(1);
                        }
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onCompleted() {
                        if (!this.innerDone) {
                            this.innerDone = true;
                            CompletableMergeSubscriber.this.set.remove(this.d);
                            CompletableMergeSubscriber.this.terminate();
                            if (!CompletableMergeSubscriber.this.done) {
                                CompletableMergeSubscriber.this.request(1);
                            }
                        }
                    }
                });
            }
        }

        @Override // rx.Observer
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaHooks.onError(t);
                return;
            }
            getOrCreateErrors().offer(t);
            this.done = true;
            terminate();
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                terminate();
            }
        }

        /* access modifiers changed from: package-private */
        public void terminate() {
            Queue<Throwable> q;
            if (this.wip.decrementAndGet() == 0) {
                Queue<Throwable> q2 = this.errors.get();
                if (q2 == null || q2.isEmpty()) {
                    this.actual.onCompleted();
                    return;
                }
                Throwable e = CompletableOnSubscribeMerge.collectErrors(q2);
                if (this.once.compareAndSet(false, true)) {
                    this.actual.onError(e);
                } else {
                    RxJavaHooks.onError(e);
                }
            } else if (!this.delayErrors && (q = this.errors.get()) != null && !q.isEmpty()) {
                Throwable e2 = CompletableOnSubscribeMerge.collectErrors(q);
                if (this.once.compareAndSet(false, true)) {
                    this.actual.onError(e2);
                } else {
                    RxJavaHooks.onError(e2);
                }
            }
        }
    }

    public static Throwable collectErrors(Queue<Throwable> q) {
        List<Throwable> list = new ArrayList<>();
        while (true) {
            Throwable t = q.poll();
            if (t == null) {
                break;
            }
            list.add(t);
        }
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new CompositeException(list);
    }
}
