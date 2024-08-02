package rx.internal.operators;

import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.CompositeSubscription;

public final class OperatorWindowWithStartEndObservable<T, U, V> implements Observable.Operator<Observable<T>, T> {
    final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
    final Observable<? extends U> windowOpenings;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorWindowWithStartEndObservable(Observable<? extends U> windowOpenings2, Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector2) {
        this.windowOpenings = windowOpenings2;
        this.windowClosingSelector = windowClosingSelector2;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> child) {
        CompositeSubscription csub = new CompositeSubscription();
        child.add(csub);
        final OperatorWindowWithStartEndObservable<T, U, V>.SourceSubscriber sub = new SourceSubscriber(child, csub);
        Subscriber<U> open = new Subscriber<U>() {
            /* class rx.internal.operators.OperatorWindowWithStartEndObservable.AnonymousClass1 */

            @Override // rx.Subscriber
            public void onStart() {
                request(LongCompanionObject.MAX_VALUE);
            }

            @Override // rx.Observer
            public void onNext(U t) {
                sub.beginWindow(t);
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                sub.onError(e);
            }

            @Override // rx.Observer
            public void onCompleted() {
                sub.onCompleted();
            }
        };
        csub.add(sub);
        csub.add(open);
        this.windowOpenings.unsafeSubscribe(open);
        return sub;
    }

    /* access modifiers changed from: package-private */
    public static final class SerializedSubject<T> {
        final Observer<T> consumer;
        final Observable<T> producer;

        public SerializedSubject(Observer<T> consumer2, Observable<T> producer2) {
            this.consumer = new SerializedObserver(consumer2);
            this.producer = producer2;
        }
    }

    /* access modifiers changed from: package-private */
    public final class SourceSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<SerializedSubject<T>> chunks = new LinkedList();
        final CompositeSubscription csub;
        boolean done;
        final Object guard = new Object();

