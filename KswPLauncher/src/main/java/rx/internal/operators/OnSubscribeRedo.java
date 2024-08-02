package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeRedo<T> implements Observable.OnSubscribe<T> {
    static final Func1<Observable<? extends Notification<?>>, Observable<?>> REDO_INFINITE = new Func1<Observable<? extends Notification<?>>, Observable<?>>() {
        /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass1 */

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<?> */
        public Observable<?> call(Observable<? extends Notification<?>> ts) {
            return (Observable<R>) ts.map(new Func1<Notification<?>, Notification<?>>() {
                /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass1.AnonymousClass1 */

                public Notification<?> call(Notification<?> notification) {
                    return Notification.createOnNext(null);
                }
            });
        }
    };
    private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> controlHandlerFunction;
    private final Scheduler scheduler;
    final Observable<T> source;
    final boolean stopOnComplete;
    final boolean stopOnError;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public static final class RedoFinite implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        final long count;

        public RedoFinite(long count2) {
            this.count = count2;
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: rx.Observable<T2>, rx.Observable<?> */
        public Observable<?> call(Observable<? extends Notification<?>> ts) {
            return (Observable<T2>) ts.map(new Func1<Notification<?>, Notification<?>>() {
                /* class rx.internal.operators.OnSubscribeRedo.RedoFinite.AnonymousClass1 */
                int num;

                public Notification<?> call(Notification<?> terminalNotification) {
                    if (RedoFinite.this.count == 0) {
                        return terminalNotification;
                    }
                    int i = this.num + 1;
                    this.num = i;
                    if (((long) i) <= RedoFinite.this.count) {
                        return Notification.createOnNext(Integer.valueOf(this.num));
                    }
                    return terminalNotification;
                }
            }).dematerialize();
        }
    }

    public static final class RetryWithPredicate implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>> {
        final Func2<Integer, Throwable, Boolean> predicate;

        public RetryWithPredicate(Func2<Integer, Throwable, Boolean> predicate2) {
            this.predicate = predicate2;
        }

        public Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> ts) {
            return ts.scan(Notification.createOnNext(0), new Func2<Notification<Integer>, Notification<?>, Notification<Integer>>() {
                /* class rx.internal.operators.OnSubscribeRedo.RetryWithPredicate.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: rx.Notification<?> */
                /* JADX WARN: Multi-variable type inference failed */
                public Notification<Integer> call(Notification<Integer> n, Notification<?> term) {
                    int value = n.getValue().intValue();
                    if (RetryWithPredicate.this.predicate.call(Integer.valueOf(value), term.getThrowable()).booleanValue()) {
                        return Notification.createOnNext(Integer.valueOf(value + 1));
                    }
                    return term;
                }
            });
        }
    }

    public static <T> Observable<T> retry(Observable<T> source2) {
        return retry(source2, REDO_INFINITE);
    }

    public static <T> Observable<T> retry(Observable<T> source2, long count) {
        if (count < 0) {
            throw new IllegalArgumentException("count >= 0 expected");
        } else if (count == 0) {
            return source2;
        } else {
            return retry(source2, new RedoFinite(count));
        }
    }

    public static <T> Observable<T> retry(Observable<T> source2, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> notificationHandler) {
        return Observable.create(new OnSubscribeRedo(source2, notificationHandler, true, false, Schedulers.trampoline()));
    }

    public static <T> Observable<T> retry(Observable<T> source2, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> notificationHandler, Scheduler scheduler2) {
        return Observable.create(new OnSubscribeRedo(source2, notificationHandler, true, false, scheduler2));
    }

    public static <T> Observable<T> repeat(Observable<T> source2) {
        return repeat(source2, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable<T> source2, Scheduler scheduler2) {
        return repeat(source2, REDO_INFINITE, scheduler2);
    }

    public static <T> Observable<T> repeat(Observable<T> source2, long count) {
        return repeat(source2, count, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable<T> source2, long count, Scheduler scheduler2) {
        if (count == 0) {
            return Observable.empty();
        }
        if (count >= 0) {
            return repeat(source2, new RedoFinite(count - 1), scheduler2);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> Observable<T> repeat(Observable<T> source2, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> notificationHandler) {
        return Observable.create(new OnSubscribeRedo(source2, notificationHandler, false, true, Schedulers.trampoline()));
    }

    public static <T> Observable<T> repeat(Observable<T> source2, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> notificationHandler, Scheduler scheduler2) {
        return Observable.create(new OnSubscribeRedo(source2, notificationHandler, false, true, scheduler2));
    }

    public static <T> Observable<T> redo(Observable<T> source2, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> notificationHandler, Scheduler scheduler2) {
        return Observable.create(new OnSubscribeRedo(source2, notificationHandler, false, false, scheduler2));
    }

    private OnSubscribeRedo(Observable<T> source2, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> f, boolean stopOnComplete2, boolean stopOnError2, Scheduler scheduler2) {
        this.source = source2;
        this.controlHandlerFunction = f;
        this.stopOnComplete = stopOnComplete2;
        this.stopOnError = stopOnError2;
        this.scheduler = scheduler2;
    }

    public void call(final Subscriber<? super T> child) {
        final AtomicBoolean resumeBoundary = new AtomicBoolean(true);
        final AtomicLong consumerCapacity = new AtomicLong();
        final Scheduler.Worker worker = this.scheduler.createWorker();
        child.add(worker);
        final SerialSubscription sourceSubscriptions = new SerialSubscription();
        child.add(sourceSubscriptions);
        final Subject<Notification<?>, Notification<?>> terminals = BehaviorSubject.create().toSerialized();
        terminals.subscribe((Subscriber<? super Notification<?>>) Subscribers.empty());
        final ProducerArbiter arbiter = new ProducerArbiter();
        final Action0 subscribeToSource = new Action0() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                if (!child.isUnsubscribed()) {
                    Subscriber<T> terminalDelegatingSubscriber = new Subscriber<T>() {
                        /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass2.AnonymousClass1 */
                        boolean done;

                        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.subjects.Subject */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // rx.Observer
                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                terminals.onNext(Notification.createOnCompleted());
                            }
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.subjects.Subject */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // rx.Observer
                        public void onError(Throwable e) {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                terminals.onNext(Notification.createOnError(e));
                            }
                        }

                        @Override // rx.Observer
                        public void onNext(T v) {
                            if (!this.done) {
                                child.onNext(v);
                                decrementConsumerCapacity();
                                arbiter.produced(1);
                            }
                        }

                        private void decrementConsumerCapacity() {
                            long cc;
                            do {
                                cc = consumerCapacity.get();
                                if (cc == LongCompanionObject.MAX_VALUE) {
                                    return;
                                }
                            } while (!consumerCapacity.compareAndSet(cc, cc - 1));
                        }

                        @Override // rx.Subscriber
                        public void setProducer(Producer producer) {
                            arbiter.setProducer(producer);
                        }
                    };
                    sourceSubscriptions.set(terminalDelegatingSubscriber);
                    OnSubscribeRedo.this.source.unsafeSubscribe(terminalDelegatingSubscriber);
                }
            }
        };
        final Observable<?> restarts = (Observable) this.controlHandlerFunction.call(terminals.lift(new Observable.Operator<Notification<?>, Notification<?>>() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass3 */

            public Subscriber<? super Notification<?>> call(final Subscriber<? super Notification<?>> filteredTerminals) {
                return new Subscriber<Notification<?>>(filteredTerminals) {
                    /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass3.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onCompleted() {
                        filteredTerminals.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable e) {
                        filteredTerminals.onError(e);
                    }

                    public void onNext(Notification<?> t) {
                        if (t.isOnCompleted() && OnSubscribeRedo.this.stopOnComplete) {
                            filteredTerminals.onCompleted();
                        } else if (!t.isOnError() || !OnSubscribeRedo.this.stopOnError) {
                            filteredTerminals.onNext(t);
                        } else {
                            filteredTerminals.onError(t.getThrowable());
                        }
                    }

                    @Override // rx.Subscriber
                    public void setProducer(Producer producer) {
                        producer.request(LongCompanionObject.MAX_VALUE);
                    }
                };
            }
        }));
        worker.schedule(new Action0() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass4 */

            @Override // rx.functions.Action0
            public void call() {
                restarts.unsafeSubscribe(new Subscriber<Object>(child) {
                    /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass4.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onCompleted() {
                        child.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable e) {
                        child.onError(e);
                    }

                    @Override // rx.Observer
                    public void onNext(Object t) {
                        if (child.isUnsubscribed()) {
                            return;
                        }
                        if (consumerCapacity.get() > 0) {
                            worker.schedule(subscribeToSource);
                        } else {
                            resumeBoundary.compareAndSet(false, true);
                        }
                    }

                    @Override // rx.Subscriber
                    public void setProducer(Producer producer) {
                        producer.request(LongCompanionObject.MAX_VALUE);
                    }
                });
            }
        });
        child.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass5 */

            @Override // rx.Producer
            public void request(long n) {
                if (n > 0) {
                    BackpressureUtils.getAndAddRequest(consumerCapacity, n);
                    arbiter.request(n);
                    if (resumeBoundary.compareAndSet(true, false)) {
                        worker.schedule(subscribeToSource);
                    }
                }
            }
        });
    }
}
