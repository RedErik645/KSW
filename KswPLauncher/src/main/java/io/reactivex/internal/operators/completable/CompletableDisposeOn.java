package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableDisposeOn extends Completable {
    final Scheduler scheduler;
    final CompletableSource source;

    public CompletableDisposeOn(CompletableSource source2, Scheduler scheduler2) {
        this.source = source2;
        this.scheduler = scheduler2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver observer) {
        this.source.subscribe(new DisposeOnObserver(observer, this.scheduler));
    }

    static final class DisposeOnObserver implements CompletableObserver, Disposable, Runnable {
        volatile boolean disposed;
        final CompletableObserver downstream;
        final Scheduler scheduler;
        Disposable upstream;

        DisposeOnObserver(CompletableObserver observer, Scheduler scheduler2) {
            this.downstream = observer;
            this.scheduler = scheduler2;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            if (!this.disposed) {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable e) {
            if (this.disposed) {
                RxJavaPlugins.onError(e);
            } else {
                this.downstream.onError(e);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.scheduler.scheduleDirect(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        public void run() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }
    }
}
