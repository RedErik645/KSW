package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.ViewBindingAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.model.ControlBean;

public class BenzMbux2021ActivityBinding2Impl extends BenzMbux2021ActivityBinding2 {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mVieModelOnControlClickAndroidViewViewOnClickListener;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_main_2021_2, 3);
        sparseIntArray.put(R.id.benzMbux2021Viewpager, 4);
        sparseIntArray.put(R.id.indicator_benz_mbux_2021, 5);
        sparseIntArray.put(R.id.layout_coat_benz_mbux_2021, 6);
        sparseIntArray.put(R.id.iv_coat_2021, 7);
        sparseIntArray.put(R.id.tv_coat_2021_tip, 8);
    }

    public BenzMbux2021ActivityBinding2Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private BenzMbux2021ActivityBinding2Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (ViewPager) bindings[4], (ImageView) bindings[2], (LinearLayout) bindings[5], (ImageView) bindings[7], (LinearLayout) bindings[6], (ImageView) bindings[1], (View) bindings[3], (TextView) bindings[8]);
        this.mDirtyFlags = -1;
        this.controlBtn.setTag(null);
        this.layoutMain2021.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (35 != variableId) {
            return false;
        }
        setVieModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BenzMbux2021ActivityBinding2
    public void setVieModel(BcVieModel VieModel) {
        this.mVieModel = VieModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(35);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVieModelControlBeanControlPanelClose((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeVieModelMediaInfoBG((ObservableField) object, fieldId);
            case 2:
                return onChangeVieModelMediaInfoPic((ObservableField) object, fieldId);
            case 3:
                return onChangeVieModelMediaInfoPageIndex((ObservableInt) object, fieldId);
            case 4:
                return onChangeVieModelControlBeanBenzControlPanelState((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVieModelControlBeanControlPanelClose(ObservableBoolean VieModelControlBeanControlPanelClose, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVieModelMediaInfoBG(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVieModelMediaInfoPic(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVieModelMediaInfoPageIndex(ObservableInt VieModelMediaInfoPageIndex, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVieModelControlBeanBenzControlPanelState(ObservableBoolean VieModelControlBeanBenzControlPanelState, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        Drawable vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector;
        int vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE;
        MediaInfo vieModelMediaInfo;
        Drawable vieModelMediaInfoPageIndexInt1VieModelMediaInfoPicJavaLangObjectNullLayoutMain2021AndroidDrawableMbux2MusicBgLayoutMain2021AndroidDrawableTranspLayoutMain2021AndroidDrawableTransp;
        long dirtyFlags2;
        int i;
        Context context;
        int vieModelMediaInfoPageIndexGet;
        ObservableBoolean vieModelControlBeanBenzControlPanelState;
        ObservableBoolean vieModelControlBeanControlPanelClose;
        Drawable vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector2;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableBoolean vieModelControlBeanControlPanelClose2 = null;
        View.OnClickListener vieModelOnControlClickAndroidViewViewOnClickListener = null;
        BcVieModel vieModel = this.mVieModel;
        ObservableField<Drawable> vieModelMediaInfoBG = null;
        ObservableField<BitmapDrawable> vieModelMediaInfoPic = null;
        boolean vieModelMediaInfoPageIndexInt1 = false;
        Drawable vieModelMediaInfoPicJavaLangObjectNullLayoutMain2021AndroidDrawableMbux2MusicBgLayoutMain2021AndroidDrawableTransp = null;
        boolean vieModelControlBeanControlPanelCloseGet = false;
        Drawable vieModelMediaInfoBGGet = null;
        ObservableInt vieModelMediaInfoPageIndex = null;
        ControlBean vieModelControlBean = null;
        BitmapDrawable vieModelMediaInfoPicGet = null;
        int vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE2 = 0;
        boolean vieModelControlBeanBenzControlPanelStateGet = false;
        if ((dirtyFlags & 113) != 0) {
            if (!((dirtyFlags & 96) == 0 || vieModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mVieModelOnControlClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mVieModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                vieModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(vieModel);
            }
            if (vieModel != null) {
                vieModelControlBean = vieModel.controlBean;
            }
            if ((dirtyFlags & 97) != 0) {
                if (vieModelControlBean != null) {
                    vieModelControlBeanControlPanelClose2 = vieModelControlBean.controlPanelClose;
                }
                updateRegistration(0, vieModelControlBeanControlPanelClose2);
                if (vieModelControlBeanControlPanelClose2 != null) {
                    vieModelControlBeanControlPanelCloseGet = vieModelControlBeanControlPanelClose2.get();
                }
                if ((dirtyFlags & 97) != 0) {
                    if (vieModelControlBeanControlPanelCloseGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= 512;
                    }
                }
                vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE2 = vieModelControlBeanControlPanelCloseGet ? 8 : 0;
            }
            if ((dirtyFlags & 112) != 0) {
                if (vieModelControlBean != null) {
                    vieModelControlBeanBenzControlPanelState = vieModelControlBean.benzControlPanelState;
                } else {
                    vieModelControlBeanBenzControlPanelState = null;
                }
                updateRegistration(4, vieModelControlBeanBenzControlPanelState);
                if (vieModelControlBeanBenzControlPanelState != null) {
                    vieModelControlBeanBenzControlPanelStateGet = vieModelControlBeanBenzControlPanelState.get();
                }
                if ((dirtyFlags & 112) != 0) {
                    if (vieModelControlBeanBenzControlPanelStateGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                }
                if (vieModelControlBeanBenzControlPanelStateGet) {
                    vieModelControlBeanControlPanelClose = vieModelControlBeanControlPanelClose2;
                    vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector2 = AppCompatResources.getDrawable(this.controlBtn.getContext(), R.drawable.ntg55_ctrlpanel_down_selector);
                } else {
                    vieModelControlBeanControlPanelClose = vieModelControlBeanControlPanelClose2;
                    vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector2 = AppCompatResources.getDrawable(this.controlBtn.getContext(), R.drawable.ntg55_ctrlpanel_up_selector);
                }
                vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE2;
                vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector2;
                vieModelControlBeanControlPanelClose2 = vieModelControlBeanControlPanelClose;
            } else {
                vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE2;
                vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = null;
            }
        } else {
            vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = 0;
            vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = null;
        }
        if ((dirtyFlags & 78) != 0) {
            MediaInfo vieModelMediaInfo2 = BcVieModel.mediaInfo;
            if ((dirtyFlags & 66) != 0) {
                if (vieModelMediaInfo2 != null) {
                    vieModelMediaInfoBG = vieModelMediaInfo2.BG;
                }
                updateRegistration(1, vieModelMediaInfoBG);
                if (vieModelMediaInfoBG != null) {
                    vieModelMediaInfoBGGet = vieModelMediaInfoBG.get();
                }
            }
            if ((dirtyFlags & 76) != 0) {
                if (vieModelMediaInfo2 != null) {
                    vieModelMediaInfoPageIndex = vieModelMediaInfo2.pageIndex;
                }
                updateRegistration(3, vieModelMediaInfoPageIndex);
                if (vieModelMediaInfoPageIndex != null) {
                    vieModelMediaInfoPageIndexGet = vieModelMediaInfoPageIndex.get();
                } else {
                    vieModelMediaInfoPageIndexGet = 0;
                }
                vieModelMediaInfoPageIndexInt1 = vieModelMediaInfoPageIndexGet == 1;
                if ((dirtyFlags & 76) == 0) {
                    vieModelMediaInfo = vieModelMediaInfo2;
                } else if (vieModelMediaInfoPageIndexInt1) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                    vieModelMediaInfo = vieModelMediaInfo2;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    vieModelMediaInfo = vieModelMediaInfo2;
                }
            } else {
                vieModelMediaInfo = vieModelMediaInfo2;
            }
        } else {
            vieModelMediaInfo = null;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE) != 0) {
            if (vieModelMediaInfo != null) {
                vieModelMediaInfoPic = vieModelMediaInfo.pic;
            }
            updateRegistration(2, vieModelMediaInfoPic);
            if (vieModelMediaInfoPic != null) {
                vieModelMediaInfoPicGet = vieModelMediaInfoPic.get();
            }
            boolean vieModelMediaInfoPicJavaLangObjectNull = vieModelMediaInfoPicGet != null;
            if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                if (vieModelMediaInfoPicJavaLangObjectNull) {
                    dirtyFlags |= 256;
                } else {
                    dirtyFlags |= 128;
                }
            }
            if (vieModelMediaInfoPicJavaLangObjectNull) {
                context = this.layoutMain2021.getContext();
                dirtyFlags2 = dirtyFlags;
                i = R.drawable.mbux2_music_bg;
            } else {
                dirtyFlags2 = dirtyFlags;
                context = this.layoutMain2021.getContext();
                i = R.drawable.transp;
            }
            vieModelMediaInfoPicJavaLangObjectNullLayoutMain2021AndroidDrawableMbux2MusicBgLayoutMain2021AndroidDrawableTransp = AppCompatResources.getDrawable(context, i);
            dirtyFlags = dirtyFlags2;
        }
        if ((dirtyFlags & 76) != 0) {
            vieModelMediaInfoPageIndexInt1VieModelMediaInfoPicJavaLangObjectNullLayoutMain2021AndroidDrawableMbux2MusicBgLayoutMain2021AndroidDrawableTranspLayoutMain2021AndroidDrawableTransp = vieModelMediaInfoPageIndexInt1 ? vieModelMediaInfoPicJavaLangObjectNullLayoutMain2021AndroidDrawableMbux2MusicBgLayoutMain2021AndroidDrawableTransp : AppCompatResources.getDrawable(this.layoutMain2021.getContext(), R.drawable.transp);
        } else {
            vieModelMediaInfoPageIndexInt1VieModelMediaInfoPicJavaLangObjectNullLayoutMain2021AndroidDrawableMbux2MusicBgLayoutMain2021AndroidDrawableTranspLayoutMain2021AndroidDrawableTransp = null;
        }
        if ((dirtyFlags & 96) != 0) {
            this.controlBtn.setOnClickListener(vieModelOnControlClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 112) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.controlBtn, vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector);
        }
        if ((dirtyFlags & 97) != 0) {
            this.controlBtn.setVisibility(vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 76) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.layoutMain2021, vieModelMediaInfoPageIndexInt1VieModelMediaInfoPicJavaLangObjectNullLayoutMain2021AndroidDrawableMbux2MusicBgLayoutMain2021AndroidDrawableTranspLayoutMain2021AndroidDrawableTransp);
        }
        if ((dirtyFlags & 66) != 0) {
            ViewBindingAdapter.setBackground(this.layoutMain2021, vieModelMediaInfoBGGet);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private BcVieModel value;

        public OnClickListenerImpl setValue(BcVieModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onControlClick(arg0);
        }
    }
}
