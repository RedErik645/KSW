package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

public final class OperatorDoAfterTerminate<T> implements Observable.Operator<T, T> {
    final Action0 action;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDoAfterTerminate(Action0 action2) {
        if (action2 != null) {
            this.action = action2;
            return;
        }
        throw new NullPointerException("Action can not be null");
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        return new Subscriber<T>(child) {
            /* class rx.internal.operators.OperatorDoAfterTerminate.AnonymousClass1 */

            @Override // rx.Observer
            public void onNext(T t) {
                child.onNext(t);
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                try {
                    child.onError(e);
                } finally {
                    callAction();
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                try {
                    child.onCompleted();
                } finally {
                    callAction();
                }
            }

            /* access modifiers changed from: package-private */
            public void callAction() {
                try {
                    OperatorDoAfterTerminate.this.action.call();
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    RxJavaHooks.onError(ex);
                }
            }
        };
    }
}
