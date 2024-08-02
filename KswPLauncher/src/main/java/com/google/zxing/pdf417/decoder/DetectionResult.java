package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;

/* access modifiers changed from: package-private */
public final class DetectionResult {
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final BarcodeMetadata barcodeMetadata;
    private BoundingBox boundingBox;
    private final DetectionResultColumn[] detectionResultColumns;

    DetectionResult(BarcodeMetadata barcodeMetadata2, BoundingBox boundingBox2) {
        this.barcodeMetadata = barcodeMetadata2;
        int columnCount = barcodeMetadata2.getColumnCount();
        this.barcodeColumnCount = columnCount;
        this.boundingBox = boundingBox2;
        this.detectionResultColumns = new DetectionResultColumn[(columnCount + 2)];
    }

    /* access modifiers changed from: package-private */
    public DetectionResultColumn[] getDetectionResultColumns() {
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int unadjustedCodewordCount = PDF417Common.MAX_CODEWORDS_IN_BARCODE;
        do {
            int adjustRowNumbers = adjustRowNumbers();
            unadjustedCodewordCount = adjustRowNumbers;
            if (adjustRowNumbers <= 0) {
                break;
            }
        } while (unadjustedCodewordCount < unadjustedCodewordCount);
        return this.detectionResultColumns;
    }

