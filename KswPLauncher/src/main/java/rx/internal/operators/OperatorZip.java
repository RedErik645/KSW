package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.FuncN;
import rx.functions.Functions;
import rx.internal.util.RxRingBuffer;
import rx.subscriptions.CompositeSubscription;

public final class OperatorZip<R> implements Observable.Operator<R, Observable<?>[]> {
    final FuncN<? extends R> zipFunction;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorZip(FuncN<? extends R> f) {
        this.zipFunction = f;
    }

    public OperatorZip(Func2 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func3 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func4 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func5 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func6 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func7 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func8 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func9 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public Subscriber<? super Observable[]> call(Subscriber<? super R> child) {
        Zip<R> zipper = new Zip<>(child, this.zipFunction);
        ZipProducer<R> producer = new ZipProducer<>(zipper);
        OperatorZip<R>.ZipSubscriber subscriber = new ZipSubscriber(child, zipper, producer);
        child.add(subscriber);
        child.setProducer(producer);
        return subscriber;
    }

    /* access modifiers changed from: package-private */
    public final class ZipSubscriber extends Subscriber<Observable[]> {
        final Subscriber<? super R> child;
        final ZipProducer<R> producer;
        boolean started;
        final Zip<R> zipper;

        public ZipSubscriber(Subscriber<? super R> child2, Zip<R> zipper2, ZipProducer<R> producer2) {
            this.child = child2;
            this.zipper = zipper2;
            this.producer = producer2;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.started) {
                this.child.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            this.child.onError(e);
        }

        public void onNext(Observable[] observables) {
            if (observables == null || observables.length == 0) {
                this.child.onCompleted();
                return;
            }
            this.started = true;
            this.zipper.start(observables, this.producer);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ZipProducer<R> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1216676403723546796L;
        final Zip<R> zipper;

        public ZipProducer(Zip<R> zipper2) {
            this.zipper = zipper2;
        }

        @Override // rx.Producer
        public void request(long n) {
            BackpressureUtils.getAndAddRequest(this, n);
            this.zipper.tick();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Zip<R> extends AtomicLong {
        static final int THRESHOLD = ((int) (((double) RxRingBuffer.SIZE) * 0.7d));
        private static final long serialVersionUID = 5995274816189928317L;
        final Observer<? super R> child;
        private final CompositeSubscription childSubscription;
        int emitted;
        private AtomicLong requested;
        private volatile Object[] subscribers;
        private final FuncN<? extends R> zipFunction;

        public Zip(Subscriber<? super R> child2, FuncN<? extends R> zipFunction2) {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.childSubscription = compositeSubscription;
            this.child = child2;
            this.zipFunction = zipFunction2;
            child2.add(compositeSubscription);
        }

        public void start(Observable[] os, AtomicLong requested2) {
            Object[] subscribers2 = new Object[os.length];
            for (int i = 0; i < os.length; i++) {
                Zip<R>.InnerSubscriber io2 = new InnerSubscriber();
                subscribers2[i] = io2;
                this.childSubscription.add(io2);
            }
            this.requested = requested2;
            this.subscribers = subscribers2;
            for (int i2 = 0; i2 < os.length; i2++) {
                os[i2].unsafeSubscribe((InnerSubscriber) subscribers2[i2]);
            }
        }

        /* access modifiers changed from: package-private */
        public void tick() {
            Object[] subscribers2 = this.subscribers;
            if (subscribers2 != null && getAndIncrement() == 0) {
                int length = subscribers2.length;
                Observer<? super R> child2 = this.child;
                AtomicLong requested2 = this.requested;
                while (true) {
                    Object[] vs = new Object[length];
                    boolean allHaveValues = true;
                    for (int i = 0; i < length; i++) {
                        RxRingBuffer buffer = ((InnerSubscriber) subscribers2[i]).items;
                        Object n = buffer.peek();
                        if (n == null) {
                            allHaveValues = false;
                        } else if (buffer.isCompleted(n)) {
                            child2.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        } else {
                            vs[i] = buffer.getValue(n);
                        }
                    }
                    if (requested2.get() > 0 && allHaveValues) {
                        try {
                            child2.onNext((Object) this.zipFunction.call(vs));
                            requested2.decrementAndGet();
                            this.emitted++;
                            for (Object obj : subscribers2) {
                                RxRingBuffer buffer2 = ((InnerSubscriber) obj).items;
                                buffer2.poll();
                                if (buffer2.isCompleted(buffer2.peek())) {
                                    child2.onCompleted();
                                    this.childSubscription.unsubscribe();
                                    return;
                                }
                            }
                            if (this.emitted > THRESHOLD) {
                                for (Object obj2 : subscribers2) {
                                    ((InnerSubscriber) obj2).requestMore((long) this.emitted);
                                }
                                this.emitted = 0;
                            }
                        } catch (Throwable e) {
                            Exceptions.throwOrReport(e, child2, vs);
                            return;
                        }
                    } else if (decrementAndGet() <= 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final class InnerSubscriber extends Subscriber {
            final RxRingBuffer items = RxRingBuffer.getSpmcInstance();

            InnerSubscriber() {
            }

            @Override // rx.Subscriber
            public void onStart() {
                request((long) RxRingBuffer.SIZE);
            }

            public void requestMore(long n) {
                request(n);
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.items.onCompleted();
                Zip.this.tick();
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                Zip.this.child.onError(e);
            }

            @Override // rx.Observer
            public void onNext(Object t) {
                try {
                    this.items.onNext(t);
                } catch (MissingBackpressureException e) {
                    onError(e);
                }
                Zip.this.tick();
            }
        }
    }
}
