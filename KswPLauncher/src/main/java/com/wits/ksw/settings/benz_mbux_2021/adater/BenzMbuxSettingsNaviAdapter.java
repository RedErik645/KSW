package com.wits.ksw.settings.benz_mbux_2021.adater;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.settings.id7.bean.MapBean;
import java.util.List;

public class BenzMbuxSettingsNaviAdapter extends BaseQuickAdapter<MapBean, BaseViewHolder> {
    private final String TAG = "BenzMbuxSettingsNaviAdapter";

    public BenzMbuxSettingsNaviAdapter(List<MapBean> data) {
        super(R.layout.activity_benz_mbux_settings_navi_item, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, final MapBean item) {
        if (item != null) {
            helper.setChecked(R.id.mbux_settings_navi_item_btn, item.isCheck());
            helper.itemView.findViewById(R.id.mbux_settings_navi_item_lay).setSelected(item.isCheck());
            helper.setText(R.id.mbux_settings_navi_item_title, item.getName());
            if (item.isCheck()) {
                helper.itemView.requestFocus();
            }
            helper.itemView.findViewById(R.id.mbux_settings_navi_item_lay).setOnTouchListener(new View.OnTouchListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsNaviAdapter.AnonymousClass1 */

                public boolean onTouch(View v, MotionEvent event) {
                    Log.i("BenzMbuxSettingsNaviAdapter", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                    if (event.getAction() != 1 || v.isFocused()) {
                        return false;
                    }
                    v.requestFocus();
                    return false;
                }
            });
            helper.itemView.findViewById(R.id.mbux_settings_navi_item_lay).setOnKeyListener(new View.OnKeyListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsNaviAdapter.AnonymousClass2 */

                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    int position = BenzMbuxSettingsNaviAdapter.this.getData().indexOf(item);
                    Log.i("BenzMbuxSettingsNaviAdapter", " position " + position + " keyCode " + keyCode + " event.getAction() " + event.getAction());
                    if (keyCode == 19) {
                        return position == 0;
                    }
                    if (keyCode == 20) {
                        return position == BenzMbuxSettingsNaviAdapter.this.getData().size() - 1;
                    }
                    if (keyCode == 21 && event.getAction() == 0) {
                        KswUtils.sendKeyDownUpSync(4);
                    }
                    return false;
                }
            });
        }
    }
}
