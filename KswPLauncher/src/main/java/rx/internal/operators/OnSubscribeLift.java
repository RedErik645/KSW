package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeLift<T, R> implements Observable.OnSubscribe<R> {
    final Observable.Operator<? extends R, ? super T> operator;
    final Observable.OnSubscribe<T> parent;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeLift(Observable.OnSubscribe<T> parent2, Observable.Operator<? extends R, ? super T> operator2) {
        this.parent = parent2;
        this.operator = operator2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: rx.Observable$OnSubscribe<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(Subscriber<? super R> o) {
        try {
            Subscriber subscriber = (Subscriber) RxJavaHooks.onObservableLift(this.operator).call(o);
            try {
                subscriber.onStart();
                this.parent.call(subscriber);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                subscriber.onError(e);
            }
        } catch (Throwable e2) {
            Exceptions.throwIfFatal(e2);
            o.onError(e2);
        }
    }
}
