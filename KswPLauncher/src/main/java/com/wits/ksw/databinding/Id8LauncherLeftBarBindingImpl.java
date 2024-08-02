package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class Id8LauncherLeftBarBindingImpl extends Id8LauncherLeftBarBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback110;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_left_1, 2);
        sparseIntArray.put(R.id.tv_left_1, 3);
        sparseIntArray.put(R.id.ll_left_2, 4);
        sparseIntArray.put(R.id.iv_left_2, 5);
        sparseIntArray.put(R.id.tv_left_2, 6);
        sparseIntArray.put(R.id.ll_left_3, 7);
        sparseIntArray.put(R.id.iv_left_3, 8);
        sparseIntArray.put(R.id.tv_left_3, 9);
        sparseIntArray.put(R.id.ll_left_4, 10);
        sparseIntArray.put(R.id.iv_left_4, 11);
        sparseIntArray.put(R.id.tv_left_4, 12);
    }

    public Id8LauncherLeftBarBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private Id8LauncherLeftBarBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[2], (ImageView) bindings[5], (ImageView) bindings[8], (ImageView) bindings[11], (LinearLayout) bindings[1], (LinearLayout) bindings[4], (LinearLayout) bindings[7], (LinearLayout) bindings[10], (LinearLayout) bindings[0], (TextView) bindings[3], (TextView) bindings[6], (TextView) bindings[9], (TextView) bindings[12]);
        this.mDirtyFlags = -1;
        this.llLeft1.setTag(null);
        this.llLeftBarContainer.setTag(null);
        setRootTag(root);
        this.mCallback110 = new OnClickListener(this, 1);
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
        if (14 != variableId) {
            return false;
        }
        setLeftViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Id8LauncherLeftBarBinding
    public void setLeftViewModel(LauncherViewModel LeftViewModel) {
        this.mLeftViewModel = LeftViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(14);
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
        LauncherViewModel launcherViewModel = this.mLeftViewModel;
        if ((2 & dirtyFlags) != 0) {
            this.llLeft1.setOnClickListener(this.mCallback110);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel leftViewModel = this.mLeftViewModel;
        if (leftViewModel != null) {
            leftViewModel.openApps(callbackArg_0);
        }
    }
}
