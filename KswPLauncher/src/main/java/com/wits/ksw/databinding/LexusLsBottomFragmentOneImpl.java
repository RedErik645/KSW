package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class LexusLsBottomFragmentOneImpl extends LexusLsBottomFragmentOne {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_lexus_ls_navi, 1);
        sparseIntArray.put(R.id.iv_lexus_ls_music, 2);
        sparseIntArray.put(R.id.iv_lexus_ls_bt, 3);
        sparseIntArray.put(R.id.iv_lexus_ls_app, 4);
        sparseIntArray.put(R.id.iv_lexus_ls_video, 5);
        sparseIntArray.put(R.id.iv_lexus_ls_car, 6);
        sparseIntArray.put(R.id.iv_lexus_ls_set, 7);
        sparseIntArray.put(R.id.iv_lexus_ls_air, 8);
    }

    public LexusLsBottomFragmentOneImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private LexusLsBottomFragmentOneImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[8], (ImageView) bindings[4], (ImageView) bindings[3], (ImageView) bindings[6], (ImageView) bindings[2], (ImageView) bindings[1], (ImageView) bindings[7], (ImageView) bindings[5], (LinearLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.lexusLsLlBottomFragOne.setTag(null);
        setRootTag(root);
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
        if (36 != variableId) {
            return false;
        }
        setViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.LexusLsBottomFragmentOne
    public void setViewModel(LauncherViewModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
