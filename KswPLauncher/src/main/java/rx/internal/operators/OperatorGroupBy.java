package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.UtilityFunctions;
import rx.observables.GroupedObservable;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.Subscriptions;

public final class OperatorGroupBy<T, K, V> implements Observable.Operator<GroupedObservable<K, V>, T> {
    final int bufferSize;
    final boolean delayError;
    final Func1<? super T, ? extends K> keySelector;
    final Func1<Action1<K>, Map<K, Object>> mapFactory;
    final Func1<? super T, ? extends V> valueSelector;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> keySelector2) {
        this(keySelector2, UtilityFunctions.identity(), RxRingBuffer.SIZE, false, null);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2) {
        this(keySelector2, valueSelector2, RxRingBuffer.SIZE, false, null);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2, Func1<Action1<K>, Map<K, Object>> mapFactory2) {
        this(keySelector2, valueSelector2, RxRingBuffer.SIZE, false, mapFactory2);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2, int bufferSize2, boolean delayError2, Func1<Action1<K>, Map<K, Object>> mapFactory2) {
        this.keySelector = keySelector2;
        this.valueSelector = valueSelector2;
        this.bufferSize = bufferSize2;
        this.delayError = delayError2;
        this.mapFactory = mapFactory2;
    }

    public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, V>> child) {
        try {
            final GroupBySubscriber<T, K, V> parent = new GroupBySubscriber<>(child, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, this.mapFactory);
            child.add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorGroupBy.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    parent.cancel();
                }
            }));
            child.setProducer(parent.producer);
            return parent;
        } catch (Throwable ex) {
            Exceptions.throwOrReport(ex, child);
            Subscriber<? super T> parent2 = Subscribers.empty();
            parent2.unsubscribe();
            return parent2;
        }
    }

    public static final class GroupByProducer implements Producer {
        final GroupBySubscriber<?, ?, ?> parent;

        public GroupByProducer(GroupBySubscriber<?, ?, ?> parent2) {
            this.parent = parent2;
        }

        @Override // rx.Producer
        public void request(long n) {
            this.parent.requestMore(n);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends Subscriber<T> {
        static final Object NULL_KEY = new Object();
        final Subscriber<? super GroupedObservable<K, V>> actual;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final Queue<K> evictedKeys;
        final AtomicInteger groupCount;
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Func1<? super T, ? extends K> keySelector;
        final GroupByProducer producer;
        final Queue<GroupedObservable<K, V>> queue = new ConcurrentLinkedQueue();
        final AtomicLong requested;
        final ProducerArbiter s;
        final Func1<? super T, ? extends V> valueSelector;
        final AtomicInteger wip;

        public GroupBySubscriber(Subscriber<? super GroupedObservable<K, V>> actual2, Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2, int bufferSize2, boolean delayError2, Func1<Action1<K>, Map<K, Object>> mapFactory) {
            this.actual = actual2;
            this.keySelector = keySelector2;
            this.valueSelector = valueSelector2;
            this.bufferSize = bufferSize2;
            this.delayError = delayError2;
            ProducerArbiter producerArbiter = new ProducerArbiter();
            this.s = producerArbiter;
            producerArbiter.request((long) bufferSize2);
            this.producer = new GroupByProducer(this);
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.groupCount = new AtomicInteger(1);
            this.wip = new AtomicInteger();
            if (mapFactory == null) {
                this.groups = new ConcurrentHashMap();
                this.evictedKeys = null;
                return;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            this.evictedKeys = concurrentLinkedQueue;
            this.groups = createMap(mapFactory, new EvictionAction(concurrentLinkedQueue));
        }

        static class EvictionAction<K> implements Action1<K> {
            final Queue<K> evictedKeys;

            EvictionAction(Queue<K> evictedKeys2) {
                this.evictedKeys = evictedKeys2;
            }

            @Override // rx.functions.Action1
            public void call(K key) {
                this.evictedKeys.offer(key);
            }
        }

        private Map<Object, GroupedUnicast<K, V>> createMap(Func1<Action1<K>, Map<K, Object>> mapFactory, Action1<K> evictionAction) {
            return mapFactory.call(evictionAction);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer s2) {
            this.s.setProducer(s2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: rx.internal.operators.OperatorGroupBy$GroupedUnicast */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                Queue<GroupedObservable<K, V>> q = this.queue;
                Subscriber<? super GroupedObservable<K, V>> a = this.actual;
                try {
                    Object call = this.keySelector.call(t);
                    boolean notNew = true;
                    Object mapKey = call != null ? call : NULL_KEY;
                    GroupedUnicast<K, V> group = this.groups.get(mapKey);
                    if (group == null) {
                        if (!this.cancelled.get()) {
                            group = GroupedUnicast.createWith(call, this.bufferSize, this, this.delayError);
                            this.groups.put(mapKey, group);
                            this.groupCount.getAndIncrement();
                            notNew = false;
                            q.offer(group);
                            drain();
                        } else {
                            return;
                        }
                    }
                    try {
                        group.onNext(this.valueSelector.call(t));
                        if (this.evictedKeys != null) {
                            while (true) {
                                K evictedKey = this.evictedKeys.poll();
                                if (evictedKey == null) {
                                    break;
                                }
                                GroupedUnicast<K, V> g = this.groups.get(evictedKey);
                                if (g != null) {
                                    g.onComplete();
                                }
                            }
                        }
                        if (notNew) {
                            this.s.request(1);
                        }
                    } catch (Throwable ex) {
                        unsubscribe();
                        errorAll(a, q, ex);
                    }
                } catch (Throwable ex2) {
                    unsubscribe();
                    errorAll(a, q, ex2);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaHooks.onError(t);
                return;
            }
            this.error = t;
            this.done = true;
            this.groupCount.decrementAndGet();
            drain();
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                for (GroupedUnicast<K, V> e : this.groups.values()) {
                    e.onComplete();
                }
                this.groups.clear();
                Queue<K> queue2 = this.evictedKeys;
                if (queue2 != null) {
                    queue2.clear();
                }
                this.done = true;
                this.groupCount.decrementAndGet();
                drain();
            }
        }

        public void requestMore(long n) {
            if (n >= 0) {
                BackpressureUtils.getAndAddRequest(this.requested, n);
                drain();
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + n);
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public void cancel(K key) {
            if (this.groups.remove(key != null ? key : NULL_KEY) != null && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int missed = 1;
                Queue<GroupedObservable<K, V>> q = this.queue;
                Subscriber<? super GroupedObservable<K, V>> a = this.actual;
                while (!checkTerminated(this.done, q.isEmpty(), a, q)) {
                    long r = this.requested.get();
                    long e = 0;
                    while (e != r) {
                        boolean d = this.done;
                        GroupedObservable<K, V> t = q.poll();
                        boolean empty = t == null;
                        if (!checkTerminated(d, empty, a, q)) {
                            if (empty) {
                                break;
                            }
                            a.onNext(t);
                            e++;
                        } else {
                            return;
                        }
                    }
                    if (e != 0) {
                        if (r != LongCompanionObject.MAX_VALUE) {
                            BackpressureUtils.produced(this.requested, e);
                        }
                        this.s.request(e);
                    }
                    missed = this.wip.addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void errorAll(Subscriber<? super GroupedObservable<K, V>> a, Queue<?> q, Throwable ex) {
            q.clear();
            List<GroupedUnicast<K, V>> list = new ArrayList<>(this.groups.values());
            this.groups.clear();
            Queue<K> queue2 = this.evictedKeys;
            if (queue2 != null) {
                queue2.clear();
            }
            for (GroupedUnicast<K, V> e : list) {
                e.onError(ex);
            }
            a.onError(ex);
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean d, boolean empty, Subscriber<? super GroupedObservable<K, V>> a, Queue<?> q) {
            if (!d) {
                return false;
            }
            Throwable err = this.error;
            if (err != null) {
                errorAll(a, q, err);
                return true;
            } else if (!empty) {
                return false;
            } else {
                this.actual.onCompleted();
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K key, int bufferSize, GroupBySubscriber<?, K, T> parent, boolean delayError) {
            return new GroupedUnicast<>(key, new State<>(bufferSize, parent, key, delayError));
        }

        protected GroupedUnicast(K key, State<T, K> state2) {
            super(key, state2);
            this.state = state2;
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        public void onError(Throwable e) {
            this.state.onError(e);
        }

        public void onComplete() {
            this.state.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class State<T, K> extends AtomicInteger implements Producer, Subscription, Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Subscriber<? super T>> actual;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once;
        final GroupBySubscriber<?, K, T> parent;
        final Queue<Object> queue = new ConcurrentLinkedQueue();
        final AtomicLong requested;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public State(int bufferSize, GroupBySubscriber<?, K, T> parent2, K key2, boolean delayError2) {
            this.parent = parent2;
            this.key = key2;
            this.delayError = delayError2;
            this.cancelled = new AtomicBoolean();
            this.actual = new AtomicReference<>();
            this.once = new AtomicBoolean();
            this.requested = new AtomicLong();
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
        public boolean isUnsubscribed() {
            return this.cancelled.get();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.parent.cancel(this.key);
            }
        }

        public void call(Subscriber<? super T> s) {
            if (this.once.compareAndSet(false, true)) {
                s.add(this);
                s.setProducer(this);
                this.actual.lazySet(s);
                drain();
                return;
            }
            s.onError(new IllegalStateException("Only one Subscriber allowed!"));
        }

        public void onNext(T t) {
            if (t == null) {
                this.error = new NullPointerException();
                this.done = true;
            } else {
                this.queue.offer(NotificationLite.instance().next(t));
            }
            drain();
        }

        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                Queue<Object> q = this.queue;
                boolean delayError2 = this.delayError;
                Subscriber<? super T> a = this.actual.get();
                NotificationLite<T> nl = NotificationLite.instance();
                while (true) {
                    if (a != null) {
                        if (!checkTerminated(this.done, q.isEmpty(), a, delayError2)) {
                            long r = this.requested.get();
                            long e = 0;
                            while (e != r) {
                                boolean d = this.done;
                                Object v = q.poll();
                                boolean empty = v == null;
                                if (!checkTerminated(d, empty, a, delayError2)) {
                                    if (empty) {
                                        break;
                                    }
                                    a.onNext(nl.getValue(v));
                                    e++;
                                } else {
                                    return;
                                }
                            }
                            if (e != 0) {
                                if (r != LongCompanionObject.MAX_VALUE) {
                                    BackpressureUtils.produced(this.requested, e);
                                }
                                this.parent.s.request(e);
                            }
                        } else {
                            return;
                        }
                    }
                    missed = addAndGet(-missed);
                    if (missed != 0) {
                        if (a == null) {
                            a = this.actual.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean d, boolean empty, Subscriber<? super T> a, boolean delayError2) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                return true;
            } else if (!d) {
                return false;
            } else {
                if (!delayError2) {
                    Throwable e = this.error;
                    if (e != null) {
                        this.queue.clear();
                        a.onError(e);
                        return true;
                    } else if (!empty) {
                        return false;
                    } else {
                        a.onCompleted();
                        return true;
                    }
                } else if (!empty) {
                    return false;
                } else {
                    Throwable e2 = this.error;
                    if (e2 != null) {
                        a.onError(e2);
                    } else {
                        a.onCompleted();
                    }
                    return true;
                }
            }
        }
    }
}
