package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.CompoundButtonBindingAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.settings.bmw_id8.vm.BmwId8SettingsViewModel;

public class ViewId9MainSettingsCameraBindingImpl extends ViewId9MainSettingsCameraBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final ScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.id9_settings_unit_title, 5);
        sparseIntArray.put(R.id.id9_settings_time_rg, 6);
    }

    public ViewId9MainSettingsCameraBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private ViewId9MainSettingsCameraBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RadioButton) bindings[3], (RadioButton) bindings[4], (RadioButton) bindings[1], (RadioButton) bindings[2], (RadioGroup) bindings[6], (TextView) bindings[5]);
        this.mDirtyFlags = -1;
        this.bmwId8SettingsSystemCamera360.setTag(null);
        this.bmwId8SettingsSystemCamera360Built.setTag(null);
        this.bmwId8SettingsSystemCameraAfter.setTag(null);
        this.bmwId8SettingsSystemCameraOem.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
        if (9 == variableId) {
            setID9Constants((Id9AlsConstants) variable);
            return true;
        } else if (36 != variableId) {
            return false;
        } else {
            setViewModel((BmwId8SettingsViewModel) variable);
            return true;
        }
    }

    @Override // com.wits.ksw.databinding.ViewId9MainSettingsCameraBinding
    public void setID9Constants(Id9AlsConstants ID9Constants) {
        this.mID9Constants = ID9Constants;
    }

    @Override // com.wits.ksw.databinding.ViewId9MainSettingsCameraBinding
    public void setViewModel(BmwId8SettingsViewModel ViewModel) {
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
                return onChangeID9ConstantsIsLayoutModelRtl((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeViewModelRearCameraType((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeID9ConstantsIsLayoutModelRtl(ObservableBoolean ID9ConstantsIsLayoutModelRtl, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelRearCameraType(ObservableInt ViewModelRearCameraType, int fieldId) {
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
        int ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean viewModelRearCameraTypeInt3 = false;
        boolean viewModelRearCameraTypeInt1 = false;
        int iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus = 0;
        int viewModelRearCameraTypeGet = 0;
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        boolean viewModelRearCameraTypeInt2 = false;
        boolean viewModelRearCameraTypeInt0 = false;
        ObservableInt viewModelRearCameraType = null;
        BmwId8SettingsViewModel viewModel = this.mViewModel;
        boolean iD9ConstantsIsLayoutModelRtlGet = false;
        if ((dirtyFlags & 17) != 0) {
            ObservableBoolean ID9ConstantsIsLayoutModelRtl1 = Id9AlsConstants.isLayoutModelRtl;
            updateRegistration(0, ID9ConstantsIsLayoutModelRtl1);
            if (ID9ConstantsIsLayoutModelRtl1 != null) {
                iD9ConstantsIsLayoutModelRtlGet = ID9ConstantsIsLayoutModelRtl1.get();
            }
            if ((dirtyFlags & 17) != 0) {
                if (iD9ConstantsIsLayoutModelRtlGet) {
                    dirtyFlags |= 256;
                } else {
                    dirtyFlags |= 128;
                }
            }
            boolean iD9ConstantsIsLayoutModelRtl = !iD9ConstantsIsLayoutModelRtlGet;
            int i = R.id.id9_setting_time;
            int ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus12 = iD9ConstantsIsLayoutModelRtlGet ? R.id.id9_setting_time : R.id.id9_freeWindow_focus;
            if ((dirtyFlags & 17) != 0) {
                if (iD9ConstantsIsLayoutModelRtl) {
                    dirtyFlags |= 64;
                } else {
                    dirtyFlags |= 32;
                }
            }
            if (!iD9ConstantsIsLayoutModelRtl) {
                i = R.id.id9_freeWindow_focus;
            }
            iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus = i;
            ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1 = ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus12;
        } else {
            ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1 = 0;
        }
        if ((dirtyFlags & 26) != 0) {
            if (!((dirtyFlags & 24) == 0 || viewModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mViewModelOnClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mViewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                viewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
            }
            if (viewModel != null) {
                viewModelRearCameraType = viewModel.rearCameraType;
            }
            updateRegistration(1, viewModelRearCameraType);
            if (viewModelRearCameraType != null) {
                viewModelRearCameraTypeGet = viewModelRearCameraType.get();
            }
            viewModelRearCameraTypeInt3 = viewModelRearCameraTypeGet == 3;
            viewModelRearCameraTypeInt1 = viewModelRearCameraTypeGet == 1;
            viewModelRearCameraTypeInt2 = viewModelRearCameraTypeGet == 2;
            viewModelRearCameraTypeInt0 = viewModelRearCameraTypeGet == 0;
        }
        if ((dirtyFlags & 26) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsSystemCamera360, viewModelRearCameraTypeInt2);
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsSystemCamera360Built, viewModelRearCameraTypeInt3);
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsSystemCameraAfter, viewModelRearCameraTypeInt0);
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsSystemCameraOem, viewModelRearCameraTypeInt1);
        }
        if ((dirtyFlags & 17) != 0) {
            this.bmwId8SettingsSystemCamera360.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsSystemCamera360.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsSystemCamera360Built.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsSystemCamera360Built.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsSystemCameraAfter.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsSystemCameraAfter.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsSystemCameraOem.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsSystemCameraOem.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
        }
        if ((dirtyFlags & 24) != 0) {
            this.bmwId8SettingsSystemCamera360.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsSystemCamera360Built.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsSystemCameraAfter.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsSystemCameraOem.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private BmwId8SettingsViewModel value;

        public OnClickListenerImpl setValue(BmwId8SettingsViewModel value2) {
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
