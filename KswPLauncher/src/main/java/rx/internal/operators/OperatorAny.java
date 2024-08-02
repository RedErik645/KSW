package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;
import rx.plugins.RxJavaHooks;

public final class OperatorAny<T> implements Observable.Operator<Boolean, T> {
    final Func1<? super T, Boolean> predicate;
    final boolean returnOnEmpty;

    public OperatorAny(Func1<? super T, Boolean> predicate2, boolean returnOnEmpty2) {
        this.predicate = predicate2;
        this.returnOnEmpty = returnOnEmpty2;
    }

    public Subscriber<? super T> call(final Subscriber<? super Boolean> child) {
        final SingleDelayedProducer<Boolean> producer = new SingleDelayedProducer<>(child);
        Subscriber<T> s = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorAny.AnonymousClass1 */
            boolean done;
            boolean hasElements;

            /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(T t) {
                if (!this.done) {
                    this.hasElements = true;
                    try {
                        if (OperatorAny.this.predicate.call(t).booleanValue()) {
                            this.done = true;
                            producer.setValue(Boolean.valueOf(true ^ OperatorAny.this.returnOnEmpty));
                            unsubscribe();
                        }
                    } catch (Throwable e) {
                        Exceptions.throwOrReport(e, this, t);
                    }
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                if (!this.done) {
                    this.done = true;
                    child.onError(e);
                    return;
                }
                RxJavaHooks.onError(e);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    if (this.hasElements) {
                        producer.setValue(false);
                    } else {
                        producer.setValue(Boolean.valueOf(OperatorAny.this.returnOnEmpty));
                    }
                }
            }
        };
        child.add(s);
        child.setProducer(producer);
        return s;
    }
}
