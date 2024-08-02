package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Object[], R> combiner;
    final ObservableSource<?>[] otherArray;
    final Iterable<? extends ObservableSource<?>> otherIterable;

    public ObservableWithLatestFromMany(ObservableSource<T> source, ObservableSource<?>[] otherArray2, Function<? super Object[], R> combiner2) {
        super(source);
        this.otherArray = otherArray2;
        this.otherIterable = null;
        this.combiner = combiner2;
    }

    public ObservableWithLatestFromMany(ObservableSource<T> source, Iterable<? extends ObservableSource<?>> otherIterable2, Function<? super Object[], R> combiner2) {
        super(source);
        this.otherArray = null;
        this.otherIterable = otherIterable2;
        this.combiner = combiner2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        Throwable ex;
        ObservableSource<?>[] others = this.otherArray;
        int n = 0;
        if (others == null) {
            others = new ObservableSource[8];
            try {
                for (ObservableSource<?> p : this.otherIterable) {
                    if (n == others.length) {
                        others = (ObservableSource[]) Arrays.copyOf(others, (n >> 1) + n);
                    }
                    int n2 = n + 1;
                    try {
                        others[n] = p;
                        n = n2;
                    } catch (Throwable th) {
                        ex = th;
                        Exceptions.throwIfFatal(ex);
                        EmptyDisposable.error(ex, observer);
                        return;
                    }
                }
            } catch (Throwable th2) {
                ex = th2;
                Exceptions.throwIfFatal(ex);
                EmptyDisposable.error(ex, observer);
                return;
            }
        } else {
            n = others.length;
        }
        if (n == 0) {
            new ObservableMap(this.source, new SingletonArrayFunc()).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver<T, R> parent = new WithLatestFromObserver<>(observer, this.combiner, n);
        observer.onSubscribe(parent);
        parent.subscribe(others, n);
        this.source.subscribe(parent);
    }

    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;
        final Function<? super Object[], R> combiner;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable error;
        final WithLatestInnerObserver[] observers;
        final AtomicReference<Disposable> upstream;
        final AtomicReferenceArray<Object> values;

        WithLatestFromObserver(Observer<? super R> actual, Function<? super Object[], R> combiner2, int n) {
            this.downstream = actual;
            this.combiner = combiner2;
            WithLatestInnerObserver[] s = new WithLatestInnerObserver[n];
            for (int i = 0; i < n; i++) {
                s[i] = new WithLatestInnerObserver(this, i);
            }
            this.observers = s;
            this.values = new AtomicReferenceArray<>(n);
            this.upstream = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void subscribe(ObservableSource<?>[] others, int n) {
            WithLatestInnerObserver[] observers2 = this.observers;
            AtomicReference<Disposable> upstream2 = this.upstream;
            for (int i = 0; i < n && !DisposableHelper.isDisposed(upstream2.get()) && !this.done; i++) {
                others[i].subscribe(observers2[i]);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this.upstream, d);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.done) {
                AtomicReferenceArray<Object> ara = this.values;
                int n = ara.length();
                Object[] objects = new Object[(n + 1)];
                objects[0] = t;
                for (int i = 0; i < n; i++) {
                    Object o = ara.get(i);
                    if (o != null) {
                        objects[i + 1] = o;
                    } else {
                        return;
                    }
                }
                try {
                    HalfSerializer.onNext(this.downstream, ObjectHelper.requireNonNull(this.combiner.apply(objects), "combiner returned a null value"), this, this.error);
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    dispose();
                    onError(ex);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onError(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                cancelAllBut(-1);
                HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            for (WithLatestInnerObserver observer : this.observers) {
                observer.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerNext(int index, Object o) {
            this.values.set(index, o);
        }

        /* access modifiers changed from: package-private */
        public void innerError(int index, Throwable t) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            cancelAllBut(index);
            HalfSerializer.onError(this.downstream, t, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public void innerComplete(int index, boolean nonEmpty) {
            if (!nonEmpty) {
                this.done = true;
                cancelAllBut(index);
                HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAllBut(int index) {
            WithLatestInnerObserver[] observers2 = this.observers;
            for (int i = 0; i < observers2.length; i++) {
                if (i != index) {
                    observers2[i].dispose();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromObserver<?, ?> parent;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> parent2, int index2) {
            this.parent = parent2;
            this.index = index2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this, d);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object t) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable t) {
            this.parent.innerError(this.index, t);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
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
                io.reactivex.internal.operators.observable.ObservableWithLatestFromMany r0 = io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.this
                io.reactivex.functions.Function<? super java.lang.Object[], R> r0 = r0.combiner
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                r1[r2] = r4
                java.lang.Object r0 = r0.apply(r1)
                java.lang.String r1 = "The combiner returned a null value"
                java.lang.Object r0 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.SingletonArrayFunc.apply(java.lang.Object):java.lang.Object");
        }
    }
}
