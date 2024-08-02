package com.ibm.icu.text;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.TZDBTimeZoneNames;
import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.impl.TimeZoneGenericNames;
import com.ibm.icu.impl.TimeZoneNamesImpl;
import com.ibm.icu.impl.ZoneMeta;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.settings.TxzMessage;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;

public class TimeZoneFormat extends UFormat implements Freezable<TimeZoneFormat>, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final EnumSet<TimeZoneGenericNames.GenericNameType> ALL_GENERIC_NAME_TYPES = EnumSet.of(TimeZoneGenericNames.GenericNameType.LOCATION, TimeZoneGenericNames.GenericNameType.LONG, TimeZoneGenericNames.GenericNameType.SHORT);
    private static final EnumSet<TimeZoneNames.NameType> ALL_SIMPLE_NAME_TYPES = EnumSet.of(TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT, TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.SHORT_DAYLIGHT, TimeZoneNames.NameType.EXEMPLAR_LOCATION);
    private static final String[] ALT_GMT_STRINGS = {DEFAULT_GMT_ZERO, "UTC", "UT"};
    private static final String ASCII_DIGITS = "0123456789";
    private static final String[] DEFAULT_GMT_DIGITS = {TxzMessage.TXZ_DISMISS, "1", "2", "3", "4", Id9AlsConstants.ID9ALS_SELECT_MODEL_VITALITY, Id9AlsConstants.ID9ALS_SELECT_MODEL_MYSTERIOUS, Id9AlsConstants.ID9ALS_SELECT_MODEL_STEADY, "8", "9"};
    private static final char DEFAULT_GMT_OFFSET_SEP = ':';
    private static final String DEFAULT_GMT_PATTERN = "GMT{0}";
    private static final String DEFAULT_GMT_ZERO = "GMT";
    private static final String ISO8601_UTC = "Z";
    private static final int ISO_LOCAL_STYLE_FLAG = 256;
    private static final int ISO_Z_STYLE_FLAG = 128;
    private static final int MAX_OFFSET = 86400000;
    private static final int MAX_OFFSET_HOUR = 23;
    private static final int MAX_OFFSET_MINUTE = 59;
    private static final int MAX_OFFSET_SECOND = 59;
    private static final int MILLIS_PER_HOUR = 3600000;
    private static final int MILLIS_PER_MINUTE = 60000;
    private static final int MILLIS_PER_SECOND = 1000;
    private static final GMTOffsetPatternType[] PARSE_GMT_OFFSET_TYPES = {GMTOffsetPatternType.POSITIVE_HMS, GMTOffsetPatternType.NEGATIVE_HMS, GMTOffsetPatternType.POSITIVE_HM, GMTOffsetPatternType.NEGATIVE_HM, GMTOffsetPatternType.POSITIVE_H, GMTOffsetPatternType.NEGATIVE_H};
    private static volatile TextTrieMap<String> SHORT_ZONE_ID_TRIE = null;
    private static final String TZID_GMT = "Etc/GMT";
    private static final String UNKNOWN_LOCATION = "Unknown";
    private static final int UNKNOWN_OFFSET = Integer.MAX_VALUE;
    private static final String UNKNOWN_SHORT_ZONE_ID = "unk";
    private static final String UNKNOWN_ZONE_ID = "Etc/Unknown";
    private static volatile TextTrieMap<String> ZONE_ID_TRIE = null;
    private static TimeZoneFormatCache _tzfCache = new TimeZoneFormatCache(null);
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("_locale", ULocale.class), new ObjectStreamField("_tznames", TimeZoneNames.class), new ObjectStreamField("_gmtPattern", String.class), new ObjectStreamField("_gmtOffsetPatterns", String[].class), new ObjectStreamField("_gmtOffsetDigits", String[].class), new ObjectStreamField("_gmtZeroFormat", String.class), new ObjectStreamField("_parseAllStyles", Boolean.TYPE)};
    private static final long serialVersionUID = 2281246852693575022L;
    private transient boolean _abuttingOffsetHoursAndMinutes;
    private volatile transient boolean _frozen;
    private String[] _gmtOffsetDigits;
    private transient Object[][] _gmtOffsetPatternItems;
    private String[] _gmtOffsetPatterns;
    private String _gmtPattern;
    private transient String _gmtPatternPrefix;
    private transient String _gmtPatternSuffix;
    private String _gmtZeroFormat = DEFAULT_GMT_ZERO;
    private volatile transient TimeZoneGenericNames _gnames;
    private ULocale _locale;
    private boolean _parseAllStyles;
    private boolean _parseTZDBNames;
    private transient String _region;
    private volatile transient TimeZoneNames _tzdbNames;
    private TimeZoneNames _tznames;

    /* access modifiers changed from: private */
    public enum OffsetFields {
        H,
        HM,
        HMS
    }

    public enum ParseOption {
        ALL_STYLES,
        TZ_DATABASE_ABBREVIATIONS
    }

    public enum TimeType {
        UNKNOWN,
        STANDARD,
        DAYLIGHT
    }

    public enum Style {
        GENERIC_LOCATION(1),
        GENERIC_LONG(2),
        GENERIC_SHORT(4),
        SPECIFIC_LONG(8),
        SPECIFIC_SHORT(16),
        LOCALIZED_GMT(32),
        LOCALIZED_GMT_SHORT(64),
        ISO_BASIC_SHORT(128),
        ISO_BASIC_LOCAL_SHORT(256),
        ISO_BASIC_FIXED(128),
        ISO_BASIC_LOCAL_FIXED(256),
        ISO_BASIC_FULL(128),
        ISO_BASIC_LOCAL_FULL(256),
        ISO_EXTENDED_FIXED(128),
        ISO_EXTENDED_LOCAL_FIXED(256),
        ISO_EXTENDED_FULL(128),
        ISO_EXTENDED_LOCAL_FULL(256),
        ZONE_ID(512),
        ZONE_ID_SHORT(1024),
        EXEMPLAR_LOCATION(2048);
        
        final int flag;

        private Style(int flag2) {
            this.flag = flag2;
        }
    }

    public enum GMTOffsetPatternType {
        POSITIVE_HM("+H:mm", DateFormat.HOUR24_MINUTE, true),
        POSITIVE_HMS("+H:mm:ss", DateFormat.HOUR24_MINUTE_SECOND, true),
        NEGATIVE_HM("-H:mm", DateFormat.HOUR24_MINUTE, false),
        NEGATIVE_HMS("-H:mm:ss", DateFormat.HOUR24_MINUTE_SECOND, false),
        POSITIVE_H("+H", DateFormat.HOUR24, true),
        NEGATIVE_H("-H", DateFormat.HOUR24, false);
        
        private String _defaultPattern;
        private boolean _isPositive;
        private String _required;

        private GMTOffsetPatternType(String defaultPattern, String required, boolean isPositive) {
            this._defaultPattern = defaultPattern;
            this._required = required;
            this._isPositive = isPositive;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private String defaultPattern() {
            return this._defaultPattern;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private String required() {
            return this._required;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean isPositive() {
            return this._isPositive;
        }
    }

    protected TimeZoneFormat(ULocale locale) {
        this._locale = locale;
        this._tznames = TimeZoneNames.getInstance(locale);
        String gmtPattern = null;
        String hourFormats = null;
        try {
            ICUResourceBundle bundle = ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt63b/zone", locale);
            try {
                gmtPattern = bundle.getStringWithFallback("zoneStrings/gmtFormat");
            } catch (MissingResourceException e) {
            }
            try {
                hourFormats = bundle.getStringWithFallback("zoneStrings/hourFormat");
            } catch (MissingResourceException e2) {
            }
            try {
                this._gmtZeroFormat = bundle.getStringWithFallback("zoneStrings/gmtZeroFormat");
            } catch (MissingResourceException e3) {
            }
        } catch (MissingResourceException e4) {
        }
        initGMTPattern(gmtPattern == null ? DEFAULT_GMT_PATTERN : gmtPattern);
        String[] gmtOffsetPatterns = new String[GMTOffsetPatternType.values().length];
        if (hourFormats != null) {
            String[] hourPatterns = hourFormats.split(";", 2);
            gmtOffsetPatterns[GMTOffsetPatternType.POSITIVE_H.ordinal()] = truncateOffsetPattern(hourPatterns[0]);
            gmtOffsetPatterns[GMTOffsetPatternType.POSITIVE_HM.ordinal()] = hourPatterns[0];
            gmtOffsetPatterns[GMTOffsetPatternType.POSITIVE_HMS.ordinal()] = expandOffsetPattern(hourPatterns[0]);
            gmtOffsetPatterns[GMTOffsetPatternType.NEGATIVE_H.ordinal()] = truncateOffsetPattern(hourPatterns[1]);
            gmtOffsetPatterns[GMTOffsetPatternType.NEGATIVE_HM.ordinal()] = hourPatterns[1];
            gmtOffsetPatterns[GMTOffsetPatternType.NEGATIVE_HMS.ordinal()] = expandOffsetPattern(hourPatterns[1]);
        } else {
            GMTOffsetPatternType[] values = GMTOffsetPatternType.values();
            for (GMTOffsetPatternType patType : values) {
                gmtOffsetPatterns[patType.ordinal()] = patType.defaultPattern();
            }
        }
        initGMTOffsetPatterns(gmtOffsetPatterns);
        this._gmtOffsetDigits = DEFAULT_GMT_DIGITS;
        NumberingSystem ns = NumberingSystem.getInstance(locale);
        if (!ns.isAlgorithmic()) {
            this._gmtOffsetDigits = toCodePoints(ns.getDescription());
        }
    }

    public static TimeZoneFormat getInstance(ULocale locale) {
        if (locale != null) {
            return (TimeZoneFormat) _tzfCache.getInstance(locale, locale);
        }
        throw new NullPointerException("locale is null");
    }

    public static TimeZoneFormat getInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale));
    }

    public TimeZoneNames getTimeZoneNames() {
        return this._tznames;
    }

    private TimeZoneGenericNames getTimeZoneGenericNames() {
        if (this._gnames == null) {
            synchronized (this) {
                if (this._gnames == null) {
                    this._gnames = TimeZoneGenericNames.getInstance(this._locale);
                }
            }
        }
        return this._gnames;
    }

    private TimeZoneNames getTZDBTimeZoneNames() {
        if (this._tzdbNames == null) {
            synchronized (this) {
                if (this._tzdbNames == null) {
                    this._tzdbNames = new TZDBTimeZoneNames(this._locale);
                }
            }
        }
        return this._tzdbNames;
    }

    public TimeZoneFormat setTimeZoneNames(TimeZoneNames tznames) {
        if (!isFrozen()) {
            this._tznames = tznames;
            this._gnames = new TimeZoneGenericNames(this._locale, this._tznames);
            return this;
        }
        throw new UnsupportedOperationException("Attempt to modify frozen object");
    }

    public String getGMTPattern() {
        return this._gmtPattern;
    }

    public TimeZoneFormat setGMTPattern(String pattern) {
        if (!isFrozen()) {
            initGMTPattern(pattern);
            return this;
        }
        throw new UnsupportedOperationException("Attempt to modify frozen object");
    }

    public String getGMTOffsetPattern(GMTOffsetPatternType type) {
        return this._gmtOffsetPatterns[type.ordinal()];
    }

    public TimeZoneFormat setGMTOffsetPattern(GMTOffsetPatternType type, String pattern) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify frozen object");
        } else if (pattern != null) {
            Object[] parsedItems = parseOffsetPattern(pattern, type.required());
            this._gmtOffsetPatterns[type.ordinal()] = pattern;
            this._gmtOffsetPatternItems[type.ordinal()] = parsedItems;
            checkAbuttingHoursAndMinutes();
            return this;
        } else {
            throw new NullPointerException("Null GMT offset pattern");
        }
    }

    public String getGMTOffsetDigits() {
        StringBuilder buf = new StringBuilder(this._gmtOffsetDigits.length);
        for (String digit : this._gmtOffsetDigits) {
            buf.append(digit);
        }
        return buf.toString();
    }

    public TimeZoneFormat setGMTOffsetDigits(String digits) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify frozen object");
        } else if (digits != null) {
            String[] digitArray = toCodePoints(digits);
            if (digitArray.length == 10) {
                this._gmtOffsetDigits = digitArray;
                return this;
            }
            throw new IllegalArgumentException("Length of digits must be 10");
        } else {
            throw new NullPointerException("Null GMT offset digits");
        }
    }

    public String getGMTZeroFormat() {
        return this._gmtZeroFormat;
    }

    public TimeZoneFormat setGMTZeroFormat(String gmtZeroFormat) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify frozen object");
        } else if (gmtZeroFormat == null) {
            throw new NullPointerException("Null GMT zero format");
        } else if (gmtZeroFormat.length() != 0) {
            this._gmtZeroFormat = gmtZeroFormat;
            return this;
        } else {
            throw new IllegalArgumentException("Empty GMT zero format");
        }
    }

    public TimeZoneFormat setDefaultParseOptions(EnumSet<ParseOption> options) {
        this._parseAllStyles = options.contains(ParseOption.ALL_STYLES);
        this._parseTZDBNames = options.contains(ParseOption.TZ_DATABASE_ABBREVIATIONS);
        return this;
    }

    public EnumSet<ParseOption> getDefaultParseOptions() {
        boolean z = this._parseAllStyles;
        if (z && this._parseTZDBNames) {
            return EnumSet.of(ParseOption.ALL_STYLES, ParseOption.TZ_DATABASE_ABBREVIATIONS);
        }
        if (z) {
            return EnumSet.of(ParseOption.ALL_STYLES);
        }
        if (this._parseTZDBNames) {
            return EnumSet.of(ParseOption.TZ_DATABASE_ABBREVIATIONS);
        }
        return EnumSet.noneOf(ParseOption.class);
    }

    public final String formatOffsetISO8601Basic(int offset, boolean useUtcIndicator, boolean isShort, boolean ignoreSeconds) {
        return formatOffsetISO8601(offset, true, useUtcIndicator, isShort, ignoreSeconds);
    }

    public final String formatOffsetISO8601Extended(int offset, boolean useUtcIndicator, boolean isShort, boolean ignoreSeconds) {
        return formatOffsetISO8601(offset, false, useUtcIndicator, isShort, ignoreSeconds);
    }

    public String formatOffsetLocalizedGMT(int offset) {
        return formatOffsetLocalizedGMT(offset, false);
    }

    public String formatOffsetShortLocalizedGMT(int offset) {
        return formatOffsetLocalizedGMT(offset, true);
    }

    public final String format(Style style, TimeZone tz, long date) {
        return format(style, tz, date, null);
    }

    public String format(Style style, TimeZone tz, long date, Output<TimeType> timeType) {
        String result = null;
        if (timeType != null) {
            timeType.value = TimeType.UNKNOWN;
        }
        boolean noOffsetFormatFallback = false;
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[style.ordinal()]) {
            case 1:
                result = getTimeZoneGenericNames().getGenericLocationName(ZoneMeta.getCanonicalCLDRID(tz));
                break;
            case 2:
                result = getTimeZoneGenericNames().getDisplayName(tz, TimeZoneGenericNames.GenericNameType.LONG, date);
                break;
            case 3:
                result = getTimeZoneGenericNames().getDisplayName(tz, TimeZoneGenericNames.GenericNameType.SHORT, date);
                break;
            case 4:
                result = formatSpecific(tz, TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT, date, timeType);
                break;
            case 5:
                result = formatSpecific(tz, TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.SHORT_DAYLIGHT, date, timeType);
                break;
            case 6:
                result = tz.getID();
                noOffsetFormatFallback = true;
                break;
            case 7:
                result = ZoneMeta.getShortID(tz);
                if (result == null) {
                    result = UNKNOWN_SHORT_ZONE_ID;
                }
                noOffsetFormatFallback = true;
                break;
            case 8:
                result = formatExemplarLocation(tz);
                noOffsetFormatFallback = true;
                break;
        }
        if (result == null && !noOffsetFormatFallback) {
            int[] offsets = {0, 0};
            tz.getOffset(date, false, offsets);
            int offset = offsets[0] + offsets[1];
            switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[style.ordinal()]) {
                case 1:
                case 2:
                case 4:
                case 9:
                    result = formatOffsetLocalizedGMT(offset);
                    break;
                case 3:
                case 5:
                case 10:
                    result = formatOffsetShortLocalizedGMT(offset);
                    break;
                case 6:
                case 7:
                case 8:
                default:
                    throw new AssertionError();
                case 11:
                    result = formatOffsetISO8601Basic(offset, true, true, true);
                    break;
                case 12:
                    result = formatOffsetISO8601Basic(offset, false, true, true);
                    break;
                case 13:
                    result = formatOffsetISO8601Basic(offset, true, false, true);
                    break;
                case 14:
                    result = formatOffsetISO8601Basic(offset, false, false, true);
                    break;
                case 15:
                    result = formatOffsetISO8601Basic(offset, true, false, false);
                    break;
                case 16:
                    result = formatOffsetISO8601Basic(offset, false, false, false);
                    break;
                case 17:
                    result = formatOffsetISO8601Extended(offset, true, false, true);
                    break;
                case 18:
                    result = formatOffsetISO8601Extended(offset, false, false, true);
                    break;
                case 19:
                    result = formatOffsetISO8601Extended(offset, true, false, false);
                    break;
                case 20:
                    result = formatOffsetISO8601Extended(offset, false, false, false);
                    break;
            }
            if (timeType != null) {
                timeType.value = offsets[1] != 0 ? TimeType.DAYLIGHT : TimeType.STANDARD;
            }
        }
        if (result != null) {
            return result;
        }
        throw new AssertionError();
    }

    public final int parseOffsetISO8601(String text, ParsePosition pos) {
        return parseOffsetISO8601(text, pos, false, null);
    }

    public int parseOffsetLocalizedGMT(String text, ParsePosition pos) {
        return parseOffsetLocalizedGMT(text, pos, false, null);
    }

    public int parseOffsetShortLocalizedGMT(String text, ParsePosition pos) {
        return parseOffsetLocalizedGMT(text, pos, true, null);
    }

    /* JADX INFO: Multiple debug info for r10v12 com.ibm.icu.text.TimeZoneFormat$TimeType: [D('parsedTimeType' com.ibm.icu.text.TimeZoneFormat$TimeType), D('parsedID' java.lang.String)] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03d3  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x058b  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0591  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x05ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ibm.icu.util.TimeZone parse(com.ibm.icu.text.TimeZoneFormat.Style r25, java.lang.String r26, java.text.ParsePosition r27, java.util.EnumSet<com.ibm.icu.text.TimeZoneFormat.ParseOption> r28, com.ibm.icu.util.Output<com.ibm.icu.text.TimeZoneFormat.TimeType> r29) {
        /*
        // Method dump skipped, instructions count: 1526
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.TimeZoneFormat.parse(com.ibm.icu.text.TimeZoneFormat$Style, java.lang.String, java.text.ParsePosition, java.util.EnumSet, com.ibm.icu.util.Output):com.ibm.icu.util.TimeZone");
    }

    public TimeZone parse(Style style, String text, ParsePosition pos, Output<TimeType> timeType) {
        return parse(style, text, pos, null, timeType);
    }

    public final TimeZone parse(String text, ParsePosition pos) {
        return parse(Style.GENERIC_LOCATION, text, pos, EnumSet.of(ParseOption.ALL_STYLES), null);
    }

    public final TimeZone parse(String text) throws ParseException {
        ParsePosition pos = new ParsePosition(0);
        TimeZone tz = parse(text, pos);
        if (pos.getErrorIndex() >= 0) {
            throw new ParseException("Unparseable time zone: \"" + text + "\"", 0);
        } else if (tz != null) {
            return tz;
        } else {
            throw new AssertionError();
        }
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        TimeZone tz;
        long date = System.currentTimeMillis();
        if (obj instanceof TimeZone) {
            tz = (TimeZone) obj;
        } else if (obj instanceof Calendar) {
            tz = ((Calendar) obj).getTimeZone();
            date = ((Calendar) obj).getTimeInMillis();
        } else {
            throw new IllegalArgumentException("Cannot format given Object (" + obj.getClass().getName() + ") as a time zone");
        }
        if (tz != null) {
            String result = formatOffsetLocalizedGMT(tz.getOffset(date));
            toAppendTo.append(result);
            if (pos.getFieldAttribute() == DateFormat.Field.TIME_ZONE || pos.getField() == 17) {
                pos.setBeginIndex(0);
                pos.setEndIndex(result.length());
            }
            return toAppendTo;
        }
        throw new AssertionError();
    }

    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        AttributedString as = new AttributedString(format(obj, new StringBuffer(), new FieldPosition(0)).toString());
        as.addAttribute(DateFormat.Field.TIME_ZONE, DateFormat.Field.TIME_ZONE);
        return as.getIterator();
    }

    public Object parseObject(String source, ParsePosition pos) {
        return parse(source, pos);
    }

    private String formatOffsetLocalizedGMT(int offset, boolean isShort) {
        Object[] offsetPatternItems;
        if (offset == 0) {
            return this._gmtZeroFormat;
        }
        StringBuilder buf = new StringBuilder();
        boolean positive = true;
        if (offset < 0) {
            offset = -offset;
            positive = false;
        }
        int offsetH = offset / 3600000;
        int offset2 = offset % 3600000;
        int offsetM = offset2 / 60000;
        int offset3 = offset2 % 60000;
        int offsetS = offset3 / 1000;
        if (offsetH > 23 || offsetM > 59 || offsetS > 59) {
            throw new IllegalArgumentException("Offset out of range :" + offset3);
        }
        if (positive) {
            if (offsetS != 0) {
                offsetPatternItems = this._gmtOffsetPatternItems[GMTOffsetPatternType.POSITIVE_HMS.ordinal()];
            } else if (offsetM != 0 || !isShort) {
                offsetPatternItems = this._gmtOffsetPatternItems[GMTOffsetPatternType.POSITIVE_HM.ordinal()];
            } else {
                offsetPatternItems = this._gmtOffsetPatternItems[GMTOffsetPatternType.POSITIVE_H.ordinal()];
            }
        } else if (offsetS != 0) {
            offsetPatternItems = this._gmtOffsetPatternItems[GMTOffsetPatternType.NEGATIVE_HMS.ordinal()];
        } else if (offsetM != 0 || !isShort) {
            offsetPatternItems = this._gmtOffsetPatternItems[GMTOffsetPatternType.NEGATIVE_HM.ordinal()];
        } else {
            offsetPatternItems = this._gmtOffsetPatternItems[GMTOffsetPatternType.NEGATIVE_H.ordinal()];
        }
        buf.append(this._gmtPatternPrefix);
        for (Object item : offsetPatternItems) {
            if (item instanceof String) {
                buf.append((String) item);
            } else if (item instanceof GMTOffsetField) {
                int i = 2;
                switch (((GMTOffsetField) item).getType()) {
                    case 'H':
                        if (isShort) {
                            i = 1;
                        }
                        appendOffsetDigits(buf, offsetH, i);
                        continue;
                    case 'm':
                        appendOffsetDigits(buf, offsetM, 2);
                        continue;
                    case 's':
                        appendOffsetDigits(buf, offsetS, 2);
                        continue;
                }
            }
        }
        buf.append(this._gmtPatternSuffix);
        return buf.toString();
    }

    private String formatOffsetISO8601(int offset, boolean isBasic, boolean useUtcIndicator, boolean isShort, boolean ignoreSeconds) {
        int absOffset = offset < 0 ? -offset : offset;
        if (useUtcIndicator) {
            if (absOffset < 1000) {
                return ISO8601_UTC;
            }
            if (ignoreSeconds && absOffset < 60000) {
                return ISO8601_UTC;
            }
        }
        OffsetFields minFields = isShort ? OffsetFields.H : OffsetFields.HM;
        OffsetFields maxFields = ignoreSeconds ? OffsetFields.HM : OffsetFields.HMS;
        Character sep = isBasic ? null : Character.valueOf(DEFAULT_GMT_OFFSET_SEP);
        if (absOffset < 86400000) {
            int absOffset2 = absOffset % 3600000;
            int[] fields = {absOffset / 3600000, absOffset2 / 60000, (absOffset2 % 60000) / 1000};
            if (fields[0] < 0 || fields[0] > 23) {
                throw new AssertionError();
            } else if (fields[1] < 0 || fields[1] > 59) {
                throw new AssertionError();
            } else if (fields[2] < 0 || fields[2] > 59) {
                throw new AssertionError();
            } else {
                int lastIdx = maxFields.ordinal();
                while (lastIdx > minFields.ordinal() && fields[lastIdx] == 0) {
                    lastIdx--;
                }
                StringBuilder buf = new StringBuilder();
                char sign = '+';
                if (offset < 0) {
                    int idx = 0;
                    while (true) {
                        if (idx > lastIdx) {
                            break;
                        } else if (fields[idx] != 0) {
                            sign = '-';
                            break;
                        } else {
                            idx++;
                        }
                    }
                }
                buf.append(sign);
                for (int idx2 = 0; idx2 <= lastIdx; idx2++) {
                    if (!(sep == null || idx2 == 0)) {
                        buf.append(sep);
                    }
                    if (fields[idx2] < 10) {
                        buf.append('0');
                    }
                    buf.append(fields[idx2]);
                }
                return buf.toString();
            }
        } else {
            throw new IllegalArgumentException("Offset out of range :" + offset);
        }
    }

    private String formatSpecific(TimeZone tz, TimeZoneNames.NameType stdType, TimeZoneNames.NameType dstType, long date, Output<TimeType> timeType) {
        String name;
        if (stdType != TimeZoneNames.NameType.LONG_STANDARD && stdType != TimeZoneNames.NameType.SHORT_STANDARD) {
            throw new AssertionError();
        } else if (dstType == TimeZoneNames.NameType.LONG_DAYLIGHT || dstType == TimeZoneNames.NameType.SHORT_DAYLIGHT) {
            boolean isDaylight = tz.inDaylightTime(new Date(date));
            if (isDaylight) {
                name = getTimeZoneNames().getDisplayName(ZoneMeta.getCanonicalCLDRID(tz), dstType, date);
            } else {
                name = getTimeZoneNames().getDisplayName(ZoneMeta.getCanonicalCLDRID(tz), stdType, date);
            }
            if (!(name == null || timeType == null)) {
                timeType.value = isDaylight ? TimeType.DAYLIGHT : TimeType.STANDARD;
            }
            return name;
        } else {
            throw new AssertionError();
        }
    }

    private String formatExemplarLocation(TimeZone tz) {
        String location = getTimeZoneNames().getExemplarLocationName(ZoneMeta.getCanonicalCLDRID(tz));
        if (location != null) {
            return location;
        }
        String location2 = getTimeZoneNames().getExemplarLocationName(UNKNOWN_ZONE_ID);
        if (location2 == null) {
            return UNKNOWN_LOCATION;
        }
        return location2;
    }

    private String getTimeZoneID(String tzID, String mzID) {
        String id = tzID;
        if (id == null) {
            if (mzID != null) {
                id = this._tznames.getReferenceZoneID(mzID, getTargetRegion());
                if (id == null) {
                    throw new IllegalArgumentException("Invalid mzID: " + mzID);
                }
            } else {
                throw new AssertionError();
            }
        }
        return id;
    }

    private synchronized String getTargetRegion() {
        if (this._region == null) {
            String country = this._locale.getCountry();
            this._region = country;
            if (country.length() == 0) {
                String country2 = ULocale.addLikelySubtags(this._locale).getCountry();
                this._region = country2;
                if (country2.length() == 0) {
                    this._region = "001";
                }
            }
        }
        return this._region;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.ibm.icu.text.TimeZoneFormat$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType;

        static {
            int[] iArr = new int[TimeZoneNames.NameType.values().length];
            $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType = iArr;
            try {
                iArr[TimeZoneNames.NameType.LONG_STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.SHORT_STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.LONG_DAYLIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[TimeZoneNames.NameType.SHORT_DAYLIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[Style.values().length];
            $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style = iArr2;
            try {
                iArr2[Style.GENERIC_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.GENERIC_LONG.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.GENERIC_SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.SPECIFIC_LONG.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.SPECIFIC_SHORT.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ZONE_ID.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ZONE_ID_SHORT.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.EXEMPLAR_LOCATION.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.LOCALIZED_GMT.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.LOCALIZED_GMT_SHORT.ordinal()] = 10;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_SHORT.ordinal()] = 11;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_LOCAL_SHORT.ordinal()] = 12;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_FIXED.ordinal()] = 13;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_LOCAL_FIXED.ordinal()] = 14;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_FULL.ordinal()] = 15;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_BASIC_LOCAL_FULL.ordinal()] = 16;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_EXTENDED_FIXED.ordinal()] = 17;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_EXTENDED_LOCAL_FIXED.ordinal()] = 18;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_EXTENDED_FULL.ordinal()] = 19;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$TimeZoneFormat$Style[Style.ISO_EXTENDED_LOCAL_FULL.ordinal()] = 20;
            } catch (NoSuchFieldError e24) {
            }
        }
    }

    private TimeType getTimeType(TimeZoneNames.NameType nameType) {
        switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$TimeZoneNames$NameType[nameType.ordinal()]) {
            case 1:
            case 2:
                return TimeType.STANDARD;
            case 3:
            case 4:
                return TimeType.DAYLIGHT;
            default:
                return TimeType.UNKNOWN;
        }
    }

    private void initGMTPattern(String gmtPattern) {
        int idx = gmtPattern.indexOf("{0}");
        if (idx >= 0) {
            this._gmtPattern = gmtPattern;
            this._gmtPatternPrefix = unquote(gmtPattern.substring(0, idx));
            this._gmtPatternSuffix = unquote(gmtPattern.substring(idx + 3));
            return;
        }
        throw new IllegalArgumentException("Bad localized GMT pattern: " + gmtPattern);
    }

    private static String unquote(String s) {
        if (s.indexOf(39) < 0) {
            return s;
        }
        boolean isPrevQuote = false;
        boolean inQuote = false;
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\'') {
                if (isPrevQuote) {
                    buf.append(c);
                    isPrevQuote = false;
                } else {
                    isPrevQuote = true;
                }
                inQuote = !inQuote;
            } else {
                isPrevQuote = false;
                buf.append(c);
            }
        }
        return buf.toString();
    }

    private void initGMTOffsetPatterns(String[] gmtOffsetPatterns) {
        int size = GMTOffsetPatternType.values().length;
        if (gmtOffsetPatterns.length >= size) {
            Object[][] gmtOffsetPatternItems = new Object[size][];
            GMTOffsetPatternType[] values = GMTOffsetPatternType.values();
            for (GMTOffsetPatternType t : values) {
                int idx = t.ordinal();
                gmtOffsetPatternItems[idx] = parseOffsetPattern(gmtOffsetPatterns[idx], t.required());
            }
            String[] strArr = new String[size];
            this._gmtOffsetPatterns = strArr;
            System.arraycopy(gmtOffsetPatterns, 0, strArr, 0, size);
            this._gmtOffsetPatternItems = gmtOffsetPatternItems;
            checkAbuttingHoursAndMinutes();
            return;
        }
        throw new IllegalArgumentException("Insufficient number of elements in gmtOffsetPatterns");
    }

    private void checkAbuttingHoursAndMinutes() {
        this._abuttingOffsetHoursAndMinutes = false;
        Object[][] objArr = this._gmtOffsetPatternItems;
        for (Object[] items : objArr) {
            boolean afterH = false;
            for (Object item : items) {
                if (item instanceof GMTOffsetField) {
                    GMTOffsetField fld = (GMTOffsetField) item;
                    if (afterH) {
                        this._abuttingOffsetHoursAndMinutes = true;
                    } else if (fld.getType() == 'H') {
                        afterH = true;
                    }
                } else if (afterH) {
                    break;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static class GMTOffsetField {
        final char _type;
        final int _width;

        GMTOffsetField(char type, int width) {
            this._type = type;
            this._width = width;
        }

        /* access modifiers changed from: package-private */
        public char getType() {
            return this._type;
        }

        /* access modifiers changed from: package-private */
        public int getWidth() {
            return this._width;
        }

        static boolean isValid(char type, int width) {
            return width == 1 || width == 2;
        }
    }

    private static Object[] parseOffsetPattern(String pattern, String letters) {
        boolean isPrevQuote = false;
        boolean inQuote = false;
        StringBuilder text = new StringBuilder();
        char itemType = 0;
        int itemLength = 1;
        boolean invalidPattern = false;
        List<Object> items = new ArrayList<>();
        BitSet checkBits = new BitSet(letters.length());
        int i = 0;
        while (true) {
            boolean z = false;
            if (i >= pattern.length()) {
                break;
            }
            char ch = pattern.charAt(i);
            if (ch == '\'') {
                if (!isPrevQuote) {
                    isPrevQuote = true;
                    if (itemType != 0) {
                        if (!GMTOffsetField.isValid(itemType, itemLength)) {
                            invalidPattern = true;
                            break;
                        }
                        items.add(new GMTOffsetField(itemType, itemLength));
                        itemType = 0;
                    }
                } else {
                    text.append('\'');
                    isPrevQuote = false;
                }
                if (!inQuote) {
                    z = true;
                }
                inQuote = z;
            } else {
                isPrevQuote = false;
                if (inQuote) {
                    text.append(ch);
                } else {
                    int patFieldIdx = letters.indexOf(ch);
                    if (patFieldIdx < 0) {
                        if (itemType != 0) {
                            if (!GMTOffsetField.isValid(itemType, itemLength)) {
                                invalidPattern = true;
                                break;
                            }
                            items.add(new GMTOffsetField(itemType, itemLength));
                            itemType = 0;
                        }
                        text.append(ch);
                    } else if (ch == itemType) {
                        itemLength++;
                    } else {
                        if (itemType != 0) {
                            if (!GMTOffsetField.isValid(itemType, itemLength)) {
                                invalidPattern = true;
                                break;
                            }
                            items.add(new GMTOffsetField(itemType, itemLength));
                        } else if (text.length() > 0) {
                            items.add(text.toString());
                            text.setLength(0);
                        }
                        itemType = ch;
                        itemLength = 1;
                        checkBits.set(patFieldIdx);
                    }
                }
            }
            i++;
        }
        if (!invalidPattern) {
            if (itemType == 0) {
                if (text.length() > 0) {
                    items.add(text.toString());
                    text.setLength(0);
                }
            } else if (GMTOffsetField.isValid(itemType, itemLength)) {
                items.add(new GMTOffsetField(itemType, itemLength));
            } else {
                invalidPattern = true;
            }
        }
        if (!invalidPattern && checkBits.cardinality() == letters.length()) {
            return items.toArray(new Object[items.size()]);
        }
        throw new IllegalStateException("Bad localized GMT offset pattern: " + pattern);
    }

    private static String expandOffsetPattern(String offsetHM) {
        int idx_mm = offsetHM.indexOf("mm");
        if (idx_mm >= 0) {
            String sep = ":";
            int idx_H = offsetHM.substring(0, idx_mm).lastIndexOf(DateFormat.HOUR24);
            if (idx_H >= 0) {
                sep = offsetHM.substring(idx_H + 1, idx_mm);
            }
            return offsetHM.substring(0, idx_mm + 2) + sep + "ss" + offsetHM.substring(idx_mm + 2);
        }
        throw new RuntimeException("Bad time zone hour pattern data");
    }

    private static String truncateOffsetPattern(String offsetHM) {
        int idx_mm = offsetHM.indexOf("mm");
        if (idx_mm >= 0) {
            int idx_HH = offsetHM.substring(0, idx_mm).lastIndexOf("HH");
            if (idx_HH >= 0) {
                return offsetHM.substring(0, idx_HH + 2);
            }
            int idx_H = offsetHM.substring(0, idx_mm).lastIndexOf(DateFormat.HOUR24);
            if (idx_H >= 0) {
                return offsetHM.substring(0, idx_H + 1);
            }
            throw new RuntimeException("Bad time zone hour pattern data");
        }
        throw new RuntimeException("Bad time zone hour pattern data");
    }

    private void appendOffsetDigits(StringBuilder buf, int n, int minDigits) {
        if (n < 0 || n >= 60) {
            throw new AssertionError();
        }
        int numDigits = n >= 10 ? 2 : 1;
        for (int i = 0; i < minDigits - numDigits; i++) {
            buf.append(this._gmtOffsetDigits[0]);
        }
        if (numDigits == 2) {
            buf.append(this._gmtOffsetDigits[n / 10]);
        }
        buf.append(this._gmtOffsetDigits[n % 10]);
    }

    private TimeZone getTimeZoneForOffset(int offset) {
        if (offset == 0) {
            return TimeZone.getTimeZone(TZID_GMT);
        }
        return ZoneMeta.getCustomTimeZone(offset);
    }

    private int parseOffsetLocalizedGMT(String text, ParsePosition pos, boolean isShort, Output<Boolean> hasDigitOffset) {
        int start = pos.getIndex();
        int[] parsedLength = {0};
        if (hasDigitOffset != null) {
            hasDigitOffset.value = false;
        }
        int offset = parseOffsetLocalizedGMTPattern(text, start, isShort, parsedLength);
        if (parsedLength[0] > 0) {
            if (hasDigitOffset != null) {
                hasDigitOffset.value = true;
            }
            pos.setIndex(parsedLength[0] + start);
            return offset;
        }
        int offset2 = parseOffsetDefaultLocalizedGMT(text, start, parsedLength);
        if (parsedLength[0] > 0) {
            if (hasDigitOffset != null) {
                hasDigitOffset.value = true;
            }
            pos.setIndex(parsedLength[0] + start);
            return offset2;
        }
        String str = this._gmtZeroFormat;
        if (text.regionMatches(true, start, str, 0, str.length())) {
            pos.setIndex(this._gmtZeroFormat.length() + start);
            return 0;
        }
        String[] strArr = ALT_GMT_STRINGS;
        int i = 0;
        for (int length = strArr.length; i < length; length = length) {
            String defGMTZero = strArr[i];
            if (text.regionMatches(true, start, defGMTZero, 0, defGMTZero.length())) {
                pos.setIndex(defGMTZero.length() + start);
                return 0;
            }
            i++;
        }
        pos.setErrorIndex(start);
        return 0;
    }

    private int parseOffsetLocalizedGMTPattern(String text, int start, boolean isShort, int[] parsedLen) {
        int idx = start;
        int offset = 0;
        boolean parsed = false;
        int len = this._gmtPatternPrefix.length();
        if (len <= 0 || text.regionMatches(true, idx, this._gmtPatternPrefix, 0, len)) {
            idx += len;
            int[] offsetLen = new int[1];
            offset = parseOffsetFields(text, idx, false, offsetLen);
            if (offsetLen[0] != 0) {
                idx += offsetLen[0];
                int len2 = this._gmtPatternSuffix.length();
                if (len2 <= 0 || text.regionMatches(true, idx, this._gmtPatternSuffix, 0, len2)) {
                    idx += len2;
                    parsed = true;
                }
            }
        }
        parsedLen[0] = parsed ? idx - start : 0;
        return offset;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseOffsetFields(java.lang.String r27, int r28, boolean r29, int[] r30) {
        /*
        // Method dump skipped, instructions count: 242
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.TimeZoneFormat.parseOffsetFields(java.lang.String, int, boolean, int[]):int");
    }

    private int parseOffsetFieldsWithPattern(String text, int start, Object[] patternItems, boolean forceSingleHourDigit, int[] fields) {
        int i;
        if (fields == null || fields.length < 3) {
            throw new AssertionError();
        }
        int i2 = 2;
        fields[2] = 0;
        fields[1] = 0;
        fields[0] = 0;
        boolean failed = false;
        int offsetS = 0;
        int offsetM = 0;
        int offsetH = 0;
        int idx = start;
        int[] tmpParsedLen = {0};
        int i3 = 0;
        while (true) {
            if (i3 >= patternItems.length) {
                break;
            }
            if (patternItems[i3] instanceof String) {
                String patStr = (String) patternItems[i3];
                int len = patStr.length();
                int patIdx = 0;
                if (i3 == 0) {
                    if (idx < text.length()) {
                        if (!PatternProps.isWhiteSpace(text.codePointAt(idx))) {
                            while (len > 0) {
                                int cp = patStr.codePointAt(patIdx);
                                if (!PatternProps.isWhiteSpace(cp)) {
                                    break;
                                }
                                int cpLen = Character.charCount(cp);
                                len -= cpLen;
                                patIdx += cpLen;
                            }
                        }
                    }
                }
                i = i3;
                if (!text.regionMatches(true, idx, patStr, patIdx, len)) {
                    failed = true;
                    break;
                }
                idx += len;
            } else {
                i = i3;
                if (patternItems[i] instanceof GMTOffsetField) {
                    char fieldType = ((GMTOffsetField) patternItems[i]).getType();
                    if (fieldType == 'H') {
                        offsetH = parseOffsetFieldWithLocalizedDigits(text, idx, 1, forceSingleHourDigit ? 1 : i2, 0, 23, tmpParsedLen);
                    } else if (fieldType == 'm') {
                        offsetM = parseOffsetFieldWithLocalizedDigits(text, idx, 2, 2, 0, 59, tmpParsedLen);
                    } else if (fieldType == 's') {
                        offsetS = parseOffsetFieldWithLocalizedDigits(text, idx, 2, 2, 0, 59, tmpParsedLen);
                    }
                    if (tmpParsedLen[0] == 0) {
                        failed = true;
                        break;
                    }
                    idx += tmpParsedLen[0];
                } else {
                    throw new AssertionError();
                }
            }
            i3 = i + 1;
            i2 = 2;
        }
        if (failed) {
            return 0;
        }
        fields[0] = offsetH;
        fields[1] = offsetM;
        fields[2] = offsetS;
        return idx - start;
    }

    /* JADX INFO: Multiple debug info for r3v2 int[]: [D('offset' int), D('lenAbut' int[])] */
    private int parseOffsetDefaultLocalizedGMT(String text, int start, int[] parsedLen) {
        int sign;
        int idx;
        int offset = 0;
        int parsed = 0;
        int gmtLen = 0;
        String[] strArr = ALT_GMT_STRINGS;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String gmt = strArr[i];
            int len = gmt.length();
            if (text.regionMatches(true, start, gmt, 0, len)) {
                gmtLen = len;
                break;
            }
            i++;
        }
        if (gmtLen != 0) {
            int idx2 = start + gmtLen;
            if (idx2 + 1 < text.length()) {
                char c = text.charAt(idx2);
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                }
                int idx3 = idx2 + 1;
                int[] lenWithSep = {0};
                int offsetWithSep = parseDefaultOffsetFields(text, idx3, DEFAULT_GMT_OFFSET_SEP, lenWithSep);
                if (lenWithSep[0] == text.length() - idx3) {
                    idx = idx3 + lenWithSep[0];
                    offset = offsetWithSep * sign;
                } else {
                    int[] lenAbut = {0};
                    int offsetAbut = parseAbuttingOffsetFields(text, idx3, lenAbut);
                    if (lenWithSep[0] > lenAbut[0]) {
                        offset = offsetWithSep * sign;
                        idx = idx3 + lenWithSep[0];
                    } else {
                        offset = offsetAbut * sign;
                        idx = idx3 + lenAbut[0];
                    }
                }
                parsed = idx - start;
            }
        }
        parsedLen[0] = parsed;
        return offset;
    }

    private int parseDefaultOffsetFields(String text, int start, char separator, int[] parsedLen) {
        int sec;
        int max = text.length();
        int idx = start;
        int[] len = {0};
        int min = 0;
        int hour = parseOffsetFieldWithLocalizedDigits(text, idx, 1, 2, 0, 23, len);
        if (len[0] == 0) {
            sec = 0;
        } else {
            idx += len[0];
            if (idx + 1 < max && text.charAt(idx) == separator) {
                min = parseOffsetFieldWithLocalizedDigits(text, idx + 1, 2, 2, 0, 59, len);
                if (len[0] == 0) {
                    sec = 0;
                } else {
                    idx += len[0] + 1;
                    if (idx + 1 < max && text.charAt(idx) == separator) {
                        int sec2 = parseOffsetFieldWithLocalizedDigits(text, idx + 1, 2, 2, 0, 59, len);
                        if (len[0] == 0) {
                            sec = sec2;
                        } else {
                            idx += len[0] + 1;
                            sec = sec2;
                        }
                    }
                }
            }
            sec = 0;
        }
        if (idx == start) {
            parsedLen[0] = 0;
            return 0;
        }
        parsedLen[0] = idx - start;
        return (3600000 * hour) + (60000 * min) + (sec * 1000);
    }

    private int parseAbuttingOffsetFields(String text, int start, int[] parsedLen) {
        int[] digits = new int[6];
        int[] parsed = new int[6];
        int idx = start;
        int[] len = {0};
        int numDigits = 0;
        int i = 0;
        while (true) {
            if (i >= 6) {
                break;
            }
            digits[i] = parseSingleLocalizedDigit(text, idx, len);
            if (digits[i] < 0) {
                break;
            }
            idx += len[0];
            parsed[i] = idx - start;
            numDigits++;
            i++;
        }
        if (numDigits == 0) {
            parsedLen[0] = 0;
            return 0;
        }
        while (numDigits > 0) {
            int hour = 0;
            int min = 0;
            int sec = 0;
            if (numDigits <= 0 || numDigits > 6) {
                throw new AssertionError();
            }
            switch (numDigits) {
                case 1:
                    hour = digits[0];
                    break;
                case 2:
                    hour = (digits[0] * 10) + digits[1];
                    break;
                case 3:
                    hour = digits[0];
                    min = (digits[1] * 10) + digits[2];
                    break;
                case 4:
                    hour = (digits[0] * 10) + digits[1];
                    min = (digits[2] * 10) + digits[3];
                    break;
                case 5:
                    hour = digits[0];
                    min = (digits[1] * 10) + digits[2];
                    sec = (digits[3] * 10) + digits[4];
                    break;
                case 6:
                    hour = (digits[0] * 10) + digits[1];
                    min = (digits[2] * 10) + digits[3];
                    sec = (digits[4] * 10) + digits[5];
                    break;
            }
            if (hour > 23 || min > 59 || sec > 59) {
                numDigits--;
            } else {
                int offset = (3600000 * hour) + (60000 * min) + (sec * 1000);
                parsedLen[0] = parsed[numDigits - 1];
                return offset;
            }
        }
        return 0;
    }

    private int parseOffsetFieldWithLocalizedDigits(String text, int start, int minDigits, int maxDigits, int minVal, int maxVal, int[] parsedLen) {
        int tmpVal;
        parsedLen[0] = 0;
        int decVal = 0;
        int numDigits = 0;
        int idx = start;
        int[] digitLen = {0};
        while (idx < text.length() && numDigits < maxDigits && (digit = parseSingleLocalizedDigit(text, idx, digitLen)) >= 0 && (tmpVal = (decVal * 10) + digit) <= maxVal) {
            decVal = tmpVal;
            numDigits++;
            idx += digitLen[0];
        }
        if (numDigits < minDigits || decVal < minVal) {
            return -1;
        }
        parsedLen[0] = idx - start;
        return decVal;
    }

    private int parseSingleLocalizedDigit(String text, int start, int[] len) {
        int digit = -1;
        len[0] = 0;
        if (start < text.length()) {
            int cp = Character.codePointAt(text, start);
            int i = 0;
            while (true) {
                String[] strArr = this._gmtOffsetDigits;
                if (i >= strArr.length) {
                    break;
                } else if (cp == strArr[i].codePointAt(0)) {
                    digit = i;
                    break;
                } else {
                    i++;
                }
            }
            if (digit < 0) {
                digit = UCharacter.digit(cp);
            }
            if (digit >= 0) {
                len[0] = Character.charCount(cp);
            }
        }
        return digit;
    }

    private static String[] toCodePoints(String str) {
        int len = str.codePointCount(0, str.length());
        String[] codePoints = new String[len];
        int offset = 0;
        for (int i = 0; i < len; i++) {
            int codeLen = Character.charCount(str.codePointAt(offset));
            codePoints[i] = str.substring(offset, offset + codeLen);
            offset += codeLen;
        }
        return codePoints;
    }

    private static int parseOffsetISO8601(String text, ParsePosition pos, boolean extendedOnly, Output<Boolean> hasDigitOffset) {
        int sign;
        if (hasDigitOffset != null) {
            hasDigitOffset.value = false;
        }
        int start = pos.getIndex();
        if (start >= text.length()) {
            pos.setErrorIndex(start);
            return 0;
        }
        char firstChar = text.charAt(start);
        if (Character.toUpperCase(firstChar) == ISO8601_UTC.charAt(0)) {
            pos.setIndex(start + 1);
            return 0;
        }
        if (firstChar == '+') {
            sign = 1;
        } else if (firstChar == '-') {
            sign = -1;
        } else {
            pos.setErrorIndex(start);
            return 0;
        }
        ParsePosition posOffset = new ParsePosition(start + 1);
        int offset = parseAsciiOffsetFields(text, posOffset, DEFAULT_GMT_OFFSET_SEP, OffsetFields.H, OffsetFields.HMS);
        if (posOffset.getErrorIndex() == -1 && !extendedOnly && posOffset.getIndex() - start <= 3) {
            ParsePosition posBasic = new ParsePosition(start + 1);
            int tmpOffset = parseAbuttingAsciiOffsetFields(text, posBasic, OffsetFields.H, OffsetFields.HMS, false);
            if (posBasic.getErrorIndex() == -1 && posBasic.getIndex() > posOffset.getIndex()) {
                offset = tmpOffset;
                posOffset.setIndex(posBasic.getIndex());
            }
        }
        if (posOffset.getErrorIndex() != -1) {
            pos.setErrorIndex(start);
            return 0;
        }
        pos.setIndex(posOffset.getIndex());
        if (hasDigitOffset != null) {
            hasDigitOffset.value = true;
        }
        return sign * offset;
    }

    private static int parseAbuttingAsciiOffsetFields(String text, ParsePosition pos, OffsetFields minFields, OffsetFields maxFields, boolean fixedHourWidth) {
        int start = pos.getIndex();
        int minDigits = ((minFields.ordinal() + 1) * 2) - (!fixedHourWidth ? 1 : 0);
        int[] digits = new int[((maxFields.ordinal() + 1) * 2)];
        int numDigits = 0;
        int idx = start;
        while (true) {
            if (numDigits < digits.length && idx < text.length()) {
                int digit = ASCII_DIGITS.indexOf(text.charAt(idx));
                if (digit < 0) {
                    break;
                }
                digits[numDigits] = digit;
                numDigits++;
                idx++;
            }
        }
        if (fixedHourWidth && (numDigits & 1) != 0) {
            numDigits--;
        }
        if (numDigits < minDigits) {
            pos.setErrorIndex(start);
            return 0;
        }
        int hour = 0;
        int min = 0;
        int sec = 0;
        boolean bParsed = false;
        while (true) {
            if (numDigits >= minDigits) {
                switch (numDigits) {
                    case 1:
                        hour = digits[0];
                        break;
                    case 2:
                        hour = (digits[0] * 10) + digits[1];
                        break;
                    case 3:
                        hour = digits[0];
                        min = (digits[1] * 10) + digits[2];
                        break;
                    case 4:
                        hour = (digits[0] * 10) + digits[1];
                        min = (digits[2] * 10) + digits[3];
                        break;
                    case 5:
                        hour = digits[0];
                        min = (digits[1] * 10) + digits[2];
                        sec = (digits[3] * 10) + digits[4];
                        break;
                    case 6:
                        hour = (digits[0] * 10) + digits[1];
                        min = (digits[2] * 10) + digits[3];
                        sec = (digits[4] * 10) + digits[5];
                        break;
                }
                if (hour > 23 || min > 59 || sec > 59) {
                    numDigits -= fixedHourWidth ? 2 : 1;
                    sec = 0;
                    min = 0;
                    hour = 0;
                } else {
                    bParsed = true;
                }
            }
        }
        if (!bParsed) {
            pos.setErrorIndex(start);
            return 0;
        }
        pos.setIndex(start + numDigits);
        return ((((hour * 60) + min) * 60) + sec) * 1000;
    }

    private static int parseAsciiOffsetFields(String text, ParsePosition pos, char sep, OffsetFields minFields, OffsetFields maxFields) {
        int digit;
        int start = pos.getIndex();
        int[] fieldVal = {0, 0, 0};
        int[] fieldLen = {0, -1, -1};
        int idx = start;
        int fieldIdx = 0;
        while (true) {
            if (idx < text.length() && fieldIdx <= maxFields.ordinal()) {
                char c = text.charAt(idx);
                if (c != sep) {
                    if (fieldLen[fieldIdx] == -1 || (digit = ASCII_DIGITS.indexOf(c)) < 0) {
                        break;
                    }
                    fieldVal[fieldIdx] = (fieldVal[fieldIdx] * 10) + digit;
                    fieldLen[fieldIdx] = fieldLen[fieldIdx] + 1;
                    if (fieldLen[fieldIdx] >= 2) {
                        fieldIdx++;
                    }
                } else if (fieldIdx == 0) {
                    if (fieldLen[0] == 0) {
                        break;
                    }
                    fieldIdx++;
                } else if (fieldLen[fieldIdx] != -1) {
                    break;
                } else {
                    fieldLen[fieldIdx] = 0;
                }
                idx++;
            }
        }
        int offset = 0;
        int parsedLen = 0;
        OffsetFields parsedFields = null;
        if (fieldLen[0] != 0) {
            if (fieldVal[0] > 23) {
                offset = (fieldVal[0] / 10) * 3600000;
                parsedFields = OffsetFields.H;
                parsedLen = 1;
            } else {
                offset = fieldVal[0] * 3600000;
                parsedLen = fieldLen[0];
                parsedFields = OffsetFields.H;
                if (fieldLen[1] == 2 && fieldVal[1] <= 59) {
                    offset += fieldVal[1] * 60000;
                    parsedLen += fieldLen[1] + 1;
                    parsedFields = OffsetFields.HM;
                    if (fieldLen[2] == 2 && fieldVal[2] <= 59) {
                        offset += fieldVal[2] * 1000;
                        parsedLen += fieldLen[2] + 1;
                        parsedFields = OffsetFields.HMS;
                    }
                }
            }
        }
        if (parsedFields == null || parsedFields.ordinal() < minFields.ordinal()) {
            pos.setErrorIndex(start);
            return 0;
        }
        pos.setIndex(start + parsedLen);
        return offset;
    }

    private static String parseZoneID(String text, ParsePosition pos) {
        if (ZONE_ID_TRIE == null) {
            synchronized (TimeZoneFormat.class) {
                if (ZONE_ID_TRIE == null) {
                    TextTrieMap<String> trie = new TextTrieMap<>(true);
                    String[] ids = TimeZone.getAvailableIDs();
                    for (String id : ids) {
                        trie.put(id, id);
                    }
                    ZONE_ID_TRIE = trie;
                }
            }
        }
        TextTrieMap.Output trieOutput = new TextTrieMap.Output();
        Iterator<String> itr = ZONE_ID_TRIE.get(text, pos.getIndex(), trieOutput);
        if (itr != null) {
            String resolvedID = itr.next();
            pos.setIndex(pos.getIndex() + trieOutput.matchLength);
            return resolvedID;
        }
        pos.setErrorIndex(pos.getIndex());
        return null;
    }

    private static String parseShortZoneID(String text, ParsePosition pos) {
        if (SHORT_ZONE_ID_TRIE == null) {
            synchronized (TimeZoneFormat.class) {
                if (SHORT_ZONE_ID_TRIE == null) {
                    TextTrieMap<String> trie = new TextTrieMap<>(true);
                    for (String id : TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.CANONICAL, (String) null, (Integer) null)) {
                        String shortID = ZoneMeta.getShortID(id);
                        if (shortID != null) {
                            trie.put(shortID, id);
                        }
                    }
                    trie.put(UNKNOWN_SHORT_ZONE_ID, UNKNOWN_ZONE_ID);
                    SHORT_ZONE_ID_TRIE = trie;
                }
            }
        }
        TextTrieMap.Output trieOutput = new TextTrieMap.Output();
        Iterator<String> itr = SHORT_ZONE_ID_TRIE.get(text, pos.getIndex(), trieOutput);
        if (itr != null) {
            String resolvedID = itr.next();
            pos.setIndex(pos.getIndex() + trieOutput.matchLength);
            return resolvedID;
        }
        pos.setErrorIndex(pos.getIndex());
        return null;
    }

    private String parseExemplarLocation(String text, ParsePosition pos) {
        int startIdx = pos.getIndex();
        int parsedPos = -1;
        String tzID = null;
        Collection<TimeZoneNames.MatchInfo> exemplarMatches = this._tznames.find(text, startIdx, EnumSet.of(TimeZoneNames.NameType.EXEMPLAR_LOCATION));
        if (exemplarMatches != null) {
            TimeZoneNames.MatchInfo exemplarMatch = null;
            for (TimeZoneNames.MatchInfo match : exemplarMatches) {
                if (match.matchLength() + startIdx > parsedPos) {
                    exemplarMatch = match;
                    parsedPos = startIdx + match.matchLength();
                }
            }
            if (exemplarMatch != null) {
                tzID = getTimeZoneID(exemplarMatch.tzID(), exemplarMatch.mzID());
                pos.setIndex(parsedPos);
            }
        }
        if (tzID == null) {
            pos.setErrorIndex(startIdx);
        }
        return tzID;
    }

    /* access modifiers changed from: private */
    public static class TimeZoneFormatCache extends SoftCache<ULocale, TimeZoneFormat, ULocale> {
        private TimeZoneFormatCache() {
        }

        /* synthetic */ TimeZoneFormatCache(AnonymousClass1 x0) {
            this();
        }

        /* access modifiers changed from: protected */
        public TimeZoneFormat createInstance(ULocale key, ULocale data) {
            TimeZoneFormat fmt = new TimeZoneFormat(data);
            fmt.freeze();
            return fmt;
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        ObjectOutputStream.PutField fields = oos.putFields();
        fields.put("_locale", this._locale);
        fields.put("_tznames", this._tznames);
        fields.put("_gmtPattern", this._gmtPattern);
        fields.put("_gmtOffsetPatterns", this._gmtOffsetPatterns);
        fields.put("_gmtOffsetDigits", this._gmtOffsetDigits);
        fields.put("_gmtZeroFormat", this._gmtZeroFormat);
        fields.put("_parseAllStyles", this._parseAllStyles);
        oos.writeFields();
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ObjectInputStream.GetField fields = ois.readFields();
        ULocale uLocale = (ULocale) fields.get("_locale", (Object) null);
        this._locale = uLocale;
        if (uLocale != null) {
            TimeZoneNames timeZoneNames = (TimeZoneNames) fields.get("_tznames", (Object) null);
            this._tznames = timeZoneNames;
            if (timeZoneNames != null) {
                String str = (String) fields.get("_gmtPattern", (Object) null);
                this._gmtPattern = str;
                if (str != null) {
                    String[] tmpGmtOffsetPatterns = (String[]) fields.get("_gmtOffsetPatterns", (Object) null);
                    if (tmpGmtOffsetPatterns == null) {
                        throw new InvalidObjectException("Missing field: gmtOffsetPatterns");
                    } else if (tmpGmtOffsetPatterns.length >= 4) {
                        this._gmtOffsetPatterns = new String[6];
                        if (tmpGmtOffsetPatterns.length == 4) {
                            for (int i = 0; i < 4; i++) {
                                this._gmtOffsetPatterns[i] = tmpGmtOffsetPatterns[i];
                            }
                            this._gmtOffsetPatterns[GMTOffsetPatternType.POSITIVE_H.ordinal()] = truncateOffsetPattern(this._gmtOffsetPatterns[GMTOffsetPatternType.POSITIVE_HM.ordinal()]);
                            this._gmtOffsetPatterns[GMTOffsetPatternType.NEGATIVE_H.ordinal()] = truncateOffsetPattern(this._gmtOffsetPatterns[GMTOffsetPatternType.NEGATIVE_HM.ordinal()]);
                        } else {
                            this._gmtOffsetPatterns = tmpGmtOffsetPatterns;
                        }
                        String[] strArr = (String[]) fields.get("_gmtOffsetDigits", (Object) null);
                        this._gmtOffsetDigits = strArr;
                        if (strArr == null) {
                            throw new InvalidObjectException("Missing field: gmtOffsetDigits");
                        } else if (strArr.length == 10) {
                            String str2 = (String) fields.get("_gmtZeroFormat", (Object) null);
                            this._gmtZeroFormat = str2;
                            if (str2 != null) {
                                this._parseAllStyles = fields.get("_parseAllStyles", false);
                                if (!fields.defaulted("_parseAllStyles")) {
                                    if (this._tznames instanceof TimeZoneNamesImpl) {
                                        this._tznames = TimeZoneNames.getInstance(this._locale);
                                        this._gnames = null;
                                    } else {
                                        this._gnames = new TimeZoneGenericNames(this._locale, this._tznames);
                                    }
                                    initGMTPattern(this._gmtPattern);
                                    initGMTOffsetPatterns(this._gmtOffsetPatterns);
                                    return;
                                }
                                throw new InvalidObjectException("Missing field: parseAllStyles");
                            }
                            throw new InvalidObjectException("Missing field: gmtZeroFormat");
                        } else {
                            throw new InvalidObjectException("Incompatible field: gmtOffsetDigits");
                        }
                    } else {
                        throw new InvalidObjectException("Incompatible field: gmtOffsetPatterns");
                    }
                } else {
                    throw new InvalidObjectException("Missing field: gmtPattern");
                }
            } else {
                throw new InvalidObjectException("Missing field: tznames");
            }
        } else {
            throw new InvalidObjectException("Missing field: locale");
        }
    }

    public boolean isFrozen() {
        return this._frozen;
    }

    public TimeZoneFormat freeze() {
        this._frozen = true;
        return this;
    }

    public TimeZoneFormat cloneAsThawed() {
        TimeZoneFormat copy = (TimeZoneFormat) super.clone();
        copy._frozen = false;
        return copy;
    }
}
