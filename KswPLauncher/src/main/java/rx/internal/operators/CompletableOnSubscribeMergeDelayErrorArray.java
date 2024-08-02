package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeDelayErrorArray implements Completable.CompletableOnSubscribe {
    final Completable[] sources;

    public CompletableOnSubscribeMergeDelayErrorArray(Completable[] sources2) {
        this.sources = sources2;
    }

    public void call(final Completable.CompletableSubscriber s) {
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger(this.sources.length + 1);
        final Queue<Throwable> q = new ConcurrentLinkedQueue<>();
        s.onSubscribe(set);
        Completable[] arr$ = this.sources;
        for (Completable c : arr$) {
            if (!set.isUnsubscribed()) {
                if (c == null) {
                    q.offer(new NullPointerException("A completable source is null"));
                    wip.decrementAndGet();
                } else {
                    c.unsafeSubscribe(new Completable.CompletableSubscriber() {
                        /* class rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray.AnonymousClass1 */

                        @Override // rx.Completable.CompletableSubscriber
                        public void onSubscribe(Subscription d) {
                            set.add(d);
                        }

                        @Override // rx.Completable.CompletableSubscriber
                        public void onError(Throwable e) {
                            q.offer(e);
                            tryTerminate();
                        }

                        @Override // rx.Completable.CompletableSubscriber
                        public void onCompleted() {
                            tryTerminate();
                        }

                        /* access modifiers changed from: package-private */
                        public void tryTerminate() {
                            if (wip.decrementAndGet() != 0) {
                                return;
                            }
                            if (q.isEmpty()) {
                                s.onCompleted();
                            } else {
                                s.onError(CompletableOnSubscribeMerge.collectErrors(q));
                            }
                        }
                    });
                }
            } else {
                return;
            }
        }
        if (wip.decrementAndGet() != 0) {
            return;
        }
        if (q.isEmpty()) {
            s.onCompleted();
        } else {
            s.onError(CompletableOnSubscribeMerge.collectErrors(q));
        }
    }
}
