package com.ibm.icu.text;

import kotlin.text.Typography;

/* access modifiers changed from: package-private */
/* compiled from: NFSubstitution */
public class IntegralPartSubstitution extends NFSubstitution {
    IntegralPartSubstitution(int pos, NFRuleSet ruleSet, String description) {
        super(pos, ruleSet, description);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long number) {
        return number;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double number) {
        return Math.floor(number);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double newRuleValue, double oldRuleValue) {
        return newRuleValue + oldRuleValue;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double oldUpperBound) {
        return Double.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return Typography.less;
    }
}
