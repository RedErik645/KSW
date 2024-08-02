package com.wits.ksw.settings.bmw_id8.adapter;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.lexusls.LexusLsAppSelBean;
import java.util.List;

public class BmwId8SettingsVideoAdapter extends BaseQuickAdapter<LexusLsAppSelBean, BaseViewHolder> {
    private final String TAG = "BmwId8SettingsVideoAdapter";

    public BmwId8SettingsVideoAdapter(List<LexusLsAppSelBean> data) {
        super(R.layout.bmw_id8_settings_system_video_item, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, final LexusLsAppSelBean item) {
        if (item != null) {
            helper.setChecked(R.id.bmw_id8_settings_system_video_item_btn, item.isChecked());
            helper.setText(R.id.bmw_id8_settings_system_video_item_title, item.getAppName());
            helper.itemView.setOnTouchListener(new View.OnTouchListener() {
                /* class com.wits.ksw.settings.bmw_id8.adapter.BmwId8SettingsVideoAdapter.AnonymousClass1 */

                public boolean onTouch(View v, MotionEvent event) {
                    Log.i("BmwId8SettingsVideoAdapter", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                    if (event.getAction() != 1 || v.isFocused()) {
                        return false;
                    }
                    v.requestFocus();
                    return false;
                }
            });
            helper.itemView.setOnKeyListener(new View.OnKeyListener() {
                /* class com.wits.ksw.settings.bmw_id8.adapter.BmwId8SettingsVideoAdapter.AnonymousClass2 */

                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    int position = BmwId8SettingsVideoAdapter.this.getData().indexOf(item);
                    Log.i("BmwId8SettingsVideoAdapter", " position " + position + " keyCode " + keyCode + " event.getAction() " + event.getAction());
                    if (keyCode == 19) {
                        return position == 0;
                    }
                    if (keyCode == 20) {
                        return position == BmwId8SettingsVideoAdapter.this.getData().size() - 1;
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
