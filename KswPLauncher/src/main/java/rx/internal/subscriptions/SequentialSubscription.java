package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public final class SequentialSubscription extends AtomicReference<Subscription> implements Subscription {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public SequentialSubscription(Subscription initial) {
        lazySet(initial);
    }

    public Subscription current() {
        Subscription current = (Subscription) super.get();
        if (current == Unsubscribed.INSTANCE) {
            return Subscriptions.unsubscribed();
        }
        return current;
    }

    public boolean update(Subscription next) {
        Subscription current;
        do {
            current = (Subscription) get();
            if (current == Unsubscribed.INSTANCE) {
                if (next == null) {
                    return false;
                }
                next.unsubscribe();
                return false;
            }
        } while (!compareAndSet(current, next));
        if (current == null) {
            return true;
        }
        current.unsubscribe();
        return true;
    }

    public boolean replace(Subscription next) {
        Subscription current;
        do {
            current = (Subscription) get();
            if (current == Unsubscribed.INSTANCE) {
                if (next == null) {
                    return false;
                }
                next.unsubscribe();
                return false;
            }
        } while (!compareAndSet(current, next));
        return true;
    }

    public boolean updateWeak(Subscription next) {
        Subscription current = (Subscription) get();
        if (current == Unsubscribed.INSTANCE) {
            if (next != null) {
                next.unsubscribe();
            }
            return false;
        } else if (compareAndSet(current, next)) {
            return true;
        } else {
            Subscription current2 = (Subscription) get();
            if (next != null) {
                next.unsubscribe();
            }
            if (current2 == Unsubscribed.INSTANCE) {
                return true;
            }
            return false;
        }
    }

    public boolean replaceWeak(Subscription next) {
        Subscription current = (Subscription) get();
        if (current == Unsubscribed.INSTANCE) {
            if (next != null) {
                next.unsubscribe();
            }
            return false;
        } else if (compareAndSet(current, next) || ((Subscription) get()) != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (next != null) {
                next.unsubscribe();
            }
            return false;
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        Subscription current;
        if (((Subscription) get()) != Unsubscribed.INSTANCE && (current = (Subscription) getAndSet(Unsubscribed.INSTANCE)) != null && current != Unsubscribed.INSTANCE) {
            current.unsubscribe();
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return get() == Unsubscribed.INSTANCE;
    }
}
