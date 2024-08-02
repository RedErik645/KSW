package com.wits.ksw.settings.utlis_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.support.v7.widget.RecyclerView, android.support.v4.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return 5;
    }

    @Override // android.support.v7.widget.RecyclerView, android.support.v4.view.ScrollingView
    public int computeVerticalScrollOffset() {
        int sRange = super.computeVerticalScrollRange();
        int range = sRange - super.computeVerticalScrollExtent();
        if (range == 0) {
            return 0;
        }
        return (int) ((((float) (super.computeVerticalScrollOffset() * sRange)) * 1.0f) / ((float) range));
    }
}
