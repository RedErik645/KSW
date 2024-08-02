package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action onAfterTerminate;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;

    public FlowableDoOnEach(Flowable<T> source, Consumer<? super T> onNext2, Consumer<? super Throwable> onError2, Action onComplete2, Action onAfterTerminate2) {
        super(source);
        this.onNext = onNext2;
        this.onError = onError2;
        this.onComplete = onComplete2;
        this.onAfterTerminate = onAfterTerminate2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        if (s instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber) new DoOnEachConditionalSubscriber((ConditionalSubscriber) s, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
        } else {
            this.source.subscribe((FlowableSubscriber) new DoOnEachSubscriber(s, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
        }
    }

    static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Action onAfterTerminate;
        final Action onComplete;
        final Consumer<? super Throwable> onError;
        final Consumer<? super T> onNext;

        DoOnEachSubscriber(Subscriber<? super T> actual, Consumer<? super T> onNext2, Consumer<? super Throwable> onError2, Action onComplete2, Action onAfterTerminate2) {
            super(actual);
            this.onNext = onNext2;
            this.onError = onError2;
            this.onComplete = onComplete2;
            this.onAfterTerminate = onAfterTerminate2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                    return;
                }
                try {
                    this.onNext.accept(t);
                    this.downstream.onNext(t);
                } catch (Throwable e) {
                    fail(e);
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            boolean relay = true;
            try {
                this.onError.accept(t);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(new CompositeException(t, e));
                relay = false;
            }
            if (relay) {
                this.downstream.onError(t);
            }
            try {
                this.onAfterTerminate.run();
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                RxJavaPlugins.onError(e2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                try {
                    this.onComplete.run();
                    this.done = true;
                    this.downstream.onComplete();
                    try {
                        this.onAfterTerminate.run();
                    } catch (Throwable e) {
                        Exceptions.throwIfFatal(e);
                        RxJavaPlugins.onError(e);
                    }
                } catch (Throwable e2) {
                    fail(e2);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            try {
                T v = (T) this.qs.poll();
                if (v != null) {
                    try {
                        this.onNext.accept(v);
                        this.onAfterTerminate.run();
                    } catch (Throwable exc) {
                        throw new CompositeException(ex, exc);
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                    this.onAfterTerminate.run();
                }
                return v;
            } catch (Throwable exc2) {
                throw new CompositeException(ex, exc2);
            }
        }
    }

    static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Action onAfterTerminate;
        final Action onComplete;
        final Consumer<? super Throwable> onError;
        final Consumer<? super T> onNext;

        DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> actual, Consumer<? super T> onNext2, Consumer<? super Throwable> onError2, Action onComplete2, Action onAfterTerminate2) {
            super(actual);
            this.onNext = onNext2;
            this.onError = onError2;
            this.onComplete = onComplete2;
            this.onAfterTerminate = onAfterTerminate2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                    return;
                }
                try {
                    this.onNext.accept(t);
                    this.downstream.onNext(t);
                } catch (Throwable e) {
                    fail(e);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            try {
                this.onNext.accept(t);
                return this.downstream.tryOnNext(t);
            } catch (Throwable e) {
                fail(e);
                return false;
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            boolean relay = true;
            try {
                this.onError.accept(t);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(new CompositeException(t, e));
                relay = false;
            }
            if (relay) {
                this.downstream.onError(t);
            }
            try {
                this.onAfterTerminate.run();
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                RxJavaPlugins.onError(e2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                try {
                    this.onComplete.run();
                    this.done = true;
                    this.downstream.onComplete();
                    try {
                        this.onAfterTerminate.run();
                    } catch (Throwable e) {
                        Exceptions.throwIfFatal(e);
                        RxJavaPlugins.onError(e);
                    }
                } catch (Throwable e2) {
                    fail(e2);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            try {
                T v = (T) this.qs.poll();
                if (v != null) {
                    try {
                        this.onNext.accept(v);
                        this.onAfterTerminate.run();
                    } catch (Throwable exc) {
                        throw new CompositeException(ex, exc);
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                    this.onAfterTerminate.run();
                }
                return v;
            } catch (Throwable exc2) {
                throw new CompositeException(ex, exc2);
            }
        }
    }
}
