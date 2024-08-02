package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSerialize<T> implements Observable.Operator<T, T> {
    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* access modifiers changed from: package-private */
    public static final class Holder {
        static final OperatorSerialize<Object> INSTANCE = new OperatorSerialize<>();

        Holder() {
        }
    }

    public static <T> OperatorSerialize<T> instance() {
        return (OperatorSerialize<T>) Holder.INSTANCE;
    }

    OperatorSerialize() {
    }

    public Subscriber<? super T> call(final Subscriber<? super T> s) {
        return new SerializedSubscriber(new Subscriber<T>(s) {
            /* class rx.internal.operators.OperatorSerialize.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
                s.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                s.onError(e);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                s.onNext(t);
            }
        });
    }
}
