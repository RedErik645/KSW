package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.RefCountSubscription;

public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements Observable.OnSubscribe<R> {
    final Observable<T1> left;
    final Func1<? super T1, ? extends Observable<D1>> leftDuration;
    final Func2<? super T1, ? super Observable<T2>, ? extends R> resultSelector;
    final Observable<T2> right;
    final Func1<? super T2, ? extends Observable<D2>> rightDuration;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeGroupJoin(Observable<T1> left2, Observable<T2> right2, Func1<? super T1, ? extends Observable<D1>> leftDuration2, Func1<? super T2, ? extends Observable<D2>> rightDuration2, Func2<? super T1, ? super Observable<T2>, ? extends R> resultSelector2) {
        this.left = left2;
        this.right = right2;
        this.leftDuration = leftDuration2;
        this.rightDuration = rightDuration2;
        this.resultSelector = resultSelector2;
    }

    public void call(Subscriber<? super R> child) {
        OnSubscribeGroupJoin<T1, T2, D1, D2, R>.ResultManager ro = new ResultManager(new SerializedSubscriber(child));
        child.add(ro);
        ro.init();
    }

    /* access modifiers changed from: package-private */
    public final class ResultManager extends HashMap<Integer, Observer<T2>> implements Subscription {
        private static final long serialVersionUID = -3035156013812425335L;
        final RefCountSubscription cancel;
        final CompositeSubscription group;
        boolean leftDone;
        int leftIds;
        boolean rightDone;
        int rightIds;
        final Map<Integer, T2> rightMap = new HashMap();
        final Subscriber<? super R> subscriber;

        public ResultManager(Subscriber<? super R> subscriber2) {
            this.subscriber = subscriber2;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.group = compositeSubscription;
            this.cancel = new RefCountSubscription(compositeSubscription);
        }

        public void init() {
            Subscriber<T1> s1 = new LeftObserver();
            Subscriber<T2> s2 = new RightObserver();
            this.group.add(s1);
            this.group.add(s2);
            OnSubscribeGroupJoin.this.left.unsafeSubscribe(s1);
            OnSubscribeGroupJoin.this.right.unsafeSubscribe(s2);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        /* access modifiers changed from: package-private */
        public Map<Integer, Observer<T2>> leftMap() {
            return this;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
            if (r1.hasNext() == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            r1.next().onError(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
            r3.subscriber.onError(r4);
            r3.cancel.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            r1 = r1.iterator();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void errorAll(java.lang.Throwable r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                r0 = 0
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x003c }
                java.util.Map r2 = r3.leftMap()     // Catch:{ all -> 0x003c }
                java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x003c }
                r1.<init>(r2)     // Catch:{ all -> 0x003c }
                r0 = r1
                java.util.Map r1 = r3.leftMap()     // Catch:{ all -> 0x003f }
                r1.clear()     // Catch:{ all -> 0x003f }
                java.util.Map<java.lang.Integer, T2> r1 = r3.rightMap     // Catch:{ all -> 0x003f }
                r1.clear()     // Catch:{ all -> 0x003f }
                monitor-exit(r3)     // Catch:{ all -> 0x003f }
                java.util.Iterator r1 = r0.iterator()
            L_0x0021:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0031
                java.lang.Object r2 = r1.next()
                rx.Observer r2 = (rx.Observer) r2
                r2.onError(r4)
                goto L_0x0021
            L_0x0031:
                rx.Subscriber<? super R> r1 = r3.subscriber
                r1.onError(r4)
                rx.subscriptions.RefCountSubscription r1 = r3.cancel
                r1.unsubscribe()
                return
            L_0x003c:
                r1 = move-exception
            L_0x003d:
                monitor-exit(r3)
                throw r1
            L_0x003f:
                r1 = move-exception
                goto L_0x003d
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeGroupJoin.ResultManager.errorAll(java.lang.Throwable):void");
        }

        /* access modifiers changed from: package-private */
        public void errorMain(Throwable e) {
            synchronized (this) {
                leftMap().clear();
                this.rightMap.clear();
            }
            this.subscriber.onError(e);
            this.cancel.unsubscribe();
        }

        /* access modifiers changed from: package-private */
        public void complete(List<Observer<T2>> list) {
            if (list != null) {
                for (Observer<T2> o : list) {
                    o.onCompleted();
                }
                this.subscriber.onCompleted();
                this.cancel.unsubscribe();
            }
        }

        /* access modifiers changed from: package-private */
        public final class LeftObserver extends Subscriber<T1> {
            LeftObserver() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
                r2 = rx.Observable.create(new rx.internal.operators.OnSubscribeGroupJoin.WindowObservableFunc(r0, r11.this$1.cancel));
                r5 = new rx.internal.operators.OnSubscribeGroupJoin.ResultManager.LeftDurationObserver(r11.this$1, r5);
                r11.this$1.group.add(r5);
                ((rx.Observable) r11.this$1.this$0.leftDuration.call(r12)).unsafeSubscribe(r5);
                r6 = r11.this$1.this$0.resultSelector.call(r12, r2);
                r7 = r11.this$1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x005a, code lost:
                monitor-enter(r7);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                r9 = new java.util.ArrayList<>(r11.this$1.rightMap.values());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
                monitor-exit(r7);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
                r11.this$1.subscriber.onNext(r6);
                r7 = r9.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
                if (r7.hasNext() == false) goto L_0x0093;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
                r1.onNext(r7.next());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
                r9 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
                monitor-exit(r7);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
                throw r9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0088, code lost:
                r9 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
                return;
             */
            @Override // rx.Observer
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onNext(T1 r12) {
                /*
                // Method dump skipped, instructions count: 148
                */
                throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeGroupJoin.ResultManager.LeftObserver.onNext(java.lang.Object):void");
            }

            @Override // rx.Observer
            public void onCompleted() {
                ArrayList arrayList = null;
                synchronized (ResultManager.this) {
                    ResultManager.this.leftDone = true;
                    if (ResultManager.this.rightDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                ResultManager.this.errorAll(e);
            }
        }

        /* access modifiers changed from: package-private */
        public final class RightObserver extends Subscriber<T2> {
            RightObserver() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
                r2 = new rx.internal.operators.OnSubscribeGroupJoin.ResultManager.RightDurationObserver(r7.this$1, r3);
                r7.this$1.group.add(r2);
                ((rx.Observable) r7.this$1.this$0.rightDuration.call(r8)).unsafeSubscribe(r2);
                r3 = r7.this$1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
                monitor-enter(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                r5 = new java.util.ArrayList<>(r7.this$1.leftMap().values());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
                monitor-exit(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
                r3 = r5.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
                if (r3.hasNext() == false) goto L_0x006e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
                r3.next().onNext(r8);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
                r5 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
                monitor-exit(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
                throw r5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
                r5 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
                return;
             */
            @Override // rx.Observer
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onNext(T2 r8) {
                /*
                // Method dump skipped, instructions count: 111
                */
                throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeGroupJoin.ResultManager.RightObserver.onNext(java.lang.Object):void");
            }

            @Override // rx.Observer
            public void onCompleted() {
                ArrayList arrayList = null;
                synchronized (ResultManager.this) {
                    ResultManager.this.rightDone = true;
                    if (ResultManager.this.leftDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                ResultManager.this.errorAll(e);
            }
        }

        final class LeftDurationObserver extends Subscriber<D1> {
            final int id;
            boolean once = true;

            public LeftDurationObserver(int id2) {
                this.id = id2;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
                if (r2 == null) goto L_0x0024;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
                r2.onCompleted();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
                r4.this$1.group.remove(r4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                return;
             */
            @Override // rx.Observer
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCompleted() {
                /*
                    r4 = this;
                    boolean r0 = r4.once
                    if (r0 == 0) goto L_0x0031
                    r0 = 0
                    r4.once = r0
                    rx.internal.operators.OnSubscribeGroupJoin$ResultManager r0 = rx.internal.operators.OnSubscribeGroupJoin.ResultManager.this
                    monitor-enter(r0)
                    r1 = 0
                    rx.internal.operators.OnSubscribeGroupJoin$ResultManager r2 = rx.internal.operators.OnSubscribeGroupJoin.ResultManager.this     // Catch:{ all -> 0x002c }
                    java.util.Map r2 = r2.leftMap()     // Catch:{ all -> 0x002c }
                    int r3 = r4.id     // Catch:{ all -> 0x002c }
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x002c }
                    java.lang.Object r2 = r2.remove(r3)     // Catch:{ all -> 0x002c }
                    rx.Observer r2 = (rx.Observer) r2     // Catch:{ all -> 0x002c }
                    r1 = r2
                    monitor-exit(r0)     // Catch:{ all -> 0x002f }
                    if (r1 == 0) goto L_0x0024
                    r1.onCompleted()
                L_0x0024:
                    rx.internal.operators.OnSubscribeGroupJoin$ResultManager r0 = rx.internal.operators.OnSubscribeGroupJoin.ResultManager.this
                    rx.subscriptions.CompositeSubscription r0 = r0.group
                    r0.remove(r4)
                    goto L_0x0031
                L_0x002c:
                    r2 = move-exception
                L_0x002d:
                    monitor-exit(r0)
                    throw r2
                L_0x002f:
                    r2 = move-exception
                    goto L_0x002d
                L_0x0031:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeGroupJoin.ResultManager.LeftDurationObserver.onCompleted():void");
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                ResultManager.this.errorMain(e);
            }

            @Override // rx.Observer
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        final class RightDurationObserver extends Subscriber<D2> {
            final int id;
            boolean once = true;

            public RightDurationObserver(int id2) {
                this.id = id2;
            }

            @Override // rx.Observer
            public void onCompleted() {
                if (this.once) {
                    this.once = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.id));
                    }
                    ResultManager.this.group.remove(this);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                ResultManager.this.errorMain(e);
            }

            @Override // rx.Observer
            public void onNext(D2 d2) {
                onCompleted();
            }
        }
    }

    static final class WindowObservableFunc<T> implements Observable.OnSubscribe<T> {
        final RefCountSubscription refCount;
        final Observable<T> underlying;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public WindowObservableFunc(Observable<T> underlying2, RefCountSubscription refCount2) {
            this.refCount = refCount2;
            this.underlying = underlying2;
        }

        public void call(Subscriber<? super T> t1) {
            Subscription ref = this.refCount.get();
            WindowObservableFunc<T>.WindowSubscriber wo = new WindowSubscriber(t1, ref);
            wo.add(ref);
            this.underlying.unsafeSubscribe(wo);
        }

        /* access modifiers changed from: package-private */
        public final class WindowSubscriber extends Subscriber<T> {
            private final Subscription ref;
            final Subscriber<? super T> subscriber;

            public WindowSubscriber(Subscriber<? super T> subscriber2, Subscription ref2) {
                super(subscriber2);
                this.subscriber = subscriber2;
                this.ref = ref2;
            }

            @Override // rx.Observer
            public void onNext(T args) {
                this.subscriber.onNext(args);
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                this.subscriber.onError(e);
                this.ref.unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.subscriber.onCompleted();
                this.ref.unsubscribe();
            }
        }
    }
}
