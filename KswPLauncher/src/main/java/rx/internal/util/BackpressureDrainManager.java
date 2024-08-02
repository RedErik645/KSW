package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Producer;

public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    final BackpressureQueueCallback actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback actual2) {
        this.actual = actual2;
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminate(Throwable error) {
        if (!this.terminated) {
            this.exception = error;
            this.terminated = true;
        }
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminateAndDrain(Throwable error) {
        if (!this.terminated) {
            this.exception = error;
            this.terminated = true;
            drain();
        }
    }

    @Override // rx.Producer
    public void request(long n) {
        long r;
        boolean mayDrain;
        long u;
        if (n != 0) {
            do {
                r = get();
                mayDrain = r == 0;
                if (r == LongCompanionObject.MAX_VALUE) {
                    break;
                } else if (n == LongCompanionObject.MAX_VALUE) {
                    u = n;
                    mayDrain = true;
                } else if (r > LongCompanionObject.MAX_VALUE - n) {
                    u = LongCompanionObject.MAX_VALUE;
                } else {
                    u = r + n;
                }
            } while (!compareAndSet(r, u));
            if (mayDrain) {
                drain();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x00c4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r4 = get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r7 = r16.actual;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
        if (r4 > 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        if (r3 == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        if (r3 == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
        if (r7.peek() != null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        r7.complete(r16.exception);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
        if (1 != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0031, code lost:
        monitor-enter(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r16.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        monitor-exit(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x003c, code lost:
        if (r4 != 0) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x003f, code lost:
        r11 = r7.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0043, code lost:
        if (r11 != null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0046, code lost:
        monitor-enter(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r3 = r16.terminated;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x004e, code lost:
        if (r7.peek() == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0050, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0052, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005e, code lost:
        if (get() != kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0060, code lost:
        if (r11 != false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0062, code lost:
        if (r3 != false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0064, code lost:
        r16.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0067, code lost:
        monitor-exit(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0068, code lost:
        if (1 != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x006a, code lost:
        monitor-enter(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r16.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006d, code lost:
        monitor-exit(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0073, code lost:
        r4 = kotlin.jvm.internal.LongCompanionObject.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0079, code lost:
        r4 = addAndGet((long) (-r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0082, code lost:
        if (r4 == 0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0084, code lost:
        if (r11 != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0086, code lost:
        if (r3 == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0088, code lost:
        if (r11 == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x008b, code lost:
        monitor-exit(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008d, code lost:
        r16.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0090, code lost:
        monitor-exit(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0091, code lost:
        if (1 != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0093, code lost:
        monitor-enter(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r16.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0096, code lost:
        monitor-exit(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00a3, code lost:
        if (r7.accept(r11) == false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00a6, code lost:
        if (1 != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00a8, code lost:
        monitor-enter(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r16.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00ab, code lost:
        monitor-exit(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00b1, code lost:
        r4 = r4 - 1;
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00ba, code lost:
        if (0 == 0) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00bc, code lost:
        monitor-enter(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r16.emitting = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
        // Method dump skipped, instructions count: 205
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.BackpressureDrainManager.drain():void");
    }
}
