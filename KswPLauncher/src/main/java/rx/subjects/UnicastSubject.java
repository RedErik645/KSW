package rx.subjects;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.operators.BackpressureUtils;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class UnicastSubject<T> extends Subject<T, T> {
    final State<T> state;

    public static <T> UnicastSubject<T> create() {
        return create(16);
    }

    public static <T> UnicastSubject<T> create(int capacityHint) {
        return new UnicastSubject<>(new State<>(capacityHint, null));
    }

    public static <T> UnicastSubject<T> create(int capacityHint, Action0 onTerminated) {
        return new UnicastSubject<>(new State<>(capacityHint, onTerminated));
    }

    private UnicastSubject(State<T> state2) {
        super(state2);
        this.state = state2;
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.state.onNext(t);
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        this.state.onError(e);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.state.onCompleted();
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.subscriber.get() != null;
    }

    /* access modifiers changed from: package-private */
    public static final class State<T> extends AtomicLong implements Producer, Observer<T>, Observable.OnSubscribe<T>, Subscription {
        private static final long serialVersionUID = -9044104859202255786L;
        volatile boolean caughtUp;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        final NotificationLite<T> nl = NotificationLite.instance();
        final Queue<Object> queue;
        final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference<>();
        final AtomicReference<Action0> terminateOnce;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public State(int capacityHint, Action0 onTerminated) {
            Queue<Object> q;
            this.terminateOnce = onTerminated != null ? new AtomicReference<>(onTerminated) : null;
            if (capacityHint > 1) {
                q = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(capacityHint) : new SpscUnboundedAtomicArrayQueue<>(capacityHint);
            } else {
                q = UnsafeAccess.isUnsafeAvailable() ? new SpscLinkedQueue<>() : new SpscLinkedAtomicQueue<>();
            }
            this.queue = q;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                if (!this.caughtUp) {
                    boolean stillReplay = false;
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(this.nl.next(t));
                            stillReplay = true;
                        }
                    }
                    if (stillReplay) {
                        replay();
                        return;
                    }
                }
                Subscriber<? super T> s = this.subscriber.get();
                try {
                    s.onNext(t);
                } catch (Throwable ex) {
                    Exceptions.throwOrReport(ex, s, t);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (!this.done) {
                doTerminate();
                this.error = e;
                boolean stillReplay = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            stillReplay = false;
                        }
                    }
                    if (stillReplay) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onError(e);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                doTerminate();
                boolean stillReplay = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            stillReplay = false;
                        }
                    }
                    if (stillReplay) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onCompleted();
            }
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            } else if (n > 0) {
                BackpressureUtils.getAndAddRequest(this, n);
                replay();
            } else if (this.done) {
                replay();
            }
        }

        public void call(Subscriber<? super T> subscriber2) {
            if (this.subscriber.compareAndSet(null, subscriber2)) {
                subscriber2.add(this);
                subscriber2.setProducer(this);
                return;
            }
            subscriber2.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
            r3 = r18.queue;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
            r4 = r18.subscriber.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
            if (r4 == null) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
            if (checkTerminated(r18.done, r3.isEmpty(), r4) == false) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            r8 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
            if (r8 != kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
            r10 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            r11 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
            if (r8 == 0) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
            r6 = r18.done;
            r15 = r3.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
            if (r15 != null) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004d, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
            if (checkTerminated(r6, r0, r4) == false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0055, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
            if (r0 == false) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
            r13 = r18.nl.getValue(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            r4.onNext(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0062, code lost:
            r8 = r8 - 1;
            r11 = r11 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x006a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x006b, code lost:
            r3.clear();
            rx.exceptions.Exceptions.throwIfFatal(r0);
            r4.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r0, r13));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x007a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
            if (r10 != false) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007f, code lost:
            if (r11 == 0) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0081, code lost:
            addAndGet(-r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0086, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0087, code lost:
            monitor-enter(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x008a, code lost:
            if (r18.missed != false) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x008c, code lost:
            if (r10 == false) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0092, code lost:
            if (r3.isEmpty() == false) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0094, code lost:
            r18.caughtUp = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0096, code lost:
            r18.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0098, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0099, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009a, code lost:
            r18.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x009c, code lost:
            monitor-exit(r18);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay() {
            /*
            // Method dump skipped, instructions count: 165
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.UnicastSubject.State.replay():void");
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            doTerminate();
            this.done = true;
            synchronized (this) {
                if (!this.emitting) {
                    this.emitting = true;
                    this.queue.clear();
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.done;
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean done2, boolean empty, Subscriber<? super T> s) {
            if (s.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (!done2) {
                return false;
            } else {
                Throwable e = this.error;
                if (e != null) {
                    this.queue.clear();
                    s.onError(e);
                    return true;
                } else if (!empty) {
                    return false;
                } else {
                    s.onCompleted();
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void doTerminate() {
            Action0 a;
            AtomicReference<Action0> ref = this.terminateOnce;
            if (ref != null && (a = ref.get()) != null && ref.compareAndSet(a, null)) {
                a.call();
            }
        }
    }
}
