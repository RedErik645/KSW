package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Callable<? extends R> onCompleteSupplier;
    final Function<? super Throwable, ? extends R> onErrorMapper;
    final Function<? super T, ? extends R> onNextMapper;

    public FlowableMapNotification(Flowable<T> source, Function<? super T, ? extends R> onNextMapper2, Function<? super Throwable, ? extends R> onErrorMapper2, Callable<? extends R> onCompleteSupplier2) {
        super(source);
        this.onNextMapper = onNextMapper2;
        this.onErrorMapper = onErrorMapper2;
        this.onCompleteSupplier = onCompleteSupplier2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe((FlowableSubscriber) new MapNotificationSubscriber(s, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
    }

    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Callable<? extends R> onCompleteSupplier;
        final Function<? super Throwable, ? extends R> onErrorMapper;
        final Function<? super T, ? extends R> onNextMapper;

        MapNotificationSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends R> onNextMapper2, Function<? super Throwable, ? extends R> onErrorMapper2, Callable<? extends R> onCompleteSupplier2) {
            super(actual);
            this.onNextMapper = onNextMapper2;
            this.onErrorMapper = onErrorMapper2;
            this.onCompleteSupplier = onCompleteSupplier2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: org.reactivestreams.Subscriber */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Object requireNonNull = ObjectHelper.requireNonNull(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.downstream.onNext(requireNonNull);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(e);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.reactivex.internal.operators.flowable.FlowableMapNotification$MapNotificationSubscriber<T, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            try {
                complete(ObjectHelper.requireNonNull(this.onErrorMapper.apply(t), "The onError publisher returned is null"));
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(new CompositeException(t, e));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.internal.operators.flowable.FlowableMapNotification$MapNotificationSubscriber<T, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                complete(ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(e);
            }
        }
    }
}
