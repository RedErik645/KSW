package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray<T, R> extends Single<R> {
    final SingleSource<? extends T>[] sources;
    final Function<? super Object[], ? extends R> zipper;

    public SingleZipArray(SingleSource<? extends T>[] sources2, Function<? super Object[], ? extends R> zipper2) {
        this.sources = sources2;
        this.zipper = zipper2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> observer) {
        SingleSource<? extends T>[] sources2 = this.sources;
        int n = sources2.length;
        if (n == 1) {
            sources2[0].subscribe(new SingleMap.MapSingleObserver(observer, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator<T, R> parent = new ZipCoordinator<>(observer, n, this.zipper);
        observer.onSubscribe(parent);
        for (int i = 0; i < n && !parent.isDisposed(); i++) {
            SingleSource<? extends T> source = sources2[i];
            if (source == null) {
                parent.innerError(new NullPointerException("One of the sources is null"), i);
                return;
            } else {
                source.subscribe(parent.observers[i]);
            }
        }
    }

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;
        final SingleObserver<? super R> downstream;
        final ZipSingleObserver<T>[] observers;
        final Object[] values;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(SingleObserver<? super R> observer, int n, Function<? super Object[], ? extends R> zipper2) {
            super(n);
            this.downstream = observer;
            this.zipper = zipper2;
            ZipSingleObserver<T>[] o = new ZipSingleObserver[n];
            for (int i = 0; i < n; i++) {
                o[i] = new ZipSingleObserver<>(this, i);
            }
            this.observers = o;
            this.values = new Object[n];
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() <= 0;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> zipSingleObserver : this.observers) {
                    zipSingleObserver.dispose();
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super java.lang.Object[] */
        /* access modifiers changed from: package-private */
        public void innerSuccess(T value, int index) {
            this.values[index] = value;
            if (decrementAndGet() == 0) {
                try {
                    this.downstream.onSuccess(ObjectHelper.requireNonNull(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    this.downstream.onError(ex);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void disposeExcept(int index) {
            ZipSingleObserver<T>[] observers2 = this.observers;
            int n = observers2.length;
            for (int i = 0; i < index; i++) {
                observers2[i].dispose();
            }
            for (int i2 = index + 1; i2 < n; i2++) {
                observers2[i2].dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerError(Throwable ex, int index) {
            if (getAndSet(0) > 0) {
                disposeExcept(index);
                this.downstream.onError(ex);
                return;
            }
            RxJavaPlugins.onError(ex);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final ZipCoordinator<T, ?> parent;

        ZipSingleObserver(ZipCoordinator<T, ?> parent2, int index2) {
            this.parent = parent2;
            this.index = index2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this, d);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T value) {
            this.parent.innerSuccess(value, this.index);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable e) {
            this.parent.innerError(e, this.index);
        }
    }

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public R apply(T r4) throws java.lang.Exception {
            /*
                r3 = this;
                io.reactivex.internal.operators.single.SingleZipArray r0 = io.reactivex.internal.operators.single.SingleZipArray.this
                io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> r0 = r0.zipper
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                r1[r2] = r4
                java.lang.Object r0 = r0.apply(r1)
                java.lang.String r1 = "The zipper returned a null value"
                java.lang.Object r0 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.single.SingleZipArray.SingletonArrayFunc.apply(java.lang.Object):java.lang.Object");
        }
    }
}
