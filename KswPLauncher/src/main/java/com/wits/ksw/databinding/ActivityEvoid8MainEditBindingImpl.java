package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ActivityEvoid8MainEditBindingImpl extends ActivityEvoid8MainEditBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.id8_ug_top, 1);
        sparseIntArray.put(R.id.scrollView, 2);
        sparseIntArray.put(R.id.ll_container, 3);
        sparseIntArray.put(R.id.fl_content1, 4);
        sparseIntArray.put(R.id.fl_content2, 5);
        sparseIntArray.put(R.id.fl_content3, 6);
        sparseIntArray.put(R.id.fl_content4, 7);
        sparseIntArray.put(R.id.fl_content5, 8);
        sparseIntArray.put(R.id.fl_content6, 9);
        sparseIntArray.put(R.id.fl_content7, 10);
        sparseIntArray.put(R.id.fl_content8, 11);
    }

    public ActivityEvoid8MainEditBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private ActivityEvoid8MainEditBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (FrameLayout) bindings[4], (FrameLayout) bindings[5], (FrameLayout) bindings[6], (FrameLayout) bindings[7], (FrameLayout) bindings[8], (FrameLayout) bindings[9], (FrameLayout) bindings[10], (FrameLayout) bindings[11], (ConstraintLayout) bindings[0], (ImageView) bindings[1], (LinearLayout) bindings[3], (HorizontalScrollView) bindings[2]);
        this.mDirtyFlags = -1;
        this.id8UgMain.setTag(null);
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
        if (13 != variableId) {
            return false;
        }
        setLauncherViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityEvoid8MainEditBinding
    public void setLauncherViewModel(LauncherViewModel LauncherViewModel) {
        this.mLauncherViewModel = LauncherViewModel;
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
