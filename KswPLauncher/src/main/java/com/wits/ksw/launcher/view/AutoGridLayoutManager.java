package com.wits.ksw.launcher.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class AutoGridLayoutManager extends GridLayoutManager {
    private int measuredHeight = 0;
    private int measuredWidth = 0;
    private int totalPages;

    public AutoGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public AutoGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public AutoGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    public void setTotalPages(int totalPages2) {
        this.totalPages = totalPages2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        View view;
        if (state.getItemCount() > 0) {
            if (this.measuredHeight <= 0 && (view = recycler.getViewForPosition(0)) != null) {
                measureChild(view, widthSpec, heightSpec);
                this.measuredWidth = View.MeasureSpec.getSize(widthSpec);
                this.measuredHeight = view.getMeasuredHeight() * getSpanCount();
            }
            setMeasuredDimension(this.measuredWidth, this.measuredHeight);
            return;
        }
        super.onMeasure(recycler, state, widthSpec, heightSpec);
    }

    @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.totalPages > 1) {
            return super.scrollHorizontallyBy(dx, recycler, state);
        }
        return 0;
    }
}
