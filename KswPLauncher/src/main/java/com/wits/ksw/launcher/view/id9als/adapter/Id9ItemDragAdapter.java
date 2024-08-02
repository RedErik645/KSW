package com.wits.ksw.launcher.view.id9als.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.KswUtils;
import java.util.List;

public class Id9ItemDragAdapter extends BaseItemDraggableAdapter<View, BaseViewHolder> {
    private LinearLayout.LayoutParams layoutParams;

    public Id9ItemDragAdapter(Context mContext, List<View> data) {
        super(R.layout.item_id9_home_edit, data);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(KswUtils.dip2px(mContext, 320.0f), KswUtils.dip2px(mContext, 180.0f)));
        this.layoutParams = layoutParams2;
        layoutParams2.topMargin = KswUtils.dip2px(mContext, 8.0f);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, View item) {
        FrameLayout frameLayout = (FrameLayout) helper.getView(R.id.frame_OneLayout);
        frameLayout.removeAllViews();
        frameLayout.addView(item);
    }
}
