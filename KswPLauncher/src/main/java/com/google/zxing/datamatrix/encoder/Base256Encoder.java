package com.google.zxing.datamatrix.encoder;

import android.support.v4.view.InputDeviceCompat;
import com.ibm.icu.text.SCSU;

/* access modifiers changed from: package-private */
public final class Base256Encoder implements Encoder {
    Base256Encoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 5;
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext context) {
        StringBuilder buffer = new StringBuilder();
        buffer.append((char) 0);
        while (true) {
            if (!context.hasMoreCharacters()) {
                break;
            }
            buffer.append(context.getCurrentChar());
            context.pos++;
            if (HighLevelEncoder.lookAheadTest(context.getMessage(), context.pos, getEncodingMode()) != getEncodingMode()) {
                context.signalEncoderChange(0);
                break;
            }
        }
        int dataCount = buffer.length() - 1;
        int currentSize = context.getCodewordCount() + dataCount + 1;
        context.updateSymbolInfo(currentSize);
        boolean mustPad = context.getSymbolInfo().getDataCapacity() - currentSize > 0;
        if (context.hasMoreCharacters() || mustPad) {
            if (dataCount <= 249) {
                buffer.setCharAt(0, (char) dataCount);
            } else if (dataCount <= 1555) {
                buffer.setCharAt(0, (char) ((dataCount / 250) + SCSU.LATININDEX));
                buffer.insert(1, (char) (dataCount % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(dataCount)));
            }
        }
        int c = buffer.length();
        for (int i = 0; i < c; i++) {
            context.writeCodeword(randomize255State(buffer.charAt(i), context.getCodewordCount() + 1));
        }
    }

    private static char randomize255State(char ch, int codewordPosition) {
        int tempVariable = ch + ((codewordPosition * 149) % 255) + 1;
        if (tempVariable <= 255) {
            return (char) tempVariable;
        }
        return (char) (tempVariable + InputDeviceCompat.SOURCE_ANY);
    }
}