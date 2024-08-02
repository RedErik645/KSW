package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;

final class BidiWriter {
    static final char LRM_CHAR = 8206;
    static final int MASK_R_AL = 8194;
    static final char RLM_CHAR = 8207;

    BidiWriter() {
    }

    private static boolean IsCombining(int type) {
        return ((1 << type) & 448) != 0;
    }

    private static String doWriteForward(String src, int options) {
        switch (options & 10) {
            case 0:
                return src;
            case 2:
                StringBuffer dest = new StringBuffer(src.length());
                int i = 0;
                do {
                    int c = UTF16.charAt(src, i);
                    i += UTF16.getCharCount(c);
                    UTF16.append(dest, UCharacter.getMirror(c));
                } while (i < src.length());
                return dest.toString();
            case 8:
                StringBuilder dest2 = new StringBuilder(src.length());
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    char c2 = src.charAt(i2);
                    if (!Bidi.IsBidiControlChar(c2)) {
                        dest2.append(c2);
                    }
                    if (i3 >= src.length()) {
                        return dest2.toString();
                    }
                    i2 = i3;
                }
            default:
                StringBuffer dest3 = new StringBuffer(src.length());
                int i4 = 0;
                do {
                    int c3 = UTF16.charAt(src, i4);
                    i4 += UTF16.getCharCount(c3);
                    if (!Bidi.IsBidiControlChar(c3)) {
                        UTF16.append(dest3, UCharacter.getMirror(c3));
                    }
                } while (i4 < src.length());
                return dest3.toString();
        }
    }

    private static String doWriteForward(char[] text, int start, int limit, int options) {
        return doWriteForward(new String(text, start, limit - start), options);
    }

    static String writeReverse(String src, int options) {
        int c;
        StringBuffer dest = new StringBuffer(src.length());
        switch (options & 11) {
            case 0:
                int srcLength = src.length();
                do {
                    srcLength -= UTF16.getCharCount(UTF16.charAt(src, srcLength - 1));
                    dest.append(src.substring(srcLength, srcLength));
                } while (srcLength > 0);
                break;
            case 1:
                int srcLength2 = src.length();
                do {
                    do {
                        c = UTF16.charAt(src, srcLength2 - 1);
                        srcLength2 -= UTF16.getCharCount(c);
                        if (srcLength2 > 0) {
                        }
                        dest.append(src.substring(srcLength2, srcLength2));
                    } while (IsCombining(UCharacter.getType(c)));
                    dest.append(src.substring(srcLength2, srcLength2));
                } while (srcLength2 > 0);
                break;
            default:
                int srcLength3 = src.length();
                do {
                    int c2 = UTF16.charAt(src, srcLength3 - 1);
                    srcLength3 -= UTF16.getCharCount(c2);
                    if ((options & 1) != 0) {
                        while (srcLength3 > 0 && IsCombining(UCharacter.getType(c2))) {
                            c2 = UTF16.charAt(src, srcLength3 - 1);
                            srcLength3 -= UTF16.getCharCount(c2);
                        }
                    }
                    if ((options & 8) == 0 || !Bidi.IsBidiControlChar(c2)) {
                        int j = srcLength3;
                        if ((options & 2) != 0) {
                            int c3 = UCharacter.getMirror(c2);
                            UTF16.append(dest, c3);
                            j += UTF16.getCharCount(c3);
                        }
                        dest.append(src.substring(j, srcLength3));
                        continue;
                    }
                } while (srcLength3 > 0);
                break;
        }
        return dest.toString();
    }

    static String doWriteReverse(char[] text, int start, int limit, int options) {
        return writeReverse(new String(text, start, limit - start), options);
    }

    /* JADX INFO: Multiple debug info for r3v5 byte[]: [D('dirProps' byte[]), D('run' int)] */
    /* JADX INFO: Multiple debug info for r3v11 byte[]: [D('dirProps' byte[]), D('run' int)] */
    static String writeReordered(Bidi bidi, int options) {
        char uc;
        char uc2;
        char uc3;
        char uc4;
        char[] text = bidi.text;
        int runCount = bidi.countRuns();
        if ((bidi.reorderingOptions & 1) != 0) {
            options = (options | 4) & -9;
        }
        if ((bidi.reorderingOptions & 2) != 0) {
            options = (options | 8) & -5;
        }
        if (!(bidi.reorderingMode == 4 || bidi.reorderingMode == 5 || bidi.reorderingMode == 6 || bidi.reorderingMode == 3)) {
            options &= -5;
        }
        StringBuilder dest = new StringBuilder((options & 4) != 0 ? bidi.length * 2 : bidi.length);
        if ((options & 16) != 0) {
            if ((options & 4) != 0) {
                byte[] dirProps = bidi.dirProps;
                int run = runCount;
                while (true) {
                    run--;
                    if (run < 0) {
                        break;
                    }
                    BidiRun bidiRun = bidi.getVisualRun(run);
                    if (bidiRun.isEvenRun()) {
                        if (dirProps[bidiRun.limit - 1] != 0) {
                            dest.append(LRM_CHAR);
                        }
                        dest.append(doWriteReverse(text, bidiRun.start, bidiRun.limit, options & -3));
                        if (dirProps[bidiRun.start] != 0) {
                            dest.append(LRM_CHAR);
                        }
                    } else {
                        if ((Bidi.DirPropFlag(dirProps[bidiRun.start]) & 8194) == 0) {
                            dest.append(RLM_CHAR);
                        }
                        dest.append(doWriteForward(text, bidiRun.start, bidiRun.limit, options));
                        if ((Bidi.DirPropFlag(dirProps[bidiRun.limit - 1]) & 8194) == 0) {
                            dest.append(RLM_CHAR);
                        }
                    }
                }
            } else {
                int run2 = runCount;
                while (true) {
                    run2--;
                    if (run2 < 0) {
                        break;
                    }
                    BidiRun bidiRun2 = bidi.getVisualRun(run2);
                    if (bidiRun2.isEvenRun()) {
                        dest.append(doWriteReverse(text, bidiRun2.start, bidiRun2.limit, options & -3));
                    } else {
                        dest.append(doWriteForward(text, bidiRun2.start, bidiRun2.limit, options));
                    }
                }
            }
        } else if ((options & 4) == 0) {
            for (int run3 = 0; run3 < runCount; run3++) {
                BidiRun bidiRun3 = bidi.getVisualRun(run3);
                if (bidiRun3.isEvenRun()) {
                    dest.append(doWriteForward(text, bidiRun3.start, bidiRun3.limit, options & -3));
                } else {
                    dest.append(doWriteReverse(text, bidiRun3.start, bidiRun3.limit, options));
                }
            }
        } else {
            byte[] dirProps2 = bidi.dirProps;
            for (int run4 = 0; run4 < runCount; run4++) {
                BidiRun bidiRun4 = bidi.getVisualRun(run4);
                int markFlag = bidi.runs[run4].insertRemove;
                if (markFlag < 0) {
                    markFlag = 0;
                }
                if (bidiRun4.isEvenRun()) {
                    if (bidi.isInverse() && dirProps2[bidiRun4.start] != 0) {
                        markFlag |= 1;
                    }
                    if ((markFlag & 1) != 0) {
                        uc3 = LRM_CHAR;
                    } else if ((markFlag & 4) != 0) {
                        uc3 = RLM_CHAR;
                    } else {
                        uc3 = 0;
                    }
                    if (uc3 != 0) {
                        dest.append(uc3);
                    }
                    dest.append(doWriteForward(text, bidiRun4.start, bidiRun4.limit, options & -3));
                    if (bidi.isInverse() && dirProps2[bidiRun4.limit - 1] != 0) {
                        markFlag |= 2;
                    }
                    if ((markFlag & 2) != 0) {
                        uc4 = LRM_CHAR;
                    } else if ((markFlag & 8) != 0) {
                        uc4 = RLM_CHAR;
                    } else {
                        uc4 = 0;
                    }
                    if (uc4 != 0) {
                        dest.append(uc4);
                    }
                } else {
                    if (bidi.isInverse() && !bidi.testDirPropFlagAt(8194, bidiRun4.limit - 1)) {
                        markFlag |= 4;
                    }
                    if ((markFlag & 1) != 0) {
                        uc = LRM_CHAR;
                    } else if ((markFlag & 4) != 0) {
                        uc = RLM_CHAR;
                    } else {
                        uc = 0;
                    }
                    if (uc != 0) {
                        dest.append(uc);
                    }
                    dest.append(doWriteReverse(text, bidiRun4.start, bidiRun4.limit, options));
                    if (bidi.isInverse() && (Bidi.DirPropFlag(dirProps2[bidiRun4.start]) & 8194) == 0) {
                        markFlag |= 8;
                    }
                    if ((markFlag & 2) != 0) {
                        uc2 = LRM_CHAR;
                    } else if ((markFlag & 8) != 0) {
                        uc2 = RLM_CHAR;
                    } else {
                        uc2 = 0;
                    }
                    if (uc2 != 0) {
                        dest.append(uc2);
                    }
                }
            }
        }
        return dest.toString();
    }
}
