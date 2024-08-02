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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.WeatherInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class WeatherPempDataBindingImpl extends WeatherPempDataBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback298;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final TextView mboundView13;
    private final RelativeLayout mboundView3;
    private final IncludeNearWeatherBinding mboundView31;
    private final ProgressBar mboundView5;
    private final LinearLayout mboundView6;
    private final TextView mboundView7;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(21);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(3, new String[]{"include_near_weather"}, new int[]{16}, new int[]{R.layout.include_near_weather});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 17);
        sparseIntArray.put(R.id.iv_divider, 18);
        sparseIntArray.put(R.id.temperature, 19);
        sparseIntArray.put(R.id.temperature_range, 20);
    }

    public WeatherPempDataBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }

    private WeatherPempDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 15, (TextView) bindings[8], (TextView) bindings[9], (TextView) bindings[10], (ImageView) bindings[18], (ImageView) bindings[15], (ImageView) bindings[2], (RelativeLayout) bindings[0], (RelativeLayout) bindings[19], (FrameLayout) bindings[20], (TextView) bindings[11], (TextView) bindings[4], (TextView) bindings[17], (TextView) bindings[12], (TextView) bindings[14]);
        this.mDirtyFlags = -1;
        this.btA.setTag(null);
        this.btB.setTag(null);
        this.btC.setTag(null);
        this.ivIcon.setTag(null);
        this.ivMask.setTag(null);
        this.llContainer.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[13];
        this.mboundView13 = textView;
        textView.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[3];
        this.mboundView3 = relativeLayout;
        relativeLayout.setTag(null);
        IncludeNearWeatherBinding includeNearWeatherBinding = (IncludeNearWeatherBinding) bindings[16];
        this.mboundView31 = includeNearWeatherBinding;
        setContainedBinding(includeNearWeatherBinding);
        ProgressBar progressBar = (ProgressBar) bindings[5];
        this.mboundView5 = progressBar;
        progressBar.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[6];
        this.mboundView6 = linearLayout;
        linearLayout.setTag(null);
        TextView textView2 = (TextView) bindings[7];
        this.mboundView7 = textView2;
        textView2.setTag(null);
        this.temperatureTv.setTag(null);
        this.tvCity.setTag(null);
        this.unitWeather.setTag(null);
        this.weatherTv.setTag(null);
        setRootTag(root);
        this.mCallback298 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        this.mboundView31.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView31.hasPendingBindings() == false) goto L_0x0016;
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
            com.wits.ksw.databinding.IncludeNearWeatherBinding r0 = r4.mboundView31
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
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.WeatherPempDataBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (26 != variableId) {
            return false;
        }
        setWeatherViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.WeatherPempDataBinding
    public void setWeatherViewModel(LauncherViewModel WeatherViewModel) {
        this.mWeatherViewModel = WeatherViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView31.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeWeatherViewModelWeatherInfoCity((ObservableField) object, fieldId);
            case 1:
                return onChangeWeatherViewModelWeatherInfoCardDetailText1((ObservableField) object, fieldId);
            case 2:
                return onChangeWeatherViewModelWeatherInfoCardDetailText3((ObservableField) object, fieldId);
            case 3:
                return onChangeWeatherViewModelWeatherInfoIsInitFinished((ObservableField) object, fieldId);
            case 4:
                return onChangeWeatherViewModelWeatherInfoTemperature((ObservableField) object, fieldId);
            case 5:
                return onChangeWeatherViewModelWeatherInfoId8CardDetailImg3((ObservableField) object, fieldId);
            case 6:
                return onChangeWeatherViewModelWeatherInfoId8CardDetailImg1((ObservableField) object, fieldId);
            case 7:
                return onChangeWeatherViewModelWeatherInfoId8ImageIcon((ObservableField) object, fieldId);
            case 8:
                return onChangeWeatherViewModelWeatherInfoPhrase((ObservableField) object, fieldId);
            case 9:
                return onChangeWeatherViewModelWeatherInfoPempId8Image((ObservableField) object, fieldId);
            case 10:
                return onChangeWeatherViewModelWeatherInfoErrorMessage((ObservableField) object, fieldId);
            case 11:
                return onChangeWeatherViewModelWeatherInfoCardDetailText2((ObservableField) object, fieldId);
            case 12:
                return onChangeWeatherViewModelWeatherInfoIsLoadSuccess((ObservableField) object, fieldId);
            case 13:
                return onChangeWeatherViewModelWeatherInfoTemperatureRange((ObservableField) object, fieldId);
            case 14:
                return onChangeWeatherViewModelWeatherInfoId8CardDetailImg2((ObservableField) object, fieldId);
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

    private boolean onChangeWeatherViewModelWeatherInfoCardDetailText1(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoCardDetailText3(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoIsInitFinished(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoTemperature(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoId8CardDetailImg3(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoId8CardDetailImg1(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoId8ImageIcon(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoPhrase(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoPempId8Image(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoErrorMessage(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoCardDetailText2(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoIsLoadSuccess(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoTemperatureRange(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean onChangeWeatherViewModelWeatherInfoId8CardDetailImg2(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r0v9 'weatherViewModelWeatherInfoErrorMessageGet'  java.lang.String: [D('weatherViewModelWeatherInfoErrorMessageGet' java.lang.String), D('weatherViewModelWeatherInfoTemperatureGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v11 java.lang.String: [D('weatherViewModelWeatherInfoErrorMessageGet' java.lang.String), D('weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE' int)] */
    /* JADX INFO: Multiple debug info for r0v13 int: [D('weatherViewModelWeatherInfoTemperatureRangeGet' java.lang.String), D('weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE' int)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        String weatherViewModelWeatherInfoPhraseGet;
        String weatherViewModelWeatherInfoTemperatureGet;
        Drawable weatherViewModelWeatherInfoId8ImageIconGet;
        String weatherViewModelWeatherInfoTemperatureRangeGet;
        Drawable weatherViewModelWeatherInfoPempId8ImageGet;
        int weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE;
        ObservableField<String> weatherViewModelWeatherInfoCity;
        Boolean weatherViewModelWeatherInfoIsLoadSuccessGet;
        Drawable weatherViewModelWeatherInfoId8CardDetailImg2Get;
        Drawable weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather;
        String weatherViewModelWeatherInfoErrorMessageGet;
        Drawable weatherViewModelWeatherInfoId8ImageIconGet2;
        String weatherViewModelWeatherInfoCardDetailText3Get;
        WeatherInfo weatherViewModelWeatherInfo;
        String weatherViewModelWeatherInfoCardDetailText2Get;
        int weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2;
        Drawable weatherViewModelWeatherInfoId8CardDetailImg1Get;
        String weatherViewModelWeatherInfoCardDetailText1Get;
        int weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE3;
        String weatherViewModelWeatherInfoErrorMessageGet2;
        Boolean weatherViewModelWeatherInfoIsLoadSuccessGet2;
        int weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE;
        int WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1;
        LauncherViewModel weatherViewModel;
        ObservableField<String> weatherViewModelWeatherInfoCity2;
        String weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather;
        Drawable weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather2;
        int weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE4;
        String weatherViewModelWeatherInfoErrorMessageGet3;
        String weatherViewModelWeatherInfoTemperatureGet2;
        ObservableField<Drawable> weatherViewModelWeatherInfoPempId8Image;
        ObservableField<Boolean> WeatherViewModelWeatherInfoIsLoadSuccess1;
        String weatherViewModelWeatherInfoTemperatureRangeGet2;
        ObservableField<Drawable> weatherViewModelWeatherInfoId8CardDetailImg2;
        ObservableField<String> weatherViewModelWeatherInfoTemperatureRange;
        ObservableField<Boolean> WeatherViewModelWeatherInfoIsLoadSuccess12;
        ObservableField<String> weatherViewModelWeatherInfoCardDetailText2;
        ObservableField<String> weatherViewModelWeatherInfoErrorMessage;
        ObservableField<String> weatherViewModelWeatherInfoPhrase;
        ObservableField<Drawable> weatherViewModelWeatherInfoId8ImageIcon;
        ObservableField<Drawable> weatherViewModelWeatherInfoId8CardDetailImg1;
        ObservableField<Drawable> weatherViewModelWeatherInfoId8CardDetailImg3;
        ObservableField<String> weatherViewModelWeatherInfoTemperature;
        ObservableField<Boolean> weatherViewModelWeatherInfoIsInitFinished;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String weatherViewModelWeatherInfoTemperatureRangeGet3 = null;
        Boolean weatherViewModelWeatherInfoIsLoadSuccessGet3 = null;
        LauncherViewModel weatherViewModel2 = this.mWeatherViewModel;
        boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet = false;
        ObservableField<String> weatherViewModelWeatherInfoCardDetailText1 = null;
        ObservableField<String> weatherViewModelWeatherInfoCardDetailText3 = null;
        String weatherViewModelWeatherInfoCityGet = null;
        String weatherViewModelWeatherInfoCardDetailText1Get2 = null;
        boolean weatherViewModelWeatherInfoIsLoadSuccess = false;
        String weatherViewModelWeatherInfoTemperatureGet3 = null;
        int weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE5 = 0;
        String weatherViewModelWeatherInfoCardDetailText2Get2 = null;
        String weatherViewModelWeatherInfoCardDetailText3Get2 = null;
        Drawable weatherViewModelWeatherInfoId8ImageIconGet3 = null;
        String weatherViewModelWeatherInfoErrorMessageGet4 = null;
        Drawable weatherViewModelWeatherInfoId8CardDetailImg3Get = null;
        ObservableField<Boolean> WeatherViewModelWeatherInfoIsLoadSuccess13 = null;
        Boolean weatherViewModelWeatherInfoIsInitFinishedGet = null;
        boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = false;
        String weatherViewModelWeatherInfoPhraseGet2 = null;
        Drawable weatherViewModelWeatherInfoId8CardDetailImg1Get2 = null;
        if ((dirtyFlags & 98303) != 0) {
            WeatherInfo weatherViewModelWeatherInfo2 = LauncherViewModel.weatherInfo;
            if ((dirtyFlags & 65538) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoCardDetailText1 = weatherViewModelWeatherInfo2.cardDetailText1;
                }
                updateRegistration(1, weatherViewModelWeatherInfoCardDetailText1);
                if (weatherViewModelWeatherInfoCardDetailText1 != null) {
                    weatherViewModelWeatherInfoCardDetailText1Get2 = weatherViewModelWeatherInfoCardDetailText1.get();
                }
            }
            if ((dirtyFlags & 65540) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoCardDetailText3 = weatherViewModelWeatherInfo2.cardDetailText3;
                }
                updateRegistration(2, weatherViewModelWeatherInfoCardDetailText3);
                if (weatherViewModelWeatherInfoCardDetailText3 != null) {
                    weatherViewModelWeatherInfoCardDetailText3Get2 = weatherViewModelWeatherInfoCardDetailText3.get();
                }
            }
            if ((dirtyFlags & 69640) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoIsInitFinished = weatherViewModelWeatherInfo2.isInitFinished;
                } else {
                    weatherViewModelWeatherInfoIsInitFinished = null;
                }
                weatherViewModelWeatherInfoTemperatureRangeGet2 = null;
                updateRegistration(3, weatherViewModelWeatherInfoIsInitFinished);
                if (weatherViewModelWeatherInfoIsInitFinished != null) {
                    weatherViewModelWeatherInfoIsInitFinishedGet = weatherViewModelWeatherInfoIsInitFinished.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet2 = ViewDataBinding.safeUnbox(weatherViewModelWeatherInfoIsInitFinishedGet);
                if ((dirtyFlags & 69640) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet2) {
                        dirtyFlags = dirtyFlags | 16777216 | 67108864;
                    } else {
                        dirtyFlags = dirtyFlags | 8388608 | 33554432;
                    }
                }
                if ((dirtyFlags & 65544) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet2) {
                        dirtyFlags |= 268435456;
                    } else {
                        dirtyFlags |= 134217728;
                    }
                }
                if ((dirtyFlags & 65544) != 0) {
                    weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE5 = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet2 ? 4 : 0;
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet2;
                } else {
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet2;
                }
            } else {
                weatherViewModelWeatherInfoTemperatureRangeGet2 = null;
            }
            if ((dirtyFlags & 65552) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoTemperature = weatherViewModelWeatherInfo2.temperature;
                } else {
                    weatherViewModelWeatherInfoTemperature = null;
                }
                updateRegistration(4, weatherViewModelWeatherInfoTemperature);
                if (weatherViewModelWeatherInfoTemperature != null) {
                    weatherViewModelWeatherInfoTemperatureGet3 = weatherViewModelWeatherInfoTemperature.get();
                }
            }
            if ((dirtyFlags & 65568) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoId8CardDetailImg3 = weatherViewModelWeatherInfo2.id8CardDetailImg3;
                } else {
                    weatherViewModelWeatherInfoId8CardDetailImg3 = null;
                }
                updateRegistration(5, weatherViewModelWeatherInfoId8CardDetailImg3);
                if (weatherViewModelWeatherInfoId8CardDetailImg3 != null) {
                    weatherViewModelWeatherInfoId8CardDetailImg3Get = weatherViewModelWeatherInfoId8CardDetailImg3.get();
                }
            }
            if ((dirtyFlags & 65600) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoId8CardDetailImg1 = weatherViewModelWeatherInfo2.id8CardDetailImg1;
                } else {
                    weatherViewModelWeatherInfoId8CardDetailImg1 = null;
                }
                updateRegistration(6, weatherViewModelWeatherInfoId8CardDetailImg1);
                if (weatherViewModelWeatherInfoId8CardDetailImg1 != null) {
                    weatherViewModelWeatherInfoId8CardDetailImg1Get2 = weatherViewModelWeatherInfoId8CardDetailImg1.get();
                }
            }
            if ((dirtyFlags & 65664) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoId8ImageIcon = weatherViewModelWeatherInfo2.id8ImageIcon;
                } else {
                    weatherViewModelWeatherInfoId8ImageIcon = null;
                }
                updateRegistration(7, weatherViewModelWeatherInfoId8ImageIcon);
                if (weatherViewModelWeatherInfoId8ImageIcon != null) {
                    weatherViewModelWeatherInfoId8ImageIconGet3 = weatherViewModelWeatherInfoId8ImageIcon.get();
                }
            }
            if ((dirtyFlags & 65792) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoPhrase = weatherViewModelWeatherInfo2.phrase;
                } else {
                    weatherViewModelWeatherInfoPhrase = null;
                }
                updateRegistration(8, weatherViewModelWeatherInfoPhrase);
                if (weatherViewModelWeatherInfoPhrase != null) {
                    weatherViewModelWeatherInfoPhraseGet2 = weatherViewModelWeatherInfoPhrase.get();
                }
            }
            if ((dirtyFlags & 66560) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoErrorMessage = weatherViewModelWeatherInfo2.errorMessage;
                } else {
                    weatherViewModelWeatherInfoErrorMessage = null;
                }
                updateRegistration(10, weatherViewModelWeatherInfoErrorMessage);
                if (weatherViewModelWeatherInfoErrorMessage != null) {
                    weatherViewModelWeatherInfoErrorMessageGet4 = weatherViewModelWeatherInfoErrorMessage.get();
                }
            }
            if ((dirtyFlags & 67584) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoCardDetailText2 = weatherViewModelWeatherInfo2.cardDetailText2;
                } else {
                    weatherViewModelWeatherInfoCardDetailText2 = null;
                }
                updateRegistration(11, weatherViewModelWeatherInfoCardDetailText2);
                if (weatherViewModelWeatherInfoCardDetailText2 != null) {
                    weatherViewModelWeatherInfoCardDetailText2Get2 = weatherViewModelWeatherInfoCardDetailText2.get();
                }
            }
            if ((dirtyFlags & 70145) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    WeatherViewModelWeatherInfoIsLoadSuccess12 = weatherViewModelWeatherInfo2.isLoadSuccess;
                } else {
                    WeatherViewModelWeatherInfoIsLoadSuccess12 = null;
                }
                updateRegistration(12, WeatherViewModelWeatherInfoIsLoadSuccess12);
                if (WeatherViewModelWeatherInfoIsLoadSuccess12 != null) {
                    weatherViewModelWeatherInfoIsLoadSuccessGet3 = WeatherViewModelWeatherInfoIsLoadSuccess12.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2 = ViewDataBinding.safeUnbox(weatherViewModelWeatherInfoIsLoadSuccessGet3);
                if ((dirtyFlags & 69633) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                }
                if ((dirtyFlags & 70144) == 0) {
                    WeatherViewModelWeatherInfoIsLoadSuccess13 = WeatherViewModelWeatherInfoIsLoadSuccess12;
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2;
                } else if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2) {
                    dirtyFlags |= 4194304;
                    WeatherViewModelWeatherInfoIsLoadSuccess13 = WeatherViewModelWeatherInfoIsLoadSuccess12;
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    WeatherViewModelWeatherInfoIsLoadSuccess13 = WeatherViewModelWeatherInfoIsLoadSuccess12;
                    androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet2;
                }
            }
            if ((dirtyFlags & 73728) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoTemperatureRange = weatherViewModelWeatherInfo2.temperatureRange;
                } else {
                    weatherViewModelWeatherInfoTemperatureRange = null;
                }
                updateRegistration(13, weatherViewModelWeatherInfoTemperatureRange);
                weatherViewModelWeatherInfoTemperatureRangeGet3 = weatherViewModelWeatherInfoTemperatureRange != null ? weatherViewModelWeatherInfoTemperatureRange.get() : weatherViewModelWeatherInfoTemperatureRangeGet2;
            } else {
                weatherViewModelWeatherInfoTemperatureRangeGet3 = weatherViewModelWeatherInfoTemperatureRangeGet2;
            }
            if ((dirtyFlags & 81920) != 0) {
                if (weatherViewModelWeatherInfo2 != null) {
                    weatherViewModelWeatherInfoId8CardDetailImg2 = weatherViewModelWeatherInfo2.id8CardDetailImg2;
                } else {
                    weatherViewModelWeatherInfoId8CardDetailImg2 = null;
                }
                updateRegistration(14, weatherViewModelWeatherInfoId8CardDetailImg2);
                if (weatherViewModelWeatherInfoId8CardDetailImg2 != null) {
                    Drawable weatherViewModelWeatherInfoId8CardDetailImg2Get2 = weatherViewModelWeatherInfoId8CardDetailImg2.get();
                    weatherViewModelWeatherInfoTemperatureRangeGet3 = weatherViewModelWeatherInfoTemperatureRangeGet3;
                    weatherViewModelWeatherInfoPhraseGet = weatherViewModelWeatherInfoPhraseGet2;
                    weatherViewModelWeatherInfoId8CardDetailImg1Get = weatherViewModelWeatherInfoId8CardDetailImg1Get2;
                    weatherViewModelWeatherInfoTemperatureRangeGet = null;
                    weatherViewModelWeatherInfoId8ImageIconGet2 = weatherViewModelWeatherInfoId8ImageIconGet3;
                    weatherViewModelWeatherInfoId8ImageIconGet = null;
                    weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather = weatherViewModelWeatherInfoId8CardDetailImg3Get;
                    weatherViewModelWeatherInfoTemperatureGet = weatherViewModelWeatherInfoTemperatureGet3;
                    weatherViewModelWeatherInfoCity = null;
                    weatherViewModelWeatherInfoCardDetailText2Get = weatherViewModelWeatherInfoCardDetailText2Get2;
                    weatherViewModelWeatherInfoPempId8ImageGet = null;
                    weatherViewModelWeatherInfoCardDetailText3Get = weatherViewModelWeatherInfoCardDetailText3Get2;
                    weatherViewModelWeatherInfoErrorMessageGet = weatherViewModelWeatherInfoErrorMessageGet4;
                    weatherViewModelWeatherInfoId8CardDetailImg2Get = weatherViewModelWeatherInfoId8CardDetailImg2Get2;
                    weatherViewModelWeatherInfo = weatherViewModelWeatherInfo2;
                    weatherViewModelWeatherInfoCardDetailText1Get = weatherViewModelWeatherInfoCardDetailText1Get2;
                    weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccessGet3;
                    weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2 = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE5;
                    weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = 0;
                } else {
                    weatherViewModelWeatherInfoTemperatureRangeGet3 = weatherViewModelWeatherInfoTemperatureRangeGet3;
                    weatherViewModelWeatherInfoPhraseGet = weatherViewModelWeatherInfoPhraseGet2;
                    weatherViewModelWeatherInfoId8CardDetailImg1Get = weatherViewModelWeatherInfoId8CardDetailImg1Get2;
                    weatherViewModelWeatherInfoTemperatureRangeGet = null;
                    weatherViewModelWeatherInfoId8ImageIconGet2 = weatherViewModelWeatherInfoId8ImageIconGet3;
                    weatherViewModelWeatherInfoId8ImageIconGet = null;
                    weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather = weatherViewModelWeatherInfoId8CardDetailImg3Get;
                    weatherViewModelWeatherInfoTemperatureGet = weatherViewModelWeatherInfoTemperatureGet3;
                    weatherViewModelWeatherInfoCity = null;
                    weatherViewModelWeatherInfoCardDetailText2Get = weatherViewModelWeatherInfoCardDetailText2Get2;
                    weatherViewModelWeatherInfoPempId8ImageGet = null;
                    weatherViewModelWeatherInfoCardDetailText3Get = weatherViewModelWeatherInfoCardDetailText3Get2;
                    weatherViewModelWeatherInfoErrorMessageGet = weatherViewModelWeatherInfoErrorMessageGet4;
                    weatherViewModelWeatherInfoId8CardDetailImg2Get = null;
                    weatherViewModelWeatherInfo = weatherViewModelWeatherInfo2;
                    weatherViewModelWeatherInfoCardDetailText1Get = weatherViewModelWeatherInfoCardDetailText1Get2;
                    weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccessGet3;
                    weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2 = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE5;
                    weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = 0;
                }
            } else {
                weatherViewModelWeatherInfoPhraseGet = weatherViewModelWeatherInfoPhraseGet2;
                weatherViewModelWeatherInfoId8CardDetailImg1Get = weatherViewModelWeatherInfoId8CardDetailImg1Get2;
                weatherViewModelWeatherInfoTemperatureRangeGet = null;
                weatherViewModelWeatherInfoId8ImageIconGet2 = weatherViewModelWeatherInfoId8ImageIconGet3;
                weatherViewModelWeatherInfoId8ImageIconGet = null;
                weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather = weatherViewModelWeatherInfoId8CardDetailImg3Get;
                weatherViewModelWeatherInfoTemperatureGet = weatherViewModelWeatherInfoTemperatureGet3;
                weatherViewModelWeatherInfoCity = null;
                weatherViewModelWeatherInfoCardDetailText2Get = weatherViewModelWeatherInfoCardDetailText2Get2;
                weatherViewModelWeatherInfoPempId8ImageGet = null;
                weatherViewModelWeatherInfoCardDetailText3Get = weatherViewModelWeatherInfoCardDetailText3Get2;
                weatherViewModelWeatherInfoErrorMessageGet = weatherViewModelWeatherInfoErrorMessageGet4;
                weatherViewModelWeatherInfoId8CardDetailImg2Get = null;
                weatherViewModelWeatherInfo = weatherViewModelWeatherInfo2;
                weatherViewModelWeatherInfoCardDetailText1Get = weatherViewModelWeatherInfoCardDetailText1Get2;
                weatherViewModelWeatherInfoIsLoadSuccessGet = weatherViewModelWeatherInfoIsLoadSuccessGet3;
                weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2 = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE5;
                weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = 0;
            }
        } else {
            weatherViewModelWeatherInfoCardDetailText1Get = null;
            weatherViewModelWeatherInfoPhraseGet = null;
            weatherViewModelWeatherInfoId8CardDetailImg1Get = null;
            weatherViewModelWeatherInfoIsLoadSuccessGet = null;
            weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2 = 0;
            weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = 0;
            weatherViewModelWeatherInfo = null;
            weatherViewModelWeatherInfoTemperatureRangeGet = null;
            weatherViewModelWeatherInfoId8ImageIconGet2 = null;
            weatherViewModelWeatherInfoId8ImageIconGet = null;
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather = null;
            weatherViewModelWeatherInfoTemperatureGet = null;
            weatherViewModelWeatherInfoCity = null;
            weatherViewModelWeatherInfoCardDetailText2Get = null;
            weatherViewModelWeatherInfoPempId8ImageGet = null;
            weatherViewModelWeatherInfoCardDetailText3Get = null;
            weatherViewModelWeatherInfoErrorMessageGet = null;
            weatherViewModelWeatherInfoId8CardDetailImg2Get = null;
        }
        if ((dirtyFlags & 83886080) != 0) {
            if (weatherViewModelWeatherInfo != null) {
                weatherViewModelWeatherInfoErrorMessageGet2 = weatherViewModelWeatherInfoErrorMessageGet;
                WeatherViewModelWeatherInfoIsLoadSuccess1 = weatherViewModelWeatherInfo.isLoadSuccess;
            } else {
                weatherViewModelWeatherInfoErrorMessageGet2 = weatherViewModelWeatherInfoErrorMessageGet;
                WeatherViewModelWeatherInfoIsLoadSuccess1 = WeatherViewModelWeatherInfoIsLoadSuccess13;
            }
            weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE3 = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2;
            updateRegistration(12, WeatherViewModelWeatherInfoIsLoadSuccess1);
            if (WeatherViewModelWeatherInfoIsLoadSuccess1 != null) {
                weatherViewModelWeatherInfoIsLoadSuccessGet2 = WeatherViewModelWeatherInfoIsLoadSuccess1.get();
            } else {
                weatherViewModelWeatherInfoIsLoadSuccessGet2 = weatherViewModelWeatherInfoIsLoadSuccessGet;
            }
            androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet = ViewDataBinding.safeUnbox(weatherViewModelWeatherInfoIsLoadSuccessGet2);
            if ((dirtyFlags & 69633) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
            }
            if ((dirtyFlags & 70144) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet) {
                    dirtyFlags |= 4194304;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                }
            }
            if ((dirtyFlags & 67108864) != 0) {
                weatherViewModelWeatherInfoIsLoadSuccess = !androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet;
            }
        } else {
            weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE3 = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2;
            weatherViewModelWeatherInfoErrorMessageGet2 = weatherViewModelWeatherInfoErrorMessageGet;
            weatherViewModelWeatherInfoIsLoadSuccessGet2 = weatherViewModelWeatherInfoIsLoadSuccessGet;
        }
        if ((dirtyFlags & 69640) != 0) {
            boolean weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet ? androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet : false;
            boolean WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse1 = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsInitFinishedGet ? weatherViewModelWeatherInfoIsLoadSuccess : false;
            if ((dirtyFlags & 69640) != 0) {
                if (weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                }
            }
            if ((dirtyFlags & 69640) != 0) {
                if (WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse1) {
                    dirtyFlags |= 1073741824;
                } else {
                    dirtyFlags |= 536870912;
                }
            }
            weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse ? 0 : 4;
            WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalse1 ? 0 : 4;
        } else {
            weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE;
            WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = 0;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            if (weatherViewModelWeatherInfo != null) {
                weatherViewModelWeatherInfoCity2 = weatherViewModelWeatherInfo.city;
            } else {
                weatherViewModelWeatherInfoCity2 = weatherViewModelWeatherInfoCity;
            }
            weatherViewModel = weatherViewModel2;
            updateRegistration(0, weatherViewModelWeatherInfoCity2);
            if (weatherViewModelWeatherInfoCity2 != null) {
                weatherViewModelWeatherInfoCityGet = weatherViewModelWeatherInfoCity2.get();
            }
        } else {
            weatherViewModel = weatherViewModel2;
            weatherViewModelWeatherInfoCity2 = weatherViewModelWeatherInfoCity;
        }
        if ((dirtyFlags & 4194304) != 0) {
            if (weatherViewModelWeatherInfo != null) {
                weatherViewModelWeatherInfoPempId8Image = weatherViewModelWeatherInfo.PempId8Image;
            } else {
                weatherViewModelWeatherInfoPempId8Image = null;
            }
            updateRegistration(9, weatherViewModelWeatherInfoPempId8Image);
            if (weatherViewModelWeatherInfoPempId8Image != null) {
                weatherViewModelWeatherInfoPempId8ImageGet = weatherViewModelWeatherInfoPempId8Image.get();
            }
        }
        if ((dirtyFlags & 69633) != 0) {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet ? weatherViewModelWeatherInfoCityGet : this.tvCity.getResources().getString(R.string.ksw_id8_weather);
        } else {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather = weatherViewModelWeatherInfoTemperatureRangeGet;
        }
        if ((dirtyFlags & 70144) != 0) {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather2 = androidDatabindingViewDataBindingSafeUnboxWeatherViewModelWeatherInfoIsLoadSuccessGet ? weatherViewModelWeatherInfoPempId8ImageGet : AppCompatResources.getDrawable(this.mboundView1.getContext(), R.drawable.pemp_id8_main_icon_weather);
        } else {
            weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather2 = weatherViewModelWeatherInfoId8ImageIconGet;
        }
        if ((dirtyFlags & 65600) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.btA, weatherViewModelWeatherInfoId8CardDetailImg1Get);
        }
        if ((dirtyFlags & 65538) != 0) {
            TextViewBindingAdapter.setText(this.btA, weatherViewModelWeatherInfoCardDetailText1Get);
        }
        if ((dirtyFlags & 81920) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.btB, weatherViewModelWeatherInfoId8CardDetailImg2Get);
        }
        if ((dirtyFlags & 67584) != 0) {
            TextViewBindingAdapter.setText(this.btB, weatherViewModelWeatherInfoCardDetailText2Get);
        }
        if ((dirtyFlags & 65568) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.btC, weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather);
        }
        if ((dirtyFlags & 65540) != 0) {
            TextViewBindingAdapter.setText(this.btC, weatherViewModelWeatherInfoCardDetailText3Get);
        }
        if ((dirtyFlags & 65664) != 0) {
            ViewBindingAdapter.setBackground(this.ivIcon, weatherViewModelWeatherInfoId8ImageIconGet2);
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
            this.ivMask.setOnClickListener(this.mCallback298);
        }
        if ((dirtyFlags & 70144) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView1, weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoPempId8ImageMboundView1AndroidDrawablePempId8MainIconWeather2);
        }
        if ((dirtyFlags & 73728) != 0) {
            TextViewBindingAdapter.setText(this.mboundView13, weatherViewModelWeatherInfoTemperatureRangeGet3);
        }
        if ((dirtyFlags & 69640) != 0) {
            this.mboundView13.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE);
            this.mboundView6.setVisibility(WeatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1);
            this.temperatureTv.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE);
            this.tvCity.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE);
            this.unitWeather.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE);
            this.weatherTv.setVisibility(weatherViewModelWeatherInfoIsInitFinishedWeatherViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 98304) != 0) {
            this.mboundView31.setWeatherViewModel(weatherViewModel);
        }
        if ((dirtyFlags & 65544) != 0) {
            weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE4 = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE3;
            this.mboundView5.setVisibility(weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE4);
        } else {
            weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE4 = weatherViewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE3;
        }
        if ((dirtyFlags & 66560) != 0) {
            weatherViewModelWeatherInfoErrorMessageGet3 = weatherViewModelWeatherInfoErrorMessageGet2;
            TextViewBindingAdapter.setText(this.mboundView7, weatherViewModelWeatherInfoErrorMessageGet3);
        } else {
            weatherViewModelWeatherInfoErrorMessageGet3 = weatherViewModelWeatherInfoErrorMessageGet2;
        }
        if ((dirtyFlags & 65552) != 0) {
            weatherViewModelWeatherInfoTemperatureGet2 = weatherViewModelWeatherInfoTemperatureGet;
            TextViewBindingAdapter.setText(this.temperatureTv, weatherViewModelWeatherInfoTemperatureGet2);
        } else {
            weatherViewModelWeatherInfoTemperatureGet2 = weatherViewModelWeatherInfoTemperatureGet;
        }
        if ((dirtyFlags & 69633) != 0) {
            TextViewBindingAdapter.setText(this.tvCity, weatherViewModelWeatherInfoIsLoadSuccessWeatherViewModelWeatherInfoCityTvCityAndroidStringKswId8Weather);
        }
        if ((dirtyFlags & 65792) != 0) {
            TextViewBindingAdapter.setText(this.weatherTv, weatherViewModelWeatherInfoPhraseGet);
        }
        executeBindingsOn(this.mboundView31);
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel weatherViewModel = this.mWeatherViewModel;
        if (weatherViewModel != null) {
            weatherViewModel.openWeatherApp(callbackArg_0);
        }
    }
}
