package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.operators.OperatorTimeoutBase;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class OperatorTimeoutWithSelector<T, U, V> extends OperatorTimeoutBase<T> {
    @Override // rx.internal.operators.OperatorTimeoutBase
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber x0) {
        return super.call(x0);
    }

    public OperatorTimeoutWithSelector(final Func0<? extends Observable<U>> firstTimeoutSelector, final Func1<? super T, ? extends Observable<V>> timeoutSelector, Observable<? extends T> other) {
        super(new OperatorTimeoutBase.FirstTimeoutStub<T>() {
            /* class rx.internal.operators.OperatorTimeoutWithSelector.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Subscription call(Object x0, Long l, Scheduler.Worker worker) {
                return call((OperatorTimeoutBase.TimeoutSubscriber) ((OperatorTimeoutBase.TimeoutSubscriber) x0), l, worker);
            }

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long seqId, Scheduler.Worker inner) {
                Func0 func0 = Func0.this;
                if (func0 == null) {
                    return Subscriptions.unsubscribed();
                }
                try {
                    return ((Observable) func0.call()).unsafeSubscribe(new Subscriber<U>() {
                        /* class rx.internal.operators.OperatorTimeoutWithSelector.AnonymousClass1.AnonymousClass1 */

                        @Override // rx.Observer
                        public void onCompleted() {
                            timeoutSubscriber.onTimeout(seqId.longValue());
                        }

                        @Override // rx.Observer
                        public void onError(Throwable e) {
                            timeoutSubscriber.onError(e);
                        }

                        @Override // rx.Observer
                        public void onNext(U u) {
                            timeoutSubscriber.onTimeout(seqId.longValue());
                        }
                    });
                } catch (Throwable t) {
                    Exceptions.throwOrReport(t, timeoutSubscriber);
                    return Subscriptions.unsubscribed();
                }
            }
        }, new OperatorTimeoutBase.TimeoutStub<T>() {
            /* class rx.internal.operators.OperatorTimeoutWithSelector.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func4
            public /* bridge */ /* synthetic */ Subscription call(Object x0, Long l, Object x2, Scheduler.Worker worker) {
                return call((OperatorTimeoutBase.TimeoutSubscriber) ((OperatorTimeoutBase.TimeoutSubscriber) x0), l, x2, worker);
            }

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long seqId, T value, Scheduler.Worker inner) {
                try {
                    return ((Observable) Func1.this.call(value)).unsafeSubscribe(new Subscriber<V>() {
                        /* class rx.internal.operators.OperatorTimeoutWithSelector.AnonymousClass2.AnonymousClass1 */

                        @Override // rx.Observer
                        public void onCompleted() {
                            timeoutSubscriber.onTimeout(seqId.longValue());
                        }

                        @Override // rx.Observer
                        public void onError(Throwable e) {
                            timeoutSubscriber.onError(e);
                        }

                        @Override // rx.Observer
                        public void onNext(V v) {
                            timeoutSubscriber.onTimeout(seqId.longValue());
                        }
                    });
                } catch (Throwable t) {
                    Exceptions.throwOrReport(t, timeoutSubscriber);
                    return Subscriptions.unsubscribed();
                }
            }
        }, other, Schedulers.immediate());
    }
}
