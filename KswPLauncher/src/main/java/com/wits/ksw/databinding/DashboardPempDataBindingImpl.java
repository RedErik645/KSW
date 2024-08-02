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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class DashboardPempDataBindingImpl extends DashboardPempDataBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback563;
    private long mDirtyFlags;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final ImageView mboundView4;
    private final TextView mboundView5;
    private final ImageView mboundView6;
    private final ImageView mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_dashboard, 8);
        sparseIntArray.put(R.id.divider, 9);
        sparseIntArray.put(R.id.iv_speed, 10);
    }

    public DashboardPempDataBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private DashboardPempDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (ImageView) bindings[9], (ImageView) bindings[1], (FrameLayout) bindings[10], (RelativeLayout) bindings[0], (TextView) bindings[8]);
        this.mDirtyFlags = -1;
        this.ivMask.setTag(null);
        this.llContainer.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) bindings[4];
        this.mboundView4 = imageView;
        imageView.setTag(null);
        TextView textView3 = (TextView) bindings[5];
        this.mboundView5 = textView3;
        textView3.setTag(null);
        ImageView imageView2 = (ImageView) bindings[6];
        this.mboundView6 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[7];
        this.mboundView7 = imageView3;
        imageView3.setTag(null);
        setRootTag(root);
        this.mCallback563 = new OnClickListener(this, 1);
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

    @Override // com.wits.ksw.databinding.DashboardPempDataBinding
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
        Drawable dashboardViewModelCarInfoSeatBeltpValueMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltF;
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
        Drawable dashboardViewModelCarInfoBrakeValueMboundView7AndroidDrawablePempId8MainIconDashboardBrakeFMboundView7AndroidDrawablePempId8MainIconDashboardBrake = null;
        Boolean dashboardViewModelCarInfoBrakeValueGet = null;
        String dashboardViewModelCarInfoSpeedUnitGet = null;
        String dashboardViewModelCarInfoOilValueGet = null;
        LauncherViewModel launcherViewModel = this.mDashboardViewModel;
        ObservableInt dashboardViewModelCarInfoSpeed = null;
        int dashboardViewModelCarInfoSpeedGet = 0;
        String stringValueOfDashboardViewModelCarInfoSpeed2 = null;
        Boolean dashboardViewModelCarInfoSeatBeltpValueGet = null;
        Drawable dashboardViewModelCarInfoSeatBeltpValueMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltF2 = null;
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
                    drawable = AppCompatResources.getDrawable(this.mboundView6.getContext(), R.drawable.pemp_id8_main_icon_dashboard_seatbelt);
                } else {
                    dashboardViewModelCarInfoOilValue = dashboardViewModelCarInfoOilValue2;
                    drawable = AppCompatResources.getDrawable(this.mboundView6.getContext(), R.drawable.pemp_id8_main_icon_dashboard_seatbelt_f);
                }
                dashboardViewModelCarInfoSeatBeltpValueMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltF2 = drawable;
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
                dashboardViewModelCarInfoBrakeValueMboundView7AndroidDrawablePempId8MainIconDashboardBrakeFMboundView7AndroidDrawablePempId8MainIconDashboardBrake = AppCompatResources.getDrawable(this.mboundView7.getContext(), androidDatabindingViewDataBindingSafeUnboxDashboardViewModelCarInfoBrakeValueGet ? R.drawable.pemp_id8_main_icon_dashboard_brake_f : R.drawable.pemp_id8_main_icon_dashboard_brake);
                stringValueOfDashboardViewModelCarInfoSpeed = stringValueOfDashboardViewModelCarInfoSpeed2;
                dashboardViewModelCarInfoSeatBeltpValueMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltF = dashboardViewModelCarInfoSeatBeltpValueMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltF2;
                dashboardViewModelCarInfoOilValue2 = dashboardViewModelCarInfoOilValue;
            } else {
                stringValueOfDashboardViewModelCarInfoSpeed = stringValueOfDashboardViewModelCarInfoSpeed2;
                dashboardViewModelCarInfoSeatBeltpValueMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltF = dashboardViewModelCarInfoSeatBeltpValueMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltF2;
                dashboardViewModelCarInfoOilValue2 = dashboardViewModelCarInfoOilValue;
            }
        } else {
            stringValueOfDashboardViewModelCarInfoSpeed = null;
            dashboardViewModelCarInfoSeatBeltpValueMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltF = null;
        }
        if ((dirtyFlags & 64) != 0) {
            this.ivMask.setOnClickListener(this.mCallback563);
        }
        if ((dirtyFlags & 65) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, dashboardViewModelCarInfoOilValueGet);
        }
        if ((dirtyFlags & 68) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, stringValueOfDashboardViewModelCarInfoSpeed);
            LauncherViewModel.setPempId8SpeedRotation(this.mboundView4, dashboardViewModelCarInfoSpeedGet);
        }
        if ((dirtyFlags & 66) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, dashboardViewModelCarInfoSpeedUnitGet);
        }
        if ((dirtyFlags & 72) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView6, dashboardViewModelCarInfoSeatBeltpValueMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltMboundView6AndroidDrawablePempId8MainIconDashboardSeatbeltF);
        }
        if ((dirtyFlags & 80) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView7, dashboardViewModelCarInfoBrakeValueMboundView7AndroidDrawablePempId8MainIconDashboardBrakeFMboundView7AndroidDrawablePempId8MainIconDashboardBrake);
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
