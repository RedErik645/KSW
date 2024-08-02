package rx.internal.util.unsafe;

public final class SpmcArrayQueue<E> extends SpmcArrayQueueL3Pad<E> {
    public SpmcArrayQueue(int capacity) {
        super(capacity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: rx.internal.util.unsafe.SpmcArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public boolean offer(E e) {
        if (e != null) {
            Object[] objArr = this.buffer;
            long lMask = this.mask;
            long currProducerIndex = lvProducerIndex();
            long offset = calcElementOffset(currProducerIndex);
            if (lvElement(objArr, offset) == null) {
                spElement(objArr, offset, e);
                soTail(1 + currProducerIndex);
            } else if (currProducerIndex - lvConsumerIndex() > lMask) {
                return false;
            } else {
                do {
                } while (lvElement(objArr, offset) != null);
            }
            spElement(objArr, offset, e);
            soTail(1 + currProducerIndex);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: rx.internal.util.unsafe.SpmcArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public E poll() {
        long currentConsumerIndex;
        long currProducerIndexCache = lvProducerIndexCache();
        do {
            currentConsumerIndex = lvConsumerIndex();
            if (currentConsumerIndex >= currProducerIndexCache) {
                long currProducerIndex = lvProducerIndex();
                if (currentConsumerIndex >= currProducerIndex) {
                    return null;
                }
                svProducerIndexCache(currProducerIndex);
            }
        } while (!casHead(currentConsumerIndex, 1 + currentConsumerIndex));
        long offset = calcElementOffset(currentConsumerIndex);
        Object[] objArr = this.buffer;
        E e = (E) lpElement(objArr, offset);
        soElement(objArr, offset, null);
        return e;
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public E peek() {
        E e;
        long currProducerIndexCache = lvProducerIndexCache();
        do {
            long currentConsumerIndex = lvConsumerIndex();
            if (currentConsumerIndex >= currProducerIndexCache) {
                long currProducerIndex = lvProducerIndex();
                if (currentConsumerIndex >= currProducerIndex) {
                    return null;
                }
                svProducerIndexCache(currProducerIndex);
            }
            e = lvElement(calcElementOffset(currentConsumerIndex));
        } while (e == null);
        return e;
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
        long currentProducerIndex;
        long after = lvConsumerIndex();
        do {
            currentProducerIndex = lvProducerIndex();
            after = lvConsumerIndex();
        } while (after != after);
        return (int) (currentProducerIndex - after);
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }
}
