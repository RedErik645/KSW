package com.wits.ksw.databinding;

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
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.model.ControlBean;

public class BenzMbuxKswActivityNewBindingHdpi1920x720Impl extends BenzMbuxKswActivityNewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mVieModelOnControlClickAndroidViewViewOnClickListener;
    private final LinearLayout mboundView0;
    private final RelativeLayout mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_main_2021_2, 6);
        sparseIntArray.put(R.id.indicator_benz_mbux_2021, 7);
        sparseIntArray.put(R.id.layout_coat_benz_mbux_2021, 8);
        sparseIntArray.put(R.id.iv_coat_2021, 9);
        sparseIntArray.put(R.id.tv_coat_2021_tip, 10);
    }

    public BenzMbuxKswActivityNewBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private BenzMbuxKswActivityNewBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (RecyclerView) bindings[3], (ViewPager) bindings[2], (ImageView) bindings[5], (LinearLayout) bindings[7], (ImageView) bindings[9], (LinearLayout) bindings[8], (ImageView) bindings[1], (RelativeLayout) bindings[6], (TextView) bindings[10]);
        this.mDirtyFlags = -1;
        this.benzMbux2021KswNewRecycle.setTag(null);
        this.benzMbux2021Viewpager.setTag(null);
        this.controlBtn.setTag(null);
        this.layoutMain2021.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[4];
        this.mboundView4 = relativeLayout;
        relativeLayout.setTag(null);
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

    @Override // com.wits.ksw.databinding.BenzMbuxKswActivityNewBinding
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
                return onChangeVieModelMediaInfoPageIndex((ObservableInt) object, fieldId);
            case 2:
                return onChangeVieModelIsEditState((ObservableBoolean) object, fieldId);
            case 3:
                return onChangeVieModelMediaInfoPicOther((ObservableField) object, fieldId);
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

    private boolean onChangeVieModelMediaInfoPageIndex(ObservableInt VieModelMediaInfoPageIndex, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVieModelIsEditState(ObservableBoolean VieModelIsEditState, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVieModelMediaInfoPicOther(ObservableField<BitmapDrawable> observableField, int fieldId) {
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
        int vieModelIsEditStateViewINVISIBLEViewVISIBLE;
        Drawable vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp;
        BitmapDrawable vieModelMediaInfoPicOtherGet;
        Drawable vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp2;
        ObservableField<BitmapDrawable> vieModelMediaInfoPicOther;
        int vieModelMediaInfoPageIndexGet;
        ObservableField<BitmapDrawable> vieModelMediaInfoPicOther2;
        ObservableBoolean vieModelIsEditState;
        ObservableBoolean vieModelControlBeanBenzControlPanelState;
        ObservableBoolean vieModelControlBeanControlPanelClose;
        Drawable drawable;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableBoolean vieModelControlBeanControlPanelClose2 = null;
        View.OnClickListener vieModelOnControlClickAndroidViewViewOnClickListener = null;
        int vieModelIsEditStateViewGONEViewVISIBLE = 0;
        BcVieModel vieModel = this.mVieModel;
        int vieModelMediaInfoPageIndexGet2 = 0;
        boolean vieModelControlBeanControlPanelCloseGet = false;
        ObservableInt vieModelMediaInfoPageIndex = null;
        boolean vieModelIsEditStateGet = false;
        int vieModelIsEditStateViewVISIBLEViewINVISIBLE = 0;
        ControlBean vieModelControlBean = null;
        ObservableField<BitmapDrawable> vieModelMediaInfoPicOther3 = null;
        int vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE2 = 0;
        Drawable vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector2 = null;
        boolean vieModelMediaInfoPicOtherJavaLangObjectNull = false;
        boolean vieModelControlBeanBenzControlPanelStateGet = false;
        BitmapDrawable vieModelMediaInfoPicOtherGet2 = null;
        if ((dirtyFlags & 117) != 0) {
            if (!((dirtyFlags & 96) == 0 || vieModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mVieModelOnControlClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mVieModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                vieModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(vieModel);
            }
            int i = 8;
            if ((dirtyFlags & 113) != 0) {
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
                            dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                        } else {
                            dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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
                            dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        } else {
                            dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        }
                    }
                    if (vieModelControlBeanBenzControlPanelStateGet) {
                        vieModelControlBeanControlPanelClose = vieModelControlBeanControlPanelClose2;
                        drawable = AppCompatResources.getDrawable(this.controlBtn.getContext(), R.drawable.ntg55_ctrlpanel_down_selector);
                    } else {
                        vieModelControlBeanControlPanelClose = vieModelControlBeanControlPanelClose2;
                        drawable = AppCompatResources.getDrawable(this.controlBtn.getContext(), R.drawable.ntg55_ctrlpanel_up_selector);
                    }
                    vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector2 = drawable;
                    vieModelControlBeanControlPanelClose2 = vieModelControlBeanControlPanelClose;
                }
            }
            if ((dirtyFlags & 100) != 0) {
                if (vieModel != null) {
                    vieModelIsEditState = vieModel.isEditState;
                } else {
                    vieModelIsEditState = null;
                }
                updateRegistration(2, vieModelIsEditState);
                if (vieModelIsEditState != null) {
                    vieModelIsEditStateGet = vieModelIsEditState.get();
                }
                if ((dirtyFlags & 100) != 0) {
                    if (vieModelIsEditStateGet) {
                        dirtyFlags = dirtyFlags | 256 | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    } else {
                        dirtyFlags = dirtyFlags | 128 | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    }
                }
                if (!vieModelIsEditStateGet) {
                    i = 0;
                }
                vieModelIsEditStateViewGONEViewVISIBLE = i;
                vieModelIsEditStateViewVISIBLEViewINVISIBLE = vieModelIsEditStateGet ? 0 : 4;
                vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE2;
                vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector2;
                vieModelIsEditStateViewINVISIBLEViewVISIBLE = vieModelIsEditStateGet ? 4 : 0;
            } else {
                vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE2;
                vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector2;
                vieModelIsEditStateViewINVISIBLEViewVISIBLE = 0;
            }
        } else {
            vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = 0;
            vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = null;
            vieModelIsEditStateViewINVISIBLEViewVISIBLE = 0;
        }
        if ((dirtyFlags & 74) != 0) {
            MediaInfo vieModelMediaInfo = BcVieModel.mediaInfo;
            if (vieModelMediaInfo != null) {
                vieModelMediaInfoPageIndex = vieModelMediaInfo.pageIndex;
            }
            vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp = null;
            updateRegistration(1, vieModelMediaInfoPageIndex);
            if (vieModelMediaInfoPageIndex != null) {
                vieModelMediaInfoPageIndexGet = vieModelMediaInfoPageIndex.get();
            } else {
                vieModelMediaInfoPageIndexGet = 0;
            }
            int vieModelMediaInfoPageIndexInt1 = vieModelMediaInfoPageIndexGet == 1 ? 1 : 0;
            if ((dirtyFlags & 74) != 0) {
                if (vieModelMediaInfoPageIndexInt1 != 0) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
            }
            if ((dirtyFlags & 72) != 0) {
                if (vieModelMediaInfo != null) {
                    vieModelMediaInfoPicOther2 = vieModelMediaInfo.picOther;
                } else {
                    vieModelMediaInfoPicOther2 = null;
                }
                updateRegistration(3, vieModelMediaInfoPicOther2);
                if (vieModelMediaInfoPicOther2 != null) {
                    vieModelMediaInfoPicOtherGet2 = vieModelMediaInfoPicOther2.get();
                    vieModelMediaInfoPicOther3 = vieModelMediaInfoPicOther2;
                    vieModelMediaInfoPageIndexGet2 = vieModelMediaInfoPageIndexInt1;
                    dirtyFlags = dirtyFlags;
                } else {
                    vieModelMediaInfoPicOther3 = vieModelMediaInfoPicOther2;
                    vieModelMediaInfoPageIndexGet2 = vieModelMediaInfoPageIndexInt1;
                    dirtyFlags = dirtyFlags;
                }
            } else {
                vieModelMediaInfoPageIndexGet2 = vieModelMediaInfoPageIndexInt1;
            }
        } else {
            vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp = null;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            MediaInfo vieModelMediaInfo2 = BcVieModel.mediaInfo;
            if (vieModelMediaInfo2 != null) {
                vieModelMediaInfoPicOther = vieModelMediaInfo2.picOther;
            } else {
                vieModelMediaInfoPicOther = vieModelMediaInfoPicOther3;
            }
            updateRegistration(3, vieModelMediaInfoPicOther);
            if (vieModelMediaInfoPicOther != null) {
                vieModelMediaInfoPicOtherGet2 = vieModelMediaInfoPicOther.get();
            }
            vieModelMediaInfoPicOtherJavaLangObjectNull = vieModelMediaInfoPicOtherGet2 != null;
            if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) == 0) {
                vieModelMediaInfoPicOtherGet = vieModelMediaInfoPicOtherGet2;
            } else if (vieModelMediaInfoPicOtherJavaLangObjectNull) {
                dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                vieModelMediaInfoPicOtherGet = vieModelMediaInfoPicOtherGet2;
            } else {
                dirtyFlags |= 512;
                vieModelMediaInfoPicOtherGet = vieModelMediaInfoPicOtherGet2;
            }
        } else {
            vieModelMediaInfoPicOtherGet = vieModelMediaInfoPicOtherGet2;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp2 = vieModelMediaInfoPicOtherJavaLangObjectNull ? vieModelMediaInfoPicOtherGet : AppCompatResources.getDrawable(this.layoutMain2021.getContext(), R.drawable.transp);
        } else {
            vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp2 = vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp;
        }
        if ((dirtyFlags & 74) == 0) {
            vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp2 = null;
        } else if (vieModelMediaInfoPageIndexGet2 == 0) {
            vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp2 = AppCompatResources.getDrawable(this.layoutMain2021.getContext(), R.drawable.transp);
        }
        if ((dirtyFlags & 100) != 0) {
            this.benzMbux2021KswNewRecycle.setVisibility(vieModelIsEditStateViewVISIBLEViewINVISIBLE);
            this.benzMbux2021Viewpager.setVisibility(vieModelIsEditStateViewINVISIBLEViewVISIBLE);
            this.mboundView4.setVisibility(vieModelIsEditStateViewGONEViewVISIBLE);
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
        if ((dirtyFlags & 74) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.layoutMain2021, vieModelMediaInfoPicOtherJavaLangObjectNullVieModelMediaInfoPicOtherLayoutMain2021AndroidDrawableTransp2);
        }
        if ((dirtyFlags & 72) != 0) {
            ViewBindingAdapter.setBackground(this.layoutMain2021, vieModelMediaInfoPicOtherGet);
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
