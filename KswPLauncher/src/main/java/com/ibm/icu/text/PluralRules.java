package com.ibm.icu.text;

import com.ibm.icu.impl.PluralRulesLoader;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import kotlin.time.DurationKt;

public class PluralRules implements Serializable {
    static final UnicodeSet ALLOWED_ID = new UnicodeSet("[a-z]").freeze();
    static final Pattern AND_SEPARATED = Pattern.compile("\\s*and\\s*");
    static final Pattern AT_SEPARATED = Pattern.compile("\\s*\\Q\\E@\\s*");
    @Deprecated
    public static final String CATEGORY_SEPARATOR = ";  ";
    static final Pattern COMMA_SEPARATED = Pattern.compile("\\s*,\\s*");
    public static final PluralRules DEFAULT;
    private static final Rule DEFAULT_RULE;
    static final Pattern DOTDOT_SEPARATED = Pattern.compile("\\s*\\Q..\\E\\s*");
    public static final String KEYWORD_FEW = "few";
    public static final String KEYWORD_MANY = "many";
    public static final String KEYWORD_ONE = "one";
    public static final String KEYWORD_OTHER = "other";
    @Deprecated
    public static final String KEYWORD_RULE_SEPARATOR = ": ";
    public static final String KEYWORD_TWO = "two";
    public static final String KEYWORD_ZERO = "zero";
    private static final Constraint NO_CONSTRAINT;
    public static final double NO_UNIQUE_VALUE = -0.00123456777d;
    static final Pattern OR_SEPARATED = Pattern.compile("\\s*or\\s*");
    static final Pattern SEMI_SEPARATED = Pattern.compile("\\s*;\\s*");
    static final Pattern TILDE_SEPARATED = Pattern.compile("\\s*~\\s*");
    private static final long serialVersionUID = 1;
    private final transient Set<String> keywords;
    private final RuleList rules;

    /* access modifiers changed from: private */
    public interface Constraint extends Serializable {
        boolean isFulfilled(IFixedDecimal iFixedDecimal);

        boolean isLimited(SampleType sampleType);
    }

    @Deprecated
    public interface IFixedDecimal {
        @Deprecated
        double getPluralOperand(Operand operand);

        @Deprecated
        boolean isInfinite();

        @Deprecated
        boolean isNaN();
    }

    public enum KeywordStatus {
        INVALID,
        SUPPRESSED,
        UNIQUE,
        BOUNDED,
        UNBOUNDED
    }

    @Deprecated
    public enum Operand {
        n,
        i,
        f,
        t,
        v,
        w,
        j
    }

    public enum PluralType {
        CARDINAL,
        ORDINAL
    }

    @Deprecated
    public enum SampleType {
        INTEGER,
        DECIMAL
    }

    static {
        AnonymousClass1 r0 = new Constraint() {
            /* class com.ibm.icu.text.PluralRules.AnonymousClass1 */
            private static final long serialVersionUID = 9163464945387899416L;

            @Override // com.ibm.icu.text.PluralRules.Constraint
            public boolean isFulfilled(IFixedDecimal n) {
                return true;
            }

            @Override // com.ibm.icu.text.PluralRules.Constraint
            public boolean isLimited(SampleType sampleType) {
                return false;
            }

            public String toString() {
                return "";
            }
        };
        NO_CONSTRAINT = r0;
        Rule rule = new Rule(KEYWORD_OTHER, r0, null, null);
        DEFAULT_RULE = rule;
        DEFAULT = new PluralRules(new RuleList().addRule(rule));
    }

    @Deprecated
    public static abstract class Factory {
        @Deprecated
        public abstract PluralRules forLocale(ULocale uLocale, PluralType pluralType);

        @Deprecated
        public abstract ULocale[] getAvailableULocales();

        @Deprecated
        public abstract ULocale getFunctionalEquivalent(ULocale uLocale, boolean[] zArr);

        @Deprecated
        public abstract boolean hasOverride(ULocale uLocale);

        @Deprecated
        protected Factory() {
        }

        @Deprecated
        public final PluralRules forLocale(ULocale locale) {
            return forLocale(locale, PluralType.CARDINAL);
        }

        @Deprecated
        public static PluralRulesLoader getDefaultFactory() {
            return PluralRulesLoader.loader;
        }
    }

    public static PluralRules parseDescription(String description) throws ParseException {
        String description2 = description.trim();
        return description2.length() == 0 ? DEFAULT : new PluralRules(parseRuleChain(description2));
    }

    public static PluralRules createRules(String description) {
        try {
            return parseDescription(description);
        } catch (Exception e) {
            return null;
        }
    }

    @Deprecated
    public static class FixedDecimal extends Number implements Comparable<FixedDecimal>, IFixedDecimal {
        static final long MAX = 1000000000000000000L;
        private static final long MAX_INTEGER_PART = 1000000000;
        private static final long serialVersionUID = -4756200506571685661L;
        private final int baseFactor;
        final long decimalDigits;
        final long decimalDigitsWithoutTrailingZeros;
        final boolean hasIntegerValue;
        final long integerValue;
        final boolean isNegative;
        final double source;
        final int visibleDecimalDigitCount;
        final int visibleDecimalDigitCountWithoutTrailingZeros;

