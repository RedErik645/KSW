package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.producers.SingleProducer;
import rx.internal.schedulers.EventLoopsScheduler;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;

public final class ScalarSynchronousObservable<T> extends Observable<T> {
    static final boolean STRONG_MODE = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    final T t;

    static <T> Producer createProducer(Subscriber<? super T> s, T v) {
        if (STRONG_MODE) {
            return new SingleProducer(s, v);
        }
        return new WeakSingleProducer(s, v);
    }

    public static <T> ScalarSynchronousObservable<T> create(T t2) {
        return new ScalarSynchronousObservable<>(t2);
    }

    protected ScalarSynchronousObservable(T t2) {
        super(RxJavaHooks.onCreate(new JustOnSubscribe(t2)));
        this.t = t2;
    }

    public T get() {
        return this.t;
    }

    public Observable<T> scalarScheduleOn(final Scheduler scheduler) {
        Func1<Action0, Subscription> onSchedule;
        if (scheduler instanceof EventLoopsScheduler) {
            final EventLoopsScheduler els = (EventLoopsScheduler) scheduler;
            onSchedule = new Func1<Action0, Subscription>() {
                /* class rx.internal.util.ScalarSynchronousObservable.AnonymousClass1 */

                public Subscription call(Action0 a) {
                    return els.scheduleDirect(a);
                }
            };
        } else {
            onSchedule = new Func1<Action0, Subscription>() {
                /* class rx.internal.util.ScalarSynchronousObservable.AnonymousClass2 */

                public Subscription call(final Action0 a) {
                    final Scheduler.Worker w = scheduler.createWorker();
                    w.schedule(new Action0() {
                        /* class rx.internal.util.ScalarSynchronousObservable.AnonymousClass2.AnonymousClass1 */

                        @Override // rx.functions.Action0
                        public void call() {
                            try {
                                a.call();
                            } finally {
                                w.unsubscribe();
                            }
                        }
                    });
                    return w;
                }
            };
        }
        return create((Observable.OnSubscribe) new ScalarAsyncOnSubscribe(this.t, onSchedule));
    }

    static final class JustOnSubscribe<T> implements Observable.OnSubscribe<T> {
        final T value;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        JustOnSubscribe(T value2) {
            this.value = value2;
        }

        public void call(Subscriber<? super T> s) {
            s.setProducer(ScalarSynchronousObservable.createProducer(s, this.value));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ScalarAsyncOnSubscribe<T> implements Observable.OnSubscribe<T> {
        final Func1<Action0, Subscription> onSchedule;
        final T value;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        ScalarAsyncOnSubscribe(T value2, Func1<Action0, Subscription> onSchedule2) {
            this.value = value2;
            this.onSchedule = onSchedule2;
        }

        public void call(Subscriber<? super T> s) {
            s.setProducer(new ScalarAsyncProducer(s, this.value, this.onSchedule));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;
        final Subscriber<? super T> actual;
        final Func1<Action0, Subscription> onSchedule;
        final T value;

        public ScalarAsyncProducer(Subscriber<? super T> actual2, T value2, Func1<Action0, Subscription> onSchedule2) {
            this.actual = actual2;
            this.value = value2;
            this.onSchedule = onSchedule2;
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + n);
            } else if (n != 0 && compareAndSet(false, true)) {
                this.actual.add(this.onSchedule.call(this));
            }
        }

        @Override // rx.functions.Action0
        public void call() {
            Subscriber<? super T> a = this.actual;
            if (!a.isUnsubscribed()) {
                T v = this.value;
                try {
                    a.onNext(v);
                    if (!a.isUnsubscribed()) {
                        a.onCompleted();
                    }
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, a, v);
                }
            }
        }

        public String toString() {
            return "ScalarAsyncProducer[" + ((Object) this.value) + ", " + get() + "]";
        }
    }

    public <R> Observable<R> scalarFlatMap(final Func1<? super T, ? extends Observable<? extends R>> func) {
        return create((Observable.OnSubscribe) new Observable.OnSubscribe<R>() {
            /* class rx.internal.util.ScalarSynchronousObservable.AnonymousClass3 */

            public void call(Subscriber<? super R> child) {
                Observable<? extends R> o = (Observable) func.call(ScalarSynchronousObservable.this.t);
                if (o instanceof ScalarSynchronousObservable) {
                    child.setProducer(ScalarSynchronousObservable.createProducer(child, ((ScalarSynchronousObservable) o).t));
                } else {
                    o.unsafeSubscribe(Subscribers.wrap(child));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static final class WeakSingleProducer<T> implements Producer {
        final Subscriber<? super T> actual;
        boolean once;
        final T value;

        public WeakSingleProducer(Subscriber<? super T> actual2, T value2) {
            this.actual = actual2;
            this.value = value2;
        }

        @Override // rx.Producer
        public void request(long n) {
            if (!this.once) {
                if (n < 0) {
                    throw new IllegalStateException("n >= required but it was " + n);
                } else if (n != 0) {
                    this.once = true;
                    Subscriber<? super T> a = this.actual;
                    if (!a.isUnsubscribed()) {
                        T v = this.value;
                        try {
                            a.onNext(v);
                            if (!a.isUnsubscribed()) {
                                a.onCompleted();
                            }
                        } catch (Throwable e) {
                            Exceptions.throwOrReport(e, a, v);
                        }
                    }
                }
            }
        }
    }
}
