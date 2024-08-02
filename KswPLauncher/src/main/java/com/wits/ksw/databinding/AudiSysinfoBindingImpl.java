package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.settings.audi.vm.AudiSettingViewModel;
import com.wits.ksw.settings.audi.widget.AudiConstraintLayout;

public class AudiSysinfoBindingImpl extends AudiSysinfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.audiSysInfParentPanel, 6);
        sparseIntArray.put(R.id.audiSysInfoCpu, 7);
        sparseIntArray.put(R.id.audioSysInfoMcuUpdata, 8);
        sparseIntArray.put(R.id.audioSysInfoRestoreFactory, 9);
        sparseIntArray.put(R.id.audioSysInfoUpDateFactory, 10);
    }

    public AudiSysinfoBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private AudiSysinfoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (AudiConstraintLayout) bindings[6], (TextView) bindings[2], (MarqueeTextView) bindings[7], (TextView) bindings[1], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[8], (TextView) bindings[5], (TextView) bindings[9], (TextView) bindings[10]);
        this.mDirtyFlags = -1;
        this.audiSysInfoAppVer.setTag(null);
        this.audiSysInfoMcuVer.setTag(null);
        this.audiSysInfoSysVer.setTag(null);
        this.audioSysInfoFlash.setTag(null);
        this.audioSysInfoRam.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
        if (37 != variableId) {
            return false;
        }
        setVm((AudiSettingViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AudiSysinfoBinding
    public void setVm(AudiSettingViewModel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmAppVer((ObservableField) object, fieldId);
            case 1:
                return onChangeVmNandflash((ObservableField) object, fieldId);
            case 2:
                return onChangeVmMcuVer((ObservableField) object, fieldId);
            case 3:
                return onChangeVmSystemVersion((ObservableField) object, fieldId);
            case 4:
                return onChangeVmRamVer((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmAppVer(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmNandflash(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmMcuVer(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmSystemVersion(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmRamVer(ObservableField<String> observableField, int fieldId) {
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
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<String> vmAppVer = null;
        ObservableField<String> vmNandflash = null;
        String vmSystemVersionGet = null;
        String vmNandflashGet = null;
        ObservableField<String> vmMcuVer = null;
        ObservableField<String> vmSystemVersion = null;
        AudiSettingViewModel vm = this.mVm;
        ObservableField<String> vmRamVer = null;
        String vmMcuVerGet = null;
        String vmRamVerGet = null;
        String vmAppVerGet = null;
        if ((dirtyFlags & 127) != 0) {
            if ((dirtyFlags & 97) != 0) {
                if (vm != null) {
                    vmAppVer = vm.appVer;
                }
                updateRegistration(0, vmAppVer);
                if (vmAppVer != null) {
                    vmAppVerGet = vmAppVer.get();
                }
            }
            if ((dirtyFlags & 98) != 0) {
                if (vm != null) {
                    vmNandflash = vm.nandflash;
                }
                updateRegistration(1, vmNandflash);
                if (vmNandflash != null) {
                    vmNandflashGet = vmNandflash.get();
                }
            }
            if ((dirtyFlags & 100) != 0) {
                if (vm != null) {
                    vmMcuVer = vm.mcuVer;
                }
                updateRegistration(2, vmMcuVer);
                if (vmMcuVer != null) {
                    vmMcuVerGet = vmMcuVer.get();
                }
            }
            if ((dirtyFlags & 104) != 0) {
                if (vm != null) {
                    vmSystemVersion = vm.systemVersion;
                }
                updateRegistration(3, vmSystemVersion);
                if (vmSystemVersion != null) {
                    vmSystemVersionGet = vmSystemVersion.get();
                }
            }
            if ((dirtyFlags & 112) != 0) {
                if (vm != null) {
                    vmRamVer = vm.ramVer;
                }
                updateRegistration(4, vmRamVer);
                if (vmRamVer != null) {
                    vmRamVerGet = vmRamVer.get();
                }
            }
        }
        if ((dirtyFlags & 97) != 0) {
            TextViewBindingAdapter.setText(this.audiSysInfoAppVer, vmAppVerGet);
        }
        if ((dirtyFlags & 100) != 0) {
            TextViewBindingAdapter.setText(this.audiSysInfoMcuVer, vmMcuVerGet);
        }
        if ((dirtyFlags & 104) != 0) {
            TextViewBindingAdapter.setText(this.audiSysInfoSysVer, vmSystemVersionGet);
        }
        if ((dirtyFlags & 98) != 0) {
            TextViewBindingAdapter.setText(this.audioSysInfoFlash, vmNandflashGet);
        }
        if ((dirtyFlags & 112) != 0) {
            TextViewBindingAdapter.setText(this.audioSysInfoRam, vmRamVerGet);
        }
    }
}
