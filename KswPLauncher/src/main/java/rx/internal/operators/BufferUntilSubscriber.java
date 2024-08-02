package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class BufferUntilSubscriber<T> extends Subject<T, T> {
    static final Observer EMPTY_OBSERVER = new Observer() {
        /* class rx.internal.operators.BufferUntilSubscriber.AnonymousClass1 */

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
        }

        @Override // rx.Observer
        public void onNext(Object t) {
        }
    };
    private boolean forward;
    final State<T> state;

    public static <T> BufferUntilSubscriber<T> create() {
        return new BufferUntilSubscriber<>(new State<>());
    }

    /* access modifiers changed from: package-private */
    public static final class State<T> extends AtomicReference<Observer<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;
        final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();
        boolean emitting;
        final Object guard = new Object();
        final NotificationLite<T> nl = NotificationLite.instance();

        State() {
        }

        /* access modifiers changed from: package-private */
        public boolean casObserverRef(Observer<? super T> expected, Observer<? super T> next) {
            return compareAndSet(expected, next);
        }
    }

    static final class OnSubscribeAction<T> implements Observable.OnSubscribe<T> {
        final State<T> state;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public OnSubscribeAction(State<T> state2) {
            this.state = state2;
        }

        public void call(Subscriber<? super T> s) {
            if (this.state.casObserverRef(null, s)) {
                s.add(Subscriptions.create(new Action0() {
                    /* class rx.internal.operators.BufferUntilSubscriber.OnSubscribeAction.AnonymousClass1 */

                    @Override // rx.functions.Action0
                    public void call() {
                        OnSubscribeAction.this.state.set(BufferUntilSubscriber.EMPTY_OBSERVER);
                    }
                }));
                boolean win = false;
                synchronized (this.state.guard) {
                    if (!this.state.emitting) {
                        this.state.emitting = true;
                        win = true;
                    }
                }
                if (win) {
                    NotificationLite<T> nl = NotificationLite.instance();
                    while (true) {
                        Object o = this.state.buffer.poll();
                        if (o != null) {
                            nl.accept((Observer) this.state.get(), o);
                        } else {
                            synchronized (this.state.guard) {
                                if (this.state.buffer.isEmpty()) {
                                    this.state.emitting = false;
                                    return;
                                }
                            }
                        }
                    }
                }
            } else {
                s.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    private BufferUntilSubscriber(State<T> state2) {
        super(new OnSubscribeAction(state2));
        this.state = state2;
    }

    private void emit(Object v) {
        synchronized (this.state.guard) {
            this.state.buffer.add(v);
            if (this.state.get() != null && !this.state.emitting) {
                this.forward = true;
                this.state.emitting = true;
            }
        }
        if (this.forward) {
            while (true) {
                Object o = this.state.buffer.poll();
                if (o != null) {
                    this.state.nl.accept((Observer) this.state.get(), o);
                } else {
                    return;
                }
            }
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.forward) {
            ((Observer) this.state.get()).onCompleted();
        } else {
            emit(this.state.nl.completed());
        }
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        if (this.forward) {
            ((Observer) this.state.get()).onError(e);
        } else {
            emit(this.state.nl.error(e));
        }
    }

    @Override // rx.Observer
    public void onNext(T t) {
        if (this.forward) {
            ((Observer) this.state.get()).onNext(t);
        } else {
            emit(this.state.nl.next(t));
        }
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        boolean z;
        synchronized (this.state.guard) {
            z = this.state.get() != null;
        }
        return z;
    }
}
