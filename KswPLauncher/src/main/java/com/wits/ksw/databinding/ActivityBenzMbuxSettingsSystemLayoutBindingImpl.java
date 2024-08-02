package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class ActivityBenzMbuxSettingsSystemLayoutBindingImpl extends ActivityBenzMbuxSettingsSystemLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    private final ImageView mboundView2;
    private final ImageView mboundView3;
    private final ImageView mboundView4;
    private final ImageView mboundView5;
    private final ImageView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_settings_system_scroll, 7);
        sparseIntArray.put(R.id.mbux_settings_system_mirror, 8);
        sparseIntArray.put(R.id.mbux_settings_system_motion, 9);
        sparseIntArray.put(R.id.mbux_settings_system_lines, 10);
        sparseIntArray.put(R.id.mbux_settings_system_radar, 11);
        sparseIntArray.put(R.id.mbux_settings_system_mute, 12);
        sparseIntArray.put(R.id.mbux_settings_system_time, 13);
        sparseIntArray.put(R.id.mbux_settings_system_language, 14);
        sparseIntArray.put(R.id.mbux_settings_system_camera, 15);
        sparseIntArray.put(R.id.mbux_settings_system_aux, 16);
        sparseIntArray.put(R.id.mbux_settings_system_brightness, 17);
        sparseIntArray.put(R.id.mbux_settings_system_temp, 18);
        sparseIntArray.put(R.id.mbux_settings_system_fuel, 19);
        sparseIntArray.put(R.id.mbux_settings_system_music, 20);
        sparseIntArray.put(R.id.mbux_settings_system_video, 21);
        sparseIntArray.put(R.id.mbux_settings_system_framelay, 22);
    }

    public ActivityBenzMbuxSettingsSystemLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }

    private ActivityBenzMbuxSettingsSystemLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (RelativeLayout) bindings[16], (RelativeLayout) bindings[17], (RelativeLayout) bindings[15], (FrameLayout) bindings[22], (RelativeLayout) bindings[19], (RelativeLayout) bindings[14], (RelativeLayout) bindings[10], (RelativeLayout) bindings[8], (RelativeLayout) bindings[9], (RelativeLayout) bindings[20], (RelativeLayout) bindings[12], (RelativeLayout) bindings[11], (ScrollView) bindings[7], (RelativeLayout) bindings[18], (RelativeLayout) bindings[13], (RelativeLayout) bindings[21]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[2];
        this.mboundView2 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[3];
        this.mboundView3 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[4];
        this.mboundView4 = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) bindings[5];
        this.mboundView5 = imageView5;
        imageView5.setTag(null);
        ImageView imageView6 = (ImageView) bindings[6];
        this.mboundView6 = imageView6;
        imageView6.setTag(null);
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
        if (36 != variableId) {
            return false;
        }
        setViewModel((BenzMbuxSettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityBenzMbuxSettingsSystemLayoutBinding
    public void setViewModel(BenzMbuxSettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelParkMute((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeViewModelParkLines((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeViewModelParkRadar((ObservableBoolean) object, fieldId);
            case 3:
                return onChangeViewModelSystemIconShow((ObservableBoolean) object, fieldId);
            case 4:
                return onChangeViewModelDisableVideo((ObservableBoolean) object, fieldId);
            case 5:
                return onChangeViewModelRearMirror((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelParkMute(ObservableBoolean ViewModelParkMute, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelParkLines(ObservableBoolean ViewModelParkLines, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelParkRadar(ObservableBoolean ViewModelParkRadar, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelSystemIconShow(ObservableBoolean ViewModelSystemIconShow, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelDisableVideo(ObservableBoolean ViewModelDisableVideo, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelRearMirror(ObservableBoolean ViewModelRearMirror, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        Drawable viewModelRearMirrorMboundView1AndroidDrawableMbuxSettingsSystemOnMboundView1AndroidDrawableMbuxSettingsSystemOff;
        Drawable viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff;
        Drawable viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff2;
        int viewModelSystemIconShowViewVISIBLEViewGONE;
        int viewModelSystemIconShowViewVISIBLEViewGONE2;
        int viewModelSystemIconShowViewVISIBLEViewGONE3;
        ObservableBoolean viewModelRearMirror;
        Drawable viewModelRearMirrorMboundView1AndroidDrawableMbuxSettingsSystemOnMboundView1AndroidDrawableMbuxSettingsSystemOff2;
        ObservableBoolean viewModelDisableVideo;
        Drawable drawable;
        ObservableBoolean viewModelSystemIconShow;
        ObservableBoolean viewModelParkRadar;
        Drawable drawable2;
        long dirtyFlags2;
        int i;
        Context context;
        long dirtyFlags3;
        int i2;
        Context context2;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff3 = null;
        boolean viewModelRearMirrorGet = false;
        boolean viewModelSystemIconShowGet = false;
        boolean viewModelParkMuteGet = false;
        ObservableBoolean viewModelParkMute = null;
        Drawable viewModelDisableVideoMboundView2AndroidDrawableMbuxSettingsSystemOnMboundView2AndroidDrawableMbuxSettingsSystemOff = null;
        Drawable viewModelParkLinesMboundView3AndroidDrawableMbuxSettingsSystemOnMboundView3AndroidDrawableMbuxSettingsSystemOff = null;
        boolean viewModelDisableVideoGet = false;
        Drawable viewModelParkRadarMboundView4AndroidDrawableMbuxSettingsSystemOnMboundView4AndroidDrawableMbuxSettingsSystemOff = null;
        ObservableBoolean viewModelParkLines = null;
        boolean viewModelParkLinesGet = false;
        boolean viewModelParkRadarGet = false;
        BenzMbuxSettingsViewModel viewModel = this.mViewModel;
        int viewModelSystemIconShowViewVISIBLEViewGONE4 = 0;
        if ((dirtyFlags & 255) != 0) {
            if ((dirtyFlags & 193) != 0) {
                if (viewModel != null) {
                    viewModelParkMute = viewModel.parkMute;
                }
                updateRegistration(0, viewModelParkMute);
                if (viewModelParkMute != null) {
                    viewModelParkMuteGet = viewModelParkMute.get();
                }
                if ((dirtyFlags & 193) != 0) {
                    if (viewModelParkMuteGet) {
                        dirtyFlags |= 512;
                    } else {
                        dirtyFlags |= 256;
                    }
                }
                if (viewModelParkMuteGet) {
                    context2 = this.mboundView5.getContext();
                    dirtyFlags3 = dirtyFlags;
                    i2 = R.drawable.mbux_settings_system_on;
                } else {
                    dirtyFlags3 = dirtyFlags;
                    context2 = this.mboundView5.getContext();
                    i2 = R.drawable.mbux_settings_system_off;
                }
                viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff = AppCompatResources.getDrawable(context2, i2);
                dirtyFlags = dirtyFlags3;
            } else {
                viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff = null;
            }
            if ((dirtyFlags & 194) != 0) {
                if (viewModel != null) {
                    viewModelParkLines = viewModel.parkLines;
                }
                viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff2 = viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff;
                updateRegistration(1, viewModelParkLines);
                if (viewModelParkLines != null) {
                    viewModelParkLinesGet = viewModelParkLines.get();
                }
                if ((dirtyFlags & 194) != 0) {
                    if (viewModelParkLinesGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                }
                if (viewModelParkLinesGet) {
                    context = this.mboundView3.getContext();
                    dirtyFlags2 = dirtyFlags;
                    i = R.drawable.mbux_settings_system_on;
                } else {
                    dirtyFlags2 = dirtyFlags;
                    context = this.mboundView3.getContext();
                    i = R.drawable.mbux_settings_system_off;
                }
                viewModelParkLinesMboundView3AndroidDrawableMbuxSettingsSystemOnMboundView3AndroidDrawableMbuxSettingsSystemOff = AppCompatResources.getDrawable(context, i);
                dirtyFlags = dirtyFlags2;
            } else {
                viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff2 = viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff;
            }
            if ((dirtyFlags & 196) != 0) {
                if (viewModel != null) {
                    viewModelParkRadar = viewModel.parkRadar;
                } else {
                    viewModelParkRadar = null;
                }
                viewModelSystemIconShowViewVISIBLEViewGONE = 0;
                updateRegistration(2, viewModelParkRadar);
                if (viewModelParkRadar != null) {
                    viewModelParkRadarGet = viewModelParkRadar.get();
                }
                if ((dirtyFlags & 196) != 0) {
                    if (viewModelParkRadarGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                    }
                }
                if (viewModelParkRadarGet) {
                    drawable2 = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.mbux_settings_system_on);
                } else {
                    drawable2 = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.mbux_settings_system_off);
                }
                viewModelParkRadarMboundView4AndroidDrawableMbuxSettingsSystemOnMboundView4AndroidDrawableMbuxSettingsSystemOff = drawable2;
            } else {
                viewModelSystemIconShowViewVISIBLEViewGONE = 0;
            }
            if ((dirtyFlags & 200) != 0) {
                if (viewModel != null) {
                    viewModelSystemIconShow = viewModel.systemIconShow;
                } else {
                    viewModelSystemIconShow = null;
                }
                updateRegistration(3, viewModelSystemIconShow);
                if (viewModelSystemIconShow != null) {
                    viewModelSystemIconShowGet = viewModelSystemIconShow.get();
                }
                if ((dirtyFlags & 200) != 0) {
                    if (viewModelSystemIconShowGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    }
                }
                viewModelSystemIconShowViewVISIBLEViewGONE2 = viewModelSystemIconShowGet ? 0 : 8;
            } else {
                viewModelSystemIconShowViewVISIBLEViewGONE2 = viewModelSystemIconShowViewVISIBLEViewGONE;
            }
            if ((dirtyFlags & 208) != 0) {
                if (viewModel != null) {
                    viewModelDisableVideo = viewModel.disableVideo;
                } else {
                    viewModelDisableVideo = null;
                }
                viewModelSystemIconShowViewVISIBLEViewGONE3 = viewModelSystemIconShowViewVISIBLEViewGONE2;
                updateRegistration(4, viewModelDisableVideo);
                if (viewModelDisableVideo != null) {
                    viewModelDisableVideoGet = viewModelDisableVideo.get();
                }
                if ((dirtyFlags & 208) != 0) {
                    if (viewModelDisableVideoGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                }
                if (viewModelDisableVideoGet) {
                    drawable = AppCompatResources.getDrawable(this.mboundView2.getContext(), R.drawable.mbux_settings_system_on);
                } else {
                    drawable = AppCompatResources.getDrawable(this.mboundView2.getContext(), R.drawable.mbux_settings_system_off);
                }
                viewModelDisableVideoMboundView2AndroidDrawableMbuxSettingsSystemOnMboundView2AndroidDrawableMbuxSettingsSystemOff = drawable;
            } else {
                viewModelSystemIconShowViewVISIBLEViewGONE3 = viewModelSystemIconShowViewVISIBLEViewGONE2;
            }
            if ((dirtyFlags & 224) != 0) {
                if (viewModel != null) {
                    viewModelRearMirror = viewModel.rearMirror;
                } else {
                    viewModelRearMirror = null;
                }
                updateRegistration(5, viewModelRearMirror);
                if (viewModelRearMirror != null) {
                    viewModelRearMirrorGet = viewModelRearMirror.get();
                }
                if ((dirtyFlags & 224) != 0) {
                    if (viewModelRearMirrorGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    }
                }
                if (viewModelRearMirrorGet) {
                    viewModelRearMirrorMboundView1AndroidDrawableMbuxSettingsSystemOnMboundView1AndroidDrawableMbuxSettingsSystemOff2 = AppCompatResources.getDrawable(this.mboundView1.getContext(), R.drawable.mbux_settings_system_on);
                } else {
                    viewModelRearMirrorMboundView1AndroidDrawableMbuxSettingsSystemOnMboundView1AndroidDrawableMbuxSettingsSystemOff2 = AppCompatResources.getDrawable(this.mboundView1.getContext(), R.drawable.mbux_settings_system_off);
                }
                viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff3 = viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff2;
                viewModelSystemIconShowViewVISIBLEViewGONE4 = viewModelSystemIconShowViewVISIBLEViewGONE3;
                viewModelRearMirrorMboundView1AndroidDrawableMbuxSettingsSystemOnMboundView1AndroidDrawableMbuxSettingsSystemOff = viewModelRearMirrorMboundView1AndroidDrawableMbuxSettingsSystemOnMboundView1AndroidDrawableMbuxSettingsSystemOff2;
            } else {
                viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff3 = viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff2;
                viewModelSystemIconShowViewVISIBLEViewGONE4 = viewModelSystemIconShowViewVISIBLEViewGONE3;
                viewModelRearMirrorMboundView1AndroidDrawableMbuxSettingsSystemOnMboundView1AndroidDrawableMbuxSettingsSystemOff = null;
            }
        } else {
            viewModelRearMirrorMboundView1AndroidDrawableMbuxSettingsSystemOnMboundView1AndroidDrawableMbuxSettingsSystemOff = null;
        }
        if ((dirtyFlags & 224) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView1, viewModelRearMirrorMboundView1AndroidDrawableMbuxSettingsSystemOnMboundView1AndroidDrawableMbuxSettingsSystemOff);
        }
        if ((dirtyFlags & 208) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, viewModelDisableVideoMboundView2AndroidDrawableMbuxSettingsSystemOnMboundView2AndroidDrawableMbuxSettingsSystemOff);
        }
        if ((dirtyFlags & 194) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, viewModelParkLinesMboundView3AndroidDrawableMbuxSettingsSystemOnMboundView3AndroidDrawableMbuxSettingsSystemOff);
        }
        if ((dirtyFlags & 196) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, viewModelParkRadarMboundView4AndroidDrawableMbuxSettingsSystemOnMboundView4AndroidDrawableMbuxSettingsSystemOff);
        }
        if ((dirtyFlags & 193) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, viewModelParkMuteMboundView5AndroidDrawableMbuxSettingsSystemOnMboundView5AndroidDrawableMbuxSettingsSystemOff3);
        }
        if ((dirtyFlags & 200) != 0) {
            this.mboundView6.setVisibility(viewModelSystemIconShowViewVISIBLEViewGONE4);
        }
    }
}
