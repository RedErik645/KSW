package kotlin.collections.builders;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class ListBuilderKt {
    public static final <E> E[] arrayOfUninitializedElements(int size) {
        if (size >= 0) {
            return (E[]) new Object[size];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> String subarrayContentToString(T[] tArr, int offset, int length) {
        StringBuilder sb = new StringBuilder((length * 3) + 2);
        sb.append("[");
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append((Object) tArr[offset + i]);
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public static final <T> int subarrayContentHashCode(T[] tArr, int offset, int length) {
        int result = 1;
        for (int i = 0; i < length; i++) {
            T t = tArr[offset + i];
            result = (result * 31) + (t != null ? t.hashCode() : 0);
        }
        return result;
    }

    public static final <T> boolean subarrayContentEquals(T[] tArr, int offset, int length, List<?> list) {
        if (length != list.size()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!Intrinsics.areEqual(tArr[offset + i], list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static final <T> T[] copyOfUninitializedElements(T[] tArr, int newSize) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, newSize);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(this, newSize)");
        return tArr2;
    }

    public static final <E> void resetAt(E[] eArr, int index) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        eArr[index] = null;
    }

    public static final <E> void resetRange(E[] eArr, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        for (int index = fromIndex; index < toIndex; index++) {
            resetAt(eArr, index);
        }
    }
}
