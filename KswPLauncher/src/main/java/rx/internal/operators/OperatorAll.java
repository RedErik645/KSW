package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;
import rx.plugins.RxJavaHooks;

public final class OperatorAll<T> implements Observable.Operator<Boolean, T> {
    final Func1<? super T, Boolean> predicate;

    public OperatorAll(Func1<? super T, Boolean> predicate2) {
        this.predicate = predicate2;
    }

    public Subscriber<? super T> call(final Subscriber<? super Boolean> child) {
        final SingleDelayedProducer<Boolean> producer = new SingleDelayedProducer<>(child);
        Subscriber<T> s = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorAll.AnonymousClass1 */
            boolean done;

            /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(T t) {
                if (!this.done) {
                    try {
                        if (!OperatorAll.this.predicate.call(t).booleanValue()) {
                            this.done = true;
                            producer.setValue(false);
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

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    producer.setValue(true);
                }
            }
        };
        child.add(s);
        child.setProducer(producer);
        return s;
    }
}
