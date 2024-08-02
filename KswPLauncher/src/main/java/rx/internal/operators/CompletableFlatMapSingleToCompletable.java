package rx.internal.operators;

import rx.Completable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class CompletableFlatMapSingleToCompletable<T> implements Completable.CompletableOnSubscribe {
    final Func1<? super T, ? extends Completable> mapper;
    final Single<T> source;

    public CompletableFlatMapSingleToCompletable(Single<T> source2, Func1<? super T, ? extends Completable> mapper2) {
        this.source = source2;
        this.mapper = mapper2;
    }

    public void call(Completable.CompletableSubscriber t) {
        SourceSubscriber<T> parent = new SourceSubscriber<>(t, this.mapper);
        t.onSubscribe(parent);
        this.source.subscribe(parent);
    }

    /* access modifiers changed from: package-private */
    public static final class SourceSubscriber<T> extends SingleSubscriber<T> implements Completable.CompletableSubscriber {
        final Completable.CompletableSubscriber actual;
        final Func1<? super T, ? extends Completable> mapper;

        public SourceSubscriber(Completable.CompletableSubscriber actual2, Func1<? super T, ? extends Completable> mapper2) {
            this.actual = actual2;
            this.mapper = mapper2;
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T value) {
            try {
                Completable c = (Completable) this.mapper.call(value);
                if (c == null) {
                    onError(new NullPointerException("The mapper returned a null Completable"));
                } else {
                    c.subscribe(this);
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                onError(ex);
            }
        }

        @Override // rx.SingleSubscriber, rx.Completable.CompletableSubscriber
        public void onError(Throwable error) {
            this.actual.onError(error);
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onCompleted() {
            this.actual.onCompleted();
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onSubscribe(Subscription d) {
            add(d);
        }
    }
}
