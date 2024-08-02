package kotlin.collections;

import com.ibm.icu.text.PluralRules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    private static final <T> T component1(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) list.get(0);
    }

    private static final <T> T component2(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) list.get(1);
    }

    private static final <T> T component3(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) list.get(2);
    }

    private static final <T> T component4(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) list.get(3);
    }

    private static final <T> T component5(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) list.get(4);
    }

    public static final <T> boolean contains(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return CollectionsKt.indexOf(iterable, t) >= 0;
    }

    public static final <T> T elementAt(Iterable<? extends T> iterable, int index) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof List ? (T) ((List) iterable).get(index) : (T) CollectionsKt.elementAtOrElse(iterable, index, new CollectionsKt___CollectionsKt$elementAt$1(index));
    }

    private static final <T> T elementAt(List<? extends T> list, int index) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) list.get(index);
    }

    public static final <T> T elementAtOrElse(Iterable<? extends T> iterable, int index, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (index < 0 || index > CollectionsKt.getLastIndex(list)) ? (T) function1.invoke(Integer.valueOf(index)) : (T) list.get(index);
        } else if (index < 0) {
            return (T) function1.invoke(Integer.valueOf(index));
        } else {
            int count = 0;
            for (T t : iterable) {
                int count2 = count + 1;
                if (index == count) {
                    return t;
                }
                count = count2;
            }
            return (T) function1.invoke(Integer.valueOf(index));
        }
    }

    private static final <T> T elementAtOrElse(List<? extends T> list, int index, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        return (index < 0 || index > CollectionsKt.getLastIndex(list)) ? (T) function1.invoke(Integer.valueOf(index)) : (T) list.get(index);
    }

    public static final <T> T elementAtOrNull(Iterable<? extends T> iterable, int index) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.getOrNull((List) iterable, index);
        }
        if (index < 0) {
            return null;
        }
        int count = 0;
        for (T t : iterable) {
            int count2 = count + 1;
            if (index == count) {
                return t;
            }
            count = count2;
        }
        return null;
    }

    private static final <T> T elementAtOrNull(List<? extends T> list, int index) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) CollectionsKt.getOrNull(list, index);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> T find(java.lang.Iterable<? extends T> r5, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = r5
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x0010:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r2.next()
            java.lang.Object r4 = r6.invoke(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0010
            goto L_0x0028
        L_0x0027:
            r3 = 0
        L_0x0028:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.find(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> T findLast(java.lang.Iterable<? extends T> r6, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = r6
            r1 = 0
            r2 = 0
            java.util.Iterator r3 = r0.iterator()
        L_0x0011:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0029
            java.lang.Object r4 = r3.next()
            java.lang.Object r5 = r7.invoke(r4)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0011
            r2 = r4
            goto L_0x0011
        L_0x0029:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.findLast(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> T findLast(java.util.List<? extends T> r5, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = r5
            r1 = 0
            int r2 = r0.size()
            java.util.ListIterator r2 = r0.listIterator(r2)
        L_0x0014:
            boolean r3 = r2.hasPrevious()
            if (r3 == 0) goto L_0x002b
            java.lang.Object r3 = r2.previous()
            java.lang.Object r4 = r6.invoke(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0014
            goto L_0x002c
        L_0x002b:
            r3 = 0
        L_0x002c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.findLast(java.util.List, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final <T> T first(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.first((List) iterable);
        }
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            return (T) iterator.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T first(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return (T) list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T first(java.lang.Iterable<? extends T> r4, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            java.util.Iterator r1 = r4.iterator()
        L_0x000f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r1.next()
            java.lang.Object r3 = r5.invoke(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x000f
            return r2
        L_0x0026:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            java.lang.String r2 = "Collection contains no element matching the predicate."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.first(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    private static final <T, R> R firstNotNullOf(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        R r;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                r = null;
                break;
            }
            r = (R) function1.invoke((Object) it.next());
            if (r != null) {
                break;
            }
        }
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    }

    private static final <T, R> R firstNotNullOfOrNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R r = (R) function1.invoke((Object) it.next());
            if (r != null) {
                return r;
            }
        }
        return null;
    }

    public static final <T> T firstOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof List)) {
            Iterator iterator = iterable.iterator();
            if (!iterator.hasNext()) {
                return null;
            }
            return (T) iterator.next();
        } else if (((List) iterable).isEmpty()) {
            return null;
        } else {
            return (T) ((List) iterable).get(0);
        }
    }

    public static final <T> T firstOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T firstOrNull(java.lang.Iterable<? extends T> r4, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            java.util.Iterator r1 = r4.iterator()
        L_0x000f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r1.next()
            java.lang.Object r3 = r5.invoke(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x000f
            return r2
        L_0x0026:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    private static final <T> T getOrElse(List<? extends T> list, int index, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        return (index < 0 || index > CollectionsKt.getLastIndex(list)) ? (T) function1.invoke(Integer.valueOf(index)) : (T) list.get(index);
    }

    public static final <T> T getOrNull(List<? extends T> list, int index) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (index < 0 || index > CollectionsKt.getLastIndex(list)) {
            return null;
        }
        return (T) list.get(index);
    }

    public static final <T> int indexOf(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int index = 0;
        for (Object item : iterable) {
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static final <T> int indexOf(List<? extends T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.indexOf(t);
    }

    public static final <T> int indexOfFirst(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int index = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item = (Object) it.next();
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (function1.invoke(item).booleanValue()) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(List<? extends T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int index = 0;
        Iterator<? extends T> it = list.iterator();
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue()) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int lastIndex = -1;
        int index = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item = (Object) it.next();
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (function1.invoke(item).booleanValue()) {
                lastIndex = index;
            }
            index++;
        }
        return lastIndex;
    }

    public static final <T> int indexOfLast(List<? extends T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ListIterator iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            if (function1.invoke((Object) iterator.previous()).booleanValue()) {
                return iterator.nextIndex();
            }
        }
        return -1;
    }

    public static final <T> T last(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.last((List) iterable);
        }
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            Object last = (T) iterator.next();
            while (iterator.hasNext()) {
                last = (T) iterator.next();
            }
            return (T) last;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T last(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return (T) list.get(CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T last(java.lang.Iterable<? extends T> r6, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r1 = 0
            r2 = 0
            java.util.Iterator r3 = r6.iterator()
        L_0x0011:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x002a
            java.lang.Object r4 = r3.next()
            java.lang.Object r5 = r7.invoke(r4)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0011
            r1 = r4
            r2 = 1
            goto L_0x0011
        L_0x002a:
            if (r2 == 0) goto L_0x002d
            return r1
        L_0x002d:
            java.util.NoSuchElementException r3 = new java.util.NoSuchElementException
            java.lang.String r4 = "Collection contains no element matching the predicate."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.last(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T last(java.util.List<? extends T> r4, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            int r1 = r4.size()
            java.util.ListIterator r1 = r4.listIterator(r1)
        L_0x0013:
            boolean r2 = r1.hasPrevious()
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r1.previous()
            java.lang.Object r3 = r5.invoke(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0013
            return r2
        L_0x002a:
            java.util.NoSuchElementException r2 = new java.util.NoSuchElementException
            java.lang.String r3 = "List contains no element matching the predicate."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.last(java.util.List, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final <T> int lastIndexOf(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t);
        }
        int lastIndex = -1;
        int index = 0;
        for (Object item : iterable) {
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, item)) {
                lastIndex = index;
            }
            index++;
        }
        return lastIndex;
    }

    public static final <T> int lastIndexOf(List<? extends T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.lastIndexOf(t);
    }

    public static final <T> T lastOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof List)) {
            Iterator iterator = iterable.iterator();
            if (!iterator.hasNext()) {
                return null;
            }
            Object last = (T) iterator.next();
            while (iterator.hasNext()) {
                last = (T) iterator.next();
            }
            return (T) last;
        } else if (((List) iterable).isEmpty()) {
            return null;
        } else {
            return (T) ((List) iterable).get(((List) iterable).size() - 1);
        }
    }

    public static final <T> T lastOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(list.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T lastOrNull(java.lang.Iterable<? extends T> r5, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r1 = 0
            java.util.Iterator r2 = r5.iterator()
        L_0x0010:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0028
            java.lang.Object r3 = r2.next()
            java.lang.Object r4 = r6.invoke(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0010
            r1 = r3
            goto L_0x0010
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T lastOrNull(java.util.List<? extends T> r4, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            int r1 = r4.size()
            java.util.ListIterator r1 = r4.listIterator(r1)
        L_0x0013:
            boolean r2 = r1.hasPrevious()
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r1.previous()
            java.lang.Object r3 = r5.invoke(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0013
            return r2
        L_0x002a:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(java.util.List, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    private static final <T> T random(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return (T) CollectionsKt.random(collection, Random.Default);
    }

    public static final <T> T random(Collection<? extends T> collection, Random random) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!collection.isEmpty()) {
            return (T) CollectionsKt.elementAt(collection, random.nextInt(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    private static final <T> T randomOrNull(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return (T) CollectionsKt.randomOrNull(collection, Random.Default);
    }

    public static final <T> T randomOrNull(Collection<? extends T> collection, Random random) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) CollectionsKt.elementAt(collection, random.nextInt(collection.size()));
    }

    public static final <T> T single(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.single((List) iterable);
        }
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            T t = (T) iterator.next();
            if (!iterator.hasNext()) {
                return t;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T single(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        switch (list.size()) {
            case 0:
                throw new NoSuchElementException("List is empty.");
            case 1:
                return (T) list.get(0);
            default:
                throw new IllegalArgumentException("List has more than one element.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T single(java.lang.Iterable<? extends T> r6, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r1 = 0
            r2 = 0
            java.util.Iterator r3 = r6.iterator()
        L_0x0011:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0034
            java.lang.Object r4 = r3.next()
            java.lang.Object r5 = r7.invoke(r4)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0011
            if (r2 != 0) goto L_0x002c
            r1 = r4
            r2 = 1
            goto L_0x0011
        L_0x002c:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Collection contains more than one matching element."
            r3.<init>(r5)
            throw r3
        L_0x0034:
            if (r2 == 0) goto L_0x0037
            return r1
        L_0x0037:
            java.util.NoSuchElementException r3 = new java.util.NoSuchElementException
            java.lang.String r4 = "Collection contains no element matching the predicate."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.single(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final <T> T singleOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof List)) {
            Iterator iterator = iterable.iterator();
            if (!iterator.hasNext()) {
                return null;
            }
            T t = (T) iterator.next();
            if (iterator.hasNext()) {
                return null;
            }
            return t;
        } else if (((List) iterable).size() == 1) {
            return (T) ((List) iterable).get(0);
        } else {
            return null;
        }
    }

    public static final <T> T singleOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() == 1) {
            return (T) list.get(0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T singleOrNull(java.lang.Iterable<? extends T> r7, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            r1 = 0
            r2 = 0
            java.util.Iterator r3 = r7.iterator()
        L_0x0011:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x002e
            java.lang.Object r4 = r3.next()
            java.lang.Object r6 = r8.invoke(r4)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0011
            if (r2 == 0) goto L_0x002b
            return r5
        L_0x002b:
            r1 = r4
            r2 = 1
            goto L_0x0011
        L_0x002e:
            if (r2 != 0) goto L_0x0031
            return r5
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.singleOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final <T> List<T> drop(Iterable<? extends T> iterable, int n) {
        ArrayList list;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(n >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + n + " is less than zero.").toString());
        } else if (n == 0) {
            return CollectionsKt.toList(iterable);
        } else {
            if (iterable instanceof Collection) {
                int resultSize = ((Collection) iterable).size() - n;
                if (resultSize <= 0) {
                    return CollectionsKt.emptyList();
                }
                if (resultSize == 1) {
                    return CollectionsKt.listOf(CollectionsKt.last(iterable));
                }
                list = new ArrayList(resultSize);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size = ((Collection) iterable).size();
                        for (int index = n; index < size; index++) {
                            list.add(((List) iterable).get(index));
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(n);
                        while (listIterator.hasNext()) {
                            list.add(listIterator.next());
                        }
                    }
                    return list;
                }
            } else {
                list = new ArrayList();
            }
            int count = 0;
            for (Object item : iterable) {
                if (count >= n) {
                    list.add(item);
                } else {
                    count++;
                }
            }
            return CollectionsKt.optimizeReadOnlyList(list);
        }
    }

    public static final <T> List<T> dropLast(List<? extends T> list, int n) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (n >= 0) {
            return CollectionsKt.take(list, RangesKt.coerceAtLeast(list.size() - n, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + n + " is less than zero.").toString());
    }

    public static final <T> List<T> dropLastWhile(List<? extends T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (!list.isEmpty()) {
            ListIterator iterator = list.listIterator(list.size());
            while (iterator.hasPrevious()) {
                if (!function1.invoke((Object) iterator.previous()).booleanValue()) {
                    return CollectionsKt.take(list, iterator.nextIndex() + 1);
                }
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final <T> List<T> dropWhile(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        boolean yielding = false;
        ArrayList list = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item = (Object) it.next();
            if (yielding) {
                list.add(item);
            } else if (!function1.invoke(item).booleanValue()) {
                list.add(item);
                yielding = true;
            }
        }
        return list;
    }

    public static final <T> List<T> filter(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Collection destination$iv = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element$iv = (Object) it.next();
            if (function1.invoke(element$iv).booleanValue()) {
                destination$iv.add(element$iv);
            }
        }
        return (List) destination$iv;
    }

    /* JADX INFO: Multiple debug info for r6v1 'index$iv$iv'  int: [D('index$iv' int), D('index$iv$iv' int)] */
    public static final <T> List<T> filterIndexed(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Collection destination$iv = new ArrayList();
        int index$iv = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item$iv$iv = (Object) it.next();
            int index$iv$iv = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (function2.invoke(Integer.valueOf(index$iv), item$iv$iv).booleanValue()) {
                destination$iv.add(item$iv$iv);
            }
            index$iv = index$iv$iv;
        }
        return (List) destination$iv;
    }

    /* JADX INFO: Multiple debug info for r3v1 'index$iv'  int: [D('index' int), D('index$iv' int)] */
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(Iterable<? extends T> iterable, C c, Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int index = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item$iv = (Object) it.next();
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (function2.invoke(Integer.valueOf(index), item$iv).booleanValue()) {
                c.add(item$iv);
            }
            index = index$iv;
        }
        return c;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Iterable<?> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Collection destination$iv = new ArrayList();
        for (Object element$iv : iterable) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (element$iv instanceof Object) {
                destination$iv.add(element$iv);
            }
        }
        return (List) destination$iv;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Iterable<?> iterable, C c) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        for (Object element : iterable) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (element instanceof Object) {
                c.add(element);
            }
        }
        return c;
    }

    public static final <T> List<T> filterNot(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Collection destination$iv = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element$iv = (Object) it.next();
            if (!function1.invoke(element$iv).booleanValue()) {
                destination$iv.add(element$iv);
            }
        }
        return (List) destination$iv;
    }

    public static final <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (List) CollectionsKt.filterNotNullTo(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> iterable, C c) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        for (Object element : iterable) {
            if (element != null) {
                c.add(element);
            }
        }
        return c;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(Iterable<? extends T> iterable, C c, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            if (!function1.invoke(element).booleanValue()) {
                c.add(element);
            }
        }
        return c;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(Iterable<? extends T> iterable, C c, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            if (function1.invoke(element).booleanValue()) {
                c.add(element);
            }
        }
        return c;
    }

    public static final <T> List<T> slice(List<? extends T> list, IntRange indices) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.toList(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final <T> List<T> slice(List<? extends T> list, Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int size = CollectionsKt.collectionSizeOrDefault(iterable, 10);
        if (size == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList list2 = new ArrayList(size);
        for (Integer num : iterable) {
            list2.add(list.get(num.intValue()));
        }
        return list2;
    }

    public static final <T> List<T> take(Iterable<? extends T> iterable, int n) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(n >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + n + " is less than zero.").toString());
        } else if (n == 0) {
            return CollectionsKt.emptyList();
        } else {
            if (iterable instanceof Collection) {
                if (n >= ((Collection) iterable).size()) {
                    return CollectionsKt.toList(iterable);
                }
                if (n == 1) {
                    return CollectionsKt.listOf(CollectionsKt.first(iterable));
                }
            }
            int count = 0;
            ArrayList list = new ArrayList(n);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                list.add(it.next());
                count++;
                if (count == n) {
                    break;
                }
            }
            return CollectionsKt.optimizeReadOnlyList(list);
        }
    }

    public static final <T> List<T> takeLast(List<? extends T> list, int n) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!(n >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + n + " is less than zero.").toString());
        } else if (n == 0) {
            return CollectionsKt.emptyList();
        } else {
            int size = list.size();
            if (n >= size) {
                return CollectionsKt.toList(list);
            }
            if (n == 1) {
                return CollectionsKt.listOf(CollectionsKt.last((List) list));
            }
            ArrayList list2 = new ArrayList(n);
            if (list instanceof RandomAccess) {
                for (int index = size - n; index < size; index++) {
                    list2.add(list.get(index));
                }
            } else {
                ListIterator<? extends T> listIterator = list.listIterator(size - n);
                while (listIterator.hasNext()) {
                    list2.add(listIterator.next());
                }
            }
            return list2;
        }
    }

    public static final <T> List<T> takeLastWhile(List<? extends T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ListIterator iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            if (!function1.invoke((Object) iterator.previous()).booleanValue()) {
                iterator.next();
                int expectedSize = list.size() - iterator.nextIndex();
                if (expectedSize == 0) {
                    return CollectionsKt.emptyList();
                }
                ArrayList $this$takeLastWhile_u24lambda_u2d5 = new ArrayList(expectedSize);
                while (iterator.hasNext()) {
                    $this$takeLastWhile_u24lambda_u2d5.add(iterator.next());
                }
                return $this$takeLastWhile_u24lambda_u2d5;
            }
        }
        return CollectionsKt.toList(list);
    }

    public static final <T> List<T> takeWhile(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList list = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item = (Object) it.next();
            if (!function1.invoke(item).booleanValue()) {
                break;
            }
            list.add(item);
        }
        return list;
    }

    public static final <T> List<T> reversed(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return CollectionsKt.toList(iterable);
        }
        List list = CollectionsKt.toMutableList(iterable);
        CollectionsKt.reverse(list);
        return list;
    }

    public static final <T> void shuffle(List<T> list, Random random) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int i = CollectionsKt.getLastIndex(list); i > 0; i--) {
            int j = random.nextInt(i + 1);
            list.set(j, list.set(i, list.get(j)));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(List<T> list, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(List<T> list, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        CollectionsKt.sortWith(list, ComparisonsKt.reverseOrder());
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List $this$sorted_u24lambda_u2d7 = CollectionsKt.toMutableList(iterable);
            CollectionsKt.sort($this$sorted_u24lambda_u2d7);
            return $this$sorted_u24lambda_u2d7;
        } else if (((Collection) iterable).size() <= 1) {
            return CollectionsKt.toList(iterable);
        } else {
            Object[] array = ((Collection) iterable).toArray(new Comparable[0]);
            if (array != null) {
                Comparable[] $this$sorted_u24lambda_u2d6 = (Comparable[]) array;
                ArraysKt.sort((Object[]) $this$sorted_u24lambda_u2d6);
                return ArraysKt.asList($this$sorted_u24lambda_u2d6);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return CollectionsKt.sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return CollectionsKt.sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    public static final <T extends Comparable<? super T>> List<T> sortedDescending(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.sortedWith(iterable, ComparisonsKt.reverseOrder());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: java.util.Collection */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List $this$sortedWith_u24lambda_u2d9 = CollectionsKt.toMutableList(iterable);
            CollectionsKt.sortWith($this$sortedWith_u24lambda_u2d9, comparator);
            return $this$sortedWith_u24lambda_u2d9;
        } else if (((Collection) iterable).size() <= 1) {
            return CollectionsKt.toList(iterable);
        } else {
            Object[] $this$sortedWith_u24lambda_u2d8 = ((Collection) iterable).toArray(new Object[0]);
            if ($this$sortedWith_u24lambda_u2d8 != null) {
                ArraysKt.sortWith($this$sortedWith_u24lambda_u2d8, comparator);
                return ArraysKt.asList($this$sortedWith_u24lambda_u2d8);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public static final boolean[] toBooleanArray(Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        boolean[] result = new boolean[collection.size()];
        int index = 0;
        for (Boolean bool : collection) {
            result[index] = bool.booleanValue();
            index++;
        }
        return result;
    }

    public static final byte[] toByteArray(Collection<Byte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] result = new byte[collection.size()];
        int index = 0;
        for (Byte b : collection) {
            result[index] = b.byteValue();
            index++;
        }
        return result;
    }

    public static final char[] toCharArray(Collection<Character> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        char[] result = new char[collection.size()];
        int index = 0;
        for (Character ch : collection) {
            result[index] = ch.charValue();
            index++;
        }
        return result;
    }

    public static final double[] toDoubleArray(Collection<Double> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        double[] result = new double[collection.size()];
        int index = 0;
        for (Double d : collection) {
            result[index] = d.doubleValue();
            index++;
        }
        return result;
    }

    public static final float[] toFloatArray(Collection<Float> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        float[] result = new float[collection.size()];
        int index = 0;
        for (Float f : collection) {
            result[index] = f.floatValue();
            index++;
        }
        return result;
    }

    public static final int[] toIntArray(Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] result = new int[collection.size()];
        int index = 0;
        for (Integer num : collection) {
            result[index] = num.intValue();
            index++;
        }
        return result;
    }

    public static final long[] toLongArray(Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] result = new long[collection.size()];
        int index = 0;
        for (Long l : collection) {
            result[index] = l.longValue();
            index++;
        }
        return result;
    }

    public static final short[] toShortArray(Collection<Short> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] result = new short[collection.size()];
        int index = 0;
        for (Short sh : collection) {
            result[index] = sh.shortValue();
            index++;
        }
        return result;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associate(Iterable<? extends T> iterable, Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) function1.invoke((Object) it.next());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K> Map<K, T> associateBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element$iv = (Object) it.next();
            linkedHashMap.put(function1.invoke(element$iv), element$iv);
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associateBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1, Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element$iv = (Object) it.next();
            linkedHashMap.put(function1.invoke(element$iv), function12.invoke(element$iv));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(Iterable<? extends T> iterable, M m, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            m.put(function1.invoke(element), element);
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(Iterable<? extends T> iterable, M m, Function1<? super T, ? extends K> function1, Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            m.put(function1.invoke(element), function12.invoke(element));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(Iterable<? extends T> iterable, M m, Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) function1.invoke((Object) it.next());
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateWith(Iterable<? extends K> iterable, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        LinkedHashMap result = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends K> it = iterable.iterator();
        while (it.hasNext()) {
            Object element$iv = (Object) it.next();
            result.put(element$iv, function1.invoke(element$iv));
        }
        return result;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(Iterable<? extends K> iterable, M m, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        Iterator<? extends K> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            m.put(element, function1.invoke(element));
        }
        return m;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C c) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> HashSet<T> toHashSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (HashSet) CollectionsKt.toCollection(iterable, new HashSet(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 12))));
    }

    public static final <T> List<T> toList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return CollectionsKt.optimizeReadOnlyList(CollectionsKt.toMutableList(iterable));
        }
        switch (((Collection) iterable).size()) {
            case 0:
                return CollectionsKt.emptyList();
            case 1:
                return CollectionsKt.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            default:
                return CollectionsKt.toMutableList((Collection) iterable);
        }
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return CollectionsKt.toMutableList((Collection) iterable);
        }
        return (List) CollectionsKt.toCollection(iterable, new ArrayList());
    }

    public static final <T> List<T> toMutableList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final <T> Set<T> toSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return SetsKt.optimizeReadOnlySet((Set) CollectionsKt.toCollection(iterable, new LinkedHashSet()));
        }
        switch (((Collection) iterable).size()) {
            case 0:
                return SetsKt.emptySet();
            case 1:
                return SetsKt.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            default:
                return (Set) CollectionsKt.toCollection(iterable, new LinkedHashSet(MapsKt.mapCapacity(((Collection) iterable).size())));
        }
    }

    public static final <T, R> List<R> flatMap(Iterable<? extends T> iterable, Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(destination$iv, (Iterable) function1.invoke((Object) it.next()));
        }
        return (List) destination$iv;
    }

    public static final <T, R> List<R> flatMapSequence(Iterable<? extends T> iterable, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(destination$iv, (Sequence) function1.invoke((Object) it.next()));
        }
        return (List) destination$iv;
    }

    private static final <T, R> List<R> flatMapIndexedIterable(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt.addAll(arrayList, (Iterable) function2.invoke(Integer.valueOf(i), obj));
            i = i2;
        }
        return arrayList;
    }

    private static final <T, R> List<R> flatMapIndexedSequence(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt.addAll(arrayList, (Sequence) function2.invoke(Integer.valueOf(i), obj));
            i = i2;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(Iterable<? extends T> iterable, C c, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int index = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            int index2 = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt.addAll(c, (Iterable) function2.invoke(Integer.valueOf(index), element));
            index = index2;
        }
        return c;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(Iterable<? extends T> iterable, C c, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int index = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            int index2 = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt.addAll(c, (Sequence) function2.invoke(Integer.valueOf(index), element));
            index = index2;
        }
        return c;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(Iterable<? extends T> iterable, C c, Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(c, (Iterable) function1.invoke((Object) it.next()));
        }
        return c;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(Iterable<? extends T> iterable, C c, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(c, (Sequence) function1.invoke((Object) it.next()));
        }
        return c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Multiple debug info for r10v4 java.lang.Object: [D('answer$iv$iv' java.lang.Object), D('$i$a$-getOrPut-CollectionsKt___CollectionsKt$groupByTo$list$1$iv' int)] */
    public static final <T, K> Map<K, List<T>> groupBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1) {
        ArrayList answer$iv$iv;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element$iv = (Object) it.next();
            Object key$iv = function1.invoke(element$iv);
            Object value$iv$iv = linkedHashMap.get(key$iv);
            if (value$iv$iv == null) {
                answer$iv$iv = new ArrayList();
                linkedHashMap.put(key$iv, answer$iv$iv);
            } else {
                answer$iv$iv = value$iv$iv;
            }
            ((List) answer$iv$iv).add(element$iv);
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Multiple debug info for r10v4 java.lang.Object: [D('$i$a$-getOrPut-CollectionsKt___CollectionsKt$groupByTo$list$2$iv' int), D('answer$iv$iv' java.lang.Object)] */
    public static final <T, K, V> Map<K, List<V>> groupBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1, Function1<? super T, ? extends V> function12) {
        ArrayList answer$iv$iv;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element$iv = (Object) it.next();
            Object key$iv = function1.invoke(element$iv);
            Object value$iv$iv = linkedHashMap.get(key$iv);
            if (value$iv$iv == null) {
                answer$iv$iv = new ArrayList();
                linkedHashMap.put(key$iv, answer$iv$iv);
            } else {
                answer$iv$iv = value$iv$iv;
            }
            ((List) answer$iv$iv).add(function12.invoke(element$iv));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: M extends java.util.Map<? super K, java.util.List<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Multiple debug info for r7v4 java.lang.Object: [D('$i$a$-getOrPut-CollectionsKt___CollectionsKt$groupByTo$list$1' int), D('answer$iv' java.lang.Object)] */
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(Iterable<? extends T> iterable, M m, Function1<? super T, ? extends K> function1) {
        ArrayList answer$iv;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            Object key = function1.invoke(element);
            Object value$iv = m.get(key);
            if (value$iv == null) {
                answer$iv = new ArrayList();
                m.put(key, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            ((List) answer$iv).add(element);
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: M extends java.util.Map<? super K, java.util.List<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Multiple debug info for r7v4 java.lang.Object: [D('$i$a$-getOrPut-CollectionsKt___CollectionsKt$groupByTo$list$2' int), D('answer$iv' java.lang.Object)] */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(Iterable<? extends T> iterable, M m, Function1<? super T, ? extends K> function1, Function1<? super T, ? extends V> function12) {
        ArrayList answer$iv;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            Object key = function1.invoke(element);
            Object value$iv = m.get(key);
            if (value$iv == null) {
                answer$iv = new ArrayList();
                m.put(key, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            ((List) answer$iv).add(function12.invoke(element));
        }
        return m;
    }

    public static final <T, K> Grouping<T, K> groupingBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        return new CollectionsKt___CollectionsKt$groupingBy$1(iterable, function1);
    }

    public static final <T, R> List<R> map(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination$iv.add(function1.invoke((Object) it.next()));
        }
        return (List) destination$iv;
    }

    public static final <T, R> List<R> mapIndexed(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Collection destination$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        int index$iv = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item$iv = (Object) it.next();
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            destination$iv.add(function2.invoke(Integer.valueOf(index$iv), item$iv));
            index$iv = index$iv2;
        }
        return (List) destination$iv;
    }

    /* JADX INFO: Multiple debug info for r6v1 'index$iv$iv'  int: [D('index$iv' int), D('index$iv$iv' int)] */
    public static final <T, R> List<R> mapIndexedNotNull(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Collection destination$iv = new ArrayList();
        int index$iv = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item$iv$iv = (Object) it.next();
            int index$iv$iv = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object it$iv = function2.invoke(Integer.valueOf(index$iv), item$iv$iv);
            if (it$iv != null) {
                destination$iv.add(it$iv);
            }
            index$iv = index$iv$iv;
        }
        return (List) destination$iv;
    }

    /* JADX INFO: Multiple debug info for r3v1 'index$iv'  int: [D('index' int), D('index$iv' int)] */
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(Iterable<? extends T> iterable, C c, Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int index = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item$iv = (Object) it.next();
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object it2 = function2.invoke(Integer.valueOf(index), item$iv);
            if (it2 != null) {
                c.add(it2);
            }
            index = index$iv;
        }
        return c;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(Iterable<? extends T> iterable, C c, Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int index = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item = (Object) it.next();
            int index2 = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            c.add(function2.invoke(Integer.valueOf(index), item));
            index = index2;
        }
        return c;
    }

    public static final <T, R> List<R> mapNotNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object it$iv = function1.invoke((Object) it.next());
            if (it$iv != null) {
                destination$iv.add(it$iv);
            }
        }
        return (List) destination$iv;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(Iterable<? extends T> iterable, C c, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object it2 = function1.invoke((Object) it.next());
            if (it2 != null) {
                c.add(it2);
            }
        }
        return c;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(Iterable<? extends T> iterable, C c, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(function1.invoke((Object) it.next()));
        }
        return c;
    }

    public static final <T> Iterable<IndexedValue<T>> withIndex(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new IndexingIterable(new CollectionsKt___CollectionsKt$withIndex$1(iterable));
    }

    public static final <T> List<T> distinct(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.toList(CollectionsKt.toMutableSet(iterable));
    }

    public static final <T, K> List<T> distinctBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet set = new HashSet();
        ArrayList list = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object e = (Object) it.next();
            if (set.add(function1.invoke(e))) {
                list.add(e);
            }
        }
        return list;
    }

    public static final <T> Set<T> intersect(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(iterable2, PluralRules.KEYWORD_OTHER);
        Set set = CollectionsKt.toMutableSet(iterable);
        CollectionsKt.retainAll(set, iterable2);
        return set;
    }

    public static final <T> Set<T> subtract(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(iterable2, PluralRules.KEYWORD_OTHER);
        Set set = CollectionsKt.toMutableSet(iterable);
        CollectionsKt.removeAll(set, iterable2);
        return set;
    }

    public static final <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) CollectionsKt.toCollection(iterable, new LinkedHashSet());
    }

    public static final <T> Set<T> union(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(iterable2, PluralRules.KEYWORD_OTHER);
        Set set = CollectionsKt.toMutableSet(iterable);
        CollectionsKt.addAll(set, iterable2);
        return set;
    }

    public static final <T> boolean all(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!function1.invoke((Object) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return !((Collection) iterable).isEmpty();
        }
        return iterable.iterator().hasNext();
    }

    public static final <T> boolean any(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T> int count(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        int count = 0;
        for (Object obj : iterable) {
            count++;
            if (count < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return count;
    }

    private static final <T> int count(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return collection.size();
    }

    public static final <T> int count(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        int count = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue() && (count = count + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return count;
    }

    public static final <T, R> R fold(Iterable<? extends T> iterable, R r, Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Object accumulator = r;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            accumulator = (R) function2.invoke(accumulator, (Object) it.next());
        }
        return (R) accumulator;
    }

    public static final <T, R> R foldIndexed(Iterable<? extends T> iterable, R r, Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int index = 0;
        Object accumulator = r;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            int index2 = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            accumulator = (R) function3.invoke(Integer.valueOf(index), accumulator, element);
            index = index2;
        }
        return (R) accumulator;
    }

    public static final <T, R> R foldRight(List<? extends T> list, R r, Function2<? super T, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        R accumulator = r;
        if (!list.isEmpty()) {
            ListIterator iterator = list.listIterator(list.size());
            while (iterator.hasPrevious()) {
                accumulator = (Object) function2.invoke((Object) iterator.previous(), accumulator);
            }
        }
        return (R) accumulator;
    }

    public static final <T, R> R foldRightIndexed(List<? extends T> list, R r, Function3<? super Integer, ? super T, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        R accumulator = r;
        if (!list.isEmpty()) {
            ListIterator iterator = list.listIterator(list.size());
            while (iterator.hasPrevious()) {
                accumulator = (Object) function3.invoke(Integer.valueOf(iterator.previousIndex()), (Object) iterator.previous(), accumulator);
            }
        }
        return (R) accumulator;
    }

    public static final <T> void forEach(Iterable<? extends T> iterable, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            function1.invoke((Object) it.next());
        }
    }

    public static final <T> void forEachIndexed(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        int index = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object item = (Object) it.next();
            int index2 = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            function2.invoke(Integer.valueOf(index), item);
            index = index2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Comparable] */
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator$iv = iterable.iterator();
        if (!iterator$iv.hasNext()) {
            return null;
        }
        T t = (T) iterator$iv.next();
        if (!iterator$iv.hasNext()) {
            return t;
        }
        Comparable maxValue$iv = (Comparable) function1.invoke(t);
        do {
            Object maxElem$iv = (Object) iterator$iv.next();
            Comparable v$iv = (Comparable) function1.invoke(maxElem$iv);
            int compareTo = maxValue$iv.compareTo(v$iv);
            Comparable maxValue$iv2 = maxValue$iv;
            if (compareTo < 0) {
                t = (T) maxElem$iv;
                maxValue$iv2 = v$iv;
            }
            maxValue$iv = maxValue$iv2;
        } while (iterator$iv.hasNext());
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Comparable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R extends java.lang.Comparable<? super R>> T maxByOrNull(java.lang.Iterable<? extends T> r7, kotlin.jvm.functions.Function1<? super T, ? extends R> r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            java.util.Iterator r1 = r7.iterator()
            boolean r2 = r1.hasNext()
            if (r2 != 0) goto L_0x0018
            r2 = 0
            return r2
        L_0x0018:
            java.lang.Object r2 = r1.next()
            boolean r3 = r1.hasNext()
            if (r3 != 0) goto L_0x0023
            return r2
        L_0x0023:
            java.lang.Object r3 = r8.invoke(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
        L_0x0029:
            java.lang.Object r4 = r1.next()
            java.lang.Object r5 = r8.invoke(r4)
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            int r6 = r3.compareTo(r5)
            if (r6 >= 0) goto L_0x003b
            r2 = r4
            r3 = r5
        L_0x003b:
            boolean r6 = r1.hasNext()
            if (r6 != 0) goto L_0x0029
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.maxByOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    private static final <T> double maxOf(Iterable<? extends T> iterable, Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            double maxValue = function1.invoke((Object) iterator.next()).doubleValue();
            while (iterator.hasNext()) {
                maxValue = Math.max(maxValue, function1.invoke((Object) iterator.next()).doubleValue());
            }
            return maxValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOf */
    private static final <T> float m432maxOf(Iterable<? extends T> iterable, Function1<? super T, Float> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            float maxValue = function1.invoke((Object) iterator.next()).floatValue();
            while (iterator.hasNext()) {
                maxValue = Math.max(maxValue, function1.invoke((Object) iterator.next()).floatValue());
            }
            return maxValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Comparable] */
    /* renamed from: maxOf */
    private static final <T, R extends Comparable<? super R>> R m433maxOf(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            Comparable maxValue = (R) ((Comparable) function1.invoke((Object) iterator.next()));
            while (iterator.hasNext()) {
                Comparable v = (Comparable) function1.invoke((Object) iterator.next());
                if (maxValue.compareTo(v) < 0) {
                    maxValue = (R) v;
                }
            }
            return (R) maxValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOfOrNull */
    private static final <T> Double m434maxOfOrNull(Iterable<? extends T> iterable, Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        double maxValue = function1.invoke((Object) iterator.next()).doubleValue();
        while (iterator.hasNext()) {
            maxValue = Math.max(maxValue, function1.invoke((Object) iterator.next()).doubleValue());
        }
        return Double.valueOf(maxValue);
    }

    /* renamed from: maxOfOrNull */
    private static final <T> Float m435maxOfOrNull(Iterable<? extends T> iterable, Function1<? super T, Float> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        float maxValue = function1.invoke((Object) iterator.next()).floatValue();
        while (iterator.hasNext()) {
            maxValue = Math.max(maxValue, function1.invoke((Object) iterator.next()).floatValue());
        }
        return Float.valueOf(maxValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Comparable] */
    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Comparable maxValue = (R) ((Comparable) function1.invoke((Object) iterator.next()));
        while (iterator.hasNext()) {
            Comparable v = (Comparable) function1.invoke((Object) iterator.next());
            if (maxValue.compareTo(v) < 0) {
                maxValue = (R) v;
            }
        }
        return (R) maxValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    private static final <T, R> R maxOfWith(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            Object maxValue = (R) function1.invoke((Object) iterator.next());
            while (iterator.hasNext()) {
                Object v = (Object) function1.invoke((Object) iterator.next());
                if (comparator.compare(maxValue, v) < 0) {
                    maxValue = (R) v;
                }
            }
            return (R) maxValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    private static final <T, R> R maxOfWithOrNull(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Object maxValue = (R) function1.invoke((Object) iterator.next());
        while (iterator.hasNext()) {
            Object v = (Object) function1.invoke((Object) iterator.next());
            if (comparator.compare(maxValue, v) < 0) {
                maxValue = (R) v;
            }
        }
        return (R) maxValue;
    }

    /* renamed from: maxOrNull */
    public static final Double m436maxOrNull(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        double max = iterator.next().doubleValue();
        while (iterator.hasNext()) {
            max = Math.max(max, iterator.next().doubleValue());
        }
        return Double.valueOf(max);
    }

    /* renamed from: maxOrNull */
    public static final Float m437maxOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        float max = iterator.next().floatValue();
        while (iterator.hasNext()) {
            max = Math.max(max, iterator.next().floatValue());
        }
        return Float.valueOf(max);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Comparable max = (T) ((Comparable) iterator.next());
        while (iterator.hasNext()) {
            Comparable e = (Comparable) iterator.next();
            if (max.compareTo(e) < 0) {
                max = (T) e;
            }
        }
        return (T) max;
    }

    public static final /* synthetic */ Object maxWith(Iterable $this$maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt.maxWithOrNull($this$maxWith, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T maxWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Object max = (T) iterator.next();
        while (iterator.hasNext()) {
            Object e = (Object) iterator.next();
            if (comparator.compare(max, e) < 0) {
                max = (T) e;
            }
        }
        return (T) max;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Comparable] */
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator$iv = iterable.iterator();
        if (!iterator$iv.hasNext()) {
            return null;
        }
        T t = (T) iterator$iv.next();
        if (!iterator$iv.hasNext()) {
            return t;
        }
        Comparable minValue$iv = (Comparable) function1.invoke(t);
        do {
            Object minElem$iv = (Object) iterator$iv.next();
            Comparable v$iv = (Comparable) function1.invoke(minElem$iv);
            int compareTo = minValue$iv.compareTo(v$iv);
            Comparable minValue$iv2 = minValue$iv;
            if (compareTo > 0) {
                t = (T) minElem$iv;
                minValue$iv2 = v$iv;
            }
            minValue$iv = minValue$iv2;
        } while (iterator$iv.hasNext());
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Comparable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R extends java.lang.Comparable<? super R>> T minByOrNull(java.lang.Iterable<? extends T> r7, kotlin.jvm.functions.Function1<? super T, ? extends R> r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            java.util.Iterator r1 = r7.iterator()
            boolean r2 = r1.hasNext()
            if (r2 != 0) goto L_0x0018
            r2 = 0
            return r2
        L_0x0018:
            java.lang.Object r2 = r1.next()
            boolean r3 = r1.hasNext()
            if (r3 != 0) goto L_0x0023
            return r2
        L_0x0023:
            java.lang.Object r3 = r8.invoke(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
        L_0x0029:
            java.lang.Object r4 = r1.next()
            java.lang.Object r5 = r8.invoke(r4)
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            int r6 = r3.compareTo(r5)
            if (r6 <= 0) goto L_0x003b
            r2 = r4
            r3 = r5
        L_0x003b:
            boolean r6 = r1.hasNext()
            if (r6 != 0) goto L_0x0029
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.minByOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    private static final <T> double minOf(Iterable<? extends T> iterable, Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            double minValue = function1.invoke((Object) iterator.next()).doubleValue();
            while (iterator.hasNext()) {
                minValue = Math.min(minValue, function1.invoke((Object) iterator.next()).doubleValue());
            }
            return minValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOf */
    private static final <T> float m438minOf(Iterable<? extends T> iterable, Function1<? super T, Float> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            float minValue = function1.invoke((Object) iterator.next()).floatValue();
            while (iterator.hasNext()) {
                minValue = Math.min(minValue, function1.invoke((Object) iterator.next()).floatValue());
            }
            return minValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Comparable] */
    /* renamed from: minOf */
    private static final <T, R extends Comparable<? super R>> R m439minOf(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            Comparable minValue = (R) ((Comparable) function1.invoke((Object) iterator.next()));
            while (iterator.hasNext()) {
                Comparable v = (Comparable) function1.invoke((Object) iterator.next());
                if (minValue.compareTo(v) > 0) {
                    minValue = (R) v;
                }
            }
            return (R) minValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOfOrNull */
    private static final <T> Double m440minOfOrNull(Iterable<? extends T> iterable, Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        double minValue = function1.invoke((Object) iterator.next()).doubleValue();
        while (iterator.hasNext()) {
            minValue = Math.min(minValue, function1.invoke((Object) iterator.next()).doubleValue());
        }
        return Double.valueOf(minValue);
    }

    /* renamed from: minOfOrNull */
    private static final <T> Float m441minOfOrNull(Iterable<? extends T> iterable, Function1<? super T, Float> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        float minValue = function1.invoke((Object) iterator.next()).floatValue();
        while (iterator.hasNext()) {
            minValue = Math.min(minValue, function1.invoke((Object) iterator.next()).floatValue());
        }
        return Float.valueOf(minValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Comparable] */
    private static final <T, R extends Comparable<? super R>> R minOfOrNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Comparable minValue = (R) ((Comparable) function1.invoke((Object) iterator.next()));
        while (iterator.hasNext()) {
            Comparable v = (Comparable) function1.invoke((Object) iterator.next());
            if (minValue.compareTo(v) > 0) {
                minValue = (R) v;
            }
        }
        return (R) minValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    private static final <T, R> R minOfWith(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            Object minValue = (R) function1.invoke((Object) iterator.next());
            while (iterator.hasNext()) {
                Object v = (Object) function1.invoke((Object) iterator.next());
                if (comparator.compare(minValue, v) > 0) {
                    minValue = (R) v;
                }
            }
            return (R) minValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    private static final <T, R> R minOfWithOrNull(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Object minValue = (R) function1.invoke((Object) iterator.next());
        while (iterator.hasNext()) {
            Object v = (Object) function1.invoke((Object) iterator.next());
            if (comparator.compare(minValue, v) > 0) {
                minValue = (R) v;
            }
        }
        return (R) minValue;
    }

    /* renamed from: minOrNull */
    public static final Double m442minOrNull(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        double min = iterator.next().doubleValue();
        while (iterator.hasNext()) {
            min = Math.min(min, iterator.next().doubleValue());
        }
        return Double.valueOf(min);
    }

    /* renamed from: minOrNull */
    public static final Float m443minOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        float min = iterator.next().floatValue();
        while (iterator.hasNext()) {
            min = Math.min(min, iterator.next().floatValue());
        }
        return Float.valueOf(min);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Comparable min = (T) ((Comparable) iterator.next());
        while (iterator.hasNext()) {
            Comparable e = (Comparable) iterator.next();
            if (min.compareTo(e) > 0) {
                min = (T) e;
            }
        }
        return (T) min;
    }

    public static final /* synthetic */ Object minWith(Iterable $this$minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt.minWithOrNull($this$minWith, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T minWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Object min = (T) iterator.next();
        while (iterator.hasNext()) {
            Object e = (Object) iterator.next();
            if (comparator.compare(min, e) > 0) {
                min = (T) e;
            }
        }
        return (T) min;
    }

    public static final <T> boolean none(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static final <T> boolean none(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T, C extends Iterable<? extends T>> C onEach(C c, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(c, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (Object element : c) {
            function1.invoke(element);
        }
        return c;
    }

    public static final <T, C extends Iterable<? extends T>> C onEachIndexed(C c, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(c, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        int index$iv = 0;
        for (Object item$iv : c) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            function2.invoke(Integer.valueOf(index$iv), item$iv);
            index$iv = index$iv2;
        }
        return c;
    }

    public static final <S, T extends S> S reduce(Iterable<? extends T> iterable, Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            Object accumulator = (S) iterator.next();
            while (iterator.hasNext()) {
                accumulator = (S) function2.invoke(accumulator, (Object) iterator.next());
            }
            return (S) accumulator;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(Iterable<? extends T> iterable, Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            int index = 1;
            Object accumulator = (S) iterator.next();
            while (iterator.hasNext()) {
                int index2 = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                accumulator = (S) function3.invoke(Integer.valueOf(index), accumulator, (Object) iterator.next());
                index = index2;
            }
            return (S) accumulator;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexedOrNull(Iterable<? extends T> iterable, Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        int index = 1;
        Object accumulator = (S) iterator.next();
        while (iterator.hasNext()) {
            int index2 = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            accumulator = (S) function3.invoke(Integer.valueOf(index), accumulator, (Object) iterator.next());
            index = index2;
        }
        return (S) accumulator;
    }

    public static final <S, T extends S> S reduceOrNull(Iterable<? extends T> iterable, Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Object accumulator = (S) iterator.next();
        while (iterator.hasNext()) {
            accumulator = (S) function2.invoke(accumulator, (Object) iterator.next());
        }
        return (S) accumulator;
    }

    public static final <S, T extends S> S reduceRight(List<? extends T> list, Function2<? super T, ? super S, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        ListIterator iterator = list.listIterator(list.size());
        if (iterator.hasPrevious()) {
            Object accumulator = (S) iterator.previous();
            while (iterator.hasPrevious()) {
                accumulator = (S) function2.invoke((Object) iterator.previous(), accumulator);
            }
            return (S) accumulator;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    public static final <S, T extends S> S reduceRightIndexed(List<? extends T> list, Function3<? super Integer, ? super T, ? super S, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        ListIterator iterator = list.listIterator(list.size());
        if (iterator.hasPrevious()) {
            Object accumulator = (S) iterator.previous();
            while (iterator.hasPrevious()) {
                accumulator = (S) function3.invoke(Integer.valueOf(iterator.previousIndex()), (Object) iterator.previous(), accumulator);
            }
            return (S) accumulator;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    public static final <S, T extends S> S reduceRightIndexedOrNull(List<? extends T> list, Function3<? super Integer, ? super T, ? super S, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        ListIterator iterator = list.listIterator(list.size());
        if (!iterator.hasPrevious()) {
            return null;
        }
        Object accumulator = (S) iterator.previous();
        while (iterator.hasPrevious()) {
            accumulator = (S) function3.invoke(Integer.valueOf(iterator.previousIndex()), (Object) iterator.previous(), accumulator);
        }
        return (S) accumulator;
    }

    public static final <S, T extends S> S reduceRightOrNull(List<? extends T> list, Function2<? super T, ? super S, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        ListIterator iterator = list.listIterator(list.size());
        if (!iterator.hasPrevious()) {
            return null;
        }
        Object accumulator = (S) iterator.previous();
        while (iterator.hasPrevious()) {
            accumulator = (S) function2.invoke((Object) iterator.previous(), accumulator);
        }
        return (S) accumulator;
    }

    /* JADX INFO: Multiple debug info for r2v0 java.util.ArrayList: [D('result' java.util.ArrayList), D('$this$runningFold_u24lambda_u2d18' java.util.ArrayList)] */
    public static final <T, R> List<R> runningFold(Iterable<? extends T> iterable, R $this$runningFold_u24lambda_u2d18, Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int estimatedSize = CollectionsKt.collectionSizeOrDefault(iterable, 9);
        if (estimatedSize == 0) {
            return CollectionsKt.listOf($this$runningFold_u24lambda_u2d18);
        }
        ArrayList $this$runningFold_u24lambda_u2d182 = new ArrayList(estimatedSize + 1);
        $this$runningFold_u24lambda_u2d182.add($this$runningFold_u24lambda_u2d18);
        ArrayList accumulator = $this$runningFold_u24lambda_u2d18;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            accumulator = (Object) function2.invoke(accumulator, (Object) it.next());
            $this$runningFold_u24lambda_u2d182.add(accumulator);
        }
        return $this$runningFold_u24lambda_u2d182;
    }

    /* JADX INFO: Multiple debug info for r2v0 java.util.ArrayList: [D('result' java.util.ArrayList), D('$this$runningFoldIndexed_u24lambda_u2d19' java.util.ArrayList)] */
    public static final <T, R> List<R> runningFoldIndexed(Iterable<? extends T> iterable, R r, Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int estimatedSize = CollectionsKt.collectionSizeOrDefault(iterable, 9);
        if (estimatedSize == 0) {
            return CollectionsKt.listOf(r);
        }
        ArrayList $this$runningFoldIndexed_u24lambda_u2d19 = new ArrayList(estimatedSize + 1);
        $this$runningFoldIndexed_u24lambda_u2d19.add(r);
        int index = 0;
        R accumulator = r;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            int index2 = index + 1;
            accumulator = (Object) function3.invoke(Integer.valueOf(index), accumulator, (Object) it.next());
            $this$runningFoldIndexed_u24lambda_u2d19.add(accumulator);
            index = index2;
        }
        return $this$runningFoldIndexed_u24lambda_u2d19;
    }

    /* JADX INFO: Multiple debug info for r3v0 java.util.ArrayList: [D('result' java.util.ArrayList), D('$this$runningReduce_u24lambda_u2d20' java.util.ArrayList)] */
    public static final <S, T extends S> List<S> runningReduce(Iterable<? extends T> iterable, Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return CollectionsKt.emptyList();
        }
        Object accumulator = (Object) iterator.next();
        ArrayList $this$runningReduce_u24lambda_u2d20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        $this$runningReduce_u24lambda_u2d20.add(accumulator);
        while (iterator.hasNext()) {
            accumulator = (Object) function2.invoke(accumulator, (Object) iterator.next());
            $this$runningReduce_u24lambda_u2d20.add(accumulator);
        }
        return $this$runningReduce_u24lambda_u2d20;
    }

    /* JADX INFO: Multiple debug info for r3v0 java.util.ArrayList: [D('result' java.util.ArrayList), D('$this$runningReduceIndexed_u24lambda_u2d21' java.util.ArrayList)] */
    public static final <S, T extends S> List<S> runningReduceIndexed(Iterable<? extends T> iterable, Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return CollectionsKt.emptyList();
        }
        Object accumulator = (Object) iterator.next();
        ArrayList $this$runningReduceIndexed_u24lambda_u2d21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        $this$runningReduceIndexed_u24lambda_u2d21.add(accumulator);
        int index = 1;
        while (iterator.hasNext()) {
            accumulator = (Object) function3.invoke(Integer.valueOf(index), accumulator, (Object) iterator.next());
            $this$runningReduceIndexed_u24lambda_u2d21.add(accumulator);
            index++;
        }
        return $this$runningReduceIndexed_u24lambda_u2d21;
    }

    /* JADX INFO: Multiple debug info for r4v0 java.util.ArrayList: [D('$this$runningFold_u24lambda_u2d18$iv' java.util.ArrayList), D('result$iv' java.util.ArrayList)] */
    public static final <T, R> List<R> scan(Iterable<? extends T> iterable, R $this$runningFold_u24lambda_u2d18$iv, Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int estimatedSize$iv = CollectionsKt.collectionSizeOrDefault(iterable, 9);
        if (estimatedSize$iv == 0) {
            return CollectionsKt.listOf($this$runningFold_u24lambda_u2d18$iv);
        }
        ArrayList result$iv = new ArrayList(estimatedSize$iv + 1);
        result$iv.add($this$runningFold_u24lambda_u2d18$iv);
        ArrayList accumulator$iv = $this$runningFold_u24lambda_u2d18$iv;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            accumulator$iv = (Object) function2.invoke(accumulator$iv, (Object) it.next());
            result$iv.add(accumulator$iv);
        }
        return result$iv;
    }

    /* JADX INFO: Multiple debug info for r4v0 java.util.ArrayList: [D('$this$runningFoldIndexed_u24lambda_u2d19$iv' java.util.ArrayList), D('result$iv' java.util.ArrayList)] */
    public static final <T, R> List<R> scanIndexed(Iterable<? extends T> iterable, R r, Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int estimatedSize$iv = CollectionsKt.collectionSizeOrDefault(iterable, 9);
        if (estimatedSize$iv == 0) {
            return CollectionsKt.listOf(r);
        }
        ArrayList result$iv = new ArrayList(estimatedSize$iv + 1);
        result$iv.add(r);
        int index$iv = 0;
        R accumulator$iv = r;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            int index$iv2 = index$iv + 1;
            accumulator$iv = (Object) function3.invoke(Integer.valueOf(index$iv), accumulator$iv, (Object) it.next());
            result$iv.add(accumulator$iv);
            index$iv = index$iv2;
        }
        return result$iv;
    }

    public static final <T> int sumBy(Iterable<? extends T> iterable, Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int sum = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            sum += function1.invoke((Object) it.next()).intValue();
        }
        return sum;
    }

    public static final <T> double sumByDouble(Iterable<? extends T> iterable, Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double sum = 0.0d;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            sum += function1.invoke((Object) it.next()).doubleValue();
        }
        return sum;
    }

    private static final <T> double sumOfDouble(Iterable<? extends T> iterable, Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double sum = 0.0d;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            sum += function1.invoke((Object) it.next()).doubleValue();
        }
        return sum;
    }

    private static final <T> int sumOfInt(Iterable<? extends T> iterable, Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int sum = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            sum += function1.invoke((Object) it.next()).intValue();
        }
        return sum;
    }

    private static final <T> long sumOfLong(Iterable<? extends T> iterable, Function1<? super T, Long> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        long sum = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            sum += function1.invoke((Object) it.next()).longValue();
        }
        return sum;
    }

    private static final <T> int sumOfUInt(Iterable<? extends T> iterable, Function1<? super T, UInt> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int sum = UInt.m103constructorimpl(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            sum = UInt.m103constructorimpl(function1.invoke((Object) it.next()).m154unboximpl() + sum);
        }
        return sum;
    }

    private static final <T> long sumOfULong(Iterable<? extends T> iterable, Function1<? super T, ULong> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        long sum = ULong.m181constructorimpl(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            sum = ULong.m181constructorimpl(function1.invoke((Object) it.next()).m232unboximpl() + sum);
        }
        return sum;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Iterable<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Iterable<T> requireNoNulls(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + '.');
            }
        }
        return iterable;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> requireNoNulls(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + '.');
            }
        }
        return list;
    }

    public static final <T> List<List<T>> chunked(Iterable<? extends T> iterable, int size) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.windowed(iterable, size, size, true);
    }

    public static final <T, R> List<R> chunked(Iterable<? extends T> iterable, int size, Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return CollectionsKt.windowed(iterable, size, size, true, function1);
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, T t) {
        boolean z;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterable result = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        boolean removed = false;
        for (Object element$iv : iterable) {
            if (removed || !Intrinsics.areEqual(element$iv, t)) {
                z = true;
            } else {
                removed = true;
                z = false;
            }
            if (z) {
                ((Collection) result).add(element$iv);
            }
        }
        return (List) ((Collection) result);
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, T[] tArr) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length == 0) {
            return CollectionsKt.toList(iterable);
        }
        Collection other = BrittleContainsOptimizationKt.convertToSetForSetOperation(tArr);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : iterable) {
            if (!other.contains(element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(iterable2, "elements");
        Collection other = BrittleContainsOptimizationKt.convertToSetForSetOperationWith(iterable2, iterable);
        if (other.isEmpty()) {
            return CollectionsKt.toList(iterable);
        }
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : iterable) {
            if (!other.contains(element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        Collection other = BrittleContainsOptimizationKt.convertToSetForSetOperation(sequence);
        if (other.isEmpty()) {
            return CollectionsKt.toList(iterable);
        }
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : iterable) {
            if (!other.contains(element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    private static final <T> List<T> minusElement(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.minus((Iterable) iterable, (Object) t);
    }

    public static final <T> Pair<List<T>, List<T>> partition(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList first = new ArrayList();
        ArrayList second = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            if (function1.invoke(element).booleanValue()) {
                first.add(element);
            } else {
                second.add(element);
            }
        }
        return new Pair<>(first, second);
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return CollectionsKt.plus((Collection) iterable, (Object) t);
        }
        ArrayList result = new ArrayList();
        CollectionsKt.addAll(result, iterable);
        result.add(t);
        return result;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList result = new ArrayList(collection.size() + 1);
        result.addAll(collection);
        result.add(t);
        return result;
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, T[] tArr) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (iterable instanceof Collection) {
            return CollectionsKt.plus((Collection) iterable, (Object[]) tArr);
        }
        ArrayList result = new ArrayList();
        CollectionsKt.addAll(result, iterable);
        CollectionsKt.addAll(result, tArr);
        return result;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        ArrayList result = new ArrayList(collection.size() + tArr.length);
        result.addAll(collection);
        CollectionsKt.addAll(result, tArr);
        return result;
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(iterable2, "elements");
        if (iterable instanceof Collection) {
            return CollectionsKt.plus((Collection) iterable, (Iterable) iterable2);
        }
        ArrayList result = new ArrayList();
        CollectionsKt.addAll(result, iterable);
        CollectionsKt.addAll(result, iterable2);
        return result;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            ArrayList result = new ArrayList(collection.size() + ((Collection) iterable).size());
            result.addAll(collection);
            result.addAll((Collection) iterable);
            return result;
        }
        ArrayList result2 = new ArrayList(collection);
        CollectionsKt.addAll(result2, iterable);
        return result2;
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        ArrayList result = new ArrayList();
        CollectionsKt.addAll(result, iterable);
        CollectionsKt.addAll(result, sequence);
        return result;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        ArrayList result = new ArrayList(collection.size() + 10);
        result.addAll(collection);
        CollectionsKt.addAll(result, sequence);
        return result;
    }

    private static final <T> List<T> plusElement(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.plus((Iterable) iterable, (Object) t);
    }

    private static final <T> List<T> plusElement(Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return CollectionsKt.plus((Collection) collection, (Object) t);
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return CollectionsKt.windowed(iterable, i, i2, z);
    }

    public static final <T> List<List<T>> windowed(Iterable<? extends T> iterable, int size, int step, boolean partialWindows) {
        int windowSize;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        SlidingWindowKt.checkWindowSizeStep(size, step);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList result = new ArrayList();
            Iterator $this$forEach$iv = SlidingWindowKt.windowedIterator(iterable.iterator(), size, step, partialWindows, false);
            while ($this$forEach$iv.hasNext()) {
                result.add((List) $this$forEach$iv.next());
            }
            return result;
        }
        int thisSize = ((List) iterable).size();
        ArrayList result2 = new ArrayList((thisSize / step) + (thisSize % step == 0 ? 0 : 1));
        int index = 0;
        while (true) {
            if ((index >= 0 && index < thisSize) && ((windowSize = RangesKt.coerceAtMost(size, thisSize - index)) >= size || partialWindows)) {
                ArrayList arrayList = new ArrayList(windowSize);
                for (int it = 0; it < windowSize; it++) {
                    arrayList.add(((List) iterable).get(it + index));
                }
                result2.add(arrayList);
                index += step;
            }
        }
        return result2;
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return CollectionsKt.windowed(iterable, i, i2, z, function1);
    }

    public static final <T, R> List<R> windowed(Iterable<? extends T> iterable, int size, int step, boolean partialWindows, Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        SlidingWindowKt.checkWindowSizeStep(size, step);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList result = new ArrayList();
            Iterator $this$forEach$iv = SlidingWindowKt.windowedIterator(iterable.iterator(), size, step, partialWindows, true);
            while ($this$forEach$iv.hasNext()) {
                result.add(function1.invoke((List) $this$forEach$iv.next()));
            }
            return result;
        }
        int thisSize = ((List) iterable).size();
        ArrayList result2 = new ArrayList((thisSize / step) + (thisSize % step == 0 ? 0 : 1));
        MovingSubList window = new MovingSubList((List) iterable);
        int index = 0;
        while (true) {
            if (!(index >= 0 && index < thisSize)) {
                break;
            }
            int windowSize = RangesKt.coerceAtMost(size, thisSize - index);
            if (!partialWindows && windowSize < size) {
                break;
            }
            window.move(index, index + windowSize);
            result2.add(function1.invoke(window));
            index += step;
        }
        return result2;
    }

    /* JADX INFO: Multiple debug info for r4v5 R: [D('t2' java.lang.Object), D('i$iv' int)] */
    public static final <T, R> List<Pair<T, R>> zip(Iterable<? extends T> iterable, R[] rArr) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(rArr, PluralRules.KEYWORD_OTHER);
        int arraySize$iv = rArr.length;
        ArrayList list$iv = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(iterable, 10), arraySize$iv));
        int i$iv = 0;
        for (Object element$iv : iterable) {
            if (i$iv >= arraySize$iv) {
                break;
            }
            list$iv.add(TuplesKt.to(element$iv, rArr[i$iv]));
            i$iv++;
        }
        return list$iv;
    }

    public static final <T, R, V> List<V> zip(Iterable<? extends T> iterable, R[] rArr, Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(rArr, PluralRules.KEYWORD_OTHER);
        Intrinsics.checkNotNullParameter(function2, "transform");
        int arraySize = rArr.length;
        ArrayList list = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(iterable, 10), arraySize));
        int i = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object element = (Object) it.next();
            if (i >= arraySize) {
                break;
            }
            list.add(function2.invoke(element, rArr[i]));
            i++;
        }
        return list;
    }

    public static final <T, R> List<Pair<T, R>> zip(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(iterable2, PluralRules.KEYWORD_OTHER);
        Iterator first$iv = iterable.iterator();
        Iterator second$iv = iterable2.iterator();
        ArrayList list$iv = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(iterable, 10), CollectionsKt.collectionSizeOrDefault(iterable2, 10)));
        while (first$iv.hasNext() && second$iv.hasNext()) {
            list$iv.add(TuplesKt.to(first$iv.next(), second$iv.next()));
        }
        return list$iv;
    }

    public static final <T, R, V> List<V> zip(Iterable<? extends T> iterable, Iterable<? extends R> iterable2, Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(iterable2, PluralRules.KEYWORD_OTHER);
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator first = iterable.iterator();
        Iterator second = iterable2.iterator();
        ArrayList list = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(iterable, 10), CollectionsKt.collectionSizeOrDefault(iterable2, 10)));
        while (first.hasNext() && second.hasNext()) {
            list.add(function2.invoke((Object) first.next(), (Object) second.next()));
        }
        return list;
    }

    public static final <T> List<Pair<T, T>> zipWithNext(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator iterator$iv = iterable.iterator();
        if (!iterator$iv.hasNext()) {
            return CollectionsKt.emptyList();
        }
        List result$iv = new ArrayList();
        Object current$iv = iterator$iv.next();
        while (iterator$iv.hasNext()) {
            Object next$iv = iterator$iv.next();
            result$iv.add(TuplesKt.to(current$iv, next$iv));
            current$iv = next$iv;
        }
        return result$iv;
    }

    public static final <T, R> List<R> zipWithNext(Iterable<? extends T> iterable, Function2<? super T, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return CollectionsKt.emptyList();
        }
        List result = new ArrayList();
        Object current = (Object) iterator.next();
        while (iterator.hasNext()) {
            Object next = (Object) iterator.next();
            result.add(function2.invoke(current, next));
            current = (Object) next;
        }
        return result;
    }

    public static /* synthetic */ Appendable joinTo$default(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        return CollectionsKt.joinTo(iterable, appendable, (i2 & 2) != 0 ? ", " : charSequence, (i2 & 4) != 0 ? "" : charSequence2, (i2 & 8) != 0 ? "" : charSequence3, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> iterable, A a, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(a, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        a.append(prefix);
        int count = 0;
        for (Object element : iterable) {
            count++;
            if (count > 1) {
                a.append(separator);
            }
            if (limit >= 0 && count > limit) {
                break;
            }
            StringsKt.appendElement(a, element, function1);
        }
        if (limit >= 0 && count > limit) {
            a.append(truncated);
        }
        a.append(postfix);
        return a;
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return CollectionsKt.joinToString(iterable, charSequence, charSequence2, charSequence3, i, charSequence4, function1);
    }

    public static final <T> String joinToString(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) CollectionsKt.joinTo(iterable, new StringBuilder(), separator, prefix, postfix, limit, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Iterable<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Iterable<T> asIterable(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable;
    }

    public static final <T> Sequence<T> asSequence(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(iterable);
    }

    public static final double averageOfByte(Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        double sum = 0.0d;
        int count = 0;
        for (Byte b : iterable) {
            sum += (double) b.byteValue();
            count++;
            if (count < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (count == 0) {
            return Double.NaN;
        }
        return sum / ((double) count);
    }

    public static final double averageOfShort(Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        double sum = 0.0d;
        int count = 0;
        for (Short sh : iterable) {
            sum += (double) sh.shortValue();
            count++;
            if (count < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (count == 0) {
            return Double.NaN;
        }
        return sum / ((double) count);
    }

    public static final double averageOfInt(Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        double sum = 0.0d;
        int count = 0;
        for (Integer num : iterable) {
            sum += (double) num.intValue();
            count++;
            if (count < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (count == 0) {
            return Double.NaN;
        }
        return sum / ((double) count);
    }

    public static final double averageOfLong(Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        double sum = 0.0d;
        int count = 0;
        for (Long l : iterable) {
            sum += (double) l.longValue();
            count++;
            if (count < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (count == 0) {
            return Double.NaN;
        }
        return sum / ((double) count);
    }

    public static final double averageOfFloat(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        double sum = 0.0d;
        int count = 0;
        for (Float f : iterable) {
            sum += (double) f.floatValue();
            count++;
            if (count < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (count == 0) {
            return Double.NaN;
        }
        return sum / ((double) count);
    }

    public static final double averageOfDouble(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        double sum = 0.0d;
        int count = 0;
        for (Double d : iterable) {
            sum += d.doubleValue();
            count++;
            if (count < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (count == 0) {
            return Double.NaN;
        }
        return sum / ((double) count);
    }

    public static final int sumOfByte(Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        for (Byte b : iterable) {
            sum += b.byteValue();
        }
        return sum;
    }

    public static final int sumOfShort(Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        for (Short sh : iterable) {
            sum += sh.shortValue();
        }
        return sum;
    }

    public static final int sumOfInt(Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        for (Integer num : iterable) {
            sum += num.intValue();
        }
        return sum;
    }

    public static final long sumOfLong(Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        long sum = 0;
        for (Long l : iterable) {
            sum += l.longValue();
        }
        return sum;
    }

    public static final float sumOfFloat(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        float sum = 0.0f;
        for (Float f : iterable) {
            sum += f.floatValue();
        }
        return sum;
    }

    public static final double sumOfDouble(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        double sum = 0.0d;
        for (Double d : iterable) {
            sum += d.doubleValue();
        }
        return sum;
    }
}
