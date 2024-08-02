package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

public final class OperatorOnBackpressureLatest<T> implements Observable.Operator<T, T> {
    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* access modifiers changed from: package-private */
    public static final class Holder {
        static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> instance() {
        return (OperatorOnBackpressureLatest<T>) Holder.INSTANCE;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        LatestEmitter<T> producer = new LatestEmitter<>(child);
        LatestSubscriber<T> parent = new LatestSubscriber<>(producer);
        producer.parent = parent;
        child.add(parent);
        child.add(producer);
        child.setProducer(producer);
        return parent;
    }

    /* access modifiers changed from: package-private */
    public static final class LatestEmitter<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final Subscriber<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        LatestSubscriber<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(Subscriber<? super T> child2) {
            this.child = child2;
            lazySet(NOT_REQUESTED);
        }

        @Override // rx.Producer
        public void request(long n) {
            long r;
            long u;
            if (n >= 0) {
                do {
                    r = get();
                    if (r != Long.MIN_VALUE) {
                        if (r == NOT_REQUESTED) {
                            u = n;
                        } else {
                            u = r + n;
                            if (u < 0) {
                                u = LongCompanionObject.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(r, u));
                if (r == NOT_REQUESTED) {
                    this.parent.requestMore(LongCompanionObject.MAX_VALUE);
                }
                emit();
            }
        }

        /* access modifiers changed from: package-private */
        public long produced(long n) {
            long r;
            long u;
            do {
                r = get();
                if (r < 0) {
                    return r;
                }
                u = r - n;
            } while (!compareAndSet(r, u));
            return u;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.value.lazySet(t);
            emit();
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.terminal = e;
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r2 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
            if (r2 != Long.MIN_VALUE) goto L_0x001d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            r1 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
            r4 = r9.value.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
            if (r2 <= 0) goto L_0x003e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            r5 = rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.EMPTY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
            if (r4 == r5) goto L_0x003e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
            r9.child.onNext(r4);
            r9.value.compareAndSet(r4, r5);
            produced(1);
            r4 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
            if (r4 != rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.EMPTY) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
            if (r9.done == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
            r5 = r9.terminal;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
            if (r5 == null) goto L_0x0050;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
            r9.child.onError(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
            r9.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
            if (r9.missed != false) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
            r9.emitting = false;
            r1 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005e, code lost:
            if (r1 != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0060, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r9.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0069, code lost:
            r9.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x006b, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0070, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
            if (0 == 0) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0073, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            r9.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x007b, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emit() {
            /*
            // Method dump skipped, instructions count: 127
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.emit():void");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class LatestSubscriber<T> extends Subscriber<T> {
        private final LatestEmitter<T> producer;

        LatestSubscriber(LatestEmitter<T> producer2) {
            this.producer = producer2;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(0);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.producer.onNext(t);
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.producer.onError(e);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.producer.onCompleted();
        }

        /* access modifiers changed from: package-private */
        public void requestMore(long n) {
            request(n);
        }
    }
}
