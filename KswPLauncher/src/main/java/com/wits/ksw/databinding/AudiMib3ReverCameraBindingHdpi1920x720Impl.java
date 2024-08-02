package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.CompoundButtonBindingAdapter;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3SystemViewModel;

public class AudiMib3ReverCameraBindingHdpi1920x720Impl extends AudiMib3ReverCameraBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 6);
        sparseIntArray.put(R.id.title_divider, 7);
        sparseIntArray.put(R.id.v_divider, 8);
    }

    public AudiMib3ReverCameraBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private AudiMib3ReverCameraBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RadioButton) bindings[2], (RadioButton) bindings[3], (RadioButton) bindings[4], (RadioButton) bindings[5], (RadioGroup) bindings[1], (AppCompatTextView) bindings[6], (View) bindings[7], (View) bindings[8]);
        this.mDirtyFlags = -1;
        this.RadioButton1.setTag("jz_camera");
        this.RadioButton2.setTag("car_camera");
        this.RadioButton3.setTag(null);
        this.RadioButton4.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.timeRadioGroup.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (37 != variableId) {
            return false;
        }
        setVm((AudiMib3SystemViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AudiMib3ReverCameraBinding
    public void setVm(AudiMib3SystemViewModel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmReverCamera((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmReverCamera(ObservableInt VmReverCamera, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
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
        RadioGroup.OnCheckedChangeListener vmOnReverCameraCheckedChangeListener = null;
        int vmReverCameraGet = 0;
        boolean vmReverCameraInt3 = false;
        boolean vmReverCameraInt2 = false;
        boolean vmReverCameraInt0 = false;
        boolean vmReverCameraInt1 = false;
        AudiMib3SystemViewModel vm = this.mVm;
        ObservableInt vmReverCamera = null;
        if ((dirtyFlags & 7) != 0) {
            if (!((dirtyFlags & 6) == 0 || vm == null)) {
                vmOnReverCameraCheckedChangeListener = vm.onReverCameraCheckedChangeListener;
            }
            if (vm != null) {
                vmReverCamera = vm.reverCamera;
            }
            updateRegistration(0, vmReverCamera);
            if (vmReverCamera != null) {
                vmReverCameraGet = vmReverCamera.get();
            }
            vmReverCameraInt3 = vmReverCameraGet == 3;
            vmReverCameraInt2 = vmReverCameraGet == 2;
            vmReverCameraInt0 = vmReverCameraGet == 0;
            vmReverCameraInt1 = vmReverCameraGet == 1;
        }
        if ((dirtyFlags & 7) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.RadioButton1, vmReverCameraInt0);
            CompoundButtonBindingAdapter.setChecked(this.RadioButton2, vmReverCameraInt1);
            CompoundButtonBindingAdapter.setChecked(this.RadioButton3, vmReverCameraInt2);
            CompoundButtonBindingAdapter.setChecked(this.RadioButton4, vmReverCameraInt3);
        }
        if ((dirtyFlags & 6) != 0) {
            this.timeRadioGroup.setOnCheckedChangeListener(vmOnReverCameraCheckedChangeListener);
        }
    }
}
