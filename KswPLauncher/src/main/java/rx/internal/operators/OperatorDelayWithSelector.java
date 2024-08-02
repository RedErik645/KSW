package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;
import rx.subjects.PublishSubject;

public final class OperatorDelayWithSelector<T, V> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends Observable<V>> itemDelay;
    final Observable<? extends T> source;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDelayWithSelector(Observable<? extends T> source2, Func1<? super T, ? extends Observable<V>> itemDelay2) {
        this.source = source2;
        this.itemDelay = itemDelay2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> _child) {
        final SerializedSubscriber<T> child = new SerializedSubscriber<>(_child);
        final PublishSubject<Observable<T>> delayedEmissions = PublishSubject.create();
        _child.add(Observable.merge(delayedEmissions).unsafeSubscribe(Subscribers.from(child)));
        return new Subscriber<T>(_child) {
            /* class rx.internal.operators.OperatorDelayWithSelector.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
                delayedEmissions.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                child.onError(e);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: rx.subjects.PublishSubject */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(final T t) {
                try {
                    delayedEmissions.onNext(((Observable) OperatorDelayWithSelector.this.itemDelay.call(t)).take(1).defaultIfEmpty(null).map(new Func1<V, T>() {
                        /* class rx.internal.operators.OperatorDelayWithSelector.AnonymousClass1.AnonymousClass1 */

                        @Override // rx.functions.Func1
                        public T call(V v) {
                            return (T) t;
                        }
                    }));
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, this);
                }
            }
        };
    }
}
