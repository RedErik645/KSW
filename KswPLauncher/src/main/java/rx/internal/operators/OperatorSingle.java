package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;
import rx.internal.producers.SingleProducer;
import rx.plugins.RxJavaHooks;

public final class OperatorSingle<T> implements Observable.Operator<T, T> {
    private final T defaultValue;
    private final boolean hasDefaultValue;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* access modifiers changed from: package-private */
    public static final class Holder {
        static final OperatorSingle<?> INSTANCE = new OperatorSingle<>();

        Holder() {
        }
    }

    public static <T> OperatorSingle<T> instance() {
        return (OperatorSingle<T>) Holder.INSTANCE;
    }

    OperatorSingle() {
        this(false, null);
    }

    public OperatorSingle(T defaultValue2) {
        this(true, defaultValue2);
    }

    private OperatorSingle(boolean hasDefaultValue2, T defaultValue2) {
        this.hasDefaultValue = hasDefaultValue2;
        this.defaultValue = defaultValue2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        ParentSubscriber<T> parent = new ParentSubscriber<>(child, this.hasDefaultValue, this.defaultValue);
        child.add(parent);
        return parent;
    }

    /* access modifiers changed from: package-private */
    public static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> child;
        private final T defaultValue;
        private final boolean hasDefaultValue;
        private boolean hasTooManyElements;
        private boolean isNonEmpty;
        private T value;

        ParentSubscriber(Subscriber<? super T> child2, boolean hasDefaultValue2, T defaultValue2) {
            this.child = child2;
            this.hasDefaultValue = hasDefaultValue2;
            this.defaultValue = defaultValue2;
            request(2);
        }

        @Override // rx.Observer
        public void onNext(T value2) {
            if (!this.hasTooManyElements) {
                if (this.isNonEmpty) {
                    this.hasTooManyElements = true;
                    this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                    unsubscribe();
                    return;
                }
                this.value = value2;
                this.isNonEmpty = true;
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.hasTooManyElements) {
                if (this.isNonEmpty) {
                    this.child.setProducer(new SingleProducer(this.child, this.value));
                } else if (this.hasDefaultValue) {
                    this.child.setProducer(new SingleProducer(this.child, this.defaultValue));
                } else {
                    this.child.onError(new NoSuchElementException("Sequence contains no elements"));
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (this.hasTooManyElements) {
                RxJavaHooks.onError(e);
            } else {
                this.child.onError(e);
            }
        }
    }
}
