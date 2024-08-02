package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class CompletableDetach extends Completable {
    final CompletableSource source;

    public CompletableDetach(CompletableSource source2) {
        this.source = source2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver observer) {
        this.source.subscribe(new DetachCompletableObserver(observer));
    }

    static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        CompletableObserver downstream;
        Disposable upstream;

        DetachCompletableObserver(CompletableObserver downstream2) {
            this.downstream = downstream2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.downstream = null;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable e) {
            this.upstream = DisposableHelper.DISPOSED;
            CompletableObserver a = this.downstream;
            if (a != null) {
                this.downstream = null;
                a.onError(e);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            CompletableObserver a = this.downstream;
            if (a != null) {
                this.downstream = null;
                a.onComplete();
            }
        }
    }
}
