package com.wits.ksw.launcher.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class PageRecyclerView extends RecyclerView {
    private int currentPage;
    private AutoGridLayoutManager mAutoGridLayoutManager;
    private Context mContext;
    private PageIndicatorView mIndicatorView;
    private int pageMargin;
    private int realPosition;
    private int scrollState;
    private float scrollX;
    private int shortestDistance;
    private float slideDistance;
    private int spanColumn;
    private int spanRow;
    private int totalPage;
    private int totaleSize;

    public PageRecyclerView(Context context) {
        this(context, null);
    }

    public PageRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = null;
        this.slideDistance = 0.0f;
        this.scrollX = 0.0f;
        this.spanRow = 2;
        this.spanColumn = 5;
        this.totalPage = 0;
        this.currentPage = 1;
        this.pageMargin = 0;
        this.totaleSize = 0;
        this.mIndicatorView = null;
        this.realPosition = 0;
        this.scrollState = 0;
        defaultInit(context);
    }

    private void defaultInit(Context context) {
        this.mContext = context;
        this.mAutoGridLayoutManager = new AutoGridLayoutManager(this.mContext, this.spanRow, 0, false);
        setOverScrollMode(2);
    }

    public void setPageSize(int spanRow2, int spanColumn2) {
        this.spanRow = spanRow2 <= 0 ? this.spanRow : spanRow2;
        this.spanColumn = spanColumn2 <= 0 ? this.spanColumn : spanColumn2;
    }

    public void setTotalSize(int size) {
        this.totaleSize = size;
    }

    public void initCurrentPage() {
        this.currentPage = 1;
    }

    public void initScrollX() {
        this.scrollX = 0.0f;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setPageMargin(int pageMargin2) {
        this.pageMargin = pageMargin2;
    }

    public void setIndicator(PageIndicatorView indicatorView) {
        this.mIndicatorView = indicatorView;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView
    public void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        this.shortestDistance = getMeasuredWidth() / 10;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        update();
    }

    private void update() {
        int temp = (int) Math.ceil(((double) this.totaleSize) / ((double) (this.spanRow * this.spanColumn)));
        if (temp != this.totalPage) {
            this.mIndicatorView.initIndicator(temp);
            int i = this.totalPage;
            if (temp < i && this.currentPage == i) {
                this.currentPage = temp;
                smoothScrollBy(-getWidth(), 0);
            }
            this.mIndicatorView.setSelectedPage(this.currentPage - 1);
            this.totalPage = temp;
        }
        if (this.totalPage > 1) {
            this.mIndicatorView.setVisibility(0);
        } else {
            this.mIndicatorView.setVisibility(8);
        }
    }

    public void setSelectedPage(int page) {
        try {
            this.currentPage = page;
            this.mIndicatorView.setSelectedPage(page - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onScrollStateChanged(int state) {
        switch (state) {
            case 0:
                float f = this.slideDistance;
                if (f != 0.0f) {
                    this.scrollState = 0;
                    if (f < 0.0f) {
                        int ceil = (int) Math.ceil((double) (this.scrollX / ((float) getWidth())));
                        this.currentPage = ceil;
                        if (((float) (ceil * getWidth())) - this.scrollX < ((float) this.shortestDistance)) {
                            this.currentPage++;
                        }
                    } else {
                        int ceil2 = ((int) Math.ceil((double) (this.scrollX / ((float) getWidth())))) + 1;
                        this.currentPage = ceil2;
                        int i = this.totalPage;
                        if (ceil2 >= i) {
                            this.currentPage = i;
                        } else if (this.scrollX - ((float) ((ceil2 - 2) * getWidth())) < ((float) this.shortestDistance)) {
                            this.currentPage--;
                        }
                    }
                    smoothScrollBy((int) (((float) ((this.currentPage - 1) * getWidth())) - this.scrollX), 0);
                    this.mIndicatorView.setSelectedPage(this.currentPage - 1);
                    this.slideDistance = 0.0f;
                    break;
                }
                break;
            case 1:
                this.scrollState = 1;
                break;
            case 2:
                this.scrollState = 2;
                break;
        }
        super.onScrollStateChanged(state);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int velocityX, int velocityY) {
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onScrolled(int dx, int dy) {
        this.scrollX += (float) dx;
        if (this.scrollState == 1) {
            this.slideDistance += (float) dx;
        }
        super.onScrolled(dx, dy);
    }
}
