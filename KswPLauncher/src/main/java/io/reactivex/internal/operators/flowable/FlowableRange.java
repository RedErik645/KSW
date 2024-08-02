package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;

public final class FlowableRange extends Flowable<Integer> {
    final int end;
    final int start;

    public FlowableRange(int start2, int count) {
        this.start = start2;
        this.end = start2 + count;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Integer> s) {
        if (s instanceof ConditionalSubscriber) {
            s.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) s, this.start, this.end));
        } else {
            s.onSubscribe(new RangeSubscription(s, this.start, this.end));
        }
    }

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        /* access modifiers changed from: package-private */
        public abstract void fastPath();

        /* access modifiers changed from: package-private */
        public abstract void slowPath(long j);

        BaseRangeSubscription(int index2, int end2) {
            this.index = index2;
            this.end = end2;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int mode) {
            return mode & 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final Integer poll() {
            int i = this.index;
            if (i == this.end) {
                return null;
            }
            this.index = i + 1;
            return Integer.valueOf(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.end;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long n) {
            if (SubscriptionHelper.validate(n) && BackpressureHelper.add(this, n) == 0) {
                if (n == LongCompanionObject.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(n);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Integer> downstream;

        RangeSubscription(Subscriber<? super Integer> actual, int index, int end) {
            super(index, end);
            this.downstream = actual;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void fastPath() {
            int f = this.end;
            Subscriber<? super Integer> a = this.downstream;
            for (int i = this.index; i != f; i++) {
                if (!this.cancelled) {
                    a.onNext(Integer.valueOf(i));
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                a.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void slowPath(long r) {
            long e = 0;
            int f = this.end;
            int i = this.index;
            Subscriber<? super Integer> a = this.downstream;
            while (true) {
                if (e == r || i == f) {
                    if (i != f) {
                        r = get();
                        if (e == r) {
                            this.index = i;
                            r = addAndGet(-e);
                            if (r != 0) {
                                e = 0;
                            } else {
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.cancelled) {
                        a.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    a.onNext(Integer.valueOf(i));
                    e++;
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Integer> downstream;

        RangeConditionalSubscription(ConditionalSubscriber<? super Integer> actual, int index, int end) {
            super(index, end);
            this.downstream = actual;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void fastPath() {
            int f = this.end;
            ConditionalSubscriber<? super Integer> a = this.downstream;
            for (int i = this.index; i != f; i++) {
                if (!this.cancelled) {
                    a.tryOnNext(Integer.valueOf(i));
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                a.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void slowPath(long r) {
            long e = 0;
            int f = this.end;
            int i = this.index;
            ConditionalSubscriber<? super Integer> a = this.downstream;
            while (true) {
                if (e == r || i == f) {
                    if (i != f) {
                        r = get();
                        if (e == r) {
                            this.index = i;
                            r = addAndGet(-e);
                            if (r != 0) {
                                e = 0;
                            } else {
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.cancelled) {
                        a.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    if (a.tryOnNext(Integer.valueOf(i))) {
                        e++;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
