package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.settings.bmw_id8.vm.BmwId8SettingsViewModel;

public class BmwId8SettingsInfoLayoutBindingImpl extends BmwId8SettingsInfoLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id8_settings_info_back, 7);
        sparseIntArray.put(R.id.bmw_id8_settings_info_lay, 8);
        sparseIntArray.put(R.id.bmw_id8_info_mcu_ver, 9);
        sparseIntArray.put(R.id.bmw_id8_info_system_version, 10);
        sparseIntArray.put(R.id.bmw_id8_info_cpu, 11);
        sparseIntArray.put(R.id.bmw_id8_info_mcu_upgrade, 12);
        sparseIntArray.put(R.id.bmw_id8_info_system_recovery, 13);
        sparseIntArray.put(R.id.bmw_id8_info_system_update, 14);
    }

    public BmwId8SettingsInfoLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private BmwId8SettingsInfoLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (MarqueeTextView) bindings[2], (RelativeLayout) bindings[11], (MarqueeTextView) bindings[4], (RelativeLayout) bindings[12], (RelativeLayout) bindings[9], (MarqueeTextView) bindings[1], (MarqueeTextView) bindings[6], (MarqueeTextView) bindings[5], (MarqueeTextView) bindings[3], (RelativeLayout) bindings[13], (RelativeLayout) bindings[14], (RelativeLayout) bindings[10], (ImageView) bindings[7], (ScrollView) bindings[8]);
        this.mDirtyFlags = -1;
        this.bmwId8InfoAppVersionContent.setTag(null);
        this.bmwId8InfoCpuContent.setTag(null);
        this.bmwId8InfoMcuVersionContent.setTag(null);
        this.bmwId8InfoRamContent.setTag(null);
        this.bmwId8InfoStorageContent.setTag(null);
        this.bmwId8InfoSysVersionContent.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        setViewModel((BmwId8SettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BmwId8SettingsInfoLayoutBinding
    public void setViewModel(BmwId8SettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelAppVersionStr((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelCpuInfoStr((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelRamStr((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelMcuVersionStr((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelStorageStr((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelSystemVersionStr((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelAppVersionStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelCpuInfoStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelRamStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelMcuVersionStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelStorageStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelSystemVersionStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        String viewModelRamStrGet;
        String viewModelCpuInfoStrGet;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<String> viewModelAppVersionStr = null;
        ObservableField<String> viewModelCpuInfoStr = null;
        ObservableField<String> viewModelRamStr = null;
        String viewModelStorageStrGet = null;
        String viewModelAppVersionStrGet = null;
        String viewModelSystemVersionStrGet = null;
        ObservableField<String> viewModelMcuVersionStr = null;
        ObservableField<String> viewModelStorageStr = null;
        String viewModelMcuVersionStrGet = null;
        ObservableField<String> viewModelSystemVersionStr = null;
        BmwId8SettingsViewModel viewModel = this.mViewModel;
        String viewModelCpuInfoStrGet2 = null;
        String viewModelRamStrGet2 = null;
        if ((dirtyFlags & 255) != 0) {
            if ((dirtyFlags & 193) != 0) {
                if (viewModel != null) {
                    viewModelAppVersionStr = viewModel.appVersionStr;
                }
                updateRegistration(0, viewModelAppVersionStr);
                if (viewModelAppVersionStr != null) {
                    viewModelAppVersionStrGet = viewModelAppVersionStr.get();
                }
            }
            if ((dirtyFlags & 194) != 0) {
                if (viewModel != null) {
                    viewModelCpuInfoStr = viewModel.cpuInfoStr;
                }
                updateRegistration(1, viewModelCpuInfoStr);
                if (viewModelCpuInfoStr != null) {
                    viewModelCpuInfoStrGet2 = viewModelCpuInfoStr.get();
                }
            }
            if ((dirtyFlags & 196) != 0) {
                if (viewModel != null) {
                    viewModelRamStr = viewModel.ramStr;
                }
                updateRegistration(2, viewModelRamStr);
                if (viewModelRamStr != null) {
                    viewModelRamStrGet2 = viewModelRamStr.get();
                }
            }
            if ((dirtyFlags & 200) != 0) {
                if (viewModel != null) {
                    viewModelMcuVersionStr = viewModel.mcuVersionStr;
                }
                updateRegistration(3, viewModelMcuVersionStr);
                if (viewModelMcuVersionStr != null) {
                    viewModelMcuVersionStrGet = viewModelMcuVersionStr.get();
                }
            }
            if ((dirtyFlags & 208) != 0) {
                if (viewModel != null) {
                    viewModelStorageStr = viewModel.storageStr;
                }
                updateRegistration(4, viewModelStorageStr);
                if (viewModelStorageStr != null) {
                    viewModelStorageStrGet = viewModelStorageStr.get();
                }
            }
            if ((dirtyFlags & 224) != 0) {
                if (viewModel != null) {
                    viewModelSystemVersionStr = viewModel.systemVersionStr;
                }
                updateRegistration(5, viewModelSystemVersionStr);
                if (viewModelSystemVersionStr != null) {
                    viewModelSystemVersionStrGet = viewModelSystemVersionStr.get();
                    viewModelCpuInfoStrGet = viewModelCpuInfoStrGet2;
                    viewModelRamStrGet = viewModelRamStrGet2;
                } else {
                    viewModelCpuInfoStrGet = viewModelCpuInfoStrGet2;
                    viewModelRamStrGet = viewModelRamStrGet2;
                }
            } else {
                viewModelCpuInfoStrGet = viewModelCpuInfoStrGet2;
                viewModelRamStrGet = viewModelRamStrGet2;
            }
        } else {
            viewModelCpuInfoStrGet = null;
            viewModelRamStrGet = null;
        }
        if ((dirtyFlags & 193) != 0) {
            TextViewBindingAdapter.setText(this.bmwId8InfoAppVersionContent, viewModelAppVersionStrGet);
        }
        if ((dirtyFlags & 194) != 0) {
            TextViewBindingAdapter.setText(this.bmwId8InfoCpuContent, viewModelCpuInfoStrGet);
        }
        if ((dirtyFlags & 200) != 0) {
            TextViewBindingAdapter.setText(this.bmwId8InfoMcuVersionContent, viewModelMcuVersionStrGet);
        }
        if ((dirtyFlags & 196) != 0) {
            TextViewBindingAdapter.setText(this.bmwId8InfoRamContent, viewModelRamStrGet);
        }
        if ((dirtyFlags & 208) != 0) {
            TextViewBindingAdapter.setText(this.bmwId8InfoStorageContent, viewModelStorageStrGet);
        }
        if ((dirtyFlags & 224) != 0) {
            TextViewBindingAdapter.setText(this.bmwId8InfoSysVersionContent, viewModelSystemVersionStrGet);
        }
    }
}
