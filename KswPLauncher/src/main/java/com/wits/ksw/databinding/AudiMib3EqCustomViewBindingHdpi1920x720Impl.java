package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.SeekBarBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.audi.widget.AudiConstraintLayout;
import com.wits.ksw.settings.audi.widget.EqSeekBar;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3EQViewModel;

public class AudiMib3EqCustomViewBindingHdpi1920x720Impl extends AudiMib3EqCustomViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 7);
        sparseIntArray.put(R.id.title_divider, 8);
        sparseIntArray.put(R.id.linearLayout4, 9);
        sparseIntArray.put(R.id.hzMediaLinearLayout, 10);
        sparseIntArray.put(R.id.eq_text7_tv, 11);
        sparseIntArray.put(R.id.eq_text7_iv, 12);
        sparseIntArray.put(R.id.linearLayout5, 13);
        sparseIntArray.put(R.id.eq_text8_tv, 14);
        sparseIntArray.put(R.id.eq_text8_iv, 15);
        sparseIntArray.put(R.id.linearLayout6, 16);
        sparseIntArray.put(R.id.eq_text9_tv, 17);
        sparseIntArray.put(R.id.eq_text9_iv, 18);
        sparseIntArray.put(R.id.v_divider, 19);
    }

    public AudiMib3EqCustomViewBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }

    private AudiMib3EqCustomViewBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7, (EqSeekBar) bindings[1], (TextView) bindings[2], (ImageView) bindings[12], (TextView) bindings[11], (ImageView) bindings[15], (TextView) bindings[14], (ImageView) bindings[18], (TextView) bindings[17], (View) bindings[10], (AudiConstraintLayout) bindings[9], (View) bindings[13], (View) bindings[16], (EqSeekBar) bindings[3], (TextView) bindings[4], (AppCompatTextView) bindings[7], (View) bindings[8], (EqSeekBar) bindings[5], (TextView) bindings[6], (View) bindings[19]);
        this.mDirtyFlags = -1;
        this.bassSeekBar.setTag(null);
        this.bassTv.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.mezzoSeekBar.setTag(null);
        this.mezzoTv.setTag(null);
        this.trebleSeekBar.setTag(null);
        this.trebleTv.setTag(null);
        setRootTag(root);
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
        if (37 != variableId) {
            return false;
        }
        setVm((AudiMib3EQViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AudiMib3EqCustomViewBinding
    public void setVm(AudiMib3EQViewModel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmMezzoStr((ObservableField) object, fieldId);
            case 1:
                return onChangeVmBassStr((ObservableField) object, fieldId);
            case 2:
                return onChangeVmTrebleStr((ObservableField) object, fieldId);
            case 3:
                return onChangeVmBassProgress((ObservableInt) object, fieldId);
            case 4:
                return onChangeVmMezzoProgress((ObservableInt) object, fieldId);
            case 5:
                return onChangeVmTrebleProgress((ObservableInt) object, fieldId);
            case 6:
                return onChangeVmEqModel((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmMezzoStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmBassStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmTrebleStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmBassProgress(ObservableInt VmBassProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmMezzoProgress(ObservableInt VmMezzoProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmTrebleProgress(ObservableInt VmTrebleProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmEqModel(ObservableInt VmEqModel, int fieldId) {
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
        String vmTrebleStrGet;
        String vmMezzoStrGet;
        boolean vmEqModelInt0;
        ObservableInt vmEqModel;
        ObservableInt vmTrebleProgress;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<String> vmMezzoStr = null;
        ObservableField<String> vmBassStr = null;
        AudiMib3EQViewModel vm = this.mVm;
        int vmMezzoProgressGet = 0;
        int vmTrebleProgressGet = 0;
        ObservableField<String> vmTrebleStr = null;
        int vmBassProgressGet = 0;
        ObservableInt vmBassProgress = null;
        int vmEqModelGet = 0;
        ObservableInt vmMezzoProgress = null;
        String vmBassStrGet = null;
        String vmMezzoStrGet2 = null;
        String vmTrebleStrGet2 = null;
        if ((dirtyFlags & 511) != 0) {
            if ((dirtyFlags & 385) != 0) {
                if (vm != null) {
                    vmMezzoStr = vm.mezzoStr;
                }
                updateRegistration(0, vmMezzoStr);
                if (vmMezzoStr != null) {
                    vmMezzoStrGet2 = vmMezzoStr.get();
                }
            }
            if ((dirtyFlags & 386) != 0) {
                if (vm != null) {
                    vmBassStr = vm.bassStr;
                }
                updateRegistration(1, vmBassStr);
                if (vmBassStr != null) {
                    vmBassStrGet = vmBassStr.get();
                }
            }
            if ((dirtyFlags & 388) != 0) {
                if (vm != null) {
                    vmTrebleStr = vm.trebleStr;
                }
                updateRegistration(2, vmTrebleStr);
                if (vmTrebleStr != null) {
                    vmTrebleStrGet2 = vmTrebleStr.get();
                }
            }
            if ((dirtyFlags & 392) != 0) {
                if (vm != null) {
                    vmBassProgress = vm.bassProgress;
                }
                updateRegistration(3, vmBassProgress);
                if (vmBassProgress != null) {
                    vmBassProgressGet = vmBassProgress.get();
                }
            }
            if ((dirtyFlags & 400) != 0) {
                if (vm != null) {
                    vmMezzoProgress = vm.mezzoProgress;
                }
                updateRegistration(4, vmMezzoProgress);
                if (vmMezzoProgress != null) {
                    vmMezzoProgressGet = vmMezzoProgress.get();
                }
            }
            if ((dirtyFlags & 416) != 0) {
                if (vm != null) {
                    vmTrebleProgress = vm.trebleProgress;
                } else {
                    vmTrebleProgress = null;
                }
                updateRegistration(5, vmTrebleProgress);
                if (vmTrebleProgress != null) {
                    vmTrebleProgressGet = vmTrebleProgress.get();
                }
            }
            if ((dirtyFlags & 448) != 0) {
                if (vm != null) {
                    vmEqModel = vm.eqModel;
                } else {
                    vmEqModel = null;
                }
                updateRegistration(6, vmEqModel);
                if (vmEqModel != null) {
                    vmEqModelGet = vmEqModel.get();
                }
                vmMezzoStrGet = vmMezzoStrGet2;
                vmTrebleStrGet = vmTrebleStrGet2;
                vmEqModelInt0 = vmEqModelGet == 0;
            } else {
                vmMezzoStrGet = vmMezzoStrGet2;
                vmTrebleStrGet = vmTrebleStrGet2;
                vmEqModelInt0 = false;
            }
        } else {
            vmMezzoStrGet = null;
            vmTrebleStrGet = null;
            vmEqModelInt0 = false;
        }
        if ((dirtyFlags & 392) != 0) {
            SeekBarBindingAdapter.setProgress(this.bassSeekBar, vmBassProgressGet);
        }
        if ((dirtyFlags & 448) != 0) {
            this.bassSeekBar.setEnabled(vmEqModelInt0);
            this.mezzoSeekBar.setEnabled(vmEqModelInt0);
            this.trebleSeekBar.setEnabled(vmEqModelInt0);
        }
        if ((dirtyFlags & 384) != 0) {
            AudiMib3EQViewModel.setBassSeekBarChangeListener(this.bassSeekBar, vm);
            AudiMib3EQViewModel.setmezzoSeekBarChangeListener(this.mezzoSeekBar, vm);
            AudiMib3EQViewModel.setTrebleSeekBarChangeListener(this.trebleSeekBar, vm);
        }
        if ((dirtyFlags & 386) != 0) {
            TextViewBindingAdapter.setText(this.bassTv, vmBassStrGet);
        }
        if ((dirtyFlags & 400) != 0) {
            SeekBarBindingAdapter.setProgress(this.mezzoSeekBar, vmMezzoProgressGet);
        }
        if ((dirtyFlags & 385) != 0) {
            TextViewBindingAdapter.setText(this.mezzoTv, vmMezzoStrGet);
        }
        if ((dirtyFlags & 416) != 0) {
            SeekBarBindingAdapter.setProgress(this.trebleSeekBar, vmTrebleProgressGet);
        }
        if ((dirtyFlags & 388) != 0) {
            TextViewBindingAdapter.setText(this.trebleTv, vmTrebleStrGet);
        }
    }
}
