package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix image2) throws NotFoundException {
        this(image2, 10, image2.getWidth() / 2, image2.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix image2, int initSize, int x, int y) throws NotFoundException {
        this.image = image2;
        int height2 = image2.getHeight();
        this.height = height2;
        int width2 = image2.getWidth();
        this.width = width2;
        int halfsize = initSize / 2;
        int i = x - halfsize;
        this.leftInit = i;
        int i2 = x + halfsize;
        this.rightInit = i2;
        int i3 = y - halfsize;
        this.upInit = i3;
        int i4 = y + halfsize;
        this.downInit = i4;
        if (i3 < 0 || i < 0 || i4 >= height2 || i2 >= width2) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public ResultPoint[] detect() throws NotFoundException {
        int down;
        int left = this.leftInit;
        int right = this.rightInit;
        int up = this.upInit;
        int down2 = this.downInit;
        boolean sizeExceeded = false;
        boolean aBlackPointFoundOnBorder = true;
        boolean atLeastOneBlackPointFoundOnBorder = false;
        boolean atLeastOneBlackPointFoundOnRight = false;
        boolean atLeastOneBlackPointFoundOnBottom = false;
        boolean atLeastOneBlackPointFoundOnLeft = false;
        boolean atLeastOneBlackPointFoundOnTop = false;
        while (true) {
            if (!aBlackPointFoundOnBorder) {
                break;
            }
            aBlackPointFoundOnBorder = false;
            boolean rightBorderNotWhite = true;
            while (true) {
                if ((rightBorderNotWhite || !atLeastOneBlackPointFoundOnRight) && right < this.width) {
                    boolean containsBlackPoint = containsBlackPoint(up, down2, right, false);
                    rightBorderNotWhite = containsBlackPoint;
                    if (containsBlackPoint) {
                        right++;
                        aBlackPointFoundOnBorder = true;
                        atLeastOneBlackPointFoundOnRight = true;
                    } else if (!atLeastOneBlackPointFoundOnRight) {
                        right++;
                    }
                }
            }
            if (right >= this.width) {
                sizeExceeded = true;
                break;
            }
            boolean bottomBorderNotWhite = true;
            while (true) {
                if ((bottomBorderNotWhite || !atLeastOneBlackPointFoundOnBottom) && down2 < this.height) {
                    boolean containsBlackPoint2 = containsBlackPoint(left, right, down2, true);
                    bottomBorderNotWhite = containsBlackPoint2;
                    if (containsBlackPoint2) {
                        down2++;
                        aBlackPointFoundOnBorder = true;
                        atLeastOneBlackPointFoundOnBottom = true;
                    } else if (!atLeastOneBlackPointFoundOnBottom) {
                        down2++;
                    }
                }
            }
            if (down2 >= this.height) {
                sizeExceeded = true;
                break;
            }
            boolean leftBorderNotWhite = true;
            while (true) {
                if ((leftBorderNotWhite || !atLeastOneBlackPointFoundOnLeft) && left >= 0) {
                    boolean containsBlackPoint3 = containsBlackPoint(up, down2, left, false);
                    leftBorderNotWhite = containsBlackPoint3;
                    if (containsBlackPoint3) {
                        left--;
                        aBlackPointFoundOnBorder = true;
                        atLeastOneBlackPointFoundOnLeft = true;
                    } else if (!atLeastOneBlackPointFoundOnLeft) {
                        left--;
                    }
                }
            }
            if (left < 0) {
                sizeExceeded = true;
                break;
            }
            boolean topBorderNotWhite = true;
            while (true) {
                if (topBorderNotWhite || !atLeastOneBlackPointFoundOnTop) {
                    if (up < 0) {
                        down = down2;
                        break;
                    }
                    boolean containsBlackPoint4 = containsBlackPoint(left, right, up, true);
                    topBorderNotWhite = containsBlackPoint4;
                    if (containsBlackPoint4) {
                        up--;
                        aBlackPointFoundOnBorder = true;
                        atLeastOneBlackPointFoundOnTop = true;
                        down2 = down2;
                    } else if (!atLeastOneBlackPointFoundOnTop) {
                        up--;
                        down2 = down2;
                    } else {
                        down2 = down2;
                    }
                } else {
                    down = down2;
                    break;
                }
            }
            if (up < 0) {
                sizeExceeded = true;
                down2 = down;
                break;
            }
            if (aBlackPointFoundOnBorder) {
                atLeastOneBlackPointFoundOnBorder = true;
            }
            down2 = down;
        }
        if (sizeExceeded || !atLeastOneBlackPointFoundOnBorder) {
            throw NotFoundException.getNotFoundInstance();
        }
        int maxSize = right - left;
        ResultPoint z = null;
        int i = 1;
        while (z == null && i < maxSize) {
            z = getBlackPointOnSegment((float) left, (float) (down2 - i), (float) (left + i), (float) down2);
            i++;
            sizeExceeded = sizeExceeded;
            aBlackPointFoundOnBorder = aBlackPointFoundOnBorder;
            atLeastOneBlackPointFoundOnBorder = atLeastOneBlackPointFoundOnBorder;
        }
        if (z != null) {
            ResultPoint t = null;
            int i2 = 1;
            while (t == null && i2 < maxSize) {
                t = getBlackPointOnSegment((float) left, (float) (up + i2), (float) (left + i2), (float) up);
                i2++;
                left = left;
            }
            if (t != null) {
                ResultPoint x = null;
                int i3 = 1;
                while (x == null && i3 < maxSize) {
                    x = getBlackPointOnSegment((float) right, (float) (up + i3), (float) (right - i3), (float) up);
                    i3++;
                    atLeastOneBlackPointFoundOnRight = atLeastOneBlackPointFoundOnRight;
                }
                if (x != null) {
                    ResultPoint y = null;
                    int i4 = 1;
                    while (y == null && i4 < maxSize) {
                        y = getBlackPointOnSegment((float) right, (float) (down2 - i4), (float) (right - i4), (float) down2);
                        i4++;
                        right = right;
                    }
                    if (y != null) {
                        return centerEdges(y, z, x, t);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint getBlackPointOnSegment(float aX, float aY, float bX, float bY) {
        int dist = MathUtils.round(MathUtils.distance(aX, aY, bX, bY));
        float xStep = (bX - aX) / ((float) dist);
        float yStep = (bY - aY) / ((float) dist);
        for (int i = 0; i < dist; i++) {
            int x = MathUtils.round((((float) i) * xStep) + aX);
            int y = MathUtils.round((((float) i) * yStep) + aY);
            if (this.image.get(x, y)) {
                return new ResultPoint((float) x, (float) y);
            }
        }
        return null;
    }

    private ResultPoint[] centerEdges(ResultPoint y, ResultPoint z, ResultPoint x, ResultPoint t) {
        float yi = y.getX();
        float yj = y.getY();
        float zi = z.getX();
        float zj = z.getY();
        float xi = x.getX();
        float xj = x.getY();
        float ti = t.getX();
        float tj = t.getY();
        if (yi < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(ti - 1.0f, tj + 1.0f), new ResultPoint(zi + 1.0f, zj + 1.0f), new ResultPoint(xi - 1.0f, xj - 1.0f), new ResultPoint(yi + 1.0f, yj - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(ti + 1.0f, tj + 1.0f), new ResultPoint(zi + 1.0f, zj - 1.0f), new ResultPoint(xi - 1.0f, xj + 1.0f), new ResultPoint(yi - 1.0f, yj - 1.0f)};
    }

    private boolean containsBlackPoint(int a, int b, int fixed, boolean horizontal) {
        if (horizontal) {
            for (int x = a; x <= b; x++) {
                if (this.image.get(x, fixed)) {
                    return true;
                }
            }
            return false;
        }
        for (int y = a; y <= b; y++) {
            if (this.image.get(fixed, y)) {
                return true;
            }
        }
        return false;
    }
}
