package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class EventLoopsScheduler extends Scheduler implements SchedulerLifecycle {
    static final String KEY_MAX_THREADS = "rx.scheduler.max-computation-threads";
    static final int MAX_THREADS;
    static final FixedSchedulerPool NONE = new FixedSchedulerPool(null, 0);
    static final PoolWorker SHUTDOWN_WORKER;
    final AtomicReference<FixedSchedulerPool> pool = new AtomicReference<>(NONE);
    final ThreadFactory threadFactory;

    static {
        int max;
        int maxThreads = Integer.getInteger(KEY_MAX_THREADS, 0).intValue();
        int ncpu = Runtime.getRuntime().availableProcessors();
        if (maxThreads <= 0 || maxThreads > ncpu) {
            max = ncpu;
        } else {
            max = maxThreads;
        }
        MAX_THREADS = max;
        PoolWorker poolWorker = new PoolWorker(RxThreadFactory.NONE);
        SHUTDOWN_WORKER = poolWorker;
        poolWorker.unsubscribe();
    }

    /* access modifiers changed from: package-private */
    public static final class FixedSchedulerPool {
        final int cores;
        final PoolWorker[] eventLoops;
        long n;

        FixedSchedulerPool(ThreadFactory threadFactory, int maxThreads) {
            this.cores = maxThreads;
            this.eventLoops = new PoolWorker[maxThreads];
            for (int i = 0; i < maxThreads; i++) {
                this.eventLoops[i] = new PoolWorker(threadFactory);
            }
        }

        public PoolWorker getEventLoop() {
            int c = this.cores;
            if (c == 0) {
                return EventLoopsScheduler.SHUTDOWN_WORKER;
            }
            PoolWorker[] poolWorkerArr = this.eventLoops;
            long j = this.n;
            this.n = 1 + j;
            return poolWorkerArr[(int) (j % ((long) c))];
        }

        public void shutdown() {
            for (PoolWorker w : this.eventLoops) {
                w.unsubscribe();
            }
        }
    }

    public EventLoopsScheduler(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
        start();
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        FixedSchedulerPool update = new FixedSchedulerPool(this.threadFactory, MAX_THREADS);
        if (!this.pool.compareAndSet(NONE, update)) {
            update.shutdown();
        }
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        FixedSchedulerPool curr;
        FixedSchedulerPool fixedSchedulerPool;
        do {
            curr = this.pool.get();
            fixedSchedulerPool = NONE;
            if (curr == fixedSchedulerPool) {
                return;
            }
        } while (!this.pool.compareAndSet(curr, fixedSchedulerPool));
        curr.shutdown();
    }

    public Subscription scheduleDirect(Action0 action) {
        return this.pool.get().getEventLoop().scheduleActual(action, -1, TimeUnit.NANOSECONDS);
    }

    static final class EventLoopWorker extends Scheduler.Worker {
        private final SubscriptionList both;
        private final PoolWorker poolWorker;
        private final SubscriptionList serial;
        private final CompositeSubscription timed;

        EventLoopWorker(PoolWorker poolWorker2) {
            SubscriptionList subscriptionList = new SubscriptionList();
            this.serial = subscriptionList;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.timed = compositeSubscription;
            this.both = new SubscriptionList(subscriptionList, compositeSubscription);
            this.poolWorker = poolWorker2;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.both.unsubscribe();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.both.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(final Action0 action) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual(new Action0() {
                /* class rx.internal.schedulers.EventLoopsScheduler.EventLoopWorker.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    if (!EventLoopWorker.this.isUnsubscribed()) {
                        action.call();
                    }
                }
            }, 0, (TimeUnit) null, this.serial);
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(final Action0 action, long delayTime, TimeUnit unit) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual(new Action0() {
                /* class rx.internal.schedulers.EventLoopsScheduler.EventLoopWorker.AnonymousClass2 */

                @Override // rx.functions.Action0
                public void call() {
                    if (!EventLoopWorker.this.isUnsubscribed()) {
                        action.call();
                    }
                }
            }, delayTime, unit, this.timed);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
