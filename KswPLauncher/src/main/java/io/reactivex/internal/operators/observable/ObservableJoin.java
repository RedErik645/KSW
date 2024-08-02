package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
    final ObservableSource<? extends TRight> other;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;

    public ObservableJoin(ObservableSource<TLeft> source, ObservableSource<? extends TRight> other2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd2, Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd2, BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector2) {
        super(source);
        this.other = other2;
        this.leftEnd = leftEnd2;
        this.rightEnd = rightEnd2;
        this.resultSelector = resultSelector2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> parent = new JoinDisposable<>(observer, this.leftEnd, this.rightEnd, this.resultSelector);
        observer.onSubscribe(parent);
        ObservableGroupJoin.LeftRightObserver left = new ObservableGroupJoin.LeftRightObserver(parent, true);
        parent.disposables.add(left);
        ObservableGroupJoin.LeftRightObserver right = new ObservableGroupJoin.LeftRightObserver(parent, false);
        parent.disposables.add(right);
        this.source.subscribe(left);
        this.other.subscribe(right);
    }

    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {
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
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights = new LinkedHashMap();

        JoinDisposable(Observer<? super R> actual, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd2, Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd2, BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector2) {
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

        /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: java.util.Map<java.lang.Integer, TRight> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v38, resolved type: java.util.Map<java.lang.Integer, TLeft> */
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
                            int idx = this.leftIndex;
                            this.leftIndex = idx + 1;
                            this.lefts.put(Integer.valueOf(idx), val);
                            try {
                                ObservableSource<TLeftEnd> p = (ObservableSource) ObjectHelper.requireNonNull(this.leftEnd.apply(val), "The leftEnd returned a null ObservableSource");
                                ObservableGroupJoin.LeftRightEndObserver end = new ObservableGroupJoin.LeftRightEndObserver(this, true, idx);
                                this.disposables.add(end);
                                p.subscribe(end);
                                if (this.error.get() != null) {
                                    q.clear();
                                    cancelAll();
                                    errorAll(a);
                                    return;
                                }
                                for (Iterator<TRight> it = this.rights.values().iterator(); it.hasNext(); it = it) {
                                    try {
                                        a.onNext((Object) ObjectHelper.requireNonNull(this.resultSelector.apply(val, it.next()), "The resultSelector returned a null value"));
                                    } catch (Throwable exc) {
                                        fail(exc, a, q);
                                        return;
                                    }
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
                                ObservableGroupJoin.LeftRightEndObserver end2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, idx2);
                                this.disposables.add(end2);
                                p2.subscribe(end2);
                                if (this.error.get() != null) {
                                    q.clear();
                                    cancelAll();
                                    errorAll(a);
                                    return;
                                }
                                for (Iterator<TLeft> it2 = this.lefts.values().iterator(); it2.hasNext(); it2 = it2) {
                                    try {
                                        a.onNext((Object) ObjectHelper.requireNonNull(this.resultSelector.apply(it2.next(), val), "The resultSelector returned a null value"));
                                    } catch (Throwable exc3) {
                                        fail(exc3, a, q);
                                        return;
                                    }
                                }
                            } catch (Throwable exc4) {
                                fail(exc4, a, q);
                                return;
                            }
                        } else if (mode == LEFT_CLOSE) {
                            ObservableGroupJoin.LeftRightEndObserver end3 = (ObservableGroupJoin.LeftRightEndObserver) val;
                            this.lefts.remove(Integer.valueOf(end3.index));
                            this.disposables.remove(end3);
                        } else {
                            ObservableGroupJoin.LeftRightEndObserver end4 = (ObservableGroupJoin.LeftRightEndObserver) val;
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
        public void innerComplete(ObservableGroupJoin.LeftRightObserver sender) {
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
        public void innerClose(boolean isLeft, ObservableGroupJoin.LeftRightEndObserver index) {
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
}
