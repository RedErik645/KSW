package rx.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Subscription;
import rx.functions.Func1;

public final class IndexedRingBuffer<E> implements Subscription {
    private static final ObjectPool<IndexedRingBuffer<?>> POOL = new ObjectPool<IndexedRingBuffer<?>>() {
        /* class rx.internal.util.IndexedRingBuffer.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // rx.internal.util.ObjectPool
        public IndexedRingBuffer<?> createObject() {
            return new IndexedRingBuffer<>();
        }
    };
    static final int SIZE;
    private final ElementSection<E> elements = new ElementSection<>();
    final AtomicInteger index = new AtomicInteger();
    private final IndexSection removed = new IndexSection();
    final AtomicInteger removedIndex = new AtomicInteger();

    static {
        int defaultSize = 128;
        if (PlatformDependent.isAndroid()) {
            defaultSize = 8;
        }
        String sizeFromProperty = System.getProperty("rx.indexed-ring-buffer.size");
        if (sizeFromProperty != null) {
            try {
                defaultSize = Integer.parseInt(sizeFromProperty);
            } catch (NumberFormatException e) {
                System.err.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + sizeFromProperty + " => " + e.getMessage());
            }
        }
        SIZE = defaultSize;
    }

    public static <T> IndexedRingBuffer<T> getInstance() {
        return (IndexedRingBuffer<T>) POOL.borrowObject();
    }

    public void releaseToPool() {
        int maxIndex = this.index.get();
        int realIndex = 0;
        ElementSection<E> section = this.elements;
        loop0:
        while (true) {
            if (section == null) {
                break;
            }
            int i = 0;
            while (i < SIZE) {
                if (realIndex >= maxIndex) {
                    break loop0;
                }
                section.array.set(i, null);
                i++;
                realIndex++;
            }
            section = section.next.get();
        }
        this.index.set(0);
        this.removedIndex.set(0);
        POOL.returnObject(this);
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        releaseToPool();
    }

    IndexedRingBuffer() {
    }

    public int add(E e) {
        int i = getIndexForAdd();
        int i2 = SIZE;
        if (i < i2) {
            this.elements.array.set(i, e);
            return i;
        }
        getElementSection(i).array.set(i % i2, e);
        return i;
    }

    /* JADX INFO: Multiple debug info for r0v2 int: [D('e' E), D('sectionIndex' int)] */
    public E remove(int index2) {
        E e;
        int i = SIZE;
        if (index2 < i) {
            e = this.elements.array.getAndSet(index2, null);
        } else {
            e = getElementSection(index2).array.getAndSet(index2 % i, null);
        }
        pushRemovedIndex(index2);
        return e;
    }

    private IndexSection getIndexSection(int index2) {
        int i = SIZE;
        if (index2 < i) {
            return this.removed;
        }
        int numSections = index2 / i;
        IndexSection a = this.removed;
        for (int i2 = 0; i2 < numSections; i2++) {
            a = a.getNext();
        }
        return a;
    }

    private ElementSection<E> getElementSection(int index2) {
        int i = SIZE;
        if (index2 < i) {
            return this.elements;
        }
        int numSections = index2 / i;
        ElementSection<E> a = this.elements;
        for (int i2 = 0; i2 < numSections; i2++) {
            a = a.getNext();
        }
        return a;
    }

    /* JADX INFO: Multiple debug info for r1v5 int: [D('sectionIndex' int), D('i' int)] */
    private synchronized int getIndexForAdd() {
        int sectionIndex;
        int ri = getIndexFromPreviouslyRemoved();
        if (ri >= 0) {
            int i = SIZE;
            if (ri < i) {
                sectionIndex = this.removed.getAndSet(ri, -1);
            } else {
                sectionIndex = getIndexSection(ri).getAndSet(ri % i, -1);
            }
            if (sectionIndex == this.index.get()) {
                this.index.getAndIncrement();
            }
        } else {
            sectionIndex = this.index.getAndIncrement();
        }
        return sectionIndex;
    }

    private synchronized int getIndexFromPreviouslyRemoved() {
        int currentRi;
        do {
            currentRi = this.removedIndex.get();
            if (currentRi <= 0) {
                return -1;
            }
        } while (!this.removedIndex.compareAndSet(currentRi, currentRi - 1));
        return currentRi - 1;
    }

    private synchronized void pushRemovedIndex(int elementIndex) {
        int i = this.removedIndex.getAndIncrement();
        int i2 = SIZE;
        if (i < i2) {
            this.removed.set(i, elementIndex);
        } else {
            getIndexSection(i).set(i % i2, elementIndex);
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return false;
    }

    public int forEach(Func1<? super E, Boolean> action) {
        return forEach(action, 0);
    }

    public int forEach(Func1<? super E, Boolean> action, int startIndex) {
        int endedAt = forEach(action, startIndex, this.index.get());
        if (startIndex > 0 && endedAt == this.index.get()) {
            return forEach(action, 0, startIndex);
        }
        if (endedAt == this.index.get()) {
            return 0;
        }
        return endedAt;
    }

    private int forEach(Func1<? super E, Boolean> action, int startIndex, int endIndex) {
        int maxIndex = this.index.get();
        int realIndex = startIndex;
        ElementSection<E> section = this.elements;
        int i = SIZE;
        if (startIndex >= i) {
            section = getElementSection(startIndex);
            startIndex %= i;
        }
        loop0:
        while (true) {
            if (section == null) {
                break;
            }
            int i2 = startIndex;
            while (i2 < SIZE) {
                if (realIndex < maxIndex && realIndex < endIndex) {
                    E element = section.array.get(i2);
                    if (element != null && !action.call(element).booleanValue()) {
                        return realIndex;
                    }
                    i2++;
                    realIndex++;
                }
            }
            section = section.next.get();
            startIndex = 0;
        }
        return realIndex;
    }

    /* access modifiers changed from: package-private */
    public static final class ElementSection<E> {
        final AtomicReferenceArray<E> array = new AtomicReferenceArray<>(IndexedRingBuffer.SIZE);
        final AtomicReference<ElementSection<E>> next = new AtomicReference<>();

        ElementSection() {
        }

        /* access modifiers changed from: package-private */
        public ElementSection<E> getNext() {
            if (this.next.get() != null) {
                return this.next.get();
            }
            ElementSection<E> newSection = new ElementSection<>();
            if (this.next.compareAndSet(null, newSection)) {
                return newSection;
            }
            return this.next.get();
        }
    }

    /* access modifiers changed from: package-private */
    public static class IndexSection {
        private final AtomicReference<IndexSection> _next = new AtomicReference<>();
        private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);

        IndexSection() {
        }

        public int getAndSet(int expected, int newValue) {
            return this.unsafeArray.getAndSet(expected, newValue);
        }

        public void set(int i, int elementIndex) {
            this.unsafeArray.set(i, elementIndex);
        }

        /* access modifiers changed from: package-private */
        public IndexSection getNext() {
            if (this._next.get() != null) {
                return this._next.get();
            }
            IndexSection newSection = new IndexSection();
            if (this._next.compareAndSet(null, newSection)) {
                return newSection;
            }
            return this._next.get();
        }
    }
}
