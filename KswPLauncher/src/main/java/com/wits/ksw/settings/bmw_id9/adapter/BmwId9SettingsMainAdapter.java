package com.wits.ksw.settings.bmw_id9.adapter;

import android.view.KeyEvent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.KeyUtils;
import com.wits.ksw.settings.bmw_id9.bean.BmwId9SettingsMainBean;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

public class BmwId9SettingsMainAdapter extends BaseQuickAdapter<BmwId9SettingsMainBean, BaseViewHolder> {
    private final String TAG = "BmwId9SettingsMainAdapter";
    private ItemClickListener mItemClickListener;

    public interface ItemClickListener {
        void onItemClick(View view, int i, BmwId9SettingsMainBean bmwId9SettingsMainBean);
    }

    public BmwId9SettingsMainAdapter(List<BmwId9SettingsMainBean> data) {
        super(R.layout.activity_bmw_id9_settings_main_item, data);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, final BmwId9SettingsMainBean item) {
        if (item != null) {
            helper.setBackgroundRes(R.id.bmw_id9_settings_main_item_bg, item.getBgId());
            helper.setImageResource(R.id.bmw_id9_settings_main_item_icon, item.getIconId());
            helper.setText(R.id.bmw_id9_settings_main_item_title, item.getTitle());
            helper.setText(R.id.bmw_id9_settings_main_item_content, item.getContent());
            helper.setTextColor(R.id.bmw_id9_settings_main_item_content, SkinCompatResources.getInstance().getColor(R.color.white));
            helper.itemView.findViewById(R.id.bmw_id9_settings_main_item_bg).setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.settings.bmw_id9.adapter.BmwId9SettingsMainAdapter.AnonymousClass1 */

                public void onClick(View v) {
                    if (BmwId9SettingsMainAdapter.this.mItemClickListener != null) {
                        BmwId9SettingsMainAdapter.this.mItemClickListener.onItemClick(v, BmwId9SettingsMainAdapter.this.getData().indexOf(item), item);
                    }
                }
            });
            helper.itemView.findViewById(R.id.bmw_id9_settings_main_item_bg).setOnKeyListener(new View.OnKeyListener() {
                /* class com.wits.ksw.settings.bmw_id9.adapter.BmwId9SettingsMainAdapter.AnonymousClass2 */

                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (BmwId9SettingsMainAdapter.this.getData().indexOf(item) == 0 && keyCode == 19) {
                        return true;
                    }
                    if (keyCode == 20 && event.getAction() == 0) {
                        KeyUtils.pressKey(22);
                        return true;
                    } else if (keyCode != 19 || event.getAction() != 0) {
                        return false;
                    } else {
                        KeyUtils.pressKey(21);
                        return true;
                    }
                }
            });
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }
}
