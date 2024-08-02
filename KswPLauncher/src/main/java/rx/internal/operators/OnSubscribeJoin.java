package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;

public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements Observable.OnSubscribe<R> {
    final Observable<TLeft> left;
    final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
    final Func2<TLeft, TRight, R> resultSelector;
    final Observable<TRight> right;
    final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeJoin(Observable<TLeft> left2, Observable<TRight> right2, Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector2, Func1<TRight, Observable<TRightDuration>> rightDurationSelector2, Func2<TLeft, TRight, R> resultSelector2) {
        this.left = left2;
        this.right = right2;
        this.leftDurationSelector = leftDurationSelector2;
        this.rightDurationSelector = rightDurationSelector2;
        this.resultSelector = resultSelector2;
    }

    public void call(Subscriber<? super R> t1) {
        new ResultSink(new SerializedSubscriber(t1)).run();
    }

    /* access modifiers changed from: package-private */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        private static final long serialVersionUID = 3491669543549085380L;
        final CompositeSubscription group = new CompositeSubscription();
        boolean leftDone;
        int leftId;
        boolean rightDone;
        int rightId;
        final Map<Integer, TRight> rightMap = new HashMap();
        final Subscriber<? super R> subscriber;

        public ResultSink(Subscriber<? super R> subscriber2) {
            this.subscriber = subscriber2;
        }

        /* access modifiers changed from: package-private */
        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        public void run() {
            this.subscriber.add(this.group);
            Subscriber<TLeft> s1 = new LeftSubscriber();
            Subscriber<TRight> s2 = new RightSubscriber();
            this.group.add(s1);
            this.group.add(s2);
            OnSubscribeJoin.this.left.unsafeSubscribe(s1);
            OnSubscribeJoin.this.right.unsafeSubscribe(s2);
        }

        /* access modifiers changed from: package-private */
        public final class LeftSubscriber extends Subscriber<TLeft> {
            LeftSubscriber() {
            }

            /* access modifiers changed from: protected */
            public void expire(int id, Subscription resource) {
                boolean complete = false;
                synchronized (ResultSink.this) {
                    if (ResultSink.this.leftMap().remove(Integer.valueOf(id)) != null && ResultSink.this.leftMap().isEmpty() && ResultSink.this.leftDone) {
                        complete = true;
                    }
                }
                if (complete) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(resource);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: rx.functions.Func2<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
                r3 = r9.this$1.this$0.leftDurationSelector.call(r10);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                r3 = new rx.internal.operators.OnSubscribeJoin.ResultSink.LeftSubscriber.LeftDurationSubscriber(r9, r3);
                r9.this$1.group.add(r3);
                r3.unsafeSubscribe(r3);
                r4 = new java.util.ArrayList<>();
                r5 = r9.this$1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
                monitor-enter(r5);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
                r6 = r9.this$1.rightMap.entrySet().iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
                if (r6.hasNext() == false) goto L_0x006f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
                r7 = r6.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
                if (r7.getKey().intValue() >= r1) goto L_0x006e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
                r4.add(r7.getValue());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x006f, code lost:
                monitor-exit(r5);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0070, code lost:
                r5 = r4.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
                if (r5.hasNext() == false) goto L_0x009a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
                r9.this$1.subscriber.onNext(r9.this$1.this$0.resultSelector.call(r10, r5.next()));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x0094, code lost:
                r3 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x0096, code lost:
                r3 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
                rx.exceptions.Exceptions.throwOrReport(r3, r9);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
                return;
             */
            @Override // rx.Observer
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onNext(TLeft r10) {
                /*
                // Method dump skipped, instructions count: 163
                */
                throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeJoin.ResultSink.LeftSubscriber.onNext(java.lang.Object):void");
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                ResultSink.this.subscriber.onError(e);
                ResultSink.this.subscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                boolean complete = false;
                synchronized (ResultSink.this) {
                    ResultSink.this.leftDone = true;
                    if (ResultSink.this.rightDone || ResultSink.this.leftMap().isEmpty()) {
                        complete = true;
                    }
                }
                if (complete) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(this);
            }

            final class LeftDurationSubscriber extends Subscriber<TLeftDuration> {
                final int id;
                boolean once = true;

                public LeftDurationSubscriber(int id2) {
                    this.id = id2;
                }

                @Override // rx.Observer
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }

                @Override // rx.Observer
                public void onError(Throwable e) {
                    LeftSubscriber.this.onError(e);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        LeftSubscriber.this.expire(this.id, this);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final class RightSubscriber extends Subscriber<TRight> {
            RightSubscriber() {
            }

            /* access modifiers changed from: package-private */
            public void expire(int id, Subscription resource) {
                boolean complete = false;
                synchronized (ResultSink.this) {
                    if (ResultSink.this.rightMap.remove(Integer.valueOf(id)) != null && ResultSink.this.rightMap.isEmpty() && ResultSink.this.rightDone) {
                        complete = true;
                    }
                }
                if (complete) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(resource);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r8v3, resolved type: rx.functions.Func2<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
                r10.this$1.group.add(new rx.subscriptions.SerialSubscription());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                r4 = r10.this$1.this$0.rightDurationSelector.call(r11);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                r4 = new rx.internal.operators.OnSubscribeJoin.ResultSink.RightSubscriber.RightDurationSubscriber(r10, r3);
                r10.this$1.group.add(r4);
                r4.unsafeSubscribe(r4);
                r5 = new java.util.ArrayList<>();
                r6 = r10.this$1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
                monitor-enter(r6);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                r7 = r10.this$1.leftMap().entrySet().iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
                if (r7.hasNext() == false) goto L_0x007c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
                r8 = r7.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
                if (r8.getKey().intValue() >= r1) goto L_0x007b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
                r5.add(r8.getValue());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
                monitor-exit(r6);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
                r6 = r5.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
                if (r6.hasNext() == false) goto L_0x00a7;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
                r10.this$1.subscriber.onNext(r10.this$1.this$0.resultSelector.call(r6.next(), r11));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
                r4 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a3, code lost:
                r4 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a4, code lost:
                rx.exceptions.Exceptions.throwOrReport(r4, r10);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
                return;
             */
            @Override // rx.Observer
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onNext(TRight r11) {
                /*
                // Method dump skipped, instructions count: 176
                */
                throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeJoin.ResultSink.RightSubscriber.onNext(java.lang.Object):void");
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                ResultSink.this.subscriber.onError(e);
                ResultSink.this.subscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                boolean complete = false;
                synchronized (ResultSink.this) {
                    ResultSink.this.rightDone = true;
                    if (ResultSink.this.leftDone || ResultSink.this.rightMap.isEmpty()) {
                        complete = true;
                    }
                }
                if (complete) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(this);
            }

            final class RightDurationSubscriber extends Subscriber<TRightDuration> {
                final int id;
                boolean once = true;

                public RightDurationSubscriber(int id2) {
                    this.id = id2;
                }

                @Override // rx.Observer
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }

                @Override // rx.Observer
                public void onError(Throwable e) {
                    RightSubscriber.this.onError(e);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        RightSubscriber.this.expire(this.id, this);
                    }
                }
            }
        }
    }
}
