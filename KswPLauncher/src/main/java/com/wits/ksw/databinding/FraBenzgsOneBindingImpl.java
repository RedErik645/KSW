package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.utils.CustomFontTextView;
import com.wits.ksw.launcher.view.benzgs.BenzGsViewMoel;

public class FraBenzgsOneBindingImpl extends FraBenzgsOneBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.benz_gs_home_navi_hint, 8);
        sparseIntArray.put(R.id.benz_gs_home_navi, 9);
        sparseIntArray.put(R.id.benz_gs_home_music, 10);
        sparseIntArray.put(R.id.benz_gs_home_bt, 11);
        sparseIntArray.put(R.id.benz_gs_home_car_hint, 12);
        sparseIntArray.put(R.id.benz_gs_home_car, 13);
        sparseIntArray.put(R.id.benz_gs_home_set_hint, 14);
        sparseIntArray.put(R.id.benz_gs_home_set, 15);
    }

    public FraBenzgsOneBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private FraBenzgsOneBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (CustomFontTextView) bindings[11], (RelativeLayout) bindings[4], (CustomFontTextView) bindings[5], (CustomFontTextView) bindings[13], (RelativeLayout) bindings[6], (CustomFontTextView) bindings[12], (CustomFontTextView) bindings[10], (RelativeLayout) bindings[2], (CustomFontTextView) bindings[3], (CustomFontTextView) bindings[9], (RelativeLayout) bindings[1], (CustomFontTextView) bindings[8], (CustomFontTextView) bindings[15], (RelativeLayout) bindings[7], (CustomFontTextView) bindings[14], (LinearLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.benzGsHomeBtBtn.setTag(null);
        this.benzGsHomeBtHint.setTag(null);
        this.benzGsHomeCarBtn.setTag(null);
        this.benzGsHomeMusicBtn.setTag(null);
        this.benzGsHomeMusicHint.setTag(null);
        this.benzGsHomeNaviBtn.setTag(null);
        this.benzGsHomeSetBtn.setTag(null);
        this.benzgsHomeOne.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        setVm((BenzGsViewMoel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.FraBenzgsOneBinding
    public void setVm(BenzGsViewMoel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmIndex((ObservableInt) object, fieldId);
            case 1:
                return onChangeVmPhoneConState((ObservableInt) object, fieldId);
            case 2:
                return onChangeVmMediaInfoMusicName((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmIndex(ObservableInt VmIndex, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmPhoneConState(ObservableInt VmPhoneConState, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmMediaInfoMusicName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        boolean vmIndexInt1;
        String vmMediaInfoMusicNameJavaLangObjectNullBenzGsHomeMusicHintAndroidStringBenzGsHomeMusicHintVmMediaInfoMusicName;
        String vmMediaInfoMusicNameJavaLangObjectNullBenzGsHomeMusicHintAndroidStringBenzGsHomeMusicHintVmMediaInfoMusicName2;
        ObservableField<String> vmMediaInfoMusicName;
        int vmIndexGet;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean vmIndexInt2 = false;
        boolean vmIndexInt0 = false;
        String vmPhoneConStateInt0BenzGsHomeBtHintAndroidStringKswId7NotConnectedPhoneBenzGsHomeBtHintAndroidStringKswId7ConnectedPhone = null;
        ObservableInt vmIndex = null;
        String vmMediaInfoMusicNameGet = null;
        BenzGsViewMoel vm = this.mVm;
        int vmPhoneConStateGet = 0;
        ObservableInt vmPhoneConState = null;
        boolean vmIndexInt3 = false;
        boolean vmIndexInt32 = false;
        boolean vmIndexInt12 = false;
        boolean vmMediaInfoMusicNameJavaLangObjectNull = false;
        if ((dirtyFlags & 27) != 0) {
            if ((dirtyFlags & 25) != 0) {
                if (vm != null) {
                    vmIndex = vm.index;
                }
                updateRegistration(0, vmIndex);
                if (vmIndex != null) {
                    vmIndexGet = vmIndex.get();
                } else {
                    vmIndexGet = 0;
                }
                vmIndexInt2 = vmIndexGet == 2;
                boolean vmIndexInt4 = vmIndexGet == 4;
                boolean vmIndexInt02 = vmIndexGet == 0;
                boolean vmIndexInt33 = vmIndexGet == 3;
                vmIndexInt12 = vmIndexGet == 1;
                vmIndexInt32 = vmIndexInt33;
                vmIndexInt3 = vmIndexInt02;
                vmIndexInt0 = vmIndexInt4;
            }
            if ((dirtyFlags & 26) != 0) {
                if (vm != null) {
                    vmPhoneConState = vm.phoneConState;
                }
                updateRegistration(1, vmPhoneConState);
                if (vmPhoneConState != null) {
                    vmPhoneConStateGet = vmPhoneConState.get();
                }
                boolean vmPhoneConStateInt0 = vmPhoneConStateGet == 0;
                if ((dirtyFlags & 26) != 0) {
                    if (vmPhoneConStateInt0) {
                        dirtyFlags |= 256;
                    } else {
                        dirtyFlags |= 128;
                    }
                }
                vmPhoneConStateInt0BenzGsHomeBtHintAndroidStringKswId7NotConnectedPhoneBenzGsHomeBtHintAndroidStringKswId7ConnectedPhone = vmPhoneConStateInt0 ? this.benzGsHomeBtHint.getResources().getString(R.string.ksw_id7_not_connected_phone) : this.benzGsHomeBtHint.getResources().getString(R.string.ksw_id7_connected_phone);
                vmIndexInt1 = vmIndexInt12;
            } else {
                vmIndexInt1 = vmIndexInt12;
            }
        } else {
            vmIndexInt1 = false;
        }
        if ((dirtyFlags & 20) != 0) {
            MediaInfo vmMediaInfo = BenzGsViewMoel.mediaInfo;
            if (vmMediaInfo != null) {
                vmMediaInfoMusicNameJavaLangObjectNullBenzGsHomeMusicHintAndroidStringBenzGsHomeMusicHintVmMediaInfoMusicName = null;
                vmMediaInfoMusicName = vmMediaInfo.musicName;
            } else {
                vmMediaInfoMusicNameJavaLangObjectNullBenzGsHomeMusicHintAndroidStringBenzGsHomeMusicHintVmMediaInfoMusicName = null;
                vmMediaInfoMusicName = null;
            }
            updateRegistration(2, vmMediaInfoMusicName);
            if (vmMediaInfoMusicName != null) {
                vmMediaInfoMusicNameGet = vmMediaInfoMusicName.get();
            }
            vmMediaInfoMusicNameJavaLangObjectNull = vmMediaInfoMusicNameGet == null;
            if ((dirtyFlags & 20) != 0) {
                if (vmMediaInfoMusicNameJavaLangObjectNull) {
                    dirtyFlags |= 64;
                } else {
                    dirtyFlags |= 32;
                }
            }
        } else {
            vmMediaInfoMusicNameJavaLangObjectNullBenzGsHomeMusicHintAndroidStringBenzGsHomeMusicHintVmMediaInfoMusicName = null;
        }
        if ((dirtyFlags & 20) != 0) {
            vmMediaInfoMusicNameJavaLangObjectNullBenzGsHomeMusicHintAndroidStringBenzGsHomeMusicHintVmMediaInfoMusicName2 = vmMediaInfoMusicNameJavaLangObjectNull ? this.benzGsHomeMusicHint.getResources().getString(R.string.benz_gs_home_music_hint) : vmMediaInfoMusicNameGet;
        } else {
            vmMediaInfoMusicNameJavaLangObjectNullBenzGsHomeMusicHintAndroidStringBenzGsHomeMusicHintVmMediaInfoMusicName2 = vmMediaInfoMusicNameJavaLangObjectNullBenzGsHomeMusicHintAndroidStringBenzGsHomeMusicHintVmMediaInfoMusicName;
        }
        if ((dirtyFlags & 25) != 0) {
            this.benzGsHomeBtBtn.setSelected(vmIndexInt2);
            this.benzGsHomeCarBtn.setSelected(vmIndexInt32);
            this.benzGsHomeMusicBtn.setSelected(vmIndexInt1);
            this.benzGsHomeNaviBtn.setSelected(vmIndexInt3);
            this.benzGsHomeSetBtn.setSelected(vmIndexInt0);
        }
        if ((dirtyFlags & 26) != 0) {
            TextViewBindingAdapter.setText(this.benzGsHomeBtHint, vmPhoneConStateInt0BenzGsHomeBtHintAndroidStringKswId7NotConnectedPhoneBenzGsHomeBtHintAndroidStringKswId7ConnectedPhone);
        }
        if ((dirtyFlags & 20) != 0) {
            TextViewBindingAdapter.setText(this.benzGsHomeMusicHint, vmMediaInfoMusicNameJavaLangObjectNullBenzGsHomeMusicHintAndroidStringBenzGsHomeMusicHintVmMediaInfoMusicName2);
        }
    }
}