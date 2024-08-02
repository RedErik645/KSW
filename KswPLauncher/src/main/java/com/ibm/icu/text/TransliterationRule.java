package com.ibm.icu.text;

import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.RuleBasedTransliterator;
import com.ibm.icu.text.Transliterator;

/* access modifiers changed from: package-private */
public class TransliterationRule {
    static final int ANCHOR_END = 2;
    static final int ANCHOR_START = 1;
    private StringMatcher anteContext;
    private int anteContextLength;
    private final RuleBasedTransliterator.Data data;
    byte flags;
    private StringMatcher key;
    private int keyLength;
    private UnicodeReplacer output;
    private String pattern;
    private StringMatcher postContext;
    UnicodeMatcher[] segments;

    public TransliterationRule(String input, int anteContextPos, int postContextPos, String output2, int cursorPos, int cursorOffset, UnicodeMatcher[] segs, boolean anchorStart, boolean anchorEnd, RuleBasedTransliterator.Data theData) {
        int cursorPos2 = cursorPos;
        this.data = theData;
        if (anteContextPos < 0) {
            this.anteContextLength = 0;
        } else if (anteContextPos <= input.length()) {
            this.anteContextLength = anteContextPos;
        } else {
            throw new IllegalArgumentException("Invalid ante context");
        }
        if (postContextPos < 0) {
            this.keyLength = input.length() - this.anteContextLength;
        } else {
            if (postContextPos >= this.anteContextLength) {
                if (postContextPos <= input.length()) {
                    this.keyLength = postContextPos - this.anteContextLength;
                }
            }
            throw new IllegalArgumentException("Invalid post context");
        }
        if (cursorPos2 < 0) {
            cursorPos2 = output2.length();
        } else if (cursorPos2 > output2.length()) {
            throw new IllegalArgumentException("Invalid cursor position");
        }
        this.segments = segs;
        this.pattern = input;
        this.flags = 0;
        if (anchorStart) {
            this.flags = (byte) (0 | 1);
        }
        if (anchorEnd) {
            this.flags = (byte) (this.flags | 2);
        }
        this.anteContext = null;
        if (this.anteContextLength > 0) {
            this.anteContext = new StringMatcher(this.pattern.substring(0, this.anteContextLength), 0, theData);
        }
        this.key = null;
        if (this.keyLength > 0) {
            String str = this.pattern;
            int i = this.anteContextLength;
            this.key = new StringMatcher(str.substring(i, this.keyLength + i), 0, theData);
        }
        int postContextLength = (this.pattern.length() - this.keyLength) - this.anteContextLength;
        this.postContext = null;
        if (postContextLength > 0) {
            this.postContext = new StringMatcher(this.pattern.substring(this.anteContextLength + this.keyLength), 0, theData);
        }
        this.output = new StringReplacer(output2, cursorPos2 + cursorOffset, theData);
    }

    public int getAnteContextLength() {
        int i = this.anteContextLength;
        int i2 = 1;
        if ((this.flags & 1) == 0) {
            i2 = 0;
        }
        return i + i2;
    }

