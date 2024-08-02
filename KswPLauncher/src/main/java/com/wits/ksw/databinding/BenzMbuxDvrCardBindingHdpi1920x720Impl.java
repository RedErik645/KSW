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

public class BenzMbuxDvrCardBindingHdpi1920x720Impl extends BenzMbuxDvrCardBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback398;
    private final View.OnClickListener mCallback399;
    private final View.OnClickListener mCallback400;
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

    public BenzMbuxDvrCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private BenzMbuxDvrCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
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
        this.mCallback398 = new OnClickListener(this, 1);
        this.mCallback400 = new OnClickListener(this, 3);
        this.mCallback399 = new OnClickListener(this, 2);
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

    @Override // com.wits.ksw.databinding.BenzMbuxDvrCardBinding
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
        Drawable viewModelItemIconClassicalBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeDvrSelector1BenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeDvrSelector2 = null;
        ObservableBoolean viewModelItemIconClassical = null;
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
            viewModelItemIconClassicalBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeDvrSelector1BenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeDvrSelector2 = AppCompatResources.getDrawable(this.benzMbuxLocalCardBg.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_home_dvr_selector1 : R.drawable.benz_mbux_2021_ksw_home_dvr_selector2);
        }
        if ((7 & dirtyFlags) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.benzMbuxLocalCardBg, viewModelItemIconClassicalBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeDvrSelector1BenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeDvrSelector2);
        }
        if ((4 & dirtyFlags) != 0) {
            this.benzMbuxLocalCardBg.setOnClickListener(this.mCallback398);
            this.mboundView2.setOnClickListener(this.mCallback399);
            this.mboundView3.setOnClickListener(this.mCallback400);
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
                    viewModel.openDvr(callbackArg_0);
                    return;
                }
                return;
            case 2:
                BcVieModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.openDvr(callbackArg_0);
                    return;
                }
                return;
            case 3:
                BcVieModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.openDvr(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
