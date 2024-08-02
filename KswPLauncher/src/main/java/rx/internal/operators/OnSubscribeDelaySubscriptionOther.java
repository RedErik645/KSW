package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeDelaySubscriptionOther<T, U> implements Observable.OnSubscribe<T> {
    final Observable<? extends T> main;
    final Observable<U> other;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeDelaySubscriptionOther(Observable<? extends T> main2, Observable<U> other2) {
        this.main = main2;
        this.other = other2;
    }

    public void call(Subscriber<? super T> t) {
        final SerialSubscription serial = new SerialSubscription();
        t.add(serial);
        final Subscriber<T> child = Subscribers.wrap(t);
        Subscriber<U> otherSubscriber = new Subscriber<U>() {
            /* class rx.internal.operators.OnSubscribeDelaySubscriptionOther.AnonymousClass1 */
            boolean done;

            @Override // rx.Observer
            public void onNext(U u) {
                onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                if (this.done) {
                    RxJavaHooks.onError(e);
                    return;
                }
                this.done = true;
                child.onError(e);
            }

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    serial.set(Subscriptions.unsubscribed());
                    OnSubscribeDelaySubscriptionOther.this.main.unsafeSubscribe(child);
                }
            }
        };
        serial.set(otherSubscriber);
        this.other.unsafeSubscribe(otherSubscriber);
    }
}
