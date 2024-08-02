package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public final class OnSubscribeTakeLastOne<T> implements Observable.OnSubscribe<T> {
    final Observable<T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeTakeLastOne(Observable<T> source2) {
        this.source = source2;
    }

    public void call(Subscriber<? super T> t) {
        new TakeLastOneSubscriber(t).subscribeTo(this.source);
    }

    /* access modifiers changed from: package-private */
    public static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscriber<T, T> {
        static final Object EMPTY = new Object();

        public TakeLastOneSubscriber(Subscriber<? super T> actual) {
            super(actual);
            this.value = EMPTY;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.value = t;
        }

        @Override // rx.internal.operators.DeferredScalarSubscriber, rx.Observer
        public void onCompleted() {
            Object o = this.value;
            if (o == EMPTY) {
                complete();
            } else {
                complete(o);
            }
        }
    }
}
