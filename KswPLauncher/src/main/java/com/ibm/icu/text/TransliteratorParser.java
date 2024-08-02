package com.ibm.icu.text;

import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.Normalizer;
import com.ibm.icu.text.RuleBasedTransliterator;
import java.text.ParsePosition;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* access modifiers changed from: package-private */
public class TransliteratorParser {
    private static final char ALT_FORWARD_RULE_OP = 8594;
    private static final char ALT_FUNCTION = 8710;
    private static final char ALT_FWDREV_RULE_OP = 8596;
    private static final char ALT_REVERSE_RULE_OP = 8592;
    private static final char ANCHOR_START = '^';
    private static final char CONTEXT_ANTE = '{';
    private static final char CONTEXT_POST = '}';
    private static final char CURSOR_OFFSET = '@';
    private static final char CURSOR_POS = '|';
    private static final char DOT = '.';
    private static final String DOT_SET = "[^[:Zp:][:Zl:]\\r\\n$]";
    private static final char END_OF_RULE = ';';
    private static final char ESCAPE = '\\';
    private static final char FORWARD_RULE_OP = '>';
    private static final char FUNCTION = '&';
    private static final char FWDREV_RULE_OP = '~';
    private static final String HALF_ENDERS = "=><←→↔;";
    private static final String ID_TOKEN = "::";
    private static final int ID_TOKEN_LEN = 2;
    private static UnicodeSet ILLEGAL_FUNC = new UnicodeSet("[\\^\\(\\.\\*\\+\\?\\{\\}\\|\\@]");
    private static UnicodeSet ILLEGAL_SEG = new UnicodeSet("[\\{\\}\\|\\@]");
    private static UnicodeSet ILLEGAL_TOP = new UnicodeSet("[\\)]");
    private static final char KLEENE_STAR = '*';
    private static final char ONE_OR_MORE = '+';
    private static final String OPERATORS = "=><←→↔";
    private static final char QUOTE = '\'';
    private static final char REVERSE_RULE_OP = '<';
    private static final char RULE_COMMENT_CHAR = '#';
    private static final char SEGMENT_CLOSE = ')';
    private static final char SEGMENT_OPEN = '(';
    private static final char VARIABLE_DEF_OP = '=';
    private static final char ZERO_OR_ONE = '?';
    public UnicodeSet compoundFilter;
    private RuleBasedTransliterator.Data curData;
    public List<RuleBasedTransliterator.Data> dataVector;
    private int direction;
    private int dotStandIn = -1;
    public List<String> idBlockVector;
    private ParseData parseData;
    private List<StringMatcher> segmentObjects;
    private StringBuffer segmentStandins;
    private String undefinedVariableName;
    private char variableLimit;
    private Map<String, char[]> variableNames;
    private char variableNext;
    private List<Object> variablesVector;

    /* access modifiers changed from: private */
    public class ParseData implements SymbolTable {
        private ParseData() {
        }

        @Override // com.ibm.icu.text.SymbolTable
        public char[] lookup(String name) {
            return (char[]) TransliteratorParser.this.variableNames.get(name);
        }

        @Override // com.ibm.icu.text.SymbolTable
        public UnicodeMatcher lookupMatcher(int ch) {
            int i = ch - TransliteratorParser.this.curData.variablesBase;
            if (i < 0 || i >= TransliteratorParser.this.variablesVector.size()) {
                return null;
            }
            return (UnicodeMatcher) TransliteratorParser.this.variablesVector.get(i);
        }

        @Override // com.ibm.icu.text.SymbolTable
        public String parseReference(String text, ParsePosition pos, int limit) {
            int start = pos.getIndex();
            int i = start;
            while (i < limit) {
                char c = text.charAt(i);
                if ((i == start && !UCharacter.isUnicodeIdentifierStart(c)) || !UCharacter.isUnicodeIdentifierPart(c)) {
                    break;
                }
                i++;
            }
            if (i == start) {
                return null;
            }
            pos.setIndex(i);
            return text.substring(start, i);
        }

        public boolean isMatcher(int ch) {
            int i = ch - TransliteratorParser.this.curData.variablesBase;
            if (i < 0 || i >= TransliteratorParser.this.variablesVector.size()) {
                return true;
            }
            return TransliteratorParser.this.variablesVector.get(i) instanceof UnicodeMatcher;
        }

        public boolean isReplacer(int ch) {
            int i = ch - TransliteratorParser.this.curData.variablesBase;
            if (i < 0 || i >= TransliteratorParser.this.variablesVector.size()) {
                return true;
            }
            return TransliteratorParser.this.variablesVector.get(i) instanceof UnicodeReplacer;
        }
    }

    /* access modifiers changed from: private */
    public static abstract class RuleBody {
        /* access modifiers changed from: package-private */
        public abstract String handleNextLine();

        /* access modifiers changed from: package-private */
        public abstract void reset();

        private RuleBody() {
        }

