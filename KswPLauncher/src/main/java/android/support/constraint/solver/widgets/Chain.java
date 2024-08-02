package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

/* access modifiers changed from: package-private */
public class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem system, int orientation) {
        ChainHead[] chainsArray;
        int chainsSize;
        int offset;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.mHorizontalChainsSize;
            chainsArray = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.mVerticalChainsSize;
            chainsArray = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i = 0; i < chainsSize; i++) {
            ChainHead first = chainsArray[i];
            first.define();
            applyChainConstraints(constraintWidgetContainer, system, orientation, offset, first);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:299:0x0666 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x067a  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x067f  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0686  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x068e  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x06a6  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x06aa  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x06b6  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x06b9 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer r45, android.support.constraint.solver.LinearSystem r46, int r47, int r48, android.support.constraint.solver.widgets.ChainHead r49) {
        /*
        // Method dump skipped, instructions count: 1772
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ChainHead):void");
    }
}
