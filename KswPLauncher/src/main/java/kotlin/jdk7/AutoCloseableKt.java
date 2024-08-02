package kotlin.jdk7;

import kotlin.ExceptionsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aH\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000b"}, d2 = {"closeFinally", "", "Ljava/lang/AutoCloseable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 6, 0}, pn = "kotlin", xi = 48)
/* compiled from: AutoCloseable.kt */
public final class AutoCloseableKt {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        closeFinally(r3, r2);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r2 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T extends java.lang.AutoCloseable, R> R use(T r3, kotlin.jvm.functions.Function1<? super T, ? extends R> r4) {
        /*
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            r1 = 1
            java.lang.Object r2 = r4.invoke(r3)     // Catch:{ all -> 0x0017 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            closeFinally(r3, r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            return r2
        L_0x0017:
            r2 = move-exception
            r0 = r2
            throw r2     // Catch:{ all -> 0x001b }
        L_0x001b:
            r2 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            closeFinally(r3, r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jdk7.AutoCloseableKt.use(java.lang.AutoCloseable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final void closeFinally(AutoCloseable $this$closeFinally, Throwable cause) {
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
