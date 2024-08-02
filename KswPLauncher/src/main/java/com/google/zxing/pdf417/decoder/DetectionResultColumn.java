package com.google.zxing.pdf417.decoder;

/* access modifiers changed from: package-private */
public class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    DetectionResultColumn(BoundingBox boundingBox2) {
        this.boundingBox = new BoundingBox(boundingBox2);
        this.codewords = new Codeword[((boundingBox2.getMaxY() - boundingBox2.getMinY()) + 1)];
    }

    /* access modifiers changed from: package-private */
    public final Codeword getCodewordNearby(int imageRow) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = getCodeword(imageRow);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i = 1; i < 5; i++) {
            int nearImageRow = imageRowToCodewordIndex(imageRow) - i;
            if (nearImageRow >= 0 && (codeword2 = this.codewords[nearImageRow]) != null) {
                return codeword2;
            }
            int nearImageRow2 = imageRowToCodewordIndex(imageRow) + i;
            Codeword[] codewordArr = this.codewords;
            if (nearImageRow2 < codewordArr.length && (codeword = codewordArr[nearImageRow2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final int imageRowToCodewordIndex(int imageRow) {
        return imageRow - this.boundingBox.getMinY();
    }

    /* access modifiers changed from: package-private */
    public final void setCodeword(int imageRow, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(imageRow)] = codeword;
    }

    /* access modifiers changed from: package-private */
    public final Codeword getCodeword(int imageRow) {
        return this.codewords[imageRowToCodewordIndex(imageRow)];
    }

    /* access modifiers changed from: package-private */
    public final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    /* access modifiers changed from: package-private */
    public final Codeword[] getCodewords() {
        return this.codewords;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        if (r1 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r1.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DetectionResultColumn.toString():java.lang.String");
    }
}
