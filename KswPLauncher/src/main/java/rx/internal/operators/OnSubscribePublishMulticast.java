package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.OnSubscribe<T>, Observer<T>, Subscription {
    static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final ParentSubscriber<T> parent;
    final int prefetch;
    volatile Producer producer;
    final Queue<T> queue;
    volatile PublishProducer<T>[] subscribers;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    public OnSubscribePublishMulticast(int prefetch2, boolean delayError2) {
        if (prefetch2 > 0) {
            this.prefetch = prefetch2;
            this.delayError = delayError2;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(prefetch2);
            } else {
                this.queue = new SpscAtomicArrayQueue(prefetch2);
            }
            this.subscribers = EMPTY;
            this.parent = new ParentSubscriber<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + prefetch2);
    }

    public void call(Subscriber<? super T> t) {
        PublishProducer<T> pp = new PublishProducer<>(t, this);
        t.add(pp);
        t.setProducer(pp);
        if (!add(pp)) {
            Throwable e = this.error;
            if (e != null) {
                t.onError(e);
            } else {
                t.onCompleted();
            }
        } else if (pp.isUnsubscribed()) {
            remove(pp);
        } else {
            drain();
        }
    }

    @Override // rx.Observer
    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        this.error = e;
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.done = true;
        drain();
    }

    /* access modifiers changed from: package-private */
    public void setProducer(Producer p) {
        this.producer = p;
        p.request((long) this.prefetch);
    }

    /* access modifiers changed from: package-private */
    public void drain() {
        if (getAndIncrement() == 0) {
            Queue<T> q = this.queue;
            int missed = 0;
            do {
                long r = LongCompanionObject.MAX_VALUE;
                PublishProducer<T>[] a = this.subscribers;
                int n = a.length;
                for (PublishProducer<T> inner : a) {
                    r = Math.min(r, inner.get());
                }
                if (n != 0) {
                    long e = 0;
                    while (true) {
                        if (e == r) {
                            break;
                        }
                        boolean d = this.done;
                        T v = q.poll();
                        boolean empty = v == null;
                        if (!checkTerminated(d, empty)) {
                            if (empty) {
                                break;
                            }
                            int len$ = a.length;
                            int i$ = 0;
                            while (i$ < len$) {
                                a[i$].actual.onNext(v);
                                i$++;
                                n = n;
                            }
                            e++;
                        } else {
                            return;
                        }
                    }
                    if (e == r && checkTerminated(this.done, q.isEmpty())) {
                        return;
                    }
                    if (e != 0) {
                        Producer p = this.producer;
                        if (p != null) {
                            p.request(e);
                        }
                        for (PublishProducer<T> inner2 : a) {
                            BackpressureUtils.produced(inner2, e);
                        }
                    }
                }
                missed = addAndGet(-missed);
            } while (missed != 0);
        }
    }

    /* JADX INFO: Multiple debug info for r0v2 java.lang.Throwable: [D('ex' java.lang.Throwable), D('a' rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<T>[])] */
    /* access modifiers changed from: package-private */
    public boolean checkTerminated(boolean d, boolean empty) {
        if (!d) {
            return false;
        }
        if (!this.delayError) {
            Throwable ex = this.error;
            if (ex != null) {
                this.queue.clear();
                for (PublishProducer<T> inner : terminate()) {
                    inner.actual.onError(ex);
                }
                return true;
            } else if (!empty) {
                return false;
            } else {
                for (PublishProducer<T> inner2 : terminate()) {
                    inner2.actual.onCompleted();
                }
                return true;
            }
        } else if (!empty) {
            return false;
        } else {
            PublishProducer<T>[] a = terminate();
            Throwable ex2 = this.error;
            if (ex2 != null) {
                for (PublishProducer<T> inner3 : a) {
                    inner3.actual.onError(ex2);
                }
            } else {
                for (PublishProducer<T> inner4 : a) {
                    inner4.actual.onCompleted();
                }
            }
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public PublishProducer<T>[] terminate() {
        PublishProducer<T>[] a = this.subscribers;
        PublishProducer<?>[] publishProducerArr = TERMINATED;
        if (a != publishProducerArr) {
            synchronized (this) {
                a = this.subscribers;
                if (a != publishProducerArr) {
                    this.subscribers = publishProducerArr;
                }
            }
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    public boolean add(PublishProducer<T> inner) {
        PublishProducer<T>[] a = this.subscribers;
        PublishProducer<?>[] publishProducerArr = TERMINATED;
        if (a == publishProducerArr) {
            return false;
        }
        synchronized (this) {
            PublishProducer<T>[] a2 = this.subscribers;
            if (a2 == publishProducerArr) {
                return false;
            }
            int n = a2.length;
            PublishProducer<T>[] b = new PublishProducer[(n + 1)];
            System.arraycopy(a2, 0, b, 0, n);
            b[n] = inner;
            this.subscribers = b;
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public void remove(PublishProducer<T> inner) {
        PublishProducer<?>[] publishProducerArr;
        PublishProducer<?>[] b;
        PublishProducer<T>[] a = this.subscribers;
        PublishProducer<?>[] publishProducerArr2 = TERMINATED;
        if (a != publishProducerArr2 && a != (publishProducerArr = EMPTY)) {
            synchronized (this) {
                PublishProducer<T>[] a2 = this.subscribers;
                if (a2 != publishProducerArr2) {
                    if (a2 != publishProducerArr) {
                        int j = -1;
                        int n = a2.length;
                        int i = 0;
                        while (true) {
                            if (i >= n) {
                                break;
                            } else if (a2[i] == inner) {
                                j = i;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (j >= 0) {
                            if (n == 1) {
                                b = EMPTY;
                            } else {
                                PublishProducer<T>[] b2 = new PublishProducer[(n - 1)];
                                System.arraycopy(a2, 0, b2, 0, j);
                                System.arraycopy(a2, j + 1, b2, j, (n - j) - 1);
                                b = b2;
                            }
                            this.subscribers = b;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ParentSubscriber<T> extends Subscriber<T> {
        final OnSubscribePublishMulticast<T> state;

        public ParentSubscriber(OnSubscribePublishMulticast<T> state2) {
            this.state = state2;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.state.onNext(t);
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.state.onError(e);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.onCompleted();
        }

        @Override // rx.Subscriber
        public void setProducer(Producer p) {
            this.state.setProducer(p);
        }
    }

    public Subscriber<T> subscriber() {
        return this.parent;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    /* access modifiers changed from: package-private */
    public static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;
        final Subscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(Subscriber<? super T> actual2, OnSubscribePublishMulticast<T> parent2) {
            this.actual = actual2;
            this.parent = parent2;
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + n);
            } else if (n != 0) {
                BackpressureUtils.getAndAddRequest(this, n);
                this.parent.drain();
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.once.get();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }
}