        @Deprecated
        public double getSource() {
            return this.source;
        }

        @Deprecated
        public int getVisibleDecimalDigitCount() {
            return this.visibleDecimalDigitCount;
        }

        @Deprecated
        public int getVisibleDecimalDigitCountWithoutTrailingZeros() {
            return this.visibleDecimalDigitCountWithoutTrailingZeros;
        }

        @Deprecated
        public long getDecimalDigits() {
            return this.decimalDigits;
        }

        @Deprecated
        public long getDecimalDigitsWithoutTrailingZeros() {
            return this.decimalDigitsWithoutTrailingZeros;
        }

        @Deprecated
        public long getIntegerValue() {
            return this.integerValue;
        }

        @Deprecated
        public boolean isHasIntegerValue() {
            return this.hasIntegerValue;
        }

        @Deprecated
        public boolean isNegative() {
            return this.isNegative;
        }

        @Deprecated
        public int getBaseFactor() {
            return this.baseFactor;
        }

        @Deprecated
        public FixedDecimal(double n, int v, long f) {
            boolean z = true;
            boolean z2 = n < 0.0d;
            this.isNegative = z2;
            double d = z2 ? -n : n;
            this.source = d;
            this.visibleDecimalDigitCount = v;
            this.decimalDigits = f;
            long j = n > 1.0E18d ? MAX : (long) n;
            this.integerValue = j;
            this.hasIntegerValue = d != ((double) j) ? false : z;
            if (f == 0) {
                this.decimalDigitsWithoutTrailingZeros = 0;
                this.visibleDecimalDigitCountWithoutTrailingZeros = 0;
            } else {
                long fdwtz = f;
                int trimmedCount = v;
                while (fdwtz % 10 == 0) {
                    fdwtz /= 10;
                    trimmedCount--;
                }
                this.decimalDigitsWithoutTrailingZeros = fdwtz;
                this.visibleDecimalDigitCountWithoutTrailingZeros = trimmedCount;
            }
            this.baseFactor = (int) Math.pow(10.0d, (double) v);
        }

        @Deprecated
        public FixedDecimal(double n, int v) {
            this(n, v, (long) getFractionalDigits(n, v));
        }

        private static int getFractionalDigits(double n, int v) {
            if (v == 0) {
                return 0;
            }
            if (n < 0.0d) {
                n = -n;
            }
            int baseFactor2 = (int) Math.pow(10.0d, (double) v);
            return (int) (Math.round(((double) baseFactor2) * n) % ((long) baseFactor2));
        }

        @Deprecated
        public FixedDecimal(double n) {
            this(n, decimals(n));
        }

        @Deprecated
        public FixedDecimal(long n) {
            this((double) n, 0);
        }

        @Deprecated
        public static int decimals(double n) {
            if (Double.isInfinite(n) || Double.isNaN(n)) {
                return 0;
            }
            if (n < 0.0d) {
                n = -n;
            }
            if (n == Math.floor(n)) {
                return 0;
            }
            if (n < 1.0E9d) {
                long temp = ((long) (1000000.0d * n)) % 1000000;
                int mask = 10;
                for (int digits = 6; digits > 0; digits--) {
                    if (temp % ((long) mask) != 0) {
                        return digits;
                    }
                    mask *= 10;
                }
                return 0;
            }
            String buf = String.format(Locale.ENGLISH, "%1.15e", Double.valueOf(n));
            int ePos = buf.lastIndexOf(101);
            int expNumPos = ePos + 1;
            if (buf.charAt(expNumPos) == '+') {
                expNumPos++;
            }
            int numFractionDigits = (ePos - 2) - Integer.parseInt(buf.substring(expNumPos));
            if (numFractionDigits < 0) {
                return 0;
            }
            int i = ePos - 1;
            while (numFractionDigits > 0 && buf.charAt(i) == '0') {
                numFractionDigits--;
                i--;
            }
            return numFractionDigits;
        }

        @Deprecated
        public FixedDecimal(String n) {
            this(Double.parseDouble(n), getVisibleFractionCount(n));
        }

        private static int getVisibleFractionCount(String value) {
            String value2 = value.trim();
            int decimalPos = value2.indexOf(46) + 1;
            if (decimalPos == 0) {
                return 0;
            }
            return value2.length() - decimalPos;
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public double getPluralOperand(Operand operand) {
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$text$PluralRules$Operand[operand.ordinal()]) {
                case 1:
                    return this.source;
                case 2:
                    return (double) this.integerValue;
                case 3:
                    return (double) this.decimalDigits;
                case 4:
                    return (double) this.decimalDigitsWithoutTrailingZeros;
                case 5:
                    return (double) this.visibleDecimalDigitCount;
                case 6:
                    return (double) this.visibleDecimalDigitCountWithoutTrailingZeros;
                default:
                    return this.source;
            }
        }

