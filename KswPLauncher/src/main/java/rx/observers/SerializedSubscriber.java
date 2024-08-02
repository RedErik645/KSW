package rx.observers;

import rx.Observer;
import rx.Subscriber;

public class SerializedSubscriber<T> extends Subscriber<T> {
    private final Observer<T> s;

    public SerializedSubscriber(Subscriber<? super T> s2) {
        this(s2, true);
    }

    public SerializedSubscriber(Subscriber<? super T> s2, boolean shareSubscriptions) {
        super(s2, shareSubscriptions);
        this.s = new SerializedObserver(s2);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.s.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        this.s.onError(e);
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.s.onNext(t);
    }
}