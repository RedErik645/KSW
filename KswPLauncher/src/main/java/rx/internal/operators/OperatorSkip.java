package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OperatorSkip<T> implements Observable.Operator<T, T> {
    final int toSkip;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorSkip(int n) {
        if (n >= 0) {
            this.toSkip = n;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + n);
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        return new Subscriber<T>(child) {
            /* class rx.internal.operators.OperatorSkip.AnonymousClass1 */
            int skipped;

            @Override // rx.Observer
            public void onCompleted() {
                child.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                child.onError(e);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (this.skipped >= OperatorSkip.this.toSkip) {
                    child.onNext(t);
                } else {
                    this.skipped++;
                }
            }

            @Override // rx.Subscriber
            public void setProducer(Producer producer) {
                child.setProducer(producer);
                producer.request((long) OperatorSkip.this.toSkip);
            }
        };
    }
}
