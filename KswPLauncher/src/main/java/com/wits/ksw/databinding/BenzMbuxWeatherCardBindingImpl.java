package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.BcVieModel;

public class BenzMbuxWeatherCardBindingImpl extends BenzMbuxWeatherCardBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback484;
    private final View.OnClickListener mCallback485;
    private final View.OnClickListener mCallback486;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final AppCompatImageView mboundView2;
    private final AppCompatImageView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.benz_mbux_local_card_title, 4);
        sparseIntArray.put(R.id.benz_mbux_local_card_content, 5);
    }

    public BenzMbuxWeatherCardBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private BenzMbuxWeatherCardBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (AppCompatImageView) bindings[1], (AppCompatTextView) bindings[5], (AppCompatTextView) bindings[4]);
        this.mDirtyFlags = -1;
        this.benzMbuxLocalCardBg.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) bindings[2];
        this.mboundView2 = appCompatImageView;
        appCompatImageView.setTag(null);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) bindings[3];
        this.mboundView3 = appCompatImageView2;
        appCompatImageView2.setTag(null);
        setRootTag(root);
        this.mCallback486 = new OnClickListener(this, 3);
        this.mCallback485 = new OnClickListener(this, 2);
        this.mCallback484 = new OnClickListener(this, 1);
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
        if (25 != variableId) {
            return false;
        }
        setViewModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BenzMbuxWeatherCardBinding
    public void setViewModel(BcVieModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelItemIconClassical((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelItemIconClassical(ObservableBoolean ViewModelItemIconClassical, int fieldId) {
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
        BcVieModel viewModel = this.mViewModel;
        ObservableBoolean viewModelItemIconClassical = null;
        Drawable viewModelItemIconClassicalBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswV2WeatherIcon1SelectorBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswV2WeatherIcon2Selector = null;
        boolean viewModelItemIconClassicalGet = false;
        if ((dirtyFlags & 7) != 0) {
            if (viewModel != null) {
                viewModelItemIconClassical = viewModel.itemIconClassical;
            }
            updateRegistration(0, viewModelItemIconClassical);
            if (viewModelItemIconClassical != null) {
                viewModelItemIconClassicalGet = viewModelItemIconClassical.get();
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            viewModelItemIconClassicalBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswV2WeatherIcon1SelectorBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswV2WeatherIcon2Selector = AppCompatResources.getDrawable(this.benzMbuxLocalCardBg.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_v2_weather_icon1_selector : R.drawable.benz_mbux_2021_ksw_v2_weather_icon2_selector);
        }
        if ((7 & dirtyFlags) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.benzMbuxLocalCardBg, viewModelItemIconClassicalBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswV2WeatherIcon1SelectorBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswV2WeatherIcon2Selector);
        }
        if ((4 & dirtyFlags) != 0) {
            this.benzMbuxLocalCardBg.setOnClickListener(this.mCallback484);
            this.mboundView2.setOnClickListener(this.mCallback485);
            this.mboundView3.setOnClickListener(this.mCallback486);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean viewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                BcVieModel viewModel = this.mViewModel;
                if (viewModel == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel.openWeatherApp(callbackArg_0);
                    return;
                }
                return;
            case 2:
                BcVieModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.openWeatherApp(callbackArg_0);
                    return;
                }
                return;
            case 3:
                BcVieModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.openWeatherApp(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
