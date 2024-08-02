package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OperatorSwitch<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayError;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* access modifiers changed from: package-private */
    public static final class Holder {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(false);

        Holder() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class HolderDelayError {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(true);

        HolderDelayError() {
        }
    }

    public static <T> OperatorSwitch<T> instance(boolean delayError2) {
        return delayError2 ? (OperatorSwitch<T>) HolderDelayError.INSTANCE : (OperatorSwitch<T>) Holder.INSTANCE;
    }

    OperatorSwitch(boolean delayError2) {
        this.delayError = delayError2;
    }

    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> child) {
        SwitchSubscriber<T> sws = new SwitchSubscriber<>(child, this.delayError);
        child.add(sws);
        sws.init();
        return sws;
    }

    /* access modifiers changed from: package-private */
    public static final class SwitchSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final Throwable TERMINAL_ERROR = new Throwable("Terminal error");
        final Subscriber<? super T> child;
        final boolean delayError;
        boolean emitting;
        Throwable error;
        final AtomicLong index;
        boolean innerActive;
        volatile boolean mainDone;
        boolean missed;
        final NotificationLite<T> nl;
        Producer producer;
        final SpscLinkedArrayQueue<Object> queue;
        long requested;
        final SerialSubscription ssub = new SerialSubscription();

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Observable) ((Observable) x0));
        }

        SwitchSubscriber(Subscriber<? super T> child2, boolean delayError2) {
            this.child = child2;
            this.delayError = delayError2;
            this.index = new AtomicLong();
            this.queue = new SpscLinkedArrayQueue<>(RxRingBuffer.SIZE);
            this.nl = NotificationLite.instance();
        }

        /* access modifiers changed from: package-private */
        public void init() {
            this.child.add(this.ssub);
            this.child.add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorSwitch.SwitchSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    SwitchSubscriber.this.clearProducer();
                }
            }));
            this.child.setProducer(new Producer() {
                /* class rx.internal.operators.OperatorSwitch.SwitchSubscriber.AnonymousClass2 */

                @Override // rx.Producer
                public void request(long n) {
                    if (n > 0) {
                        SwitchSubscriber.this.childRequested(n);
                    } else if (n < 0) {
                        throw new IllegalArgumentException("n >= 0 expected but it was " + n);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void clearProducer() {
            synchronized (this) {
                this.producer = null;
            }
        }

        public void onNext(Observable<? extends T> t) {
            Throwable th;
            long id = this.index.incrementAndGet();
            Subscription s = this.ssub.get();
            if (s != null) {
                s.unsubscribe();
            }
            synchronized (this) {
                try {
                    InnerSubscriber<T> inner = new InnerSubscriber<>(id, this);
                    try {
                        this.innerActive = true;
                        this.producer = null;
                        this.ssub.set(inner);
                        t.unsafeSubscribe(inner);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0006, code lost:
            if (r0 == false) goto L_0x000f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0008, code lost:
            r2.mainDone = true;
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
            pluginError(r3);
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onError(java.lang.Throwable r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.updateError(r3)     // Catch:{ all -> 0x0015 }
                monitor-exit(r2)     // Catch:{ all -> 0x0013 }
                if (r0 == 0) goto L_0x000f
                r1 = 1
                r2.mainDone = r1
                r2.drain()
                goto L_0x0012
            L_0x000f:
                r2.pluginError(r3)
            L_0x0012:
                return
            L_0x0013:
                r1 = move-exception
                goto L_0x0017
            L_0x0015:
                r1 = move-exception
                r0 = 0
            L_0x0017:
                monitor-exit(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorSwitch.SwitchSubscriber.onError(java.lang.Throwable):void");
        }

        /* access modifiers changed from: package-private */
        public boolean updateError(Throwable next) {
            Throwable e = this.error;
            if (e == TERMINAL_ERROR) {
                return false;
            }
            if (e == null) {
                this.error = next;
            } else if (e instanceof CompositeException) {
                List<Throwable> list = new ArrayList<>(((CompositeException) e).getExceptions());
                list.add(next);
                this.error = new CompositeException(list);
            } else {
                this.error = new CompositeException(e, next);
            }
            return true;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.mainDone = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void emit(T value, InnerSubscriber<T> inner) {
            synchronized (this) {
                if (this.index.get() == ((InnerSubscriber) inner).id) {
                    this.queue.offer(inner, this.nl.next(value));
                    drain();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            if (r1 == false) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
            pluginError(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void error(java.lang.Throwable r5, long r6) {
            /*
                r4 = this;
                monitor-enter(r4)
                r0 = 0
                java.util.concurrent.atomic.AtomicLong r1 = r4.index     // Catch:{ all -> 0x0023 }
                long r1 = r1.get()     // Catch:{ all -> 0x0023 }
                int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r1 != 0) goto L_0x0016
                boolean r1 = r4.updateError(r5)     // Catch:{ all -> 0x0023 }
                r4.innerActive = r0     // Catch:{ all -> 0x0029 }
                r0 = 0
                r4.producer = r0     // Catch:{ all -> 0x0029 }
                goto L_0x0018
            L_0x0016:
                r0 = 1
                r1 = r0
            L_0x0018:
                monitor-exit(r4)     // Catch:{ all -> 0x0029 }
                if (r1 == 0) goto L_0x001f
                r4.drain()
                goto L_0x0022
            L_0x001f:
                r4.pluginError(r5)
            L_0x0022:
                return
            L_0x0023:
                r1 = move-exception
                r3 = r1
                r1 = r0
                r0 = r3
            L_0x0027:
                monitor-exit(r4)
                throw r0
            L_0x0029:
                r0 = move-exception
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorSwitch.SwitchSubscriber.error(java.lang.Throwable, long):void");
        }

        /* access modifiers changed from: package-private */
        public void complete(long id) {
            synchronized (this) {
                if (this.index.get() == id) {
                    this.innerActive = false;
                    this.producer = null;
                    drain();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void pluginError(Throwable e) {
            RxJavaHooks.onError(e);
        }

        /* access modifiers changed from: package-private */
        public void innerProducer(Producer p, long id) {
            Throwable th;
            synchronized (this) {
                try {
                    if (this.index.get() == id) {
                        long n = this.requested;
                        try {
                            this.producer = p;
                            p.request(n);
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
            if (r0 == null) goto L_0x0011;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
            r0.request(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void childRequested(long r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                rx.Producer r0 = r3.producer     // Catch:{ all -> 0x0017 }
                long r1 = r3.requested     // Catch:{ all -> 0x0015 }
                long r1 = rx.internal.operators.BackpressureUtils.addCap(r1, r4)     // Catch:{ all -> 0x0015 }
                r3.requested = r1     // Catch:{ all -> 0x0015 }
                monitor-exit(r3)     // Catch:{ all -> 0x0015 }
                if (r0 == 0) goto L_0x0011
                r0.request(r4)
            L_0x0011:
                r3.drain()
                return
            L_0x0015:
                r1 = move-exception
                goto L_0x0019
            L_0x0017:
                r1 = move-exception
                r0 = 0
            L_0x0019:
                monitor-exit(r3)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorSwitch.SwitchSubscriber.childRequested(long):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0028, code lost:
            r10 = r20.queue;
            r11 = r20.index;
            r12 = r20.child;
            r13 = r20.mainDone;
            r14 = r0;
            r16 = r0;
            r17 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
            r18 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x003c, code lost:
            if (r18 == r14) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0042, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x0045;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0045, code lost:
            r0 = r10.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0057, code lost:
            if (checkTerminated(r13, r17, r16, r10, r12, r0) == false) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0059, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005a, code lost:
            if (r0 == false) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005d, code lost:
            r2 = r20.nl.getValue(r10.poll());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0077, code lost:
            if (r11.get() != ((rx.internal.operators.OperatorSwitch.InnerSubscriber) ((rx.internal.operators.OperatorSwitch.InnerSubscriber) r10.poll())).id) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0079, code lost:
            r12.onNext(r2);
            r18 = r18 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0083, code lost:
            if (r18 != r14) goto L_0x00a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0089, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x008b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x009e, code lost:
            if (checkTerminated(r20.mainDone, r17, r16, r10, r12, r10.isEmpty()) == false) goto L_0x00a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a0, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a1, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            r0 = r20.requested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ab, code lost:
            if (r0 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ad, code lost:
            r14 = r0 - r18;
            r20.requested = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b2, code lost:
            r14 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b5, code lost:
            if (r20.missed != false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b7, code lost:
            r20.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b9, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ba, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bb, code lost:
            r20.missed = false;
            r13 = r20.mainDone;
            r17 = r20.innerActive;
            r0 = r20.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c7, code lost:
            if (r0 == null) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r0 = rx.internal.operators.OperatorSwitch.SwitchSubscriber.TERMINAL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00cb, code lost:
            if (r0 == r0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cf, code lost:
            if (r20.delayError != false) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d1, code lost:
            r20.error = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00d3, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d4, code lost:
            r16 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00d8, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00dc, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00dd, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00de, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
            // Method dump skipped, instructions count: 233
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorSwitch.SwitchSubscriber.drain():void");
        }

        /* access modifiers changed from: protected */
        public boolean checkTerminated(boolean localMainDone, boolean localInnerActive, Throwable localError, SpscLinkedArrayQueue<Object> localQueue, Subscriber<? super T> localChild, boolean empty) {
            if (this.delayError) {
                if (!localMainDone || localInnerActive || !empty) {
                    return false;
                }
                if (localError != null) {
                    localChild.onError(localError);
                } else {
                    localChild.onCompleted();
                }
                return true;
            } else if (localError != null) {
                localQueue.clear();
                localChild.onError(localError);
                return true;
            } else if (!localMainDone || localInnerActive || !empty) {
                return false;
            } else {
                localChild.onCompleted();
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class InnerSubscriber<T> extends Subscriber<T> {
        private final long id;
        private final SwitchSubscriber<T> parent;

        InnerSubscriber(long id2, SwitchSubscriber<T> parent2) {
            this.id = id2;
            this.parent = parent2;
        }

        @Override // rx.Subscriber
        public void setProducer(Producer p) {
            this.parent.innerProducer(p, this.id);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.parent.emit(t, this);
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.parent.error(e, this.id);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.parent.complete(this.id);
        }
    }
}
