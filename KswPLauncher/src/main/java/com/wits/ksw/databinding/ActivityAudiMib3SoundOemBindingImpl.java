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

public class ActivityAudiMib3SoundOemBindingImpl extends ActivityAudiMib3SoundOemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final SeekBar mboundView1;
    private final TextView mboundView2;
    private final SeekBar mboundView3;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 5);
        sparseIntArray.put(R.id.title_divider, 6);
        sparseIntArray.put(R.id.sv_sound, 7);
        sparseIntArray.put(R.id.linearLayout4, 8);
        sparseIntArray.put(R.id.carCallLinearLayout, 9);
        sparseIntArray.put(R.id.carNaviLinearLayout, 10);
        sparseIntArray.put(R.id.v_divider, 11);
    }

    public ActivityAudiMib3SoundOemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private ActivityAudiMib3SoundOemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (View) bindings[9], null, null, (View) bindings[10], (ConstraintLayout) bindings[8], (ScrollView) bindings[7], (AppCompatTextView) bindings[5], (View) bindings[6], (View) bindings[11], null, null, null, null);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        SeekBar seekBar = (SeekBar) bindings[1];
        this.mboundView1 = seekBar;
        seekBar.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        SeekBar seekBar2 = (SeekBar) bindings[3];
        this.mboundView3 = seekBar2;
        seekBar2.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
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

    @Override // com.wits.ksw.databinding.ActivityAudiMib3SoundOemBinding
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
                return onChangeVmCarCallVolume((ObservableInt) object, fieldId);
            case 1:
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

    private boolean onChangeVmCarNaviVolume(ObservableInt VmCarNaviVolume, int fieldId) {
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
        ObservableInt vmCarCallVolume = null;
        int vmCarCallVolumeGet = 0;
        ObservableInt vmCarNaviVolume = null;
        String javaLangStringVmCarCallVolume = null;
        AudiMib3VolumeViewModel vm = this.mVm;
        int vmCarNaviVolumeGet = 0;
        String javaLangStringVmCarNaviVolume = null;
        if ((15 & dirtyFlags) != 0) {
            if ((dirtyFlags & 13) != 0) {
                if (vm != null) {
                    vmCarCallVolume = vm.carCallVolume;
                }
                updateRegistration(0, vmCarCallVolume);
                if (vmCarCallVolume != null) {
                    vmCarCallVolumeGet = vmCarCallVolume.get();
                }
                javaLangStringVmCarCallVolume = "" + vmCarCallVolumeGet;
            }
            if ((dirtyFlags & 14) != 0) {
                if (vm != null) {
                    vmCarNaviVolume = vm.carNaviVolume;
                }
                updateRegistration(1, vmCarNaviVolume);
                if (vmCarNaviVolume != null) {
                    vmCarNaviVolumeGet = vmCarNaviVolume.get();
                }
                javaLangStringVmCarNaviVolume = "" + vmCarNaviVolumeGet;
            }
        }
        if ((13 & dirtyFlags) != 0) {
            SeekBarBindingAdapter.setProgress(this.mboundView1, vmCarCallVolumeGet);
            AudiMib3VolumeViewModel.setCarCallSeekBarChangeListener(this.mboundView1, vmCarCallVolume);
            TextViewBindingAdapter.setText(this.mboundView2, javaLangStringVmCarCallVolume);
        }
        if ((dirtyFlags & 14) != 0) {
            SeekBarBindingAdapter.setProgress(this.mboundView3, vmCarNaviVolumeGet);
            AudiMib3VolumeViewModel.setCarNaviSeekBarChangeListener(this.mboundView3, vmCarNaviVolume);
            TextViewBindingAdapter.setText(this.mboundView4, javaLangStringVmCarNaviVolume);
        }
    }
}
