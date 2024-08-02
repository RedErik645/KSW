package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new InnerCurrentThreadScheduler();
    }

    private TrampolineScheduler() {
    }

    static final class InnerCurrentThreadScheduler extends Scheduler.Worker implements Subscription {
        final AtomicInteger counter = new AtomicInteger();
        private final BooleanSubscription innerSubscription = new BooleanSubscription();
        final PriorityBlockingQueue<TimedAction> queue = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();

        InnerCurrentThreadScheduler() {
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action) {
            return enqueue(action, now());
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
            long execTime = now() + unit.toMillis(delayTime);
            return enqueue(new SleepingAction(action, this, execTime), execTime);
        }

        private Subscription enqueue(Action0 action, long execTime) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            final TimedAction timedAction = new TimedAction(action, Long.valueOf(execTime), this.counter.incrementAndGet());
            this.queue.add(timedAction);
            if (this.wip.getAndIncrement() != 0) {
                return Subscriptions.create(new Action0() {
                    /* class rx.internal.schedulers.TrampolineScheduler.InnerCurrentThreadScheduler.AnonymousClass1 */

                    @Override // rx.functions.Action0
                    public void call() {
                        InnerCurrentThreadScheduler.this.queue.remove(timedAction);
                    }
                });
            }
            do {
                TimedAction polled = this.queue.poll();
                if (polled != null) {
                    polled.action.call();
                }
            } while (this.wip.decrementAndGet() > 0);
            return Subscriptions.unsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.innerSubscription.unsubscribe();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class TimedAction implements Comparable<TimedAction> {
        final Action0 action;
        final int count;
        final Long execTime;

        TimedAction(Action0 action2, Long execTime2, int count2) {
            this.action = action2;
            this.execTime = execTime2;
            this.count = count2;
        }

        public int compareTo(TimedAction that) {
            int result = this.execTime.compareTo(that.execTime);
            if (result == 0) {
                return TrampolineScheduler.compare(this.count, that.count);
            }
            return result;
        }
    }

    static int compare(int x, int y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }
}
