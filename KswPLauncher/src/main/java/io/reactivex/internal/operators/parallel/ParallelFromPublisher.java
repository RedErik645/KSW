package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    final int parallelism;
    final int prefetch;
    final Publisher<? extends T> source;

    public ParallelFromPublisher(Publisher<? extends T> source2, int parallelism2, int prefetch2) {
        this.source = source2;
        this.parallelism = parallelism2;
        this.prefetch = prefetch2;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.parallelism;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscribers) {
        if (validate(subscribers)) {
            this.source.subscribe(new ParallelDispatcher(subscribers, this.prefetch));
        }
    }

    static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        SimpleQueue<T> queue;
        final AtomicLongArray requests;
        int sourceMode;
        final AtomicInteger subscriberCount = new AtomicInteger();
        final Subscriber<? super T>[] subscribers;
        Subscription upstream;

        ParallelDispatcher(Subscriber<? super T>[] subscribers2, int prefetch2) {
            this.subscribers = subscribers2;
            this.prefetch = prefetch2;
            this.limit = prefetch2 - (prefetch2 >> 2);
            int m = subscribers2.length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(m + m + 1);
            this.requests = atomicLongArray;
            atomicLongArray.lazySet(m + m, (long) m);
            this.emissions = new long[m];
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                if (s instanceof QueueSubscription) {
                    QueueSubscription<T> qs = (QueueSubscription) s;
                    int m = qs.requestFusion(7);
                    if (m == 1) {
                        this.sourceMode = m;
                        this.queue = qs;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    } else if (m == 2) {
                        this.sourceMode = m;
                        this.queue = qs;
                        setupSubscribers();
                        s.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                setupSubscribers();
                s.request((long) this.prefetch);
            }
        }

        /* access modifiers changed from: package-private */
        public void setupSubscribers() {
            Subscriber<? super T>[] subs = this.subscribers;
            int m = subs.length;
            for (int i = 0; i < m && !this.cancelled; i++) {
                this.subscriberCount.lazySet(i + 1);
                subs[i].onSubscribe(new RailSubscription(i, m));
            }
        }

        /* access modifiers changed from: package-private */
        public final class RailSubscription implements Subscription {
            final int j;
            final int m;

            RailSubscription(int j2, int m2) {
                this.j = j2;
                this.m = m2;
            }

            @Override // org.reactivestreams.Subscription
            public void request(long n) {
                long r;
                if (SubscriptionHelper.validate(n)) {
                    AtomicLongArray ra = ParallelDispatcher.this.requests;
                    do {
                        r = ra.get(this.j);
                        if (r != LongCompanionObject.MAX_VALUE) {
                        } else {
                            return;
                        }
                    } while (!ra.compareAndSet(this.j, r, BackpressureHelper.addCap(r, n)));
                    if (ParallelDispatcher.this.subscriberCount.get() == this.m) {
                        ParallelDispatcher.this.drain();
                    }
                }
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                if (ParallelDispatcher.this.requests.compareAndSet(this.j + this.m, 0, 1)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i = this.m;
                    parallelDispatcher.cancel(i + i);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                drain();
                return;
            }
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.error = t;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void cancel(int m) {
            if (this.requests.decrementAndGet(m) == 0) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00cd  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drainAsync() {
            /*
            // Method dump skipped, instructions count: 234
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher.drainAsync():void");
        }

        /* access modifiers changed from: package-private */
        public void drainSync() {
            SimpleQueue<T> q;
            int missed;
            SimpleQueue<T> q2 = this.queue;
            Subscriber<? super T>[] a = this.subscribers;
            AtomicLongArray r = this.requests;
            long[] e = this.emissions;
            int n = e.length;
            int missed2 = 1;
            int w = this.index;
            while (true) {
                int notReady = 0;
                int idx = w;
                while (!this.cancelled) {
                    if (q2.isEmpty()) {
                        for (Subscriber<? super T> s : a) {
                            s.onComplete();
                        }
                        return;
                    }
                    long requestAtIndex = r.get(idx);
                    long emissionAtIndex = e[idx];
                    if (requestAtIndex == emissionAtIndex || r.get(n + idx) != 0) {
                        q = q2;
                        notReady++;
                    } else {
                        try {
                            T v = q2.poll();
                            if (v == null) {
                                for (Subscriber<? super T> s2 : a) {
                                    s2.onComplete();
                                }
                                return;
                            }
                            q = q2;
                            a[idx].onNext(v);
                            e[idx] = emissionAtIndex + 1;
                            notReady = 0;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.upstream.cancel();
                            int i = 0;
                            for (int length = a.length; i < length; length = length) {
                                a[i].onError(th);
                                i++;
                            }
                            return;
                        }
                    }
                    idx++;
                    if (idx == n) {
                        idx = 0;
                    }
                    if (notReady == n) {
                        int w2 = get();
                        if (w2 == missed2) {
                            this.index = idx;
                            missed = addAndGet(-missed2);
                            if (missed == 0) {
                                return;
                            }
                        } else {
                            missed = w2;
                        }
                        missed2 = missed;
                        w = idx;
                        q2 = q;
                    } else {
                        q2 = q;
                    }
                }
                q2.clear();
                return;
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.sourceMode == 1) {
                    drainSync();
                } else {
                    drainAsync();
                }
            }
        }
    }
}
