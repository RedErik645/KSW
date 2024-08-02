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
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class ActivityBenzMbuxSettingsFactoryLayoutBindingImpl extends ActivityBenzMbuxSettingsFactoryLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_factory_input, 1);
        sparseIntArray.put(R.id.mbux_settings_factory_psw, 2);
        sparseIntArray.put(R.id.mbux_settings_factory_1_btn, 3);
        sparseIntArray.put(R.id.mbux_settings_factory_2_btn, 4);
        sparseIntArray.put(R.id.mbux_settings_factory_3_btn, 5);
        sparseIntArray.put(R.id.mbux_settings_factory_4_btn, 6);
        sparseIntArray.put(R.id.mbux_settings_factory_5_btn, 7);
        sparseIntArray.put(R.id.mbux_settings_factory_6_btn, 8);
        sparseIntArray.put(R.id.mbux_settings_factory_7_btn, 9);
        sparseIntArray.put(R.id.mbux_settings_factory_8_btn, 10);
        sparseIntArray.put(R.id.mbux_settings_factory_9_btn, 11);
        sparseIntArray.put(R.id.mbux_settings_factory_del_btn, 12);
        sparseIntArray.put(R.id.mbux_settings_factory_0_btn, 13);
        sparseIntArray.put(R.id.mbux_settings_factory_enter_btn, 14);
    }

    public ActivityBenzMbuxSettingsFactoryLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private ActivityBenzMbuxSettingsFactoryLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[1], (ImageView) bindings[13], (ImageView) bindings[3], (ImageView) bindings[4], (ImageView) bindings[5], (ImageView) bindings[6], (ImageView) bindings[7], (ImageView) bindings[8], (ImageView) bindings[9], (ImageView) bindings[10], (ImageView) bindings[11], (ImageView) bindings[12], (ImageView) bindings[14], (TextView) bindings[2]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
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
        setViewModel((BenzMbuxSettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityBenzMbuxSettingsFactoryLayoutBinding
    public void setViewModel(BenzMbuxSettingsViewModel ViewModel) {
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
