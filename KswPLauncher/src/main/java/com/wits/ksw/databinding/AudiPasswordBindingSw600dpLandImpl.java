package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.settings.audi.vm.AudiSettingViewModel;
import com.wits.ksw.settings.audi.widget.DateView;

public class AudiPasswordBindingSw600dpLandImpl extends AudiPasswordBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback442;
    private final View.OnClickListener mCallback443;
    private final View.OnClickListener mCallback444;
    private final View.OnClickListener mCallback445;
    private final View.OnClickListener mCallback446;
    private final View.OnClickListener mCallback447;
    private final View.OnClickListener mCallback448;
    private final View.OnClickListener mCallback449;
    private final View.OnClickListener mCallback450;
    private final View.OnClickListener mCallback451;
    private long mDirtyFlags;
    private OnClickListenerImpl mVmOnDeleteClickAndroidViewViewOnClickListener;
    private OnLongClickListenerImpl mVmOnDeleteLongClickAndroidViewViewOnLongClickListener;
    private final TextView mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.audioViewPager, 13);
        sparseIntArray.put(R.id.audi_key_ok, 14);
        sparseIntArray.put(R.id.bottomFrameLayout, 15);
    }

    public AudiPasswordBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private AudiPasswordBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[3], (ImageView) bindings[4], (ImageView) bindings[5], (ImageView) bindings[6], (ImageView) bindings[7], (ImageView) bindings[8], (ImageView) bindings[9], (ImageView) bindings[10], (ImageView) bindings[11], (ImageView) bindings[12], (ImageView) bindings[2], (ImageView) bindings[14], (GridLayout) bindings[13], (DateView) bindings[15], (ConstraintLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.audiKey0.setTag(null);
        this.audiKey1.setTag(null);
        this.audiKey2.setTag(null);
        this.audiKey3.setTag(null);
        this.audiKey4.setTag(null);
        this.audiKey5.setTag(null);
        this.audiKey6.setTag(null);
        this.audiKey7.setTag(null);
        this.audiKey8.setTag(null);
        this.audiKey9.setTag(null);
        this.audiKeyDelete.setTag(null);
        this.linearLayout4.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        setRootTag(root);
        this.mCallback445 = new OnClickListener(this, 4);
        this.mCallback447 = new OnClickListener(this, 6);
        this.mCallback443 = new OnClickListener(this, 2);
        this.mCallback451 = new OnClickListener(this, 10);
        this.mCallback449 = new OnClickListener(this, 8);
        this.mCallback446 = new OnClickListener(this, 5);
        this.mCallback448 = new OnClickListener(this, 7);
        this.mCallback442 = new OnClickListener(this, 1);
        this.mCallback444 = new OnClickListener(this, 3);
        this.mCallback450 = new OnClickListener(this, 9);
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
        if (37 != variableId) {
            return false;
        }
        setVm((AudiSettingViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AudiPasswordBinding
    public void setVm(AudiSettingViewModel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmKeyBuffer((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmKeyBuffer(ObservableField<String> observableField, int fieldId) {
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
        String vmKeyBufferGet = null;
        AudiSettingViewModel vm = this.mVm;
        View.OnLongClickListener vmOnDeleteLongClickAndroidViewViewOnLongClickListener = null;
        ObservableField<String> vmKeyBuffer = null;
        View.OnClickListener vmOnDeleteClickAndroidViewViewOnClickListener = null;
        if ((dirtyFlags & 7) != 0) {
            if (!((dirtyFlags & 6) == 0 || vm == null)) {
                OnLongClickListenerImpl onLongClickListenerImpl = this.mVmOnDeleteLongClickAndroidViewViewOnLongClickListener;
                if (onLongClickListenerImpl == null) {
                    onLongClickListenerImpl = new OnLongClickListenerImpl();
                    this.mVmOnDeleteLongClickAndroidViewViewOnLongClickListener = onLongClickListenerImpl;
                }
                vmOnDeleteLongClickAndroidViewViewOnLongClickListener = onLongClickListenerImpl.setValue(vm);
                OnClickListenerImpl onClickListenerImpl = this.mVmOnDeleteClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mVmOnDeleteClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                vmOnDeleteClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(vm);
            }
            if (vm != null) {
                vmKeyBuffer = vm.keyBuffer;
            }
            updateRegistration(0, vmKeyBuffer);
            if (vmKeyBuffer != null) {
                vmKeyBufferGet = vmKeyBuffer.get();
            }
        }
        if ((4 & dirtyFlags) != 0) {
            this.audiKey0.setOnClickListener(this.mCallback442);
            this.audiKey1.setOnClickListener(this.mCallback443);
            this.audiKey2.setOnClickListener(this.mCallback444);
            this.audiKey3.setOnClickListener(this.mCallback445);
            this.audiKey4.setOnClickListener(this.mCallback446);
            this.audiKey5.setOnClickListener(this.mCallback447);
            this.audiKey6.setOnClickListener(this.mCallback448);
            this.audiKey7.setOnClickListener(this.mCallback449);
            this.audiKey8.setOnClickListener(this.mCallback450);
            this.audiKey9.setOnClickListener(this.mCallback451);
        }
        if ((dirtyFlags & 6) != 0) {
            this.audiKeyDelete.setOnClickListener(vmOnDeleteClickAndroidViewViewOnClickListener);
            this.audiKeyDelete.setOnLongClickListener(vmOnDeleteLongClickAndroidViewViewOnLongClickListener);
        }
        if ((7 & dirtyFlags) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, vmKeyBufferGet);
        }
    }

    public static class OnLongClickListenerImpl implements View.OnLongClickListener {
        private AudiSettingViewModel value;

        public OnLongClickListenerImpl setValue(AudiSettingViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public boolean onLongClick(View arg0) {
            return this.value.onDeleteLongClick(arg0);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private AudiSettingViewModel value;

        public OnClickListenerImpl setValue(AudiSettingViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onDeleteClick(arg0);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean vmJavaLangObjectNull = true;
        boolean vmJavaLangObjectNull2 = false;
        switch (sourceId) {
            case 1:
                AudiSettingViewModel vm = this.mVm;
                if (vm == null) {
                    vmJavaLangObjectNull = false;
                }
                if (vmJavaLangObjectNull) {
                    vm.onKeyClick(callbackArg_0, 0);
                    return;
                }
                return;
            case 2:
                AudiSettingViewModel vm2 = this.mVm;
                if (vm2 != null) {
                    vmJavaLangObjectNull2 = true;
                }
                if (vmJavaLangObjectNull2) {
                    vm2.onKeyClick(callbackArg_0, 1);
                    return;
                }
                return;
            case 3:
                AudiSettingViewModel vm3 = this.mVm;
                if (vm3 == null) {
                    vmJavaLangObjectNull = false;
                }
                if (vmJavaLangObjectNull) {
                    vm3.onKeyClick(callbackArg_0, 2);
                    return;
                }
                return;
            case 4:
                AudiSettingViewModel vm4 = this.mVm;
                if (vm4 == null) {
                    vmJavaLangObjectNull = false;
                }
                if (vmJavaLangObjectNull) {
                    vm4.onKeyClick(callbackArg_0, 3);
                    return;
                }
                return;
            case 5:
                AudiSettingViewModel vm5 = this.mVm;
                if (vm5 == null) {
                    vmJavaLangObjectNull = false;
                }
                if (vmJavaLangObjectNull) {
                    vm5.onKeyClick(callbackArg_0, 4);
                    return;
                }
                return;
            case 6:
                AudiSettingViewModel vm6 = this.mVm;
                if (vm6 == null) {
                    vmJavaLangObjectNull = false;
                }
                if (vmJavaLangObjectNull) {
                    vm6.onKeyClick(callbackArg_0, 5);
                    return;
                }
                return;
            case 7:
                AudiSettingViewModel vm7 = this.mVm;
                if (vm7 == null) {
                    vmJavaLangObjectNull = false;
                }
                if (vmJavaLangObjectNull) {
                    vm7.onKeyClick(callbackArg_0, 6);
                    return;
                }
                return;
            case 8:
                AudiSettingViewModel vm8 = this.mVm;
                if (vm8 == null) {
                    vmJavaLangObjectNull = false;
                }
                if (vmJavaLangObjectNull) {
                    vm8.onKeyClick(callbackArg_0, 7);
                    return;
                }
                return;
            case 9:
                AudiSettingViewModel vm9 = this.mVm;
                if (vm9 == null) {
                    vmJavaLangObjectNull = false;
                }
                if (vmJavaLangObjectNull) {
                    vm9.onKeyClick(callbackArg_0, 8);
                    return;
                }
                return;
            case 10:
                AudiSettingViewModel vm10 = this.mVm;
                if (vm10 == null) {
                    vmJavaLangObjectNull = false;
                }
                if (vmJavaLangObjectNull) {
                    vm10.onKeyClick(callbackArg_0, 9);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
