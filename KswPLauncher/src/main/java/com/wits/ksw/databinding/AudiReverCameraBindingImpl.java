package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.CompoundButtonBindingAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.wits.ksw.settings.audi.vm.AudiSystemViewModel;

public class AudiReverCameraBindingImpl extends AudiReverCameraBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public AudiReverCameraBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private AudiReverCameraBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RadioButton) bindings[1], (RadioButton) bindings[2], (RadioButton) bindings[3], (RadioButton) bindings[4], (RadioGroup) bindings[0]);
        this.mDirtyFlags = -1;
        this.RadioButton1.setTag("jz_camera");
        this.RadioButton2.setTag("car_camera");
        this.RadioButton3.setTag(null);
        this.RadioButton4.setTag(null);
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
        setVm((AudiSystemViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AudiReverCameraBinding
    public void setVm(AudiSystemViewModel Vm) {
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
        AudiSystemViewModel vm = this.mVm;
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
