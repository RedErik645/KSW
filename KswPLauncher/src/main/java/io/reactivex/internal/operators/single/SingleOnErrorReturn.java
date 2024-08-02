package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

public final class SingleOnErrorReturn<T> extends Single<T> {
    final SingleSource<? extends T> source;
    final T value;
    final Function<? super Throwable, ? extends T> valueSupplier;

    public SingleOnErrorReturn(SingleSource<? extends T> source2, Function<? super Throwable, ? extends T> valueSupplier2, T value2) {
        this.source = source2;
        this.valueSupplier = valueSupplier2;
        this.value = value2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> observer) {
        this.source.subscribe(new OnErrorReturn(observer));
    }

    final class OnErrorReturn implements SingleObserver<T> {
        private final SingleObserver<? super T> observer;

        OnErrorReturn(SingleObserver<? super T> observer2) {
            this.observer = observer2;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable e) {
            T t;
            if (SingleOnErrorReturn.this.valueSupplier != null) {
                try {
                    t = (Object) SingleOnErrorReturn.this.valueSupplier.apply(e);
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    this.observer.onError(new CompositeException(e, ex));
                    return;
                }
            } else {
                t = SingleOnErrorReturn.this.value;
            }
            if (t == null) {
                NullPointerException npe = new NullPointerException("Value supplied was null");
                npe.initCause(e);
                this.observer.onError(npe);
                return;
            }
            this.observer.onSuccess(t);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable d) {
            this.observer.onSubscribe(d);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T value) {
            this.observer.onSuccess(value);
        }
    }
}
