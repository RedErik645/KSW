package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class ActivityBenzMbuxSettingsInfoLayoutBindingImpl extends ActivityBenzMbuxSettingsInfoLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final MarqueeTextView mboundView1;
    private final MarqueeTextView mboundView2;
    private final MarqueeTextView mboundView3;
    private final MarqueeTextView mboundView4;
    private final MarqueeTextView mboundView5;
    private final MarqueeTextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_settings_info_lay, 7);
        sparseIntArray.put(R.id.mbux_info_mcu_ver, 8);
        sparseIntArray.put(R.id.mbux_info_system_version, 9);
        sparseIntArray.put(R.id.mbux_info_cpu, 10);
        sparseIntArray.put(R.id.mbux_info_mcu_upgrade, 11);
        sparseIntArray.put(R.id.mbux_info_system_recovery, 12);
        sparseIntArray.put(R.id.mbux_info_system_update, 13);
    }

    public ActivityBenzMbuxSettingsInfoLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private ActivityBenzMbuxSettingsInfoLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (RelativeLayout) bindings[10], (RelativeLayout) bindings[11], (RelativeLayout) bindings[8], (RelativeLayout) bindings[12], (RelativeLayout) bindings[13], (RelativeLayout) bindings[9], (ScrollView) bindings[7]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        MarqueeTextView marqueeTextView = (MarqueeTextView) bindings[1];
        this.mboundView1 = marqueeTextView;
        marqueeTextView.setTag(null);
        MarqueeTextView marqueeTextView2 = (MarqueeTextView) bindings[2];
        this.mboundView2 = marqueeTextView2;
        marqueeTextView2.setTag(null);
        MarqueeTextView marqueeTextView3 = (MarqueeTextView) bindings[3];
        this.mboundView3 = marqueeTextView3;
        marqueeTextView3.setTag(null);
        MarqueeTextView marqueeTextView4 = (MarqueeTextView) bindings[4];
        this.mboundView4 = marqueeTextView4;
        marqueeTextView4.setTag(null);
        MarqueeTextView marqueeTextView5 = (MarqueeTextView) bindings[5];
        this.mboundView5 = marqueeTextView5;
        marqueeTextView5.setTag(null);
        MarqueeTextView marqueeTextView6 = (MarqueeTextView) bindings[6];
        this.mboundView6 = marqueeTextView6;
        marqueeTextView6.setTag(null);
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
        setViewModel((BenzMbuxSettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityBenzMbuxSettingsInfoLayoutBinding
    public void setViewModel(BenzMbuxSettingsViewModel ViewModel) {
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
                return onChangeViewModelMcuVersionStr((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelRamStr((ObservableField) object, fieldId);
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

    private boolean onChangeViewModelMcuVersionStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelRamStr(ObservableField<String> observableField, int fieldId) {
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
        String viewModelAppVersionStrGet = null;
        ObservableField<String> viewModelAppVersionStr = null;
        ObservableField<String> viewModelCpuInfoStr = null;
        String viewModelSystemVersionStrGet = null;
        ObservableField<String> viewModelMcuVersionStr = null;
        ObservableField<String> viewModelRamStr = null;
        ObservableField<String> viewModelStorageStr = null;
        String viewModelMcuVersionStrGet = null;
        String viewModelStorageStrGet = null;
        ObservableField<String> viewModelSystemVersionStr = null;
        BenzMbuxSettingsViewModel viewModel = this.mViewModel;
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
                    viewModelMcuVersionStr = viewModel.mcuVersionStr;
                }
                updateRegistration(2, viewModelMcuVersionStr);
                if (viewModelMcuVersionStr != null) {
                    viewModelMcuVersionStrGet = viewModelMcuVersionStr.get();
                }
            }
            if ((dirtyFlags & 200) != 0) {
                if (viewModel != null) {
                    viewModelRamStr = viewModel.ramStr;
                }
                updateRegistration(3, viewModelRamStr);
                if (viewModelRamStr != null) {
                    viewModelRamStrGet2 = viewModelRamStr.get();
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
        if ((dirtyFlags & 196) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, viewModelMcuVersionStrGet);
        }
        if ((dirtyFlags & 193) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, viewModelAppVersionStrGet);
        }
        if ((dirtyFlags & 224) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, viewModelSystemVersionStrGet);
        }
        if ((dirtyFlags & 194) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, viewModelCpuInfoStrGet);
        }
        if ((dirtyFlags & 208) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, viewModelStorageStrGet);
        }
        if ((dirtyFlags & 200) != 0) {
            TextViewBindingAdapter.setText(this.mboundView6, viewModelRamStrGet);
        }
    }
}
