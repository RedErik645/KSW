package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

public final class ErrorCorrection {
    private final ModulusGF field = ModulusGF.PDF417_GF;

    public int decode(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int evaluateAt = modulusPoly.evaluateAt(this.field.exp(i2));
            iArr3[i - i2] = evaluateAt;
            if (evaluateAt != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        ModulusPoly one = this.field.getOne();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int exp = this.field.exp((iArr.length - 1) - i3);
                ModulusGF modulusGF = this.field;
                one = one.multiply(new ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, exp), 1}));
            }
        }
        ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new ModulusPoly(this.field, iArr3), i);
        ModulusPoly modulusPoly2 = runEuclideanAlgorithm[0];
        ModulusPoly modulusPoly3 = runEuclideanAlgorithm[1];
        int[] findErrorLocations = findErrorLocations(modulusPoly2);
        int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, findErrorLocations);
        for (int i4 = 0; i4 < findErrorLocations.length; i4++) {
            int length = (iArr.length - 1) - this.field.log(findErrorLocations[i4]);
            if (length >= 0) {
                iArr[length] = this.field.subtract(iArr[length], findErrorMagnitudes[i4]);
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
        return findErrorLocations.length;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int i) throws ChecksumException {
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly2;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        while (true) {
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly2;
            zero = one;
            if (modulusPoly.getDegree() < i / 2) {
                int coefficient = zero.getCoefficient(0);
                if (coefficient != 0) {
                    int inverse = this.field.inverse(coefficient);
                    return new ModulusPoly[]{zero.multiply(inverse), modulusPoly.multiply(inverse)};
                }
                throw ChecksumException.getChecksumInstance();
            } else if (!modulusPoly.isZero()) {
                ModulusPoly zero2 = this.field.getZero();
                int inverse2 = this.field.inverse(modulusPoly.getCoefficient(modulusPoly.getDegree()));
                while (modulusPoly2.getDegree() >= modulusPoly.getDegree() && !modulusPoly2.isZero()) {
                    int degree = modulusPoly2.getDegree() - modulusPoly.getDegree();
                    int multiply = this.field.multiply(modulusPoly2.getCoefficient(modulusPoly2.getDegree()), inverse2);
                    zero2 = zero2.add(this.field.buildMonomial(degree, multiply));
                    modulusPoly2 = modulusPoly2.subtract(modulusPoly.multiplyByMonomial(degree, multiply));
                }
                one = zero2.multiply(zero).subtract(zero).negative();
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    private int[] findErrorLocations(ModulusPoly errorLocator) throws ChecksumException {
        int numErrors = errorLocator.getDegree();
        int[] result = new int[numErrors];
        int e = 0;
        for (int i = 1; i < this.field.getSize() && e < numErrors; i++) {
            if (errorLocator.evaluateAt(i) == 0) {
                result[e] = this.field.inverse(i);
                e++;
            }
        }
        if (e == numErrors) {
            return result;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly errorEvaluator, ModulusPoly errorLocator, int[] errorLocations) {
        int errorLocatorDegree = errorLocator.getDegree();
        int[] formalDerivativeCoefficients = new int[errorLocatorDegree];
        for (int i = 1; i <= errorLocatorDegree; i++) {
            formalDerivativeCoefficients[errorLocatorDegree - i] = this.field.multiply(i, errorLocator.getCoefficient(i));
        }
        ModulusPoly formalDerivative = new ModulusPoly(this.field, formalDerivativeCoefficients);
        int s = errorLocations.length;
        int[] result = new int[s];
        for (int i2 = 0; i2 < s; i2++) {
            int xiInverse = this.field.inverse(errorLocations[i2]);
            result[i2] = this.field.multiply(this.field.subtract(0, errorEvaluator.evaluateAt(xiInverse)), this.field.inverse(formalDerivative.evaluateAt(xiInverse)));
        }
        return result;
    }
}
