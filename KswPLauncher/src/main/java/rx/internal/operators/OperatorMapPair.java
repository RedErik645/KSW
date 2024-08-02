package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.plugins.RxJavaHooks;

public final class OperatorMapPair<T, U, R> implements Observable.Operator<Observable<? extends R>, T> {
    final Func1<? super T, ? extends Observable<? extends U>> collectionSelector;
    final Func2<? super T, ? super U, ? extends R> resultSelector;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public static <T, U> Func1<T, Observable<U>> convertSelector(final Func1<? super T, ? extends Iterable<? extends U>> selector) {
        return new Func1<T, Observable<U>>() {
            /* class rx.internal.operators.OperatorMapPair.AnonymousClass1 */

            @Override // rx.functions.Func1
            public Observable<U> call(T t1) {
                return Observable.from((Iterable) selector.call(t1));
            }
        };
    }

    public OperatorMapPair(Func1<? super T, ? extends Observable<? extends U>> collectionSelector2, Func2<? super T, ? super U, ? extends R> resultSelector2) {
        this.collectionSelector = collectionSelector2;
        this.resultSelector = resultSelector2;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<? extends R>> o) {
        MapPairSubscriber<T, U, R> parent = new MapPairSubscriber<>(o, this.collectionSelector, this.resultSelector);
        o.add(parent);
        return parent;
    }

    /* access modifiers changed from: package-private */
    public static final class MapPairSubscriber<T, U, R> extends Subscriber<T> {
        final Subscriber<? super Observable<? extends R>> actual;
        final Func1<? super T, ? extends Observable<? extends U>> collectionSelector;
        boolean done;
        final Func2<? super T, ? super U, ? extends R> resultSelector;

        public MapPairSubscriber(Subscriber<? super Observable<? extends R>> actual2, Func1<? super T, ? extends Observable<? extends U>> collectionSelector2, Func2<? super T, ? super U, ? extends R> resultSelector2) {
            this.actual = actual2;
            this.collectionSelector = collectionSelector2;
            this.resultSelector = resultSelector2;
        }

        @Override // rx.Observer
        public void onNext(T outer) {
            try {
                this.actual.onNext(((Observable) this.collectionSelector.call(outer)).map(new OuterInnerMapper<>(outer, this.resultSelector)));
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(ex, outer));
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (this.done) {
                RxJavaHooks.onError(e);
                return;
            }
            this.done = true;
            this.actual.onError(e);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.actual.onCompleted();
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer p) {
            this.actual.setProducer(p);
        }
    }

    static final class OuterInnerMapper<T, U, R> implements Func1<U, R> {
        final T outer;
        final Func2<? super T, ? super U, ? extends R> resultSelector;

        public OuterInnerMapper(T outer2, Func2<? super T, ? super U, ? extends R> resultSelector2) {
            this.outer = outer2;
            this.resultSelector = resultSelector2;
        }

        @Override // rx.functions.Func1
        public R call(U inner) {
            return (R) this.resultSelector.call(this.outer, inner);
        }
    }
}
