package rx.internal.operators;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeReduce<T> implements Observable.OnSubscribe<T> {
    final Func2<T, T, T> reducer;
    final Observable<T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeReduce(Observable<T> source2, Func2<T, T, T> reducer2) {
        this.source = source2;
        this.reducer = reducer2;
    }

    public void call(Subscriber<? super T> t) {
        final ReduceSubscriber<T> parent = new ReduceSubscriber<>(t, this.reducer);
        t.add(parent);
        t.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeReduce.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long n) {
                parent.downstreamRequest(n);
            }
        });
        this.source.unsafeSubscribe(parent);
    }

    /* access modifiers changed from: package-private */
    public static final class ReduceSubscriber<T> extends Subscriber<T> {
        static final Object EMPTY = new Object();
        final Subscriber<? super T> actual;
        boolean done;
        final Func2<T, T, T> reducer;
        T value = ((T) EMPTY);

        public ReduceSubscriber(Subscriber<? super T> actual2, Func2<T, T, T> reducer2) {
            this.actual = actual2;
            this.reducer = reducer2;
            request(0);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                T t2 = this.value;
                if (t2 == EMPTY) {
                    this.value = t;
                    return;
                }
                try {
                    this.value = this.reducer.call(t2, t);
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    unsubscribe();
                    onError(ex);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            if (!this.done) {
                this.done = true;
                this.actual.onError(e);
                return;
            }
            RxJavaHooks.onError(e);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                Object o = this.value;
                if (o != EMPTY) {
                    this.actual.onNext(o);
                    this.actual.onCompleted();
                    return;
                }
                this.actual.onError(new NoSuchElementException());
            }
        }

        /* access modifiers changed from: package-private */
        public void downstreamRequest(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + n);
            } else if (n != 0) {
                request(LongCompanionObject.MAX_VALUE);
            }
        }
    }
}
