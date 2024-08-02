package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableList<T> implements Observable.Operator<List<T>, T> {
    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* access modifiers changed from: package-private */
    public static final class Holder {
        static final OperatorToObservableList<Object> INSTANCE = new OperatorToObservableList<>();

        Holder() {
        }
    }

    public static <T> OperatorToObservableList<T> instance() {
        return (OperatorToObservableList<T>) Holder.INSTANCE;
    }

    OperatorToObservableList() {
    }

    public Subscriber<? super T> call(final Subscriber<? super List<T>> o) {
        final SingleDelayedProducer<List<T>> producer = new SingleDelayedProducer<>(o);
        Subscriber<T> result = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorToObservableList.AnonymousClass1 */
            boolean completed;
            List<T> list = new LinkedList();

            @Override // rx.Subscriber
            public void onStart() {
                request(LongCompanionObject.MAX_VALUE);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    try {
                        ArrayList arrayList = new ArrayList(this.list);
                        this.list = null;
                        producer.setValue(arrayList);
                    } catch (Throwable t) {
                        Exceptions.throwOrReport(t, this);
                    }
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                o.onError(e);
            }

            @Override // rx.Observer
            public void onNext(T value) {
                if (!this.completed) {
                    this.list.add(value);
                }
            }
        };
        o.add(result);
        o.setProducer(producer);
        return result;
    }
}
