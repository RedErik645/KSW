package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.ibm.icu.text.SCSU;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import kotlin.text.Typography;

/* access modifiers changed from: package-private */
public final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] TEXT_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT3_SET_CHARS = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* access modifiers changed from: private */
    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', Typography.quote, '#', '$', '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', Typography.less, '=', Typography.greater, '?', '@', '[', '\\', ']', '^', '_'};
        C40_SHIFT2_SET_CHARS = cArr;
        TEXT_SHIFT2_SET_CHARS = cArr;
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.zxing.common.DecoderResult decode(byte[] r9) throws com.google.zxing.FormatException {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.decode(byte[]):com.google.zxing.common.DecoderResult");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static Mode decodeAsciiSegment(BitSource bits, StringBuilder result, StringBuilder resultTrailer) throws FormatException {
        boolean upperShift = false;
        do {
            int readBits = bits.readBits(8);
            int oneByte = readBits;
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            } else if (oneByte <= 128) {
                if (upperShift) {
                    oneByte += 128;
                }
                result.append((char) (oneByte - 1));
                return Mode.ASCII_ENCODE;
            } else if (oneByte == 129) {
                return Mode.PAD_ENCODE;
            } else {
                if (oneByte <= 229) {
                    int value = oneByte - 130;
                    if (value < 10) {
                        result.append('0');
                    }
                    result.append(value);
                } else {
                    switch (oneByte) {
                        case SCSU.UCHANGE6 /*{ENCODED_INT: 230}*/:
                            return Mode.C40_ENCODE;
                        case SCSU.UCHANGE7 /*{ENCODED_INT: 231}*/:
                            return Mode.BASE256_ENCODE;
                        case SCSU.UDEFINE0 /*{ENCODED_INT: 232}*/:
                            result.append((char) 29);
                            break;
                        case SCSU.UDEFINE1 /*{ENCODED_INT: 233}*/:
                        case SCSU.UDEFINE2 /*{ENCODED_INT: 234}*/:
                        case SCSU.UDEFINEX /*{ENCODED_INT: 241}*/:
                            break;
                        case SCSU.UDEFINE3 /*{ENCODED_INT: 235}*/:
                            upperShift = true;
                            break;
                        case SCSU.UDEFINE4 /*{ENCODED_INT: 236}*/:
                            result.append("[)>\u001e05\u001d");
                            resultTrailer.insert(0, "\u001e\u0004");
                            break;
                        case SCSU.UDEFINE5 /*{ENCODED_INT: 237}*/:
                            result.append("[)>\u001e06\u001d");
                            resultTrailer.insert(0, "\u001e\u0004");
                            break;
                        case SCSU.UDEFINE6 /*{ENCODED_INT: 238}*/:
                            return Mode.ANSIX12_ENCODE;
                        case SCSU.UDEFINE7 /*{ENCODED_INT: 239}*/:
                            return Mode.TEXT_ENCODE;
                        case SCSU.UQUOTEU /*{ENCODED_INT: 240}*/:
                            return Mode.EDIFACT_ENCODE;
                        default:
                            if (!(oneByte == 254 && bits.available() == 0)) {
                                throw FormatException.getFormatInstance();
                            }
                    }
                }
            }
        } while (bits.available() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void decodeC40Segment(BitSource bits, StringBuilder result) throws FormatException {
        int firstByte;
        boolean upperShift = false;
        int[] cValues = new int[3];
        int shift = 0;
        while (bits.available() != 8 && (firstByte = bits.readBits(8)) != 254) {
            parseTwoBytes(firstByte, bits.readBits(8), cValues);
            for (int i = 0; i < 3; i++) {
                int cValue = cValues[i];
                switch (shift) {
                    case 0:
                        if (cValue < 3) {
                            shift = cValue + 1;
                            break;
                        } else {
                            char[] cArr = C40_BASIC_SET_CHARS;
                            if (cValue < cArr.length) {
                                char c40char = cArr[cValue];
                                if (upperShift) {
                                    result.append((char) (c40char + 128));
                                    upperShift = false;
                                    break;
                                } else {
                                    result.append(c40char);
                                    break;
                                }
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        }
                    case 1:
                        if (upperShift) {
                            result.append((char) (cValue + 128));
                            upperShift = false;
                        } else {
                            result.append((char) cValue);
                        }
                        shift = 0;
                        break;
                    case 2:
                        char[] cArr2 = C40_SHIFT2_SET_CHARS;
                        if (cValue < cArr2.length) {
                            char c40char2 = cArr2[cValue];
                            if (upperShift) {
                                result.append((char) (c40char2 + 128));
                                upperShift = false;
                            } else {
                                result.append(c40char2);
                            }
                        } else {
                            switch (cValue) {
                                case 27:
                                    result.append((char) 29);
                                    break;
                                case 30:
                                    upperShift = true;
                                    break;
                                default:
                                    throw FormatException.getFormatInstance();
                            }
                        }
                        shift = 0;
                        break;
                    case 3:
                        if (upperShift) {
                            result.append((char) (cValue + 224));
                            upperShift = false;
                        } else {
                            result.append((char) (cValue + 96));
                        }
                        shift = 0;
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
            if (bits.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeTextSegment(BitSource bits, StringBuilder result) throws FormatException {
        int firstByte;
        boolean upperShift = false;
        int[] cValues = new int[3];
        int shift = 0;
        while (bits.available() != 8 && (firstByte = bits.readBits(8)) != 254) {
            parseTwoBytes(firstByte, bits.readBits(8), cValues);
            for (int i = 0; i < 3; i++) {
                int cValue = cValues[i];
                switch (shift) {
                    case 0:
                        if (cValue < 3) {
                            shift = cValue + 1;
                            break;
                        } else {
                            char[] cArr = TEXT_BASIC_SET_CHARS;
                            if (cValue < cArr.length) {
                                char textChar = cArr[cValue];
                                if (upperShift) {
                                    result.append((char) (textChar + 128));
                                    upperShift = false;
                                    break;
                                } else {
                                    result.append(textChar);
                                    break;
                                }
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        }
                    case 1:
                        if (upperShift) {
                            result.append((char) (cValue + 128));
                            upperShift = false;
                        } else {
                            result.append((char) cValue);
                        }
                        shift = 0;
                        break;
                    case 2:
                        char[] cArr2 = TEXT_SHIFT2_SET_CHARS;
                        if (cValue < cArr2.length) {
                            char textChar2 = cArr2[cValue];
                            if (upperShift) {
                                result.append((char) (textChar2 + 128));
                                upperShift = false;
                            } else {
                                result.append(textChar2);
                            }
                        } else {
                            switch (cValue) {
                                case 27:
                                    result.append((char) 29);
                                    break;
                                case 30:
                                    upperShift = true;
                                    break;
                                default:
                                    throw FormatException.getFormatInstance();
                            }
                        }
                        shift = 0;
                        break;
                    case 3:
                        char[] cArr3 = TEXT_SHIFT3_SET_CHARS;
                        if (cValue < cArr3.length) {
                            char textChar3 = cArr3[cValue];
                            if (upperShift) {
                                result.append((char) (textChar3 + 128));
                                upperShift = false;
                            } else {
                                result.append(textChar3);
                            }
                            shift = 0;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
            if (bits.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeAnsiX12Segment(BitSource bits, StringBuilder result) throws FormatException {
        int firstByte;
        int[] cValues = new int[3];
        while (bits.available() != 8 && (firstByte = bits.readBits(8)) != 254) {
            parseTwoBytes(firstByte, bits.readBits(8), cValues);
            for (int i = 0; i < 3; i++) {
                int cValue = cValues[i];
                switch (cValue) {
                    case 0:
                        result.append('\r');
                        break;
                    case 1:
                        result.append('*');
                        break;
                    case 2:
                        result.append(Typography.greater);
                        break;
                    case 3:
                        result.append(' ');
                        break;
                    default:
                        if (cValue < 14) {
                            result.append((char) (cValue + 44));
                            break;
                        } else if (cValue < 40) {
                            result.append((char) (cValue + 51));
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                }
            }
            if (bits.available() <= 0) {
                return;
            }
        }
    }

    private static void parseTwoBytes(int firstByte, int secondByte, int[] result) {
        int fullBitValue = ((firstByte << 8) + secondByte) - 1;
        int temp = fullBitValue / 1600;
        result[0] = temp;
        int fullBitValue2 = fullBitValue - (temp * 1600);
        int temp2 = fullBitValue2 / 40;
        result[1] = temp2;
        result[2] = fullBitValue2 - (temp2 * 40);
    }

    private static void decodeEdifactSegment(BitSource bits, StringBuilder result) {
        while (bits.available() > 16) {
            for (int i = 0; i < 4; i++) {
                int readBits = bits.readBits(6);
                int edifactValue = readBits;
                if (readBits == 31) {
                    int bitsLeft = 8 - bits.getBitOffset();
                    if (bitsLeft != 8) {
                        bits.readBits(bitsLeft);
                        return;
                    }
                    return;
                }
                if ((edifactValue & 32) == 0) {
                    edifactValue |= 64;
                }
                result.append((char) edifactValue);
            }
            if (bits.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeBase256Segment(BitSource bits, StringBuilder result, Collection<byte[]> byteSegments) throws FormatException {
        int count;
        int codewordPosition = bits.getByteOffset() + 1;
        int codewordPosition2 = codewordPosition + 1;
        int d1 = unrandomize255State(bits.readBits(8), codewordPosition);
        if (d1 == 0) {
            count = bits.available() / 8;
        } else if (d1 < 250) {
            count = d1;
        } else {
            count = unrandomize255State(bits.readBits(8), codewordPosition2) + ((d1 - 249) * 250);
            codewordPosition2++;
        }
        if (count >= 0) {
            byte[] bytes = new byte[count];
            int i = 0;
            while (i < count) {
                if (bits.available() >= 8) {
                    bytes[i] = (byte) unrandomize255State(bits.readBits(8), codewordPosition2);
                    i++;
                    codewordPosition2++;
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            byteSegments.add(bytes);
            try {
                result.append(new String(bytes, "ISO8859_1"));
            } catch (UnsupportedEncodingException uee) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(uee)));
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static int unrandomize255State(int randomizedBase256Codeword, int base256CodewordPosition) {
        int tempVariable = randomizedBase256Codeword - (((base256CodewordPosition * 149) % 255) + 1);
        return tempVariable >= 0 ? tempVariable : tempVariable + 256;
    }
}
