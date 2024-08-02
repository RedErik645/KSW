package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapObservable(MaybeSource<T> source2, Function<? super T, ? extends ObservableSource<? extends R>> mapper2) {
        this.source = source2;
        this.mapper = mapper2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver<T, R> parent = new FlatMapObserver<>(observer, this.mapper);
        observer.onSubscribe(parent);
        this.source.subscribe(parent);
    }

    static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;

        FlatMapObserver(Observer<? super R> downstream2, Function<? super T, ? extends ObservableSource<? extends R>> mapper2) {
            this.downstream = downstream2;
            this.mapper = mapper2;
        }

        @Override // io.reactivex.Observer
        public void onNext(R t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.MaybeObserver, io.reactivex.Observer
        public void onError(Throwable t) {
            this.downstream.onError(t);
        }

        @Override // io.reactivex.MaybeObserver, io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.MaybeObserver, io.reactivex.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.replace(this, d);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            try {
                ((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.downstream.onError(ex);
            }
        }
    }
}
