package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* access modifiers changed from: package-private */
public final class AI01320xDecoder extends AI013x0xDecoder {
    AI01320xDecoder(BitArray information) {
        super(information);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public void addWeightCode(StringBuilder buf, int weight) {
        if (weight < 10000) {
            buf.append("(3202)");
        } else {
            buf.append("(3203)");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public int checkWeight(int weight) {
        if (weight < 10000) {
            return weight;
        }
        return weight - 10000;
    }
}
