package com.wits.ksw.launcher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import java.util.ArrayList;
import java.util.List;

public class PageIndicatorView extends LinearLayout {
    private int dotSize;
    private List<View> indicatorViews;
    private Context mContext;
    private int margins;

    public PageIndicatorView(Context context) {
        this(context, null);
    }

    public PageIndicatorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = null;
        this.dotSize = 15;
        this.margins = 4;
        this.indicatorViews = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setGravity(17);
        setOrientation(0);
    }

    public void initIndicator(int count) {
        List<View> list = this.indicatorViews;
        if (list == null) {
            this.indicatorViews = new ArrayList();
        } else {
            list.clear();
            removeAllViews();
        }
        int i = this.dotSize;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(i, i);
        int i2 = this.margins;
        params.setMargins(i2, i2, i2, i2);
        for (int i3 = 0; i3 < count; i3++) {
            View view = new View(this.mContext);
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_allapp_gray);
            addView(view, params);
            this.indicatorViews.add(view);
        }
        if (this.indicatorViews.size() > 0) {
            this.indicatorViews.get(0).setBackgroundResource(R.drawable.ntg6_fy_v3_allapp_red);
        }
    }

    public void setSelectedPage(int selected) {
        for (int i = 0; i < this.indicatorViews.size(); i++) {
            if (i == selected) {
                this.indicatorViews.get(i).setBackgroundResource(R.drawable.ntg6_fy_v3_allapp_red);
            } else {
                this.indicatorViews.get(i).setBackgroundResource(R.drawable.ntg6_fy_v3_allapp_gray);
            }
        }
    }
}
