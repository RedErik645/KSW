package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleAmb<T> extends Single<T> {
    private final SingleSource<? extends T>[] sources;
    private final Iterable<? extends SingleSource<? extends T>> sourcesIterable;

    public SingleAmb(SingleSource<? extends T>[] sources2, Iterable<? extends SingleSource<? extends T>> sourcesIterable2) {
        this.sources = sources2;
        this.sourcesIterable = sourcesIterable2;
    }

    /* JADX INFO: Multiple debug info for r6v4 int: [D('count' int), D('b' io.reactivex.SingleSource<? extends T>[])] */
    /* access modifiers changed from: protected */
    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> observer) {
        Throwable e;
        SingleSource<? extends T>[] sources2 = this.sources;
        int count = 0;
        if (sources2 == null) {
            sources2 = new SingleSource[8];
            try {
                for (SingleSource<? extends T> element : this.sourcesIterable) {
                    if (element == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (count == sources2.length) {
                        SingleSource<? extends T>[] b = new SingleSource[((count >> 2) + count)];
                        System.arraycopy(sources2, 0, b, 0, count);
                        sources2 = b;
                    }
                    int count2 = count + 1;
                    try {
                        sources2[count] = element;
                        count = count2;
                    } catch (Throwable th) {
                        e = th;
                        Exceptions.throwIfFatal(e);
                        EmptyDisposable.error(e, observer);
                        return;
                    }
                }
            } catch (Throwable th2) {
                e = th2;
                Exceptions.throwIfFatal(e);
                EmptyDisposable.error(e, observer);
                return;
            }
        } else {
            count = sources2.length;
        }
        AtomicBoolean winner = new AtomicBoolean();
        CompositeDisposable set = new CompositeDisposable();
        observer.onSubscribe(set);
        for (int i = 0; i < count; i++) {
            SingleSource<? extends T> s1 = sources2[i];
            if (set.isDisposed()) {
                return;
            }
            if (s1 == null) {
                set.dispose();
                Throwable e2 = new NullPointerException("One of the sources is null");
                if (winner.compareAndSet(false, true)) {
                    observer.onError(e2);
                    return;
                } else {
                    RxJavaPlugins.onError(e2);
                    return;
                }
            } else {
                s1.subscribe(new AmbSingleObserver(observer, set, winner));
            }
        }
    }

    static final class AmbSingleObserver<T> implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;
        final CompositeDisposable set;
        Disposable upstream;
        final AtomicBoolean winner;

        AmbSingleObserver(SingleObserver<? super T> observer, CompositeDisposable set2, AtomicBoolean winner2) {
            this.downstream = observer;
            this.set = set2;
            this.winner = winner2;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable d) {
            this.upstream = d;
            this.set.add(d);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T value) {
            if (this.winner.compareAndSet(false, true)) {
                this.set.delete(this.upstream);
                this.set.dispose();
                this.downstream.onSuccess(value);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable e) {
            if (this.winner.compareAndSet(false, true)) {
                this.set.delete(this.upstream);
                this.set.dispose();
                this.downstream.onError(e);
                return;
            }
            RxJavaPlugins.onError(e);
        }
    }
}
