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

public class ViewId9MainSettingsUnitBindingImpl extends ViewId9MainSettingsUnitBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final ScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.id9_settings_unit_title, 6);
        sparseIntArray.put(R.id.id9_settings_time_rg, 7);
        sparseIntArray.put(R.id.id9_settings_temp_title, 8);
        sparseIntArray.put(R.id.id9_settings_time_format_rg, 9);
    }

    public ViewId9MainSettingsUnitBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private ViewId9MainSettingsUnitBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RadioButton) bindings[1], (RadioButton) bindings[3], (RadioButton) bindings[2], (RadioButton) bindings[4], (RadioButton) bindings[5], (TextView) bindings[8], (RadioGroup) bindings[9], (RadioGroup) bindings[7], (TextView) bindings[6]);
        this.mDirtyFlags = -1;
        this.bmwId8SettingsSystemFuelL.setTag(null);
        this.bmwId8SettingsSystemFuelUk.setTag(null);
        this.bmwId8SettingsSystemFuelUs.setTag(null);
        this.bmwId8SettingsSystemTempC.setTag(null);
        this.bmwId8SettingsSystemTempF.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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

    @Override // com.wits.ksw.databinding.ViewId9MainSettingsUnitBinding
    public void setID9Constants(Id9AlsConstants ID9Constants) {
        this.mID9Constants = ID9Constants;
    }

    @Override // com.wits.ksw.databinding.ViewId9MainSettingsUnitBinding
    public void setViewModel(BmwId8SettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
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
                return onChangeViewModelFuelUnit((ObservableInt) object, fieldId);
            case 2:
                return onChangeViewModelTempUnit((ObservableInt) object, fieldId);
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

    private boolean onChangeViewModelFuelUnit(ObservableInt ViewModelFuelUnit, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelTempUnit(ObservableInt ViewModelTempUnit, int fieldId) {
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
        boolean iD9ConstantsIsLayoutModelRtlGet;
        int ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1;
        boolean viewModelFuelUnitInt0;
        boolean viewModelFuelUnitInt2;
        ObservableInt viewModelTempUnit;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int viewModelTempUnitGet = 0;
        boolean viewModelTempUnitInt1 = false;
        boolean viewModelFuelUnitInt22 = false;
        int iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus = 0;
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        boolean viewModelTempUnitInt0 = false;
        int viewModelFuelUnitGet = 0;
        ObservableInt viewModelFuelUnit = null;
        boolean viewModelFuelUnitInt23 = false;
        boolean viewModelFuelUnitInt02 = false;
        BmwId8SettingsViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 33) != 0) {
            ObservableBoolean ID9ConstantsIsLayoutModelRtl1 = Id9AlsConstants.isLayoutModelRtl;
            updateRegistration(0, ID9ConstantsIsLayoutModelRtl1);
            if (ID9ConstantsIsLayoutModelRtl1 != null) {
                iD9ConstantsIsLayoutModelRtlGet = ID9ConstantsIsLayoutModelRtl1.get();
            } else {
                iD9ConstantsIsLayoutModelRtlGet = false;
            }
            if ((dirtyFlags & 33) != 0) {
                if (iD9ConstantsIsLayoutModelRtlGet) {
                    dirtyFlags |= 512;
                } else {
                    dirtyFlags |= 256;
                }
            }
            boolean iD9ConstantsIsLayoutModelRtl = !iD9ConstantsIsLayoutModelRtlGet;
            int i = R.id.id9_setting_time;
            int ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus12 = iD9ConstantsIsLayoutModelRtlGet ? R.id.id9_setting_time : R.id.id9_freeWindow_focus;
            if ((dirtyFlags & 33) != 0) {
                if (iD9ConstantsIsLayoutModelRtl) {
                    dirtyFlags |= 128;
                } else {
                    dirtyFlags |= 64;
                }
            }
            if (!iD9ConstantsIsLayoutModelRtl) {
                i = R.id.id9_freeWindow_focus;
            }
            iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus = i;
            ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1 = ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus12;
        } else {
            ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1 = 0;
            iD9ConstantsIsLayoutModelRtlGet = false;
        }
        if ((dirtyFlags & 54) != 0) {
            if ((dirtyFlags & 48) != 0) {
                if (viewModel != null) {
                    OnClickListenerImpl onClickListenerImpl = this.mViewModelOnClickAndroidViewViewOnClickListener;
                    if (onClickListenerImpl == null) {
                        onClickListenerImpl = new OnClickListenerImpl();
                        this.mViewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl;
                    }
                    viewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
                }
            }
            if ((dirtyFlags & 50) != 0) {
                if (viewModel != null) {
                    viewModelFuelUnit = viewModel.fuelUnit;
                }
                updateRegistration(1, viewModelFuelUnit);
                if (viewModelFuelUnit != null) {
                    viewModelFuelUnitGet = viewModelFuelUnit.get();
                }
                boolean viewModelFuelUnitInt1 = viewModelFuelUnitGet == 1;
                boolean viewModelFuelUnitInt24 = viewModelFuelUnitGet == 2;
                viewModelFuelUnitInt02 = viewModelFuelUnitGet == 0;
                viewModelFuelUnitInt23 = viewModelFuelUnitInt24;
                viewModelFuelUnitInt22 = viewModelFuelUnitInt1;
            }
            if ((dirtyFlags & 52) != 0) {
                if (viewModel != null) {
                    viewModelTempUnit = viewModel.tempUnit;
                } else {
                    viewModelTempUnit = null;
                }
                updateRegistration(2, viewModelTempUnit);
                if (viewModelTempUnit != null) {
                    viewModelTempUnitGet = viewModelTempUnit.get();
                } else {
                    viewModelTempUnitGet = 0;
                }
                viewModelTempUnitInt1 = viewModelTempUnitGet == 1;
                viewModelTempUnitInt0 = viewModelTempUnitGet == 0;
                viewModelFuelUnitInt2 = viewModelFuelUnitInt23;
                viewModelFuelUnitInt0 = viewModelFuelUnitInt02;
            } else {
                viewModelFuelUnitInt2 = viewModelFuelUnitInt23;
                viewModelFuelUnitInt0 = viewModelFuelUnitInt02;
                viewModelTempUnitGet = 0;
            }
        } else {
            viewModelFuelUnitInt2 = false;
            viewModelFuelUnitInt0 = false;
        }
        if ((dirtyFlags & 50) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsSystemFuelL, viewModelFuelUnitInt0);
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsSystemFuelUk, viewModelFuelUnitInt2);
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsSystemFuelUs, viewModelFuelUnitInt22);
        }
        if ((dirtyFlags & 33) != 0) {
            this.bmwId8SettingsSystemFuelL.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsSystemFuelL.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsSystemFuelUk.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsSystemFuelUk.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsSystemFuelUs.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsSystemFuelUs.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsSystemTempC.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsSystemTempC.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsSystemTempF.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsSystemTempF.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
        }
        if ((dirtyFlags & 48) != 0) {
            this.bmwId8SettingsSystemFuelL.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsSystemFuelUk.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsSystemFuelUs.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsSystemTempC.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsSystemTempF.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 52) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsSystemTempC, viewModelTempUnitInt0);
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsSystemTempF, viewModelTempUnitInt1);
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
