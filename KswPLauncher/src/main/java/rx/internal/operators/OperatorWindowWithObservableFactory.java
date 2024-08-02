package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.SerialSubscription;

public final class OperatorWindowWithObservableFactory<T, U> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    static final NotificationLite<Object> NL = NotificationLite.instance();
    final Func0<? extends Observable<? extends U>> otherFactory;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorWindowWithObservableFactory(Func0<? extends Observable<? extends U>> otherFactory2) {
        this.otherFactory = otherFactory2;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> child) {
        SourceSubscriber<T, U> sub = new SourceSubscriber<>(child, this.otherFactory);
        child.add(sub);
        sub.replaceWindow();
        return sub;
    }

    /* access modifiers changed from: package-private */
    public static final class SourceSubscriber<T, U> extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        Observer<T> consumer;
        boolean emitting;
        final Object guard = new Object();
        final Func0<? extends Observable<? extends U>> otherFactory;
        Observable<T> producer;
        List<Object> queue;
        final SerialSubscription ssub;

        public SourceSubscriber(Subscriber<? super Observable<T>> child2, Func0<? extends Observable<? extends U>> otherFactory2) {
            this.child = new SerializedSubscriber(child2);
            SerialSubscription serialSubscription = new SerialSubscription();
            this.ssub = serialSubscription;
            this.otherFactory = otherFactory2;
            add(serialSubscription);
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            drain(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0028, code lost:
            if (r0 == false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
            r0 = false;
            emitValue(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
            r5 = r8.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r2 = r8.queue;
            r8.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
            if (r2 != null) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0038, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x003b, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x003c, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x003e, code lost:
            r1 = r8.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0040, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0043, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0049, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0050, code lost:
            if (r8.child.isUnsubscribed() == false) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0052, code lost:
            if (0 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0054, code lost:
            r1 = r8.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0056, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0059, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0062, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0063, code lost:
            if (0 == 0) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0067, code lost:
            monitor-enter(r8.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x006f, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
            return;
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
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r9) {
            /*
            // Method dump skipped, instructions count: 122
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithObservableFactory.SourceSubscriber.onNext(java.lang.Object):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.internal.operators.OperatorWindowWithObservableFactory$SourceSubscriber<T, U> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public void drain(List<Object> queue2) {
            if (queue2 != null) {
                for (Object o : queue2) {
                    if (o == OperatorWindowWithObservableFactory.NEXT_SUBJECT) {
                        replaceSubject();
                    } else if (OperatorWindowWithObservableFactory.NL.isError(o)) {
                        error(OperatorWindowWithObservableFactory.NL.getError(o));
                        return;
                    } else if (OperatorWindowWithObservableFactory.NL.isCompleted(o)) {
                        complete();
                        return;
                    } else {
                        emitValue(o);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void replaceSubject() {
            Observer<T> s = this.consumer;
            if (s != null) {
                s.onCompleted();
            }
            createNewWindow();
            this.child.onNext(this.producer);
        }

        /* access modifiers changed from: package-private */
        public void createNewWindow() {
            UnicastSubject<T> bus = UnicastSubject.create();
            this.consumer = bus;
            this.producer = bus;
            try {
                Observable<? extends U> other = (Observable) this.otherFactory.call();
                BoundarySubscriber<T, U> bs = new BoundarySubscriber<>(this);
                this.ssub.set(bs);
                other.unsafeSubscribe(bs);
            } catch (Throwable e) {
                this.child.onError(e);
                unsubscribe();
            }
        }

        /* access modifiers changed from: package-private */
        public void emitValue(T t) {
            Observer<T> s = this.consumer;
            if (s != null) {
                s.onNext(t);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(OperatorWindowWithObservableFactory.NL.error(e));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(e);
            }
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
                        this.queue.add(OperatorWindowWithObservableFactory.NL.completed());
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
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            drain(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
            if (r0 == false) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
            r0 = false;
            replaceSubject();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
            r5 = r8.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r2 = r8.queue;
            r8.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0038, code lost:
            if (r2 != null) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x003a, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x003d, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x003e, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0040, code lost:
            r1 = r8.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0042, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0045, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x004b, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0052, code lost:
            if (r8.child.isUnsubscribed() == false) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0054, code lost:
            if (0 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0056, code lost:
            r1 = r8.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0058, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x005b, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0064, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0065, code lost:
            if (0 == 0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0069, code lost:
            monitor-enter(r8.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0071, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
            return;
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
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replaceWindow() {
            /*
            // Method dump skipped, instructions count: 124
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithObservableFactory.SourceSubscriber.replaceWindow():void");
        }

        /* access modifiers changed from: package-private */
        public void complete() {
            Observer<T> s = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (s != null) {
                s.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        /* access modifiers changed from: package-private */
        public void error(Throwable e) {
            Observer<T> s = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (s != null) {
                s.onError(e);
            }
            this.child.onError(e);
            unsubscribe();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class BoundarySubscriber<T, U> extends Subscriber<U> {
        boolean done;
        final SourceSubscriber<T, U> sub;

        public BoundarySubscriber(SourceSubscriber<T, U> sub2) {
            this.sub = sub2;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        @Override // rx.Observer
        public void onNext(U u) {
            if (!this.done) {
                this.done = true;
                this.sub.replaceWindow();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.sub.onError(e);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.sub.onCompleted();
            }
        }
    }
}
