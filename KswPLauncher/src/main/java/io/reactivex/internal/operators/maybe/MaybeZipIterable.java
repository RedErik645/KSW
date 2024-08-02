package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import java.util.Arrays;

public final class MaybeZipIterable<T, R> extends Maybe<R> {
    final Iterable<? extends MaybeSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    public MaybeZipIterable(Iterable<? extends MaybeSource<? extends T>> sources2, Function<? super Object[], ? extends R> zipper2) {
        this.sources = sources2;
        this.zipper = zipper2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super R> observer) {
        Throwable ex;
        MaybeSource<? extends T>[] a = new MaybeSource[8];
        int n = 0;
        try {
            for (MaybeSource<? extends T> source : this.sources) {
                if (source == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
                    return;
                }
                if (n == a.length) {
                    a = (MaybeSource[]) Arrays.copyOf(a, (n >> 2) + n);
                }
                int n2 = n + 1;
                try {
                    a[n] = source;
                    n = n2;
                } catch (Throwable th) {
                    ex = th;
                    Exceptions.throwIfFatal(ex);
                    EmptyDisposable.error(ex, observer);
                }
            }
            if (n == 0) {
                EmptyDisposable.complete(observer);
            } else if (n == 1) {
                a[0].subscribe(new MaybeMap.MapMaybeObserver<>(observer, new SingletonArrayFunc()));
            } else {
                MaybeZipArray.ZipCoordinator<T, R> parent = new MaybeZipArray.ZipCoordinator<>(observer, n, this.zipper);
                observer.onSubscribe(parent);
                for (int i = 0; i < n && !parent.isDisposed(); i++) {
                    a[i].subscribe(parent.observers[i]);
                }
            }
        } catch (Throwable th2) {
            ex = th2;
            Exceptions.throwIfFatal(ex);
            EmptyDisposable.error(ex, observer);
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
                io.reactivex.internal.operators.maybe.MaybeZipIterable r0 = io.reactivex.internal.operators.maybe.MaybeZipIterable.this
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.maybe.MaybeZipIterable.SingletonArrayFunc.apply(java.lang.Object):java.lang.Object");
        }
    }
}
