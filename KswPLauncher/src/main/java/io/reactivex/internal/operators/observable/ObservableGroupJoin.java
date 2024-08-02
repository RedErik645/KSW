package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
    final ObservableSource<? extends TRight> other;
    final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;

    /* access modifiers changed from: package-private */
    public interface JoinSupport {
        void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver);

        void innerCloseError(Throwable th);

        void innerComplete(LeftRightObserver leftRightObserver);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    public ObservableGroupJoin(ObservableSource<TLeft> source, ObservableSource<? extends TRight> other2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd2, Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector2) {
        super(source);
        this.other = other2;
        this.leftEnd = leftEnd2;
        this.rightEnd = rightEnd2;
        this.resultSelector = resultSelector2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> parent = new GroupJoinDisposable<>(observer, this.leftEnd, this.rightEnd, this.resultSelector);
        observer.onSubscribe(parent);
        LeftRightObserver left = new LeftRightObserver(parent, true);
        parent.disposables.add(left);
        LeftRightObserver right = new LeftRightObserver(parent, false);
        parent.disposables.add(right);
        this.source.subscribe(left);
        this.other.subscribe(right);
    }

    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {
        static final Integer LEFT_CLOSE = 3;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_CLOSE = 4;
        static final Integer RIGHT_VALUE = 2;
        private static final long serialVersionUID = -6071216598687999801L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final CompositeDisposable disposables = new CompositeDisposable();
        final Observer<? super R> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, UnicastSubject<TRight>> lefts = new LinkedHashMap();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights = new LinkedHashMap();

        GroupJoinDisposable(Observer<? super R> actual, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd2, Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector2) {
            this.downstream = actual;
            this.leftEnd = leftEnd2;
            this.rightEnd = rightEnd2;
            this.resultSelector = resultSelector2;
            this.active = new AtomicInteger(2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void cancelAll() {
            this.disposables.dispose();
        }

        /* access modifiers changed from: package-private */
        public void errorAll(Observer<?> a) {
            Throwable ex = ExceptionHelper.terminate(this.error);
            for (UnicastSubject<TRight> up : this.lefts.values()) {
                up.onError(ex);
            }
            this.lefts.clear();
            this.rights.clear();
            a.onError(ex);
        }

        /* access modifiers changed from: package-private */
        public void fail(Throwable exc, Observer<?> a, SpscLinkedArrayQueue<?> q) {
            Exceptions.throwIfFatal(exc);
            ExceptionHelper.addThrowable(this.error, exc);
            q.clear();
            cancelAll();
            errorAll(a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: java.util.Map<java.lang.Integer, TRight> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> q = this.queue;
                Observer<? super R> a = this.downstream;
                int missed = 1;
                while (!this.cancelled) {
                    if (this.error.get() != null) {
                        q.clear();
                        cancelAll();
                        errorAll(a);
                        return;
                    }
                    boolean d = this.active.get() == 0;
                    Integer mode = (Integer) q.poll();
                    boolean empty = mode == null;
                    if (d && empty) {
                        for (UnicastSubject<TRight> unicastSubject : this.lefts.values()) {
                            unicastSubject.onComplete();
                        }
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        a.onComplete();
                        return;
                    } else if (empty) {
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        Object val = q.poll();
                        if (mode == LEFT_VALUE) {
                            UnicastSubject<TRight> up = UnicastSubject.create();
                            int idx = this.leftIndex;
                            this.leftIndex = idx + 1;
                            this.lefts.put(Integer.valueOf(idx), up);
                            try {
                                ObservableSource<TLeftEnd> p = (ObservableSource) ObjectHelper.requireNonNull(this.leftEnd.apply(val), "The leftEnd returned a null ObservableSource");
                                LeftRightEndObserver end = new LeftRightEndObserver(this, true, idx);
                                this.disposables.add(end);
                                p.subscribe(end);
                                if (this.error.get() != null) {
                                    q.clear();
                                    cancelAll();
                                    errorAll(a);
                                    return;
                                }
                                try {
                                    Object obj = (Object) ObjectHelper.requireNonNull(this.resultSelector.apply(val, up), "The resultSelector returned a null value");
                                    a.onNext(obj);
                                    for (TRight right : this.rights.values()) {
                                        up.onNext(right);
                                        obj = (Object) obj;
                                    }
                                } catch (Throwable exc) {
                                    fail(exc, a, q);
                                    return;
                                }
                            } catch (Throwable exc2) {
                                fail(exc2, a, q);
                                return;
                            }
                        } else if (mode == RIGHT_VALUE) {
                            int idx2 = this.rightIndex;
                            this.rightIndex = idx2 + 1;
                            this.rights.put(Integer.valueOf(idx2), val);
                            try {
                                ObservableSource<TRightEnd> p2 = (ObservableSource) ObjectHelper.requireNonNull(this.rightEnd.apply(val), "The rightEnd returned a null ObservableSource");
                                LeftRightEndObserver end2 = new LeftRightEndObserver(this, false, idx2);
                                this.disposables.add(end2);
                                p2.subscribe(end2);
                                if (this.error.get() != null) {
                                    q.clear();
                                    cancelAll();
                                    errorAll(a);
                                    return;
                                }
                                for (UnicastSubject<TRight> up2 : this.lefts.values()) {
                                    up2.onNext(val);
                                }
                            } catch (Throwable exc3) {
                                fail(exc3, a, q);
                                return;
                            }
                        } else if (mode == LEFT_CLOSE) {
                            LeftRightEndObserver end3 = (LeftRightEndObserver) val;
                            UnicastSubject<TRight> up3 = this.lefts.remove(Integer.valueOf(end3.index));
                            this.disposables.remove(end3);
                            if (up3 != null) {
                                up3.onComplete();
                            }
                        } else if (mode == RIGHT_CLOSE) {
                            LeftRightEndObserver end4 = (LeftRightEndObserver) val;
                            this.rights.remove(Integer.valueOf(end4.index));
                            this.disposables.remove(end4);
                        }
                    }
                }
                q.clear();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerError(Throwable ex) {
            if (ExceptionHelper.addThrowable(this.error, ex)) {
                this.active.decrementAndGet();
                drain();
                return;
            }
            RxJavaPlugins.onError(ex);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerComplete(LeftRightObserver sender) {
            this.disposables.delete(sender);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerValue(boolean isLeft, Object o) {
            synchronized (this) {
                this.queue.offer(isLeft ? LEFT_VALUE : RIGHT_VALUE, o);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerClose(boolean isLeft, LeftRightEndObserver index) {
            synchronized (this) {
                this.queue.offer(isLeft ? LEFT_CLOSE : RIGHT_CLOSE, index);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerCloseError(Throwable ex) {
            if (ExceptionHelper.addThrowable(this.error, ex)) {
                drain();
            } else {
                RxJavaPlugins.onError(ex);
            }
        }
    }

    static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final JoinSupport parent;

        LeftRightObserver(JoinSupport parent2, boolean isLeft2) {
            this.parent = parent2;
            this.isLeft = isLeft2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this, d);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object t) {
            this.parent.innerValue(this.isLeft, t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable t) {
            this.parent.innerError(t);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete(this);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final JoinSupport parent;

        LeftRightEndObserver(JoinSupport parent2, boolean isLeft2, int index2) {
            this.parent = parent2;
            this.isLeft = isLeft2;
            this.index = index2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this, d);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object t) {
            if (DisposableHelper.dispose(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable t) {
            this.parent.innerCloseError(t);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }
    }
}
