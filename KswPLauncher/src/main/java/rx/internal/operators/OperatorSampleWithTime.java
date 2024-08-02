package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorSampleWithTime<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorSampleWithTime(long time2, TimeUnit unit2, Scheduler scheduler2) {
        this.time = time2;
        this.unit = unit2;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        SerializedSubscriber<T> s = new SerializedSubscriber<>(child);
        Scheduler.Worker worker = this.scheduler.createWorker();
        child.add(worker);
        SamplerSubscriber<T> sampler = new SamplerSubscriber<>(s);
        child.add(sampler);
        long j = this.time;
        worker.schedulePeriodically(sampler, j, j, this.unit);
        return sampler;
    }

    /* access modifiers changed from: package-private */
    public static final class SamplerSubscriber<T> extends Subscriber<T> implements Action0 {
        private static final Object EMPTY_TOKEN = new Object();
        private final Subscriber<? super T> subscriber;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY_TOKEN);

        public SamplerSubscriber(Subscriber<? super T> subscriber2) {
            this.subscriber = subscriber2;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.value.set(t);
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.subscriber.onError(e);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onCompleted() {
            emitIfNonEmpty();
            this.subscriber.onCompleted();
            unsubscribe();
        }

        @Override // rx.functions.Action0
        public void call() {
            emitIfNonEmpty();
        }

        private void emitIfNonEmpty() {
            AtomicReference<Object> atomicReference = this.value;
            Object obj = EMPTY_TOKEN;
            Object localValue = atomicReference.getAndSet(obj);
            if (localValue != obj) {
                try {
                    this.subscriber.onNext(localValue);
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, this);
                }
            }
        }
    }
}
