package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public final class OnSubscribeThrow<T> implements Observable.OnSubscribe<T> {
    private final Throwable exception;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeThrow(Throwable exception2) {
        this.exception = exception2;
    }

    public void call(Subscriber<? super T> observer) {
        observer.onError(this.exception);
    }
}
