package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {
    final Iterable<? extends T> is;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.is = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    public void call(Subscriber<? super T> o) {
        Throwable ex;
        try {
            Iterator<? extends T> it = this.is.iterator();
            try {
                boolean b = it.hasNext();
                if (o.isUnsubscribed()) {
                    return;
                }
                if (!b) {
                    o.onCompleted();
                } else {
                    o.setProducer(new IterableProducer(o, it));
                }
            } catch (Throwable th) {
                ex = th;
                Exceptions.throwOrReport(ex, o);
            }
        } catch (Throwable th2) {
            ex = th2;
            Exceptions.throwOrReport(ex, o);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;
        private final Subscriber<? super T> o;

        IterableProducer(Subscriber<? super T> o2, Iterator<? extends T> it2) {
            this.o = o2;
            this.it = it2;
        }

        @Override // rx.Producer
        public void request(long n) {
            if (get() != LongCompanionObject.MAX_VALUE) {
                if (n == LongCompanionObject.MAX_VALUE && compareAndSet(0, LongCompanionObject.MAX_VALUE)) {
                    fastpath();
                } else if (n > 0 && BackpressureUtils.getAndAddRequest(this, n) == 0) {
                    slowpath(n);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void slowpath(long n) {
            Subscriber<? super T> o2 = this.o;
            Iterator<? extends T> it2 = this.it;
            long r = n;
            long e = 0;
            while (true) {
                if (e == r) {
                    r = get();
                    if (e == r) {
                        r = BackpressureUtils.produced(this, e);
                        if (r != 0) {
                            e = 0;
                        } else {
                            return;
                        }
                    } else {
                        continue;
                    }
                } else if (!o2.isUnsubscribed()) {
                    try {
                        o2.onNext((Object) it2.next());
                        if (!o2.isUnsubscribed()) {
                            try {
                                if (it2.hasNext()) {
                                    e++;
                                } else if (!o2.isUnsubscribed()) {
                                    o2.onCompleted();
                                    return;
                                } else {
                                    return;
                                }
                            } catch (Throwable ex) {
                                Exceptions.throwOrReport(ex, o2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable ex2) {
                        Exceptions.throwOrReport(ex2, o2);
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void fastpath() {
            Subscriber<? super T> o2 = this.o;
            Iterator<? extends T> it2 = this.it;
            while (!o2.isUnsubscribed()) {
                try {
                    o2.onNext((Object) it2.next());
                    if (!o2.isUnsubscribed()) {
                        try {
                            if (!it2.hasNext()) {
                                if (!o2.isUnsubscribed()) {
                                    o2.onCompleted();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable ex) {
                            Exceptions.throwOrReport(ex, o2);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable ex2) {
                    Exceptions.throwOrReport(ex2, o2);
                    return;
                }
            }
        }
    }
}
