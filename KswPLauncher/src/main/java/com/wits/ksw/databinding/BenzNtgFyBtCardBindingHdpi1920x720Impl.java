package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.BcVieModel;

public class BenzNtgFyBtCardBindingHdpi1920x720Impl extends BenzNtgFyBtCardBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback48;
    private final View.OnClickListener mCallback49;
    private final View.OnClickListener mCallback50;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final AppCompatImageView mboundView3;
    private final AppCompatImageView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.benz_mbux_local_card_title, 5);
    }

    public BenzNtgFyBtCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private BenzNtgFyBtCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (AppCompatImageView) bindings[1], (AppCompatTextView) bindings[2], (AppCompatTextView) bindings[5]);
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
        this.mCallback49 = new OnClickListener(this, 2);
        this.mCallback48 = new OnClickListener(this, 1);
        this.mCallback50 = new OnClickListener(this, 3);
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

    @Override // com.wits.ksw.databinding.BenzNtgFyBtCardBinding
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
                return onChangeViewModelBtState((ObservableField) object, fieldId);
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

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        BcVieModel viewModel = this.mViewModel;
        String viewModelBtStateGet = null;
        ObservableField<String> viewModelBtState = null;
        if ((dirtyFlags & 7) != 0) {
            if (viewModel != null) {
                viewModelBtState = viewModel.btState;
            }
            updateRegistration(0, viewModelBtState);
            if (viewModelBtState != null) {
                viewModelBtStateGet = viewModelBtState.get();
            }
        }
        if ((4 & dirtyFlags) != 0) {
            this.benzMbuxLocalCardBg.setOnClickListener(this.mCallback48);
            this.mboundView3.setOnClickListener(this.mCallback49);
            this.mboundView4.setOnClickListener(this.mCallback50);
        }
        if ((7 & dirtyFlags) != 0) {
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