    private void adjustIndicatorColumnRowNumbers(DetectionResultColumn detectionResultColumn) {
        if (detectionResultColumn != null) {
            ((DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }

    private int adjustRowNumbers() {
        int unadjustedCount = adjustRowNumbersByRow();
        if (unadjustedCount == 0) {
            return 0;
        }
        for (int barcodeColumn = 1; barcodeColumn < this.barcodeColumnCount + 1; barcodeColumn++) {
            Codeword[] codewords = this.detectionResultColumns[barcodeColumn].getCodewords();
            for (int codewordsRow = 0; codewordsRow < codewords.length; codewordsRow++) {
                if (codewords[codewordsRow] != null && !codewords[codewordsRow].hasValidRowNumber()) {
                    adjustRowNumbers(barcodeColumn, codewordsRow, codewords);
                }
            }
        }
        return unadjustedCount;
    }

    private int adjustRowNumbersByRow() {
        adjustRowNumbersFromBothRI();
        return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
    }

    private void adjustRowNumbersFromBothRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        if (!(detectionResultColumnArr[0] == null || detectionResultColumnArr[this.barcodeColumnCount + 1] == null)) {
            Codeword[] LRIcodewords = detectionResultColumnArr[0].getCodewords();
            Codeword[] RRIcodewords = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
            for (int codewordsRow = 0; codewordsRow < LRIcodewords.length; codewordsRow++) {
                if (!(LRIcodewords[codewordsRow] == null || RRIcodewords[codewordsRow] == null || LRIcodewords[codewordsRow].getRowNumber() != RRIcodewords[codewordsRow].getRowNumber())) {
                    for (int barcodeColumn = 1; barcodeColumn <= this.barcodeColumnCount; barcodeColumn++) {
                        Codeword codeword = this.detectionResultColumns[barcodeColumn].getCodewords()[codewordsRow];
                        if (codeword != null) {
                            codeword.setRowNumber(LRIcodewords[codewordsRow].getRowNumber());
                            if (!codeword.hasValidRowNumber()) {
                                this.detectionResultColumns[barcodeColumn].getCodewords()[codewordsRow] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    private int adjustRowNumbersFromRRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i = this.barcodeColumnCount;
        if (detectionResultColumnArr[i + 1] == null) {
            return 0;
        }
        int unadjustedCount = 0;
        Codeword[] codewords = detectionResultColumnArr[i + 1].getCodewords();
        for (int codewordsRow = 0; codewordsRow < codewords.length; codewordsRow++) {
            if (codewords[codewordsRow] != null) {
                int rowIndicatorRowNumber = codewords[codewordsRow].getRowNumber();
                int invalidRowCounts = 0;
                for (int barcodeColumn = this.barcodeColumnCount + 1; barcodeColumn > 0 && invalidRowCounts < 2; barcodeColumn--) {
                    Codeword codeword = this.detectionResultColumns[barcodeColumn].getCodewords()[codewordsRow];
                    if (codeword != null) {
                        invalidRowCounts = adjustRowNumberIfValid(rowIndicatorRowNumber, invalidRowCounts, codeword);
                        if (!codeword.hasValidRowNumber()) {
                            unadjustedCount++;
                        }
                    }
                }
            }
        }
        return unadjustedCount;
    }

    private int adjustRowNumbersFromLRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        if (detectionResultColumnArr[0] == null) {
            return 0;
        }
        int unadjustedCount = 0;
        Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
        for (int codewordsRow = 0; codewordsRow < codewords.length; codewordsRow++) {
            if (codewords[codewordsRow] != null) {
                int rowIndicatorRowNumber = codewords[codewordsRow].getRowNumber();
                int invalidRowCounts = 0;
                for (int barcodeColumn = 1; barcodeColumn < this.barcodeColumnCount + 1 && invalidRowCounts < 2; barcodeColumn++) {
                    Codeword codeword = this.detectionResultColumns[barcodeColumn].getCodewords()[codewordsRow];
                    if (codeword != null) {
                        invalidRowCounts = adjustRowNumberIfValid(rowIndicatorRowNumber, invalidRowCounts, codeword);
                        if (!codeword.hasValidRowNumber()) {
                            unadjustedCount++;
                        }
                    }
                }
            }
        }
        return unadjustedCount;
    }

    private static int adjustRowNumberIfValid(int rowIndicatorRowNumber, int invalidRowCounts, Codeword codeword) {
        if (codeword == null || codeword.hasValidRowNumber()) {
            return invalidRowCounts;
        }
        if (!codeword.isValidRowNumber(rowIndicatorRowNumber)) {
            return invalidRowCounts + 1;
        }
        codeword.setRowNumber(rowIndicatorRowNumber);
        return 0;
    }

    private void adjustRowNumbers(int barcodeColumn, int codewordsRow, Codeword[] codewords) {
        Codeword codeword = codewords[codewordsRow];
        Codeword[] nextColumnCodewords = this.detectionResultColumns[barcodeColumn - 1].getCodewords();
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        if (detectionResultColumnArr[barcodeColumn + 1] != null) {
            nextColumnCodewords = detectionResultColumnArr[barcodeColumn + 1].getCodewords();
        }
        Codeword[] otherCodewords = new Codeword[14];
        otherCodewords[2] = nextColumnCodewords[codewordsRow];
        otherCodewords[3] = nextColumnCodewords[codewordsRow];
        int i = 0;
        if (codewordsRow > 0) {
            otherCodewords[0] = codewords[codewordsRow - 1];
            otherCodewords[4] = nextColumnCodewords[codewordsRow - 1];
            otherCodewords[5] = nextColumnCodewords[codewordsRow - 1];
        }
        if (codewordsRow > 1) {
            otherCodewords[8] = codewords[codewordsRow - 2];
            otherCodewords[10] = nextColumnCodewords[codewordsRow - 2];
            otherCodewords[11] = nextColumnCodewords[codewordsRow - 2];
        }
        if (codewordsRow < codewords.length - 1) {
            otherCodewords[1] = codewords[codewordsRow + 1];
            otherCodewords[6] = nextColumnCodewords[codewordsRow + 1];
            otherCodewords[7] = nextColumnCodewords[codewordsRow + 1];
        }
        if (codewordsRow < codewords.length - 2) {
            otherCodewords[9] = codewords[codewordsRow + 2];
            otherCodewords[12] = nextColumnCodewords[codewordsRow + 2];
            otherCodewords[13] = nextColumnCodewords[codewordsRow + 2];
        }
        while (i < 14 && !adjustRowNumber(codeword, otherCodewords[i])) {
            i++;
        }
    }

    private static boolean adjustRowNumber(Codeword codeword, Codeword otherCodeword) {
        if (otherCodeword == null || !otherCodeword.hasValidRowNumber() || otherCodeword.getBucket() != codeword.getBucket()) {
            return false;
        }
        codeword.setRowNumber(otherCodeword.getRowNumber());
        return true;
    }

    /* access modifiers changed from: package-private */
    public int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }

    /* access modifiers changed from: package-private */
    public int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }

    /* access modifiers changed from: package-private */
    public int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }

    /* access modifiers changed from: package-private */
    public void setBoundingBox(BoundingBox boundingBox2) {
        this.boundingBox = boundingBox2;
    }

    /* access modifiers changed from: package-private */
    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    /* access modifiers changed from: package-private */
    public void setDetectionResultColumn(int barcodeColumn, DetectionResultColumn detectionResultColumn) {
        this.detectionResultColumns[barcodeColumn] = detectionResultColumn;
    }

    /* access modifiers changed from: package-private */
    public DetectionResultColumn getDetectionResultColumn(int barcodeColumn) {
        return this.detectionResultColumns[barcodeColumn];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        if (r1 != null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0089, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        r1.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DetectionResult.toString():java.lang.String");
    }
}
