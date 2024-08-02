package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;

public final class BooleanSubscription implements Subscription {
    static final Action0 EMPTY_ACTION = new Action0() {
        /* class rx.subscriptions.BooleanSubscription.AnonymousClass1 */

        @Override // rx.functions.Action0
        public void call() {
        }
    };
    final AtomicReference<Action0> actionRef;

    public BooleanSubscription() {
        this.actionRef = new AtomicReference<>();
    }

    private BooleanSubscription(Action0 action) {
        this.actionRef = new AtomicReference<>(action);
    }

    public static BooleanSubscription create() {
        return new BooleanSubscription();
    }

    public static BooleanSubscription create(Action0 onUnsubscribe) {
        return new BooleanSubscription(onUnsubscribe);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.actionRef.get() == EMPTY_ACTION;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        Action0 action;
        Action0 action2 = this.actionRef.get();
        Action0 action0 = EMPTY_ACTION;
        if (action2 != action0 && (action = this.actionRef.getAndSet(action0)) != null && action != action0) {
            action.call();
        }
    }
}
