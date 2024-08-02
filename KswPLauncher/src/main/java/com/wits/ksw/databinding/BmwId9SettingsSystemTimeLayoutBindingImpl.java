package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class BmwId9SettingsSystemTimeLayoutBindingImpl extends BmwId9SettingsSystemTimeLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id9_settings_system_time_lay, 2);
        sparseIntArray.put(R.id.time_system_title, 3);
        sparseIntArray.put(R.id.bmw_id9_settings_time_sync, 4);
        sparseIntArray.put(R.id.bmw_id9_settings_time_car, 5);
        sparseIntArray.put(R.id.bmw_id9_settings_time_android, 6);
        sparseIntArray.put(R.id.bmw_id9_settings_time_format, 7);
        sparseIntArray.put(R.id.bmw_id9_time_format_12, 8);
        sparseIntArray.put(R.id.bmw_id9_time_format_24, 9);
    }

    public BmwId9SettingsSystemTimeLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private BmwId9SettingsSystemTimeLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (LinearLayout) bindings[2], (RadioButton) bindings[6], (RadioButton) bindings[5], (RadioGroup) bindings[7], (RadioGroup) bindings[4], (RadioButton) bindings[8], (RadioButton) bindings[9], (TextView) bindings[3]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
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
        if (36 != variableId) {
            return false;
        }
        setViewModel((BmwId9SettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BmwId9SettingsSystemTimeLayoutBinding
    public void setViewModel(BmwId9SettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelSystemBgShow((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelSystemBgShow(ObservableBoolean ViewModelSystemBgShow, int fieldId) {
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
        ObservableBoolean viewModelSystemBgShow = null;
        boolean viewModelSystemBgShowGet = false;
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        int viewModelSystemBgShowViewGONEViewVISIBLE = 0;
        if ((dirtyFlags & 7) != 0) {
            if (viewModel != null) {
                viewModelSystemBgShow = viewModel.systemBgShow;
            }
            int i = 0;
            updateRegistration(0, viewModelSystemBgShow);
            if (viewModelSystemBgShow != null) {
                viewModelSystemBgShowGet = viewModelSystemBgShow.get();
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelSystemBgShowGet) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            if (viewModelSystemBgShowGet) {
                i = 8;
            }
            viewModelSystemBgShowViewGONEViewVISIBLE = i;
        }
        if ((7 & dirtyFlags) != 0) {
            this.mboundView1.setVisibility(viewModelSystemBgShowViewGONEViewVISIBLE);
        }
    }
}
