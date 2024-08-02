package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected Disposable upstream;

    public DeferredScalarObserver(Observer<? super R> downstream) {
        super(downstream);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable d) {
        if (DisposableHelper.validate(this.upstream, d)) {
            this.upstream = d;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable t) {
        this.value = null;
        error(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.internal.observers.DeferredScalarObserver<T, R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observer
    public void onComplete() {
        Object obj = this.value;
        if (obj != null) {
            this.value = null;
            complete(obj);
            return;
        }
        complete();
    }

    @Override // io.reactivex.disposables.Disposable, io.reactivex.internal.observers.DeferredScalarDisposable
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }
}
