package rx.internal.operators;

import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithSelector<T, U> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends Observable<U>> selector;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDebounceWithSelector(Func1<? super T, ? extends Observable<U>> selector2) {
        this.selector = selector2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        final SerializedSubscriber<T> s = new SerializedSubscriber<>(child);
        final SerialSubscription ssub = new SerialSubscription();
        child.add(ssub);
        return new Subscriber<T>(child) {
            /* class rx.internal.operators.OperatorDebounceWithSelector.AnonymousClass1 */
            final Subscriber<?> self = this;
            final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState<>();

            @Override // rx.Subscriber
            public void onStart() {
                request(LongCompanionObject.MAX_VALUE);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                try {
                    Observable<U> debouncer = (Observable) OperatorDebounceWithSelector.this.selector.call(t);
                    final int index = this.state.next(t);
                    Subscriber<U> debounceSubscriber = new Subscriber<U>() {
                        /* class rx.internal.operators.OperatorDebounceWithSelector.AnonymousClass1.AnonymousClass1 */

                        @Override // rx.Observer
                        public void onNext(U u) {
                            onCompleted();
                        }

                        @Override // rx.Observer
                        public void onError(Throwable e) {
                            AnonymousClass1.this.self.onError(e);
                        }

                        @Override // rx.Observer
                        public void onCompleted() {
                            AnonymousClass1.this.state.emit(index, s, AnonymousClass1.this.self);
                            unsubscribe();
                        }
                    };
                    ssub.set(debounceSubscriber);
                    debouncer.unsafeSubscribe(debounceSubscriber);
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, this);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                s.onError(e);
                unsubscribe();
                this.state.clear();
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.state.emitAndComplete(s, this);
            }
        };
    }
}
