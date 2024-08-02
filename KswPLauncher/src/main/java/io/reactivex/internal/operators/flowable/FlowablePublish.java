package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, FlowablePublishClassic<T> {
    static final long CANCELLED = Long.MIN_VALUE;
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    public static <T> ConnectableFlowable<T> create(Flowable<T> source2, int bufferSize2) {
        AtomicReference<PublishSubscriber<T>> curr = new AtomicReference<>();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowablePublish(new FlowablePublisher<>(curr, bufferSize2), source2, curr, bufferSize2));
    }

    private FlowablePublish(Publisher<T> onSubscribe2, Flowable<T> source2, AtomicReference<PublishSubscriber<T>> current2, int bufferSize2) {
        this.onSubscribe = onSubscribe2;
        this.source = source2;
        this.current = current2;
        this.bufferSize = bufferSize2;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowablePublishClassic
    public int publishBufferSize() {
        return this.bufferSize;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowablePublishClassic
    public Publisher<T> publishSource() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        this.onSubscribe.subscribe(s);
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> connection) {
        PublishSubscriber<T> ps;
        while (true) {
            ps = this.current.get();
            if (ps != null && !ps.isDisposed()) {
                break;
            }
            PublishSubscriber<T> u = new PublishSubscriber<>(this.current, this.bufferSize);
            if (this.current.compareAndSet(ps, u)) {
                ps = u;
                break;
            }
        }
        boolean doConnect = true;
        if (ps.shouldConnect.get() || !ps.shouldConnect.compareAndSet(false, true)) {
            doConnect = false;
        }
        try {
            connection.accept(ps);
            if (doConnect) {
                this.source.subscribe((FlowableSubscriber) ps);
            }
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            throw ExceptionHelper.wrapOrThrow(ex);
        }
    }

    static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile SimpleQueue<T> queue;
        final AtomicBoolean shouldConnect;
        int sourceMode;
        final AtomicReference<InnerSubscriber<T>[]> subscribers = new AtomicReference<>(EMPTY);
        volatile Object terminalEvent;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> current2, int bufferSize2) {
            this.current = current2;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = bufferSize2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            InnerSubscriber[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber[] innerSubscriberArr2 = TERMINATED;
            if (innerSubscriberArr != innerSubscriberArr2 && this.subscribers.getAndSet(innerSubscriberArr2) != innerSubscriberArr2) {
                this.current.compareAndSet(this, null);
                SubscriptionHelper.cancel(this.upstream);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.setOnce(this.upstream, s)) {
                if (s instanceof QueueSubscription) {
                    QueueSubscription<T> qs = (QueueSubscription) s;
                    int m = qs.requestFusion(7);
                    if (m == 1) {
                        this.sourceMode = m;
                        this.queue = qs;
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    } else if (m == 2) {
                        this.sourceMode = m;
                        this.queue = qs;
                        s.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                s.request((long) this.bufferSize);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                dispatch();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable e) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(e);
                dispatch();
                return;
            }
            RxJavaPlugins.onError(e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean add(InnerSubscriber<T> producer) {
            InnerSubscriber<T>[] c;
            InnerSubscriber<T>[] u;
            do {
                c = this.subscribers.get();
                if (c == TERMINATED) {
                    return false;
                }
                int len = c.length;
                u = new InnerSubscriber[(len + 1)];
                System.arraycopy(c, 0, u, 0, len);
                u[len] = producer;
            } while (!this.subscribers.compareAndSet(c, u));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void remove(InnerSubscriber<T> producer) {
            InnerSubscriber<T>[] c;
            InnerSubscriber<T>[] u;
            do {
                c = this.subscribers.get();
                int len = c.length;
                if (len != 0) {
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= len) {
                            break;
                        } else if (c[i].equals(producer)) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (len == 1) {
                            u = EMPTY;
                        } else {
                            InnerSubscriber<T>[] u2 = new InnerSubscriber[(len - 1)];
                            System.arraycopy(c, 0, u2, 0, j);
                            System.arraycopy(c, j + 1, u2, j, (len - j) - 1);
                            u = u2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(c, u));
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(Object term, boolean empty) {
            int i = 0;
            if (term != null) {
                if (!NotificationLite.isComplete(term)) {
                    Throwable t = NotificationLite.getError(term);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] a = this.subscribers.getAndSet(TERMINATED);
                    if (a.length != 0) {
                        int length = a.length;
                        while (i < length) {
                            a[i].child.onError(t);
                            i++;
                        }
                    } else {
                        RxJavaPlugins.onError(t);
                    }
                    return true;
                } else if (empty) {
                    this.current.compareAndSet(this, null);
                    InnerSubscriber<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
                    int length2 = andSet.length;
                    while (i < length2) {
                        andSet[i].child.onComplete();
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Multiple debug info for r0v2 java.lang.Object: [D('term' java.lang.Object), D('missed' int)] */
        /* JADX INFO: Multiple debug info for r5v16 io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber<T>: [D('q' io.reactivex.internal.fuseable.SimpleQueue<T>), D('ip' io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber<T>)] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0164, code lost:
            if (r8 == 0) goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0169, code lost:
            if (r27.sourceMode == 1) goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x016b, code lost:
            r27.upstream.get().request((long) r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x017b, code lost:
            if (r10 == 0) goto L_0x0181;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x017d, code lost:
            if (r19 != false) goto L_0x0181;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0014, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dispatch() {
            /*
            // Method dump skipped, instructions count: 410
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.dispatch():void");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        long emitted;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(Subscriber<? super T> child2) {
            this.child = child2;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.addCancel(this, n);
                PublishSubscriber<T> p = this.parent;
                if (p != null) {
                    p.dispatch();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            PublishSubscriber<T> p;
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE && (p = this.parent) != null) {
                p.remove(this);
                p.dispatch();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class FlowablePublisher<T> implements Publisher<T> {
        private final int bufferSize;
        private final AtomicReference<PublishSubscriber<T>> curr;

        FlowablePublisher(AtomicReference<PublishSubscriber<T>> curr2, int bufferSize2) {
            this.curr = curr2;
            this.bufferSize = bufferSize2;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> child) {
            PublishSubscriber<T> r;
            InnerSubscriber<T> inner = new InnerSubscriber<>(child);
            child.onSubscribe(inner);
            while (true) {
                r = this.curr.get();
                if (r == null || r.isDisposed()) {
                    PublishSubscriber<T> u = new PublishSubscriber<>(this.curr, this.bufferSize);
                    if (!this.curr.compareAndSet(r, u)) {
                        continue;
                    } else {
                        r = u;
                    }
                }
                if (r.add(inner)) {
                    break;
                }
            }
            if (inner.get() == Long.MIN_VALUE) {
                r.remove(inner);
            } else {
                inner.parent = r;
            }
            r.dispatch();
        }
    }
}
