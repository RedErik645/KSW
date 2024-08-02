package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;
import java.io.IOException;

/* access modifiers changed from: package-private */
public class BurmeseBreakEngine extends DictionaryBreakEngine {
    private static final byte BURMESE_LOOKAHEAD = 3;
    private static final byte BURMESE_MIN_WORD = 2;
    private static final byte BURMESE_PREFIX_COMBINE_THRESHOLD = 3;
    private static final byte BURMESE_ROOT_COMBINE_THRESHOLD = 3;
    private static UnicodeSet fBeginWordSet = new UnicodeSet();
    private static UnicodeSet fBurmeseWordSet = new UnicodeSet();
    private static UnicodeSet fEndWordSet = new UnicodeSet(fBurmeseWordSet);
    private static UnicodeSet fMarkSet = new UnicodeSet();
    private DictionaryMatcher fDictionary = DictionaryData.loadDictionaryFor("Mymr");

    static {
        fBurmeseWordSet.applyPattern("[[:Mymr:]&[:LineBreak=SA:]]");
        fBurmeseWordSet.compact();
        fMarkSet.applyPattern("[[:Mymr:]&[:LineBreak=SA:]&[:M:]]");
        fMarkSet.add(32);
        fBeginWordSet.add(4096, 4138);
        fMarkSet.compact();
        fEndWordSet.compact();
        fBeginWordSet.compact();
        fBurmeseWordSet.freeze();
        fMarkSet.freeze();
        fEndWordSet.freeze();
        fBeginWordSet.freeze();
    }

    public BurmeseBreakEngine() throws IOException {
        setCharacters(fBurmeseWordSet);
    }

    public boolean equals(Object obj) {
        return obj instanceof BurmeseBreakEngine;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override // com.ibm.icu.text.DictionaryBreakEngine, com.ibm.icu.text.LanguageBreakEngine
    public boolean handles(int c) {
        return UCharacter.getIntPropertyValue(c, 4106) == 28;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013a  */
    @Override // com.ibm.icu.text.DictionaryBreakEngine
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int divideUpDictionaryRange(java.text.CharacterIterator r17, int r18, int r19, com.ibm.icu.text.DictionaryBreakEngine.DequeI r20) {
        /*
        // Method dump skipped, instructions count: 333
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.BurmeseBreakEngine.divideUpDictionaryRange(java.text.CharacterIterator, int, int, com.ibm.icu.text.DictionaryBreakEngine$DequeI):int");
    }
}
