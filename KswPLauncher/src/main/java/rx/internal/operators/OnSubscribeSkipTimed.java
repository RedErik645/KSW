package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

public final class OnSubscribeSkipTimed<T> implements Observable.OnSubscribe<T> {
    final Scheduler scheduler;
    final Observable<T> source;
    final long time;
    final TimeUnit unit;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeSkipTimed(Observable<T> source2, long time2, TimeUnit unit2, Scheduler scheduler2) {
        this.source = source2;
        this.time = time2;
        this.unit = unit2;
        this.scheduler = scheduler2;
    }

    public void call(Subscriber<? super T> child) {
        Scheduler.Worker worker = this.scheduler.createWorker();
        SkipTimedSubscriber<T> subscriber = new SkipTimedSubscriber<>(child);
        subscriber.add(worker);
        child.add(subscriber);
        worker.schedule(subscriber, this.time, this.unit);
        this.source.unsafeSubscribe(subscriber);
    }

    /* access modifiers changed from: package-private */
    public static final class SkipTimedSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> child;
        volatile boolean gate;

        SkipTimedSubscriber(Subscriber<? super T> child2) {
            this.child = child2;
        }

        @Override // rx.functions.Action0
        public void call() {
            this.gate = true;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.gate) {
                this.child.onNext(t);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            try {
                this.child.onError(e);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            try {
                this.child.onCompleted();
            } finally {
                unsubscribe();
            }
        }
    }
}
