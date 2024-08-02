package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;

public class BenzNtg6FyFragmentTwoClsV21024x600Impl extends BenzNtg6FyFragmentTwoClsV2 {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.set_rl, 1);
        sparseIntArray.put(R.id.set_itemview, 2);
        sparseIntArray.put(R.id.set_tv, 3);
        sparseIntArray.put(R.id.set_tip, 4);
        sparseIntArray.put(R.id.set_iv1, 5);
        sparseIntArray.put(R.id.space1, 6);
        sparseIntArray.put(R.id.set_iv2, 7);
        sparseIntArray.put(R.id.video_rl, 8);
        sparseIntArray.put(R.id.video_itemview, 9);
        sparseIntArray.put(R.id.video_tv, 10);
        sparseIntArray.put(R.id.video_tip, 11);
        sparseIntArray.put(R.id.video_iv1, 12);
        sparseIntArray.put(R.id.space2, 13);
        sparseIntArray.put(R.id.video_iv2, 14);
        sparseIntArray.put(R.id.app_rl, 15);
        sparseIntArray.put(R.id.app_itemview, 16);
        sparseIntArray.put(R.id.app_tv, 17);
        sparseIntArray.put(R.id.app_tip, 18);
        sparseIntArray.put(R.id.app_iv1, 19);
        sparseIntArray.put(R.id.space3, 20);
        sparseIntArray.put(R.id.app_iv2, 21);
        sparseIntArray.put(R.id.phonelink_rl, 22);
        sparseIntArray.put(R.id.phonelink_itemview, 23);
        sparseIntArray.put(R.id.phonelink_tv, 24);
        sparseIntArray.put(R.id.phonelink_tip, 25);
        sparseIntArray.put(R.id.phonelink_iv1, 26);
        sparseIntArray.put(R.id.space4, 27);
        sparseIntArray.put(R.id.phonelink_iv2, 28);
        sparseIntArray.put(R.id.dashboard_rl, 29);
        sparseIntArray.put(R.id.dashboard_itemview, 30);
        sparseIntArray.put(R.id.dashboard_tv, 31);
        sparseIntArray.put(R.id.dashboard_tip, 32);
        sparseIntArray.put(R.id.dashboard_iv1, 33);
        sparseIntArray.put(R.id.space5, 34);
        sparseIntArray.put(R.id.dashboard_iv2, 35);
    }

    public BenzNtg6FyFragmentTwoClsV21024x600Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 36, sIncludes, sViewsWithIds));
    }

    private BenzNtg6FyFragmentTwoClsV21024x600Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BenzMbuxItemView) bindings[16], (ImageView) bindings[19], (ImageView) bindings[21], (RelativeLayout) bindings[15], (TextView) bindings[18], (TextView) bindings[17], (BenzMbuxItemView) bindings[30], (ImageView) bindings[33], (ImageView) bindings[35], (RelativeLayout) bindings[29], (TextView) bindings[32], (TextView) bindings[31], (LinearLayout) bindings[0], (BenzMbuxItemView) bindings[23], (ImageView) bindings[26], (ImageView) bindings[28], (RelativeLayout) bindings[22], (TextView) bindings[25], (View) bindings[24], (BenzMbuxItemView) bindings[2], (ImageView) bindings[5], (ImageView) bindings[7], (RelativeLayout) bindings[1], (TextView) bindings[4], (TextView) bindings[3], (View) bindings[6], (View) bindings[13], (View) bindings[20], (View) bindings[27], (View) bindings[34], (BenzMbuxItemView) bindings[9], (ImageView) bindings[12], (ImageView) bindings[14], (RelativeLayout) bindings[8], (TextView) bindings[11], (TextView) bindings[10]);
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

    @Override // com.wits.ksw.databinding.BenzNtg6FyFragmentTwoClsV2
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
