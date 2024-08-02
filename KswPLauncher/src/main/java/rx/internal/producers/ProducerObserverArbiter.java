package rx.internal.producers;

import java.util.List;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;

public final class ProducerObserverArbiter<T> implements Producer, Observer<T> {
    static final Producer NULL_PRODUCER = new Producer() {
        /* class rx.internal.producers.ProducerObserverArbiter.AnonymousClass1 */

        @Override // rx.Producer
        public void request(long n) {
        }
    };
    final Subscriber<? super T> child;
    Producer currentProducer;
    boolean emitting;
    volatile boolean hasError;
    Producer missedProducer;
    long missedRequested;
    Object missedTerminal;
    List<T> queue;
    long requested;

    public ProducerObserverArbiter(Subscriber<? super T> child2) {
        this.child = child2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r6.child.onNext(r7);
        r2 = r6.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r2 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r6.requested = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        if (1 != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r6.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0043, code lost:
        if (0 == 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0045, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r6.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x004d, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    @Override // rx.Observer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.emitting     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0017
            java.util.List<T> r0 = r6.queue     // Catch:{ all -> 0x004e }
            if (r0 != 0) goto L_0x0012
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x004e }
            r2 = 4
            r1.<init>(r2)     // Catch:{ all -> 0x004e }
            r0 = r1
            r6.queue = r0     // Catch:{ all -> 0x004e }
        L_0x0012:
            r0.add(r7)     // Catch:{ all -> 0x004e }
            monitor-exit(r6)     // Catch:{ all -> 0x004e }
            return
        L_0x0017:
            r0 = 1
            r6.emitting = r0     // Catch:{ all -> 0x004e }
            monitor-exit(r6)     // Catch:{ all -> 0x004e }
            r0 = 0
            r1 = 0
            rx.Subscriber<? super T> r2 = r6.child     // Catch:{ all -> 0x0042 }
            r2.onNext(r7)     // Catch:{ all -> 0x0042 }
            long r2 = r6.requested     // Catch:{ all -> 0x0042 }
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0033
            r4 = 1
            long r4 = r2 - r4
            r6.requested = r4     // Catch:{ all -> 0x0042 }
        L_0x0033:
            r6.emitLoop()     // Catch:{ all -> 0x0042 }
            r0 = 1
            if (r0 != 0) goto L_0x0041
            monitor-enter(r6)
            r6.emitting = r1     // Catch:{ all -> 0x003e }
            monitor-exit(r6)     // Catch:{ all -> 0x003e }
            goto L_0x0041
        L_0x003e:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x003e }
            throw r1
        L_0x0041:
            return
        L_0x0042:
            r2 = move-exception
            if (r0 != 0) goto L_0x004d
            monitor-enter(r6)
            r6.emitting = r1     // Catch:{ all -> 0x004a }
            monitor-exit(r6)     // Catch:{ all -> 0x004a }
            goto L_0x004d
        L_0x004a:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x004a }
            throw r1
        L_0x004d:
            throw r2
        L_0x004e:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.onNext(java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        if (r0 == false) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        r3.child.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r3.hasError = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    @Override // rx.Observer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            boolean r1 = r3.emitting     // Catch:{ all -> 0x001a }
            r2 = 1
            if (r1 == 0) goto L_0x000b
            r3.missedTerminal = r4     // Catch:{ all -> 0x001a }
            r0 = 0
            goto L_0x000e
        L_0x000b:
            r3.emitting = r2     // Catch:{ all -> 0x001a }
            r0 = 1
        L_0x000e:
            monitor-exit(r3)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0017
            rx.Subscriber<? super T> r1 = r3.child
            r1.onError(r4)
            goto L_0x0019
        L_0x0017:
            r3.hasError = r2
        L_0x0019:
            return
        L_0x001a:
            r1 = move-exception
        L_0x001b:
            monitor-exit(r3)
            throw r1
        L_0x001d:
            r1 = move-exception
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.onError(java.lang.Throwable):void");
    }

