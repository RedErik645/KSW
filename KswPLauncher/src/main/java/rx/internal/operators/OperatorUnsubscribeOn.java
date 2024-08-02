package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public class OperatorUnsubscribeOn<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorUnsubscribeOn(Scheduler scheduler2) {
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final Subscriber<T> parent = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorUnsubscribeOn.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                subscriber.onError(e);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                subscriber.onNext(t);
            }
        };
        subscriber.add(Subscriptions.create(new Action0() {
            /* class rx.internal.operators.OperatorUnsubscribeOn.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                final Scheduler.Worker inner = OperatorUnsubscribeOn.this.scheduler.createWorker();
                inner.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorUnsubscribeOn.AnonymousClass2.AnonymousClass1 */

                    @Override // rx.functions.Action0
                    public void call() {
                        parent.unsubscribe();
                        inner.unsubscribe();
                    }
                });
            }
        }));
        return parent;
    }
}
