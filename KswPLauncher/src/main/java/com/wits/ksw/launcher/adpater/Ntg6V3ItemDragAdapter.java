package com.wits.ksw.launcher.adpater;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.AppInfo;
import java.util.List;

public class Ntg6V3ItemDragAdapter extends BaseItemDraggableAdapter<AppInfo, BaseViewHolder> {
    public Ntg6V3ItemDragAdapter(List<AppInfo> data) {
        super(R.layout.ntg6v3_all_app_item, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, AppInfo item) {
        helper.setImageDrawable(R.id.nameImageView, item.getAppIcon()).setText(R.id.textView, item.getAppLable());
    }
}
