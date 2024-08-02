package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.CompoundButtonBindingAdapter;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.ControlBean;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class BenzControlBindImpl extends BenzControlBind {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl2 mLauncherViewModelOnAuxiliaryRadarClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mLauncherViewModelOnHighChasssisClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl mLauncherViewModelOnSportClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mLauncherViewModelShowBrightnessDialogAndroidViewViewOnClickListener;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.netgControlImageview, 9);
    }

    public BenzControlBindImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private BenzControlBindImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, null, (ImageView) bindings[6], (ImageView) bindings[5], (CheckBox) bindings[7], (CheckBox) bindings[8], (ImageView) bindings[2], (ImageView) bindings[3], (ImageView) bindings[4], (ImageView) bindings[1], (ConstraintLayout) bindings[0], (ImageView) bindings[9]);
        this.mDirtyFlags = -1;
        this.brightnessBtnLeft.setTag(null);
        this.brightnessBtnRight.setTag(null);
        this.checkBox.setTag(null);
        this.checkBox2.setTag(null);
        this.controlBtn1.setTag(null);
        this.controlBtn2.setTag(null);
        this.controlBtn3.setTag(null);
        this.imageView.setTag(null);
        this.linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        if (28 != variableId) {
            return false;
        }
        setLauncherViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BenzControlBind
    public void setLauncherViewModel(LauncherViewModel LauncherViewModel) {
        this.mLauncherViewModel = LauncherViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeLauncherViewModelControlBeanRightBrightnessAdjus((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeLauncherViewModelControlBeanSport((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeLauncherViewModelControlBeanRdarAssistance((ObservableBoolean) object, fieldId);
            case 3:
                return onChangeLauncherViewModelControlBeanLeftBrightnessAdjus((ObservableBoolean) object, fieldId);
            case 4:
                return onChangeLauncherViewModelControlBeanPassairbar((ObservableBoolean) object, fieldId);
            case 5:
                return onChangeLauncherViewModelControlBeanChassis((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeLauncherViewModelControlBeanRightBrightnessAdjus(ObservableBoolean LauncherViewModelControlBeanRightBrightnessAdjus, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelControlBeanSport(ObservableBoolean LauncherViewModelControlBeanSport, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelControlBeanRdarAssistance(ObservableBoolean LauncherViewModelControlBeanRdarAssistance, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelControlBeanLeftBrightnessAdjus(ObservableBoolean LauncherViewModelControlBeanLeftBrightnessAdjus, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelControlBeanPassairbar(ObservableBoolean LauncherViewModelControlBeanPassairbar, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelControlBeanChassis(ObservableBoolean LauncherViewModelControlBeanChassis, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        CompoundButton.OnCheckedChangeListener launcherViewModelRightOnCheckedChangeListener;
        Drawable launcherViewModelControlBeanSportControlBtn2AndroidDrawableNtg55CtrlpanelBtnOnControlBtn2AndroidDrawableNtg55CtrlpanelBtnOff;
        boolean launcherViewModelControlBeanRightBrightnessAdjusGet;
        Drawable launcherViewModelControlBeanRdarAssistanceControlBtn3AndroidDrawableNtg55CtrlpanelBtnOnControlBtn3AndroidDrawableNtg55CtrlpanelBtnOff;
        ObservableBoolean launcherViewModelControlBeanRightBrightnessAdjus;
        ControlBean launcherViewModelControlBean;
        ObservableBoolean launcherViewModelControlBeanPassairbar;
        ObservableBoolean launcherViewModelControlBeanRightBrightnessAdjus2;
        ObservableBoolean launcherViewModelControlBeanPassairbar2;
        ObservableBoolean launcherViewModelControlBeanChassis;
        long dirtyFlags2;
        int i;
        Context context;
        long dirtyFlags3;
        Drawable drawable;
        ObservableBoolean launcherViewModelControlBeanLeftBrightnessAdjus;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable launcherViewModelControlBeanChassisControlBtn1AndroidDrawableNtg55CtrlpanelBtnOnControlBtn1AndroidDrawableNtg55CtrlpanelBtnOff = null;
        ObservableBoolean launcherViewModelControlBeanSport = null;
        View.OnClickListener launcherViewModelOnSportClickAndroidViewViewOnClickListener = null;
        View.OnClickListener launcherViewModelShowBrightnessDialogAndroidViewViewOnClickListener = null;
        boolean launcherViewModelControlBeanLeftBrightnessAdjusGet = false;
        CompoundButton.OnCheckedChangeListener launcherViewModelLeftOnCheckedChangeListener = null;
        Drawable launcherViewModelControlBeanPassairbarImageViewAndroidDrawableNtg55CtrlpanelAirbagOnImageViewAndroidDrawableNtg55CtrlpanelAirbagOff = null;
        View.OnClickListener launcherViewModelOnAuxiliaryRadarClickAndroidViewViewOnClickListener = null;
        ObservableBoolean launcherViewModelControlBeanRdarAssistance = null;
        View.OnClickListener launcherViewModelOnHighChasssisClickAndroidViewViewOnClickListener = null;
        boolean launcherViewModelControlBeanRightBrightnessAdjusGet2 = false;
        boolean launcherViewModelControlBeanSportGet = false;
        Drawable launcherViewModelControlBeanRdarAssistanceControlBtn3AndroidDrawableNtg55CtrlpanelBtnOnControlBtn3AndroidDrawableNtg55CtrlpanelBtnOff2 = null;
        boolean launcherViewModelControlBeanRdarAssistanceGet = false;
        Drawable launcherViewModelControlBeanSportControlBtn2AndroidDrawableNtg55CtrlpanelBtnOnControlBtn2AndroidDrawableNtg55CtrlpanelBtnOff2 = null;
        boolean launcherViewModelControlBeanPassairbarGet = false;
        CompoundButton.OnCheckedChangeListener launcherViewModelRightOnCheckedChangeListener2 = null;
        boolean launcherViewModelControlBeanChassisGet = false;
        LauncherViewModel launcherViewModel = this.mLauncherViewModel;
        if ((dirtyFlags & 255) != 0) {
            if ((dirtyFlags & 192) == 0) {
                launcherViewModelControlBeanRightBrightnessAdjus = null;
            } else if (launcherViewModel != null) {
                launcherViewModelControlBeanRightBrightnessAdjus = null;
                OnClickListenerImpl onClickListenerImpl = this.mLauncherViewModelOnSportClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mLauncherViewModelOnSportClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                launcherViewModelOnSportClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(launcherViewModel);
                OnClickListenerImpl1 onClickListenerImpl1 = this.mLauncherViewModelShowBrightnessDialogAndroidViewViewOnClickListener;
                if (onClickListenerImpl1 == null) {
                    onClickListenerImpl1 = new OnClickListenerImpl1();
                    this.mLauncherViewModelShowBrightnessDialogAndroidViewViewOnClickListener = onClickListenerImpl1;
                }
                launcherViewModelShowBrightnessDialogAndroidViewViewOnClickListener = onClickListenerImpl1.setValue(launcherViewModel);
                launcherViewModelLeftOnCheckedChangeListener = launcherViewModel.leftOnCheckedChangeListener;
                OnClickListenerImpl2 onClickListenerImpl2 = this.mLauncherViewModelOnAuxiliaryRadarClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl2 == null) {
                    onClickListenerImpl2 = new OnClickListenerImpl2();
                    this.mLauncherViewModelOnAuxiliaryRadarClickAndroidViewViewOnClickListener = onClickListenerImpl2;
                }
                launcherViewModelOnAuxiliaryRadarClickAndroidViewViewOnClickListener = onClickListenerImpl2.setValue(launcherViewModel);
                OnClickListenerImpl3 onClickListenerImpl3 = this.mLauncherViewModelOnHighChasssisClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl3 == null) {
                    onClickListenerImpl3 = new OnClickListenerImpl3();
                    this.mLauncherViewModelOnHighChasssisClickAndroidViewViewOnClickListener = onClickListenerImpl3;
                }
                launcherViewModelOnHighChasssisClickAndroidViewViewOnClickListener = onClickListenerImpl3.setValue(launcherViewModel);
                launcherViewModelRightOnCheckedChangeListener2 = launcherViewModel.rightOnCheckedChangeListener;
            } else {
                launcherViewModelControlBeanRightBrightnessAdjus = null;
            }
            if (launcherViewModel != null) {
                launcherViewModelControlBean = launcherViewModel.controlBean;
            } else {
                launcherViewModelControlBean = null;
            }
            if ((dirtyFlags & 193) != 0) {
                if (launcherViewModelControlBean != null) {
                    launcherViewModelControlBeanRightBrightnessAdjus2 = launcherViewModelControlBean.rightBrightnessAdjus;
                } else {
                    launcherViewModelControlBeanRightBrightnessAdjus2 = launcherViewModelControlBeanRightBrightnessAdjus;
                }
                launcherViewModelControlBeanPassairbar = null;
                updateRegistration(0, launcherViewModelControlBeanRightBrightnessAdjus2);
                if (launcherViewModelControlBeanRightBrightnessAdjus2 != null) {
                    launcherViewModelControlBeanRightBrightnessAdjusGet2 = launcherViewModelControlBeanRightBrightnessAdjus2.get();
                }
            } else {
                launcherViewModelControlBeanPassairbar = null;
                launcherViewModelControlBeanRightBrightnessAdjus2 = launcherViewModelControlBeanRightBrightnessAdjus;
            }
            if ((dirtyFlags & 194) != 0) {
                if (launcherViewModelControlBean != null) {
                    launcherViewModelControlBeanSport = launcherViewModelControlBean.sport;
                }
                updateRegistration(1, launcherViewModelControlBeanSport);
                if (launcherViewModelControlBeanSport != null) {
                    launcherViewModelControlBeanSportGet = launcherViewModelControlBeanSport.get();
                }
                if ((dirtyFlags & 194) != 0) {
                    if (launcherViewModelControlBeanSportGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                    }
                }
                launcherViewModelControlBeanSportControlBtn2AndroidDrawableNtg55CtrlpanelBtnOnControlBtn2AndroidDrawableNtg55CtrlpanelBtnOff2 = launcherViewModelControlBeanSportGet ? AppCompatResources.getDrawable(this.controlBtn2.getContext(), R.drawable.ntg55_ctrlpanel_btn_on) : AppCompatResources.getDrawable(this.controlBtn2.getContext(), R.drawable.ntg55_ctrlpanel_btn_off);
            }
            if ((dirtyFlags & 196) != 0) {
                if (launcherViewModelControlBean != null) {
                    launcherViewModelControlBeanRdarAssistance = launcherViewModelControlBean.rdarAssistance;
                }
                updateRegistration(2, launcherViewModelControlBeanRdarAssistance);
                if (launcherViewModelControlBeanRdarAssistance != null) {
                    launcherViewModelControlBeanRdarAssistanceGet = launcherViewModelControlBeanRdarAssistance.get();
                }
                if ((dirtyFlags & 196) != 0) {
                    if (launcherViewModelControlBeanRdarAssistanceGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                }
                launcherViewModelControlBeanRdarAssistanceControlBtn3AndroidDrawableNtg55CtrlpanelBtnOnControlBtn3AndroidDrawableNtg55CtrlpanelBtnOff2 = AppCompatResources.getDrawable(this.controlBtn3.getContext(), launcherViewModelControlBeanRdarAssistanceGet ? R.drawable.ntg55_ctrlpanel_btn_on : R.drawable.ntg55_ctrlpanel_btn_off);
            }
            if ((dirtyFlags & 200) != 0) {
                if (launcherViewModelControlBean != null) {
                    launcherViewModelControlBeanLeftBrightnessAdjus = launcherViewModelControlBean.leftBrightnessAdjus;
                } else {
                    launcherViewModelControlBeanLeftBrightnessAdjus = null;
                }
                updateRegistration(3, launcherViewModelControlBeanLeftBrightnessAdjus);
                if (launcherViewModelControlBeanLeftBrightnessAdjus != null) {
                    launcherViewModelControlBeanLeftBrightnessAdjusGet = launcherViewModelControlBeanLeftBrightnessAdjus.get();
                }
            }
            if ((dirtyFlags & 208) != 0) {
                if (launcherViewModelControlBean != null) {
                    launcherViewModelControlBeanPassairbar2 = launcherViewModelControlBean.passairbar;
                } else {
                    launcherViewModelControlBeanPassairbar2 = launcherViewModelControlBeanPassairbar;
                }
                updateRegistration(4, launcherViewModelControlBeanPassairbar2);
                if (launcherViewModelControlBeanPassairbar2 != null) {
                    launcherViewModelControlBeanPassairbarGet = launcherViewModelControlBeanPassairbar2.get();
                }
                if ((dirtyFlags & 208) != 0) {
                    if (launcherViewModelControlBeanPassairbarGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                }
                if (launcherViewModelControlBeanPassairbarGet) {
                    dirtyFlags3 = dirtyFlags;
                    drawable = AppCompatResources.getDrawable(this.imageView.getContext(), R.drawable.ntg55_ctrlpanel_airbag_on);
                } else {
                    dirtyFlags3 = dirtyFlags;
                    drawable = AppCompatResources.getDrawable(this.imageView.getContext(), R.drawable.ntg55_ctrlpanel_airbag_off);
                }
                launcherViewModelControlBeanPassairbarImageViewAndroidDrawableNtg55CtrlpanelAirbagOnImageViewAndroidDrawableNtg55CtrlpanelAirbagOff = drawable;
                dirtyFlags = dirtyFlags3;
            } else {
                launcherViewModelControlBeanPassairbar2 = launcherViewModelControlBeanPassairbar;
            }
            if ((dirtyFlags & 224) != 0) {
                if (launcherViewModelControlBean != null) {
                    launcherViewModelControlBeanChassis = launcherViewModelControlBean.chassis;
                } else {
                    launcherViewModelControlBeanChassis = null;
                }
                updateRegistration(5, launcherViewModelControlBeanChassis);
                if (launcherViewModelControlBeanChassis != null) {
                    launcherViewModelControlBeanChassisGet = launcherViewModelControlBeanChassis.get();
                }
                if ((dirtyFlags & 224) != 0) {
                    if (launcherViewModelControlBeanChassisGet) {
                        dirtyFlags |= 512;
                    } else {
                        dirtyFlags |= 256;
                    }
                }
                if (launcherViewModelControlBeanChassisGet) {
                    context = this.controlBtn1.getContext();
                    dirtyFlags2 = dirtyFlags;
                    i = R.drawable.ntg55_ctrlpanel_btn_on;
                } else {
                    dirtyFlags2 = dirtyFlags;
                    context = this.controlBtn1.getContext();
                    i = R.drawable.ntg55_ctrlpanel_btn_off;
                }
                launcherViewModelControlBeanChassisControlBtn1AndroidDrawableNtg55CtrlpanelBtnOnControlBtn1AndroidDrawableNtg55CtrlpanelBtnOff = AppCompatResources.getDrawable(context, i);
                launcherViewModelControlBeanRightBrightnessAdjusGet = launcherViewModelControlBeanRightBrightnessAdjusGet2;
                launcherViewModelControlBeanRdarAssistanceControlBtn3AndroidDrawableNtg55CtrlpanelBtnOnControlBtn3AndroidDrawableNtg55CtrlpanelBtnOff = launcherViewModelControlBeanRdarAssistanceControlBtn3AndroidDrawableNtg55CtrlpanelBtnOnControlBtn3AndroidDrawableNtg55CtrlpanelBtnOff2;
                dirtyFlags = dirtyFlags2;
                launcherViewModelControlBeanSportControlBtn2AndroidDrawableNtg55CtrlpanelBtnOnControlBtn2AndroidDrawableNtg55CtrlpanelBtnOff = launcherViewModelControlBeanSportControlBtn2AndroidDrawableNtg55CtrlpanelBtnOnControlBtn2AndroidDrawableNtg55CtrlpanelBtnOff2;
                launcherViewModelRightOnCheckedChangeListener = launcherViewModelRightOnCheckedChangeListener2;
            } else {
                launcherViewModelControlBeanRightBrightnessAdjusGet = launcherViewModelControlBeanRightBrightnessAdjusGet2;
                launcherViewModelControlBeanRdarAssistanceControlBtn3AndroidDrawableNtg55CtrlpanelBtnOnControlBtn3AndroidDrawableNtg55CtrlpanelBtnOff = launcherViewModelControlBeanRdarAssistanceControlBtn3AndroidDrawableNtg55CtrlpanelBtnOnControlBtn3AndroidDrawableNtg55CtrlpanelBtnOff2;
                launcherViewModelControlBeanSportControlBtn2AndroidDrawableNtg55CtrlpanelBtnOnControlBtn2AndroidDrawableNtg55CtrlpanelBtnOff = launcherViewModelControlBeanSportControlBtn2AndroidDrawableNtg55CtrlpanelBtnOnControlBtn2AndroidDrawableNtg55CtrlpanelBtnOff2;
                launcherViewModelRightOnCheckedChangeListener = launcherViewModelRightOnCheckedChangeListener2;
            }
        } else {
            launcherViewModelControlBeanRightBrightnessAdjusGet = false;
            launcherViewModelControlBeanRdarAssistanceControlBtn3AndroidDrawableNtg55CtrlpanelBtnOnControlBtn3AndroidDrawableNtg55CtrlpanelBtnOff = null;
            launcherViewModelControlBeanSportControlBtn2AndroidDrawableNtg55CtrlpanelBtnOnControlBtn2AndroidDrawableNtg55CtrlpanelBtnOff = null;
            launcherViewModelRightOnCheckedChangeListener = null;
        }
        if ((dirtyFlags & 192) != 0) {
            this.brightnessBtnLeft.setOnClickListener(launcherViewModelShowBrightnessDialogAndroidViewViewOnClickListener);
            this.brightnessBtnRight.setOnClickListener(launcherViewModelShowBrightnessDialogAndroidViewViewOnClickListener);
            this.checkBox.setOnCheckedChangeListener(launcherViewModelLeftOnCheckedChangeListener);
            this.checkBox2.setOnCheckedChangeListener(launcherViewModelRightOnCheckedChangeListener);
            this.controlBtn1.setOnClickListener(launcherViewModelOnHighChasssisClickAndroidViewViewOnClickListener);
            this.controlBtn2.setOnClickListener(launcherViewModelOnSportClickAndroidViewViewOnClickListener);
            this.controlBtn3.setOnClickListener(launcherViewModelOnAuxiliaryRadarClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 200) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.checkBox, launcherViewModelControlBeanLeftBrightnessAdjusGet);
        }
        if ((dirtyFlags & 193) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.checkBox2, launcherViewModelControlBeanRightBrightnessAdjusGet);
        }
        if ((dirtyFlags & 224) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.controlBtn1, launcherViewModelControlBeanChassisControlBtn1AndroidDrawableNtg55CtrlpanelBtnOnControlBtn1AndroidDrawableNtg55CtrlpanelBtnOff);
        }
        if ((dirtyFlags & 194) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.controlBtn2, launcherViewModelControlBeanSportControlBtn2AndroidDrawableNtg55CtrlpanelBtnOnControlBtn2AndroidDrawableNtg55CtrlpanelBtnOff);
        }
        if ((dirtyFlags & 196) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.controlBtn3, launcherViewModelControlBeanRdarAssistanceControlBtn3AndroidDrawableNtg55CtrlpanelBtnOnControlBtn3AndroidDrawableNtg55CtrlpanelBtnOff);
        }
        if ((dirtyFlags & 208) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.imageView, launcherViewModelControlBeanPassairbarImageViewAndroidDrawableNtg55CtrlpanelAirbagOnImageViewAndroidDrawableNtg55CtrlpanelAirbagOff);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onSportClick(arg0);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl1 setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.showBrightnessDialog(arg0);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl2 setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onAuxiliaryRadarClick(arg0);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl3 setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onHighChasssisClick(arg0);
        }
    }
}