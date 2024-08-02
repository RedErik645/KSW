package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.SchedulerWhen;
import rx.internal.subscriptions.SequentialSubscription;

public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public abstract Worker createWorker();

    public static abstract class Worker implements Subscription {
        public abstract Subscription schedule(Action0 action0);

        public abstract Subscription schedule(Action0 action0, long j, TimeUnit timeUnit);

        public Subscription schedulePeriodically(Action0 action, long initialDelay, long period, TimeUnit unit) {
            long periodInNanos = unit.toNanos(period);
            long firstNowNanos = TimeUnit.MILLISECONDS.toNanos(now());
            long firstStartInNanos = firstNowNanos + unit.toNanos(initialDelay);
            SequentialSubscription first = new SequentialSubscription();
            SequentialSubscription mas = new SequentialSubscription(first);
            first.replace(schedule(new Action0(firstNowNanos, firstStartInNanos, action, mas, periodInNanos) {
                /* class rx.Scheduler.Worker.AnonymousClass1 */
                long count;
                long lastNowNanos;
                long startInNanos;
                final /* synthetic */ Action0 val$action;
                final /* synthetic */ long val$firstNowNanos;
                final /* synthetic */ long val$firstStartInNanos;
                final /* synthetic */ SequentialSubscription val$mas;
                final /* synthetic */ long val$periodInNanos;

                {
                    this.val$firstNowNanos = r2;
                    this.val$firstStartInNanos = r4;
                    this.val$action = r6;
                    this.val$mas = r7;
                    this.val$periodInNanos = r8;
                    this.lastNowNanos = r2;
                    this.startInNanos = r4;
                }

                @Override // rx.functions.Action0
                public void call() {
                    long nextTick;
                    this.val$action.call();
                    if (!this.val$mas.isUnsubscribed()) {
                        long nowNanos = TimeUnit.MILLISECONDS.toNanos(Worker.this.now());
                        long j = this.lastNowNanos;
                        if (Scheduler.CLOCK_DRIFT_TOLERANCE_NANOS + nowNanos < j || nowNanos >= j + this.val$periodInNanos + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOS) {
                            long nextTick2 = this.val$periodInNanos;
                            long nextTick3 = nowNanos + nextTick2;
                            long j2 = this.count + 1;
                            this.count = j2;
                            this.startInNanos = nextTick3 - (nextTick2 * j2);
                            nextTick = nextTick3;
                        } else {
                            long j3 = this.startInNanos;
                            long j4 = this.count + 1;
                            this.count = j4;
                            nextTick = j3 + (j4 * this.val$periodInNanos);
                        }
                        this.lastNowNanos = nowNanos;
                        this.val$mas.replace(Worker.this.schedule(this, nextTick - nowNanos, TimeUnit.NANOSECONDS));
                    }
                }
            }, initialDelay, unit));
            return mas;
        }

        public long now() {
            return System.currentTimeMillis();
        }
    }

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends Scheduler & Subscription> S when(Func1<Observable<Observable<Completable>>, Completable> combine) {
        return new SchedulerWhen(combine, this);
    }
}
