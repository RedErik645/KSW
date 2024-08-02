package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

public final class SingleDoAfterTerminate<T> implements Single.OnSubscribe<T> {
    final Action0 action;
    final Single<T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    public SingleDoAfterTerminate(Single<T> source2, Action0 action2) {
        this.source = source2;
        this.action = action2;
    }

    public void call(SingleSubscriber<? super T> t) {
        SingleDoAfterTerminateSubscriber<T> parent = new SingleDoAfterTerminateSubscriber<>(t, this.action);
        t.add(parent);
        this.source.subscribe(parent);
    }

    /* access modifiers changed from: package-private */
    public static final class SingleDoAfterTerminateSubscriber<T> extends SingleSubscriber<T> {
        final Action0 action;
        final SingleSubscriber<? super T> actual;

        public SingleDoAfterTerminateSubscriber(SingleSubscriber<? super T> actual2, Action0 action2) {
            this.actual = actual2;
            this.action = action2;
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T value) {
            try {
                this.actual.onSuccess(value);
            } finally {
                doAction();
            }
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable error) {
            try {
                this.actual.onError(error);
            } finally {
                doAction();
            }
        }

        /* access modifiers changed from: package-private */
        public void doAction() {
            try {
                this.action.call();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                RxJavaHooks.onError(ex);
            }
        }
    }
}
