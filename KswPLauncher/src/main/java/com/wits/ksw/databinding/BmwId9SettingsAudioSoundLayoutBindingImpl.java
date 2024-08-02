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
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class BmwId9SettingsAudioSoundLayoutBindingImpl extends BmwId9SettingsAudioSoundLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    private final LinearLayout mboundView10;
    private final TextView mboundView11;
    private final TextView mboundView13;
    private final TextView mboundView15;
    private final ImageView mboundView2;
    private final ImageView mboundView3;
    private final ScrollView mboundView4;
    private final ImageView mboundView5;
    private final ImageView mboundView6;
    private final ImageView mboundView7;
    private final ImageView mboundView8;
    private final ImageView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id9_settings_audio_sound_lay, 17);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_sound_user, 18);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_sound_pop, 19);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_sound_class, 20);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_sound_rock, 21);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_sound_jazz, 22);
        sparseIntArray.put(R.id.bmw_id9_settings_audio_sound_dance, 23);
        sparseIntArray.put(R.id.bmw_id9_settings_bass_sub_btn, 24);
        sparseIntArray.put(R.id.bmw_id9_settings_bass_add_btn, 25);
        sparseIntArray.put(R.id.bmw_id9_settings_mid_sub_btn, 26);
        sparseIntArray.put(R.id.bmw_id9_settings_mid_add_btn, 27);
        sparseIntArray.put(R.id.bmw_id9_settings_tre_sub_btn, 28);
        sparseIntArray.put(R.id.bmw_id9_settings_tre_add_btn, 29);
    }

    public BmwId9SettingsAudioSoundLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }

    private BmwId9SettingsAudioSoundLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 9, (SeekBar) bindings[12], (SeekBar) bindings[14], (RelativeLayout) bindings[20], (RelativeLayout) bindings[23], (RelativeLayout) bindings[22], (LinearLayout) bindings[17], (RelativeLayout) bindings[19], (RelativeLayout) bindings[21], (RelativeLayout) bindings[18], (SeekBar) bindings[16], (ImageButton) bindings[25], (ImageButton) bindings[24], (ImageButton) bindings[27], (ImageButton) bindings[26], (ImageButton) bindings[29], (ImageButton) bindings[28]);
        this.mDirtyFlags = -1;
        this.bmwId9SettingsAudioLow.setTag(null);
        this.bmwId9SettingsAudioMid.setTag(null);
        this.bmwId9SettingsAudioTre.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[10];
        this.mboundView10 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[11];
        this.mboundView11 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[15];
        this.mboundView15 = textView3;
        textView3.setTag(null);
        ImageView imageView2 = (ImageView) bindings[2];
        this.mboundView2 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[3];
        this.mboundView3 = imageView3;
        imageView3.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[4];
        this.mboundView4 = scrollView;
        scrollView.setTag(null);
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
        ImageView imageView8 = (ImageView) bindings[9];
        this.mboundView9 = imageView8;
        imageView8.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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

    @Override // com.wits.ksw.databinding.BmwId9SettingsAudioSoundLayoutBinding
    public void setViewModel(BmwId9SettingsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 512;
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
            case 8:
                return onChangeViewModelSystemBgShow((ObservableBoolean) object, fieldId);
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

    private boolean onChangeViewModelSystemBgShow(ObservableBoolean ViewModelSystemBgShow, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        Drawable viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect;
        Drawable viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect;
        Drawable viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect;
        String viewModelBassVolumeStrGet;
        int viewModelMidVolumeGet;
        int viewModelTreVolumeGet;
        Drawable viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect;
        int viewModelBassVolumeGet;
        int viewModelSystemBgShowViewGONEViewVISIBLE;
        Drawable viewModelUserTypeShowMboundView3AndroidDrawableBmwId9SettingsSystemUpMboundView3AndroidDrawableBmwId9SettingsSystemDown;
        int viewModelUserTypeShowViewVISIBLEViewGONE;
        Drawable viewModelEqTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect;
        Drawable viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect2;
        ObservableInt viewModelBassVolume;
        ObservableBoolean viewModelUserTypeShow;
        ObservableBoolean viewModelSystemBgShow;
        ObservableField<String> viewModelBassVolumeStr;
        ObservableInt viewModelEqType;
        int viewModelEqTypeGet;
        boolean viewModelEqTypeInt2;
        Drawable viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect2;
        Drawable viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect2;
        Drawable viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect3;
        Drawable viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect;
        Drawable viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect2;
        Drawable viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect3;
        ObservableInt viewModelTreVolume;
        ObservableField<String> viewModelTreVolumeStr;
        long dirtyFlags2;
        int i;
        Context context;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect4 = null;
        ObservableBoolean viewModelUserTypeShow2 = null;
        boolean viewModelEqTypeInt3 = false;
        int viewModelUserTypeShowViewGONEViewVISIBLE = 0;
        ObservableInt viewModelMidVolume = null;
        ObservableField<String> viewModelMidVolumeStr = null;
        boolean viewModelEqTypeInt4 = false;
        Drawable viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect4 = null;
        String viewModelMidVolumeStrGet = null;
        String viewModelTreVolumeStrGet = null;
        Drawable viewModelUserTypeShowMboundView3AndroidDrawableBmwId9SettingsSystemUpMboundView3AndroidDrawableBmwId9SettingsSystemDown2 = null;
        Drawable viewModelEqTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect2 = null;
        int viewModelUserTypeShowViewVISIBLEViewGONE2 = 0;
        int viewModelBassVolumeGet2 = 0;
        boolean viewModelUserTypeShowGet = false;
        boolean viewModelSystemBgShowGet = false;
        Drawable viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect3 = null;
        int viewModelTreVolumeGet2 = 0;
        int viewModelMidVolumeGet2 = 0;
        String viewModelBassVolumeStrGet2 = null;
        Drawable viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect5 = null;
        Drawable viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect2 = null;
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 2047) != 0) {
            if ((dirtyFlags & 1537) != 0) {
                if (viewModel != null) {
                    viewModelBassVolume = viewModel.bassVolume;
                } else {
                    viewModelBassVolume = null;
                }
                updateRegistration(0, viewModelBassVolume);
                if (viewModelBassVolume != null) {
                    viewModelBassVolumeGet2 = viewModelBassVolume.get();
                }
            } else {
                viewModelBassVolume = null;
            }
            if ((dirtyFlags & 1538) != 0) {
                if (viewModel != null) {
                    viewModelUserTypeShow2 = viewModel.userTypeShow;
                }
                updateRegistration(1, viewModelUserTypeShow2);
                if (viewModelUserTypeShow2 != null) {
                    viewModelUserTypeShowGet = viewModelUserTypeShow2.get();
                }
                if ((dirtyFlags & 1538) != 0) {
                    if (viewModelUserTypeShowGet) {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_SET_REPEAT_MODE | 4194304;
                    } else {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PLAY_FROM_URI | PlaybackStateCompat.ACTION_PREPARE_FROM_URI | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    }
                }
                viewModelUserTypeShowViewGONEViewVISIBLE = viewModelUserTypeShowGet ? 8 : 0;
                if (viewModelUserTypeShowGet) {
                    context = this.mboundView3.getContext();
                    dirtyFlags2 = dirtyFlags;
                    i = R.drawable.bmw_id9_settings_system_up;
                } else {
                    dirtyFlags2 = dirtyFlags;
                    context = this.mboundView3.getContext();
                    i = R.drawable.bmw_id9_settings_system_down;
                }
                viewModelUserTypeShowMboundView3AndroidDrawableBmwId9SettingsSystemUpMboundView3AndroidDrawableBmwId9SettingsSystemDown2 = AppCompatResources.getDrawable(context, i);
                viewModelUserTypeShowViewVISIBLEViewGONE2 = viewModelUserTypeShowGet ? 0 : 8;
                dirtyFlags = dirtyFlags2;
            }
            if ((dirtyFlags & 1540) != 0) {
                if (viewModel != null) {
                    viewModelMidVolume = viewModel.midVolume;
                }
                updateRegistration(2, viewModelMidVolume);
                if (viewModelMidVolume != null) {
                    viewModelMidVolumeGet2 = viewModelMidVolume.get();
                }
            }
            if ((dirtyFlags & 1544) != 0) {
                if (viewModel != null) {
                    viewModelMidVolumeStr = viewModel.midVolumeStr;
                }
                updateRegistration(3, viewModelMidVolumeStr);
                if (viewModelMidVolumeStr != null) {
                    viewModelMidVolumeStrGet = viewModelMidVolumeStr.get();
                }
            }
            if ((dirtyFlags & 1552) != 0) {
                if (viewModel != null) {
                    viewModelTreVolumeStr = viewModel.treVolumeStr;
                } else {
                    viewModelTreVolumeStr = null;
                }
                updateRegistration(4, viewModelTreVolumeStr);
                if (viewModelTreVolumeStr != null) {
                    viewModelTreVolumeStrGet = viewModelTreVolumeStr.get();
                }
            }
            if ((dirtyFlags & 1568) != 0) {
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
            if ((dirtyFlags & 1600) != 0) {
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
                boolean viewModelEqTypeInt5 = viewModelEqTypeGet == 5;
                viewModelUserTypeShow = viewModelUserTypeShow2;
                boolean viewModelEqTypeInt1 = true;
                if (viewModelEqTypeGet != 1) {
                    viewModelEqTypeInt1 = false;
                }
                if ((dirtyFlags & 1600) != 0) {
                    if (viewModelEqTypeInt22) {
                        dirtyFlags |= 268435456;
                    } else {
                        dirtyFlags |= 134217728;
                    }
                }
                if ((dirtyFlags & 1600) != 0) {
                    if (viewModelEqTypeInt32) {
                        dirtyFlags |= 16777216;
                    } else {
                        dirtyFlags |= 8388608;
                    }
                }
                if ((dirtyFlags & 1600) != 0) {
                    if (viewModelEqTypeInt42) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                }
                if ((dirtyFlags & 1600) != 0) {
                    if (viewModelEqTypeInt0) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                }
                if ((dirtyFlags & 1600) != 0) {
                    if (viewModelEqTypeInt5) {
                        dirtyFlags |= 1073741824;
                    } else {
                        dirtyFlags |= 536870912;
                    }
                }
                if ((dirtyFlags & 1600) != 0) {
                    if (viewModelEqTypeInt1) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                }
                int i2 = R.drawable.bmw_id9_settings_select;
                Context context2 = this.mboundView6.getContext();
                if (!viewModelEqTypeInt22) {
                    i2 = R.drawable.bmw_id9_settings_unselect;
                }
                Drawable viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect3 = AppCompatResources.getDrawable(context2, i2);
                if (viewModelEqTypeInt32) {
                    viewModelEqTypeInt2 = viewModelEqTypeInt22;
                    viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect2 = AppCompatResources.getDrawable(this.mboundView7.getContext(), R.drawable.bmw_id9_settings_select);
                } else {
                    viewModelEqTypeInt2 = viewModelEqTypeInt22;
                    viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect2 = AppCompatResources.getDrawable(this.mboundView7.getContext(), R.drawable.bmw_id9_settings_unselect);
                }
                if (viewModelEqTypeInt42) {
                    viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect3 = viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect2;
                    viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect2 = AppCompatResources.getDrawable(this.mboundView8.getContext(), R.drawable.bmw_id9_settings_select);
                } else {
                    viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect3 = viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect2;
                    viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect2 = AppCompatResources.getDrawable(this.mboundView8.getContext(), R.drawable.bmw_id9_settings_unselect);
                }
                if (viewModelEqTypeInt0) {
                    viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect3 = viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect2;
                    viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect = AppCompatResources.getDrawable(this.mboundView2.getContext(), R.drawable.bmw_id9_settings_select);
                } else {
                    viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect3 = viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect2;
                    viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect = AppCompatResources.getDrawable(this.mboundView2.getContext(), R.drawable.bmw_id9_settings_unselect);
                }
                Drawable viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect3 = AppCompatResources.getDrawable(this.mboundView9.getContext(), viewModelEqTypeInt5 ? R.drawable.bmw_id9_settings_select : R.drawable.bmw_id9_settings_unselect);
                if (viewModelEqTypeInt1) {
                    viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect2 = viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect;
                    viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect3 = AppCompatResources.getDrawable(this.mboundView5.getContext(), R.drawable.bmw_id9_settings_select);
                } else {
                    viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect2 = viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect;
                    viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect3 = AppCompatResources.getDrawable(this.mboundView5.getContext(), R.drawable.bmw_id9_settings_unselect);
                }
                viewModelEqTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect2 = viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect3;
                viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect2 = viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect3;
                viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect4 = viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect3;
                viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect4 = viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect2;
                viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect5 = viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect3;
                dirtyFlags = dirtyFlags;
                viewModelEqTypeInt4 = viewModelEqTypeInt32;
                viewModelEqTypeInt3 = viewModelEqTypeInt2;
            } else {
                viewModelUserTypeShow = viewModelUserTypeShow2;
            }
            if ((dirtyFlags & 1664) != 0) {
                if (viewModel != null) {
                    viewModelBassVolumeStr = viewModel.bassVolumeStr;
                } else {
                    viewModelBassVolumeStr = null;
                }
                updateRegistration(7, viewModelBassVolumeStr);
                if (viewModelBassVolumeStr != null) {
                    viewModelBassVolumeStrGet2 = viewModelBassVolumeStr.get();
                }
            }
            if ((dirtyFlags & 1792) != 0) {
                if (viewModel != null) {
                    viewModelSystemBgShow = viewModel.systemBgShow;
                } else {
                    viewModelSystemBgShow = null;
                }
                int viewModelSystemBgShowViewGONEViewVISIBLE2 = 8;
                updateRegistration(8, viewModelSystemBgShow);
                if (viewModelSystemBgShow != null) {
                    viewModelSystemBgShowGet = viewModelSystemBgShow.get();
                }
                if ((dirtyFlags & 1792) != 0) {
                    if (viewModelSystemBgShowGet) {
                        dirtyFlags |= 67108864;
                    } else {
                        dirtyFlags |= 33554432;
                    }
                }
                if (!viewModelSystemBgShowGet) {
                    viewModelSystemBgShowViewGONEViewVISIBLE2 = 0;
                }
                viewModelUserTypeShowMboundView3AndroidDrawableBmwId9SettingsSystemUpMboundView3AndroidDrawableBmwId9SettingsSystemDown = viewModelUserTypeShowMboundView3AndroidDrawableBmwId9SettingsSystemUpMboundView3AndroidDrawableBmwId9SettingsSystemDown2;
                viewModelEqTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect2;
                viewModelBassVolumeGet = viewModelBassVolumeGet2;
                viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect2;
                viewModelUserTypeShowViewVISIBLEViewGONE = viewModelUserTypeShowViewVISIBLEViewGONE2;
                viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect5;
                viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect4;
                viewModelSystemBgShowViewGONEViewVISIBLE = viewModelSystemBgShowViewGONEViewVISIBLE2;
                viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect3;
                viewModelTreVolumeGet = viewModelTreVolumeGet2;
                viewModelMidVolumeGet = viewModelMidVolumeGet2;
                viewModelBassVolumeStrGet = viewModelBassVolumeStrGet2;
            } else {
                viewModelUserTypeShowMboundView3AndroidDrawableBmwId9SettingsSystemUpMboundView3AndroidDrawableBmwId9SettingsSystemDown = viewModelUserTypeShowMboundView3AndroidDrawableBmwId9SettingsSystemUpMboundView3AndroidDrawableBmwId9SettingsSystemDown2;
                viewModelEqTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect2;
                viewModelBassVolumeGet = viewModelBassVolumeGet2;
                viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect2;
                viewModelUserTypeShowViewVISIBLEViewGONE = viewModelUserTypeShowViewVISIBLEViewGONE2;
                viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect5;
                viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect4;
                viewModelSystemBgShowViewGONEViewVISIBLE = 0;
                viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect = viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect3;
                viewModelTreVolumeGet = viewModelTreVolumeGet2;
                viewModelMidVolumeGet = viewModelMidVolumeGet2;
                viewModelBassVolumeStrGet = viewModelBassVolumeStrGet2;
            }
        } else {
            viewModelUserTypeShowMboundView3AndroidDrawableBmwId9SettingsSystemUpMboundView3AndroidDrawableBmwId9SettingsSystemDown = null;
            viewModelEqTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect = null;
            viewModelSystemBgShowViewGONEViewVISIBLE = 0;
            viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect = null;
            viewModelUserTypeShowViewVISIBLEViewGONE = 0;
            viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect = null;
            viewModelBassVolumeGet = 0;
            viewModelTreVolumeGet = 0;
            viewModelMidVolumeGet = 0;
            viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect = null;
            viewModelBassVolumeStrGet = null;
            viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect = null;
        }
        if ((dirtyFlags & 1537) != 0) {
            viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect2 = viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect;
            SeekBarBindingAdapter.setProgress(this.bmwId9SettingsAudioLow, viewModelBassVolumeGet);
        } else {
            viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect2 = viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect;
        }
        if ((dirtyFlags & 1540) != 0) {
            SeekBarBindingAdapter.setProgress(this.bmwId9SettingsAudioMid, viewModelMidVolumeGet);
        }
        if ((dirtyFlags & 1568) != 0) {
            SeekBarBindingAdapter.setProgress(this.bmwId9SettingsAudioTre, viewModelTreVolumeGet);
        }
        if ((dirtyFlags & 1792) != 0) {
            this.mboundView1.setVisibility(viewModelSystemBgShowViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 1538) != 0) {
            this.mboundView10.setVisibility(viewModelUserTypeShowViewVISIBLEViewGONE);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, viewModelUserTypeShowMboundView3AndroidDrawableBmwId9SettingsSystemUpMboundView3AndroidDrawableBmwId9SettingsSystemDown);
            this.mboundView4.setVisibility(viewModelUserTypeShowViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 1664) != 0) {
            TextViewBindingAdapter.setText(this.mboundView11, viewModelBassVolumeStrGet);
        }
        if ((dirtyFlags & 1544) != 0) {
            TextViewBindingAdapter.setText(this.mboundView13, viewModelMidVolumeStrGet);
        }
        if ((dirtyFlags & 1552) != 0) {
            TextViewBindingAdapter.setText(this.mboundView15, viewModelTreVolumeStrGet);
        }
        if ((dirtyFlags & 1600) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, viewModelEqTypeInt0MboundView2AndroidDrawableBmwId9SettingsSelectMboundView2AndroidDrawableBmwId9SettingsUnselect4);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, viewModelEqTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView6, viewModelEqTypeInt2MboundView6AndroidDrawableBmwId9SettingsSelectMboundView6AndroidDrawableBmwId9SettingsUnselect2);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView7, viewModelEqTypeInt3MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView8, viewModelEqTypeInt4MboundView8AndroidDrawableBmwId9SettingsSelectMboundView8AndroidDrawableBmwId9SettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView9, viewModelEqTypeInt5MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect);
        }
    }
}
