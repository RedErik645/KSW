package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    public FlowableFromObservable(Observable<T> upstream2) {
        this.upstream = upstream2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        this.upstream.subscribe(new SubscriberObserver(s));
    }

    static final class SubscriberObserver<T> implements Observer<T>, Subscription {
        final Subscriber<? super T> downstream;
        Disposable upstream;

        SubscriberObserver(Subscriber<? super T> s) {
            this.downstream = s;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }

        @Override // io.reactivex.Observer
        public void onNext(T value) {
            this.downstream.onNext(value);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable d) {
            this.upstream = d;
            this.downstream.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
        }
    }
}
