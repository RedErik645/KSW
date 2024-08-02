package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3AppEditViewModel;

public class ActivityNtg6v3AppEditMainBindingImpl extends ActivityNtg6v3AppEditMainBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback55;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_left_1, 2);
        sparseIntArray.put(R.id.iv_left_1, 3);
        sparseIntArray.put(R.id.ntg_fy_v3_popwindow_bg, 4);
        sparseIntArray.put(R.id.rv_list, 5);
    }

    public ActivityNtg6v3AppEditMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private ActivityNtg6v3AppEditMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[3], (LinearLayout) bindings[2], (LinearLayout) bindings[1], (RelativeLayout) bindings[0], (RelativeLayout) bindings[4], (RecyclerView) bindings[5]);
        this.mDirtyFlags = -1;
        this.llLeftBarContainer.setTag(null);
        this.ntg6v3ChangeThemeMainBg.setTag(null);
        setRootTag(root);
        this.mCallback55 = new OnClickListener(this, 1);
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
        if (1 != variableId) {
            return false;
        }
        setAppEditViewModel((Ntg6v3AppEditViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityNtg6v3AppEditMainBinding
    public void setAppEditViewModel(Ntg6v3AppEditViewModel AppEditViewModel) {
        this.mAppEditViewModel = AppEditViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
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
        Ntg6v3AppEditViewModel ntg6v3AppEditViewModel = this.mAppEditViewModel;
        if ((2 & dirtyFlags) != 0) {
            this.llLeftBarContainer.setOnClickListener(this.mCallback55);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        Ntg6v3AppEditViewModel appEditViewModel = this.mAppEditViewModel;
        if (appEditViewModel != null) {
            appEditViewModel.changeList();
        }
    }
}
