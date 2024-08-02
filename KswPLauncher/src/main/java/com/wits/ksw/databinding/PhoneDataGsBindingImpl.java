package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class PhoneDataGsBindingImpl extends PhoneDataGsBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback299;
    private long mDirtyFlags;

    public PhoneDataGsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }

    private PhoneDataGsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (RelativeLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.ivMask.setTag(null);
        this.llContainerGs.setTag(null);
        setRootTag(root);
        this.mCallback299 = new OnClickListener(this, 1);
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
        if (4 != variableId) {
            return false;
        }
        setBtViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.PhoneDataGsBinding
    public void setBtViewModel(LauncherViewModel BtViewModel) {
        this.mBtViewModel = BtViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(4);
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
        LauncherViewModel btViewModel = this.mBtViewModel;
        View.OnFocusChangeListener btViewModelPhoneViewFocusChangeListener = null;
        if (!((dirtyFlags & 3) == 0 || btViewModel == null)) {
            btViewModelPhoneViewFocusChangeListener = btViewModel.phoneViewFocusChangeListener;
        }
        if ((2 & dirtyFlags) != 0) {
            this.ivMask.setOnClickListener(this.mCallback299);
        }
        if ((3 & dirtyFlags) != 0) {
            this.ivMask.setOnFocusChangeListener(btViewModelPhoneViewFocusChangeListener);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel btViewModel = this.mBtViewModel;
        if (btViewModel != null) {
            btViewModel.openBtApp(callbackArg_0);
        }
    }
}
