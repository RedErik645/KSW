package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
/* compiled from: GroupingJVM.kt */
public class GroupingKt__GroupingJVMKt {
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> grouping) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Grouping $this$foldTo$iv = grouping;
        Iterator<T> sourceIterator = $this$foldTo$iv.sourceIterator();
        while (sourceIterator.hasNext()) {
            Object key$iv$iv = $this$foldTo$iv.keyOf(sourceIterator.next());
            Object accumulator$iv$iv = linkedHashMap.get(key$iv$iv);
            Ref.IntRef acc = (Ref.IntRef) (accumulator$iv$iv == null && !linkedHashMap.containsKey(key$iv$iv) ? new Ref.IntRef() : accumulator$iv$iv);
            acc.element++;
            linkedHashMap.put(key$iv$iv, acc);
            $this$foldTo$iv = $this$foldTo$iv;
        }
        for (Map.Entry it : linkedHashMap.entrySet()) {
            TypeIntrinsics.asMutableMapEntry(it).setValue(Integer.valueOf(((Ref.IntRef) it.getValue()).element));
        }
        return TypeIntrinsics.asMutableMap(linkedHashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Map$Entry */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "f");
        for (Map.Entry it : map.entrySet()) {
            TypeIntrinsics.asMutableMapEntry(it).setValue(function1.invoke(it));
        }
        return TypeIntrinsics.asMutableMap(map);
    }
}
