package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.SeekBarBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.bean.WeatherInfo;
import com.wits.ksw.launcher.model.DashboardViewModel;
import com.wits.ksw.launcher.view.ColorArcProgressBar;
import com.wits.ksw.launcher.view.ID7SpeedImageView;

public class NTG6V3DashBoardBindImpl extends NTG6V3DashBoardBind implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback526;
    private final View.OnClickListener mCallback527;
    private final View.OnClickListener mCallback528;
    private final View.OnClickListener mCallback529;
    private final View.OnClickListener mCallback530;
    private final View.OnClickListener mCallback531;
    private final View.OnClickListener mCallback532;
    private final View.OnClickListener mCallback533;
    private final View.OnClickListener mCallback534;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ID7SpeedImageView mboundView1;
    private final ConstraintLayout mboundView12;
    private final ConstraintLayout mboundView18;
    private final ConstraintLayout mboundView20;
    private final TextView mboundView31;
    private final TextView mboundView32;
    private final TextView mboundView33;
    private final TextView mboundView34;
    private final TextView mboundView35;
    private final TextView mboundView36;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.speed_tv_min, 39);
        sparseIntArray.put(R.id.zspeedUnitTextView, 40);
        sparseIntArray.put(R.id.textClock1, 41);
        sparseIntArray.put(R.id.textClock2, 42);
        sparseIntArray.put(R.id.textClock3, 43);
        sparseIntArray.put(R.id.alsRadioGroup, 44);
    }

    public NTG6V3DashBoardBindImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 45, sIncludes, sViewsWithIds));
    }

    private NTG6V3DashBoardBindImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 24, (ConstraintLayout) bindings[30], (LinearLayout) bindings[44], (ID7SpeedImageView) bindings[28], (ImageView) bindings[13], (TextView) bindings[26], (ImageView) bindings[14], (ImageView) bindings[15], (ImageView) bindings[16], (ImageView) bindings[17], (ConstraintLayout) bindings[0], (TextView) bindings[22], (TextView) bindings[21], (ID7SpeedImageView) bindings[23], (ImageView) bindings[24], (ID7SpeedImageView) bindings[29], (ID7SpeedImageView) bindings[2], (ID7SpeedImageView) bindings[6], (SeekBar) bindings[25], (TextView) bindings[9], (ColorArcProgressBar) bindings[5], (TextView) bindings[4], (TextView) bindings[39], (TextView) bindings[10], (ID7SpeedImageView) bindings[3], (ID7SpeedImageView) bindings[7], (TextClock) bindings[41], (TextClock) bindings[42], (TextClock) bindings[43], (TextView) bindings[37], (TextClock) bindings[38], (TextView) bindings[27], (ColorArcProgressBar) bindings[8], (TextView) bindings[19], (TextView) bindings[11], (TextView) bindings[40]);
        this.mDirtyFlags = -1;
        this.mDirtyFlags_1 = -1;
        this.alsMenu.setTag(null);
        this.batteryImageView.setTag(null);
        this.carImageView.setTag(null);
        this.currentTimeTextView.setTag(null);
        this.dorrLeftFlImageView.setTag(null);
        this.dorrLeftFrImageView.setTag(null);
        this.dorrLeftRlImageView.setTag(null);
        this.imageView19.setTag(null);
        this.linearLayout2.setTag(null);
        ID7SpeedImageView iD7SpeedImageView = (ID7SpeedImageView) bindings[1];
        this.mboundView1 = iD7SpeedImageView;
        iD7SpeedImageView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[12];
        this.mboundView12 = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) bindings[18];
        this.mboundView18 = constraintLayout2;
        constraintLayout2.setTag(null);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) bindings[20];
        this.mboundView20 = constraintLayout3;
        constraintLayout3.setTag(null);
        TextView textView = (TextView) bindings[31];
        this.mboundView31 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[32];
        this.mboundView32 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[33];
        this.mboundView33 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[34];
        this.mboundView34 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[35];
        this.mboundView35 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) bindings[36];
        this.mboundView36 = textView6;
        textView6.setTag(null);
        this.musicArtistTv.setTag(null);
        this.musicNameTv.setTag(null);
        this.ntg6v3MusicBkPic.setTag(null);
        this.ntg6v3MusicPic.setTag(null);
        this.oilImageView.setTag(null);
        this.outerRingImageView.setTag(null);
        this.outerRingTachometer.setTag(null);
        this.seekBar.setTag(null);
        this.speedPointerTextView.setTag(null);
        this.speedProgressBar.setTag(null);
        this.speedTvMax.setTag(null);
        this.speedUnitTextView.setTag(null);
        this.speedometerImageView.setTag(null);
        this.tachometerImageView.setTag(null);
        this.textView18.setTag(null);
        this.time.setTag(null);
        this.totalTimeTextView.setTag(null);
        this.turnSpeedProgressBar.setTag(null);
        this.weatherTv.setTag(null);
        this.zspeedPointerTextView.setTag(null);
        setRootTag(root);
        this.mCallback532 = new OnClickListener(this, 7);
        this.mCallback528 = new OnClickListener(this, 3);
        this.mCallback533 = new OnClickListener(this, 8);
        this.mCallback529 = new OnClickListener(this, 4);
        this.mCallback530 = new OnClickListener(this, 5);
        this.mCallback526 = new OnClickListener(this, 1);
        this.mCallback531 = new OnClickListener(this, 6);
        this.mCallback527 = new OnClickListener(this, 2);
        this.mCallback534 = new OnClickListener(this, 9);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 33554432;
            this.mDirtyFlags_1 = 0;
        }
        requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0) {
                if (this.mDirtyFlags_1 == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (36 != variableId) {
            return false;
        }
        setViewModel((DashboardViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.NTG6V3DashBoardBind
    public void setViewModel(DashboardViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16777216;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelWeatherInfoImage((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelMediaInfoMusicAtist((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelMediaInfoMaxProgress((ObservableInt) object, fieldId);
            case 3:
                return onChangeViewModelCarInfoCarImage((ObservableBoolean) object, fieldId);
            case 4:
                return onChangeViewModelCarInfoNtg6v3SevenMode((ObservableInt) object, fieldId);
            case 5:
                return onChangeViewModelCarInfoFrDoorState((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelWeatherInfoTemperature((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelCarInfoRrDoorState((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelCarInfoTempStr((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelCarInfoSeatBeltpValue((ObservableField) object, fieldId);
            case 10:
                return onChangeViewModelMediaInfoCurrentTime((ObservableField) object, fieldId);
            case 11:
                return onChangeViewModelNtg6v3showSevenMenu((ObservableBoolean) object, fieldId);
            case 12:
                return onChangeViewModelNtg6v3MiddleViewModel((ObservableInt) object, fieldId);
            case 13:
                return onChangeViewModelMediaInfoPic((ObservableField) object, fieldId);
            case 14:
                return onChangeViewModelCarInfoTurnSpeed((ObservableInt) object, fieldId);
            case 15:
                return onChangeViewModelMediaInfoProgress((ObservableInt) object, fieldId);
            case 16:
                return onChangeViewModelCarInfoUnitEnImg((ObservableField) object, fieldId);
            case 17:
                return onChangeViewModelMediaInfoTotalTime((ObservableField) object, fieldId);
            case 18:
                return onChangeViewModelMediaInfoMusicName((ObservableField) object, fieldId);
            case 19:
                return onChangeViewModelCarInfoRlDoorState((ObservableField) object, fieldId);
            case 20:
                return onChangeViewModelCarInfoFlDoorState((ObservableField) object, fieldId);
            case 21:
                return onChangeViewModelWeatherInfoTemperUnit((ObservableField) object, fieldId);
            case 22:
                return onChangeViewModelCarInfoSpeed((ObservableInt) object, fieldId);
            case 23:
                return onChangeViewModelCarInfoBrakeValue((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelWeatherInfoImage(ObservableField<Drawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoMusicAtist(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoMaxProgress(ObservableInt ViewModelMediaInfoMaxProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoCarImage(ObservableBoolean ViewModelCarInfoCarImage, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoNtg6v3SevenMode(ObservableInt ViewModelCarInfoNtg6v3SevenMode, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoFrDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoTemperature(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoRrDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoTempStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSeatBeltpValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoCurrentTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeViewModelNtg6v3showSevenMenu(ObservableBoolean ViewModelNtg6v3showSevenMenu, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeViewModelNtg6v3MiddleViewModel(ObservableInt ViewModelNtg6v3MiddleViewModel, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoPic(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoTurnSpeed(ObservableInt ViewModelCarInfoTurnSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoProgress(ObservableInt ViewModelMediaInfoProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoUnitEnImg(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoTotalTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoMusicName(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoRlDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoFlDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoTemperUnit(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSpeed(ObservableInt ViewModelCarInfoSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoBrakeValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r4v19 'viewModelMediaInfoTotalTimeGet'  java.lang.String: [D('viewModelCarInfoTurnSpeedGet' int), D('stringValueOfViewModelCarInfoTurnSpeed' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r4v21 'viewModelCarInfoTempStrGet'  java.lang.String: [D('viewModelCarInfoTempStrGet' java.lang.String), D('viewModelMediaInfoTotalTimeGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r4v23 'viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn'  java.lang.String: [D('viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn' java.lang.String), D('viewModelCarInfoTempStrGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r4v26 java.lang.String: [D('viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn' java.lang.String), D('viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r4v29 'viewModelMediaInfoProgressGet'  int: [D('viewModelCarInfoSpeedGet' int), D('stringValueOfViewModelCarInfoSpeed' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r4v31 'viewModelMediaInfoMaxProgressGet'  int: [D('viewModelMediaInfoMaxProgressGet' int), D('viewModelMediaInfoProgressGet' int)] */
    /* JADX INFO: Multiple debug info for r4v33 'viewModelCarInfoBrakeValueViewVISIBLEViewGONE'  int: [D('viewModelMediaInfoMaxProgressGet' int), D('viewModelCarInfoBrakeValueViewVISIBLEViewGONE' int)] */
    /* JADX INFO: Multiple debug info for r4v35 int: [D('viewModelMediaInfoPicGet' android.graphics.drawable.BitmapDrawable), D('viewModelCarInfoBrakeValueViewVISIBLEViewGONE' int)] */
    /* JADX INFO: Multiple debug info for r4v38 android.graphics.drawable.BitmapDrawable: [D('viewModelMediaInfoPicGet' android.graphics.drawable.BitmapDrawable), D('viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE' int)] */
    /* JADX INFO: Multiple debug info for r4v40 java.lang.String: [D('viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE' int), D('viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v59 'viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE'  int: [D('viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE' int)] */
    /* JADX INFO: Multiple debug info for r0v61 'viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE'  int: [D('viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE' int)] */
    /* JADX INFO: Multiple debug info for r0v63 'viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE'  int: [D('viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE' int)] */
    /* JADX INFO: Multiple debug info for r0v65 int: [D('viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN' android.graphics.drawable.Drawable)] */
    /* JADX INFO: Multiple debug info for r14v3 com.wits.ksw.launcher.bean.CarInfo: [D('viewModelCarInfo' com.wits.ksw.launcher.bean.CarInfo), D('viewModelNtg6v3MiddleViewModelInt0' boolean)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        long dirtyFlags_1;
        ObservableField<Boolean> viewModelCarInfoBrakeValue;
        Drawable viewModelWeatherInfoImageGet;
        String viewModelWeatherInfoTemperUnitGet;
        int viewModelMediaInfoMaxProgressGet;
        Drawable viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN;
        int viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE;
        String viewModelMediaInfoCurrentTimeGet;
        int viewModelMediaInfoMaxProgressGet2;
        String viewModelMediaInfoTotalTimeGet;
        BitmapDrawable viewModelMediaInfoPicGet;
        int viewModelMediaInfoProgressGet;
        String stringValueOfViewModelCarInfoTurnSpeed;
        String viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax;
        String viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn;
        String viewModelCarInfoTempStrGet;
        int viewModelCarInfoBrakeValueViewVISIBLEViewGONE;
        int viewModelCarInfoTurnSpeedGet;
        int viewModelCarInfoSpeedGet;
        int viewModelMediaInfoMaxProgressGet3;
        int viewModelMediaInfoProgressGet2;
        String viewModelMediaInfoTotalTimeGet2;
        Drawable viewModelWeatherInfoImageGet2;
        String viewModelWeatherInfoTemperatureViewModelWeatherInfoTemperUnit;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE;
        BitmapDrawable viewModelMediaInfoPicGet2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN;
        int viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE;
        int viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
        Drawable viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN;
        Drawable viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN;
        int viewModelCarInfoNtg6v3SevenModeGet;
        Drawable viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN;
        int viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
        int viewModelNtg6v3MiddleViewModelGet;
        int viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE;
        int viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE;
        int viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2;
        int viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2;
        String viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName;
        String viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2;
        String viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName3;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE3;
        int viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2;
        int viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE3;
        String viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName4;
        BitmapDrawable viewModelMediaInfoPicGet3;
        int viewModelCarInfoBrakeValueViewVISIBLEViewGONE2;
        int viewModelCarInfoBrakeValueViewVISIBLEViewGONE3;
        int viewModelMediaInfoProgressGet3;
        int viewModelCarInfoSpeedGet2;
        String viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax2;
        String viewModelCarInfoTempStrGet2;
        String viewModelMediaInfoTotalTimeGet3;
        String stringValueOfViewModelCarInfoTurnSpeed2;
        ObservableInt viewModelNtg6v3MiddleViewModel;
        int viewModelNtg6v3MiddleViewModelGet2;
        ObservableBoolean viewModelNtg6v3showSevenMenu;
        int i;
        ObservableField<Boolean> viewModelCarInfoBrakeValue2;
        ObservableInt viewModelCarInfoSpeed;
        ObservableField<Boolean> viewModelCarInfoFlDoorState;
        ObservableField<Boolean> viewModelCarInfoRlDoorState;
        ObservableField<Boolean> viewModelCarInfoUnitEnImg;
        ObservableInt viewModelCarInfoTurnSpeed;
        ObservableField<Boolean> viewModelCarInfoSeatBeltpValue;
        ObservableField<String> viewModelCarInfoTempStr;
        ObservableField<Boolean> viewModelCarInfoRrDoorState;
        ObservableField<Boolean> viewModelCarInfoFrDoorState;
        ObservableInt viewModelCarInfoNtg6v3SevenMode;
        int viewModelCarInfoNtg6v3SevenModeGet2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN3;
        Drawable viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN3;
        Drawable viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN4;
        Drawable viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN3;
        Drawable viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN4;
        ObservableBoolean viewModelCarInfoCarImage;
        long dirtyFlags_12;
        ObservableField<String> viewModelMediaInfoMusicName;
        ObservableField<String> viewModelMediaInfoTotalTime;
        ObservableInt viewModelMediaInfoProgress;
        ObservableField<BitmapDrawable> viewModelMediaInfoPic;
        ObservableField<String> viewModelMediaInfoCurrentTime;
        ObservableField<String> viewModelWeatherInfoTemperUnit;
        ObservableField<String> viewModelWeatherInfoTemperature;
        String viewModelWeatherInfoTemperatureGet;
        String viewModelWeatherInfoTemperUnitGet2;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
            dirtyFlags_1 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0;
        }
        ObservableField<Drawable> viewModelWeatherInfoImage = null;
        WeatherInfo viewModelWeatherInfo = null;
        ObservableField<String> viewModelMediaInfoMusicAtist = null;
        ObservableInt viewModelMediaInfoMaxProgress = null;
        int viewModelMediaInfoProgressGet4 = 0;
        Drawable viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN3 = null;
        BitmapDrawable viewModelMediaInfoPicGet4 = null;
        Boolean viewModelCarInfoRlDoorStateGet = null;
        int viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE3 = 0;
        String viewModelMediaInfoTotalTimeGet4 = null;
        String stringValueOfViewModelCarInfoSpeed = null;
        int viewModelMediaInfoMaxProgressGet4 = 0;
        int viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        boolean viewModelMediaInfoMusicNameJavaLangObjectNull = false;
        Drawable viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN2 = null;
        int viewModelCarInfoNtg6v3SevenModeGet3 = 0;
        boolean viewModelCarInfoCarImageGet = false;
        Boolean viewModelCarInfoFrDoorStateGet = null;
        Drawable viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2 = null;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3 = 0;
        String viewModelMediaInfoCurrentTimeGet2 = null;
        int viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE2 = 0;
        int viewModelCarInfoSpeedGet3 = 0;
        int viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3 = 0;
        String viewModelMediaInfoMusicNameGet = null;
        int viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE2 = 0;
        boolean viewModelMediaInfoMusicAtistJavaLangObjectNull = false;
        Boolean viewModelCarInfoSeatBeltpValueGet = null;
        Boolean viewModelCarInfoRrDoorStateGet = null;
        String viewModelMediaInfoMusicAtistGet = null;
        int viewModelCarInfoTurnSpeedGet2 = 0;
        Boolean viewModelCarInfoFlDoorStateGet = null;
        Drawable viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN4 = null;
        String viewModelCarInfoTempStrGet3 = null;
        Boolean viewModelCarInfoBrakeValueGet = null;
        Boolean viewModelCarInfoUnitEnImgGet = null;
        boolean viewModelNtg6v3showSevenMenuGet = false;
        String viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn2 = null;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE3 = 0;
        String viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax3 = null;
        String stringValueOfViewModelCarInfoTurnSpeed3 = null;
        Drawable viewModelWeatherInfoImageGet3 = null;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE4 = 0;
        Drawable viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN5 = null;
        DashboardViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 35651649) != 0) {
            viewModelWeatherInfo = DashboardViewModel.weatherInfo;
            if ((dirtyFlags & 33554433) != 0) {
                if (viewModelWeatherInfo != null) {
                    viewModelWeatherInfoImage = viewModelWeatherInfo.image;
                }
                updateRegistration(0, viewModelWeatherInfoImage);
                if (viewModelWeatherInfoImage != null) {
                    viewModelWeatherInfoImageGet3 = viewModelWeatherInfoImage.get();
                }
            }
            if ((dirtyFlags & 35651648) != 0) {
                if (viewModelWeatherInfo != null) {
                    ObservableField<String> viewModelWeatherInfoTemperature2 = viewModelWeatherInfo.temperature;
                    viewModelCarInfoBrakeValue = null;
                    viewModelWeatherInfoTemperUnit = viewModelWeatherInfo.temperUnit;
                    viewModelWeatherInfoTemperature = viewModelWeatherInfoTemperature2;
                } else {
                    viewModelCarInfoBrakeValue = null;
                    viewModelWeatherInfoTemperature = null;
                    viewModelWeatherInfoTemperUnit = null;
                }
                updateRegistration(6, viewModelWeatherInfoTemperature);
                updateRegistration(21, viewModelWeatherInfoTemperUnit);
                if (viewModelWeatherInfoTemperature != null) {
                    viewModelWeatherInfoTemperatureGet = viewModelWeatherInfoTemperature.get();
                } else {
                    viewModelWeatherInfoTemperatureGet = null;
                }
                if (viewModelWeatherInfoTemperUnit != null) {
                    viewModelWeatherInfoTemperUnitGet2 = viewModelWeatherInfoTemperUnit.get();
                } else {
                    viewModelWeatherInfoTemperUnitGet2 = null;
                }
                viewModelWeatherInfoTemperUnitGet = viewModelWeatherInfoTemperatureGet + viewModelWeatherInfoTemperUnitGet2;
                viewModelWeatherInfoImageGet = viewModelWeatherInfoImageGet3;
                viewModelWeatherInfoImage = viewModelWeatherInfoImage;
            } else {
                viewModelCarInfoBrakeValue = null;
                viewModelWeatherInfoTemperUnitGet = null;
                viewModelWeatherInfoImageGet = viewModelWeatherInfoImageGet3;
            }
        } else {
            viewModelCarInfoBrakeValue = null;
            viewModelWeatherInfoTemperUnitGet = null;
            viewModelWeatherInfoImageGet = null;
        }
        if ((dirtyFlags & 33989638) != 0) {
            MediaInfo viewModelMediaInfo = DashboardViewModel.mediaInfo;
            if ((dirtyFlags & 33554434) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoMusicAtist = viewModelMediaInfo.musicAtist;
                }
                updateRegistration(1, viewModelMediaInfoMusicAtist);
                if (viewModelMediaInfoMusicAtist != null) {
                    viewModelMediaInfoMusicAtistGet = viewModelMediaInfoMusicAtist.get();
                }
                viewModelMediaInfoMusicAtistJavaLangObjectNull = viewModelMediaInfoMusicAtistGet == null;
                if ((dirtyFlags & 33554434) != 0) {
                    dirtyFlags_1 = viewModelMediaInfoMusicAtistJavaLangObjectNull ? dirtyFlags_1 | 2 : dirtyFlags_1 | 1;
                }
            }
            if ((dirtyFlags & 33554436) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoMaxProgress = viewModelMediaInfo.maxProgress;
                }
                updateRegistration(2, viewModelMediaInfoMaxProgress);
                if (viewModelMediaInfoMaxProgress != null) {
                    viewModelMediaInfoMaxProgressGet4 = viewModelMediaInfoMaxProgress.get();
                }
            }
            if ((dirtyFlags & 33555456) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoCurrentTime = viewModelMediaInfo.currentTime;
                } else {
                    viewModelMediaInfoCurrentTime = null;
                }
                dirtyFlags_12 = dirtyFlags_1;
                updateRegistration(10, viewModelMediaInfoCurrentTime);
                if (viewModelMediaInfoCurrentTime != null) {
                    viewModelMediaInfoCurrentTimeGet2 = viewModelMediaInfoCurrentTime.get();
                }
            } else {
                dirtyFlags_12 = dirtyFlags_1;
            }
            if ((dirtyFlags & 33562624) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoPic = viewModelMediaInfo.pic;
                } else {
                    viewModelMediaInfoPic = null;
                }
                updateRegistration(13, viewModelMediaInfoPic);
                if (viewModelMediaInfoPic != null) {
                    viewModelMediaInfoPicGet4 = viewModelMediaInfoPic.get();
                }
                boolean viewModelMediaInfoPicJavaLangObjectNull = viewModelMediaInfoPicGet4 == null;
                if ((dirtyFlags & 33562624) != 0) {
                    if (viewModelMediaInfoPicJavaLangObjectNull) {
                        dirtyFlags |= 562949953421312L;
                    } else {
                        dirtyFlags |= 281474976710656L;
                    }
                }
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3 = viewModelMediaInfoPicJavaLangObjectNull ? 8 : 0;
            }
            if ((33587200 & dirtyFlags) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoProgress = viewModelMediaInfo.progress;
                } else {
                    viewModelMediaInfoProgress = null;
                }
                updateRegistration(15, viewModelMediaInfoProgress);
                if (viewModelMediaInfoProgress != null) {
                    viewModelMediaInfoProgressGet4 = viewModelMediaInfoProgress.get();
                }
            }
            if ((33685504 & dirtyFlags) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoTotalTime = viewModelMediaInfo.totalTime;
                } else {
                    viewModelMediaInfoTotalTime = null;
                }
                updateRegistration(17, viewModelMediaInfoTotalTime);
                if (viewModelMediaInfoTotalTime != null) {
                    viewModelMediaInfoTotalTimeGet4 = viewModelMediaInfoTotalTime.get();
                }
            }
            if ((dirtyFlags & 33816576) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoMusicName = viewModelMediaInfo.musicName;
                } else {
                    viewModelMediaInfoMusicName = null;
                }
                updateRegistration(18, viewModelMediaInfoMusicName);
                if (viewModelMediaInfoMusicName != null) {
                    viewModelMediaInfoMusicNameGet = viewModelMediaInfoMusicName.get();
                }
                viewModelMediaInfoMusicNameJavaLangObjectNull = viewModelMediaInfoMusicNameGet == null;
                if ((dirtyFlags & 33816576) == 0) {
                    viewModelMediaInfoProgressGet = viewModelMediaInfoProgressGet4;
                    viewModelMediaInfoPicGet = viewModelMediaInfoPicGet4;
                    dirtyFlags_1 = dirtyFlags_12;
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN = null;
                    viewModelMediaInfoTotalTimeGet = viewModelMediaInfoTotalTimeGet4;
                    viewModelMediaInfoMaxProgressGet2 = viewModelMediaInfoMaxProgressGet4;
                    viewModelMediaInfoMaxProgressGet = 0;
                    viewModelMediaInfoCurrentTimeGet = viewModelMediaInfoCurrentTimeGet2;
                    viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3;
                } else if (viewModelMediaInfoMusicNameJavaLangObjectNull) {
                    dirtyFlags |= 34359738368L;
                    viewModelMediaInfoProgressGet = viewModelMediaInfoProgressGet4;
                    viewModelMediaInfoPicGet = viewModelMediaInfoPicGet4;
                    dirtyFlags_1 = dirtyFlags_12;
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN = null;
                    viewModelMediaInfoTotalTimeGet = viewModelMediaInfoTotalTimeGet4;
                    viewModelMediaInfoMaxProgressGet2 = viewModelMediaInfoMaxProgressGet4;
                    viewModelMediaInfoMaxProgressGet = 0;
                    viewModelMediaInfoCurrentTimeGet = viewModelMediaInfoCurrentTimeGet2;
                    viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3;
                } else {
                    dirtyFlags |= 17179869184L;
                    viewModelMediaInfoProgressGet = viewModelMediaInfoProgressGet4;
                    viewModelMediaInfoPicGet = viewModelMediaInfoPicGet4;
                    dirtyFlags_1 = dirtyFlags_12;
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN = null;
                    viewModelMediaInfoTotalTimeGet = viewModelMediaInfoTotalTimeGet4;
                    viewModelMediaInfoMaxProgressGet2 = viewModelMediaInfoMaxProgressGet4;
                    viewModelMediaInfoMaxProgressGet = 0;
                    viewModelMediaInfoCurrentTimeGet = viewModelMediaInfoCurrentTimeGet2;
                    viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3;
                }
            } else {
                viewModelMediaInfoProgressGet = viewModelMediaInfoProgressGet4;
                viewModelMediaInfoPicGet = viewModelMediaInfoPicGet4;
                dirtyFlags_1 = dirtyFlags_12;
                viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN = null;
                viewModelMediaInfoTotalTimeGet = viewModelMediaInfoTotalTimeGet4;
                viewModelMediaInfoMaxProgressGet2 = viewModelMediaInfoMaxProgressGet4;
                viewModelMediaInfoMaxProgressGet = 0;
                viewModelMediaInfoCurrentTimeGet = viewModelMediaInfoCurrentTimeGet2;
                viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3;
            }
        } else {
            viewModelMediaInfoProgressGet = 0;
            viewModelMediaInfoPicGet = null;
            viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN = null;
            viewModelMediaInfoTotalTimeGet = null;
            viewModelMediaInfoMaxProgressGet2 = 0;
            viewModelMediaInfoMaxProgressGet = 0;
            viewModelMediaInfoCurrentTimeGet = null;
            viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = 0;
        }
        if ((dirtyFlags & 47793080) != 0) {
            CarInfo viewModelCarInfo = DashboardViewModel.carInfo;
            if ((dirtyFlags & 33554440) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoCarImage = viewModelCarInfo.carImage;
                } else {
                    viewModelCarInfoCarImage = null;
                }
                viewModelWeatherInfoTemperatureViewModelWeatherInfoTemperUnit = viewModelWeatherInfoTemperUnitGet;
                updateRegistration(3, viewModelCarInfoCarImage);
                if (viewModelCarInfoCarImage != null) {
                    viewModelCarInfoCarImageGet = viewModelCarInfoCarImage.get();
                }
                if ((dirtyFlags & 33554440) != 0) {
                    if (viewModelCarInfoCarImageGet) {
                        dirtyFlags |= 35184372088832L;
                    } else {
                        dirtyFlags |= 17592186044416L;
                    }
                }
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3 = viewModelCarInfoCarImageGet ? 0 : 4;
            } else {
                viewModelWeatherInfoTemperatureViewModelWeatherInfoTemperUnit = viewModelWeatherInfoTemperUnitGet;
            }
            if ((dirtyFlags & 33554448) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoNtg6v3SevenMode = viewModelCarInfo.ntg6v3SevenMode;
                } else {
                    viewModelCarInfoNtg6v3SevenMode = null;
                }
                updateRegistration(4, viewModelCarInfoNtg6v3SevenMode);
                if (viewModelCarInfoNtg6v3SevenMode != null) {
                    viewModelCarInfoNtg6v3SevenModeGet2 = viewModelCarInfoNtg6v3SevenMode.get();
                } else {
                    viewModelCarInfoNtg6v3SevenModeGet2 = 0;
                }
                boolean viewModelCarInfoNtg6v3SevenModeInt2 = viewModelCarInfoNtg6v3SevenModeGet2 == 2;
                viewModelWeatherInfoImageGet2 = viewModelWeatherInfoImageGet;
                boolean viewModelCarInfoNtg6v3SevenModeInt5 = viewModelCarInfoNtg6v3SevenModeGet2 == 5;
                boolean viewModelCarInfoNtg6v3SevenModeInt0 = viewModelCarInfoNtg6v3SevenModeGet2 == 0;
                viewModelMediaInfoTotalTimeGet2 = viewModelMediaInfoTotalTimeGet;
                boolean viewModelCarInfoNtg6v3SevenModeInt3 = viewModelCarInfoNtg6v3SevenModeGet2 == 3;
                viewModelMediaInfoProgressGet2 = viewModelMediaInfoProgressGet;
                boolean viewModelCarInfoNtg6v3SevenModeInt1 = viewModelCarInfoNtg6v3SevenModeGet2 == 1;
                viewModelMediaInfoMaxProgressGet3 = viewModelMediaInfoMaxProgressGet2;
                boolean viewModelCarInfoNtg6v3SevenModeInt4 = viewModelCarInfoNtg6v3SevenModeGet2 == 4;
                if ((dirtyFlags & 33554448) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt2) {
                        dirtyFlags |= 2199023255552L;
                    } else {
                        dirtyFlags |= 1099511627776L;
                    }
                }
                if ((dirtyFlags & 33554448) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt5) {
                        dirtyFlags |= 144115188075855872L;
                    } else {
                        dirtyFlags |= 72057594037927936L;
                    }
                }
                if ((dirtyFlags & 33554448) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt0) {
                        dirtyFlags |= 2147483648L;
                    } else {
                        dirtyFlags |= 1073741824;
                    }
                }
                if ((dirtyFlags & 33554448) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt3) {
                        dirtyFlags |= 134217728;
                    } else {
                        dirtyFlags |= 67108864;
                    }
                }
                if ((dirtyFlags & 33554448) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt1) {
                        dirtyFlags_1 |= 32;
                    } else {
                        dirtyFlags_1 |= 16;
                    }
                }
                if ((dirtyFlags & 33554448) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt4) {
                        dirtyFlags |= 549755813888L;
                    } else {
                        dirtyFlags |= 274877906944L;
                    }
                }
                Drawable viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt2 ? AppCompatResources.getDrawable(this.mboundView33.getContext(), R.drawable.ntg6v3_color_checkbox_sel) : AppCompatResources.getDrawable(this.mboundView33.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                if (viewModelCarInfoNtg6v3SevenModeInt5) {
                    viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2 = viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN3;
                    viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView36.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2 = viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN3;
                    viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView36.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                if (viewModelCarInfoNtg6v3SevenModeInt0) {
                    viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView31.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView31.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                if (viewModelCarInfoNtg6v3SevenModeInt3) {
                    viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN3 = AppCompatResources.getDrawable(this.mboundView34.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN3 = AppCompatResources.getDrawable(this.mboundView34.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                if (viewModelCarInfoNtg6v3SevenModeInt1) {
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN4 = viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN3;
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView32.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN4 = viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN3;
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView32.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                if (viewModelCarInfoNtg6v3SevenModeInt4) {
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN4 = AppCompatResources.getDrawable(this.mboundView35.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN4 = AppCompatResources.getDrawable(this.mboundView35.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN2 = viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN4;
                viewModelCarInfoNtg6v3SevenModeGet3 = viewModelCarInfoNtg6v3SevenModeGet2;
                viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN2 = viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN4;
                viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN4 = viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN3;
                viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN5 = viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN3;
            } else {
                viewModelWeatherInfoImageGet2 = viewModelWeatherInfoImageGet;
                viewModelMediaInfoProgressGet2 = viewModelMediaInfoProgressGet;
                viewModelMediaInfoTotalTimeGet2 = viewModelMediaInfoTotalTimeGet;
                viewModelMediaInfoMaxProgressGet3 = viewModelMediaInfoMaxProgressGet2;
                viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN2 = viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN;
            }
            if ((dirtyFlags & 33554464) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoFrDoorState = viewModelCarInfo.frDoorState;
                } else {
                    viewModelCarInfoFrDoorState = null;
                }
                updateRegistration(5, viewModelCarInfoFrDoorState);
                if (viewModelCarInfoFrDoorState != null) {
                    viewModelCarInfoFrDoorStateGet = viewModelCarInfoFrDoorState.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoFrDoorStateGet);
                if ((dirtyFlags & 33554464) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet) {
                        dirtyFlags_1 |= 8;
                    } else {
                        dirtyFlags_1 |= 4;
                    }
                }
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE4 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 33554560) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoRrDoorState = viewModelCarInfo.rrDoorState;
                } else {
                    viewModelCarInfoRrDoorState = null;
                }
                updateRegistration(7, viewModelCarInfoRrDoorState);
                if (viewModelCarInfoRrDoorState != null) {
                    viewModelCarInfoRrDoorStateGet = viewModelCarInfoRrDoorState.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoRrDoorStateGet);
                if ((dirtyFlags & 33554560) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet) {
                        dirtyFlags |= 8589934592L;
                    } else {
                        dirtyFlags |= 4294967296L;
                    }
                }
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE3 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet ? 0 : 4;
            }
            if ((33554688 & dirtyFlags) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoTempStr = viewModelCarInfo.tempStr;
                } else {
                    viewModelCarInfoTempStr = null;
                }
                i = 8;
                updateRegistration(8, viewModelCarInfoTempStr);
                if (viewModelCarInfoTempStr != null) {
                    viewModelCarInfoTempStrGet3 = viewModelCarInfoTempStr.get();
                }
            } else {
                i = 8;
            }
            if ((dirtyFlags & 33554944) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSeatBeltpValue = viewModelCarInfo.seatBeltpValue;
                } else {
                    viewModelCarInfoSeatBeltpValue = null;
                }
                updateRegistration(9, viewModelCarInfoSeatBeltpValue);
                if (viewModelCarInfoSeatBeltpValue != null) {
                    viewModelCarInfoSeatBeltpValueGet = viewModelCarInfoSeatBeltpValue.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet = ViewDataBinding.safeUnbox(viewModelCarInfoSeatBeltpValueGet);
                if ((dirtyFlags & 33554944) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet) {
                        dirtyFlags |= 140737488355328L;
                    } else {
                        dirtyFlags |= 70368744177664L;
                    }
                }
                viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet ? i : 0;
            }
            if ((dirtyFlags & 33570816) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoTurnSpeed = viewModelCarInfo.turnSpeed;
                } else {
                    viewModelCarInfoTurnSpeed = null;
                }
                updateRegistration(14, viewModelCarInfoTurnSpeed);
                if (viewModelCarInfoTurnSpeed != null) {
                    viewModelCarInfoTurnSpeedGet2 = viewModelCarInfoTurnSpeed.get();
                }
                stringValueOfViewModelCarInfoTurnSpeed3 = String.valueOf(viewModelCarInfoTurnSpeedGet2);
            }
            if ((dirtyFlags & 33619968) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoUnitEnImg = viewModelCarInfo.unitEnImg;
                } else {
                    viewModelCarInfoUnitEnImg = null;
                }
                updateRegistration(16, viewModelCarInfoUnitEnImg);
                if (viewModelCarInfoUnitEnImg != null) {
                    viewModelCarInfoUnitEnImgGet = viewModelCarInfoUnitEnImg.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoUnitEnImgGet = ViewDataBinding.safeUnbox(viewModelCarInfoUnitEnImgGet);
                if ((dirtyFlags & 33619968) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoUnitEnImgGet) {
                        dirtyFlags = dirtyFlags | 576460752303423488L | Long.MIN_VALUE;
                    } else {
                        dirtyFlags = dirtyFlags | 288230376151711744L | 4611686018427387904L;
                    }
                }
                String viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn3 = this.speedUnitTextView.getResources().getString(androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoUnitEnImgGet ? R.string.speed_unit_en : R.string.speed_unit_cn);
                viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax3 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoUnitEnImgGet ? this.speedTvMax.getResources().getString(R.string.speed_unit_en_max) : this.speedTvMax.getResources().getString(R.string.speed_unit_cn_max);
                viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn2 = viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn3;
            }
            if ((dirtyFlags & 34078720) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoRlDoorState = viewModelCarInfo.rlDoorState;
                } else {
                    viewModelCarInfoRlDoorState = null;
                }
                updateRegistration(19, viewModelCarInfoRlDoorState);
                if (viewModelCarInfoRlDoorState != null) {
                    viewModelCarInfoRlDoorStateGet = viewModelCarInfoRlDoorState.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoRlDoorStateGet);
                if ((dirtyFlags & 34078720) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet) {
                        dirtyFlags |= 137438953472L;
                    } else {
                        dirtyFlags |= 68719476736L;
                    }
                }
                viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 34603008) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoFlDoorState = viewModelCarInfo.flDoorState;
                } else {
                    viewModelCarInfoFlDoorState = null;
                }
                updateRegistration(20, viewModelCarInfoFlDoorState);
                if (viewModelCarInfoFlDoorState != null) {
                    viewModelCarInfoFlDoorStateGet = viewModelCarInfoFlDoorState.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoFlDoorStateGet);
                if ((dirtyFlags & 34603008) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet) {
                        dirtyFlags |= 2305843009213693952L;
                    } else {
                        dirtyFlags |= 1152921504606846976L;
                    }
                }
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE3 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet ? 0 : 4;
            }
            if ((37748736 & dirtyFlags) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSpeed = viewModelCarInfo.speed;
                } else {
                    viewModelCarInfoSpeed = null;
                }
                updateRegistration(22, viewModelCarInfoSpeed);
                if (viewModelCarInfoSpeed != null) {
                    viewModelCarInfoSpeedGet3 = viewModelCarInfoSpeed.get();
                }
                stringValueOfViewModelCarInfoSpeed = String.valueOf(viewModelCarInfoSpeedGet3);
            }
            if ((dirtyFlags & 41943040) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoBrakeValue2 = viewModelCarInfo.brakeValue;
                } else {
                    viewModelCarInfoBrakeValue2 = viewModelCarInfoBrakeValue;
                }
                updateRegistration(23, viewModelCarInfoBrakeValue2);
                if (viewModelCarInfoBrakeValue2 != null) {
                    viewModelCarInfoBrakeValueGet = viewModelCarInfoBrakeValue2.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet = ViewDataBinding.safeUnbox(viewModelCarInfoBrakeValueGet);
                if ((dirtyFlags & 41943040) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet) {
                        dirtyFlags |= 36028797018963968L;
                    } else {
                        dirtyFlags |= 18014398509481984L;
                    }
                }
                int viewModelCarInfoBrakeValueViewVISIBLEViewGONE4 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet ? 0 : 8;
                viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN3;
                viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN2;
                viewModelCarInfoSpeedGet = viewModelCarInfoSpeedGet3;
                viewModelCarInfoTurnSpeedGet = viewModelCarInfoTurnSpeedGet2;
                viewModelCarInfoBrakeValueViewVISIBLEViewGONE = viewModelCarInfoBrakeValueViewVISIBLEViewGONE4;
                viewModelCarInfoTempStrGet = viewModelCarInfoTempStrGet3;
                viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn = viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn2;
                viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax = viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax3;
                stringValueOfViewModelCarInfoTurnSpeed = stringValueOfViewModelCarInfoTurnSpeed3;
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE4;
                viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN5;
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE;
                viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE = viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE2;
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2 = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE3;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelMediaInfoPicGet2 = viewModelMediaInfoPicGet;
                viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN4;
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE3;
                viewModelCarInfoNtg6v3SevenModeGet = viewModelCarInfoNtg6v3SevenModeGet3;
                viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2;
            } else {
                viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN3;
                viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN2;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3;
                viewModelCarInfoSpeedGet = viewModelCarInfoSpeedGet3;
                viewModelCarInfoTurnSpeedGet = viewModelCarInfoTurnSpeedGet2;
                viewModelCarInfoBrakeValueViewVISIBLEViewGONE = 0;
                viewModelCarInfoTempStrGet = viewModelCarInfoTempStrGet3;
                viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn = viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn2;
                viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax = viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax3;
                stringValueOfViewModelCarInfoTurnSpeed = stringValueOfViewModelCarInfoTurnSpeed3;
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE4;
                viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN5;
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE = viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE2;
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2 = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE3;
                viewModelMediaInfoPicGet2 = viewModelMediaInfoPicGet;
                viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN4;
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE3;
                viewModelCarInfoNtg6v3SevenModeGet = viewModelCarInfoNtg6v3SevenModeGet3;
                viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2;
            }
        } else {
            viewModelWeatherInfoTemperatureViewModelWeatherInfoTemperUnit = viewModelWeatherInfoTemperUnitGet;
            viewModelWeatherInfoImageGet2 = viewModelWeatherInfoImageGet;
            viewModelMediaInfoProgressGet2 = viewModelMediaInfoProgressGet;
            viewModelMediaInfoTotalTimeGet2 = viewModelMediaInfoTotalTimeGet;
            viewModelMediaInfoMaxProgressGet3 = viewModelMediaInfoMaxProgressGet2;
            viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN2 = viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN;
            viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN = null;
            viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN = null;
            viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = 0;
            viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE = 0;
            viewModelCarInfoSpeedGet = 0;
            viewModelCarInfoTurnSpeedGet = 0;
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE = 0;
            viewModelCarInfoTempStrGet = null;
            viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn = null;
            viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax = null;
            stringValueOfViewModelCarInfoTurnSpeed = null;
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = 0;
            viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN = null;
            viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE;
            viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = 0;
            viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2 = 0;
            viewModelMediaInfoPicGet2 = viewModelMediaInfoPicGet;
            viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN = null;
            viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = 0;
            viewModelCarInfoNtg6v3SevenModeGet = 0;
            viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN = null;
        }
        if ((dirtyFlags & 50337792) != 0) {
            if ((dirtyFlags & 50333696) != 0) {
                if (viewModel != null) {
                    viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
                    viewModelNtg6v3showSevenMenu = viewModel.ntg6v3showSevenMenu;
                } else {
                    viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
                    viewModelNtg6v3showSevenMenu = null;
                }
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2;
                updateRegistration(11, viewModelNtg6v3showSevenMenu);
                if (viewModelNtg6v3showSevenMenu != null) {
                    viewModelNtg6v3showSevenMenuGet = viewModelNtg6v3showSevenMenu.get();
                }
                if ((dirtyFlags & 50333696) != 0) {
                    if (viewModelNtg6v3showSevenMenuGet) {
                        dirtyFlags |= 2251799813685248L;
                    } else {
                        dirtyFlags |= 1125899906842624L;
                    }
                }
                viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE2 = viewModelNtg6v3showSevenMenuGet ? 0 : 8;
            } else {
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2;
            }
            if ((dirtyFlags & 50335744) != 0) {
                if (viewModel != null) {
                    viewModelNtg6v3MiddleViewModel = viewModel.ntg6v3MiddleViewModel;
                } else {
                    viewModelNtg6v3MiddleViewModel = null;
                }
                updateRegistration(12, viewModelNtg6v3MiddleViewModel);
                if (viewModelNtg6v3MiddleViewModel != null) {
                    viewModelNtg6v3MiddleViewModelGet2 = viewModelNtg6v3MiddleViewModel.get();
                } else {
                    viewModelNtg6v3MiddleViewModelGet2 = 0;
                }
                boolean viewModelNtg6v3MiddleViewModelInt0 = viewModelNtg6v3MiddleViewModelGet2 == 0;
                boolean viewModelNtg6v3MiddleViewModelInt2 = viewModelNtg6v3MiddleViewModelGet2 == 2;
                boolean viewModelNtg6v3MiddleViewModelInt1 = true;
                if (viewModelNtg6v3MiddleViewModelGet2 != 1) {
                    viewModelNtg6v3MiddleViewModelInt1 = false;
                }
                if ((dirtyFlags & 50335744) != 0) {
                    if (viewModelNtg6v3MiddleViewModelInt0) {
                        dirtyFlags |= 8796093022208L;
                    } else {
                        dirtyFlags |= 4398046511104L;
                    }
                }
                if ((dirtyFlags & 50335744) != 0) {
                    if (viewModelNtg6v3MiddleViewModelInt2) {
                        dirtyFlags |= 9007199254740992L;
                    } else {
                        dirtyFlags |= 4503599627370496L;
                    }
                }
                if ((dirtyFlags & 50335744) != 0) {
                    if (viewModelNtg6v3MiddleViewModelInt1) {
                        dirtyFlags |= 536870912;
                    } else {
                        dirtyFlags |= 268435456;
                    }
                }
                int viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE4 = viewModelNtg6v3MiddleViewModelInt0 ? 0 : 8;
                viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE = viewModelNtg6v3MiddleViewModelInt2 ? 0 : 8;
                viewModelNtg6v3MiddleViewModelGet = viewModelNtg6v3MiddleViewModelInt1 ? 0 : 8;
                viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE = viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE4;
                viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE = viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE2;
            } else {
                viewModelNtg6v3MiddleViewModelGet = viewModelMediaInfoMaxProgressGet;
                viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE = 0;
                viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE = viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE2;
                viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE = 0;
            }
        } else {
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
            viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2;
            viewModelNtg6v3MiddleViewModelGet = viewModelMediaInfoMaxProgressGet;
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE = 0;
            viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE = 0;
            viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE = 0;
        }
        if ((dirtyFlags & 33816576) == 0) {
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE;
            viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelGet;
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName = null;
        } else if (viewModelMediaInfoMusicNameJavaLangObjectNull) {
            viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelGet;
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE;
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName = this.musicNameTv.getResources().getString(R.string.ksw_idf7_unkonw_soung);
        } else {
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE;
            viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelGet;
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName = viewModelMediaInfoMusicNameGet;
        }
        if ((dirtyFlags & 33554434) == 0) {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2 = viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName;
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName3 = null;
        } else if (viewModelMediaInfoMusicAtistJavaLangObjectNull) {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2 = viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName;
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName3 = this.musicArtistTv.getResources().getString(R.string.ksw_idf7_unknow_artis);
        } else {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2 = viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName;
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName3 = viewModelMediaInfoMusicAtistGet;
        }
        if ((dirtyFlags & 50333696) != 0) {
            this.alsMenu.setVisibility(viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 33554944) != 0) {
            this.batteryImageView.setVisibility(viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 33554448) != 0) {
            this.batteryImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.mboundView1.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView31, viewModelCarInfoNtg6v3SevenModeInt0MboundView31AndroidDrawableNtg6v3ColorCheckboxSelMboundView31AndroidDrawableNtg6v3ColorCheckboxN);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView32, viewModelCarInfoNtg6v3SevenModeInt1MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView33, viewModelCarInfoNtg6v3SevenModeInt2MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView34, viewModelCarInfoNtg6v3SevenModeInt3MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN2);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView35, viewModelCarInfoNtg6v3SevenModeInt4MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView36, viewModelCarInfoNtg6v3SevenModeInt5MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN);
            this.ntg6v3MusicBkPic.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.oilImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.outerRingImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.outerRingTachometer.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            BaseBindingModel.setNtg6v3ProgressDrawable(this.seekBar, viewModelCarInfoNtg6v3SevenModeGet);
            this.speedometerImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.tachometerImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
        }
        if ((dirtyFlags & 33554440) != 0) {
            this.carImageView.setVisibility(viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2);
        }
        if ((dirtyFlags & 33555456) != 0) {
            TextViewBindingAdapter.setText(this.currentTimeTextView, viewModelMediaInfoCurrentTimeGet);
        }
        if ((dirtyFlags & 34603008) != 0) {
            viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE;
            this.dorrLeftFlImageView.setVisibility(viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2);
        } else {
            viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE;
        }
        if ((dirtyFlags & 33554464) != 0) {
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE3 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
            this.dorrLeftFrImageView.setVisibility(viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE3);
        } else {
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE3 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
        }
        if ((dirtyFlags & 34078720) != 0) {
            viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE;
            this.dorrLeftRlImageView.setVisibility(viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE);
        } else {
            viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE;
        }
        if ((dirtyFlags & 33554560) != 0) {
            viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE;
            this.imageView19.setVisibility(viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2);
        } else {
            viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE;
        }
        if ((dirtyFlags & 33554432) != 0) {
            this.mboundView12.setOnClickListener(this.mCallback526);
            this.mboundView18.setOnClickListener(this.mCallback527);
            this.mboundView20.setOnClickListener(this.mCallback528);
            this.mboundView31.setOnClickListener(this.mCallback529);
            this.mboundView32.setOnClickListener(this.mCallback530);
            this.mboundView33.setOnClickListener(this.mCallback531);
            this.mboundView34.setOnClickListener(this.mCallback532);
            this.mboundView35.setOnClickListener(this.mCallback533);
            this.mboundView36.setOnClickListener(this.mCallback534);
            ImageViewBindingAdapter.setImageDrawable(this.ntg6v3MusicBkPic, AppCompatResources.getDrawable(this.ntg6v3MusicBkPic.getContext(), R.drawable.ntg6v3_color_music_pic_level));
            ImageViewBindingAdapter.setImageDrawable(this.outerRingImageView, AppCompatResources.getDrawable(this.outerRingImageView.getContext(), R.drawable.ntg6v3_color_speed_outer_ring_level));
            ImageViewBindingAdapter.setImageDrawable(this.outerRingTachometer, AppCompatResources.getDrawable(this.outerRingTachometer.getContext(), R.drawable.ntg6v3_color_tachometer_outer_ring_level));
            ImageViewBindingAdapter.setImageDrawable(this.speedometerImageView, AppCompatResources.getDrawable(this.speedometerImageView.getContext(), R.drawable.ntg6v3_color_speed_mp_wtach_level));
        }
        if ((dirtyFlags & 50335744) != 0) {
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE3 = viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2;
            this.mboundView12.setVisibility(viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE3);
            this.mboundView18.setVisibility(viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2);
            this.mboundView20.setVisibility(viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE);
            this.textView18.setVisibility(viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE3);
            this.time.setVisibility(viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE3);
        } else {
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE3 = viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2;
        }
        if ((dirtyFlags & 33554434) != 0) {
            TextViewBindingAdapter.setText(this.musicArtistTv, viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName3);
        }
        if ((dirtyFlags & 33816576) != 0) {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName4 = viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2;
            TextViewBindingAdapter.setText(this.musicNameTv, viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName4);
        } else {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName4 = viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2;
        }
        if ((dirtyFlags & 33562624) != 0) {
            this.ntg6v3MusicPic.setVisibility(viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE);
            viewModelMediaInfoPicGet3 = viewModelMediaInfoPicGet2;
            BaseBindingModel.setAlbumIcon(this.ntg6v3MusicPic, viewModelMediaInfoPicGet3);
        } else {
            viewModelMediaInfoPicGet3 = viewModelMediaInfoPicGet2;
        }
        if ((dirtyFlags & 41943040) != 0) {
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE2 = viewModelCarInfoBrakeValueViewVISIBLEViewGONE;
            this.oilImageView.setVisibility(viewModelCarInfoBrakeValueViewVISIBLEViewGONE2);
        } else {
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE2 = viewModelCarInfoBrakeValueViewVISIBLEViewGONE;
        }
        if ((dirtyFlags & 33554436) != 0) {
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE3 = viewModelMediaInfoMaxProgressGet3;
            this.seekBar.setMax(viewModelCarInfoBrakeValueViewVISIBLEViewGONE3);
        } else {
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE3 = viewModelMediaInfoMaxProgressGet3;
        }
        if ((dirtyFlags & 33587200) != 0) {
            viewModelMediaInfoProgressGet3 = viewModelMediaInfoProgressGet2;
            SeekBarBindingAdapter.setProgress(this.seekBar, viewModelMediaInfoProgressGet3);
        } else {
            viewModelMediaInfoProgressGet3 = viewModelMediaInfoProgressGet2;
        }
        if ((dirtyFlags & 37748736) != 0) {
            TextViewBindingAdapter.setText(this.speedPointerTextView, stringValueOfViewModelCarInfoSpeed);
            viewModelCarInfoSpeedGet2 = viewModelCarInfoSpeedGet;
            BaseBindingModel.setNtg6v3ArcProgressBarValue(this.speedProgressBar, viewModelCarInfoSpeedGet2);
        } else {
            viewModelCarInfoSpeedGet2 = viewModelCarInfoSpeedGet;
        }
        if ((dirtyFlags & 33619968) != 0) {
            TextViewBindingAdapter.setText(this.speedTvMax, viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax);
            viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax2 = viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn;
            TextViewBindingAdapter.setText(this.speedUnitTextView, viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax2);
        } else {
            viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax2 = viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn;
        }
        if ((dirtyFlags & 33554688) != 0) {
            viewModelCarInfoTempStrGet2 = viewModelCarInfoTempStrGet;
            TextViewBindingAdapter.setText(this.textView18, viewModelCarInfoTempStrGet2);
        } else {
            viewModelCarInfoTempStrGet2 = viewModelCarInfoTempStrGet;
        }
        if ((dirtyFlags & 33685504) != 0) {
            viewModelMediaInfoTotalTimeGet3 = viewModelMediaInfoTotalTimeGet2;
            TextViewBindingAdapter.setText(this.totalTimeTextView, viewModelMediaInfoTotalTimeGet3);
        } else {
            viewModelMediaInfoTotalTimeGet3 = viewModelMediaInfoTotalTimeGet2;
        }
        if ((dirtyFlags & 33570816) != 0) {
            BaseBindingModel.setNtg6v3ArcProgressBarValue(this.turnSpeedProgressBar, viewModelCarInfoTurnSpeedGet);
            stringValueOfViewModelCarInfoTurnSpeed2 = stringValueOfViewModelCarInfoTurnSpeed;
            TextViewBindingAdapter.setText(this.zspeedPointerTextView, stringValueOfViewModelCarInfoTurnSpeed2);
        } else {
            stringValueOfViewModelCarInfoTurnSpeed2 = stringValueOfViewModelCarInfoTurnSpeed;
        }
        if ((dirtyFlags & 33554433) != 0) {
            TextViewBindingAdapter.setDrawableLeft(this.weatherTv, viewModelWeatherInfoImageGet2);
        }
        if ((dirtyFlags & 35651648) != 0) {
            TextViewBindingAdapter.setText(this.weatherTv, viewModelWeatherInfoTemperatureViewModelWeatherInfoTemperUnit);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean viewModelJavaLangObjectNull = true;
        boolean viewModelJavaLangObjectNull2 = false;
        switch (sourceId) {
            case 1:
                DashboardViewModel viewModel = this.mViewModel;
                if (viewModel != null) {
                    viewModelJavaLangObjectNull2 = true;
                }
                if (viewModelJavaLangObjectNull2) {
                    viewModel.onNtg6v3MiddleViewClick(1);
                    return;
                }
                return;
            case 2:
                DashboardViewModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.onNtg6v3MiddleViewClick(2);
                    return;
                }
                return;
            case 3:
                DashboardViewModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.onNtg6v3MiddleViewClick(0);
                    return;
                }
                return;
            case 4:
                DashboardViewModel viewModel4 = this.mViewModel;
                if (viewModel4 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel4.onNtg6v3SevenModeClick(0);
                    return;
                }
                return;
            case 5:
                DashboardViewModel viewModel5 = this.mViewModel;
                if (viewModel5 != null) {
                    viewModelJavaLangObjectNull2 = true;
                }
                if (viewModelJavaLangObjectNull2) {
                    viewModel5.onNtg6v3SevenModeClick(1);
                    return;
                }
                return;
            case 6:
                DashboardViewModel viewModel6 = this.mViewModel;
                if (viewModel6 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel6.onNtg6v3SevenModeClick(2);
                    return;
                }
                return;
            case 7:
                DashboardViewModel viewModel7 = this.mViewModel;
                if (viewModel7 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel7.onNtg6v3SevenModeClick(3);
                    return;
                }
                return;
            case 8:
                DashboardViewModel viewModel8 = this.mViewModel;
                if (viewModel8 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel8.onNtg6v3SevenModeClick(4);
                    return;
                }
                return;
            case 9:
                DashboardViewModel viewModel9 = this.mViewModel;
                if (viewModel9 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel9.onNtg6v3SevenModeClick(5);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
