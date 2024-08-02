package com.wits.ksw.databinding;

import android.content.res.Resources;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.model.DashboardViewModel;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.CustomSkinImageView;

public class AlsId7UiDashBoardSubViewBindingImpl extends AlsId7UiDashBoardSubViewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback223;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.textView2, 9);
        sparseIntArray.put(R.id.imageView5, 10);
    }

    public AlsId7UiDashBoardSubViewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private AlsId7UiDashBoardSubViewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7, (TextView) bindings[3], (ConstraintLayout) bindings[0], (CustomSkinImageView) bindings[1], (ImageView) bindings[10], (TextView) bindings[2], (ImageView) bindings[8], (TextView) bindings[7], (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[4], (TextView) bindings[9]);
        this.mDirtyFlags = -1;
        this.brakeTextView.setTag(null);
        this.dashboardConstraintLayout.setTag(null);
        this.dashboardImageView.setTag(null);
        this.oilTextView.setTag(null);
        this.pointerImageView.setTag(null);
        this.rpmTextView.setTag(null);
        this.seatBeltTextView.setTag(null);
        this.speedTextView.setTag(null);
        this.tempTextView.setTag(null);
        setRootTag(root);
        this.mCallback223 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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
        if (5 != variableId) {
            return false;
        }
        setCarViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AlsId7UiDashBoardSubViewBinding
    public void setCarViewModel(LauncherViewModel CarViewModel) {
        this.mCarViewModel = CarViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeCarViewModelCarInfoTempStr((ObservableField) object, fieldId);
            case 1:
                return onChangeCarViewModelCarInfoTurnSpeed((ObservableInt) object, fieldId);
            case 2:
                return onChangeCarViewModelCarInfoTurnSpeedAnge((ObservableFloat) object, fieldId);
            case 3:
                return onChangeCarViewModelCarInfoUnitStr((ObservableField) object, fieldId);
            case 4:
                return onChangeCarViewModelCarInfoBrakeValue((ObservableField) object, fieldId);
            case 5:
                return onChangeCarViewModelCarInfoOilValue((ObservableField) object, fieldId);
            case 6:
                return onChangeCarViewModelCarInfoSeatBeltpValue((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeCarViewModelCarInfoTempStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeCarViewModelCarInfoTurnSpeed(ObservableInt CarViewModelCarInfoTurnSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeCarViewModelCarInfoTurnSpeedAnge(ObservableFloat CarViewModelCarInfoTurnSpeedAnge, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeCarViewModelCarInfoUnitStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeCarViewModelCarInfoBrakeValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeCarViewModelCarInfoOilValue(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeCarViewModelCarInfoSeatBeltpValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        String carViewModelCarInfoSeatBeltpValueSeatBeltTextViewAndroidStringKswId7Seatbelt2SeatBeltTextViewAndroidStringKswId7Seatbelt1;
        String stringValueOfCarViewModelCarInfoTurnSpeed;
        String carViewModelCarInfoOilValueGet;
        String carViewModelCarInfoTempStrGet;
        boolean androidDatabindingViewDataBindingSafeUnboxCarViewModelCarInfoSeatBeltpValueGet;
        ObservableField<Boolean> carViewModelCarInfoSeatBeltpValue;
        long dirtyFlags2;
        ObservableField<Boolean> carViewModelCarInfoSeatBeltpValue2;
        int i;
        Resources resources;
        ObservableField<String> carViewModelCarInfoOilValue;
        ObservableField<Boolean> carViewModelCarInfoBrakeValue;
        ObservableField<Boolean> carViewModelCarInfoBrakeValue2;
        String str;
        ObservableField<String> carViewModelCarInfoUnitStr;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Boolean carViewModelCarInfoSeatBeltpValueGet = null;
        ObservableField<String> carViewModelCarInfoTempStr = null;
        ObservableInt carViewModelCarInfoTurnSpeed = null;
        ObservableFloat carViewModelCarInfoTurnSpeedAnge = null;
        String carViewModelCarInfoBrakeValueBrakeTextViewAndroidStringKswId7Brake2BrakeTextViewAndroidStringKswId7Brake1 = null;
        int carViewModelCarInfoTurnSpeedGet = 0;
        LauncherViewModel launcherViewModel = this.mCarViewModel;
        String carViewModelCarInfoUnitStrGet = null;
        float carViewModelCarInfoTurnSpeedAngeGet = 0.0f;
        String carViewModelCarInfoOilValueGet2 = null;
        Boolean carViewModelCarInfoBrakeValueGet = null;
        String stringValueOfCarViewModelCarInfoTurnSpeed2 = null;
        String carViewModelCarInfoTempStrGet2 = null;
        if ((dirtyFlags & 383) != 0) {
            CarInfo carViewModelCarInfo = LauncherViewModel.carInfo;
            if ((dirtyFlags & 257) != 0) {
                if (carViewModelCarInfo != null) {
                    carViewModelCarInfoTempStr = carViewModelCarInfo.tempStr;
                }
                updateRegistration(0, carViewModelCarInfoTempStr);
                if (carViewModelCarInfoTempStr != null) {
                    carViewModelCarInfoTempStrGet2 = carViewModelCarInfoTempStr.get();
                }
            }
            if ((dirtyFlags & 258) != 0) {
                if (carViewModelCarInfo != null) {
                    carViewModelCarInfoTurnSpeed = carViewModelCarInfo.turnSpeed;
                }
                updateRegistration(1, carViewModelCarInfoTurnSpeed);
                if (carViewModelCarInfoTurnSpeed != null) {
                    carViewModelCarInfoTurnSpeedGet = carViewModelCarInfoTurnSpeed.get();
                }
                stringValueOfCarViewModelCarInfoTurnSpeed2 = String.valueOf(carViewModelCarInfoTurnSpeedGet);
            }
            if ((dirtyFlags & 260) != 0) {
                if (carViewModelCarInfo != null) {
                    carViewModelCarInfoTurnSpeedAnge = carViewModelCarInfo.turnSpeedAnge;
                }
                updateRegistration(2, carViewModelCarInfoTurnSpeedAnge);
                if (carViewModelCarInfoTurnSpeedAnge != null) {
                    carViewModelCarInfoTurnSpeedAngeGet = carViewModelCarInfoTurnSpeedAnge.get();
                }
            }
            if ((dirtyFlags & 264) != 0) {
                if (carViewModelCarInfo != null) {
                    carViewModelCarInfoUnitStr = carViewModelCarInfo.unitStr;
                } else {
                    carViewModelCarInfoUnitStr = null;
                }
                androidDatabindingViewDataBindingSafeUnboxCarViewModelCarInfoSeatBeltpValueGet = false;
                updateRegistration(3, carViewModelCarInfoUnitStr);
                if (carViewModelCarInfoUnitStr != null) {
                    carViewModelCarInfoUnitStrGet = carViewModelCarInfoUnitStr.get();
                }
            } else {
                androidDatabindingViewDataBindingSafeUnboxCarViewModelCarInfoSeatBeltpValueGet = false;
            }
            if ((dirtyFlags & 272) != 0) {
                if (carViewModelCarInfo != null) {
                    carViewModelCarInfoBrakeValue = carViewModelCarInfo.brakeValue;
                } else {
                    carViewModelCarInfoBrakeValue = null;
                }
                updateRegistration(4, carViewModelCarInfoBrakeValue);
                if (carViewModelCarInfoBrakeValue != null) {
                    carViewModelCarInfoBrakeValueGet = carViewModelCarInfoBrakeValue.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxCarViewModelCarInfoBrakeValueGet = ViewDataBinding.safeUnbox(carViewModelCarInfoBrakeValueGet);
                if ((dirtyFlags & 272) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxCarViewModelCarInfoBrakeValueGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= 512;
                    }
                }
                if (androidDatabindingViewDataBindingSafeUnboxCarViewModelCarInfoBrakeValueGet) {
                    carViewModelCarInfoBrakeValue2 = carViewModelCarInfoBrakeValue;
                    str = this.brakeTextView.getResources().getString(R.string.ksw_id7_brake2);
                } else {
                    carViewModelCarInfoBrakeValue2 = carViewModelCarInfoBrakeValue;
                    str = this.brakeTextView.getResources().getString(R.string.ksw_id7_brake1);
                }
                carViewModelCarInfoBrakeValueBrakeTextViewAndroidStringKswId7Brake2BrakeTextViewAndroidStringKswId7Brake1 = str;
            }
            if ((dirtyFlags & 288) != 0) {
                if (carViewModelCarInfo != null) {
                    carViewModelCarInfoOilValue = carViewModelCarInfo.oilValue;
                } else {
                    carViewModelCarInfoOilValue = null;
                }
                updateRegistration(5, carViewModelCarInfoOilValue);
                if (carViewModelCarInfoOilValue != null) {
                    carViewModelCarInfoOilValueGet2 = carViewModelCarInfoOilValue.get();
                }
            }
            if ((dirtyFlags & 320) != 0) {
                if (carViewModelCarInfo != null) {
                    carViewModelCarInfoSeatBeltpValue = carViewModelCarInfo.seatBeltpValue;
                } else {
                    carViewModelCarInfoSeatBeltpValue = null;
                }
                updateRegistration(6, carViewModelCarInfoSeatBeltpValue);
                if (carViewModelCarInfoSeatBeltpValue != null) {
                    carViewModelCarInfoSeatBeltpValueGet = carViewModelCarInfoSeatBeltpValue.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxCarViewModelCarInfoSeatBeltpValueGet2 = ViewDataBinding.safeUnbox(carViewModelCarInfoSeatBeltpValueGet);
                if ((dirtyFlags & 320) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxCarViewModelCarInfoSeatBeltpValueGet2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                }
                if (androidDatabindingViewDataBindingSafeUnboxCarViewModelCarInfoSeatBeltpValueGet2) {
                    carViewModelCarInfoSeatBeltpValue2 = carViewModelCarInfoSeatBeltpValue;
                    resources = this.seatBeltTextView.getResources();
                    dirtyFlags2 = dirtyFlags;
                    i = R.string.ksw_id7_seatbelt2;
                } else {
                    carViewModelCarInfoSeatBeltpValue2 = carViewModelCarInfoSeatBeltpValue;
                    dirtyFlags2 = dirtyFlags;
                    resources = this.seatBeltTextView.getResources();
                    i = R.string.ksw_id7_seatbelt1;
                }
                String carViewModelCarInfoSeatBeltpValueSeatBeltTextViewAndroidStringKswId7Seatbelt2SeatBeltTextViewAndroidStringKswId7Seatbelt12 = resources.getString(i);
                carViewModelCarInfoTempStrGet = carViewModelCarInfoTempStrGet2;
                dirtyFlags = dirtyFlags2;
                carViewModelCarInfoOilValueGet = carViewModelCarInfoOilValueGet2;
                stringValueOfCarViewModelCarInfoTurnSpeed = stringValueOfCarViewModelCarInfoTurnSpeed2;
                carViewModelCarInfoSeatBeltpValueSeatBeltTextViewAndroidStringKswId7Seatbelt2SeatBeltTextViewAndroidStringKswId7Seatbelt1 = carViewModelCarInfoSeatBeltpValueSeatBeltTextViewAndroidStringKswId7Seatbelt2SeatBeltTextViewAndroidStringKswId7Seatbelt12;
            } else {
                carViewModelCarInfoOilValueGet = carViewModelCarInfoOilValueGet2;
                stringValueOfCarViewModelCarInfoTurnSpeed = stringValueOfCarViewModelCarInfoTurnSpeed2;
                carViewModelCarInfoTempStrGet = carViewModelCarInfoTempStrGet2;
                carViewModelCarInfoSeatBeltpValueSeatBeltTextViewAndroidStringKswId7Seatbelt2SeatBeltTextViewAndroidStringKswId7Seatbelt1 = null;
            }
        } else {
            carViewModelCarInfoOilValueGet = null;
            stringValueOfCarViewModelCarInfoTurnSpeed = null;
            carViewModelCarInfoTempStrGet = null;
            carViewModelCarInfoSeatBeltpValueSeatBeltTextViewAndroidStringKswId7Seatbelt2SeatBeltTextViewAndroidStringKswId7Seatbelt1 = null;
        }
        if ((dirtyFlags & 272) != 0) {
            TextViewBindingAdapter.setText(this.brakeTextView, carViewModelCarInfoBrakeValueBrakeTextViewAndroidStringKswId7Brake2BrakeTextViewAndroidStringKswId7Brake1);
        }
        if ((dirtyFlags & 256) != 0) {
            this.dashboardImageView.setOnClickListener(this.mCallback223);
        }
        if ((dirtyFlags & 288) != 0) {
            TextViewBindingAdapter.setText(this.oilTextView, carViewModelCarInfoOilValueGet);
        }
        if ((dirtyFlags & 260) != 0) {
            DashboardViewModel.setRotation(this.pointerImageView, carViewModelCarInfoTurnSpeedAngeGet);
        }
        if ((dirtyFlags & 264) != 0) {
            TextViewBindingAdapter.setText(this.rpmTextView, carViewModelCarInfoUnitStrGet);
        }
        if ((dirtyFlags & 320) != 0) {
            TextViewBindingAdapter.setText(this.seatBeltTextView, carViewModelCarInfoSeatBeltpValueSeatBeltTextViewAndroidStringKswId7Seatbelt2SeatBeltTextViewAndroidStringKswId7Seatbelt1);
        }
        if ((dirtyFlags & 258) != 0) {
            TextViewBindingAdapter.setText(this.speedTextView, stringValueOfCarViewModelCarInfoTurnSpeed);
        }
        if ((dirtyFlags & 257) != 0) {
            TextViewBindingAdapter.setText(this.tempTextView, carViewModelCarInfoTempStrGet);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel carViewModel = this.mCarViewModel;
        if (carViewModel != null) {
            carViewModel.openDashboard(callbackArg_0);
        }
    }
}
