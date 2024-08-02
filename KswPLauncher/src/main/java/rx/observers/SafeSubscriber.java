package rx.observers;

import java.util.Arrays;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.plugins.RxJavaHooks;

public class SafeSubscriber<T> extends Subscriber<T> {
    private final Subscriber<? super T> actual;
    boolean done;

    public SafeSubscriber(Subscriber<? super T> actual2) {
        super(actual2);
        this.actual = actual2;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onCompleted();
                try {
                    unsubscribe();
                } catch (Throwable e) {
                    RxJavaHooks.onError(e);
                    throw new UnsubscribeFailedException(e.getMessage(), e);
                }
            } catch (Throwable e2) {
                try {
                    unsubscribe();
                    throw e2;
                } catch (Throwable e3) {
                    RxJavaHooks.onError(e3);
                    throw new UnsubscribeFailedException(e3.getMessage(), e3);
                }
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        Exceptions.throwIfFatal(e);
        if (!this.done) {
            this.done = true;
            _onError(e);
        }
    }

    @Override // rx.Observer
    public void onNext(T args) {
        try {
            if (!this.done) {
                this.actual.onNext(args);
            }
        } catch (Throwable e) {
            Exceptions.throwOrReport(e, this);
        }
    }

    /* access modifiers changed from: protected */
    public void _onError(Throwable e) {
        RxJavaHooks.onError(e);
        try {
            this.actual.onError(e);
            try {
                unsubscribe();
            } catch (Throwable unsubscribeException) {
                RxJavaHooks.onError(unsubscribeException);
                throw new OnErrorFailedException(unsubscribeException);
            }
        } catch (OnErrorNotImplementedException e2) {
            unsubscribe();
            throw e2;
        } catch (Throwable unsubscribeException2) {
            RxJavaHooks.onError(unsubscribeException2);
            throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(e, unsubscribeException2)));
        }
    }

    public Subscriber<? super T> getActual() {
        return this.actual;
    }
}