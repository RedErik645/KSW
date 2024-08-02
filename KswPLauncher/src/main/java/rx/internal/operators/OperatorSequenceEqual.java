package rx.internal.operators;

import rx.Observable;
import rx.functions.Func2;
import rx.internal.util.UtilityFunctions;

public final class OperatorSequenceEqual {
    static final Object LOCAL_ONCOMPLETED = new Object();

    private OperatorSequenceEqual() {
        throw new IllegalStateException("No instances!");
    }

    static <T> Observable<Object> materializeLite(Observable<T> source) {
        return Observable.concat(source, Observable.just(LOCAL_ONCOMPLETED));
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> first, Observable<? extends T> second, final Func2<? super T, ? super T, Boolean> equality) {
        return Observable.zip(materializeLite(first), materializeLite(second), new Func2<Object, Object, Boolean>() {
            /* class rx.internal.operators.OperatorSequenceEqual.AnonymousClass1 */

            @Override // rx.functions.Func2
            public Boolean call(Object t1, Object t2) {
                boolean c1 = t1 == OperatorSequenceEqual.LOCAL_ONCOMPLETED;
                boolean c2 = t2 == OperatorSequenceEqual.LOCAL_ONCOMPLETED;
                if (c1 && c2) {
                    return true;
                }
                if (c1 || c2) {
                    return false;
                }
                return (Boolean) equality.call(t1, t2);
            }
        }).all(UtilityFunctions.identity());
    }
}
