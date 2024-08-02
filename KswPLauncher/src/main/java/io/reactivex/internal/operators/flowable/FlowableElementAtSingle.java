package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {
    final T defaultValue;
    final long index;
    final Flowable<T> source;

    public FlowableElementAtSingle(Flowable<T> source2, long index2, T defaultValue2) {
        this.source = source2;
        this.index = index2;
        this.defaultValue = defaultValue2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> observer) {
        this.source.subscribe((FlowableSubscriber) new ElementAtSubscriber(observer, this.index, this.defaultValue));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.source, this.index, this.defaultValue, true));
    }

    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        long count;
        final T defaultValue;
        boolean done;
        final SingleObserver<? super T> downstream;
        final long index;
        Subscription upstream;

        ElementAtSubscriber(SingleObserver<? super T> actual, long index2, T defaultValue2) {
            this.downstream = actual;
            this.index = index2;
            this.defaultValue = defaultValue2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
                s.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                long c = this.count;
                if (c == this.index) {
                    this.done = true;
                    this.upstream.cancel();
                    this.upstream = SubscriptionHelper.CANCELLED;
                    this.downstream.onSuccess(t);
                    return;
                }
                this.count = 1 + c;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
                return;
            }
            this.done = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            if (!this.done) {
                this.done = true;
                T v = this.defaultValue;
                if (v != null) {
                    this.downstream.onSuccess(v);
                } else {
                    this.downstream.onError(new NoSuchElementException());
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
        }
    }
}
