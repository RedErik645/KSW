package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;
import rx.internal.operators.NotificationLite;

public class SerializedObserver<T> implements Observer<T> {
    private final Observer<? super T> actual;
    private boolean emitting;
    private final NotificationLite<T> nl = NotificationLite.instance();
    private FastList queue;
    private volatile boolean terminated;

    static final class FastList {
        Object[] array;
        int size;

        FastList() {
        }

        public void add(Object o) {
            int s = this.size;
            Object[] a = this.array;
            if (a == null) {
                a = new Object[16];
                this.array = a;
            } else if (s == a.length) {
                Object[] array2 = new Object[((s >> 2) + s)];
                System.arraycopy(a, 0, array2, 0, s);
                a = array2;
                this.array = a;
            }
            a[s] = o;
            this.size = s + 1;
        }
    }

    public SerializedObserver(Observer<? super T> s) {
        this.actual = s;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r8.actual.onNext(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1 = r8.queue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0034, code lost:
        if (r1 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r8.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r8.queue = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x003e, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x003f, code lost:
        r2 = r1.array;
        r3 = r2.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0043, code lost:
        if (r4 >= r3) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0045, code lost:
        r5 = r2[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0047, code lost:
        if (r5 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0052, code lost:
        if (r8.nl.accept(r8.actual, r5) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0054, code lost:
        r8.terminated = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0057, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x005b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x005c, code lost:
        r8.terminated = true;
        rx.exceptions.Exceptions.throwIfFatal(r6);
        r8.actual.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r6, r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x006a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x006c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x006e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006f, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0070, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0071, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0073, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0074, code lost:
        r8.terminated = true;
        rx.exceptions.Exceptions.throwOrReport(r1, r8.actual, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x007b, code lost:
        return;
     */
    @Override // rx.Observer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r9) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observers.SerializedObserver.onNext(java.lang.Object):void");
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        Exceptions.throwIfFatal(e);
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.emitting) {
                        FastList list = this.queue;
                        if (list == null) {
                            list = new FastList();
                            this.queue = list;
                        }
                        list.add(this.nl.error(e));
                        return;
                    }
                    this.emitting = true;
                    this.actual.onError(e);
                }
            }
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.emitting) {
                        FastList list = this.queue;
                        if (list == null) {
                            list = new FastList();
                            this.queue = list;
                        }
                        list.add(this.nl.completed());
                        return;
                    }
                    this.emitting = true;
                    this.actual.onCompleted();
                }
            }
        }
    }
}
