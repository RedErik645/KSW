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
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class ActivityBmwId9SettingsInfoLayoutBindingImpl extends ActivityBmwId9SettingsInfoLayoutBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback579;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final MarqueeTextView mboundView2;
    private final MarqueeTextView mboundView3;
    private final MarqueeTextView mboundView4;
    private final MarqueeTextView mboundView5;
    private final MarqueeTextView mboundView6;
    private final MarqueeTextView mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id9_settings_info_lay, 8);
        sparseIntArray.put(R.id.bmw_id9_info_mcu_ver, 9);
        sparseIntArray.put(R.id.bmw_id9_info_system_version, 10);
        sparseIntArray.put(R.id.bmw_id9_info_cpu, 11);
        sparseIntArray.put(R.id.bmw_id9_info_mcu_upgrade, 12);
        sparseIntArray.put(R.id.bmw_id9_info_system_recovery, 13);
        sparseIntArray.put(R.id.bmw_id9_info_system_update, 14);
    }

    public ActivityBmwId9SettingsInfoLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private ActivityBmwId9SettingsInfoLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (ImageView) bindings[1], (RelativeLayout) bindings[11], (RelativeLayout) bindings[12], (RelativeLayout) bindings[9], (RelativeLayout) bindings[13], (RelativeLayout) bindings[14], (RelativeLayout) bindings[10], (ScrollView) bindings[8]);
        this.mDirtyFlags = -1;
        this.bmwId8SettingsHomeback.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        MarqueeTextView marqueeTextView = (MarqueeTextView) bindings[2];
        this.mboundView2 = marqueeTextView;
        marqueeTextView.setTag(null);
        MarqueeTextView marqueeTextView2 = (MarqueeTextView) bindings[3];
        this.mboundView3 = marqueeTextView2;
        marqueeTextView2.setTag(null);
        MarqueeTextView marqueeTextView3 = (MarqueeTextView) bindings[4];
        this.mboundView4 = marqueeTextView3;
        marqueeTextView3.setTag(null);
        MarqueeTextView marqueeTextView4 = (MarqueeTextView) bindings[5];
        this.mboundView5 = marqueeTextView4;
        marqueeTextView4.setTag(null);
        MarqueeTextView marqueeTextView5 = (MarqueeTextView) bindings[6];
        this.mboundView6 = marqueeTextView5;
        marqueeTextView5.setTag(null);
        MarqueeTextView marqueeTextView6 = (MarqueeTextView) bindings[7];
        this.mboundView7 = marqueeTextView6;
        marqueeTextView6.setTag(null);
        setRootTag(root);
        this.mCallback579 = new OnClickListener(this, 1);
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
        setViewModel((BmwId9SettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityBmwId9SettingsInfoLayoutBinding
    public void setViewModel(BmwId9SettingsViewModel ViewModel) {
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
        BmwId9SettingsViewModel viewModel = this.mViewModel;
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
        if ((dirtyFlags & 128) != 0) {
            this.bmwId8SettingsHomeback.setOnClickListener(this.mCallback579);
        }
        if ((dirtyFlags & 196) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, viewModelMcuVersionStrGet);
        }
        if ((dirtyFlags & 193) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, viewModelAppVersionStrGet);
        }
        if ((dirtyFlags & 224) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, viewModelSystemVersionStrGet);
        }
        if ((dirtyFlags & 194) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, viewModelCpuInfoStrGet);
        }
        if ((dirtyFlags & 208) != 0) {
            TextViewBindingAdapter.setText(this.mboundView6, viewModelStorageStrGet);
        }
        if ((dirtyFlags & 200) != 0) {
            TextViewBindingAdapter.setText(this.mboundView7, viewModelRamStrGet);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        if (viewModel != null) {
            viewModel.backClick();
        }
    }
}
