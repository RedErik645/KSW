package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableFromFuture<T> extends Flowable<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public FlowableFromFuture(Future<? extends T> future2, long timeout2, TimeUnit unit2) {
        this.future = future2;
        this.timeout = timeout2;
        this.unit = unit2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.internal.subscriptions.DeferredScalarSubscription */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(s);
        s.onSubscribe(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.unit;
            Object obj = timeUnit != null ? this.future.get(this.timeout, timeUnit) : this.future.get();
            if (obj == null) {
                s.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.complete(obj);
            }
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            if (!deferredScalarSubscription.isCancelled()) {
                s.onError(ex);
            }
        }
    }
}
