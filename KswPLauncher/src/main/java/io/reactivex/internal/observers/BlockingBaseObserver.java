package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {
    volatile boolean cancelled;
    Throwable error;
    Disposable upstream;
    T value;

    public BlockingBaseObserver() {
        super(1);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable d) {
        this.upstream = d;
        if (this.cancelled) {
            d.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.cancelled = true;
        Disposable d = this.upstream;
        if (d != null) {
            d.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    /* JADX INFO: Multiple debug info for r0v2 java.lang.Throwable: [D('ex' java.lang.InterruptedException), D('e' java.lang.Throwable)] */
    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException ex) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(ex);
            }
        }
        Throwable e = this.error;
        if (e == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(e);
    }
}
