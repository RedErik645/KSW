package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.SeekBarBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class BenzMbuxSettingsAudioSoundLayoutBindingImpl extends BenzMbuxSettingsAudioSoundLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    private final TextView mboundView10;
    private final TextView mboundView12;
    private final TextView mboundView14;
    private final ImageView mboundView2;
    private final ScrollView mboundView3;
    private final ImageView mboundView4;
    private final ImageView mboundView5;
    private final ImageView mboundView6;
    private final ImageView mboundView7;
    private final ImageView mboundView8;
    private final LinearLayout mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_settings_audio_sound_lay, 16);
        sparseIntArray.put(R.id.mbux_settings_audio_sound_user, 17);
        sparseIntArray.put(R.id.mbux_settings_audio_sound_pop, 18);
        sparseIntArray.put(R.id.mbux_settings_audio_sound_class, 19);
        sparseIntArray.put(R.id.mbux_settings_audio_sound_rock, 20);
        sparseIntArray.put(R.id.mbux_settings_audio_sound_jazz, 21);
        sparseIntArray.put(R.id.mbux_settings_audio_sound_dance, 22);
        sparseIntArray.put(R.id.mbux_settings_bass_sub_btn, 23);
        sparseIntArray.put(R.id.mbux_settings_bass_add_btn, 24);
        sparseIntArray.put(R.id.mbux_settings_mid_sub_btn, 25);
        sparseIntArray.put(R.id.mbux_settings_mid_add_btn, 26);
        sparseIntArray.put(R.id.mbux_settings_tre_sub_btn, 27);
        sparseIntArray.put(R.id.mbux_settings_tre_add_btn, 28);
    }

    public BenzMbuxSettingsAudioSoundLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }

    private BenzMbuxSettingsAudioSoundLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (SeekBar) bindings[11], (SeekBar) bindings[13], (RelativeLayout) bindings[19], (RelativeLayout) bindings[22], (RelativeLayout) bindings[21], (LinearLayout) bindings[16], (RelativeLayout) bindings[18], (RelativeLayout) bindings[20], (RelativeLayout) bindings[17], (SeekBar) bindings[15], (ImageButton) bindings[24], (ImageButton) bindings[23], (ImageButton) bindings[26], (ImageButton) bindings[25], (ImageButton) bindings[28], (ImageButton) bindings[27]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[12];
        this.mboundView12 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[14];
        this.mboundView14 = textView3;
        textView3.setTag(null);
        ImageView imageView2 = (ImageView) bindings[2];
        this.mboundView2 = imageView2;
        imageView2.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[3];
        this.mboundView3 = scrollView;
        scrollView.setTag(null);
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
        LinearLayout linearLayout = (LinearLayout) bindings[9];
        this.mboundView9 = linearLayout;
        linearLayout.setTag(null);
        this.mbuxSettingsAudioLow.setTag(null);
        this.mbuxSettingsAudioMid.setTag(null);
        this.mbuxSettingsAudioTre.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512;
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

    @Override // com.wits.ksw.databinding.BenzMbuxSettingsAudioSoundLayoutBinding
    public void setViewModel(BenzMbuxSettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelBassVolume((ObservableInt) object, fieldId);
            case 1:
                return onChangeViewModelUserTypeShow((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeViewModelMidVolume((ObservableInt) object, fieldId);
            case 3:
                return onChangeViewModelMidVolumeStr((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelTreVolumeStr((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelTreVolume((ObservableInt) object, fieldId);
            case 6:
                return onChangeViewModelEqType((ObservableInt) object, fieldId);
            case 7:
                return onChangeViewModelBassVolumeStr((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelBassVolume(ObservableInt ViewModelBassVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelUserTypeShow(ObservableBoolean ViewModelUserTypeShow, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelMidVolume(ObservableInt ViewModelMidVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelMidVolumeStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelTreVolumeStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelTreVolume(ObservableInt ViewModelTreVolume, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelEqType(ObservableInt ViewModelEqType, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelBassVolumeStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r0v8 'viewModelBassVolumeGet'  int: [D('viewModelBassVolumeGet' int), D('viewModelMidVolumeGet' int)] */
    /* JADX INFO: Multiple debug info for r0v10 int: [D('viewModelTreVolumeStrGet' java.lang.String), D('viewModelBassVolumeGet' int)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int viewModelMidVolumeGet;
        int viewModelTreVolumeGet;
        String viewModelBassVolumeStrGet;
        Drawable viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown;
        Drawable viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect;
        Drawable viewModelEqTypeInt2MboundView5AndroidDrawableMbuxSettingsSelectMboundView5AndroidDrawableMbuxSettingsUnselect;
        int viewModelBassVolumeGet;
        int viewModelUserTypeShowViewVISIBLEViewGONE;
        String viewModelTreVolumeStrGet;
        int viewModelBassVolumeGet2;
        int viewModelBassVolumeGet3;
        int viewModelMidVolumeGet2;
        Drawable viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect;
        ObservableInt viewModelBassVolume;
        ObservableInt viewModelBassVolume2;
        ObservableBoolean viewModelUserTypeShow;
        ObservableField<String> viewModelBassVolumeStr;
        ObservableInt viewModelEqType;
        int viewModelEqTypeGet;
        boolean viewModelEqTypeInt2;
        Drawable viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect;
        Drawable viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect2;
        Drawable viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect2;
        Drawable viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect3;
        Drawable viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect4;
        ObservableInt viewModelTreVolume;
        ObservableField<String> viewModelTreVolumeStr;
        Drawable drawable;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableBoolean viewModelUserTypeShow2 = null;
        Drawable viewModelEqTypeInt0MboundView1AndroidDrawableMbuxSettingsSelectMboundView1AndroidDrawableMbuxSettingsUnselect = null;
        boolean viewModelEqTypeInt3 = false;
        int viewModelUserTypeShowViewGONEViewVISIBLE = 0;
        Drawable viewModelEqTypeInt0MboundView1AndroidDrawableMbuxSettingsSelectMboundView1AndroidDrawableMbuxSettingsUnselect2 = null;
        ObservableInt viewModelMidVolume = null;
        ObservableField<String> viewModelMidVolumeStr = null;
        boolean viewModelEqTypeInt4 = false;
        Drawable viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect3 = null;
        String viewModelMidVolumeStrGet = null;
        String viewModelTreVolumeStrGet2 = null;
        int viewModelUserTypeShowViewVISIBLEViewGONE2 = 0;
        int viewModelBassVolumeGet4 = 0;
        boolean viewModelUserTypeShowGet = false;
        Drawable viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect4 = null;
        int viewModelTreVolumeGet2 = 0;
        int viewModelMidVolumeGet3 = 0;
        Drawable viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect2 = null;
        Drawable viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown2 = null;
        BenzMbuxSettingsViewModel viewModel = this.mViewModel;
        Drawable viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect5 = null;
        if ((dirtyFlags & 1023) != 0) {
            if ((dirtyFlags & 769) != 0) {
                if (viewModel != null) {
                    viewModelBassVolume = viewModel.bassVolume;
                } else {
                    viewModelBassVolume = null;
                }
                viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect = null;
                updateRegistration(0, viewModelBassVolume);
                if (viewModelBassVolume != null) {
                    viewModelBassVolumeGet4 = viewModelBassVolume.get();
                }
            } else {
                viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect = null;
                viewModelBassVolume = null;
            }
            if ((dirtyFlags & 770) != 0) {
                if (viewModel != null) {
                    viewModelUserTypeShow2 = viewModel.userTypeShow;
                }
                updateRegistration(1, viewModelUserTypeShow2);
                if (viewModelUserTypeShow2 != null) {
                    viewModelUserTypeShowGet = viewModelUserTypeShow2.get();
                }
                if ((dirtyFlags & 770) != 0) {
                    if (viewModelUserTypeShowGet) {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PLAY_FROM_URI | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | 33554432;
                    } else {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM | PlaybackStateCompat.ACTION_SET_REPEAT_MODE | 16777216;
                    }
                }
                int i = 8;
                viewModelUserTypeShowViewGONEViewVISIBLE = viewModelUserTypeShowGet ? 8 : 0;
                if (viewModelUserTypeShowGet) {
                    i = 0;
                }
                viewModelUserTypeShowViewVISIBLEViewGONE2 = i;
                if (viewModelUserTypeShowGet) {
                    viewModelBassVolume2 = viewModelBassVolume;
                    drawable = AppCompatResources.getDrawable(this.mboundView2.getContext(), R.drawable.mbux_settings_system_up);
                } else {
                    viewModelBassVolume2 = viewModelBassVolume;
                    drawable = AppCompatResources.getDrawable(this.mboundView2.getContext(), R.drawable.mbux_settings_system_down);
                }
                viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown2 = drawable;
            } else {
                viewModelBassVolume2 = viewModelBassVolume;
            }
            if ((dirtyFlags & 772) != 0) {
                if (viewModel != null) {
                    viewModelMidVolume = viewModel.midVolume;
                }
                updateRegistration(2, viewModelMidVolume);
                if (viewModelMidVolume != null) {
                    viewModelMidVolumeGet3 = viewModelMidVolume.get();
                }
            }
            if ((dirtyFlags & 776) != 0) {
                if (viewModel != null) {
                    viewModelMidVolumeStr = viewModel.midVolumeStr;
                }
                updateRegistration(3, viewModelMidVolumeStr);
                if (viewModelMidVolumeStr != null) {
                    viewModelMidVolumeStrGet = viewModelMidVolumeStr.get();
                }
            }
            if ((dirtyFlags & 784) != 0) {
                if (viewModel != null) {
                    viewModelTreVolumeStr = viewModel.treVolumeStr;
                } else {
                    viewModelTreVolumeStr = null;
                }
                updateRegistration(4, viewModelTreVolumeStr);
                if (viewModelTreVolumeStr != null) {
                    viewModelTreVolumeStrGet2 = viewModelTreVolumeStr.get();
                }
            }
            if ((dirtyFlags & 800) != 0) {
                if (viewModel != null) {
                    viewModelTreVolume = viewModel.treVolume;
                } else {
                    viewModelTreVolume = null;
                }
                updateRegistration(5, viewModelTreVolume);
                if (viewModelTreVolume != null) {
                    viewModelTreVolumeGet2 = viewModelTreVolume.get();
                }
            }
            if ((dirtyFlags & 832) != 0) {
                if (viewModel != null) {
                    viewModelEqType = viewModel.eqType;
                } else {
                    viewModelEqType = null;
                }
                updateRegistration(6, viewModelEqType);
                if (viewModelEqType != null) {
                    viewModelEqTypeGet = viewModelEqType.get();
                } else {
                    viewModelEqTypeGet = 0;
                }
                boolean viewModelEqTypeInt22 = viewModelEqTypeGet == 2;
                boolean viewModelEqTypeInt32 = viewModelEqTypeGet == 3;
                boolean viewModelEqTypeInt42 = viewModelEqTypeGet == 4;
                boolean viewModelEqTypeInt0 = viewModelEqTypeGet == 0;
                viewModelUserTypeShow = viewModelUserTypeShow2;
                boolean viewModelEqTypeInt5 = viewModelEqTypeGet == 5;
                boolean viewModelEqTypeInt1 = true;
                if (viewModelEqTypeGet != 1) {
                    viewModelEqTypeInt1 = false;
                }
                if ((dirtyFlags & 832) != 0) {
                    if (viewModelEqTypeInt22) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    }
                }
                if ((dirtyFlags & 832) != 0) {
                    if (viewModelEqTypeInt32) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    }
                }
                if ((dirtyFlags & 832) != 0) {
                    if (viewModelEqTypeInt42) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                    }
                }
                if ((dirtyFlags & 832) != 0) {
                    if (viewModelEqTypeInt0) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                }
                if ((dirtyFlags & 832) != 0) {
                    if (viewModelEqTypeInt5) {
                        dirtyFlags |= 134217728;
                    } else {
                        dirtyFlags |= 67108864;
                    }
                }
                if ((dirtyFlags & 832) != 0) {
                    if (viewModelEqTypeInt1) {
                        dirtyFlags |= 8388608;
                    } else {
                        dirtyFlags |= 4194304;
                    }
                }
                int i2 = R.drawable.mbux_settings_select;
                Context context = this.mboundView5.getContext();
                if (!viewModelEqTypeInt22) {
                    i2 = R.drawable.mbux_settings_unselect;
                }
                Drawable viewModelEqTypeInt2MboundView5AndroidDrawableMbuxSettingsSelectMboundView5AndroidDrawableMbuxSettingsUnselect2 = AppCompatResources.getDrawable(context, i2);
                if (viewModelEqTypeInt32) {
                    viewModelEqTypeInt2 = viewModelEqTypeInt22;
                    viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect = AppCompatResources.getDrawable(this.mboundView6.getContext(), R.drawable.mbux_settings_select);
                } else {
                    viewModelEqTypeInt2 = viewModelEqTypeInt22;
                    viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect = AppCompatResources.getDrawable(this.mboundView6.getContext(), R.drawable.mbux_settings_unselect);
                }
                Drawable viewModelEqTypeInt4MboundView7AndroidDrawableMbuxSettingsSelectMboundView7AndroidDrawableMbuxSettingsUnselect = AppCompatResources.getDrawable(this.mboundView7.getContext(), viewModelEqTypeInt42 ? R.drawable.mbux_settings_select : R.drawable.mbux_settings_unselect);
                Drawable viewModelEqTypeInt0MboundView1AndroidDrawableMbuxSettingsSelectMboundView1AndroidDrawableMbuxSettingsUnselect3 = AppCompatResources.getDrawable(this.mboundView1.getContext(), viewModelEqTypeInt0 ? R.drawable.mbux_settings_select : R.drawable.mbux_settings_unselect);
                if (viewModelEqTypeInt5) {
                    viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect2 = viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect;
                    viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect2 = AppCompatResources.getDrawable(this.mboundView8.getContext(), R.drawable.mbux_settings_select);
                } else {
                    viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect2 = viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect;
                    viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect2 = AppCompatResources.getDrawable(this.mboundView8.getContext(), R.drawable.mbux_settings_unselect);
                }
                if (viewModelEqTypeInt1) {
                    viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect3 = viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect2;
                    viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect4 = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.mbux_settings_select);
                } else {
                    viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect3 = viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect2;
                    viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect4 = AppCompatResources.getDrawable(this.mboundView4.getContext(), R.drawable.mbux_settings_unselect);
                }
                viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect2 = viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect4;
                viewModelEqTypeInt0MboundView1AndroidDrawableMbuxSettingsSelectMboundView1AndroidDrawableMbuxSettingsUnselect = viewModelEqTypeInt0MboundView1AndroidDrawableMbuxSettingsSelectMboundView1AndroidDrawableMbuxSettingsUnselect3;
                viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect3 = viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect2;
                viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect4 = viewModelEqTypeInt2MboundView5AndroidDrawableMbuxSettingsSelectMboundView5AndroidDrawableMbuxSettingsUnselect2;
                viewModelEqTypeInt0MboundView1AndroidDrawableMbuxSettingsSelectMboundView1AndroidDrawableMbuxSettingsUnselect2 = viewModelEqTypeInt4MboundView7AndroidDrawableMbuxSettingsSelectMboundView7AndroidDrawableMbuxSettingsUnselect;
                dirtyFlags = dirtyFlags;
                viewModelEqTypeInt4 = viewModelEqTypeInt32;
                viewModelEqTypeInt3 = viewModelEqTypeInt2;
                viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect5 = viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect3;
            } else {
                viewModelUserTypeShow = viewModelUserTypeShow2;
                viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect5 = viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect;
            }
            if ((dirtyFlags & 896) != 0) {
                if (viewModel != null) {
                    viewModelBassVolumeStr = viewModel.bassVolumeStr;
                } else {
                    viewModelBassVolumeStr = null;
                }
                updateRegistration(7, viewModelBassVolumeStr);
                if (viewModelBassVolumeStr != null) {
                    String viewModelBassVolumeStrGet2 = viewModelBassVolumeStr.get();
                    viewModelTreVolumeStrGet = viewModelTreVolumeStrGet2;
                    viewModelBassVolumeGet = viewModelBassVolumeGet4;
                    viewModelUserTypeShowViewVISIBLEViewGONE = viewModelUserTypeShowViewVISIBLEViewGONE2;
                    viewModelEqTypeInt2MboundView5AndroidDrawableMbuxSettingsSelectMboundView5AndroidDrawableMbuxSettingsUnselect = viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect4;
                    viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect2;
                    viewModelTreVolumeGet = viewModelTreVolumeGet2;
                    viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown = viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown2;
                    viewModelMidVolumeGet = viewModelMidVolumeGet3;
                    viewModelBassVolumeStrGet = viewModelBassVolumeStrGet2;
                } else {
                    viewModelTreVolumeStrGet = viewModelTreVolumeStrGet2;
                    viewModelBassVolumeGet = viewModelBassVolumeGet4;
                    viewModelUserTypeShowViewVISIBLEViewGONE = viewModelUserTypeShowViewVISIBLEViewGONE2;
                    viewModelEqTypeInt2MboundView5AndroidDrawableMbuxSettingsSelectMboundView5AndroidDrawableMbuxSettingsUnselect = viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect4;
                    viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect2;
                    viewModelTreVolumeGet = viewModelTreVolumeGet2;
                    viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown = viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown2;
                    viewModelMidVolumeGet = viewModelMidVolumeGet3;
                    viewModelBassVolumeStrGet = null;
                }
            } else {
                viewModelTreVolumeStrGet = viewModelTreVolumeStrGet2;
                viewModelBassVolumeGet = viewModelBassVolumeGet4;
                viewModelUserTypeShowViewVISIBLEViewGONE = viewModelUserTypeShowViewVISIBLEViewGONE2;
                viewModelEqTypeInt2MboundView5AndroidDrawableMbuxSettingsSelectMboundView5AndroidDrawableMbuxSettingsUnselect = viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect4;
                viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect2;
                viewModelTreVolumeGet = viewModelTreVolumeGet2;
                viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown = viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown2;
                viewModelMidVolumeGet = viewModelMidVolumeGet3;
                viewModelBassVolumeStrGet = null;
            }
        } else {
            viewModelTreVolumeStrGet = null;
            viewModelUserTypeShowViewVISIBLEViewGONE = 0;
            viewModelBassVolumeGet = 0;
            viewModelEqTypeInt2MboundView5AndroidDrawableMbuxSettingsSelectMboundView5AndroidDrawableMbuxSettingsUnselect = null;
            viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = null;
            viewModelTreVolumeGet = 0;
            viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown = null;
            viewModelMidVolumeGet = 0;
            viewModelBassVolumeStrGet = null;
        }
        if ((dirtyFlags & 832) != 0) {
            viewModelBassVolumeGet2 = viewModelBassVolumeGet;
            ImageViewBindingAdapter.setImageDrawable(this.mboundView1, viewModelEqTypeInt0MboundView1AndroidDrawableMbuxSettingsSelectMboundView1AndroidDrawableMbuxSettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, viewModelEqTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, viewModelEqTypeInt2MboundView5AndroidDrawableMbuxSettingsSelectMboundView5AndroidDrawableMbuxSettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView6, viewModelEqTypeInt3MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect3);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView7, viewModelEqTypeInt0MboundView1AndroidDrawableMbuxSettingsSelectMboundView1AndroidDrawableMbuxSettingsUnselect2);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView8, viewModelEqTypeInt5MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect5);
        } else {
            viewModelBassVolumeGet2 = viewModelBassVolumeGet;
        }
        if ((dirtyFlags & 896) != 0) {
            TextViewBindingAdapter.setText(this.mboundView10, viewModelBassVolumeStrGet);
        }
        if ((dirtyFlags & 776) != 0) {
            TextViewBindingAdapter.setText(this.mboundView12, viewModelMidVolumeStrGet);
        }
        if ((dirtyFlags & 784) != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, viewModelTreVolumeStrGet);
        }
        if ((dirtyFlags & 770) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, viewModelUserTypeShowMboundView2AndroidDrawableMbuxSettingsSystemUpMboundView2AndroidDrawableMbuxSettingsSystemDown);
            this.mboundView3.setVisibility(viewModelUserTypeShowViewGONEViewVISIBLE);
            this.mboundView9.setVisibility(viewModelUserTypeShowViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 769) != 0) {
            viewModelBassVolumeGet3 = viewModelBassVolumeGet2;
            SeekBarBindingAdapter.setProgress(this.mbuxSettingsAudioLow, viewModelBassVolumeGet3);
        } else {
            viewModelBassVolumeGet3 = viewModelBassVolumeGet2;
        }
        if ((dirtyFlags & 772) != 0) {
            viewModelMidVolumeGet2 = viewModelMidVolumeGet;
            SeekBarBindingAdapter.setProgress(this.mbuxSettingsAudioMid, viewModelMidVolumeGet2);
        } else {
            viewModelMidVolumeGet2 = viewModelMidVolumeGet;
        }
        if ((dirtyFlags & 800) != 0) {
            SeekBarBindingAdapter.setProgress(this.mbuxSettingsAudioTre, viewModelTreVolumeGet);
        }
    }
}
