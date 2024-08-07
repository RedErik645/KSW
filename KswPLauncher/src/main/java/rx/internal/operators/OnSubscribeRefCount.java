package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeRefCount<T> implements Observable.OnSubscribe<T> {
    volatile CompositeSubscription baseSubscription = new CompositeSubscription();
    final ReentrantLock lock = new ReentrantLock();
    private final ConnectableObservable<? extends T> source;
    final AtomicInteger subscriptionCount = new AtomicInteger(0);

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeRefCount(ConnectableObservable<? extends T> source2) {
        this.source = source2;
    }

    public void call(Subscriber<? super T> subscriber) {
        this.lock.lock();
        if (this.subscriptionCount.incrementAndGet() == 1) {
            AtomicBoolean writeLocked = new AtomicBoolean(true);
            try {
                this.source.connect(onSubscribe(subscriber, writeLocked));
            } finally {
                if (writeLocked.get()) {
                    this.lock.unlock();
                }
            }
        } else {
            try {
                doSubscribe(subscriber, this.baseSubscription);
            } finally {
                this.lock.unlock();
            }
        }
    }

    private Action1<Subscription> onSubscribe(final Subscriber<? super T> subscriber, final AtomicBoolean writeLocked) {
        return new Action1<Subscription>() {
            /* class rx.internal.operators.OnSubscribeRefCount.AnonymousClass1 */

            public void call(Subscription subscription) {
                try {
                    OnSubscribeRefCount.this.baseSubscription.add(subscription);
                    OnSubscribeRefCount onSubscribeRefCount = OnSubscribeRefCount.this;
                    onSubscribeRefCount.doSubscribe(subscriber, onSubscribeRefCount.baseSubscription);
                } finally {
                    OnSubscribeRefCount.this.lock.unlock();
                    writeLocked.set(false);
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void doSubscribe(final Subscriber<? super T> subscriber, final CompositeSubscription currentBase) {
        subscriber.add(disconnect(currentBase));
        this.source.unsafeSubscribe(new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OnSubscribeRefCount.AnonymousClass2 */

            @Override // rx.Observer
            public void onError(Throwable e) {
                cleanup();
                subscriber.onError(e);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                subscriber.onNext(t);
            }

            @Override // rx.Observer
            public void onCompleted() {
                cleanup();
                subscriber.onCompleted();
            }

            /* access modifiers changed from: package-private */
            public void cleanup() {
                OnSubscribeRefCount.this.lock.lock();
                try {
                    if (OnSubscribeRefCount.this.baseSubscription == currentBase) {
                        OnSubscribeRefCount.this.baseSubscription.unsubscribe();
                        OnSubscribeRefCount.this.baseSubscription = new CompositeSubscription();
                        OnSubscribeRefCount.this.subscriptionCount.set(0);
                    }
                } finally {
                    OnSubscribeRefCount.this.lock.unlock();
                }
            }
        });
    }

    private Subscription disconnect(final CompositeSubscription current) {
        return Subscriptions.create(new Action0() {
            /* class rx.internal.operators.OnSubscribeRefCount.AnonymousClass3 */

            @Override // rx.functions.Action0
            public void call() {
                OnSubscribeRefCount.this.lock.lock();
                try {
                    if (OnSubscribeRefCount.this.baseSubscription == current && OnSubscribeRefCount.this.subscriptionCount.decrementAndGet() == 0) {
                        OnSubscribeRefCount.this.baseSubscription.unsubscribe();
                        OnSubscribeRefCount.this.baseSubscription = new CompositeSubscription();
                    }
                } finally {
                    OnSubscribeRefCount.this.lock.unlock();
                }
            }
        });
    }
}
