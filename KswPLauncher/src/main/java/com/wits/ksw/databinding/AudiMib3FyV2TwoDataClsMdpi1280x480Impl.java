package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;

public class AudiMib3FyV2TwoDataClsMdpi1280x480Impl extends AudiMib3FyV2TwoDataCls {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.dvr_itemview, 1);
        sparseIntArray.put(R.id.dvr_iv, 2);
        sparseIntArray.put(R.id.dvr_tv, 3);
        sparseIntArray.put(R.id.dashboard_itemview, 4);
        sparseIntArray.put(R.id.dashboard_iv, 5);
        sparseIntArray.put(R.id.dashboard_tv, 6);
        sparseIntArray.put(R.id.file_itemview, 7);
        sparseIntArray.put(R.id.file_iv, 8);
        sparseIntArray.put(R.id.file_tv, 9);
        sparseIntArray.put(R.id.browser_itemview, 10);
        sparseIntArray.put(R.id.browser_iv, 11);
        sparseIntArray.put(R.id.browser_tv, 12);
        sparseIntArray.put(R.id.app_itemview, 13);
        sparseIntArray.put(R.id.app_iv, 14);
        sparseIntArray.put(R.id.app_tv, 15);
    }

    public AudiMib3FyV2TwoDataClsMdpi1280x480Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private AudiMib3FyV2TwoDataClsMdpi1280x480Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BenzMbuxItemView) bindings[13], (ImageView) bindings[14], (TextView) bindings[15], (BenzMbuxItemView) bindings[10], (ImageView) bindings[11], (TextView) bindings[12], (BenzMbuxItemView) bindings[4], (ImageView) bindings[5], (TextView) bindings[6], (BenzMbuxItemView) bindings[1], (ImageView) bindings[2], (TextView) bindings[3], (BenzMbuxItemView) bindings[7], (ImageView) bindings[8], (TextView) bindings[9], (LinearLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.fragmentTwoLl.setTag(null);
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
        setViewModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AudiMib3FyV2TwoDataCls
    public void setViewModel(BcVieModel ViewModel) {
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
