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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3SystemViewModel;

public class AudiMib3AuxBindingHdpi1920x720Impl extends AudiMib3AuxBinding {
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
        sparseIntArray.put(R.id.linearLayout4, 7);
        sparseIntArray.put(R.id.hzMediaLinearLayout, 8);
        sparseIntArray.put(R.id.audio_seekbar_title, 9);
        sparseIntArray.put(R.id.hzCallLinearLayout, 10);
        sparseIntArray.put(R.id.v_divider, 11);
    }

    public AudiMib3AuxBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private AudiMib3AuxBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (SeekBar) bindings[1], (TextView) bindings[2], (TextView) bindings[9], (LinearLayout) bindings[10], (LinearLayout) bindings[8], (ConstraintLayout) bindings[7], (AppCompatTextView) bindings[5], (View) bindings[6], (View) bindings[11]);
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
        setVm((AudiMib3SystemViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AudiMib3AuxBinding
    public void setVm(AudiMib3SystemViewModel Vm) {
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
                return onChangeVmAux2Progress((ObservableInt) object, fieldId);
            case 1:
                return onChangeVmAux1Progress((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmAux2Progress(ObservableInt VmAux2Progress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmAux1Progress(ObservableInt VmAux1Progress, int fieldId) {
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
        ObservableInt vmAux2Progress = null;
        int vmAux2ProgressGet = 0;
        ObservableInt vmAux1Progress = null;
        SeekBar.OnSeekBarChangeListener vmAux1ChangeListener = null;
        AudiMib3SystemViewModel vm = this.mVm;
        int vmAux1ProgressGet = 0;
        String stringValueOfVmAux1Progress = null;
        SeekBar.OnSeekBarChangeListener vmAux2ChangeListener = null;
        String stringValueOfVmAux2Progress = null;
        if ((15 & dirtyFlags) != 0) {
            if ((dirtyFlags & 13) != 0) {
                if (vm != null) {
                    vmAux2Progress = vm.aux2Progress;
                }
                updateRegistration(0, vmAux2Progress);
                if (vmAux2Progress != null) {
                    vmAux2ProgressGet = vmAux2Progress.get();
                }
                stringValueOfVmAux2Progress = String.valueOf(vmAux2ProgressGet);
            }
            if ((dirtyFlags & 14) != 0) {
                if (vm != null) {
                    vmAux1Progress = vm.aux1Progress;
                }
                updateRegistration(1, vmAux1Progress);
                if (vmAux1Progress != null) {
                    vmAux1ProgressGet = vmAux1Progress.get();
                }
                stringValueOfVmAux1Progress = String.valueOf(vmAux1ProgressGet);
            }
            if (!((dirtyFlags & 12) == 0 || vm == null)) {
                vmAux1ChangeListener = vm.aux1ChangeListener;
                vmAux2ChangeListener = vm.aux2ChangeListener;
            }
        }
        if ((dirtyFlags & 14) != 0) {
            SeekBarBindingAdapter.setProgress(this.audioSeekbar, vmAux1ProgressGet);
            TextViewBindingAdapter.setText(this.audioSeekbarRightText, stringValueOfVmAux1Progress);
        }
        if ((dirtyFlags & 12) != 0) {
            this.audioSeekbar.setOnSeekBarChangeListener(vmAux1ChangeListener);
            this.mboundView3.setOnSeekBarChangeListener(vmAux2ChangeListener);
        }
        if ((dirtyFlags & 13) != 0) {
            SeekBarBindingAdapter.setProgress(this.mboundView3, vmAux2ProgressGet);
            TextViewBindingAdapter.setText(this.mboundView4, stringValueOfVmAux2Progress);
        }
    }
}
