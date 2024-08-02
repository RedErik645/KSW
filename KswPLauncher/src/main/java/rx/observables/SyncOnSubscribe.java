package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaHooks;

public abstract class SyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {
    /* access modifiers changed from: protected */
    public abstract S generateState();

    /* access modifiers changed from: protected */
    public abstract S next(S s, Observer<? super T> observer);

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public final void call(Subscriber<? super T> subscriber) {
        try {
            SubscriptionProducer<S, T> p = new SubscriptionProducer<>(subscriber, this, generateState());
            subscriber.add(p);
            subscriber.setProducer(p);
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            subscriber.onError(e);
        }
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribe(S s) {
    }

    public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> generator, final Action2<? super S, ? super Observer<? super T>> next) {
        return new SyncOnSubscribeImpl(generator, new Func2<S, Observer<? super T>, S>() {
            /* class rx.observables.SyncOnSubscribe.AnonymousClass1 */

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1) {
                return call(x0, (Observer) ((Observer) x1));
            }

            public S call(S state, Observer<? super T> subscriber) {
                next.call(state, subscriber);
                return state;
            }
        });
    }

    public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> generator, final Action2<? super S, ? super Observer<? super T>> next, Action1<? super S> onUnsubscribe) {
        return new SyncOnSubscribeImpl(generator, new Func2<S, Observer<? super T>, S>() {
            /* class rx.observables.SyncOnSubscribe.AnonymousClass2 */

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1) {
                return call(x0, (Observer) ((Observer) x1));
            }

            public S call(S state, Observer<? super T> subscriber) {
                next.call(state, subscriber);
                return state;
            }
        }, onUnsubscribe);
    }

    public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> generator, Func2<? super S, ? super Observer<? super T>, ? extends S> next, Action1<? super S> onUnsubscribe) {
        return new SyncOnSubscribeImpl(generator, next, onUnsubscribe);
    }

    public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> generator, Func2<? super S, ? super Observer<? super T>, ? extends S> next) {
        return new SyncOnSubscribeImpl(generator, next);
    }

    public static <T> SyncOnSubscribe<Void, T> createStateless(final Action1<? super Observer<? super T>> next) {
        return new SyncOnSubscribeImpl(new Func2<Void, Observer<? super T>, Void>() {
            /* class rx.observables.SyncOnSubscribe.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Void call(Void r3, Object x1) {
                return call(r3, (Observer) ((Observer) x1));
            }

            public Void call(Void state, Observer<? super T> subscriber) {
                next.call(subscriber);
                return state;
            }
        });
    }

    public static <T> SyncOnSubscribe<Void, T> createStateless(final Action1<? super Observer<? super T>> next, final Action0 onUnsubscribe) {
        return new SyncOnSubscribeImpl(new Func2<Void, Observer<? super T>, Void>() {
            /* class rx.observables.SyncOnSubscribe.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Void call(Void r3, Object x1) {
                return call(r3, (Observer) ((Observer) x1));
            }

            public Void call(Void state, Observer<? super T> subscriber) {
                next.call(subscriber);
                return null;
            }
        }, new Action1<Void>() {
            /* class rx.observables.SyncOnSubscribe.AnonymousClass5 */

            public void call(Void t) {
                onUnsubscribe.call();
            }
        });
    }

    static final class SyncOnSubscribeImpl<S, T> extends SyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func2<? super S, ? super Observer<? super T>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        @Override // rx.observables.SyncOnSubscribe, rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            SyncOnSubscribe.super.call((Subscriber) ((Subscriber) x0));
        }

        SyncOnSubscribeImpl(Func0<? extends S> generator2, Func2<? super S, ? super Observer<? super T>, ? extends S> next2, Action1<? super S> onUnsubscribe2) {
            this.generator = generator2;
            this.next = next2;
            this.onUnsubscribe = onUnsubscribe2;
        }

        public SyncOnSubscribeImpl(Func0<? extends S> generator2, Func2<? super S, ? super Observer<? super T>, ? extends S> next2) {
            this(generator2, next2, null);
        }

        public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> next2, Action1<? super S> onUnsubscribe2) {
            this(null, next2, onUnsubscribe2);
        }

        public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> nextFunc) {
            this(null, nextFunc, null);
        }

        /* access modifiers changed from: protected */
        @Override // rx.observables.SyncOnSubscribe
        public S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return (S) func0.call();
        }

        /* access modifiers changed from: protected */
        @Override // rx.observables.SyncOnSubscribe
        public S next(S state, Observer<? super T> observer) {
            return (S) this.next.call(state, observer);
        }

        /* access modifiers changed from: protected */
        @Override // rx.observables.SyncOnSubscribe
        public void onUnsubscribe(S state) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(state);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        private static final long serialVersionUID = -3736864024352728072L;
        private final Subscriber<? super T> actualSubscriber;
        private boolean hasTerminated;
        private boolean onNextCalled;
        private final SyncOnSubscribe<S, T> parent;
        private S state;

        SubscriptionProducer(Subscriber<? super T> subscriber, SyncOnSubscribe<S, T> parent2, S state2) {
            this.actualSubscriber = subscriber;
            this.parent = parent2;
            this.state = state2;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            long requestCount;
            do {
                requestCount = get();
                if (compareAndSet(0, -1)) {
                    doUnsubscribe();
                    return;
                }
            } while (!compareAndSet(requestCount, -2));
        }

        private boolean tryUnsubscribe() {
            if (!this.hasTerminated && get() >= -1) {
                return false;
            }
            set(-1);
            doUnsubscribe();
            return true;
        }

        private void doUnsubscribe() {
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                RxJavaHooks.onError(e);
            }
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n > 0 && BackpressureUtils.getAndAddRequest(this, n) == 0) {
                if (n == LongCompanionObject.MAX_VALUE) {
                    fastpath();
                } else {
                    slowPath(n);
                }
            }
        }

        private void fastpath() {
            SyncOnSubscribe<S, T> p = this.parent;
            Subscriber<? super T> a = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(p);
                } catch (Throwable ex) {
                    handleThrownError(a, ex);
                    return;
                }
            } while (!tryUnsubscribe());
        }

        private void handleThrownError(Subscriber<? super T> a, Throwable ex) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(ex);
                return;
            }
            this.hasTerminated = true;
            a.onError(ex);
            unsubscribe();
        }

        private void slowPath(long n) {
            SyncOnSubscribe<S, T> p = this.parent;
            Subscriber<? super T> a = this.actualSubscriber;
            long numRequested = n;
            do {
                long numRemaining = numRequested;
                do {
                    try {
                        this.onNextCalled = false;
                        nextIteration(p);
                        if (!tryUnsubscribe()) {
                            if (this.onNextCalled) {
                                numRemaining--;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable ex) {
                        handleThrownError(a, ex);
                        return;
                    }
                } while (numRemaining != 0);
                numRequested = addAndGet(-numRequested);
            } while (numRequested > 0);
            tryUnsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> parent2) {
            this.state = parent2.next(this.state, this);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onCompleted();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onError(e);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Observer
        public void onNext(T value) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(value);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }
    }
}
