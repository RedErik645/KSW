package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

public final class RegexKt {
    public static final int toInt(Iterable<? extends FlagEnum> iterable) {
        int accumulator$iv = 0;
        for (FlagEnum option : iterable) {
            accumulator$iv |= option.getValue();
        }
        return accumulator$iv;
    }

    private static final /* synthetic */ <T extends Enum<T> & FlagEnum> Set<T> fromInt(int value) {
        Intrinsics.reifiedOperationMarker(4, "T");
        EnumSet allOf = EnumSet.allOf(Enum.class);
        EnumSet $this$fromInt_u24lambda_u2d1 = allOf;
        Intrinsics.checkNotNullExpressionValue($this$fromInt_u24lambda_u2d1, "");
        Intrinsics.needClassReification();
        CollectionsKt.retainAll($this$fromInt_u24lambda_u2d1, new RegexKt$fromInt$1$1(value));
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        return unmodifiableSet;
    }

    public static final MatchResult findNext(Matcher $this$findNext, int from, CharSequence input) {
        if (!$this$findNext.find(from)) {
            return null;
        }
        return new MatcherMatchResult($this$findNext, input);
    }

    public static final MatchResult matchEntire(Matcher $this$matchEntire, CharSequence input) {
        if (!$this$matchEntire.matches()) {
            return null;
        }
        return new MatcherMatchResult($this$matchEntire, input);
    }

    public static final IntRange range(MatchResult $this$range) {
        return RangesKt.until($this$range.start(), $this$range.end());
    }

    public static final IntRange range(MatchResult $this$range, int groupIndex) {
        return RangesKt.until($this$range.start(groupIndex), $this$range.end(groupIndex));
    }
}
