package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final Callable<C> bufferSupplier;
    final int size;
    final int skip;

    public FlowableBuffer(Flowable<T> source, int size2, int skip2, Callable<C> bufferSupplier2) {
        super(source);
        this.size = size2;
        this.skip = skip2;
        this.bufferSupplier = bufferSupplier2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super C> s) {
        int i = this.size;
        int i2 = this.skip;
        if (i == i2) {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferExactSubscriber(s, this.size, this.bufferSupplier));
        } else if (i2 > i) {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferSkipSubscriber(s, this.size, this.skip, this.bufferSupplier));
        } else {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferOverlappingSubscriber(s, this.size, this.skip, this.bufferSupplier));
        }
    }

    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final int size;
        Subscription upstream;

        PublisherBufferExactSubscriber(Subscriber<? super C> actual, int size2, Callable<C> bufferSupplier2) {
            this.downstream = actual;
            this.size = size2;
            this.bufferSupplier = bufferSupplier2;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                this.upstream.request(BackpressureHelper.multiplyCap(n, (long) this.size));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.util.Collection] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.reactivestreams.Subscriber
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r4) {
            /*
                r3 = this;
                boolean r0 = r3.done
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                C extends java.util.Collection<? super T> r0 = r3.buffer
                if (r0 != 0) goto L_0x0027
                java.util.concurrent.Callable<C extends java.util.Collection<? super T>> r1 = r3.bufferSupplier     // Catch:{ all -> 0x001c }
                java.lang.Object r1 = r1.call()     // Catch:{ all -> 0x001c }
                java.lang.String r2 = "The bufferSupplier returned a null buffer"
                java.lang.Object r1 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r1, r2)     // Catch:{ all -> 0x001c }
                java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x001c }
                r0 = r1
                r3.buffer = r0
                goto L_0x0027
            L_0x001c:
                r1 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r1)
                r3.cancel()
                r3.onError(r1)
                return
            L_0x0027:
                r0.add(r4)
                int r1 = r3.index
                int r1 = r1 + 1
                int r2 = r3.size
                if (r1 != r2) goto L_0x003e
                r2 = 0
                r3.index = r2
                r2 = 0
                r3.buffer = r2
                org.reactivestreams.Subscriber<? super C extends java.util.Collection<? super T>> r2 = r3.downstream
                r2.onNext(r0)
                goto L_0x0040
            L_0x003e:
                r3.index = r1
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBuffer.PublisherBufferExactSubscriber.onNext(java.lang.Object):void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                C b = this.buffer;
                if (b != null && !b.isEmpty()) {
                    this.downstream.onNext(b);
                }
                this.downstream.onComplete();
            }
        }
    }

    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final int size;
        final int skip;
        Subscription upstream;

        PublisherBufferSkipSubscriber(Subscriber<? super C> actual, int size2, int skip2, Callable<C> bufferSupplier2) {
            this.downstream = actual;
            this.size = size2;
            this.skip = skip2;
            this.bufferSupplier = bufferSupplier2;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (!SubscriptionHelper.validate(n)) {
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                this.upstream.request(BackpressureHelper.multiplyCap((long) this.skip, n));
                return;
            }
            this.upstream.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(n, (long) this.size), BackpressureHelper.multiplyCap((long) (this.skip - this.size), n - 1)));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v9, types: [java.util.Collection] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.reactivestreams.Subscriber
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r5) {
            /*
                r4 = this;
                boolean r0 = r4.done
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                C extends java.util.Collection<? super T> r0 = r4.buffer
                int r1 = r4.index
                int r2 = r1 + 1
                if (r1 != 0) goto L_0x002b
                java.util.concurrent.Callable<C extends java.util.Collection<? super T>> r1 = r4.bufferSupplier     // Catch:{ all -> 0x0020 }
                java.lang.Object r1 = r1.call()     // Catch:{ all -> 0x0020 }
                java.lang.String r3 = "The bufferSupplier returned a null buffer"
                java.lang.Object r1 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r1, r3)     // Catch:{ all -> 0x0020 }
                java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x0020 }
                r0 = r1
                r4.buffer = r0
                goto L_0x002b
            L_0x0020:
                r1 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r1)
                r4.cancel()
                r4.onError(r1)
                return
            L_0x002b:
                if (r0 == 0) goto L_0x0040
                r0.add(r5)
                int r1 = r0.size()
                int r3 = r4.size
                if (r1 != r3) goto L_0x0040
                r1 = 0
                r4.buffer = r1
                org.reactivestreams.Subscriber<? super C extends java.util.Collection<? super T>> r1 = r4.downstream
                r1.onNext(r0)
            L_0x0040:
                int r1 = r4.skip
                if (r2 != r1) goto L_0x0045
                r2 = 0
            L_0x0045:
                r4.index = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBuffer.PublisherBufferSkipSubscriber.onNext(java.lang.Object):void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                C b = this.buffer;
                this.buffer = null;
                if (b != null) {
                    this.downstream.onNext(b);
                }
                this.downstream.onComplete();
            }
        }
    }

    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        final Callable<C> bufferSupplier;
        final ArrayDeque<C> buffers = new ArrayDeque<>();
        volatile boolean cancelled;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final AtomicBoolean once = new AtomicBoolean();
        long produced;
        final int size;
        final int skip;
        Subscription upstream;

        PublisherBufferOverlappingSubscriber(Subscriber<? super C> actual, int size2, int skip2, Callable<C> bufferSupplier2) {
            this.downstream = actual;
            this.size = size2;
            this.skip = skip2;
            this.bufferSupplier = bufferSupplier2;
        }

        @Override // io.reactivex.functions.BooleanSupplier
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n) && !QueueDrainHelper.postCompleteRequest(n, this.downstream, this.buffers, this, this)) {
                if (this.once.get() || !this.once.compareAndSet(false, true)) {
                    this.upstream.request(BackpressureHelper.multiplyCap((long) this.skip, n));
                    return;
                }
                this.upstream.request(BackpressureHelper.addCap((long) this.size, BackpressureHelper.multiplyCap((long) this.skip, n - 1)));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.ArrayDeque<C extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                ArrayDeque<C> bs = this.buffers;
                int i = this.index;
                int i2 = i + 1;
                if (i == 0) {
                    try {
                        bs.offer((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                    } catch (Throwable e) {
                        Exceptions.throwIfFatal(e);
                        cancel();
                        onError(e);
                        return;
                    }
                }
                Collection collection = (Collection) bs.peek();
                if (collection != null && collection.size() + 1 == this.size) {
                    bs.poll();
                    collection.add(t);
                    this.produced++;
                    this.downstream.onNext(collection);
                }
                Iterator it = bs.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t);
                }
                if (i2 == this.skip) {
                    i2 = 0;
                }
                this.index = i2;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                long p = this.produced;
                if (p != 0) {
                    BackpressureHelper.produced(this, p);
                }
                QueueDrainHelper.postComplete(this.downstream, this.buffers, this, this);
            }
        }
    }
}
