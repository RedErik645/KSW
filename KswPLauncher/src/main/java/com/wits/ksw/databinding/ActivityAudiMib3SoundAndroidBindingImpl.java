package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.SeekBarBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3VolumeViewModel;

public class ActivityAudiMib3SoundAndroidBindingImpl extends ActivityAudiMib3SoundAndroidBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final SeekBar mboundView3;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 5);
        sparseIntArray.put(R.id.title_divider, 6);
        sparseIntArray.put(R.id.sv_sound, 7);
        sparseIntArray.put(R.id.linearLayout4, 8);
        sparseIntArray.put(R.id.hzMediaLinearLayout, 9);
        sparseIntArray.put(R.id.audio_seekbar_title, 10);
        sparseIntArray.put(R.id.hzCallLinearLayout, 11);
        sparseIntArray.put(R.id.v_divider, 12);
    }

    public ActivityAudiMib3SoundAndroidBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private ActivityAudiMib3SoundAndroidBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (SeekBar) bindings[1], (TextView) bindings[2], (TextView) bindings[10], (View) bindings[11], (View) bindings[9], (ConstraintLayout) bindings[8], null, null, null, null, (ScrollView) bindings[7], (AppCompatTextView) bindings[5], (View) bindings[6], (View) bindings[12]);
        this.mDirtyFlags = -1;
        this.audioSeekbar.setTag(null);
        this.audioSeekbarRightText.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        SeekBar seekBar = (SeekBar) bindings[3];
        this.mboundView3 = seekBar;
        seekBar.setTag(null);
        TextView textView = (TextView) bindings[4];
        this.mboundView4 = textView;
        textView.setTag(null);
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
        if (37 != variableId) {
            return false;
        }
        setVm((AudiMib3VolumeViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityAudiMib3SoundAndroidBinding
    public void setVm(AudiMib3VolumeViewModel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmHzcallVolume((ObservableInt) object, fieldId);
            case 1:
                return onChangeVmHzMediaVolume((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmHzcallVolume(ObservableInt VmHzcallVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmHzMediaVolume(ObservableInt VmHzMediaVolume, int fieldId) {
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
        int vmHzMediaVolumeGet = 0;
        ObservableInt vmHzcallVolume = null;
        String javaLangStringVmHzcallVolume = null;
        ObservableInt vmHzMediaVolume = null;
        AudiMib3VolumeViewModel vm = this.mVm;
        String javaLangStringVmHzMediaVolume = null;
        int vmHzcallVolumeGet = 0;
        if ((15 & dirtyFlags) != 0) {
            if ((dirtyFlags & 13) != 0) {
                if (vm != null) {
                    vmHzcallVolume = vm.hzcallVolume;
                }
                updateRegistration(0, vmHzcallVolume);
                if (vmHzcallVolume != null) {
                    vmHzcallVolumeGet = vmHzcallVolume.get();
                }
                javaLangStringVmHzcallVolume = "" + vmHzcallVolumeGet;
            }
            if ((dirtyFlags & 14) != 0) {
                if (vm != null) {
                    vmHzMediaVolume = vm.hzMediaVolume;
                }
                updateRegistration(1, vmHzMediaVolume);
                if (vmHzMediaVolume != null) {
                    vmHzMediaVolumeGet = vmHzMediaVolume.get();
                }
                javaLangStringVmHzMediaVolume = "" + vmHzMediaVolumeGet;
            }
        }
        if ((dirtyFlags & 14) != 0) {
            SeekBarBindingAdapter.setProgress(this.audioSeekbar, vmHzMediaVolumeGet);
            AudiMib3VolumeViewModel.setOnSeekBarChangeListener(this.audioSeekbar, vmHzMediaVolume);
            TextViewBindingAdapter.setText(this.audioSeekbarRightText, javaLangStringVmHzMediaVolume);
        }
        if ((13 & dirtyFlags) != 0) {
            SeekBarBindingAdapter.setProgress(this.mboundView3, vmHzcallVolumeGet);
            AudiMib3VolumeViewModel.setHzCallSeekBarChangeListener(this.mboundView3, vmHzcallVolume);
            TextViewBindingAdapter.setText(this.mboundView4, javaLangStringVmHzcallVolume);
        }
    }
}
