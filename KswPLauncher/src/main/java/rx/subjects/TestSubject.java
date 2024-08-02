package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.schedulers.TestScheduler;
import rx.subjects.SubjectSubscriptionManager;

public final class TestSubject<T> extends Subject<T, T> {
    private final Scheduler.Worker innerScheduler;
    private final SubjectSubscriptionManager<T> state;

    public static <T> TestSubject<T> create(TestScheduler scheduler) {
        final SubjectSubscriptionManager<T> state2 = new SubjectSubscriptionManager<>();
        state2.onAdded = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() {
            /* class rx.subjects.TestSubject.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) x0));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> o) {
                o.emitFirst(state2.getLatest(), state2.nl);
            }
        };
        state2.onTerminated = state2.onAdded;
        return new TestSubject<>(state2, state2, scheduler);
    }

    protected TestSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> state2, TestScheduler scheduler) {
        super(onSubscribe);
        this.state = state2;
        this.innerScheduler = scheduler.createWorker();
    }

    @Override // rx.Observer
    public void onCompleted() {
        onCompleted(0);
    }

    /* access modifiers changed from: package-private */
    public void internalOnCompleted() {
        if (this.state.active) {
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : this.state.terminate(NotificationLite.instance().completed())) {
                bo.onCompleted();
            }
        }
    }

    public void onCompleted(long delayTime) {
        this.innerScheduler.schedule(new Action0() {
            /* class rx.subjects.TestSubject.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                TestSubject.this.internalOnCompleted();
            }
        }, delayTime, TimeUnit.MILLISECONDS);
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        onError(e, 0);
    }

    /* access modifiers changed from: package-private */
    public void internalOnError(Throwable e) {
        if (this.state.active) {
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : this.state.terminate(NotificationLite.instance().error(e))) {
                bo.onError(e);
            }
        }
    }

    public void onError(final Throwable e, long delayTime) {
        this.innerScheduler.schedule(new Action0() {
            /* class rx.subjects.TestSubject.AnonymousClass3 */

            @Override // rx.functions.Action0
            public void call() {
                TestSubject.this.internalOnError(e);
            }
        }, delayTime, TimeUnit.MILLISECONDS);
    }

    @Override // rx.Observer
    public void onNext(T v) {
        onNext(v, 0);
    }

    /* access modifiers changed from: package-private */
    public void internalOnNext(T v) {
        for (Observer<? super T> o : this.state.observers()) {
            o.onNext(v);
        }
    }

    public void onNext(final T v, long delayTime) {
        this.innerScheduler.schedule(new Action0() {
            /* class rx.subjects.TestSubject.AnonymousClass4 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: rx.subjects.TestSubject */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.functions.Action0
            public void call() {
                TestSubject.this.internalOnNext(v);
            }
        }, delayTime, TimeUnit.MILLISECONDS);
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }
}
