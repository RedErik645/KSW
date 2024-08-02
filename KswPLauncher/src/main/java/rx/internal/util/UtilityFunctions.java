package rx.internal.util;

import rx.functions.Func1;

public final class UtilityFunctions {
    private UtilityFunctions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Func1<? super T, Boolean> alwaysTrue() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> Func1<? super T, Boolean> alwaysFalse() {
        return AlwaysFalse.INSTANCE;
    }

    public static <T> Func1<T, T> identity() {
        return new Func1<T, T>() {
            /* class rx.internal.util.UtilityFunctions.AnonymousClass1 */

            @Override // rx.functions.Func1
            public T call(T o) {
                return o;
            }
        };
    }

    enum AlwaysTrue implements Func1<Object, Boolean> {
        INSTANCE;

        @Override // rx.functions.Func1
        public Boolean call(Object o) {
            return true;
        }
    }

    enum AlwaysFalse implements Func1<Object, Boolean> {
        INSTANCE;

        @Override // rx.functions.Func1
        public Boolean call(Object o) {
            return false;
        }
    }
}
