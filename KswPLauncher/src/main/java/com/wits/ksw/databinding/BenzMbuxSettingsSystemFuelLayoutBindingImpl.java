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

public class BenzMbuxSettingsSystemFuelLayoutBindingImpl extends BenzMbuxSettingsSystemFuelLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView2;
    private final ImageView mboundView4;
    private final ImageView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_settings_system_fuel_lay, 7);
    }

    public BenzMbuxSettingsSystemFuelLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private BenzMbuxSettingsSystemFuelLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RelativeLayout) bindings[1], (LinearLayout) bindings[7], (RelativeLayout) bindings[5], (RelativeLayout) bindings[3]);
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
        ImageView imageView3 = (ImageView) bindings[6];
        this.mboundView6 = imageView3;
        imageView3.setTag(null);
        this.mbuxSettingsSystemFuelL.setTag(null);
        this.mbuxSettingsSystemFuelUk.setTag(null);
        this.mbuxSettingsSystemFuelUs.setTag(null);
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

    @Override // com.wits.ksw.databinding.BenzMbuxSettingsSystemFuelLayoutBinding
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
                return onChangeViewModelFuelUnit((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelFuelUnit(ObservableInt ViewModelFuelUnit, int fieldId) {
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
        Drawable viewModelFuelUnitInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = null;
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        Drawable viewModelFuelUnitInt2MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect = null;
        int viewModelFuelUnitGet = 0;
        ObservableInt viewModelFuelUnit = null;
        BenzMbuxSettingsViewModel viewModel = this.mViewModel;
        Drawable viewModelFuelUnitInt0MboundView2AndroidDrawableMbuxSettingsSelectMboundView2AndroidDrawableMbuxSettingsUnselect = null;
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
                viewModelFuelUnit = viewModel.fuelUnit;
            }
            updateRegistration(0, viewModelFuelUnit);
            if (viewModelFuelUnit != null) {
                viewModelFuelUnitGet = viewModelFuelUnit.get();
            }
            boolean viewModelFuelUnitInt1 = viewModelFuelUnitGet == 1;
            boolean viewModelFuelUnitInt2 = viewModelFuelUnitGet == 2;
            boolean viewModelFuelUnitInt0 = viewModelFuelUnitGet == 0;
            if ((dirtyFlags & 7) != 0) {
                if (viewModelFuelUnitInt1) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelFuelUnitInt2) {
                    dirtyFlags |= 64;
                } else {
                    dirtyFlags |= 32;
                }
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelFuelUnitInt0) {
                    dirtyFlags |= 256;
                } else {
                    dirtyFlags |= 128;
                }
            }
            Context context = this.mboundView4.getContext();
            viewModelFuelUnitInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = viewModelFuelUnitInt1 ? AppCompatResources.getDrawable(context, R.drawable.mbux_settings_select) : AppCompatResources.getDrawable(context, R.drawable.mbux_settings_unselect);
            Context context2 = this.mboundView6.getContext();
            viewModelFuelUnitInt2MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect = viewModelFuelUnitInt2 ? AppCompatResources.getDrawable(context2, R.drawable.mbux_settings_select) : AppCompatResources.getDrawable(context2, R.drawable.mbux_settings_unselect);
            viewModelFuelUnitInt0MboundView2AndroidDrawableMbuxSettingsSelectMboundView2AndroidDrawableMbuxSettingsUnselect = viewModelFuelUnitInt0 ? AppCompatResources.getDrawable(this.mboundView2.getContext(), R.drawable.mbux_settings_select) : AppCompatResources.getDrawable(this.mboundView2.getContext(), R.drawable.mbux_settings_unselect);
        }
        if ((7 & dirtyFlags) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, viewModelFuelUnitInt0MboundView2AndroidDrawableMbuxSettingsSelectMboundView2AndroidDrawableMbuxSettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, viewModelFuelUnitInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView6, viewModelFuelUnitInt2MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect);
        }
        if ((dirtyFlags & 6) != 0) {
            this.mbuxSettingsSystemFuelL.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.mbuxSettingsSystemFuelUk.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.mbuxSettingsSystemFuelUs.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
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
