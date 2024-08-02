package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* access modifiers changed from: package-private */
public class OperatorTimeoutBase<T> implements Observable.Operator<T, T> {
    final FirstTimeoutStub<T> firstTimeoutStub;
    final Observable<? extends T> other;
    final Scheduler scheduler;
    final TimeoutStub<T> timeoutStub;

    /* access modifiers changed from: package-private */
    public interface FirstTimeoutStub<T> extends Func3<TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription> {
    }

    /* access modifiers changed from: package-private */
    public interface TimeoutStub<T> extends Func4<TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription> {
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    OperatorTimeoutBase(FirstTimeoutStub<T> firstTimeoutStub2, TimeoutStub<T> timeoutStub2, Observable<? extends T> other2, Scheduler scheduler2) {
        this.firstTimeoutStub = firstTimeoutStub2;
        this.timeoutStub = timeoutStub2;
        this.other = other2;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker inner = this.scheduler.createWorker();
        subscriber.add(inner);
        SerializedSubscriber<T> synchronizedSubscriber = new SerializedSubscriber<>(subscriber);
        SerialSubscription serial = new SerialSubscription();
        synchronizedSubscriber.add(serial);
        TimeoutSubscriber<T> timeoutSubscriber = new TimeoutSubscriber<>(synchronizedSubscriber, this.timeoutStub, serial, this.other, inner);
        synchronizedSubscriber.add(timeoutSubscriber);
        synchronizedSubscriber.setProducer(timeoutSubscriber.arbiter);
        serial.set((Subscription) this.firstTimeoutStub.call(timeoutSubscriber, 0L, inner));
        return timeoutSubscriber;
    }

    /* access modifiers changed from: package-private */
    public static final class TimeoutSubscriber<T> extends Subscriber<T> {
        long actual;
        final ProducerArbiter arbiter = new ProducerArbiter();
        final Scheduler.Worker inner;
        final Observable<? extends T> other;
        final SerialSubscription serial;
        final SerializedSubscriber<T> serializedSubscriber;
        boolean terminated;
        final TimeoutStub<T> timeoutStub;

        TimeoutSubscriber(SerializedSubscriber<T> serializedSubscriber2, TimeoutStub<T> timeoutStub2, SerialSubscription serial2, Observable<? extends T> other2, Scheduler.Worker inner2) {
            this.serializedSubscriber = serializedSubscriber2;
            this.timeoutStub = timeoutStub2;
            this.serial = serial2;
            this.other = other2;
            this.inner = inner2;
        }

        @Override // rx.Subscriber
        public void setProducer(Producer p) {
            this.arbiter.setProducer(p);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            r7.serializedSubscriber.onNext(r8);
            r7.serial.set((rx.Subscription) r7.timeoutStub.call(r7, java.lang.Long.valueOf(r1), r8, r7.inner));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        @Override // rx.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
                r7 = this;
                r0 = 0
                monitor-enter(r7)
                r1 = 0
                boolean r3 = r7.terminated     // Catch:{ all -> 0x0030 }
                if (r3 != 0) goto L_0x0012
                long r3 = r7.actual     // Catch:{ all -> 0x0030 }
                r5 = 1
                long r3 = r3 + r5
                r7.actual = r3     // Catch:{ all -> 0x0030 }
                r1 = r3
                r0 = 1
                goto L_0x0014
            L_0x0012:
                long r1 = r7.actual     // Catch:{ all -> 0x0030 }
            L_0x0014:
                monitor-exit(r7)     // Catch:{ all -> 0x0033 }
                if (r0 == 0) goto L_0x002f
                rx.observers.SerializedSubscriber<T> r3 = r7.serializedSubscriber
                r3.onNext(r8)
                rx.subscriptions.SerialSubscription r3 = r7.serial
                rx.internal.operators.OperatorTimeoutBase$TimeoutStub<T> r4 = r7.timeoutStub
                java.lang.Long r5 = java.lang.Long.valueOf(r1)
                rx.Scheduler$Worker r6 = r7.inner
                java.lang.Object r4 = r4.call(r7, r5, r8, r6)
                rx.Subscription r4 = (rx.Subscription) r4
                r3.set(r4)
            L_0x002f:
                return
            L_0x0030:
                r3 = move-exception
            L_0x0031:
                monitor-exit(r7)
                throw r3
            L_0x0033:
                r3 = move-exception
                goto L_0x0031
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorTimeoutBase.TimeoutSubscriber.onNext(java.lang.Object):void");
        }

        @Override // rx.Observer
        public void onError(Throwable error) {
            boolean onErrorWins = false;
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    onErrorWins = true;
                }
            }
            if (onErrorWins) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onError(error);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            boolean onCompletedWins = false;
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    onCompletedWins = true;
                }
            }
            if (onCompletedWins) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onCompleted();
            }
        }

        public void onTimeout(long seqId) {
            boolean timeoutWins = false;
            synchronized (this) {
                if (seqId == this.actual && !this.terminated) {
                    this.terminated = true;
                    timeoutWins = true;
                }
            }
            if (!timeoutWins) {
                return;
            }
            if (this.other == null) {
                this.serializedSubscriber.onError(new TimeoutException());
                return;
            }
            Subscriber<T> second = new Subscriber<T>() {
                /* class rx.internal.operators.OperatorTimeoutBase.TimeoutSubscriber.AnonymousClass1 */

                @Override // rx.Observer
                public void onNext(T t) {
                    TimeoutSubscriber.this.serializedSubscriber.onNext(t);
                }

                @Override // rx.Observer
                public void onError(Throwable e) {
                    TimeoutSubscriber.this.serializedSubscriber.onError(e);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    TimeoutSubscriber.this.serializedSubscriber.onCompleted();
                }

                @Override // rx.Subscriber
                public void setProducer(Producer p) {
                    TimeoutSubscriber.this.arbiter.setProducer(p);
                }
            };
            this.other.unsafeSubscribe(second);
            this.serial.set(second);
        }
    }
}
