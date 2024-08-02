package com.wits.ksw.launcher.view.id8ug.adapter;

import android.provider.Settings;
import android.text.TextUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.settings.id7.bean.MapBean;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import java.util.List;

public class Id8GsMainNaviAdapter extends BaseQuickAdapter<MapBean, BaseViewHolder> {
    public Id8GsMainNaviAdapter(List<MapBean> data) {
        super(R.layout.item_evoid8_ug_main_navi, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, MapBean item) {
        helper.setImageDrawable(R.id.icon_iv, item.getMapicon()).setVisible(R.id.picCheckIv, TextUtils.equals(item.getPackageName(), Settings.System.getString(this.mContext.getContentResolver(), KeyConfig.NAVI_DEFUAL)));
    }
}
