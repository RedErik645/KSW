package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.internal.producers.SingleProducer;
import rx.subjects.SubjectSubscriptionManager;

public final class AsyncSubject<T> extends Subject<T, T> {
    volatile Object lastValue;
    private final NotificationLite<T> nl = NotificationLite.instance();
    final SubjectSubscriptionManager<T> state;

    public static <T> AsyncSubject<T> create() {
        final SubjectSubscriptionManager<T> state2 = new SubjectSubscriptionManager<>();
        state2.onTerminated = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() {
            /* class rx.subjects.AsyncSubject.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) x0));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> o) {
                Object v = state2.getLatest();
                NotificationLite<T> nl = state2.nl;
                if (v == null || nl.isCompleted(v)) {
                    o.onCompleted();
                } else if (nl.isError(v)) {
                    o.onError(nl.getError(v));
                } else {
                    o.actual.setProducer(new SingleProducer(o.actual, nl.getValue(v)));
                }
            }
        };
        return new AsyncSubject<>(state2, state2);
    }

    protected AsyncSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> state2) {
        super(onSubscribe);
        this.state = state2;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.state.active) {
            Object last = this.lastValue;
            if (last == null) {
                last = this.nl.completed();
            }
            SubjectSubscriptionManager.SubjectObserver<T>[] arr$ = this.state.terminate(last);
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : arr$) {
                if (last == this.nl.completed()) {
                    bo.onCompleted();
                } else {
                    bo.actual.setProducer(new SingleProducer(bo.actual, this.nl.getValue(last)));
                }
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        if (this.state.active) {
            List<Throwable> errors = null;
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : this.state.terminate(this.nl.error(e))) {
                try {
                    bo.onError(e);
                } catch (Throwable e2) {
                    if (errors == null) {
                        errors = new ArrayList<>();
                    }
                    errors.add(e2);
                }
            }
            Exceptions.throwIfAny(errors);
        }
    }

    @Override // rx.Observer
    public void onNext(T v) {
        this.lastValue = this.nl.next(v);
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }

    public boolean hasValue() {
        return !this.nl.isError(this.state.getLatest()) && this.nl.isNext(this.lastValue);
    }

    public boolean hasThrowable() {
        return this.nl.isError(this.state.getLatest());
    }

    public boolean hasCompleted() {
        Object o = this.state.getLatest();
        return o != null && !this.nl.isError(o);
    }

    public T getValue() {
        Object v = this.lastValue;
        if (this.nl.isError(this.state.getLatest()) || !this.nl.isNext(v)) {
            return null;
        }
        return this.nl.getValue(v);
    }

    public Throwable getThrowable() {
        Object o = this.state.getLatest();
        if (this.nl.isError(o)) {
            return this.nl.getError(o);
        }
        return null;
    }
}
