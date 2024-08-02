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
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.LinearGradientProgressNew;

public class FragmentDashboardEditBindingImpl extends FragmentDashboardEditBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final LinearGradientProgressNew mboundView1;
    private final TextView mboundView2;
    private final ImageView mboundView3;
    private final ImageView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout, 7);
        sparseIntArray.put(R.id.title, 8);
        sparseIntArray.put(R.id.iv_divider, 9);
    }

    public FragmentDashboardEditBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private FragmentDashboardEditBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (ImageView) bindings[9], (RelativeLayout) bindings[7], (TextView) bindings[8]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        LinearGradientProgressNew linearGradientProgressNew = (LinearGradientProgressNew) bindings[1];
        this.mboundView1 = linearGradientProgressNew;
        linearGradientProgressNew.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) bindings[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[4];
        this.mboundView4 = imageView2;
        imageView2.setTag(null);
        TextView textView2 = (TextView) bindings[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[6];
        this.mboundView6 = textView3;
        textView3.setTag(null);
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
        if (8 != variableId) {
            return false;
        }
        setDashboardViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.FragmentDashboardEditBinding
    public void setDashboardViewModel(LauncherViewModel DashboardViewModel) {
        this.mDashboardViewModel = DashboardViewModel;
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
        Drawable dashboardViewModelCarInfoSeatBeltpValueMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltF;
        String stringValueOfDashboardViewModelCarInfoSpeed;
        ObservableField<Boolean> dashboardViewModelCarInfoBrakeValue;
        ObservableField<String> dashboardViewModelCarInfoOilValue;
        Drawable drawable;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<String> dashboardViewModelCarInfoOilValue2 = null;
        ObservableField<String> dashboardViewModelCarInfoSpeedUnit = null;
        Boolean dashboardViewModelCarInfoBrakeValueGet = null;
        String dashboardViewModelCarInfoSpeedUnitGet = null;
        Drawable dashboardViewModelCarInfoBrakeValueMboundView3AndroidDrawableId8MainEditIconDashboardBrakeFMboundView3AndroidDrawableId8MainEditIconDashboardBrake = null;
        String dashboardViewModelCarInfoOilValueGet = null;
        ObservableInt dashboardViewModelCarInfoSpeed = null;
        int dashboardViewModelCarInfoSpeedGet = 0;
        ObservableField<Boolean> dashboardViewModelCarInfoSeatBeltpValue = null;
        String stringValueOfDashboardViewModelCarInfoSpeed2 = null;
        Boolean dashboardViewModelCarInfoSeatBeltpValueGet = null;
        Drawable dashboardViewModelCarInfoSeatBeltpValueMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltF2 = null;
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
                dashboardViewModelCarInfoSeatBeltpValueMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltF2 = AppCompatResources.getDrawable(this.mboundView4.getContext(), androidDatabindingViewDataBindingSafeUnboxDashboardViewModelCarInfoSeatBeltpValueGet ? R.drawable.id8_main_edit_icon_dashboard_seatbelt : R.drawable.id8_main_edit_icon_dashboard_seatbelt_f);
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
                if (androidDatabindingViewDataBindingSafeUnboxDashboardViewModelCarInfoBrakeValueGet) {
                    dashboardViewModelCarInfoOilValue = dashboardViewModelCarInfoOilValue2;
                    drawable = AppCompatResources.getDrawable(this.mboundView3.getContext(), R.drawable.id8_main_edit_icon_dashboard_brake_f);
                } else {
                    dashboardViewModelCarInfoOilValue = dashboardViewModelCarInfoOilValue2;
                    drawable = AppCompatResources.getDrawable(this.mboundView3.getContext(), R.drawable.id8_main_edit_icon_dashboard_brake);
                }
                dashboardViewModelCarInfoBrakeValueMboundView3AndroidDrawableId8MainEditIconDashboardBrakeFMboundView3AndroidDrawableId8MainEditIconDashboardBrake = drawable;
                stringValueOfDashboardViewModelCarInfoSpeed = stringValueOfDashboardViewModelCarInfoSpeed2;
                dashboardViewModelCarInfoSeatBeltpValueMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltF = dashboardViewModelCarInfoSeatBeltpValueMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltF2;
                dashboardViewModelCarInfoOilValue2 = dashboardViewModelCarInfoOilValue;
            } else {
                stringValueOfDashboardViewModelCarInfoSpeed = stringValueOfDashboardViewModelCarInfoSpeed2;
                dashboardViewModelCarInfoSeatBeltpValueMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltF = dashboardViewModelCarInfoSeatBeltpValueMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltF2;
            }
        } else {
            stringValueOfDashboardViewModelCarInfoSpeed = null;
            dashboardViewModelCarInfoSeatBeltpValueMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltF = null;
        }
        if ((dirtyFlags & 68) != 0) {
            this.mboundView1.setScae(dashboardViewModelCarInfoSpeedGet);
            TextViewBindingAdapter.setText(this.mboundView5, stringValueOfDashboardViewModelCarInfoSpeed);
        }
        if ((dirtyFlags & 65) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, dashboardViewModelCarInfoOilValueGet);
        }
        if ((dirtyFlags & 80) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, dashboardViewModelCarInfoBrakeValueMboundView3AndroidDrawableId8MainEditIconDashboardBrakeFMboundView3AndroidDrawableId8MainEditIconDashboardBrake);
        }
        if ((dirtyFlags & 72) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, dashboardViewModelCarInfoSeatBeltpValueMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltMboundView4AndroidDrawableId8MainEditIconDashboardSeatbeltF);
        }
        if ((dirtyFlags & 66) != 0) {
            TextViewBindingAdapter.setText(this.mboundView6, dashboardViewModelCarInfoSpeedUnitGet);
        }
    }
}
