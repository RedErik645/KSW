package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;
    final int capacitySkip;
    final AtomicLong consumerIndex = new AtomicLong();
    final int mask;
    final AtomicLong producerIndex = new AtomicLong();

    public SpscExactAtomicArrayQueue(int capacity) {
        super(Pow2.roundToPowerOfTwo(capacity));
        int len = length();
        this.mask = len - 1;
        this.capacitySkip = len - capacity;
    }

    @Override // java.util.Queue
    public boolean offer(T value) {
        if (value != null) {
            long pi = this.producerIndex.get();
            int m = this.mask;
            if (get(((int) (((long) this.capacitySkip) + pi)) & m) != null) {
                return false;
            }
            this.producerIndex.lazySet(1 + pi);
            lazySet(((int) pi) & m, value);
            return true;
        }
        throw new NullPointerException();
    }

    @Override // java.util.Queue
    public T poll() {
        long ci = this.consumerIndex.get();
        int offset = ((int) ci) & this.mask;
        T value = (T) get(offset);
        if (value == null) {
            return null;
        }
        this.consumerIndex.lazySet(1 + ci);
        lazySet(offset, null);
        return value;
    }

    @Override // java.util.Queue
    public T peek() {
        return (T) get(((int) this.consumerIndex.get()) & this.mask);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.producerIndex == this.consumerIndex;
    }

    public int size() {
        long ci = this.consumerIndex.get();
        while (true) {
            long pi = this.producerIndex.get();
            long ci2 = this.consumerIndex.get();
            if (ci == ci2) {
                return (int) (pi - ci2);
            }
            ci = ci2;
        }
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.util.Queue
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }
}
