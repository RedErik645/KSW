package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.LinearGradientProgressNew;

public class DashboardDataGsBindingImpl extends DashboardDataGsBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback492;
    private long mDirtyFlags;
    private final LinearGradientProgressNew mboundView1;
    private final TextView mboundView3;
    private final ImageView mboundView4;
    private final ImageView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;

    public DashboardDataGsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private DashboardDataGsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (ImageView) bindings[2], (RelativeLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.ivMask.setTag(null);
        this.llContainerGs.setTag(null);
        LinearGradientProgressNew linearGradientProgressNew = (LinearGradientProgressNew) bindings[1];
        this.mboundView1 = linearGradientProgressNew;
        linearGradientProgressNew.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) bindings[4];
        this.mboundView4 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[5];
        this.mboundView5 = imageView2;
        imageView2.setTag(null);
        TextView textView2 = (TextView) bindings[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[7];
        this.mboundView7 = textView3;
        textView3.setTag(null);
        setRootTag(root);
        this.mCallback492 = new OnClickListener(this, 1);
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
        if (8 != variableId) {
            return false;
        }
        setDashboardViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.DashboardDataGsBinding
    public void setDashboardViewModel(LauncherViewModel DashboardViewModel) {
        this.mDashboardViewModel = DashboardViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeDashboardViewModelCarInfoOilValue((ObservableField) object, fieldId);
            case 1:
                return onChangeDashboardViewModelCarInfoSpeedUnit((ObservableField) object, fieldId);
            case 2:
                return onChangeDashboardViewModelCarInfoSpeed((ObservableInt) object, fieldId);
            case 3:
                return onChangeDashboardViewModelCarInfoSeatBeltpValue((ObservableField) object, fieldId);
            case 4:
                return onChangeDashboardViewModelCarInfoBrakeValue((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeDashboardViewModelCarInfoOilValue(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeDashboardViewModelCarInfoSpeedUnit(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeDashboardViewModelCarInfoSpeed(ObservableInt DashboardViewModelCarInfoSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeDashboardViewModelCarInfoSeatBeltpValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeDashboardViewModelCarInfoBrakeValue(ObservableField<Boolean> observableField, int fieldId) {
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
        Drawable dashboardViewModelCarInfoSeatBeltpValueMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltF;
        String stringValueOfDashboardViewModelCarInfoSpeed;
        ObservableField<String> dashboardViewModelCarInfoOilValue;
        ObservableField<Boolean> dashboardViewModelCarInfoBrakeValue;
        ObservableField<Boolean> dashboardViewModelCarInfoSeatBeltpValue;
        Drawable drawable;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<String> dashboardViewModelCarInfoOilValue2 = null;
        ObservableField<String> dashboardViewModelCarInfoSpeedUnit = null;
        Boolean dashboardViewModelCarInfoBrakeValueGet = null;
        String dashboardViewModelCarInfoSpeedUnitGet = null;
        Drawable dashboardViewModelCarInfoBrakeValueMboundView4AndroidDrawableGsId8MainIconDashboardBrakeFMboundView4AndroidDrawableGsId8MainIconDashboardBrake = null;
        String dashboardViewModelCarInfoOilValueGet = null;
        LauncherViewModel launcherViewModel = this.mDashboardViewModel;
        ObservableInt dashboardViewModelCarInfoSpeed = null;
        int dashboardViewModelCarInfoSpeedGet = 0;
        String stringValueOfDashboardViewModelCarInfoSpeed2 = null;
        Boolean dashboardViewModelCarInfoSeatBeltpValueGet = null;
        Drawable dashboardViewModelCarInfoSeatBeltpValueMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltF2 = null;
        if ((dirtyFlags & 95) != 0) {
            CarInfo dashboardViewModelCarInfo = LauncherViewModel.carInfo;
            if ((dirtyFlags & 65) != 0) {
                if (dashboardViewModelCarInfo != null) {
                    dashboardViewModelCarInfoOilValue2 = dashboardViewModelCarInfo.oilValue;
                }
                updateRegistration(0, dashboardViewModelCarInfoOilValue2);
                if (dashboardViewModelCarInfoOilValue2 != null) {
                    dashboardViewModelCarInfoOilValueGet = dashboardViewModelCarInfoOilValue2.get();
                }
            }
            if ((dirtyFlags & 66) != 0) {
                if (dashboardViewModelCarInfo != null) {
                    dashboardViewModelCarInfoSpeedUnit = dashboardViewModelCarInfo.speedUnit;
                }
                updateRegistration(1, dashboardViewModelCarInfoSpeedUnit);
                if (dashboardViewModelCarInfoSpeedUnit != null) {
                    dashboardViewModelCarInfoSpeedUnitGet = dashboardViewModelCarInfoSpeedUnit.get();
                }
            }
            if ((dirtyFlags & 68) != 0) {
                if (dashboardViewModelCarInfo != null) {
                    dashboardViewModelCarInfoSpeed = dashboardViewModelCarInfo.speed;
                }
                updateRegistration(2, dashboardViewModelCarInfoSpeed);
                if (dashboardViewModelCarInfoSpeed != null) {
                    dashboardViewModelCarInfoSpeedGet = dashboardViewModelCarInfoSpeed.get();
                }
                stringValueOfDashboardViewModelCarInfoSpeed2 = String.valueOf(dashboardViewModelCarInfoSpeedGet);
            }
            if ((dirtyFlags & 72) != 0) {
                if (dashboardViewModelCarInfo != null) {
                    dashboardViewModelCarInfoSeatBeltpValue = dashboardViewModelCarInfo.seatBeltpValue;
                } else {
                    dashboardViewModelCarInfoSeatBeltpValue = null;
                }
                updateRegistration(3, dashboardViewModelCarInfoSeatBeltpValue);
                if (dashboardViewModelCarInfoSeatBeltpValue != null) {
                    dashboardViewModelCarInfoSeatBeltpValueGet = dashboardViewModelCarInfoSeatBeltpValue.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxDashboardViewModelCarInfoSeatBeltpValueGet = ViewDataBinding.safeUnbox(dashboardViewModelCarInfoSeatBeltpValueGet);
                if ((dirtyFlags & 72) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxDashboardViewModelCarInfoSeatBeltpValueGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= 512;
                    }
                }
                if (androidDatabindingViewDataBindingSafeUnboxDashboardViewModelCarInfoSeatBeltpValueGet) {
                    dashboardViewModelCarInfoOilValue = dashboardViewModelCarInfoOilValue2;
                    drawable = AppCompatResources.getDrawable(this.mboundView5.getContext(), R.drawable.gs_id8_main_icon_dashboard_seatbelt);
                } else {
                    dashboardViewModelCarInfoOilValue = dashboardViewModelCarInfoOilValue2;
                    drawable = AppCompatResources.getDrawable(this.mboundView5.getContext(), R.drawable.gs_id8_main_icon_dashboard_seatbelt_f);
                }
                dashboardViewModelCarInfoSeatBeltpValueMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltF2 = drawable;
            } else {
                dashboardViewModelCarInfoOilValue = dashboardViewModelCarInfoOilValue2;
            }
            if ((dirtyFlags & 80) != 0) {
                if (dashboardViewModelCarInfo != null) {
                    dashboardViewModelCarInfoBrakeValue = dashboardViewModelCarInfo.brakeValue;
                } else {
                    dashboardViewModelCarInfoBrakeValue = null;
                }
                updateRegistration(4, dashboardViewModelCarInfoBrakeValue);
                if (dashboardViewModelCarInfoBrakeValue != null) {
                    dashboardViewModelCarInfoBrakeValueGet = dashboardViewModelCarInfoBrakeValue.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxDashboardViewModelCarInfoBrakeValueGet = ViewDataBinding.safeUnbox(dashboardViewModelCarInfoBrakeValueGet);
                if ((dirtyFlags & 80) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxDashboardViewModelCarInfoBrakeValueGet) {
                        dirtyFlags |= 256;
                    } else {
                        dirtyFlags |= 128;
                    }
                }
                dashboardViewModelCarInfoBrakeValueMboundView4AndroidDrawableGsId8MainIconDashboardBrakeFMboundView4AndroidDrawableGsId8MainIconDashboardBrake = AppCompatResources.getDrawable(this.mboundView4.getContext(), androidDatabindingViewDataBindingSafeUnboxDashboardViewModelCarInfoBrakeValueGet ? R.drawable.gs_id8_main_icon_dashboard_brake_f : R.drawable.gs_id8_main_icon_dashboard_brake);
                stringValueOfDashboardViewModelCarInfoSpeed = stringValueOfDashboardViewModelCarInfoSpeed2;
                dashboardViewModelCarInfoSeatBeltpValueMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltF = dashboardViewModelCarInfoSeatBeltpValueMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltF2;
                dashboardViewModelCarInfoOilValue2 = dashboardViewModelCarInfoOilValue;
            } else {
                stringValueOfDashboardViewModelCarInfoSpeed = stringValueOfDashboardViewModelCarInfoSpeed2;
                dashboardViewModelCarInfoSeatBeltpValueMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltF = dashboardViewModelCarInfoSeatBeltpValueMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltF2;
                dashboardViewModelCarInfoOilValue2 = dashboardViewModelCarInfoOilValue;
            }
        } else {
            stringValueOfDashboardViewModelCarInfoSpeed = null;
            dashboardViewModelCarInfoSeatBeltpValueMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltF = null;
        }
        if ((dirtyFlags & 64) != 0) {
            this.ivMask.setOnClickListener(this.mCallback492);
        }
        if ((dirtyFlags & 68) != 0) {
            this.mboundView1.setScae(dashboardViewModelCarInfoSpeedGet);
            TextViewBindingAdapter.setText(this.mboundView6, stringValueOfDashboardViewModelCarInfoSpeed);
        }
        if ((dirtyFlags & 65) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, dashboardViewModelCarInfoOilValueGet);
        }
        if ((dirtyFlags & 80) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, dashboardViewModelCarInfoBrakeValueMboundView4AndroidDrawableGsId8MainIconDashboardBrakeFMboundView4AndroidDrawableGsId8MainIconDashboardBrake);
        }
        if ((dirtyFlags & 72) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, dashboardViewModelCarInfoSeatBeltpValueMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltMboundView5AndroidDrawableGsId8MainIconDashboardSeatbeltF);
        }
        if ((dirtyFlags & 66) != 0) {
            TextViewBindingAdapter.setText(this.mboundView7, dashboardViewModelCarInfoSpeedUnitGet);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel dashboardViewModel = this.mDashboardViewModel;
        if (dashboardViewModel != null) {
            dashboardViewModel.openDashboard(callbackArg_0);
        }
    }
}