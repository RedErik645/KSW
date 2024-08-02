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

public class AudiMib3OneDataClsImpl extends AudiMib3OneDataCls {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.video_itemview, 1);
        sparseIntArray.put(R.id.video_iv, 2);
        sparseIntArray.put(R.id.video_tv, 3);
        sparseIntArray.put(R.id.music_itemview, 4);
        sparseIntArray.put(R.id.music_iv, 5);
        sparseIntArray.put(R.id.music_tv, 6);
        sparseIntArray.put(R.id.bt_itemview, 7);
        sparseIntArray.put(R.id.bt_iv, 8);
        sparseIntArray.put(R.id.bt_tv, 9);
        sparseIntArray.put(R.id.navi_itemview, 10);
        sparseIntArray.put(R.id.navi_iv, 11);
        sparseIntArray.put(R.id.navi_tv, 12);
        sparseIntArray.put(R.id.phonelink_itemview, 13);
        sparseIntArray.put(R.id.phonelink_iv, 14);
        sparseIntArray.put(R.id.phonelink_tv, 15);
        sparseIntArray.put(R.id.car_itemview, 16);
        sparseIntArray.put(R.id.car_iv, 17);
        sparseIntArray.put(R.id.car_tv, 18);
        sparseIntArray.put(R.id.app_itemview, 19);
        sparseIntArray.put(R.id.app_iv, 20);
        sparseIntArray.put(R.id.app_tv, 21);
        sparseIntArray.put(R.id.set_itemview, 22);
        sparseIntArray.put(R.id.set_iv, 23);
        sparseIntArray.put(R.id.set_tv, 24);
    }

    public AudiMib3OneDataClsImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }

    private AudiMib3OneDataClsImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BenzMbuxItemView) bindings[19], (ImageView) bindings[20], (TextView) bindings[21], (BenzMbuxItemView) bindings[7], (ImageView) bindings[8], (TextView) bindings[9], (BenzMbuxItemView) bindings[16], (ImageView) bindings[17], (TextView) bindings[18], (LinearLayout) bindings[0], (BenzMbuxItemView) bindings[4], (ImageView) bindings[5], (TextView) bindings[6], (BenzMbuxItemView) bindings[10], (ImageView) bindings[11], (TextView) bindings[12], (BenzMbuxItemView) bindings[13], (ImageView) bindings[14], (TextView) bindings[15], (BenzMbuxItemView) bindings[22], (ImageView) bindings[23], (TextView) bindings[24], (BenzMbuxItemView) bindings[1], (ImageView) bindings[2], (TextView) bindings[3]);
        this.mDirtyFlags = -1;
        this.fragmentOneLl.setTag(null);
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

    @Override // com.wits.ksw.databinding.AudiMib3OneDataCls
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
