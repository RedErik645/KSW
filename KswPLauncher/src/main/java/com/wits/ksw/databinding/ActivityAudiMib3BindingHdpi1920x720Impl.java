package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.audi.widget.AudiConstraintLayout;

public class ActivityAudiMib3BindingHdpi1920x720Impl extends ActivityAudiMib3Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.audiHomeParentPanel, 1);
        sparseIntArray.put(R.id.au_set_sys_item, 2);
        sparseIntArray.put(R.id.au_set_navi_item, 3);
        sparseIntArray.put(R.id.au_set_sound_item, 4);
        sparseIntArray.put(R.id.au_set_eq_item, 5);
        sparseIntArray.put(R.id.au_set_lag_item, 6);
        sparseIntArray.put(R.id.au_set_time_item, 7);
        sparseIntArray.put(R.id.au_set_sysinfo_item, 8);
        sparseIntArray.put(R.id.au_set_more_item, 9);
        sparseIntArray.put(R.id.au_set_fac_item, 10);
    }

    public ActivityAudiMib3BindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private ActivityAudiMib3BindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[5], (TextView) bindings[10], (TextView) bindings[6], (TextView) bindings[9], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[2], (TextView) bindings[8], (TextView) bindings[7], (AudiConstraintLayout) bindings[1]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
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
        return true;
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
