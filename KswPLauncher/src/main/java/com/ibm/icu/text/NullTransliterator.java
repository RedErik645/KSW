package com.ibm.icu.text;

import com.ibm.icu.text.Transliterator;

class NullTransliterator extends Transliterator {
    static final String SHORT_ID = "Null";
    static final String _ID = "Any-Null";

    public NullTransliterator() {
        super(_ID, null);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.text.Transliterator
    public void handleTransliterate(Replaceable text, Transliterator.Position offsets, boolean incremental) {
        offsets.start = offsets.limit;
    }

    @Override // com.ibm.icu.text.Transliterator
    public void addSourceTargetSet(UnicodeSet inputFilter, UnicodeSet sourceSet, UnicodeSet targetSet) {
    }
}
