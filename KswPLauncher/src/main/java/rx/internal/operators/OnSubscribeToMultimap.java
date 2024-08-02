package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OnSubscribeToMultimap<T, K, V> implements Observable.OnSubscribe<Map<K, Collection<V>>>, Func0<Map<K, Collection<V>>> {
    private final Func1<? super K, ? extends Collection<V>> collectionFactory;
    private final Func1<? super T, ? extends K> keySelector;
    private final Func0<? extends Map<K, Collection<V>>> mapFactory;
    private final Observable<T> source;
    private final Func1<? super T, ? extends V> valueSelector;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeToMultimap(Observable<T> source2, Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2) {
        this(source2, keySelector2, valueSelector2, null, DefaultMultimapCollectionFactory.instance());
    }

    public OnSubscribeToMultimap(Observable<T> source2, Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2, Func0<? extends Map<K, Collection<V>>> mapFactory2) {
        this(source2, keySelector2, valueSelector2, mapFactory2, DefaultMultimapCollectionFactory.instance());
    }

    public OnSubscribeToMultimap(Observable<T> source2, Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2, Func0<? extends Map<K, Collection<V>>> mapFactory2, Func1<? super K, ? extends Collection<V>> collectionFactory2) {
        this.source = source2;
        this.keySelector = keySelector2;
        this.valueSelector = valueSelector2;
        if (mapFactory2 == null) {
            this.mapFactory = this;
        } else {
            this.mapFactory = mapFactory2;
        }
        this.collectionFactory = collectionFactory2;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public Map<K, Collection<V>> call() {
        return new HashMap();
    }

    public void call(Subscriber<? super Map<K, Collection<V>>> subscriber) {
        try {
            new ToMultimapSubscriber(subscriber, (Map) this.mapFactory.call(), this.keySelector, this.valueSelector, this.collectionFactory).subscribeTo(this.source);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            subscriber.onError(ex);
        }
    }

    /* access modifiers changed from: private */
    public static final class ToMultimapSubscriber<T, K, V> extends DeferredScalarSubscriberSafe<T, Map<K, Collection<V>>> {
        private final Func1<? super K, ? extends Collection<V>> collectionFactory;
        private final Func1<? super T, ? extends K> keySelector;
        private final Func1<? super T, ? extends V> valueSelector;

        ToMultimapSubscriber(Subscriber<? super Map<K, Collection<V>>> subscriber, Map<K, Collection<V>> map, Func1<? super T, ? extends K> keySelector2, Func1<? super T, ? extends V> valueSelector2, Func1<? super K, ? extends Collection<V>> collectionFactory2) {
            super(subscriber);
            this.value = map;
            this.hasValue = true;
            this.keySelector = keySelector2;
            this.valueSelector = valueSelector2;
            this.collectionFactory = collectionFactory2;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.util.Map */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                try {
                    Object call = this.keySelector.call(t);
                    Object call2 = this.valueSelector.call(t);
                    Collection collection = (Collection) ((Map) this.value).get(call);
                    if (collection == null) {
                        collection = (Collection) this.collectionFactory.call(call);
                        ((Map) this.value).put(call, collection);
                    }
                    collection.add(call2);
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    unsubscribe();
                    onError(ex);
                }
            }
        }
    }

    private static final class DefaultMultimapCollectionFactory<K, V> implements Func1<K, Collection<V>> {
        private static final DefaultMultimapCollectionFactory<Object, Object> INSTANCE = new DefaultMultimapCollectionFactory<>();

        private DefaultMultimapCollectionFactory() {
        }

        static <K, V> DefaultMultimapCollectionFactory<K, V> instance() {
            return (DefaultMultimapCollectionFactory<K, V>) INSTANCE;
        }

        @Override // rx.functions.Func1
        public Collection<V> call(K k) {
            return new ArrayList();
        }
    }
}