        /* access modifiers changed from: package-private */
        public String nextLine() {
            String s;
            String s2 = handleNextLine();
            if (s2 == null || s2.length() <= 0 || s2.charAt(s2.length() - 1) != '\\') {
                return s2;
            }
            StringBuilder b = new StringBuilder(s2);
            do {
                b.deleteCharAt(b.length() - 1);
                s = handleNextLine();
                if (s != null) {
                    b.append(s);
                    if (s.length() <= 0) {
                        break;
                    }
                } else {
                    break;
                }
            } while (s.charAt(s.length() - 1) == '\\');
            return b.toString();
        }
    }

    /* access modifiers changed from: private */
    public static class RuleArray extends RuleBody {
        String[] array;
        int i = 0;

        public RuleArray(String[] array2) {
            super();
            this.array = array2;
        }

        @Override // com.ibm.icu.text.TransliteratorParser.RuleBody
        public String handleNextLine() {
            int i2 = this.i;
            String[] strArr = this.array;
            if (i2 >= strArr.length) {
                return null;
            }
            this.i = i2 + 1;
            return strArr[i2];
        }

        @Override // com.ibm.icu.text.TransliteratorParser.RuleBody
        public void reset() {
            this.i = 0;
        }
    }

    /* access modifiers changed from: private */
    public static class RuleHalf {
        public boolean anchorEnd;
        public boolean anchorStart;
        public int ante;
        public int cursor;
        public int cursorOffset;
        private int cursorOffsetPos;
        private int nextSegmentNumber;
        public int post;
        public String text;

        private RuleHalf() {
            this.cursor = -1;
            this.ante = -1;
            this.post = -1;
            this.cursorOffset = 0;
            this.cursorOffsetPos = 0;
            this.anchorStart = false;
            this.anchorEnd = false;
            this.nextSegmentNumber = 1;
        }

