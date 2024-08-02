package rx.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.MultipleAssignmentSubscription;
import rx.subscriptions.Subscriptions;

public final class ExecutorScheduler extends Scheduler {
    final Executor executor;

    public ExecutorScheduler(Executor executor2) {
        this.executor = executor2;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new ExecutorSchedulerWorker(this.executor);
    }

    static final class ExecutorSchedulerWorker extends Scheduler.Worker implements Runnable {
        final Executor executor;
        final ConcurrentLinkedQueue<ScheduledAction> queue = new ConcurrentLinkedQueue<>();
        final ScheduledExecutorService service = GenericScheduledExecutorService.getInstance();
        final CompositeSubscription tasks = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger();

        public ExecutorSchedulerWorker(Executor executor2) {
            this.executor = executor2;
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            ScheduledAction ea = new ScheduledAction(RxJavaHooks.onScheduledAction(action), this.tasks);
            this.tasks.add(ea);
            this.queue.offer(ea);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                } catch (RejectedExecutionException t) {
                    this.tasks.remove(ea);
                    this.wip.decrementAndGet();
                    RxJavaHooks.onError(t);
                    throw t;
                }
            }
            return ea;
        }

        public void run() {
            while (!this.tasks.isUnsubscribed()) {
                ScheduledAction sa = this.queue.poll();
                if (sa != null) {
                    if (!sa.isUnsubscribed()) {
                        if (!this.tasks.isUnsubscribed()) {
                            sa.run();
                        } else {
                            this.queue.clear();
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.queue.clear();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
            if (delayTime <= 0) {
                return schedule(action);
            }
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            final Action0 decorated = RxJavaHooks.onScheduledAction(action);
            MultipleAssignmentSubscription first = new MultipleAssignmentSubscription();
            final MultipleAssignmentSubscription mas = new MultipleAssignmentSubscription();
            mas.set(first);
            this.tasks.add(mas);
            final Subscription removeMas = Subscriptions.create(new Action0() {
                /* class rx.internal.schedulers.ExecutorScheduler.ExecutorSchedulerWorker.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    ExecutorSchedulerWorker.this.tasks.remove(mas);
                }
            });
            ScheduledAction ea = new ScheduledAction(new Action0() {
                /* class rx.internal.schedulers.ExecutorScheduler.ExecutorSchedulerWorker.AnonymousClass2 */

                @Override // rx.functions.Action0
                public void call() {
                    if (!mas.isUnsubscribed()) {
                        Subscription s2 = ExecutorSchedulerWorker.this.schedule(decorated);
                        mas.set(s2);
                        if (s2.getClass() == ScheduledAction.class) {
                            ((ScheduledAction) s2).add(removeMas);
                        }
                    }
                }
            });
            first.set(ea);
            try {
                ea.add(this.service.schedule(ea, delayTime, unit));
                return removeMas;
            } catch (RejectedExecutionException t) {
                RxJavaHooks.onError(t);
                throw t;
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.tasks.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.tasks.unsubscribe();
            this.queue.clear();
        }
    }
}
