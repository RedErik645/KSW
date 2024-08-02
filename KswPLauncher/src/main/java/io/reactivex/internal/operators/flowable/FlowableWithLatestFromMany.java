package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFromMany<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super Object[], R> combiner;
    final Publisher<?>[] otherArray;
    final Iterable<? extends Publisher<?>> otherIterable;

    public FlowableWithLatestFromMany(Flowable<T> source, Publisher<?>[] otherArray2, Function<? super Object[], R> combiner2) {
        super(source);
        this.otherArray = otherArray2;
        this.otherIterable = null;
        this.combiner = combiner2;
    }

    public FlowableWithLatestFromMany(Flowable<T> source, Iterable<? extends Publisher<?>> otherIterable2, Function<? super Object[], R> combiner2) {
        super(source);
        this.otherArray = null;
        this.otherIterable = otherIterable2;
        this.combiner = combiner2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> s) {
        Throwable ex;
        Publisher<?>[] others = this.otherArray;
        int n = 0;
        if (others == null) {
            others = new Publisher[8];
            try {
                for (Publisher<?> p : this.otherIterable) {
                    if (n == others.length) {
                        others = (Publisher[]) Arrays.copyOf(others, (n >> 1) + n);
                    }
                    int n2 = n + 1;
                    try {
                        others[n] = p;
                        n = n2;
                    } catch (Throwable th) {
                        ex = th;
                        Exceptions.throwIfFatal(ex);
                        EmptySubscription.error(ex, s);
                        return;
                    }
                }
            } catch (Throwable th2) {
                ex = th2;
                Exceptions.throwIfFatal(ex);
                EmptySubscription.error(ex, s);
                return;
            }
        } else {
            n = others.length;
        }
        if (n == 0) {
            new FlowableMap(this.source, new SingletonArrayFunc()).subscribeActual(s);
            return;
        }
        WithLatestFromSubscriber<T, R> parent = new WithLatestFromSubscriber<>(s, this.combiner, n);
        s.onSubscribe(parent);
        parent.subscribe(others, n);
        this.source.subscribe((FlowableSubscriber) parent);
    }

    static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1577321883966341961L;
        final Function<? super Object[], R> combiner;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicThrowable error;
        final AtomicLong requested;
        final WithLatestInnerSubscriber[] subscribers;
        final AtomicReference<Subscription> upstream;
        final AtomicReferenceArray<Object> values;

        WithLatestFromSubscriber(Subscriber<? super R> actual, Function<? super Object[], R> combiner2, int n) {
            this.downstream = actual;
            this.combiner = combiner2;
            WithLatestInnerSubscriber[] s = new WithLatestInnerSubscriber[n];
            for (int i = 0; i < n; i++) {
                s[i] = new WithLatestInnerSubscriber(this, i);
            }
            this.subscribers = s;
            this.values = new AtomicReferenceArray<>(n);
            this.upstream = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void subscribe(Publisher<?>[] others, int n) {
            WithLatestInnerSubscriber[] subscribers2 = this.subscribers;
            AtomicReference<Subscription> upstream2 = this.upstream;
            for (int i = 0; i < n && upstream2.get() != SubscriptionHelper.CANCELLED; i++) {
                others[i].subscribe(subscribers2[i]);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, s);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t) && !this.done) {
                this.upstream.get().request(1);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            AtomicReferenceArray<Object> ara = this.values;
            int n = ara.length();
            Object[] objects = new Object[(n + 1)];
            objects[0] = t;
            for (int i = 0; i < n; i++) {
                Object o = ara.get(i);
                if (o == null) {
                    return false;
                }
                objects[i + 1] = o;
            }
            try {
                HalfSerializer.onNext(this.downstream, ObjectHelper.requireNonNull(this.combiner.apply(objects), "The combiner returned a null value"), this, this.error);
                return true;
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                cancel();
                onError(ex);
                return false;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onError(this.downstream, t, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                cancelAllBut(-1);
                HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            for (WithLatestInnerSubscriber s : this.subscribers) {
                s.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerNext(int index, Object o) {
            this.values.set(index, o);
        }

        /* access modifiers changed from: package-private */
        public void innerError(int index, Throwable t) {
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(index);
            HalfSerializer.onError(this.downstream, t, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public void innerComplete(int index, boolean nonEmpty) {
            if (!nonEmpty) {
                this.done = true;
                SubscriptionHelper.cancel(this.upstream);
                cancelAllBut(index);
                HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAllBut(int index) {
            WithLatestInnerSubscriber[] subscribers2 = this.subscribers;
            for (int i = 0; i < subscribers2.length; i++) {
                if (i != index) {
                    subscribers2[i].dispose();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromSubscriber<?, ?> parent;

        WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> parent2, int index2) {
            this.parent = parent2;
            this.index = index2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, LongCompanionObject.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object t) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.parent.innerError(this.index, t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        /* access modifiers changed from: package-private */
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }
    }

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public R apply(T r4) throws java.lang.Exception {
            /*
                r3 = this;
                io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany r0 = io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.this
                io.reactivex.functions.Function<? super java.lang.Object[], R> r0 = r0.combiner
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                r1[r2] = r4
                java.lang.Object r0 = r0.apply(r1)
                java.lang.String r1 = "The combiner returned a null value"
                java.lang.Object r0 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.SingletonArrayFunc.apply(java.lang.Object):java.lang.Object");
        }
    }
}