        public int parse(String rule, int pos, int limit, TransliteratorParser parser) {
            StringBuffer buf = new StringBuffer();
            int pos2 = parseSection(rule, pos, limit, parser, buf, TransliteratorParser.ILLEGAL_TOP, false);
            this.text = buf.toString();
            if (this.cursorOffset > 0 && this.cursor != this.cursorOffsetPos) {
                TransliteratorParser.syntaxError("Misplaced |", rule, pos);
            }
            return pos2;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:171:0x0022 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:180:0x0022 */
        /* JADX WARN: Type inference failed for: r15v0 */
        /* JADX WARN: Type inference failed for: r15v1, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r15v2 */
        /* JADX WARN: Type inference failed for: r15v3 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int parseSection(java.lang.String r29, int r30, int r31, com.ibm.icu.text.TransliteratorParser r32, java.lang.StringBuffer r33, com.ibm.icu.text.UnicodeSet r34, boolean r35) {
            /*
            // Method dump skipped, instructions count: 1392
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.TransliteratorParser.RuleHalf.parseSection(java.lang.String, int, int, com.ibm.icu.text.TransliteratorParser, java.lang.StringBuffer, com.ibm.icu.text.UnicodeSet, boolean):int");
        }

        /* access modifiers changed from: package-private */
        public void removeContext() {
            String str = this.text;
            int i = this.ante;
            if (i < 0) {
                i = 0;
            }
            int i2 = this.post;
            if (i2 < 0) {
                i2 = str.length();
            }
            this.text = str.substring(i, i2);
            this.post = -1;
            this.ante = -1;
            this.anchorEnd = false;
            this.anchorStart = false;
        }

        public boolean isValidOutput(TransliteratorParser parser) {
            int i = 0;
            while (i < this.text.length()) {
                int c = UTF16.charAt(this.text, i);
                i += UTF16.getCharCount(c);
                if (!parser.parseData.isReplacer(c)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isValidInput(TransliteratorParser parser) {
            int i = 0;
            while (i < this.text.length()) {
                int c = UTF16.charAt(this.text, i);
                i += UTF16.getCharCount(c);
                if (!parser.parseData.isMatcher(c)) {
                    return false;
                }
            }
            return true;
        }
    }

    public void parse(String rules, int dir) {
        parseRules(new RuleArray(new String[]{rules}), dir);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0205 A[LOOP:3: B:104:0x01fd->B:106:0x0205, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0236 A[Catch:{ IllegalArgumentException -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0255 A[Catch:{ IllegalArgumentException -> 0x0284 }, LOOP:4: B:123:0x024d->B:125:0x0255, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02c3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01b5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseRules(com.ibm.icu.text.TransliteratorParser.RuleBody r22, int r23) {
        /*
        // Method dump skipped, instructions count: 742
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.TransliteratorParser.parseRules(com.ibm.icu.text.TransliteratorParser$RuleBody, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0039, code lost:
        if (com.ibm.icu.text.TransliteratorParser.OPERATORS.indexOf(r8) < 0) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseRule(java.lang.String r23, int r24, int r25) {
        /*
        // Method dump skipped, instructions count: 510
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.TransliteratorParser.parseRule(java.lang.String, int, int):int");
    }

    private void setVariableRange(int start, int end) {
        if (start > end || start < 0 || end > 65535) {
            throw new IllegalIcuArgumentException("Invalid variable range " + start + ", " + end);
        }
        this.curData.variablesBase = (char) start;
        if (this.dataVector.size() == 0) {
            this.variableNext = (char) start;
            this.variableLimit = (char) (end + 1);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkVariableRange(int ch, String rule, int start) {
        if (ch >= this.curData.variablesBase && ch < this.variableLimit) {
            syntaxError("Variable range character in rule", rule, start);
        }
    }

    private void pragmaMaximumBackup(int backup) {
        throw new IllegalIcuArgumentException("use maximum backup pragma not implemented yet");
    }

    private void pragmaNormalizeRules(Normalizer.Mode mode) {
        throw new IllegalIcuArgumentException("use normalize rules pragma not implemented yet");
    }

    static boolean resemblesPragma(String rule, int pos, int limit) {
        return Utility.parsePattern(rule, pos, limit, "use ", null) >= 0;
    }

    private int parsePragma(String rule, int pos, int limit) {
        int[] array = new int[2];
        int pos2 = pos + 4;
        int p = Utility.parsePattern(rule, pos2, limit, "~variable range # #~;", array);
        if (p >= 0) {
            setVariableRange(array[0], array[1]);
            return p;
        }
        int p2 = Utility.parsePattern(rule, pos2, limit, "~maximum backup #~;", array);
        if (p2 >= 0) {
            pragmaMaximumBackup(array[0]);
            return p2;
        }
        int p3 = Utility.parsePattern(rule, pos2, limit, "~nfd rules~;", (int[]) null);
        if (p3 >= 0) {
            pragmaNormalizeRules(Normalizer.NFD);
            return p3;
        }
        int p4 = Utility.parsePattern(rule, pos2, limit, "~nfc rules~;", (int[]) null);
        if (p4 < 0) {
            return -1;
        }
        pragmaNormalizeRules(Normalizer.NFC);
        return p4;
    }

    static final void syntaxError(String msg, String rule, int start) {
        throw new IllegalIcuArgumentException(msg + " in \"" + Utility.escape(rule.substring(start, ruleEnd(rule, start, rule.length()))) + Typography.quote);
    }

    static final int ruleEnd(String rule, int start, int limit) {
        int end = Utility.quotedIndexOf(rule, start, limit, ";");
        return end < 0 ? limit : end;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final char parseSet(String rule, ParsePosition pos) {
        UnicodeSet set = new UnicodeSet(rule, pos, this.parseData);
        if (this.variableNext < this.variableLimit) {
            set.compact();
            return generateStandInFor(set);
        }
        throw new RuntimeException("Private use variables exhausted");
    }

    /* access modifiers changed from: package-private */
    public char generateStandInFor(Object obj) {
        for (int i = 0; i < this.variablesVector.size(); i++) {
            if (this.variablesVector.get(i) == obj) {
                return (char) (this.curData.variablesBase + i);
            }
        }
        if (this.variableNext < this.variableLimit) {
            this.variablesVector.add(obj);
            char c = this.variableNext;
            this.variableNext = (char) (c + 1);
            return c;
        }
        throw new RuntimeException("Variable range exhausted");
    }

    public char getSegmentStandin(int seg) {
        if (this.segmentStandins.length() < seg) {
            this.segmentStandins.setLength(seg);
        }
        char c = this.segmentStandins.charAt(seg - 1);
        if (c != 0) {
            return c;
        }
        char c2 = this.variableNext;
        if (c2 < this.variableLimit) {
            this.variableNext = (char) (c2 + 1);
            this.variablesVector.add(null);
            this.segmentStandins.setCharAt(seg - 1, c2);
            return c2;
        }
        throw new RuntimeException("Variable range exhausted");
    }

    public void setSegmentObject(int seg, StringMatcher obj) {
        while (this.segmentObjects.size() < seg) {
            this.segmentObjects.add(null);
        }
        int index = getSegmentStandin(seg) - this.curData.variablesBase;
        if (this.segmentObjects.get(seg - 1) == null && this.variablesVector.get(index) == null) {
            this.segmentObjects.set(seg - 1, obj);
            this.variablesVector.set(index, obj);
            return;
        }
        throw new RuntimeException();
    }

    /* access modifiers changed from: package-private */
    public char getDotStandIn() {
        if (this.dotStandIn == -1) {
            this.dotStandIn = generateStandInFor(new UnicodeSet(DOT_SET));
        }
        return (char) this.dotStandIn;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void appendVariableDef(String name, StringBuffer buf) {
        char[] ch = this.variableNames.get(name);
        if (ch != null) {
            buf.append(ch);
        } else if (this.undefinedVariableName == null) {
            this.undefinedVariableName = name;
            char c = this.variableNext;
            char c2 = this.variableLimit;
            if (c < c2) {
                char c3 = (char) (c2 - 1);
                this.variableLimit = c3;
                buf.append(c3);
                return;
            }
            throw new RuntimeException("Private use variables exhausted");
        } else {
            throw new IllegalIcuArgumentException("Undefined variable $" + name);
        }
    }
}
