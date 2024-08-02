package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.schedulers.ImmediateScheduler;
import rx.internal.schedulers.TrampolineScheduler;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

public final class OperatorObserveOn<T> implements Observable.Operator<T, T> {
    private final int bufferSize;
    private final boolean delayError;
    private final Scheduler scheduler;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorObserveOn(Scheduler scheduler2, boolean delayError2) {
        this(scheduler2, delayError2, RxRingBuffer.SIZE);
    }

    public OperatorObserveOn(Scheduler scheduler2, boolean delayError2, int bufferSize2) {
        this.scheduler = scheduler2;
        this.delayError = delayError2;
        this.bufferSize = bufferSize2 > 0 ? bufferSize2 : RxRingBuffer.SIZE;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        Scheduler scheduler2 = this.scheduler;
        if ((scheduler2 instanceof ImmediateScheduler) || (scheduler2 instanceof TrampolineScheduler)) {
            return child;
        }
        ObserveOnSubscriber<T> parent = new ObserveOnSubscriber<>(this.scheduler, child, this.delayError, this.bufferSize);
        parent.init();
        return parent;
    }

    public static <T> Observable.Operator<T, T> rebatch(final int n) {
        return new Observable.Operator<T, T>() {
            /* class rx.internal.operators.OperatorObserveOn.AnonymousClass1 */

            @Override // rx.functions.Func1
            public /* bridge */ /* synthetic */ Object call(Object x0) {
                return call((Subscriber) ((Subscriber) x0));
            }

            public Subscriber<? super T> call(Subscriber<? super T> child) {
                ObserveOnSubscriber<T> parent = new ObserveOnSubscriber<>(Schedulers.immediate(), child, false, n);
                parent.init();
                return parent;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static final class ObserveOnSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> child;
        final AtomicLong counter = new AtomicLong();
        final boolean delayError;
        long emitted;
        Throwable error;
        volatile boolean finished;
        final int limit;
        final NotificationLite<T> on;
        final Queue<Object> queue;
        final Scheduler.Worker recursiveScheduler;
        final AtomicLong requested = new AtomicLong();

        public ObserveOnSubscriber(Scheduler scheduler, Subscriber<? super T> child2, boolean delayError2, int bufferSize) {
            this.child = child2;
            this.recursiveScheduler = scheduler.createWorker();
            this.delayError = delayError2;
            this.on = NotificationLite.instance();
            int calculatedSize = bufferSize > 0 ? bufferSize : RxRingBuffer.SIZE;
            this.limit = calculatedSize - (calculatedSize >> 2);
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(calculatedSize);
            } else {
                this.queue = new SpscAtomicArrayQueue(calculatedSize);
            }
            request((long) calculatedSize);
        }

        /* access modifiers changed from: package-private */
        public void init() {
            Subscriber<? super T> localChild = this.child;
            localChild.setProducer(new Producer() {
                /* class rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber.AnonymousClass1 */

                @Override // rx.Producer
                public void request(long n) {
                    if (n > 0) {
                        BackpressureUtils.getAndAddRequest(ObserveOnSubscriber.this.requested, n);
                        ObserveOnSubscriber.this.schedule();
                    }
                }
            });
            localChild.add(this.recursiveScheduler);
            localChild.add(this);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!isUnsubscribed() && !this.finished) {
                if (!this.queue.offer(this.on.next(t))) {
                    onError(new MissingBackpressureException());
                } else {
                    schedule();
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!isUnsubscribed() && !this.finished) {
                this.finished = true;
                schedule();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (isUnsubscribed() || this.finished) {
                RxJavaHooks.onError(e);
                return;
            }
            this.error = e;
            this.finished = true;
            schedule();
        }

        /* access modifiers changed from: protected */
        public void schedule() {
            if (this.counter.getAndIncrement() == 0) {
                this.recursiveScheduler.schedule(this);
            }
        }

        @Override // rx.functions.Action0
        public void call() {
            long missed = 1;
            long currentEmission = this.emitted;
            Queue<Object> q = this.queue;
            Subscriber<? super T> localChild = this.child;
            NotificationLite<T> localOn = this.on;
            do {
                long requestAmount = this.requested.get();
                while (requestAmount != currentEmission) {
                    boolean done = this.finished;
                    Object v = q.poll();
                    boolean empty = v == null;
                    if (!checkTerminated(done, empty, localChild, q)) {
                        if (empty) {
                            break;
                        }
                        localChild.onNext(localOn.getValue(v));
                        currentEmission++;
                        if (currentEmission == ((long) this.limit)) {
                            requestAmount = BackpressureUtils.produced(this.requested, currentEmission);
                            request(currentEmission);
                            currentEmission = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (requestAmount != currentEmission || !checkTerminated(this.finished, q.isEmpty(), localChild, q)) {
                    this.emitted = currentEmission;
                    missed = this.counter.addAndGet(-missed);
                } else {
                    return;
                }
            } while (missed != 0);
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean done, boolean isEmpty, Subscriber<? super T> a, Queue<Object> q) {
            if (a.isUnsubscribed()) {
                q.clear();
                return true;
            } else if (!done) {
                return false;
            } else {
                if (!this.delayError) {
                    Throwable e = this.error;
                    if (e != null) {
                        q.clear();
                        try {
                            a.onError(e);
                            return true;
                        } finally {
                            this.recursiveScheduler.unsubscribe();
                        }
                    } else if (!isEmpty) {
                        return false;
                    } else {
                        try {
                            a.onCompleted();
                            return true;
                        } finally {
                            this.recursiveScheduler.unsubscribe();
                        }
                    }
                } else if (!isEmpty) {
                    return false;
                } else {
                    Throwable e2 = this.error;
                    if (e2 != null) {
                        try {
                            a.onError(e2);
                        } catch (Throwable th) {
                            this.recursiveScheduler.unsubscribe();
                            throw th;
                        }
                    } else {
                        a.onCompleted();
                    }
                    this.recursiveScheduler.unsubscribe();
                    return false;
                }
            }
        }
    }
}
