package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
    final Func1<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    final Observable<? extends T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    protected OnSubscribeFlattenIterable(Observable<? extends T> source2, Func1<? super T, ? extends Iterable<? extends R>> mapper2, int prefetch2) {
        this.source = source2;
        this.mapper = mapper2;
        this.prefetch = prefetch2;
    }

    public void call(Subscriber<? super R> t) {
        final FlattenIterableSubscriber<T, R> parent = new FlattenIterableSubscriber<>(t, this.mapper, this.prefetch);
        t.add(parent);
        t.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeFlattenIterable.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long n) {
                parent.requestMore(n);
            }
        });
        this.source.unsafeSubscribe(parent);
    }

    public static <T, R> Observable<R> createFrom(Observable<? extends T> source2, Func1<? super T, ? extends Iterable<? extends R>> mapper2, int prefetch2) {
        if (source2 instanceof ScalarSynchronousObservable) {
            return Observable.create(new OnSubscribeScalarFlattenIterable(((ScalarSynchronousObservable) source2).get(), mapper2));
        }
        return Observable.create(new OnSubscribeFlattenIterable(source2, mapper2, prefetch2));
    }

    /* access modifiers changed from: package-private */
    public static final class FlattenIterableSubscriber<T, R> extends Subscriber<T> {
        Iterator<? extends R> active;
        final Subscriber<? super R> actual;
        volatile boolean done;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final long limit;
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        final NotificationLite<T> nl = NotificationLite.instance();
        long produced;
        final Queue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger wip = new AtomicInteger();

        public FlattenIterableSubscriber(Subscriber<? super R> actual2, Func1<? super T, ? extends Iterable<? extends R>> mapper2, int prefetch) {
            this.actual = actual2;
            this.mapper = mapper2;
            if (prefetch == Integer.MAX_VALUE) {
                this.limit = LongCompanionObject.MAX_VALUE;
                this.queue = new SpscLinkedArrayQueue(RxRingBuffer.SIZE);
            } else {
                this.limit = (long) (prefetch - (prefetch >> 2));
                if (UnsafeAccess.isUnsafeAvailable()) {
                    this.queue = new SpscArrayQueue(prefetch);
                } else {
                    this.queue = new SpscAtomicArrayQueue(prefetch);
                }
            }
            request((long) prefetch);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.queue.offer(this.nl.next(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (ExceptionsUtils.addThrowable(this.error, e)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaHooks.onError(e);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void requestMore(long n) {
            if (n > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, n);
                drain();
            } else if (n < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + n);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d8, code lost:
            if (r0 == null) goto L_0x00db;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
            // Method dump skipped, instructions count: 235
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeFlattenIterable.FlattenIterableSubscriber.drain():void");
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean d, boolean empty, Subscriber<?> a, Queue<?> q) {
            if (a.isUnsubscribed()) {
                q.clear();
                this.active = null;
                return true;
            } else if (!d) {
                return false;
            } else {
                if (this.error.get() != null) {
                    Throwable ex = ExceptionsUtils.terminate(this.error);
                    unsubscribe();
                    q.clear();
                    this.active = null;
                    a.onError(ex);
                    return true;
                } else if (!empty) {
                    return false;
                } else {
                    a.onCompleted();
                    return true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class OnSubscribeScalarFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        final T value;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public OnSubscribeScalarFlattenIterable(T value2, Func1<? super T, ? extends Iterable<? extends R>> mapper2) {
            this.value = value2;
            this.mapper = mapper2;
        }

        public void call(Subscriber<? super R> t) {
            Throwable ex;
            try {
                Iterator<? extends R> itor = ((Iterable) this.mapper.call(this.value)).iterator();
                try {
                    if (!itor.hasNext()) {
                        t.onCompleted();
                    } else {
                        t.setProducer(new OnSubscribeFromIterable.IterableProducer(t, itor));
                    }
                } catch (Throwable th) {
                    ex = th;
                }
            } catch (Throwable th2) {
                ex = th2;
                Exceptions.throwOrReport(ex, t, this.value);
            }
        }
    }
}
