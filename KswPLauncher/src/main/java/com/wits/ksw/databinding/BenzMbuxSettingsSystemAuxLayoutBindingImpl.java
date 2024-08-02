package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class BenzMbuxSettingsSystemAuxLayoutBindingImpl extends BenzMbuxSettingsSystemAuxLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_settings_aux_lay, 1);
        sparseIntArray.put(R.id.mbux_settings_aux1_text_name, 2);
        sparseIntArray.put(R.id.mbux_settings_aux1_text_value, 3);
        sparseIntArray.put(R.id.mbux_settings_aux1_sub_btn, 4);
        sparseIntArray.put(R.id.mbux_settings_aux1_seekbar, 5);
        sparseIntArray.put(R.id.mbux_settings_aux1_add_btn, 6);
        sparseIntArray.put(R.id.mbux_settings_aux2_text_name, 7);
        sparseIntArray.put(R.id.mbux_settings_aux2_text_value, 8);
        sparseIntArray.put(R.id.mbux_settings_aux2_sub_btn, 9);
        sparseIntArray.put(R.id.mbux_settings_aux2_seekbar, 10);
        sparseIntArray.put(R.id.mbux_settings_aux2_add_btn, 11);
    }

    public BenzMbuxSettingsSystemAuxLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private BenzMbuxSettingsSystemAuxLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageButton) bindings[6], (BenzMbuxProgressBar) bindings[5], (ImageButton) bindings[4], (TextView) bindings[2], (TextView) bindings[3], (ImageButton) bindings[11], (BenzMbuxProgressBar) bindings[10], (ImageButton) bindings[9], (TextView) bindings[7], (TextView) bindings[8], (LinearLayout) bindings[1]);
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

    @Override // com.wits.ksw.databinding.BenzMbuxSettingsSystemAuxLayoutBinding
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
