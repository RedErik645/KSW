package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapMaybe<T, R> extends Maybe<R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final SingleSource<? extends T> source;

    public SingleFlatMapMaybe(SingleSource<? extends T> source2, Function<? super T, ? extends MaybeSource<? extends R>> mapper2) {
        this.mapper = mapper2;
        this.source = source2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super R> downstream) {
        this.source.subscribe(new FlatMapSingleObserver(downstream, this.mapper));
    }

    static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5843758257109742742L;
        final MaybeObserver<? super R> downstream;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;

        FlatMapSingleObserver(MaybeObserver<? super R> actual, Function<? super T, ? extends MaybeSource<? extends R>> mapper2) {
            this.downstream = actual;
            this.mapper = mapper2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.setOnce(this, d)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T value) {
            try {
                MaybeSource<? extends R> ms = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(value), "The mapper returned a null MaybeSource");
                if (!isDisposed()) {
                    ms.subscribe(new FlatMapMaybeObserver<>(this, this.downstream));
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                onError(ex);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }
    }

    static final class FlatMapMaybeObserver<R> implements MaybeObserver<R> {
        final MaybeObserver<? super R> downstream;
        final AtomicReference<Disposable> parent;

        FlatMapMaybeObserver(AtomicReference<Disposable> parent2, MaybeObserver<? super R> downstream2) {
            this.parent = parent2;
            this.downstream = downstream2;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable d) {
            DisposableHelper.replace(this.parent, d);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(R value) {
            this.downstream.onSuccess(value);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable e) {
            this.downstream.onError(e);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }
    }
}
