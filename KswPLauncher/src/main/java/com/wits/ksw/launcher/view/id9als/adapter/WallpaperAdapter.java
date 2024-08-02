package com.wits.ksw.launcher.view.id9als.adapter;

import android.os.RemoteException;
import android.support.v7.widget.GridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.WallpaperPicBean;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.listener.FocusTouchListener;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;

public class WallpaperAdapter extends BaseQuickAdapter<WallpaperPicBean, BaseViewHolder> {
    private GridLayoutManager layoutManager;
    private FocusTouchListener mOnTouchListener = new FocusTouchListener();
    private int selectPosition = -1;

    public WallpaperAdapter(GridLayoutManager layoutManager2, int layoutResId) {
        super(layoutResId, new ArrayList());
        this.layoutManager = layoutManager2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<WallpaperPicBean> data) {
        this.selectPosition = -1;
        super.setNewData(data);
    }

    public int getSelectPosition() {
        return this.selectPosition;
    }

    public void setSelectPosition(int selectPosition2) {
        this.selectPosition = selectPosition2;
    }

    private boolean isPathSelect(String path) {
        try {
            if (!"4".equals(PowerManagerApp.getSettingsString(Id9AlsConstants.ID9ALS_SKIN_WALLPAPER))) {
                return false;
            }
            return SpfUtils.getString(Id9AlsConstants.ID9ALS_SKIN_WALLPAPER_PATH, "").equals(path);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, WallpaperPicBean item) {
        try {
            ImageView imageView = (ImageView) helper.getView(R.id.picIv);
            if (imageView != null) {
                ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load(item.getPath()).placeholder((int) R.drawable.id6_music_album_default)).error(R.drawable.id6_music_album_default)).into(imageView);
                if (helper.getAdapterPosition() == this.selectPosition) {
                    imageView.requestFocus();
                } else {
                    imageView.clearFocus();
                }
                imageView.setOnTouchListener(this.mOnTouchListener);
                helper.setVisible(R.id.picCheckIv, isPathSelect(item.getPath())).addOnClickListener(R.id.picIv);
                imageView.setOnKeyListener(new View.OnKeyListener(helper) {
                    /* class com.wits.ksw.launcher.view.id9als.adapter.$$Lambda$WallpaperAdapter$KQfd5Ax3Cdklx0gFTuJudMhsWP8 */
                    public final /* synthetic */ BaseViewHolder f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        return WallpaperAdapter.this.lambda$convert$0$WallpaperAdapter(this.f$1, view, i, keyEvent);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ boolean lambda$convert$0$WallpaperAdapter(BaseViewHolder helper, View v, int keyCode, KeyEvent event) {
        View view;
        if ((keyCode == 21 || keyCode == 19) && event.getAction() == 0) {
            int selectPosition2 = helper.getAdapterPosition();
            if (selectPosition2 <= 0 || (view = this.layoutManager.findViewByPosition(selectPosition2 - 1)) == null) {
                return false;
            }
            return view.requestFocus();
        } else if ((keyCode != 22 && keyCode != 20) || event.getAction() != 0) {
            return false;
        } else {
            int nextPosition = helper.getAdapterPosition() + 1;
            if (nextPosition >= getItemCount()) {
                return true;
            }
            View view2 = this.layoutManager.findViewByPosition(nextPosition);
            if (view2 != null) {
                return view2.requestFocus();
            }
            return false;
        }
    }
}
