package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ViewId9AlsBtBindingImpl extends ViewId9AlsBtBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.id9_bt_input_iv, 3);
        sparseIntArray.put(R.id.id9_home_video_title_tv, 4);
    }

    public ViewId9AlsBtBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private ViewId9AlsBtBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (ImageView) bindings[2], (ImageView) bindings[3], (TextView) bindings[1], (ConstraintLayout) bindings[0], (TextView) bindings[4]);
        this.mDirtyFlags = -1;
        this.id9BtIcon.setTag(null);
        this.id9BtStatusTv.setTag(null);
        this.id9CardView.setTag(null);
        setRootTag(root);
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
        if (12 != variableId) {
            return false;
        }
        setId9ViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ViewId9AlsBtBinding
    public void setId9ViewModel(LauncherViewModel Id9ViewModel) {
        this.mId9ViewModel = Id9ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeId9ViewModelBtState((ObservableField) object, fieldId);
            case 1:
                return onChangeId9ViewModelBtStateBoolean((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeId9ViewModelBtState(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeId9ViewModelBtStateBoolean(ObservableField<Boolean> observableField, int fieldId) {
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
        Drawable id9ViewModelBtStateBooleanId9BtIconAndroidDrawableId9BluetoothPicId9BtIconAndroidDrawableId9BluetoothPicNot = null;
        ObservableField<String> id9ViewModelBtState = null;
        String id9ViewModelBtStateGet = null;
        LauncherViewModel id9ViewModel = this.mId9ViewModel;
        ObservableField<Boolean> id9ViewModelBtStateBoolean = null;
        Boolean id9ViewModelBtStateBooleanGet = null;
        if ((15 & dirtyFlags) != 0) {
            if ((dirtyFlags & 13) != 0) {
                if (id9ViewModel != null) {
                    id9ViewModelBtState = id9ViewModel.btState;
                }
                updateRegistration(0, id9ViewModelBtState);
                if (id9ViewModelBtState != null) {
                    id9ViewModelBtStateGet = id9ViewModelBtState.get();
                }
            }
            if ((dirtyFlags & 14) != 0) {
                if (id9ViewModel != null) {
                    id9ViewModelBtStateBoolean = id9ViewModel.btStateBoolean;
                }
                updateRegistration(1, id9ViewModelBtStateBoolean);
                if (id9ViewModelBtStateBoolean != null) {
                    id9ViewModelBtStateBooleanGet = id9ViewModelBtStateBoolean.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxId9ViewModelBtStateBooleanGet = ViewDataBinding.safeUnbox(id9ViewModelBtStateBooleanGet);
                if ((dirtyFlags & 14) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxId9ViewModelBtStateBooleanGet) {
                        dirtyFlags |= 32;
                    } else {
                        dirtyFlags |= 16;
                    }
                }
                id9ViewModelBtStateBooleanId9BtIconAndroidDrawableId9BluetoothPicId9BtIconAndroidDrawableId9BluetoothPicNot = AppCompatResources.getDrawable(this.id9BtIcon.getContext(), androidDatabindingViewDataBindingSafeUnboxId9ViewModelBtStateBooleanGet ? R.drawable.id9_bluetooth_pic : R.drawable.id9_bluetooth_pic_not);
            }
        }
        if ((dirtyFlags & 14) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.id9BtIcon, id9ViewModelBtStateBooleanId9BtIconAndroidDrawableId9BluetoothPicId9BtIconAndroidDrawableId9BluetoothPicNot);
        }
        if ((13 & dirtyFlags) != 0) {
            TextViewBindingAdapter.setText(this.id9BtStatusTv, id9ViewModelBtStateGet);
        }
    }
}
