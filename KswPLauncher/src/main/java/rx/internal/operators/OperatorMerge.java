package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayErrors;
    final int maxConcurrent;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* access modifiers changed from: package-private */
    public static final class HolderNoDelay {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);

        HolderNoDelay() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class HolderDelayErrors {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);

        HolderDelayErrors() {
        }
    }

    public static <T> OperatorMerge<T> instance(boolean delayErrors2) {
        return delayErrors2 ? (OperatorMerge<T>) HolderDelayErrors.INSTANCE : (OperatorMerge<T>) HolderNoDelay.INSTANCE;
    }

    public static <T> OperatorMerge<T> instance(boolean delayErrors2, int maxConcurrent2) {
        if (maxConcurrent2 <= 0) {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + maxConcurrent2);
        } else if (maxConcurrent2 == Integer.MAX_VALUE) {
            return instance(delayErrors2);
        } else {
            return new OperatorMerge<>(delayErrors2, maxConcurrent2);
        }
    }

    OperatorMerge(boolean delayErrors2, int maxConcurrent2) {
        this.delayErrors = delayErrors2;
        this.maxConcurrent = maxConcurrent2;
    }

    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> child) {
        MergeSubscriber<T> subscriber = new MergeSubscriber<>(child, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> producer = new MergeProducer<>(subscriber);
        subscriber.producer = producer;
        child.add(subscriber);
        child.setProducer(producer);
        return subscriber;
    }

    /* access modifiers changed from: package-private */
    public static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> subscriber2) {
            this.subscriber = subscriber2;
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n > 0) {
                if (get() != LongCompanionObject.MAX_VALUE) {
                    BackpressureUtils.getAndAddRequest(this, n);
                    this.subscriber.emit();
                }
            } else if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        public long produced(int n) {
            return addAndGet((long) (-n));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        final Subscriber<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        volatile ConcurrentLinkedQueue<Throwable> errors;
        final Object innerGuard = new Object();
        volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;
        long lastId;
        int lastIndex;
        final int maxConcurrent;
        boolean missed;
        final NotificationLite<T> nl = NotificationLite.instance();
        MergeProducer<T> producer;
        volatile Queue<Object> queue;
        int scalarEmissionCount;
        final int scalarEmissionLimit;
        volatile CompositeSubscription subscriptions;
        long uniqueId;

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Observable) ((Observable) x0));
        }

        public MergeSubscriber(Subscriber<? super T> child2, boolean delayErrors2, int maxConcurrent2) {
            this.child = child2;
            this.delayErrors = delayErrors2;
            this.maxConcurrent = maxConcurrent2;
            if (maxConcurrent2 == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(LongCompanionObject.MAX_VALUE);
                return;
            }
            this.scalarEmissionLimit = Math.max(1, maxConcurrent2 >> 1);
            request((long) maxConcurrent2);
        }

        /* access modifiers changed from: package-private */
        public Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> q = this.errors;
            if (q == null) {
                synchronized (this) {
                    q = this.errors;
                    if (q == null) {
                        q = new ConcurrentLinkedQueue<>();
                        this.errors = q;
                    }
                }
            }
            return q;
        }

        /* access modifiers changed from: package-private */
        public CompositeSubscription getOrCreateComposite() {
            CompositeSubscription c = this.subscriptions;
            if (c == null) {
                boolean shouldAdd = false;
                synchronized (this) {
                    c = this.subscriptions;
                    if (c == null) {
                        c = new CompositeSubscription();
                        this.subscriptions = c;
                        shouldAdd = true;
                    }
                }
                if (shouldAdd) {
                    add(c);
                }
            }
            return c;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.OperatorMerge$MergeSubscriber<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void onNext(Observable<? extends T> t) {
            if (t != null) {
                if (t == Observable.empty()) {
                    emitEmpty();
                } else if (t instanceof ScalarSynchronousObservable) {
                    tryEmit(((ScalarSynchronousObservable) t).get());
                } else {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    InnerSubscriber<T> inner = new InnerSubscriber<>(this, j);
                    addInner(inner);
                    t.unsafeSubscribe(inner);
                    emit();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void emitEmpty() {
            int produced = this.scalarEmissionCount + 1;
            if (produced == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore((long) produced);
                return;
            }
            this.scalarEmissionCount = produced;
        }

        private void reportError() {
            List<Throwable> list = new ArrayList<>(this.errors);
            if (list.size() == 1) {
                this.child.onError(list.get(0));
            } else {
                this.child.onError(new CompositeException(list));
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            getOrCreateErrorQueue().offer(e);
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.internal.operators.OperatorMerge$InnerSubscriber<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public void addInner(InnerSubscriber<T> inner) {
            getOrCreateComposite().add(inner);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] a = this.innerSubscribers;
                int n = a.length;
                InnerSubscriber<?>[] b = new InnerSubscriber[(n + 1)];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = inner;
                this.innerSubscribers = b;
            }
        }

        /* access modifiers changed from: package-private */
        public void removeInner(InnerSubscriber<T> inner) {
            RxRingBuffer q = inner.queue;
            if (q != null) {
                q.release();
            }
            this.subscriptions.remove(inner);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] a = this.innerSubscribers;
                int n = a.length;
                int j = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (inner.equals(a[i])) {
                        j = i;
                        break;
                    } else {
                        i++;
                    }
                }
                if (j >= 0) {
                    if (n == 1) {
                        this.innerSubscribers = EMPTY;
                        return;
                    }
                    InnerSubscriber<?>[] b = new InnerSubscriber[(n - 1)];
                    System.arraycopy(a, 0, b, 0, j);
                    System.arraycopy(a, j + 1, b, j, (n - j) - 1);
                    this.innerSubscribers = b;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void tryEmit(InnerSubscriber<T> subscriber, T value) {
            boolean success = false;
            long r = this.producer.get();
            if (r != 0) {
                synchronized (this) {
                    r = this.producer.get();
                    if (!this.emitting && r != 0) {
                        this.emitting = true;
                        success = true;
                    }
                }
            }
            if (success) {
                RxRingBuffer subscriberQueue = subscriber.queue;
                if (subscriberQueue == null || subscriberQueue.isEmpty()) {
                    emitScalar(subscriber, value, r);
                    return;
                }
                queueScalar(subscriber, value);
                emitLoop();
                return;
            }
            queueScalar(subscriber, value);
            emit();
        }

        /* access modifiers changed from: protected */
        public void queueScalar(InnerSubscriber<T> subscriber, T value) {
            RxRingBuffer q = subscriber.queue;
            if (q == null) {
                q = RxRingBuffer.getSpscInstance();
                subscriber.add(q);
                subscriber.queue = q;
            }
            try {
                q.onNext(this.nl.next(value));
            } catch (MissingBackpressureException ex) {
                subscriber.unsubscribe();
                subscriber.onError(ex);
            } catch (IllegalStateException ex2) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.unsubscribe();
                    subscriber.onError(ex2);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x004b, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0054, code lost:
            if (1 != 0) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0056, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0059, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x005e, code lost:
            emitLoop();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0061, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0065, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0066, code lost:
            r2 = r0;
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitScalar(rx.internal.operators.OperatorMerge.InnerSubscriber<T> r6, T r7, long r8) {
            /*
            // Method dump skipped, instructions count: 118
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitScalar(rx.internal.operators.OperatorMerge$InnerSubscriber, java.lang.Object, long):void");
        }

        public void requestMore(long n) {
            request(n);
        }

        /* access modifiers changed from: package-private */
        public void tryEmit(T value) {
            boolean success = false;
            long r = this.producer.get();
            if (r != 0) {
                synchronized (this) {
                    r = this.producer.get();
                    if (!this.emitting && r != 0) {
                        this.emitting = true;
                        success = true;
                    }
                }
            }
            if (success) {
                Queue<Object> mainQueue = this.queue;
                if (mainQueue == null || mainQueue.isEmpty()) {
                    emitScalar(value, r);
                    return;
                }
                queueScalar(value);
                emitLoop();
                return;
            }
            queueScalar(value);
            emit();
        }

        /* access modifiers changed from: protected */
        public void queueScalar(T value) {
            Queue<Object> q = this.queue;
            if (q == null) {
                int mc = this.maxConcurrent;
                if (mc == Integer.MAX_VALUE) {
                    q = new SpscUnboundedAtomicArrayQueue(RxRingBuffer.SIZE);
                } else if (!Pow2.isPowerOfTwo(mc)) {
                    q = new SpscExactAtomicArrayQueue(mc);
                } else if (UnsafeAccess.isUnsafeAvailable()) {
                    q = new SpscArrayQueue(mc);
                } else {
                    q = new SpscAtomicArrayQueue(mc);
                }
                this.queue = q;
            }
            if (!q.offer(this.nl.next(value))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), value));
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x005f, code lost:
            if (1 != 0) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0061, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0064, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0069, code lost:
            emitLoop();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x006c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0070, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0071, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitScalar(T r6, long r7) {
            /*
            // Method dump skipped, instructions count: 127
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitScalar(java.lang.Object, long):void");
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
        /* JADX WARNING: Code restructure failed: missing block: B:239:0x02b5, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x02b7, code lost:
            monitor-enter(r34);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
            r34.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x02bb, code lost:
            monitor-exit(r34);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:251:0x02c5, code lost:
            r2 = r21;
            r4 = r29;
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:316:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:317:?, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x014b A[Catch:{ all -> 0x029e }] */
        /* JADX WARNING: Removed duplicated region for block: B:260:0x02d8  */
        /* JADX WARNING: Removed duplicated region for block: B:291:0x0276 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitLoop() {
            /*
            // Method dump skipped, instructions count: 738
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitLoop():void");
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            Queue<Throwable> e = this.errors;
            if (this.delayErrors || e == null || e.isEmpty()) {
                return false;
            }
            try {
                reportError();
                return true;
            } finally {
                unsubscribe();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int LIMIT = (RxRingBuffer.SIZE / 4);
        volatile boolean done;
        final long id;
        int outstanding;
        final MergeSubscriber<T> parent;
        volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> parent2, long id2) {
            this.parent = parent2;
            this.id = id2;
        }

        @Override // rx.Subscriber
        public void onStart() {
            this.outstanding = RxRingBuffer.SIZE;
            request((long) RxRingBuffer.SIZE);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.parent.tryEmit(this, t);
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.done = true;
            this.parent.getOrCreateErrorQueue().offer(e);
            this.parent.emit();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            this.parent.emit();
        }

        public void requestMore(long n) {
            int r = this.outstanding - ((int) n);
            if (r > LIMIT) {
                this.outstanding = r;
                return;
            }
            this.outstanding = RxRingBuffer.SIZE;
            int k = RxRingBuffer.SIZE - r;
            if (k > 0) {
                request((long) k);
            }
        }
    }
}
