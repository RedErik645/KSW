package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    public Detector(BitMatrix image2) throws NotFoundException {
        this.image = image2;
        this.rectangleDetector = new WhiteRectangleDetector(image2);
    }

    /* JADX INFO: Multiple debug info for r1v6 com.google.zxing.ResultPoint: [D('topLeft' com.google.zxing.ResultPoint), D('bottomLeft' com.google.zxing.ResultPoint)] */
    public DetectorResult detect() throws NotFoundException {
        ResultPoint topRight;
        char c;
        ResultPoint bottomRight;
        BitMatrix bits;
        ResultPoint correctedTopRight;
        ResultPoint topLeft;
        ResultPoint topRight2;
        ResultPoint pointD;
        int dimensionTop;
        int dimensionRight;
        ResultPoint[] cornerPoints = this.rectangleDetector.detect();
        ResultPoint pointA = cornerPoints[0];
        ResultPoint pointB = cornerPoints[1];
        ResultPoint pointC = cornerPoints[2];
        ResultPoint pointD2 = cornerPoints[3];
        List<ResultPointsAndTransitions> transitions = new ArrayList<>(4);
        transitions.add(transitionsBetween(pointA, pointB));
        transitions.add(transitionsBetween(pointA, pointC));
        transitions.add(transitionsBetween(pointB, pointD2));
        transitions.add(transitionsBetween(pointC, pointD2));
        Collections.sort(transitions, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions lSideOne = transitions.get(0);
        ResultPointsAndTransitions lSideTwo = transitions.get(1);
        Map<ResultPoint, Integer> pointCount = new HashMap<>();
        increment(pointCount, lSideOne.getFrom());
        increment(pointCount, lSideOne.getTo());
        increment(pointCount, lSideTwo.getFrom());
        increment(pointCount, lSideTwo.getTo());
        ResultPoint bottomLeft = null;
        ResultPoint maybeBottomRight = null;
        ResultPoint maybeTopLeft = null;
        for (Map.Entry<ResultPoint, Integer> entry : pointCount.entrySet()) {
            ResultPoint point = entry.getKey();
            if (entry.getValue().intValue() == 2) {
                bottomLeft = point;
            } else if (maybeTopLeft == null) {
                maybeTopLeft = point;
            } else {
                maybeBottomRight = point;
            }
        }
        if (maybeTopLeft == null || bottomLeft == null || maybeBottomRight == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint[] corners = {maybeTopLeft, bottomLeft, maybeBottomRight};
        ResultPoint.orderBestPatterns(corners);
        ResultPoint bottomRight2 = corners[0];
        ResultPoint bottomLeft2 = corners[1];
        ResultPoint bottomLeft3 = corners[2];
        if (!pointCount.containsKey(pointA)) {
            topRight = pointA;
        } else if (!pointCount.containsKey(pointB)) {
            topRight = pointB;
        } else if (!pointCount.containsKey(pointC)) {
            topRight = pointC;
        } else {
            topRight = pointD2;
        }
        int dimensionTop2 = transitionsBetween(bottomLeft3, topRight).getTransitions();
        int dimensionRight2 = transitionsBetween(bottomRight2, topRight).getTransitions();
        if ((dimensionTop2 & 1) == 1) {
            dimensionTop2++;
        }
        int dimensionTop3 = dimensionTop2 + 2;
        if ((dimensionRight2 & 1) == 1) {
            dimensionRight2++;
        }
        int dimensionRight3 = dimensionRight2 + 2;
        if (dimensionTop3 * 4 >= dimensionRight3 * 7) {
            topRight2 = topRight;
            pointD = bottomLeft3;
        } else if (dimensionRight3 * 4 >= dimensionTop3 * 7) {
            topRight2 = topRight;
            pointD = bottomLeft3;
        } else {
            ResultPoint correctTopRight = correctTopRight(bottomLeft2, bottomRight2, bottomLeft3, topRight, Math.min(dimensionRight3, dimensionTop3));
            correctedTopRight = correctTopRight;
            if (correctTopRight == null) {
                correctedTopRight = topRight;
            }
            int dimensionCorrected = Math.max(transitionsBetween(bottomLeft3, correctedTopRight).getTransitions(), transitionsBetween(bottomRight2, correctedTopRight).getTransitions()) + 1;
            if ((dimensionCorrected & 1) == 1) {
                dimensionCorrected++;
            }
            bits = sampleGrid(this.image, bottomLeft3, bottomLeft2, bottomRight2, correctedTopRight, dimensionCorrected, dimensionCorrected);
            bottomRight = bottomRight2;
            topLeft = bottomLeft3;
            c = 3;
            ResultPoint[] resultPointArr = new ResultPoint[4];
            resultPointArr[0] = topLeft;
            resultPointArr[1] = bottomLeft2;
            resultPointArr[2] = bottomRight;
            resultPointArr[c] = correctedTopRight;
            return new DetectorResult(bits, resultPointArr);
        }
        bottomRight = bottomRight2;
        c = 3;
        ResultPoint correctTopRightRectangular = correctTopRightRectangular(bottomLeft2, bottomRight2, pointD, topRight2, dimensionTop3, dimensionRight3);
        correctedTopRight = correctTopRightRectangular;
        if (correctTopRightRectangular == null) {
            correctedTopRight = topRight2;
        }
        topLeft = pointD;
        int dimensionTop4 = transitionsBetween(topLeft, correctedTopRight).getTransitions();
        int dimensionRight4 = transitionsBetween(bottomRight, correctedTopRight).getTransitions();
        if ((dimensionTop4 & 1) == 1) {
            dimensionTop = dimensionTop4 + 1;
        } else {
            dimensionTop = dimensionTop4;
        }
        if ((dimensionRight4 & 1) == 1) {
            dimensionRight = dimensionRight4 + 1;
        } else {
            dimensionRight = dimensionRight4;
        }
        bits = sampleGrid(this.image, topLeft, bottomLeft2, bottomRight, correctedTopRight, dimensionTop, dimensionRight);
        ResultPoint[] resultPointArr2 = new ResultPoint[4];
        resultPointArr2[0] = topLeft;
        resultPointArr2[1] = bottomLeft2;
        resultPointArr2[2] = bottomRight;
        resultPointArr2[c] = correctedTopRight;
        return new DetectorResult(bits, resultPointArr2);
    }

    private ResultPoint correctTopRightRectangular(ResultPoint bottomLeft, ResultPoint bottomRight, ResultPoint topLeft, ResultPoint topRight, int dimensionTop, int dimensionRight) {
        float corr = ((float) distance(bottomLeft, bottomRight)) / ((float) dimensionTop);
        int norm = distance(topLeft, topRight);
        ResultPoint c1 = new ResultPoint(topRight.getX() + (corr * ((topRight.getX() - topLeft.getX()) / ((float) norm))), topRight.getY() + (corr * ((topRight.getY() - topLeft.getY()) / ((float) norm))));
        float corr2 = ((float) distance(bottomLeft, topLeft)) / ((float) dimensionRight);
        int norm2 = distance(bottomRight, topRight);
        ResultPoint c2 = new ResultPoint(topRight.getX() + (corr2 * ((topRight.getX() - bottomRight.getX()) / ((float) norm2))), topRight.getY() + (corr2 * ((topRight.getY() - bottomRight.getY()) / ((float) norm2))));
        if (!isValid(c1)) {
            if (isValid(c2)) {
                return c2;
            }
            return null;
        } else if (isValid(c2) && Math.abs(dimensionTop - transitionsBetween(topLeft, c1).getTransitions()) + Math.abs(dimensionRight - transitionsBetween(bottomRight, c1).getTransitions()) > Math.abs(dimensionTop - transitionsBetween(topLeft, c2).getTransitions()) + Math.abs(dimensionRight - transitionsBetween(bottomRight, c2).getTransitions())) {
            return c2;
        } else {
            return c1;
        }
    }

    private ResultPoint correctTopRight(ResultPoint bottomLeft, ResultPoint bottomRight, ResultPoint topLeft, ResultPoint topRight, int dimension) {
        float corr = ((float) distance(bottomLeft, bottomRight)) / ((float) dimension);
        int norm = distance(topLeft, topRight);
        ResultPoint c1 = new ResultPoint(topRight.getX() + (corr * ((topRight.getX() - topLeft.getX()) / ((float) norm))), topRight.getY() + (corr * ((topRight.getY() - topLeft.getY()) / ((float) norm))));
        float corr2 = ((float) distance(bottomLeft, topLeft)) / ((float) dimension);
        int norm2 = distance(bottomRight, topRight);
        ResultPoint c2 = new ResultPoint(topRight.getX() + (corr2 * ((topRight.getX() - bottomRight.getX()) / ((float) norm2))), topRight.getY() + (corr2 * ((topRight.getY() - bottomRight.getY()) / ((float) norm2))));
        if (isValid(c1)) {
            return (isValid(c2) && Math.abs(transitionsBetween(topLeft, c1).getTransitions() - transitionsBetween(bottomRight, c1).getTransitions()) > Math.abs(transitionsBetween(topLeft, c2).getTransitions() - transitionsBetween(bottomRight, c2).getTransitions())) ? c2 : c1;
        }
        if (isValid(c2)) {
            return c2;
        }
        return null;
    }

    private boolean isValid(ResultPoint p) {
        return p.getX() >= 0.0f && p.getX() < ((float) this.image.getWidth()) && p.getY() > 0.0f && p.getY() < ((float) this.image.getHeight());
    }

    private static int distance(ResultPoint a, ResultPoint b) {
        return MathUtils.round(ResultPoint.distance(a, b));
    }

    private static void increment(Map<ResultPoint, Integer> table, ResultPoint key) {
        Integer value = table.get(key);
        int i = 1;
        if (value != null) {
            i = 1 + value.intValue();
        }
        table.put(key, Integer.valueOf(i));
    }

    private static BitMatrix sampleGrid(BitMatrix image2, ResultPoint topLeft, ResultPoint bottomLeft, ResultPoint bottomRight, ResultPoint topRight, int dimensionX, int dimensionY) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(image2, dimensionX, dimensionY, 0.5f, 0.5f, ((float) dimensionX) - 0.5f, 0.5f, ((float) dimensionX) - 0.5f, ((float) dimensionY) - 0.5f, 0.5f, ((float) dimensionY) - 0.5f, topLeft.getX(), topLeft.getY(), topRight.getX(), topRight.getY(), bottomRight.getX(), bottomRight.getY(), bottomLeft.getX(), bottomLeft.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint from, ResultPoint to) {
        Detector detector = this;
        int fromX = (int) from.getX();
        int fromY = (int) from.getY();
        int toX = (int) to.getX();
        int y = (int) to.getY();
        boolean isBlack = false;
        int toY = y;
        int xstep = 1;
        boolean steep = Math.abs(y - fromY) > Math.abs(toX - fromX);
        if (steep) {
            fromX = fromY;
            fromY = fromX;
            toX = toY;
            toY = toX;
        }
        int dx = Math.abs(toX - fromX);
        int dy = Math.abs(toY - fromY);
        int error = (-dx) / 2;
        int ystep = fromY < toY ? 1 : -1;
        if (fromX >= toX) {
            xstep = -1;
        }
        int transitions = 0;
        boolean inBlack = detector.image.get(steep ? fromY : fromX, steep ? fromX : fromY);
        int x = fromX;
        int y2 = fromY;
        while (true) {
            if (x == toX) {
                break;
            }
            boolean z = detector.image.get(steep ? y2 : x, steep ? x : y2);
            isBlack = z;
            if (z != inBlack) {
                transitions++;
                inBlack = isBlack;
            }
            int i = error + dy;
            error = i;
            if (i > 0) {
                if (y2 == toY) {
                    break;
                }
                y2 += ystep;
                error -= dx;
            }
            x += xstep;
            detector = this;
            fromX = fromX;
            fromY = fromY;
        }
        return new ResultPointsAndTransitions(from, to, transitions);
    }

    /* access modifiers changed from: private */
    public static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        private ResultPointsAndTransitions(ResultPoint from2, ResultPoint to2, int transitions2) {
            this.from = from2;
            this.to = to2;
            this.transitions = transitions2;
        }

        /* access modifiers changed from: package-private */
        public ResultPoint getFrom() {
            return this.from;
        }

        /* access modifiers changed from: package-private */
        public ResultPoint getTo() {
            return this.to;
        }

        /* access modifiers changed from: package-private */
        public int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + "/" + this.to + '/' + this.transitions;
        }
    }

    /* access modifiers changed from: private */
    public static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        public int compare(ResultPointsAndTransitions o1, ResultPointsAndTransitions o2) {
            return o1.getTransitions() - o2.getTransitions();
        }
    }
}