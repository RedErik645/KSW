package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

public final class BackpressureUtils {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    private BackpressureUtils() {
        throw new IllegalStateException("No instances!");
    }

    @Deprecated
    public static <T> long getAndAddRequest(AtomicLongFieldUpdater<T> requested, T object, long n) {
        long current;
        do {
            current = requested.get(object);
        } while (!requested.compareAndSet(object, current, addCap(current, n)));
        return current;
    }

    public static long getAndAddRequest(AtomicLong requested, long n) {
        long current;
        do {
            current = requested.get();
        } while (!requested.compareAndSet(current, addCap(current, n)));
        return current;
    }

    public static long multiplyCap(long a, long b) {
        long u = a * b;
        if (((a | b) >>> 31) == 0 || b == 0 || u / b == a) {
            return u;
        }
        return Long.MAX_VALUE;
    }

    public static long addCap(long a, long b) {
        long u = a + b;
        if (u < 0) {
            return Long.MAX_VALUE;
        }
        return u;
    }

    public static <T> void postCompleteDone(AtomicLong requested, Queue<T> queue, Subscriber<? super T> actual) {
        postCompleteDone(requested, queue, actual, UtilityFunctions.identity());
    }

    public static <T> boolean postCompleteRequest(AtomicLong requested, long n, Queue<T> queue, Subscriber<? super T> actual) {
        return postCompleteRequest(requested, n, queue, actual, UtilityFunctions.identity());
    }

    public static <T, R> void postCompleteDone(AtomicLong requested, Queue<T> queue, Subscriber<? super R> actual, Func1<? super T, ? extends R> exitTransform) {
        long r;
        do {
            r = requested.get();
            if ((r & Long.MIN_VALUE) != 0) {
                return;
            }
        } while (!requested.compareAndSet(r, Long.MIN_VALUE | r));
        if (r != 0) {
            postCompleteDrain(requested, queue, actual, exitTransform);
        }
    }

    public static <T, R> boolean postCompleteRequest(AtomicLong requested, long n, Queue<T> queue, Subscriber<? super R> actual, Func1<? super T, ? extends R> exitTransform) {
        long r;
        long c;
        if (n < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + n);
        } else if (n == 0) {
            return (Long.MIN_VALUE & requested.get()) == 0;
        } else {
            while (true) {
                r = requested.get();
                c = r & Long.MIN_VALUE;
                if (requested.compareAndSet(r, addCap(Long.MAX_VALUE & r, n) | c)) {
                    break;
                }
            }
            if (r != Long.MIN_VALUE) {
                return c == 0;
            }
            postCompleteDrain(requested, queue, actual, exitTransform);
            return false;
        }
    }

    static <T, R> void postCompleteDrain(AtomicLong requested, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> exitTransform) {
        long r = requested.get();
        if (r == Long.MAX_VALUE) {
            while (!subscriber.isUnsubscribed()) {
                T v = queue.poll();
                if (v == null) {
                    subscriber.onCompleted();
                    return;
                }
                subscriber.onNext((Object) exitTransform.call(v));
            }
            return;
        }
        long e = Long.MIN_VALUE;
        while (true) {
            if (e == r) {
                if (e == r) {
                    if (!subscriber.isUnsubscribed()) {
                        if (queue.isEmpty()) {
                            subscriber.onCompleted();
                            return;
                        }
                    } else {
                        return;
                    }
                }
                r = requested.get();
                if (r == e) {
                    r = requested.addAndGet(-(e & Long.MAX_VALUE));
                    if (r != Long.MIN_VALUE) {
                        e = Long.MIN_VALUE;
                    } else {
                        return;
                    }
                } else {
                    continue;
                }
            } else if (!subscriber.isUnsubscribed()) {
                T v2 = queue.poll();
                if (v2 == null) {
                    subscriber.onCompleted();
                    return;
                } else {
                    subscriber.onNext((Object) exitTransform.call(v2));
                    e++;
                }
            } else {
                return;
            }
        }
    }

    public static long produced(AtomicLong requested, long n) {
        long current;
        long next;
        do {
            current = requested.get();
            if (current == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            next = current - n;
            if (next < 0) {
                throw new IllegalStateException("More produced than requested: " + next);
            }
        } while (!requested.compareAndSet(current, next));
        return next;
    }

    public static boolean validate(long n) {
        if (n >= 0) {
            return n != 0;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + n);
    }
}
