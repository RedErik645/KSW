package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenCompletable extends Completable {
    final CompletableSource next;
    final CompletableSource source;

    public CompletableAndThenCompletable(CompletableSource source2, CompletableSource next2) {
        this.source = source2;
        this.next = next2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver observer) {
        this.source.subscribe(new SourceObserver(observer, this.next));
    }

    static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -4101678820158072998L;
        final CompletableObserver actualObserver;
        final CompletableSource next;

        SourceObserver(CompletableObserver actualObserver2, CompletableSource next2) {
            this.actualObserver = actualObserver2;
            this.next = next2;
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.setOnce(this, d)) {
                this.actualObserver.onSubscribe(this);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable e) {
            this.actualObserver.onError(e);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.next.subscribe(new NextObserver(this, this.actualObserver));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }
    }

    static final class NextObserver implements CompletableObserver {
        final CompletableObserver downstream;
        final AtomicReference<Disposable> parent;

        NextObserver(AtomicReference<Disposable> parent2, CompletableObserver downstream2) {
            this.parent = parent2;
            this.downstream = downstream2;
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable d) {
            DisposableHelper.replace(this.parent, d);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }
    }
}
