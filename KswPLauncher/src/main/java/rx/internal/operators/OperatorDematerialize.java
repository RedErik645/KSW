package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.Subscriber;

public final class OperatorDematerialize<T> implements Observable.Operator<T, Notification<T>> {
    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* access modifiers changed from: package-private */
    public static final class Holder {
        static final OperatorDematerialize<Object> INSTANCE = new OperatorDematerialize<>();

        Holder() {
        }
    }

    public static OperatorDematerialize instance() {
        return Holder.INSTANCE;
    }

    OperatorDematerialize() {
    }

    public Subscriber<? super Notification<T>> call(final Subscriber<? super T> child) {
        return new Subscriber<Notification<T>>(child) {
            /* class rx.internal.operators.OperatorDematerialize.AnonymousClass1 */
            boolean terminated;

            @Override // rx.Observer
            public /* bridge */ /* synthetic */ void onNext(Object x0) {
                onNext((Notification) ((Notification) x0));
            }

            public void onNext(Notification<T> t) {
                switch (AnonymousClass2.$SwitchMap$rx$Notification$Kind[t.getKind().ordinal()]) {
                    case 1:
                        if (!this.terminated) {
                            child.onNext(t.getValue());
                            return;
                        }
                        return;
                    case 2:
                        onError(t.getThrowable());
                        return;
                    case 3:
                        onCompleted();
                        return;
                    default:
                        onError(new IllegalArgumentException("Unsupported notification type: " + t));
                        return;
                }
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                if (!this.terminated) {
                    this.terminated = true;
                    child.onError(e);
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.terminated) {
                    this.terminated = true;
                    child.onCompleted();
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.OperatorDematerialize$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$rx$Notification$Kind;

        static {
            int[] iArr = new int[Notification.Kind.values().length];
            $SwitchMap$rx$Notification$Kind = iArr;
            try {
                iArr[Notification.Kind.OnNext.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$rx$Notification$Kind[Notification.Kind.OnError.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$rx$Notification$Kind[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
