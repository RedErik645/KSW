package com.wits.ksw.launcher.view.benzntg6fynew.adapter;

import android.text.TextUtils;
import android.util.Log;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.view.benzmbux2021new.bean.BenzCardItem;
import com.wits.ksw.launcher.view.benzmbux2021new.bean.BenzCardMenu;
import java.util.List;

public class BenzNtgfyNewAdapter extends BaseMultiItemQuickAdapter<BenzCardMenu, BaseViewHolder> {
    private static final String TAG = "BenzNtgfyNewAdapter";
    private BcVieModel mBcVieModel;
    private List<BenzCardMenu> mBenzCardMenuList;

    public BenzNtgfyNewAdapter(List<BenzCardMenu> data) {
        super(data);
        this.mBenzCardMenuList = data;
        addItemType(1, R.layout.benz_ntg_fy_new_recycle_item);
        addItemType(2, R.layout.benz_ntg_fy_new_recycle_item_third);
    }

    public void setCardList(List<BenzCardMenu> data) {
        this.mBenzCardMenuList = data;
        notifyDataSetChanged();
    }

    public void setmBcVieModel(BcVieModel vieModel) {
        this.mBcVieModel = vieModel;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, BenzCardMenu item) {
        int type = helper.getItemViewType();
        BenzCardItem benzCardItem = (BenzCardItem) item.getBenzCardItem();
        Log.i(TAG, "convert: benzCardItem.getName() " + benzCardItem.getName());
        if (benzCardItem.getImgSrc() != null) {
            helper.setImageDrawable(R.id.benz_mbux_2021_ksw_new_item_img, benzCardItem.getImgSrc());
        }
        helper.setImageResource(R.id.benz_mbux_2021_ksw_new_item_bg, benzCardItem.getImgBg());
        helper.setTag(R.id.benz_mbux_2021_ksw_new_item_bg, benzCardItem.getName());
        helper.addOnClickListener(R.id.benz_mbux_2021_ksw_new_item_bg);
        helper.setText(R.id.benz_mbux_2021_ksw_new_item_title, benzCardItem.getTitle());
        helper.setText(R.id.benz_mbux_2021_ksw_new_item_content, benzCardItem.getContent());
        if (type == 1) {
            helper.setImageResource(R.id.benz_mbux_2021_ksw_new_item_left_icon, benzCardItem.getIconLeft());
            helper.addOnClickListener(R.id.benz_mbux_2021_ksw_new_item_left_icon);
            helper.setImageResource(R.id.benz_mbux_2021_ksw_new_item_right_icon, benzCardItem.getIconRight());
            helper.addOnClickListener(R.id.benz_mbux_2021_ksw_new_item_right_icon);
        }
        helper.addOnClickListener(R.id.benz_mbux_edit_ok_btn);
        helper.addOnClickListener(R.id.benz_mbux_edit_left_btn);
        helper.addOnClickListener(R.id.benz_mbux_edit_right_btn);
        if (TextUtils.equals(this.mBcVieModel.selectCardName.get(), benzCardItem.getName())) {
            helper.setAlpha(R.id.benz_mbux_2021_ksw_new_item_bg, 0.5f);
            helper.setAlpha(R.id.benz_mbux_2021_ksw_new_item_img, 0.5f);
            helper.setVisible(R.id.benz_mbux_edit_lay, true);
        } else {
            helper.setAlpha(R.id.benz_mbux_2021_ksw_new_item_bg, 1.0f);
            helper.setAlpha(R.id.benz_mbux_2021_ksw_new_item_img, 1.0f);
            helper.setVisible(R.id.benz_mbux_edit_lay, false);
        }
        if (type == 2) {
            helper.addOnClickListener(R.id.benz_mbux_edit_delete_btn);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