    /* access modifiers changed from: package-private */
    public final int getIndexValue() {
        if (this.anteContextLength == this.pattern.length()) {
            return -1;
        }
        int c = UTF16.charAt(this.pattern, this.anteContextLength);
        if (this.data.lookupMatcher(c) == null) {
            return c & 255;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final boolean matchesIndexValue(int v) {
        UnicodeMatcher m = this.key;
        if (m == null) {
            m = this.postContext;
        }
        if (m != null) {
            return m.matchesIndexValue(v);
        }
        return true;
    }

    public boolean masks(TransliterationRule r2) {
        int len = this.pattern.length();
        int left = this.anteContextLength;
        int left2 = r2.anteContextLength;
        int right = this.pattern.length() - left;
        int right2 = r2.pattern.length() - left2;
        if (left != left2 || right != right2 || this.keyLength > r2.keyLength || !r2.pattern.regionMatches(0, this.pattern, 0, len)) {
            return left <= left2 && (right < right2 || (right == right2 && this.keyLength <= r2.keyLength)) && r2.pattern.regionMatches(left2 - left, this.pattern, 0, len);
        }
        byte b = this.flags;
        byte b2 = r2.flags;
        if (b == b2) {
            return true;
        }
        if ((b & 1) == 0 && (b & 2) == 0) {
            return true;
        }
        return ((b2 & 1) == 0 || (b2 & 2) == 0) ? false : true;
    }

    static final int posBefore(Replaceable str, int pos) {
        return pos > 0 ? pos - UTF16.getCharCount(str.char32At(pos - 1)) : pos - 1;
    }

    static final int posAfter(Replaceable str, int pos) {
        return (pos < 0 || pos >= str.length()) ? pos + 1 : UTF16.getCharCount(str.char32At(pos)) + pos;
    }

    /* JADX INFO: Multiple debug info for r3v3 int: [D('match' int), D('oText' int)] */
    /* JADX INFO: Multiple debug info for r7v4 int: [D('keyLimit' int), D('match' int)] */
    public int matchAndReplace(Replaceable text, Transliterator.Position pos, boolean incremental) {
        int match;
        if (this.segments != null) {
            int i = 0;
            while (true) {
                UnicodeMatcher[] unicodeMatcherArr = this.segments;
                if (i >= unicodeMatcherArr.length) {
                    break;
                }
                ((StringMatcher) unicodeMatcherArr[i]).resetMatch();
                i++;
            }
        }
        int anteLimit = posBefore(text, pos.contextStart);
        int[] intRef = {posBefore(text, pos.start)};
        StringMatcher stringMatcher = this.anteContext;
        if (stringMatcher != null && stringMatcher.matches(text, intRef, anteLimit, false) != 2) {
            return 0;
        }
        int oText = intRef[0];
        int minOText = posAfter(text, oText);
        if ((this.flags & 1) != 0 && oText != anteLimit) {
            return 0;
        }
        intRef[0] = pos.start;
        StringMatcher stringMatcher2 = this.key;
        if (stringMatcher2 != null && (match = stringMatcher2.matches(text, intRef, pos.limit, incremental)) != 2) {
            return match;
        }
        int match2 = intRef[0];
        if (this.postContext != null) {
            if (incremental && match2 == pos.limit) {
                return 1;
            }
            int match3 = this.postContext.matches(text, intRef, pos.contextLimit, incremental);
            if (match3 != 2) {
                return match3;
            }
        }
        int oText2 = intRef[0];
        if ((this.flags & 2) != 0) {
            if (oText2 != pos.contextLimit) {
                return 0;
            }
            if (incremental) {
                return 1;
            }
        }
        int lenDelta = this.output.replace(text, pos.start, match2, intRef) - (match2 - pos.start);
        int newStart = intRef[0];
        pos.limit += lenDelta;
        pos.contextLimit += lenDelta;
        pos.start = Math.max(minOText, Math.min(Math.min(oText2 + lenDelta, pos.limit), newStart));
        return 2;
    }

    public String toRule(boolean escapeUnprintable) {
        StringBuffer rule = new StringBuffer();
        StringBuffer quoteBuf = new StringBuffer();
        boolean emitBraces = (this.anteContext == null && this.postContext == null) ? false : true;
        if ((this.flags & 1) != 0) {
            rule.append('^');
        }
        Utility.appendToRule(rule, this.anteContext, escapeUnprintable, quoteBuf);
        if (emitBraces) {
            Utility.appendToRule(rule, 123, true, escapeUnprintable, quoteBuf);
        }
        Utility.appendToRule(rule, this.key, escapeUnprintable, quoteBuf);
        if (emitBraces) {
            Utility.appendToRule(rule, 125, true, escapeUnprintable, quoteBuf);
        }
        Utility.appendToRule(rule, this.postContext, escapeUnprintable, quoteBuf);
        if ((this.flags & 2) != 0) {
            rule.append('$');
        }
        Utility.appendToRule(rule, " > ", true, escapeUnprintable, quoteBuf);
        Utility.appendToRule(rule, this.output.toReplacerPattern(escapeUnprintable), true, escapeUnprintable, quoteBuf);
        Utility.appendToRule(rule, 59, true, escapeUnprintable, quoteBuf);
        return rule.toString();
    }

    public String toString() {
        return '{' + toRule(true) + '}';
    }

    /* access modifiers changed from: package-private */
    public void addSourceTargetSet(UnicodeSet filter, UnicodeSet sourceSet, UnicodeSet targetSet, UnicodeSet revisiting) {
        int limit = this.anteContextLength + this.keyLength;
        UnicodeSet tempSource = new UnicodeSet();
        UnicodeSet temp = new UnicodeSet();
        int i = this.anteContextLength;
        while (i < limit) {
            int ch = UTF16.charAt(this.pattern, i);
            i += UTF16.getCharCount(ch);
            UnicodeMatcher matcher = this.data.lookupMatcher(ch);
            if (matcher != null) {
                try {
                    if (filter.containsSome((UnicodeSet) matcher)) {
                        matcher.addMatchSetTo(tempSource);
                    } else {
                        return;
                    }
                } catch (ClassCastException e) {
                    temp.clear();
                    matcher.addMatchSetTo(temp);
                    if (filter.containsSome(temp)) {
                        tempSource.addAll(temp);
                    } else {
                        return;
                    }
                }
            } else if (filter.contains(ch)) {
                tempSource.add(ch);
            } else {
                return;
            }
        }
        sourceSet.addAll(tempSource);
        this.output.addReplacementSetTo(targetSet);
    }
}