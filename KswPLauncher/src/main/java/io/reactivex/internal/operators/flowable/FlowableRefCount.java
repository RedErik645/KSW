package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRefCount<T> extends Flowable<T> {
    RefConnection connection;
    final int n;
    final Scheduler scheduler;
    final ConnectableFlowable<T> source;
    final long timeout;
    final TimeUnit unit;

    public FlowableRefCount(ConnectableFlowable<T> source2) {
        this(source2, 1, 0, TimeUnit.NANOSECONDS, null);
    }

    public FlowableRefCount(ConnectableFlowable<T> source2, int n2, long timeout2, TimeUnit unit2, Scheduler scheduler2) {
        this.source = source2;
        this.n = n2;
        this.timeout = timeout2;
        this.unit = unit2;
        this.scheduler = scheduler2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
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
        this.source.subscribe((FlowableSubscriber) new RefCountSubscriber(s, this, conn));
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
            if (this.source instanceof FlowablePublishClassic) {
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
        ConnectableFlowable<T> connectableFlowable = this.source;
        if (connectableFlowable instanceof Disposable) {
            ((Disposable) connectableFlowable).dispose();
        } else if (connectableFlowable instanceof ResettableConnectable) {
            ((ResettableConnectable) connectableFlowable).resetIf((Disposable) rc.get());
        }
    }

    /* access modifiers changed from: package-private */
    public void timeout(RefConnection rc) {
        synchronized (this) {
            if (rc.subscriberCount == 0 && rc == this.connection) {
                this.connection = null;
                Disposable connectionObject = (Disposable) rc.get();
                DisposableHelper.dispose(rc);
                ConnectableFlowable<T> connectableFlowable = this.source;
                if (connectableFlowable instanceof Disposable) {
                    ((Disposable) connectableFlowable).dispose();
                } else if (connectableFlowable instanceof ResettableConnectable) {
                    if (connectionObject == null) {
                        rc.disconnectedEarly = true;
                    } else {
                        ((ResettableConnectable) connectableFlowable).resetIf(connectionObject);
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
        final FlowableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        RefConnection(FlowableRefCount<?> parent2) {
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

    static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Subscriber<? super T> downstream;
        final FlowableRefCount<T> parent;
        Subscription upstream;

        RefCountSubscriber(Subscriber<? super T> actual, FlowableRefCount<T> parent2, RefConnection connection2) {
            this.downstream = actual;
            this.parent = parent2;
            this.connection = connection2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onError(t);
                return;
            }
            RxJavaPlugins.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            this.upstream.request(n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                this.parent.cancel(this.connection);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }
    }
}
