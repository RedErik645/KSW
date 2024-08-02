package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.databinding.adapters.ViewBindingAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;

public class Benz2021KswFragmentOneHdpi1280x720Impl extends Benz2021KswFragmentOne {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final BenzMbuxItemView mboundView3;
    private final BenzMbuxItemView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.navi_rl, 10);
        sparseIntArray.put(R.id.navi_tv, 11);
        sparseIntArray.put(R.id.navi_tip, 12);
        sparseIntArray.put(R.id.iv_navi1, 13);
        sparseIntArray.put(R.id.iv_navi2, 14);
        sparseIntArray.put(R.id.music_rl, 15);
        sparseIntArray.put(R.id.music_tv, 16);
        sparseIntArray.put(R.id.iv_music1, 17);
        sparseIntArray.put(R.id.iv_music2, 18);
        sparseIntArray.put(R.id.bt_rl, 19);
        sparseIntArray.put(R.id.bt_tv, 20);
        sparseIntArray.put(R.id.iv_bt1, 21);
        sparseIntArray.put(R.id.iv_bt2, 22);
        sparseIntArray.put(R.id.car_rl, 23);
        sparseIntArray.put(R.id.car_tv, 24);
        sparseIntArray.put(R.id.car_tip, 25);
        sparseIntArray.put(R.id.iv_car1, 26);
        sparseIntArray.put(R.id.space, 27);
        sparseIntArray.put(R.id.iv_car2, 28);
        sparseIntArray.put(R.id.setting_rl, 29);
        sparseIntArray.put(R.id.set_tv, 30);
        sparseIntArray.put(R.id.set_tip, 31);
        sparseIntArray.put(R.id.iv_set1, 32);
        sparseIntArray.put(R.id.space5, 33);
        sparseIntArray.put(R.id.iv_set2, 34);
    }

    public Benz2021KswFragmentOneHdpi1280x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 35, sIncludes, sViewsWithIds));
    }

    private Benz2021KswFragmentOneHdpi1280x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (BenzMbuxItemView) bindings[6], (RelativeLayout) bindings[19], (TextView) bindings[7], (TextView) bindings[20], (BenzMbuxItemView) bindings[8], (RelativeLayout) bindings[23], (TextView) bindings[25], (TextView) bindings[24], (LinearLayout) bindings[0], (ImageView) bindings[21], (ImageView) bindings[22], (ImageView) bindings[26], (ImageView) bindings[28], (ImageView) bindings[17], (ImageView) bindings[18], (ImageView) bindings[13], (ImageView) bindings[14], (ImageView) bindings[32], (ImageView) bindings[34], (FrameLayout) bindings[2], (RelativeLayout) bindings[15], (TextView) bindings[5], (TextView) bindings[16], (BenzMbuxItemView) bindings[1], (RelativeLayout) bindings[10], (TextView) bindings[12], (TextView) bindings[11], (BenzMbuxItemView) bindings[9], (TextView) bindings[31], (TextView) bindings[30], (RelativeLayout) bindings[29], (View) bindings[27], null, null, null, (View) bindings[33]);
        this.mDirtyFlags = -1;
        this.btItemview.setTag(null);
        this.btTip.setTag(null);
        this.carItemview.setTag(null);
        this.fragmentOneLl.setTag(null);
        BenzMbuxItemView benzMbuxItemView = (BenzMbuxItemView) bindings[3];
        this.mboundView3 = benzMbuxItemView;
        benzMbuxItemView.setTag(null);
        BenzMbuxItemView benzMbuxItemView2 = (BenzMbuxItemView) bindings[4];
        this.mboundView4 = benzMbuxItemView2;
        benzMbuxItemView2.setTag(null);
        this.musicItemview.setTag(null);
        this.musicTip.setTag(null);
        this.naviItemview.setTag(null);
        this.setItemview.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
        }
        requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (36 != variableId) {
            return false;
        }
        setViewModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Benz2021KswFragmentOne
    public void setViewModel(BcVieModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelMediaInfoSongInfo((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelItemIconClassical((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeViewModelBtState((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelMediaInfoPicZoom((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelMediaInfoSongInfo(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelItemIconClassical(ObservableBoolean ViewModelItemIconClassical, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelBtState(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoPicZoom(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        Drawable viewModelMediaInfoPicZoomJavaLangObjectNullMusicItemviewAndroidDrawableTranspMusicItemviewAndroidDrawableBenzMbux2021AlbumSelector;
        String viewModelMediaInfoSongInfoGet;
        Drawable viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector2;
        Drawable viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector2;
        String viewModelMediaInfoSongInfoJavaLangObjectNullMusicTipAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo;
        long dirtyFlags2;
        Drawable viewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021KswHomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021KswHomeMusicSelector2;
        String viewModelMediaInfoSongInfoGet2;
        ObservableField<String> viewModelMediaInfoSongInfo;
        ObservableField<BitmapDrawable> viewModelMediaInfoPicZoom;
        long dirtyFlags3;
        int i;
        Context context;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector22 = null;
        Drawable viewModelItemIconClassicalBtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector2 = null;
        BitmapDrawable viewModelMediaInfoPicZoomGet = null;
        ObservableBoolean viewModelItemIconClassical = null;
        ObservableField<String> viewModelBtState = null;
        Drawable viewModelItemIconClassicalNaviItemviewAndroidDrawableBenzMbux2021KswHomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021KswHomeNaviSelector2 = null;
        int viewModelMediaInfoPicZoomJavaLangObjectNullViewVISIBLEViewGONE = 0;
        String viewModelBtStateGet = null;
        int viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE = 0;
        Drawable viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector23 = null;
        Drawable viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector22 = null;
        boolean viewModelMediaInfoSongInfoJavaLangObjectNull = false;
        boolean viewModelItemIconClassicalGet = false;
        BcVieModel viewModel = this.mViewModel;
        String viewModelMediaInfoSongInfoGet3 = null;
        if ((dirtyFlags & 41) != 0) {
            MediaInfo viewModelMediaInfo = BcVieModel.mediaInfo;
            if ((dirtyFlags & 33) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoSongInfo = viewModelMediaInfo.songInfo;
                } else {
                    viewModelMediaInfoSongInfo = null;
                }
                viewModelMediaInfoSongInfoGet2 = null;
                updateRegistration(0, viewModelMediaInfoSongInfo);
                if (viewModelMediaInfoSongInfo != null) {
                    viewModelMediaInfoSongInfoGet2 = viewModelMediaInfoSongInfo.get();
                }
                viewModelMediaInfoSongInfoJavaLangObjectNull = viewModelMediaInfoSongInfoGet2 == null;
                if ((dirtyFlags & 33) != 0) {
                    dirtyFlags = viewModelMediaInfoSongInfoJavaLangObjectNull ? dirtyFlags | PlaybackStateCompat.ACTION_PREPARE_FROM_URI : dirtyFlags | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                }
            } else {
                viewModelMediaInfoSongInfoGet2 = null;
                viewModelMediaInfoSongInfo = null;
            }
            if ((dirtyFlags & 40) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoPicZoom = viewModelMediaInfo.picZoom;
                } else {
                    viewModelMediaInfoPicZoom = null;
                }
                updateRegistration(3, viewModelMediaInfoPicZoom);
                if (viewModelMediaInfoPicZoom != null) {
                    viewModelMediaInfoPicZoomGet = viewModelMediaInfoPicZoom.get();
                }
                boolean viewModelMediaInfoPicZoomJavaLangObjectNull = viewModelMediaInfoPicZoomGet == null;
                if ((dirtyFlags & 40) != 0) {
                    if (viewModelMediaInfoPicZoomJavaLangObjectNull) {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PLAY_FROM_URI | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 8388608;
                    } else {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM | PlaybackStateCompat.ACTION_PREPARE | 4194304;
                    }
                }
                int i2 = 8;
                viewModelMediaInfoPicZoomJavaLangObjectNullViewVISIBLEViewGONE = viewModelMediaInfoPicZoomJavaLangObjectNull ? 0 : 8;
                if (!viewModelMediaInfoPicZoomJavaLangObjectNull) {
                    i2 = 0;
                }
                viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE = i2;
                if (viewModelMediaInfoPicZoomJavaLangObjectNull) {
                    context = this.musicItemview.getContext();
                    dirtyFlags3 = dirtyFlags;
                    i = R.drawable.transp;
                } else {
                    dirtyFlags3 = dirtyFlags;
                    context = this.musicItemview.getContext();
                    i = R.drawable.benz_mbux_2021_album_selector;
                }
                viewModelMediaInfoPicZoomJavaLangObjectNullMusicItemviewAndroidDrawableTranspMusicItemviewAndroidDrawableBenzMbux2021AlbumSelector = AppCompatResources.getDrawable(context, i);
                viewModelMediaInfoSongInfoGet3 = viewModelMediaInfoSongInfoGet2;
                dirtyFlags = dirtyFlags3;
            } else {
                viewModelMediaInfoPicZoomJavaLangObjectNullMusicItemviewAndroidDrawableTranspMusicItemviewAndroidDrawableBenzMbux2021AlbumSelector = null;
                viewModelMediaInfoSongInfoGet3 = viewModelMediaInfoSongInfoGet2;
            }
        } else {
            viewModelMediaInfoPicZoomJavaLangObjectNullMusicItemviewAndroidDrawableTranspMusicItemviewAndroidDrawableBenzMbux2021AlbumSelector = null;
        }
        if ((dirtyFlags & 54) != 0) {
            if ((dirtyFlags & 50) != 0) {
                if (viewModel != null) {
                    viewModelItemIconClassical = viewModel.itemIconClassical;
                }
                viewModelMediaInfoSongInfoGet = viewModelMediaInfoSongInfoGet3;
                updateRegistration(1, viewModelItemIconClassical);
                if (viewModelItemIconClassical != null) {
                    viewModelItemIconClassicalGet = viewModelItemIconClassical.get();
                }
                if ((dirtyFlags & 50) != 0) {
                    if (viewModelItemIconClassicalGet) {
                        dirtyFlags = dirtyFlags | 128 | 512 | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    } else {
                        dirtyFlags = dirtyFlags | 64 | 256 | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_SET_REPEAT_MODE | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    }
                }
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags2 = dirtyFlags;
                    viewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021KswHomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021KswHomeMusicSelector2 = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.benz_mbux_2021_ksw_home_music_selector1);
                } else {
                    dirtyFlags2 = dirtyFlags;
                    viewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021KswHomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021KswHomeMusicSelector2 = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.benz_mbux_2021_ksw_home_music_selector2);
                }
                Drawable viewModelItemIconClassicalBtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector22 = AppCompatResources.getDrawable(this.btItemview.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_home_bt_selector1 : R.drawable.benz_mbux_2021_ksw_home_bt_selector2);
                viewModelItemIconClassicalNaviItemviewAndroidDrawableBenzMbux2021KswHomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021KswHomeNaviSelector2 = AppCompatResources.getDrawable(this.naviItemview.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_home_navi_selector1 : R.drawable.benz_mbux_2021_ksw_home_navi_selector2);
                viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector23 = AppCompatResources.getDrawable(this.carItemview.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_home_car_selector1 : R.drawable.benz_mbux_2021_ksw_home_car_selector2);
                viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector22 = AppCompatResources.getDrawable(this.setItemview.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_home_setting_selector1 : R.drawable.benz_mbux_2021_ksw_home_setting_selector2);
                viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector22 = viewModelItemIconClassicalMboundView4AndroidDrawableBenzMbux2021KswHomeMusicSelector1MboundView4AndroidDrawableBenzMbux2021KswHomeMusicSelector2;
                viewModelItemIconClassicalBtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector2 = viewModelItemIconClassicalBtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector22;
                dirtyFlags = dirtyFlags2;
            } else {
                viewModelMediaInfoSongInfoGet = viewModelMediaInfoSongInfoGet3;
            }
            if ((dirtyFlags & 52) != 0) {
                if (viewModel != null) {
                    viewModelBtState = viewModel.btState;
                }
                updateRegistration(2, viewModelBtState);
                if (viewModelBtState != null) {
                    viewModelBtStateGet = viewModelBtState.get();
                    viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector2 = viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector23;
                    viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector2 = viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector22;
                } else {
                    viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector2 = viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector23;
                    viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector2 = viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector22;
                }
            } else {
                viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector2 = viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector23;
                viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector2 = viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector22;
            }
        } else {
            viewModelMediaInfoSongInfoGet = viewModelMediaInfoSongInfoGet3;
            viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector2 = null;
            viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector2 = null;
        }
        if ((dirtyFlags & 33) != 0) {
            viewModelMediaInfoSongInfoJavaLangObjectNullMusicTipAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo = viewModelMediaInfoSongInfoJavaLangObjectNull ? this.musicTip.getResources().getString(R.string.ksw_idf7_unkonw_soung) : viewModelMediaInfoSongInfoGet;
        } else {
            viewModelMediaInfoSongInfoJavaLangObjectNullMusicTipAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo = null;
        }
        if ((dirtyFlags & 50) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.btItemview, viewModelItemIconClassicalBtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021KswHomeBtSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.carItemview, viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector22);
            ImageViewBindingAdapter.setImageDrawable(this.naviItemview, viewModelItemIconClassicalNaviItemviewAndroidDrawableBenzMbux2021KswHomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021KswHomeNaviSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.setItemview, viewModelItemIconClassicalSetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector1SetItemviewAndroidDrawableBenzMbux2021KswHomeSettingSelector2);
        }
        if ((dirtyFlags & 52) != 0) {
            TextViewBindingAdapter.setText(this.btTip, viewModelBtStateGet);
        }
        if ((dirtyFlags & 40) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, viewModelMediaInfoPicZoomGet);
            this.mboundView3.setVisibility(viewModelMediaInfoPicZoomJavaLangObjectNullViewGONEViewVISIBLE);
            this.mboundView4.setVisibility(viewModelMediaInfoPicZoomJavaLangObjectNullViewVISIBLEViewGONE);
            ViewBindingAdapter.setBackground(this.musicItemview, viewModelMediaInfoPicZoomJavaLangObjectNullMusicItemviewAndroidDrawableTranspMusicItemviewAndroidDrawableBenzMbux2021AlbumSelector);
        }
        if ((dirtyFlags & 33) != 0) {
            TextViewBindingAdapter.setText(this.musicTip, viewModelMediaInfoSongInfoJavaLangObjectNullMusicTipAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoSongInfo);
        }
    }
}
