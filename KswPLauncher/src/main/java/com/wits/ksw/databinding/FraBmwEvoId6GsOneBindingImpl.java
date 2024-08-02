package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.view.bmwevoid6gs.BmwId6gsViewMode;

public class FraBmwEvoId6GsOneBindingImpl extends FraBmwEvoId6GsOneBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ConstraintLayout mboundView2;
    private final ConstraintLayout mboundView5;
    private final ConstraintLayout mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_evo_id6_gs_hmoe_navi_hint_textview, 7);
        sparseIntArray.put(R.id.textView17, 8);
        sparseIntArray.put(R.id.bmw_evo_id6_gs_hmoe_video_hint_textview, 9);
    }

    public FraBmwEvoId6GsOneBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private FraBmwEvoId6GsOneBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (TextView) bindings[3], (TextView) bindings[4], (ConstraintLayout) bindings[1], (TextView) bindings[7], (TextView) bindings[9], (TextView) bindings[8]);
        this.mDirtyFlags = -1;
        this.bmwEvoId6GsHmoeMusicHintTextview.setTag(null);
        this.bmwEvoId6GsHmoeMusicNameTextview.setTag(null);
        this.bmwEvoId6GsHmoeNaviBtn.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[2];
        this.mboundView2 = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) bindings[5];
        this.mboundView5 = constraintLayout2;
        constraintLayout2.setTag(null);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) bindings[6];
        this.mboundView6 = constraintLayout3;
        constraintLayout3.setTag(null);
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
        setVm((BmwId6gsViewMode) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.FraBmwEvoId6GsOneBinding
    public void setVm(BmwId6gsViewMode Vm) {
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
                return onChangeVmMediaInfoMusicName((ObservableField) object, fieldId);
            case 2:
                return onChangeVmMediaInfoMusicAtist((ObservableField) object, fieldId);
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

    private boolean onChangeVmMediaInfoMusicName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmMediaInfoMusicAtist(ObservableField<String> observableField, int fieldId) {
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
        String vmMediaInfoMusicAtistGet;
        ObservableField<String> vmMediaInfoMusicAtist;
        ObservableField<String> vmMediaInfoMusicName;
        int vmIndexGet;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean vmIndexInt2 = false;
        String vmMediaInfoMusicAtistGet2 = null;
        ObservableInt vmIndex = null;
        String vmMediaInfoMusicNameGet = null;
        boolean vmMediaInfoMusicAtistJavaLangObjectNull = false;
        BmwId6gsViewMode vm = this.mVm;
        String vmMediaInfoMusicAtistJavaLangObjectNullBmwEvoId6GsHmoeMusicHintTextviewAndroidStringKswIdf7UnknowArtisVmMediaInfoMusicAtist = null;
        String vmMediaInfoMusicNameJavaLangObjectNullBmwEvoId6GsHmoeMusicNameTextviewAndroidStringKswIdf7UnkonwSoungVmMediaInfoMusicName = null;
        boolean vmIndexInt0 = false;
        boolean vmIndexInt3 = false;
        boolean vmMediaInfoMusicNameJavaLangObjectNull = false;
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
            vmIndexInt0 = vmIndexGet == 0;
            vmIndexInt3 = vmIndexGet == 3;
            vmIndexInt1 = vmIndexGet == 1;
        } else {
            vmIndexInt1 = false;
        }
        if ((dirtyFlags & 22) != 0) {
            MediaInfo vmMediaInfo = BmwId6gsViewMode.mediaInfo;
            if ((dirtyFlags & 18) != 0) {
                if (vmMediaInfo != null) {
                    vmMediaInfoMusicName = vmMediaInfo.musicName;
                } else {
                    vmMediaInfoMusicName = null;
                }
                vmMediaInfoMusicAtistGet = null;
                updateRegistration(1, vmMediaInfoMusicName);
                if (vmMediaInfoMusicName != null) {
                    vmMediaInfoMusicNameGet = vmMediaInfoMusicName.get();
                }
                vmMediaInfoMusicNameJavaLangObjectNull = vmMediaInfoMusicNameGet == null;
                if ((dirtyFlags & 18) != 0) {
                    dirtyFlags = vmMediaInfoMusicNameJavaLangObjectNull ? dirtyFlags | 256 : dirtyFlags | 128;
                }
            } else {
                vmMediaInfoMusicAtistGet = null;
            }
            if ((dirtyFlags & 20) != 0) {
                if (vmMediaInfo != null) {
                    vmMediaInfoMusicAtist = vmMediaInfo.musicAtist;
                } else {
                    vmMediaInfoMusicAtist = null;
                }
                updateRegistration(2, vmMediaInfoMusicAtist);
                if (vmMediaInfoMusicAtist != null) {
                    vmMediaInfoMusicAtistGet2 = vmMediaInfoMusicAtist.get();
                } else {
                    vmMediaInfoMusicAtistGet2 = vmMediaInfoMusicAtistGet;
                }
                vmMediaInfoMusicAtistJavaLangObjectNull = vmMediaInfoMusicAtistGet2 == null;
                if ((dirtyFlags & 20) != 0) {
                    if (vmMediaInfoMusicAtistJavaLangObjectNull) {
                        dirtyFlags |= 64;
                    } else {
                        dirtyFlags |= 32;
                    }
                }
            } else {
                vmMediaInfoMusicAtistGet2 = vmMediaInfoMusicAtistGet;
            }
        }
        if ((dirtyFlags & 20) != 0) {
            vmMediaInfoMusicAtistJavaLangObjectNullBmwEvoId6GsHmoeMusicHintTextviewAndroidStringKswIdf7UnknowArtisVmMediaInfoMusicAtist = vmMediaInfoMusicAtistJavaLangObjectNull ? this.bmwEvoId6GsHmoeMusicHintTextview.getResources().getString(R.string.ksw_idf7_unknow_artis) : vmMediaInfoMusicAtistGet2;
        }
        if ((dirtyFlags & 18) != 0) {
            vmMediaInfoMusicNameJavaLangObjectNullBmwEvoId6GsHmoeMusicNameTextviewAndroidStringKswIdf7UnkonwSoungVmMediaInfoMusicName = vmMediaInfoMusicNameJavaLangObjectNull ? this.bmwEvoId6GsHmoeMusicNameTextview.getResources().getString(R.string.ksw_idf7_unkonw_soung) : vmMediaInfoMusicNameGet;
        }
        if ((dirtyFlags & 20) != 0) {
            TextViewBindingAdapter.setText(this.bmwEvoId6GsHmoeMusicHintTextview, vmMediaInfoMusicAtistJavaLangObjectNullBmwEvoId6GsHmoeMusicHintTextviewAndroidStringKswIdf7UnknowArtisVmMediaInfoMusicAtist);
        }
        if ((dirtyFlags & 18) != 0) {
            TextViewBindingAdapter.setText(this.bmwEvoId6GsHmoeMusicNameTextview, vmMediaInfoMusicNameJavaLangObjectNullBmwEvoId6GsHmoeMusicNameTextviewAndroidStringKswIdf7UnkonwSoungVmMediaInfoMusicName);
        }
        if ((dirtyFlags & 25) != 0) {
            this.bmwEvoId6GsHmoeNaviBtn.setSelected(vmIndexInt0);
            this.mboundView2.setSelected(vmIndexInt1);
            this.mboundView5.setSelected(vmIndexInt2);
            this.mboundView6.setSelected(vmIndexInt3);
        }
    }
}
