package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    static final int QUEUE_LINK_SIZE = 4;
    final boolean delayError;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;
    Subscription upstream;

    public SerializedSubscriber(Subscriber<? super T> downstream2) {
        this(downstream2, false);
    }

    public SerializedSubscriber(Subscriber<? super T> actual, boolean delayError2) {
        this.downstream = actual;
        this.delayError = delayError2;
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
        if (!this.done) {
            if (t == null) {
                this.upstream.cancel();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> q = this.queue;
                        if (q == null) {
                            q = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = q;
                        }
                        q.add(NotificationLite.next(t));
                        return;
                    }
                    this.emitting = true;
                    this.downstream.onNext(t);
                    emitLoop();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r0 == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        io.reactivex.plugins.RxJavaPlugins.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        r3.downstream.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        return;
     */
    @Override // org.reactivestreams.Subscriber
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            boolean r0 = r3.done
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.onError(r4)
            return
        L_0x0008:
            monitor-enter(r3)
            boolean r0 = r3.done     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0039
        L_0x000f:
            boolean r0 = r3.emitting     // Catch:{ all -> 0x0046 }
            r1 = 1
            if (r0 == 0) goto L_0x0034
            r3.done = r1     // Catch:{ all -> 0x0046 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r3.queue     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0023
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r1 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0046 }
            r2 = 4
            r1.<init>(r2)     // Catch:{ all -> 0x0046 }
            r0 = r1
            r3.queue = r0     // Catch:{ all -> 0x0046 }
        L_0x0023:
            java.lang.Object r1 = io.reactivex.internal.util.NotificationLite.error(r4)     // Catch:{ all -> 0x0046 }
            boolean r2 = r3.delayError     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x002f
            r0.add(r1)     // Catch:{ all -> 0x0046 }
            goto L_0x0032
        L_0x002f:
            r0.setFirst(r1)     // Catch:{ all -> 0x0046 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            return
        L_0x0034:
            r3.done = r1     // Catch:{ all -> 0x0046 }
            r3.emitting = r1     // Catch:{ all -> 0x0046 }
            r0 = 0
        L_0x0039:
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0040
            io.reactivex.plugins.RxJavaPlugins.onError(r4)
            return
        L_0x0040:
            org.reactivestreams.Subscriber<? super T> r1 = r3.downstream
            r1.onError(r4)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subscribers.SerializedSubscriber.onError(java.lang.Throwable):void");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> q = this.queue;
                        if (q == null) {
                            q = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = q;
                        }
                        q.add(NotificationLite.complete());
                        return;
                    }
                    this.done = true;
                    this.emitting = true;
                    this.downstream.onComplete();
                }
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: org.reactivestreams.Subscriber<? super T>, org.reactivestreams.Subscriber<? super U> */
    /* access modifiers changed from: package-private */
    public void emitLoop() {
        AppendOnlyLinkedArrayList<Object> q;
        do {
            synchronized (this) {
                q = this.queue;
                if (q == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
        } while (!q.accept((Subscriber<? super T>) this.downstream));
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
