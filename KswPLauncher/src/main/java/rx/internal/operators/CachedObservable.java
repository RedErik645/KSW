package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

public final class CachedObservable<T> extends Observable<T> {
    private final CacheState<T> state;

    public static <T> CachedObservable<T> from(Observable<? extends T> source) {
        return from(source, 16);
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> source, int capacityHint) {
        if (capacityHint >= 1) {
            CacheState<T> state2 = new CacheState<>(source, capacityHint);
            return new CachedObservable<>(new CachedSubscribe<>(state2), state2);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }

    private CachedObservable(Observable.OnSubscribe<T> onSubscribe, CacheState<T> state2) {
        super(onSubscribe);
        this.state = state2;
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.state.isConnected;
    }

    /* access modifiers changed from: package-private */
    public boolean hasObservers() {
        return this.state.producers.length != 0;
    }

    /* access modifiers changed from: package-private */
    public static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayProducer<?>[] EMPTY = new ReplayProducer[0];
        final SerialSubscription connection = new SerialSubscription();
        volatile boolean isConnected;
        final NotificationLite<T> nl = NotificationLite.instance();
        volatile ReplayProducer<?>[] producers = EMPTY;
        final Observable<? extends T> source;
        boolean sourceDone;

        public CacheState(Observable<? extends T> source2, int capacityHint) {
            super(capacityHint);
            this.source = source2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.internal.operators.CachedObservable$ReplayProducer<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        public void addProducer(ReplayProducer<T> p) {
            synchronized (this.connection) {
                ReplayProducer<?>[] a = this.producers;
                int n = a.length;
                ReplayProducer<?>[] b = new ReplayProducer[(n + 1)];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = p;
                this.producers = b;
            }
        }

        public void removeProducer(ReplayProducer<T> p) {
            synchronized (this.connection) {
                ReplayProducer<?>[] a = this.producers;
                int n = a.length;
                int j = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (a[i].equals(p)) {
                        j = i;
                        break;
                    } else {
                        i++;
                    }
                }
                if (j >= 0) {
                    if (n == 1) {
                        this.producers = EMPTY;
                        return;
                    }
                    ReplayProducer<?>[] b = new ReplayProducer[(n - 1)];
                    System.arraycopy(a, 0, b, 0, j);
                    System.arraycopy(a, j + 1, b, j, (n - j) - 1);
                    this.producers = b;
                }
            }
        }

        public void connect() {
            Subscriber<T> subscriber = new Subscriber<T>() {
                /* class rx.internal.operators.CachedObservable.CacheState.AnonymousClass1 */

                @Override // rx.Observer
                public void onNext(T t) {
                    CacheState.this.onNext(t);
                }

                @Override // rx.Observer
                public void onError(Throwable e) {
                    CacheState.this.onError(e);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    CacheState.this.onCompleted();
                }
            };
            this.connection.set(subscriber);
            this.source.unsafeSubscribe(subscriber);
            this.isConnected = true;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.sourceDone) {
                add(this.nl.next(t));
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(this.nl.error(e));
                this.connection.unsubscribe();
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(this.nl.completed());
                this.connection.unsubscribe();
                dispatch();
            }
        }

        /* access modifiers changed from: package-private */
        public void dispatch() {
            for (ReplayProducer<?> rp : this.producers) {
                rp.replay();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        final CacheState<T> state;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public CachedSubscribe(CacheState<T> state2) {
            this.state = state2;
        }

        public void call(Subscriber<? super T> t) {
            ReplayProducer<T> rp = new ReplayProducer<>(t, this.state);
            this.state.addProducer(rp);
            t.add(rp);
            t.setProducer(rp);
            if (!get() && compareAndSet(false, true)) {
                this.state.connect();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        boolean emitting;
        int index;
        boolean missed;
        final CacheState<T> state;

        public ReplayProducer(Subscriber<? super T> child2, CacheState<T> state2) {
            this.child = child2;
            this.state = state2;
        }

        @Override // rx.Producer
        public void request(long n) {
            long r;
            long u;
            do {
                r = get();
                if (r >= 0) {
                    u = r + n;
                    if (u < 0) {
                        u = LongCompanionObject.MAX_VALUE;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(r, u));
            replay();
        }

        public long produced(long n) {
            return addAndGet(-n);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() >= 0 && getAndSet(-1) >= 0) {
                this.state.removeProducer(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0109, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0116, code lost:
            if (r0.isUnsubscribed() == false) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0119, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x011b, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x011e, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0124, code lost:
            r20.index = r8;
            r20.currentIndexInBuffer = r2;
            r20.currentBuffer = r12;
            produced((long) r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x012f, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x0132, code lost:
            if (r20.missed != false) goto L_0x0143;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x0134, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x0137, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x0138, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x013a, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r0 = r20.state.nl;
            r0 = r20.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x013d, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x0143, code lost:
            r20.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0145, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
            r7 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x014c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x014d, code lost:
            if (0 == 0) goto L_0x014f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x014f, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x0157, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
            if (r7 >= 0) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x002f, code lost:
            r0 = r20.state.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0036, code lost:
            if (r0 == 0) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0038, code lost:
            r0 = r20.currentBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x003a, code lost:
            if (r0 != null) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x003c, code lost:
            r12 = r20.state.head();
            r20.currentBuffer = r12;
            r12 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0047, code lost:
            r12 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0048, code lost:
            r13 = r12.length - 1;
            r0 = r20.index;
            r0 = r20.currentIndexInBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
            if (r7 != 0) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0055, code lost:
            r0 = r12[r0];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005c, code lost:
            if (r0.isCompleted(r0) == false) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005e, code lost:
            r0.onCompleted();
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0065, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0067, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x006a, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0074, code lost:
            if (r0.isError(r0) == false) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0076, code lost:
            r0.onError(r0.getError(r0));
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0081, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0083, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0086, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0090, code lost:
            if (r7 <= 0) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0092, code lost:
            r2 = r0;
            r7 = 0;
            r8 = r0;
            r14 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x009a, code lost:
            if (r8 >= r0) goto L_0x0112;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x009e, code lost:
            if (r14 <= r9) goto L_0x0112;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a4, code lost:
            if (r0.isUnsubscribed() == false) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a7, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a9, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00ac, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00b2, code lost:
            if (r2 != r13) goto L_0x00bd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00b4, code lost:
            r12 = (java.lang.Object[]) r12[r13];
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00bd, code lost:
            r16 = r12[r2];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x00c7, code lost:
            if (r0.accept(r0, r16) == false) goto L_0x00d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x00c9, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x00cd, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x00cf, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x00d2, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x00d8, code lost:
            r2 = r2 + 1;
            r8 = r8 + 1;
            r14 = r14 - 1;
            r7 = r7 + 1;
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x00e7, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x00e8, code lost:
            rx.exceptions.Exceptions.throwIfFatal(r0);
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x00fc, code lost:
            r0.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r0, r0.getValue(r16)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0107, code lost:
            if (1 == 0) goto L_0x0109;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay() {
            /*
            // Method dump skipped, instructions count: 347
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.CachedObservable.ReplayProducer.replay():void");
        }
    }
}
