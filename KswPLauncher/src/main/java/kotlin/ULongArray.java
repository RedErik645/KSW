package kotlin;

import com.ibm.icu.text.PluralRules;
import com.wits.ksw.launcher.view.benzgs.BenzConfig;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0001\u0007\u0001\u00020\bø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00063"}, d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", PluralRules.KEYWORD_OTHER, "", "equals-impl", "([JLjava/lang/Object;)Z", "get", BenzConfig.INDEX, "get-s-VKNKU", "([JI)J", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "toString-impl", "([J)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: ULongArray.kt */
public final class ULongArray implements Collection<ULong>, KMappedMarker {
    private final long[] storage;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULongArray m233boximpl(long[] jArr) {
        return new ULongArray(jArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m235constructorimpl(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "storage");
        return jArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m238equalsimpl(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.areEqual(jArr, ((ULongArray) obj).m249unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m239equalsimpl0(long[] jArr, long[] jArr2) {
        return Intrinsics.areEqual(jArr, jArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m242hashCodeimpl(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m246toStringimpl(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-VKZWuLQ  reason: not valid java name */
    public boolean m247addVKZWuLQ(long j) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object obj) {
        return m238equalsimpl(this.storage, obj);
    }

    public int hashCode() {
        return m242hashCodeimpl(this.storage);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return m246toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long[] m249unboximpl() {
        return this.storage;
    }

    public final /* bridge */ boolean contains(Object element) {
        if (!(element instanceof ULong)) {
            return false;
        }
        return m248containsVKZWuLQ(((ULong) element).m232unboximpl());
    }

    private /* synthetic */ ULongArray(long[] storage2) {
        this.storage = storage2;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m234constructorimpl(int size) {
        return m235constructorimpl(new long[size]);
    }

    /* renamed from: get-s-VKNKU  reason: not valid java name */
    public static final long m240getsVKNKU(long[] arg0, int index) {
        return ULong.m181constructorimpl(arg0[index]);
    }

    /* renamed from: set-k8EXiF4  reason: not valid java name */
    public static final void m245setk8EXiF4(long[] arg0, int index, long value) {
        arg0[index] = value;
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m241getSizeimpl(long[] arg0) {
        return arg0.length;
    }

    /* renamed from: getSize */
    public int size() {
        return m241getSizeimpl(this.storage);
    }

    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<ULong> m244iteratorimpl(long[] arg0) {
        return new Iterator(arg0);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<ULong> iterator() {
        return m244iteratorimpl(this.storage);
    }

    /* access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\u0015\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\r"}, d2 = {"Lkotlin/ULongArray$Iterator;", "Lkotlin/collections/ULongIterator;", "array", "", "([J)V", BenzConfig.INDEX, "", "hasNext", "", "nextULong", "Lkotlin/ULong;", "nextULong-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ULongArray.kt */
    public static final class Iterator extends ULongIterator {
        private final long[] array;
        private int index;

        public Iterator(long[] array2) {
            Intrinsics.checkNotNullParameter(array2, "array");
            this.array = array2;
        }

        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.ULongIterator
        /* renamed from: nextULong-s-VKNKU  reason: not valid java name */
        public long m250nextULongsVKNKU() {
            int i = this.index;
            long[] jArr = this.array;
            if (i < jArr.length) {
                this.index = i + 1;
                return ULong.m181constructorimpl(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m248containsVKZWuLQ(long element) {
        return m236containsVKZWuLQ(this.storage, element);
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public static boolean m236containsVKZWuLQ(long[] arg0, long element) {
        return ArraysKt.contains(arg0, element);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m237containsAllimpl(this.storage, collection);
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m237containsAllimpl(long[] arg0, Collection<ULong> collection) {
        Object it;
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<ULong> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!(element$iv instanceof ULong) || !ArraysKt.contains(arg0, ((ULong) element$iv).m232unboximpl())) {
                it = null;
                continue;
            } else {
                it = 1;
                continue;
            }
            if (it == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m243isEmptyimpl(long[] arg0) {
        return arg0.length == 0;
    }

    public boolean isEmpty() {
        return m243isEmptyimpl(this.storage);
    }
}
