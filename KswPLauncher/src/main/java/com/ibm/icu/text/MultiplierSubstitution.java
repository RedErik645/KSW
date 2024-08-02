package com.ibm.icu.text;

import kotlin.text.Typography;

/* access modifiers changed from: package-private */
/* compiled from: NFSubstitution */
public class MultiplierSubstitution extends NFSubstitution {
    long divisor;

    MultiplierSubstitution(int pos, NFRule rule, NFRuleSet ruleSet, String description) {
        super(pos, ruleSet, description);
        long divisor2 = rule.getDivisor();
        this.divisor = divisor2;
        if (divisor2 == 0) {
            throw new IllegalStateException("Substitution with divisor 0 " + description.substring(0, pos) + " | " + description.substring(pos));
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void setDivisor(int radix, short exponent) {
        long power = NFRule.power((long) radix, exponent);
        this.divisor = power;
        if (power == 0) {
            throw new IllegalStateException("Substitution with divisor 0");
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public boolean equals(Object that) {
        return super.equals(that) && this.divisor == ((MultiplierSubstitution) that).divisor;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long number) {
        return (long) Math.floor((double) (number / this.divisor));
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double number) {
        if (this.ruleSet == null) {
            return number / ((double) this.divisor);
        }
        return Math.floor(number / ((double) this.divisor));
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double newRuleValue, double oldRuleValue) {
        return ((double) this.divisor) * newRuleValue;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double oldUpperBound) {
        return (double) this.divisor;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return Typography.less;
    }
}
