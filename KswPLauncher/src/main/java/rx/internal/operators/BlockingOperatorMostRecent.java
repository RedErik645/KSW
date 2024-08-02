package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorMostRecent {
    private BlockingOperatorMostRecent() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> mostRecent(final Observable<? extends T> source, final T initialValue) {
        return new Iterable<T>() {
            /* class rx.internal.operators.BlockingOperatorMostRecent.AnonymousClass1 */

            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                MostRecentObserver<T> mostRecentObserver = new MostRecentObserver<>(initialValue);
                source.subscribe((Subscriber) mostRecentObserver);
                return mostRecentObserver.getIterable();
            }
        };
    }

    static final class MostRecentObserver<T> extends Subscriber<T> {
        final NotificationLite<T> nl;
        volatile Object value;

        MostRecentObserver(T value2) {
            NotificationLite<T> instance = NotificationLite.instance();
            this.nl = instance;
            this.value = instance.next(value2);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.value = this.nl.completed();
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.value = this.nl.error(e);
        }

        @Override // rx.Observer
        public void onNext(T args) {
            this.value = this.nl.next(args);
        }

        public Iterator<T> getIterable() {
            return new Iterator<T>() {
                /* class rx.internal.operators.BlockingOperatorMostRecent.MostRecentObserver.AnonymousClass1 */
                private Object buf;

                public boolean hasNext() {
                    this.buf = MostRecentObserver.this.value;
                    return !MostRecentObserver.this.nl.isCompleted(this.buf);
                }

                @Override // java.util.Iterator
                public T next() {
                    Object obj = null;
                    try {
                        if (this.buf == null) {
                            obj = MostRecentObserver.this.value;
                        }
                        if (MostRecentObserver.this.nl.isCompleted(this.buf)) {
                            throw new NoSuchElementException();
                        } else if (!MostRecentObserver.this.nl.isError(this.buf)) {
                            T value = MostRecentObserver.this.nl.getValue(this.buf);
                            this.buf = obj;
                            return value;
                        } else {
                            throw Exceptions.propagate(MostRecentObserver.this.nl.getError(this.buf));
                        }
                    } finally {
                        this.buf = obj;
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException("Read only iterator");
                }
            };
        }
    }
}
