package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;

public final class BehaviorSubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private final NotificationLite<T> nl = NotificationLite.instance();
    private final SubjectSubscriptionManager<T> state;

    public static <T> BehaviorSubject<T> create() {
        return create(null, false);
    }

    public static <T> BehaviorSubject<T> create(T defaultValue) {
        return create(defaultValue, true);
    }

    private static <T> BehaviorSubject<T> create(T defaultValue, boolean hasDefault) {
        final SubjectSubscriptionManager<T> state2 = new SubjectSubscriptionManager<>();
        if (hasDefault) {
            state2.setLatest(NotificationLite.instance().next(defaultValue));
        }
        state2.onAdded = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() {
            /* class rx.subjects.BehaviorSubject.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) x0));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> o) {
                o.emitFirst(state2.getLatest(), state2.nl);
            }
        };
        state2.onTerminated = state2.onAdded;
        return new BehaviorSubject<>(state2, state2);
    }

    protected BehaviorSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> state2) {
        super(onSubscribe);
        this.state = state2;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.state.getLatest() == null || this.state.active) {
            Object n = this.nl.completed();
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : this.state.terminate(n)) {
                bo.emitNext(n, this.state.nl);
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        if (this.state.getLatest() == null || this.state.active) {
            Object n = this.nl.error(e);
            List<Throwable> errors = null;
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : this.state.terminate(n)) {
                try {
                    bo.emitNext(n, this.state.nl);
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
        if (this.state.getLatest() == null || this.state.active) {
            Object n = this.nl.next(v);
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : this.state.next(n)) {
                bo.emitNext(n, this.state.nl);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int subscriberCount() {
        return this.state.observers().length;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }

    public boolean hasValue() {
        return this.nl.isNext(this.state.getLatest());
    }

    public boolean hasThrowable() {
        return this.nl.isError(this.state.getLatest());
    }

    public boolean hasCompleted() {
        return this.nl.isCompleted(this.state.getLatest());
    }

    public T getValue() {
        Object o = this.state.getLatest();
        if (this.nl.isNext(o)) {
            return this.nl.getValue(o);
        }
        return null;
    }

    public Throwable getThrowable() {
        Object o = this.state.getLatest();
        if (this.nl.isError(o)) {
            return this.nl.getError(o);
        }
        return null;
    }

    public T[] getValues(T[] a) {
        Object o = this.state.getLatest();
        if (this.nl.isNext(o)) {
            if (a.length == 0) {
                a = (T[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), 1));
            }
            a[0] = this.nl.getValue(o);
            if (a.length > 1) {
                a[1] = null;
            }
        } else if (a.length > 0) {
            a[0] = null;
        }
        return a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.subjects.BehaviorSubject<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        T[] r = getValues(objArr);
        if (r == objArr) {
            return new Object[0];
        }
        return r;
    }
}
