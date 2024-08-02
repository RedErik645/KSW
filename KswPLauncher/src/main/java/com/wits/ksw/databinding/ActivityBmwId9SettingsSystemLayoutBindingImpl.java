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
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class ActivityBmwId9SettingsSystemLayoutBindingImpl extends ActivityBmwId9SettingsSystemLayoutBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback264;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView2;
    private final ImageView mboundView3;
    private final ImageView mboundView4;
    private final ImageView mboundView5;
    private final ImageView mboundView6;
    private final ImageView mboundView7;
    private final ImageView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id9_settings_system_scroll, 9);
        sparseIntArray.put(R.id.bmw_id9_settings_system_mirror, 10);
        sparseIntArray.put(R.id.bmw_id9_settings_system_motion, 11);
        sparseIntArray.put(R.id.bmw_id9_settings_system_lines, 12);
        sparseIntArray.put(R.id.bmw_id9_settings_system_radar, 13);
        sparseIntArray.put(R.id.bmw_id9_settings_system_mute, 14);
        sparseIntArray.put(R.id.bmw_id9_settings_system_time, 15);
        sparseIntArray.put(R.id.bmw_id9_settings_system_language, 16);
        sparseIntArray.put(R.id.bmw_id9_settings_system_camera, 17);
        sparseIntArray.put(R.id.bmw_id9_settings_system_brightness, 18);
        sparseIntArray.put(R.id.bmw_id9_settings_system_temp, 19);
        sparseIntArray.put(R.id.bmw_id9_settings_system_fuel, 20);
        sparseIntArray.put(R.id.bmw_id9_settings_system_music, 21);
        sparseIntArray.put(R.id.bmw_id9_settings_system_video, 22);
        sparseIntArray.put(R.id.bmw_id9_settings_system_framelay, 23);
    }

    public ActivityBmwId9SettingsSystemLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    private ActivityBmwId9SettingsSystemLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7, (ImageView) bindings[1], (RelativeLayout) bindings[18], (RelativeLayout) bindings[17], (FrameLayout) bindings[23], (RelativeLayout) bindings[20], (RelativeLayout) bindings[16], (RelativeLayout) bindings[12], (RelativeLayout) bindings[10], (RelativeLayout) bindings[11], (RelativeLayout) bindings[21], (RelativeLayout) bindings[14], (RelativeLayout) bindings[13], (ScrollView) bindings[9], (RelativeLayout) bindings[19], (RelativeLayout) bindings[15], (RelativeLayout) bindings[22]);
        this.mDirtyFlags = -1;
        this.bmwId8SettingsHomeback.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[3];
        this.mboundView3 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[4];
        this.mboundView4 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[5];
        this.mboundView5 = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) bindings[6];
        this.mboundView6 = imageView5;
        imageView5.setTag(null);
        ImageView imageView6 = (ImageView) bindings[7];
        this.mboundView7 = imageView6;
        imageView6.setTag(null);
        ImageView imageView7 = (ImageView) bindings[8];
        this.mboundView8 = imageView7;
        imageView7.setTag(null);
        setRootTag(root);
        this.mCallback264 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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
        setViewModel((BmwId9SettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityBmwId9SettingsSystemLayoutBinding
    public void setViewModel(BmwId9SettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
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
                return onChangeViewModelSystemBgShow((ObservableBoolean) object, fieldId);
            case 5:
                return onChangeViewModelDisableVideo((ObservableBoolean) object, fieldId);
            case 6:
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

    private boolean onChangeViewModelSystemBgShow(ObservableBoolean ViewModelSystemBgShow, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelDisableVideo(ObservableBoolean ViewModelDisableVideo, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelRearMirror(ObservableBoolean ViewModelRearMirror, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        Drawable viewModelRearMirrorMboundView3AndroidDrawableBmwId9SettingsSystemOnMboundView3AndroidDrawableBmwId9SettingsSystemOff;
        Drawable viewModelParkRadarMboundView6AndroidDrawableBmwId9SettingsSystemOnMboundView6AndroidDrawableBmwId9SettingsSystemOff;
        int viewModelSystemIconShowViewVISIBLEViewGONE;
        int viewModelSystemIconShowViewVISIBLEViewGONE2;
        int viewModelSystemIconShowViewVISIBLEViewGONE3;
        ObservableBoolean viewModelRearMirror;
        long dirtyFlags2;
        int i;
        Context context;
        ObservableBoolean viewModelDisableVideo;
        ObservableBoolean viewModelSystemBgShow;
        ObservableBoolean viewModelSystemIconShow;
        ObservableBoolean viewModelParkRadar;
        Drawable drawable;
        long dirtyFlags3;
        int i2;
        Context context2;
        long dirtyFlags4;
        int i3;
        Context context3;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable viewModelDisableVideoMboundView4AndroidDrawableBmwId9SettingsSystemOnMboundView4AndroidDrawableBmwId9SettingsSystemOff = null;
        Drawable viewModelParkLinesMboundView5AndroidDrawableBmwId9SettingsSystemOnMboundView5AndroidDrawableBmwId9SettingsSystemOff = null;
        int viewModelSystemBgShowViewVISIBLEViewGONE = 0;
        boolean viewModelRearMirrorGet = false;
        boolean viewModelSystemIconShowGet = false;
        boolean viewModelParkMuteGet = false;
        ObservableBoolean viewModelParkMute = null;
        Drawable viewModelParkMuteMboundView7AndroidDrawableBmwId9SettingsSystemOnMboundView7AndroidDrawableBmwId9SettingsSystemOff = null;
        boolean viewModelDisableVideoGet = false;
        ObservableBoolean viewModelParkLines = null;
        boolean viewModelParkLinesGet = false;
        boolean viewModelSystemBgShowGet = false;
        Drawable viewModelParkRadarMboundView6AndroidDrawableBmwId9SettingsSystemOnMboundView6AndroidDrawableBmwId9SettingsSystemOff2 = null;
        boolean viewModelParkRadarGet = false;
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        int viewModelSystemIconShowViewVISIBLEViewGONE4 = 0;
        if ((dirtyFlags & 511) != 0) {
            if ((dirtyFlags & 385) != 0) {
                if (viewModel != null) {
                    viewModelParkMute = viewModel.parkMute;
                }
                updateRegistration(0, viewModelParkMute);
                if (viewModelParkMute != null) {
                    viewModelParkMuteGet = viewModelParkMute.get();
                }
                if ((dirtyFlags & 385) != 0) {
                    if (viewModelParkMuteGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                }
                if (viewModelParkMuteGet) {
                    context3 = this.mboundView7.getContext();
                    dirtyFlags4 = dirtyFlags;
                    i3 = R.drawable.bmw_id9_settings_system_on;
                } else {
                    dirtyFlags4 = dirtyFlags;
                    context3 = this.mboundView7.getContext();
                    i3 = R.drawable.bmw_id9_settings_system_off;
                }
                viewModelParkMuteMboundView7AndroidDrawableBmwId9SettingsSystemOnMboundView7AndroidDrawableBmwId9SettingsSystemOff = AppCompatResources.getDrawable(context3, i3);
                dirtyFlags = dirtyFlags4;
            }
            if ((dirtyFlags & 386) != 0) {
                if (viewModel != null) {
                    viewModelParkLines = viewModel.parkLines;
                }
                updateRegistration(1, viewModelParkLines);
                if (viewModelParkLines != null) {
                    viewModelParkLinesGet = viewModelParkLines.get();
                }
                if ((dirtyFlags & 386) != 0) {
                    if (viewModelParkLinesGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                }
                if (viewModelParkLinesGet) {
                    context2 = this.mboundView5.getContext();
                    dirtyFlags3 = dirtyFlags;
                    i2 = R.drawable.bmw_id9_settings_system_on;
                } else {
                    dirtyFlags3 = dirtyFlags;
                    context2 = this.mboundView5.getContext();
                    i2 = R.drawable.bmw_id9_settings_system_off;
                }
                viewModelParkLinesMboundView5AndroidDrawableBmwId9SettingsSystemOnMboundView5AndroidDrawableBmwId9SettingsSystemOff = AppCompatResources.getDrawable(context2, i2);
                dirtyFlags = dirtyFlags3;
            }
            if ((dirtyFlags & 388) != 0) {
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
                if ((dirtyFlags & 388) != 0) {
                    if (viewModelParkRadarGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    }
                }
                if (viewModelParkRadarGet) {
                    drawable = AppCompatResources.getDrawable(this.mboundView6.getContext(), R.drawable.bmw_id9_settings_system_on);
                } else {
                    drawable = AppCompatResources.getDrawable(this.mboundView6.getContext(), R.drawable.bmw_id9_settings_system_off);
                }
                viewModelParkRadarMboundView6AndroidDrawableBmwId9SettingsSystemOnMboundView6AndroidDrawableBmwId9SettingsSystemOff2 = drawable;
            } else {
                viewModelSystemIconShowViewVISIBLEViewGONE = 0;
            }
            if ((dirtyFlags & 392) != 0) {
                if (viewModel != null) {
                    viewModelSystemIconShow = viewModel.systemIconShow;
                } else {
                    viewModelSystemIconShow = null;
                }
                updateRegistration(3, viewModelSystemIconShow);
                if (viewModelSystemIconShow != null) {
                    viewModelSystemIconShowGet = viewModelSystemIconShow.get();
                }
                if ((dirtyFlags & 392) != 0) {
                    if (viewModelSystemIconShowGet) {
                        dirtyFlags |= 4194304;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    }
                }
                viewModelSystemIconShowViewVISIBLEViewGONE2 = viewModelSystemIconShowGet ? 0 : 8;
            } else {
                viewModelSystemIconShowViewVISIBLEViewGONE2 = viewModelSystemIconShowViewVISIBLEViewGONE;
            }
            if ((dirtyFlags & 400) != 0) {
                if (viewModel != null) {
                    viewModelSystemBgShow = viewModel.systemBgShow;
                } else {
                    viewModelSystemBgShow = null;
                }
                viewModelSystemIconShowViewVISIBLEViewGONE3 = viewModelSystemIconShowViewVISIBLEViewGONE2;
                updateRegistration(4, viewModelSystemBgShow);
                if (viewModelSystemBgShow != null) {
                    viewModelSystemBgShowGet = viewModelSystemBgShow.get();
                }
                if ((dirtyFlags & 400) != 0) {
                    if (viewModelSystemBgShowGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    }
                }
                viewModelSystemBgShowViewVISIBLEViewGONE = viewModelSystemBgShowGet ? 0 : 8;
            } else {
                viewModelSystemIconShowViewVISIBLEViewGONE3 = viewModelSystemIconShowViewVISIBLEViewGONE2;
            }
            if ((dirtyFlags & 416) != 0) {
                if (viewModel != null) {
                    viewModelDisableVideo = viewModel.disableVideo;
                } else {
                    viewModelDisableVideo = null;
                }
                updateRegistration(5, viewModelDisableVideo);
                if (viewModelDisableVideo != null) {
                    viewModelDisableVideoGet = viewModelDisableVideo.get();
                }
                if ((dirtyFlags & 416) != 0) {
                    if (viewModelDisableVideoGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= 512;
                    }
                }
                viewModelDisableVideoMboundView4AndroidDrawableBmwId9SettingsSystemOnMboundView4AndroidDrawableBmwId9SettingsSystemOff = viewModelDisableVideoGet ? AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.bmw_id9_settings_system_on) : AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.bmw_id9_settings_system_off);
            } else {
                viewModelDisableVideoMboundView4AndroidDrawableBmwId9SettingsSystemOnMboundView4AndroidDrawableBmwId9SettingsSystemOff = null;
            }
            if ((dirtyFlags & 448) != 0) {
                if (viewModel != null) {
                    viewModelRearMirror = viewModel.rearMirror;
                } else {
                    viewModelRearMirror = null;
                }
                updateRegistration(6, viewModelRearMirror);
                if (viewModelRearMirror != null) {
                    viewModelRearMirrorGet = viewModelRearMirror.get();
                }
                if ((dirtyFlags & 448) != 0) {
                    if (viewModelRearMirrorGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                }
                if (viewModelRearMirrorGet) {
                    context = this.mboundView3.getContext();
                    dirtyFlags2 = dirtyFlags;
                    i = R.drawable.bmw_id9_settings_system_on;
                } else {
                    dirtyFlags2 = dirtyFlags;
                    context = this.mboundView3.getContext();
                    i = R.drawable.bmw_id9_settings_system_off;
                }
                Drawable viewModelRearMirrorMboundView3AndroidDrawableBmwId9SettingsSystemOnMboundView3AndroidDrawableBmwId9SettingsSystemOff2 = AppCompatResources.getDrawable(context, i);
                viewModelDisableVideoMboundView4AndroidDrawableBmwId9SettingsSystemOnMboundView4AndroidDrawableBmwId9SettingsSystemOff = viewModelDisableVideoMboundView4AndroidDrawableBmwId9SettingsSystemOnMboundView4AndroidDrawableBmwId9SettingsSystemOff;
                viewModelSystemIconShowViewVISIBLEViewGONE4 = viewModelSystemIconShowViewVISIBLEViewGONE3;
                dirtyFlags = dirtyFlags2;
                viewModelParkRadarMboundView6AndroidDrawableBmwId9SettingsSystemOnMboundView6AndroidDrawableBmwId9SettingsSystemOff = viewModelParkRadarMboundView6AndroidDrawableBmwId9SettingsSystemOnMboundView6AndroidDrawableBmwId9SettingsSystemOff2;
                viewModelRearMirrorMboundView3AndroidDrawableBmwId9SettingsSystemOnMboundView3AndroidDrawableBmwId9SettingsSystemOff = viewModelRearMirrorMboundView3AndroidDrawableBmwId9SettingsSystemOnMboundView3AndroidDrawableBmwId9SettingsSystemOff2;
            } else {
                viewModelSystemIconShowViewVISIBLEViewGONE4 = viewModelSystemIconShowViewVISIBLEViewGONE3;
                viewModelParkRadarMboundView6AndroidDrawableBmwId9SettingsSystemOnMboundView6AndroidDrawableBmwId9SettingsSystemOff = viewModelParkRadarMboundView6AndroidDrawableBmwId9SettingsSystemOnMboundView6AndroidDrawableBmwId9SettingsSystemOff2;
                viewModelRearMirrorMboundView3AndroidDrawableBmwId9SettingsSystemOnMboundView3AndroidDrawableBmwId9SettingsSystemOff = null;
            }
        } else {
            viewModelParkRadarMboundView6AndroidDrawableBmwId9SettingsSystemOnMboundView6AndroidDrawableBmwId9SettingsSystemOff = null;
            viewModelRearMirrorMboundView3AndroidDrawableBmwId9SettingsSystemOnMboundView3AndroidDrawableBmwId9SettingsSystemOff = null;
        }
        if ((dirtyFlags & 256) != 0) {
            this.bmwId8SettingsHomeback.setOnClickListener(this.mCallback264);
        }
        if ((dirtyFlags & 400) != 0) {
            this.mboundView2.setVisibility(viewModelSystemBgShowViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 448) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, viewModelRearMirrorMboundView3AndroidDrawableBmwId9SettingsSystemOnMboundView3AndroidDrawableBmwId9SettingsSystemOff);
        }
        if ((dirtyFlags & 416) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, viewModelDisableVideoMboundView4AndroidDrawableBmwId9SettingsSystemOnMboundView4AndroidDrawableBmwId9SettingsSystemOff);
        }
        if ((dirtyFlags & 386) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, viewModelParkLinesMboundView5AndroidDrawableBmwId9SettingsSystemOnMboundView5AndroidDrawableBmwId9SettingsSystemOff);
        }
        if ((dirtyFlags & 388) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView6, viewModelParkRadarMboundView6AndroidDrawableBmwId9SettingsSystemOnMboundView6AndroidDrawableBmwId9SettingsSystemOff);
        }
        if ((dirtyFlags & 385) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView7, viewModelParkMuteMboundView7AndroidDrawableBmwId9SettingsSystemOnMboundView7AndroidDrawableBmwId9SettingsSystemOff);
        }
        if ((dirtyFlags & 392) != 0) {
            this.mboundView8.setVisibility(viewModelSystemIconShowViewVISIBLEViewGONE4);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        if (viewModel != null) {
            viewModel.backClick();
        }
    }
}
