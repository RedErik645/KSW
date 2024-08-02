package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

public final class DurationKt {
    public static final long MAX_MILLIS;
    public static final long MAX_NANOS;
    private static final long MAX_NANOS_IN_MILLIS;
    public static final int NANOS_IN_MILLIS;

    public static /* synthetic */ void getDays$annotations(double d) {
    }

    public static /* synthetic */ void getDays$annotations(int i) {
    }

    public static /* synthetic */ void getDays$annotations(long j) {
    }

    public static /* synthetic */ void getHours$annotations(double d) {
    }

    public static /* synthetic */ void getHours$annotations(int i) {
    }

    public static /* synthetic */ void getHours$annotations(long j) {
    }

    public static /* synthetic */ void getMicroseconds$annotations(double d) {
    }

    public static /* synthetic */ void getMicroseconds$annotations(int i) {
    }

    public static /* synthetic */ void getMicroseconds$annotations(long j) {
    }

    public static /* synthetic */ void getMilliseconds$annotations(double d) {
    }

    public static /* synthetic */ void getMilliseconds$annotations(int i) {
    }

    public static /* synthetic */ void getMilliseconds$annotations(long j) {
    }

    public static /* synthetic */ void getMinutes$annotations(double d) {
    }

    public static /* synthetic */ void getMinutes$annotations(int i) {
    }

    public static /* synthetic */ void getMinutes$annotations(long j) {
    }

    public static /* synthetic */ void getNanoseconds$annotations(double d) {
    }

    public static /* synthetic */ void getNanoseconds$annotations(int i) {
    }

    public static /* synthetic */ void getNanoseconds$annotations(long j) {
    }

    public static /* synthetic */ void getSeconds$annotations(double d) {
    }

    public static /* synthetic */ void getSeconds$annotations(int i) {
    }

    public static /* synthetic */ void getSeconds$annotations(long j) {
    }

