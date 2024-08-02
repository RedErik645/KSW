package rx.internal.util;

import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

public final class ActionObserver<T> implements Observer<T> {
    final Action0 onCompleted;
    final Action1<Throwable> onError;
    final Action1<? super T> onNext;

    public ActionObserver(Action1<? super T> onNext2, Action1<Throwable> onError2, Action0 onCompleted2) {
        this.onNext = onNext2;
        this.onError = onError2;
        this.onCompleted = onCompleted2;
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.onNext.call(t);
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        this.onError.call(e);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.onCompleted.call();
    }
}
