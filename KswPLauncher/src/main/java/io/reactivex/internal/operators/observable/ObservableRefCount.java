package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {
    RefConnection connection;
    final int n;
    final Scheduler scheduler;
    final ConnectableObservable<T> source;
    final long timeout;
    final TimeUnit unit;

    public ObservableRefCount(ConnectableObservable<T> source2) {
        this(source2, 1, 0, TimeUnit.NANOSECONDS, null);
    }

    public ObservableRefCount(ConnectableObservable<T> source2, int n2, long timeout2, TimeUnit unit2, Scheduler scheduler2) {
        this.source = source2;
        this.n = n2;
        this.timeout = timeout2;
        this.unit = unit2;
        this.scheduler = scheduler2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        RefConnection conn;
        boolean connect = false;
        synchronized (this) {
            conn = this.connection;
            if (conn == null) {
                conn = new RefConnection(this);
                this.connection = conn;
            }
            long c = conn.subscriberCount;
            if (c == 0 && conn.timer != null) {
                conn.timer.dispose();
            }
            conn.subscriberCount = c + 1;
            if (!conn.connected && 1 + c == ((long) this.n)) {
                connect = true;
                conn.connected = true;
            }
        }
        this.source.subscribe(new RefCountObserver(observer, this, conn));
        if (connect) {
            this.source.connect(conn);
        }
    }

    /* access modifiers changed from: package-private */
    public void cancel(RefConnection rc) {
        synchronized (this) {
            RefConnection refConnection = this.connection;
            if (refConnection != null) {
                if (refConnection == rc) {
                    long c = rc.subscriberCount - 1;
                    rc.subscriberCount = c;
                    if (c == 0) {
                        if (rc.connected) {
                            if (this.timeout == 0) {
                                timeout(rc);
                                return;
                            }
                            SequentialDisposable sd = new SequentialDisposable();
                            rc.timer = sd;
                            sd.replace(this.scheduler.scheduleDirect(rc, this.timeout, this.unit));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void terminated(RefConnection rc) {
        synchronized (this) {
            if (this.source instanceof ObservablePublishClassic) {
                RefConnection refConnection = this.connection;
                if (refConnection != null && refConnection == rc) {
                    this.connection = null;
                    clearTimer(rc);
                }
                long j = rc.subscriberCount - 1;
                rc.subscriberCount = j;
                if (j == 0) {
                    reset(rc);
                }
            } else {
                RefConnection refConnection2 = this.connection;
                if (refConnection2 != null && refConnection2 == rc) {
                    clearTimer(rc);
                    long j2 = rc.subscriberCount - 1;
                    rc.subscriberCount = j2;
                    if (j2 == 0) {
                        this.connection = null;
                        reset(rc);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearTimer(RefConnection rc) {
        if (rc.timer != null) {
            rc.timer.dispose();
            rc.timer = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void reset(RefConnection rc) {
        ConnectableObservable<T> connectableObservable = this.source;
        if (connectableObservable instanceof Disposable) {
            ((Disposable) connectableObservable).dispose();
        } else if (connectableObservable instanceof ResettableConnectable) {
            ((ResettableConnectable) connectableObservable).resetIf((Disposable) rc.get());
        }
    }

    /* access modifiers changed from: package-private */
    public void timeout(RefConnection rc) {
        synchronized (this) {
            if (rc.subscriberCount == 0 && rc == this.connection) {
                this.connection = null;
                Disposable connectionObject = (Disposable) rc.get();
                DisposableHelper.dispose(rc);
                ConnectableObservable<T> connectableObservable = this.source;
                if (connectableObservable instanceof Disposable) {
                    ((Disposable) connectableObservable).dispose();
                } else if (connectableObservable instanceof ResettableConnectable) {
                    if (connectionObject == null) {
                        rc.disconnectedEarly = true;
                    } else {
                        ((ResettableConnectable) connectableObservable).resetIf(connectionObject);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        RefConnection(ObservableRefCount<?> parent2) {
            this.parent = parent2;
        }

        public void run() {
            this.parent.timeout(this);
        }

        public void accept(Disposable t) throws Exception {
            DisposableHelper.replace(this, t);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ResettableConnectable) this.parent.source).resetIf(t);
                }
            }
        }
    }

    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Observer<? super T> downstream;
        final ObservableRefCount<T> parent;
        Disposable upstream;

        RefCountObserver(Observer<? super T> downstream2, ObservableRefCount<T> parent2, RefConnection connection2) {
            this.downstream = downstream2;
            this.parent = parent2;
            this.connection = connection2;
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable t) {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onError(t);
                return;
            }
            RxJavaPlugins.onError(t);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.cancel(this.connection);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }
    }
}
