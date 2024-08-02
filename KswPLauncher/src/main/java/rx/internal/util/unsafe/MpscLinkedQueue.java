package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

public final class MpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public MpscLinkedQueue() {
        this.consumerNode = new LinkedQueueNode();
        xchgProducerNode(this.consumerNode);
    }

    /* access modifiers changed from: protected */
    public LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> newVal) {
        Object oldVal;
        do {
            oldVal = this.producerNode;
        } while (!UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, oldVal, newVal));
        return (LinkedQueueNode) oldVal;
    }

    @Override // java.util.Queue
    public boolean offer(E nextValue) {
        if (nextValue != null) {
            LinkedQueueNode<E> nextNode = new LinkedQueueNode<>(nextValue);
            xchgProducerNode(nextNode).soNext(nextNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> nextNode;
        LinkedQueueNode<E> currConsumerNode = lpConsumerNode();
        LinkedQueueNode<E> nextNode2 = currConsumerNode.lvNext();
        if (nextNode2 != null) {
            E nextValue = nextNode2.getAndNullValue();
            spConsumerNode(nextNode2);
            return nextValue;
        } else if (currConsumerNode == lvProducerNode()) {
            return null;
        } else {
            do {
                nextNode = currConsumerNode.lvNext();
            } while (nextNode == null);
            E nextValue2 = nextNode.getAndNullValue();
            this.consumerNode = nextNode;
            return nextValue2;
        }
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> nextNode;
        LinkedQueueNode<E> currConsumerNode = this.consumerNode;
        LinkedQueueNode<E> nextNode2 = currConsumerNode.lvNext();
        if (nextNode2 != null) {
            return nextNode2.lpValue();
        }
        if (currConsumerNode == lvProducerNode()) {
            return null;
        }
        do {
            nextNode = currConsumerNode.lvNext();
        } while (nextNode == null);
        return nextNode.lpValue();
    }
}
