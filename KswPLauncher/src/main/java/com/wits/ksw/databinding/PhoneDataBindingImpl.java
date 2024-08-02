package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.databinding.adapters.ViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class PhoneDataBindingImpl extends PhoneDataBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback224;
    private long mDirtyFlags;
    private final ImageView mboundView2;

    public PhoneDataBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    private PhoneDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (ImageView) bindings[1], (RelativeLayout) bindings[0], (TextView) bindings[3]);
        this.mDirtyFlags = -1;
        this.ivMask.setTag(null);
        this.llContainer.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        this.tvDesc.setTag(null);
        setRootTag(root);
        this.mCallback224 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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

    @Override // com.wits.ksw.databinding.PhoneDataBinding
    public void setBtViewModel(LauncherViewModel BtViewModel) {
        this.mBtViewModel = BtViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeBtViewModelBtState((ObservableField) object, fieldId);
            case 1:
                return onChangeBtViewModelPhoneConState((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeBtViewModelBtState(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeBtViewModelPhoneConState(ObservableInt BtViewModelPhoneConState, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
        String btViewModelBtStateGet = null;
        int btViewModelPhoneConStateGet = 0;
        LauncherViewModel btViewModel = this.mBtViewModel;
        ObservableField<String> btViewModelBtState = null;
        ObservableInt btViewModelPhoneConState = null;
        View.OnFocusChangeListener btViewModelPhoneViewFocusChangeListener = null;
        Drawable btViewModelPhoneConStateInt0MboundView2AndroidDrawableId8MainIconPhoneUnconnectedMboundView2AndroidDrawableId8MainIconPhoneConnected = null;
        if ((15 & dirtyFlags) != 0) {
            boolean btViewModelPhoneConStateInt0 = false;
            if ((dirtyFlags & 13) != 0) {
                if (btViewModel != null) {
                    btViewModelBtState = btViewModel.btState;
                }
                updateRegistration(0, btViewModelBtState);
                if (btViewModelBtState != null) {
                    btViewModelBtStateGet = btViewModelBtState.get();
                }
            }
            if ((dirtyFlags & 14) != 0) {
                if (btViewModel != null) {
                    btViewModelPhoneConState = btViewModel.phoneConState;
                }
                updateRegistration(1, btViewModelPhoneConState);
                if (btViewModelPhoneConState != null) {
                    btViewModelPhoneConStateGet = btViewModelPhoneConState.get();
                }
                if (btViewModelPhoneConStateGet == 0) {
                    btViewModelPhoneConStateInt0 = true;
                }
                if ((dirtyFlags & 14) != 0) {
                    if (btViewModelPhoneConStateInt0) {
                        dirtyFlags |= 32;
                    } else {
                        dirtyFlags |= 16;
                    }
                }
                btViewModelPhoneConStateInt0MboundView2AndroidDrawableId8MainIconPhoneUnconnectedMboundView2AndroidDrawableId8MainIconPhoneConnected = AppCompatResources.getDrawable(this.mboundView2.getContext(), btViewModelPhoneConStateInt0 ? R.drawable.id8_main_icon_phone_unconnected : R.drawable.id8_main_icon_phone_connected);
            }
            if (!((dirtyFlags & 12) == 0 || btViewModel == null)) {
                btViewModelPhoneViewFocusChangeListener = btViewModel.phoneViewFocusChangeListener;
            }
        }
        if ((8 & dirtyFlags) != 0) {
            this.ivMask.setOnClickListener(this.mCallback224);
        }
        if ((12 & dirtyFlags) != 0) {
            this.ivMask.setOnFocusChangeListener(btViewModelPhoneViewFocusChangeListener);
        }
        if ((dirtyFlags & 14) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView2, btViewModelPhoneConStateInt0MboundView2AndroidDrawableId8MainIconPhoneUnconnectedMboundView2AndroidDrawableId8MainIconPhoneConnected);
        }
        if ((dirtyFlags & 13) != 0) {
            TextViewBindingAdapter.setText(this.tvDesc, btViewModelBtStateGet);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel btViewModel = this.mBtViewModel;
        if (btViewModel != null) {
            btViewModel.openBtApp(callbackArg_0);
        }
    }
}
