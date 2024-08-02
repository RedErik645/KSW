package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, ResettableConnectable {
    static final Callable DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    final Callable<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerSubscription<T> innerSubscription);
    }

    public static <U, R> Flowable<R> multicastSelector(Callable<? extends ConnectableFlowable<U>> connectableFactory, Function<? super Flowable<U>, ? extends Publisher<R>> selector) {
        return new MulticastFlowable(connectableFactory, selector);
    }

    public static <T> ConnectableFlowable<T> observeOn(ConnectableFlowable<T> cf, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new ConnectableFlowableReplay(cf, cf.observeOn(scheduler)));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> source2) {
        return create(source2, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source2, int bufferSize) {
        if (bufferSize == Integer.MAX_VALUE) {
            return createFrom(source2);
        }
        return create(source2, new ReplayBufferTask(bufferSize));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source2, long maxAge, TimeUnit unit, Scheduler scheduler) {
        return create(source2, maxAge, unit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> source2, long maxAge, TimeUnit unit, Scheduler scheduler, int bufferSize) {
        return create(source2, new ScheduledReplayBufferTask(bufferSize, maxAge, unit, scheduler));
    }

    static <T> ConnectableFlowable<T> create(Flowable<T> source2, Callable<? extends ReplayBuffer<T>> bufferFactory2) {
        AtomicReference<ReplaySubscriber<T>> curr = new AtomicReference<>();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowableReplay(new ReplayPublisher<>(curr, bufferFactory2), source2, curr, bufferFactory2));
    }

    private FlowableReplay(Publisher<T> onSubscribe2, Flowable<T> source2, AtomicReference<ReplaySubscriber<T>> current2, Callable<? extends ReplayBuffer<T>> bufferFactory2) {
        this.onSubscribe = onSubscribe2;
        this.source = source2;
        this.current = current2;
        this.bufferFactory = bufferFactory2;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        this.onSubscribe.subscribe(s);
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(Disposable connectionObject) {
        this.current.compareAndSet((ReplaySubscriber) connectionObject, null);
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> connection) {
        ReplaySubscriber<T> ps;
        while (true) {
            ps = this.current.get();
            if (ps != null && !ps.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> u = new ReplaySubscriber<>((ReplayBuffer) this.bufferFactory.call());
                if (this.current.compareAndSet(ps, u)) {
                    ps = u;
                    break;
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                throw ExceptionHelper.wrapOrThrow(ex);
            }
        }
        boolean doConnect = !ps.shouldConnect.get() && ps.shouldConnect.compareAndSet(false, true);
        try {
            connection.accept(ps);
            if (doConnect) {
                this.source.subscribe((FlowableSubscriber) ps);
            }
        } catch (Throwable ex2) {
            if (doConnect) {
                ps.shouldConnect.compareAndSet(true, false);
            }
            Exceptions.throwIfFatal(ex2);
            throw ExceptionHelper.wrapOrThrow(ex2);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> buffer;
        boolean done;
        final AtomicInteger management = new AtomicInteger();
        long maxChildRequested;
        long maxUpstreamRequested;
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

        ReplaySubscriber(ReplayBuffer<T> buffer2) {
            this.buffer = buffer2;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.subscribers.set(TERMINATED);
            SubscriptionHelper.cancel(this);
        }

        /* access modifiers changed from: package-private */
        public boolean add(InnerSubscription<T> producer) {
            InnerSubscription<T>[] c;
            InnerSubscription<T>[] u;
            if (producer != null) {
                do {
                    c = this.subscribers.get();
                    if (c == TERMINATED) {
                        return false;
                    }
                    int len = c.length;
                    u = new InnerSubscription[(len + 1)];
                    System.arraycopy(c, 0, u, 0, len);
                    u[len] = producer;
                } while (!this.subscribers.compareAndSet(c, u));
                return true;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: package-private */
        public void remove(InnerSubscription<T> p) {
            InnerSubscription<T>[] c;
            InnerSubscription<T>[] u;
            do {
                c = this.subscribers.get();
                int len = c.length;
                if (len != 0) {
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= len) {
                            break;
                        } else if (c[i].equals(p)) {
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
                            InnerSubscription<T>[] u2 = new InnerSubscription[(len - 1)];
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
            } while (!this.subscribers.compareAndSet(c, u));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription p) {
            if (SubscriptionHelper.setOnce(this, p)) {
                manageRequests();
                for (InnerSubscription<T> rp : this.subscribers.get()) {
                    this.buffer.replay(rp);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                for (InnerSubscription<T> rp : this.subscribers.get()) {
                    this.buffer.replay(rp);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable e) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(e);
                for (InnerSubscription<T> rp : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(rp);
                }
                return;
            }
            RxJavaPlugins.onError(e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                for (InnerSubscription<T> rp : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(rp);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void manageRequests() {
            if (this.management.getAndIncrement() == 0) {
                int missed = 1;
                while (!isDisposed()) {
                    InnerSubscription<T>[] a = this.subscribers.get();
                    long ri = this.maxChildRequested;
                    long maxTotalRequests = ri;
                    for (InnerSubscription<T> rp : a) {
                        maxTotalRequests = Math.max(maxTotalRequests, rp.totalRequested.get());
                    }
                    long ur = this.maxUpstreamRequested;
                    Subscription p = (Subscription) get();
                    long diff = maxTotalRequests - ri;
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
                    } else if (!(ur == 0 || p == null)) {
                        this.maxUpstreamRequested = 0;
                        p.request(ur);
                    }
                    missed = this.management.addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        InnerSubscription(ReplaySubscriber<T> parent2, Subscriber<? super T> child2) {
            this.parent = parent2;
            this.child = child2;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n) && BackpressureHelper.addCancel(this, n) != Long.MIN_VALUE) {
                BackpressureHelper.add(this.totalRequested, n);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }

        public long produced(long n) {
            return BackpressureHelper.producedCancel(this, n);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
                this.index = null;
            }
        }

        /* access modifiers changed from: package-private */
        public <U> U index() {
            return (U) this.index;
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int capacityHint) {
            super(capacityHint);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T value) {
            add(NotificationLite.next(value));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(Throwable e) {
            add(NotificationLite.error(e));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r15.isDisposed() == false) goto L_0x0016;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            r1 = r14.size;
            r2 = (java.lang.Integer) r15.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            if (r2 == null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
            r4 = r2.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            r5 = r15.get();
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            if (r5 == 0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
            if (r4 >= r1) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
            r11 = get(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
            if (io.reactivex.internal.util.NotificationLite.accept(r11, r0) == false) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
            if (r15.isDisposed() == false) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0048, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0049, code lost:
            r4 = r4 + 1;
            r5 = r5 - 1;
            r9 = r9 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0051, code lost:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r3);
            r15.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
            if (io.reactivex.internal.util.NotificationLite.isError(r11) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
            r0.onError(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0069, code lost:
            if (r9 == 0) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x006b, code lost:
            r15.index = java.lang.Integer.valueOf(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
            if (r5 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007a, code lost:
            r15.produced(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007d, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0080, code lost:
            if (r15.missed != false) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0082, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0084, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0085, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0086, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0088, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
            r0 = r15.child;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r15) {
            /*
            // Method dump skipped, instructions count: 144
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.UnboundedReplayBuffer.replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object value2, long index2) {
            this.value = value2;
            this.index = index2;
        }
    }

    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        BoundedReplayBuffer() {
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
            Node head2 = (Node) get();
            if (head2.get() == null) {
                this.tail = head2;
            }
        }

        /* access modifiers changed from: package-private */
        public final void setFirst(Node n) {
            set(n);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T value) {
            Object o = enterTransform(NotificationLite.next(value));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(o, j));
            truncate();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable e) {
            Object o = enterTransform(NotificationLite.error(e));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(o, j));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Object o = enterTransform(NotificationLite.complete());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(o, j));
            truncateFinal();
        }

        /* access modifiers changed from: package-private */
        public final void trimHead() {
            Node head = (Node) get();
            if (head.value != null) {
                Node n = new Node(null, 0);
                n.lazySet(head.get());
                set(n);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
            if (r15.isDisposed() == false) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
            r15.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
            r3 = r15.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            if (r3 != kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
            r6 = 0;
            r8 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r15.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
            if (r8 != null) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            r8 = getHead();
            r15.index = r8;
            io.reactivex.internal.util.BackpressureHelper.add(r15.totalRequested, r8.index);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
            if (r3 == 0) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
            r11 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r8.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
            if (r11 == null) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
            r9 = leaveTransform(r11.value);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0059, code lost:
            if (io.reactivex.internal.util.NotificationLite.accept(r9, r15.child) == false) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
            r15.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005e, code lost:
            r6 = r6 + 1;
            r3 = r3 - 1;
            r8 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0068, code lost:
            if (r15.isDisposed() == false) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
            r15.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x006e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x006f, code lost:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r1);
            r15.index = null;
            r15.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x007b, code lost:
            if (io.reactivex.internal.util.NotificationLite.isError(r9) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0083, code lost:
            r15.child.onError(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x008b, code lost:
            if (r6 == 0) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x008d, code lost:
            r15.index = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x008f, code lost:
            if (r0 != false) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0091, code lost:
            r15.produced(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0094, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0097, code lost:
            if (r15.missed != false) goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0099, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x009b, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009d, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x009f, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void replay(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r15) {
            /*
            // Method dump skipped, instructions count: 168
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer.replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
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
            trimHead();
        }

        /* access modifiers changed from: package-private */
        public final void collect(Collection<? super T> output) {
            Node n = getHead();
            while (true) {
                Node next = (Node) n.get();
                if (next != null) {
                    Object v = leaveTransform(next.value);
                    if (!NotificationLite.isComplete(v) && !NotificationLite.isError(v)) {
                        output.add((Object) NotificationLite.getValue(v));
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
            return this.tail.value != null && NotificationLite.isError(leaveTransform(this.tail.value));
        }

        /* access modifiers changed from: package-private */
        public boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.isComplete(leaveTransform(this.tail.value));
        }

        /* access modifiers changed from: package-private */
        public Node getHead() {
            return (Node) get();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int limit2) {
            this.limit = limit2;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
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
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int limit2, long maxAge2, TimeUnit unit2, Scheduler scheduler2) {
            this.scheduler = scheduler2;
            this.limit = limit2;
            this.maxAge = maxAge2;
            this.unit = unit2;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Object enterTransform(Object value) {
            return new Timed(value, this.scheduler.now(this.unit), this.unit);
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Object leaveTransform(Object value) {
            return ((Timed) value).value();
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void truncate() {
            long timeLimit = this.scheduler.now(this.unit) - this.maxAge;
            Node prev = (Node) get();
            Node next = (Node) prev.get();
            int e = 0;
            while (next != null) {
                if (this.size <= this.limit || this.size <= 1) {
                    if (((Timed) next.value).time() > timeLimit) {
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
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void truncateFinal() {
            long timeLimit = this.scheduler.now(this.unit) - this.maxAge;
            Node prev = (Node) get();
            Node next = (Node) prev.get();
            int e = 0;
            while (next != null && this.size > 1 && ((Timed) next.value).time() <= timeLimit) {
                e++;
                this.size--;
                prev = next;
                next = (Node) next.get();
            }
            if (e != 0) {
                setFirst(prev);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Node getHead() {
            long timeLimit = this.scheduler.now(this.unit) - this.maxAge;
            Node prev = (Node) get();
            for (Node next = (Node) prev.get(); next != null; next = (Node) next.get()) {
                Timed<?> v = (Timed) next.value;
                if (NotificationLite.isComplete(v.value()) || NotificationLite.isError(v.value()) || v.time() > timeLimit) {
                    break;
                }
                prev = next;
            }
            return prev;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Callable<? extends ConnectableFlowable<U>> connectableFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        MulticastFlowable(Callable<? extends ConnectableFlowable<U>> connectableFactory2, Function<? super Flowable<U>, ? extends Publisher<R>> selector2) {
            this.connectableFactory = connectableFactory2;
            this.selector = selector2;
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super R> child) {
            try {
                ConnectableFlowable<U> cf = (ConnectableFlowable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned null");
                try {
                    Publisher<R> observable = (Publisher) ObjectHelper.requireNonNull(this.selector.apply(cf), "The selector returned a null Publisher");
                    SubscriberResourceWrapper<R> srw = new SubscriberResourceWrapper<>(child);
                    observable.subscribe(srw);
                    cf.connect(new DisposableConsumer(srw));
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    EmptySubscription.error(e, child);
                }
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                EmptySubscription.error(e2, child);
            }
        }

        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;

            DisposableConsumer(SubscriberResourceWrapper<R> srw2) {
                this.srw = srw2;
            }

            public void accept(Disposable r) {
                this.srw.setResource(r);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {
        private final ConnectableFlowable<T> cf;
        private final Flowable<T> flowable;

        ConnectableFlowableReplay(ConnectableFlowable<T> cf2, Flowable<T> flowable2) {
            this.cf = cf2;
            this.flowable = flowable2;
        }

        @Override // io.reactivex.flowables.ConnectableFlowable
        public void connect(Consumer<? super Disposable> connection) {
            this.cf.connect(connection);
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super T> s) {
            this.flowable.subscribe(s);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;

        ReplayBufferTask(int bufferSize2) {
            this.bufferSize = bufferSize2;
        }

        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        ScheduledReplayBufferTask(int bufferSize2, long maxAge2, TimeUnit unit2, Scheduler scheduler2) {
            this.bufferSize = bufferSize2;
            this.maxAge = maxAge2;
            this.unit = unit2;
            this.scheduler = scheduler2;
        }

        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ReplayPublisher<T> implements Publisher<T> {
        private final Callable<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> curr2, Callable<? extends ReplayBuffer<T>> bufferFactory2) {
            this.curr = curr2;
            this.bufferFactory = bufferFactory2;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> child) {
            ReplaySubscriber<T> r;
            while (true) {
                r = this.curr.get();
                if (r != null) {
                    break;
                }
                try {
                    ReplaySubscriber<T> u = new ReplaySubscriber<>((ReplayBuffer) this.bufferFactory.call());
                    if (this.curr.compareAndSet(null, u)) {
                        r = u;
                        break;
                    }
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    EmptySubscription.error(ex, child);
                    return;
                }
            }
            InnerSubscription<T> inner = new InnerSubscription<>(r, child);
            child.onSubscribe(inner);
            r.add(inner);
            if (inner.isDisposed()) {
                r.remove(inner);
                return;
            }
            r.manageRequests();
            r.buffer.replay(inner);
        }
    }

    static final class DefaultUnboundedFactory implements Callable<Object> {
        DefaultUnboundedFactory() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }
}
