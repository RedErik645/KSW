package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.AsyncEmitter;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeFromAsync<T> implements Observable.OnSubscribe<T> {
    final Action1<AsyncEmitter<T>> asyncEmitter;
    final AsyncEmitter.BackpressureMode backpressure;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeFromAsync(Action1<AsyncEmitter<T>> asyncEmitter2, AsyncEmitter.BackpressureMode backpressure2) {
        this.asyncEmitter = asyncEmitter2;
        this.backpressure = backpressure2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.OnSubscribeFromAsync$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$rx$AsyncEmitter$BackpressureMode;

        static {
            int[] iArr = new int[AsyncEmitter.BackpressureMode.values().length];
            $SwitchMap$rx$AsyncEmitter$BackpressureMode = iArr;
            try {
                iArr[AsyncEmitter.BackpressureMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$rx$AsyncEmitter$BackpressureMode[AsyncEmitter.BackpressureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$rx$AsyncEmitter$BackpressureMode[AsyncEmitter.BackpressureMode.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$rx$AsyncEmitter$BackpressureMode[AsyncEmitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void call(Subscriber<? super T> t) {
        BaseAsyncEmitter<T> emitter;
        switch (AnonymousClass1.$SwitchMap$rx$AsyncEmitter$BackpressureMode[this.backpressure.ordinal()]) {
            case 1:
                emitter = new NoneAsyncEmitter<>(t);
                break;
            case 2:
                emitter = new ErrorAsyncEmitter<>(t);
                break;
            case 3:
                emitter = new DropAsyncEmitter<>(t);
                break;
            case 4:
                emitter = new LatestAsyncEmitter<>(t);
                break;
            default:
                emitter = new BufferAsyncEmitter<>(t, RxRingBuffer.SIZE);
                break;
        }
        t.add(emitter);
        t.setProducer(emitter);
        this.asyncEmitter.call(emitter);
    }

    static final class CancellableSubscription extends AtomicReference<AsyncEmitter.Cancellable> implements Subscription {
        private static final long serialVersionUID = 5718521705281392066L;

        public CancellableSubscription(AsyncEmitter.Cancellable cancellable) {
            super(cancellable);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == null;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            AsyncEmitter.Cancellable c;
            if (get() != null && (c = (AsyncEmitter.Cancellable) getAndSet(null)) != null) {
                try {
                    c.cancel();
                } catch (Exception ex) {
                    Exceptions.throwIfFatal(ex);
                    RxJavaHooks.onError(ex);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class BaseAsyncEmitter<T> extends AtomicLong implements AsyncEmitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> actual;
        final SerialSubscription serial = new SerialSubscription();

        public BaseAsyncEmitter(Subscriber<? super T> actual2) {
            this.actual = actual2;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onCompleted();
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onError(e);
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        @Override // rx.Subscription
        public final void unsubscribe() {
            this.serial.unsubscribe();
            onUnsubscribed();
        }

        /* access modifiers changed from: package-private */
        public void onUnsubscribed() {
        }

        @Override // rx.Subscription
        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        @Override // rx.Producer
        public final void request(long n) {
            if (BackpressureUtils.validate(n)) {
                BackpressureUtils.getAndAddRequest(this, n);
                onRequested();
            }
        }

        /* access modifiers changed from: package-private */
        public void onRequested() {
        }

        @Override // rx.AsyncEmitter
        public final void setSubscription(Subscription s) {
            this.serial.set(s);
        }

        @Override // rx.AsyncEmitter
        public final void setCancellation(AsyncEmitter.Cancellable c) {
            setSubscription(new CancellableSubscription(c));
        }

        @Override // rx.AsyncEmitter
        public final long requested() {
            return get();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class NoneAsyncEmitter<T> extends BaseAsyncEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public NoneAsyncEmitter(Subscriber<? super T> actual) {
            super(actual);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            long r;
            if (!this.actual.isUnsubscribed()) {
                this.actual.onNext(t);
                do {
                    r = get();
                    if (r == 0) {
                        return;
                    }
                } while (!compareAndSet(r, r - 1));
            }
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseAsyncEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        /* access modifiers changed from: package-private */
        public abstract void onOverflow();

        public NoOverflowBaseAsyncEmitter(Subscriber<? super T> actual) {
            super(actual);
        }

        @Override // rx.Observer
        public final void onNext(T t) {
            if (!this.actual.isUnsubscribed()) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    BackpressureUtils.produced(this, 1);
                    return;
                }
                onOverflow();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public DropAsyncEmitter(Subscriber<? super T> actual) {
            super(actual);
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OnSubscribeFromAsync.NoOverflowBaseAsyncEmitter
        public void onOverflow() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        public ErrorAsyncEmitter(Subscriber<? super T> actual) {
            super(actual);
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OnSubscribeFromAsync.NoOverflowBaseAsyncEmitter
        public void onOverflow() {
            onError(new MissingBackpressureException("fromAsync: could not emit value due to lack of requests"));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class BufferAsyncEmitter<T> extends BaseAsyncEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final NotificationLite<T> nl;
        final Queue<Object> queue;
        final AtomicInteger wip;

        public BufferAsyncEmitter(Subscriber<? super T> actual, int capacityHint) {
            super(actual);
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(capacityHint) : new SpscUnboundedAtomicArrayQueue<>(capacityHint);
            this.wip = new AtomicInteger();
            this.nl = NotificationLite.instance();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.queue.offer(this.nl.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter, rx.Observer
        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter, rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter
        public void onRequested() {
            drain();
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter
        public void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int missed = 1;
                Subscriber<? super T> a = this.actual;
                Queue<Object> q = this.queue;
                do {
                    long r = get();
                    long e = 0;
                    while (e != r) {
                        if (a.isUnsubscribed()) {
                            q.clear();
                            return;
                        }
                        boolean d = this.done;
                        Object o = q.poll();
                        boolean empty = o == null;
                        if (d && empty) {
                            Throwable ex = this.error;
                            if (ex != null) {
                                super.onError(ex);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (empty) {
                            break;
                        } else {
                            a.onNext(this.nl.getValue(o));
                            e++;
                        }
                    }
                    if (e == r) {
                        if (a.isUnsubscribed()) {
                            q.clear();
                            return;
                        }
                        boolean d2 = this.done;
                        boolean empty2 = q.isEmpty();
                        if (d2 && empty2) {
                            Throwable ex2 = this.error;
                            if (ex2 != null) {
                                super.onError(ex2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (e != 0) {
                        BackpressureUtils.produced(this, e);
                    }
                    missed = this.wip.addAndGet(-missed);
                } while (missed != 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class LatestAsyncEmitter<T> extends BaseAsyncEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final NotificationLite<T> nl = NotificationLite.instance();
        final AtomicReference<Object> queue = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        public LatestAsyncEmitter(Subscriber<? super T> actual) {
            super(actual);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.queue.set(this.nl.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter, rx.Observer
        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter, rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter
        public void onRequested() {
            drain();
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter
        public void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            boolean empty;
            if (this.wip.getAndIncrement() == 0) {
                int missed = 1;
                Subscriber<? super T> a = this.actual;
                AtomicReference<Object> q = this.queue;
                do {
                    long r = get();
                    long e = 0;
                    while (true) {
                        empty = true;
                        if (e == r) {
                            break;
                        } else if (a.isUnsubscribed()) {
                            q.lazySet(null);
                            return;
                        } else {
                            boolean d = this.done;
                            Object o = q.getAndSet(null);
                            boolean empty2 = o == null;
                            if (d && empty2) {
                                Throwable ex = this.error;
                                if (ex != null) {
                                    super.onError(ex);
                                    return;
                                } else {
                                    super.onCompleted();
                                    return;
                                }
                            } else if (empty2) {
                                break;
                            } else {
                                a.onNext(this.nl.getValue(o));
                                e++;
                            }
                        }
                    }
                    if (e == r) {
                        if (a.isUnsubscribed()) {
                            q.lazySet(null);
                            return;
                        }
                        boolean d2 = this.done;
                        if (q.get() != null) {
                            empty = false;
                        }
                        if (d2 && empty) {
                            Throwable ex2 = this.error;
                            if (ex2 != null) {
                                super.onError(ex2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (e != 0) {
                        BackpressureUtils.produced(this, e);
                    }
                    missed = this.wip.addAndGet(-missed);
                } while (missed != 0);
            }
        }
    }
}
