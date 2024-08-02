package rx.singles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.BlockingOperatorToFuture;
import rx.internal.util.BlockingUtils;

public final class BlockingSingle<T> {
    private final Single<? extends T> single;

    private BlockingSingle(Single<? extends T> single2) {
        this.single = single2;
    }

    public static <T> BlockingSingle<T> from(Single<? extends T> single2) {
        return new BlockingSingle<>(single2);
    }

    public T value() {
        final AtomicReference<T> returnItem = new AtomicReference<>();
        final AtomicReference<Throwable> returnException = new AtomicReference<>();
        final CountDownLatch latch = new CountDownLatch(1);
        BlockingUtils.awaitForComplete(latch, this.single.subscribe(new SingleSubscriber<T>() {
            /* class rx.singles.BlockingSingle.AnonymousClass1 */

            @Override // rx.SingleSubscriber
            public void onSuccess(T value) {
                returnItem.set(value);
                latch.countDown();
            }

            @Override // rx.SingleSubscriber
            public void onError(Throwable error) {
                returnException.set(error);
                latch.countDown();
            }
        }));
        Throwable throwable = returnException.get();
        if (throwable == null) {
            return returnItem.get();
        }
        throw Exceptions.propagate(throwable);
    }

    public Future<T> toFuture() {
        return BlockingOperatorToFuture.toFuture(this.single.toObservable());
    }
}
