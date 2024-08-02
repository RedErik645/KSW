package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class BmwId9SettingsSystemTempLayoutBindingImpl extends BmwId9SettingsSystemTempLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    private final ImageView mboundView3;
    private final ImageView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id9_settings_system_temp_lay, 6);
    }

    public BmwId9SettingsSystemTempLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private BmwId9SettingsSystemTempLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RelativeLayout) bindings[2], (RelativeLayout) bindings[4], (LinearLayout) bindings[6]);
        this.mDirtyFlags = -1;
        this.bmwId9SettingsSystemTempC.setTag(null);
        this.bmwId9SettingsSystemTempF.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[3];
        this.mboundView3 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[5];
        this.mboundView5 = imageView3;
        imageView3.setTag(null);
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
        setViewModel((BmwId9SettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BmwId9SettingsSystemTempLayoutBinding
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
                return onChangeViewModelSystemBgShow((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeViewModelTempUnit((ObservableInt) object, fieldId);
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

    private boolean onChangeViewModelTempUnit(ObservableInt ViewModelTempUnit, int fieldId) {
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
        Drawable viewModelTempUnitInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect = null;
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        int viewModelTempUnitGet = 0;
        Drawable viewModelTempUnitInt0MboundView3AndroidDrawableBmwId9SettingsSelectMboundView3AndroidDrawableBmwId9SettingsUnselect = null;
        ObservableBoolean viewModelSystemBgShow = null;
        boolean viewModelSystemBgShowGet = false;
        ObservableInt viewModelTempUnit = null;
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        int viewModelSystemBgShowViewGONEViewVISIBLE = 0;
        if ((dirtyFlags & 15) != 0) {
            if (!((dirtyFlags & 12) == 0 || viewModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mViewModelOnClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mViewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                viewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
            }
            boolean viewModelTempUnitInt1 = false;
            if ((dirtyFlags & 13) != 0) {
                if (viewModel != null) {
                    viewModelSystemBgShow = viewModel.systemBgShow;
                }
                updateRegistration(0, viewModelSystemBgShow);
                if (viewModelSystemBgShow != null) {
                    viewModelSystemBgShowGet = viewModelSystemBgShow.get();
                }
                if ((dirtyFlags & 13) != 0) {
                    if (viewModelSystemBgShowGet) {
                        dirtyFlags |= 512;
                    } else {
                        dirtyFlags |= 256;
                    }
                }
                viewModelSystemBgShowViewGONEViewVISIBLE = viewModelSystemBgShowGet ? 8 : 0;
            }
            if ((dirtyFlags & 14) != 0) {
                if (viewModel != null) {
                    viewModelTempUnit = viewModel.tempUnit;
                }
                updateRegistration(1, viewModelTempUnit);
                if (viewModelTempUnit != null) {
                    viewModelTempUnitGet = viewModelTempUnit.get();
                }
                boolean viewModelTempUnitInt0 = viewModelTempUnitGet == 0;
                if (viewModelTempUnitGet == 1) {
                    viewModelTempUnitInt1 = true;
                }
                if ((dirtyFlags & 14) != 0) {
                    if (viewModelTempUnitInt0) {
                        dirtyFlags |= 128;
                    } else {
                        dirtyFlags |= 64;
                    }
                }
                if ((dirtyFlags & 14) != 0) {
                    if (viewModelTempUnitInt1) {
                        dirtyFlags |= 32;
                    } else {
                        dirtyFlags |= 16;
                    }
                }
                int i = R.drawable.bmw_id9_settings_select;
                Context context = this.mboundView3.getContext();
                if (!viewModelTempUnitInt0) {
                    i = R.drawable.bmw_id9_settings_unselect;
                }
                viewModelTempUnitInt0MboundView3AndroidDrawableBmwId9SettingsSelectMboundView3AndroidDrawableBmwId9SettingsUnselect = AppCompatResources.getDrawable(context, i);
                viewModelTempUnitInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect = AppCompatResources.getDrawable(this.mboundView5.getContext(), viewModelTempUnitInt1 ? R.drawable.bmw_id9_settings_select : R.drawable.bmw_id9_settings_unselect);
            }
        }
        if ((dirtyFlags & 12) != 0) {
            this.bmwId9SettingsSystemTempC.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId9SettingsSystemTempF.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 13) != 0) {
            this.mboundView1.setVisibility(viewModelSystemBgShowViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 14) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, viewModelTempUnitInt0MboundView3AndroidDrawableBmwId9SettingsSelectMboundView3AndroidDrawableBmwId9SettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, viewModelTempUnitInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect);
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