        @Deprecated
        public static Operand getOperand(String t) {
            return Operand.valueOf(t);
        }

        @Deprecated
        public int compareTo(FixedDecimal other) {
            long j = this.integerValue;
            long j2 = other.integerValue;
            if (j != j2) {
                return j < j2 ? -1 : 1;
            }
            double d = this.source;
            double d2 = other.source;
            if (d != d2) {
                return d < d2 ? -1 : 1;
            }
            int i = this.visibleDecimalDigitCount;
            int i2 = other.visibleDecimalDigitCount;
            if (i != i2) {
                return i < i2 ? -1 : 1;
            }
            long diff = this.decimalDigits - other.decimalDigits;
            if (diff != 0) {
                return diff < 0 ? -1 : 1;
            }
            return 0;
        }

        @Deprecated
        public boolean equals(Object arg0) {
            if (arg0 == null) {
                return false;
            }
            if (arg0 == this) {
                return true;
            }
            if (!(arg0 instanceof FixedDecimal)) {
                return false;
            }
            FixedDecimal other = (FixedDecimal) arg0;
            if (this.source == other.source && this.visibleDecimalDigitCount == other.visibleDecimalDigitCount && this.decimalDigits == other.decimalDigits) {
                return true;
            }
            return false;
        }

        @Deprecated
        public int hashCode() {
            return (int) (this.decimalDigits + ((long) ((this.visibleDecimalDigitCount + ((int) (this.source * 37.0d))) * 37)));
        }

        @Deprecated
        public String toString() {
            return String.format("%." + this.visibleDecimalDigitCount + "f", Double.valueOf(this.source));
        }

        @Deprecated
        public boolean hasIntegerValue() {
            return this.hasIntegerValue;
        }

        @Deprecated
        public int intValue() {
            return (int) this.integerValue;
        }

        @Deprecated
        public long longValue() {
            return this.integerValue;
        }

        @Deprecated
        public float floatValue() {
            return (float) this.source;
        }

        @Deprecated
        public double doubleValue() {
            return this.isNegative ? -this.source : this.source;
        }

