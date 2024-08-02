package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OperatorOnErrorResumeNextViaFunction<T> implements Observable.Operator<T, T> {
    final Func1<Throwable, ? extends Observable<? extends T>> resumeFunction;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withSingle(final Func1<Throwable, ? extends T> resumeFunction2) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() {
            /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass1 */

            public Observable<? extends T> call(Throwable t) {
                return Observable.just(resumeFunction2.call(t));
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withOther(final Observable<? extends T> other) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() {
            /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass2 */

            public Observable<? extends T> call(Throwable t) {
                return other;
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withException(final Observable<? extends T> other) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() {
            /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass3 */

            public Observable<? extends T> call(Throwable t) {
                if (t instanceof Exception) {
                    return other;
                }
                return Observable.error(t);
            }
        });
    }

    public OperatorOnErrorResumeNextViaFunction(Func1<Throwable, ? extends Observable<? extends T>> f) {
        this.resumeFunction = f;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        final ProducerArbiter pa = new ProducerArbiter();
        final SerialSubscription ssub = new SerialSubscription();
        Subscriber<T> parent = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass4 */
            private boolean done;
            long produced;

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    child.onCompleted();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                if (this.done) {
                    Exceptions.throwIfFatal(e);
                    RxJavaHooks.onError(e);
                    return;
                }
                this.done = true;
                try {
                    unsubscribe();
                    Subscriber<? super Object> r0 = new Subscriber<T>() {
                        /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass4.AnonymousClass1 */

                        @Override // rx.Observer
                        public void onNext(T t) {
                            child.onNext(t);
                        }

                        @Override // rx.Observer
                        public void onError(Throwable e) {
                            child.onError(e);
                        }

                        @Override // rx.Observer
                        public void onCompleted() {
                            child.onCompleted();
                        }

                        @Override // rx.Subscriber
                        public void setProducer(Producer producer) {
                            pa.setProducer(producer);
                        }
                    };
                    ssub.set(r0);
                    long p = this.produced;
                    if (p != 0) {
                        pa.produced(p);
                    }
                    ((Observable) OperatorOnErrorResumeNextViaFunction.this.resumeFunction.call(e)).unsafeSubscribe(r0);
                } catch (Throwable e2) {
                    Exceptions.throwOrReport(e2, child);
                }
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (!this.done) {
                    this.produced++;
                    child.onNext(t);
                }
            }

            @Override // rx.Subscriber
            public void setProducer(Producer producer) {
                pa.setProducer(producer);
            }
        };
        ssub.set(parent);
        child.add(ssub);
        child.setProducer(pa);
        return parent;
    }
}
