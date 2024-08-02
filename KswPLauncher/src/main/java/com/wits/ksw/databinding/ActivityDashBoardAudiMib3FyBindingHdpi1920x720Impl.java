package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.model.DashboardViewModel;
import com.wits.ksw.launcher.view.ID7SpeedImageView;

public class ActivityDashBoardAudiMib3FyBindingHdpi1920x720Impl extends ActivityDashBoardAudiMib3FyBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.clock_time, 16);
        sparseIntArray.put(R.id.tachometerImageView, 17);
        sparseIntArray.put(R.id.show_mode_iv, 18);
        sparseIntArray.put(R.id.mode_rg, 19);
        sparseIntArray.put(R.id.energy_conservation_rb, 20);
        sparseIntArray.put(R.id.comfortable_rb, 21);
        sparseIntArray.put(R.id.motion_rb, 22);
    }

    public ActivityDashBoardAudiMib3FyBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }

    private ActivityDashBoardAudiMib3FyBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 13, (ImageView) bindings[1], (ImageView) bindings[9], (TextClock) bindings[16], (RadioButton) bindings[21], (ImageView) bindings[10], (ImageView) bindings[11], (ImageView) bindings[12], (ImageView) bindings[13], (RadioButton) bindings[20], (ImageView) bindings[14], (RelativeLayout) bindings[15], (ConstraintLayout) bindings[0], (RadioGroup) bindings[19], (RadioButton) bindings[22], (ImageView) bindings[2], (ImageView) bindings[18], (ID7SpeedImageView) bindings[6], (TextView) bindings[5], (ID7SpeedImageView) bindings[4], (ImageView) bindings[17], (TextView) bindings[3], (ImageView) bindings[8], (TextView) bindings[7]);
        this.mDirtyFlags = -1;
        this.brakeTextView.setTag(null);
        this.carImageView.setTag(null);
        this.dorrBackImageView.setTag(null);
        this.dorrLeftFlImageView.setTag(null);
        this.dorrLeftFrImageView.setTag(null);
        this.dorrLeftRlImageView.setTag(null);
        this.imageView19.setTag(null);
        this.leftModeRl.setTag(null);
        this.linearLayout2.setTag(null);
        this.seatBeltTextView.setTag(null);
        this.speedPointerImageView.setTag(null);
        this.speedPointerTextView.setTag(null);
        this.speedometerImageView.setTag(null);
        this.temperatureTextView.setTag(null);
        this.zspeedPointerImageView.setTag(null);
        this.zspeedPointerTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE;
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
        setViewModel((DashboardViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityDashBoardAudiMib3FyBinding
    public void setViewModel(DashboardViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelCarInfoTurnSpeed((ObservableInt) object, fieldId);
            case 1:
                return onChangeViewModelCarInfoCarImage((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeViewModelCarInfoFrDoorState((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelShowAls((ObservableBoolean) object, fieldId);
            case 4:
                return onChangeViewModelCarInfoSpeedWatch((ObservableInt) object, fieldId);
            case 5:
                return onChangeViewModelCarInfoRlDoorState((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelCarInfoRrDoorState((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelCarInfoTempStr((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelCarInfoSeatBeltpValue((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelCarInfoFlDoorState((ObservableField) object, fieldId);
            case 10:
                return onChangeViewModelCarInfoSpeed((ObservableInt) object, fieldId);
            case 11:
                return onChangeViewModelCarInfoBDoorState((ObservableField) object, fieldId);
            case 12:
                return onChangeViewModelCarInfoBrakeValue((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelCarInfoTurnSpeed(ObservableInt ViewModelCarInfoTurnSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoCarImage(ObservableBoolean ViewModelCarInfoCarImage, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoFrDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelShowAls(ObservableBoolean ViewModelShowAls, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSpeedWatch(ObservableInt ViewModelCarInfoSpeedWatch, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoRlDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoRrDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoTempStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSeatBeltpValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoFlDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSpeed(ObservableInt ViewModelCarInfoSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoBDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoBrakeValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r0v8 java.lang.String: [D('viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelCarInfoTempStrGet' java.lang.String)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE;
        String stringValueOfViewModelCarInfoTurnSpeed;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE;
        String viewModelCarInfoTempStrGet;
        int viewModelCarInfoBrakeValueViewVISIBLEViewGONE;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2;
        String stringValueOfViewModelCarInfoSpeed;
        int viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE;
        String viewModelCarInfoTempStrGet2;
        int viewModelShowAlsViewVISIBLEViewGONE;
        String viewModelCarInfoTempStrGet3;
        ObservableBoolean viewModelShowAls;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet;
        ObservableField<Boolean> viewModelCarInfoBDoorState;
        ObservableInt viewModelCarInfoTurnSpeed;
        ObservableInt viewModelCarInfoTurnSpeed2;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2;
        ObservableField<Boolean> viewModelCarInfoBDoorState2;
        ObservableField<Boolean> viewModelCarInfoBDoorState3;
        ObservableField<Boolean> viewModelCarInfoBDoorState4;
        ObservableInt viewModelCarInfoSpeed;
        ObservableField<Boolean> viewModelCarInfoFlDoorState;
        ObservableField<Boolean> viewModelCarInfoSeatBeltpValue;
        ObservableField<String> viewModelCarInfoTempStr;
        ObservableField<Boolean> viewModelCarInfoRrDoorState;
        ObservableField<Boolean> viewModelCarInfoRlDoorState;
        ObservableInt viewModelCarInfoSpeedWatch;
        ObservableField<Boolean> viewModelCarInfoFrDoorState;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE = 0;
        Boolean viewModelCarInfoBDoorStateGet = null;
        int viewModelCarInfoSpeedWatchGet = 0;
        int viewModelCarInfoSpeedGet = 0;
        int viewModelCarInfoBDoorStateViewVISIBLEViewINVISIBLE = 0;
        ObservableBoolean viewModelCarInfoCarImage = null;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet = false;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet = false;
        Boolean viewModelCarInfoSeatBeltpValueGet = null;
        Boolean viewModelCarInfoRlDoorStateGet = null;
        int viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        String stringValueOfViewModelCarInfoSpeed2 = null;
        Boolean viewModelCarInfoRrDoorStateGet = null;
        int viewModelCarInfoTurnSpeedGet = 0;
        boolean viewModelShowAlsGet = false;
        Boolean viewModelCarInfoFlDoorStateGet = null;
        String viewModelCarInfoTempStrGet4 = null;
        Boolean viewModelCarInfoBrakeValueGet = null;
        int viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        String stringValueOfViewModelCarInfoTurnSpeed2 = null;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        boolean viewModelCarInfoCarImageGet = false;
        Boolean viewModelCarInfoFrDoorStateGet = null;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3 = 0;
        DashboardViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 24567) != 0) {
            CarInfo viewModelCarInfo = DashboardViewModel.carInfo;
            if ((dirtyFlags & 16385) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoBDoorState = null;
                    viewModelCarInfoTurnSpeed = viewModelCarInfo.turnSpeed;
                } else {
                    viewModelCarInfoBDoorState = null;
                    viewModelCarInfoTurnSpeed = null;
                }
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet = false;
                updateRegistration(0, viewModelCarInfoTurnSpeed);
                if (viewModelCarInfoTurnSpeed != null) {
                    viewModelCarInfoTurnSpeedGet = viewModelCarInfoTurnSpeed.get();
                }
                stringValueOfViewModelCarInfoTurnSpeed2 = String.valueOf(viewModelCarInfoTurnSpeedGet);
            } else {
                viewModelCarInfoBDoorState = null;
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet = false;
                viewModelCarInfoTurnSpeed = null;
            }
            if ((dirtyFlags & 16386) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoCarImage = viewModelCarInfo.carImage;
                }
                updateRegistration(1, viewModelCarInfoCarImage);
                if (viewModelCarInfoCarImage != null) {
                    viewModelCarInfoCarImageGet = viewModelCarInfoCarImage.get();
                }
                if ((dirtyFlags & 16386) != 0) {
                    if (viewModelCarInfoCarImageGet) {
                        dirtyFlags |= 4294967296L;
                    } else {
                        dirtyFlags |= 2147483648L;
                    }
                }
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3 = viewModelCarInfoCarImageGet ? 0 : 4;
            }
            if ((dirtyFlags & 16388) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoFrDoorState = viewModelCarInfo.frDoorState;
                } else {
                    viewModelCarInfoFrDoorState = null;
                }
                viewModelCarInfoTurnSpeed2 = viewModelCarInfoTurnSpeed;
                updateRegistration(2, viewModelCarInfoFrDoorState);
                if (viewModelCarInfoFrDoorState != null) {
                    viewModelCarInfoFrDoorStateGet = viewModelCarInfoFrDoorState.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoFrDoorStateGet);
                if ((dirtyFlags & 16388) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet) {
                        dirtyFlags |= 1073741824;
                    } else {
                        dirtyFlags |= 536870912;
                    }
                }
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet ? 0 : 4;
            } else {
                viewModelCarInfoTurnSpeed2 = viewModelCarInfoTurnSpeed;
            }
            if ((dirtyFlags & 16400) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSpeedWatch = viewModelCarInfo.speedWatch;
                } else {
                    viewModelCarInfoSpeedWatch = null;
                }
                updateRegistration(4, viewModelCarInfoSpeedWatch);
                if (viewModelCarInfoSpeedWatch != null) {
                    viewModelCarInfoSpeedWatchGet = viewModelCarInfoSpeedWatch.get();
                }
            }
            if ((dirtyFlags & 16416) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoRlDoorState = viewModelCarInfo.rlDoorState;
                } else {
                    viewModelCarInfoRlDoorState = null;
                }
                updateRegistration(5, viewModelCarInfoRlDoorState);
                if (viewModelCarInfoRlDoorState != null) {
                    viewModelCarInfoRlDoorStateGet = viewModelCarInfoRlDoorState.get();
                }
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoRlDoorStateGet);
                if ((dirtyFlags & 16416) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet) {
                        dirtyFlags |= 67108864;
                    } else {
                        dirtyFlags |= 33554432;
                    }
                }
                viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 16448) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoRrDoorState = viewModelCarInfo.rrDoorState;
                } else {
                    viewModelCarInfoRrDoorState = null;
                }
                updateRegistration(6, viewModelCarInfoRrDoorState);
                if (viewModelCarInfoRrDoorState != null) {
                    viewModelCarInfoRrDoorStateGet = viewModelCarInfoRrDoorState.get();
                }
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoRrDoorStateGet);
                if ((dirtyFlags & 16448) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                }
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 16512) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoTempStr = viewModelCarInfo.tempStr;
                } else {
                    viewModelCarInfoTempStr = null;
                }
                updateRegistration(7, viewModelCarInfoTempStr);
                if (viewModelCarInfoTempStr != null) {
                    viewModelCarInfoTempStrGet4 = viewModelCarInfoTempStr.get();
                }
            }
            if ((dirtyFlags & 16640) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSeatBeltpValue = viewModelCarInfo.seatBeltpValue;
                } else {
                    viewModelCarInfoSeatBeltpValue = null;
                }
                updateRegistration(8, viewModelCarInfoSeatBeltpValue);
                if (viewModelCarInfoSeatBeltpValue != null) {
                    viewModelCarInfoSeatBeltpValueGet = viewModelCarInfoSeatBeltpValue.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet = ViewDataBinding.safeUnbox(viewModelCarInfoSeatBeltpValueGet);
                if ((dirtyFlags & 16640) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                }
                viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet ? 8 : 0;
            }
            if ((dirtyFlags & 16896) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoFlDoorState = viewModelCarInfo.flDoorState;
                } else {
                    viewModelCarInfoFlDoorState = null;
                }
                updateRegistration(9, viewModelCarInfoFlDoorState);
                if (viewModelCarInfoFlDoorState != null) {
                    viewModelCarInfoFlDoorStateGet = viewModelCarInfoFlDoorState.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoFlDoorStateGet);
                if ((dirtyFlags & 16896) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet) {
                        dirtyFlags |= 268435456;
                    } else {
                        dirtyFlags |= 134217728;
                    }
                }
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 17408) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSpeed = viewModelCarInfo.speed;
                } else {
                    viewModelCarInfoSpeed = null;
                }
                updateRegistration(10, viewModelCarInfoSpeed);
                if (viewModelCarInfoSpeed != null) {
                    viewModelCarInfoSpeedGet = viewModelCarInfoSpeed.get();
                }
                stringValueOfViewModelCarInfoSpeed2 = String.valueOf(viewModelCarInfoSpeedGet);
            }
            if ((dirtyFlags & 18432) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoBDoorState2 = viewModelCarInfo.bDoorState;
                } else {
                    viewModelCarInfoBDoorState2 = viewModelCarInfoBDoorState;
                }
                updateRegistration(11, viewModelCarInfoBDoorState2);
                if (viewModelCarInfoBDoorState2 != null) {
                    viewModelCarInfoBDoorStateGet = viewModelCarInfoBDoorState2.get();
                }
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2 = ViewDataBinding.safeUnbox(viewModelCarInfoBDoorStateGet);
                if ((dirtyFlags & 18432) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    }
                }
                viewModelCarInfoBDoorStateViewVISIBLEViewINVISIBLE = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2 ? 0 : 4;
            } else {
                viewModelCarInfoBDoorState2 = viewModelCarInfoBDoorState;
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet;
            }
            if ((dirtyFlags & 20480) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoBDoorState3 = viewModelCarInfoBDoorState2;
                    viewModelCarInfoBDoorState4 = viewModelCarInfo.brakeValue;
                } else {
                    viewModelCarInfoBDoorState3 = viewModelCarInfoBDoorState2;
                    viewModelCarInfoBDoorState4 = null;
                }
                updateRegistration(12, viewModelCarInfoBDoorState4);
                if (viewModelCarInfoBDoorState4 != null) {
                    viewModelCarInfoBrakeValueGet = viewModelCarInfoBDoorState4.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet = ViewDataBinding.safeUnbox(viewModelCarInfoBrakeValueGet);
                if ((dirtyFlags & 20480) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet) {
                        dirtyFlags |= 16777216;
                    } else {
                        dirtyFlags |= 8388608;
                    }
                }
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2;
                stringValueOfViewModelCarInfoSpeed = stringValueOfViewModelCarInfoSpeed2;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = viewModelCarInfoTurnSpeedGet;
                viewModelCarInfoBrakeValueViewVISIBLEViewGONE = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet ? 0 : 8;
                viewModelCarInfoTempStrGet = viewModelCarInfoTempStrGet4;
                viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
                stringValueOfViewModelCarInfoTurnSpeed = stringValueOfViewModelCarInfoTurnSpeed2;
            } else {
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2;
                stringValueOfViewModelCarInfoSpeed = stringValueOfViewModelCarInfoSpeed2;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = viewModelCarInfoTurnSpeedGet;
                viewModelCarInfoBrakeValueViewVISIBLEViewGONE = 0;
                viewModelCarInfoTempStrGet = viewModelCarInfoTempStrGet4;
                viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
                stringValueOfViewModelCarInfoTurnSpeed = stringValueOfViewModelCarInfoTurnSpeed2;
            }
        } else {
            viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = 0;
            stringValueOfViewModelCarInfoSpeed = null;
            viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = 0;
            viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = 0;
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE = 0;
            viewModelCarInfoTempStrGet = null;
            viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = 0;
            viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = 0;
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = 0;
            stringValueOfViewModelCarInfoTurnSpeed = null;
        }
        if ((dirtyFlags & 24584) != 0) {
            if (viewModel != null) {
                viewModelCarInfoTempStrGet2 = viewModelCarInfoTempStrGet;
                viewModelShowAls = viewModel.showAls;
            } else {
                viewModelCarInfoTempStrGet2 = viewModelCarInfoTempStrGet;
                viewModelShowAls = null;
            }
            updateRegistration(3, viewModelShowAls);
            if (viewModelShowAls != null) {
                viewModelShowAlsGet = viewModelShowAls.get();
            }
            if ((dirtyFlags & 24584) != 0) {
                if (viewModelShowAlsGet) {
                    dirtyFlags |= 4194304;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                }
            }
            viewModelShowAlsViewVISIBLEViewGONE = viewModelShowAlsGet ? 0 : 8;
        } else {
            viewModelCarInfoTempStrGet2 = viewModelCarInfoTempStrGet;
            viewModelShowAlsViewVISIBLEViewGONE = 0;
        }
        if ((dirtyFlags & 20480) != 0) {
            this.brakeTextView.setVisibility(viewModelCarInfoBrakeValueViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 16386) != 0) {
            this.carImageView.setVisibility(viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2);
        }
        if ((dirtyFlags & 18432) != 0) {
            this.dorrBackImageView.setVisibility(viewModelCarInfoBDoorStateViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 16896) != 0) {
            this.dorrLeftFlImageView.setVisibility(viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 16388) != 0) {
            this.dorrLeftFrImageView.setVisibility(viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 16416) != 0) {
            this.dorrLeftRlImageView.setVisibility(viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 16448) != 0) {
            this.imageView19.setVisibility(viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 24584) != 0) {
            this.leftModeRl.setVisibility(viewModelShowAlsViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 16640) != 0) {
            this.seatBeltTextView.setVisibility(viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 16400) != 0) {
            this.speedPointerImageView.setImageLevel(viewModelCarInfoSpeedWatchGet);
            this.speedometerImageView.setImageLevel(viewModelCarInfoSpeedWatchGet);
        }
        if ((dirtyFlags & 17408) != 0) {
            DashboardViewModel.setAudiMib3SeepRotation(this.speedPointerImageView, viewModelCarInfoSpeedGet);
            TextViewBindingAdapter.setText(this.speedPointerTextView, stringValueOfViewModelCarInfoSpeed);
        }
        if ((dirtyFlags & 16512) != 0) {
            viewModelCarInfoTempStrGet3 = viewModelCarInfoTempStrGet2;
            TextViewBindingAdapter.setText(this.temperatureTextView, viewModelCarInfoTempStrGet3);
        } else {
            viewModelCarInfoTempStrGet3 = viewModelCarInfoTempStrGet2;
        }
        if ((dirtyFlags & 16385) != 0) {
            DashboardViewModel.setAudiMib3TurnSpeedRotation(this.zspeedPointerImageView, viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE);
            TextViewBindingAdapter.setText(this.zspeedPointerTextView, stringValueOfViewModelCarInfoTurnSpeed);
        }
    }
}
