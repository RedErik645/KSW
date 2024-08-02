package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

public final class OnSubscribeReduceSeed<T, R> implements Observable.OnSubscribe<R> {
    final R initialValue;
    final Func2<R, ? super T, R> reducer;
    final Observable<T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeReduceSeed(Observable<T> source2, R initialValue2, Func2<R, ? super T, R> reducer2) {
        this.source = source2;
        this.initialValue = initialValue2;
        this.reducer = reducer2;
    }

    public void call(Subscriber<? super R> t) {
        new ReduceSeedSubscriber(t, this.initialValue, this.reducer).subscribeTo(this.source);
    }

    /* access modifiers changed from: package-private */
    public static final class ReduceSeedSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        final Func2<R, ? super T, R> reducer;

        public ReduceSeedSubscriber(Subscriber<? super R> actual, R initialValue, Func2<R, ? super T, R> reducer2) {
            super(actual);
            this.value = initialValue;
            this.hasValue = true;
            this.reducer = reducer2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: rx.functions.Func2<R, ? super T, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(T t) {
            try {
                this.value = this.reducer.call(this.value, t);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                unsubscribe();
                this.actual.onError(ex);
            }
        }
    }
}
