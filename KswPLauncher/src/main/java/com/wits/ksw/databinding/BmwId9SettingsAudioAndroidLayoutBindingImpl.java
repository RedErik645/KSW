package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class BmwId9SettingsAudioAndroidLayoutBindingImpl extends BmwId9SettingsAudioAndroidLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id9_settings_audio_android_lay, 10);
    }

    public BmwId9SettingsAudioAndroidLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private BmwId9SettingsAudioAndroidLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (ImageButton) bindings[9], (BmwId9ProgressBar) bindings[8], (ImageButton) bindings[7], (LinearLayout) bindings[10], (ImageButton) bindings[5], (BmwId9ProgressBar) bindings[4], (ImageButton) bindings[3]);
        this.mDirtyFlags = -1;
        this.bmwId9SettingsAndroidCallAddBtn.setTag(null);
        this.bmwId9SettingsAndroidCallSeekbar.setTag(null);
        this.bmwId9SettingsAndroidCallSubBtn.setTag(null);
        this.bmwId9SettingsMeidaAddBtn.setTag(null);
        this.bmwId9SettingsMeidaSeekbar.setTag(null);
        this.bmwId9SettingsMeidaSubBtn.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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

    @Override // com.wits.ksw.databinding.BmwId9SettingsAudioAndroidLayoutBinding
    public void setViewModel(BmwId9SettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelAndroidCallVolume((ObservableInt) object, fieldId);
            case 1:
                return onChangeViewModelAndroidMediaVolume((ObservableInt) object, fieldId);
            case 2:
                return onChangeViewModelSystemBgShow((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelAndroidCallVolume(ObservableInt ViewModelAndroidCallVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelAndroidMediaVolume(ObservableInt ViewModelAndroidMediaVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelSystemBgShow(ObservableBoolean ViewModelSystemBgShow, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
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
        String stringValueOfViewModelAndroidMediaVolume = null;
        String stringValueOfViewModelAndroidCallVolume = null;
        ObservableInt viewModelAndroidCallVolume = null;
        int viewModelAndroidMediaVolumeGet = 0;
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        int viewModelAndroidCallVolumeGet = 0;
        ObservableInt viewModelAndroidMediaVolume = null;
        ObservableBoolean viewModelSystemBgShow = null;
        boolean viewModelSystemBgShowGet = false;
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        int viewModelSystemBgShowViewGONEViewVISIBLE = 0;
        if ((dirtyFlags & 31) != 0) {
            int i = 0;
            if ((dirtyFlags & 25) != 0) {
                if (viewModel != null) {
                    viewModelAndroidCallVolume = viewModel.androidCallVolume;
                }
                updateRegistration(0, viewModelAndroidCallVolume);
                if (viewModelAndroidCallVolume != null) {
                    viewModelAndroidCallVolumeGet = viewModelAndroidCallVolume.get();
                }
                stringValueOfViewModelAndroidCallVolume = String.valueOf(viewModelAndroidCallVolumeGet);
            }
            if (!((dirtyFlags & 24) == 0 || viewModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mViewModelOnClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mViewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                viewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
            }
            if ((dirtyFlags & 26) != 0) {
                if (viewModel != null) {
                    viewModelAndroidMediaVolume = viewModel.androidMediaVolume;
                }
                updateRegistration(1, viewModelAndroidMediaVolume);
                if (viewModelAndroidMediaVolume != null) {
                    viewModelAndroidMediaVolumeGet = viewModelAndroidMediaVolume.get();
                }
                stringValueOfViewModelAndroidMediaVolume = String.valueOf(viewModelAndroidMediaVolumeGet);
            }
            if ((dirtyFlags & 28) != 0) {
                if (viewModel != null) {
                    viewModelSystemBgShow = viewModel.systemBgShow;
                }
                updateRegistration(2, viewModelSystemBgShow);
                if (viewModelSystemBgShow != null) {
                    viewModelSystemBgShowGet = viewModelSystemBgShow.get();
                }
                if ((dirtyFlags & 28) != 0) {
                    if (viewModelSystemBgShowGet) {
                        dirtyFlags |= 64;
                    } else {
                        dirtyFlags |= 32;
                    }
                }
                if (viewModelSystemBgShowGet) {
                    i = 8;
                }
                viewModelSystemBgShowViewGONEViewVISIBLE = i;
            }
        }
        if ((dirtyFlags & 24) != 0) {
            this.bmwId9SettingsAndroidCallAddBtn.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId9SettingsAndroidCallSubBtn.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId9SettingsMeidaAddBtn.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId9SettingsMeidaSubBtn.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 25) != 0) {
            BaseBindingModel.setBmwId9ProgressBarValue(this.bmwId9SettingsAndroidCallSeekbar, viewModelAndroidCallVolumeGet);
            TextViewBindingAdapter.setText(this.mboundView6, stringValueOfViewModelAndroidCallVolume);
        }
        if ((dirtyFlags & 26) != 0) {
            BaseBindingModel.setBmwId9ProgressBarValue(this.bmwId9SettingsMeidaSeekbar, viewModelAndroidMediaVolumeGet);
            TextViewBindingAdapter.setText(this.mboundView2, stringValueOfViewModelAndroidMediaVolume);
        }
        if ((dirtyFlags & 28) != 0) {
            this.mboundView1.setVisibility(viewModelSystemBgShowViewGONEViewVISIBLE);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private BmwId9SettingsViewModel value;

        public OnClickListenerImpl setValue(BmwId9SettingsViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onClick(arg0);
        }
    }
}
