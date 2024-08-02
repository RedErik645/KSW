package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
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

public class BenzMbuxBtCardBindingHdpi1920x720Impl extends BenzMbuxBtCardBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback387;
    private final View.OnClickListener mCallback388;
    private final View.OnClickListener mCallback389;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final AppCompatImageView mboundView3;
    private final AppCompatImageView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.benz_mbux_local_card_title, 5);
    }

    public BenzMbuxBtCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private BenzMbuxBtCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (AppCompatImageView) bindings[1], (AppCompatTextView) bindings[2], (AppCompatTextView) bindings[5]);
        this.mDirtyFlags = -1;
        this.benzMbuxLocalCardBg.setTag(null);
        this.benzMbuxLocalCardContent.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) bindings[3];
        this.mboundView3 = appCompatImageView;
        appCompatImageView.setTag(null);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) bindings[4];
        this.mboundView4 = appCompatImageView2;
        appCompatImageView2.setTag(null);
        setRootTag(root);
        this.mCallback387 = new OnClickListener(this, 1);
        this.mCallback389 = new OnClickListener(this, 3);
        this.mCallback388 = new OnClickListener(this, 2);
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
        if (25 != variableId) {
            return false;
        }
        setViewModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BenzMbuxBtCardBinding
    public void setViewModel(BcVieModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelBtState((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelItemIconClassical((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelBtState(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelItemIconClassical(ObservableBoolean ViewModelItemIconClassical, int fieldId) {
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
        Drawable viewModelItemIconClassicalBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeBtSelector1BenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeBtSelector2 = null;
        BcVieModel viewModel = this.mViewModel;
        ObservableField<String> viewModelBtState = null;
        ObservableBoolean viewModelItemIconClassical = null;
        String viewModelBtStateGet = null;
        boolean viewModelItemIconClassicalGet = false;
        if ((15 & dirtyFlags) != 0) {
            if ((dirtyFlags & 13) != 0) {
                if (viewModel != null) {
                    viewModelBtState = viewModel.btState;
                }
                updateRegistration(0, viewModelBtState);
                if (viewModelBtState != null) {
                    viewModelBtStateGet = viewModelBtState.get();
                }
            }
            if ((dirtyFlags & 14) != 0) {
                if (viewModel != null) {
                    viewModelItemIconClassical = viewModel.itemIconClassical;
                }
                updateRegistration(1, viewModelItemIconClassical);
                if (viewModelItemIconClassical != null) {
                    viewModelItemIconClassicalGet = viewModelItemIconClassical.get();
                }
                if ((dirtyFlags & 14) != 0) {
                    if (viewModelItemIconClassicalGet) {
                        dirtyFlags |= 32;
                    } else {
                        dirtyFlags |= 16;
                    }
                }
                viewModelItemIconClassicalBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeBtSelector1BenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeBtSelector2 = AppCompatResources.getDrawable(this.benzMbuxLocalCardBg.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_home_bt_selector1 : R.drawable.benz_mbux_2021_ksw_home_bt_selector2);
            }
        }
        if ((dirtyFlags & 14) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.benzMbuxLocalCardBg, viewModelItemIconClassicalBenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeBtSelector1BenzMbuxLocalCardBgAndroidDrawableBenzMbux2021KswHomeBtSelector2);
        }
        if ((8 & dirtyFlags) != 0) {
            this.benzMbuxLocalCardBg.setOnClickListener(this.mCallback387);
            this.mboundView3.setOnClickListener(this.mCallback388);
            this.mboundView4.setOnClickListener(this.mCallback389);
        }
        if ((13 & dirtyFlags) != 0) {
            TextViewBindingAdapter.setText(this.benzMbuxLocalCardContent, viewModelBtStateGet);
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
                    viewModel.openBtApp();
                    return;
                }
                return;
            case 2:
                BcVieModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.openBtApp();
                    return;
                }
                return;
            case 3:
                BcVieModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.openBtApp();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
