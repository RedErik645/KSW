package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.BcVieModel;

public class BenzNtgFyVideoCardBindingHdpi1920x720Impl extends BenzNtgFyVideoCardBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback439;
    private final View.OnClickListener mCallback440;
    private final View.OnClickListener mCallback441;
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

    public BenzNtgFyVideoCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private BenzNtgFyVideoCardBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatImageView) bindings[1], (AppCompatTextView) bindings[5], (AppCompatTextView) bindings[4]);
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
        this.mCallback441 = new OnClickListener(this, 3);
        this.mCallback440 = new OnClickListener(this, 2);
        this.mCallback439 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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

    @Override // com.wits.ksw.databinding.BenzNtgFyVideoCardBinding
    public void setViewModel(BcVieModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        BcVieModel bcVieModel = this.mViewModel;
        if ((2 & dirtyFlags) != 0) {
            this.benzMbuxLocalCardBg.setOnClickListener(this.mCallback439);
            this.mboundView2.setOnClickListener(this.mCallback440);
            this.mboundView3.setOnClickListener(this.mCallback441);
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
                    viewModel.openVideoMulti(callbackArg_0);
                    return;
                }
                return;
            case 2:
                BcVieModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.openVideoMulti(callbackArg_0);
                    return;
                }
                return;
            case 3:
                BcVieModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.openVideoMulti(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
