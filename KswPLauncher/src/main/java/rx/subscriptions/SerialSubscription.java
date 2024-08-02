package rx.subscriptions;

import rx.Subscription;
import rx.internal.subscriptions.SequentialSubscription;

public final class SerialSubscription implements Subscription {
    final SequentialSubscription state = new SequentialSubscription();

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.state.isUnsubscribed();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.state.unsubscribe();
    }

    public void set(Subscription s) {
        if (s != null) {
            this.state.update(s);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    public Subscription get() {
        return this.state.current();
    }
}
