package rx.internal.util;

import java.util.Queue;
import rx.Observer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public class RxRingBuffer implements Subscription {
    private static final NotificationLite<Object> ON = NotificationLite.instance();
    public static final int SIZE;
    public static final ObjectPool<Queue<Object>> SPMC_POOL = new ObjectPool<Queue<Object>>() {
        /* class rx.internal.util.RxRingBuffer.AnonymousClass2 */

        /* Return type fixed from 'rx.internal.util.unsafe.SpmcArrayQueue<java.lang.Object>' to match base method */
        /* access modifiers changed from: protected */
        @Override // rx.internal.util.ObjectPool
        public Queue<Object> createObject() {
            return new SpmcArrayQueue<>(RxRingBuffer.SIZE);
        }
    };
    public static final ObjectPool<Queue<Object>> SPSC_POOL = new ObjectPool<Queue<Object>>() {
        /* class rx.internal.util.RxRingBuffer.AnonymousClass1 */

        /* Return type fixed from 'rx.internal.util.unsafe.SpscArrayQueue<java.lang.Object>' to match base method */
        /* access modifiers changed from: protected */
        @Override // rx.internal.util.ObjectPool
        public Queue<Object> createObject() {
            return new SpscArrayQueue<>(RxRingBuffer.SIZE);
        }
    };
    private final ObjectPool<Queue<Object>> pool;
    private Queue<Object> queue;
    private final int size;
    public volatile Object terminalState;

    static {
        int defaultSize = 128;
        if (PlatformDependent.isAndroid()) {
            defaultSize = 16;
        }
        String sizeFromProperty = System.getProperty("rx.ring-buffer.size");
        if (sizeFromProperty != null) {
            try {
                defaultSize = Integer.parseInt(sizeFromProperty);
            } catch (NumberFormatException e) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + sizeFromProperty + " => " + e.getMessage());
            }
        }
        SIZE = defaultSize;
    }

    public static RxRingBuffer getSpscInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(SPSC_POOL, SIZE);
        }
        return new RxRingBuffer();
    }

    public static RxRingBuffer getSpmcInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(SPMC_POOL, SIZE);
        }
        return new RxRingBuffer();
    }

    private RxRingBuffer(Queue<Object> queue2, int size2) {
        this.queue = queue2;
        this.pool = null;
        this.size = size2;
    }

    private RxRingBuffer(ObjectPool<Queue<Object>> pool2, int size2) {
        this.pool = pool2;
        this.queue = pool2.borrowObject();
        this.size = size2;
    }

    public synchronized void release() {
        Queue<Object> q = this.queue;
        ObjectPool<Queue<Object>> p = this.pool;
        if (!(p == null || q == null)) {
            q.clear();
            this.queue = null;
            p.returnObject(q);
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        release();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    RxRingBuffer() {
        /*
            r2 = this;
            rx.internal.util.SynchronizedQueue r0 = new rx.internal.util.SynchronizedQueue
            int r1 = rx.internal.util.RxRingBuffer.SIZE
            r0.<init>(r1)
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.RxRingBuffer.<init>():void");
    }

    public void onNext(Object o) throws MissingBackpressureException {
        boolean iae = false;
        boolean mbe = false;
        synchronized (this) {
            Queue<Object> q = this.queue;
            if (q != null) {
                mbe = !q.offer(ON.next(o));
            } else {
                iae = true;
            }
        }
        if (iae) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (mbe) {
            throw new MissingBackpressureException();
        }
    }

    public void onCompleted() {
        if (this.terminalState == null) {
            this.terminalState = ON.completed();
        }
    }

    public void onError(Throwable t) {
        if (this.terminalState == null) {
            this.terminalState = ON.error(t);
        }
    }

    public int available() {
        return this.size - count();
    }

    public int capacity() {
        return this.size;
    }

    public int count() {
        Queue<Object> q = this.queue;
        if (q == null) {
            return 0;
        }
        return q.size();
    }

    public boolean isEmpty() {
        Queue<Object> q = this.queue;
        if (q == null) {
            return true;
        }
        return q.isEmpty();
    }

    public Object poll() {
        Object o;
        synchronized (this) {
            try {
                Queue<Object> q = this.queue;
                if (q == null) {
                    return null;
                }
                Object o2 = q.poll();
                try {
                    Object ts = this.terminalState;
                    if (o2 == null && ts != null && q.peek() == null) {
                        this.terminalState = null;
                        o = ts;
                    } else {
                        o = o2;
                    }
                    return o;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public Object peek() {
        synchronized (this) {
            try {
                Queue<Object> q = this.queue;
                if (q == null) {
                    return null;
                }
                Object o = q.peek();
                Object ts = this.terminalState;
                if (o == null && ts != null && q.peek() == null) {
                    o = ts;
                }
                return o;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public boolean isCompleted(Object o) {
        return ON.isCompleted(o);
    }

    public boolean isError(Object o) {
        return ON.isError(o);
    }

    public Object getValue(Object o) {
        return ON.getValue(o);
    }

    public boolean accept(Object o, Observer child) {
        return ON.accept(child, o);
    }

    public Throwable asError(Object o) {
        return ON.getError(o);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.queue == null;
    }
}