    public static final long toDuration(int $this$toDuration, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo((Enum) DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow((long) $this$toDuration, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration((long) $this$toDuration, unit);
    }

    public static final long toDuration(long $this$toDuration, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long maxNsInUnit = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, unit);
        boolean z = false;
        if ((-maxNsInUnit) <= $this$toDuration && $this$toDuration <= maxNsInUnit) {
            z = true;
        }
        if (z) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow($this$toDuration, unit, DurationUnit.NANOSECONDS));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, (long) MAX_MILLIS));
    }

    public static final long toDuration(double $this$toDuration, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double valueInNs = DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.NANOSECONDS);
        boolean z = true;
        if (!Double.isNaN(valueInNs)) {
            long nanos = MathKt.roundToLong(valueInNs);
            if (-4611686018426999999L > nanos || nanos >= 4611686018427000000L) {
                z = false;
            }
            if (z) {
                return durationOfNanos(nanos);
            }
            return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long getNanoseconds(int $this$nanoseconds) {
        return toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(long $this$nanoseconds) {
        return toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(double $this$nanoseconds) {
        return toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
    }

    public static final long getMicroseconds(int $this$microseconds) {
        return toDuration($this$microseconds, DurationUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(long $this$microseconds) {
        return toDuration($this$microseconds, DurationUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(double $this$microseconds) {
        return toDuration($this$microseconds, DurationUnit.MICROSECONDS);
    }

    public static final long getMilliseconds(int $this$milliseconds) {
        return toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(long $this$milliseconds) {
        return toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(double $this$milliseconds) {
        return toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
    }

    public static final long getSeconds(int $this$seconds) {
        return toDuration($this$seconds, DurationUnit.SECONDS);
    }

    public static final long getSeconds(long $this$seconds) {
        return toDuration($this$seconds, DurationUnit.SECONDS);
    }

    public static final long getSeconds(double $this$seconds) {
        return toDuration($this$seconds, DurationUnit.SECONDS);
    }

    public static final long getMinutes(int $this$minutes) {
        return toDuration($this$minutes, DurationUnit.MINUTES);
    }

    public static final long getMinutes(long $this$minutes) {
        return toDuration($this$minutes, DurationUnit.MINUTES);
    }

    public static final long getMinutes(double $this$minutes) {
        return toDuration($this$minutes, DurationUnit.MINUTES);
    }

    public static final long getHours(int $this$hours) {
        return toDuration($this$hours, DurationUnit.HOURS);
    }

    public static final long getHours(long $this$hours) {
        return toDuration($this$hours, DurationUnit.HOURS);
    }

    public static final long getHours(double $this$hours) {
        return toDuration($this$hours, DurationUnit.HOURS);
    }

    public static final long getDays(int $this$days) {
        return toDuration($this$days, DurationUnit.DAYS);
    }

    public static final long getDays(long $this$days) {
        return toDuration($this$days, DurationUnit.DAYS);
    }

    public static final long getDays(double $this$days) {
        return toDuration($this$days, DurationUnit.DAYS);
    }

    /* renamed from: times-mvk6XK0 */
    private static final long m1419timesmvk6XK0(int $this$times_u2dmvk6XK0, long duration) {
        return Duration.m1331timesUwyO8pc(duration, $this$times_u2dmvk6XK0);
    }

    /* renamed from: times-kIfJnKk */
    private static final long m1418timeskIfJnKk(double $this$times_u2dkIfJnKk, long duration) {
        return Duration.m1330timesUwyO8pc(duration, $this$times_u2dkIfJnKk);
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0279 A[LOOP:4: B:116:0x024e->B:131:0x0279, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x00e4 A[EDGE_INSN: B:187:0x00e4->B:54:0x00e4 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0282 A[EDGE_INSN: B:200:0x0282->B:133:0x0282 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c9 A[LOOP:1: B:36:0x0084->B:52:0x00c9, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long parseDuration(java.lang.String r32, boolean r33) {
        /*
        // Method dump skipped, instructions count: 884
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.parseDuration(java.lang.String, boolean):long");
    }

    private static final long parseOverLongIsoComponent(String value) {
        Iterable $this$all$iv;
        int it;
        int length = value.length();
        int startIndex = 0;
        if (length > 0 && StringsKt.contains$default((CharSequence) "+-", value.charAt(0), false, 2, (Object) null)) {
            startIndex = 0 + 1;
        }
        if (length - startIndex > 16) {
            Iterable $this$all$iv2 = new IntRange(startIndex, StringsKt.getLastIndex(value));
            if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
                Iterator it2 = $this$all$iv2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        $this$all$iv = 1;
                        break;
                    }
                    char charAt = value.charAt(((IntIterator) it2).nextInt());
                    if ('0' > charAt || charAt >= ':') {
                        it = 0;
                        continue;
                    } else {
                        it = 1;
                        continue;
                    }
                    if (it == 0) {
                        $this$all$iv = null;
                        break;
                    }
                }
            } else {
                $this$all$iv = 1;
            }
            if ($this$all$iv != null) {
                if (value.charAt(0) == '-') {
                    return Long.MIN_VALUE;
                }
                return LongCompanionObject.MAX_VALUE;
            }
        }
        return StringsKt.startsWith$default(value, "+", false, 2, null) ? Long.parseLong(StringsKt.drop(value, 1)) : Long.parseLong(value);
    }

    private static final String substringWhile(String $this$substringWhile, int startIndex, Function1<? super Character, Boolean> function1) {
        int i$iv = startIndex;
        while (i$iv < $this$substringWhile.length() && function1.invoke(Character.valueOf($this$substringWhile.charAt(i$iv))).booleanValue()) {
            i$iv++;
        }
        String $this$skipWhile$iv = $this$substringWhile.substring(startIndex, i$iv);
        Intrinsics.checkNotNullExpressionValue($this$skipWhile$iv, "this as java.lang.String…ing(startIndex, endIndex)");
        return $this$skipWhile$iv;
    }

    private static final int skipWhile(String $this$skipWhile, int startIndex, Function1<? super Character, Boolean> function1) {
        int i = startIndex;
        while (i < $this$skipWhile.length() && function1.invoke(Character.valueOf($this$skipWhile.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    public static final long nanosToMillis(long nanos) {
        return nanos / ((long) NANOS_IN_MILLIS);
    }

    public static final long millisToNanos(long millis) {
        return ((long) NANOS_IN_MILLIS) * millis;
    }

    public static final long durationOfNanos(long normalNanos) {
        return Duration.m1293constructorimpl(normalNanos << 1);
    }

    public static final long durationOfMillis(long normalMillis) {
        return Duration.m1293constructorimpl((normalMillis << 1) + 1);
    }

    public static final long durationOf(long normalValue, int unitDiscriminator) {
        return Duration.m1293constructorimpl((normalValue << 1) + ((long) unitDiscriminator));
    }

    public static final long durationOfNanosNormalized(long nanos) {
        boolean z = false;
        if (-4611686018426999999L <= nanos && nanos < 4611686018427000000L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(nanos);
        }
        return durationOfMillis(nanosToMillis(nanos));
    }

    public static final long durationOfMillisNormalized(long millis) {
        boolean z = false;
        if (-4611686018426L <= millis && millis < 4611686018427L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(millisToNanos(millis));
        }
        return durationOfMillis(RangesKt.coerceIn(millis, -4611686018427387903L, (long) MAX_MILLIS));
    }
}
