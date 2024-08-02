package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
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
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class BenzMbuxSettingsSystemTempLayoutBindingImpl extends BenzMbuxSettingsSystemTempLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView2;
    private final ImageView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_settings_system_temp_lay, 5);
    }

    public BenzMbuxSettingsSystemTempLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private BenzMbuxSettingsSystemTempLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RelativeLayout) bindings[1], (RelativeLayout) bindings[3], (LinearLayout) bindings[5]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[4];
        this.mboundView4 = imageView2;
        imageView2.setTag(null);
        this.mbuxSettingsSystemTempC.setTag(null);
        this.mbuxSettingsSystemTempF.setTag(null);
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

    @Override // com.wits.ksw.databinding.BenzMbuxSettingsSystemTempLayoutBinding
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
                return onChangeViewModelTempUnit((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelTempUnit(ObservableInt ViewModelTempUnit, int fieldId) {
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
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        int viewModelTempUnitGet = 0;
        Drawable viewModelTempUnitInt0MboundView2AndroidDrawableMbuxSettingsSelectMboundView2AndroidDrawableMbuxSettingsUnselect = null;
        Drawable viewModelTempUnitInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = null;
        ObservableInt viewModelTempUnit = null;
        BenzMbuxSettingsViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 7) != 0) {
            if (!((dirtyFlags & 6) == 0 || viewModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mViewModelOnClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mViewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                viewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
            }
            if (viewModel != null) {
                viewModelTempUnit = viewModel.tempUnit;
            }
            updateRegistration(0, viewModelTempUnit);
            if (viewModelTempUnit != null) {
                viewModelTempUnitGet = viewModelTempUnit.get();
            }
            boolean viewModelTempUnitInt1 = true;
            boolean viewModelTempUnitInt0 = viewModelTempUnitGet == 0;
            if (viewModelTempUnitGet != 1) {
                viewModelTempUnitInt1 = false;
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelTempUnitInt0) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelTempUnitInt1) {
                    dirtyFlags |= 64;
                } else {
                    dirtyFlags |= 32;
                }
            }
            Context context = this.mboundView2.getContext();
            viewModelTempUnitInt0MboundView2AndroidDrawableMbuxSettingsSelectMboundView2AndroidDrawableMbuxSettingsUnselect = viewModelTempUnitInt0 ? AppCompatResources.getDrawable(context, R.drawable.mbux_settings_select) : AppCompatResources.getDrawable(context, R.drawable.mbux_settings_unselect);
            viewModelTempUnitInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = viewModelTempUnitInt1 ? AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.mbux_settings_select) : AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.mbux_settings_unselect);
        }
        if ((dirtyFlags & 7) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, viewModelTempUnitInt0MboundView2AndroidDrawableMbuxSettingsSelectMboundView2AndroidDrawableMbuxSettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, viewModelTempUnitInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect);
        }
        if ((dirtyFlags & 6) != 0) {
            this.mbuxSettingsSystemTempC.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.mbuxSettingsSystemTempF.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
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
