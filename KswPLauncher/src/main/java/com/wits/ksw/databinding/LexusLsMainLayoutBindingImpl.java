package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class LexusLsMainLayoutBindingImpl extends LexusLsMainLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lexus_ls_recycleview_desktop, 1);
        sparseIntArray.put(R.id.iv_lexus_ls_bg_app_layerlist, 2);
        sparseIntArray.put(R.id.iv_lexusls_left_btn, 3);
        sparseIntArray.put(R.id.lexus_ls_viewpager_bottom, 4);
        sparseIntArray.put(R.id.iv_lexusls_right_btn, 5);
    }

    public LexusLsMainLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private LexusLsMainLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[2], (ImageView) bindings[3], (ImageView) bindings[5], (RelativeLayout) bindings[0], (RecyclerView) bindings[1], (ViewPager) bindings[4]);
        this.mDirtyFlags = -1;
        this.lexusLsMainLl.setTag(null);
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
        if (15 != variableId) {
            return false;
        }
        setLexusLsViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.LexusLsMainLayoutBinding
    public void setLexusLsViewModel(LauncherViewModel LexusLsViewModel) {
        this.mLexusLsViewModel = LexusLsViewModel;
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
