package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    private final AtomicReference<LinkedQueueNode<T>> consumerNode = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> producerNode = new AtomicReference<>();

    public MpscLinkedQueue() {
        LinkedQueueNode<T> node = new LinkedQueueNode<>();
        spConsumerNode(node);
        xchgProducerNode(node);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T e) {
        if (e != null) {
            LinkedQueueNode<T> nextNode = new LinkedQueueNode<>(e);
            xchgProducerNode(nextNode).soNext(nextNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue, io.reactivex.internal.fuseable.SimplePlainQueue
    public T poll() {
        LinkedQueueNode<T> nextNode;
        LinkedQueueNode<T> currConsumerNode = lpConsumerNode();
        LinkedQueueNode<T> nextNode2 = currConsumerNode.lvNext();
        if (nextNode2 != null) {
            T nextValue = nextNode2.getAndNullValue();
            spConsumerNode(nextNode2);
            return nextValue;
        } else if (currConsumerNode == lvProducerNode()) {
            return null;
        } else {
            do {
                nextNode = currConsumerNode.lvNext();
            } while (nextNode == null);
            T nextValue2 = nextNode.getAndNullValue();
            spConsumerNode(nextNode);
            return nextValue2;
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T v1, T v2) {
        offer(v1);
        offer(v2);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    @Override // io.reactivex.internal.fuseable.SimpleQueue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.queue.MpscLinkedQueue.clear():void");
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> lvProducerNode() {
        return this.producerNode.get();
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> xchgProducerNode(LinkedQueueNode<T> node) {
        return this.producerNode.getAndSet(node);
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> lvConsumerNode() {
        return this.consumerNode.get();
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> lpConsumerNode() {
        return this.consumerNode.get();
    }

    /* access modifiers changed from: package-private */
    public void spConsumerNode(LinkedQueueNode<T> node) {
        this.consumerNode.lazySet(node);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    /* access modifiers changed from: package-private */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E val) {
            spValue(val);
        }

        public E getAndNullValue() {
            E temp = lpValue();
            spValue(null);
            return temp;
        }

        public E lpValue() {
            return this.value;
        }

        public void spValue(E newValue) {
            this.value = newValue;
        }

        public void soNext(LinkedQueueNode<E> n) {
            lazySet(n);
        }

        public LinkedQueueNode<E> lvNext() {
            return (LinkedQueueNode) get();
        }
    }
}
