package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

public final class OperatorThrottleFirst<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeInMilliseconds;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorThrottleFirst(long windowDuration, TimeUnit unit, Scheduler scheduler2) {
        this.timeInMilliseconds = unit.toMillis(windowDuration);
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorThrottleFirst.AnonymousClass1 */
            private long lastOnNext;

            @Override // rx.Subscriber
            public void onStart() {
                request(LongCompanionObject.MAX_VALUE);
            }

            @Override // rx.Observer
            public void onNext(T v) {
                long now = OperatorThrottleFirst.this.scheduler.now();
                long j = this.lastOnNext;
                if (j == 0 || now - j >= OperatorThrottleFirst.this.timeInMilliseconds) {
                    this.lastOnNext = now;
                    subscriber.onNext(v);
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                subscriber.onError(e);
            }
        };
    }
}
