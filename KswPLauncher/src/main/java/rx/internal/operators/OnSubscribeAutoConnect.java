package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;

public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements Observable.OnSubscribe<T> {
    final Action1<? super Subscription> connection;
    final int numberOfSubscribers;
    final ConnectableObservable<? extends T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeAutoConnect(ConnectableObservable<? extends T> source2, int numberOfSubscribers2, Action1<? super Subscription> connection2) {
        if (numberOfSubscribers2 > 0) {
            this.source = source2;
            this.numberOfSubscribers = numberOfSubscribers2;
            this.connection = connection2;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(Subscriber<? super T> child) {
        this.source.unsafeSubscribe(Subscribers.wrap(child));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.connect(this.connection);
        }
    }
}
