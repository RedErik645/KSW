package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.subjects.PublishSubject;
import rx.subscriptions.Subscriptions;

public class SchedulerWhen extends Scheduler implements Subscription {
    private static final Subscription SUBSCRIBED = new Subscription() {
        /* class rx.internal.schedulers.SchedulerWhen.AnonymousClass3 */

        @Override // rx.Subscription
        public void unsubscribe() {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return false;
        }
    };
    private static final Subscription UNSUBSCRIBED = Subscriptions.unsubscribed();
    private final Scheduler actualScheduler;
    private final Subscription subscription;
    private final Observer<Observable<Completable>> workerObserver;

    public SchedulerWhen(Func1<Observable<Observable<Completable>>, Completable> combine, Scheduler actualScheduler2) {
        this.actualScheduler = actualScheduler2;
        PublishSubject<Observable<Completable>> workerSubject = PublishSubject.create();
        this.workerObserver = new SerializedObserver(workerSubject);
        this.subscription = combine.call(workerSubject.onBackpressureBuffer()).subscribe();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.subscription.unsubscribe();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.subscription.isUnsubscribed();
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        final Scheduler.Worker actualWorker = this.actualScheduler.createWorker();
        BufferUntilSubscriber<ScheduledAction> actionSubject = BufferUntilSubscriber.create();
        final Observer<ScheduledAction> actionObserver = new SerializedObserver<>(actionSubject);
        Observable<Completable> actions = actionSubject.map(new Func1<ScheduledAction, Completable>() {
            /* class rx.internal.schedulers.SchedulerWhen.AnonymousClass1 */

            public Completable call(final ScheduledAction action) {
                return Completable.create(new Completable.CompletableOnSubscribe() {
                    /* class rx.internal.schedulers.SchedulerWhen.AnonymousClass1.AnonymousClass1 */

                    public void call(Completable.CompletableSubscriber actionCompletable) {
                        actionCompletable.onSubscribe(action);
                        action.call(actualWorker);
                        actionCompletable.onCompleted();
                    }
                });
            }
        });
        Scheduler.Worker worker = new Scheduler.Worker() {
            /* class rx.internal.schedulers.SchedulerWhen.AnonymousClass2 */
            private final AtomicBoolean unsubscribed = new AtomicBoolean();

            @Override // rx.Subscription
            public void unsubscribe() {
                if (this.unsubscribed.compareAndSet(false, true)) {
                    actualWorker.unsubscribe();
                    actionObserver.onCompleted();
                }
            }

            @Override // rx.Subscription
            public boolean isUnsubscribed() {
                return this.unsubscribed.get();
            }

            @Override // rx.Scheduler.Worker
            public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
                DelayedAction delayedAction = new DelayedAction(action, delayTime, unit);
                actionObserver.onNext(delayedAction);
                return delayedAction;
            }

            @Override // rx.Scheduler.Worker
            public Subscription schedule(Action0 action) {
                ImmediateAction immediateAction = new ImmediateAction(action);
                actionObserver.onNext(immediateAction);
                return immediateAction;
            }
        };
        this.workerObserver.onNext(actions);
        return worker;
    }

    /* access modifiers changed from: private */
    public static abstract class ScheduledAction extends AtomicReference<Subscription> implements Subscription {
        /* access modifiers changed from: protected */
        public abstract Subscription callActual(Scheduler.Worker worker);

        public ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void call(Scheduler.Worker actualWorker) {
            Subscription oldState = (Subscription) get();
            if (oldState != SchedulerWhen.UNSUBSCRIBED && oldState == SchedulerWhen.SUBSCRIBED) {
                Subscription newState = callActual(actualWorker);
                if (!compareAndSet(SchedulerWhen.SUBSCRIBED, newState)) {
                    newState.unsubscribe();
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return ((Subscription) get()).isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            Subscription oldState;
            Subscription newState = SchedulerWhen.UNSUBSCRIBED;
            do {
                oldState = (Subscription) get();
                if (oldState == SchedulerWhen.UNSUBSCRIBED) {
                    return;
                }
            } while (!compareAndSet(oldState, newState));
            if (oldState != SchedulerWhen.SUBSCRIBED) {
                oldState.unsubscribe();
            }
        }
    }

    private static class ImmediateAction extends ScheduledAction {
        private final Action0 action;

        public ImmediateAction(Action0 action2) {
            this.action = action2;
        }

        /* access modifiers changed from: protected */
        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public Subscription callActual(Scheduler.Worker actualWorker) {
            return actualWorker.schedule(this.action);
        }
    }

    private static class DelayedAction extends ScheduledAction {
        private final Action0 action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Action0 action2, long delayTime2, TimeUnit unit2) {
            this.action = action2;
            this.delayTime = delayTime2;
            this.unit = unit2;
        }

        /* access modifiers changed from: protected */
        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public Subscription callActual(Scheduler.Worker actualWorker) {
            return actualWorker.schedule(this.action, this.delayTime, this.unit);
        }
    }
}
