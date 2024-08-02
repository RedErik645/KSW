package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class PhoneEditorDataBindingImpl extends PhoneEditorDataBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    public PhoneEditorDataBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }

    private PhoneEditorDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (LinearLayout) bindings[1]);
        this.mDirtyFlags = -1;
        this.layout.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (4 != variableId) {
            return false;
        }
        setBtViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.PhoneEditorDataBinding
    public void setBtViewModel(LauncherViewModel BtViewModel) {
        this.mBtViewModel = BtViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeBtViewModelPhoneConState((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeBtViewModelPhoneConState(ObservableInt BtViewModelPhoneConState, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable btViewModelPhoneConStateInt0LayoutAndroidDrawableId8MainEditIconPhoneUnconnectedLayoutAndroidDrawableId8MainEditIconPhoneConnected = null;
        int btViewModelPhoneConStateGet = 0;
        LauncherViewModel btViewModel = this.mBtViewModel;
        ObservableInt btViewModelPhoneConState = null;
        if ((dirtyFlags & 7) != 0) {
            if (btViewModel != null) {
                btViewModelPhoneConState = btViewModel.phoneConState;
            }
            boolean btViewModelPhoneConStateInt0 = false;
            updateRegistration(0, btViewModelPhoneConState);
            if (btViewModelPhoneConState != null) {
                btViewModelPhoneConStateGet = btViewModelPhoneConState.get();
            }
            if (btViewModelPhoneConStateGet == 0) {
                btViewModelPhoneConStateInt0 = true;
            }
            if ((dirtyFlags & 7) != 0) {
                if (btViewModelPhoneConStateInt0) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            btViewModelPhoneConStateInt0LayoutAndroidDrawableId8MainEditIconPhoneUnconnectedLayoutAndroidDrawableId8MainEditIconPhoneConnected = AppCompatResources.getDrawable(this.layout.getContext(), btViewModelPhoneConStateInt0 ? R.drawable.id8_main_edit_icon_phone_unconnected : R.drawable.id8_main_edit_icon_phone_connected);
        }
        if ((7 & dirtyFlags) != 0) {
            ViewBindingAdapter.setBackground(this.layout, btViewModelPhoneConStateInt0LayoutAndroidDrawableId8MainEditIconPhoneUnconnectedLayoutAndroidDrawableId8MainEditIconPhoneConnected);
        }
    }
}
