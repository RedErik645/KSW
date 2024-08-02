package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

public final class OperatorBufferWithSingleObservable<T, TClosing> implements Observable.Operator<List<T>, T> {
    final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
    final int initialCapacity;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> bufferClosingSelector2, int initialCapacity2) {
        this.bufferClosingSelector = bufferClosingSelector2;
        this.initialCapacity = initialCapacity2;
    }

    public OperatorBufferWithSingleObservable(final Observable<? extends TClosing> bufferClosing, int initialCapacity2) {
        this.bufferClosingSelector = new Func0<Observable<? extends TClosing>>() {
            /* class rx.internal.operators.OperatorBufferWithSingleObservable.AnonymousClass1 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<? extends TClosing> call() {
                return bufferClosing;
            }
        };
        this.initialCapacity = initialCapacity2;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> child) {
        try {
            Observable<? extends TClosing> closing = (Observable) this.bufferClosingSelector.call();
            final OperatorBufferWithSingleObservable<T, TClosing>.BufferingSubscriber bsub = new BufferingSubscriber(new SerializedSubscriber(child));
            Subscriber<TClosing> closingSubscriber = new Subscriber<TClosing>() {
                /* class rx.internal.operators.OperatorBufferWithSingleObservable.AnonymousClass2 */

                @Override // rx.Observer
                public void onNext(TClosing tclosing) {
                    bsub.emit();
                }

                @Override // rx.Observer
                public void onError(Throwable e) {
                    bsub.onError(e);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    bsub.onCompleted();
                }
            };
            child.add(closingSubscriber);
            child.add(bsub);
            closing.unsafeSubscribe(closingSubscriber);
            return bsub;
        } catch (Throwable t) {
            Exceptions.throwOrReport(t, child);
            return Subscribers.empty();
        }
    }

    /* access modifiers changed from: package-private */
    public final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk;
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> child2) {
            this.child = child2;
            this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            synchronized (this) {
                if (!this.done) {
                    this.chunk.add(t);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.chunk = null;
                    this.child.onError(e);
                    unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            Throwable th;
            try {
                synchronized (this) {
                    try {
                        if (!this.done) {
                            this.done = true;
                            List<T> toEmit = this.chunk;
                            try {
                                this.chunk = null;
                                this.child.onNext(toEmit);
                                this.child.onCompleted();
                                unsubscribe();
                            } catch (Throwable th2) {
                                th = th2;
                                while (true) {
                                    try {
                                        break;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        while (true) {
                            break;
                        }
                        throw th;
                    }
                }
            } catch (Throwable t) {
                Exceptions.throwOrReport(t, this.child);
            }
        }

        /* access modifiers changed from: package-private */
        public void emit() {
            Throwable t;
            synchronized (this) {
                try {
                    if (!this.done) {
                        List<T> toEmit = this.chunk;
                        try {
                            this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
                            try {
                                this.child.onNext(toEmit);
                            } catch (Throwable t2) {
                                unsubscribe();
                                synchronized (this) {
                                    if (!this.done) {
                                        this.done = true;
                                        Exceptions.throwOrReport(t2, this.child);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            t = th;
                            throw t;
                        }
                    }
                } catch (Throwable th2) {
                    t = th2;
                    throw t;
                }
            }
        }
    }
}
