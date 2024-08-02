package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.schedulers.Schedulers;
import rx.subscriptions.SerialSubscription;

public final class OperatorRetryWithPredicate<T> implements Observable.Operator<T, Observable<T>> {
    final Func2<Integer, Throwable, Boolean> predicate;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> predicate2) {
        this.predicate = predicate2;
    }

    public Subscriber<? super Observable<T>> call(Subscriber<? super T> child) {
        Scheduler.Worker inner = Schedulers.trampoline().createWorker();
        child.add(inner);
        SerialSubscription serialSubscription = new SerialSubscription();
        child.add(serialSubscription);
        ProducerArbiter pa = new ProducerArbiter();
        child.setProducer(pa);
        return new SourceSubscriber(child, this.predicate, inner, serialSubscription, pa);
    }

    /* access modifiers changed from: package-private */
    public static final class SourceSubscriber<T> extends Subscriber<Observable<T>> {
        final AtomicInteger attempts = new AtomicInteger();
        final Subscriber<? super T> child;
        final Scheduler.Worker inner;
        final ProducerArbiter pa;
        final Func2<Integer, Throwable, Boolean> predicate;
        final SerialSubscription serialSubscription;

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Observable) ((Observable) x0));
        }

        public SourceSubscriber(Subscriber<? super T> child2, Func2<Integer, Throwable, Boolean> predicate2, Scheduler.Worker inner2, SerialSubscription serialSubscription2, ProducerArbiter pa2) {
            this.child = child2;
            this.predicate = predicate2;
            this.inner = inner2;
            this.serialSubscription = serialSubscription2;
            this.pa = pa2;
        }

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.child.onError(e);
        }

        public void onNext(final Observable<T> o) {
            this.inner.schedule(new Action0() {
                /* class rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    SourceSubscriber.this.attempts.incrementAndGet();
                    AnonymousClass1 r1 = new Subscriber<T>() {
                        /* class rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.AnonymousClass1.AnonymousClass1 */
                        boolean done;

                        @Override // rx.Observer
                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                SourceSubscriber.this.child.onCompleted();
                            }
                        }

                        @Override // rx.Observer
                        public void onError(Throwable e) {
                            if (!this.done) {
                                this.done = true;
                                if (!SourceSubscriber.this.predicate.call(Integer.valueOf(SourceSubscriber.this.attempts.get()), e).booleanValue() || SourceSubscriber.this.inner.isUnsubscribed()) {
                                    SourceSubscriber.this.child.onError(e);
                                } else {
                                    SourceSubscriber.this.inner.schedule(this);
                                }
                            }
                        }

                        @Override // rx.Observer
                        public void onNext(T v) {
                            if (!this.done) {
                                SourceSubscriber.this.child.onNext(v);
                                SourceSubscriber.this.pa.produced(1);
                            }
                        }

                        @Override // rx.Subscriber
                        public void setProducer(Producer p) {
                            SourceSubscriber.this.pa.setProducer(p);
                        }
                    };
                    SourceSubscriber.this.serialSubscription.set(r1);
                    o.unsafeSubscribe(r1);
                }
            });
        }
    }
}
