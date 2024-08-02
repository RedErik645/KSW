package rx.internal.util;

import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

public final class ScalarSynchronousSingle<T> extends Single<T> {
    final T value;

    public static <T> ScalarSynchronousSingle<T> create(T t) {
        return new ScalarSynchronousSingle<>(t);
    }

    protected ScalarSynchronousSingle(final T t) {
        super(new Single.OnSubscribe<T>() {
            /* class rx.internal.util.ScalarSynchronousSingle.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SingleSubscriber) ((SingleSubscriber) x0));
            }

            public void call(SingleSubscriber<? super T> te) {
                te.onSuccess((Object) t);
            }
        });
        this.value = t;
    }

    public T get() {
        return this.value;
    }

    public Single<T> scalarScheduleOn(Scheduler scheduler) {
        if (scheduler instanceof EventLoopsScheduler) {
            return create((Single.OnSubscribe) new DirectScheduledEmission((EventLoopsScheduler) scheduler, this.value));
        }
        return create((Single.OnSubscribe) new NormalScheduledEmission(scheduler, this.value));
    }

    /* access modifiers changed from: package-private */
    public static final class DirectScheduledEmission<T> implements Single.OnSubscribe<T> {
        private final EventLoopsScheduler es;
        private final T value;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((SingleSubscriber) ((SingleSubscriber) x0));
        }

        DirectScheduledEmission(EventLoopsScheduler es2, T value2) {
            this.es = es2;
            this.value = value2;
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            singleSubscriber.add(this.es.scheduleDirect(new ScalarSynchronousSingleAction(singleSubscriber, this.value)));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class NormalScheduledEmission<T> implements Single.OnSubscribe<T> {
        private final Scheduler scheduler;
        private final T value;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((SingleSubscriber) ((SingleSubscriber) x0));
        }

        NormalScheduledEmission(Scheduler scheduler2, T value2) {
            this.scheduler = scheduler2;
            this.value = value2;
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            Scheduler.Worker worker = this.scheduler.createWorker();
            singleSubscriber.add(worker);
            worker.schedule(new ScalarSynchronousSingleAction(singleSubscriber, this.value));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ScalarSynchronousSingleAction<T> implements Action0 {
        private final SingleSubscriber<? super T> subscriber;
        private final T value;

        ScalarSynchronousSingleAction(SingleSubscriber<? super T> subscriber2, T value2) {
            this.subscriber = subscriber2;
            this.value = value2;
        }

        @Override // rx.functions.Action0
        public void call() {
            try {
                this.subscriber.onSuccess(this.value);
            } catch (Throwable t) {
                this.subscriber.onError(t);
            }
        }
    }

    public <R> Single<R> scalarFlatMap(final Func1<? super T, ? extends Single<? extends R>> func) {
        return create((Single.OnSubscribe) new Single.OnSubscribe<R>() {
            /* class rx.internal.util.ScalarSynchronousSingle.AnonymousClass2 */

            public void call(final SingleSubscriber<? super R> child) {
                Single<? extends R> o = (Single) func.call(ScalarSynchronousSingle.this.value);
                if (o instanceof ScalarSynchronousSingle) {
                    child.onSuccess(((ScalarSynchronousSingle) o).value);
                    return;
                }
                Subscriber<R> subscriber = new Subscriber<R>() {
                    /* class rx.internal.util.ScalarSynchronousSingle.AnonymousClass2.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onCompleted() {
                    }

                    @Override // rx.Observer
                    public void onError(Throwable e) {
                        child.onError(e);
                    }

                    @Override // rx.Observer
                    public void onNext(R r) {
                        child.onSuccess(r);
                    }
                };
                child.add(subscriber);
                o.unsafeSubscribe(subscriber);
            }
        });
    }
}
