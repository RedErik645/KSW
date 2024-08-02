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
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class ActivityBmwId9SettingsFactoryLayoutBindingImpl extends ActivityBmwId9SettingsFactoryLayoutBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback581;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id9_factory_input, 2);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_psw, 3);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_1_btn, 4);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_2_btn, 5);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_3_btn, 6);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_del_btn, 7);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_4_btn, 8);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_5_btn, 9);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_6_btn, 10);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_enter_btn, 11);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_7_btn, 12);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_8_btn, 13);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_9_btn, 14);
        sparseIntArray.put(R.id.bmw_id9_settings_factory_0_btn, 15);
    }

    public ActivityBmwId9SettingsFactoryLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private ActivityBmwId9SettingsFactoryLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (LinearLayout) bindings[2], (ImageView) bindings[15], (ImageView) bindings[4], (ImageView) bindings[5], (ImageView) bindings[6], (ImageView) bindings[8], (ImageView) bindings[9], (ImageView) bindings[10], (ImageView) bindings[12], (ImageView) bindings[13], (ImageView) bindings[14], (ImageView) bindings[7], (ImageView) bindings[11], (TextView) bindings[3]);
        this.mDirtyFlags = -1;
        this.bmwId8SettingsHomeback.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        this.mCallback581 = new OnClickListener(this, 1);
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
        setViewModel((BmwId9SettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityBmwId9SettingsFactoryLayoutBinding
    public void setViewModel(BmwId9SettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        BmwId9SettingsViewModel bmwId9SettingsViewModel = this.mViewModel;
        if ((2 & dirtyFlags) != 0) {
            this.bmwId8SettingsHomeback.setOnClickListener(this.mCallback581);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        if (viewModel != null) {
            viewModel.backClick();
        }
    }
}
