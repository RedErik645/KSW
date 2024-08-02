package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class ActivityBenzMbuxSettingsAudioLayoutBindingImpl extends ActivityBenzMbuxSettingsAudioLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_settings_audio_lay, 2);
        sparseIntArray.put(R.id.mbux_settings_audio_android_item, 3);
        sparseIntArray.put(R.id.mbux_settings_audio_oem_item, 4);
        sparseIntArray.put(R.id.mbux_settings_audio_sound_item, 5);
        sparseIntArray.put(R.id.mbux_settings_audio_framelay, 6);
    }

    public ActivityBenzMbuxSettingsAudioLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private ActivityBenzMbuxSettingsAudioLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RelativeLayout) bindings[3], (FrameLayout) bindings[6], (ImageView) bindings[1], (LinearLayout) bindings[2], (RelativeLayout) bindings[4], (RelativeLayout) bindings[5]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.mbuxSettingsAudioImg.setTag(null);
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
        setViewModel((BenzMbuxSettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityBenzMbuxSettingsAudioLayoutBinding
    public void setViewModel(BenzMbuxSettingsViewModel ViewModel) {
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
                return onChangeViewModelAudioIconShow((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelAudioIconShow(ObservableBoolean ViewModelAudioIconShow, int fieldId) {
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
        ObservableBoolean viewModelAudioIconShow = null;
        BenzMbuxSettingsViewModel viewModel = this.mViewModel;
        boolean viewModelAudioIconShowGet = false;
        int viewModelAudioIconShowViewVISIBLEViewGONE = 0;
        if ((dirtyFlags & 7) != 0) {
            if (viewModel != null) {
                viewModelAudioIconShow = viewModel.audioIconShow;
            }
            int i = 0;
            updateRegistration(0, viewModelAudioIconShow);
            if (viewModelAudioIconShow != null) {
                viewModelAudioIconShowGet = viewModelAudioIconShow.get();
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelAudioIconShowGet) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            if (!viewModelAudioIconShowGet) {
                i = 8;
            }
            viewModelAudioIconShowViewVISIBLEViewGONE = i;
        }
        if ((7 & dirtyFlags) != 0) {
            this.mbuxSettingsAudioImg.setVisibility(viewModelAudioIconShowViewVISIBLEViewGONE);
        }
    }
}
