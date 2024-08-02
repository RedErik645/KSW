package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action2;
import rx.functions.Func0;

public final class OnSubscribeCollect<T, R> implements Observable.OnSubscribe<R> {
    final Func0<R> collectionFactory;
    final Action2<R, ? super T> collector;
    final Observable<T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeCollect(Observable<T> source2, Func0<R> collectionFactory2, Action2<R, ? super T> collector2) {
        this.source = source2;
        this.collectionFactory = collectionFactory2;
        this.collector = collector2;
    }

    public void call(Subscriber<? super R> t) {
        try {
            new CollectSubscriber(t, this.collectionFactory.call(), this.collector).subscribeTo(this.source);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            t.onError(ex);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class CollectSubscriber<T, R> extends DeferredScalarSubscriberSafe<T, R> {
        final Action2<R, ? super T> collector;

        public CollectSubscriber(Subscriber<? super R> actual, R initialValue, Action2<R, ? super T> collector2) {
            super(actual);
            this.value = initialValue;
            this.hasValue = true;
            this.collector = collector2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.functions.Action2<R, ? super T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.collector.call(this.value, t);
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    unsubscribe();
                    onError(ex);
                }
            }
        }
    }
}
