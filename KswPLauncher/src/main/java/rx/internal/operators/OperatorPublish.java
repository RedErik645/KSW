package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.SynchronizedQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observables.ConnectableObservable;
import rx.subscriptions.Subscriptions;

public final class OperatorPublish<T> extends ConnectableObservable<T> {
    final AtomicReference<PublishSubscriber<T>> current;
    final Observable<? extends T> source;

    public static <T> ConnectableObservable<T> create(Observable<? extends T> source2) {
        final AtomicReference<PublishSubscriber<T>> curr = new AtomicReference<>();
        return new OperatorPublish(new Observable.OnSubscribe<T>() {
            /* class rx.internal.operators.OperatorPublish.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(Subscriber<? super T> child) {
                while (true) {
                    PublishSubscriber<T> r = (PublishSubscriber) curr.get();
                    if (r == null || r.isUnsubscribed()) {
                        PublishSubscriber<T> u = new PublishSubscriber<>(curr);
                        u.init();
                        if (!curr.compareAndSet(r, u)) {
                            continue;
                        } else {
                            r = u;
                        }
                    }
                    InnerProducer<T> inner = new InnerProducer<>(r, child);
                    if (r.add((InnerProducer) inner)) {
                        child.add(inner);
                        child.setProducer(inner);
                        return;
                    }
                }
            }
        }, source2, curr);
    }

    public static <T, R> Observable<R> create(Observable<? extends T> source2, Func1<? super Observable<T>, ? extends Observable<R>> selector) {
        return create(source2, selector, false);
    }

    public static <T, R> Observable<R> create(final Observable<? extends T> source2, final Func1<? super Observable<T>, ? extends Observable<R>> selector, final boolean delayError) {
        return create(new Observable.OnSubscribe<R>() {
            /* class rx.internal.operators.OperatorPublish.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: rx.functions.Func1 */
            /* JADX WARN: Multi-variable type inference failed */
            public void call(final Subscriber<? super R> child) {
                final OnSubscribePublishMulticast<T> op = new OnSubscribePublishMulticast<>(RxRingBuffer.SIZE, delayError);
                AnonymousClass1 r1 = new Subscriber<R>() {
                    /* class rx.internal.operators.OperatorPublish.AnonymousClass2.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onNext(R t) {
                        child.onNext(t);
                    }

                    @Override // rx.Observer
                    public void onError(Throwable e) {
                        op.unsubscribe();
                        child.onError(e);
                    }

                    @Override // rx.Observer
                    public void onCompleted() {
                        op.unsubscribe();
                        child.onCompleted();
                    }

                    @Override // rx.Subscriber
                    public void setProducer(Producer p) {
                        child.setProducer(p);
                    }
                };
                child.add(op);
                child.add(r1);
                ((Observable) selector.call(Observable.create(op))).unsafeSubscribe(r1);
                source2.unsafeSubscribe(op.subscriber());
            }
        });
    }

    private OperatorPublish(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> source2, AtomicReference<PublishSubscriber<T>> current2) {
        super(onSubscribe);
        this.source = source2;
        this.current = current2;
    }

    @Override // rx.observables.ConnectableObservable
    public void connect(Action1<? super Subscription> connection) {
        PublishSubscriber<T> ps;
        while (true) {
            ps = this.current.get();
            if (ps != null && !ps.isUnsubscribed()) {
                break;
            }
            PublishSubscriber<T> u = new PublishSubscriber<>(this.current);
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
    public static final class PublishSubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final AtomicReference<PublishSubscriber<T>> current;
        boolean emitting;
        boolean missed;
        final NotificationLite<T> nl;
        final AtomicReference<InnerProducer[]> producers;
        final Queue<Object> queue;
        final AtomicBoolean shouldConnect;
        volatile Object terminalEvent;

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> current2) {
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscArrayQueue<>(RxRingBuffer.SIZE) : new SynchronizedQueue<>(RxRingBuffer.SIZE);
            this.nl = NotificationLite.instance();
            this.producers = new AtomicReference<>(EMPTY);
            this.current = current2;
            this.shouldConnect = new AtomicBoolean();
        }

        /* access modifiers changed from: package-private */
        public void init() {
            add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorPublish.PublishSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    PublishSubscriber.this.producers.getAndSet(PublishSubscriber.TERMINATED);
                    PublishSubscriber.this.current.compareAndSet(PublishSubscriber.this, null);
                }
            }));
        }

        @Override // rx.Subscriber
        public void onStart() {
            request((long) RxRingBuffer.SIZE);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.queue.offer(this.nl.next(t))) {
                onError(new MissingBackpressureException());
            } else {
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (this.terminalEvent == null) {
                this.terminalEvent = this.nl.error(e);
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.terminalEvent == null) {
                this.terminalEvent = this.nl.completed();
                dispatch();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean add(InnerProducer<T> producer) {
            InnerProducer[] c;
            InnerProducer[] u;
            if (producer != null) {
                do {
                    c = this.producers.get();
                    if (c == TERMINATED) {
                        return false;
                    }
                    int len = c.length;
                    u = new InnerProducer[(len + 1)];
                    System.arraycopy(c, 0, u, 0, len);
                    u[len] = producer;
                } while (!this.producers.compareAndSet(c, u));
                return true;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: package-private */
        public void remove(InnerProducer<T> producer) {
            InnerProducer[] c;
            InnerProducer[] u;
            do {
                c = this.producers.get();
                if (c != EMPTY && c != TERMINATED) {
                    int j = -1;
                    int len = c.length;
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
                            InnerProducer[] u2 = new InnerProducer[(len - 1)];
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
            } while (!this.producers.compareAndSet(c, u));
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(Object term, boolean empty) {
            if (term == null) {
                return false;
            }
            if (!this.nl.isCompleted(term)) {
                Throwable t = this.nl.getError(term);
                this.current.compareAndSet(this, null);
                try {
                    for (InnerProducer<?> ip : this.producers.getAndSet(TERMINATED)) {
                        ip.child.onError(t);
                    }
                    return true;
                } finally {
                    unsubscribe();
                }
            } else if (!empty) {
                return false;
            } else {
                this.current.compareAndSet(this, null);
                try {
                    for (InnerProducer<?> ip2 : this.producers.getAndSet(TERMINATED)) {
                        ip2.child.onCompleted();
                    }
                    return true;
                } finally {
                    unsubscribe();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x014d, code lost:
            r16 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x014f, code lost:
            monitor-enter(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x0152, code lost:
            if (r27.missed != false) goto L_0x0168;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0154, code lost:
            r27.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
            monitor-exit(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x0159, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x015b, code lost:
            monitor-enter(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
            r27.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x015f, code lost:
            monitor-exit(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0165, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x0168, code lost:
            r27.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x016b, code lost:
            monitor-exit(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x016c, code lost:
            r4 = r16;
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x0172, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
            monitor-exit(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x0176, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r0 = r27.terminalEvent;
            r6 = r27.queue.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x0177, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x0179, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x017b, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x017c, code lost:
            r4 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x017f, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x0182, code lost:
            if (r4 == null) goto L_0x0184;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0184, code lost:
            monitor-enter(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (checkTerminated(r0, r6) == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
            r27.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x018d, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            monitor-enter(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r27.emitting = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
            monitor-exit(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x002f, code lost:
            if (r6 != false) goto L_0x014d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r0 = r27.producers.get();
            r0 = r0.length;
            r12 = r0.length;
            r9 = 0;
            r0 = 0;
            r13 = Long.MAX_VALUE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
            if (r0 >= r12) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r17 = r0[r0].get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
            if (r17 < 0) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
            r13 = java.lang.Math.min(r13, r17);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0067, code lost:
            if (r17 != Long.MIN_VALUE) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0069, code lost:
            r9 = r9 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x006b, code lost:
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0072, code lost:
            if (r0 != r9) goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0074, code lost:
            r0 = r27.terminalEvent;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007e, code lost:
            if (r27.queue.poll() != null) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0080, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0082, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0087, code lost:
            if (checkTerminated(r0, r0) == false) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008a, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x008c, code lost:
            monitor-enter(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            r27.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0090, code lost:
            monitor-exit(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0096, code lost:
            request(1);
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x009d, code lost:
            r5 = 0;
            r0 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a6, code lost:
            if (((long) r5) >= r13) goto L_0x0135;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a8, code lost:
            r10 = r27.terminalEvent;
            r0 = r27.queue.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b1, code lost:
            if (r0 != null) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b3, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b5, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00b6, code lost:
            r6 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00bb, code lost:
            if (checkTerminated(r10, r6) == false) goto L_0x00ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00be, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c0, code lost:
            monitor-enter(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            r27.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00c4, code lost:
            monitor-exit(r27);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ca, code lost:
            if (r6 == false) goto L_0x00d1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00cc, code lost:
            r16 = r4;
            r0 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d1, code lost:
            r0 = r27.nl.getValue(r0);
            r2 = r0;
            r3 = r2.length;
            r15 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x00e0, code lost:
            if (r15 >= r3) goto L_0x0125;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x00e2, code lost:
            r16 = r2[r15];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x00ee, code lost:
            if (r16.get() <= 0) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x00f0, code lost:
            r19 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            r16.child.onNext(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x00f9, code lost:
            r23 = r3;
            r16 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            r16.produced(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0104, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0105, code lost:
            r23 = r3;
            r16 = r4;
            r16.unsubscribe();
            rx.exceptions.Exceptions.throwOrReport(r0, r16.child, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0114, code lost:
            r19 = r2;
            r23 = r3;
            r16 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0125, code lost:
            r5 = r5 + 1;
            r0 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0135, code lost:
            r16 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0137, code lost:
            if (r5 <= 0) goto L_0x013d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0139, code lost:
            request((long) r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0141, code lost:
            if (r13 == 0) goto L_0x014b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0143, code lost:
            if (r6 != false) goto L_0x014b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0145, code lost:
            r4 = r16;
            r3 = false;
         */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0184  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dispatch() {
            /*
            // Method dump skipped, instructions count: 401
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorPublish.PublishSubscriber.dispatch():void");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        final PublishSubscriber<T> parent;

        public InnerProducer(PublishSubscriber<T> parent2, Subscriber<? super T> child2) {
            this.parent = parent2;
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
                        if (r >= 0 && n == 0) {
                            return;
                        }
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
                this.parent.dispatch();
            }
        }

        public long produced(long n) {
            long r;
            long u;
            if (n > 0) {
                do {
                    r = get();
                    if (r == NOT_REQUESTED) {
                        throw new IllegalStateException("Produced without request");
                    } else if (r == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    } else {
                        u = r - n;
                        if (u < 0) {
                            throw new IllegalStateException("More produced (" + n + ") than requested (" + r + ")");
                        }
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
                this.parent.dispatch();
            }
        }
    }
}
