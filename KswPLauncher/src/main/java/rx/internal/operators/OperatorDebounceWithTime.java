package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithTime<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorDebounceWithTime(long timeout2, TimeUnit unit2, Scheduler scheduler2) {
        this.timeout = timeout2;
        this.unit = unit2;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        final Scheduler.Worker worker = this.scheduler.createWorker();
        final SerializedSubscriber<T> s = new SerializedSubscriber<>(child);
        final SerialSubscription ssub = new SerialSubscription();
        s.add(worker);
        s.add(ssub);
        return new Subscriber<T>(child) {
            /* class rx.internal.operators.OperatorDebounceWithTime.AnonymousClass1 */
            final Subscriber<?> self = this;
            final DebounceState<T> state = new DebounceState<>();

            @Override // rx.Subscriber
            public void onStart() {
                request(LongCompanionObject.MAX_VALUE);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                final int index = this.state.next(t);
                ssub.set(worker.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorDebounceWithTime.AnonymousClass1.AnonymousClass1 */

                    @Override // rx.functions.Action0
                    public void call() {
                        AnonymousClass1.this.state.emit(index, s, AnonymousClass1.this.self);
                    }
                }, OperatorDebounceWithTime.this.timeout, OperatorDebounceWithTime.this.unit));
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                s.onError(e);
                unsubscribe();
                this.state.clear();
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.state.emitAndComplete(s, this);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static final class DebounceState<T> {
        boolean emitting;
        boolean hasValue;
        int index;
        boolean terminate;
        T value;

        DebounceState() {
        }

        public synchronized int next(T value2) {
            int i;
            this.value = value2;
            this.hasValue = true;
            i = this.index + 1;
            this.index = i;
            return i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r6.onNext(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
            if (r4.terminate != false) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0023, code lost:
            r4.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0026, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0027, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0028, code lost:
            r6.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x002b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x002f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0030, code lost:
            rx.exceptions.Exceptions.throwOrReport(r0, r7, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0033, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emit(int r5, rx.Subscriber<T> r6, rx.Subscriber<?> r7) {
            /*
                r4 = this;
                monitor-enter(r4)
                r0 = 0
                boolean r1 = r4.emitting     // Catch:{ all -> 0x0036 }
                if (r1 != 0) goto L_0x0034
                boolean r1 = r4.hasValue     // Catch:{ all -> 0x0036 }
                if (r1 == 0) goto L_0x0034
                int r1 = r4.index     // Catch:{ all -> 0x0036 }
                if (r5 == r1) goto L_0x000f
                goto L_0x0034
            L_0x000f:
                T r1 = r4.value     // Catch:{ all -> 0x0036 }
                r4.value = r0     // Catch:{ all -> 0x003c }
                r0 = 0
                r4.hasValue = r0     // Catch:{ all -> 0x003c }
                r2 = 1
                r4.emitting = r2     // Catch:{ all -> 0x003c }
                monitor-exit(r4)     // Catch:{ all -> 0x003c }
                r6.onNext(r1)     // Catch:{ all -> 0x002f }
                monitor-enter(r4)
                boolean r2 = r4.terminate     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x0027
                r4.emitting = r0     // Catch:{ all -> 0x002c }
                monitor-exit(r4)     // Catch:{ all -> 0x002c }
                return
            L_0x0027:
                monitor-exit(r4)     // Catch:{ all -> 0x002c }
                r6.onCompleted()
                return
            L_0x002c:
                r0 = move-exception
                monitor-exit(r4)
                throw r0
            L_0x002f:
                r0 = move-exception
                rx.exceptions.Exceptions.throwOrReport(r0, r7, r1)
                return
            L_0x0034:
                monitor-exit(r4)
                return
            L_0x0036:
                r1 = move-exception
                r3 = r1
                r1 = r0
                r0 = r3
            L_0x003a:
                monitor-exit(r4)
                throw r0
            L_0x003c:
                r0 = move-exception
                goto L_0x003a
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorDebounceWithTime.DebounceState.emit(int, rx.Subscriber, rx.Subscriber):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
            if (r4 == false) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r7.onNext(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x001e, code lost:
            rx.exceptions.Exceptions.throwOrReport(r0, r8, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0022, code lost:
            r7.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitAndComplete(rx.Subscriber<T> r7, rx.Subscriber<?> r8) {
            /*
                r6 = this;
                monitor-enter(r6)
                r0 = 0
                r1 = 0
                boolean r2 = r6.emitting     // Catch:{ all -> 0x0031 }
                r3 = 1
                if (r2 == 0) goto L_0x000c
                r6.terminate = r3     // Catch:{ all -> 0x0031 }
                monitor-exit(r6)     // Catch:{ all -> 0x0031 }
                return
            L_0x000c:
                T r2 = r6.value     // Catch:{ all -> 0x0031 }
                boolean r4 = r6.hasValue     // Catch:{ all -> 0x002c }
                r6.value = r0     // Catch:{ all -> 0x0026 }
                r6.hasValue = r1     // Catch:{ all -> 0x0026 }
                r6.emitting = r3     // Catch:{ all -> 0x0026 }
                monitor-exit(r6)     // Catch:{ all -> 0x0026 }
                if (r4 == 0) goto L_0x0022
                r7.onNext(r2)     // Catch:{ all -> 0x001d }
                goto L_0x0022
            L_0x001d:
                r0 = move-exception
                rx.exceptions.Exceptions.throwOrReport(r0, r8, r2)
                return
            L_0x0022:
                r7.onCompleted()
                return
            L_0x0026:
                r0 = move-exception
                r1 = r4
                r5 = r2
                r2 = r0
                r0 = r5
                goto L_0x0032
            L_0x002c:
                r0 = move-exception
                r5 = r2
                r2 = r0
                r0 = r5
                goto L_0x0032
            L_0x0031:
                r2 = move-exception
            L_0x0032:
                monitor-exit(r6)     // Catch:{ all -> 0x0034 }
                throw r2
            L_0x0034:
                r2 = move-exception
                goto L_0x0032
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorDebounceWithTime.DebounceState.emitAndComplete(rx.Subscriber, rx.Subscriber):void");
        }

        public synchronized void clear() {
            this.index++;
            this.value = null;
            this.hasValue = false;
        }
    }
}
