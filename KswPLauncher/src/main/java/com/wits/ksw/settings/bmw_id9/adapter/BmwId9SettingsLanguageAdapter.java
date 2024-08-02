package com.wits.ksw.settings.bmw_id9.adapter;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.settings.id7.bean.FunctionBean;
import java.util.List;

public class BmwId9SettingsLanguageAdapter extends BaseQuickAdapter<FunctionBean, BaseViewHolder> {
    private final String TAG = "BmwId9SettingsLanguageAdapter";

    public BmwId9SettingsLanguageAdapter(List<FunctionBean> data) {
        super(R.layout.bmw_id9_settings_language_item, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, final FunctionBean item) {
        if (item != null) {
            helper.setChecked(R.id.bmw_id9_settings_language_item_btn, item.isIscheck());
            helper.itemView.setSelected(item.isIscheck());
            helper.setText(R.id.bmw_id9_settings_language_item_title, item.getTitle());
            helper.itemView.setOnTouchListener(new View.OnTouchListener() {
                /* class com.wits.ksw.settings.bmw_id9.adapter.BmwId9SettingsLanguageAdapter.AnonymousClass1 */

                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() != 1 || v.isFocused()) {
                        return false;
                    }
                    v.requestFocus();
                    return false;
                }
            });
            helper.itemView.setOnKeyListener(new View.OnKeyListener() {
                /* class com.wits.ksw.settings.bmw_id9.adapter.BmwId9SettingsLanguageAdapter.AnonymousClass2 */

                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    int position = BmwId9SettingsLanguageAdapter.this.getData().indexOf(item);
                    Log.i("BmwId9SettingsLanguageAdapter", " position " + position + " keyCode " + keyCode + " event.getAction() " + event.getAction());
                    if (keyCode == 19) {
                        return position == 0;
                    }
                    if (keyCode == 20) {
                        return position == BmwId9SettingsLanguageAdapter.this.getData().size() - 1;
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
