package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorSkipWhile<T> implements Observable.Operator<T, T> {
    final Func2<? super T, Integer, Boolean> predicate;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorSkipWhile(Func2<? super T, Integer, Boolean> predicate2) {
        this.predicate = predicate2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        return new Subscriber<T>(child) {
            /* class rx.internal.operators.OperatorSkipWhile.AnonymousClass1 */
            int index;
            boolean skipping = true;

            @Override // rx.Observer
            public void onNext(T t) {
                if (!this.skipping) {
                    child.onNext(t);
                    return;
                }
                try {
                    Func2<? super T, Integer, Boolean> func2 = OperatorSkipWhile.this.predicate;
                    int i = this.index;
                    this.index = i + 1;
                    if (!func2.call(t, Integer.valueOf(i)).booleanValue()) {
                        this.skipping = false;
                        child.onNext(t);
                        return;
                    }
                    request(1);
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, child, t);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                child.onError(e);
            }

            @Override // rx.Observer
            public void onCompleted() {
                child.onCompleted();
            }
        };
    }

    public static <T> Func2<T, Integer, Boolean> toPredicate2(final Func1<? super T, Boolean> predicate2) {
        return new Func2<T, Integer, Boolean>() {
            /* class rx.internal.operators.OperatorSkipWhile.AnonymousClass2 */

            public Boolean call(T t1, Integer t2) {
                return (Boolean) predicate2.call(t1);
            }
        };
    }
}
