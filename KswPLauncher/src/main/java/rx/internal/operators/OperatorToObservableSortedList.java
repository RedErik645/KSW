package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableSortedList<T> implements Observable.Operator<List<T>, T> {
    private static final Comparator DEFAULT_SORT_FUNCTION = new DefaultComparableFunction();
    final int initialCapacity;
    final Comparator<? super T> sortFunction;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorToObservableSortedList(int initialCapacity2) {
        this.sortFunction = DEFAULT_SORT_FUNCTION;
        this.initialCapacity = initialCapacity2;
    }

    public OperatorToObservableSortedList(final Func2<? super T, ? super T, Integer> sortFunction2, int initialCapacity2) {
        this.initialCapacity = initialCapacity2;
        this.sortFunction = new Comparator<T>() {
            /* class rx.internal.operators.OperatorToObservableSortedList.AnonymousClass1 */

            @Override // java.util.Comparator
            public int compare(T o1, T o2) {
                return ((Integer) sortFunction2.call(o1, o2)).intValue();
            }
        };
    }

    public Subscriber<? super T> call(final Subscriber<? super List<T>> child) {
        final SingleDelayedProducer<List<T>> producer = new SingleDelayedProducer<>(child);
        Subscriber<T> result = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorToObservableSortedList.AnonymousClass2 */
            boolean completed;
            List<T> list;

            {
                this.list = new ArrayList(OperatorToObservableSortedList.this.initialCapacity);
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(LongCompanionObject.MAX_VALUE);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    List<T> a = this.list;
                    this.list = null;
                    try {
                        Collections.sort(a, OperatorToObservableSortedList.this.sortFunction);
                        producer.setValue(a);
                    } catch (Throwable e) {
                        Exceptions.throwOrReport(e, this);
                    }
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                child.onError(e);
            }

            @Override // rx.Observer
            public void onNext(T value) {
                if (!this.completed) {
                    this.list.add(value);
                }
            }
        };
        child.add(result);
        child.setProducer(producer);
        return result;
    }

    static final class DefaultComparableFunction implements Comparator<Object> {
        DefaultComparableFunction() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.Comparable */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public int compare(Object t1, Object t2) {
            return ((Comparable) t1).compareTo((Comparable) t2);
        }
    }
}
