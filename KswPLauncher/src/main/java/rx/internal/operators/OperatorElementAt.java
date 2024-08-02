package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OperatorElementAt<T> implements Observable.Operator<T, T> {
    final T defaultValue;
    final boolean hasDefault;
    final int index;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorElementAt(int index2) {
        this(index2, null, false);
    }

    public OperatorElementAt(int index2, T defaultValue2) {
        this(index2, defaultValue2, true);
    }

    private OperatorElementAt(int index2, T defaultValue2, boolean hasDefault2) {
        if (index2 >= 0) {
            this.index = index2;
            this.defaultValue = defaultValue2;
            this.hasDefault = hasDefault2;
            return;
        }
        throw new IndexOutOfBoundsException(index2 + " is out of bounds");
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        Subscriber<T> parent = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorElementAt.AnonymousClass1 */
            private int currentIndex;

            @Override // rx.Observer
            public void onNext(T value) {
                int i = this.currentIndex;
                this.currentIndex = i + 1;
                if (i == OperatorElementAt.this.index) {
                    child.onNext(value);
                    child.onCompleted();
                    unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                child.onError(e);
            }

            @Override // rx.Observer
            public void onCompleted() {
                if (this.currentIndex > OperatorElementAt.this.index) {
                    return;
                }
                if (OperatorElementAt.this.hasDefault) {
                    child.onNext(OperatorElementAt.this.defaultValue);
                    child.onCompleted();
                    return;
                }
                child.onError(new IndexOutOfBoundsException(OperatorElementAt.this.index + " is out of bounds"));
            }

            @Override // rx.Subscriber
            public void setProducer(Producer p) {
                child.setProducer(new InnerProducer(p));
            }
        };
        child.add(parent);
        return parent;
    }

    static class InnerProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 1;
        final Producer actual;

        public InnerProducer(Producer actual2) {
            this.actual = actual2;
        }

        @Override // rx.Producer
        public void request(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            } else if (n > 0 && compareAndSet(false, true)) {
                this.actual.request(LongCompanionObject.MAX_VALUE);
            }
        }
    }
}
