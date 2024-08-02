package com.wits.ksw.databinding;

import android.arch.lifecycle.LifecycleOwner;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.WeatherInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class FragmentPempWeatherEditBindingImpl extends FragmentPempWeatherEditBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final IncludeNearWeatherEditBinding mboundView1;
    private final TextView mboundView8;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"include_near_weather_edit"}, new int[]{10}, new int[]{R.layout.include_near_weather_edit});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 11);
        sparseIntArray.put(R.id.iv_divider, 12);
        sparseIntArray.put(R.id.temperature, 13);
        sparseIntArray.put(R.id.remove, 14);
    }

    public FragmentPempWeatherEditBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private FragmentPempWeatherEditBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 13, (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[5], (ImageView) bindings[12], (RelativeLayout) bindings[1], (ImageView) bindings[14], (RelativeLayout) bindings[13], (TextView) bindings[6], (TextView) bindings[2], (TextView) bindings[11], (TextView) bindings[7], (TextView) bindings[9]);
        this.mDirtyFlags = -1;
        this.btA.setTag(null);
        this.btB.setTag(null);
        this.btC.setTag(null);
        this.layout.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        IncludeNearWeatherEditBinding includeNearWeatherEditBinding = (IncludeNearWeatherEditBinding) bindings[10];
        this.mboundView1 = includeNearWeatherEditBinding;
        setContainedBinding(includeNearWeatherEditBinding);
        TextView textView = (TextView) bindings[8];
        this.mboundView8 = textView;
        textView.setTag(null);
        this.temperatureTv.setTag(null);
        this.tvCity.setTag(null);
        this.unitWeather.setTag(null);
        this.weatherTv.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE;
        }
        this.mboundView1.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView1.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    @Override // android.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            com.wits.ksw.databinding.IncludeNearWeatherEditBinding r0 = r4.mboundView1
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.FragmentPempWeatherEditBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (26 != variableId) {
            return false;
        }
        setWeatherViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.FragmentPempWeatherEditBinding
    public void setWeatherViewModel(LauncherViewModel WeatherViewModel) {
        this.mWeatherViewModel = WeatherViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView1.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeWeatherViewModelWeatherInfoCity((ObservableField) object, fieldId);
            case 1:
                return onChangeWeatherViewModelWeatherInfoPempId8EditImage((ObservableField) object, fieldId);
            case 2:
                return onChangeWeatherViewModelWeatherInfoCardDetailText1((ObservableField) object, fieldId);
            case 3:
                return onChangeWeatherViewModelWeatherInfoCardDetailText3((ObservableField) object, fieldId);
            case 4:
                return onChangeWeatherViewModelWeatherInfoIsInitFinished((ObservableField) object, fieldId);
            case 5:
                return onChangeWeatherViewModelWeatherInfoTemperature((ObservableField) object, fieldId);
            case 6:
                return onChangeWeatherViewModelWeatherInfoId8CardEditDetailImg2((ObservableField) object, fieldId);
            case 7:
                return onChangeWeatherViewModelWeatherInfoPhrase((ObservableField) object, fieldId);
            case 8:
                return onChangeWeatherViewModelWeatherInfoCardDetailText2((ObservableField) object, fieldId);
            case 9:
                return onChangeWeatherViewModelWeatherInfoIsLoadSuccess((ObservableField) object, fieldId);
            case 10:
                return onChangeWeatherViewModelWeatherInfoTemperatureRange((ObservableField) object, fieldId);
            case 11:
                return onChangeWeatherViewModelWeatherInfoId8CardEditDetailImg1((ObservableField) object, fieldId);
            case 12:
                return onChangeWeatherViewModelWeatherInfoId8CardEditDetailImg3((ObservableField) object, fieldId);
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

    private boolean onChangeWeatherViewModelWeatherInfoPempId8EditImage(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoCardDetailText1(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoCardDetailText3(ObservableField<String> observableField, int fieldId) {
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

    private boolean onChangeWeatherViewModelWeatherInfoTemperature(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoId8CardEditDetailImg2(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoPhrase(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoCardDetailText2(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoIsLoadSuccess(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoTemperatureRange(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoId8CardEditDetailImg1(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoId8CardEditDetailImg3(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        String weatherViewModelWeatherInfoCardDetailText2Get;
        int weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE;
        ObservableField<Drawable> weatherViewModelWeatherInfoPempId8EditImage;
        ObservableField<String> weatherViewModelWeatherInfoCity;
        Boolean weatherViewModelWeatherInfoIsLoadSuccessGet;
        String weatherViewModelWeatherInfoPhraseGet;
        Drawable weatherViewModelWeatherInfoId8CardEditDetailImg3Get;
        String weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather;
        WeatherInfo weatherViewModelWeatherInfo;
        String weatherViewModelWeatherInfoCardDetailText2Get2;
        String weatherViewModelWeatherInfoTemperatureGet;
        Drawable weatherViewModelWeatherInfoId8CardEditDetailImg1Get;
        String weatherViewModelWeatherInfoCardDetailText1Get;
        Drawable weatherViewModelWeatherInfoId8CardEditDetailImg2Get;
        String weatherViewModelWeatherInfoPhraseGet2;
        String weatherViewModelWeatherInfoCityGet;
        int weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2;
        ObservableField<String> weatherViewModelWeatherInfoCity2;
        ObservableField<Drawable> weatherViewModelWeatherInfoPempId8EditImage2;
        String weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather2;
        Drawable weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8EditImageLayoutAndroidDrawablePempId8MainEditIconWeather;
        ObservableField<Boolean> weatherViewModelWeatherInfoIsLoadSuccess;
        String weatherViewModelWeatherInfoTemperatureRangeGet;
        String weatherViewModelWeatherInfoTemperatureRangeGet2;
        String weatherViewModelWeatherInfoTemperatureRangeGet3;
        ObservableField<Drawable> weatherViewModelWeatherInfoId8CardEditDetailImg3;
        ObservableField<Drawable> weatherViewModelWeatherInfoId8CardEditDetailImg1;
        ObservableField<String> weatherViewModelWeatherInfoTemperatureRange;
        ObservableField<Boolean> weatherViewModelWeatherInfoIsLoadSuccess2;
        ObservableField<String> weatherViewModelWeatherInfoCardDetailText2;
        ObservableField<String> weatherViewModelWeatherInfoPhrase;
        ObservableField<Drawable> weatherViewModelWeatherInfoId8CardEditDetailImg2;
        ObservableField<String> weatherViewModelWeatherInfoTemperature;
        ObservableField<Boolean> weatherViewModelWeatherInfoIsInitFinished;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String weatherViewModelWeatherInfoTemperatureRangeGet4 = null;
        Boolean weatherViewModelWeatherInfoIsLoadSuccessGet2 = null;
        LauncherViewModel weatherViewModel = this.mWeatherViewModel;
        boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet = false;
        ObservableField<String> weatherViewModelWeatherInfoCardDetailText1 = null;
        ObservableField<String> weatherViewModelWeatherInfoCardDetailText3 = null;
        Drawable weatherViewModelWeatherInfoId8CardEditDetailImg2Get2 = null;
        String weatherViewModelWeatherInfoCardDetailText1Get2 = null;
        Drawable weatherViewModelWeatherInfoId8CardEditDetailImg1Get2 = null;
        String weatherViewModelWeatherInfoTemperatureGet2 = null;
        Drawable weatherViewModelWeatherInfoPempId8EditImageGet = null;
        String weatherViewModelWeatherInfoCardDetailText2Get3 = null;
        String weatherViewModelWeatherInfoCardDetailText3Get = null;
        ObservableField<Boolean> weatherViewModelWeatherInfoIsLoadSuccess3 = null;
        Boolean weatherViewModelWeatherInfoIsInitFinishedGet = null;
        boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = false;
        String weatherViewModelWeatherInfoPhraseGet3 = null;
        if ((dirtyFlags & 24575) != 0) {
            WeatherInfo weatherViewModelWeatherInfo2 = LauncherViewModel.weatherInfo;
            if ((dirtyFlags & 16388) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoCardDetailText1 = weatherViewModelWeatherInfo2.cardDetailText1;
                }
                updateRegistration(2, weatherViewModelWeatherInfoCardDetailText1);
                if (weatherViewModelWeatherInfoCardDetailText1 != null) {
                    weatherViewModelWeatherInfoCardDetailText1Get2 = weatherViewModelWeatherInfoCardDetailText1.get();
                }
            }
            if ((dirtyFlags & 16392) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoCardDetailText3 = weatherViewModelWeatherInfo2.cardDetailText3;
                }
                updateRegistration(3, weatherViewModelWeatherInfoCardDetailText3);
                if (weatherViewModelWeatherInfoCardDetailText3 != null) {
                    weatherViewModelWeatherInfoCardDetailText3Get = weatherViewModelWeatherInfoCardDetailText3.get();
                }
            }
            if ((dirtyFlags & 16912) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoIsInitFinished = weatherViewModelWeatherInfo2.isInitFinished;
                } else {
                    weatherViewModelWeatherInfoIsInitFinished = null;
                }
                weatherViewModelWeatherInfoTemperatureRangeGet = null;
                updateRegistration(4, weatherViewModelWeatherInfoIsInitFinished);
                if (weatherViewModelWeatherInfoIsInitFinished != null) {
                    weatherViewModelWeatherInfoIsInitFinishedGet = weatherViewModelWeatherInfoIsInitFinished.get();
                }
                androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet = ViewDataBinding.safeUnbox(weatherViewModelWeatherInfoIsInitFinishedGet);
                if ((dirtyFlags & 16912) != 0) {
                    dirtyFlags = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet ? dirtyFlags | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : dirtyFlags | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
            } else {
                weatherViewModelWeatherInfoTemperatureRangeGet = null;
            }
            if ((dirtyFlags & 16416) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoTemperature = weatherViewModelWeatherInfo2.temperature;
                } else {
                    weatherViewModelWeatherInfoTemperature = null;
                }
                updateRegistration(5, weatherViewModelWeatherInfoTemperature);
                if (weatherViewModelWeatherInfoTemperature != null) {
                    weatherViewModelWeatherInfoTemperatureGet2 = weatherViewModelWeatherInfoTemperature.get();
                }
            }
            if ((dirtyFlags & 16448) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoId8CardEditDetailImg2 = weatherViewModelWeatherInfo2.id8CardEditDetailImg2;
                } else {
                    weatherViewModelWeatherInfoId8CardEditDetailImg2 = null;
                }
                updateRegistration(6, weatherViewModelWeatherInfoId8CardEditDetailImg2);
                if (weatherViewModelWeatherInfoId8CardEditDetailImg2 != null) {
                    weatherViewModelWeatherInfoId8CardEditDetailImg2Get2 = weatherViewModelWeatherInfoId8CardEditDetailImg2.get();
                }
            }
            if ((dirtyFlags & 16512) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoPhrase = weatherViewModelWeatherInfo2.phrase;
                } else {
                    weatherViewModelWeatherInfoPhrase = null;
                }
                updateRegistration(7, weatherViewModelWeatherInfoPhrase);
                if (weatherViewModelWeatherInfoPhrase != null) {
                    weatherViewModelWeatherInfoPhraseGet3 = weatherViewModelWeatherInfoPhrase.get();
                }
            }
            if ((dirtyFlags & 16640) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoCardDetailText2 = weatherViewModelWeatherInfo2.cardDetailText2;
                } else {
                    weatherViewModelWeatherInfoCardDetailText2 = null;
                }
                updateRegistration(8, weatherViewModelWeatherInfoCardDetailText2);
                if (weatherViewModelWeatherInfoCardDetailText2 != null) {
                    weatherViewModelWeatherInfoCardDetailText2Get3 = weatherViewModelWeatherInfoCardDetailText2.get();
                }
            }
            if ((dirtyFlags & 16899) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoIsLoadSuccess2 = weatherViewModelWeatherInfo2.isLoadSuccess;
                } else {
                    weatherViewModelWeatherInfoIsLoadSuccess2 = null;
                }
                updateRegistration(9, weatherViewModelWeatherInfoIsLoadSuccess2);
                if (weatherViewModelWeatherInfoIsLoadSuccess2 != null) {
                    weatherViewModelWeatherInfoIsLoadSuccessGet2 = weatherViewModelWeatherInfoIsLoadSuccess2.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2 = ViewDataBinding.safeUnbox(weatherViewModelWeatherInfoIsLoadSuccessGet2);
                if ((dirtyFlags & 16897) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    }
                }
                if ((dirtyFlags & 16898) == 0) {
                    weatherViewModelWeatherInfoIsLoadSuccess3 = weatherViewModelWeatherInfoIsLoadSuccess2;
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2;
                } else if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2) {
                    dirtyFlags |= 4194304;
                    weatherViewModelWeatherInfoIsLoadSuccess3 = weatherViewModelWeatherInfoIsLoadSuccess2;
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    weatherViewModelWeatherInfoIsLoadSuccess3 = weatherViewModelWeatherInfoIsLoadSuccess2;
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2;
                }
            }
            if ((dirtyFlags & 17408) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoTemperatureRange = weatherViewModelWeatherInfo2.temperatureRange;
                } else {
                    weatherViewModelWeatherInfoTemperatureRange = null;
                }
                updateRegistration(10, weatherViewModelWeatherInfoTemperatureRange);
                weatherViewModelWeatherInfoTemperatureRangeGet2 = weatherViewModelWeatherInfoTemperatureRange != null ? weatherViewModelWeatherInfoTemperatureRange.get() : weatherViewModelWeatherInfoTemperatureRangeGet;
            } else {
                weatherViewModelWeatherInfoTemperatureRangeGet2 = weatherViewModelWeatherInfoTemperatureRangeGet;
            }
            if ((dirtyFlags & 18432) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoId8CardEditDetailImg1 = weatherViewModelWeatherInfo2.id8CardEditDetailImg1;
                } else {
                    weatherViewModelWeatherInfoId8CardEditDetailImg1 = null;
                }
                weatherViewModelWeatherInfoTemperatureRangeGet3 = weatherViewModelWeatherInfoTemperatureRangeGet2;
                updateRegistration(11, weatherViewModelWeatherInfoId8CardEditDetailImg1);
                if (weatherViewModelWeatherInfoId8CardEditDetailImg1 != null) {
                    weatherViewModelWeatherInfoId8CardEditDetailImg1Get2 = weatherViewModelWeatherInfoId8CardEditDetailImg1.get();
                }
            } else {
                weatherViewModelWeatherInfoTemperatureRangeGet3 = weatherViewModelWeatherInfoTemperatureRangeGet2;
            }
            if ((dirtyFlags & 20480) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoId8CardEditDetailImg3 = weatherViewModelWeatherInfo2.id8CardEditDetailImg3;
                } else {
                    weatherViewModelWeatherInfoId8CardEditDetailImg3 = null;
                }
                updateRegistration(12, weatherViewModelWeatherInfoId8CardEditDetailImg3);
                if (weatherViewModelWeatherInfoId8CardEditDetailImg3 != null) {
                    Drawable weatherViewModelWeatherInfoId8CardEditDetailImg3Get2 = weatherViewModelWeatherInfoId8CardEditDetailImg3.get();
                    weatherViewModelWeatherInfoId8CardEditDetailImg2Get = weatherViewModelWeatherInfoId8CardEditDetailImg2Get2;
                    weatherViewModelWeatherInfoTemperatureRangeGet4 = weatherViewModelWeatherInfoTemperatureRangeGet3;
                    weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccessGet2;
                    weatherViewModelWeatherInfoId8CardEditDetailImg1Get = weatherViewModelWeatherInfoId8CardEditDetailImg1Get2;
                    weatherViewModelWeatherInfoId8CardEditDetailImg3Get = weatherViewModelWeatherInfoId8CardEditDetailImg3Get2;
                    weatherViewModelWeatherInfoPempId8EditImage = null;
                    weatherViewModelWeatherInfoCardDetailText2Get2 = weatherViewModelWeatherInfoCardDetailText2Get3;
                    weatherViewModelWeatherInfoCardDetailText2Get = null;
                    weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather = weatherViewModelWeatherInfoCardDetailText3Get;
                    weatherViewModelWeatherInfoPhraseGet = weatherViewModelWeatherInfoPhraseGet3;
                    weatherViewModelWeatherInfo = weatherViewModelWeatherInfo2;
                    weatherViewModelWeatherInfoCardDetailText1Get = weatherViewModelWeatherInfoCardDetailText1Get2;
                    weatherViewModelWeatherInfoCity = null;
                    weatherViewModelWeatherInfoTemperatureGet = weatherViewModelWeatherInfoTemperatureGet2;
                    weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
                } else {
                    weatherViewModelWeatherInfoId8CardEditDetailImg2Get = weatherViewModelWeatherInfoId8CardEditDetailImg2Get2;
                    weatherViewModelWeatherInfoTemperatureRangeGet4 = weatherViewModelWeatherInfoTemperatureRangeGet3;
                    weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccessGet2;
                    weatherViewModelWeatherInfoId8CardEditDetailImg1Get = weatherViewModelWeatherInfoId8CardEditDetailImg1Get2;
                    weatherViewModelWeatherInfoId8CardEditDetailImg3Get = null;
                    weatherViewModelWeatherInfoPempId8EditImage = null;
                    weatherViewModelWeatherInfoCardDetailText2Get2 = weatherViewModelWeatherInfoCardDetailText2Get3;
                    weatherViewModelWeatherInfoCardDetailText2Get = null;
                    weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather = weatherViewModelWeatherInfoCardDetailText3Get;
                    weatherViewModelWeatherInfoPhraseGet = weatherViewModelWeatherInfoPhraseGet3;
                    weatherViewModelWeatherInfo = weatherViewModelWeatherInfo2;
                    weatherViewModelWeatherInfoCardDetailText1Get = weatherViewModelWeatherInfoCardDetailText1Get2;
                    weatherViewModelWeatherInfoCity = null;
                    weatherViewModelWeatherInfoTemperatureGet = weatherViewModelWeatherInfoTemperatureGet2;
                    weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
                }
            } else {
                weatherViewModelWeatherInfoId8CardEditDetailImg2Get = weatherViewModelWeatherInfoId8CardEditDetailImg2Get2;
                weatherViewModelWeatherInfoTemperatureRangeGet4 = weatherViewModelWeatherInfoTemperatureRangeGet3;
                weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccessGet2;
                weatherViewModelWeatherInfoId8CardEditDetailImg1Get = weatherViewModelWeatherInfoId8CardEditDetailImg1Get2;
                weatherViewModelWeatherInfoId8CardEditDetailImg3Get = null;
                weatherViewModelWeatherInfoPempId8EditImage = null;
                weatherViewModelWeatherInfoCardDetailText2Get2 = weatherViewModelWeatherInfoCardDetailText2Get3;
                weatherViewModelWeatherInfoCardDetailText2Get = null;
                weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather = weatherViewModelWeatherInfoCardDetailText3Get;
                weatherViewModelWeatherInfoPhraseGet = weatherViewModelWeatherInfoPhraseGet3;
                weatherViewModelWeatherInfo = weatherViewModelWeatherInfo2;
                weatherViewModelWeatherInfoCardDetailText1Get = weatherViewModelWeatherInfoCardDetailText1Get2;
                weatherViewModelWeatherInfoCity = null;
                weatherViewModelWeatherInfoTemperatureGet = weatherViewModelWeatherInfoTemperatureGet2;
                weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
            }
        } else {
            weatherViewModelWeatherInfoId8CardEditDetailImg2Get = null;
            weatherViewModelWeatherInfoCardDetailText1Get = null;
            weatherViewModelWeatherInfoIsLoadSuccessGet = null;
            weatherViewModelWeatherInfoCity = null;
            weatherViewModelWeatherInfoId8CardEditDetailImg1Get = null;
            weatherViewModelWeatherInfoTemperatureGet = null;
            weatherViewModelWeatherInfoPempId8EditImage = null;
            weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
            weatherViewModelWeatherInfoCardDetailText2Get2 = null;
            weatherViewModelWeatherInfo = null;
            weatherViewModelWeatherInfoCardDetailText2Get = null;
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather = null;
            weatherViewModelWeatherInfoId8CardEditDetailImg3Get = null;
            weatherViewModelWeatherInfoPhraseGet = null;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            if (weatherViewModelWeatherInfo != null) {
                weatherViewModelWeatherInfoCityGet = null;
                weatherViewModelWeatherInfoIsLoadSuccess = weatherViewModelWeatherInfo.isLoadSuccess;
            } else {
                weatherViewModelWeatherInfoCityGet = null;
                weatherViewModelWeatherInfoIsLoadSuccess = weatherViewModelWeatherInfoIsLoadSuccess3;
            }
            weatherViewModelWeatherInfoPhraseGet2 = weatherViewModelWeatherInfoPhraseGet;
            updateRegistration(9, weatherViewModelWeatherInfoIsLoadSuccess);
            if (weatherViewModelWeatherInfoIsLoadSuccess != null) {
                weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccess.get();
            }
            androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = ViewDataBinding.safeUnbox(weatherViewModelWeatherInfoIsLoadSuccessGet);
            if ((dirtyFlags & 16897) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                }
            }
            if ((dirtyFlags & 16898) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet) {
                    dirtyFlags |= 4194304;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                }
            }
        } else {
            weatherViewModelWeatherInfoPhraseGet2 = weatherViewModelWeatherInfoPhraseGet;
            weatherViewModelWeatherInfoCityGet = null;
        }
        if ((dirtyFlags & 16912) != 0) {
            boolean weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet ? androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet : false;
            if ((dirtyFlags & 16912) != 0) {
                if (weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
            }
            weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2 = weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse ? 0 : 4;
        } else {
            weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2 = weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) {
            if (weatherViewModelWeatherInfo != null) {
                weatherViewModelWeatherInfoCity2 = weatherViewModelWeatherInfo.city;
            } else {
                weatherViewModelWeatherInfoCity2 = weatherViewModelWeatherInfoCity;
            }
            updateRegistration(0, weatherViewModelWeatherInfoCity2);
            if (weatherViewModelWeatherInfoCity2 != null) {
                weatherViewModelWeatherInfoCityGet = weatherViewModelWeatherInfoCity2.get();
            }
        } else {
            weatherViewModelWeatherInfoCity2 = weatherViewModelWeatherInfoCity;
        }
        if ((dirtyFlags & 4194304) != 0) {
            if (weatherViewModelWeatherInfo != null) {
                weatherViewModelWeatherInfoPempId8EditImage2 = weatherViewModelWeatherInfo.PempId8EditImage;
            } else {
                weatherViewModelWeatherInfoPempId8EditImage2 = weatherViewModelWeatherInfoPempId8EditImage;
            }
            updateRegistration(1, weatherViewModelWeatherInfoPempId8EditImage2);
            if (weatherViewModelWeatherInfoPempId8EditImage2 != null) {
                weatherViewModelWeatherInfoPempId8EditImageGet = weatherViewModelWeatherInfoPempId8EditImage2.get();
            }
        } else {
            weatherViewModelWeatherInfoPempId8EditImage2 = weatherViewModelWeatherInfoPempId8EditImage;
        }
        if ((dirtyFlags & 16897) != 0) {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather2 = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet ? weatherViewModelWeatherInfoCityGet : this.tvCity.getResources().getString(R.string.ksw_id8_weather);
        } else {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather2 = weatherViewModelWeatherInfoCardDetailText2Get;
        }
        if ((dirtyFlags & 16898) != 0) {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8EditImageLayoutAndroidDrawablePempId8MainEditIconWeather = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet ? weatherViewModelWeatherInfoPempId8EditImageGet : AppCompatResources.getDrawable(this.layout.getContext(), R.drawable.pemp_id8_main_edit_icon_weather);
        } else {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8EditImageLayoutAndroidDrawablePempId8MainEditIconWeather = null;
        }
        if ((dirtyFlags & 18432) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.btA, weatherViewModelWeatherInfoId8CardEditDetailImg1Get);
        }
        if ((dirtyFlags & 16388) != 0) {
            TextViewBindingAdapter.setText(this.btA, weatherViewModelWeatherInfoCardDetailText1Get);
        }
        if ((dirtyFlags & 16448) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.btB, weatherViewModelWeatherInfoId8CardEditDetailImg2Get);
        }
        if ((dirtyFlags & 16640) != 0) {
            TextViewBindingAdapter.setText(this.btB, weatherViewModelWeatherInfoCardDetailText2Get2);
        }
        if ((dirtyFlags & 20480) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.btC, weatherViewModelWeatherInfoId8CardEditDetailImg3Get);
        }
        if ((dirtyFlags & 16392) != 0) {
            TextViewBindingAdapter.setText(this.btC, weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather);
        }
        if ((dirtyFlags & 16898) != 0) {
            ViewBindingAdapter.setBackground(this.layout, weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8EditImageLayoutAndroidDrawablePempId8MainEditIconWeather);
        }
        if ((dirtyFlags & 24576) != 0) {
            this.mboundView1.setWeatherViewModel(weatherViewModel);
        }
        if ((dirtyFlags & 17408) != 0) {
            TextViewBindingAdapter.setText(this.mboundView8, weatherViewModelWeatherInfoTemperatureRangeGet4);
        }
        if ((dirtyFlags & 16912) != 0) {
            this.mboundView8.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
            this.temperatureTv.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
            this.tvCity.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
            this.unitWeather.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
            this.weatherTv.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
        }
        if ((dirtyFlags & 16416) != 0) {
            TextViewBindingAdapter.setText(this.temperatureTv, weatherViewModelWeatherInfoTemperatureGet);
        }
        if ((dirtyFlags & 16897) != 0) {
            TextViewBindingAdapter.setText(this.tvCity, weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather2);
        }
        if ((dirtyFlags & 16512) != 0) {
            TextViewBindingAdapter.setText(this.weatherTv, weatherViewModelWeatherInfoPhraseGet2);
        }
        executeBindingsOn(this.mboundView1);
    }
}
