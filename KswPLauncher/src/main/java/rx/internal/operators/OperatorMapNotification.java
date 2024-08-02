package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OperatorMapNotification<T, R> implements Observable.Operator<R, T> {
    final Func0<? extends R> onCompleted;
    final Func1<? super Throwable, ? extends R> onError;
    final Func1<? super T, ? extends R> onNext;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorMapNotification(Func1<? super T, ? extends R> onNext2, Func1<? super Throwable, ? extends R> onError2, Func0<? extends R> onCompleted2) {
        this.onNext = onNext2;
        this.onError = onError2;
        this.onCompleted = onCompleted2;
    }

    public Subscriber<? super T> call(Subscriber<? super R> child) {
        final MapNotificationSubscriber<T, R> parent = new MapNotificationSubscriber<>(child, this.onNext, this.onError, this.onCompleted);
        child.add(parent);
        child.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorMapNotification.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long n) {
                parent.requestInner(n);
            }
        });
        return parent;
    }

    /* access modifiers changed from: package-private */
    public static final class MapNotificationSubscriber<T, R> extends Subscriber<T> {
        static final long COMPLETED_FLAG = Long.MIN_VALUE;
        static final long REQUESTED_MASK = Long.MAX_VALUE;
        final Subscriber<? super R> actual;
        final AtomicLong missedRequested = new AtomicLong();
        final Func0<? extends R> onCompleted;
        final Func1<? super Throwable, ? extends R> onError;
        final Func1<? super T, ? extends R> onNext;
        long produced;
        final AtomicReference<Producer> producer = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        R value;

        public MapNotificationSubscriber(Subscriber<? super R> actual2, Func1<? super T, ? extends R> onNext2, Func1<? super Throwable, ? extends R> onError2, Func0<? extends R> onCompleted2) {
            this.actual = actual2;
            this.onNext = onNext2;
            this.onError = onError2;
            this.onCompleted = onCompleted2;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            try {
                this.produced++;
                this.actual.onNext((Object) this.onNext.call(t));
            } catch (Throwable ex) {
                Exceptions.throwOrReport(ex, this.actual, t);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            accountProduced();
            try {
                this.value = (R) this.onError.call(e);
            } catch (Throwable ex) {
                Exceptions.throwOrReport(ex, this.actual, e);
            }
            tryEmit();
        }

        @Override // rx.Observer
        public void onCompleted() {
            accountProduced();
            try {
                this.value = (R) this.onCompleted.call();
            } catch (Throwable ex) {
                Exceptions.throwOrReport(ex, this.actual);
            }
            tryEmit();
        }

        /* access modifiers changed from: package-private */
        public void accountProduced() {
            long p = this.produced;
            if (p != 0 && this.producer.get() != null) {
                BackpressureUtils.produced(this.requested, p);
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer p) {
            if (this.producer.compareAndSet(null, p)) {
                long r = this.missedRequested.getAndSet(0);
                if (r != 0) {
                    p.request(r);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Producer already set!");
        }

        /* access modifiers changed from: package-private */
        public void tryEmit() {
            long r;
            do {
                r = this.requested.get();
                if ((r & Long.MIN_VALUE) != 0) {
                    return;
                }
            } while (!this.requested.compareAndSet(r, Long.MIN_VALUE | r));
            if (r != 0 || this.producer.get() == null) {
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onNext(this.value);
                }
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onCompleted();
                }
            }
        }

        /* JADX INFO: Multiple debug info for r2v5 java.util.concurrent.atomic.AtomicReference<rx.Producer>: [D('r' long), D('localProducer' java.util.concurrent.atomic.AtomicReference<rx.Producer>)] */
        /* access modifiers changed from: package-private */
        public void requestInner(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + n);
            } else if (n != 0) {
                while (true) {
                    long r = this.requested.get();
                    if ((r & Long.MIN_VALUE) != 0) {
                        long v = Long.MAX_VALUE & r;
                        if (this.requested.compareAndSet(r, Long.MIN_VALUE | BackpressureUtils.addCap(v, n))) {
                            if (v == 0) {
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onNext(this.value);
                                }
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onCompleted();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        if (this.requested.compareAndSet(r, BackpressureUtils.addCap(r, n))) {
                            AtomicReference<Producer> localProducer = this.producer;
                            Producer actualProducer = localProducer.get();
                            if (actualProducer != null) {
                                actualProducer.request(n);
                                return;
                            }
                            BackpressureUtils.getAndAddRequest(this.missedRequested, n);
                            Producer actualProducer2 = localProducer.get();
                            if (actualProducer2 != null) {
                                long r2 = this.missedRequested.getAndSet(0);
                                if (r2 != 0) {
                                    actualProducer2.request(r2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
