package com.wits.ksw.launcher.view.benzntg6fy;

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
import com.wits.ksw.launcher.utils.Constants;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.List;

public class SelectWallpaperAdapter extends BaseQuickAdapter<WallpaperPicBean, BaseViewHolder> {
    private AdapterItemRequestFocusListener focusListener;
    private boolean isNeedRequest = false;
    private GridLayoutManager layoutManager;
    private int selectPosition;

    public interface AdapterItemRequestFocusListener {
        void hasRequestFocus(boolean z);
    }

    public SelectWallpaperAdapter(GridLayoutManager layoutManager2, List<WallpaperPicBean> data) {
        super(R.layout.ntg6v3_wallpaper_select_pic_item, data);
        this.layoutManager = layoutManager2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<WallpaperPicBean> data) {
        this.isNeedRequest = false;
        super.setNewData(data);
    }

    public void setAdapterItemRequestFocus(AdapterItemRequestFocusListener requestFocus) {
        this.focusListener = requestFocus;
    }

    public int getSelectPosition() {
        return this.selectPosition;
    }

    public void setSelectPosition(int selectPosition2) {
        this.selectPosition = selectPosition2;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder helper, WallpaperPicBean item) {
        AdapterItemRequestFocusListener adapterItemRequestFocusListener;
        try {
            String wallpaperPath = PowerManagerApp.getSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_ORIGINAL_PATH);
            ImageView imageView = (ImageView) helper.getView(R.id.picIv);
            ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load(item.getPath()).placeholder((int) R.drawable.id6_music_album_default)).error(R.drawable.id6_music_album_default)).into(imageView);
            boolean isSelect = item.getPath().equals(wallpaperPath) && PowerManagerApp.getSettingsInt(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL) == Constants.NTG6V3_THEME_WALLPAPER_MODEL_CUSTOM;
            if (isSelect) {
                this.selectPosition = helper.getPosition();
                if (this.isNeedRequest) {
                    boolean hasRequestFocus = helper.itemView.requestFocus();
                    if (!hasRequestFocus && (adapterItemRequestFocusListener = this.focusListener) != null) {
                        adapterItemRequestFocusListener.hasRequestFocus(hasRequestFocus);
                    }
                } else {
                    this.isNeedRequest = true;
                }
            } else {
                helper.itemView.clearFocus();
            }
            helper.setVisible(R.id.picCheckIv, isSelect);
            helper.itemView.setOnKeyListener(new View.OnKeyListener(helper) {
                /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$SelectWallpaperAdapter$3iyJsZXlr3sH6wmxR_z5voOadZY */
                public final /* synthetic */ BaseViewHolder f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    return SelectWallpaperAdapter.this.lambda$convert$0$SelectWallpaperAdapter(this.f$1, view, i, keyEvent);
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ boolean lambda$convert$0$SelectWallpaperAdapter(BaseViewHolder helper, View v, int keyCode, KeyEvent event) {
        View view;
        View view2;
        if ((keyCode == 21 || keyCode == 19) && event.getAction() == 0) {
            int selectPosition2 = helper.getPosition();
            if (selectPosition2 <= 0 || (view2 = this.layoutManager.findViewByPosition(selectPosition2 - 1)) == null) {
                return false;
            }
            return view2.requestFocus();
        } else if ((keyCode != 22 && keyCode != 20) || event.getAction() != 0) {
            return false;
        } else {
            int selectPosition3 = helper.getPosition();
            int nextPosition = selectPosition3 + 1;
            if (selectPosition3 >= getItemCount() || (view = this.layoutManager.findViewByPosition(nextPosition)) == null) {
                return false;
            }
            return view.requestFocus();
        }
    }
}
