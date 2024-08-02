package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OperatorScan<R, T> implements Observable.Operator<R, T> {
    private static final Object NO_INITIAL_VALUE = new Object();
    final Func2<R, ? super T, R> accumulator;
    private final Func0<R> initialValueFactory;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorScan(final R initialValue, Func2<R, ? super T, R> accumulator2) {
        this((Func0) new Func0<R>() {
            /* class rx.internal.operators.OperatorScan.AnonymousClass1 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public R call() {
                return (R) initialValue;
            }
        }, (Func2) accumulator2);
    }

    public OperatorScan(Func0<R> initialValueFactory2, Func2<R, ? super T, R> accumulator2) {
        this.initialValueFactory = initialValueFactory2;
        this.accumulator = accumulator2;
    }

    public OperatorScan(Func2<R, ? super T, R> accumulator2) {
        this(NO_INITIAL_VALUE, accumulator2);
    }

    public Subscriber<? super T> call(final Subscriber<? super R> child) {
        R initialValue = this.initialValueFactory.call();
        if (initialValue == NO_INITIAL_VALUE) {
            return new Subscriber<T>(child) {
                /* class rx.internal.operators.OperatorScan.AnonymousClass2 */
                boolean once;
                R value;

                @Override // rx.Observer
                public void onNext(T t) {
                    R v;
                    if (!this.once) {
                        this.once = true;
                        v = (R) t;
                    } else {
                        try {
                            v = OperatorScan.this.accumulator.call(this.value, t);
                        } catch (Throwable e) {
                            Exceptions.throwOrReport(e, child, t);
                            return;
                        }
                    }
                    this.value = v;
                    child.onNext(v);
                }

                @Override // rx.Observer
                public void onError(Throwable e) {
                    child.onError(e);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    child.onCompleted();
                }
            };
        }
        InitialProducer<R> ip = new InitialProducer<>(initialValue, child);
        Subscriber<T> parent = new Subscriber<T>(initialValue, ip) {
            /* class rx.internal.operators.OperatorScan.AnonymousClass3 */
            final /* synthetic */ Object val$initialValue;
            final /* synthetic */ InitialProducer val$ip;
            private R value;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.val$initialValue = r2;
                this.val$ip = r3;
                this.value = r2;
            }

            @Override // rx.Observer
            public void onNext(T currentValue) {
                try {
                    R v = OperatorScan.this.accumulator.call(this.value, currentValue);
                    this.value = v;
                    this.val$ip.onNext(v);
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, this, currentValue);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                this.val$ip.onError(e);
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.val$ip.onCompleted();
            }

            @Override // rx.Subscriber
            public void setProducer(Producer producer) {
                this.val$ip.setProducer(producer);
            }
        };
        child.add(parent);
        child.setProducer(ip);
        return parent;
    }

    /* access modifiers changed from: package-private */
    public static final class InitialProducer<R> implements Producer, Observer<R> {
        final Subscriber<? super R> child;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        long missedRequested;
        volatile Producer producer;
        final Queue<Object> queue;
        final AtomicLong requested;

        public InitialProducer(R initialValue, Subscriber<? super R> child2) {
            Queue<Object> q;
            this.child = child2;
            if (UnsafeAccess.isUnsafeAvailable()) {
                q = new SpscLinkedQueue<>();
            } else {
                q = new SpscLinkedAtomicQueue<>();
            }
            this.queue = q;
            q.offer(NotificationLite.instance().next(initialValue));
            this.requested = new AtomicLong();
        }

        @Override // rx.Observer
        public void onNext(R t) {
            this.queue.offer(NotificationLite.instance().next(t));
            emit();
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean d, boolean empty, Subscriber<? super R> child2) {
            if (child2.isUnsubscribed()) {
                return true;
            }
            if (!d) {
                return false;
            }
            Throwable err = this.error;
            if (err != null) {
                child2.onError(err);
                return true;
            } else if (!empty) {
                return false;
            } else {
                child2.onCompleted();
                return true;
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= required but it was " + n);
            } else if (n != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, n);
                Producer p = this.producer;
                if (p == null) {
                    synchronized (this.requested) {
                        p = this.producer;
                        if (p == null) {
                            this.missedRequested = BackpressureUtils.addCap(this.missedRequested, n);
                        }
                    }
                }
                if (p != null) {
                    p.request(n);
                }
                emit();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
            if (r3 <= 0) goto L_0x0025;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
            r10.request(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
            emit();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setProducer(rx.Producer r10) {
            /*
                r9 = this;
                if (r10 == 0) goto L_0x0039
                java.util.concurrent.atomic.AtomicLong r0 = r9.requested
                monitor-enter(r0)
                r1 = 0
                rx.Producer r3 = r9.producer     // Catch:{ all -> 0x0031 }
                if (r3 != 0) goto L_0x0029
                long r3 = r9.missedRequested     // Catch:{ all -> 0x0031 }
                r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 == 0) goto L_0x0019
                r5 = 1
                long r3 = r3 - r5
            L_0x0019:
                r9.missedRequested = r1     // Catch:{ all -> 0x0037 }
                r9.producer = r10     // Catch:{ all -> 0x0037 }
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0025
                r10.request(r3)
            L_0x0025:
                r9.emit()
                return
            L_0x0029:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "Can't set more than one Producer!"
                r3.<init>(r4)
                throw r3
            L_0x0031:
                r3 = move-exception
                r7 = r1
                r1 = r3
                r3 = r7
            L_0x0035:
                monitor-exit(r0)
                throw r1
            L_0x0037:
                r1 = move-exception
                goto L_0x0035
            L_0x0039:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorScan.InitialProducer.setProducer(rx.Producer):void");
        }

        /* access modifiers changed from: package-private */
        public void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                emitLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public void emitLoop() {
            Subscriber<? super R> child2 = this.child;
            Queue<Object> queue2 = this.queue;
            NotificationLite<R> nl = NotificationLite.instance();
            AtomicLong requested2 = this.requested;
            long r = requested2.get();
            while (!checkTerminated(this.done, queue2.isEmpty(), child2)) {
                long e = 0;
                while (e != r) {
                    boolean d = this.done;
                    Object o = queue2.poll();
                    boolean empty = o == null;
                    if (!checkTerminated(d, empty, child2)) {
                        if (empty) {
                            break;
                        }
                        R v = nl.getValue(o);
                        try {
                            child2.onNext(v);
                            e++;
                        } catch (Throwable ex) {
                            Exceptions.throwOrReport(ex, child2, v);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (!(e == 0 || r == LongCompanionObject.MAX_VALUE)) {
                    r = BackpressureUtils.produced(requested2, e);
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                }
            }
        }
    }
}
