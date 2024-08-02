package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    public FlowableConcatMapEager(Flowable<T> source, Function<? super T, ? extends Publisher<? extends R>> mapper2, int maxConcurrency2, int prefetch2, ErrorMode errorMode2) {
        super(source);
        this.mapper = mapper2;
        this.maxConcurrency = maxConcurrency2;
        this.prefetch = prefetch2;
        this.errorMode = errorMode2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe((FlowableSubscriber) new ConcatMapEagerDelayErrorSubscriber(s, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }

    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested = new AtomicLong();
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        Subscription upstream;

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends Publisher<? extends R>> mapper2, int maxConcurrency2, int prefetch2, ErrorMode errorMode2) {
            this.downstream = actual;
            this.mapper = mapper2;
            this.maxConcurrency = maxConcurrency2;
            this.prefetch = prefetch2;
            this.errorMode = errorMode2;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(prefetch2, maxConcurrency2));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                int i = this.maxConcurrency;
                s.request(i == Integer.MAX_VALUE ? LongCompanionObject.MAX_VALUE : (long) i);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Publisher<? extends R> p = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> inner = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (!this.cancelled) {
                    this.subscribers.offer(inner);
                    p.subscribe(inner);
                    if (this.cancelled) {
                        inner.cancel();
                        drainAndCancel();
                    }
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.cancel();
                onError(ex);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.errors.addThrowable(t)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                drainAndCancel();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAll() {
            InnerQueuedSubscriber<R> inner = this.current;
            this.current = null;
            if (inner != null) {
                inner.cancel();
            }
            while (true) {
                InnerQueuedSubscriber<R> inner2 = this.subscribers.poll();
                if (inner2 != null) {
                    inner2.cancel();
                } else {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                drain();
            }
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> inner, R value) {
            if (inner.queue().offer(value)) {
                drain();
                return;
            }
            inner.cancel();
            innerError(inner, new MissingBackpressureException());
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> inner, Throwable e) {
            if (this.errors.addThrowable(e)) {
                inner.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(e);
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> inner) {
            inner.setDone();
            drain();
        }

        /* JADX INFO: Multiple debug info for r9v11 boolean: [D('outerDone' boolean), D('ex' java.lang.Throwable)] */
        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void drain() {
            InnerQueuedSubscriber<R> inner;
            SimpleQueue<R> q;
            if (getAndIncrement() == 0) {
                InnerQueuedSubscriber<R> inner2 = this.current;
                Subscriber<? super R> a = this.downstream;
                ErrorMode em = this.errorMode;
                int missed = 1;
                InnerQueuedSubscriber<R> inner3 = inner2;
                while (true) {
                    long r = this.requested.get();
                    long e = 0;
                    if (inner3 != null) {
                        inner = inner3;
                    } else if (em == ErrorMode.END || ((Throwable) this.errors.get()) == null) {
                        boolean outerDone = this.done;
                        InnerQueuedSubscriber<R> inner4 = this.subscribers.poll();
                        if (!outerDone || inner4 != null) {
                            if (inner4 != null) {
                                this.current = inner4;
                            }
                            inner = inner4;
                        } else {
                            Throwable ex = this.errors.terminate();
                            if (ex != null) {
                                a.onError(ex);
                                return;
                            } else {
                                a.onComplete();
                                return;
                            }
                        }
                    } else {
                        cancelAll();
                        a.onError(this.errors.terminate());
                        return;
                    }
                    boolean continueNextSource = false;
                    if (!(inner == null || (q = inner.queue()) == null)) {
                        while (true) {
                            if (e == r) {
                                break;
                            } else if (this.cancelled) {
                                cancelAll();
                                return;
                            } else if (em != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                                boolean d = inner.isDone();
                                try {
                                    R v = q.poll();
                                    boolean empty = v == null;
                                    if (d && empty) {
                                        inner = null;
                                        this.current = null;
                                        this.upstream.request(1);
                                        continueNextSource = true;
                                        break;
                                    } else if (empty) {
                                        break;
                                    } else {
                                        a.onNext(v);
                                        e++;
                                        inner.requestOne();
                                    }
                                } catch (Throwable ex2) {
                                    Exceptions.throwIfFatal(ex2);
                                    this.current = null;
                                    inner.cancel();
                                    cancelAll();
                                    a.onError(ex2);
                                    return;
                                }
                            } else {
                                this.current = null;
                                inner.cancel();
                                cancelAll();
                                a.onError(this.errors.terminate());
                                return;
                            }
                        }
                        if (e == r) {
                            if (this.cancelled) {
                                cancelAll();
                                return;
                            } else if (em != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                                boolean d2 = inner.isDone();
                                boolean empty2 = q.isEmpty();
                                if (d2 && empty2) {
                                    this.current = null;
                                    this.upstream.request(1);
                                    continueNextSource = true;
                                    inner3 = null;
                                    if (!(e == 0 || r == LongCompanionObject.MAX_VALUE)) {
                                        this.requested.addAndGet(-e);
                                    }
                                    if (!continueNextSource && (missed = addAndGet(-missed)) == 0) {
                                        return;
                                    }
                                }
                            } else {
                                this.current = null;
                                inner.cancel();
                                cancelAll();
                                a.onError(this.errors.terminate());
                                return;
                            }
                        }
                    }
                    inner3 = inner;
                    this.requested.addAndGet(-e);
                    if (!continueNextSource) {
                        return;
                    }
                }
            }
        }
    }
}
