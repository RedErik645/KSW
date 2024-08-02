package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ID6FragmentThreeSw600dpLandImpl extends ID6FragmentThree {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.id6_file_iamge_view, 3);
        sparseIntArray.put(R.id.id6_video_mess, 4);
        sparseIntArray.put(R.id.id6_dvr_image_view, 5);
        sparseIntArray.put(R.id.id6_dvr_mess, 6);
        sparseIntArray.put(R.id.id6_dashboard_image_view, 7);
    }

    public ID6FragmentThreeSw600dpLandImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private ID6FragmentThreeSw600dpLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (ImageView) bindings[7], (ImageView) bindings[5], (TextView) bindings[6], (ImageView) bindings[3], (TextView) bindings[1], (TextView) bindings[2], (TextView) bindings[4]);
        this.mDirtyFlags = -1;
        this.id6OilMess.setTag(null);
        this.id6SpeedMess.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        setViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ID6FragmentThree
    public void setViewModel(LauncherViewModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelCarInfoOilValue((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelCarInfoSpeed((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelCarInfoOilValue(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSpeed(ObservableInt ViewModelCarInfoSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<String> viewModelCarInfoOilValue = null;
        int viewModelCarInfoSpeedGet = 0;
        ObservableInt viewModelCarInfoSpeed = null;
        String viewModelCarInfoSpeedJavaLangStringKmH = null;
        String viewModelCarInfoOilValueGet = null;
        if ((11 & dirtyFlags) != 0) {
            CarInfo viewModelCarInfo = LauncherViewModel.carInfo;
            if ((dirtyFlags & 9) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoOilValue = viewModelCarInfo.oilValue;
                }
                updateRegistration(0, viewModelCarInfoOilValue);
                if (viewModelCarInfoOilValue != null) {
                    viewModelCarInfoOilValueGet = viewModelCarInfoOilValue.get();
                }
            }
            if ((dirtyFlags & 10) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSpeed = viewModelCarInfo.speed;
                }
                updateRegistration(1, viewModelCarInfoSpeed);
                if (viewModelCarInfoSpeed != null) {
                    viewModelCarInfoSpeedGet = viewModelCarInfoSpeed.get();
                }
                viewModelCarInfoSpeedJavaLangStringKmH = viewModelCarInfoSpeedGet + "km/h";
            }
        }
        if ((dirtyFlags & 9) != 0) {
            TextViewBindingAdapter.setText(this.id6OilMess, viewModelCarInfoOilValueGet);
        }
        if ((10 & dirtyFlags) != 0) {
            TextViewBindingAdapter.setText(this.id6SpeedMess, viewModelCarInfoSpeedJavaLangStringKmH);
        }
    }
}
