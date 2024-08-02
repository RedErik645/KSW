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

public class AudiTempBindingImpl extends AudiTempBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final RadioButton mboundView1;
    private final RadioButton mboundView2;

    public AudiTempBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private AudiTempBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RadioGroup) bindings[0]);
        this.mDirtyFlags = -1;
        RadioButton radioButton = (RadioButton) bindings[1];
        this.mboundView1 = radioButton;
        radioButton.setTag(null);
        RadioButton radioButton2 = (RadioButton) bindings[2];
        this.mboundView2 = radioButton2;
        radioButton2.setTag(null);
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

    @Override // com.wits.ksw.databinding.AudiTempBinding
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
                return onChangeVmTempUnit((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmTempUnit(ObservableInt VmTempUnit, int fieldId) {
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
        boolean vmTempUnitInt0 = false;
        boolean vmTempUnitInt1 = false;
        AudiSystemViewModel vm = this.mVm;
        RadioGroup.OnCheckedChangeListener vmOnTempUnitChangeListener = null;
        ObservableInt vmTempUnit = null;
        int vmTempUnitGet = 0;
        if ((dirtyFlags & 7) != 0) {
            if (!((dirtyFlags & 6) == 0 || vm == null)) {
                vmOnTempUnitChangeListener = vm.onTempUnitChangeListener;
            }
            if (vm != null) {
                vmTempUnit = vm.tempUnit;
            }
            updateRegistration(0, vmTempUnit);
            if (vmTempUnit != null) {
                vmTempUnitGet = vmTempUnit.get();
            }
            boolean z = true;
            vmTempUnitInt0 = vmTempUnitGet == 0;
            if (vmTempUnitGet != 1) {
                z = false;
            }
            vmTempUnitInt1 = z;
        }
        if ((7 & dirtyFlags) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.mboundView1, vmTempUnitInt0);
            CompoundButtonBindingAdapter.setChecked(this.mboundView2, vmTempUnitInt1);
        }
        if ((dirtyFlags & 6) != 0) {
            this.timeRadioGroup.setOnCheckedChangeListener(vmOnTempUnitChangeListener);
        }
    }
}
