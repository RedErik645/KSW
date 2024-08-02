package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SchedulerWhen extends Scheduler implements Disposable {
    static final Disposable DISPOSED = Disposables.disposed();
    static final Disposable SUBSCRIBED = new SubscribedDisposable();
    private final Scheduler actualScheduler;
    private Disposable disposable;
    private final FlowableProcessor<Flowable<Completable>> workerProcessor;

    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> combine, Scheduler actualScheduler2) {
        this.actualScheduler = actualScheduler2;
        FlowableProcessor<Flowable<Completable>> serialized = UnicastProcessor.create().toSerialized();
        this.workerProcessor = serialized;
        try {
            this.disposable = combine.apply(serialized).subscribe();
        } catch (Throwable e) {
            throw ExceptionHelper.wrapOrThrow(e);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposable.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        Scheduler.Worker actualWorker = this.actualScheduler.createWorker();
        FlowableProcessor<ScheduledAction> actionProcessor = UnicastProcessor.create().toSerialized();
        Flowable<Completable> actions = actionProcessor.map(new CreateWorkerFunction(actualWorker));
        Scheduler.Worker worker = new QueueWorker(actionProcessor, actualWorker);
        this.workerProcessor.onNext(actions);
        return worker;
    }

    /* access modifiers changed from: package-private */
    public static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        /* access modifiers changed from: protected */
        public abstract Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver);

        ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        /* access modifiers changed from: package-private */
        public void call(Scheduler.Worker actualWorker, CompletableObserver actionCompletable) {
            Disposable oldState = (Disposable) get();
            if (oldState != SchedulerWhen.DISPOSED && oldState == SchedulerWhen.SUBSCRIBED) {
                Disposable newState = callActual(actualWorker, actionCompletable);
                if (!compareAndSet(SchedulerWhen.SUBSCRIBED, newState)) {
                    newState.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return ((Disposable) get()).isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable oldState;
            Disposable newState = SchedulerWhen.DISPOSED;
            do {
                oldState = (Disposable) get();
                if (oldState == SchedulerWhen.DISPOSED) {
                    return;
                }
            } while (!compareAndSet(oldState, newState));
            if (oldState != SchedulerWhen.SUBSCRIBED) {
                oldState.dispose();
            }
        }
    }

    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable action2) {
            this.action = action2;
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public Disposable callActual(Scheduler.Worker actualWorker, CompletableObserver actionCompletable) {
            return actualWorker.schedule(new OnCompletedAction(this.action, actionCompletable));
        }
    }

    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        DelayedAction(Runnable action2, long delayTime2, TimeUnit unit2) {
            this.action = action2;
            this.delayTime = delayTime2;
            this.unit = unit2;
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public Disposable callActual(Scheduler.Worker actualWorker, CompletableObserver actionCompletable) {
            return actualWorker.schedule(new OnCompletedAction(this.action, actionCompletable), this.delayTime, this.unit);
        }
    }

    static class OnCompletedAction implements Runnable {
        final Runnable action;
        final CompletableObserver actionCompletable;

        OnCompletedAction(Runnable action2, CompletableObserver actionCompletable2) {
            this.action = action2;
            this.actionCompletable = actionCompletable2;
        }

        public void run() {
            try {
                this.action.run();
            } finally {
                this.actionCompletable.onComplete();
            }
        }
    }

    static final class CreateWorkerFunction implements Function<ScheduledAction, Completable> {
        final Scheduler.Worker actualWorker;

        CreateWorkerFunction(Scheduler.Worker actualWorker2) {
            this.actualWorker = actualWorker2;
        }

        public Completable apply(ScheduledAction action) {
            return new WorkerCompletable(action);
        }

        /* access modifiers changed from: package-private */
        public final class WorkerCompletable extends Completable {
            final ScheduledAction action;

            WorkerCompletable(ScheduledAction action2) {
                this.action = action2;
            }

            /* access modifiers changed from: protected */
            @Override // io.reactivex.Completable
            public void subscribeActual(CompletableObserver actionCompletable) {
                actionCompletable.onSubscribe(this.action);
                this.action.call(CreateWorkerFunction.this.actualWorker, actionCompletable);
            }
        }
    }

    static final class QueueWorker extends Scheduler.Worker {
        private final FlowableProcessor<ScheduledAction> actionProcessor;
        private final Scheduler.Worker actualWorker;
        private final AtomicBoolean unsubscribed = new AtomicBoolean();

        QueueWorker(FlowableProcessor<ScheduledAction> actionProcessor2, Scheduler.Worker actualWorker2) {
            this.actionProcessor = actionProcessor2;
            this.actualWorker = actualWorker2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.unsubscribed.compareAndSet(false, true)) {
                this.actionProcessor.onComplete();
                this.actualWorker.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.unsubscribed.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable action, long delayTime, TimeUnit unit) {
            DelayedAction delayedAction = new DelayedAction(action, delayTime, unit);
            this.actionProcessor.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable action) {
            ImmediateAction immediateAction = new ImmediateAction(action);
            this.actionProcessor.onNext(immediateAction);
            return immediateAction;
        }
    }

    static final class SubscribedDisposable implements Disposable {
        SubscribedDisposable() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }
    }
}
