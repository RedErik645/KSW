package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final AtomicReference<Subscriber<? super T>> downstream;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested;
    final BasicIntQueueSubscription<T> wip;

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(bufferSize());
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int capacityHint) {
        return new UnicastProcessor<>(capacityHint);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(boolean delayError2) {
        return new UnicastProcessor<>(bufferSize(), null, delayError2);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int capacityHint, Runnable onCancelled) {
        ObjectHelper.requireNonNull(onCancelled, "onTerminate");
        return new UnicastProcessor<>(capacityHint, onCancelled);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int capacityHint, Runnable onCancelled, boolean delayError2) {
        ObjectHelper.requireNonNull(onCancelled, "onTerminate");
        return new UnicastProcessor<>(capacityHint, onCancelled, delayError2);
    }

    UnicastProcessor(int capacityHint) {
        this(capacityHint, null, true);
    }

    UnicastProcessor(int capacityHint, Runnable onTerminate2) {
        this(capacityHint, onTerminate2, true);
    }

    UnicastProcessor(int capacityHint, Runnable onTerminate2, boolean delayError2) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(capacityHint, "capacityHint"));
        this.onTerminate = new AtomicReference<>(onTerminate2);
        this.delayError = delayError2;
        this.downstream = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription();
        this.requested = new AtomicLong();
    }

    /* access modifiers changed from: package-private */
    public void doTerminate() {
        Runnable r = this.onTerminate.getAndSet(null);
        if (r != null) {
            r.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void drainRegular(Subscriber<? super T> a) {
        SpscLinkedArrayQueue<T> q = this.queue;
        boolean failFast = !this.delayError;
        int missed = 1;
        do {
            long r = this.requested.get();
            long e = 0;
            while (true) {
                if (r == e) {
                    break;
                }
                boolean d = this.done;
                T t = q.poll();
                boolean empty = t == null;
                if (!checkTerminated(failFast, d, empty, a, q)) {
                    if (empty) {
                        break;
                    }
                    a.onNext(t);
                    e++;
                } else {
                    return;
                }
            }
            if (r != e || !checkTerminated(failFast, this.done, q.isEmpty(), a, q)) {
                if (!(e == 0 || r == LongCompanionObject.MAX_VALUE)) {
                    this.requested.addAndGet(-e);
                }
                missed = this.wip.addAndGet(-missed);
            } else {
                return;
            }
        } while (missed != 0);
    }

    /* access modifiers changed from: package-private */
    public void drainFused(Subscriber<? super T> a) {
        int missed = 1;
        SpscLinkedArrayQueue<T> q = this.queue;
        boolean failFast = !this.delayError;
        while (!this.cancelled) {
            boolean d = this.done;
            if (!failFast || !d || this.error == null) {
                a.onNext(null);
                if (d) {
                    this.downstream.lazySet(null);
                    Throwable ex = this.error;
                    if (ex != null) {
                        a.onError(ex);
                        return;
                    } else {
                        a.onComplete();
                        return;
                    }
                } else {
                    missed = this.wip.addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            } else {
                q.clear();
                this.downstream.lazySet(null);
                a.onError(this.error);
                return;
            }
        }
        this.downstream.lazySet(null);
    }

    /* access modifiers changed from: package-private */
    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            int missed = 1;
            Subscriber<? super T> a = this.downstream.get();
            while (a == null) {
                missed = this.wip.addAndGet(-missed);
                if (missed != 0) {
                    a = this.downstream.get();
                } else {
                    return;
                }
            }
            if (this.enableOperatorFusion) {
                drainFused(a);
            } else {
                drainRegular(a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean checkTerminated(boolean failFast, boolean d, boolean empty, Subscriber<? super T> a, SpscLinkedArrayQueue<T> q) {
        if (this.cancelled) {
            q.clear();
            this.downstream.lazySet(null);
            return true;
        } else if (!d) {
            return false;
        } else {
            if (failFast && this.error != null) {
                q.clear();
                this.downstream.lazySet(null);
                a.onError(this.error);
                return true;
            } else if (!empty) {
                return false;
            } else {
                Throwable e = this.error;
                this.downstream.lazySet(null);
                if (e != null) {
                    a.onError(e);
                } else {
                    a.onComplete();
                }
                return true;
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        if (this.done || this.cancelled) {
            s.cancel();
        } else {
            s.request(LongCompanionObject.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done && !this.cancelled) {
            this.queue.offer(t);
            drain();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable t) {
        ObjectHelper.requireNonNull(t, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done || this.cancelled) {
            RxJavaPlugins.onError(t);
            return;
        }
        this.error = t;
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.done && !this.cancelled) {
            this.done = true;
            doTerminate();
            drain();
        }
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), s);
            return;
        }
        s.onSubscribe(this.wip);
        this.downstream.set(s);
        if (this.cancelled) {
            this.downstream.lazySet(null);
        } else {
            drain();
        }
    }

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int requestedMode) {
            if ((requestedMode & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.enableOperatorFusion = true;
            return 2;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(UnicastProcessor.this.requested, n);
                UnicastProcessor.this.drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!UnicastProcessor.this.cancelled) {
                UnicastProcessor.this.cancelled = true;
                UnicastProcessor.this.doTerminate();
                UnicastProcessor.this.downstream.lazySet(null);
                if (UnicastProcessor.this.wip.getAndIncrement() == 0) {
                    UnicastProcessor.this.downstream.lazySet(null);
                    if (!UnicastProcessor.this.enableOperatorFusion) {
                        UnicastProcessor.this.queue.clear();
                    }
                }
            }
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.downstream.get() != null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }
}
