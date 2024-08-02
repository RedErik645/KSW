package com.ibm.icu.text;

import com.ibm.icu.impl.UBiDiProps;
import com.ibm.icu.lang.UCharacter;
import java.awt.font.NumericShaper;
import java.awt.font.TextAttribute;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;

public class Bidi {
    static final byte AL = 13;
    static final byte AN = 5;
    static final byte B = 7;
    static final byte BN = 18;
    @Deprecated
    public static final int CLASS_DEFAULT = 23;
    private static final char CR = '\r';
    static final byte CS = 6;
    public static final int DIRECTION_DEFAULT_LEFT_TO_RIGHT = 126;
    public static final int DIRECTION_DEFAULT_RIGHT_TO_LEFT = 127;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    public static final short DO_MIRRORING = 2;
    static final int[] DirPropFlagE = {DirPropFlag(LRE), DirPropFlag(RLE)};
    static final int[] DirPropFlagLR = {DirPropFlag((byte) 0), DirPropFlag((byte) 1)};
    static final int DirPropFlagMultiRuns = DirPropFlag((byte) 31);
    static final int[] DirPropFlagO = {DirPropFlag(LRO), DirPropFlag(RLO)};
    static final byte EN = 2;
    static final byte ENL = 23;
    static final byte ENR = 24;
    static final byte ES = 3;
    static final byte ET = 4;
    static final int FIRSTALLOC = 10;
    static final byte FOUND_L = ((byte) DirPropFlag((byte) 0));
    static final byte FOUND_R = ((byte) DirPropFlag((byte) 1));
    static final byte FSI = 19;
    private static final int IMPTABLEVELS_COLUMNS = 8;
    private static final int IMPTABLEVELS_RES = 7;
    private static final int IMPTABPROPS_COLUMNS = 16;
    private static final int IMPTABPROPS_RES = 15;
    public static final short INSERT_LRM_FOR_NUMERIC = 4;
    static final int ISOLATE = 256;
    public static final short KEEP_BASE_COMBINING = 1;
    static final byte L = 0;
    public static final byte LEVEL_DEFAULT_LTR = 126;
    public static final byte LEVEL_DEFAULT_RTL = Byte.MAX_VALUE;
    public static final byte LEVEL_OVERRIDE = Byte.MIN_VALUE;
    private static final char LF = '\n';
    static final int LOOKING_FOR_PDI = 3;
    static final byte LRE = 11;
    static final byte LRI = 20;
    static final int LRM_AFTER = 2;
    static final int LRM_BEFORE = 1;
    static final byte LRO = 12;
    public static final byte LTR = 0;
    public static final int MAP_NOWHERE = -1;
    static final int MASK_BN_EXPLICIT;
    static final int MASK_B_S;
    static final int MASK_EMBEDDING;
    static final int MASK_EXPLICIT;
    static final int MASK_ISO;
    static final int MASK_LTR = (((((((DirPropFlag((byte) 0) | DirPropFlag((byte) 2)) | DirPropFlag(ENL)) | DirPropFlag(ENR)) | DirPropFlag(AN)) | DirPropFlag(LRE)) | DirPropFlag(LRO)) | DirPropFlag(LRI));
    static final int MASK_POSSIBLE_N;
    static final int MASK_RTL = ((((DirPropFlag((byte) 1) | DirPropFlag(AL)) | DirPropFlag(RLE)) | DirPropFlag(RLO)) | DirPropFlag(RLI));
    static final int MASK_R_AL = (DirPropFlag((byte) 1) | DirPropFlag(AL));
    static final int MASK_STRONG_EN_AN = ((((DirPropFlag((byte) 0) | DirPropFlag((byte) 1)) | DirPropFlag(AL)) | DirPropFlag((byte) 2)) | DirPropFlag(AN));
    static final int MASK_WS;
    public static final byte MAX_EXPLICIT_LEVEL = 125;
    public static final byte MIXED = 2;
    public static final byte NEUTRAL = 3;
    static final int NOT_SEEKING_STRONG = 0;
    static final byte NSM = 17;
    static final byte ON = 10;
    public static final int OPTION_DEFAULT = 0;
    public static final int OPTION_INSERT_MARKS = 1;
    public static final int OPTION_REMOVE_CONTROLS = 2;
    public static final int OPTION_STREAMING = 4;
    public static final short OUTPUT_REVERSE = 16;
    static final byte PDF = 16;
    static final byte PDI = 22;
    static final byte R = 1;
    public static final short REMOVE_BIDI_CONTROLS = 8;
    static final short REORDER_COUNT = 7;
    public static final short REORDER_DEFAULT = 0;
    public static final short REORDER_GROUP_NUMBERS_WITH_R = 2;
    public static final short REORDER_INVERSE_FOR_NUMBERS_SPECIAL = 6;
    public static final short REORDER_INVERSE_LIKE_DIRECT = 5;
    public static final short REORDER_INVERSE_NUMBERS_AS_L = 4;
    static final short REORDER_LAST_LOGICAL_TO_VISUAL = 1;
    public static final short REORDER_NUMBERS_SPECIAL = 1;
    public static final short REORDER_RUNS_ONLY = 3;
    static final byte RLE = 14;
    static final byte RLI = 21;
    static final int RLM_AFTER = 8;
    static final int RLM_BEFORE = 4;
    static final byte RLO = 15;
    public static final byte RTL = 1;
    static final byte S = 8;
    static final int SEEKING_STRONG_FOR_FSI = 2;
    static final int SEEKING_STRONG_FOR_PARA = 1;
    static final int SIMPLE_OPENINGS_COUNT = 20;
    static final int SIMPLE_PARAS_COUNT = 10;
    static final byte WS = 9;
    private static final short _AN = 3;
    private static final short _B = 6;
    private static final short _EN = 2;
    private static final short _L = 0;
    private static final short _ON = 4;
    private static final short _R = 1;
    private static final short _S = 5;
    private static final short[] groupProp = {0, 1, 2, REORDER_COUNT, 8, 3, 9, 6, 5, 4, 4, 10, 10, 12, 10, 10, 10, 11, 10, 4, 4, 4, 4, 13, 14};
    private static final short[] impAct0;
    private static final short[] impAct1;
    private static final short[] impAct2;
    private static final short[] impAct3;
    private static final byte[][] impTabL_DEFAULT;
    private static final byte[][] impTabL_GROUP_NUMBERS_WITH_R;
    private static final byte[][] impTabL_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS;
    private static final byte[][] impTabL_INVERSE_LIKE_DIRECT_WITH_MARKS;
    private static final byte[][] impTabL_INVERSE_NUMBERS_AS_L;
    private static final byte[][] impTabL_NUMBERS_SPECIAL;
    private static final short[][] impTabProps = {new short[]{1, 2, 4, 5, REORDER_COUNT, 15, 17, REORDER_COUNT, 9, REORDER_COUNT, 0, REORDER_COUNT, 3, 18, 21, 4}, new short[]{1, 34, 36, 37, 39, 47, 49, 39, 41, 39, 1, 1, 35, 50, 53, 0}, new short[]{33, 2, 36, 37, 39, 47, 49, 39, 41, 39, 2, 2, 35, 50, 53, 1}, new short[]{33, 34, 38, 38, 40, 48, 49, 40, 40, 40, 3, 3, 3, 50, 53, 1}, new short[]{33, 34, 4, 37, 39, 47, 49, 74, 11, 74, 4, 4, 35, 18, 21, 2}, new short[]{33, 34, 36, 5, 39, 47, 49, 39, 41, 76, 5, 5, 35, 50, 53, 3}, new short[]{33, 34, 6, 6, 40, 48, 49, 40, 40, 77, 6, 6, 35, 18, 21, 3}, new short[]{33, 34, 36, 37, REORDER_COUNT, 47, 49, REORDER_COUNT, 78, REORDER_COUNT, REORDER_COUNT, REORDER_COUNT, 35, 50, 53, 4}, new short[]{33, 34, 38, 38, 8, 48, 49, 8, 8, 8, 8, 8, 35, 50, 53, 4}, new short[]{33, 34, 4, 37, REORDER_COUNT, 47, 49, REORDER_COUNT, 9, REORDER_COUNT, 9, 9, 35, 18, 21, 4}, new short[]{97, 98, 4, 101, 135, 111, 113, 135, 142, 135, 10, 135, 99, 18, 21, 2}, new short[]{33, 34, 4, 37, 39, 47, 49, 39, 11, 39, 11, 11, 35, 18, 21, 2}, new short[]{97, 98, 100, 5, 135, 111, 113, 135, 142, 135, 12, 135, 99, 114, 117, 3}, new short[]{97, 98, 6, 6, 136, 112, 113, 136, 136, 136, 13, 136, 99, 18, 21, 3}, new short[]{33, 34, 132, 37, REORDER_COUNT, 47, 49, REORDER_COUNT, 14, REORDER_COUNT, 14, 14, 35, 146, 149, 4}, new short[]{33, 34, 36, 37, 39, 15, 49, 39, 41, 39, 15, 39, 35, 50, 53, 5}, new short[]{33, 34, 38, 38, 40, 16, 49, 40, 40, 40, 16, 40, 35, 50, 53, 5}, new short[]{33, 34, 36, 37, 39, 47, 17, 39, 41, 39, 17, 39, 35, 50, 53, 6}, new short[]{33, 34, 18, 37, 39, 47, 49, 83, 20, 83, 18, 18, 35, 18, 21, 0}, new short[]{97, 98, 18, 101, 135, 111, 113, 135, 142, 135, 19, 135, 99, 18, 21, 0}, new short[]{33, 34, 18, 37, 39, 47, 49, 39, 20, 39, 20, 20, 35, 18, 21, 0}, new short[]{33, 34, 21, 37, 39, 47, 49, 86, 23, 86, 21, 21, 35, 18, 21, 3}, new short[]{97, 98, 21, 101, 135, 111, 113, 135, 142, 135, 22, 135, 99, 18, 21, 3}, new short[]{33, 34, 21, 37, 39, 47, 49, 39, 23, 39, 23, 23, 35, 18, 21, 3}};
    private static final byte[][] impTabR_DEFAULT;
    private static final byte[][] impTabR_GROUP_NUMBERS_WITH_R;
    private static final byte[][] impTabR_INVERSE_LIKE_DIRECT;
    private static final byte[][] impTabR_INVERSE_LIKE_DIRECT_WITH_MARKS;
    private static final byte[][] impTabR_INVERSE_NUMBERS_AS_L;
    private static final ImpTabPair impTab_DEFAULT;
    private static final ImpTabPair impTab_GROUP_NUMBERS_WITH_R;
    private static final ImpTabPair impTab_INVERSE_FOR_NUMBERS_SPECIAL;
    private static final ImpTabPair impTab_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS;
    private static final ImpTabPair impTab_INVERSE_LIKE_DIRECT;
    private static final ImpTabPair impTab_INVERSE_LIKE_DIRECT_WITH_MARKS;
    private static final ImpTabPair impTab_INVERSE_NUMBERS_AS_L;
    private static final ImpTabPair impTab_NUMBERS_SPECIAL;
    final UBiDiProps bdp;
    int controlCount;
    BidiClassifier customClassifier;
    byte defaultParaLevel;
    byte[] dirProps;
    byte[] dirPropsMemory;
    byte direction;
    String epilogue;
    int flags;
    ImpTabPair impTabPair;
    InsertPoints insertPoints;
    boolean isGoodLogicalToVisualRunsMap;
    boolean isInverse;
    int isolateCount;
    Isolate[] isolates;
    int lastArabicPos;
    int length;
    byte[] levels;
    byte[] levelsMemory;
    int[] logicalToVisualRunsMap;
    boolean mayAllocateRuns;
    boolean mayAllocateText;
    boolean orderParagraphsLTR;
    int originalLength;
    Bidi paraBidi;
    int paraCount;
    byte paraLevel;
    byte[] paras_level;
    int[] paras_limit;
    String prologue;
    int reorderingMode;
    int reorderingOptions;
    int resultLength;
    int runCount;
    BidiRun[] runs;
    BidiRun[] runsMemory;
    BidiRun[] simpleRuns;
    char[] text;
    int trailingWSStart;

