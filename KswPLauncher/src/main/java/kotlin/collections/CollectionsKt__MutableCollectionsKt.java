package kotlin.collections;

import com.wits.ksw.launcher.view.benzgs.BenzConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001a(\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\n¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\n\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\n\u001a(\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\n¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\n\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\n\u001a-\u0010\u0016\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0018\u001a&\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\b¢\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010\u001c\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\b\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a\u001d\u0010\u001e\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001d\u0010!\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010\"\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a-\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010#\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\b\u001a*\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a\u0015\u0010$\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0002\b%¨\u0006&"}, d2 = {"addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", BenzConfig.INDEX, "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* compiled from: MutableCollections.kt */
class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    private static final <T> boolean remove(Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return TypeIntrinsics.asMutableCollection(collection).remove(t);
    }

    private static final <T> boolean removeAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(collection2, "elements");
        return TypeIntrinsics.asMutableCollection(collection).removeAll(collection2);
    }

    private static final <T> boolean retainAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(collection2, "elements");
        return TypeIntrinsics.asMutableCollection(collection).retainAll(collection2);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        collection.add(t);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        CollectionsKt.addAll(collection, iterable);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        CollectionsKt.addAll(collection, tArr);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        CollectionsKt.addAll(collection, sequence);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        collection.remove(t);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        CollectionsKt.removeAll(collection, iterable);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        CollectionsKt.removeAll(collection, tArr);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        CollectionsKt.removeAll(collection, sequence);
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean result = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((Object) it.next())) {
                result = true;
            }
        }
        return result;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        boolean result = false;
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            if (collection.add((Object) it.next())) {
                result = true;
            }
        }
        return result;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return collection.addAll(ArraysKt.asList(tArr));
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        return TypeIntrinsics.asMutableCollection(collection).removeAll(BrittleContainsOptimizationKt.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        Collection set = BrittleContainsOptimizationKt.convertToSetForSetOperation(sequence);
        return (set.isEmpty() ^ true) && collection.removeAll(set);
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return ((tArr.length == 0) ^ true) && collection.removeAll(BrittleContainsOptimizationKt.convertToSetForSetOperation(tArr));
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        return TypeIntrinsics.asMutableCollection(collection).retainAll(BrittleContainsOptimizationKt.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (!(tArr.length == 0)) {
            return collection.retainAll(BrittleContainsOptimizationKt.convertToSetForSetOperation(tArr));
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        Collection set = BrittleContainsOptimizationKt.convertToSetForSetOperation(sequence);
        if (!set.isEmpty()) {
            return collection.retainAll(set);
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> collection) {
        boolean result = !collection.isEmpty();
        collection.clear();
        return result;
    }

    public static final <T> boolean removeAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) iterable, (Function1) function1, true);
    }

    public static final <T> boolean retainAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) iterable, (Function1) function1, false);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean predicateResultToRemove) {
        boolean result = false;
        Iterator $this$filterInPlace_u24lambda_u2d0 = iterable.iterator();
        while ($this$filterInPlace_u24lambda_u2d0.hasNext()) {
            if (function1.invoke((Object) $this$filterInPlace_u24lambda_u2d0.next()).booleanValue() == predicateResultToRemove) {
                $this$filterInPlace_u24lambda_u2d0.remove();
                result = true;
            }
        }
        return result;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    private static final <T> T remove(List<T> list, int index) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.remove(index);
    }

    public static final <T> T removeFirst(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T removeFirstOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public static final <T> T removeLast(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T removeLastOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    public static final <T> boolean removeAll(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) list, (Function1) function1, true);
    }

    public static final <T> boolean retainAll(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) list, (Function1) function1, false);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> list, Function1<? super T, Boolean> function1, boolean predicateResultToRemove) {
        if (!(list instanceof RandomAccess)) {
            return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(list), function1, predicateResultToRemove);
        }
        int writeIndex = 0;
        int readIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (0 <= lastIndex) {
            while (true) {
                T t = list.get(readIndex);
                if (function1.invoke(t).booleanValue() != predicateResultToRemove) {
                    if (writeIndex != readIndex) {
                        list.set(writeIndex, t);
                    }
                    writeIndex++;
                }
                if (readIndex == lastIndex) {
                    break;
                }
                readIndex++;
            }
        }
        if (writeIndex >= list.size()) {
            return false;
        }
        int removeIndex = CollectionsKt.getLastIndex(list);
        if (writeIndex > removeIndex) {
            return true;
        }
        while (true) {
            list.remove(removeIndex);
            if (removeIndex == writeIndex) {
                return true;
            }
            removeIndex--;
        }
    }
}