        @Deprecated
        public long getShiftedValue() {
            return (this.integerValue * ((long) this.baseFactor)) + this.decimalDigits;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public boolean isNaN() {
            return Double.isNaN(this.source);
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public boolean isInfinite() {
            return Double.isInfinite(this.source);
        }
    }

    @Deprecated
    public static class FixedDecimalRange {
        @Deprecated
        public final FixedDecimal end;
        @Deprecated
        public final FixedDecimal start;

        @Deprecated
        public FixedDecimalRange(FixedDecimal start2, FixedDecimal end2) {
            if (start2.visibleDecimalDigitCount == end2.visibleDecimalDigitCount) {
                this.start = start2;
                this.end = end2;
                return;
            }
            throw new IllegalArgumentException("Ranges must have the same number of visible decimals: " + start2 + "~" + end2);
        }

        @Deprecated
        public String toString() {
            return this.start + (this.end == this.start ? "" : "~" + this.end);
        }
    }

    @Deprecated
    public static class FixedDecimalSamples {
        @Deprecated
        public final boolean bounded;
        @Deprecated
        public final SampleType sampleType;
        @Deprecated
        public final Set<FixedDecimalRange> samples;

        private FixedDecimalSamples(SampleType sampleType2, Set<FixedDecimalRange> samples2, boolean bounded2) {
            this.sampleType = sampleType2;
            this.samples = samples2;
            this.bounded = bounded2;
        }

        static FixedDecimalSamples parse(String source) {
            SampleType sampleType2;
            boolean bounded2 = true;
            boolean haveBound = false;
            Set<FixedDecimalRange> samples2 = new LinkedHashSet<>();
            if (source.startsWith("integer")) {
                sampleType2 = SampleType.INTEGER;
            } else if (source.startsWith("decimal")) {
                sampleType2 = SampleType.DECIMAL;
            } else {
                throw new IllegalArgumentException("Samples must start with 'integer' or 'decimal'");
            }
            String[] split = PluralRules.COMMA_SEPARATED.split(source.substring(7).trim());
            for (String range : split) {
                if (range.equals("…") || range.equals("...")) {
                    bounded2 = false;
                    haveBound = true;
                } else if (!haveBound) {
                    String[] rangeParts = PluralRules.TILDE_SEPARATED.split(range);
                    switch (rangeParts.length) {
                        case 1:
                            FixedDecimal sample = new FixedDecimal(rangeParts[0]);
                            checkDecimal(sampleType2, sample);
                            samples2.add(new FixedDecimalRange(sample, sample));
                            continue;
                        case 2:
                            FixedDecimal start = new FixedDecimal(rangeParts[0]);
                            FixedDecimal end = new FixedDecimal(rangeParts[1]);
                            checkDecimal(sampleType2, start);
                            checkDecimal(sampleType2, end);
                            samples2.add(new FixedDecimalRange(start, end));
                            continue;
                        default:
                            throw new IllegalArgumentException("Ill-formed number range: " + range);
                    }
                } else {
                    throw new IllegalArgumentException("Can only have … at the end of samples: " + range);
                }
            }
            return new FixedDecimalSamples(sampleType2, Collections.unmodifiableSet(samples2), bounded2);
        }

        private static void checkDecimal(SampleType sampleType2, FixedDecimal sample) {
            boolean z = true;
            boolean z2 = sampleType2 == SampleType.INTEGER;
            if (sample.getVisibleDecimalDigitCount() != 0) {
                z = false;
            }
            if (z2 != z) {
                throw new IllegalArgumentException("Ill-formed number range: " + sample);
            }
        }

        @Deprecated
        public Set<Double> addSamples(Set<Double> result) {
            for (FixedDecimalRange item : this.samples) {
                long startDouble = item.start.getShiftedValue();
                long endDouble = item.end.getShiftedValue();
                for (long d = startDouble; d <= endDouble; d++) {
                    result.add(Double.valueOf(((double) d) / ((double) item.start.baseFactor)));
                }
            }
            return result;
        }

        @Deprecated
        public String toString() {
            StringBuilder b = new StringBuilder("@").append(this.sampleType.toString().toLowerCase(Locale.ENGLISH));
            boolean first = true;
            for (FixedDecimalRange item : this.samples) {
                if (first) {
                    first = false;
                } else {
                    b.append(",");
                }
                b.append(' ').append(item);
            }
            if (!this.bounded) {
                b.append(", …");
            }
            return b.toString();
        }

        @Deprecated
        public Set<FixedDecimalRange> getSamples() {
            return this.samples;
        }

        @Deprecated
        public void getStartEndSamples(Set<FixedDecimal> target) {
            for (FixedDecimalRange item : this.samples) {
                target.add(item.start);
                target.add(item.end);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class SimpleTokenizer {
        static final UnicodeSet BREAK_AND_IGNORE = new UnicodeSet(9, 10, 12, 13, 32, 32).freeze();
        static final UnicodeSet BREAK_AND_KEEP = new UnicodeSet(33, 33, 37, 37, 44, 44, 46, 46, 61, 61).freeze();

        SimpleTokenizer() {
        }

        static String[] split(String source) {
            int last = -1;
            List<String> result = new ArrayList<>();
            for (int i = 0; i < source.length(); i++) {
                char ch = source.charAt(i);
                if (BREAK_AND_IGNORE.contains(ch)) {
                    if (last >= 0) {
                        result.add(source.substring(last, i));
                        last = -1;
                    }
                } else if (BREAK_AND_KEEP.contains(ch)) {
                    if (last >= 0) {
                        result.add(source.substring(last, i));
                    }
                    result.add(source.substring(i, i + 1));
                    last = -1;
                } else if (last < 0) {
                    last = i;
                }
            }
            if (last >= 0) {
                result.add(source.substring(last));
            }
            return (String[]) result.toArray(new String[result.size()]);
        }
    }

    /* JADX INFO: Multiple debug info for r3v4 'result'  com.ibm.icu.text.PluralRules$Constraint: [D('result' com.ibm.icu.text.PluralRules$Constraint), D('andConstraint' com.ibm.icu.text.PluralRules$Constraint)] */
    /* JADX INFO: Multiple debug info for r1v7 int: [D('or_together' java.lang.String[]), D('x' int)] */
    /* JADX INFO: Multiple debug info for r1v9 java.lang.String: [D('t' java.lang.String), D('x' int)] */
    /* JADX INFO: Multiple debug info for r13v5 int: [D('integersOnly' boolean), D('x' int)] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0255 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.ibm.icu.text.PluralRules.Constraint parseConstraint(java.lang.String r39) throws java.text.ParseException {
        /*
        // Method dump skipped, instructions count: 725
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.PluralRules.parseConstraint(java.lang.String):com.ibm.icu.text.PluralRules$Constraint");
    }

    private static ParseException unexpected(String token, String context) {
        return new ParseException("unexpected token '" + token + "' in '" + context + "'", -1);
    }

    private static String nextToken(String[] tokens, int x, String context) throws ParseException {
        if (x < tokens.length) {
            return tokens[x];
        }
        throw new ParseException("missing token at end of '" + context + "'", -1);
    }

    /* access modifiers changed from: private */
    public static Rule parseRule(String description) throws ParseException {
        Constraint constraint;
        if (description.length() == 0) {
            return DEFAULT_RULE;
        }
        String description2 = description.toLowerCase(Locale.ENGLISH);
        int x = description2.indexOf(58);
        if (x != -1) {
            String keyword = description2.substring(0, x).trim();
            if (isValidKeyword(keyword)) {
                String description3 = description2.substring(x + 1).trim();
                String[] constraintOrSamples = AT_SEPARATED.split(description3);
                FixedDecimalSamples integerSamples = null;
                FixedDecimalSamples decimalSamples = null;
                boolean z = true;
                switch (constraintOrSamples.length) {
                    case 1:
                        break;
                    case 2:
                        integerSamples = FixedDecimalSamples.parse(constraintOrSamples[1]);
                        if (integerSamples.sampleType == SampleType.DECIMAL) {
                            decimalSamples = integerSamples;
                            integerSamples = null;
                            break;
                        }
                        break;
                    case 3:
                        integerSamples = FixedDecimalSamples.parse(constraintOrSamples[1]);
                        decimalSamples = FixedDecimalSamples.parse(constraintOrSamples[2]);
                        if (!(integerSamples.sampleType == SampleType.INTEGER && decimalSamples.sampleType == SampleType.DECIMAL)) {
                            throw new IllegalArgumentException("Must have @integer then @decimal in " + description3);
                        }
                    default:
                        throw new IllegalArgumentException("Too many samples in " + description3);
                }
                if (0 == 0) {
                    boolean isOther = keyword.equals(KEYWORD_OTHER);
                    if (constraintOrSamples[0].length() != 0) {
                        z = false;
                    }
                    if (isOther == z) {
                        if (isOther) {
                            constraint = NO_CONSTRAINT;
                        } else {
                            constraint = parseConstraint(constraintOrSamples[0]);
                        }
                        return new Rule(keyword, constraint, integerSamples, decimalSamples);
                    }
                    throw new IllegalArgumentException("The keyword 'other' must have no constraints, just samples.");
                }
                throw new IllegalArgumentException("Ill-formed samples—'@' characters.");
            }
            throw new ParseException("keyword '" + keyword + " is not valid", 0);
        }
        throw new ParseException("missing ':' in rule description '" + description2 + "'", 0);
    }

    private static RuleList parseRuleChain(String description) throws ParseException {
        String[] rules2;
        RuleList result = new RuleList();
        if (description.endsWith(";")) {
            description = description.substring(0, description.length() - 1);
        }
        for (String str : SEMI_SEPARATED.split(description)) {
            Rule rule = parseRule(str.trim());
            result.hasExplicitBoundingInfo |= (rule.integerSamples == null && rule.decimalSamples == null) ? false : true;
            result.addRule(rule);
        }
        return result.finish();
    }

    /* access modifiers changed from: private */
    public static class RangeConstraint implements Constraint, Serializable {
        private static final long serialVersionUID = 1;
        private final boolean inRange;
        private final boolean integersOnly;
        private final double lowerBound;
        private final int mod;
        private final Operand operand;
        private final long[] range_list;
        private final double upperBound;

        RangeConstraint(int mod2, boolean inRange2, Operand operand2, boolean integersOnly2, double lowBound, double highBound, long[] vals) {
            this.mod = mod2;
            this.inRange = inRange2;
            this.integersOnly = integersOnly2;
            this.lowerBound = lowBound;
            this.upperBound = highBound;
            this.range_list = vals;
            this.operand = operand2;
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal number) {
            double n = number.getPluralOperand(this.operand);
            if ((this.integersOnly && n - ((double) ((long) n)) != 0.0d) || (this.operand == Operand.j && number.getPluralOperand(Operand.v) != 0.0d)) {
                return !this.inRange;
            }
            int i = this.mod;
            if (i != 0) {
                n %= (double) i;
            }
            boolean test = n >= this.lowerBound && n <= this.upperBound;
            if (test && this.range_list != null) {
                test = false;
                int i2 = 0;
                while (!test) {
                    long[] jArr = this.range_list;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    test = n >= ((double) jArr[i2]) && n <= ((double) jArr[i2 + 1]);
                    i2 += 2;
                }
            }
            if (this.inRange == test) {
                return true;
            }
            return false;
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isLimited(SampleType sampleType) {
            double d = this.lowerBound;
            boolean hasDecimals = (this.operand == Operand.v || this.operand == Operand.w || this.operand == Operand.f || this.operand == Operand.t) && this.inRange != ((d > this.upperBound ? 1 : (d == this.upperBound ? 0 : -1)) == 0 && (d > 0.0d ? 1 : (d == 0.0d ? 0 : -1)) == 0);
            switch (AnonymousClass2.$SwitchMap$com$ibm$icu$text$PluralRules$SampleType[sampleType.ordinal()]) {
                case 1:
                    if (!hasDecimals) {
                        return (this.operand == Operand.n || this.operand == Operand.i || this.operand == Operand.j) && this.mod == 0 && this.inRange;
                    }
                    return true;
                case 2:
                    return (!hasDecimals || this.operand == Operand.n || this.operand == Operand.j) && (this.integersOnly || this.lowerBound == this.upperBound) && this.mod == 0 && this.inRange;
                default:
                    return false;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
            if (r11.inRange != false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
            if (r11.inRange != false) goto L_0x0046;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
            // Method dump skipped, instructions count: 119
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.PluralRules.RangeConstraint.toString():java.lang.String");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.ibm.icu.text.PluralRules$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$PluralRules$Operand;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$PluralRules$SampleType;

        static {
            int[] iArr = new int[SampleType.values().length];
            $SwitchMap$com$ibm$icu$text$PluralRules$SampleType = iArr;
            try {
                iArr[SampleType.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$SampleType[SampleType.DECIMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[Operand.values().length];
            $SwitchMap$com$ibm$icu$text$PluralRules$Operand = iArr2;
            try {
                iArr2[Operand.n.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.i.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.f.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.t.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.v.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.w.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static void addRange(StringBuilder result, double lb, double ub, boolean addSeparator) {
        if (addSeparator) {
            result.append(",");
        }
        if (lb == ub) {
            result.append(format(lb));
        } else {
            result.append(format(lb) + ".." + format(ub));
        }
    }

    private static String format(double lb) {
        long lbi = (long) lb;
        return lb == ((double) lbi) ? String.valueOf(lbi) : String.valueOf(lb);
    }

    private static abstract class BinaryConstraint implements Constraint, Serializable {
        private static final long serialVersionUID = 1;
        protected final Constraint a;
        protected final Constraint b;

        protected BinaryConstraint(Constraint a2, Constraint b2) {
            this.a = a2;
            this.b = b2;
        }
    }

    /* access modifiers changed from: private */
    public static class AndConstraint extends BinaryConstraint {
        private static final long serialVersionUID = 7766999779862263523L;

        AndConstraint(Constraint a, Constraint b) {
            super(a, b);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal n) {
            return this.a.isFulfilled(n) && this.b.isFulfilled(n);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isLimited(SampleType sampleType) {
            return this.a.isLimited(sampleType) || this.b.isLimited(sampleType);
        }

        public String toString() {
            return this.a.toString() + " and " + this.b.toString();
        }
    }

    /* access modifiers changed from: private */
    public static class OrConstraint extends BinaryConstraint {
        private static final long serialVersionUID = 1405488568664762222L;

        OrConstraint(Constraint a, Constraint b) {
            super(a, b);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal n) {
            return this.a.isFulfilled(n) || this.b.isFulfilled(n);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isLimited(SampleType sampleType) {
            return this.a.isLimited(sampleType) && this.b.isLimited(sampleType);
        }

        public String toString() {
            return this.a.toString() + " or " + this.b.toString();
        }
    }

    /* access modifiers changed from: private */
    public static class Rule implements Serializable {
        private static final long serialVersionUID = 1;
        private final Constraint constraint;
        private final FixedDecimalSamples decimalSamples;
        private final FixedDecimalSamples integerSamples;
        private final String keyword;

        public Rule(String keyword2, Constraint constraint2, FixedDecimalSamples integerSamples2, FixedDecimalSamples decimalSamples2) {
            this.keyword = keyword2;
            this.constraint = constraint2;
            this.integerSamples = integerSamples2;
            this.decimalSamples = decimalSamples2;
        }

        public Rule and(Constraint c) {
            return new Rule(this.keyword, new AndConstraint(this.constraint, c), this.integerSamples, this.decimalSamples);
        }

        public Rule or(Constraint c) {
            return new Rule(this.keyword, new OrConstraint(this.constraint, c), this.integerSamples, this.decimalSamples);
        }

        public String getKeyword() {
            return this.keyword;
        }

        public boolean appliesTo(IFixedDecimal n) {
            return this.constraint.isFulfilled(n);
        }

        public boolean isLimited(SampleType sampleType) {
            return this.constraint.isLimited(sampleType);
        }

        public String toString() {
            String str;
            StringBuilder append = new StringBuilder().append(this.keyword).append(PluralRules.KEYWORD_RULE_SEPARATOR).append(this.constraint.toString());
            String str2 = "";
            if (this.integerSamples == null) {
                str = str2;
            } else {
                str = " " + this.integerSamples.toString();
            }
            StringBuilder append2 = append.append(str);
            if (this.decimalSamples != null) {
                str2 = " " + this.decimalSamples.toString();
            }
            return append2.append(str2).toString();
        }

        public int hashCode() {
            return this.keyword.hashCode() ^ this.constraint.hashCode();
        }

        public String getConstraint() {
            return this.constraint.toString();
        }
    }

    /* access modifiers changed from: private */
    public static class RuleList implements Serializable {
        private static final long serialVersionUID = 1;
        private boolean hasExplicitBoundingInfo;
        private final List<Rule> rules;

        private RuleList() {
            this.hasExplicitBoundingInfo = false;
            this.rules = new ArrayList();
        }

        public RuleList addRule(Rule nextRule) {
            String keyword = nextRule.getKeyword();
            for (Rule rule : this.rules) {
                if (keyword.equals(rule.getKeyword())) {
                    throw new IllegalArgumentException("Duplicate keyword: " + keyword);
                }
            }
            this.rules.add(nextRule);
            return this;
        }

        public RuleList finish() throws ParseException {
            Rule otherRule = null;
            Iterator<Rule> it = this.rules.iterator();
            while (it.hasNext()) {
                Rule rule = it.next();
                if (PluralRules.KEYWORD_OTHER.equals(rule.getKeyword())) {
                    otherRule = rule;
                    it.remove();
                }
            }
            if (otherRule == null) {
                otherRule = PluralRules.parseRule("other:");
            }
            this.rules.add(otherRule);
            return this;
        }

        private Rule selectRule(IFixedDecimal n) {
            for (Rule rule : this.rules) {
                if (rule.appliesTo(n)) {
                    return rule;
                }
            }
            return null;
        }

        public String select(IFixedDecimal n) {
            if (n.isInfinite() || n.isNaN()) {
                return PluralRules.KEYWORD_OTHER;
            }
            return selectRule(n).getKeyword();
        }

        public Set<String> getKeywords() {
            Set<String> result = new LinkedHashSet<>();
            for (Rule rule : this.rules) {
                result.add(rule.getKeyword());
            }
            return result;
        }

        public boolean isLimited(String keyword, SampleType sampleType) {
            if (!this.hasExplicitBoundingInfo) {
                return computeLimited(keyword, sampleType);
            }
            FixedDecimalSamples mySamples = getDecimalSamples(keyword, sampleType);
            if (mySamples == null) {
                return true;
            }
            return mySamples.bounded;
        }

        public boolean computeLimited(String keyword, SampleType sampleType) {
            boolean result = false;
            for (Rule rule : this.rules) {
                if (keyword.equals(rule.getKeyword())) {
                    if (!rule.isLimited(sampleType)) {
                        return false;
                    }
                    result = true;
                }
            }
            return result;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Rule rule : this.rules) {
                if (builder.length() != 0) {
                    builder.append(PluralRules.CATEGORY_SEPARATOR);
                }
                builder.append(rule);
            }
            return builder.toString();
        }

        public String getRules(String keyword) {
            for (Rule rule : this.rules) {
                if (rule.getKeyword().equals(keyword)) {
                    return rule.getConstraint();
                }
            }
            return null;
        }

        public boolean select(IFixedDecimal sample, String keyword) {
            for (Rule rule : this.rules) {
                if (rule.getKeyword().equals(keyword) && rule.appliesTo(sample)) {
                    return true;
                }
            }
            return false;
        }

        public FixedDecimalSamples getDecimalSamples(String keyword, SampleType sampleType) {
            for (Rule rule : this.rules) {
                if (rule.getKeyword().equals(keyword)) {
                    return sampleType == SampleType.INTEGER ? rule.integerSamples : rule.decimalSamples;
                }
            }
            return null;
        }
    }

    private boolean addConditional(Set<IFixedDecimal> toAddTo, Set<IFixedDecimal> others, double trial) {
        IFixedDecimal toAdd = new FixedDecimal(trial);
        if (toAddTo.contains(toAdd) || others.contains(toAdd)) {
            return false;
        }
        others.add(toAdd);
        return true;
    }

    public static PluralRules forLocale(ULocale locale) {
        return Factory.getDefaultFactory().forLocale(locale, PluralType.CARDINAL);
    }

    public static PluralRules forLocale(Locale locale) {
        return forLocale(ULocale.forLocale(locale));
    }

    public static PluralRules forLocale(ULocale locale, PluralType type) {
        return Factory.getDefaultFactory().forLocale(locale, type);
    }

    public static PluralRules forLocale(Locale locale, PluralType type) {
        return forLocale(ULocale.forLocale(locale), type);
    }

    private static boolean isValidKeyword(String token) {
        return ALLOWED_ID.containsAll(token);
    }

    private PluralRules(RuleList rules2) {
        this.rules = rules2;
        this.keywords = Collections.unmodifiableSet(rules2.getKeywords());
    }

    public int hashCode() {
        return this.rules.hashCode();
    }

    public String select(double number) {
        return this.rules.select(new FixedDecimal(number));
    }

    @Deprecated
    public String select(double number, int countVisibleFractionDigits, long fractionaldigits) {
        return this.rules.select(new FixedDecimal(number, countVisibleFractionDigits, fractionaldigits));
    }

    @Deprecated
    public String select(IFixedDecimal number) {
        return this.rules.select(number);
    }

    @Deprecated
    public boolean matches(FixedDecimal sample, String keyword) {
        return this.rules.select(sample, keyword);
    }

    public Set<String> getKeywords() {
        return this.keywords;
    }

    public double getUniqueKeywordValue(String keyword) {
        Collection<Double> values = getAllKeywordValues(keyword);
        if (values == null || values.size() != 1) {
            return -0.00123456777d;
        }
        return values.iterator().next().doubleValue();
    }

    public Collection<Double> getAllKeywordValues(String keyword) {
        return getAllKeywordValues(keyword, SampleType.INTEGER);
    }

    @Deprecated
    public Collection<Double> getAllKeywordValues(String keyword, SampleType type) {
        Collection<Double> samples;
        if (isLimited(keyword, type) && (samples = getSamples(keyword, type)) != null) {
            return Collections.unmodifiableCollection(samples);
        }
        return null;
    }

    public Collection<Double> getSamples(String keyword) {
        return getSamples(keyword, SampleType.INTEGER);
    }

    @Deprecated
    public Collection<Double> getSamples(String keyword, SampleType sampleType) {
        if (!this.keywords.contains(keyword)) {
            return null;
        }
        Set<Double> result = new TreeSet<>();
        if (this.rules.hasExplicitBoundingInfo) {
            FixedDecimalSamples samples = this.rules.getDecimalSamples(keyword, sampleType);
            if (samples == null) {
                return Collections.unmodifiableSet(result);
            }
            return Collections.unmodifiableSet(samples.addSamples(result));
        }
        int maxCount = isLimited(keyword, sampleType) ? Integer.MAX_VALUE : 20;
        switch (AnonymousClass2.$SwitchMap$com$ibm$icu$text$PluralRules$SampleType[sampleType.ordinal()]) {
            case 1:
                int i = 0;
                while (i < 200 && addSample(keyword, Integer.valueOf(i), maxCount, result)) {
                    i++;
                }
                addSample(keyword, Integer.valueOf((int) DurationKt.NANOS_IN_MILLIS), maxCount, result);
                break;
            case 2:
                int i2 = 0;
                while (i2 < 2000 && addSample(keyword, new FixedDecimal(((double) i2) / 10.0d, 1), maxCount, result)) {
                    i2++;
                }
                addSample(keyword, new FixedDecimal(1000000.0d, 1), maxCount, result);
                break;
        }
        if (result.size() == 0) {
            return null;
        }
        return Collections.unmodifiableSet(result);
    }

    @Deprecated
    public boolean addSample(String keyword, Number sample, int maxCount, Set<Double> result) {
        if (!(sample instanceof FixedDecimal ? select((FixedDecimal) sample) : select(sample.doubleValue())).equals(keyword)) {
            return true;
        }
        result.add(Double.valueOf(sample.doubleValue()));
        if (maxCount - 1 < 0) {
            return false;
        }
        return true;
    }

    @Deprecated
    public FixedDecimalSamples getDecimalSamples(String keyword, SampleType sampleType) {
        return this.rules.getDecimalSamples(keyword, sampleType);
    }

    public static ULocale[] getAvailableULocales() {
        return Factory.getDefaultFactory().getAvailableULocales();
    }

    public static ULocale getFunctionalEquivalent(ULocale locale, boolean[] isAvailable) {
        return Factory.getDefaultFactory().getFunctionalEquivalent(locale, isAvailable);
    }

    public String toString() {
        return this.rules.toString();
    }

    public boolean equals(Object rhs) {
        return (rhs instanceof PluralRules) && equals((PluralRules) rhs);
    }

    public boolean equals(PluralRules rhs) {
        return rhs != null && toString().equals(rhs.toString());
    }

    public KeywordStatus getKeywordStatus(String keyword, int offset, Set<Double> explicits, Output<Double> uniqueValue) {
        return getKeywordStatus(keyword, offset, explicits, uniqueValue, SampleType.INTEGER);
    }

    @Deprecated
    public KeywordStatus getKeywordStatus(String keyword, int offset, Set<Double> explicits, Output<Double> uniqueValue, SampleType sampleType) {
        if (uniqueValue != null) {
            uniqueValue.value = null;
        }
        if (!this.keywords.contains(keyword)) {
            return KeywordStatus.INVALID;
        }
        if (!isLimited(keyword, sampleType)) {
            return KeywordStatus.UNBOUNDED;
        }
        Collection<Double> values = getSamples(keyword, sampleType);
        int originalSize = values.size();
        if (explicits == null) {
            explicits = Collections.emptySet();
        }
        if (originalSize <= explicits.size()) {
            HashSet<Double> subtractedSet = new HashSet<>(values);
            for (Double explicit : explicits) {
                subtractedSet.remove(Double.valueOf(explicit.doubleValue() - ((double) offset)));
            }
            if (subtractedSet.size() == 0) {
                return KeywordStatus.SUPPRESSED;
            }
            if (uniqueValue != null && subtractedSet.size() == 1) {
                uniqueValue.value = subtractedSet.iterator().next();
            }
            return originalSize == 1 ? KeywordStatus.UNIQUE : KeywordStatus.BOUNDED;
        } else if (originalSize != 1) {
            return KeywordStatus.BOUNDED;
        } else {
            if (uniqueValue != null) {
                uniqueValue.value = values.iterator().next();
            }
            return KeywordStatus.UNIQUE;
        }
    }

    @Deprecated
    public String getRules(String keyword) {
        return this.rules.getRules(keyword);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        throw new NotSerializableException();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        throw new NotSerializableException();
    }

    private Object writeReplace() throws ObjectStreamException {
        return new PluralRulesSerialProxy(toString());
    }

    @Deprecated
    public int compareTo(PluralRules other) {
        return toString().compareTo(other.toString());
    }

    @Deprecated
    public Boolean isLimited(String keyword) {
        return Boolean.valueOf(this.rules.isLimited(keyword, SampleType.INTEGER));
    }

    @Deprecated
    public boolean isLimited(String keyword, SampleType sampleType) {
        return this.rules.isLimited(keyword, sampleType);
    }

    @Deprecated
    public boolean computeLimited(String keyword, SampleType sampleType) {
        return this.rules.computeLimited(keyword, sampleType);
    }
}
