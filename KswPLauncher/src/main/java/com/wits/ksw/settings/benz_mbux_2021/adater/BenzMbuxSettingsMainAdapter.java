package com.wits.ksw.settings.benz_mbux_2021.adater;

import android.view.KeyEvent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.bean.BenzMbuxSettingsMainBean;
import java.util.List;

public class BenzMbuxSettingsMainAdapter extends BaseQuickAdapter<BenzMbuxSettingsMainBean, BaseViewHolder> {
    private final String TAG = "BenzMbuxSettingsMainAdapter";
    private ItemClickListener mItemClickListener;

    public interface ItemClickListener {
        void onItemClick(View view, int i, BenzMbuxSettingsMainBean benzMbuxSettingsMainBean);
    }

    public BenzMbuxSettingsMainAdapter(List<BenzMbuxSettingsMainBean> data) {
        super(R.layout.benz_mbux_settings_main_item, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, final BenzMbuxSettingsMainBean item) {
        if (item != null) {
            helper.setText(R.id.benz_settings_main_item_title, item.getTitle());
            helper.setImageResource(R.id.benz_settings_main_item_icon, item.getIconId());
            helper.setBackgroundRes(R.id.benz_settings_main_item_bg, item.getBgId());
            helper.setBackgroundRes(R.id.benz_settings_main_item_divider, item.getmColor());
            helper.itemView.findViewById(R.id.benz_settings_main_item_bg).setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsMainAdapter.AnonymousClass1 */

                public void onClick(View v) {
                    if (BenzMbuxSettingsMainAdapter.this.mItemClickListener != null) {
                        BenzMbuxSettingsMainAdapter.this.mItemClickListener.onItemClick(v, BenzMbuxSettingsMainAdapter.this.getData().indexOf(item), item);
                    }
                }
            });
            helper.itemView.findViewById(R.id.benz_settings_main_item_bg).setOnKeyListener(new View.OnKeyListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsMainAdapter.AnonymousClass2 */

                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (BenzMbuxSettingsMainAdapter.this.getData().indexOf(item) == 0 && keyCode == 19) {
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }
}
