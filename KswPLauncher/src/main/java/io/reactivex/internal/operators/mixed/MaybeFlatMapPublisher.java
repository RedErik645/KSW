package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeFlatMapPublisher<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapPublisher(MaybeSource<T> source2, Function<? super T, ? extends Publisher<? extends R>> mapper2) {
        this.source = source2;
        this.mapper = mapper2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe(new FlatMapPublisherSubscriber(s, this.mapper));
    }

    static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        FlatMapPublisherSubscriber(Subscriber<? super R> downstream2, Function<? super T, ? extends Publisher<? extends R>> mapper2) {
            this.downstream = downstream2;
            this.mapper = mapper2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.MaybeObserver, org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.downstream.onError(t);
        }

        @Override // io.reactivex.MaybeObserver, org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            SubscriptionHelper.deferredRequest(this, this.requested, n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, s);
        }
    }
}
