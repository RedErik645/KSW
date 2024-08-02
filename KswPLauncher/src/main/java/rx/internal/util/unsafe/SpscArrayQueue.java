package rx.internal.util.unsafe;

public final class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
    public SpscArrayQueue(int capacity) {
        super(capacity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: rx.internal.util.unsafe.SpscArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public boolean offer(E e) {
        if (e != null) {
            Object[] objArr = this.buffer;
            long index = this.producerIndex;
            long offset = calcElementOffset(index);
            if (lvElement(objArr, offset) != null) {
                return false;
            }
            soElement(objArr, offset, e);
            soProducerIndex(1 + index);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: rx.internal.util.unsafe.SpscArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public E poll() {
        long index = this.consumerIndex;
        long offset = calcElementOffset(index);
        Object[] objArr = this.buffer;
        E e = (E) lvElement(objArr, offset);
        if (e == null) {
            return null;
        }
        soElement(objArr, offset, null);
        soConsumerIndex(1 + index);
        return e;
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public E peek() {
        return lvElement(calcElementOffset(this.consumerIndex));
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
        return lvProducerIndex() == lvConsumerIndex();
    }

    private void soProducerIndex(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, v);
    }

    private void soConsumerIndex(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, v);
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }
}
