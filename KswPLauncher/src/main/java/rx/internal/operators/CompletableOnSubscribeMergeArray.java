package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Subscription;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeArray implements Completable.CompletableOnSubscribe {
    final Completable[] sources;

    public CompletableOnSubscribeMergeArray(Completable[] sources2) {
        this.sources = sources2;
    }

    public void call(final Completable.CompletableSubscriber s) {
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger(this.sources.length + 1);
        final AtomicBoolean once = new AtomicBoolean();
        s.onSubscribe(set);
        Completable[] arr$ = this.sources;
        for (Completable c : arr$) {
            if (!set.isUnsubscribed()) {
                if (c == null) {
                    set.unsubscribe();
                    NullPointerException npe = new NullPointerException("A completable source is null");
                    if (once.compareAndSet(false, true)) {
                        s.onError(npe);
                        return;
                    }
                    RxJavaHooks.onError(npe);
                }
                c.unsafeSubscribe(new Completable.CompletableSubscriber() {
                    /* class rx.internal.operators.CompletableOnSubscribeMergeArray.AnonymousClass1 */

                    @Override // rx.Completable.CompletableSubscriber
                    public void onSubscribe(Subscription d) {
                        set.add(d);
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onError(Throwable e) {
                        set.unsubscribe();
                        if (once.compareAndSet(false, true)) {
                            s.onError(e);
                        } else {
                            RxJavaHooks.onError(e);
                        }
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onCompleted() {
                        if (wip.decrementAndGet() == 0 && once.compareAndSet(false, true)) {
                            s.onCompleted();
                        }
                    }
                });
            } else {
                return;
            }
        }
        if (wip.decrementAndGet() == 0 && once.compareAndSet(false, true)) {
            s.onCompleted();
        }
    }
}