    @Override // rx.Observer
    public void onCompleted() {
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = true;
                return;
            }
            this.emitting = true;
            this.child.onCompleted();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        r2 = r9.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r7 = r9.requested + r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        if (r7 >= 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r7 = kotlin.jvm.internal.LongCompanionObject.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        r9.requested = r7;
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (1 != 0) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r9.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0037, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003c, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x003e, code lost:
        r2.request(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0042, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0043, code lost:
        if (0 == 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0045, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r9.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x004d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    @Override // rx.Producer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request(long r10) {
        /*
            r9 = this;
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0051
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            monitor-enter(r9)
            boolean r2 = r9.emitting     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0017
            long r0 = r9.missedRequested     // Catch:{ all -> 0x004e }
            long r0 = r0 + r10
            r9.missedRequested = r0     // Catch:{ all -> 0x004e }
            monitor-exit(r9)     // Catch:{ all -> 0x004e }
            return
        L_0x0017:
            r2 = 1
            r9.emitting = r2     // Catch:{ all -> 0x004e }
            monitor-exit(r9)     // Catch:{ all -> 0x004e }
            rx.Producer r2 = r9.currentProducer
            r3 = 0
            r4 = 0
            long r5 = r9.requested     // Catch:{ all -> 0x0042 }
            long r7 = r5 + r10
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x002c
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x002c:
            r9.requested = r7     // Catch:{ all -> 0x0042 }
            r9.emitLoop()     // Catch:{ all -> 0x0042 }
            r0 = 1
            if (r0 != 0) goto L_0x003c
            monitor-enter(r9)
            r9.emitting = r4     // Catch:{ all -> 0x0039 }
            monitor-exit(r9)     // Catch:{ all -> 0x0039 }
            goto L_0x003c
        L_0x0039:
            r1 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0039 }
            throw r1
        L_0x003c:
            if (r2 == 0) goto L_0x0041
            r2.request(r10)
        L_0x0041:
            return
        L_0x0042:
            r0 = move-exception
            if (r3 != 0) goto L_0x004d
            monitor-enter(r9)
            r9.emitting = r4     // Catch:{ all -> 0x004a }
            monitor-exit(r9)     // Catch:{ all -> 0x004a }
            goto L_0x004d
        L_0x004a:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004a }
            throw r0
        L_0x004d:
            throw r0
        L_0x004e:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L_0x0051:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "n >= 0 required"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.request(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        r5.currentProducer = r6;
        r1 = r5.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001d, code lost:
        if (1 != 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r5.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0022, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0027, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x002d, code lost:
        if (r1 == 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x002f, code lost:
        r6.request(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0033, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0034, code lost:
        if (0 == 0) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0036, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r5.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x003e, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProducer(rx.Producer r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.emitting     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x000f
            if (r6 == 0) goto L_0x0009
            r0 = r6
            goto L_0x000b
        L_0x0009:
            rx.Producer r0 = rx.internal.producers.ProducerObserverArbiter.NULL_PRODUCER     // Catch:{ all -> 0x003f }
        L_0x000b:
            r5.missedProducer = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x000f:
            r0 = 1
            r5.emitting = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            r0 = 0
            r5.currentProducer = r6
            long r1 = r5.requested
            r3 = 0
            r5.emitLoop()     // Catch:{ all -> 0x0033 }
            r0 = 1
            if (r0 != 0) goto L_0x0027
            monitor-enter(r5)
            r5.emitting = r3     // Catch:{ all -> 0x0024 }
            monitor-exit(r5)     // Catch:{ all -> 0x0024 }
            goto L_0x0027
        L_0x0024:
            r3 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0024 }
            throw r3
        L_0x0027:
            if (r6 == 0) goto L_0x0032
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0032
            r6.request(r1)
        L_0x0032:
            return
        L_0x0033:
            r4 = move-exception
            if (r0 != 0) goto L_0x003e
            monitor-enter(r5)
            r5.emitting = r3     // Catch:{ all -> 0x003b }
            monitor-exit(r5)     // Catch:{ all -> 0x003b }
            goto L_0x003e
        L_0x003b:
            r3 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003b }
            throw r3
        L_0x003e:
            throw r4
        L_0x003f:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.setProducer(rx.Producer):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        if (r14 == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0039, code lost:
        if (r8 == r6) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        if (r3 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003d, code lost:
        r3.request(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0047, code lost:
        if (r0.isEmpty() == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0049, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004a, code lost:
        if (r0 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004e, code lost:
        if (r0 == java.lang.Boolean.TRUE) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
        r2.onError((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0057, code lost:
        if (r15 == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0059, code lost:
        r2.onCompleted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x005d, code lost:
        r16 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005f, code lost:
        if (r0 == null) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0061, code lost:
        r18 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0069, code lost:
        if (r18.hasNext() == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x006b, code lost:
        r5 = r18.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0073, code lost:
        if (r2.isUnsubscribed() == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0075, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0078, code lost:
        if (r26.hasError == false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x007a, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r2.onNext(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0082, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0083, code lost:
        rx.exceptions.Exceptions.throwOrReport(r0, r2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0088, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0089, code lost:
        r16 = 0 + ((long) r0.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0090, code lost:
        r5 = r26.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0099, code lost:
        if (r5 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x009f, code lost:
        if (r12 == 0) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a1, code lost:
        r24 = r5 + r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00a5, code lost:
        if (r24 >= 0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a7, code lost:
        r24 = kotlin.jvm.internal.LongCompanionObject.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ac, code lost:
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00b2, code lost:
        if (r16 == 0) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00b6, code lost:
        if (r5 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b8, code lost:
        r22 = r5 - r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00bc, code lost:
        if (r22 < 0) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00be, code lost:
        r5 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00c8, code lost:
        throw new java.lang.IllegalStateException("More produced than requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00c9, code lost:
        r26.requested = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00cb, code lost:
        if (r0 == null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00cf, code lost:
        if (r0 != rx.internal.producers.ProducerObserverArbiter.NULL_PRODUCER) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00d1, code lost:
        r0 = null;
        r26.currentProducer = null;
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00d7, code lost:
        r0 = null;
        r26.currentProducer = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00de, code lost:
        if (r5 == 0) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00e0, code lost:
        r3 = r0;
        r8 = rx.internal.operators.BackpressureUtils.addCap(r8, r5);
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00e9, code lost:
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00ec, code lost:
        r0 = null;
        r7 = r26.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00ef, code lost:
        if (r7 == null) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00f1, code lost:
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00f5, code lost:
        if (r12 == 0) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00f7, code lost:
        r8 = rx.internal.operators.BackpressureUtils.addCap(r8, r12);
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00fd, code lost:
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00ff, code lost:
        r5 = r0;
        r6 = r18;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void emitLoop() {
        /*
        // Method dump skipped, instructions count: 273
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.emitLoop():void");
    }
}
