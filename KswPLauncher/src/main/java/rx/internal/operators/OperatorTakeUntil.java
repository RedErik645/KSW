package rx.internal.operators;

import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeUntil<T, E> implements Observable.Operator<T, T> {
    private final Observable<? extends E> other;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTakeUntil(Observable<? extends E> other2) {
        this.other = other2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        final Subscriber<T> serial = new SerializedSubscriber<>(child, false);
        final Subscriber<T> main = new Subscriber<T>(false, serial) {
            /* class rx.internal.operators.OperatorTakeUntil.AnonymousClass1 */

            @Override // rx.Observer
            public void onNext(T t) {
                serial.onNext(t);
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                try {
                    serial.onError(e);
                } finally {
                    serial.unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                try {
                    serial.onCompleted();
                } finally {
                    serial.unsubscribe();
                }
            }
        };
        Subscriber<E> so = new Subscriber<E>() {
            /* class rx.internal.operators.OperatorTakeUntil.AnonymousClass2 */

            @Override // rx.Subscriber
            public void onStart() {
                request(LongCompanionObject.MAX_VALUE);
            }

            @Override // rx.Observer
            public void onCompleted() {
                main.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                main.onError(e);
            }

            @Override // rx.Observer
            public void onNext(E e) {
                onCompleted();
            }
        };
        serial.add(main);
        serial.add(so);
        child.add(serial);
        this.other.unsafeSubscribe(so);
        return main;
    }
}
