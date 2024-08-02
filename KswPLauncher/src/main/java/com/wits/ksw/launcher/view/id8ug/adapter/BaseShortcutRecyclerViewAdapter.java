package com.wits.ksw.launcher.view.id8ug.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.AppInfo;
import java.util.List;

public class BaseShortcutRecyclerViewAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> {
    public BaseShortcutRecyclerViewAdapter(int layoutResId, List<AppInfo> data) {
        super(layoutResId, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, AppInfo item) {
        helper.setImageDrawable(R.id.nameImageView, item.getAppIcon());
        TextView textView = (TextView) helper.getView(R.id.textView);
        if (textView != null) {
            textView.setText(item.getAppLable());
        }
    }
}
