package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.settings.audi.widget.AudiConstraintLayout;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3SettingViewModel;

public class AudiMib3SysinfoBindingImpl extends AudiMib3SysinfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 6);
        sparseIntArray.put(R.id.title_divider, 7);
        sparseIntArray.put(R.id.sv_sysinfo, 8);
        sparseIntArray.put(R.id.audiSysInfParentPanel, 9);
        sparseIntArray.put(R.id.audiSysInfoCpu, 10);
        sparseIntArray.put(R.id.audioSysInfoMcuUpdata, 11);
        sparseIntArray.put(R.id.audioSysInfoRestoreFactory, 12);
        sparseIntArray.put(R.id.audioSysInfoUpDateFactory, 13);
        sparseIntArray.put(R.id.v_divider, 14);
    }

    public AudiMib3SysinfoBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private AudiMib3SysinfoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (AudiConstraintLayout) bindings[9], (TextView) bindings[2], (MarqueeTextView) bindings[10], (TextView) bindings[1], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[11], (TextView) bindings[5], (TextView) bindings[12], (TextView) bindings[13], (ScrollView) bindings[8], (AppCompatTextView) bindings[6], (View) bindings[7], (View) bindings[14]);
        this.mDirtyFlags = -1;
        this.audiSysInfoAppVer.setTag(null);
        this.audiSysInfoMcuVer.setTag(null);
        this.audiSysInfoSysVer.setTag(null);
        this.audioSysInfoFlash.setTag(null);
        this.audioSysInfoRam.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
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
        setVm((AudiMib3SettingViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AudiMib3SysinfoBinding
    public void setVm(AudiMib3SettingViewModel Vm) {
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
                return onChangeVmSystemVersion((ObservableField) object, fieldId);
            case 3:
                return onChangeVmRamVer((ObservableField) object, fieldId);
            case 4:
                return onChangeVmMcuVer((ObservableField) object, fieldId);
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

    private boolean onChangeVmSystemVersion(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmRamVer(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmMcuVer(ObservableField<String> observableField, int fieldId) {
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
        ObservableField<String> vmSystemVersion = null;
        AudiMib3SettingViewModel vm = this.mVm;
        ObservableField<String> vmRamVer = null;
        String vmAppVerGet = null;
        String vmSystemVersionGet = null;
        String vmNandflashGet = null;
        ObservableField<String> vmMcuVer = null;
        String vmMcuVerGet = null;
        String vmRamVerGet = null;
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
                    vmSystemVersion = vm.systemVersion;
                }
                updateRegistration(2, vmSystemVersion);
                if (vmSystemVersion != null) {
                    vmSystemVersionGet = vmSystemVersion.get();
                }
            }
            if ((dirtyFlags & 104) != 0) {
                if (vm != null) {
                    vmRamVer = vm.ramVer;
                }
                updateRegistration(3, vmRamVer);
                if (vmRamVer != null) {
                    vmRamVerGet = vmRamVer.get();
                }
            }
            if ((dirtyFlags & 112) != 0) {
                if (vm != null) {
                    vmMcuVer = vm.mcuVer;
                }
                updateRegistration(4, vmMcuVer);
                if (vmMcuVer != null) {
                    vmMcuVerGet = vmMcuVer.get();
                }
            }
        }
        if ((dirtyFlags & 97) != 0) {
            TextViewBindingAdapter.setText(this.audiSysInfoAppVer, vmAppVerGet);
        }
        if ((dirtyFlags & 112) != 0) {
            TextViewBindingAdapter.setText(this.audiSysInfoMcuVer, vmMcuVerGet);
        }
        if ((dirtyFlags & 100) != 0) {
            TextViewBindingAdapter.setText(this.audiSysInfoSysVer, vmSystemVersionGet);
        }
        if ((dirtyFlags & 98) != 0) {
            TextViewBindingAdapter.setText(this.audioSysInfoFlash, vmNandflashGet);
        }
        if ((dirtyFlags & 104) != 0) {
            TextViewBindingAdapter.setText(this.audioSysInfoRam, vmRamVerGet);
        }
    }
}
