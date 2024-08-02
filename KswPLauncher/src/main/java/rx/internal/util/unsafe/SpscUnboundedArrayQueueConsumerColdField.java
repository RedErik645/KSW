package rx.internal.util.unsafe;

/* access modifiers changed from: package-private */
/* compiled from: SpscUnboundedArrayQueue */
public abstract class SpscUnboundedArrayQueueConsumerColdField<E> extends SpscUnboundedArrayQueueL2Pad<E> {
    protected E[] consumerBuffer;
    protected long consumerMask;

    SpscUnboundedArrayQueueConsumerColdField() {
    }
}
