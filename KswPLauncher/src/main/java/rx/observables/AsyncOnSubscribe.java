package rx.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public abstract class AsyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {
    /* access modifiers changed from: protected */
    public abstract S generateState();

    /* access modifiers changed from: protected */
    public abstract S next(S s, long j, Observer<Observable<? extends T>> observer);

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribe(S s) {
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> generator, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> next) {
        return new AsyncOnSubscribeImpl(generator, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Object call(Object x0, Long l, Object x2) {
                return call(x0, l, (Observer) ((Observer) x2));
            }

            public S call(S state, Long requested, Observer<Observable<? extends T>> subscriber) {
                next.call(state, requested, subscriber);
                return state;
            }
        });
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> generator, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> next, Action1<? super S> onUnsubscribe) {
        return new AsyncOnSubscribeImpl(generator, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Object call(Object x0, Long l, Object x2) {
                return call(x0, l, (Observer) ((Observer) x2));
            }

            public S call(S state, Long requested, Observer<Observable<? extends T>> subscriber) {
                next.call(state, requested, subscriber);
                return state;
            }
        }, onUnsubscribe);
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> generator, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next, Action1<? super S> onUnsubscribe) {
        return new AsyncOnSubscribeImpl(generator, next, onUnsubscribe);
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> generator, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next) {
        return new AsyncOnSubscribeImpl(generator, next);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> next) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Void call(Void r4, Long l, Object x2) {
                return call(r4, l, (Observer) ((Observer) x2));
            }

            public Void call(Void state, Long requested, Observer<Observable<? extends T>> subscriber) {
                next.call(requested, subscriber);
                return state;
            }
        });
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> next, final Action0 onUnsubscribe) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Void call(Void r4, Long l, Object x2) {
                return call(r4, l, (Observer) ((Observer) x2));
            }

            public Void call(Void state, Long requested, Observer<Observable<? extends T>> subscriber) {
                next.call(requested, subscriber);
                return null;
            }
        }, new Action1<Void>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass5 */

            public void call(Void t) {
                onUnsubscribe.call();
            }
        });
    }

    static final class AsyncOnSubscribeImpl<S, T> extends AsyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        @Override // rx.observables.AsyncOnSubscribe, rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            AsyncOnSubscribe.super.call((Subscriber) ((Subscriber) x0));
        }

        AsyncOnSubscribeImpl(Func0<? extends S> generator2, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next2, Action1<? super S> onUnsubscribe2) {
            this.generator = generator2;
            this.next = next2;
            this.onUnsubscribe = onUnsubscribe2;
        }

        public AsyncOnSubscribeImpl(Func0<? extends S> generator2, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next2) {
            this(generator2, next2, null);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> next2, Action1<? super S> onUnsubscribe2) {
            this(null, next2, onUnsubscribe2);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> nextFunc) {
            this(null, nextFunc, null);
        }

        /* access modifiers changed from: protected */
        @Override // rx.observables.AsyncOnSubscribe
        public S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return (S) func0.call();
        }

        /* access modifiers changed from: protected */
        @Override // rx.observables.AsyncOnSubscribe
        public S next(S state, long requested, Observer<Observable<? extends T>> observer) {
            return (S) this.next.call(state, Long.valueOf(requested), observer);
        }

        /* access modifiers changed from: protected */
        @Override // rx.observables.AsyncOnSubscribe
        public void onUnsubscribe(S state) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(state);
            }
        }
    }

    public final void call(final Subscriber<? super T> actualSubscriber) {
        try {
            S state = generateState();
            UnicastSubject<Observable<T>> subject = UnicastSubject.create();
            final AsyncOuterManager<S, T> outerProducer = new AsyncOuterManager<>(this, state, subject);
            Subscriber<T> concatSubscriber = new Subscriber<T>() {
                /* class rx.observables.AsyncOnSubscribe.AnonymousClass6 */

                @Override // rx.Observer
                public void onNext(T t) {
                    actualSubscriber.onNext(t);
                }

                @Override // rx.Observer
                public void onError(Throwable e) {
                    actualSubscriber.onError(e);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    actualSubscriber.onCompleted();
                }

                @Override // rx.Subscriber
                public void setProducer(Producer p) {
                    outerProducer.setConcatProducer(p);
                }
            };
            subject.onBackpressureBuffer().concatMap(new Func1<Observable<T>, Observable<T>>() {
                /* class rx.observables.AsyncOnSubscribe.AnonymousClass7 */

                @Override // rx.functions.Func1
                public /* bridge */ /* synthetic */ Object call(Object x0) {
                    return call((Observable) ((Observable) x0));
                }

                public Observable<T> call(Observable<T> v) {
                    return v.onBackpressureBuffer();
                }
            }).unsafeSubscribe(concatSubscriber);
            actualSubscriber.add(concatSubscriber);
            actualSubscriber.add(outerProducer);
            actualSubscriber.setProducer(outerProducer);
        } catch (Throwable ex) {
            actualSubscriber.onError(ex);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class AsyncOuterManager<S, T> implements Producer, Subscription, Observer<Observable<? extends T>> {
        Producer concatProducer;
        boolean emitting;
        long expectedDelivery;
        private boolean hasTerminated;
        final AtomicBoolean isUnsubscribed;
        private final UnicastSubject<Observable<T>> merger;
        private boolean onNextCalled;
        private final AsyncOnSubscribe<S, T> parent;
        List<Long> requests;
        private final SerializedObserver<Observable<? extends T>> serializedSubscriber;
        private S state;
        final CompositeSubscription subscriptions = new CompositeSubscription();

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Observable) ((Observable) x0));
        }

        public AsyncOuterManager(AsyncOnSubscribe<S, T> parent2, S initialState, UnicastSubject<Observable<T>> merger2) {
            this.parent = parent2;
            this.serializedSubscriber = new SerializedObserver<>(this);
            this.state = initialState;
            this.merger = merger2;
            this.isUnsubscribed = new AtomicBoolean();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.isUnsubscribed.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        ArrayList arrayList = new ArrayList();
                        this.requests = arrayList;
                        arrayList.add(0L);
                        return;
                    }
                    this.emitting = true;
                    cleanup();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setConcatProducer(Producer p) {
            if (this.concatProducer == null) {
                this.concatProducer = p;
                return;
            }
            throw new IllegalStateException("setConcatProducer may be called at most once!");
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.isUnsubscribed.get();
        }

        public void nextIteration(long requestCount) {
            this.state = this.parent.next(this.state, requestCount, this.serializedSubscriber);
        }

        /* access modifiers changed from: package-private */
        public void cleanup() {
            this.subscriptions.unsubscribe();
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable ex) {
                handleThrownError(ex);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0048, code lost:
            r2 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
            if (r2.hasNext() == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0060, code lost:
            if (tryEmit(r2.next().longValue()) == false) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0062, code lost:
            return;
         */
        @Override // rx.Producer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void request(long r7) {
            /*
            // Method dump skipped, instructions count: 134
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.observables.AsyncOnSubscribe.AsyncOuterManager.request(long):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
            if (tryEmit(r6) == false) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            r0 = r5.requests;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0034, code lost:
            if (r0 != null) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r5.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0039, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x003a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x003b, code lost:
            r5.requests = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x003e, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x003f, code lost:
            r1 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0047, code lost:
            if (r1.hasNext() == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
            if (tryEmit(r1.next().longValue()) == false) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x005c, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x005d, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x005e, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x005f, code lost:
            r1 = th;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestRemaining(long r6) {
            /*
            // Method dump skipped, instructions count: 125
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.observables.AsyncOnSubscribe.AsyncOuterManager.requestRemaining(long):void");
        }

        /* access modifiers changed from: package-private */
        public boolean tryEmit(long n) {
            if (isUnsubscribed()) {
                cleanup();
                return true;
            }
            try {
                this.onNextCalled = false;
                this.expectedDelivery = n;
                nextIteration(n);
                if (!this.hasTerminated) {
                    if (!isUnsubscribed()) {
                        if (this.onNextCalled) {
                            return false;
                        }
                        handleThrownError(new IllegalStateException("No events emitted!"));
                        return true;
                    }
                }
                cleanup();
                return true;
            } catch (Throwable ex) {
                handleThrownError(ex);
                return true;
            }
        }

        private void handleThrownError(Throwable ex) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(ex);
                return;
            }
            this.hasTerminated = true;
            this.merger.onError(ex);
            cleanup();
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onError(e);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public void onNext(Observable<? extends T> t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                if (!this.hasTerminated) {
                    subscribeBufferToObservable(t);
                    return;
                }
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        private void subscribeBufferToObservable(Observable<? extends T> t) {
            BufferUntilSubscriber<T> buffer = BufferUntilSubscriber.create();
            final Subscriber<T> s = new Subscriber<T>(this.expectedDelivery, buffer) {
                /* class rx.observables.AsyncOnSubscribe.AsyncOuterManager.AnonymousClass1 */
                long remaining;
                final /* synthetic */ BufferUntilSubscriber val$buffer;
                final /* synthetic */ long val$expected;

                {
                    this.val$expected = r2;
                    this.val$buffer = r4;
                    this.remaining = r2;
                }

                @Override // rx.Observer
                public void onNext(T t) {
                    this.remaining--;
                    this.val$buffer.onNext(t);
                }

                @Override // rx.Observer
                public void onError(Throwable e) {
                    this.val$buffer.onError(e);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    this.val$buffer.onCompleted();
                    long r = this.remaining;
                    if (r > 0) {
                        AsyncOuterManager.this.requestRemaining(r);
                    }
                }
            };
            this.subscriptions.add(s);
            t.doOnTerminate(new Action0() {
                /* class rx.observables.AsyncOnSubscribe.AsyncOuterManager.AnonymousClass2 */

                @Override // rx.functions.Action0
                public void call() {
                    AsyncOuterManager.this.subscriptions.remove(s);
                }
            }).subscribe((Subscriber<? super Object>) s);
            this.merger.onNext(buffer);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class UnicastSubject<T> extends Observable<T> implements Observer<T> {
        private final State<T> state;

        public static <T> UnicastSubject<T> create() {
            return new UnicastSubject<>(new State());
        }

        protected UnicastSubject(State<T> state2) {
            super(state2);
            this.state = state2;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.subscriber.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.state.subscriber.onError(e);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.state.subscriber.onNext(t);
        }

        /* access modifiers changed from: package-private */
        public static final class State<T> implements Observable.OnSubscribe<T> {
            Subscriber<? super T> subscriber;

            State() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(Subscriber<? super T> s) {
                synchronized (this) {
                    if (this.subscriber == null) {
                        this.subscriber = s;
                    } else {
                        s.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }
    }
}
