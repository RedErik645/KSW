package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class CompletableOnSubscribeConcat implements Completable.CompletableOnSubscribe {
    final int prefetch;
    final Observable<Completable> sources;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.Observable<? extends rx.Completable> */
    /* JADX WARN: Multi-variable type inference failed */
    public CompletableOnSubscribeConcat(Observable<? extends Completable> sources2, int prefetch2) {
        this.sources = sources2;
        this.prefetch = prefetch2;
    }

    public void call(Completable.CompletableSubscriber s) {
        CompletableConcatSubscriber parent = new CompletableConcatSubscriber(s, this.prefetch);
        s.onSubscribe(parent);
        this.sources.subscribe((Subscriber<? super Completable>) parent);
    }

    /* access modifiers changed from: package-private */
    public static final class CompletableConcatSubscriber extends Subscriber<Completable> {
        final Completable.CompletableSubscriber actual;
        volatile boolean done;
        final ConcatInnerSubscriber inner = new ConcatInnerSubscriber();
        final AtomicBoolean once = new AtomicBoolean();
        final int prefetch;
        final SpscArrayQueue<Completable> queue;
        final SerialSubscription sr;
        final AtomicInteger wip = new AtomicInteger();

        public CompletableConcatSubscriber(Completable.CompletableSubscriber actual2, int prefetch2) {
            this.actual = actual2;
            this.prefetch = prefetch2;
            this.queue = new SpscArrayQueue<>(prefetch2);
            SerialSubscription serialSubscription = new SerialSubscription();
            this.sr = serialSubscription;
            add(serialSubscription);
            request((long) prefetch2);
        }

        public void onNext(Completable t) {
            if (!this.queue.offer(t)) {
                onError(new MissingBackpressureException());
            } else if (this.wip.getAndIncrement() == 0) {
                next();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable t) {
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(t);
            } else {
                RxJavaHooks.onError(t);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                if (this.wip.getAndIncrement() == 0) {
                    next();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void innerError(Throwable e) {
            unsubscribe();
            onError(e);
        }

        /* access modifiers changed from: package-private */
        public void innerComplete() {
            if (this.wip.decrementAndGet() != 0) {
                next();
            }
            if (!this.done) {
                request(1);
            }
        }

        /* access modifiers changed from: package-private */
        public void next() {
            boolean d = this.done;
            Completable c = this.queue.poll();
            if (c != null) {
                c.unsafeSubscribe(this.inner);
            } else if (!d) {
                RxJavaHooks.onError(new IllegalStateException("Queue is empty?!"));
            } else if (this.once.compareAndSet(false, true)) {
                this.actual.onCompleted();
            }
        }

        /* access modifiers changed from: package-private */
        public final class ConcatInnerSubscriber implements Completable.CompletableSubscriber {
            ConcatInnerSubscriber() {
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription d) {
                CompletableConcatSubscriber.this.sr.set(d);
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable e) {
                CompletableConcatSubscriber.this.innerError(e);
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                CompletableConcatSubscriber.this.innerComplete();
            }
        }
    }
}
