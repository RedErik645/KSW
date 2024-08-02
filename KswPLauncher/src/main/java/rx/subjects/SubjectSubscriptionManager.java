package rx.subjects;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

/* access modifiers changed from: package-private */
public final class SubjectSubscriptionManager<T> extends AtomicReference<State<T>> implements Observable.OnSubscribe<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    boolean active = true;
    volatile Object latest;
    public final NotificationLite<T> nl = NotificationLite.instance();
    Action1<SubjectObserver<T>> onAdded = Actions.empty();
    Action1<SubjectObserver<T>> onStart = Actions.empty();
    Action1<SubjectObserver<T>> onTerminated = Actions.empty();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public SubjectSubscriptionManager() {
        super(State.EMPTY);
    }

    public void call(Subscriber<? super T> child) {
        SubjectObserver<T> bo = new SubjectObserver<>(child);
        addUnsubscriber(child, bo);
        this.onStart.call(bo);
        if (!child.isUnsubscribed() && add(bo) && child.isUnsubscribed()) {
            remove(bo);
        }
    }

    /* access modifiers changed from: package-private */
    public void addUnsubscriber(Subscriber<? super T> child, final SubjectObserver<T> bo) {
        child.add(Subscriptions.create(new Action0() {
            /* class rx.subjects.SubjectSubscriptionManager.AnonymousClass1 */

            @Override // rx.functions.Action0
            public void call() {
                SubjectSubscriptionManager.this.remove(bo);
            }
        }));
    }

    /* access modifiers changed from: package-private */
    public void setLatest(Object value) {
        this.latest = value;
    }

    /* access modifiers changed from: package-private */
    public Object getLatest() {
        return this.latest;
    }

    /* access modifiers changed from: package-private */
    public SubjectObserver<T>[] observers() {
        return ((State) get()).observers;
    }

    /* access modifiers changed from: package-private */
    public boolean add(SubjectObserver<T> o) {
        State oldState;
        do {
            oldState = (State) get();
            if (oldState.terminated) {
                this.onTerminated.call(o);
                return false;
            }
        } while (!compareAndSet(oldState, oldState.add(o)));
        this.onAdded.call(o);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void remove(SubjectObserver<T> o) {
        State oldState;
        State newState;
        do {
            oldState = (State) get();
            if (oldState.terminated || (newState = oldState.remove(o)) == oldState) {
                return;
            }
        } while (!compareAndSet(oldState, newState));
    }

    /* access modifiers changed from: package-private */
    public SubjectObserver<T>[] next(Object n) {
        setLatest(n);
        return ((State) get()).observers;
    }

    /* access modifiers changed from: package-private */
    public SubjectObserver<T>[] terminate(Object n) {
        setLatest(n);
        this.active = false;
        if (((State) get()).terminated) {
            return State.NO_OBSERVERS;
        }
        return ((State) getAndSet(State.TERMINATED)).observers;
    }

    /* access modifiers changed from: protected */
    public static final class State<T> {
        static final State EMPTY;
        static final SubjectObserver[] NO_OBSERVERS;
        static final State TERMINATED;
        final SubjectObserver[] observers;
        final boolean terminated;

        static {
            SubjectObserver[] subjectObserverArr = new SubjectObserver[0];
            NO_OBSERVERS = subjectObserverArr;
            TERMINATED = new State(true, subjectObserverArr);
            EMPTY = new State(false, subjectObserverArr);
        }

        public State(boolean terminated2, SubjectObserver[] observers2) {
            this.terminated = terminated2;
            this.observers = observers2;
        }

        public State add(SubjectObserver o) {
            int n = this.observers.length;
            SubjectObserver[] b = new SubjectObserver[(n + 1)];
            System.arraycopy(this.observers, 0, b, 0, n);
            b[n] = o;
            return new State(this.terminated, b);
        }

        public State remove(SubjectObserver o) {
            SubjectObserver[] a = this.observers;
            int n = a.length;
            if (n == 1 && a[0] == o) {
                return EMPTY;
            }
            if (n == 0) {
                return this;
            }
            SubjectObserver[] b = new SubjectObserver[(n - 1)];
            int j = 0;
            for (SubjectObserver ai : a) {
                if (ai != o) {
                    if (j == n - 1) {
                        return this;
                    }
                    b[j] = ai;
                    j++;
                }
            }
            if (j == 0) {
                return EMPTY;
            }
            if (j < n - 1) {
                SubjectObserver[] c = new SubjectObserver[j];
                System.arraycopy(b, 0, c, 0, j);
                b = c;
            }
            return new State(this.terminated, b);
        }
    }

    /* access modifiers changed from: protected */
    public static final class SubjectObserver<T> implements Observer<T> {
        final Subscriber<? super T> actual;
        volatile boolean caughtUp;
        boolean emitting;
        boolean fastPath;
        boolean first = true;
        private volatile Object index;
        List<Object> queue;

        public SubjectObserver(Subscriber<? super T> actual2) {
            this.actual = actual2;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.actual.onError(e);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.actual.onCompleted();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r1.fastPath = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitNext(java.lang.Object r2, rx.internal.operators.NotificationLite<T> r3) {
            /*
                r1 = this;
                boolean r0 = r1.fastPath
                if (r0 != 0) goto L_0x0026
                monitor-enter(r1)
                r0 = 0
                r1.first = r0     // Catch:{ all -> 0x0023 }
                boolean r0 = r1.emitting     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x001e
                java.util.List<java.lang.Object> r0 = r1.queue     // Catch:{ all -> 0x0023 }
                if (r0 != 0) goto L_0x0017
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0023 }
                r0.<init>()     // Catch:{ all -> 0x0023 }
                r1.queue = r0     // Catch:{ all -> 0x0023 }
            L_0x0017:
                java.util.List<java.lang.Object> r0 = r1.queue     // Catch:{ all -> 0x0023 }
                r0.add(r2)     // Catch:{ all -> 0x0023 }
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                return
            L_0x001e:
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                r0 = 1
                r1.fastPath = r0
                goto L_0x0026
            L_0x0023:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            L_0x0026:
                rx.Subscriber<? super T> r0 = r1.actual
                r3.accept(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.SubjectObserver.emitNext(java.lang.Object, rx.internal.operators.NotificationLite):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            if (r2 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
            emitLoop(null, r2, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitFirst(java.lang.Object r2, rx.internal.operators.NotificationLite<T> r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.first     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r1.emitting     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x000a
                goto L_0x001a
            L_0x000a:
                r0 = 0
                r1.first = r0     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0010
                r0 = 1
            L_0x0010:
                r1.emitting = r0     // Catch:{ all -> 0x001c }
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0019
                r0 = 0
                r1.emitLoop(r0, r2, r3)
            L_0x0019:
                return
            L_0x001a:
                monitor-exit(r1)
                return
            L_0x001c:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.SubjectObserver.emitFirst(java.lang.Object, rx.internal.operators.NotificationLite):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitLoop(java.util.List<java.lang.Object> r6, java.lang.Object r7, rx.internal.operators.NotificationLite<T> r8) {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
            L_0x0002:
                r2 = 0
                if (r6 == 0) goto L_0x0019
                java.util.Iterator r3 = r6.iterator()     // Catch:{ all -> 0x0017 }
            L_0x0009:
                boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0017 }
                if (r4 == 0) goto L_0x0019
                java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0017 }
                r5.accept(r4, r8)     // Catch:{ all -> 0x0017 }
                goto L_0x0009
            L_0x0017:
                r3 = move-exception
                goto L_0x003c
            L_0x0019:
                if (r0 == 0) goto L_0x001f
                r0 = 0
                r5.accept(r7, r8)     // Catch:{ all -> 0x0017 }
            L_0x001f:
                monitor-enter(r5)     // Catch:{ all -> 0x0017 }
                java.util.List<java.lang.Object> r3 = r5.queue     // Catch:{ all -> 0x0039 }
                r6 = r3
                r3 = 0
                r5.queue = r3     // Catch:{ all -> 0x0039 }
                if (r6 != 0) goto L_0x0037
                r5.emitting = r2     // Catch:{ all -> 0x0039 }
                r1 = 1
                monitor-exit(r5)     // Catch:{ all -> 0x0039 }
                if (r1 != 0) goto L_0x0036
                monitor-enter(r5)
                r5.emitting = r2     // Catch:{ all -> 0x0033 }
                monitor-exit(r5)     // Catch:{ all -> 0x0033 }
                goto L_0x0036
            L_0x0033:
                r2 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0033 }
                throw r2
            L_0x0036:
                return
            L_0x0037:
                monitor-exit(r5)
                goto L_0x0002
            L_0x0039:
                r3 = move-exception
                monitor-exit(r5)
                throw r3
            L_0x003c:
                if (r1 != 0) goto L_0x0046
                monitor-enter(r5)
                r5.emitting = r2     // Catch:{ all -> 0x0043 }
                monitor-exit(r5)     // Catch:{ all -> 0x0043 }
                goto L_0x0046
            L_0x0043:
                r2 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0043 }
                throw r2
            L_0x0046:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.SubjectObserver.emitLoop(java.util.List, java.lang.Object, rx.internal.operators.NotificationLite):void");
        }

        /* access modifiers changed from: package-private */
        public void accept(Object n, NotificationLite<T> nl) {
            if (n != null) {
                nl.accept(this.actual, n);
            }
        }

        /* access modifiers changed from: package-private */
        public Observer<? super T> getActual() {
            return this.actual;
        }

        public <I> I index() {
            return (I) this.index;
        }

        public void index(Object newIndex) {
            this.index = newIndex;
        }
    }
}
