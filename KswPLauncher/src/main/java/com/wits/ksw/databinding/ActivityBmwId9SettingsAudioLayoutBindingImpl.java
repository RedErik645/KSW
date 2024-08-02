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
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class ActivityBmwId9SettingsAudioLayoutBindingImpl extends ActivityBmwId9SettingsAudioLayoutBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback265;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView2;
    private final ImageView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id9_settings_audio_lay, 4);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_android_item, 5);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_oem_item, 6);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_sound_item, 7);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_framelay, 8);
    }

    public ActivityBmwId9SettingsAudioLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private ActivityBmwId9SettingsAudioLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (ImageView) bindings[1], (RelativeLayout) bindings[5], (FrameLayout) bindings[8], (LinearLayout) bindings[4], (RelativeLayout) bindings[6], (RelativeLayout) bindings[7]);
        this.mDirtyFlags = -1;
        this.bmwId8SettingsHomeback.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[3];
        this.mboundView3 = imageView2;
        imageView2.setTag(null);
        setRootTag(root);
        this.mCallback265 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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

    @Override // com.wits.ksw.databinding.ActivityBmwId9SettingsAudioLayoutBinding
    public void setViewModel(BmwId9SettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelSystemIconShow((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeViewModelSystemBgShow((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelSystemIconShow(ObservableBoolean ViewModelSystemIconShow, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelSystemBgShow(ObservableBoolean ViewModelSystemBgShow, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
        ObservableBoolean viewModelSystemIconShow = null;
        ObservableBoolean viewModelSystemBgShow = null;
        boolean viewModelSystemBgShowGet = false;
        int viewModelSystemBgShowViewVISIBLEViewGONE = 0;
        boolean viewModelSystemIconShowGet = false;
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        int viewModelSystemIconShowViewVISIBLEViewGONE = 0;
        if ((15 & dirtyFlags) != 0) {
            int i = 8;
            if ((dirtyFlags & 13) != 0) {
                if (viewModel != null) {
                    viewModelSystemIconShow = viewModel.systemIconShow;
                }
                updateRegistration(0, viewModelSystemIconShow);
                if (viewModelSystemIconShow != null) {
                    viewModelSystemIconShowGet = viewModelSystemIconShow.get();
                }
                if ((dirtyFlags & 13) != 0) {
                    if (viewModelSystemIconShowGet) {
                        dirtyFlags |= 128;
                    } else {
                        dirtyFlags |= 64;
                    }
                }
                viewModelSystemIconShowViewVISIBLEViewGONE = viewModelSystemIconShowGet ? 0 : 8;
            }
            if ((dirtyFlags & 14) != 0) {
                if (viewModel != null) {
                    viewModelSystemBgShow = viewModel.systemBgShow;
                }
                updateRegistration(1, viewModelSystemBgShow);
                if (viewModelSystemBgShow != null) {
                    viewModelSystemBgShowGet = viewModelSystemBgShow.get();
                }
                if ((dirtyFlags & 14) != 0) {
                    if (viewModelSystemBgShowGet) {
                        dirtyFlags |= 32;
                    } else {
                        dirtyFlags |= 16;
                    }
                }
                if (viewModelSystemBgShowGet) {
                    i = 0;
                }
                viewModelSystemBgShowViewVISIBLEViewGONE = i;
            }
        }
        if ((8 & dirtyFlags) != 0) {
            this.bmwId8SettingsHomeback.setOnClickListener(this.mCallback265);
        }
        if ((14 & dirtyFlags) != 0) {
            this.mboundView2.setVisibility(viewModelSystemBgShowViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 13) != 0) {
            this.mboundView3.setVisibility(viewModelSystemIconShowViewVISIBLEViewGONE);
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
