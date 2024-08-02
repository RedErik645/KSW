package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.CompoundButtonBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.settings.bmw_id8.vm.BmwId8SettingsViewModel;

public class ViewId9MainSettingsTimeBindingImpl extends ViewId9MainSettingsTimeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.id9_settings_time_title, 5);
        sparseIntArray.put(R.id.id9_settings_time_rg, 6);
        sparseIntArray.put(R.id.id9_settings_time_title_format, 7);
        sparseIntArray.put(R.id.id9_settings_time_format_rg, 8);
    }

    public ViewId9MainSettingsTimeBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private ViewId9MainSettingsTimeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RadioButton) bindings[3], (RadioButton) bindings[4], (RadioButton) bindings[2], (RadioButton) bindings[1], (RadioGroup) bindings[8], (RadioGroup) bindings[6], (TextView) bindings[5], (TextView) bindings[7]);
        this.mDirtyFlags = -1;
        this.bmwId8SettingsTime12.setTag(null);
        this.bmwId8SettingsTime24.setTag(null);
        this.bmwId8SettingsTimeAndroid.setTag(null);
        this.bmwId8SettingsTimeCar.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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

    @Override // com.wits.ksw.databinding.ViewId9MainSettingsTimeBinding
    public void setID9Constants(Id9AlsConstants ID9Constants) {
        this.mID9Constants = ID9Constants;
    }

    @Override // com.wits.ksw.databinding.ViewId9MainSettingsTimeBinding
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
                return onChangeViewModelTimeFormatState((ObservableInt) object, fieldId);
            case 1:
                return onChangeID9ConstantsIsLayoutModelRtl((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeViewModelTimeSyncState((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelTimeFormatState(ObservableInt ViewModelTimeFormatState, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeID9ConstantsIsLayoutModelRtl(ObservableBoolean ID9ConstantsIsLayoutModelRtl, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelTimeSyncState(ObservableInt ViewModelTimeSyncState, int fieldId) {
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
        int ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1;
        boolean viewModelTimeSyncStateInt1;
        boolean viewModelTimeFormatStateInt0;
        boolean viewModelTimeFormatStateInt02;
        boolean viewModelTimeFormatStateInt03;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean iD9ConstantsIsLayoutModelRtlGet = false;
        ObservableInt viewModelTimeFormatState = null;
        boolean viewModelTimeSyncStateInt0 = false;
        int iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus = 0;
        ObservableInt viewModelTimeSyncState = null;
        boolean viewModelTimeFormatStateInt1 = false;
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        int viewModelTimeSyncStateGet = 0;
        boolean viewModelTimeSyncStateInt12 = false;
        BmwId8SettingsViewModel viewModel = this.mViewModel;
        int viewModelTimeFormatStateGet = 0;
        if ((dirtyFlags & 34) != 0) {
            ObservableBoolean ID9ConstantsIsLayoutModelRtl1 = Id9AlsConstants.isLayoutModelRtl;
            updateRegistration(1, ID9ConstantsIsLayoutModelRtl1);
            if (ID9ConstantsIsLayoutModelRtl1 != null) {
                iD9ConstantsIsLayoutModelRtlGet = ID9ConstantsIsLayoutModelRtl1.get();
            }
            if ((dirtyFlags & 34) != 0) {
                if (iD9ConstantsIsLayoutModelRtlGet) {
                    dirtyFlags |= 512;
                } else {
                    dirtyFlags |= 256;
                }
            }
            boolean iD9ConstantsIsLayoutModelRtl = !iD9ConstantsIsLayoutModelRtlGet;
            int i = R.id.id9_setting_time;
            int ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus12 = iD9ConstantsIsLayoutModelRtlGet ? R.id.id9_setting_time : R.id.id9_freeWindow_focus;
            if ((dirtyFlags & 34) != 0) {
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
        }
        if ((dirtyFlags & 53) != 0) {
            if ((dirtyFlags & 49) != 0) {
                if (viewModel != null) {
                    viewModelTimeFormatState = viewModel.timeFormatState;
                }
                updateRegistration(0, viewModelTimeFormatState);
                if (viewModelTimeFormatState != null) {
                    viewModelTimeFormatStateGet = viewModelTimeFormatState.get();
                }
                boolean viewModelTimeFormatStateInt04 = viewModelTimeFormatStateGet == 0;
                viewModelTimeFormatStateInt1 = viewModelTimeFormatStateGet == 1;
                viewModelTimeFormatStateInt02 = viewModelTimeFormatStateInt04;
            } else {
                viewModelTimeFormatStateInt02 = false;
            }
            if ((dirtyFlags & 52) != 0) {
                if (viewModel != null) {
                    viewModelTimeSyncState = viewModel.timeSyncState;
                }
                viewModelTimeFormatStateInt03 = viewModelTimeFormatStateInt02;
                updateRegistration(2, viewModelTimeSyncState);
                if (viewModelTimeSyncState != null) {
                    viewModelTimeSyncStateGet = viewModelTimeSyncState.get();
                }
                boolean viewModelTimeSyncStateInt02 = viewModelTimeSyncStateGet == 0;
                boolean viewModelTimeSyncStateInt03 = true;
                if (viewModelTimeSyncStateGet != 1) {
                    viewModelTimeSyncStateInt03 = false;
                }
                viewModelTimeSyncStateInt12 = viewModelTimeSyncStateInt03;
                viewModelTimeSyncStateInt0 = viewModelTimeSyncStateInt02;
            } else {
                viewModelTimeFormatStateInt03 = viewModelTimeFormatStateInt02;
            }
            if ((dirtyFlags & 48) == 0 || viewModel == null) {
                viewModelTimeFormatStateInt0 = viewModelTimeFormatStateInt03;
                viewModelTimeSyncStateInt1 = viewModelTimeSyncStateInt12;
            } else {
                OnClickListenerImpl onClickListenerImpl = this.mViewModelOnClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mViewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                viewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
                viewModelTimeFormatStateInt0 = viewModelTimeFormatStateInt03;
                viewModelTimeSyncStateInt1 = viewModelTimeSyncStateInt12;
            }
        } else {
            viewModelTimeFormatStateInt0 = false;
            viewModelTimeSyncStateInt1 = false;
        }
        if ((dirtyFlags & 49) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsTime12, viewModelTimeFormatStateInt1);
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsTime24, viewModelTimeFormatStateInt0);
        }
        if ((dirtyFlags & 34) != 0) {
            this.bmwId8SettingsTime12.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsTime12.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsTime24.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsTime24.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsTimeAndroid.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsTimeAndroid.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
            this.bmwId8SettingsTimeCar.setNextFocusLeftId(ID9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus1);
            this.bmwId8SettingsTimeCar.setNextFocusRightId(iD9ConstantsIsLayoutModelRtlAndroidIdId9SettingTimeAndroidIdId9FreeWindowFocus);
        }
        if ((dirtyFlags & 48) != 0) {
            this.bmwId8SettingsTime12.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsTime24.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsTimeAndroid.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId8SettingsTimeCar.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 52) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsTimeAndroid, viewModelTimeSyncStateInt0);
            CompoundButtonBindingAdapter.setChecked(this.bmwId8SettingsTimeCar, viewModelTimeSyncStateInt1);
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
