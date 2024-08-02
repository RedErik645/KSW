package rx.internal.operators;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;

public final class OperatorEagerConcatMap<T, R> implements Observable.Operator<R, T> {
    final int bufferSize;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;
    private final int maxConcurrent;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> mapper2, int bufferSize2, int maxConcurrent2) {
        this.mapper = mapper2;
        this.bufferSize = bufferSize2;
        this.maxConcurrent = maxConcurrent2;
    }

    public Subscriber<? super T> call(Subscriber<? super R> t) {
        EagerOuterSubscriber<T, R> outer = new EagerOuterSubscriber<>(this.mapper, this.bufferSize, this.maxConcurrent, t);
        outer.init();
        return outer;
    }

    /* access modifiers changed from: package-private */
    public static final class EagerOuterProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = -657299606803478389L;
        final EagerOuterSubscriber<?, ?> parent;

        public EagerOuterProducer(EagerOuterSubscriber<?, ?> parent2) {
            this.parent = parent2;
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + n);
            } else if (n > 0) {
                BackpressureUtils.getAndAddRequest(this, n);
                this.parent.drain();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class EagerOuterSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final Func1<? super T, ? extends Observable<? extends R>> mapper;
        private EagerOuterProducer sharedProducer;
        final Queue<EagerInnerSubscriber<R>> subscribers = new LinkedList();
        final AtomicInteger wip = new AtomicInteger();

        public EagerOuterSubscriber(Func1<? super T, ? extends Observable<? extends R>> mapper2, int bufferSize2, int maxConcurrent, Subscriber<? super R> actual2) {
            this.mapper = mapper2;
            this.bufferSize = bufferSize2;
            this.actual = actual2;
            request(maxConcurrent == Integer.MAX_VALUE ? LongCompanionObject.MAX_VALUE : (long) maxConcurrent);
        }

        /* access modifiers changed from: package-private */
        public void init() {
            this.sharedProducer = new EagerOuterProducer(this);
            add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    EagerOuterSubscriber.this.cancelled = true;
                    if (EagerOuterSubscriber.this.wip.getAndIncrement() == 0) {
                        EagerOuterSubscriber.this.cleanup();
                    }
                }
            }));
            this.actual.add(this);
            this.actual.setProducer(this.sharedProducer);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
            if (r0.hasNext() == false) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
            r0.next().unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            r0 = r2.iterator();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void cleanup() {
            /*
                r4 = this;
                java.util.Queue<rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber<R>> r0 = r4.subscribers
                monitor-enter(r0)
                r1 = 0
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0027 }
                java.util.Queue<rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber<R>> r3 = r4.subscribers     // Catch:{ all -> 0x0027 }
                r2.<init>(r3)     // Catch:{ all -> 0x0027 }
                r1 = r2
                java.util.Queue<rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber<R>> r2 = r4.subscribers     // Catch:{ all -> 0x002a }
                r2.clear()     // Catch:{ all -> 0x002a }
                monitor-exit(r0)     // Catch:{ all -> 0x002a }
                java.util.Iterator r0 = r1.iterator()
            L_0x0016:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0026
                java.lang.Object r2 = r0.next()
                rx.Subscription r2 = (rx.Subscription) r2
                r2.unsubscribe()
                goto L_0x0016
            L_0x0026:
                return
            L_0x0027:
                r2 = move-exception
            L_0x0028:
                monitor-exit(r0)
                throw r2
            L_0x002a:
                r2 = move-exception
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.cleanup():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            if (r4.cancelled == false) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r1.unsafeSubscribe(r0);
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            return;
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r5) {
            /*
                r4 = this;
                r0 = 0
                rx.functions.Func1<? super T, ? extends rx.Observable<? extends R>> r1 = r4.mapper     // Catch:{ all -> 0x0035 }
                java.lang.Object r1 = r1.call(r5)     // Catch:{ all -> 0x0035 }
                rx.Observable r1 = (rx.Observable) r1     // Catch:{ all -> 0x0035 }
                boolean r0 = r4.cancelled
                if (r0 == 0) goto L_0x000f
                return
            L_0x000f:
                rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber r0 = new rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber
                int r2 = r4.bufferSize
                r0.<init>(r4, r2)
                r2 = r0
                java.util.Queue<rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber<R>> r3 = r4.subscribers
                monitor-enter(r3)
                boolean r0 = r4.cancelled     // Catch:{ all -> 0x0032 }
                if (r0 == 0) goto L_0x0020
                monitor-exit(r3)     // Catch:{ all -> 0x0032 }
                return
            L_0x0020:
                java.util.Queue<rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber<R>> r0 = r4.subscribers     // Catch:{ all -> 0x0032 }
                r0.add(r2)     // Catch:{ all -> 0x0032 }
                monitor-exit(r3)     // Catch:{ all -> 0x0032 }
                boolean r0 = r4.cancelled
                if (r0 == 0) goto L_0x002b
                return
            L_0x002b:
                r1.unsafeSubscribe(r2)
                r4.drain()
                return
            L_0x0032:
                r0 = move-exception
                monitor-exit(r3)
                throw r0
            L_0x0035:
                r1 = move-exception
                rx.Subscriber<? super R> r2 = r4.actual
                rx.exceptions.Exceptions.throwOrReport(r1, r2, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.onNext(java.lang.Object):void");
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
            if (r0 != null) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
            r9 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
            if (r7 == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
            r10 = r1.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
            if (r10 == null) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
            cleanup();
            r3.onError(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
            if (r9 == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            r3.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0045, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
            if (r9 != false) goto L_0x00fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
            r10 = r2.get();
            r12 = 0;
            r14 = r0.queue;
            r15 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
            r7 = r0.done;
            r8 = r14.peek();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
            if (r8 != null) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
            r16 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005c, code lost:
            r16 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
            if (r7 == false) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0062, code lost:
            r1 = r0.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
            if (r1 == null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0066, code lost:
            cleanup();
            r3.onError(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x006c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x006d, code lost:
            if (r16 == false) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x006f, code lost:
            r20 = r7;
            r1 = r24;
            r7 = r1.subscribers;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0077, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            r1.subscribers.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x007d, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x007e, code lost:
            r0.unsubscribe();
            r15 = true;
            r21 = r3;
            r22 = r4;
            r1.request(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0093, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0095, code lost:
            r21 = r3;
            r22 = r4;
            r20 = r7;
            r1 = r24;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a0, code lost:
            r1 = r24;
            r21 = r3;
            r22 = r4;
            r20 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a8, code lost:
            if (r16 == false) goto L_0x00ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ad, code lost:
            if (r10 != r12) goto L_0x00d6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b4, code lost:
            if (r12 == 0) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00bd, code lost:
            if (r10 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x00c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00bf, code lost:
            rx.internal.operators.BackpressureUtils.produced(r2, r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c2, code lost:
            if (r15 != false) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c4, code lost:
            r0.requestMore(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c7, code lost:
            if (r15 == false) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c9, code lost:
            r3 = r21;
            r4 = r22;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cf, code lost:
            r4 = r21;
            r3 = r22;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d6, code lost:
            r14.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00df, code lost:
            r4 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            r4.onNext(r22.getValue(r8));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00e4, code lost:
            r12 = r12 + 1;
            r4 = r22;
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f2, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f4, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f5, code lost:
            r4 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00f7, code lost:
            rx.exceptions.Exceptions.throwOrReport(r0, r4, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00fa, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00fb, code lost:
            r4 = r3;
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0100, code lost:
            r5 = r1.wip.addAndGet(-r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0107, code lost:
            if (r5 != 0) goto L_0x010a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0109, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x010a, code lost:
            r4 = r3;
            r3 = r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
            // Method dump skipped, instructions count: 290
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.drain():void");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class EagerInnerSubscriber<T> extends Subscriber<T> {
        volatile boolean done;
        Throwable error;
        final NotificationLite<T> nl;
        final EagerOuterSubscriber<?, T> parent;
        final Queue<Object> queue;

        public EagerInnerSubscriber(EagerOuterSubscriber<?, T> parent2, int bufferSize) {
            Queue<Object> q;
            this.parent = parent2;
            if (UnsafeAccess.isUnsafeAvailable()) {
                q = new SpscArrayQueue<>(bufferSize);
            } else {
                q = new SpscAtomicArrayQueue<>(bufferSize);
            }
            this.queue = q;
            this.nl = NotificationLite.instance();
            request((long) bufferSize);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.queue.offer(this.nl.next(t));
            this.parent.drain();
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            this.parent.drain();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            this.parent.drain();
        }

        /* access modifiers changed from: package-private */
        public void requestMore(long n) {
            request(n);
        }
    }
}
