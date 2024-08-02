package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observers.Subscribers;

public final class OnSubscribeUsing<T, Resource> implements Observable.OnSubscribe<T> {
    private final Action1<? super Resource> dispose;
    private final boolean disposeEagerly;
    private final Func1<? super Resource, ? extends Observable<? extends T>> observableFactory;
    private final Func0<Resource> resourceFactory;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeUsing(Func0<Resource> resourceFactory2, Func1<? super Resource, ? extends Observable<? extends T>> observableFactory2, Action1<? super Resource> dispose2, boolean disposeEagerly2) {
        this.resourceFactory = resourceFactory2;
        this.observableFactory = observableFactory2;
        this.dispose = dispose2;
        this.disposeEagerly = disposeEagerly2;
    }

    public void call(Subscriber<? super T> subscriber) {
        Observable<? extends T> observable;
        try {
            Resource resource = this.resourceFactory.call();
            DisposeAction<Resource> disposeOnceOnly = new DisposeAction<>(this.dispose, resource);
            subscriber.add(disposeOnceOnly);
            try {
                Observable<? extends T> source = (Observable) this.observableFactory.call(resource);
                if (this.disposeEagerly) {
                    observable = source.doOnTerminate(disposeOnceOnly);
                } else {
                    observable = source.doAfterTerminate(disposeOnceOnly);
                }
                try {
                    observable.unsafeSubscribe(Subscribers.wrap(subscriber));
                } catch (Throwable e) {
                    Throwable disposeError = dispose(disposeOnceOnly);
                    Exceptions.throwIfFatal(e);
                    Exceptions.throwIfFatal(disposeError);
                    if (disposeError != null) {
                        subscriber.onError(new CompositeException(e, disposeError));
                        return;
                    }
                    subscriber.onError(e);
                }
            } catch (Throwable e2) {
                Throwable disposeError2 = dispose(disposeOnceOnly);
                Exceptions.throwIfFatal(e2);
                Exceptions.throwIfFatal(disposeError2);
                if (disposeError2 != null) {
                    subscriber.onError(new CompositeException(e2, disposeError2));
                    return;
                }
                subscriber.onError(e2);
            }
        } catch (Throwable e3) {
            Exceptions.throwOrReport(e3, subscriber);
        }
    }

    private Throwable dispose(Action0 disposeOnceOnly) {
        try {
            disposeOnceOnly.call();
            return null;
        } catch (Throwable e) {
            return e;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class DisposeAction<Resource> extends AtomicBoolean implements Action0, Subscription {
        private static final long serialVersionUID = 4262875056400218316L;
        private Action1<? super Resource> dispose;
        private Resource resource;

        DisposeAction(Action1<? super Resource> dispose2, Resource resource2) {
            this.dispose = dispose2;
            this.resource = resource2;
            lazySet(false);
        }

        @Override // rx.functions.Action0
        public void call() {
            if (compareAndSet(false, true)) {
                try {
                    this.dispose.call(this.resource);
                } finally {
                    this.resource = null;
                    this.dispose = null;
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            call();
        }
    }
}
