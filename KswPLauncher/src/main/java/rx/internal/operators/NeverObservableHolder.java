package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public enum NeverObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    static final Observable<Object> NEVER;

    static {
        NeverObservableHolder neverObservableHolder;
        NEVER = Observable.create(neverObservableHolder);
    }

    public static <T> Observable<T> instance() {
        return (Observable<T>) NEVER;
    }

    public void call(Subscriber<? super Object> subscriber) {
    }
}
