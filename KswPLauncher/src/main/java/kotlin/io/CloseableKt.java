package kotlin.io;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aK\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000b\u0002\u000f\n\u0006\b\u0011(\n0\u0001\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Closeable.kt */
public final class CloseableKt {
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r4 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        closeFinally(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T extends java.io.Closeable, R> R use(T r4, kotlin.jvm.functions.Function1<? super T, ? extends R> r5) {
        /*
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            r1 = 0
            r2 = 1
            java.lang.Object r3 = r5.invoke(r4)     // Catch:{ all -> 0x0025 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            boolean r1 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r2, r2, r1)
            if (r1 == 0) goto L_0x001c
            closeFinally(r4, r0)
            goto L_0x0021
        L_0x001c:
            if (r4 == 0) goto L_0x0021
            r4.close()
        L_0x0021:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            return r3
        L_0x0025:
            r3 = move-exception
            r0 = r3
            throw r3     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r3 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            boolean r1 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r2, r2, r1)
            if (r1 != 0) goto L_0x003e
            if (r4 == 0) goto L_0x0041
            r4.close()     // Catch:{ all -> 0x003c }
            goto L_0x0041
        L_0x003c:
            r1 = move-exception
            goto L_0x0041
        L_0x003e:
            closeFinally(r4, r0)
        L_0x0041:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.CloseableKt.use(java.io.Closeable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final void closeFinally(Closeable $this$closeFinally, Throwable cause) {
        if ($this$closeFinally == null) {
            return;
        }
        if (cause == null) {
            $this$closeFinally.close();
            return;
        }
        try {
            $this$closeFinally.close();
        } catch (Throwable closeException) {
            ExceptionsKt.addSuppressed(cause, closeException);
        }
    }
}
