package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeCombineLatest<T, R> implements Observable.OnSubscribe<R> {
    final int bufferSize;
    final FuncN<? extends R> combiner;
    final boolean delayError;
    final Observable<? extends T>[] sources;
    final Iterable<? extends Observable<? extends T>> sourcesIterable;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> sourcesIterable2, FuncN<? extends R> combiner2) {
        this(null, sourcesIterable2, combiner2, RxRingBuffer.SIZE, false);
    }

    public OnSubscribeCombineLatest(Observable<? extends T>[] sources2, Iterable<? extends Observable<? extends T>> sourcesIterable2, FuncN<? extends R> combiner2, int bufferSize2, boolean delayError2) {
        this.sources = sources2;
        this.sourcesIterable = sourcesIterable2;
        this.combiner = combiner2;
        this.bufferSize = bufferSize2;
        this.delayError = delayError2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Multiple debug info for r4v2 int: [D('count' int), D('b' rx.Observable<? extends T>[])] */
    public void call(Subscriber<? super R> s) {
        int count;
        Observable<? extends T>[] sources2 = this.sources;
        int count2 = 0;
        if (sources2 == null) {
            Iterable<? extends Observable<? extends T>> iterable = this.sourcesIterable;
            if (iterable instanceof List) {
                List list = (List) iterable;
                sources2 = (Observable[]) list.toArray(new Observable[list.size()]);
                count = sources2.length;
            } else {
                sources2 = new Observable[8];
                for (Observable<? extends T> p : iterable) {
                    if (count2 == sources2.length) {
                        Observable<? extends T>[] b = new Observable[((count2 >> 2) + count2)];
                        System.arraycopy(sources2, 0, b, 0, count2);
                        sources2 = b;
                    }
                    sources2[count2] = p;
                    count2++;
                }
                count = count2;
            }
        } else {
            count = sources2.length;
        }
        if (count == 0) {
            s.onCompleted();
        } else {
            new LatestCoordinator<>(s, this.combiner, count, this.bufferSize, this.delayError).subscribe(sources2);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements Producer, Subscription {
        static final Object MISSING = new Object();
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final FuncN<? extends R> combiner;
        int complete;
        final int count;
        final boolean delayError;
        volatile boolean done;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final Object[] latest;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final CombinerSubscriber<T, R>[] subscribers;

        public LatestCoordinator(Subscriber<? super R> actual2, FuncN<? extends R> combiner2, int count2, int bufferSize2, boolean delayError2) {
            this.actual = actual2;
            this.combiner = combiner2;
            this.count = count2;
            this.bufferSize = bufferSize2;
            this.delayError = delayError2;
            Object[] objArr = new Object[count2];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new CombinerSubscriber[count2];
            this.queue = new SpscLinkedArrayQueue<>(bufferSize2);
        }

        public void subscribe(Observable<? extends T>[] sources) {
            Subscriber<T>[] as = this.subscribers;
            int len = as.length;
            for (int i = 0; i < len; i++) {
                as[i] = new CombinerSubscriber<>(this, i);
            }
            lazySet(0);
            this.actual.add(this);
            this.actual.setProducer(this);
            for (int i2 = 0; i2 < len && !this.cancelled; i2++) {
                sources[i2].subscribe((Subscriber<? super Object>) as[i2]);
            }
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= required but it was " + n);
            } else if (n != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, n);
                drain();
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void cancel(Queue<?> q) {
            q.clear();
            for (CombinerSubscriber<T, R> s : this.subscribers) {
                s.unsubscribe();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0064, code lost:
            if (r8 != false) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0066, code lost:
            if (r12 == null) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0068, code lost:
            r0.requestMore(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x006d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006e, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void combine(java.lang.Object r12, int r13) {
            /*
            // Method dump skipped, instructions count: 138
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeCombineLatest.LatestCoordinator.combine(java.lang.Object, int):void");
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            int missed;
            if (getAndIncrement() == 0) {
                Queue<Object> q = this.queue;
                Subscriber<? super R> a = this.actual;
                boolean delayError2 = this.delayError;
                AtomicLong localRequested = this.requested;
                int missed2 = 1;
                Object obj = null;
                while (!checkTerminated(this.done, q.isEmpty(), a, q, delayError2)) {
                    long requestAmount = localRequested.get();
                    Object obj2 = obj;
                    long emitted = 0;
                    while (true) {
                        if (emitted == requestAmount) {
                            missed = missed2;
                            break;
                        }
                        boolean d = this.done;
                        CombinerSubscriber<T, R> cs = (CombinerSubscriber) q.peek();
                        boolean empty = cs == null;
                        missed = missed2;
                        if (!checkTerminated(d, empty, a, q, delayError2)) {
                            if (empty) {
                                emitted = emitted;
                                break;
                            }
                            q.poll();
                            Object[] array = (Object[]) q.poll();
                            if (array == null) {
                                this.cancelled = true;
                                cancel(q);
                                a.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                                return;
                            }
                            try {
                                obj2 = this.combiner.call(array);
                                a.onNext(obj2);
                                cs.requestMore(1);
                                emitted++;
                                missed2 = missed;
                            } catch (Throwable ex) {
                                this.cancelled = true;
                                cancel(q);
                                a.onError(ex);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (!(emitted == 0 || requestAmount == LongCompanionObject.MAX_VALUE)) {
                        BackpressureUtils.produced(localRequested, emitted);
                    }
                    missed2 = addAndGet(-missed);
                    if (missed2 != 0) {
                        obj = obj2;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean mainDone, boolean queueEmpty, Subscriber<?> childSubscriber, Queue<?> q, boolean delayError2) {
            if (this.cancelled) {
                cancel(q);
                return true;
            } else if (!mainDone) {
                return false;
            } else {
                if (!delayError2) {
                    Throwable e = this.error.get();
                    if (e != null) {
                        cancel(q);
                        childSubscriber.onError(e);
                        return true;
                    } else if (!queueEmpty) {
                        return false;
                    } else {
                        childSubscriber.onCompleted();
                        return true;
                    }
                } else if (!queueEmpty) {
                    return false;
                } else {
                    Throwable e2 = this.error.get();
                    if (e2 != null) {
                        childSubscriber.onError(e2);
                    } else {
                        childSubscriber.onCompleted();
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable e) {
            Throwable curr;
            CompositeException ce;
            AtomicReference<Throwable> localError = this.error;
            do {
                curr = localError.get();
                if (curr == null) {
                    ce = e;
                } else if (curr instanceof CompositeException) {
                    List<Throwable> es = new ArrayList<>(((CompositeException) curr).getExceptions());
                    es.add(e);
                    ce = new CompositeException(es);
                } else {
                    ce = new CompositeException(Arrays.asList(curr, e));
                }
            } while (!localError.compareAndSet(curr, ce));
        }
    }

    /* access modifiers changed from: package-private */
    public static final class CombinerSubscriber<T, R> extends Subscriber<T> {
        boolean done;
        final int index;
        final NotificationLite<T> nl = NotificationLite.instance();
        final LatestCoordinator<T, R> parent;

        public CombinerSubscriber(LatestCoordinator<T, R> parent2, int index2) {
            this.parent = parent2;
            this.index = index2;
            request((long) parent2.bufferSize);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                this.parent.combine(this.nl.next(t), this.index);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaHooks.onError(t);
                return;
            }
            this.parent.onError(t);
            this.done = true;
            this.parent.combine(null, this.index);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.parent.combine(null, this.index);
            }
        }

        public void requestMore(long n) {
            request(n);
        }
    }
}
