package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.producers.SingleProducer;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeToObservableFuture {
    private OnSubscribeToObservableFuture() {
        throw new IllegalStateException("No instances!");
    }

    /* access modifiers changed from: package-private */
    public static class ToObservableFuture<T> implements Observable.OnSubscribe<T> {
        final Future<? extends T> that;
        private final long time;
        private final TimeUnit unit;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public ToObservableFuture(Future<? extends T> that2) {
            this.that = that2;
            this.time = 0;
            this.unit = null;
        }

        public ToObservableFuture(Future<? extends T> that2, long time2, TimeUnit unit2) {
            this.that = that2;
            this.time = time2;
            this.unit = unit2;
        }

        public void call(Subscriber<? super T> subscriber) {
            subscriber.add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OnSubscribeToObservableFuture.ToObservableFuture.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    ToObservableFuture.this.that.cancel(true);
                }
            }));
            try {
                if (!subscriber.isUnsubscribed()) {
                    TimeUnit timeUnit = this.unit;
                    subscriber.setProducer(new SingleProducer(subscriber, timeUnit == null ? this.that.get() : this.that.get(this.time, timeUnit)));
                }
            } catch (Throwable e) {
                if (!subscriber.isUnsubscribed()) {
                    Exceptions.throwOrReport(e, subscriber);
                }
            }
        }
    }

    public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> that) {
        return new ToObservableFuture(that);
    }

    public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> that, long time, TimeUnit unit) {
        return new ToObservableFuture(that, time, unit);
    }
}
