package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action1;

public class OperatorDoOnRequest<T> implements Observable.Operator<T, T> {
    final Action1<Long> request;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDoOnRequest(Action1<Long> request2) {
        this.request = request2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        final ParentSubscriber<T> parent = new ParentSubscriber<>(child);
        child.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorDoOnRequest.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long n) {
                OperatorDoOnRequest.this.request.call(Long.valueOf(n));
                parent.requestMore(n);
            }
        });
        child.add(parent);
        return parent;
    }

    /* access modifiers changed from: package-private */
    public static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> child;

        ParentSubscriber(Subscriber<? super T> child2) {
            this.child = child2;
            request(0);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void requestMore(long n) {
            request(n);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.child.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.child.onError(e);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.child.onNext(t);
        }
    }
}
