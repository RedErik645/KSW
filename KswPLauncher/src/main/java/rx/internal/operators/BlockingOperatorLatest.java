package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorLatest {
    private BlockingOperatorLatest() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> latest(final Observable<? extends T> source) {
        return new Iterable<T>() {
            /* class rx.internal.operators.BlockingOperatorLatest.AnonymousClass1 */

            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                LatestObserverIterator<T> lio = new LatestObserverIterator<>();
                source.materialize().subscribe((Subscriber) lio);
                return lio;
            }
        };
    }

    static final class LatestObserverIterator<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {
        Notification<? extends T> iNotif;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<Notification<? extends T>> value = new AtomicReference<>();

        LatestObserverIterator() {
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Notification) ((Notification) x0));
        }

        public void onNext(Notification<? extends T> args) {
            if (this.value.getAndSet(args) == null) {
                this.notify.release();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
        }

        @Override // rx.Observer
        public void onCompleted() {
        }

        public boolean hasNext() {
            Notification<? extends T> notification = this.iNotif;
            if (notification == null || !notification.isOnError()) {
                Notification<? extends T> notification2 = this.iNotif;
                if ((notification2 == null || !notification2.isOnCompleted()) && this.iNotif == null) {
                    try {
                        this.notify.acquire();
                        Notification<? extends T> n = this.value.getAndSet(null);
                        this.iNotif = n;
                        if (n.isOnError()) {
                            throw Exceptions.propagate(this.iNotif.getThrowable());
                        }
                    } catch (InterruptedException ex) {
                        unsubscribe();
                        Thread.currentThread().interrupt();
                        this.iNotif = Notification.createOnError(ex);
                        throw Exceptions.propagate(ex);
                    }
                }
                return !this.iNotif.isOnCompleted();
            }
            throw Exceptions.propagate(this.iNotif.getThrowable());
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.iNotif.isOnNext()) {
                throw new NoSuchElementException();
            }
            T v = (T) this.iNotif.getValue();
            this.iNotif = null;
            return v;
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }
}
