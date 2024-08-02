package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSkipUntil<T, U> implements Observable.Operator<T, T> {
    final Observable<U> other;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorSkipUntil(Observable<U> other2) {
        this.other = other2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        final SerializedSubscriber<T> s = new SerializedSubscriber<>(child);
        final AtomicBoolean gate = new AtomicBoolean();
        Subscriber<U> u = new Subscriber<U>() {
            /* class rx.internal.operators.OperatorSkipUntil.AnonymousClass1 */

            @Override // rx.Observer
            public void onNext(U u) {
                gate.set(true);
                unsubscribe();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                s.onError(e);
                s.unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                unsubscribe();
            }
        };
        child.add(u);
        this.other.unsafeSubscribe(u);
        return new Subscriber<T>(child) {
            /* class rx.internal.operators.OperatorSkipUntil.AnonymousClass2 */

            @Override // rx.Observer
            public void onNext(T t) {
                if (gate.get()) {
                    s.onNext(t);
                } else {
                    request(1);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                s.onError(e);
                unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                s.onCompleted();
                unsubscribe();
            }
        };
    }
}
