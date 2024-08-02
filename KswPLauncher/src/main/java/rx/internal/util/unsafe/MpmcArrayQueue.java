package rx.internal.util.unsafe;

public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {
    long p30;
    long p31;
    long p32;
    long p33;
    long p34;
    long p35;
    long p36;
    long p37;
    long p40;
    long p41;
    long p42;
    long p43;
    long p44;
    long p45;
    long p46;

    public MpmcArrayQueue(int capacity) {
        super(Math.max(2, capacity));
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public boolean offer(E e) {
        if (e != null) {
            long capacity = this.mask + 1;
            long[] lSequenceBuffer = this.sequenceBuffer;
            long cIndex = Long.MAX_VALUE;
            while (true) {
                long currentProducerIndex = lvProducerIndex();
                long seqOffset = calcSequenceOffset(currentProducerIndex);
                long delta = lvSequence(lSequenceBuffer, seqOffset) - currentProducerIndex;
                if (delta == 0) {
                    if (casProducerIndex(currentProducerIndex, currentProducerIndex + 1)) {
                        spElement(calcElementOffset(currentProducerIndex), e);
                        soSequence(lSequenceBuffer, seqOffset, currentProducerIndex + 1);
                        return true;
                    }
                } else if (delta < 0 && currentProducerIndex - capacity <= cIndex) {
                    long lvConsumerIndex = lvConsumerIndex();
                    cIndex = lvConsumerIndex;
                    if (currentProducerIndex - capacity <= lvConsumerIndex) {
                        return false;
                    }
                }
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public E poll() {
        long[] lSequenceBuffer = this.sequenceBuffer;
        long pIndex = -1;
        while (true) {
            long currentConsumerIndex = lvConsumerIndex();
            long seqOffset = calcSequenceOffset(currentConsumerIndex);
            long delta = lvSequence(lSequenceBuffer, seqOffset) - (currentConsumerIndex + 1);
            if (delta == 0) {
                if (casConsumerIndex(currentConsumerIndex, currentConsumerIndex + 1)) {
                    long offset = calcElementOffset(currentConsumerIndex);
                    E e = lpElement(offset);
                    spElement(offset, null);
                    soSequence(lSequenceBuffer, seqOffset, this.mask + currentConsumerIndex + 1);
                    return e;
                }
            } else if (delta < 0 && currentConsumerIndex >= pIndex) {
                long lvProducerIndex = lvProducerIndex();
                pIndex = lvProducerIndex;
                if (currentConsumerIndex == lvProducerIndex) {
                    return null;
                }
            }
        }
    }

    @Override // rx.internal.util.unsafe.MessagePassingQueue, java.util.Queue
    public E peek() {
        long currConsumerIndex;
        E e;
        do {
            currConsumerIndex = lvConsumerIndex();
            e = lpElement(calcElementOffset(currConsumerIndex));
            if (e != null) {
                break;
            }
        } while (currConsumerIndex != lvProducerIndex());
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
