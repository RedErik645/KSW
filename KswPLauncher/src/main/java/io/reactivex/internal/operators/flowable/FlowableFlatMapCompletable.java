package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int maxConcurrency;

    public FlowableFlatMapCompletable(Flowable<T> source, Function<? super T, ? extends CompletableSource> mapper2, boolean delayErrors2, int maxConcurrency2) {
        super(source);
        this.mapper = mapper2;
        this.delayErrors = delayErrors2;
        this.maxConcurrency = maxConcurrency2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new FlatMapCompletableMainSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency));
    }

    static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final Subscriber<? super T> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final Function<? super T, ? extends CompletableSource> mapper;
        final int maxConcurrency;
        final CompositeDisposable set = new CompositeDisposable();
        Subscription upstream;

        FlatMapCompletableMainSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends CompletableSource> mapper2, boolean delayErrors2, int maxConcurrency2) {
            this.downstream = subscriber;
            this.mapper = mapper2;
            this.delayErrors = delayErrors2;
            this.maxConcurrency = maxConcurrency2;
            lazySet(1);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                int m = this.maxConcurrency;
                if (m == Integer.MAX_VALUE) {
                    s.request(LongCompanionObject.MAX_VALUE);
                } else {
                    s.request((long) m);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T value) {
            try {
                CompletableSource cs = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(value), "The mapper returned a null CompletableSource");
                getAndIncrement();
                FlatMapCompletableMainSubscriber<T>.InnerConsumer inner = new InnerConsumer();
                if (!this.cancelled && this.set.add(inner)) {
                    cs.subscribe(inner);
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.cancel();
                onError(ex);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable e) {
            if (!this.errors.addThrowable(e)) {
                RxJavaPlugins.onError(e);
            } else if (!this.delayErrors) {
                cancel();
                if (getAndSet(0) > 0) {
                    this.downstream.onError(this.errors.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.downstream.onError(this.errors.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable ex = this.errors.terminate();
                if (ex != null) {
                    this.downstream.onError(ex);
                } else {
                    this.downstream.onComplete();
                }
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return mode & 2;
        }

        /* access modifiers changed from: package-private */
        public void innerComplete(FlatMapCompletableMainSubscriber<T>.InnerConsumer inner) {
            this.set.delete(inner);
            onComplete();
        }

        /* access modifiers changed from: package-private */
        public void innerError(FlatMapCompletableMainSubscriber<T>.InnerConsumer inner, Throwable e) {
            this.set.delete(inner);
            onError(e);
        }

        final class InnerConsumer extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerConsumer() {
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.CompletableObserver
            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.innerComplete(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable e) {
                FlatMapCompletableMainSubscriber.this.innerError(this, e);
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }
        }
    }
}
