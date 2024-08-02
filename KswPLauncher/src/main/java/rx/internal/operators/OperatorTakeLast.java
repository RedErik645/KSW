package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorTakeLast<T> implements Observable.Operator<T, T> {
    final int count;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTakeLast(int count2) {
        if (count2 >= 0) {
            this.count = count2;
            return;
        }
        throw new IndexOutOfBoundsException("count cannot be negative");
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final TakeLastSubscriber<T> parent = new TakeLastSubscriber<>(subscriber, this.count);
        subscriber.add(parent);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorTakeLast.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long n) {
                parent.requestMore(n);
            }
        });
        return parent;
    }

    /* access modifiers changed from: package-private */
    public static final class TakeLastSubscriber<T> extends Subscriber<T> implements Func1<Object, T> {
        final Subscriber<? super T> actual;
        final int count;
        final NotificationLite<T> nl = NotificationLite.instance();
        final ArrayDeque<Object> queue = new ArrayDeque<>();
        final AtomicLong requested = new AtomicLong();

        public TakeLastSubscriber(Subscriber<? super T> actual2, int count2) {
            this.actual = actual2;
            this.count = count2;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.queue.size() == this.count) {
                this.queue.poll();
            }
            this.queue.offer(this.nl.next(t));
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.queue.clear();
            this.actual.onError(e);
        }

        @Override // rx.Observer
        public void onCompleted() {
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual, this);
        }

        @Override // rx.functions.Func1
        public T call(Object t) {
            return this.nl.getValue(t);
        }

        /* access modifiers changed from: package-private */
        public void requestMore(long n) {
            if (n > 0) {
                BackpressureUtils.postCompleteRequest(this.requested, n, this.queue, this.actual, this);
            }
        }
    }
}
