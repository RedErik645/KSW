package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.databinding.adapters.ViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.WeatherInfo;
import com.wits.ksw.launcher.model.RomeoViewModelV2;
import com.wits.ksw.launcher.view.MarqueeTextView;

public class ActivityRomeoV2BindingImpl extends ActivityRomeoV2Binding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback116;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final TextView mboundView11;
    private final ProgressBar mboundView2;
    private final LinearLayout mboundView3;
    private final TextView mboundView4;
    private final MarqueeTextView mboundView5;
    private final MarqueeTextView mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.romeo_navi, 12);
        sparseIntArray.put(R.id.romeo_music, 13);
        sparseIntArray.put(R.id.romeo_video, 14);
        sparseIntArray.put(R.id.romeo_phone, 15);
        sparseIntArray.put(R.id.romeo_app, 16);
        sparseIntArray.put(R.id.romeo_setting, 17);
        sparseIntArray.put(R.id.romeo_indicator_1, 18);
        sparseIntArray.put(R.id.romeo_indicator_2, 19);
        sparseIntArray.put(R.id.romeo_indicator_3, 20);
        sparseIntArray.put(R.id.romeo_indicator_4, 21);
        sparseIntArray.put(R.id.romeo_indicator_5, 22);
        sparseIntArray.put(R.id.romeo_indicator_6, 23);
        sparseIntArray.put(R.id.page_indicator1, 24);
        sparseIntArray.put(R.id.page_indicator2, 25);
        sparseIntArray.put(R.id.romeo_main_rv, 26);
        sparseIntArray.put(R.id.videoConstraintLayout, 27);
    }

    public ActivityRomeoV2BindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 28, sIncludes, sViewsWithIds));
    }

    private ActivityRomeoV2BindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 10, (TextView) bindings[6], (ImageView) bindings[8], (ImageView) bindings[24], (ImageView) bindings[25], (ImageView) bindings[16], (ImageView) bindings[18], (ImageView) bindings[19], (ImageView) bindings[20], (ImageView) bindings[21], (ImageView) bindings[22], (ImageView) bindings[23], (RecyclerView) bindings[26], (ImageView) bindings[13], (ImageView) bindings[12], (ImageView) bindings[15], (ImageView) bindings[17], (ImageView) bindings[14], (TextView) bindings[9], (TextView) bindings[10], (ConstraintLayout) bindings[27], (ImageView) bindings[1]);
        this.mDirtyFlags = -1;
        this.dateTv.setTag(null);
        this.ivIcon.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) bindings[11];
        this.mboundView11 = textView;
        textView.setTag(null);
        ProgressBar progressBar = (ProgressBar) bindings[2];
        this.mboundView2 = progressBar;
        progressBar.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        MarqueeTextView marqueeTextView = (MarqueeTextView) bindings[5];
        this.mboundView5 = marqueeTextView;
        marqueeTextView.setTag(null);
        MarqueeTextView marqueeTextView2 = (MarqueeTextView) bindings[7];
        this.mboundView7 = marqueeTextView2;
        marqueeTextView2.setTag(null);
        this.temperatureTv.setTag(null);
        this.unitWeather.setTag(null);
        this.weatherImageView.setTag(null);
        setRootTag(root);
        this.mCallback116 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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
        setViewModel((RomeoViewModelV2) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityRomeoV2Binding
    public void setViewModel(RomeoViewModelV2 ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelWeatherInfoTemperatureRange((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelWeatherInfoErrorMessage((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelWeatherInfoTemperature((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelWeatherInfoPhrase((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelWeatherInfoDate((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelWeatherInfoRomeoV2ImageIcon((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelWeatherInfoIsInitFinished((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelWeatherInfoIsLoadSuccess((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelWeatherInfoTemperUnit((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelWeatherInfoCity((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelWeatherInfoTemperatureRange(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoErrorMessage(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoTemperature(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoPhrase(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoDate(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoRomeoV2ImageIcon(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoIsInitFinished(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoIsLoadSuccess(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoTemperUnit(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoCity(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        Boolean viewModelWeatherInfoIsLoadSuccessGet;
        String viewModelWeatherInfoTemperatureRangeGet;
        ObservableField<String> viewModelWeatherInfoCity;
        Drawable viewModelWeatherInfoRomeoV2ImageIconGet;
        String viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather;
        String viewModelWeatherInfoTemperatureRangeGet2;
        String viewModelWeatherInfoTemperatureGet;
        int viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE;
        int ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1;
        int viewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE;
        String viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoCityMboundView5AndroidStringKswId8Weather;
        ObservableField<String> viewModelWeatherInfoCity2;
        String viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather2;
        String viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoCityMboundView5AndroidStringKswId8Weather2;
        String viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoPhraseMboundView7AndroidStringKswId8Weather;
        ObservableField<String> viewModelWeatherInfoDate;
        ObservableField<Boolean> ViewModelWeatherInfoIsLoadSuccess1;
        ObservableField<String> viewModelWeatherInfoTemperatureRange;
        ObservableField<String> viewModelWeatherInfoTemperatureRange2;
        ObservableField<String> viewModelWeatherInfoTemperUnit;
        ObservableField<Boolean> ViewModelWeatherInfoIsLoadSuccess12;
        ObservableField<Boolean> viewModelWeatherInfoIsInitFinished;
        ObservableField<Drawable> viewModelWeatherInfoRomeoV2ImageIcon;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Boolean viewModelWeatherInfoIsLoadSuccessGet2 = null;
        WeatherInfo viewModelWeatherInfo = null;
        String viewModelWeatherInfoTemperUnitGet = null;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet = false;
        ObservableField<String> viewModelWeatherInfoErrorMessage = null;
        ObservableField<String> viewModelWeatherInfoTemperature = null;
        ObservableField<String> viewModelWeatherInfoPhrase = null;
        String viewModelWeatherInfoDateGet = null;
        String viewModelWeatherInfoTemperatureGet2 = null;
        int viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2 = 0;
        String viewModelWeatherInfoCityGet = null;
        boolean viewModelWeatherInfoIsLoadSuccess = false;
        String viewModelWeatherInfoTemperatureRangeGet3 = null;
        String viewModelWeatherInfoPhraseGet = null;
        String viewModelWeatherInfoErrorMessageGet = null;
        Drawable viewModelWeatherInfoRomeoV2ImageIconGet2 = null;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet = false;
        ObservableField<Boolean> ViewModelWeatherInfoIsLoadSuccess13 = null;
        Boolean viewModelWeatherInfoIsInitFinishedGet = null;
        RomeoViewModelV2 romeoViewModelV2 = this.mViewModel;
        if ((dirtyFlags & 3071) != 0) {
            viewModelWeatherInfo = RomeoViewModelV2.weatherInfo;
            if ((dirtyFlags & 2049) != 0) {
                if (viewModelWeatherInfo != null) {
                    viewModelWeatherInfoTemperatureRange = viewModelWeatherInfo.temperatureRange;
                } else {
                    viewModelWeatherInfoTemperatureRange = null;
                }
                updateRegistration(0, viewModelWeatherInfoTemperatureRange);
                if (viewModelWeatherInfoTemperatureRange != null) {
                    viewModelWeatherInfoTemperatureRangeGet3 = viewModelWeatherInfoTemperatureRange.get();
                }
            } else {
                viewModelWeatherInfoTemperatureRange = null;
            }
            if ((dirtyFlags & 2050) != 0) {
                if (viewModelWeatherInfo != null) {
                    viewModelWeatherInfoErrorMessage = viewModelWeatherInfo.errorMessage;
                }
                updateRegistration(1, viewModelWeatherInfoErrorMessage);
                if (viewModelWeatherInfoErrorMessage != null) {
                    viewModelWeatherInfoErrorMessageGet = viewModelWeatherInfoErrorMessage.get();
                }
            }
            if ((dirtyFlags & 2052) != 0) {
                if (viewModelWeatherInfo != null) {
                    viewModelWeatherInfoTemperature = viewModelWeatherInfo.temperature;
                }
                updateRegistration(2, viewModelWeatherInfoTemperature);
                if (viewModelWeatherInfoTemperature != null) {
                    viewModelWeatherInfoTemperatureGet2 = viewModelWeatherInfoTemperature.get();
                }
            }
            if ((dirtyFlags & 2080) != 0) {
                if (viewModelWeatherInfo != null) {
                    viewModelWeatherInfoRomeoV2ImageIcon = viewModelWeatherInfo.romeoV2ImageIcon;
                } else {
                    viewModelWeatherInfoRomeoV2ImageIcon = null;
                }
                viewModelWeatherInfoTemperatureRange2 = viewModelWeatherInfoTemperatureRange;
                updateRegistration(5, viewModelWeatherInfoRomeoV2ImageIcon);
                if (viewModelWeatherInfoRomeoV2ImageIcon != null) {
                    viewModelWeatherInfoRomeoV2ImageIconGet2 = viewModelWeatherInfoRomeoV2ImageIcon.get();
                }
            } else {
                viewModelWeatherInfoTemperatureRange2 = viewModelWeatherInfoTemperatureRange;
            }
            if ((dirtyFlags & 2240) != 0) {
                if (viewModelWeatherInfo != null) {
                    viewModelWeatherInfoIsInitFinished = viewModelWeatherInfo.isInitFinished;
                } else {
                    viewModelWeatherInfoIsInitFinished = null;
                }
                updateRegistration(6, viewModelWeatherInfoIsInitFinished);
                if (viewModelWeatherInfoIsInitFinished != null) {
                    viewModelWeatherInfoIsInitFinishedGet = viewModelWeatherInfoIsInitFinished.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet2 = ViewDataBinding.safeUnbox(viewModelWeatherInfoIsInitFinishedGet);
                if ((dirtyFlags & 2112) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    }
                }
                if ((dirtyFlags & 2240) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet2) {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE | 8388608;
                    } else {
                        dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED | 4194304;
                    }
                }
                if ((dirtyFlags & 2112) != 0) {
                    viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet2 ? 4 : 0;
                    androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet2;
                } else {
                    androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet2;
                }
            }
            if ((dirtyFlags & 2712) != 0) {
                if (viewModelWeatherInfo != null) {
                    ViewModelWeatherInfoIsLoadSuccess12 = viewModelWeatherInfo.isLoadSuccess;
                } else {
                    ViewModelWeatherInfoIsLoadSuccess12 = null;
                }
                updateRegistration(7, ViewModelWeatherInfoIsLoadSuccess12);
                if (ViewModelWeatherInfoIsLoadSuccess12 != null) {
                    viewModelWeatherInfoIsLoadSuccessGet2 = ViewModelWeatherInfoIsLoadSuccess12.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet2 = ViewDataBinding.safeUnbox(viewModelWeatherInfoIsLoadSuccessGet2);
                if ((dirtyFlags & 2192) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                }
                if ((dirtyFlags & 2688) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                    }
                }
                if ((dirtyFlags & 2184) == 0) {
                    ViewModelWeatherInfoIsLoadSuccess13 = ViewModelWeatherInfoIsLoadSuccess12;
                    androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet2;
                } else if (androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet2) {
                    dirtyFlags |= 134217728;
                    ViewModelWeatherInfoIsLoadSuccess13 = ViewModelWeatherInfoIsLoadSuccess12;
                    androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet2;
                } else {
                    dirtyFlags |= 67108864;
                    ViewModelWeatherInfoIsLoadSuccess13 = ViewModelWeatherInfoIsLoadSuccess12;
                    androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet2;
                }
            }
            if ((dirtyFlags & 2304) != 0) {
                if (viewModelWeatherInfo != null) {
                    viewModelWeatherInfoTemperUnit = viewModelWeatherInfo.temperUnit;
                } else {
                    viewModelWeatherInfoTemperUnit = null;
                }
                updateRegistration(8, viewModelWeatherInfoTemperUnit);
                if (viewModelWeatherInfoTemperUnit != null) {
                    viewModelWeatherInfoTemperUnitGet = viewModelWeatherInfoTemperUnit.get();
                    viewModelWeatherInfoTemperatureGet = viewModelWeatherInfoTemperatureGet2;
                    viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2;
                    viewModelWeatherInfoCity = null;
                    viewModelWeatherInfoTemperatureRangeGet2 = viewModelWeatherInfoTemperatureRangeGet3;
                    viewModelWeatherInfoTemperatureRangeGet = null;
                    viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather = viewModelWeatherInfoErrorMessageGet;
                    viewModelWeatherInfoIsLoadSuccessGet = viewModelWeatherInfoIsLoadSuccessGet2;
                    viewModelWeatherInfoRomeoV2ImageIconGet = viewModelWeatherInfoRomeoV2ImageIconGet2;
                } else {
                    viewModelWeatherInfoTemperatureGet = viewModelWeatherInfoTemperatureGet2;
                    viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2;
                    viewModelWeatherInfoCity = null;
                    viewModelWeatherInfoTemperatureRangeGet2 = viewModelWeatherInfoTemperatureRangeGet3;
                    viewModelWeatherInfoTemperatureRangeGet = null;
                    viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather = viewModelWeatherInfoErrorMessageGet;
                    viewModelWeatherInfoIsLoadSuccessGet = viewModelWeatherInfoIsLoadSuccessGet2;
                    viewModelWeatherInfoRomeoV2ImageIconGet = viewModelWeatherInfoRomeoV2ImageIconGet2;
                }
            } else {
                viewModelWeatherInfoTemperatureGet = viewModelWeatherInfoTemperatureGet2;
                viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE2;
                viewModelWeatherInfoCity = null;
                viewModelWeatherInfoTemperatureRangeGet2 = viewModelWeatherInfoTemperatureRangeGet3;
                viewModelWeatherInfoTemperatureRangeGet = null;
                viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather = viewModelWeatherInfoErrorMessageGet;
                viewModelWeatherInfoIsLoadSuccessGet = viewModelWeatherInfoIsLoadSuccessGet2;
                viewModelWeatherInfoRomeoV2ImageIconGet = viewModelWeatherInfoRomeoV2ImageIconGet2;
            }
        } else {
            viewModelWeatherInfoTemperatureGet = null;
            viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE = 0;
            viewModelWeatherInfoCity = null;
            viewModelWeatherInfoTemperatureRangeGet2 = null;
            viewModelWeatherInfoTemperatureRangeGet = null;
            viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather = null;
            viewModelWeatherInfoIsLoadSuccessGet = null;
            viewModelWeatherInfoRomeoV2ImageIconGet = null;
        }
        if ((dirtyFlags & 10485760) != 0) {
            if (viewModelWeatherInfo != null) {
                ViewModelWeatherInfoIsLoadSuccess1 = viewModelWeatherInfo.isLoadSuccess;
            } else {
                ViewModelWeatherInfoIsLoadSuccess1 = ViewModelWeatherInfoIsLoadSuccess13;
            }
            updateRegistration(7, ViewModelWeatherInfoIsLoadSuccess1);
            if (ViewModelWeatherInfoIsLoadSuccess1 != null) {
                viewModelWeatherInfoIsLoadSuccessGet = ViewModelWeatherInfoIsLoadSuccess1.get();
            }
            boolean androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet3 = ViewDataBinding.safeUnbox(viewModelWeatherInfoIsLoadSuccessGet);
            if ((dirtyFlags & 2192) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet3) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                }
            }
            if ((dirtyFlags & 2688) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet3) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
                }
            }
            if ((dirtyFlags & 2184) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet3) {
                    dirtyFlags |= 134217728;
                } else {
                    dirtyFlags |= 67108864;
                }
            }
            if ((dirtyFlags & 8388608) != 0) {
                viewModelWeatherInfoIsLoadSuccess = !androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet3;
                androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet3;
            } else {
                androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet3;
            }
        }
        if ((dirtyFlags & 2240) != 0) {
            boolean viewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalse = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet ? androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet : false;
            boolean ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalse1 = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsInitFinishedGet ? viewModelWeatherInfoIsLoadSuccess : false;
            if ((dirtyFlags & 2240) != 0) {
                if (viewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalse) {
                    dirtyFlags |= 33554432;
                } else {
                    dirtyFlags |= 16777216;
                }
            }
            if ((dirtyFlags & 2240) != 0) {
                if (ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalse1) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                } else {
                    dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                }
            }
            int ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12 = viewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalse ? 0 : 4;
            viewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalse1 ? 0 : 4;
            ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12;
        } else {
            viewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
            ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = 0;
        }
        if ((dirtyFlags & 134217728) != 0) {
            if (viewModelWeatherInfo != null) {
                viewModelWeatherInfoPhrase = viewModelWeatherInfo.phrase;
            }
            viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoCityMboundView5AndroidStringKswId8Weather = null;
            updateRegistration(3, viewModelWeatherInfoPhrase);
            if (viewModelWeatherInfoPhrase != null) {
                viewModelWeatherInfoPhraseGet = viewModelWeatherInfoPhrase.get();
            }
        } else {
            viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoCityMboundView5AndroidStringKswId8Weather = null;
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_PLAY_FROM_URI) != 0) {
            if (viewModelWeatherInfo != null) {
                viewModelWeatherInfoDate = viewModelWeatherInfo.date;
            } else {
                viewModelWeatherInfoDate = null;
            }
            updateRegistration(4, viewModelWeatherInfoDate);
            if (viewModelWeatherInfoDate != null) {
                viewModelWeatherInfoDateGet = viewModelWeatherInfoDate.get();
            }
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
            if (viewModelWeatherInfo != null) {
                viewModelWeatherInfoCity2 = viewModelWeatherInfo.city;
            } else {
                viewModelWeatherInfoCity2 = viewModelWeatherInfoCity;
            }
            updateRegistration(9, viewModelWeatherInfoCity2);
            if (viewModelWeatherInfoCity2 != null) {
                viewModelWeatherInfoCityGet = viewModelWeatherInfoCity2.get();
            }
        } else {
            viewModelWeatherInfoCity2 = viewModelWeatherInfoCity;
        }
        if ((dirtyFlags & 2192) != 0) {
            viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather2 = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet ? viewModelWeatherInfoDateGet : this.dateTv.getResources().getString(R.string.ksw_id8_weather);
        } else {
            viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather2 = viewModelWeatherInfoTemperatureRangeGet;
        }
        if ((dirtyFlags & 2688) != 0) {
            viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoCityMboundView5AndroidStringKswId8Weather2 = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet ? viewModelWeatherInfoCityGet : this.mboundView5.getResources().getString(R.string.ksw_id8_weather);
        } else {
            viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoCityMboundView5AndroidStringKswId8Weather2 = viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoCityMboundView5AndroidStringKswId8Weather;
        }
        if ((dirtyFlags & 2184) != 0) {
            viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoPhraseMboundView7AndroidStringKswId8Weather = androidDatabindingViewDataBindingSafeUnboxViewModelWeatherInfoIsLoadSuccessGet ? viewModelWeatherInfoPhraseGet : this.mboundView7.getResources().getString(R.string.ksw_id8_weather);
        } else {
            viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoPhraseMboundView7AndroidStringKswId8Weather = null;
        }
        if ((dirtyFlags & 2192) != 0) {
            TextViewBindingAdapter.setText(this.dateTv, viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather2);
        }
        if ((dirtyFlags & 2240) != 0) {
            this.dateTv.setVisibility(ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1);
            this.ivIcon.setVisibility(ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1);
            this.mboundView11.setVisibility(ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1);
            this.mboundView3.setVisibility(viewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE);
            this.mboundView5.setVisibility(ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1);
            this.mboundView7.setVisibility(ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1);
            this.temperatureTv.setVisibility(ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1);
            this.unitWeather.setVisibility(ViewModelWeatherInfoIsInitFinishedViewModelWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1);
        }
        if ((dirtyFlags & 2080) != 0) {
            ViewBindingAdapter.setBackground(this.ivIcon, viewModelWeatherInfoRomeoV2ImageIconGet);
        }
        if ((dirtyFlags & 2049) != 0) {
            TextViewBindingAdapter.setText(this.mboundView11, viewModelWeatherInfoTemperatureRangeGet2);
        }
        if ((dirtyFlags & 2112) != 0) {
            this.mboundView2.setVisibility(viewModelWeatherInfoIsInitFinishedViewINVISIBLEViewVISIBLE);
        }
        if ((dirtyFlags & 2050) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoDateDateTvAndroidStringKswId8Weather);
        }
        if ((dirtyFlags & 2688) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoCityMboundView5AndroidStringKswId8Weather2);
        }
        if ((dirtyFlags & 2184) != 0) {
            TextViewBindingAdapter.setText(this.mboundView7, viewModelWeatherInfoIsLoadSuccessViewModelWeatherInfoPhraseMboundView7AndroidStringKswId8Weather);
        }
        if ((dirtyFlags & 2052) != 0) {
            TextViewBindingAdapter.setText(this.temperatureTv, viewModelWeatherInfoTemperatureGet);
        }
        if ((dirtyFlags & 2304) != 0) {
            TextViewBindingAdapter.setText(this.unitWeather, viewModelWeatherInfoTemperUnitGet);
        }
        if ((dirtyFlags & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != 0) {
            this.weatherImageView.setOnClickListener(this.mCallback116);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        RomeoViewModelV2 viewModel = this.mViewModel;
        if (viewModel != null) {
            viewModel.openWeatherApp(callbackArg_0);
        }
    }
}
