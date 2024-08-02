package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

public final class CompletableToSingle<T> extends Single<T> {
    final T completionValue;
    final Callable<? extends T> completionValueSupplier;
    final CompletableSource source;

    public CompletableToSingle(CompletableSource source2, Callable<? extends T> completionValueSupplier2, T completionValue2) {
        this.source = source2;
        this.completionValue = completionValue2;
        this.completionValueSupplier = completionValueSupplier2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> observer) {
        this.source.subscribe(new ToSingle(observer));
    }

    final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> observer;

        ToSingle(SingleObserver<? super T> observer2) {
            this.observer = observer2;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            T t;
            if (CompletableToSingle.this.completionValueSupplier != null) {
                try {
                    t = (Object) CompletableToSingle.this.completionValueSupplier.call();
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    this.observer.onError(e);
                    return;
                }
            } else {
                t = CompletableToSingle.this.completionValue;
            }
            if (t == null) {
                this.observer.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.observer.onSuccess(t);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable e) {
            this.observer.onError(e);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.observer.onSubscribe(d);
        }
    }
}
