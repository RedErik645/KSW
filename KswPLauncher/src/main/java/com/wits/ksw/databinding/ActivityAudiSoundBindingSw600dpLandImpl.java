package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.SeekBarBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.audi.vm.VolumeViewModel;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3VolumeViewModel;

public class ActivityAudiSoundBindingSw600dpLandImpl extends ActivityAudiSoundBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final SeekBar mboundView3;
    private final TextView mboundView4;
    private final SeekBar mboundView5;
    private final TextView mboundView6;
    private final SeekBar mboundView7;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.hzTextView, 9);
        sparseIntArray.put(R.id.hzMediaLinearLayout, 10);
        sparseIntArray.put(R.id.audio_seekbar_title, 11);
        sparseIntArray.put(R.id.hzCallLinearLayout, 12);
        sparseIntArray.put(R.id.carVolumeTextView, 13);
        sparseIntArray.put(R.id.carCallLinearLayout, 14);
        sparseIntArray.put(R.id.carNaviLinearLayout, 15);
    }

    public ActivityAudiSoundBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private ActivityAudiSoundBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (SeekBar) bindings[1], (TextView) bindings[2], (TextView) bindings[11], (LinearLayout) bindings[14], (LinearLayout) bindings[15], (TextView) bindings[13], (LinearLayout) bindings[12], (LinearLayout) bindings[10], (TextView) bindings[9], (ConstraintLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.audioSeekbar.setTag(null);
        this.audioSeekbarRightText.setTag(null);
        this.linearLayout4.setTag(null);
        SeekBar seekBar = (SeekBar) bindings[3];
        this.mboundView3 = seekBar;
        seekBar.setTag(null);
        TextView textView = (TextView) bindings[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        SeekBar seekBar2 = (SeekBar) bindings[5];
        this.mboundView5 = seekBar2;
        seekBar2.setTag(null);
        TextView textView2 = (TextView) bindings[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        SeekBar seekBar3 = (SeekBar) bindings[7];
        this.mboundView7 = seekBar3;
        seekBar3.setTag(null);
        TextView textView3 = (TextView) bindings[8];
        this.mboundView8 = textView3;
        textView3.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        setVm((VolumeViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityAudiSoundBinding
    public void setVm(VolumeViewModel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmCarCallVolume((ObservableInt) object, fieldId);
            case 1:
                return onChangeVmHzcallVolume((ObservableInt) object, fieldId);
            case 2:
                return onChangeVmHzMediaVolume((ObservableInt) object, fieldId);
            case 3:
                return onChangeVmCarNaviVolume((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmCarCallVolume(ObservableInt VmCarCallVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmHzcallVolume(ObservableInt VmHzcallVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmHzMediaVolume(ObservableInt VmHzMediaVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmCarNaviVolume(ObservableInt VmCarNaviVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int vmHzcallVolumeGet;
        ObservableInt vmCarNaviVolume;
        int vmHzMediaVolumeGet;
        int vmHzcallVolumeGet2;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int vmHzMediaVolumeGet2 = 0;
        ObservableInt vmCarCallVolume = null;
        ObservableInt vmHzcallVolume = null;
        String javaLangStringVmCarCallVolume = null;
        VolumeViewModel vm = this.mVm;
        int vmCarNaviVolumeGet = 0;
        String javaLangStringVmCarNaviVolume = null;
        String javaLangStringVmHzMediaVolume = null;
        int vmCarCallVolumeGet = 0;
        String javaLangStringVmHzcallVolume = null;
        ObservableInt vmHzMediaVolume = null;
        int vmHzcallVolumeGet3 = 0;
        if ((dirtyFlags & 63) != 0) {
            if ((dirtyFlags & 49) != 0) {
                if (vm != null) {
                    vmCarCallVolume = vm.carCallVolume;
                }
                updateRegistration(0, vmCarCallVolume);
                if (vmCarCallVolume != null) {
                    vmCarCallVolumeGet = vmCarCallVolume.get();
                }
                javaLangStringVmCarCallVolume = "" + vmCarCallVolumeGet;
            }
            if ((dirtyFlags & 50) != 0) {
                if (vm != null) {
                    vmHzcallVolume = vm.hzcallVolume;
                }
                updateRegistration(1, vmHzcallVolume);
                if (vmHzcallVolume != null) {
                    vmHzcallVolumeGet2 = vmHzcallVolume.get();
                } else {
                    vmHzcallVolumeGet2 = 0;
                }
                vmHzMediaVolumeGet = 0;
                javaLangStringVmHzcallVolume = "" + vmHzcallVolumeGet2;
                vmHzcallVolumeGet3 = vmHzcallVolumeGet2;
            } else {
                vmHzMediaVolumeGet = 0;
            }
            if ((dirtyFlags & 52) != 0) {
                if (vm != null) {
                    vmHzMediaVolume = vm.hzMediaVolume;
                }
                updateRegistration(2, vmHzMediaVolume);
                if (vmHzMediaVolume != null) {
                    vmHzMediaVolumeGet2 = vmHzMediaVolume.get();
                } else {
                    vmHzMediaVolumeGet2 = vmHzMediaVolumeGet;
                }
                javaLangStringVmHzMediaVolume = "" + vmHzMediaVolumeGet2;
            } else {
                vmHzMediaVolumeGet2 = vmHzMediaVolumeGet;
            }
            if ((dirtyFlags & 56) != 0) {
                if (vm != null) {
                    vmCarNaviVolume = vm.carNaviVolume;
                } else {
                    vmCarNaviVolume = null;
                }
                updateRegistration(3, vmCarNaviVolume);
                if (vmCarNaviVolume != null) {
                    vmCarNaviVolumeGet = vmCarNaviVolume.get();
                }
                javaLangStringVmCarNaviVolume = "" + vmCarNaviVolumeGet;
                vmHzcallVolumeGet = vmHzcallVolumeGet3;
                vmHzMediaVolumeGet2 = vmHzMediaVolumeGet2;
            } else {
                vmCarNaviVolume = null;
                vmHzcallVolumeGet = vmHzcallVolumeGet3;
            }
        } else {
            vmCarNaviVolume = null;
            vmHzcallVolumeGet = 0;
        }
        if ((dirtyFlags & 52) != 0) {
            SeekBarBindingAdapter.setProgress(this.audioSeekbar, vmHzMediaVolumeGet2);
            AudiMib3VolumeViewModel.setOnSeekBarChangeListener(this.audioSeekbar, vmHzMediaVolume);
            TextViewBindingAdapter.setText(this.audioSeekbarRightText, javaLangStringVmHzMediaVolume);
        }
        if ((dirtyFlags & 50) != 0) {
            SeekBarBindingAdapter.setProgress(this.mboundView3, vmHzcallVolumeGet);
            AudiMib3VolumeViewModel.setHzCallSeekBarChangeListener(this.mboundView3, vmHzcallVolume);
            TextViewBindingAdapter.setText(this.mboundView4, javaLangStringVmHzcallVolume);
        }
        if ((dirtyFlags & 49) != 0) {
            SeekBarBindingAdapter.setProgress(this.mboundView5, vmCarCallVolumeGet);
            AudiMib3VolumeViewModel.setCarCallSeekBarChangeListener(this.mboundView5, vmCarCallVolume);
            TextViewBindingAdapter.setText(this.mboundView6, javaLangStringVmCarCallVolume);
        }
        if ((dirtyFlags & 56) != 0) {
            SeekBarBindingAdapter.setProgress(this.mboundView7, vmCarNaviVolumeGet);
            AudiMib3VolumeViewModel.setCarNaviSeekBarChangeListener(this.mboundView7, vmCarNaviVolume);
            TextViewBindingAdapter.setText(this.mboundView8, javaLangStringVmCarNaviVolume);
        }
    }
}
