package rx.internal.util.unsafe;

/* access modifiers changed from: package-private */
/* compiled from: SpmcArrayQueue */
public abstract class SpmcArrayQueueProducerIndexCacheField<E> extends SpmcArrayQueueMidPad<E> {
    private volatile long producerIndexCache;

    public SpmcArrayQueueProducerIndexCacheField(int capacity) {
        super(capacity);
    }

    /* access modifiers changed from: protected */
    public final long lvProducerIndexCache() {
        return this.producerIndexCache;
    }

    /* access modifiers changed from: protected */
    public final void svProducerIndexCache(long v) {
        this.producerIndexCache = v;
    }
}
