package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    final T initialValue;
    final Flowable<T> source;

    public BlockingFlowableMostRecent(Flowable<T> source2, T initialValue2) {
        this.source = source2;
        this.initialValue = initialValue2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        MostRecentSubscriber<T> mostRecentSubscriber = new MostRecentSubscriber<>(this.initialValue);
        this.source.subscribe((FlowableSubscriber) mostRecentSubscriber);
        return mostRecentSubscriber.getIterable();
    }

    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        volatile Object value;

        MostRecentSubscriber(T value2) {
            this.value = NotificationLite.next(value2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.value = NotificationLite.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable e) {
            this.value = NotificationLite.error(e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T args) {
            this.value = NotificationLite.next(args);
        }

        public MostRecentSubscriber<T>.Iterator getIterable() {
            return new Iterator();
        }

        /* access modifiers changed from: package-private */
        public final class Iterator implements java.util.Iterator<T> {
            private Object buf;

            Iterator() {
            }

            public boolean hasNext() {
                Object obj = MostRecentSubscriber.this.value;
                this.buf = obj;
                return !NotificationLite.isComplete(obj);
            }

            @Override // java.util.Iterator
            public T next() {
                Object obj = null;
                try {
                    if (this.buf == null) {
                        Object obj2 = MostRecentSubscriber.this.value;
                    }
                    if (NotificationLite.isComplete(this.buf)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.isError(this.buf)) {
                        T t = (T) NotificationLite.getValue(this.buf);
                        this.buf = obj;
                        return t;
                    } else {
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));
                    }
                } finally {
                    this.buf = obj;
                }
            }

            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }
    }
}
