package kotlin.collections;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.markers.KMappedMarker;

@Deprecated(level = DeprecationLevel.ERROR, message = "This class is not going to be stabilized and is to be removed soon.")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\t"}, d2 = {"Lkotlin/collections/ULongIterator;", "", "Lkotlin/ULong;", "()V", "next", "next-s-VKNKU", "()J", "nextULong", "nextULong-s-VKNKU", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UIterators.kt */
public abstract class ULongIterator implements Iterator<ULong>, KMappedMarker {
    /* renamed from: nextULong-s-VKNKU  reason: not valid java name */
    public abstract long m469nextULongsVKNKU();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ ULong next() {
        return ULong.m175boximpl(m468nextsVKNKU());
    }

    /* renamed from: next-s-VKNKU  reason: not valid java name */
    public final long m468nextsVKNKU() {
        return m469nextULongsVKNKU();
    }
}
