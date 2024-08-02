package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.databinding.adapters.ViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.WeatherInfo;
import com.wits.ksw.launcher.model.AudiViewModel;
import com.wits.ksw.launcher.view.MarqueeTextView;

public class AudiRightWeatherBindingSw600dpLandImpl extends AudiRightWeatherBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback84;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final TextView mboundView10;
    private final ImageView mboundView11;
    private final TextView mboundView12;
    private final ImageView mboundView13;
    private final TextView mboundView14;
    private final MarqueeTextView mboundView15;
    private final LinearLayout mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final ImageView mboundView9;

    public AudiRightWeatherBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private AudiRightWeatherBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 16, (ConstraintLayout) bindings[1], (ImageView) bindings[2], (TextView) bindings[5], (TextView) bindings[6]);
        this.mDirtyFlags = -1;
        this.clWeather.setTag(null);
        this.ivIcon.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) bindings[11];
        this.mboundView11 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) bindings[12];
        this.mboundView12 = textView2;
        textView2.setTag(null);
        ImageView imageView2 = (ImageView) bindings[13];
        this.mboundView13 = imageView2;
        imageView2.setTag(null);
        TextView textView3 = (TextView) bindings[14];
        this.mboundView14 = textView3;
        textView3.setTag(null);
        MarqueeTextView marqueeTextView = (MarqueeTextView) bindings[15];
        this.mboundView15 = marqueeTextView;
        marqueeTextView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag(null);
        TextView textView4 = (TextView) bindings[4];
        this.mboundView4 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[7];
        this.mboundView7 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) bindings[8];
        this.mboundView8 = textView6;
        textView6.setTag(null);
        ImageView imageView3 = (ImageView) bindings[9];
        this.mboundView9 = imageView3;
        imageView3.setTag(null);
        this.temperatureTv.setTag(null);
        this.unitWeather.setTag(null);
        setRootTag(root);
        this.mCallback84 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
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
        setVm((AudiViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AudiRightWeatherBinding
    public void setVm(AudiViewModel Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmWeatherInfoTemperature((ObservableField) object, fieldId);
            case 1:
                return onChangeVmWeatherInfoPhrase((ObservableField) object, fieldId);
            case 2:
                return onChangeVmWeatherInfoAudiCardDetailImg2((ObservableField) object, fieldId);
            case 3:
                return onChangeVmWeatherInfoAudiCardDetailText1((ObservableField) object, fieldId);
            case 4:
                return onChangeVmWeatherInfoAudiCardDetailText3((ObservableField) object, fieldId);
            case 5:
                return onChangeVmWeatherInfoCity((ObservableField) object, fieldId);
            case 6:
                return onChangeVmWeatherInfoIsLoadSuccess((ObservableField) object, fieldId);
            case 7:
                return onChangeVmWeatherInfoIsInitFinished((ObservableField) object, fieldId);
            case 8:
                return onChangeVmLogoView((ObservableInt) object, fieldId);
            case 9:
                return onChangeVmWeatherInfoAudiImageIcon((ObservableField) object, fieldId);
            case 10:
                return onChangeVmWeatherInfoTemperatureRange((ObservableField) object, fieldId);
            case 11:
                return onChangeVmWeatherInfoTemperUnit((ObservableField) object, fieldId);
            case 12:
                return onChangeVmWeatherInfoAudiCardDetailImg3((ObservableField) object, fieldId);
            case 13:
                return onChangeVmWeatherInfoAudiCardDetailImg1((ObservableField) object, fieldId);
            case 14:
                return onChangeVmWeatherInfoErrorMessage((ObservableField) object, fieldId);
            case 15:
                return onChangeVmWeatherInfoAudiCardDetailText2((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmWeatherInfoTemperature(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoPhrase(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoAudiCardDetailImg2(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoAudiCardDetailText1(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoAudiCardDetailText3(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoCity(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoIsLoadSuccess(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoIsInitFinished(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeVmLogoView(ObservableInt VmLogoView, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoAudiImageIcon(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoTemperatureRange(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoTemperUnit(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoAudiCardDetailImg3(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoAudiCardDetailImg1(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoErrorMessage(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    private boolean onChangeVmWeatherInfoAudiCardDetailText2(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r0v10 java.lang.String: [D('vmWeatherInfoAudiCardDetailImg1Get' android.graphics.drawable.Drawable), D('vmWeatherInfoTemperatureGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v12 android.graphics.drawable.Drawable: [D('vmWeatherInfoAudiCardDetailImg1Get' android.graphics.drawable.Drawable), D('vmWeatherInfoPhraseGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v14 java.lang.String: [D('vmWeatherInfoAudiCardDetailImg2Get' android.graphics.drawable.Drawable), D('vmWeatherInfoPhraseGet' java.lang.String)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int vmLogoViewGet;
        String vmWeatherInfoTemperUnitGet;
        int VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1;
        int vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE;
        String vmWeatherInfoAudiCardDetailText1Get;
        WeatherInfo vmWeatherInfo;
        Drawable vmWeatherInfoAudiCardDetailImg3Get;
        String vmWeatherInfoTemperatureGet;
        String vmWeatherInfoTemperatureRangeGet;
        String vmWeatherInfoAudiCardDetailText2Get;
        long dirtyFlags2;
        String vmWeatherInfoAudiCardDetailText3Get;
        String vmWeatherInfoPhraseGet;
        Drawable vmWeatherInfoAudiCardDetailImg2Get;
        Drawable vmWeatherInfoAudiCardDetailImg1Get;
        String vmWeatherInfoTemperatureGet2;
        int VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12;
        int vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2;
        String vmWeatherInfoPhraseGet2;
        String vmWeatherInfoIsLoadSuccessVmWeatherInfoCityMboundView15AndroidStringKswId8Weather;
        String vmWeatherInfoTemperatureRangeGet2;
        String vmWeatherInfoPhraseGet3;
        Drawable vmWeatherInfoAudiCardDetailImg1Get2;
        String vmWeatherInfoTemperatureGet3;
        ObservableField<String> vmWeatherInfoCity;
        ObservableField<Boolean> vmWeatherInfoIsLoadSuccess;
        String vmWeatherInfoPhraseGet4;
        String vmWeatherInfoPhraseGet5;
        ObservableField<String> vmWeatherInfoAudiCardDetailText2;
        ObservableField<String> vmWeatherInfoErrorMessage;
        ObservableField<Drawable> vmWeatherInfoAudiCardDetailImg1;
        ObservableField<Drawable> vmWeatherInfoAudiCardDetailImg3;
        ObservableField<String> vmWeatherInfoTemperUnit;
        ObservableField<String> vmWeatherInfoTemperatureRange;
        ObservableField<Drawable> vmWeatherInfoAudiImageIcon;
        ObservableField<Boolean> vmWeatherInfoIsInitFinished;
        ObservableField<Boolean> vmWeatherInfoIsLoadSuccess2;
        ObservableField<String> vmWeatherInfoAudiCardDetailText3;
        ObservableField<String> vmWeatherInfoAudiCardDetailText1;
        ObservableInt vmLogoView;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableField<String> vmWeatherInfoTemperature = null;
        Drawable vmWeatherInfoAudiCardDetailImg1Get3 = null;
        ObservableField<String> vmWeatherInfoPhrase = null;
        AudiViewModel vm = this.mVm;
        ObservableField<Drawable> vmWeatherInfoAudiCardDetailImg2 = null;
        Drawable vmWeatherInfoAudiImageIconGet = null;
        String vmWeatherInfoErrorMessageGet = null;
        String vmWeatherInfoAudiCardDetailText3Get2 = null;
        boolean androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsInitFinishedGet = false;
        String vmWeatherInfoTemperUnitGet2 = null;
        ObservableField<Boolean> vmWeatherInfoIsLoadSuccess3 = null;
        boolean androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsLoadSuccessGet = false;
        Boolean vmWeatherInfoIsLoadSuccessGet = null;
        String vmWeatherInfoTemperatureRangeGet3 = null;
        Boolean vmWeatherInfoIsInitFinishedGet = null;
        String vmWeatherInfoTemperatureGet4 = null;
        boolean VmWeatherInfoIsLoadSuccess1 = false;
        Drawable vmWeatherInfoAudiCardDetailImg3Get2 = null;
        String vmWeatherInfoCityGet = null;
        String vmWeatherInfoAudiCardDetailText1Get2 = null;
        Drawable vmWeatherInfoAudiCardDetailImg2Get2 = null;
        if ((dirtyFlags & 196864) != 0) {
            if (vm != null) {
                vmLogoView = vm.logoView;
            } else {
                vmLogoView = null;
            }
            updateRegistration(8, vmLogoView);
            vmLogoViewGet = vmLogoView != null ? vmLogoView.get() : 0;
        } else {
            vmLogoViewGet = 0;
        }
        if ((dirtyFlags & 196351) != 0) {
            WeatherInfo vmWeatherInfo2 = AudiViewModel.weatherInfo;
            if ((dirtyFlags & 131073) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoTemperature = vmWeatherInfo2.temperature;
                }
                updateRegistration(0, vmWeatherInfoTemperature);
                if (vmWeatherInfoTemperature != null) {
                    vmWeatherInfoTemperatureGet4 = vmWeatherInfoTemperature.get();
                }
            }
            if ((dirtyFlags & 131074) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoPhrase = vmWeatherInfo2.phrase;
                }
                updateRegistration(1, vmWeatherInfoPhrase);
                if (vmWeatherInfoPhrase != null) {
                    vmWeatherInfoPhraseGet4 = vmWeatherInfoPhrase.get();
                } else {
                    vmWeatherInfoPhraseGet4 = null;
                }
            } else {
                vmWeatherInfoPhraseGet4 = null;
            }
            if ((dirtyFlags & 131076) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoAudiCardDetailImg2 = vmWeatherInfo2.audiCardDetailImg2;
                }
                vmWeatherInfoPhraseGet5 = vmWeatherInfoPhraseGet4;
                updateRegistration(2, vmWeatherInfoAudiCardDetailImg2);
                if (vmWeatherInfoAudiCardDetailImg2 != null) {
                    vmWeatherInfoAudiCardDetailImg2Get2 = vmWeatherInfoAudiCardDetailImg2.get();
                }
            } else {
                vmWeatherInfoPhraseGet5 = vmWeatherInfoPhraseGet4;
            }
            if ((dirtyFlags & 131080) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoAudiCardDetailText1 = vmWeatherInfo2.audiCardDetailText1;
                } else {
                    vmWeatherInfoAudiCardDetailText1 = null;
                }
                updateRegistration(3, vmWeatherInfoAudiCardDetailText1);
                if (vmWeatherInfoAudiCardDetailText1 != null) {
                    vmWeatherInfoAudiCardDetailText1Get2 = vmWeatherInfoAudiCardDetailText1.get();
                }
            }
            if ((dirtyFlags & 131088) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoAudiCardDetailText3 = vmWeatherInfo2.audiCardDetailText3;
                } else {
                    vmWeatherInfoAudiCardDetailText3 = null;
                }
                updateRegistration(4, vmWeatherInfoAudiCardDetailText3);
                if (vmWeatherInfoAudiCardDetailText3 != null) {
                    vmWeatherInfoAudiCardDetailText3Get2 = vmWeatherInfoAudiCardDetailText3.get();
                }
            }
            if ((dirtyFlags & 131168) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoIsLoadSuccess2 = vmWeatherInfo2.isLoadSuccess;
                } else {
                    vmWeatherInfoIsLoadSuccess2 = null;
                }
                updateRegistration(6, vmWeatherInfoIsLoadSuccess2);
                if (vmWeatherInfoIsLoadSuccess2 != null) {
                    vmWeatherInfoIsLoadSuccessGet = vmWeatherInfoIsLoadSuccess2.get();
                }
                androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsLoadSuccessGet = ViewDataBinding.safeUnbox(vmWeatherInfoIsLoadSuccessGet);
                if ((dirtyFlags & 131168) == 0) {
                    vmWeatherInfoIsLoadSuccess3 = vmWeatherInfoIsLoadSuccess2;
                } else if (androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsLoadSuccessGet) {
                    dirtyFlags |= 134217728;
                    vmWeatherInfoIsLoadSuccess3 = vmWeatherInfoIsLoadSuccess2;
                } else {
                    dirtyFlags |= 67108864;
                    vmWeatherInfoIsLoadSuccess3 = vmWeatherInfoIsLoadSuccess2;
                }
            }
            if ((dirtyFlags & 131264) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoIsInitFinished = vmWeatherInfo2.isInitFinished;
                } else {
                    vmWeatherInfoIsInitFinished = null;
                }
                updateRegistration(7, vmWeatherInfoIsInitFinished);
                if (vmWeatherInfoIsInitFinished != null) {
                    vmWeatherInfoIsInitFinishedGet = vmWeatherInfoIsInitFinished.get();
                }
                androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsInitFinishedGet = ViewDataBinding.safeUnbox(vmWeatherInfoIsInitFinishedGet);
                if ((dirtyFlags & 131264) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsInitFinishedGet) {
                        dirtyFlags = dirtyFlags | 8388608 | 33554432;
                    } else {
                        dirtyFlags = dirtyFlags | 4194304 | 16777216;
                    }
                }
            }
            if ((dirtyFlags & 131584) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoAudiImageIcon = vmWeatherInfo2.audiImageIcon;
                } else {
                    vmWeatherInfoAudiImageIcon = null;
                }
                updateRegistration(9, vmWeatherInfoAudiImageIcon);
                if (vmWeatherInfoAudiImageIcon != null) {
                    vmWeatherInfoAudiImageIconGet = vmWeatherInfoAudiImageIcon.get();
                }
            }
            if ((dirtyFlags & 132096) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoTemperatureRange = vmWeatherInfo2.temperatureRange;
                } else {
                    vmWeatherInfoTemperatureRange = null;
                }
                updateRegistration(10, vmWeatherInfoTemperatureRange);
                if (vmWeatherInfoTemperatureRange != null) {
                    vmWeatherInfoTemperatureRangeGet3 = vmWeatherInfoTemperatureRange.get();
                }
            }
            if ((dirtyFlags & 133120) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoTemperUnit = vmWeatherInfo2.temperUnit;
                } else {
                    vmWeatherInfoTemperUnit = null;
                }
                updateRegistration(11, vmWeatherInfoTemperUnit);
                if (vmWeatherInfoTemperUnit != null) {
                    vmWeatherInfoTemperUnitGet2 = vmWeatherInfoTemperUnit.get();
                }
            }
            if ((dirtyFlags & 135168) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoAudiCardDetailImg3 = vmWeatherInfo2.audiCardDetailImg3;
                } else {
                    vmWeatherInfoAudiCardDetailImg3 = null;
                }
                updateRegistration(12, vmWeatherInfoAudiCardDetailImg3);
                if (vmWeatherInfoAudiCardDetailImg3 != null) {
                    vmWeatherInfoAudiCardDetailImg3Get2 = vmWeatherInfoAudiCardDetailImg3.get();
                }
            }
            if ((dirtyFlags & 139264) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoAudiCardDetailImg1 = vmWeatherInfo2.audiCardDetailImg1;
                } else {
                    vmWeatherInfoAudiCardDetailImg1 = null;
                }
                updateRegistration(13, vmWeatherInfoAudiCardDetailImg1);
                if (vmWeatherInfoAudiCardDetailImg1 != null) {
                    vmWeatherInfoAudiCardDetailImg1Get3 = vmWeatherInfoAudiCardDetailImg1.get();
                }
            }
            if ((dirtyFlags & 147456) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoErrorMessage = vmWeatherInfo2.errorMessage;
                } else {
                    vmWeatherInfoErrorMessage = null;
                }
                updateRegistration(14, vmWeatherInfoErrorMessage);
                if (vmWeatherInfoErrorMessage != null) {
                    vmWeatherInfoErrorMessageGet = vmWeatherInfoErrorMessage.get();
                }
            }
            if ((dirtyFlags & 163840) != 0) {
                if (vmWeatherInfo2 != null) {
                    vmWeatherInfoAudiCardDetailText2 = vmWeatherInfo2.audiCardDetailText2;
                } else {
                    vmWeatherInfoAudiCardDetailText2 = null;
                }
                updateRegistration(15, vmWeatherInfoAudiCardDetailText2);
                if (vmWeatherInfoAudiCardDetailText2 != null) {
                    vmWeatherInfoAudiCardDetailImg2Get = vmWeatherInfoAudiCardDetailImg2Get2;
                    vmWeatherInfo = vmWeatherInfo2;
                    dirtyFlags2 = dirtyFlags;
                    vmWeatherInfoAudiCardDetailText3Get = vmWeatherInfoAudiCardDetailText3Get2;
                    vmWeatherInfoPhraseGet = vmWeatherInfoPhraseGet5;
                    vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
                    vmWeatherInfoAudiCardDetailText2Get = vmWeatherInfoAudiCardDetailText2.get();
                    vmWeatherInfoTemperatureGet = vmWeatherInfoTemperatureGet4;
                    vmWeatherInfoAudiCardDetailImg3Get = vmWeatherInfoAudiCardDetailImg3Get2;
                    vmWeatherInfoAudiCardDetailText1Get = vmWeatherInfoAudiCardDetailText1Get2;
                    vmWeatherInfoTemperUnitGet = vmWeatherInfoTemperUnitGet2;
                    VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = 0;
                    vmWeatherInfoTemperatureRangeGet = vmWeatherInfoTemperatureRangeGet3;
                } else {
                    vmWeatherInfoAudiCardDetailImg2Get = vmWeatherInfoAudiCardDetailImg2Get2;
                    vmWeatherInfo = vmWeatherInfo2;
                    dirtyFlags2 = dirtyFlags;
                    vmWeatherInfoAudiCardDetailText3Get = vmWeatherInfoAudiCardDetailText3Get2;
                    vmWeatherInfoPhraseGet = vmWeatherInfoPhraseGet5;
                    vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
                    vmWeatherInfoAudiCardDetailText2Get = null;
                    vmWeatherInfoTemperatureGet = vmWeatherInfoTemperatureGet4;
                    vmWeatherInfoAudiCardDetailImg3Get = vmWeatherInfoAudiCardDetailImg3Get2;
                    vmWeatherInfoAudiCardDetailText1Get = vmWeatherInfoAudiCardDetailText1Get2;
                    vmWeatherInfoTemperUnitGet = vmWeatherInfoTemperUnitGet2;
                    VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = 0;
                    vmWeatherInfoTemperatureRangeGet = vmWeatherInfoTemperatureRangeGet3;
                }
            } else {
                vmWeatherInfoAudiCardDetailImg2Get = vmWeatherInfoAudiCardDetailImg2Get2;
                vmWeatherInfo = vmWeatherInfo2;
                dirtyFlags2 = dirtyFlags;
                vmWeatherInfoAudiCardDetailText3Get = vmWeatherInfoAudiCardDetailText3Get2;
                vmWeatherInfoPhraseGet = vmWeatherInfoPhraseGet5;
                vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
                vmWeatherInfoAudiCardDetailText2Get = null;
                vmWeatherInfoTemperatureGet = vmWeatherInfoTemperatureGet4;
                vmWeatherInfoAudiCardDetailImg3Get = vmWeatherInfoAudiCardDetailImg3Get2;
                vmWeatherInfoAudiCardDetailText1Get = vmWeatherInfoAudiCardDetailText1Get2;
                vmWeatherInfoTemperUnitGet = vmWeatherInfoTemperUnitGet2;
                VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = 0;
                vmWeatherInfoTemperatureRangeGet = vmWeatherInfoTemperatureRangeGet3;
            }
        } else {
            vmWeatherInfoAudiCardDetailImg2Get = null;
            dirtyFlags2 = dirtyFlags;
            vmWeatherInfoAudiCardDetailText3Get = null;
            vmWeatherInfoPhraseGet = null;
            vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE = 0;
            vmWeatherInfoAudiCardDetailText2Get = null;
            vmWeatherInfoTemperatureGet = null;
            vmWeatherInfoAudiCardDetailImg3Get = null;
            vmWeatherInfoAudiCardDetailText1Get = null;
            vmWeatherInfoTemperUnitGet = null;
            VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1 = 0;
            vmWeatherInfoTemperatureRangeGet = null;
            vmWeatherInfo = null;
        }
        if ((dirtyFlags2 & 41943040) != 0) {
            if (vmWeatherInfo != null) {
                vmWeatherInfoTemperatureGet2 = vmWeatherInfoTemperatureGet;
                vmWeatherInfoIsLoadSuccess = vmWeatherInfo.isLoadSuccess;
            } else {
                vmWeatherInfoTemperatureGet2 = vmWeatherInfoTemperatureGet;
                vmWeatherInfoIsLoadSuccess = vmWeatherInfoIsLoadSuccess3;
            }
            vmWeatherInfoAudiCardDetailImg1Get = vmWeatherInfoAudiCardDetailImg1Get3;
            updateRegistration(6, vmWeatherInfoIsLoadSuccess);
            if (vmWeatherInfoIsLoadSuccess != null) {
                vmWeatherInfoIsLoadSuccessGet = vmWeatherInfoIsLoadSuccess.get();
            }
            androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsLoadSuccessGet = ViewDataBinding.safeUnbox(vmWeatherInfoIsLoadSuccessGet);
            if ((dirtyFlags2 & 131168) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsLoadSuccessGet) {
                    dirtyFlags2 |= 134217728;
                } else {
                    dirtyFlags2 |= 67108864;
                }
            }
            if ((dirtyFlags2 & 33554432) != 0) {
                VmWeatherInfoIsLoadSuccess1 = !androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsLoadSuccessGet;
            }
        } else {
            vmWeatherInfoAudiCardDetailImg1Get = vmWeatherInfoAudiCardDetailImg1Get3;
            vmWeatherInfoTemperatureGet2 = vmWeatherInfoTemperatureGet;
        }
        if ((dirtyFlags2 & 131264) != 0) {
            boolean vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalse = androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsInitFinishedGet ? androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsLoadSuccessGet : false;
            boolean VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalse1 = androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsInitFinishedGet ? VmWeatherInfoIsLoadSuccess1 : false;
            if ((dirtyFlags2 & 131264) != 0) {
                if (vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalse) {
                    dirtyFlags2 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                } else {
                    dirtyFlags2 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                }
            }
            if ((dirtyFlags2 & 131264) != 0) {
                if (VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalse1) {
                    dirtyFlags2 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                } else {
                    dirtyFlags2 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                }
            }
            VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12 = vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalse ? 0 : 4;
            vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2 = VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalse1 ? 0 : 4;
        } else {
            vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2 = vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE;
            VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12 = VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE1;
        }
        if ((dirtyFlags2 & 134217728) != 0) {
            if (vmWeatherInfo != null) {
                vmWeatherInfoPhraseGet2 = vmWeatherInfoPhraseGet;
                vmWeatherInfoCity = vmWeatherInfo.city;
            } else {
                vmWeatherInfoPhraseGet2 = vmWeatherInfoPhraseGet;
                vmWeatherInfoCity = null;
            }
            updateRegistration(5, vmWeatherInfoCity);
            if (vmWeatherInfoCity != null) {
                vmWeatherInfoCityGet = vmWeatherInfoCity.get();
            }
        } else {
            vmWeatherInfoPhraseGet2 = vmWeatherInfoPhraseGet;
        }
        if ((dirtyFlags2 & 131168) != 0) {
            vmWeatherInfoIsLoadSuccessVmWeatherInfoCityMboundView15AndroidStringKswId8Weather = androidDatabindingViewDataBindingSafeUnboxVmWeatherInfoIsLoadSuccessGet ? vmWeatherInfoCityGet : this.mboundView15.getResources().getString(R.string.ksw_id8_weather);
        } else {
            vmWeatherInfoIsLoadSuccessVmWeatherInfoCityMboundView15AndroidStringKswId8Weather = null;
        }
        if ((dirtyFlags2 & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0) {
            vmWeatherInfoTemperatureRangeGet2 = vmWeatherInfoTemperatureRangeGet;
            this.clWeather.setOnClickListener(this.mCallback84);
        } else {
            vmWeatherInfoTemperatureRangeGet2 = vmWeatherInfoTemperatureRangeGet;
        }
        if ((dirtyFlags2 & 131584) != 0) {
            ViewBindingAdapter.setBackground(this.ivIcon, vmWeatherInfoAudiImageIconGet);
        }
        if ((dirtyFlags2 & 131264) != 0) {
            this.ivIcon.setVisibility(VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12);
            this.mboundView15.setVisibility(VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12);
            this.mboundView3.setVisibility(vmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE2);
            this.mboundView7.setVisibility(VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12);
            this.mboundView8.setVisibility(VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12);
            this.temperatureTv.setVisibility(VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12);
            this.unitWeather.setVisibility(VmWeatherInfoIsInitFinishedVmWeatherInfoIsLoadSuccessBooleanFalseViewVISIBLEViewINVISIBLE12);
        }
        if ((dirtyFlags2 & 196864) != 0) {
            this.mboundView0.setVisibility(vmLogoViewGet);
        }
        if ((dirtyFlags2 & 131080) != 0) {
            TextViewBindingAdapter.setText(this.mboundView10, vmWeatherInfoAudiCardDetailText1Get);
        }
        if ((dirtyFlags2 & 131076) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView11, vmWeatherInfoAudiCardDetailImg2Get);
        }
        if ((dirtyFlags2 & 163840) != 0) {
            TextViewBindingAdapter.setText(this.mboundView12, vmWeatherInfoAudiCardDetailText2Get);
        }
        if ((dirtyFlags2 & 135168) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView13, vmWeatherInfoAudiCardDetailImg3Get);
        }
        if ((dirtyFlags2 & 131088) != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, vmWeatherInfoAudiCardDetailText3Get);
        }
        if ((dirtyFlags2 & 131168) != 0) {
            TextViewBindingAdapter.setText(this.mboundView15, vmWeatherInfoIsLoadSuccessVmWeatherInfoCityMboundView15AndroidStringKswId8Weather);
        }
        if ((dirtyFlags2 & 147456) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, vmWeatherInfoErrorMessageGet);
        }
        if ((dirtyFlags2 & 132096) != 0) {
            TextViewBindingAdapter.setText(this.mboundView7, vmWeatherInfoTemperatureRangeGet2);
        }
        if ((dirtyFlags2 & 131074) != 0) {
            vmWeatherInfoPhraseGet3 = vmWeatherInfoPhraseGet2;
            TextViewBindingAdapter.setText(this.mboundView8, vmWeatherInfoPhraseGet3);
        } else {
            vmWeatherInfoPhraseGet3 = vmWeatherInfoPhraseGet2;
        }
        if ((dirtyFlags2 & 139264) != 0) {
            vmWeatherInfoAudiCardDetailImg1Get2 = vmWeatherInfoAudiCardDetailImg1Get;
            ImageViewBindingAdapter.setImageDrawable(this.mboundView9, vmWeatherInfoAudiCardDetailImg1Get2);
        } else {
            vmWeatherInfoAudiCardDetailImg1Get2 = vmWeatherInfoAudiCardDetailImg1Get;
        }
        if ((dirtyFlags2 & 131073) != 0) {
            vmWeatherInfoTemperatureGet3 = vmWeatherInfoTemperatureGet2;
            TextViewBindingAdapter.setText(this.temperatureTv, vmWeatherInfoTemperatureGet3);
        } else {
            vmWeatherInfoTemperatureGet3 = vmWeatherInfoTemperatureGet2;
        }
        if ((dirtyFlags2 & 133120) != 0) {
            TextViewBindingAdapter.setText(this.unitWeather, vmWeatherInfoTemperUnitGet);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        AudiViewModel vm = this.mVm;
        if (vm != null) {
            vm.openWeatherApp(callbackArg_0);
        }
    }
}
