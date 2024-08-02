package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.operators.OperatorTimeoutBase;

public final class OperatorTimeout<T> extends OperatorTimeoutBase<T> {
    @Override // rx.internal.operators.OperatorTimeoutBase
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber x0) {
        return super.call(x0);
    }

    public OperatorTimeout(final long timeout, final TimeUnit timeUnit, Observable<? extends T> other, Scheduler scheduler) {
        super(new OperatorTimeoutBase.FirstTimeoutStub<T>() {
            /* class rx.internal.operators.OperatorTimeout.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Subscription call(Object x0, Long l, Scheduler.Worker worker) {
                return call((OperatorTimeoutBase.TimeoutSubscriber) ((OperatorTimeoutBase.TimeoutSubscriber) x0), l, worker);
            }

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long seqId, Scheduler.Worker inner) {
                return inner.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorTimeout.AnonymousClass1.AnonymousClass1 */

                    @Override // rx.functions.Action0
                    public void call() {
                        timeoutSubscriber.onTimeout(seqId.longValue());
                    }
                }, timeout, timeUnit);
            }
        }, new OperatorTimeoutBase.TimeoutStub<T>() {
            /* class rx.internal.operators.OperatorTimeout.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func4
            public /* bridge */ /* synthetic */ Subscription call(Object x0, Long l, Object x2, Scheduler.Worker worker) {
                return call((OperatorTimeoutBase.TimeoutSubscriber) ((OperatorTimeoutBase.TimeoutSubscriber) x0), l, x2, worker);
            }

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long seqId, T t, Scheduler.Worker inner) {
                return inner.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorTimeout.AnonymousClass2.AnonymousClass1 */

                    @Override // rx.functions.Action0
                    public void call() {
                        timeoutSubscriber.onTimeout(seqId.longValue());
                    }
                }, timeout, timeUnit);
            }
        }, other, scheduler);
    }
}
