package rx.observers;

import rx.Completable;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.plugins.RxJavaHooks;

public final class SafeCompletableSubscriber implements Completable.CompletableSubscriber, Subscription {
    final Completable.CompletableSubscriber actual;
    boolean done;
    Subscription s;

    public SafeCompletableSubscriber(Completable.CompletableSubscriber actual2) {
        this.actual = actual2;
    }

    @Override // rx.Completable.CompletableSubscriber
    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onCompleted();
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                throw new OnCompletedFailedException(ex);
            }
        }
    }

    @Override // rx.Completable.CompletableSubscriber
    public void onError(Throwable e) {
        RxJavaHooks.onError(e);
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onError(e);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                throw new OnErrorFailedException(new CompositeException(e, ex));
            }
        }
    }

    @Override // rx.Completable.CompletableSubscriber
    public void onSubscribe(Subscription d) {
        this.s = d;
        try {
            this.actual.onSubscribe(this);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            d.unsubscribe();
            onError(ex);
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.s.unsubscribe();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.done || this.s.isUnsubscribed();
    }
}
