package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.util.OpenHashSet;
import rx.observables.ConnectableObservable;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

public final class OperatorReplay<T> extends ConnectableObservable<T> {
    static final Func0 DEFAULT_UNBOUNDED_FACTORY = new Func0() {
        /* class rx.internal.operators.OperatorReplay.AnonymousClass1 */

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    };
    final Func0<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Observable<? extends T> source;

    /* access modifiers changed from: package-private */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    public static <T, U, R> Observable<R> multicastSelector(final Func0<? extends ConnectableObservable<U>> connectableFactory, final Func1<? super Observable<U>, ? extends Observable<R>> selector) {
        return Observable.create(new Observable.OnSubscribe<R>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: rx.functions.Func1 */
            /* JADX WARN: Multi-variable type inference failed */
            public void call(final Subscriber<? super R> child) {
                Throwable e;
                try {
                    ConnectableObservable<U> co = (ConnectableObservable) connectableFactory.call();
                    try {
                        ((Observable) selector.call(co)).subscribe(child);
                        co.connect(new Action1<Subscription>() {
                            /* class rx.internal.operators.OperatorReplay.AnonymousClass2.AnonymousClass1 */

                            public void call(Subscription t) {
                                child.add(t);
                            }
                        });
                    } catch (Throwable th) {
                        e = th;
                        Exceptions.throwOrReport(e, child);
                    }
                } catch (Throwable th2) {
                    e = th2;
                    Exceptions.throwOrReport(e, child);
                }
            }
        });
    }

    public static <T> ConnectableObservable<T> observeOn(final ConnectableObservable<T> co, Scheduler scheduler) {
        final Observable<T> observable = co.observeOn(scheduler);
        return new ConnectableObservable<T>(new Observable.OnSubscribe<T>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass3 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(final Subscriber<? super T> child) {
                observable.unsafeSubscribe(new Subscriber<T>(child) {
                    /* class rx.internal.operators.OperatorReplay.AnonymousClass3.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onNext(T t) {
                        child.onNext(t);
                    }

                    @Override // rx.Observer
                    public void onError(Throwable e) {
                        child.onError(e);
                    }

                    @Override // rx.Observer
                    public void onCompleted() {
                        child.onCompleted();
                    }
                });
            }
        }) {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass4 */

            @Override // rx.observables.ConnectableObservable
            public void connect(Action1<? super Subscription> connection) {
                co.connect(connection);
            }
        };
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source2) {
        return create(source2, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source2, final int bufferSize) {
        if (bufferSize == Integer.MAX_VALUE) {
            return create(source2);
        }
        return create(source2, new Func0<ReplayBuffer<T>>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass5 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeBoundReplayBuffer(bufferSize);
            }
        });
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source2, long maxAge, TimeUnit unit, Scheduler scheduler) {
        return create(source2, maxAge, unit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source2, long maxAge, TimeUnit unit, final Scheduler scheduler, final int bufferSize) {
        final long maxAgeInMillis = unit.toMillis(maxAge);
        return create(source2, new Func0<ReplayBuffer<T>>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass6 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeAndTimeBoundReplayBuffer(bufferSize, maxAgeInMillis, scheduler);
            }
        });
    }

    static <T> ConnectableObservable<T> create(Observable<? extends T> source2, final Func0<? extends ReplayBuffer<T>> bufferFactory2) {
        final AtomicReference<ReplaySubscriber<T>> curr = new AtomicReference<>();
        return new OperatorReplay(new Observable.OnSubscribe<T>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass7 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(Subscriber<? super T> child) {
                ReplaySubscriber<T> r;
                while (true) {
                    r = (ReplaySubscriber) curr.get();
                    if (r != null) {
                        break;
                    }
                    ReplaySubscriber<T> u = new ReplaySubscriber<>((ReplayBuffer) bufferFactory2.call());
                    u.init();
                    if (curr.compareAndSet(r, u)) {
                        r = u;
                        break;
                    }
                }
                InnerProducer<T> inner = new InnerProducer<>(r, child);
                r.add((InnerProducer) inner);
                child.add(inner);
                r.buffer.replay(inner);
                child.setProducer(inner);
            }
        }, source2, curr, bufferFactory2);
    }

    private OperatorReplay(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> source2, AtomicReference<ReplaySubscriber<T>> current2, Func0<? extends ReplayBuffer<T>> bufferFactory2) {
        super(onSubscribe);
        this.source = source2;
        this.current = current2;
        this.bufferFactory = bufferFactory2;
    }

    @Override // rx.observables.ConnectableObservable
    public void connect(Action1<? super Subscription> connection) {
        ReplaySubscriber<T> ps;
        while (true) {
            ps = this.current.get();
            if (ps != null && !ps.isUnsubscribed()) {
                break;
            }
            ReplaySubscriber<T> u = new ReplaySubscriber<>((ReplayBuffer) this.bufferFactory.call());
            u.init();
            if (this.current.compareAndSet(ps, u)) {
                ps = u;
                break;
            }
        }
        boolean doConnect = true;
        if (ps.shouldConnect.get() || !ps.shouldConnect.compareAndSet(false, true)) {
            doConnect = false;
        }
        connection.call(ps);
        if (doConnect) {
            this.source.unsafeSubscribe(ps);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ReplaySubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final ReplayBuffer<T> buffer;
        boolean coordinateAll;
        List<InnerProducer<T>> coordinationQueue;
        boolean done;
        boolean emitting;
        long maxChildRequested;
        long maxUpstreamRequested;
        boolean missed;
        final NotificationLite<T> nl = NotificationLite.instance();
        volatile Producer producer;
        final OpenHashSet<InnerProducer<T>> producers = new OpenHashSet<>();
        InnerProducer<T>[] producersCache = EMPTY;
        long producersCacheVersion;
        volatile long producersVersion;
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        volatile boolean terminated;

        public ReplaySubscriber(ReplayBuffer<T> buffer2) {
            this.buffer = buffer2;
            request(0);
        }

        /* access modifiers changed from: package-private */
        public void init() {
            add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorReplay.ReplaySubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    if (!ReplaySubscriber.this.terminated) {
                        synchronized (ReplaySubscriber.this.producers) {
                            if (!ReplaySubscriber.this.terminated) {
                                ReplaySubscriber.this.producers.terminate();
                                ReplaySubscriber.this.producersVersion++;
                                ReplaySubscriber.this.terminated = true;
                            }
                        }
                    }
                }
            }));
        }

        /* access modifiers changed from: package-private */
        public boolean add(InnerProducer<T> producer2) {
            if (producer2 == null) {
                throw new NullPointerException();
            } else if (this.terminated) {
                return false;
            } else {
                synchronized (this.producers) {
                    if (this.terminated) {
                        return false;
                    }
                    this.producers.add(producer2);
                    this.producersVersion++;
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void remove(InnerProducer<T> producer2) {
            if (!this.terminated) {
                synchronized (this.producers) {
                    if (!this.terminated) {
                        this.producers.remove(producer2);
                        if (this.producers.isEmpty()) {
                            this.producersCache = EMPTY;
                        }
                        this.producersVersion++;
                    }
                }
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer p) {
            if (this.producer == null) {
                this.producer = p;
                manageRequests(null);
                replay();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.error(e);
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.complete();
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
            r0 = r9.maxChildRequested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            if (r10 == null) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
            r3 = java.lang.Math.max(r0, r10.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            r10 = copyProducers();
            r3 = r10.length;
            r4 = r0;
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
            if (r6 >= r3) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
            r7 = r10[r6];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
            if (r7 == null) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0045, code lost:
            r4 = java.lang.Math.max(r4, r7.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
            makeRequest(r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
            if (isUnsubscribed() == false) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
            if (r9.missed != false) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0062, code lost:
            r9.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0064, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0065, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0066, code lost:
            r9.missed = false;
            r10 = r9.coordinationQueue;
            r9.coordinationQueue = null;
            r0 = r9.coordinateAll;
            r9.coordinateAll = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0071, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0072, code lost:
            r3 = r9.maxChildRequested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0075, code lost:
            if (r10 == null) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0077, code lost:
            r10 = r10.iterator();
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0080, code lost:
            if (r10.hasNext() == false) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
            r5 = java.lang.Math.max(r5, r10.next().totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0093, code lost:
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0094, code lost:
            if (r0 == false) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0096, code lost:
            r10 = copyProducers();
            r0 = r10.length;
            r1 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x009c, code lost:
            if (r1 >= r0) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009e, code lost:
            r7 = r10[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a0, code lost:
            if (r7 == null) goto L_0x00ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a2, code lost:
            r5 = java.lang.Math.max(r5, r7.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ac, code lost:
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00af, code lost:
            makeRequest(r5, r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void manageRequests(rx.internal.operators.OperatorReplay.InnerProducer<T> r10) {
            /*
            // Method dump skipped, instructions count: 185
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.ReplaySubscriber.manageRequests(rx.internal.operators.OperatorReplay$InnerProducer):void");
        }

        /* access modifiers changed from: package-private */
        public InnerProducer<T>[] copyProducers() {
            InnerProducer<T>[] result;
            synchronized (this.producers) {
                Object[] a = this.producers.values();
                int n = a.length;
                result = new InnerProducer[n];
                System.arraycopy(a, 0, result, 0, n);
            }
            return result;
        }

        /* access modifiers changed from: package-private */
        public void makeRequest(long maxTotalRequests, long previousTotalRequests) {
            long ur = this.maxUpstreamRequested;
            Producer p = this.producer;
            long diff = maxTotalRequests - previousTotalRequests;
            if (diff != 0) {
                this.maxChildRequested = maxTotalRequests;
                if (p == null) {
                    long u = ur + diff;
                    if (u < 0) {
                        u = LongCompanionObject.MAX_VALUE;
                    }
                    this.maxUpstreamRequested = u;
                } else if (ur != 0) {
                    this.maxUpstreamRequested = 0;
                    p.request(ur + diff);
                } else {
                    p.request(diff);
                }
            } else if (ur != 0 && p != null) {
                this.maxUpstreamRequested = 0;
                p.request(ur);
            }
        }

        /* access modifiers changed from: package-private */
        public void replay() {
            InnerProducer<T>[] pc = this.producersCache;
            if (this.producersCacheVersion != this.producersVersion) {
                synchronized (this.producers) {
                    pc = this.producersCache;
                    Object[] a = this.producers.values();
                    int n = a.length;
                    if (pc.length != n) {
                        pc = new InnerProducer[n];
                        this.producersCache = pc;
                    }
                    System.arraycopy(a, 0, pc, 0, n);
                    this.producersCacheVersion = this.producersVersion;
                }
            }
            ReplayBuffer<T> b = this.buffer;
            for (InnerProducer<T> rp : pc) {
                if (rp != null) {
                    b.replay(rp);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(ReplaySubscriber<T> parent2, Subscriber<? super T> child2) {
            this.parent = parent2;
            this.child = child2;
        }

        @Override // rx.Producer
        public void request(long n) {
            long r;
            long u;
            if (n >= 0) {
                do {
                    r = get();
                    if (r != Long.MIN_VALUE) {
                        if (r < 0 || n != 0) {
                            u = r + n;
                            if (u < 0) {
                                u = LongCompanionObject.MAX_VALUE;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(r, u));
                addTotalRequested(n);
                this.parent.manageRequests(this);
                this.parent.buffer.replay(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void addTotalRequested(long n) {
            long r;
            long u;
            do {
                r = this.totalRequested.get();
                u = r + n;
                if (u < 0) {
                    u = LongCompanionObject.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(r, u));
        }

        public long produced(long n) {
            long r;
            long u;
            if (n > 0) {
                do {
                    r = get();
                    if (r == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    u = r - n;
                    if (u < 0) {
                        throw new IllegalStateException("More produced (" + n + ") than requested (" + r + ")");
                    }
                } while (!compareAndSet(r, u));
                return u;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests(this);
                this.child = null;
            }
        }

        /* access modifiers changed from: package-private */
        public <U> U index() {
            return (U) this.index;
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        final NotificationLite<T> nl = NotificationLite.instance();
        volatile int size;

        public UnboundedReplayBuffer(int capacityHint) {
            super(capacityHint);
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void next(T value) {
            add(this.nl.next(value));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void error(Throwable e) {
            add(this.nl.error(e));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void complete() {
            add(this.nl.completed());
            this.size++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            if (r13.isUnsubscribed() == false) goto L_0x0014;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            r0 = r12.size;
            r1 = (java.lang.Integer) r13.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
            if (r1 == null) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r3 = r1.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            r3 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r4 = r13.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            if (r4 != null) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            r5 = r13.get();
            r7 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
            if (r7 == r5) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
            if (r3 >= r0) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
            r9 = get(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
            if (r12.nl.accept(r4, r9) == false) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0048, code lost:
            if (r13.isUnsubscribed() == false) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
            r3 = r3 + 1;
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
            rx.exceptions.Exceptions.throwIfFatal(r2);
            r13.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005e, code lost:
            if (r12.nl.isError(r9) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0068, code lost:
            r4.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r2, r12.nl.getValue(r9)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007a, code lost:
            if (r7 == 0) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007c, code lost:
            r13.index = java.lang.Integer.valueOf(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0089, code lost:
            if (r5 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x008b, code lost:
            r13.produced(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x008e, code lost:
            monitor-enter(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0091, code lost:
            if (r13.missed != false) goto L_0x0097;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0093, code lost:
            r13.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
            monitor-exit(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0096, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0097, code lost:
            r13.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0099, code lost:
            monitor-exit(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return;
         */
        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay(rx.internal.operators.OperatorReplay.InnerProducer<T> r13) {
            /*
            // Method dump skipped, instructions count: 162
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.UnboundedReplayBuffer.replay(rx.internal.operators.OperatorReplay$InnerProducer):void");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public Node(Object value2, long index2) {
            this.value = value2;
            this.index = index2;
        }
    }

    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        final NotificationLite<T> nl = NotificationLite.instance();
        int size;
        Node tail;

        public BoundedReplayBuffer() {
            Node n = new Node(null, 0);
            this.tail = n;
            set(n);
        }

        /* access modifiers changed from: package-private */
        public final void addLast(Node n) {
            this.tail.set(n);
            this.tail = n;
            this.size++;
        }

        /* access modifiers changed from: package-private */
        public final void removeFirst() {
            Node next = (Node) ((Node) get()).get();
            if (next != null) {
                this.size--;
                setFirst(next);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        /* access modifiers changed from: package-private */
        public final void removeSome(int n) {
            Node head = (Node) get();
            while (n > 0) {
                head = (Node) head.get();
                n--;
                this.size--;
            }
            setFirst(head);
        }

        /* access modifiers changed from: package-private */
        public final void setFirst(Node n) {
            set(n);
        }

        /* access modifiers changed from: package-private */
        public Node getInitialHead() {
            return (Node) get();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void next(T value) {
            Object o = enterTransform(this.nl.next(value));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(o, j));
            truncate();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void error(Throwable e) {
            Object o = enterTransform(this.nl.error(e));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(o, j));
            truncateFinal();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void complete() {
            Object o = enterTransform(this.nl.completed());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(o, j));
            truncateFinal();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x0014;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            r0 = (rx.internal.operators.OperatorReplay.Node) r11.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
            if (r0 != null) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
            r0 = getInitialHead();
            r11.index = r0;
            r11.addTotalRequested(r0.index);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            r1 = r11.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
            if (r1 != null) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            r2 = r11.get();
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
            if (r4 == r2) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            r6 = (rx.internal.operators.OperatorReplay.Node) r0.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
            if (r6 == null) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
            r7 = leaveTransform(r6.value);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
            if (r10.nl.accept(r1, r7) == false) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
            r11.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0057, code lost:
            r4 = r4 + 1;
            r0 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0062, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0065, code lost:
            r11.index = null;
            rx.exceptions.Exceptions.throwIfFatal(r9);
            r11.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0073, code lost:
            if (r10.nl.isError(r7) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007d, code lost:
            r1.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r9, r10.nl.getValue(r7)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x008f, code lost:
            if (r4 == 0) goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0091, code lost:
            r11.index = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x009a, code lost:
            if (r2 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x009c, code lost:
            r11.produced(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x009f, code lost:
            monitor-enter(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a3, code lost:
            if (r11.missed != false) goto L_0x00a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a5, code lost:
            r11.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a7, code lost:
            monitor-exit(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a8, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a9, code lost:
            r11.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ab, code lost:
            monitor-exit(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            return;
         */
        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void replay(rx.internal.operators.OperatorReplay.InnerProducer<T> r11) {
            /*
            // Method dump skipped, instructions count: 180
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.BoundedReplayBuffer.replay(rx.internal.operators.OperatorReplay$InnerProducer):void");
        }

        /* access modifiers changed from: package-private */
        public Object enterTransform(Object value) {
            return value;
        }

        /* access modifiers changed from: package-private */
        public Object leaveTransform(Object value) {
            return value;
        }

        /* access modifiers changed from: package-private */
        public void truncate() {
        }

        /* access modifiers changed from: package-private */
        public void truncateFinal() {
        }

        /* access modifiers changed from: package-private */
        public final void collect(Collection<? super T> output) {
            Node n = getInitialHead();
            while (true) {
                Node next = (Node) n.get();
                if (next != null) {
                    Object v = leaveTransform(next.value);
                    if (!this.nl.isCompleted(v) && !this.nl.isError(v)) {
                        output.add(this.nl.getValue(v));
                        n = next;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean hasError() {
            return this.tail.value != null && this.nl.isError(leaveTransform(this.tail.value));
        }

        /* access modifiers changed from: package-private */
        public boolean hasCompleted() {
            return this.tail.value != null && this.nl.isCompleted(leaveTransform(this.tail.value));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int limit2) {
            this.limit = limit2;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAgeInMillis;
        final Scheduler scheduler;

        public SizeAndTimeBoundReplayBuffer(int limit2, long maxAgeInMillis2, Scheduler scheduler2) {
            this.scheduler = scheduler2;
            this.limit = limit2;
            this.maxAgeInMillis = maxAgeInMillis2;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object enterTransform(Object value) {
            return new Timestamped(this.scheduler.now(), value);
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object leaveTransform(Object value) {
            return ((Timestamped) value).getValue();
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Node getInitialHead() {
            long timeLimit = this.scheduler.now() - this.maxAgeInMillis;
            Node prev = (Node) get();
            Node next = (Node) prev.get();
            while (next != null && ((Timestamped) next.value).getTimestampMillis() <= timeLimit) {
                prev = next;
                next = (Node) next.get();
            }
            return prev;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            long timeLimit = this.scheduler.now() - this.maxAgeInMillis;
            Node prev = (Node) get();
            Node next = (Node) prev.get();
            int e = 0;
            while (next != null) {
                if (this.size <= this.limit) {
                    if (((Timestamped) next.value).getTimestampMillis() > timeLimit) {
                        break;
                    }
                    e++;
                    this.size--;
                    prev = next;
                    next = (Node) next.get();
                } else {
                    e++;
                    this.size--;
                    prev = next;
                    next = (Node) next.get();
                }
            }
            if (e != 0) {
                setFirst(prev);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncateFinal() {
            long timeLimit = this.scheduler.now() - this.maxAgeInMillis;
            Node prev = (Node) get();
            Node next = (Node) prev.get();
            int e = 0;
            while (next != null && this.size > 1 && ((Timestamped) next.value).getTimestampMillis() <= timeLimit) {
                e++;
                this.size--;
                prev = next;
                next = (Node) next.get();
            }
            if (e != 0) {
                setFirst(prev);
            }
        }
    }
}
