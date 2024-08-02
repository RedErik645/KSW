package com.wits.ksw.settings.benz_mbux_2021.adater;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.lexusls.LexusLsAppSelBean;
import java.util.List;

public class BenzMbuxSettingsAppListAdapter extends BaseQuickAdapter<LexusLsAppSelBean, BaseViewHolder> {
    private final String TAG = "BenzMbuxSettingsAppListAdapter";

    public BenzMbuxSettingsAppListAdapter(List<LexusLsAppSelBean> data) {
        super(R.layout.benz_mbux_settings_system_app_item, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, final LexusLsAppSelBean item) {
        if (item != null) {
            helper.setChecked(R.id.mbux_settings_system_app_item_btn, item.isChecked());
            helper.setText(R.id.mbux_settings_system_app_item_title, item.getAppName());
            helper.itemView.setOnTouchListener(new View.OnTouchListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsAppListAdapter.AnonymousClass1 */

                public boolean onTouch(View v, MotionEvent event) {
                    Log.i("BenzMbuxSettingsAppListAdapter", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                    if (event.getAction() != 1 || v.isFocused()) {
                        return false;
                    }
                    v.requestFocus();
                    return false;
                }
            });
            helper.itemView.setOnKeyListener(new View.OnKeyListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsAppListAdapter.AnonymousClass2 */

                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    int position = BenzMbuxSettingsAppListAdapter.this.getData().indexOf(item);
                    Log.i("BenzMbuxSettingsAppListAdapter", " position " + position + " keyCode " + keyCode + " event.getAction() " + event.getAction());
                    if (keyCode == 19) {
                        return position == 0;
                    }
                    if (keyCode == 20) {
                        return position == BenzMbuxSettingsAppListAdapter.this.getData().size() - 1;
                    }
                    return false;
                }
            });
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return (long) position;
    }
}
