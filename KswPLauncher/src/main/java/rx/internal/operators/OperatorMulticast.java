package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;
import rx.subjects.Subject;

public final class OperatorMulticast<T, R> extends ConnectableObservable<R> {
    final AtomicReference<Subject<? super T, ? extends R>> connectedSubject;
    final Object guard;
    Subscription guardedSubscription;
    final Observable<? extends T> source;
    final Func0<? extends Subject<? super T, ? extends R>> subjectFactory;
    Subscriber<T> subscription;
    final List<Subscriber<? super R>> waitingForConnect;

    public OperatorMulticast(Observable<? extends T> source2, Func0<? extends Subject<? super T, ? extends R>> subjectFactory2) {
        this(new Object(), new AtomicReference(), new ArrayList(), source2, subjectFactory2);
    }

    private OperatorMulticast(final Object guard2, final AtomicReference<Subject<? super T, ? extends R>> connectedSubject2, final List<Subscriber<? super R>> waitingForConnect2, Observable<? extends T> source2, Func0<? extends Subject<? super T, ? extends R>> subjectFactory2) {
        super(new Observable.OnSubscribe<R>() {
            /* class rx.internal.operators.OperatorMulticast.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(Subscriber<? super R> subscriber) {
                synchronized (guard2) {
                    if (connectedSubject2.get() == null) {
                        waitingForConnect2.add(subscriber);
                    } else {
                        ((Subject) connectedSubject2.get()).unsafeSubscribe(subscriber);
                    }
                }
            }
        });
        this.guard = guard2;
        this.connectedSubject = connectedSubject2;
        this.waitingForConnect = waitingForConnect2;
        this.source = source2;
        this.subjectFactory = subjectFactory2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
        r7.call(r6.guardedSubscription);
        r1 = r6.guard;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0 = r6.subscription;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        r6.source.subscribe((rx.Subscriber<? super java.lang.Object>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    @Override // rx.observables.ConnectableObservable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(rx.functions.Action1<? super rx.Subscription> r7) {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMulticast.connect(rx.functions.Action1):void");
    }
}
