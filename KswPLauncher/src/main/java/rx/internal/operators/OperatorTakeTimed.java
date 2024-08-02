package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeTimed<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTakeTimed(long time2, TimeUnit unit2, Scheduler scheduler2) {
        this.time = time2;
        this.unit = unit2;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        Scheduler.Worker worker = this.scheduler.createWorker();
        child.add(worker);
        TakeSubscriber<T> ts = new TakeSubscriber<>(new SerializedSubscriber(child));
        worker.schedule(ts, this.time, this.unit);
        return ts;
    }

    /* access modifiers changed from: package-private */
    public static final class TakeSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> child;

        public TakeSubscriber(Subscriber<? super T> child2) {
            super(child2);
            this.child = child2;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.child.onNext(t);
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.child.onError(e);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.child.onCompleted();
            unsubscribe();
        }

        @Override // rx.functions.Action0
        public void call() {
            onCompleted();
        }
    }
}
