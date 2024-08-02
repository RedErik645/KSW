package rx.internal.operators;

import rx.Completable;
import rx.Subscription;
import rx.exceptions.AssemblyStackTraceException;

public final class OnSubscribeOnAssemblyCompletable<T> implements Completable.CompletableOnSubscribe {
    public static volatile boolean fullStackTrace;
    final Completable.CompletableOnSubscribe source;
    final String stacktrace = OnSubscribeOnAssembly.createStacktrace();

    public OnSubscribeOnAssemblyCompletable(Completable.CompletableOnSubscribe source2) {
        this.source = source2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: rx.Completable$CompletableOnSubscribe */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(Completable.CompletableSubscriber t) {
        this.source.call(new OnAssemblyCompletableSubscriber(t, this.stacktrace));
    }

    /* access modifiers changed from: package-private */
    public static final class OnAssemblyCompletableSubscriber implements Completable.CompletableSubscriber {
        final Completable.CompletableSubscriber actual;
        final String stacktrace;

        public OnAssemblyCompletableSubscriber(Completable.CompletableSubscriber actual2, String stacktrace2) {
            this.actual = actual2;
            this.stacktrace = stacktrace2;
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onSubscribe(Subscription d) {
            this.actual.onSubscribe(d);
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onCompleted() {
            this.actual.onCompleted();
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onError(Throwable e) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(e);
            this.actual.onError(e);
        }
    }
}
