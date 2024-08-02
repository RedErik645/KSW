package com.ibm.icu.text;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.DontCareFieldPosition;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.util.ICUException;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.wits.ksw.settings.TxzMessage;
import java.lang.reflect.Array;
import java.util.EnumMap;
import java.util.Locale;

public final class RelativeDateTimeFormatter {
    private static final Cache cache = new Cache(null);
    private static final Style[] fallbackCache = new Style[3];
    private final BreakIterator breakIterator;
    private final DisplayContext capitalizationContext;
    private final String combinedDateAndTime;
    private final DateFormatSymbols dateFormatSymbols;
    private final ULocale locale;
    private final NumberFormat numberFormat;
    private final EnumMap<Style, EnumMap<RelativeUnit, String[][]>> patternMap;
    private final PluralRules pluralRules;
    private final EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> qualitativeUnitMap;
    private final Style style;
    private int[] styleToDateFormatSymbolsWidth = {1, 3, 2};

    public enum AbsoluteUnit {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        DAY,
        WEEK,
        MONTH,
        YEAR,
        NOW,
        QUARTER
    }

    public enum Direction {
        LAST_2,
        LAST,
        THIS,
        NEXT,
        NEXT_2,
        PLAIN
    }

    public enum RelativeDateTimeUnit {
        YEAR,
        QUARTER,
        MONTH,
        WEEK,
        DAY,
        HOUR,
        MINUTE,
        SECOND,
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    public enum RelativeUnit {
        SECONDS,
        MINUTES,
        HOURS,
        DAYS,
        WEEKS,
        MONTHS,
        YEARS,
        QUARTERS
    }

    public enum Style {
        LONG,
        SHORT,
        NARROW;
        
        private static final int INDEX_COUNT = 3;
    }

    public static RelativeDateTimeFormatter getInstance() {
        return getInstance(ULocale.getDefault(), null, Style.LONG, DisplayContext.CAPITALIZATION_NONE);
    }

    public static RelativeDateTimeFormatter getInstance(ULocale locale2) {
        return getInstance(locale2, null, Style.LONG, DisplayContext.CAPITALIZATION_NONE);
    }

    public static RelativeDateTimeFormatter getInstance(Locale locale2) {
        return getInstance(ULocale.forLocale(locale2));
    }

    public static RelativeDateTimeFormatter getInstance(ULocale locale2, NumberFormat nf) {
        return getInstance(locale2, nf, Style.LONG, DisplayContext.CAPITALIZATION_NONE);
    }

    public static RelativeDateTimeFormatter getInstance(ULocale locale2, NumberFormat nf, Style style2, DisplayContext capitalizationContext2) {
        NumberFormat nf2;
        BreakIterator breakIterator2;
        RelativeDateTimeFormatterData data = cache.get(locale2);
        if (nf == null) {
            nf2 = NumberFormat.getInstance(locale2);
        } else {
            nf2 = (NumberFormat) nf.clone();
        }
        EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> enumMap = data.qualitativeUnitMap;
        EnumMap<Style, EnumMap<RelativeUnit, String[][]>> enumMap2 = data.relUnitPatternMap;
        String compileToStringMinMaxArguments = SimpleFormatterImpl.compileToStringMinMaxArguments(data.dateTimePattern, new StringBuilder(), 2, 2);
        PluralRules forLocale = PluralRules.forLocale(locale2);
        if (capitalizationContext2 == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE) {
            breakIterator2 = BreakIterator.getSentenceInstance(locale2);
        } else {
            breakIterator2 = null;
        }
        return new RelativeDateTimeFormatter(enumMap, enumMap2, compileToStringMinMaxArguments, forLocale, nf2, style2, capitalizationContext2, breakIterator2, locale2);
    }

    public static RelativeDateTimeFormatter getInstance(Locale locale2, NumberFormat nf) {
        return getInstance(ULocale.forLocale(locale2), nf);
    }

