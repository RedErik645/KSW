package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ObservablePublishClassic<T> {
    final AtomicReference<PublishObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    public static <T> ConnectableObservable<T> create(ObservableSource<T> source2) {
        AtomicReference<PublishObserver<T>> curr = new AtomicReference<>();
        return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservablePublish(new PublishSource<>(curr), source2, curr));
    }

    private ObservablePublish(ObservableSource<T> onSubscribe2, ObservableSource<T> source2, AtomicReference<PublishObserver<T>> current2) {
        this.onSubscribe = onSubscribe2;
        this.source = source2;
        this.current = current2;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.internal.operators.observable.ObservablePublishClassic
    public ObservableSource<T> publishSource() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> connection) {
        PublishObserver<T> ps;
        while (true) {
            ps = this.current.get();
            if (ps != null && !ps.isDisposed()) {
                break;
            }
            PublishObserver<T> u = new PublishObserver<>(this.current);
            if (this.current.compareAndSet(ps, u)) {
                ps = u;
                break;
            }
        }
        boolean doConnect = true;
        if (ps.shouldConnect.get() || !ps.shouldConnect.compareAndSet(false, true)) {
            doConnect = false;
        }
        try {
            connection.accept(ps);
            if (doConnect) {
                this.source.subscribe(ps);
            }
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            throw ExceptionHelper.wrapOrThrow(ex);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class PublishObserver<T> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        final AtomicReference<PublishObserver<T>> current;
        final AtomicReference<InnerDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect;
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        PublishObserver(AtomicReference<PublishObserver<T>> current2) {
            this.current = current2;
            this.shouldConnect = new AtomicBoolean();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            AtomicReference<InnerDisposable<T>[]> atomicReference = this.observers;
            InnerDisposable[] innerDisposableArr = TERMINATED;
            if (atomicReference.getAndSet(innerDisposableArr) != innerDisposableArr) {
                this.current.compareAndSet(this, null);
                DisposableHelper.dispose(this.upstream);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this.upstream, d);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            for (InnerDisposable<T> inner : this.observers.get()) {
                inner.child.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable e) {
            this.current.compareAndSet(this, null);
            InnerDisposable<T>[] a = this.observers.getAndSet(TERMINATED);
            if (a.length != 0) {
                for (InnerDisposable<T> inner : a) {
                    inner.child.onError(e);
                }
                return;
            }
            RxJavaPlugins.onError(e);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.current.compareAndSet(this, null);
            for (InnerDisposable<T> inner : this.observers.getAndSet(TERMINATED)) {
                inner.child.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean add(InnerDisposable<T> producer) {
            InnerDisposable<T>[] c;
            InnerDisposable<T>[] u;
            do {
                c = this.observers.get();
                if (c == TERMINATED) {
                    return false;
                }
                int len = c.length;
                u = new InnerDisposable[(len + 1)];
                System.arraycopy(c, 0, u, 0, len);
                u[len] = producer;
            } while (!this.observers.compareAndSet(c, u));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void remove(InnerDisposable<T> producer) {
            InnerDisposable<T>[] c;
            InnerDisposable<T>[] u;
            do {
                c = this.observers.get();
                int len = c.length;
                if (len != 0) {
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= len) {
                            break;
                        } else if (c[i].equals(producer)) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (len == 1) {
                            u = EMPTY;
                        } else {
                            InnerDisposable<T>[] u2 = new InnerDisposable[(len - 1)];
                            System.arraycopy(c, 0, u2, 0, j);
                            System.arraycopy(c, j + 1, u2, j, (len - j) - 1);
                            u = u2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(c, u));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        final Observer<? super T> child;

        InnerDisposable(Observer<? super T> child2) {
            this.child = child2;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == this;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object o = getAndSet(this);
            if (o != null && o != this) {
                ((PublishObserver) o).remove(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setParent(PublishObserver<T> p) {
            if (!compareAndSet(null, p)) {
                p.remove(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class PublishSource<T> implements ObservableSource<T> {
        private final AtomicReference<PublishObserver<T>> curr;

        PublishSource(AtomicReference<PublishObserver<T>> curr2) {
            this.curr = curr2;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> child) {
            InnerDisposable<T> inner = new InnerDisposable<>(child);
            child.onSubscribe(inner);
            while (true) {
                PublishObserver<T> r = this.curr.get();
                if (r == null || r.isDisposed()) {
                    PublishObserver<T> u = new PublishObserver<>(this.curr);
                    if (!this.curr.compareAndSet(r, u)) {
                        continue;
                    } else {
                        r = u;
                    }
                }
                if (r.add(inner)) {
                    inner.setParent(r);
                    return;
                }
            }
        }
    }
}
