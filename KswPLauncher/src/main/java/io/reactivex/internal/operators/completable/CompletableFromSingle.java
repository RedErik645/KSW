package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> single;

    public CompletableFromSingle(SingleSource<T> single2) {
        this.single = single2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver observer) {
        this.single.subscribe(new CompletableFromSingleObserver(observer));
    }

    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {
        final CompletableObserver co;

        CompletableFromSingleObserver(CompletableObserver co2) {
            this.co = co2;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable e) {
            this.co.onError(e);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable d) {
            this.co.onSubscribe(d);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.co.onComplete();
        }
    }
}
