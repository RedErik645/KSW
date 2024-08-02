package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;

public class AppendOnlyLinkedArrayList<T> {
    final int capacity;
    final Object[] head;
    int offset;
    Object[] tail;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int capacity2) {
        this.capacity = capacity2;
        Object[] objArr = new Object[(capacity2 + 1)];
        this.head = objArr;
        this.tail = objArr;
    }

    public void add(T value) {
        int c = this.capacity;
        int o = this.offset;
        if (o == c) {
            Object[] next = new Object[(c + 1)];
            this.tail[c] = next;
            this.tail = next;
            o = 0;
        }
        this.tail[o] = value;
        this.offset = o + 1;
    }

    public void setFirst(T value) {
        this.head[0] = value;
    }

    public void forEachWhile(NonThrowingPredicate<? super T> consumer) {
        int c = this.capacity;
        for (Object[] a = this.head; a != null; a = a[c]) {
            for (int i = 0; i < c; i++) {
                Object o = a[i];
                if (o == null) {
                    continue;
                    break;
                } else if (consumer.test(o)) {
                    return;
                }
            }
        }
    }

    public <U> boolean accept(Subscriber<? super U> subscriber) {
        int c = this.capacity;
        for (Object[] a = this.head; a != null; a = (Object[]) a[c]) {
            for (int i = 0; i < c; i++) {
                Object o = a[i];
                if (o == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull(o, subscriber)) {
                    return true;
                }
            }
        }
        return false;
    }

    public <U> boolean accept(Observer<? super U> observer) {
        int c = this.capacity;
        for (Object[] a = this.head; a != null; a = (Object[]) a[c]) {
            for (int i = 0; i < c; i++) {
                Object o = a[i];
                if (o == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull(o, observer)) {
                    return true;
                }
            }
        }
        return false;
    }

    public <S> void forEachWhile(S state, BiPredicate<? super S, ? super T> consumer) throws Exception {
        Object[] a = this.head;
        int c = this.capacity;
        while (true) {
            for (int i = 0; i < c; i++) {
                Object o = a[i];
                if (o == null || consumer.test(state, o)) {
                    return;
                }
            }
            a = a[c];
        }
    }
}
