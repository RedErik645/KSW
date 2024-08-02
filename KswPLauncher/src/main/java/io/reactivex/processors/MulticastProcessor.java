package io.reactivex.processors;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@SchedulerSupport(SchedulerSupport.NONE)
@BackpressureSupport(BackpressureKind.FULL)
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
    static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
    final int bufferSize;
    int consumed;
    volatile boolean done;
    volatile Throwable error;
    int fusionMode;
    final int limit;
    final AtomicBoolean once;
    volatile SimpleQueue<T> queue;
    final boolean refcount;
    final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    final AtomicReference<Subscription> upstream = new AtomicReference<>();
    final AtomicInteger wip = new AtomicInteger();

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(bufferSize(), false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(boolean refCount) {
        return new MulticastProcessor<>(bufferSize(), refCount);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int bufferSize2) {
        return new MulticastProcessor<>(bufferSize2, false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int bufferSize2, boolean refCount) {
        return new MulticastProcessor<>(bufferSize2, refCount);
    }

    MulticastProcessor(int bufferSize2, boolean refCount) {
        ObjectHelper.verifyPositive(bufferSize2, "bufferSize");
        this.bufferSize = bufferSize2;
        this.limit = bufferSize2 - (bufferSize2 >> 2);
        this.refcount = refCount;
        this.once = new AtomicBoolean();
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscArrayQueue(this.bufferSize);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE)) {
            this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        if (SubscriptionHelper.setOnce(this.upstream, s)) {
            if (s instanceof QueueSubscription) {
                QueueSubscription<T> qs = (QueueSubscription) s;
                int m = qs.requestFusion(3);
                if (m == 1) {
                    this.fusionMode = m;
                    this.queue = qs;
                    this.done = true;
                    drain();
                    return;
                } else if (m == 2) {
                    this.fusionMode = m;
                    this.queue = qs;
                    s.request((long) this.bufferSize);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.bufferSize);
            s.request((long) this.bufferSize);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (!this.once.get()) {
            if (this.fusionMode == 0) {
                ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                if (!this.queue.offer(t)) {
                    SubscriptionHelper.cancel(this.upstream);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            drain();
        }
    }

    public boolean offer(T t) {
        if (this.once.get()) {
            return false;
        }
        ObjectHelper.requireNonNull(t, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.fusionMode != 0 || !this.queue.offer(t)) {
            return false;
        }
        drain();
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable t) {
        ObjectHelper.requireNonNull(t, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.error = t;
            this.done = true;
            drain();
            return;
        }
        RxJavaPlugins.onError(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.once.compareAndSet(false, true)) {
            this.done = true;
            drain();
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.once.get() && this.error != null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.once.get() && this.error == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.once.get()) {
            return this.error;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        Throwable ex;
        MulticastSubscription<T> ms = new MulticastSubscription<>(s, this);
        s.onSubscribe(ms);
        if (add(ms)) {
            if (ms.get() == Long.MIN_VALUE) {
                remove(ms);
            } else {
                drain();
            }
        } else if ((this.once.get() || !this.refcount) && (ex = this.error) != null) {
            s.onError(ex);
        } else {
            s.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean add(MulticastSubscription<T> inner) {
        MulticastSubscription<T>[] a;
        MulticastSubscription<T>[] b;
        do {
            a = this.subscribers.get();
            if (a == TERMINATED) {
                return false;
            }
            int n = a.length;
            b = new MulticastSubscription[(n + 1)];
            System.arraycopy(a, 0, b, 0, n);
            b[n] = inner;
        } while (!this.subscribers.compareAndSet(a, b));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void remove(MulticastSubscription<T> inner) {
        while (true) {
            MulticastSubscription<T>[] a = this.subscribers.get();
            int n = a.length;
            if (n != 0) {
                int j = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (a[i] == inner) {
                        j = i;
                        break;
                    } else {
                        i++;
                    }
                }
                if (j >= 0) {
                    if (n != 1) {
                        MulticastSubscription<T>[] b = new MulticastSubscription[(n - 1)];
                        System.arraycopy(a, 0, b, 0, j);
                        System.arraycopy(a, j + 1, b, j, (n - j) - 1);
                        if (this.subscribers.compareAndSet(a, b)) {
                            return;
                        }
                    } else if (this.refcount) {
                        if (this.subscribers.compareAndSet(a, TERMINATED)) {
                            SubscriptionHelper.cancel(this.upstream);
                            this.once.set(true);
                            return;
                        }
                    } else if (this.subscribers.compareAndSet(a, EMPTY)) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fe, code lost:
        if (r10 != 0) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0100, code lost:
        r0 = r2.get();
        r8 = io.reactivex.processors.MulticastProcessor.TERMINATED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0108, code lost:
        if (r0 != r8) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010a, code lost:
        r6.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010e, code lost:
        if (r7 == r0) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0116, code lost:
        if (r23.done == false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011c, code lost:
        if (r6.isEmpty() == false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x011e, code lost:
        r12 = r23.error;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0120, code lost:
        if (r12 == null) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0122, code lost:
        r8 = r2.getAndSet(r8);
        r13 = r8.length;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x012a, code lost:
        if (r14 >= r13) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012c, code lost:
        r8[r14].onError(r12);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0134, code lost:
        r8 = r2.getAndSet(r8);
        r13 = r8.length;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013c, code lost:
        if (r14 >= r13) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013e, code lost:
        r8[r14].onComplete();
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0147, code lost:
        r0 = r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
        // Method dump skipped, instructions count: 346
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.MulticastProcessor.drain():void");
    }

    /* access modifiers changed from: package-private */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> actual, MulticastProcessor<T> parent2) {
            this.downstream = actual;
            this.parent = parent2;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            long r;
            long u;
            if (SubscriptionHelper.validate(n)) {
                do {
                    r = get();
                    if (r != Long.MIN_VALUE && r != LongCompanionObject.MAX_VALUE) {
                        u = r + n;
                        if (u < 0) {
                            u = LongCompanionObject.MAX_VALUE;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(r, u));
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t);
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable t) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(t);
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }
    }
}
