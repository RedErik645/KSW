package com.wits.ksw.settings.bmw_id8.adapter;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.settings.id7.bean.FunctionBean;
import java.util.List;

public class BmwId8SettingsLanguageAdapter extends BaseQuickAdapter<FunctionBean, BaseViewHolder> {
    private final String TAG = "BmwId8SettingsLanguageAdapter";

    public BmwId8SettingsLanguageAdapter(List<FunctionBean> data) {
        super(R.layout.bmw_id8_settings_language_item, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, final FunctionBean item) {
        if (item != null) {
            helper.setChecked(R.id.bmw_id8_settings_language_item_btn, item.isIscheck());
            helper.itemView.findViewById(R.id.bmw_id8_settings_language_item_lay).setSelected(item.isIscheck());
            helper.setText(R.id.bmw_id8_settings_language_item_btn, item.getTitle());
            helper.itemView.findViewById(R.id.bmw_id8_settings_language_item_lay).setOnTouchListener(new View.OnTouchListener() {
                /* class com.wits.ksw.settings.bmw_id8.adapter.BmwId8SettingsLanguageAdapter.AnonymousClass1 */

                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() != 1 || v.isFocused()) {
                        return false;
                    }
                    v.requestFocus();
                    return false;
                }
            });
            helper.itemView.findViewById(R.id.bmw_id8_settings_language_item_lay).setOnKeyListener(new View.OnKeyListener() {
                /* class com.wits.ksw.settings.bmw_id8.adapter.BmwId8SettingsLanguageAdapter.AnonymousClass2 */

                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    int position = BmwId8SettingsLanguageAdapter.this.getData().indexOf(item);
                    Log.i("BmwId8SettingsLanguageAdapter", " position " + position + " keyCode " + keyCode + " event.getAction() " + event.getAction());
                    if (keyCode == 19) {
                        return position == 0;
                    }
                    if (keyCode == 20) {
                        return position == BmwId8SettingsLanguageAdapter.this.getData().size() - 1;
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
