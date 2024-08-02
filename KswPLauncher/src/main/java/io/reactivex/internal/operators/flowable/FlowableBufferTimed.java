package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public FlowableBufferTimed(Flowable<T> source, long timespan2, long timeskip2, TimeUnit unit2, Scheduler scheduler2, Callable<U> bufferSupplier2, int maxSize2, boolean restartTimerOnMaxSize2) {
        super(source);
        this.timespan = timespan2;
        this.timeskip = timeskip2;
        this.unit = unit2;
        this.scheduler = scheduler2;
        this.bufferSupplier = bufferSupplier2;
        this.maxSize = maxSize2;
        this.restartTimerOnMaxSize = restartTimerOnMaxSize2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super U> s) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe((FlowableSubscriber) new BufferExactUnboundedSubscriber(new SerializedSubscriber(s), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker w = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe((FlowableSubscriber) new BufferExactBoundedSubscriber(new SerializedSubscriber(s), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, w));
        } else {
            this.source.subscribe((FlowableSubscriber) new BufferSkipBoundedSubscriber(new SerializedSubscriber(s), this.bufferSupplier, this.timespan, this.timeskip, this.unit, w));
        }
    }

    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;

        BufferExactUnboundedSubscriber(Subscriber<? super U> actual, Callable<U> bufferSupplier2, long timespan2, TimeUnit unit2, Scheduler scheduler2) {
            super(actual, new MpscLinkedQueue());
            this.bufferSupplier = bufferSupplier2;
            this.timespan = timespan2;
            this.unit = unit2;
            this.scheduler = scheduler2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                try {
                    this.buffer = (U) ((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null"));
                    this.downstream.onSubscribe(this);
                    if (!this.cancelled) {
                        s.request(LongCompanionObject.MAX_VALUE);
                        Scheduler scheduler2 = this.scheduler;
                        long j = this.timespan;
                        Disposable d = scheduler2.schedulePeriodicallyDirect(this, j, j, this.unit);
                        if (!this.timer.compareAndSet(null, d)) {
                            d.dispose();
                        }
                    }
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    cancel();
                    EmptySubscription.error(e, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U b = this.buffer;
                if (b != null) {
                    b.add(t);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(t);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            if (enter() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r5.queue, r5.downstream, false, null, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
            r5.queue.offer(r0);
            r5.done = true;
         */
        @Override // org.reactivestreams.Subscriber
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r5 = this;
                java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> r0 = r5.timer
                io.reactivex.internal.disposables.DisposableHelper.dispose(r0)
                monitor-enter(r5)
                U extends java.util.Collection<? super T> r0 = r5.buffer     // Catch:{ all -> 0x0027 }
                if (r0 != 0) goto L_0x000c
                monitor-exit(r5)     // Catch:{ all -> 0x0027 }
                return
            L_0x000c:
                r1 = 0
                r5.buffer = r1     // Catch:{ all -> 0x0027 }
                monitor-exit(r5)     // Catch:{ all -> 0x0027 }
                io.reactivex.internal.fuseable.SimplePlainQueue r2 = r5.queue
                r2.offer(r0)
                r2 = 1
                r5.done = r2
                boolean r2 = r5.enter()
                if (r2 == 0) goto L_0x0026
                io.reactivex.internal.fuseable.SimplePlainQueue r2 = r5.queue
                org.reactivestreams.Subscriber r3 = r5.downstream
                r4 = 0
                io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r2, r3, r4, r1, r5)
            L_0x0026:
                return
            L_0x0027:
                r0 = move-exception
                monitor-exit(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactUnboundedSubscriber.onComplete():void");
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            requested(n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            DisposableHelper.dispose(this.timer);
        }

        public void run() {
            try {
                U next = (U) ((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null"));
                synchronized (this) {
                    U current = this.buffer;
                    if (current != null) {
                        this.buffer = next;
                        fastPathEmitMax(current, false, this);
                    }
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                cancel();
                this.downstream.onError(e);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U v) {
            this.downstream.onNext(v);
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.timer.get() == DisposableHelper.DISPOSED;
        }
    }

    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Callable<U> bufferSupplier;
        final List<U> buffers = new LinkedList();
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        BufferSkipBoundedSubscriber(Subscriber<? super U> actual, Callable<U> bufferSupplier2, long timespan2, long timeskip2, TimeUnit unit2, Scheduler.Worker w2) {
            super(actual, new MpscLinkedQueue());
            this.bufferSupplier = bufferSupplier2;
            this.timespan = timespan2;
            this.timeskip = timeskip2;
            this.unit = unit2;
            this.w = w2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.List<U extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.buffers.add(collection);
                    this.downstream.onSubscribe(this);
                    s.request(LongCompanionObject.MAX_VALUE);
                    Scheduler.Worker worker = this.w;
                    long j = this.timeskip;
                    worker.schedulePeriodically(this, j, j, this.unit);
                    this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    this.w.dispose();
                    s.cancel();
                    EmptySubscription.error(e, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                for (U b : this.buffers) {
                    b.add(t);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.done = true;
            this.w.dispose();
            clear();
            this.downstream.onError(t);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: io.reactivex.internal.fuseable.SimplePlainQueue */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            List<U> bs;
            synchronized (this) {
                bs = new ArrayList<>(this.buffers);
                this.buffers.clear();
            }
            for (U b : bs) {
                this.queue.offer(b);
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this.w, this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            requested(n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.w.dispose();
            clear();
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            synchronized (this) {
                this.buffers.clear();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.util.List<U extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            if (!this.cancelled) {
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    synchronized (this) {
                        if (!this.cancelled) {
                            this.buffers.add(collection);
                            this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                        }
                    }
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    cancel();
                    this.downstream.onError(e);
                }
            }
        }

        public boolean accept(Subscriber<? super U> a, U v) {
            a.onNext(v);
            return true;
        }

        final class RemoveFromBuffer implements Runnable {
            private final U buffer;

            RemoveFromBuffer(U buffer2) {
                this.buffer = buffer2;
            }

            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.buffers.remove(this.buffer);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(this.buffer, false, bufferSkipBoundedSubscriber.w);
            }
        }
    }

    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        BufferExactBoundedSubscriber(Subscriber<? super U> actual, Callable<U> bufferSupplier2, long timespan2, TimeUnit unit2, int maxSize2, boolean restartOnMaxSize, Scheduler.Worker w2) {
            super(actual, new MpscLinkedQueue());
            this.bufferSupplier = bufferSupplier2;
            this.timespan = timespan2;
            this.unit = unit2;
            this.maxSize = maxSize2;
            this.restartTimerOnMaxSize = restartOnMaxSize;
            this.w = w2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                try {
                    this.buffer = (U) ((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null"));
                    this.downstream.onSubscribe(this);
                    Scheduler.Worker worker = this.w;
                    long j = this.timespan;
                    this.timer = worker.schedulePeriodically(this, j, j, this.unit);
                    s.request(LongCompanionObject.MAX_VALUE);
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    this.w.dispose();
                    s.cancel();
                    EmptySubscription.error(e, this.downstream);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r9.restartTimerOnMaxSize == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r9.timer.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            fastPathOrderedEmitMax(r0, false, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r1 = (U) ((java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(r9.bufferSupplier.call(), "The supplied buffer is null"));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r9.buffer = r1;
            r9.consumerIndex++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
            if (r9.restartTimerOnMaxSize == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
            r2 = r9.w;
            r6 = r9.timespan;
            r9.timer = r2.schedulePeriodically(r9, r6, r6, r9.unit);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r1);
            cancel();
            r9.downstream.onError(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        @Override // org.reactivestreams.Subscriber
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r10) {
            /*
            // Method dump skipped, instructions count: 106
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.onNext(java.lang.Object):void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(t);
            this.w.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            U b;
            synchronized (this) {
                b = this.buffer;
                this.buffer = null;
            }
            if (b != null) {
                this.queue.offer(b);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
                }
                this.w.dispose();
            }
        }

        public boolean accept(Subscriber<? super U> a, U v) {
            a.onNext(v);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            requested(n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            synchronized (this) {
                this.buffer = null;
            }
            this.upstream.cancel();
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        public void run() {
            try {
                U next = (U) ((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null"));
                synchronized (this) {
                    U current = this.buffer;
                    if (current != null) {
                        if (this.producerIndex == this.consumerIndex) {
                            this.buffer = next;
                            fastPathOrderedEmitMax(current, false, this);
                        }
                    }
                }
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                cancel();
                this.downstream.onError(e);
            }
        }
    }
}
