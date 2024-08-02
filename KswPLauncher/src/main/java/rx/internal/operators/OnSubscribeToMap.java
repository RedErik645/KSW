package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OnSubscribeToMap<T, K, V> implements Observable.OnSubscribe<Map<K, V>>, Func0<Map<K, V>> {
    final Func1<? super T, ? extends K> keySelector;
    final Func0<? extends Map<K, V>> mapFactory;
    final Observable<T> source;
    final Func1<? super T, ? extends V> valueSelector;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeToMap(Observable<T> source2, Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2) {
        this(source2, keySelector2, valueSelector2, null);
    }

    public OnSubscribeToMap(Observable<T> source2, Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2, Func0<? extends Map<K, V>> mapFactory2) {
        this.source = source2;
        this.keySelector = keySelector2;
        this.valueSelector = valueSelector2;
        if (mapFactory2 == null) {
            this.mapFactory = this;
        } else {
            this.mapFactory = mapFactory2;
        }
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public Map<K, V> call() {
        return new HashMap();
    }

    public void call(Subscriber<? super Map<K, V>> subscriber) {
        try {
            new ToMapSubscriber(subscriber, (Map) this.mapFactory.call(), this.keySelector, this.valueSelector).subscribeTo(this.source);
        } catch (Throwable ex) {
            Exceptions.throwOrReport(ex, subscriber);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ToMapSubscriber<T, K, V> extends DeferredScalarSubscriberSafe<T, Map<K, V>> {
        final Func1<? super T, ? extends K> keySelector;
        final Func1<? super T, ? extends V> valueSelector;

        ToMapSubscriber(Subscriber<? super Map<K, V>> actual, Map<K, V> map, Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2) {
            super(actual);
            this.value = map;
            this.hasValue = true;
            this.keySelector = keySelector2;
            this.valueSelector = valueSelector2;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.Map */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                try {
                    ((Map) this.value).put(this.keySelector.call(t), this.valueSelector.call(t));
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    unsubscribe();
                    onError(ex);
                }
            }
        }
    }
}
