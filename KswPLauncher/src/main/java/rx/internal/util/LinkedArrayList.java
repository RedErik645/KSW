package rx.internal.util;

import java.util.ArrayList;
import java.util.List;

public class LinkedArrayList {
    final int capacityHint;
    Object[] head;
    int indexInTail;
    volatile int size;
    Object[] tail;

    public LinkedArrayList(int capacityHint2) {
        this.capacityHint = capacityHint2;
    }

    public void add(Object o) {
        if (this.size == 0) {
            Object[] objArr = new Object[(this.capacityHint + 1)];
            this.head = objArr;
            this.tail = objArr;
            objArr[0] = o;
            this.indexInTail = 1;
            this.size = 1;
            return;
        }
        int i = this.indexInTail;
        int i2 = this.capacityHint;
        if (i == i2) {
            Object[] t = new Object[(i2 + 1)];
            t[0] = o;
            this.tail[i2] = t;
            this.tail = t;
            this.indexInTail = 1;
            this.size++;
            return;
        }
        this.tail[i] = o;
        this.indexInTail = i + 1;
        this.size++;
    }

    public Object[] head() {
        return this.head;
    }

    public Object[] tail() {
        return this.tail;
    }

    public int size() {
        return this.size;
    }

    public int indexInTail() {
        return this.indexInTail;
    }

    public int capacityHint() {
        return this.capacityHint;
    }

    /* access modifiers changed from: package-private */
    public List<Object> toList() {
        int cap = this.capacityHint;
        int s = this.size;
        List<Object> list = new ArrayList<>(s + 1);
        Object[] h = head();
        int j = 0;
        int k = 0;
        while (j < s) {
            list.add(h[k]);
            j++;
            k++;
            if (k == cap) {
                k = 0;
                h = (Object[]) h[cap];
            }
        }
        return list;
    }

    public String toString() {
        return toList().toString();
    }
}
