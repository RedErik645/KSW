package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.CompoundButtonBindingAdapter;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.audi.widget.AudiConstraintLayout;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3SystemViewModel;

public class AudiMib3SystemSetBindingHdpi1920x720Impl extends AudiMib3SystemSetBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 7);
        sparseIntArray.put(R.id.title_divider, 8);
        sparseIntArray.put(R.id.sv_list, 9);
        sparseIntArray.put(R.id.audiSystemSetParentPanel, 10);
        sparseIntArray.put(R.id.audi_system_speed_unit, 11);
        sparseIntArray.put(R.id.audi_system_temp_unit, 12);
        sparseIntArray.put(R.id.audi_system_rever_camera, 13);
        sparseIntArray.put(R.id.audi_system_brightness, 14);
        sparseIntArray.put(R.id.tv_music_app, 15);
        sparseIntArray.put(R.id.tv_video_app, 16);
        sparseIntArray.put(R.id.v_divider, 17);
    }

    public AudiMib3SystemSetBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private AudiMib3SystemSetBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (TextView) bindings[6], (TextView) bindings[14], (Switch) bindings[2], (TextView) bindings[13], (Switch) bindings[1], (Switch) bindings[5], (Switch) bindings[4], (Switch) bindings[3], (AudiConstraintLayout) bindings[10], (TextView) bindings[11], (TextView) bindings[12], (ScrollView) bindings[9], (AppCompatTextView) bindings[7], (View) bindings[8], (TextView) bindings[15], (TextView) bindings[16], (View) bindings[17]);
        this.mDirtyFlags = -1;
        this.audiSystemAuxPostion.setTag(null);
        this.audiSystemDrivingProhibitedVideo.setTag(null);
        this.audiSystemReverCameraImg.setTag(null);
        this.audiSystemReverMute.setTag(null);
        this.audiSystemReverRadar.setTag(null);
        this.audiSystemReverTrack.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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

    @Override // com.wits.ksw.databinding.AudiMib3SystemSetBinding
    public void setVm(AudiMib3SystemViewModel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmReverTrack((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeVmReverMute((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeVmReverView((ObservableBoolean) object, fieldId);
            case 3:
                return onChangeVmShowAuxPostion((ObservableBoolean) object, fieldId);
            case 4:
                return onChangeVmReverRadar((ObservableBoolean) object, fieldId);
            case 5:
                return onChangeVmDrivingVideo((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmReverTrack(ObservableBoolean VmReverTrack, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmReverMute(ObservableBoolean VmReverMute, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmReverView(ObservableBoolean VmReverView, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmShowAuxPostion(ObservableBoolean VmShowAuxPostion, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmReverRadar(ObservableBoolean VmReverRadar, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmDrivingVideo(ObservableBoolean VmDrivingVideo, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r7v3 android.widget.CompoundButton$OnCheckedChangeListener: [D('vmOndrivingVideoChangeListener' android.widget.CompoundButton$OnCheckedChangeListener), D('vmOnReverViewChangeListener' android.widget.CompoundButton$OnCheckedChangeListener)] */
    /* JADX INFO: Multiple debug info for r10v3 android.widget.CompoundButton$OnCheckedChangeListener: [D('vmOnReverViewChangeListener' android.widget.CompoundButton$OnCheckedChangeListener), D('vmOnReverMuteChangeListener' android.widget.CompoundButton$OnCheckedChangeListener)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        CompoundButton.OnCheckedChangeListener vmOnReverRadarkChangeListener;
        CompoundButton.OnCheckedChangeListener vmOnReverTrackChangeListener;
        CompoundButton.OnCheckedChangeListener vmOnReverMuteChangeListener;
        boolean vmReverTrackGet;
        boolean vmReverViewGet;
        boolean vmReverMuteGet;
        ObservableBoolean vmDrivingVideo;
        ObservableBoolean vmReverRadar;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean vmReverMuteGet2 = false;
        ObservableBoolean vmReverTrack = null;
        CompoundButton.OnCheckedChangeListener vmOnReverViewChangeListener = null;
        AudiMib3SystemViewModel vm = this.mVm;
        boolean vmDrivingVideoGet = false;
        CompoundButton.OnCheckedChangeListener vmOnReverMuteChangeListener2 = null;
        ObservableBoolean vmReverMute = null;
        int vmShowAuxPostionViewVISIBLEViewGONE = 0;
        boolean vmReverRadarGet = false;
        ObservableBoolean vmReverView = null;
        ObservableBoolean vmShowAuxPostion = null;
        boolean vmShowAuxPostionGet = false;
        boolean vmReverViewGet2 = false;
        boolean vmReverTrackGet2 = false;
        CompoundButton.OnCheckedChangeListener vmOnReverMuteChangeListener3 = null;
        CompoundButton.OnCheckedChangeListener vmOnReverTrackChangeListener2 = null;
        CompoundButton.OnCheckedChangeListener vmOnReverRadarkChangeListener2 = null;
        if ((dirtyFlags & 255) != 0) {
            if ((dirtyFlags & 193) != 0) {
                if (vm != null) {
                    vmReverTrack = vm.reverTrack;
                }
                updateRegistration(0, vmReverTrack);
                if (vmReverTrack != null) {
                    vmReverTrackGet2 = vmReverTrack.get();
                }
            }
            if ((dirtyFlags & 192) == 0) {
                vmReverMuteGet = false;
            } else if (vm != null) {
                CompoundButton.OnCheckedChangeListener vmOndrivingVideoChangeListener = vm.ondrivingVideoChangeListener;
                CompoundButton.OnCheckedChangeListener vmOnReverViewChangeListener2 = vm.onReverViewChangeListener;
                CompoundButton.OnCheckedChangeListener vmOnReverMuteChangeListener4 = vm.onReverMuteChangeListener;
                CompoundButton.OnCheckedChangeListener vmOnReverTrackChangeListener3 = vm.onReverTrackChangeListener;
                vmReverMuteGet = false;
                vmOnReverRadarkChangeListener2 = vm.onReverRadarkChangeListener;
                vmOnReverTrackChangeListener2 = vmOnReverTrackChangeListener3;
                vmOnReverMuteChangeListener3 = vmOnReverMuteChangeListener4;
                vmOnReverMuteChangeListener2 = vmOnReverViewChangeListener2;
                vmOnReverViewChangeListener = vmOndrivingVideoChangeListener;
            } else {
                vmReverMuteGet = false;
            }
            if ((dirtyFlags & 194) != 0) {
                if (vm != null) {
                    vmReverMute = vm.reverMute;
                }
                updateRegistration(1, vmReverMute);
                if (vmReverMute != null) {
                    vmReverMuteGet2 = vmReverMute.get();
                } else {
                    vmReverMuteGet2 = vmReverMuteGet;
                }
            } else {
                vmReverMuteGet2 = vmReverMuteGet;
            }
            if ((dirtyFlags & 196) != 0) {
                if (vm != null) {
                    vmReverView = vm.reverView;
                }
                updateRegistration(2, vmReverView);
                if (vmReverView != null) {
                    vmReverViewGet2 = vmReverView.get();
                }
            }
            if ((dirtyFlags & 200) != 0) {
                if (vm != null) {
                    vmShowAuxPostion = vm.showAuxPostion;
                }
                updateRegistration(3, vmShowAuxPostion);
                if (vmShowAuxPostion != null) {
                    vmShowAuxPostionGet = vmShowAuxPostion.get();
                }
                if ((dirtyFlags & 200) != 0) {
                    if (vmShowAuxPostionGet) {
                        dirtyFlags |= 512;
                    } else {
                        dirtyFlags |= 256;
                    }
                }
                vmShowAuxPostionViewVISIBLEViewGONE = vmShowAuxPostionGet ? 0 : 8;
            }
            if ((dirtyFlags & 208) != 0) {
                if (vm != null) {
                    vmReverRadar = vm.reverRadar;
                } else {
                    vmReverRadar = null;
                }
                updateRegistration(4, vmReverRadar);
                if (vmReverRadar != null) {
                    vmReverRadarGet = vmReverRadar.get();
                }
            }
            if ((dirtyFlags & 224) != 0) {
                if (vm != null) {
                    vmDrivingVideo = vm.drivingVideo;
                } else {
                    vmDrivingVideo = null;
                }
                updateRegistration(5, vmDrivingVideo);
                if (vmDrivingVideo != null) {
                    vmDrivingVideoGet = vmDrivingVideo.get();
                    vmReverViewGet = vmReverViewGet2;
                    vmReverTrackGet = vmReverTrackGet2;
                    vmOnReverMuteChangeListener = vmOnReverMuteChangeListener3;
                    vmOnReverTrackChangeListener = vmOnReverTrackChangeListener2;
                    vmOnReverRadarkChangeListener = vmOnReverRadarkChangeListener2;
                } else {
                    vmReverViewGet = vmReverViewGet2;
                    vmReverTrackGet = vmReverTrackGet2;
                    vmOnReverMuteChangeListener = vmOnReverMuteChangeListener3;
                    vmOnReverTrackChangeListener = vmOnReverTrackChangeListener2;
                    vmOnReverRadarkChangeListener = vmOnReverRadarkChangeListener2;
                }
            } else {
                vmReverViewGet = vmReverViewGet2;
                vmReverTrackGet = vmReverTrackGet2;
                vmOnReverMuteChangeListener = vmOnReverMuteChangeListener3;
                vmOnReverTrackChangeListener = vmOnReverTrackChangeListener2;
                vmOnReverRadarkChangeListener = vmOnReverRadarkChangeListener2;
            }
        } else {
            vmReverViewGet = false;
            vmReverTrackGet = false;
            vmOnReverMuteChangeListener = null;
            vmOnReverTrackChangeListener = null;
            vmOnReverRadarkChangeListener = null;
        }
        if ((dirtyFlags & 200) != 0) {
            this.audiSystemAuxPostion.setVisibility(vmShowAuxPostionViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 224) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.audiSystemDrivingProhibitedVideo, vmDrivingVideoGet);
        }
        if ((dirtyFlags & 192) != 0) {
            this.audiSystemDrivingProhibitedVideo.setOnCheckedChangeListener(vmOnReverViewChangeListener);
            this.audiSystemReverCameraImg.setOnCheckedChangeListener(vmOnReverMuteChangeListener2);
            this.audiSystemReverMute.setOnCheckedChangeListener(vmOnReverMuteChangeListener);
            this.audiSystemReverRadar.setOnCheckedChangeListener(vmOnReverRadarkChangeListener);
            this.audiSystemReverTrack.setOnCheckedChangeListener(vmOnReverTrackChangeListener);
        }
        if ((dirtyFlags & 196) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.audiSystemReverCameraImg, vmReverViewGet);
        }
        if ((dirtyFlags & 194) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.audiSystemReverMute, vmReverMuteGet2);
        }
        if ((dirtyFlags & 208) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.audiSystemReverRadar, vmReverRadarGet);
        }
        if ((dirtyFlags & 193) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.audiSystemReverTrack, vmReverTrackGet);
        }
    }
}
