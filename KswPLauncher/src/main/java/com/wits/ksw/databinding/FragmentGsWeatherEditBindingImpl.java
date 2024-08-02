package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.databinding.adapters.ViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.WeatherInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class FragmentGsWeatherEditBindingImpl extends FragmentGsWeatherEditBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    private final ProgressBar mboundView3;
    private final LinearLayout mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 9);
        sparseIntArray.put(R.id.gs_id8_icon_edit_bg, 10);
        sparseIntArray.put(R.id.remove, 11);
    }

    public FragmentGsWeatherEditBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private FragmentGsWeatherEditBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (ImageView) bindings[10], (ImageView) bindings[6], (ImageView) bindings[11], (TextView) bindings[2], (TextView) bindings[9], (TextView) bindings[7]);
        this.mDirtyFlags = -1;
        this.ivIcon.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ProgressBar progressBar = (ProgressBar) bindings[3];
        this.mboundView3 = progressBar;
        progressBar.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[4];
        this.mboundView4 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[8];
        this.mboundView8 = textView2;
        textView2.setTag(null);
        this.tvCity.setTag(null);
        this.weatherTv.setTag(null);
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
        if (26 != variableId) {
            return false;
        }
        setWeatherViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.FragmentGsWeatherEditBinding
    public void setWeatherViewModel(LauncherViewModel WeatherViewModel) {
        this.mWeatherViewModel = WeatherViewModel;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeWeatherViewModelWeatherInfoCity((ObservableField) object, fieldId);
            case 1:
                return onChangeWeatherViewModelWeatherInfoPhrase((ObservableField) object, fieldId);
            case 2:
                return onChangeWeatherViewModelWeatherInfoErrorMessage((ObservableField) object, fieldId);
            case 3:
                return onChangeWeatherViewModelWeatherInfoIsLoadSuccess((ObservableField) object, fieldId);
            case 4:
                return onChangeWeatherViewModelWeatherInfoIsInitFinished((ObservableField) object, fieldId);
            case 5:
                return onChangeWeatherViewModelWeatherInfoTemperatureRange((ObservableField) object, fieldId);
            case 6:
                return onChangeWeatherViewModelWeatherInfoId8GsImageIcon((ObservableField) object, fieldId);
            case 7:
                return onChangeWeatherViewModelWeatherInfoId8GsImageBg((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeWeatherViewModelWeatherInfoCity(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoPhrase(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoErrorMessage(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoIsLoadSuccess(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoIsInitFinished(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoTemperatureRange(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoId8GsImageIcon(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoId8GsImageBg(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        ObservableField<String> weatherViewModelWeatherInfoCity;
        Boolean weatherViewModelWeatherInfoIsLoadSuccessGet;
        String weatherViewModelWeatherInfoPhraseGet;
        WeatherInfo weatherViewModelWeatherInfo;
        int weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE;
        String weatherViewModelWeatherInfoErrorMessageGet;
        int weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE;
        int WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1;
        int weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2;
        String weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather;
        ObservableField<String> weatherViewModelWeatherInfoCity2;
        String weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather2;
        ObservableField<Drawable> weatherViewModelWeatherInfoId8GsImageBg;
        ObservableField<Boolean> weatherViewModelWeatherInfoIsLoadSuccess;
        String weatherViewModelWeatherInfoTemperatureRangeGet;
        ObservableField<Drawable> weatherViewModelWeatherInfoId8GsImageIcon;
        ObservableField<String> weatherViewModelWeatherInfoTemperatureRange;
        ObservableField<Boolean> weatherViewModelWeatherInfoIsInitFinished;
        ObservableField<Boolean> weatherViewModelWeatherInfoIsLoadSuccess2;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String weatherViewModelWeatherInfoTemperatureRangeGet2 = null;
        Boolean weatherViewModelWeatherInfoIsLoadSuccessGet2 = null;
        ObservableField<String> weatherViewModelWeatherInfoPhrase = null;
        Drawable weatherViewModelWeatherInfoId8GsImageIconGet = null;
        boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet = false;
        ObservableField<String> weatherViewModelWeatherInfoErrorMessage = null;
        Drawable weatherViewModelWeatherInfoId8GsImageBgGet = null;
        Drawable weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoId8GsImageBgMboundView1AndroidDrawableGsId8MainIconWeather = null;
        String weatherViewModelWeatherInfoErrorMessageGet2 = null;
        String weatherViewModelWeatherInfoCityGet = null;
        ObservableField<Boolean> weatherViewModelWeatherInfoIsLoadSuccess3 = null;
        boolean WeatherViewModelWeatherInfoIsLoadSuccess1 = false;
        Boolean weatherViewModelWeatherInfoIsInitFinishedGet = null;
        int weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2 = 0;
        boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = false;
        String weatherViewModelWeatherInfoPhraseGet2 = null;
        if ((dirtyFlags & 767) != 0) {
            WeatherInfo weatherViewModelWeatherInfo2 = LauncherViewModel.weatherInfo;
            if ((dirtyFlags & 514) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoPhrase = weatherViewModelWeatherInfo2.phrase;
                }
                updateRegistration(1, weatherViewModelWeatherInfoPhrase);
                if (weatherViewModelWeatherInfoPhrase != null) {
                    weatherViewModelWeatherInfoPhraseGet2 = weatherViewModelWeatherInfoPhrase.get();
                }
            }
            if ((dirtyFlags & 516) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoErrorMessage = weatherViewModelWeatherInfo2.errorMessage;
                }
                updateRegistration(2, weatherViewModelWeatherInfoErrorMessage);
                if (weatherViewModelWeatherInfoErrorMessage != null) {
                    weatherViewModelWeatherInfoErrorMessageGet2 = weatherViewModelWeatherInfoErrorMessage.get();
                }
            }
            if ((dirtyFlags & 649) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoIsLoadSuccess2 = weatherViewModelWeatherInfo2.isLoadSuccess;
                } else {
                    weatherViewModelWeatherInfoIsLoadSuccess2 = null;
                }
                weatherViewModelWeatherInfoTemperatureRangeGet = null;
                updateRegistration(3, weatherViewModelWeatherInfoIsLoadSuccess2);
                if (weatherViewModelWeatherInfoIsLoadSuccess2 != null) {
                    weatherViewModelWeatherInfoIsLoadSuccessGet2 = weatherViewModelWeatherInfoIsLoadSuccess2.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2 = ViewDataBinding.safeUnbox(weatherViewModelWeatherInfoIsLoadSuccessGet2);
                if ((dirtyFlags & 521) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                }
                if ((dirtyFlags & 648) == 0) {
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2;
                    weatherViewModelWeatherInfoIsLoadSuccess3 = weatherViewModelWeatherInfoIsLoadSuccess2;
                } else if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2;
                    weatherViewModelWeatherInfoIsLoadSuccess3 = weatherViewModelWeatherInfoIsLoadSuccess2;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2;
                    weatherViewModelWeatherInfoIsLoadSuccess3 = weatherViewModelWeatherInfoIsLoadSuccess2;
                }
            } else {
                weatherViewModelWeatherInfoTemperatureRangeGet = null;
            }
            if ((dirtyFlags & 536) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoIsInitFinished = weatherViewModelWeatherInfo2.isInitFinished;
                } else {
                    weatherViewModelWeatherInfoIsInitFinished = null;
                }
                updateRegistration(4, weatherViewModelWeatherInfoIsInitFinished);
                if (weatherViewModelWeatherInfoIsInitFinished != null) {
                    weatherViewModelWeatherInfoIsInitFinishedGet = weatherViewModelWeatherInfoIsInitFinished.get();
                }
                androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet = ViewDataBinding.safeUnbox(weatherViewModelWeatherInfoIsInitFinishedGet);
                if ((dirtyFlags & 536) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet) {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PREPARE_FROM_URI | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    } else {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    }
                }
                if ((dirtyFlags & 528) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    }
                }
                if ((dirtyFlags & 528) != 0) {
                    weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet ? 4 : 0;
                }
            }
            if ((dirtyFlags & 544) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoTemperatureRange = weatherViewModelWeatherInfo2.temperatureRange;
                } else {
                    weatherViewModelWeatherInfoTemperatureRange = null;
                }
                updateRegistration(5, weatherViewModelWeatherInfoTemperatureRange);
                weatherViewModelWeatherInfoTemperatureRangeGet2 = weatherViewModelWeatherInfoTemperatureRange != null ? weatherViewModelWeatherInfoTemperatureRange.get() : weatherViewModelWeatherInfoTemperatureRangeGet;
            } else {
                weatherViewModelWeatherInfoTemperatureRangeGet2 = weatherViewModelWeatherInfoTemperatureRangeGet;
            }
            if ((dirtyFlags & 576) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoId8GsImageIcon = weatherViewModelWeatherInfo2.id8GsImageIcon;
                } else {
                    weatherViewModelWeatherInfoId8GsImageIcon = null;
                }
                updateRegistration(6, weatherViewModelWeatherInfoId8GsImageIcon);
                if (weatherViewModelWeatherInfoId8GsImageIcon != null) {
                    weatherViewModelWeatherInfoId8GsImageIconGet = weatherViewModelWeatherInfoId8GsImageIcon.get();
                    weatherViewModelWeatherInfoErrorMessageGet = weatherViewModelWeatherInfoErrorMessageGet2;
                    weatherViewModelWeatherInfoTemperatureRangeGet2 = weatherViewModelWeatherInfoTemperatureRangeGet2;
                    weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccessGet2;
                    weatherViewModelWeatherInfo = weatherViewModelWeatherInfo2;
                    weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2;
                    weatherViewModelWeatherInfoCity = null;
                    weatherViewModelWeatherInfoPhraseGet = weatherViewModelWeatherInfoPhraseGet2;
                } else {
                    weatherViewModelWeatherInfoErrorMessageGet = weatherViewModelWeatherInfoErrorMessageGet2;
                    weatherViewModelWeatherInfoTemperatureRangeGet2 = weatherViewModelWeatherInfoTemperatureRangeGet2;
                    weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccessGet2;
                    weatherViewModelWeatherInfo = weatherViewModelWeatherInfo2;
                    weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2;
                    weatherViewModelWeatherInfoCity = null;
                    weatherViewModelWeatherInfoPhraseGet = weatherViewModelWeatherInfoPhraseGet2;
                }
            } else {
                weatherViewModelWeatherInfoErrorMessageGet = weatherViewModelWeatherInfoErrorMessageGet2;
                weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccessGet2;
                weatherViewModelWeatherInfo = weatherViewModelWeatherInfo2;
                weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2;
                weatherViewModelWeatherInfoCity = null;
                weatherViewModelWeatherInfoPhraseGet = weatherViewModelWeatherInfoPhraseGet2;
            }
        } else {
            weatherViewModelWeatherInfoErrorMessageGet = null;
            weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = 0;
            weatherViewModelWeatherInfoIsLoadSuccessGet = null;
            weatherViewModelWeatherInfoCity = null;
            weatherViewModelWeatherInfo = null;
            weatherViewModelWeatherInfoPhraseGet = null;
        }
        if ((dirtyFlags & 655360) != 0) {
            if (weatherViewModelWeatherInfo != null) {
                weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
                weatherViewModelWeatherInfoIsLoadSuccess = weatherViewModelWeatherInfo.isLoadSuccess;
            } else {
                weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
                weatherViewModelWeatherInfoIsLoadSuccess = weatherViewModelWeatherInfoIsLoadSuccess3;
            }
            updateRegistration(3, weatherViewModelWeatherInfoIsLoadSuccess);
            if (weatherViewModelWeatherInfoIsLoadSuccess != null) {
                weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccess.get();
            }
            androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = ViewDataBinding.safeUnbox(weatherViewModelWeatherInfoIsLoadSuccessGet);
            if ((dirtyFlags & 521) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                }
            }
            if ((dirtyFlags & 648) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                }
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
                WeatherViewModelWeatherInfoIsLoadSuccess1 = !androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet;
            }
        } else {
            weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
        }
        if ((dirtyFlags & 536) != 0) {
            boolean weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet ? androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet : false;
            boolean WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse1 = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet ? WeatherViewModelWeatherInfoIsLoadSuccess1 : false;
            if ((dirtyFlags & 536) != 0) {
                if (weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                }
            }
            if ((dirtyFlags & 536) != 0) {
                if (WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse1) {
                    dirtyFlags |= 8388608;
                } else {
                    dirtyFlags |= 4194304;
                }
            }
            weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2 = weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse ? 0 : 4;
            WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse1 ? 0 : 4;
        } else {
            WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = 0;
            weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2 = weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_PLAY_FROM_URI) != 0) {
            if (weatherViewModelWeatherInfo != null) {
                weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather = null;
                weatherViewModelWeatherInfoCity2 = weatherViewModelWeatherInfo.city;
            } else {
                weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather = null;
                weatherViewModelWeatherInfoCity2 = weatherViewModelWeatherInfoCity;
            }
            updateRegistration(0, weatherViewModelWeatherInfoCity2);
            if (weatherViewModelWeatherInfoCity2 != null) {
                weatherViewModelWeatherInfoCityGet = weatherViewModelWeatherInfoCity2.get();
            }
        } else {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather = null;
            weatherViewModelWeatherInfoCity2 = weatherViewModelWeatherInfoCity;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
            if (weatherViewModelWeatherInfo != null) {
                weatherViewModelWeatherInfoId8GsImageBg = weatherViewModelWeatherInfo.id8GsImageBg;
            } else {
                weatherViewModelWeatherInfoId8GsImageBg = null;
            }
            updateRegistration(7, weatherViewModelWeatherInfoId8GsImageBg);
            if (weatherViewModelWeatherInfoId8GsImageBg != null) {
                weatherViewModelWeatherInfoId8GsImageBgGet = weatherViewModelWeatherInfoId8GsImageBg.get();
            }
        }
        if ((dirtyFlags & 521) != 0) {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather2 = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet ? weatherViewModelWeatherInfoCityGet : this.tvCity.getResources().getString(R.string.ksw_id8_weather);
        } else {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather2 = weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather;
        }
        if ((dirtyFlags & 648) != 0) {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoId8GsImageBgMboundView1AndroidDrawableGsId8MainIconWeather = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet ? weatherViewModelWeatherInfoId8GsImageBgGet : AppCompatResources.getDrawable(this.mboundView1.getContext(), R.drawable.gs_id8_main_icon_weather);
        }
        if ((dirtyFlags & 576) != 0) {
            ViewBindingAdapter.setBackground(this.ivIcon, weatherViewModelWeatherInfoId8GsImageIconGet);
        }
        if ((dirtyFlags & 536) != 0) {
            this.ivIcon.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
            this.mboundView4.setVisibility(WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1);
            this.mboundView8.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
            this.tvCity.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
            this.weatherTv.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
        }
        if ((dirtyFlags & 648) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView1, weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoId8GsImageBgMboundView1AndroidDrawableGsId8MainIconWeather);
        }
        if ((dirtyFlags & 528) != 0) {
            this.mboundView3.setVisibility(weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE);
        }
        if ((dirtyFlags & 516) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, weatherViewModelWeatherInfoErrorMessageGet);
        }
        if ((dirtyFlags & 544) != 0) {
            TextViewBindingAdapter.setText(this.mboundView8, weatherViewModelWeatherInfoTemperatureRangeGet2);
        }
        if ((dirtyFlags & 521) != 0) {
            TextViewBindingAdapter.setText(this.tvCity, weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather2);
        }
        if ((dirtyFlags & 514) != 0) {
            TextViewBindingAdapter.setText(this.weatherTv, weatherViewModelWeatherInfoPhraseGet);
        }
    }
}
