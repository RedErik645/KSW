package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class BenzMbuxSettingsAudioOemLayoutBindingImpl extends BenzMbuxSettingsAudioOemLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final RelativeLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_settings_audio_oem_lay, 9);
    }

    public BenzMbuxSettingsAudioOemLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private BenzMbuxSettingsAudioOemLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (LinearLayout) bindings[9], (ImageButton) bindings[8], (BenzMbuxProgressBar) bindings[7], (ImageButton) bindings[6], (ImageButton) bindings[4], (BenzMbuxProgressBar) bindings[3], (ImageButton) bindings[2]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        this.mbuxSettingsNaviAddBtn.setTag(null);
        this.mbuxSettingsNaviSeekbar.setTag(null);
        this.mbuxSettingsNaviSubBtn.setTag(null);
        this.mbuxSettingsOemCallAddBtn.setTag(null);
        this.mbuxSettingsOemCallSeekbar.setTag(null);
        this.mbuxSettingsOemCallSubBtn.setTag(null);
        setRootTag(root);
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
        setViewModel((BenzMbuxSettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BenzMbuxSettingsAudioOemLayoutBinding
    public void setViewModel(BenzMbuxSettingsViewModel ViewModel) {
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
                return onChangeViewModelOemNaviVolume((ObservableInt) object, fieldId);
            case 1:
                return onChangeViewModelOemCallVolume((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelOemNaviVolume(ObservableInt ViewModelOemNaviVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelOemCallVolume(ObservableInt ViewModelOemCallVolume, int fieldId) {
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
        ObservableInt viewModelOemNaviVolume = null;
        String stringValueOfViewModelOemCallVolume = null;
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        int viewModelOemCallVolumeGet = 0;
        int viewModelOemNaviVolumeGet = 0;
        ObservableInt viewModelOemCallVolume = null;
        String stringValueOfViewModelOemNaviVolume = null;
        BenzMbuxSettingsViewModel viewModel = this.mViewModel;
        if ((15 & dirtyFlags) != 0) {
            if ((dirtyFlags & 13) != 0) {
                if (viewModel != null) {
                    viewModelOemNaviVolume = viewModel.oemNaviVolume;
                }
                updateRegistration(0, viewModelOemNaviVolume);
                if (viewModelOemNaviVolume != null) {
                    viewModelOemNaviVolumeGet = viewModelOemNaviVolume.get();
                }
                stringValueOfViewModelOemNaviVolume = String.valueOf(viewModelOemNaviVolumeGet);
            }
            if (!((dirtyFlags & 12) == 0 || viewModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mViewModelOnClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mViewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                viewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
            }
            if ((dirtyFlags & 14) != 0) {
                if (viewModel != null) {
                    viewModelOemCallVolume = viewModel.oemCallVolume;
                }
                updateRegistration(1, viewModelOemCallVolume);
                if (viewModelOemCallVolume != null) {
                    viewModelOemCallVolumeGet = viewModelOemCallVolume.get();
                }
                stringValueOfViewModelOemCallVolume = String.valueOf(viewModelOemCallVolumeGet);
            }
        }
        if ((dirtyFlags & 14) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, stringValueOfViewModelOemCallVolume);
            BaseBindingModel.setBenzMbuxProgressBarValue(this.mbuxSettingsOemCallSeekbar, viewModelOemCallVolumeGet);
        }
        if ((dirtyFlags & 13) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, stringValueOfViewModelOemNaviVolume);
            BaseBindingModel.setBenzMbuxProgressBarValue(this.mbuxSettingsNaviSeekbar, viewModelOemNaviVolumeGet);
        }
        if ((dirtyFlags & 12) != 0) {
            this.mbuxSettingsNaviAddBtn.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.mbuxSettingsNaviSubBtn.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.mbuxSettingsOemCallAddBtn.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.mbuxSettingsOemCallSubBtn.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private BenzMbuxSettingsViewModel value;

        public OnClickListenerImpl setValue(BenzMbuxSettingsViewModel value2) {
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
