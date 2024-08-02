package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

public final class ReplaySubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    final ReplayState<T> state;

    /* access modifiers changed from: package-private */
    public interface ReplayBuffer<T> {
        void complete();

        void drain(ReplayProducer<T> replayProducer);

        Throwable error();

        void error(Throwable th);

        boolean isComplete();

        boolean isEmpty();

        T last();

        void next(T t);

        int size();

        T[] toArray(T[] tArr);
    }

    public static <T> ReplaySubject<T> create() {
        return create(16);
    }

    public static <T> ReplaySubject<T> create(int capacity) {
        if (capacity > 0) {
            return new ReplaySubject<>(new ReplayState<>(new ReplayUnboundedBuffer<>(capacity)));
        }
        throw new IllegalArgumentException("capacity > 0 required but it was " + capacity);
    }

    static <T> ReplaySubject<T> createUnbounded() {
        return new ReplaySubject<>(new ReplayState<>(new ReplaySizeBoundBuffer<>(Integer.MAX_VALUE)));
    }

    static <T> ReplaySubject<T> createUnboundedTime() {
        return new ReplaySubject<>(new ReplayState<>(new ReplaySizeAndTimeBoundBuffer<>(Integer.MAX_VALUE, LongCompanionObject.MAX_VALUE, Schedulers.immediate())));
    }

    public static <T> ReplaySubject<T> createWithSize(int size) {
        return new ReplaySubject<>(new ReplayState<>(new ReplaySizeBoundBuffer<>(size)));
    }

    public static <T> ReplaySubject<T> createWithTime(long time, TimeUnit unit, Scheduler scheduler) {
        return createWithTimeAndSize(time, unit, Integer.MAX_VALUE, scheduler);
    }

    public static <T> ReplaySubject<T> createWithTimeAndSize(long time, TimeUnit unit, int size, Scheduler scheduler) {
        return new ReplaySubject<>(new ReplayState<>(new ReplaySizeAndTimeBoundBuffer<>(size, unit.toMillis(time), scheduler)));
    }

    ReplaySubject(ReplayState<T> state2) {
        super(state2);
        this.state = state2;
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.state.onNext(t);
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        this.state.onError(e);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.state.onCompleted();
    }

    /* access modifiers changed from: package-private */
    public int subscriberCount() {
        return ((ReplayProducer[]) this.state.get()).length;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return ((ReplayProducer[]) this.state.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.state.isTerminated() && this.state.buffer.error() != null;
    }

    public boolean hasCompleted() {
        return this.state.isTerminated() && this.state.buffer.error() == null;
    }

    public Throwable getThrowable() {
        if (this.state.isTerminated()) {
            return this.state.buffer.error();
        }
        return null;
    }

    public int size() {
        return this.state.buffer.size();
    }

    public boolean hasAnyValue() {
        return !this.state.buffer.isEmpty();
    }

    public boolean hasValue() {
        return hasAnyValue();
    }

    public T[] getValues(T[] a) {
        return this.state.buffer.toArray(a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.subjects.ReplaySubject<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        T[] r = getValues(objArr);
        if (r == objArr) {
            return new Object[0];
        }
        return r;
    }

    public T getValue() {
        return this.state.buffer.last();
    }

    /* access modifiers changed from: package-private */
    public static final class ReplayState<T> extends AtomicReference<ReplayProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
        static final ReplayProducer[] EMPTY = new ReplayProducer[0];
        static final ReplayProducer[] TERMINATED = new ReplayProducer[0];
        private static final long serialVersionUID = 5952362471246910544L;
        final ReplayBuffer<T> buffer;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public ReplayState(ReplayBuffer<T> buffer2) {
            this.buffer = buffer2;
            lazySet(EMPTY);
        }

        public void call(Subscriber<? super T> t) {
            ReplayProducer<T> rp = new ReplayProducer<>(t, this);
            t.add(rp);
            t.setProducer(rp);
            if (!add(rp) || !rp.isUnsubscribed()) {
                this.buffer.drain(rp);
            } else {
                remove(rp);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean add(ReplayProducer<T> rp) {
            ReplayProducer<T>[] a;
            ReplayProducer<T>[] b;
            do {
                a = (ReplayProducer[]) get();
                if (a == TERMINATED) {
                    return false;
                }
                int n = a.length;
                b = new ReplayProducer[(n + 1)];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = rp;
            } while (!compareAndSet(a, b));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void remove(ReplayProducer<T> rp) {
            ReplayProducer<T>[] a;
            ReplayProducer<T>[] b;
            do {
                a = (ReplayProducer[]) get();
                if (a != TERMINATED && a != EMPTY) {
                    int n = a.length;
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= n) {
                            break;
                        } else if (a[i] == rp) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (n == 1) {
                            b = EMPTY;
                        } else {
                            ReplayProducer<T>[] b2 = new ReplayProducer[(n - 1)];
                            System.arraycopy(a, 0, b2, 0, j);
                            System.arraycopy(a, j + 1, b2, j, (n - j) - 1);
                            b = b2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(a, b));
        }

        @Override // rx.Observer
        public void onNext(T t) {
            ReplayBuffer<T> b = this.buffer;
            b.next(t);
            for (ReplayProducer<T> rp : (ReplayProducer[]) get()) {
                b.drain(rp);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            ReplayBuffer<T> b = this.buffer;
            b.error(e);
            List<Throwable> errors = null;
            for (ReplayProducer<T> rp : (ReplayProducer[]) getAndSet(TERMINATED)) {
                try {
                    b.drain(rp);
                } catch (Throwable ex) {
                    if (errors == null) {
                        errors = new ArrayList<>();
                    }
                    errors.add(ex);
                }
            }
            Exceptions.throwIfAny(errors);
        }

        @Override // rx.Observer
        public void onCompleted() {
            ReplayBuffer<T> b = this.buffer;
            b.complete();
            for (ReplayProducer<T> rp : (ReplayProducer[]) getAndSet(TERMINATED)) {
                b.drain(rp);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isTerminated() {
            return get() == TERMINATED;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ReplayUnboundedBuffer<T> implements ReplayBuffer<T> {
        final int capacity;
        volatile boolean done;
        Throwable error;
        final Object[] head;
        volatile int size;
        Object[] tail;
        int tailIndex;

        public ReplayUnboundedBuffer(int capacity2) {
            this.capacity = capacity2;
            Object[] objArr = new Object[(capacity2 + 1)];
            this.head = objArr;
            this.tail = objArr;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t) {
            if (!this.done) {
                int i = this.tailIndex;
                Object[] a = this.tail;
                if (i == a.length - 1) {
                    Object[] b = new Object[a.length];
                    b[0] = t;
                    this.tailIndex = 1;
                    a[i] = b;
                    this.tail = b;
                } else {
                    a[i] = t;
                    this.tailIndex = i + 1;
                }
                this.size++;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable e) {
            if (this.done) {
                RxJavaHooks.onError(e);
                return;
            }
            this.error = e;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> rp) {
            if (rp.getAndIncrement() == 0) {
                int missed = 1;
                Subscriber<? super T> a = rp.actual;
                int n = this.capacity;
                do {
                    long r = rp.requested.get();
                    long e = 0;
                    Object[] node = (Object[]) rp.node;
                    if (node == null) {
                        node = this.head;
                    }
                    int tailIndex2 = rp.tailIndex;
                    int index = rp.index;
                    while (e != r) {
                        if (a.isUnsubscribed()) {
                            rp.node = null;
                            return;
                        }
                        boolean d = this.done;
                        boolean empty = index == this.size;
                        if (d && empty) {
                            rp.node = null;
                            Throwable ex = this.error;
                            if (ex != null) {
                                a.onError(ex);
                                return;
                            } else {
                                a.onCompleted();
                                return;
                            }
                        } else if (empty) {
                            break;
                        } else {
                            if (tailIndex2 == n) {
                                node = (Object[]) node[tailIndex2];
                                tailIndex2 = 0;
                            }
                            a.onNext(node[tailIndex2]);
                            e++;
                            tailIndex2++;
                            index++;
                        }
                    }
                    if (e == r) {
                        if (a.isUnsubscribed()) {
                            rp.node = null;
                            return;
                        }
                        boolean d2 = this.done;
                        boolean empty2 = index == this.size;
                        if (d2 && empty2) {
                            rp.node = null;
                            Throwable ex2 = this.error;
                            if (ex2 != null) {
                                a.onError(ex2);
                                return;
                            } else {
                                a.onCompleted();
                                return;
                            }
                        }
                    }
                    if (!(e == 0 || r == LongCompanionObject.MAX_VALUE)) {
                        BackpressureUtils.produced(rp.requested, e);
                    }
                    rp.index = index;
                    rp.tailIndex = tailIndex2;
                    rp.node = node;
                    missed = rp.addAndGet(-missed);
                } while (missed != 0);
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            int s = this.size;
            if (s == 0) {
                return null;
            }
            Object[] h = this.head;
            int n = this.capacity;
            while (s >= n) {
                h = (Object[]) h[n];
                s -= n;
            }
            return (T) h[s - 1];
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] a) {
            int s = this.size;
            if (a.length < s) {
                a = (T[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), s));
            }
            Object[] h = this.head;
            int n = this.capacity;
            int j = 0;
            while (j + n < s) {
                System.arraycopy(h, 0, a, j, n);
                j += n;
                h = (Object[]) h[n];
            }
            System.arraycopy(h, 0, a, j, s - j);
            if (a.length > s) {
                a[s] = null;
            }
            return a;
        }
    }

    static final class ReplaySizeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int limit;
        int size;
        Node<T> tail;

        public ReplaySizeBoundBuffer(int limit2) {
            this.limit = limit2;
            Node<T> n = new Node<>(null);
            this.tail = n;
            this.head = n;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T value) {
            Node<T> n = new Node<>(value);
            this.tail.set(n);
            this.tail = n;
            int s = this.size;
            if (s == this.limit) {
                this.head = (Node) this.head.get();
            } else {
                this.size = s + 1;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable ex) {
            this.error = ex;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> rp) {
            boolean empty;
            if (rp.getAndIncrement() == 0) {
                Subscriber<? super T> a = rp.actual;
                int missed = 1;
                do {
                    long r = rp.requested.get();
                    long e = 0;
                    Node<T> node = (Node) rp.node;
                    if (node == null) {
                        node = this.head;
                    }
                    while (true) {
                        empty = true;
                        if (e == r) {
                            break;
                        } else if (a.isUnsubscribed()) {
                            rp.node = null;
                            return;
                        } else {
                            boolean d = this.done;
                            Node<T> next = (Node) node.get();
                            boolean empty2 = next == null;
                            if (d && empty2) {
                                rp.node = null;
                                Throwable ex = this.error;
                                if (ex != null) {
                                    a.onError(ex);
                                    return;
                                } else {
                                    a.onCompleted();
                                    return;
                                }
                            } else if (empty2) {
                                break;
                            } else {
                                a.onNext(next.value);
                                e++;
                                node = next;
                            }
                        }
                    }
                    if (e == r) {
                        if (a.isUnsubscribed()) {
                            rp.node = null;
                            return;
                        }
                        boolean d2 = this.done;
                        if (node.get() != null) {
                            empty = false;
                        }
                        if (d2 && empty) {
                            rp.node = null;
                            Throwable ex2 = this.error;
                            if (ex2 != null) {
                                a.onError(ex2);
                                return;
                            } else {
                                a.onCompleted();
                                return;
                            }
                        }
                    }
                    if (!(e == 0 || r == LongCompanionObject.MAX_VALUE)) {
                        BackpressureUtils.produced(rp.requested, e);
                    }
                    rp.node = node;
                    missed = rp.addAndGet(-missed);
                } while (missed != 0);
            }
        }

        static final class Node<T> extends AtomicReference<Node<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final T value;

            public Node(T value2) {
                this.value = value2;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            Node<T> h = this.head;
            while (true) {
                Node<T> n = (Node) h.get();
                if (n == null) {
                    return h.value;
                }
                h = n;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int s = 0;
            Node<T> n = (Node) this.head.get();
            while (n != null && s != Integer.MAX_VALUE) {
                n = (Node) n.get();
                s++;
            }
            return s;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return this.head.get() == null;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] a) {
            List<T> list = new ArrayList<>();
            for (Node<T> n = (Node) this.head.get(); n != null; n = (Node) n.get()) {
                list.add(n.value);
            }
            return (T[]) list.toArray(a);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ReplaySizeAndTimeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final int limit;
        final long maxAgeMillis;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;

        public ReplaySizeAndTimeBoundBuffer(int limit2, long maxAgeMillis2, Scheduler scheduler2) {
            this.limit = limit2;
            TimedNode<T> n = new TimedNode<>(null, 0);
            this.tail = n;
            this.head = n;
            this.maxAgeMillis = maxAgeMillis2;
            this.scheduler = scheduler2;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T value) {
            long now = this.scheduler.now();
            TimedNode<T> n = new TimedNode<>(value, now);
            this.tail.set(n);
            this.tail = n;
            long now2 = now - this.maxAgeMillis;
            int s = this.size;
            TimedNode<T> h0 = this.head;
            TimedNode<T> h = h0;
            if (s == this.limit) {
                h = (TimedNode) h.get();
            } else {
                s++;
            }
            while (true) {
                TimedNode<T> n2 = (TimedNode) h.get();
                if (n2 == null || n2.timestamp > now2) {
                    this.size = s;
                } else {
                    h = n2;
                    s--;
                }
            }
            this.size = s;
            if (h != h0) {
                this.head = h;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable ex) {
            evictFinal();
            this.error = ex;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            evictFinal();
            this.done = true;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0020  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void evictFinal() {
            /*
                r8 = this;
                rx.Scheduler r0 = r8.scheduler
                long r0 = r0.now()
                long r2 = r8.maxAgeMillis
                long r0 = r0 - r2
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode<T> r2 = r8.head
                r3 = r2
            L_0x000c:
                java.lang.Object r4 = r3.get()
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode r4 = (rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.TimedNode) r4
                r5 = r4
                if (r4 == 0) goto L_0x001e
                long r6 = r5.timestamp
                int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r4 <= 0) goto L_0x001c
                goto L_0x001e
            L_0x001c:
                r3 = r5
                goto L_0x000c
            L_0x001e:
                if (r2 == r3) goto L_0x0022
                r8.head = r3
            L_0x0022:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.evictFinal():void");
        }

        /* access modifiers changed from: package-private */
        public TimedNode<T> latestHead() {
            long now = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> h = this.head;
            while (true) {
                TimedNode<T> n = (TimedNode) h.get();
                if (n == null || n.timestamp > now) {
                    return h;
                }
                h = n;
            }
            return h;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> rp) {
            boolean empty;
            if (rp.getAndIncrement() == 0) {
                Subscriber<? super T> a = rp.actual;
                int missed = 1;
                do {
                    long r = rp.requested.get();
                    long e = 0;
                    TimedNode<T> node = (TimedNode) rp.node;
                    if (node == null) {
                        node = latestHead();
                    }
                    while (true) {
                        empty = true;
                        if (e == r) {
                            break;
                        } else if (a.isUnsubscribed()) {
                            rp.node = null;
                            return;
                        } else {
                            boolean d = this.done;
                            TimedNode<T> next = (TimedNode) node.get();
                            boolean empty2 = next == null;
                            if (d && empty2) {
                                rp.node = null;
                                Throwable ex = this.error;
                                if (ex != null) {
                                    a.onError(ex);
                                    return;
                                } else {
                                    a.onCompleted();
                                    return;
                                }
                            } else if (empty2) {
                                break;
                            } else {
                                a.onNext(next.value);
                                e++;
                                node = next;
                            }
                        }
                    }
                    if (e == r) {
                        if (a.isUnsubscribed()) {
                            rp.node = null;
                            return;
                        }
                        boolean d2 = this.done;
                        if (node.get() != null) {
                            empty = false;
                        }
                        if (d2 && empty) {
                            rp.node = null;
                            Throwable ex2 = this.error;
                            if (ex2 != null) {
                                a.onError(ex2);
                                return;
                            } else {
                                a.onCompleted();
                                return;
                            }
                        }
                    }
                    if (!(e == 0 || r == LongCompanionObject.MAX_VALUE)) {
                        BackpressureUtils.produced(rp.requested, e);
                    }
                    rp.node = node;
                    missed = rp.addAndGet(-missed);
                } while (missed != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final long timestamp;
            final T value;

            public TimedNode(T value2, long timestamp2) {
                this.value = value2;
                this.timestamp = timestamp2;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            TimedNode<T> h = latestHead();
            while (true) {
                TimedNode<T> n = (TimedNode) h.get();
                if (n == null) {
                    return h.value;
                }
                h = n;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int s = 0;
            TimedNode<T> n = (TimedNode) latestHead().get();
            while (n != null && s != Integer.MAX_VALUE) {
                n = (TimedNode) n.get();
                s++;
            }
            return s;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return latestHead().get() == null;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] a) {
            List<T> list = new ArrayList<>();
            for (TimedNode<T> n = (TimedNode) latestHead().get(); n != null; n = (TimedNode) n.get()) {
                list.add(n.value);
            }
            return (T[]) list.toArray(a);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ReplayProducer<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        final Subscriber<? super T> actual;
        int index;
        Object node;
        final AtomicLong requested = new AtomicLong();
        final ReplayState<T> state;
        int tailIndex;

        public ReplayProducer(Subscriber<? super T> actual2, ReplayState<T> state2) {
            this.actual = actual2;
            this.state = state2;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.state.remove(this);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, n);
                this.state.buffer.drain(this);
            } else if (n < 0) {
                throw new IllegalArgumentException("n >= required but it was " + n);
            }
        }
    }
}