        public SourceSubscriber(Subscriber<? super Observable<T>> child2, CompositeSubscription csub2) {
            this.child = new SerializedSubscriber(child2);
            this.csub = csub2;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0 = r2.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
            if (r0.hasNext() == false) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
            r0.next().consumer.onNext(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            return;
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r5) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.guard
                monitor-enter(r0)
                r1 = 0
                boolean r2 = r4.done     // Catch:{ all -> 0x002a }
                if (r2 == 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x002a }
                return
            L_0x000a:
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x002a }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r3 = r4.chunks     // Catch:{ all -> 0x002a }
                r2.<init>(r3)     // Catch:{ all -> 0x002a }
                r1 = r2
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                java.util.Iterator r0 = r1.iterator()
            L_0x0017:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0029
                java.lang.Object r2 = r0.next()
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r2 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r2
                rx.Observer<T> r3 = r2.consumer
                r3.onNext(r5)
                goto L_0x0017
            L_0x0029:
                return
            L_0x002a:
                r2 = move-exception
            L_0x002b:
                monitor-exit(r0)
                throw r2
            L_0x002d:
                r2 = move-exception
                goto L_0x002b
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.onNext(java.lang.Object):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
            r0 = r2.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            if (r0.hasNext() == false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            r0.next().consumer.onError(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
            r4.child.onError(r5);
            r4.csub.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
            return;
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onError(java.lang.Throwable r5) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.guard     // Catch:{ all -> 0x0047 }
                monitor-enter(r0)     // Catch:{ all -> 0x0047 }
                r1 = 0
                boolean r2 = r4.done     // Catch:{ all -> 0x0042 }
                if (r2 == 0) goto L_0x000f
                monitor-exit(r0)     // Catch:{ all -> 0x0042 }
                rx.subscriptions.CompositeSubscription r0 = r4.csub
                r0.unsubscribe()
                return
            L_0x000f:
                r2 = 1
                r4.done = r2
                java.util.ArrayList r2 = new java.util.ArrayList
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r3 = r4.chunks
                r2.<init>(r3)
                r1 = r2
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r4.chunks     // Catch:{ all -> 0x0045 }
                r2.clear()     // Catch:{ all -> 0x0045 }
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                java.util.Iterator r0 = r1.iterator()
            L_0x0024:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0036
                java.lang.Object r2 = r0.next()
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r2 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r2
                rx.Observer<T> r3 = r2.consumer
                r3.onError(r5)
                goto L_0x0024
            L_0x0036:
                rx.Subscriber<? super rx.Observable<T>> r0 = r4.child
                r0.onError(r5)
                rx.subscriptions.CompositeSubscription r0 = r4.csub
                r0.unsubscribe()
                return
            L_0x0042:
                r2 = move-exception
            L_0x0043:
                monitor-exit(r0)
                throw r2
            L_0x0045:
                r2 = move-exception
                goto L_0x0043
            L_0x0047:
                r0 = move-exception
                rx.subscriptions.CompositeSubscription r1 = r4.csub
                r1.unsubscribe()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.onError(java.lang.Throwable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
            r0 = r2.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            if (r0.hasNext() == false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            r0.next().consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
            r4.child.onCompleted();
            r4.csub.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
            return;
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCompleted() {
            /*
                r4 = this;
                java.lang.Object r0 = r4.guard     // Catch:{ all -> 0x0047 }
                monitor-enter(r0)     // Catch:{ all -> 0x0047 }
                r1 = 0
                boolean r2 = r4.done     // Catch:{ all -> 0x0042 }
                if (r2 == 0) goto L_0x000f
                monitor-exit(r0)     // Catch:{ all -> 0x0042 }
                rx.subscriptions.CompositeSubscription r0 = r4.csub
                r0.unsubscribe()
                return
            L_0x000f:
                r2 = 1
                r4.done = r2
                java.util.ArrayList r2 = new java.util.ArrayList
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r3 = r4.chunks
                r2.<init>(r3)
                r1 = r2
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r4.chunks     // Catch:{ all -> 0x0045 }
                r2.clear()     // Catch:{ all -> 0x0045 }
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                java.util.Iterator r0 = r1.iterator()
            L_0x0024:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0036
                java.lang.Object r2 = r0.next()
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r2 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r2
                rx.Observer<T> r3 = r2.consumer
                r3.onCompleted()
                goto L_0x0024
            L_0x0036:
                rx.Subscriber<? super rx.Observable<T>> r0 = r4.child
                r0.onCompleted()
                rx.subscriptions.CompositeSubscription r0 = r4.csub
                r0.unsubscribe()
                return
            L_0x0042:
                r2 = move-exception
            L_0x0043:
                monitor-exit(r0)
                throw r2
            L_0x0045:
                r2 = move-exception
                goto L_0x0043
            L_0x0047:
                r0 = move-exception
                rx.subscriptions.CompositeSubscription r1 = r4.csub
                r1.unsubscribe()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.onCompleted():void");
        }

        /* access modifiers changed from: package-private */
        public void beginWindow(U token) {
            final SerializedSubject<T> s = createSerializedSubject();
            synchronized (this.guard) {
                if (!this.done) {
                    this.chunks.add(s);
                    this.child.onNext(s.producer);
                    try {
                        Observable<? extends V> end = (Observable) OperatorWindowWithStartEndObservable.this.windowClosingSelector.call(token);
                        Subscriber<V> v = new Subscriber<V>() {
                            /* class rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.AnonymousClass1 */
                            boolean once = true;

                            @Override // rx.Observer
                            public void onNext(V v) {
                                onCompleted();
                            }

                            @Override // rx.Observer
                            public void onError(Throwable e) {
                                SourceSubscriber.this.onError(e);
                            }

                            @Override // rx.Observer
                            public void onCompleted() {
                                if (this.once) {
                                    this.once = false;
                                    SourceSubscriber.this.endWindow(s);
                                    SourceSubscriber.this.csub.remove(this);
                                }
                            }
                        };
                        this.csub.add(v);
                        end.unsafeSubscribe(v);
                    } catch (Throwable e) {
                        onError(e);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r5.consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void endWindow(rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject<T> r5) {
            /*
                r4 = this;
                r0 = 0
                java.lang.Object r1 = r4.guard
                monitor-enter(r1)
                boolean r2 = r4.done     // Catch:{ all -> 0x002d }
                if (r2 == 0) goto L_0x000a
                monitor-exit(r1)     // Catch:{ all -> 0x002d }
                return
            L_0x000a:
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r4.chunks     // Catch:{ all -> 0x002d }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x002d }
            L_0x0010:
                boolean r3 = r2.hasNext()     // Catch:{ all -> 0x002d }
                if (r3 == 0) goto L_0x0024
                java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x002d }
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r3 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r3     // Catch:{ all -> 0x002d }
                if (r3 != r5) goto L_0x0023
                r0 = 1
                r2.remove()     // Catch:{ all -> 0x002d }
                goto L_0x0024
            L_0x0023:
                goto L_0x0010
            L_0x0024:
                monitor-exit(r1)     // Catch:{ all -> 0x002d }
                if (r0 == 0) goto L_0x002c
                rx.Observer<T> r1 = r5.consumer
                r1.onCompleted()
            L_0x002c:
                return
            L_0x002d:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.endWindow(rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject):void");
        }

        /* access modifiers changed from: package-private */
        public SerializedSubject<T> createSerializedSubject() {
            UnicastSubject<T> bus = UnicastSubject.create();
            return new SerializedSubject<>(bus, bus);
        }
    }
}