    public String format(double quantity, Direction direction, RelativeUnit unit) {
        String result;
        if (direction == Direction.LAST || direction == Direction.NEXT) {
            int pastFutureIndex = direction == Direction.NEXT ? 1 : 0;
            synchronized (this.numberFormat) {
                StringBuffer formatStr = new StringBuffer();
                result = SimpleFormatterImpl.formatCompiledPattern(getRelativeUnitPluralPattern(this.style, unit, pastFutureIndex, QuantityFormatter.selectPlural(Double.valueOf(quantity), this.numberFormat, this.pluralRules, formatStr, DontCareFieldPosition.INSTANCE)), new CharSequence[]{formatStr});
            }
            return adjustForContext(result);
        }
        throw new IllegalArgumentException("direction must be NEXT or LAST");
    }

    public String formatNumeric(double offset, RelativeDateTimeUnit unit) {
        RelativeUnit relunit = RelativeUnit.SECONDS;
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[unit.ordinal()]) {
            case 1:
                relunit = RelativeUnit.YEARS;
                break;
            case 2:
                relunit = RelativeUnit.QUARTERS;
                break;
            case 3:
                relunit = RelativeUnit.MONTHS;
                break;
            case 4:
                relunit = RelativeUnit.WEEKS;
                break;
            case 5:
                relunit = RelativeUnit.DAYS;
                break;
            case 6:
                relunit = RelativeUnit.HOURS;
                break;
            case 7:
                relunit = RelativeUnit.MINUTES;
                break;
            case 8:
                break;
            default:
                throw new UnsupportedOperationException("formatNumeric does not currently support RelativeUnit.SUNDAY..SATURDAY");
        }
        Direction direction = Direction.NEXT;
        if (Double.compare(offset, 0.0d) < 0) {
            direction = Direction.LAST;
            offset = -offset;
        }
        String result = format(offset, direction, relunit);
        return result != null ? result : "";
    }

    public String format(Direction direction, AbsoluteUnit unit) {
        String result;
        if (unit != AbsoluteUnit.NOW || direction == Direction.PLAIN) {
            if (direction != Direction.PLAIN || AbsoluteUnit.SUNDAY.ordinal() > unit.ordinal() || unit.ordinal() > AbsoluteUnit.SATURDAY.ordinal()) {
                result = getAbsoluteUnitString(this.style, unit, direction);
            } else {
                result = this.dateFormatSymbols.getWeekdays(1, this.styleToDateFormatSymbolsWidth[this.style.ordinal()])[(unit.ordinal() - AbsoluteUnit.SUNDAY.ordinal()) + 1];
            }
            if (result != null) {
                return adjustForContext(result);
            }
            return null;
        }
        throw new IllegalArgumentException("NOW can only accept direction PLAIN.");
    }

