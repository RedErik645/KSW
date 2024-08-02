package com.wits.ksw.launcher.view.id8ug.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.AppInfo;
import java.util.List;

public class BaseAddShortcutAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> {
    public BaseAddShortcutAdapter(List<AppInfo> data) {
        super(R.layout.item_evoid8_base_add_shortcut, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, AppInfo item) {
        helper.setImageDrawable(R.id.nameImageView, item.getAppIcon()).setText(R.id.textView, item.getAppLable());
    }
}
