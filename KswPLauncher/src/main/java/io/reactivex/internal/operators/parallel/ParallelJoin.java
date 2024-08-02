package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    public ParallelJoin(ParallelFlowable<? extends T> source2, int prefetch2, boolean delayErrors2) {
        this.source = source2;
        this.prefetch = prefetch2;
        this.delayErrors = delayErrors2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        JoinSubscriptionBase<T> parent;
        if (this.delayErrors) {
            parent = new JoinSubscriptionDelayError<>(s, this.source.parallelism(), this.prefetch);
        } else {
            parent = new JoinSubscription<>(s, this.source.parallelism(), this.prefetch);
        }
        s.onSubscribe(parent);
        this.source.subscribe(parent.subscribers);
    }

    static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        volatile boolean cancelled;
        final AtomicInteger done = new AtomicInteger();
        final Subscriber<? super T> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final JoinInnerSubscriber<T>[] subscribers;

        /* access modifiers changed from: package-private */
        public abstract void drain();

        /* access modifiers changed from: package-private */
        public abstract void onComplete();

        /* access modifiers changed from: package-private */
        public abstract void onError(Throwable th);

        /* access modifiers changed from: package-private */
        public abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        JoinSubscriptionBase(Subscriber<? super T> actual, int n, int prefetch) {
            this.downstream = actual;
            JoinInnerSubscriber<T>[] a = new JoinInnerSubscriber[n];
            for (int i = 0; i < n; i++) {
                a[i] = new JoinInnerSubscriber<>(this, prefetch);
            }
            this.subscribers = a;
            this.done.lazySet(n);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    cleanup();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAll() {
            for (JoinInnerSubscriber<T> s : this.subscribers) {
                s.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        public void cleanup() {
            for (JoinInnerSubscriber<T> s : this.subscribers) {
                s.queue = null;
            }
        }
    }

    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> actual, int n, int prefetch) {
            super(actual, n, prefetch);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> inner, T value) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(value);
                    if (this.requested.get() != LongCompanionObject.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    inner.request(1);
                } else if (!inner.getQueue().offer(value)) {
                    cancelAll();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.downstream.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!inner.getQueue().offer(value)) {
                cancelAll();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable e) {
            if (this.errors.compareAndSet(null, e)) {
                cancelAll();
                drain();
            } else if (e != this.errors.get()) {
                RxJavaPlugins.onError(e);
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005e, code lost:
            if (r12 == false) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
            if (r13 == false) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
            r4.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0066, code lost:
            if (r13 == false) goto L_0x0010;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drainLoop() {
            /*
            // Method dump skipped, instructions count: 214
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscription.drainLoop():void");
        }
    }

    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> actual, int n, int prefetch) {
            super(actual, n, prefetch);
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> inner, T value) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!inner.getQueue().offer(value) && inner.cancel()) {
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(value);
                    if (this.requested.get() != LongCompanionObject.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    inner.request(1);
                } else if (!inner.getQueue().offer(value)) {
                    inner.cancel();
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable e) {
            this.errors.addThrowable(e);
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
            if (r9 == false) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
            if (r12 == false) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
            if (((java.lang.Throwable) r18.errors.get()) == null) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
            r4.onError(r18.errors.terminate());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0065, code lost:
            r4.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
            if (r12 == false) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drainLoop() {
            /*
            // Method dump skipped, instructions count: 221
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.drainLoop():void");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> parent2, int prefetch2) {
            this.parent = parent2;
            this.prefetch = prefetch2;
            this.limit = prefetch2 - (prefetch2 >> 2);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, (long) this.prefetch);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.parent.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.onComplete();
        }

        public void requestOne() {
            long p = this.produced + 1;
            if (p == ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(p);
                return;
            }
            this.produced = p;
        }

        public void request(long n) {
            long p = this.produced + n;
            if (p >= ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(p);
                return;
            }
            this.produced = p;
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        /* access modifiers changed from: package-private */
        public SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> q = this.queue;
            if (q != null) {
                return q;
            }
            SimplePlainQueue<T> q2 = new SpscArrayQueue<>(this.prefetch);
            this.queue = q2;
            return q2;
        }
    }
}
