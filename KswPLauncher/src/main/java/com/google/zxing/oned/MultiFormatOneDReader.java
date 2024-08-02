package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.RSS14Reader;
import com.google.zxing.oned.rss.expanded.RSSExpandedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatOneDReader extends OneDReader {
    private final OneDReader[] readers;

    public MultiFormatOneDReader(Map<DecodeHintType, ?> hints) {
        Collection<BarcodeFormat> possibleFormats;
        if (hints == null) {
            possibleFormats = null;
        } else {
            possibleFormats = (Collection) hints.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        boolean useCode39CheckDigit = (hints == null || hints.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        Collection<OneDReader> readers2 = new ArrayList<>();
        if (possibleFormats != null) {
            if (possibleFormats.contains(BarcodeFormat.EAN_13) || possibleFormats.contains(BarcodeFormat.UPC_A) || possibleFormats.contains(BarcodeFormat.EAN_8) || possibleFormats.contains(BarcodeFormat.UPC_E)) {
                readers2.add(new MultiFormatUPCEANReader(hints));
            }
            if (possibleFormats.contains(BarcodeFormat.CODE_39)) {
                readers2.add(new Code39Reader(useCode39CheckDigit));
            }
            if (possibleFormats.contains(BarcodeFormat.CODE_93)) {
                readers2.add(new Code93Reader());
            }
            if (possibleFormats.contains(BarcodeFormat.CODE_128)) {
                readers2.add(new Code128Reader());
            }
            if (possibleFormats.contains(BarcodeFormat.ITF)) {
                readers2.add(new ITFReader());
            }
            if (possibleFormats.contains(BarcodeFormat.CODABAR)) {
                readers2.add(new CodaBarReader());
            }
            if (possibleFormats.contains(BarcodeFormat.RSS_14)) {
                readers2.add(new RSS14Reader());
            }
            if (possibleFormats.contains(BarcodeFormat.RSS_EXPANDED)) {
                readers2.add(new RSSExpandedReader());
            }
        }
        if (readers2.isEmpty()) {
            readers2.add(new MultiFormatUPCEANReader(hints));
            readers2.add(new Code39Reader());
            readers2.add(new CodaBarReader());
            readers2.add(new Code93Reader());
            readers2.add(new Code128Reader());
            readers2.add(new ITFReader());
            readers2.add(new RSS14Reader());
            readers2.add(new RSSExpandedReader());
        }
        this.readers = (OneDReader[]) readers2.toArray(new OneDReader[readers2.size()]);
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int rowNumber, BitArray row, Map<DecodeHintType, ?> hints) throws NotFoundException {
        OneDReader[] oneDReaderArr = this.readers;
        for (int i = 0; i < oneDReaderArr.length; i++) {
            try {
                return oneDReaderArr[i].decodeRow(rowNumber, row, hints);
            } catch (ReaderException e) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.Reader, com.google.zxing.oned.OneDReader
    public void reset() {
        for (OneDReader oneDReader : this.readers) {
            oneDReader.reset();
        }
    }
}
