package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

public final class OperatorWindowWithTime<T> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    static final NotificationLite<Object> NL = NotificationLite.instance();
    final Scheduler scheduler;
    final int size;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorWindowWithTime(long timespan2, long timeshift2, TimeUnit unit2, int size2, Scheduler scheduler2) {
        this.timespan = timespan2;
        this.timeshift = timeshift2;
        this.unit = unit2;
        this.size = size2;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> child) {
        Scheduler.Worker worker = this.scheduler.createWorker();
        if (this.timespan == this.timeshift) {
            OperatorWindowWithTime<T>.ExactSubscriber s = new ExactSubscriber(child, worker);
            s.add(worker);
            s.scheduleExact();
            return s;
        }
        OperatorWindowWithTime<T>.InexactSubscriber s2 = new InexactSubscriber(child, worker);
        s2.add(worker);
        s2.startNewChunk();
        s2.scheduleChunk();
        return s2;
    }

    /* access modifiers changed from: package-private */
    public static final class State<T> {
        static final State<Object> EMPTY = new State<>(null, null, 0);
        final Observer<T> consumer;
        final int count;
        final Observable<T> producer;

        public State(Observer<T> consumer2, Observable<T> producer2, int count2) {
            this.consumer = consumer2;
            this.producer = producer2;
            this.count = count2;
        }

        public State<T> next() {
            return new State<>(this.consumer, this.producer, this.count + 1);
        }

        public State<T> create(Observer<T> consumer2, Observable<T> producer2) {
            return new State<>(consumer2, producer2, 0);
        }

        public State<T> clear() {
            return empty();
        }

        public static <T> State<T> empty() {
            return (State<T>) EMPTY;
        }
    }

    /* access modifiers changed from: package-private */
    public final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        boolean emitting;
        final Object guard = new Object();
        List<Object> queue;
        volatile State<T> state = State.empty();
        final Scheduler.Worker worker;

        public ExactSubscriber(Subscriber<? super Observable<T>> child2, Scheduler.Worker worker2) {
            this.child = new SerializedSubscriber(child2);
            this.worker = worker2;
            child2.add(Subscriptions.create(new Action0(OperatorWindowWithTime.this) {
                /* class rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    if (ExactSubscriber.this.state.consumer == null) {
                        ExactSubscriber.this.unsubscribe();
                    }
                }
            }));
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            if (emitValue(r6) != false) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
            if (0 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
            r2 = r5.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0034, code lost:
            r4 = r5.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0036, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r3 = r5.queue;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0039, code lost:
            if (r3 != null) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x003e, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x003f, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0041, code lost:
            r2 = r5.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0043, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0046, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x004c, code lost:
            r5.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x004e, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0053, code lost:
            if (drain(r3) != false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0055, code lost:
            if (0 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0057, code lost:
            r2 = r5.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0059, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x005c, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0063, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0064, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0065, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0066, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0068, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0069, code lost:
            if (0 == 0) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x006d, code lost:
            monitor-enter(r5.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0075, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            return;
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r6) {
            /*
            // Method dump skipped, instructions count: 121
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.onNext(java.lang.Object):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: rx.internal.operators.OperatorWindowWithTime$ExactSubscriber */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public boolean drain(List<Object> queue2) {
            if (queue2 == null) {
                return true;
            }
            Iterator i$ = queue2.iterator();
            while (true) {
                if (!i$.hasNext()) {
                    break;
                }
                Object o = i$.next();
                if (o == OperatorWindowWithTime.NEXT_SUBJECT) {
                    if (!replaceSubject()) {
                        return false;
                    }
                } else if (OperatorWindowWithTime.NL.isError(o)) {
                    error(OperatorWindowWithTime.NL.getError(o));
                    break;
                } else if (OperatorWindowWithTime.NL.isCompleted(o)) {
                    complete();
                    break;
                } else if (!emitValue(o)) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean replaceSubject() {
            Observer<T> s = this.state.consumer;
            if (s != null) {
                s.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.state = this.state.clear();
                unsubscribe();
                return false;
            }
            UnicastSubject<T> bus = UnicastSubject.create();
            this.state = this.state.create(bus, bus);
            this.child.onNext(bus);
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean emitValue(T t) {
            State<T> s;
            State<T> s2 = this.state;
            if (s2.consumer == null) {
                if (!replaceSubject()) {
                    return false;
                }
                s2 = this.state;
            }
            s2.consumer.onNext(t);
            if (s2.count == OperatorWindowWithTime.this.size - 1) {
                s2.consumer.onCompleted();
                s = s2.clear();
            } else {
                s = s2.next();
            }
            this.state = s;
            return true;
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(OperatorWindowWithTime.NL.error(e));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(e);
            }
        }

        /* access modifiers changed from: package-private */
        public void error(Throwable e) {
            Observer<T> s = this.state.consumer;
            this.state = this.state.clear();
            if (s != null) {
                s.onError(e);
            }
            this.child.onError(e);
            unsubscribe();
        }

        /* access modifiers changed from: package-private */
        public void complete() {
            Observer<T> s = this.state.consumer;
            this.state = this.state.clear();
            if (s != null) {
                s.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        @Override // rx.Observer
        public void onCompleted() {
            Throwable th;
            synchronized (this.guard) {
                try {
                    if (this.emitting) {
                        if (this.queue == null) {
                            this.queue = new ArrayList();
                        }
                        this.queue.add(OperatorWindowWithTime.NL.completed());
                        return;
                    }
                    List<Object> localQueue = this.queue;
                    try {
                        this.queue = null;
                        this.emitting = true;
                        try {
                            drain(localQueue);
                            complete();
                        } catch (Throwable e) {
                            error(e);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    while (true) {
                        break;
                    }
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void scheduleExact() {
            this.worker.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.AnonymousClass2 */

                @Override // rx.functions.Action0
                public void call() {
                    ExactSubscriber.this.nextWindow();
                }
            }, 0, OperatorWindowWithTime.this.timespan, OperatorWindowWithTime.this.unit);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            if (replaceSubject() != false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            if (0 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            r2 = r5.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0036, code lost:
            r4 = r5.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0038, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r3 = r5.queue;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x003b, code lost:
            if (r3 != null) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0040, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0041, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0043, code lost:
            r2 = r5.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0045, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0048, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x004e, code lost:
            r5.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0050, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0055, code lost:
            if (drain(r3) != false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0057, code lost:
            if (0 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0059, code lost:
            r2 = r5.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x005b, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x005e, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0065, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0066, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0067, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0068, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x006a, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x006b, code lost:
            if (0 == 0) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x006f, code lost:
            monitor-enter(r5.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0077, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void nextWindow() {
            /*
            // Method dump skipped, instructions count: 123
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.nextWindow():void");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class CountedSerializedSubject<T> {
        final Observer<T> consumer;
        int count;
        final Observable<T> producer;

        public CountedSerializedSubject(Observer<T> consumer2, Observable<T> producer2) {
            this.consumer = new SerializedObserver(consumer2);
            this.producer = producer2;
        }
    }

    /* access modifiers changed from: package-private */
    public final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<CountedSerializedSubject<T>> chunks = new LinkedList();
        boolean done;
        final Object guard = new Object();
        final Scheduler.Worker worker;

        public InexactSubscriber(Subscriber<? super Observable<T>> child2, Scheduler.Worker worker2) {
            super(child2);
            this.child = child2;
            this.worker = worker2;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
            r0 = r2.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
            if (r0.hasNext() == false) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
            r2 = r0.next();
            r2.consumer.onNext(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
            if (r2.count != r6.this$0.size) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
            r2.consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
            return;
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.guard
                monitor-enter(r0)
                r1 = 0
                boolean r2 = r6.done     // Catch:{ all -> 0x0059 }
                if (r2 == 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0059 }
                return
            L_0x000a:
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0059 }
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r3 = r6.chunks     // Catch:{ all -> 0x0059 }
                r2.<init>(r3)     // Catch:{ all -> 0x0059 }
                r1 = r2
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r6.chunks     // Catch:{ all -> 0x005c }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x005c }
            L_0x0018:
                boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005c }
                if (r3 == 0) goto L_0x0034
                java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005c }
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r3 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r3     // Catch:{ all -> 0x005c }
                int r4 = r3.count     // Catch:{ all -> 0x005c }
                int r4 = r4 + 1
                r3.count = r4     // Catch:{ all -> 0x005c }
                rx.internal.operators.OperatorWindowWithTime r5 = rx.internal.operators.OperatorWindowWithTime.this     // Catch:{ all -> 0x005c }
                int r5 = r5.size     // Catch:{ all -> 0x005c }
                if (r4 != r5) goto L_0x0033
                r2.remove()     // Catch:{ all -> 0x005c }
            L_0x0033:
                goto L_0x0018
            L_0x0034:
                monitor-exit(r0)     // Catch:{ all -> 0x005c }
                java.util.Iterator r0 = r1.iterator()
            L_0x0039:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0058
                java.lang.Object r2 = r0.next()
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r2 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r2
                rx.Observer<T> r3 = r2.consumer
                r3.onNext(r7)
                int r3 = r2.count
                rx.internal.operators.OperatorWindowWithTime r4 = rx.internal.operators.OperatorWindowWithTime.this
                int r4 = r4.size
                if (r3 != r4) goto L_0x0057
                rx.Observer<T> r3 = r2.consumer
                r3.onCompleted()
            L_0x0057:
                goto L_0x0039
            L_0x0058:
                return
            L_0x0059:
                r2 = move-exception
            L_0x005a:
                monitor-exit(r0)
                throw r2
            L_0x005c:
                r2 = move-exception
                goto L_0x005a
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.onNext(java.lang.Object):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            r0 = r2.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r0.hasNext() == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r0.next().consumer.onError(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
            r4.child.onError(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
            return;
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onError(java.lang.Throwable r5) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.guard
                monitor-enter(r0)
                r1 = 0
                boolean r2 = r4.done     // Catch:{ all -> 0x0037 }
                if (r2 == 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                return
            L_0x000a:
                r2 = 1
                r4.done = r2     // Catch:{ all -> 0x0037 }
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0037 }
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r3 = r4.chunks     // Catch:{ all -> 0x0037 }
                r2.<init>(r3)     // Catch:{ all -> 0x0037 }
                r1 = r2
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r4.chunks     // Catch:{ all -> 0x003a }
                r2.clear()     // Catch:{ all -> 0x003a }
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                java.util.Iterator r0 = r1.iterator()
            L_0x001f:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0031
                java.lang.Object r2 = r0.next()
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r2 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r2
                rx.Observer<T> r3 = r2.consumer
                r3.onError(r5)
                goto L_0x001f
            L_0x0031:
                rx.Subscriber<? super rx.Observable<T>> r0 = r4.child
                r0.onError(r5)
                return
            L_0x0037:
                r2 = move-exception
            L_0x0038:
                monitor-exit(r0)
                throw r2
            L_0x003a:
                r2 = move-exception
                goto L_0x0038
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.onError(java.lang.Throwable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            r0 = r2.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r0.hasNext() == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r0.next().consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
            r4.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
            return;
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCompleted() {
            /*
                r4 = this;
                java.lang.Object r0 = r4.guard
                monitor-enter(r0)
                r1 = 0
                boolean r2 = r4.done     // Catch:{ all -> 0x0037 }
                if (r2 == 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                return
            L_0x000a:
                r2 = 1
                r4.done = r2     // Catch:{ all -> 0x0037 }
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0037 }
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r3 = r4.chunks     // Catch:{ all -> 0x0037 }
                r2.<init>(r3)     // Catch:{ all -> 0x0037 }
                r1 = r2
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r4.chunks     // Catch:{ all -> 0x003a }
                r2.clear()     // Catch:{ all -> 0x003a }
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                java.util.Iterator r0 = r1.iterator()
            L_0x001f:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0031
                java.lang.Object r2 = r0.next()
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r2 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r2
                rx.Observer<T> r3 = r2.consumer
                r3.onCompleted()
                goto L_0x001f
            L_0x0031:
                rx.Subscriber<? super rx.Observable<T>> r0 = r4.child
                r0.onCompleted()
                return
            L_0x0037:
                r2 = move-exception
            L_0x0038:
                monitor-exit(r0)
                throw r2
            L_0x003a:
                r2 = move-exception
                goto L_0x0038
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.onCompleted():void");
        }

        /* access modifiers changed from: package-private */
        public void scheduleChunk() {
            this.worker.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            }, OperatorWindowWithTime.this.timeshift, OperatorWindowWithTime.this.timeshift, OperatorWindowWithTime.this.unit);
        }

        /* access modifiers changed from: package-private */
        public void startNewChunk() {
            final CountedSerializedSubject<T> chunk = createCountedSerializedSubject();
            synchronized (this.guard) {
                if (!this.done) {
                    this.chunks.add(chunk);
                    try {
                        this.child.onNext(chunk.producer);
                        this.worker.schedule(new Action0() {
                            /* class rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.AnonymousClass2 */

                            @Override // rx.functions.Action0
                            public void call() {
                                InexactSubscriber.this.terminateChunk(chunk);
                            }
                        }, OperatorWindowWithTime.this.timespan, OperatorWindowWithTime.this.unit);
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
        public void terminateChunk(rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject<T> r5) {
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
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r4.chunks     // Catch:{ all -> 0x002d }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x002d }
            L_0x0010:
                boolean r3 = r2.hasNext()     // Catch:{ all -> 0x002d }
                if (r3 == 0) goto L_0x0024
                java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x002d }
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r3 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r3     // Catch:{ all -> 0x002d }
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
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.terminateChunk(rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject):void");
        }

        /* access modifiers changed from: package-private */
        public CountedSerializedSubject<T> createCountedSerializedSubject() {
            UnicastSubject<T> bus = UnicastSubject.create();
            return new CountedSerializedSubject<>(bus, bus);
        }
    }
}
