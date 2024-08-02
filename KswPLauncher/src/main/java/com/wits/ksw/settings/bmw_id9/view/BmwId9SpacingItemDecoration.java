package com.wits.ksw.settings.bmw_id9.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BmwId9SpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final int[] leftSpacing;
    private final int[] rightSpacing;

    public BmwId9SpacingItemDecoration(int[] leftSpacing2, int[] rightSpacing2) {
        this.leftSpacing = leftSpacing2;
        this.rightSpacing = rightSpacing2;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if (position != -1) {
            outRect.left = this.leftSpacing[position];
            outRect.right = this.rightSpacing[position];
        }
    }
}
