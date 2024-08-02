package rx.plugins;

import rx.Completable;

public abstract class RxJavaCompletableExecutionHook {
    @Deprecated
    public Completable.CompletableOnSubscribe onCreate(Completable.CompletableOnSubscribe f) {
        return f;
    }

    @Deprecated
    public Completable.CompletableOnSubscribe onSubscribeStart(Completable completableInstance, Completable.CompletableOnSubscribe onSubscribe) {
        return onSubscribe;
    }

    @Deprecated
    public Throwable onSubscribeError(Throwable e) {
        return e;
    }

    @Deprecated
    public Completable.CompletableOperator onLift(Completable.CompletableOperator lift) {
        return lift;
    }
}
