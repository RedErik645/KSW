package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelSortedJoin<T> extends Flowable<T> {
    final Comparator<? super T> comparator;
    final ParallelFlowable<List<T>> source;

    public ParallelSortedJoin(ParallelFlowable<List<T>> source2, Comparator<? super T> comparator2) {
        this.source = source2;
        this.comparator = comparator2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        SortedJoinSubscription<T> parent = new SortedJoinSubscription<>(s, this.source.parallelism(), this.comparator);
        s.onSubscribe(parent);
        this.source.subscribe(parent.subscribers);
    }

    /* access modifiers changed from: package-private */
    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final Subscriber<? super T> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final int[] indexes;
        final List<T>[] lists;
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();
        final SortedJoinInnerSubscriber<T>[] subscribers;

        SortedJoinSubscription(Subscriber<? super T> actual, int n, Comparator<? super T> comparator2) {
            this.downstream = actual;
            this.comparator = comparator2;
            SortedJoinInnerSubscriber<T>[] s = new SortedJoinInnerSubscriber[n];
            for (int i = 0; i < n; i++) {
                s[i] = new SortedJoinInnerSubscriber<>(this, i);
            }
            this.subscribers = s;
            this.lists = new List[n];
            this.indexes = new int[n];
            this.remaining.lazySet(n);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                BackpressureHelper.add(this.requested, n);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.lists, (Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAll() {
            for (SortedJoinInnerSubscriber<T> s : this.subscribers) {
                s.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerNext(List<T> value, int index) {
            this.lists[index] = value;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerError(Throwable e) {
            if (this.error.compareAndSet(null, e)) {
                drain();
            } else if (e != this.error.get()) {
                RxJavaPlugins.onError(e);
            }
        }

        /* JADX INFO: Multiple debug info for r12v4 int: [D('index' int), D('ex' java.lang.Throwable)] */
        /* access modifiers changed from: package-private */
        public void drain() {
            int missed;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> a = this.downstream;
                List<T>[] lists2 = this.lists;
                int[] indexes2 = this.indexes;
                int n = indexes2.length;
                int missed2 = 1;
                while (true) {
                    long r = this.requested.get();
                    long e = 0;
                    while (e != r) {
                        if (this.cancelled) {
                            Arrays.fill(lists2, (Object) null);
                            return;
                        }
                        Throwable ex = this.error.get();
                        if (ex != null) {
                            cancelAll();
                            Arrays.fill(lists2, (Object) null);
                            a.onError(ex);
                            return;
                        }
                        int i = 0;
                        int minIndex = -1;
                        T min = null;
                        while (i < n) {
                            List<T> list = lists2[i];
                            int index = indexes2[i];
                            if (list.size() == index) {
                                missed = missed2;
                            } else if (min == null) {
                                missed = missed2;
                                minIndex = i;
                                min = list.get(index);
                            } else {
                                missed = missed2;
                                T b = list.get(index);
                                try {
                                    if (this.comparator.compare(min, b) > 0) {
                                        min = b;
                                        minIndex = i;
                                    }
                                } catch (Throwable exc) {
                                    Exceptions.throwIfFatal(exc);
                                    cancelAll();
                                    Arrays.fill(lists2, (Object) null);
                                    if (!this.error.compareAndSet(null, exc)) {
                                        RxJavaPlugins.onError(exc);
                                    }
                                    a.onError(this.error.get());
                                    return;
                                }
                            }
                            i++;
                            ex = ex;
                            missed2 = missed;
                        }
                        if (min == null) {
                            Arrays.fill(lists2, (Object) null);
                            a.onComplete();
                            return;
                        }
                        a.onNext(min);
                        indexes2[minIndex] = indexes2[minIndex] + 1;
                        e++;
                        missed2 = missed2;
                    }
                    if (e == r) {
                        if (this.cancelled) {
                            Arrays.fill(lists2, (Object) null);
                            return;
                        }
                        Throwable ex2 = this.error.get();
                        if (ex2 != null) {
                            cancelAll();
                            Arrays.fill(lists2, (Object) null);
                            a.onError(ex2);
                            return;
                        }
                        boolean empty = true;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= n) {
                                break;
                            } else if (indexes2[i2] != lists2[i2].size()) {
                                empty = false;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (empty) {
                            Arrays.fill(lists2, (Object) null);
                            a.onComplete();
                            return;
                        }
                    }
                    if (!(e == 0 || r == LongCompanionObject.MAX_VALUE)) {
                        this.requested.addAndGet(-e);
                    }
                    int w = get();
                    if (w == missed2) {
                        missed2 = addAndGet(-missed2);
                        if (missed2 == 0) {
                            return;
                        }
                    } else {
                        missed2 = w;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((List) ((List) obj));
        }

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> parent2, int index2) {
            this.parent = parent2;
            this.index = index2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.setOnce(this, s, LongCompanionObject.MAX_VALUE);
        }

        public void onNext(List<T> t) {
            this.parent.innerNext(t, this.index);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.parent.innerError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        /* access modifiers changed from: package-private */
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}
