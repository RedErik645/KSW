package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
import kotlin.UByte;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource source) {
        super(source);
    }

    /* JADX INFO: Multiple debug info for r2v4 int: [D('subHeight' int), D('subWidth' int)] */
    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        int subWidth;
        int subHeight;
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource source = getLuminanceSource();
        int width = source.getWidth();
        int height = source.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] luminances = source.getMatrix();
            int subWidth2 = width >> 3;
            if ((width & 7) != 0) {
                subWidth = subWidth2 + 1;
            } else {
                subWidth = subWidth2;
            }
            int subWidth3 = height >> 3;
            if ((height & 7) != 0) {
                subHeight = subWidth3 + 1;
            } else {
                subHeight = subWidth3;
            }
            int[][] blackPoints = calculateBlackPoints(luminances, subWidth, subHeight, width, height);
            BitMatrix newMatrix = new BitMatrix(width, height);
            calculateThresholdForBlock(luminances, subWidth, subHeight, width, height, blackPoints, newMatrix);
            this.matrix = newMatrix;
        }
        return this.matrix;
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource source) {
        return new HybridBinarizer(source);
    }

    private static void calculateThresholdForBlock(byte[] luminances, int subWidth, int subHeight, int width, int height, int[][] blackPoints, BitMatrix matrix2) {
        int yoffset;
        int xoffset;
        int maxYOffset = height - 8;
        int maxXOffset = width - 8;
        for (int y = 0; y < subHeight; y++) {
            int yoffset2 = y << 3;
            if (yoffset2 > maxYOffset) {
                yoffset = maxYOffset;
            } else {
                yoffset = yoffset2;
            }
            int top = cap(y, 2, subHeight - 3);
            for (int x = 0; x < subWidth; x++) {
                int xoffset2 = x << 3;
                if (xoffset2 > maxXOffset) {
                    xoffset = maxXOffset;
                } else {
                    xoffset = xoffset2;
                }
                int left = cap(x, 2, subWidth - 3);
                int sum = 0;
                for (int z = -2; z <= 2; z++) {
                    int[] blackRow = blackPoints[top + z];
                    sum += blackRow[left - 2] + blackRow[left - 1] + blackRow[left] + blackRow[left + 1] + blackRow[left + 2];
                }
                thresholdBlock(luminances, xoffset, yoffset, sum / 25, width, matrix2);
            }
        }
    }

    private static int cap(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }

    private static void thresholdBlock(byte[] luminances, int xoffset, int yoffset, int threshold, int stride, BitMatrix matrix2) {
        int y = 0;
        int offset = (yoffset * stride) + xoffset;
        while (y < 8) {
            for (int x = 0; x < 8; x++) {
                if ((luminances[offset + x] & UByte.MAX_VALUE) <= threshold) {
                    matrix2.set(xoffset + x, yoffset + y);
                }
            }
            y++;
            offset += stride;
        }
    }

    private static int[][] calculateBlackPoints(byte[] luminances, int subWidth, int subHeight, int width, int height) {
        char c;
        int maxYOffset = height - 8;
        int maxXOffset = width - 8;
        char c2 = 2;
        int[] iArr = new int[2];
        boolean z = true;
        iArr[1] = subWidth;
        iArr[0] = subHeight;
        int[][] blackPoints = (int[][]) Array.newInstance(int.class, iArr);
        int y = 0;
        while (y < subHeight) {
            int i = y << 3;
            int yoffset = i;
            if (i > maxYOffset) {
                yoffset = maxYOffset;
            }
            int x = 0;
            while (x < subWidth) {
                int i2 = x << 3;
                int xoffset = i2;
                if (i2 > maxXOffset) {
                    xoffset = maxXOffset;
                }
                int sum = 0;
                int min = 255;
                int max = 0;
                int yy = 0;
                int offset = (yoffset * width) + xoffset;
                while (true) {
                    if (yy >= 8) {
                        break;
                    }
                    int xx = 0;
                    for (int i3 = 8; xx < i3; i3 = 8) {
                        int pixel = luminances[offset + xx] & UByte.MAX_VALUE;
                        sum += pixel;
                        if (pixel < min) {
                            min = pixel;
                        }
                        if (pixel > max) {
                            max = pixel;
                        }
                        xx++;
                    }
                    if (max - min <= 24) {
                        yy++;
                        offset += width;
                    }
                    while (true) {
                        yy++;
                        offset += width;
                        if (yy >= 8) {
                            break;
                        }
                        int xx2 = 0;
                        for (int i4 = 8; xx2 < i4; i4 = 8) {
                            sum += luminances[offset + xx2] & UByte.MAX_VALUE;
                            xx2++;
                        }
                    }
                    yy++;
                    offset += width;
                }
                int average = sum >> 6;
                if (max - min <= 24) {
                    average = min / 2;
                    if (y <= 0 || x <= 0) {
                        c = 2;
                    } else {
                        c = 2;
                        int averageNeighborBlackPoint = ((blackPoints[y - 1][x] + (blackPoints[y][x - 1] * 2)) + blackPoints[y - 1][x - 1]) / 4;
                        if (min < averageNeighborBlackPoint) {
                            average = averageNeighborBlackPoint;
                        }
                    }
                } else {
                    c = 2;
                }
                blackPoints[y][x] = average;
                x++;
                z = true;
                c2 = c;
            }
            y++;
            c2 = c2;
        }
        return blackPoints;
    }
}
