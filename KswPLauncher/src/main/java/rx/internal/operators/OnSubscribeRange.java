package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeRange implements Observable.OnSubscribe<Integer> {
    private final int endIndex;
    private final int startIndex;

    public OnSubscribeRange(int start, int end) {
        this.startIndex = start;
        this.endIndex = end;
    }

    public void call(Subscriber<? super Integer> childSubscriber) {
        childSubscriber.setProducer(new RangeProducer(childSubscriber, this.startIndex, this.endIndex));
    }

    /* access modifiers changed from: package-private */
    public static final class RangeProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = 4114392207069098388L;
        private final Subscriber<? super Integer> childSubscriber;
        private long currentIndex;
        private final int endOfRange;

        RangeProducer(Subscriber<? super Integer> childSubscriber2, int startIndex, int endIndex) {
            this.childSubscriber = childSubscriber2;
            this.currentIndex = (long) startIndex;
            this.endOfRange = endIndex;
        }

        @Override // rx.Producer
        public void request(long requestedAmount) {
            if (get() != LongCompanionObject.MAX_VALUE) {
                if (requestedAmount == LongCompanionObject.MAX_VALUE && compareAndSet(0, LongCompanionObject.MAX_VALUE)) {
                    fastpath();
                } else if (requestedAmount > 0 && BackpressureUtils.getAndAddRequest(this, requestedAmount) == 0) {
                    slowpath(requestedAmount);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void slowpath(long requestedAmount) {
            long emitted = 0;
            long endIndex = ((long) this.endOfRange) + 1;
            long index = this.currentIndex;
            Subscriber<? super Integer> childSubscriber2 = this.childSubscriber;
            while (true) {
                if (emitted == requestedAmount || index == endIndex) {
                    if (!childSubscriber2.isUnsubscribed()) {
                        if (index == endIndex) {
                            childSubscriber2.onCompleted();
                            return;
                        }
                        requestedAmount = get();
                        if (requestedAmount == emitted) {
                            this.currentIndex = index;
                            requestedAmount = addAndGet(-emitted);
                            if (requestedAmount != 0) {
                                emitted = 0;
                            } else {
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        return;
                    }
                } else if (!childSubscriber2.isUnsubscribed()) {
                    childSubscriber2.onNext(Integer.valueOf((int) index));
                    index++;
                    emitted++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void fastpath() {
            long endIndex = ((long) this.endOfRange) + 1;
            Subscriber<? super Integer> childSubscriber2 = this.childSubscriber;
            for (long index = this.currentIndex; index != endIndex; index++) {
                if (!childSubscriber2.isUnsubscribed()) {
                    childSubscriber2.onNext(Integer.valueOf((int) index));
                } else {
                    return;
                }
            }
            if (!childSubscriber2.isUnsubscribed()) {
                childSubscriber2.onCompleted();
            }
        }
    }
}
