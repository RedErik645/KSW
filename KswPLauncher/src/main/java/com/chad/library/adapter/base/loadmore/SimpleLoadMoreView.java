package com.chad.library.adapter.base.loadmore;

import com.chad.library.R;

public final class SimpleLoadMoreView extends LoadMoreView {
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLayoutId() {
        return R.layout.brvah_quick_view_load_more;
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    /* access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}
