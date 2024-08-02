package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ID6CuspFragmentTowImpl extends ID6CuspFragmentTow {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.id6_cusp_video_iamge_view, 1);
        sparseIntArray.put(R.id.id6_cusp_video_mess, 2);
        sparseIntArray.put(R.id.id6_cusp_car_image_view, 3);
        sparseIntArray.put(R.id.id6_cusp_car_text_view, 4);
        sparseIntArray.put(R.id.id6_cusp_car_mess, 5);
        sparseIntArray.put(R.id.id6_cusp_browser_image_view, 6);
        sparseIntArray.put(R.id.id6_cusp_browser_text_view, 7);
        sparseIntArray.put(R.id.id6_cusp_browser_mess, 8);
    }

    public ID6CuspFragmentTowImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private ID6CuspFragmentTowImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[6], (TextView) bindings[8], (TextView) bindings[7], (ImageView) bindings[3], (TextView) bindings[5], (TextView) bindings[4], (ImageView) bindings[1], (TextView) bindings[2]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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

    @Override // com.wits.ksw.databinding.ID6CuspFragmentTow
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
