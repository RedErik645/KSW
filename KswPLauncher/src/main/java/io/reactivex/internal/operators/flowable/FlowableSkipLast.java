package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int skip;

    public FlowableSkipLast(Flowable<T> source, int skip2) {
        super(source);
        this.skip = skip2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        this.source.subscribe((FlowableSubscriber) new SkipLastSubscriber(s, this.skip));
    }

    static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3807491841935125653L;
        final Subscriber<? super T> downstream;
        final int skip;
        Subscription upstream;

        SkipLastSubscriber(Subscriber<? super T> actual, int skip2) {
            super(skip2);
            this.downstream = actual;
            this.skip = skip2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.skip == size()) {
                this.downstream.onNext((Object) poll());
            } else {
                this.upstream.request(1);
            }
            offer(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            this.downstream.onError(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            this.upstream.request(n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }
    }
}