    /* access modifiers changed from: package-private */
    public static class Point {
        int flag;
        int pos;

        Point() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class InsertPoints {
        int confirmed;
        Point[] points = new Point[0];
        int size;

        InsertPoints() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class Opening {
        byte contextDir;
        int contextPos;
        short flags;
        int match;
        int position;

        Opening() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class IsoRun {
        byte contextDir;
        int contextPos;
        byte lastBase;
        byte lastStrong;
        byte level;
        short limit;
        short start;

        IsoRun() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class BracketData {
        boolean isNumbersSpecial;
        int isoRunLast;
        IsoRun[] isoRuns = new IsoRun[127];
        Opening[] openings = new Opening[20];

        BracketData() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class Isolate {
        int start1;
        int startON;
        short state;
        short stateImp;

        Isolate() {
        }
    }

    static {
        int DirPropFlag = DirPropFlag(LRE) | DirPropFlag(LRO) | DirPropFlag(RLE) | DirPropFlag(RLO) | DirPropFlag(PDF);
        MASK_EXPLICIT = DirPropFlag;
        int DirPropFlag2 = DirPropFlag(BN) | DirPropFlag;
        MASK_BN_EXPLICIT = DirPropFlag2;
        int DirPropFlag3 = DirPropFlag(LRI) | DirPropFlag(RLI) | DirPropFlag(FSI) | DirPropFlag(PDI);
        MASK_ISO = DirPropFlag3;
        int DirPropFlag4 = DirPropFlag(B) | DirPropFlag(S);
        MASK_B_S = DirPropFlag4;
        int DirPropFlag5 = DirPropFlag4 | DirPropFlag(WS) | DirPropFlag2 | DirPropFlag3;
        MASK_WS = DirPropFlag5;
        int DirPropFlag6 = DirPropFlag(ON) | DirPropFlag(CS) | DirPropFlag((byte) 3) | DirPropFlag(ET) | DirPropFlag5;
        MASK_POSSIBLE_N = DirPropFlag6;
        MASK_EMBEDDING = DirPropFlag(NSM) | DirPropFlag6;
        byte[][] bArr = {new byte[]{0, 1, 0, 2, 0, 0, 0, 0}, new byte[]{0, 1, 3, 3, LRI, LRI, 0, 1}, new byte[]{0, 1, 0, 2, RLI, RLI, 0, 2}, new byte[]{0, 1, 3, 3, LRI, LRI, 0, 2}, new byte[]{0, 33, 51, 51, ET, ET, 0, 0}, new byte[]{0, 33, 0, 50, AN, AN, 0, 0}};
        impTabL_DEFAULT = bArr;
        byte[][] bArr2 = {new byte[]{1, 0, 2, 2, 0, 0, 0, 0}, new byte[]{1, 0, 1, 3, LRI, LRI, 0, 1}, new byte[]{1, 0, 2, 2, 0, 0, 0, 1}, new byte[]{1, 0, 1, 3, AN, AN, 0, 1}, new byte[]{33, 0, 33, 3, ET, ET, 0, 0}, new byte[]{1, 0, 1, 3, AN, AN, 0, 0}};
        impTabR_DEFAULT = bArr2;
        short[] sArr = {0, 1, 2, 3, 4};
        impAct0 = sArr;
        impTab_DEFAULT = new ImpTabPair(bArr, bArr2, sArr, sArr);
        byte[][] bArr3 = {new byte[]{0, 2, NSM, NSM, 0, 0, 0, 0}, new byte[]{0, 66, 1, 1, 0, 0, 0, 0}, new byte[]{0, 2, ET, ET, FSI, FSI, 0, 1}, new byte[]{0, 34, 52, 52, 3, 3, 0, 0}, new byte[]{0, 2, ET, ET, FSI, FSI, 0, 2}};
        impTabL_NUMBERS_SPECIAL = bArr3;
        impTab_NUMBERS_SPECIAL = new ImpTabPair(bArr3, bArr2, sArr, sArr);
        byte[][] bArr4 = {new byte[]{0, 3, NSM, NSM, 0, 0, 0, 0}, new byte[]{32, 3, 1, 1, 2, 32, 32, 2}, new byte[]{32, 3, 1, 1, 2, 32, 32, 1}, new byte[]{0, 3, AN, AN, LRI, 0, 0, 1}, new byte[]{32, 3, AN, AN, ET, 32, 32, 1}, new byte[]{0, 3, AN, AN, LRI, 0, 0, 2}};
        impTabL_GROUP_NUMBERS_WITH_R = bArr4;
        byte[][] bArr5 = {new byte[]{2, 0, 1, 1, 0, 0, 0, 0}, new byte[]{2, 0, 1, 1, 0, 0, 0, 1}, new byte[]{2, 0, LRI, LRI, FSI, 0, 0, 1}, new byte[]{34, 0, ET, ET, 3, 0, 0, 0}, new byte[]{34, 0, ET, ET, 3, 0, 0, 1}};
        impTabR_GROUP_NUMBERS_WITH_R = bArr5;
        impTab_GROUP_NUMBERS_WITH_R = new ImpTabPair(bArr4, bArr5, sArr, sArr);
        byte[][] bArr6 = {new byte[]{0, 1, 0, 0, 0, 0, 0, 0}, new byte[]{0, 1, 0, 0, LRI, LRI, 0, 1}, new byte[]{0, 1, 0, 0, RLI, RLI, 0, 2}, new byte[]{0, 1, 0, 0, LRI, LRI, 0, 2}, new byte[]{32, 1, 32, 32, ET, ET, 32, 1}, new byte[]{32, 1, 32, 32, AN, AN, 32, 1}};
        impTabL_INVERSE_NUMBERS_AS_L = bArr6;
        byte[][] bArr7 = {new byte[]{1, 0, 1, 1, 0, 0, 0, 0}, new byte[]{1, 0, 1, 1, LRI, LRI, 0, 1}, new byte[]{1, 0, 1, 1, 0, 0, 0, 1}, new byte[]{1, 0, 1, 1, AN, AN, 0, 1}, new byte[]{33, 0, 33, 33, ET, ET, 0, 0}, new byte[]{1, 0, 1, 1, AN, AN, 0, 0}};
        impTabR_INVERSE_NUMBERS_AS_L = bArr7;
        impTab_INVERSE_NUMBERS_AS_L = new ImpTabPair(bArr6, bArr7, sArr, sArr);
        byte[][] bArr8 = {new byte[]{1, 0, 2, 2, 0, 0, 0, 0}, new byte[]{1, 0, 1, 2, FSI, FSI, 0, 1}, new byte[]{1, 0, 2, 2, 0, 0, 0, 1}, new byte[]{33, 48, CS, ET, 3, 3, 48, 0}, new byte[]{33, 48, CS, ET, AN, AN, 48, 3}, new byte[]{33, 48, CS, ET, AN, AN, 48, 2}, new byte[]{33, 48, CS, ET, 3, 3, 48, 1}};
        impTabR_INVERSE_LIKE_DIRECT = bArr8;
        short[] sArr2 = {0, 1, 13, 14};
        impAct1 = sArr2;
        impTab_INVERSE_LIKE_DIRECT = new ImpTabPair(bArr, bArr8, sArr, sArr2);
        byte[][] bArr9 = {new byte[]{0, 99, 0, 1, 0, 0, 0, 0}, new byte[]{0, 99, 0, 1, BN, 48, 0, ET}, new byte[]{32, 99, 32, 1, 2, 48, 32, 3}, new byte[]{0, 99, 85, 86, LRI, 48, 0, 3}, new byte[]{48, 67, 85, 86, ET, 48, 48, 3}, new byte[]{48, 67, AN, 86, LRI, 48, 48, ET}, new byte[]{48, 67, 85, CS, LRI, 48, 48, ET}};
        impTabL_INVERSE_LIKE_DIRECT_WITH_MARKS = bArr9;
        byte[][] bArr10 = {new byte[]{FSI, 0, 1, 1, 0, 0, 0, 0}, new byte[]{35, 0, 1, 1, 2, 64, 0, 1}, new byte[]{35, 0, 1, 1, 2, 64, 0, 0}, new byte[]{3, 0, 3, 54, LRI, 64, 0, 1}, new byte[]{83, 64, AN, 54, ET, 64, 64, 0}, new byte[]{83, 64, AN, 54, ET, 64, 64, 1}, new byte[]{83, 64, CS, CS, ET, 64, 64, 3}};
        impTabR_INVERSE_LIKE_DIRECT_WITH_MARKS = bArr10;
        short[] sArr3 = {0, 1, 2, 5, 6, REORDER_COUNT, 8};
        impAct2 = sArr3;
        short[] sArr4 = {0, 1, 9, 10, 11, 12};
        impAct3 = sArr4;
        impTab_INVERSE_LIKE_DIRECT_WITH_MARKS = new ImpTabPair(bArr9, bArr10, sArr3, sArr4);
        impTab_INVERSE_FOR_NUMBERS_SPECIAL = new ImpTabPair(bArr3, bArr8, sArr, sArr2);
        byte[][] bArr11 = {new byte[]{0, 98, 1, 1, 0, 0, 0, 0}, new byte[]{0, 98, 1, 1, 0, 48, 0, ET}, new byte[]{0, 98, 84, 84, FSI, 48, 0, 3}, new byte[]{48, 66, 84, 84, 3, 48, 48, 3}, new byte[]{48, 66, ET, ET, FSI, 48, 48, ET}};
        impTabL_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS = bArr11;
        impTab_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS = new ImpTabPair(bArr11, bArr10, sArr3, sArr4);
    }

    static int DirPropFlag(byte dir) {
        return 1 << dir;
    }

    /* access modifiers changed from: package-private */
    public boolean testDirPropFlagAt(int flag, int index) {
        return (DirPropFlag(this.dirProps[index]) & flag) != 0;
    }

    static final int DirPropFlagLR(byte level) {
        return DirPropFlagLR[level & 1];
    }

    static final int DirPropFlagE(byte level) {
        return DirPropFlagE[level & 1];
    }

    static final int DirPropFlagO(byte level) {
        return DirPropFlagO[level & 1];
    }

    static final byte DirFromStrong(byte strong) {
        return strong == 0 ? (byte) 0 : 1;
    }

    static final byte NoOverride(byte level) {
        return (byte) (level & Byte.MAX_VALUE);
    }

    static byte GetLRFromLevel(byte level) {
        return (byte) (level & 1);
    }

    static boolean IsDefaultLevel(byte level) {
        return (level & LEVEL_DEFAULT_LTR) == 126;
    }

    static boolean IsBidiControlChar(int c) {
        return (c & -4) == 8204 || (c >= 8234 && c <= 8238) || (c >= 8294 && c <= 8297);
    }

    /* access modifiers changed from: package-private */
    public void verifyValidPara() {
        if (this != this.paraBidi) {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: package-private */
    public void verifyValidParaOrLine() {
        Bidi para = this.paraBidi;
        if (this != para) {
            if (para == null || para != para.paraBidi) {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void verifyRange(int index, int start, int limit) {
        if (index < start || index >= limit) {
            throw new IllegalArgumentException("Value " + index + " is out of range " + start + " to " + limit);
        }
    }

    public Bidi() {
        this(0, 0);
    }

    public Bidi(int maxLength, int maxRunCount) {
        this.dirPropsMemory = new byte[1];
        this.levelsMemory = new byte[1];
        this.paras_limit = new int[10];
        this.paras_level = new byte[10];
        this.runsMemory = new BidiRun[0];
        this.simpleRuns = new BidiRun[]{new BidiRun()};
        this.customClassifier = null;
        this.insertPoints = new InsertPoints();
        if (maxLength < 0 || maxRunCount < 0) {
            throw new IllegalArgumentException();
        }
        this.bdp = UBiDiProps.INSTANCE;
        if (maxLength > 0) {
            getInitialDirPropsMemory(maxLength);
            getInitialLevelsMemory(maxLength);
        } else {
            this.mayAllocateText = true;
        }
        if (maxRunCount <= 0) {
            this.mayAllocateRuns = true;
        } else if (maxRunCount > 1) {
            getInitialRunsMemory(maxRunCount);
        }
    }

    private Object getMemory(String label, Object array, Class<?> arrayClass, boolean mayAllocate, int sizeNeeded) {
        int len = Array.getLength(array);
        if (sizeNeeded == len) {
            return array;
        }
        if (mayAllocate) {
            try {
                return Array.newInstance(arrayClass, sizeNeeded);
            } catch (Exception e) {
                throw new OutOfMemoryError("Failed to allocate memory for " + label);
            }
        } else if (sizeNeeded <= len) {
            return array;
        } else {
            throw new OutOfMemoryError("Failed to allocate memory for " + label);
        }
    }

    private void getDirPropsMemory(boolean mayAllocate, int len) {
        this.dirPropsMemory = (byte[]) getMemory("DirProps", this.dirPropsMemory, Byte.TYPE, mayAllocate, len);
    }

    /* access modifiers changed from: package-private */
    public void getDirPropsMemory(int len) {
        getDirPropsMemory(this.mayAllocateText, len);
    }

    private void getLevelsMemory(boolean mayAllocate, int len) {
        this.levelsMemory = (byte[]) getMemory("Levels", this.levelsMemory, Byte.TYPE, mayAllocate, len);
    }

    /* access modifiers changed from: package-private */
    public void getLevelsMemory(int len) {
        getLevelsMemory(this.mayAllocateText, len);
    }

    private void getRunsMemory(boolean mayAllocate, int len) {
        this.runsMemory = (BidiRun[]) getMemory("Runs", this.runsMemory, BidiRun.class, mayAllocate, len);
    }

    /* access modifiers changed from: package-private */
    public void getRunsMemory(int len) {
        getRunsMemory(this.mayAllocateRuns, len);
    }

    private void getInitialDirPropsMemory(int len) {
        getDirPropsMemory(true, len);
    }

    private void getInitialLevelsMemory(int len) {
        getLevelsMemory(true, len);
    }

    private void getInitialRunsMemory(int len) {
        getRunsMemory(true, len);
    }

    public void setInverse(boolean isInverse2) {
        this.isInverse = isInverse2;
        this.reorderingMode = isInverse2 ? 4 : 0;
    }

    public boolean isInverse() {
        return this.isInverse;
    }

    public void setReorderingMode(int reorderingMode2) {
        if (reorderingMode2 >= 0 && reorderingMode2 < 7) {
            this.reorderingMode = reorderingMode2;
            this.isInverse = reorderingMode2 == 4;
        }
    }

    public int getReorderingMode() {
        return this.reorderingMode;
    }

    public void setReorderingOptions(int options) {
        if ((options & 2) != 0) {
            this.reorderingOptions = options & -2;
        } else {
            this.reorderingOptions = options;
        }
    }

    public int getReorderingOptions() {
        return this.reorderingOptions;
    }

    public static byte getBaseDirection(CharSequence paragraph) {
        if (paragraph == null || paragraph.length() == 0) {
            return 3;
        }
        int length2 = paragraph.length();
        int i = 0;
        while (i < length2) {
            byte direction2 = UCharacter.getDirectionality(UCharacter.codePointAt(paragraph, i));
            if (direction2 == 0) {
                return 0;
            }
            if (direction2 == 1 || direction2 == 13) {
                return 1;
            }
            i = UCharacter.offsetByCodePoints(paragraph, i, 1);
        }
        return 3;
    }

    private byte firstL_R_AL() {
        byte result = ON;
        int i = 0;
        while (i < this.prologue.length()) {
            int uchar = this.prologue.codePointAt(i);
            i += Character.charCount(uchar);
            byte dirProp = (byte) getCustomizedClass(uchar);
            if (result == 10) {
                if (dirProp == 0 || dirProp == 1 || dirProp == 13) {
                    result = dirProp;
                }
            } else if (dirProp == 7) {
                result = ON;
            }
        }
        return result;
    }

    private void checkParaCount() {
        int count = this.paraCount;
        byte[] bArr = this.paras_level;
        if (count > bArr.length) {
            int oldLength = bArr.length;
            int[] saveLimits = this.paras_limit;
            byte[] saveLevels = this.paras_level;
            try {
                int[] iArr = new int[(count * 2)];
                this.paras_limit = iArr;
                this.paras_level = new byte[(count * 2)];
                System.arraycopy(saveLimits, 0, iArr, 0, oldLength);
                System.arraycopy(saveLevels, 0, this.paras_level, 0, oldLength);
            } catch (Exception e) {
                throw new OutOfMemoryError("Failed to allocate memory for paras");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0161, code lost:
        if (r23.text[r1] == '\n') goto L_0x01e4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getDirProps() {
        /*
        // Method dump skipped, instructions count: 624
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.Bidi.getDirProps():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte GetParaLevelAt(int r4) {
        /*
            r3 = this;
            byte r0 = r3.defaultParaLevel
            if (r0 == 0) goto L_0x0024
            int[] r0 = r3.paras_limit
            r1 = 0
            r0 = r0[r1]
            if (r4 >= r0) goto L_0x000c
            goto L_0x0024
        L_0x000c:
            r0 = 1
        L_0x000d:
            int r1 = r3.paraCount
            if (r0 >= r1) goto L_0x001b
            int[] r2 = r3.paras_limit
            r2 = r2[r0]
            if (r4 >= r2) goto L_0x0018
            goto L_0x001b
        L_0x0018:
            int r0 = r0 + 1
            goto L_0x000d
        L_0x001b:
            if (r0 < r1) goto L_0x001f
            int r0 = r1 + -1
        L_0x001f:
            byte[] r1 = r3.paras_level
            byte r1 = r1[r0]
            return r1
        L_0x0024:
            byte r0 = r3.paraLevel
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.Bidi.GetParaLevelAt(int):byte");
    }

    private void bracketInit(BracketData bd) {
        boolean z = false;
        bd.isoRunLast = 0;
        bd.isoRuns[0] = new IsoRun();
        bd.isoRuns[0].start = 0;
        bd.isoRuns[0].limit = 0;
        bd.isoRuns[0].level = GetParaLevelAt(0);
        IsoRun isoRun = bd.isoRuns[0];
        IsoRun isoRun2 = bd.isoRuns[0];
        IsoRun isoRun3 = bd.isoRuns[0];
        byte GetParaLevelAt = (byte) (GetParaLevelAt(0) & 1);
        isoRun3.contextDir = GetParaLevelAt;
        isoRun2.lastBase = GetParaLevelAt;
        isoRun.lastStrong = GetParaLevelAt;
        bd.isoRuns[0].contextPos = 0;
        bd.openings = new Opening[20];
        int i = this.reorderingMode;
        if (i == 1 || i == 6) {
            z = true;
        }
        bd.isNumbersSpecial = z;
    }

    private void bracketProcessB(BracketData bd, byte level) {
        bd.isoRunLast = 0;
        bd.isoRuns[0].limit = 0;
        bd.isoRuns[0].level = level;
        IsoRun isoRun = bd.isoRuns[0];
        IsoRun isoRun2 = bd.isoRuns[0];
        byte b = (byte) (level & 1);
        bd.isoRuns[0].contextDir = b;
        isoRun2.lastBase = b;
        isoRun.lastStrong = b;
        bd.isoRuns[0].contextPos = 0;
    }

    private void bracketProcessBoundary(BracketData bd, int lastCcPos, byte contextLevel, byte embeddingLevel) {
        IsoRun pLastIsoRun = bd.isoRuns[bd.isoRunLast];
        if ((DirPropFlag(this.dirProps[lastCcPos]) & MASK_ISO) == 0) {
            if (NoOverride(embeddingLevel) > NoOverride(contextLevel)) {
                contextLevel = embeddingLevel;
            }
            pLastIsoRun.limit = pLastIsoRun.start;
            pLastIsoRun.level = embeddingLevel;
            byte b = (byte) (contextLevel & 1);
            pLastIsoRun.contextDir = b;
            pLastIsoRun.lastBase = b;
            pLastIsoRun.lastStrong = b;
            pLastIsoRun.contextPos = lastCcPos;
        }
    }

    private void bracketProcessLRI_RLI(BracketData bd, byte level) {
        IsoRun pLastIsoRun = bd.isoRuns[bd.isoRunLast];
        pLastIsoRun.lastBase = ON;
        short lastLimit = pLastIsoRun.limit;
        bd.isoRunLast++;
        IsoRun pLastIsoRun2 = bd.isoRuns[bd.isoRunLast];
        if (pLastIsoRun2 == null) {
            IsoRun[] isoRunArr = bd.isoRuns;
            int i = bd.isoRunLast;
            IsoRun isoRun = new IsoRun();
            isoRunArr[i] = isoRun;
            pLastIsoRun2 = isoRun;
        }
        pLastIsoRun2.limit = lastLimit;
        pLastIsoRun2.start = lastLimit;
        pLastIsoRun2.level = level;
        byte b = (byte) (level & 1);
        pLastIsoRun2.contextDir = b;
        pLastIsoRun2.lastBase = b;
        pLastIsoRun2.lastStrong = b;
        pLastIsoRun2.contextPos = 0;
    }

    private void bracketProcessPDI(BracketData bd) {
        bd.isoRunLast--;
        bd.isoRuns[bd.isoRunLast].lastBase = ON;
    }

    private void bracketAddOpening(BracketData bd, char match, int position) {
        IsoRun pLastIsoRun = bd.isoRuns[bd.isoRunLast];
        if (pLastIsoRun.limit >= bd.openings.length) {
            Opening[] saveOpenings = bd.openings;
            try {
                int count = bd.openings.length;
                bd.openings = new Opening[(count * 2)];
                System.arraycopy(saveOpenings, 0, bd.openings, 0, count);
            } catch (Exception e) {
                throw new OutOfMemoryError("Failed to allocate memory for openings");
            }
        }
        Opening pOpening = bd.openings[pLastIsoRun.limit];
        if (pOpening == null) {
            Opening[] openingArr = bd.openings;
            short s = pLastIsoRun.limit;
            Opening opening = new Opening();
            openingArr[s] = opening;
            pOpening = opening;
        }
        pOpening.position = position;
        pOpening.match = match;
        pOpening.contextDir = pLastIsoRun.contextDir;
        pOpening.contextPos = pLastIsoRun.contextPos;
        pOpening.flags = 0;
        pLastIsoRun.limit = (short) (pLastIsoRun.limit + 1);
    }

    private void fixN0c(BracketData bd, int openingIndex, int newPropPosition, byte newProp) {
        IsoRun pLastIsoRun = bd.isoRuns[bd.isoRunLast];
        for (int k = openingIndex + 1; k < pLastIsoRun.limit; k++) {
            Opening qOpening = bd.openings[k];
            if (qOpening.match < 0) {
                if (newPropPosition < qOpening.contextPos) {
                    return;
                }
                if (newPropPosition >= qOpening.position) {
                    continue;
                } else if (newProp != qOpening.contextDir) {
                    int openingPosition = qOpening.position;
                    this.dirProps[openingPosition] = newProp;
                    int closingPosition = -qOpening.match;
                    this.dirProps[closingPosition] = newProp;
                    qOpening.match = 0;
                    fixN0c(bd, k, openingPosition, newProp);
                    fixN0c(bd, k, closingPosition, newProp);
                } else {
                    return;
                }
            }
        }
    }

    private byte bracketProcessClosing(BracketData bd, int openIdx, int position) {
        byte newProp;
        IsoRun pLastIsoRun = bd.isoRuns[bd.isoRunLast];
        Opening pOpening = bd.openings[openIdx];
        byte direction2 = (byte) (pLastIsoRun.level & 1);
        boolean stable = true;
        if ((direction2 == 0 && (pOpening.flags & FOUND_L) > 0) || (direction2 == 1 && (pOpening.flags & FOUND_R) > 0)) {
            newProp = direction2;
        } else if ((pOpening.flags & (FOUND_L | FOUND_R)) != 0) {
            stable = openIdx == pLastIsoRun.start;
            if (direction2 != pOpening.contextDir) {
                newProp = pOpening.contextDir;
            } else {
                newProp = direction2;
            }
        } else {
            pLastIsoRun.limit = (short) openIdx;
            return ON;
        }
        this.dirProps[pOpening.position] = newProp;
        this.dirProps[position] = newProp;
        fixN0c(bd, openIdx, pOpening.position, newProp);
        if (stable) {
            pLastIsoRun.limit = (short) openIdx;
            while (pLastIsoRun.limit > pLastIsoRun.start && bd.openings[pLastIsoRun.limit - 1].position == pOpening.position) {
                pLastIsoRun.limit = (short) (pLastIsoRun.limit - 1);
            }
        } else {
            pOpening.match = -position;
            int k = openIdx - 1;
            while (k >= pLastIsoRun.start && bd.openings[k].position == pOpening.position) {
                bd.openings[k].match = 0;
                k--;
            }
            for (int k2 = openIdx + 1; k2 < pLastIsoRun.limit; k2++) {
                Opening qOpening = bd.openings[k2];
                if (qOpening.position >= position) {
                    break;
                }
                if (qOpening.match > 0) {
                    qOpening.match = 0;
                }
            }
        }
        return newProp;
    }

    private void bracketProcessChar(BracketData bd, int position) {
        byte newProp;
        char match;
        IsoRun pLastIsoRun = bd.isoRuns[bd.isoRunLast];
        byte dirProp = this.dirProps[position];
        if (dirProp == 10) {
            char c = this.text[position];
            int idx = pLastIsoRun.limit - 1;
            while (true) {
                if (idx < pLastIsoRun.start) {
                    break;
                } else if (bd.openings[idx].match != c) {
                    idx--;
                } else {
                    byte newProp2 = bracketProcessClosing(bd, idx, position);
                    if (newProp2 == 10) {
                        c = 0;
                    } else {
                        pLastIsoRun.lastBase = ON;
                        pLastIsoRun.contextDir = newProp2;
                        pLastIsoRun.contextPos = position;
                        byte level = this.levels[position];
                        if ((level & Byte.MIN_VALUE) != 0) {
                            byte newProp3 = (byte) (level & 1);
                            pLastIsoRun.lastStrong = newProp3;
                            short flag = (short) DirPropFlag(newProp3);
                            for (int i = pLastIsoRun.start; i < idx; i++) {
                                Opening opening = bd.openings[i];
                                opening.flags = (short) (opening.flags | flag);
                            }
                            byte[] bArr = this.levels;
                            bArr[position] = (byte) (bArr[position] & Byte.MAX_VALUE);
                        }
                        byte[] bArr2 = this.levels;
                        int i2 = bd.openings[idx].position;
                        bArr2[i2] = (byte) (bArr2[i2] & Byte.MAX_VALUE);
                        return;
                    }
                }
            }
            if (c != 0) {
                match = (char) UCharacter.getBidiPairedBracket(c);
            } else {
                match = 0;
            }
            if (match != c && UCharacter.getIntPropertyValue(c, 4117) == 1) {
                if (match == 9002) {
                    bracketAddOpening(bd, 12297, position);
                } else if (match == 12297) {
                    bracketAddOpening(bd, 9002, position);
                }
                bracketAddOpening(bd, match, position);
            }
        }
        byte level2 = this.levels[position];
        if ((level2 & Byte.MIN_VALUE) != 0) {
            newProp = (byte) (level2 & 1);
            if (!(dirProp == 8 || dirProp == 9 || dirProp == 10)) {
                this.dirProps[position] = newProp;
            }
            pLastIsoRun.lastBase = newProp;
            pLastIsoRun.lastStrong = newProp;
            pLastIsoRun.contextDir = newProp;
            pLastIsoRun.contextPos = position;
        } else if (dirProp <= 1 || dirProp == 13) {
            newProp = DirFromStrong(dirProp);
            pLastIsoRun.lastBase = dirProp;
            pLastIsoRun.lastStrong = dirProp;
            pLastIsoRun.contextDir = newProp;
            pLastIsoRun.contextPos = position;
        } else if (dirProp == 2) {
            pLastIsoRun.lastBase = 2;
            if (pLastIsoRun.lastStrong == 0) {
                newProp = 0;
                if (!bd.isNumbersSpecial) {
                    this.dirProps[position] = ENL;
                }
                pLastIsoRun.contextDir = 0;
                pLastIsoRun.contextPos = position;
            } else {
                newProp = 1;
                if (pLastIsoRun.lastStrong == 13) {
                    this.dirProps[position] = AN;
                } else {
                    this.dirProps[position] = ENR;
                }
                pLastIsoRun.contextDir = 1;
                pLastIsoRun.contextPos = position;
            }
        } else if (dirProp == 5) {
            newProp = 1;
            pLastIsoRun.lastBase = AN;
            pLastIsoRun.contextDir = 1;
            pLastIsoRun.contextPos = position;
        } else if (dirProp == 17) {
            newProp = pLastIsoRun.lastBase;
            if (newProp == 10) {
                this.dirProps[position] = newProp;
            }
        } else {
            newProp = dirProp;
            pLastIsoRun.lastBase = dirProp;
        }
        if (newProp <= 1 || newProp == 13) {
            short flag2 = (short) DirPropFlag(DirFromStrong(newProp));
            for (int i3 = pLastIsoRun.start; i3 < pLastIsoRun.limit; i3++) {
                if (position > bd.openings[i3].position) {
                    Opening opening2 = bd.openings[i3];
                    opening2.flags = (short) (opening2.flags | flag2);
                }
            }
        }
    }

    private byte directionFromFlags() {
        int i = this.flags;
        if ((MASK_RTL & i) == 0 && ((i & DirPropFlag(AN)) == 0 || (this.flags & MASK_POSSIBLE_N) == 0)) {
            return 0;
        }
        if ((this.flags & MASK_LTR) == 0) {
            return 1;
        }
        return 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x026e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte resolveExplicitLevels() {
        /*
        // Method dump skipped, instructions count: 818
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.Bidi.resolveExplicitLevels():byte");
    }

    private byte checkExplicitLevels() {
        int isolateCount2 = 0;
        this.flags = 0;
        this.isolateCount = 0;
        int currentParaIndex = 0;
        int currentParaLimit = this.paras_limit[0];
        byte currentParaLevel = this.paraLevel;
        for (int i = 0; i < this.length; i++) {
            byte[] bArr = this.levels;
            byte level = bArr[i];
            byte dirProp = this.dirProps[i];
            if (dirProp == 20 || dirProp == 21) {
                isolateCount2++;
                if (isolateCount2 > this.isolateCount) {
                    this.isolateCount = isolateCount2;
                }
            } else if (dirProp == 22) {
                isolateCount2--;
            } else if (dirProp == 7) {
                isolateCount2 = 0;
            }
            if (this.defaultParaLevel != 0 && i == currentParaLimit && currentParaIndex + 1 < this.paraCount) {
                currentParaIndex++;
                currentParaLevel = this.paras_level[currentParaIndex];
                currentParaLimit = this.paras_limit[currentParaIndex];
            }
            int overrideFlag = level & Byte.MIN_VALUE;
            byte level2 = (byte) (level & Byte.MAX_VALUE);
            if (level2 < currentParaLevel || 125 < level2) {
                if (level2 != 0) {
                    throw new IllegalArgumentException("level " + ((int) level2) + " out of bounds at " + i);
                } else if (dirProp != 7) {
                    level2 = currentParaLevel;
                    bArr[i] = (byte) (level2 | overrideFlag);
                }
            }
            if (overrideFlag != 0) {
                this.flags |= DirPropFlagO(level2);
            } else {
                this.flags |= DirPropFlagE(level2) | DirPropFlag(dirProp);
            }
        }
        int i2 = this.flags;
        if ((MASK_EMBEDDING & i2) != 0) {
            this.flags = i2 | DirPropFlagLR(this.paraLevel);
        }
        return directionFromFlags();
    }

    private static short GetStateProps(short cell) {
        return (short) (cell & 31);
    }

    private static short GetActionProps(short cell) {
        return (short) (cell >> 5);
    }

    private static short GetState(byte cell) {
        return (short) (cell & RLO);
    }

    private static short GetAction(byte cell) {
        return (short) (cell >> ET);
    }

    /* access modifiers changed from: private */
    public static class ImpTabPair {
        short[][] impact;
        byte[][][] imptab;

        ImpTabPair(byte[][] table1, byte[][] table2, short[] act1, short[] act2) {
            this.imptab = new byte[][][]{table1, table2};
            this.impact = new short[][]{act1, act2};
        }
    }

    /* access modifiers changed from: private */
    public static class LevState {
        short[] impAct;
        byte[][] impTab;
        int lastStrongRTL;
        byte runLevel;
        int runStart;
        int startL2EN;
        int startON;
        short state;

        private LevState() {
        }
    }

    private void addPoint(int pos, int flag) {
        Point point = new Point();
        int len = this.insertPoints.points.length;
        if (len == 0) {
            this.insertPoints.points = new Point[10];
            len = 10;
        }
        if (this.insertPoints.size >= len) {
            Point[] savePoints = this.insertPoints.points;
            this.insertPoints.points = new Point[(len * 2)];
            System.arraycopy(savePoints, 0, this.insertPoints.points, 0, len);
        }
        point.pos = pos;
        point.flag = flag;
        this.insertPoints.points[this.insertPoints.size] = point;
        this.insertPoints.size++;
    }

    private void setLevelsOutsideIsolates(int start, int limit, byte level) {
        int isolateCount2 = 0;
        for (int k = start; k < limit; k++) {
            byte dirProp = this.dirProps[k];
            if (dirProp == 22) {
                isolateCount2--;
            }
            if (isolateCount2 == 0) {
                this.levels[k] = level;
            }
            if (dirProp == 20 || dirProp == 21) {
                isolateCount2++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processPropertySeq(com.ibm.icu.text.Bidi.LevState r20, short r21, int r22, int r23) {
        /*
        // Method dump skipped, instructions count: 510
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.Bidi.processPropertySeq(com.ibm.icu.text.Bidi$LevState, short, int, int):void");
    }

    private byte lastL_R_AL() {
        int i = this.prologue.length();
        while (i > 0) {
            int uchar = this.prologue.codePointBefore(i);
            i -= Character.charCount(uchar);
            byte dirProp = (byte) getCustomizedClass(uchar);
            if (dirProp == 0) {
                return 0;
            }
            if (dirProp == 1 || dirProp == 13) {
                return 1;
            }
            if (dirProp == 7) {
                return ET;
            }
        }
        return ET;
    }

    private byte firstL_R_AL_EN_AN() {
        int i = 0;
        while (i < this.epilogue.length()) {
            int uchar = this.epilogue.codePointAt(i);
            i += Character.charCount(uchar);
            byte dirProp = (byte) getCustomizedClass(uchar);
            if (dirProp == 0) {
                return 0;
            }
            if (dirProp == 1 || dirProp == 13) {
                return 1;
            }
            if (dirProp == 2) {
                return 2;
            }
            if (dirProp == 5) {
                return 3;
            }
        }
        return ET;
    }

    /* JADX WARNING: Removed duplicated region for block: B:99:0x01b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void resolveImplicitLevels(int r21, int r22, short r23, short r24) {
        /*
        // Method dump skipped, instructions count: 502
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.Bidi.resolveImplicitLevels(int, int, short, short):void");
    }

    private void adjustWSLevels() {
        if ((this.flags & MASK_WS) != 0) {
            int i = this.trailingWSStart;
            while (i > 0) {
                while (i > 0) {
                    i--;
                    int flag = DirPropFlag(this.dirProps[i]);
                    if ((flag & MASK_WS) == 0) {
                        break;
                    } else if (!this.orderParagraphsLTR || (DirPropFlag(B) & flag) == 0) {
                        this.levels[i] = GetParaLevelAt(i);
                    } else {
                        this.levels[i] = 0;
                    }
                }
                while (true) {
                    if (i <= 0) {
                        break;
                    }
                    i--;
                    int flag2 = DirPropFlag(this.dirProps[i]);
                    if ((MASK_BN_EXPLICIT & flag2) == 0) {
                        if (this.orderParagraphsLTR && (DirPropFlag(B) & flag2) != 0) {
                            this.levels[i] = 0;
                            break;
                        } else if ((MASK_B_S & flag2) != 0) {
                            this.levels[i] = GetParaLevelAt(i);
                            break;
                        }
                    } else {
                        byte[] bArr = this.levels;
                        bArr[i] = bArr[i + 1];
                    }
                }
            }
        }
    }

    public void setContext(String prologue2, String epilogue2) {
        String str = null;
        this.prologue = (prologue2 == null || prologue2.length() <= 0) ? null : prologue2;
        if (epilogue2 != null && epilogue2.length() > 0) {
            str = epilogue2;
        }
        this.epilogue = str;
    }

    private void setParaSuccess() {
        this.prologue = null;
        this.epilogue = null;
        this.paraBidi = this;
    }

    /* access modifiers changed from: package-private */
    public int Bidi_Min(int x, int y) {
        return x < y ? x : y;
    }

    /* access modifiers changed from: package-private */
    public int Bidi_Abs(int x) {
        return x >= 0 ? x : -x;
    }

    /* JADX INFO: Multiple debug info for r9v10 int: [D('index' int), D('logicalStart' int)] */
    /* JADX INFO: Multiple debug info for r6v13 int: [D('logicalPos' int), D('addedRuns' int)] */
    /* access modifiers changed from: package-private */
    public void setParaRunsOnly(char[] parmText, byte parmParaLevel) {
        byte saveDirection;
        int saveTrailingWSStart;
        int oldRunCount;
        int addedRuns;
        int step;
        int limit;
        int start;
        byte saveDirection2;
        int saveOptions;
        byte parmParaLevel2;
        this.reorderingMode = 0;
        int parmLength = parmText.length;
        if (parmLength == 0) {
            setPara(parmText, parmParaLevel, (byte[]) null);
            this.reorderingMode = 3;
            return;
        }
        int index = this.reorderingOptions;
        int i = 2;
        if ((index & 1) > 0) {
            int i2 = this.reorderingOptions & -2;
            this.reorderingOptions = i2;
            this.reorderingOptions = i2 | 2;
        }
        byte parmParaLevel3 = (byte) (parmParaLevel & 1);
        setPara(parmText, parmParaLevel3, (byte[]) null);
        byte[] saveLevels = new byte[this.length];
        System.arraycopy(getLevels(), 0, saveLevels, 0, this.length);
        int saveTrailingWSStart2 = this.trailingWSStart;
        String visualText = writeReordered(2);
        int[] visualMap = getVisualMap();
        this.reorderingOptions = index;
        int saveLength = this.length;
        byte saveDirection3 = this.direction;
        this.reorderingMode = 5;
        byte parmParaLevel4 = (byte) (parmParaLevel3 ^ 1);
        setPara(visualText, parmParaLevel4, (byte[]) null);
        BidiLine.getRuns(this);
        int addedRuns2 = 0;
        int oldRunCount2 = this.runCount;
        int visualStart = 0;
        int i3 = 0;
        while (i3 < oldRunCount2) {
            int runLength = this.runs[i3].limit - visualStart;
            if (runLength >= i) {
                int logicalStart = this.runs[i3].start;
                parmParaLevel2 = parmParaLevel4;
                int j = logicalStart + 1;
                while (true) {
                    saveOptions = index;
                    if (j >= logicalStart + runLength) {
                        break;
                    }
                    int index2 = visualMap[j];
                    int index1 = visualMap[j - 1];
                    if (Bidi_Abs(index2 - index1) != 1 || saveLevels[index2] != saveLevels[index1]) {
                        addedRuns2++;
                    }
                    j++;
                    index = saveOptions;
                    logicalStart = logicalStart;
                    visualText = visualText;
                }
            } else {
                parmParaLevel2 = parmParaLevel4;
                saveOptions = index;
            }
            i3++;
            visualStart += runLength;
            parmParaLevel4 = parmParaLevel2;
            index = saveOptions;
            visualText = visualText;
            i = 2;
        }
        if (addedRuns2 > 0) {
            getRunsMemory(oldRunCount2 + addedRuns2);
            int i4 = this.runCount;
            if (i4 == 1) {
                this.runsMemory[0] = this.runs[0];
            } else {
                System.arraycopy(this.runs, 0, this.runsMemory, 0, i4);
            }
            this.runs = this.runsMemory;
            this.runCount += addedRuns2;
            for (int i5 = oldRunCount2; i5 < this.runCount; i5++) {
                BidiRun[] bidiRunArr = this.runs;
                if (bidiRunArr[i5] == null) {
                    bidiRunArr[i5] = new BidiRun(0, 0, (byte) 0);
                }
            }
        }
        int i6 = oldRunCount2 - 1;
        while (i6 >= 0) {
            int newI = i6 + addedRuns2;
            int runLength2 = i6 == 0 ? this.runs[0].limit : this.runs[i6].limit - this.runs[i6 - 1].limit;
            int logicalStart2 = this.runs[i6].start;
            int indexOddBit = this.runs[i6].level & 1;
            if (runLength2 < 2) {
                if (addedRuns2 > 0) {
                    BidiRun[] bidiRunArr2 = this.runs;
                    addedRuns = addedRuns2;
                    bidiRunArr2[newI].copyFrom(bidiRunArr2[i6]);
                } else {
                    addedRuns = addedRuns2;
                }
                int addedRuns3 = visualMap[logicalStart2];
                this.runs[newI].start = addedRuns3;
                this.runs[newI].level = (byte) (saveLevels[addedRuns3] ^ indexOddBit);
                saveTrailingWSStart = saveTrailingWSStart2;
                saveDirection = saveDirection3;
                oldRunCount = oldRunCount2;
            } else {
                addedRuns = addedRuns2;
                if (indexOddBit > 0) {
                    start = logicalStart2;
                    limit = (logicalStart2 + runLength2) - 1;
                    step = 1;
                } else {
                    start = (logicalStart2 + runLength2) - 1;
                    limit = logicalStart2;
                    step = -1;
                }
                int start2 = start;
                int newI2 = newI;
                int j2 = start2;
                while (j2 != limit) {
                    int logicalStart3 = visualMap[j2];
                    int index12 = visualMap[j2 + step];
                    if (Bidi_Abs(logicalStart3 - index12) == 1 && saveLevels[logicalStart3] == saveLevels[index12]) {
                        saveDirection2 = saveDirection3;
                    } else {
                        int logicalPos = Bidi_Min(visualMap[start2], logicalStart3);
                        this.runs[newI2].start = logicalPos;
                        this.runs[newI2].level = (byte) (saveLevels[logicalPos] ^ indexOddBit);
                        BidiRun[] bidiRunArr3 = this.runs;
                        bidiRunArr3[newI2].limit = bidiRunArr3[i6].limit;
                        this.runs[i6].limit -= Bidi_Abs(j2 - start2) + 1;
                        int insertRemove = this.runs[i6].insertRemove & 10;
                        this.runs[newI2].insertRemove = insertRemove;
                        BidiRun bidiRun = this.runs[i6];
                        saveDirection2 = saveDirection3;
                        bidiRun.insertRemove = (~insertRemove) & bidiRun.insertRemove;
                        start2 = j2 + step;
                        addedRuns--;
                        newI2--;
                    }
                    j2 += step;
                    logicalStart2 = logicalStart2;
                    oldRunCount2 = oldRunCount2;
                    saveTrailingWSStart2 = saveTrailingWSStart2;
                    saveDirection3 = saveDirection2;
                }
                saveTrailingWSStart = saveTrailingWSStart2;
                saveDirection = saveDirection3;
                oldRunCount = oldRunCount2;
                if (addedRuns > 0) {
                    BidiRun[] bidiRunArr4 = this.runs;
                    bidiRunArr4[newI2].copyFrom(bidiRunArr4[i6]);
                }
                int logicalPos2 = Bidi_Min(visualMap[start2], visualMap[limit]);
                this.runs[newI2].start = logicalPos2;
                this.runs[newI2].level = (byte) (saveLevels[logicalPos2] ^ indexOddBit);
            }
            i6--;
            addedRuns2 = addedRuns;
            oldRunCount2 = oldRunCount;
            saveTrailingWSStart2 = saveTrailingWSStart;
            saveDirection3 = saveDirection;
        }
        this.paraLevel = (byte) (this.paraLevel ^ 1);
        this.text = parmText;
        this.length = saveLength;
        this.originalLength = parmLength;
        this.direction = saveDirection3;
        this.levels = saveLevels;
        this.trailingWSStart = saveTrailingWSStart2;
        if (this.runCount > 1) {
            this.direction = 2;
        }
        this.reorderingMode = 3;
    }

    public void setPara(String text2, byte paraLevel2, byte[] embeddingLevels) {
        if (text2 == null) {
            setPara(new char[0], paraLevel2, embeddingLevels);
        } else {
            setPara(text2.toCharArray(), paraLevel2, embeddingLevels);
        }
    }

    public void setPara(char[] chars, byte paraLevel2, byte[] embeddingLevels) {
        int i;
        short eor;
        short sor;
        int start;
        Isolate[] isolateArr;
        if (paraLevel2 < 126) {
            verifyRange(paraLevel2, 0, 126);
        }
        if (chars == null) {
            chars = new char[0];
        }
        if (this.reorderingMode == 3) {
            setParaRunsOnly(chars, paraLevel2);
            return;
        }
        this.paraBidi = null;
        this.text = chars;
        int length2 = chars.length;
        this.resultLength = length2;
        this.originalLength = length2;
        this.length = length2;
        this.paraLevel = paraLevel2;
        this.direction = (byte) (paraLevel2 & 1);
        this.paraCount = 1;
        this.dirProps = new byte[0];
        this.levels = new byte[0];
        this.runs = new BidiRun[0];
        this.isGoodLogicalToVisualRunsMap = false;
        this.insertPoints.size = 0;
        this.insertPoints.confirmed = 0;
        this.defaultParaLevel = IsDefaultLevel(paraLevel2) ? paraLevel2 : 0;
        int i2 = this.length;
        if (i2 == 0) {
            if (IsDefaultLevel(paraLevel2)) {
                this.paraLevel = (byte) (1 & this.paraLevel);
                this.defaultParaLevel = 0;
            }
            this.flags = DirPropFlagLR(paraLevel2);
            this.runCount = 0;
            this.paraCount = 0;
            setParaSuccess();
            return;
        }
        this.runCount = -1;
        getDirPropsMemory(i2);
        this.dirProps = this.dirPropsMemory;
        getDirProps();
        int i3 = this.length;
        this.trailingWSStart = i3;
        if (embeddingLevels == null) {
            getLevelsMemory(i3);
            this.levels = this.levelsMemory;
            this.direction = resolveExplicitLevels();
        } else {
            this.levels = embeddingLevels;
            this.direction = checkExplicitLevels();
        }
        int i4 = this.isolateCount;
        if (i4 > 0 && ((isolateArr = this.isolates) == null || isolateArr.length < i4)) {
            this.isolates = new Isolate[(i4 + 3)];
        }
        this.isolateCount = -1;
        switch (this.direction) {
            case 0:
                this.trailingWSStart = 0;
                break;
            case 1:
                this.trailingWSStart = 0;
                break;
            default:
                switch (this.reorderingMode) {
                    case 0:
                        this.impTabPair = impTab_DEFAULT;
                        break;
                    case 1:
                        this.impTabPair = impTab_NUMBERS_SPECIAL;
                        break;
                    case 2:
                        this.impTabPair = impTab_GROUP_NUMBERS_WITH_R;
                        break;
                    case 3:
                        throw new InternalError("Internal ICU error in setPara");
                    case 4:
                        this.impTabPair = impTab_INVERSE_NUMBERS_AS_L;
                        break;
                    case 5:
                        if ((this.reorderingOptions & 1) == 0) {
                            this.impTabPair = impTab_INVERSE_LIKE_DIRECT;
                            break;
                        } else {
                            this.impTabPair = impTab_INVERSE_LIKE_DIRECT_WITH_MARKS;
                            break;
                        }
                    case 6:
                        if ((this.reorderingOptions & 1) == 0) {
                            this.impTabPair = impTab_INVERSE_FOR_NUMBERS_SPECIAL;
                            break;
                        } else {
                            this.impTabPair = impTab_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS;
                            break;
                        }
                }
                if (embeddingLevels == null && this.paraCount <= 1 && (this.flags & DirPropFlagMultiRuns) == 0) {
                    resolveImplicitLevels(0, this.length, (short) GetLRFromLevel(GetParaLevelAt(0)), (short) GetLRFromLevel(GetParaLevelAt(this.length - 1)));
                } else {
                    int limit = 0;
                    byte level = GetParaLevelAt(0);
                    byte nextLevel = this.levels[0];
                    if (level < nextLevel) {
                        eor = (short) GetLRFromLevel(nextLevel);
                    } else {
                        eor = (short) GetLRFromLevel(level);
                    }
                    do {
                        int start2 = limit;
                        if (start2 <= 0 || this.dirProps[start2 - 1] != 7) {
                            sor = eor;
                        } else {
                            sor = (short) GetLRFromLevel(GetParaLevelAt(start2));
                        }
                        while (true) {
                            limit++;
                            if (limit >= this.length || (this.levels[limit] != nextLevel && (DirPropFlag(this.dirProps[limit]) & MASK_BN_EXPLICIT) == 0)) {
                                int i5 = this.length;
                            }
                        }
                        int i52 = this.length;
                        if (limit < i52) {
                            nextLevel = this.levels[limit];
                        } else {
                            nextLevel = GetParaLevelAt(i52 - 1);
                        }
                        if (NoOverride(nextLevel) < NoOverride(nextLevel)) {
                            eor = (short) GetLRFromLevel(nextLevel);
                        } else {
                            eor = (short) GetLRFromLevel(nextLevel);
                        }
                        if ((nextLevel & Byte.MIN_VALUE) == 0) {
                            resolveImplicitLevels(start2, limit, sor, eor);
                        } else {
                            do {
                                byte[] bArr = this.levels;
                                start = start2 + 1;
                                bArr[start2] = (byte) (bArr[start2] & Byte.MAX_VALUE);
                                start2 = start;
                            } while (start < limit);
                        }
                    } while (limit < this.length);
                }
                adjustWSLevels();
                break;
        }
        if (this.defaultParaLevel > 0 && (this.reorderingOptions & 1) != 0 && ((i = this.reorderingMode) == 5 || i == 6)) {
            int i6 = 0;
            while (i6 < this.paraCount) {
                int[] iArr = this.paras_limit;
                int last = iArr[i6] - 1;
                if (this.paras_level[i6] != 0) {
                    int start3 = i6 == 0 ? 0 : iArr[i6 - 1];
                    int j = last;
                    while (true) {
                        if (j >= start3) {
                            byte dirProp = this.dirProps[j];
                            if (dirProp == 0) {
                                if (j < last) {
                                    while (this.dirProps[last] == 7) {
                                        last--;
                                    }
                                }
                                addPoint(last, 4);
                            } else if ((DirPropFlag(dirProp) & MASK_R_AL) == 0) {
                                j--;
                            }
                        }
                    }
                }
                i6++;
            }
        }
        if ((this.reorderingOptions & 2) != 0) {
            this.resultLength -= this.controlCount;
        } else {
            this.resultLength += this.insertPoints.size;
        }
        setParaSuccess();
    }

    public void setPara(AttributedCharacterIterator paragraph) {
        int i;
        byte level;
        Boolean runDirection = (Boolean) paragraph.getAttribute(TextAttribute.RUN_DIRECTION);
        if (runDirection == null) {
            i = 126;
        } else {
            i = !runDirection.equals(TextAttribute.RUN_DIRECTION_LTR);
        }
        byte[] lvls = null;
        int len = paragraph.getEndIndex() - paragraph.getBeginIndex();
        byte[] embeddingLevels = new byte[len];
        char[] txt = new char[len];
        int i2 = 0;
        char ch = paragraph.first();
        while (ch != 65535) {
            txt[i2] = ch;
            Integer embedding = (Integer) paragraph.getAttribute(TextAttribute.BIDI_EMBEDDING);
            if (!(embedding == null || (level = embedding.byteValue()) == 0)) {
                if (level < 0) {
                    lvls = embeddingLevels;
                    embeddingLevels[i2] = (byte) ((0 - level) | -128);
                } else {
                    lvls = embeddingLevels;
                    embeddingLevels[i2] = level;
                }
            }
            ch = paragraph.next();
            i2++;
        }
        NumericShaper shaper = (NumericShaper) paragraph.getAttribute(TextAttribute.NUMERIC_SHAPING);
        if (shaper != null) {
            shaper.shape(txt, 0, len);
        }
        setPara(txt, i == 1 ? (byte) 1 : 0, lvls);
    }

    public void orderParagraphsLTR(boolean ordarParaLTR) {
        this.orderParagraphsLTR = ordarParaLTR;
    }

    public boolean isOrderParagraphsLTR() {
        return this.orderParagraphsLTR;
    }

    public byte getDirection() {
        verifyValidParaOrLine();
        return this.direction;
    }

    public String getTextAsString() {
        verifyValidParaOrLine();
        return new String(this.text);
    }

    public char[] getText() {
        verifyValidParaOrLine();
        return this.text;
    }

    public int getLength() {
        verifyValidParaOrLine();
        return this.originalLength;
    }

    public int getProcessedLength() {
        verifyValidParaOrLine();
        return this.length;
    }

    public int getResultLength() {
        verifyValidParaOrLine();
        return this.resultLength;
    }

    public byte getParaLevel() {
        verifyValidParaOrLine();
        return this.paraLevel;
    }

    public int countParagraphs() {
        verifyValidParaOrLine();
        return this.paraCount;
    }

    public BidiRun getParagraphByIndex(int paraIndex) {
        int paraStart;
        verifyValidParaOrLine();
        verifyRange(paraIndex, 0, this.paraCount);
        Bidi bidi = this.paraBidi;
        if (paraIndex == 0) {
            paraStart = 0;
        } else {
            paraStart = bidi.paras_limit[paraIndex - 1];
        }
        BidiRun bidiRun = new BidiRun();
        bidiRun.start = paraStart;
        bidiRun.limit = bidi.paras_limit[paraIndex];
        bidiRun.level = GetParaLevelAt(paraStart);
        return bidiRun;
    }

    public BidiRun getParagraph(int charIndex) {
        verifyValidParaOrLine();
        Bidi bidi = this.paraBidi;
        verifyRange(charIndex, 0, bidi.length);
        int paraIndex = 0;
        while (charIndex >= bidi.paras_limit[paraIndex]) {
            paraIndex++;
        }
        return getParagraphByIndex(paraIndex);
    }

    public int getParagraphIndex(int charIndex) {
        verifyValidParaOrLine();
        Bidi bidi = this.paraBidi;
        verifyRange(charIndex, 0, bidi.length);
        int paraIndex = 0;
        while (charIndex >= bidi.paras_limit[paraIndex]) {
            paraIndex++;
        }
        return paraIndex;
    }

    public void setCustomClassifier(BidiClassifier classifier) {
        this.customClassifier = classifier;
    }

    public BidiClassifier getCustomClassifier() {
        return this.customClassifier;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (r0 == 23) goto L_0x000d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCustomizedClass(int r4) {
        /*
            r3 = this;
            com.ibm.icu.text.BidiClassifier r0 = r3.customClassifier
            r1 = 23
            if (r0 == 0) goto L_0x000d
            int r0 = r0.classify(r4)
            r2 = r0
            if (r0 != r1) goto L_0x0013
        L_0x000d:
            com.ibm.icu.impl.UBiDiProps r0 = r3.bdp
            int r2 = r0.getClass(r4)
        L_0x0013:
            if (r2 < r1) goto L_0x0017
            r2 = 10
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.Bidi.getCustomizedClass(int):int");
    }

    public Bidi setLine(int start, int limit) {
        verifyValidPara();
        verifyRange(start, 0, limit);
        verifyRange(limit, 0, this.length + 1);
        if (getParagraphIndex(start) == getParagraphIndex(limit - 1)) {
            return BidiLine.setLine(this, start, limit);
        }
        throw new IllegalArgumentException();
    }

    public byte getLevelAt(int charIndex) {
        verifyValidParaOrLine();
        verifyRange(charIndex, 0, this.length);
        return BidiLine.getLevelAt(this, charIndex);
    }

    public byte[] getLevels() {
        verifyValidParaOrLine();
        if (this.length <= 0) {
            return new byte[0];
        }
        return BidiLine.getLevels(this);
    }

    public BidiRun getLogicalRun(int logicalPosition) {
        verifyValidParaOrLine();
        verifyRange(logicalPosition, 0, this.length);
        return BidiLine.getLogicalRun(this, logicalPosition);
    }

    public int countRuns() {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        return this.runCount;
    }

    public BidiRun getVisualRun(int runIndex) {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        verifyRange(runIndex, 0, this.runCount);
        return BidiLine.getVisualRun(this, runIndex);
    }

    public int getVisualIndex(int logicalIndex) {
        verifyValidParaOrLine();
        verifyRange(logicalIndex, 0, this.length);
        return BidiLine.getVisualIndex(this, logicalIndex);
    }

    public int getLogicalIndex(int visualIndex) {
        verifyValidParaOrLine();
        verifyRange(visualIndex, 0, this.resultLength);
        if (this.insertPoints.size == 0 && this.controlCount == 0) {
            byte b = this.direction;
            if (b == 0) {
                return visualIndex;
            }
            if (b == 1) {
                return (this.length - visualIndex) - 1;
            }
        }
        BidiLine.getRuns(this);
        return BidiLine.getLogicalIndex(this, visualIndex);
    }

    public int[] getLogicalMap() {
        countRuns();
        if (this.length <= 0) {
            return new int[0];
        }
        return BidiLine.getLogicalMap(this);
    }

    public int[] getVisualMap() {
        countRuns();
        if (this.resultLength <= 0) {
            return new int[0];
        }
        return BidiLine.getVisualMap(this);
    }

    public static int[] reorderLogical(byte[] levels2) {
        return BidiLine.reorderLogical(levels2);
    }

    public static int[] reorderVisual(byte[] levels2) {
        return BidiLine.reorderVisual(levels2);
    }

    public static int[] invertMap(int[] srcMap) {
        if (srcMap == null) {
            return null;
        }
        return BidiLine.invertMap(srcMap);
    }

    public Bidi(String paragraph, int flags2) {
        this(paragraph.toCharArray(), 0, null, 0, paragraph.length(), flags2);
    }

    public Bidi(AttributedCharacterIterator paragraph) {
        this();
        setPara(paragraph);
    }

    public Bidi(char[] text2, int textStart, byte[] embeddings, int embStart, int paragraphLength, int flags2) {
        this();
        byte paraLvl;
        byte[] paraEmbeddings;
        switch (flags2) {
            case 1:
                paraLvl = 1;
                break;
            case 126:
                paraLvl = LEVEL_DEFAULT_LTR;
                break;
            case 127:
                paraLvl = Byte.MAX_VALUE;
                break;
            default:
                paraLvl = 0;
                break;
        }
        if (embeddings == null) {
            paraEmbeddings = null;
        } else {
            paraEmbeddings = new byte[paragraphLength];
            for (int i = 0; i < paragraphLength; i++) {
                byte lev = embeddings[i + embStart];
                if (lev < 0) {
                    lev = (byte) ((-lev) | -128);
                }
                paraEmbeddings[i] = lev;
            }
        }
        if (textStart == 0 && paragraphLength == text2.length) {
            setPara(text2, paraLvl, paraEmbeddings);
            return;
        }
        char[] paraText = new char[paragraphLength];
        System.arraycopy(text2, textStart, paraText, 0, paragraphLength);
        setPara(paraText, paraLvl, paraEmbeddings);
    }

    public Bidi createLineBidi(int lineStart, int lineLimit) {
        return setLine(lineStart, lineLimit);
    }

    public boolean isMixed() {
        return !isLeftToRight() && !isRightToLeft();
    }

    public boolean isLeftToRight() {
        return getDirection() == 0 && (this.paraLevel & 1) == 0;
    }

    public boolean isRightToLeft() {
        return getDirection() == 1 && (this.paraLevel & 1) == 1;
    }

    public boolean baseIsLeftToRight() {
        return getParaLevel() == 0;
    }

    public int getBaseLevel() {
        return getParaLevel();
    }

    public int getRunCount() {
        return countRuns();
    }

    /* access modifiers changed from: package-private */
    public void getLogicalToVisualRunsMap() {
        if (!this.isGoodLogicalToVisualRunsMap) {
            int count = countRuns();
            int[] iArr = this.logicalToVisualRunsMap;
            if (iArr == null || iArr.length < count) {
                this.logicalToVisualRunsMap = new int[count];
            }
            long[] keys = new long[count];
            for (int i = 0; i < count; i++) {
                keys[i] = (((long) this.runs[i].start) << 32) + ((long) i);
            }
            Arrays.sort(keys);
            for (int i2 = 0; i2 < count; i2++) {
                this.logicalToVisualRunsMap[i2] = (int) (keys[i2] & -1);
            }
            this.isGoodLogicalToVisualRunsMap = true;
        }
    }

    public int getRunLevel(int run) {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        verifyRange(run, 0, this.runCount);
        getLogicalToVisualRunsMap();
        return this.runs[this.logicalToVisualRunsMap[run]].level;
    }

    public int getRunStart(int run) {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        verifyRange(run, 0, this.runCount);
        getLogicalToVisualRunsMap();
        return this.runs[this.logicalToVisualRunsMap[run]].start;
    }

    public int getRunLimit(int run) {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        verifyRange(run, 0, this.runCount);
        getLogicalToVisualRunsMap();
        int idx = this.logicalToVisualRunsMap[run];
        BidiRun[] bidiRunArr = this.runs;
        return this.runs[idx].start + (idx == 0 ? bidiRunArr[idx].limit : bidiRunArr[idx].limit - this.runs[idx - 1].limit);
    }

    public static boolean requiresBidi(char[] text2, int start, int limit) {
        for (int i = start; i < limit; i++) {
            if (((1 << UCharacter.getDirection(text2[i])) & 57378) != 0) {
                return true;
            }
        }
        return false;
    }

    public static void reorderVisually(byte[] levels2, int levelStart, Object[] objects, int objectStart, int count) {
        byte[] reorderLevels = new byte[count];
        System.arraycopy(levels2, levelStart, reorderLevels, 0, count);
        int[] indexMap = reorderVisual(reorderLevels);
        Object[] temp = new Object[count];
        System.arraycopy(objects, objectStart, temp, 0, count);
        for (int i = 0; i < count; i++) {
            objects[objectStart + i] = temp[indexMap[i]];
        }
    }

    public String writeReordered(int options) {
        verifyValidParaOrLine();
        if (this.length == 0) {
            return "";
        }
        return BidiWriter.writeReordered(this, options);
    }

    public static String writeReverse(String src, int options) {
        if (src == null) {
            throw new IllegalArgumentException();
        } else if (src.length() > 0) {
            return BidiWriter.writeReverse(src, options);
        } else {
            return "";
        }
    }
}
