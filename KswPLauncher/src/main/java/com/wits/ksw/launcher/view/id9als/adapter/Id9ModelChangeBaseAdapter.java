package com.wits.ksw.launcher.view.id9als.adapter;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.Id9ChangeModelBean;
import com.wits.ksw.launcher.view.id9als.listener.FocusTouchListener;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;

public class Id9ModelChangeBaseAdapter extends BaseQuickAdapter<Id9ChangeModelBean, BaseViewHolder> {
    private FocusTouchListener mOnTouchListener = new FocusTouchListener();
    private int selectPosition = -1;

    public Id9ModelChangeBaseAdapter() {
        super(R.layout.item_id9_change_model, new ArrayList());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<Id9ChangeModelBean> data) {
        super.setNewData(data);
    }

    public void setSelectPosition(int selectPosition2) {
        this.selectPosition = selectPosition2;
    }

    public int getSelectPosition() {
        return this.selectPosition;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, Id9ChangeModelBean item) {
        try {
            ImageView imageView = (ImageView) helper.getView(R.id.picIv);
            if (imageView != null) {
                imageView.setImageResource(item.getBgResId());
                if (this.selectPosition == helper.getAdapterPosition()) {
                    imageView.requestFocus();
                } else {
                    imageView.clearFocus();
                }
                imageView.setOnTouchListener(this.mOnTouchListener);
            }
            helper.setImageResource(R.id.picIv, item.getBgResId()).setText(R.id.model_title_tv, item.getTitle()).setGone(R.id.wallpaper_tips_tv, "4".equals(item.getModelId()));
            boolean isStatusShow = false;
            if (item.getItemType() == Id9ChangeModelBean.ITEM_TYPE_MODEL) {
                int tvColor = Color.parseColor("#FFD584");
                String selectModel = PowerManagerApp.getSettingsString(Id9AlsConstants.ID9ALS_SKIN_MODEL);
                if ("1".equals(item.getModelId())) {
                    if ("1".equals(selectModel)) {
                        isStatusShow = true;
                    }
                    tvColor = Color.parseColor("#FFD584");
                } else if ("2".equals(item.getModelId())) {
                    if ("2".equals(selectModel)) {
                        isStatusShow = true;
                    }
                    tvColor = Color.parseColor("#E42121");
                } else if ("3".equals(item.getModelId())) {
                    if ("3".equals(selectModel)) {
                        isStatusShow = true;
                    }
                    tvColor = Color.parseColor("#61C6FF");
                } else if ("4".equals(item.getModelId())) {
                    if ("4".equals(selectModel)) {
                        isStatusShow = true;
                    }
                    tvColor = Color.parseColor("#3BDBF7");
                } else if (Id9AlsConstants.ID9ALS_SELECT_MODEL_VITALITY.equals(item.getModelId())) {
                    if (Id9AlsConstants.ID9ALS_SELECT_MODEL_VITALITY.equals(selectModel)) {
                        isStatusShow = true;
                    }
                    tvColor = Color.parseColor("#FF62C8");
                } else if (Id9AlsConstants.ID9ALS_SELECT_MODEL_MYSTERIOUS.equals(item.getModelId())) {
                    if (Id9AlsConstants.ID9ALS_SELECT_MODEL_MYSTERIOUS.equals(selectModel)) {
                        isStatusShow = true;
                    }
                    tvColor = Color.parseColor("#CB50FF");
                } else if (Id9AlsConstants.ID9ALS_SELECT_MODEL_STEADY.equals(item.getModelId())) {
                    if (Id9AlsConstants.ID9ALS_SELECT_MODEL_STEADY.equals(selectModel)) {
                        isStatusShow = true;
                    }
                    tvColor = Color.parseColor("#D6D2DB");
                }
                ((TextView) helper.getView(R.id.model_title_tv)).setTextColor(tvColor);
            } else if (item.getItemType() == Id9ChangeModelBean.ITEM_TYPE_WALLPAPER) {
                String selectModel2 = PowerManagerApp.getSettingsString(Id9AlsConstants.ID9ALS_SKIN_WALLPAPER);
                if ("1".equals(selectModel2) && "1".equals(item.getModelId())) {
                    isStatusShow = true;
                } else if ("2".equals(selectModel2) && "2".equals(item.getModelId())) {
                    isStatusShow = true;
                } else if ("3".equals(selectModel2) && "3".equals(item.getModelId())) {
                    isStatusShow = true;
                } else if ("4".equals(selectModel2) && "4".equals(item.getModelId())) {
                    isStatusShow = true;
                }
            }
            helper.setVisible(R.id.model_status_tv, isStatusShow).setVisible(R.id.model_line_iv, isStatusShow).addOnClickListener(R.id.picIv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