    public String format(double offset, RelativeDateTimeUnit unit) {
        String result;
        boolean useNumeric = true;
        Direction direction = Direction.THIS;
        if (offset > -2.1d && offset < 2.1d) {
            double offsetx100 = 100.0d * offset;
            switch (offsetx100 < 0.0d ? (int) (offsetx100 - 0.5d) : (int) (0.5d + offsetx100)) {
                case -200:
                    direction = Direction.LAST_2;
                    useNumeric = false;
                    break;
                case -100:
                    direction = Direction.LAST;
                    useNumeric = false;
                    break;
                case 0:
                    useNumeric = false;
                    break;
                case 100:
                    direction = Direction.NEXT;
                    useNumeric = false;
                    break;
                case 200:
                    direction = Direction.NEXT_2;
                    useNumeric = false;
                    break;
            }
        }
        AbsoluteUnit absunit = AbsoluteUnit.NOW;
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[unit.ordinal()]) {
            case 1:
                absunit = AbsoluteUnit.YEAR;
                break;
            case 2:
                absunit = AbsoluteUnit.QUARTER;
                break;
            case 3:
                absunit = AbsoluteUnit.MONTH;
                break;
            case 4:
                absunit = AbsoluteUnit.WEEK;
                break;
            case 5:
                absunit = AbsoluteUnit.DAY;
                break;
            case 6:
            case 7:
            default:
                useNumeric = true;
                break;
            case 8:
                if (direction != Direction.THIS) {
                    useNumeric = true;
                    break;
                } else {
                    direction = Direction.PLAIN;
                    break;
                }
            case 9:
                absunit = AbsoluteUnit.SUNDAY;
                break;
            case 10:
                absunit = AbsoluteUnit.MONDAY;
                break;
            case 11:
                absunit = AbsoluteUnit.TUESDAY;
                break;
            case 12:
                absunit = AbsoluteUnit.WEDNESDAY;
                break;
            case 13:
                absunit = AbsoluteUnit.THURSDAY;
                break;
            case 14:
                absunit = AbsoluteUnit.FRIDAY;
                break;
            case 15:
                absunit = AbsoluteUnit.SATURDAY;
                break;
        }
        if (useNumeric || (result = format(direction, absunit)) == null || result.length() <= 0) {
            return formatNumeric(offset, unit);
        }
        return result;
    }

    private String getAbsoluteUnitString(Style style2, AbsoluteUnit unit, Direction direction) {
        Style style3;
        EnumMap<Direction, String> dirMap;
        String result;
        do {
            EnumMap<AbsoluteUnit, EnumMap<Direction, String>> unitMap = this.qualitativeUnitMap.get(style2);
            if (unitMap != null && (dirMap = unitMap.get(unit)) != null && (result = dirMap.get(direction)) != null) {
                return result;
            }
            style3 = fallbackCache[style2.ordinal()];
            style2 = style3;
        } while (style3 != null);
        return null;
    }

    public String combineDateAndTime(String relativeDateString, String timeString) {
        return SimpleFormatterImpl.formatCompiledPattern(this.combinedDateAndTime, new CharSequence[]{timeString, relativeDateString});
    }

    public NumberFormat getNumberFormat() {
        NumberFormat numberFormat2;
        synchronized (this.numberFormat) {
            numberFormat2 = (NumberFormat) this.numberFormat.clone();
        }
        return numberFormat2;
    }

    public DisplayContext getCapitalizationContext() {
        return this.capitalizationContext;
    }

    public Style getFormatStyle() {
        return this.style;
    }

    private String adjustForContext(String originalFormattedString) {
        String titleCase;
        if (this.breakIterator == null || originalFormattedString.length() == 0 || !UCharacter.isLowerCase(UCharacter.codePointAt(originalFormattedString, 0))) {
            return originalFormattedString;
        }
        synchronized (this.breakIterator) {
            titleCase = UCharacter.toTitleCase(this.locale, originalFormattedString, this.breakIterator, 768);
        }
        return titleCase;
    }

    private RelativeDateTimeFormatter(EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> qualitativeUnitMap2, EnumMap<Style, EnumMap<RelativeUnit, String[][]>> patternMap2, String combinedDateAndTime2, PluralRules pluralRules2, NumberFormat numberFormat2, Style style2, DisplayContext capitalizationContext2, BreakIterator breakIterator2, ULocale locale2) {
        this.qualitativeUnitMap = qualitativeUnitMap2;
        this.patternMap = patternMap2;
        this.combinedDateAndTime = combinedDateAndTime2;
        this.pluralRules = pluralRules2;
        this.numberFormat = numberFormat2;
        this.style = style2;
        if (capitalizationContext2.type() == DisplayContext.Type.CAPITALIZATION) {
            this.capitalizationContext = capitalizationContext2;
            this.breakIterator = breakIterator2;
            this.locale = locale2;
            this.dateFormatSymbols = new DateFormatSymbols(locale2);
            return;
        }
        throw new IllegalArgumentException(capitalizationContext2.toString());
    }

    private String getRelativeUnitPluralPattern(Style style2, RelativeUnit unit, int pastFutureIndex, StandardPlural pluralForm) {
        String formatter;
        if (pluralForm == StandardPlural.OTHER || (formatter = getRelativeUnitPattern(style2, unit, pastFutureIndex, pluralForm)) == null) {
            return getRelativeUnitPattern(style2, unit, pastFutureIndex, StandardPlural.OTHER);
        }
        return formatter;
    }

    private String getRelativeUnitPattern(Style style2, RelativeUnit unit, int pastFutureIndex, StandardPlural pluralForm) {
        Style style3;
        String[][] spfCompiledPatterns;
        int pluralIndex = pluralForm.ordinal();
        do {
            EnumMap<RelativeUnit, String[][]> unitMap = this.patternMap.get(style2);
            if (unitMap != null && (spfCompiledPatterns = unitMap.get(unit)) != null && spfCompiledPatterns[pastFutureIndex][pluralIndex] != null) {
                return spfCompiledPatterns[pastFutureIndex][pluralIndex];
            }
            style3 = fallbackCache[style2.ordinal()];
            style2 = style3;
        } while (style3 != null);
        return null;
    }

    /* access modifiers changed from: private */
    public static class RelativeDateTimeFormatterData {
        public final String dateTimePattern;
        public final EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> qualitativeUnitMap;
        EnumMap<Style, EnumMap<RelativeUnit, String[][]>> relUnitPatternMap;

        public RelativeDateTimeFormatterData(EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> qualitativeUnitMap2, EnumMap<Style, EnumMap<RelativeUnit, String[][]>> relUnitPatternMap2, String dateTimePattern2) {
            this.qualitativeUnitMap = qualitativeUnitMap2;
            this.relUnitPatternMap = relUnitPatternMap2;
            this.dateTimePattern = dateTimePattern2;
        }
    }

    /* access modifiers changed from: private */
    public static class Cache {
        private final CacheBase<String, RelativeDateTimeFormatterData, ULocale> cache;

        private Cache() {
            this.cache = new SoftCache<String, RelativeDateTimeFormatterData, ULocale>() {
                /* class com.ibm.icu.text.RelativeDateTimeFormatter.Cache.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public RelativeDateTimeFormatterData createInstance(String key, ULocale locale) {
                    return new Loader(locale).load();
                }
            };
        }

        /* synthetic */ Cache(AnonymousClass1 x0) {
            this();
        }

        public RelativeDateTimeFormatterData get(ULocale locale) {
            return (RelativeDateTimeFormatterData) this.cache.getInstance(locale.toString(), locale);
        }
    }

    /* access modifiers changed from: private */
    public static Direction keyToDirection(UResource.Key key) {
        if (key.contentEquals("-2")) {
            return Direction.LAST_2;
        }
        if (key.contentEquals("-1")) {
            return Direction.LAST;
        }
        if (key.contentEquals(TxzMessage.TXZ_DISMISS)) {
            return Direction.THIS;
        }
        if (key.contentEquals("1")) {
            return Direction.NEXT;
        }
        if (key.contentEquals("2")) {
            return Direction.NEXT_2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final class RelDateTimeDataSink extends UResource.Sink {
        int pastFutureIndex;
        EnumMap<Style, EnumMap<AbsoluteUnit, EnumMap<Direction, String>>> qualitativeUnitMap = new EnumMap<>(Style.class);
        StringBuilder sb = new StringBuilder();
        Style style;
        EnumMap<Style, EnumMap<RelativeUnit, String[][]>> styleRelUnitPatterns = new EnumMap<>(Style.class);
        DateTimeUnit unit;

        /* access modifiers changed from: private */
        public enum DateTimeUnit {
            SECOND(RelativeUnit.SECONDS, null),
            MINUTE(RelativeUnit.MINUTES, null),
            HOUR(RelativeUnit.HOURS, null),
            DAY(RelativeUnit.DAYS, AbsoluteUnit.DAY),
            WEEK(RelativeUnit.WEEKS, AbsoluteUnit.WEEK),
            MONTH(RelativeUnit.MONTHS, AbsoluteUnit.MONTH),
            QUARTER(RelativeUnit.QUARTERS, AbsoluteUnit.QUARTER),
            YEAR(RelativeUnit.YEARS, AbsoluteUnit.YEAR),
            SUNDAY(null, AbsoluteUnit.SUNDAY),
            MONDAY(null, AbsoluteUnit.MONDAY),
            TUESDAY(null, AbsoluteUnit.TUESDAY),
            WEDNESDAY(null, AbsoluteUnit.WEDNESDAY),
            THURSDAY(null, AbsoluteUnit.THURSDAY),
            FRIDAY(null, AbsoluteUnit.FRIDAY),
            SATURDAY(null, AbsoluteUnit.SATURDAY);
            
            AbsoluteUnit absUnit;
            RelativeUnit relUnit;

            private DateTimeUnit(RelativeUnit relUnit2, AbsoluteUnit absUnit2) {
                this.relUnit = relUnit2;
                this.absUnit = absUnit2;
            }

            /* access modifiers changed from: private */
            public static final DateTimeUnit orNullFromString(CharSequence keyword) {
                switch (keyword.length()) {
                    case 3:
                        if ("day".contentEquals(keyword)) {
                            return DAY;
                        }
                        if ("sun".contentEquals(keyword)) {
                            return SUNDAY;
                        }
                        if ("mon".contentEquals(keyword)) {
                            return MONDAY;
                        }
                        if ("tue".contentEquals(keyword)) {
                            return TUESDAY;
                        }
                        if ("wed".contentEquals(keyword)) {
                            return WEDNESDAY;
                        }
                        if ("thu".contentEquals(keyword)) {
                            return THURSDAY;
                        }
                        if ("fri".contentEquals(keyword)) {
                            return FRIDAY;
                        }
                        if ("sat".contentEquals(keyword)) {
                            return SATURDAY;
                        }
                        return null;
                    case 4:
                        if ("hour".contentEquals(keyword)) {
                            return HOUR;
                        }
                        if ("week".contentEquals(keyword)) {
                            return WEEK;
                        }
                        if ("year".contentEquals(keyword)) {
                            return YEAR;
                        }
                        return null;
                    case 5:
                        if ("month".contentEquals(keyword)) {
                            return MONTH;
                        }
                        return null;
                    case 6:
                        if ("minute".contentEquals(keyword)) {
                            return MINUTE;
                        }
                        if ("second".contentEquals(keyword)) {
                            return SECOND;
                        }
                        return null;
                    case 7:
                        if ("quarter".contentEquals(keyword)) {
                            return QUARTER;
                        }
                        return null;
                    default:
                        return null;
                }
            }
        }

        private Style styleFromKey(UResource.Key key) {
            if (key.endsWith("-short")) {
                return Style.SHORT;
            }
            if (key.endsWith("-narrow")) {
                return Style.NARROW;
            }
            return Style.LONG;
        }

        private Style styleFromAlias(UResource.Value value) {
            String s = value.getAliasString();
            if (s.endsWith("-short")) {
                return Style.SHORT;
            }
            if (s.endsWith("-narrow")) {
                return Style.NARROW;
            }
            return Style.LONG;
        }

        private static int styleSuffixLength(Style style2) {
            switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$Style[style2.ordinal()]) {
                case 1:
                    return 6;
                case 2:
                    return 7;
                default:
                    return 0;
            }
        }

        public void consumeTableRelative(UResource.Key key, UResource.Value value) {
            AbsoluteUnit absUnit;
            UResource.Table unitTypesTable = value.getTable();
            for (int i = 0; unitTypesTable.getKeyAndValue(i, key, value); i++) {
                if (value.getType() == 0) {
                    String valueString = value.getString();
                    EnumMap<AbsoluteUnit, EnumMap<Direction, String>> absMap = this.qualitativeUnitMap.get(this.style);
                    if (this.unit.relUnit != RelativeUnit.SECONDS || !key.contentEquals(TxzMessage.TXZ_DISMISS)) {
                        Direction keyDirection = RelativeDateTimeFormatter.keyToDirection(key);
                        if (!(keyDirection == null || (absUnit = this.unit.absUnit) == null)) {
                            if (absMap == null) {
                                absMap = new EnumMap<>(AbsoluteUnit.class);
                                this.qualitativeUnitMap.put(this.style, absMap);
                            }
                            EnumMap<Direction, String> dirMap = absMap.get(absUnit);
                            if (dirMap == null) {
                                dirMap = new EnumMap<>(Direction.class);
                                absMap.put(absUnit, dirMap);
                            }
                            if (dirMap.get(keyDirection) == null) {
                                dirMap.put(keyDirection, value.getString());
                            }
                        }
                    } else {
                        EnumMap<Direction, String> unitStrings = absMap.get(AbsoluteUnit.NOW);
                        if (unitStrings == null) {
                            unitStrings = new EnumMap<>(Direction.class);
                            absMap.put(AbsoluteUnit.NOW, unitStrings);
                        }
                        if (unitStrings.get(Direction.PLAIN) == null) {
                            unitStrings.put(Direction.PLAIN, valueString);
                        }
                    }
                }
            }
        }

        public void consumeTableRelativeTime(UResource.Key key, UResource.Value value) {
            if (this.unit.relUnit != null) {
                UResource.Table unitTypesTable = value.getTable();
                for (int i = 0; unitTypesTable.getKeyAndValue(i, key, value); i++) {
                    if (key.contentEquals("past")) {
                        this.pastFutureIndex = 0;
                    } else if (key.contentEquals("future")) {
                        this.pastFutureIndex = 1;
                    }
                    consumeTimeDetail(key, value);
                }
            }
        }

        public void consumeTimeDetail(UResource.Key key, UResource.Value value) {
            UResource.Table unitTypesTable = value.getTable();
            EnumMap<RelativeUnit, String[][]> unitPatterns = this.styleRelUnitPatterns.get(this.style);
            if (unitPatterns == null) {
                unitPatterns = new EnumMap<>(RelativeUnit.class);
                this.styleRelUnitPatterns.put(this.style, unitPatterns);
            }
            String[][] patterns = unitPatterns.get(this.unit.relUnit);
            if (patterns == null) {
                int[] iArr = new int[2];
                iArr[1] = StandardPlural.COUNT;
                iArr[0] = 2;
                patterns = (String[][]) Array.newInstance(String.class, iArr);
                unitPatterns.put(this.unit.relUnit, patterns);
            }
            for (int i = 0; unitTypesTable.getKeyAndValue(i, key, value); i++) {
                if (value.getType() == 0) {
                    int pluralIndex = StandardPlural.indexFromString(key.toString());
                    int i2 = this.pastFutureIndex;
                    if (patterns[i2][pluralIndex] == null) {
                        patterns[i2][pluralIndex] = SimpleFormatterImpl.compileToStringMinMaxArguments(value.getString(), this.sb, 0, 1);
                    }
                }
            }
        }

        private void handlePlainDirection(UResource.Key key, UResource.Value value) {
            AbsoluteUnit absUnit = this.unit.absUnit;
            if (absUnit != null) {
                EnumMap<AbsoluteUnit, EnumMap<Direction, String>> unitMap = this.qualitativeUnitMap.get(this.style);
                if (unitMap == null) {
                    unitMap = new EnumMap<>(AbsoluteUnit.class);
                    this.qualitativeUnitMap.put(this.style, unitMap);
                }
                EnumMap<Direction, String> dirMap = unitMap.get(absUnit);
                if (dirMap == null) {
                    dirMap = new EnumMap<>(Direction.class);
                    unitMap.put(absUnit, dirMap);
                }
                if (dirMap.get(Direction.PLAIN) == null) {
                    dirMap.put(Direction.PLAIN, value.toString());
                }
            }
        }

        public void consumeTimeUnit(UResource.Key key, UResource.Value value) {
            UResource.Table unitTypesTable = value.getTable();
            for (int i = 0; unitTypesTable.getKeyAndValue(i, key, value); i++) {
                if (key.contentEquals("dn") && value.getType() == 0) {
                    handlePlainDirection(key, value);
                }
                if (value.getType() == 2) {
                    if (key.contentEquals("relative")) {
                        consumeTableRelative(key, value);
                    } else if (key.contentEquals("relativeTime")) {
                        consumeTableRelativeTime(key, value);
                    }
                }
            }
        }

        private void handleAlias(UResource.Key key, UResource.Value value, boolean noFallback) {
            Style sourceStyle = styleFromKey(key);
            if (DateTimeUnit.orNullFromString(key.substring(0, key.length() - styleSuffixLength(sourceStyle))) != null) {
                Style targetStyle = styleFromAlias(value);
                if (sourceStyle == targetStyle) {
                    throw new ICUException("Invalid style fallback from " + sourceStyle + " to itself");
                } else if (RelativeDateTimeFormatter.fallbackCache[sourceStyle.ordinal()] == null) {
                    RelativeDateTimeFormatter.fallbackCache[sourceStyle.ordinal()] = targetStyle;
                } else if (RelativeDateTimeFormatter.fallbackCache[sourceStyle.ordinal()] != targetStyle) {
                    throw new ICUException("Inconsistent style fallback for style " + sourceStyle + " to " + targetStyle);
                }
            }
        }

        public void put(UResource.Key key, UResource.Value value, boolean noFallback) {
            if (value.getType() != 3) {
                UResource.Table table = value.getTable();
                for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                    if (value.getType() == 3) {
                        handleAlias(key, value, noFallback);
                    } else {
                        this.style = styleFromKey(key);
                        DateTimeUnit orNullFromString = DateTimeUnit.orNullFromString(key.substring(0, key.length() - styleSuffixLength(this.style)));
                        this.unit = orNullFromString;
                        if (orNullFromString != null) {
                            consumeTimeUnit(key, value);
                        }
                    }
                }
            }
        }

        RelDateTimeDataSink() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.ibm.icu.text.RelativeDateTimeFormatter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$Style;

        static {
            int[] iArr = new int[Style.values().length];
            $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$Style = iArr;
            try {
                iArr[Style.SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$Style[Style.NARROW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[RelativeDateTimeUnit.values().length];
            $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit = iArr2;
            try {
                iArr2[RelativeDateTimeUnit.YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.QUARTER.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.WEEK.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.DAY.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.HOUR.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.MINUTE.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.SECOND.ordinal()] = 8;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.SUNDAY.ordinal()] = 9;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.MONDAY.ordinal()] = 10;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.TUESDAY.ordinal()] = 11;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.WEDNESDAY.ordinal()] = 12;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.THURSDAY.ordinal()] = 13;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.FRIDAY.ordinal()] = 14;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$RelativeDateTimeFormatter$RelativeDateTimeUnit[RelativeDateTimeUnit.SATURDAY.ordinal()] = 15;
            } catch (NoSuchFieldError e17) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static class Loader {
        private final ULocale ulocale;

        public Loader(ULocale ulocale2) {
            this.ulocale = ulocale2;
        }

        private String getDateTimePattern(ICUResourceBundle r) {
            String calType = r.getStringWithFallback("calendar/default");
            if (calType == null || calType.equals("")) {
                calType = "gregorian";
            }
            ICUResourceBundle patternsRb = r.findWithFallback("calendar/" + calType + "/DateTimePatterns");
            if (patternsRb == null && calType.equals("gregorian")) {
                patternsRb = r.findWithFallback("calendar/gregorian/DateTimePatterns");
            }
            if (patternsRb == null || patternsRb.getSize() < 9) {
                return "{1} {0}";
            }
            if (patternsRb.get(8).getType() == 8) {
                return patternsRb.get(8).getString(0);
            }
            return patternsRb.getString(8);
        }

        public RelativeDateTimeFormatterData load() {
            Style newStyle2;
            RelDateTimeDataSink sink = new RelDateTimeDataSink();
            ICUResourceBundle r = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt63b", this.ulocale);
            r.getAllItemsWithFallback("fields", sink);
            for (Style testStyle : Style.values()) {
                Style newStyle1 = RelativeDateTimeFormatter.fallbackCache[testStyle.ordinal()];
                if (newStyle1 != null && (newStyle2 = RelativeDateTimeFormatter.fallbackCache[newStyle1.ordinal()]) != null && RelativeDateTimeFormatter.fallbackCache[newStyle2.ordinal()] != null) {
                    throw new IllegalStateException("Style fallback too deep");
                }
            }
            return new RelativeDateTimeFormatterData(sink.qualitativeUnitMap, sink.styleRelUnitPatterns, getDateTimePattern(r));
        }
    }
}
