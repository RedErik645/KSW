package rx.observers;

import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

public abstract class AsyncCompletableSubscriber implements Completable.CompletableSubscriber, Subscription {
    static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();
    private final AtomicReference<Subscription> upstream = new AtomicReference<>();

    @Override // rx.Completable.CompletableSubscriber
    public final void onSubscribe(Subscription d) {
        if (!this.upstream.compareAndSet(null, d)) {
            d.unsubscribe();
            if (this.upstream.get() != UNSUBSCRIBED) {
                RxJavaHooks.onError(new IllegalStateException("Subscription already set!"));
                return;
            }
            return;
        }
        onStart();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.upstream.get() == UNSUBSCRIBED;
    }

    /* access modifiers changed from: protected */
    public final void clear() {
        this.upstream.set(UNSUBSCRIBED);
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        Subscription current;
        Subscription current2 = this.upstream.get();
        Unsubscribed unsubscribed = UNSUBSCRIBED;
        if (current2 != unsubscribed && (current = this.upstream.getAndSet(unsubscribed)) != null && current != unsubscribed) {
            current.unsubscribe();
        }
    }

    static final class Unsubscribed implements Subscription {
        Unsubscribed() {
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }
    }
}
