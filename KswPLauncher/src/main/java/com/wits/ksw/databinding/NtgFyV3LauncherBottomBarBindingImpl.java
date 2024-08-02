package com.wits.ksw.databinding;

import android.content.res.Resources;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.generated.callback.OnLongClickListener;
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.bean.WeatherInfo;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public class NtgFyV3LauncherBottomBarBindingImpl extends NtgFyV3LauncherBottomBarBinding implements OnLongClickListener.Listener, OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback160;
    private final View.OnClickListener mCallback161;
    private final View.OnClickListener mCallback162;
    private final View.OnClickListener mCallback163;
    private final View.OnClickListener mCallback164;
    private final View.OnClickListener mCallback165;
    private final View.OnLongClickListener mCallback166;
    private final View.OnClickListener mCallback167;
    private final View.OnLongClickListener mCallback168;
    private final View.OnClickListener mCallback169;
    private final View.OnLongClickListener mCallback170;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final RelativeLayout mboundView10;
    private final RelativeLayout mboundView11;
    private final TextView mboundView12;
    private final TextView mboundView13;
    private final ImageView mboundView14;
    private final LinearLayout mboundView15;
    private final TextView mboundView4;
    private final Button mboundView6;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.weather_view, 19);
        sparseIntArray.put(R.id.weather_tv_symbol, 20);
        sparseIntArray.put(R.id.ntg_fy_v3_apps_2, 21);
        sparseIntArray.put(R.id.ntg_fy_v3_apps_1, 22);
        sparseIntArray.put(R.id.ntg_fy_v3_apps_3, 23);
    }

    public NtgFyV3LauncherBottomBarBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    private NtgFyV3LauncherBottomBarBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 11, (TextView) bindings[3], (RelativeLayout) bindings[7], (LinearLayout) bindings[1], (RelativeLayout) bindings[2], (RelativeLayout) bindings[5], (LinearLayout) bindings[16], (LinearLayout) bindings[17], (LinearLayout) bindings[18], (RelativeLayout) bindings[9], (ImageView) bindings[22], (ImageView) bindings[21], (ImageView) bindings[23], (TextView) bindings[20], (View) bindings[19]);
        this.mDirtyFlags = -1;
        this.carinfoTv.setTag(null);
        this.llBottom3.setTag(null);
        this.llBottomBarContainer.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) bindings[10];
        this.mboundView10 = relativeLayout2;
        relativeLayout2.setTag(null);
        RelativeLayout relativeLayout3 = (RelativeLayout) bindings[11];
        this.mboundView11 = relativeLayout3;
        relativeLayout3.setTag(null);
        TextView textView = (TextView) bindings[12];
        this.mboundView12 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) bindings[14];
        this.mboundView14 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[15];
        this.mboundView15 = linearLayout;
        linearLayout.setTag(null);
        TextView textView3 = (TextView) bindings[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
        Button button = (Button) bindings[6];
        this.mboundView6 = button;
        button.setTag(null);
        TextView textView4 = (TextView) bindings[8];
        this.mboundView8 = textView4;
        textView4.setTag(null);
        this.ntg3v6MainBottomCarRl.setTag(null);
        this.ntg3v6MainBottomNavRl.setTag(null);
        this.ntg3v6MainBottomShoujihlRl.setTag(null);
        this.ntg3v6MainBottomThemeRl.setTag(null);
        this.ntg3v6MainBottomVideoRl.setTag(null);
        this.ntg3v6MainBottomWeatherRl.setTag(null);
        setRootTag(root);
        this.mCallback168 = new OnLongClickListener(this, 9);
        this.mCallback164 = new OnClickListener(this, 5);
        this.mCallback160 = new OnClickListener(this, 1);
        this.mCallback169 = new OnClickListener(this, 10);
        this.mCallback165 = new OnClickListener(this, 6);
        this.mCallback161 = new OnClickListener(this, 2);
        this.mCallback166 = new OnLongClickListener(this, 7);
        this.mCallback162 = new OnClickListener(this, 3);
        this.mCallback170 = new OnLongClickListener(this, 11);
        this.mCallback167 = new OnClickListener(this, 8);
        this.mCallback163 = new OnClickListener(this, 4);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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
        if (3 != variableId) {
            return false;
        }
        setBottomViewModel((Ntg6v3LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.NtgFyV3LauncherBottomBarBinding
    public void setBottomViewModel(Ntg6v3LauncherViewModel BottomViewModel) {
        this.mBottomViewModel = BottomViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeBottomViewModelBtStateBoolean((ObservableField) object, fieldId);
            case 1:
                return onChangeBottomViewModelWeatherInfoIsInitFinished((ObservableField) object, fieldId);
            case 2:
                return onChangeBottomViewModelBtState((ObservableField) object, fieldId);
            case 3:
                return onChangeBottomViewModelWeatherInfoImage((ObservableField) object, fieldId);
            case 4:
                return onChangeBottomViewModelWeatherInfoPhrase((ObservableField) object, fieldId);
            case 5:
                return onChangeBottomViewModelCarInfoSpeed((ObservableInt) object, fieldId);
            case 6:
                return onChangeBottomViewModelWeatherInfoTemperature((ObservableField) object, fieldId);
            case 7:
                return onChangeBottomViewModelNtg6v3MainThemeMode((ObservableInt) object, fieldId);
            case 8:
                return onChangeBottomViewModelAllappPopStatle((ObservableField) object, fieldId);
            case 9:
                return onChangeBottomViewModelWeatherInfoIsLoadSuccess((ObservableField) object, fieldId);
            case 10:
                return onChangeBottomViewModelCarInfoUnitEnImg((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeBottomViewModelBtStateBoolean(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeBottomViewModelWeatherInfoIsInitFinished(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeBottomViewModelBtState(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeBottomViewModelWeatherInfoImage(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeBottomViewModelWeatherInfoPhrase(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeBottomViewModelCarInfoSpeed(ObservableInt BottomViewModelCarInfoSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeBottomViewModelWeatherInfoTemperature(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeBottomViewModelNtg6v3MainThemeMode(ObservableInt BottomViewModelNtg6v3MainThemeMode, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeBottomViewModelAllappPopStatle(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeBottomViewModelWeatherInfoIsLoadSuccess(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeBottomViewModelCarInfoUnitEnImg(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r8v4 android.databinding.ObservableInt: [D('androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet' boolean), D('bottomViewModelNtg6v3MainThemeMode' android.databinding.ObservableInt)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int bottomViewModelCarInfoSpeedGet;
        ObservableField<Boolean> bottomViewModelBtStateBoolean;
        String bottomViewModelWeatherInfoPhraseGet;
        String bottomViewModelWeatherInfoTemperatureGet;
        boolean androidDatabindingViewDataBindingSafeUnboxBottomViewModelBtStateBooleanGet;
        String bottomViewModelBtStateGet;
        int bottomViewModelNtg6v3MainThemeModeGet;
        String stringValueOfBottomViewModelCarInfoSpeed;
        String bottomViewModelCarInfoUnitEnImgMboundView4AndroidStringSpeedUnitEnMboundView4AndroidStringSpeedUnitCn;
        int bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewGONE;
        int bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewGONEViewVISIBLE;
        ObservableField<Boolean> bottomViewModelWeatherInfoIsLoadSuccess;
        Boolean bottomViewModelCarInfoUnitEnImgGet;
        ObservableField<Boolean> bottomViewModelCarInfoUnitEnImg;
        long dirtyFlags2;
        int i;
        Resources resources;
        ObservableInt bottomViewModelCarInfoSpeed;
        boolean androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet;
        ObservableField<Boolean> bottomViewModelBtStateBoolean2;
        ObservableField<Boolean> bottomViewModelAllappPopStatle;
        boolean androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet;
        ObservableField<String> bottomViewModelWeatherInfoTemperature;
        ObservableField<String> bottomViewModelWeatherInfoPhrase;
        ObservableField<Drawable> bottomViewModelWeatherInfoImage;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<Boolean> bottomViewModelWeatherInfoIsInitFinished = null;
        boolean androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet2 = false;
        Boolean bottomViewModelCarInfoUnitEnImgGet2 = null;
        Boolean bottomViewModelAllappPopStatleGet = null;
        WeatherInfo bottomViewModelWeatherInfo = null;
        ObservableField<String> bottomViewModelBtState = null;
        int bottomViewModelAllappPopStatleViewGONEViewVISIBLE = 0;
        Drawable bottomViewModelWeatherInfoImageGet = null;
        Boolean bottomViewModelWeatherInfoIsInitFinishedGet = null;
        Boolean bottomViewModelBtStateBooleanGet = null;
        boolean androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsLoadSuccessGet = false;
        Ntg6v3LauncherViewModel bottomViewModel = this.mBottomViewModel;
        boolean androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet2 = false;
        String bottomViewModelBtStateGet2 = null;
        boolean androidDatabindingViewDataBindingSafeUnboxBottomViewModelBtStateBooleanGet2 = false;
        String bottomViewModelWeatherInfoPhraseGet2 = null;
        String stringValueOfBottomViewModelCarInfoSpeed2 = null;
        Boolean bottomViewModelWeatherInfoIsLoadSuccessGet = null;
        if ((dirtyFlags & 4698) != 0) {
            bottomViewModelWeatherInfo = Ntg6v3LauncherViewModel.weatherInfo;
            if ((dirtyFlags & 4610) != 0) {
                if (bottomViewModelWeatherInfo != null) {
                    bottomViewModelWeatherInfoIsInitFinished = bottomViewModelWeatherInfo.isInitFinished;
                }
                bottomViewModelCarInfoSpeedGet = 0;
                updateRegistration(1, bottomViewModelWeatherInfoIsInitFinished);
                if (bottomViewModelWeatherInfoIsInitFinished != null) {
                    bottomViewModelWeatherInfoIsInitFinishedGet = bottomViewModelWeatherInfoIsInitFinished.get();
                }
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet2 = ViewDataBinding.safeUnbox(bottomViewModelWeatherInfoIsInitFinishedGet);
                if ((dirtyFlags & 4610) != 0) {
                    dirtyFlags = androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet2 ? dirtyFlags | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : dirtyFlags | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
            } else {
                bottomViewModelCarInfoSpeedGet = 0;
            }
            if ((dirtyFlags & 4104) != 0) {
                if (bottomViewModelWeatherInfo != null) {
                    bottomViewModelWeatherInfoImage = bottomViewModelWeatherInfo.image;
                } else {
                    bottomViewModelWeatherInfoImage = null;
                }
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet = androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet2;
                updateRegistration(3, bottomViewModelWeatherInfoImage);
                if (bottomViewModelWeatherInfoImage != null) {
                    bottomViewModelWeatherInfoImageGet = bottomViewModelWeatherInfoImage.get();
                }
            } else {
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet = androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet2;
            }
            if ((dirtyFlags & 4112) != 0) {
                if (bottomViewModelWeatherInfo != null) {
                    bottomViewModelWeatherInfoPhrase = bottomViewModelWeatherInfo.phrase;
                } else {
                    bottomViewModelWeatherInfoPhrase = null;
                }
                updateRegistration(4, bottomViewModelWeatherInfoPhrase);
                if (bottomViewModelWeatherInfoPhrase != null) {
                    bottomViewModelWeatherInfoPhraseGet2 = bottomViewModelWeatherInfoPhrase.get();
                }
            }
            if ((dirtyFlags & 4160) != 0) {
                if (bottomViewModelWeatherInfo != null) {
                    bottomViewModelWeatherInfoTemperature = bottomViewModelWeatherInfo.temperature;
                } else {
                    bottomViewModelWeatherInfoTemperature = null;
                }
                updateRegistration(6, bottomViewModelWeatherInfoTemperature);
                if (bottomViewModelWeatherInfoTemperature != null) {
                    bottomViewModelWeatherInfoTemperatureGet = bottomViewModelWeatherInfoTemperature.get();
                    androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet2 = androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet;
                    bottomViewModelBtStateBoolean = null;
                    bottomViewModelWeatherInfoPhraseGet = bottomViewModelWeatherInfoPhraseGet2;
                } else {
                    bottomViewModelWeatherInfoTemperatureGet = null;
                    androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet2 = androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet;
                    bottomViewModelBtStateBoolean = null;
                    bottomViewModelWeatherInfoPhraseGet = bottomViewModelWeatherInfoPhraseGet2;
                }
            } else {
                bottomViewModelWeatherInfoTemperatureGet = null;
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet2 = androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet;
                bottomViewModelBtStateBoolean = null;
                bottomViewModelWeatherInfoPhraseGet = bottomViewModelWeatherInfoPhraseGet2;
            }
        } else {
            bottomViewModelCarInfoSpeedGet = 0;
            bottomViewModelWeatherInfoTemperatureGet = null;
            bottomViewModelBtStateBoolean = null;
            bottomViewModelWeatherInfoPhraseGet = null;
        }
        if ((dirtyFlags & 6533) != 0) {
            if ((dirtyFlags & 6273) != 0) {
                if (bottomViewModel != null) {
                    bottomViewModelBtStateBoolean2 = bottomViewModel.btStateBoolean;
                } else {
                    bottomViewModelBtStateBoolean2 = bottomViewModelBtStateBoolean;
                }
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet = false;
                updateRegistration(0, bottomViewModelBtStateBoolean2);
                if (bottomViewModelBtStateBoolean2 != null) {
                    bottomViewModelBtStateBooleanGet = bottomViewModelBtStateBoolean2.get();
                }
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelBtStateBooleanGet2 = ViewDataBinding.safeUnbox(bottomViewModelBtStateBooleanGet);
            } else {
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet = false;
                bottomViewModelBtStateBoolean2 = bottomViewModelBtStateBoolean;
            }
            if ((dirtyFlags & 6148) != 0) {
                if (bottomViewModel != null) {
                    bottomViewModelBtState = bottomViewModel.btState;
                }
                updateRegistration(2, bottomViewModelBtState);
                if (bottomViewModelBtState != null) {
                    bottomViewModelBtStateGet2 = bottomViewModelBtState.get();
                }
            }
            if ((dirtyFlags & 6400) != 0) {
                if (bottomViewModel != null) {
                    bottomViewModelAllappPopStatle = bottomViewModel.allappPopStatle;
                } else {
                    bottomViewModelAllappPopStatle = null;
                }
                updateRegistration(8, bottomViewModelAllappPopStatle);
                if (bottomViewModelAllappPopStatle != null) {
                    bottomViewModelAllappPopStatleGet = bottomViewModelAllappPopStatle.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet3 = ViewDataBinding.safeUnbox(bottomViewModelAllappPopStatleGet);
                if ((dirtyFlags & 6400) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet3) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    }
                }
                bottomViewModelAllappPopStatleViewGONEViewVISIBLE = androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet3 ? 8 : 0;
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet2 = androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet3;
                bottomViewModelBtStateGet = bottomViewModelBtStateGet2;
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelBtStateBooleanGet = androidDatabindingViewDataBindingSafeUnboxBottomViewModelBtStateBooleanGet2;
            } else {
                bottomViewModelBtStateGet = bottomViewModelBtStateGet2;
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelBtStateBooleanGet = androidDatabindingViewDataBindingSafeUnboxBottomViewModelBtStateBooleanGet2;
                androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet2 = androidDatabindingViewDataBindingSafeUnboxBottomViewModelAllappPopStatleGet;
            }
        } else {
            bottomViewModelBtStateGet = null;
            androidDatabindingViewDataBindingSafeUnboxBottomViewModelBtStateBooleanGet = false;
        }
        if ((dirtyFlags & 6273) != 0) {
            ObservableInt bottomViewModelNtg6v3MainThemeMode = Ntg6v3LauncherViewModel.ntg6v3MainThemeMode;
            updateRegistration(7, bottomViewModelNtg6v3MainThemeMode);
            bottomViewModelNtg6v3MainThemeModeGet = bottomViewModelNtg6v3MainThemeMode != null ? bottomViewModelNtg6v3MainThemeMode.get() : 0;
        } else {
            bottomViewModelNtg6v3MainThemeModeGet = 0;
        }
        if ((dirtyFlags & 5152) != 0) {
            CarInfo bottomViewModelCarInfo = Ntg6v3LauncherViewModel.carInfo;
            if ((dirtyFlags & 4128) != 0) {
                if (bottomViewModelCarInfo != null) {
                    bottomViewModelCarInfoUnitEnImgGet = null;
                    bottomViewModelCarInfoSpeed = bottomViewModelCarInfo.speed;
                } else {
                    bottomViewModelCarInfoUnitEnImgGet = null;
                    bottomViewModelCarInfoSpeed = null;
                }
                updateRegistration(5, bottomViewModelCarInfoSpeed);
                if (bottomViewModelCarInfoSpeed != null) {
                    bottomViewModelCarInfoSpeedGet = bottomViewModelCarInfoSpeed.get();
                }
                stringValueOfBottomViewModelCarInfoSpeed2 = String.valueOf(bottomViewModelCarInfoSpeedGet);
            } else {
                bottomViewModelCarInfoUnitEnImgGet = null;
            }
            if ((dirtyFlags & 5120) != 0) {
                if (bottomViewModelCarInfo != null) {
                    bottomViewModelCarInfoUnitEnImg = bottomViewModelCarInfo.unitEnImg;
                } else {
                    bottomViewModelCarInfoUnitEnImg = null;
                }
                updateRegistration(10, bottomViewModelCarInfoUnitEnImg);
                if (bottomViewModelCarInfoUnitEnImg != null) {
                    bottomViewModelCarInfoUnitEnImgGet = bottomViewModelCarInfoUnitEnImg.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxBottomViewModelCarInfoUnitEnImgGet = ViewDataBinding.safeUnbox(bottomViewModelCarInfoUnitEnImgGet);
                if ((dirtyFlags & 5120) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxBottomViewModelCarInfoUnitEnImgGet) {
                        dirtyFlags |= 4194304;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    }
                }
                if (androidDatabindingViewDataBindingSafeUnboxBottomViewModelCarInfoUnitEnImgGet) {
                    dirtyFlags2 = dirtyFlags;
                    resources = this.mboundView4.getResources();
                    i = R.string.speed_unit_en;
                } else {
                    dirtyFlags2 = dirtyFlags;
                    resources = this.mboundView4.getResources();
                    i = R.string.speed_unit_cn;
                }
                String bottomViewModelCarInfoUnitEnImgMboundView4AndroidStringSpeedUnitEnMboundView4AndroidStringSpeedUnitCn2 = resources.getString(i);
                stringValueOfBottomViewModelCarInfoSpeed = stringValueOfBottomViewModelCarInfoSpeed2;
                dirtyFlags = dirtyFlags2;
                bottomViewModelCarInfoUnitEnImgGet2 = bottomViewModelCarInfoUnitEnImgGet;
                bottomViewModelCarInfoUnitEnImgMboundView4AndroidStringSpeedUnitEnMboundView4AndroidStringSpeedUnitCn = bottomViewModelCarInfoUnitEnImgMboundView4AndroidStringSpeedUnitEnMboundView4AndroidStringSpeedUnitCn2;
            } else {
                bottomViewModelCarInfoUnitEnImgGet2 = bottomViewModelCarInfoUnitEnImgGet;
                stringValueOfBottomViewModelCarInfoSpeed = stringValueOfBottomViewModelCarInfoSpeed2;
                bottomViewModelCarInfoUnitEnImgMboundView4AndroidStringSpeedUnitEnMboundView4AndroidStringSpeedUnitCn = null;
            }
        } else {
            stringValueOfBottomViewModelCarInfoSpeed = null;
            bottomViewModelCarInfoUnitEnImgMboundView4AndroidStringSpeedUnitEnMboundView4AndroidStringSpeedUnitCn = null;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            if (bottomViewModelWeatherInfo != null) {
                bottomViewModelWeatherInfoIsLoadSuccess = bottomViewModelWeatherInfo.isLoadSuccess;
            } else {
                bottomViewModelWeatherInfoIsLoadSuccess = null;
            }
            updateRegistration(9, bottomViewModelWeatherInfoIsLoadSuccess);
            if (bottomViewModelWeatherInfoIsLoadSuccess != null) {
                bottomViewModelWeatherInfoIsLoadSuccessGet = bottomViewModelWeatherInfoIsLoadSuccess.get();
            }
            androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsLoadSuccessGet = ViewDataBinding.safeUnbox(bottomViewModelWeatherInfoIsLoadSuccessGet);
        }
        if ((dirtyFlags & 4610) != 0) {
            boolean bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalse = androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsInitFinishedGet2 ? androidDatabindingViewDataBindingSafeUnboxBottomViewModelWeatherInfoIsLoadSuccessGet : false;
            if ((dirtyFlags & 4610) != 0) {
                if (bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalse) {
                    dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                } else {
                    dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                }
            }
            int bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewGONEViewVISIBLE2 = bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalse ? 8 : 0;
            int bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewGONE2 = bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalse ? 0 : 8;
            bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewGONEViewVISIBLE = bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewGONEViewVISIBLE2;
            bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewGONE = bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewGONE2;
        } else {
            bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewGONEViewVISIBLE = 0;
            bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewGONE = 0;
        }
        if ((dirtyFlags & 4128) != 0) {
            TextViewBindingAdapter.setText(this.carinfoTv, stringValueOfBottomViewModelCarInfoSpeed);
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) != 0) {
            this.llBottom3.setOnClickListener(this.mCallback163);
            this.mboundView6.setOnClickListener(this.mCallback162);
            this.ntg3v6MainBottomCarRl.setOnClickListener(this.mCallback160);
            this.ntg3v6MainBottomNavRl.setOnClickListener(this.mCallback161);
            this.ntg3v6MainBottomShoujihlRl.setOnClickListener(this.mCallback165);
            this.ntg3v6MainBottomShoujihlRl.setOnLongClickListener(this.mCallback166);
            this.ntg3v6MainBottomThemeRl.setOnClickListener(this.mCallback167);
            this.ntg3v6MainBottomThemeRl.setOnLongClickListener(this.mCallback168);
            this.ntg3v6MainBottomVideoRl.setOnClickListener(this.mCallback169);
            this.ntg3v6MainBottomVideoRl.setOnLongClickListener(this.mCallback170);
            this.ntg3v6MainBottomWeatherRl.setOnClickListener(this.mCallback164);
        }
        if ((dirtyFlags & 6273) != 0) {
            Ntg6v3LauncherViewModel.setNtg6v3MainBottomBtBg(this.llBottom3, bottomViewModelNtg6v3MainThemeModeGet, androidDatabindingViewDataBindingSafeUnboxBottomViewModelBtStateBooleanGet);
        }
        if ((dirtyFlags & 6400) != 0) {
            this.llBottomBarContainer.setVisibility(bottomViewModelAllappPopStatleViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 4610) != 0) {
            this.mboundView10.setVisibility(bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewGONEViewVISIBLE);
            this.mboundView11.setVisibility(bottomViewModelWeatherInfoIsInitFinishedBottomViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 4160) != 0) {
            TextViewBindingAdapter.setText(this.mboundView12, bottomViewModelWeatherInfoTemperatureGet);
        }
        if ((dirtyFlags & 4112) != 0) {
            TextViewBindingAdapter.setText(this.mboundView13, bottomViewModelWeatherInfoPhraseGet);
        }
        if ((dirtyFlags & 4104) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView14, bottomViewModelWeatherInfoImageGet);
        }
        if ((dirtyFlags & 4224) != 0) {
            Ntg6v3LauncherViewModel.setNtg6v3MainBottomWeatherBg(this.mboundView15, bottomViewModelNtg6v3MainThemeModeGet);
            Ntg6v3LauncherViewModel.setNtg6v3MainBottomCarBg(this.ntg3v6MainBottomCarRl, bottomViewModelNtg6v3MainThemeModeGet);
            Ntg6v3LauncherViewModel.setNtg6v3MainBottomNavBg(this.ntg3v6MainBottomNavRl, bottomViewModelNtg6v3MainThemeModeGet);
            Ntg6v3LauncherViewModel.setNtg6v3MainBottomWeatherBg(this.ntg3v6MainBottomWeatherRl, bottomViewModelNtg6v3MainThemeModeGet);
        }
        if ((dirtyFlags & 5120) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, bottomViewModelCarInfoUnitEnImgMboundView4AndroidStringSpeedUnitEnMboundView4AndroidStringSpeedUnitCn);
        }
        if ((dirtyFlags & 6148) != 0) {
            TextViewBindingAdapter.setText(this.mboundView8, bottomViewModelBtStateGet);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnLongClickListener.Listener
    public final boolean _internalCallbackOnLongClick(int sourceId, View callbackArg_0) {
        boolean bottomViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 7:
                Ntg6v3LauncherViewModel bottomViewModel = this.mBottomViewModel;
                if (bottomViewModel == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    return bottomViewModel.itemOneLongClick(callbackArg_0);
                }
                return false;
            case 8:
            case 10:
            default:
                return false;
            case 9:
                Ntg6v3LauncherViewModel bottomViewModel2 = this.mBottomViewModel;
                if (bottomViewModel2 == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    return bottomViewModel2.itemTwoLongClick(callbackArg_0);
                }
                return false;
            case 11:
                Ntg6v3LauncherViewModel bottomViewModel3 = this.mBottomViewModel;
                if (bottomViewModel3 == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    return bottomViewModel3.itemThreeLongClick(callbackArg_0);
                }
                return false;
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean bottomViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                Ntg6v3LauncherViewModel bottomViewModel = this.mBottomViewModel;
                if (bottomViewModel == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    bottomViewModel.openCar(callbackArg_0);
                    return;
                }
                return;
            case 2:
                Ntg6v3LauncherViewModel bottomViewModel2 = this.mBottomViewModel;
                if (bottomViewModel2 == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    bottomViewModel2.openNaviApp(callbackArg_0);
                    return;
                }
                return;
            case 3:
                Ntg6v3LauncherViewModel bottomViewModel3 = this.mBottomViewModel;
                if (bottomViewModel3 == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    bottomViewModel3.openNaviApp(callbackArg_0);
                    return;
                }
                return;
            case 4:
                Ntg6v3LauncherViewModel bottomViewModel4 = this.mBottomViewModel;
                if (bottomViewModel4 == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    bottomViewModel4.openBtApp(callbackArg_0);
                    return;
                }
                return;
            case 5:
                Ntg6v3LauncherViewModel bottomViewModel5 = this.mBottomViewModel;
                if (bottomViewModel5 == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    bottomViewModel5.openWeatherApp(callbackArg_0);
                    return;
                }
                return;
            case 6:
                Ntg6v3LauncherViewModel bottomViewModel6 = this.mBottomViewModel;
                if (bottomViewModel6 == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    bottomViewModel6.itemOneClick(callbackArg_0);
                    return;
                }
                return;
            case 7:
            case 9:
            default:
                return;
            case 8:
                Ntg6v3LauncherViewModel bottomViewModel7 = this.mBottomViewModel;
                if (bottomViewModel7 == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    bottomViewModel7.itemTwoClick(callbackArg_0);
                    return;
                }
                return;
            case 10:
                Ntg6v3LauncherViewModel bottomViewModel8 = this.mBottomViewModel;
                if (bottomViewModel8 == null) {
                    bottomViewModelJavaLangObjectNull = false;
                }
                if (bottomViewModelJavaLangObjectNull) {
                    bottomViewModel8.itemThreeClick(callbackArg_0);
                    return;
                }
                return;
        }
    }
}
