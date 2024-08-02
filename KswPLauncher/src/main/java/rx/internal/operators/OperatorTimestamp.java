package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

public final class OperatorTimestamp<T> implements Observable.Operator<Timestamped<T>, T> {
    final Scheduler scheduler;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTimestamp(Scheduler scheduler2) {
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super Timestamped<T>> o) {
        return new Subscriber<T>(o) {
            /* class rx.internal.operators.OperatorTimestamp.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
                o.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                o.onError(e);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: rx.Subscriber */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(T t) {
                o.onNext(new Timestamped(OperatorTimestamp.this.scheduler.now(), t));
            }
        };
    }
}
