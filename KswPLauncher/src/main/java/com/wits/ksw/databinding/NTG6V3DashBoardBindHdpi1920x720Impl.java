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

public class NTG6V3DashBoardBindHdpi1920x720Impl extends NTG6V3DashBoardBind implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback455;
    private final View.OnClickListener mCallback456;
    private final View.OnClickListener mCallback457;
    private final View.OnClickListener mCallback458;
    private final View.OnClickListener mCallback459;
    private final View.OnClickListener mCallback460;
    private final View.OnClickListener mCallback461;
    private final View.OnClickListener mCallback462;
    private final View.OnClickListener mCallback463;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ID7SpeedImageView mboundView1;
    private final ConstraintLayout mboundView12;
    private final ConstraintLayout mboundView18;
    private final ConstraintLayout mboundView20;
    private final ImageView mboundView30;
    private final TextView mboundView32;
    private final TextView mboundView33;
    private final TextView mboundView34;
    private final TextView mboundView35;
    private final TextView mboundView36;
    private final TextView mboundView37;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.speed_tv_min, 40);
        sparseIntArray.put(R.id.zspeedUnitTextView, 41);
        sparseIntArray.put(R.id.textClock1, 42);
        sparseIntArray.put(R.id.textClock2, 43);
        sparseIntArray.put(R.id.textClock3, 44);
        sparseIntArray.put(R.id.alsRadioGroup, 45);
    }

    public NTG6V3DashBoardBindHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 46, sIncludes, sViewsWithIds));
    }

    private NTG6V3DashBoardBindHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 23, (ConstraintLayout) bindings[31], (LinearLayout) bindings[45], (ID7SpeedImageView) bindings[28], (ImageView) bindings[13], (TextView) bindings[26], (ImageView) bindings[14], (ImageView) bindings[15], (ImageView) bindings[16], (ImageView) bindings[17], (ConstraintLayout) bindings[0], (TextView) bindings[22], (TextView) bindings[21], (ID7SpeedImageView) bindings[23], (ImageView) bindings[24], (ID7SpeedImageView) bindings[29], (ID7SpeedImageView) bindings[2], (ID7SpeedImageView) bindings[6], (SeekBar) bindings[25], (TextView) bindings[9], (ColorArcProgressBar) bindings[5], (TextView) bindings[4], (TextView) bindings[40], (TextView) bindings[10], (ID7SpeedImageView) bindings[3], (ID7SpeedImageView) bindings[7], (TextClock) bindings[42], (TextClock) bindings[43], (TextClock) bindings[44], (TextView) bindings[38], (TextClock) bindings[39], (TextView) bindings[27], (ColorArcProgressBar) bindings[8], (TextView) bindings[19], (TextView) bindings[11], (TextView) bindings[41]);
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
        ImageView imageView = (ImageView) bindings[30];
        this.mboundView30 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[32];
        this.mboundView32 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[33];
        this.mboundView33 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[34];
        this.mboundView34 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[35];
        this.mboundView35 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[36];
        this.mboundView36 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) bindings[37];
        this.mboundView37 = textView6;
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
        this.mCallback459 = new OnClickListener(this, 5);
        this.mCallback463 = new OnClickListener(this, 9);
        this.mCallback457 = new OnClickListener(this, 3);
        this.mCallback461 = new OnClickListener(this, 7);
        this.mCallback458 = new OnClickListener(this, 4);
        this.mCallback462 = new OnClickListener(this, 8);
        this.mCallback455 = new OnClickListener(this, 1);
        this.mCallback456 = new OnClickListener(this, 2);
        this.mCallback460 = new OnClickListener(this, 6);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16777216;
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
            this.mDirtyFlags |= 8388608;
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
                return onChangeViewModelCarInfoRrDoorState((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelCarInfoTempStr((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelCarInfoSeatBeltpValue((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelMediaInfoCurrentTime((ObservableField) object, fieldId);
            case 10:
                return onChangeViewModelNtg6v3showSevenMenu((ObservableBoolean) object, fieldId);
            case 11:
                return onChangeViewModelNtg6v3MiddleViewModel((ObservableInt) object, fieldId);
            case 12:
                return onChangeViewModelMediaInfoPic((ObservableField) object, fieldId);
            case 13:
                return onChangeViewModelCarInfoTurnSpeed((ObservableInt) object, fieldId);
            case 14:
                return onChangeViewModelMediaInfoProgress((ObservableInt) object, fieldId);
            case 15:
                return onChangeViewModelWeatherInfoNtg6v3Temperature((ObservableField) object, fieldId);
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
                return onChangeViewModelCarInfoSpeed((ObservableInt) object, fieldId);
            case 22:
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

    private boolean onChangeViewModelCarInfoRrDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoTempStr(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSeatBeltpValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoCurrentTime(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelNtg6v3showSevenMenu(ObservableBoolean ViewModelNtg6v3showSevenMenu, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeViewModelNtg6v3MiddleViewModel(ObservableInt ViewModelNtg6v3MiddleViewModel, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoPic(ObservableField<BitmapDrawable> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoTurnSpeed(ObservableInt ViewModelCarInfoTurnSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean onChangeViewModelMediaInfoProgress(ObservableInt ViewModelMediaInfoProgress, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    private boolean onChangeViewModelWeatherInfoNtg6v3Temperature(ObservableField<String> observableField, int fieldId) {
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

    private boolean onChangeViewModelCarInfoSpeed(ObservableInt ViewModelCarInfoSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoBrakeValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
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
    /* JADX INFO: Multiple debug info for r0v60 'viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE'  int: [D('viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE' int)] */
    /* JADX INFO: Multiple debug info for r0v62 'viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE'  int: [D('viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE' int)] */
    /* JADX INFO: Multiple debug info for r0v64 'viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE'  int: [D('viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE' int)] */
    /* JADX INFO: Multiple debug info for r0v66 int: [D('viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE' int), D('viewModelMediaInfoCurrentTimeGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v68 java.lang.String: [D('viewModelMediaInfoCurrentTimeGet' java.lang.String), D('viewModelCarInfoNtg6v3SevenModeGet' int)] */
    /* JADX INFO: Multiple debug info for r14v4 com.wits.ksw.launcher.bean.CarInfo: [D('viewModelCarInfo' com.wits.ksw.launcher.bean.CarInfo), D('viewModelMediaInfoMaxProgress' android.databinding.ObservableInt)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        long dirtyFlags_1;
        ObservableField<Boolean> viewModelCarInfoBrakeValue;
        Drawable viewModelWeatherInfoImageGet;
        String viewModelWeatherInfoNtg6v3TemperatureGet;
        boolean z;
        int viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE;
        int viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE;
        String viewModelMediaInfoCurrentTimeGet;
        int viewModelMediaInfoMaxProgressGet;
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
        int viewModelMediaInfoMaxProgressGet2;
        int viewModelMediaInfoProgressGet2;
        String viewModelMediaInfoTotalTimeGet2;
        Drawable viewModelWeatherInfoImageGet2;
        String viewModelWeatherInfoNtg6v3TemperatureGet2;
        int viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE;
        int viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2;
        BitmapDrawable viewModelMediaInfoPicGet2;
        String stringValueOfViewModelCarInfoSpeed;
        int viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN;
        int viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3;
        Drawable viewModelCarInfoNtg6v3SevenModeInt4MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN;
        Drawable viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN;
        Drawable viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN;
        Drawable viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN;
        int viewModelCarInfoNtg6v3SevenModeGet;
        int viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
        int viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2;
        int viewModelNtg6v3MiddleViewModelGet;
        int viewModelNtg6v3showSevenMenuViewGONEViewVISIBLE;
        int viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE;
        String viewModelMediaInfoCurrentTimeGet2;
        int viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE;
        String viewModelMediaInfoCurrentTimeGet3;
        String viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName;
        String viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2;
        String viewModelMediaInfoCurrentTimeGet4;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE3;
        int viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2;
        String viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName3;
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
        ObservableBoolean viewModelCarInfoCarImage;
        ObservableBoolean viewModelCarInfoCarImage2;
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
        Drawable viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN3;
        Drawable viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2;
        Drawable viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN3;
        long dirtyFlags_12;
        ObservableField<String> viewModelMediaInfoMusicName;
        ObservableField<String> viewModelMediaInfoTotalTime;
        ObservableInt viewModelMediaInfoProgress;
        ObservableField<BitmapDrawable> viewModelMediaInfoPic;
        ObservableField<String> viewModelMediaInfoCurrentTime;
        ObservableField<String> viewModelWeatherInfoNtg6v3Temperature;
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
        Drawable viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN3 = null;
        BitmapDrawable viewModelMediaInfoPicGet4 = null;
        Boolean viewModelCarInfoRlDoorStateGet = null;
        int viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        String viewModelMediaInfoTotalTimeGet4 = null;
        String stringValueOfViewModelCarInfoSpeed2 = null;
        Drawable viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN3 = null;
        int viewModelMediaInfoMaxProgressGet3 = 0;
        int viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        boolean viewModelMediaInfoMusicNameJavaLangObjectNull = false;
        int viewModelNtg6v3showSevenMenuViewGONEViewVISIBLE2 = 0;
        int viewModelCarInfoNtg6v3SevenModeGet3 = 0;
        boolean viewModelCarInfoCarImageGet = false;
        Boolean viewModelCarInfoFrDoorStateGet = null;
        Drawable viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN4 = null;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3 = 0;
        String viewModelMediaInfoCurrentTimeGet5 = null;
        int viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE3 = 0;
        Drawable viewModelCarInfoNtg6v3SevenModeInt4MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN2 = null;
        int viewModelCarInfoSpeedGet3 = 0;
        int viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE4 = 0;
        String viewModelMediaInfoMusicNameGet = null;
        int viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE2 = 0;
        boolean viewModelMediaInfoMusicAtistJavaLangObjectNull = false;
        Boolean viewModelCarInfoSeatBeltpValueGet = null;
        Boolean viewModelCarInfoRrDoorStateGet = null;
        String viewModelMediaInfoMusicAtistGet = null;
        int viewModelCarInfoTurnSpeedGet2 = 0;
        Drawable viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN4 = null;
        Boolean viewModelCarInfoFlDoorStateGet = null;
        String viewModelCarInfoTempStrGet3 = null;
        Boolean viewModelCarInfoBrakeValueGet = null;
        Boolean viewModelCarInfoUnitEnImgGet = null;
        boolean viewModelNtg6v3showSevenMenuGet = false;
        String viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn2 = null;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE3 = 0;
        String viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax3 = null;
        Drawable viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN5 = null;
        String stringValueOfViewModelCarInfoTurnSpeed3 = null;
        Drawable viewModelWeatherInfoImageGet3 = null;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE4 = 0;
        DashboardViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 16809985) != 0) {
            viewModelWeatherInfo = DashboardViewModel.weatherInfo;
            if ((dirtyFlags & 16777217) != 0) {
                if (viewModelWeatherInfo != null) {
                    viewModelWeatherInfoImage = viewModelWeatherInfo.image;
                }
                updateRegistration(0, viewModelWeatherInfoImage);
                if (viewModelWeatherInfoImage != null) {
                    viewModelWeatherInfoImageGet3 = viewModelWeatherInfoImage.get();
                }
            }
            if ((dirtyFlags & 16809984) != 0) {
                if (viewModelWeatherInfo != null) {
                    viewModelWeatherInfoNtg6v3Temperature = viewModelWeatherInfo.ntg6v3Temperature;
                } else {
                    viewModelWeatherInfoNtg6v3Temperature = null;
                }
                viewModelCarInfoBrakeValue = null;
                updateRegistration(15, viewModelWeatherInfoNtg6v3Temperature);
                if (viewModelWeatherInfoNtg6v3Temperature != null) {
                    viewModelWeatherInfoNtg6v3TemperatureGet = viewModelWeatherInfoNtg6v3Temperature.get();
                    viewModelWeatherInfoImageGet = viewModelWeatherInfoImageGet3;
                } else {
                    viewModelWeatherInfoNtg6v3TemperatureGet = null;
                    viewModelWeatherInfoImageGet = viewModelWeatherInfoImageGet3;
                }
            } else {
                viewModelCarInfoBrakeValue = null;
                viewModelWeatherInfoNtg6v3TemperatureGet = null;
                viewModelWeatherInfoImageGet = viewModelWeatherInfoImageGet3;
            }
        } else {
            viewModelCarInfoBrakeValue = null;
            viewModelWeatherInfoNtg6v3TemperatureGet = null;
            viewModelWeatherInfoImageGet = null;
        }
        if ((dirtyFlags & 17191430) != 0) {
            MediaInfo viewModelMediaInfo = DashboardViewModel.mediaInfo;
            if ((dirtyFlags & 16777218) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoMusicAtist = viewModelMediaInfo.musicAtist;
                }
                updateRegistration(1, viewModelMediaInfoMusicAtist);
                if (viewModelMediaInfoMusicAtist != null) {
                    viewModelMediaInfoMusicAtistGet = viewModelMediaInfoMusicAtist.get();
                }
                viewModelMediaInfoMusicAtistJavaLangObjectNull = viewModelMediaInfoMusicAtistGet == null;
                if ((dirtyFlags & 16777218) != 0) {
                    dirtyFlags_1 = viewModelMediaInfoMusicAtistJavaLangObjectNull ? dirtyFlags_1 | 16 : dirtyFlags_1 | 8;
                }
            }
            if ((dirtyFlags & 16777220) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoMaxProgress = viewModelMediaInfo.maxProgress;
                }
                updateRegistration(2, viewModelMediaInfoMaxProgress);
                if (viewModelMediaInfoMaxProgress != null) {
                    viewModelMediaInfoMaxProgressGet3 = viewModelMediaInfoMaxProgress.get();
                }
            }
            if ((dirtyFlags & 16777728) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoCurrentTime = viewModelMediaInfo.currentTime;
                } else {
                    viewModelMediaInfoCurrentTime = null;
                }
                dirtyFlags_12 = dirtyFlags_1;
                updateRegistration(9, viewModelMediaInfoCurrentTime);
                if (viewModelMediaInfoCurrentTime != null) {
                    viewModelMediaInfoCurrentTimeGet5 = viewModelMediaInfoCurrentTime.get();
                }
            } else {
                dirtyFlags_12 = dirtyFlags_1;
            }
            if ((dirtyFlags & 16781312) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoPic = viewModelMediaInfo.pic;
                } else {
                    viewModelMediaInfoPic = null;
                }
                updateRegistration(12, viewModelMediaInfoPic);
                if (viewModelMediaInfoPic != null) {
                    viewModelMediaInfoPicGet4 = viewModelMediaInfoPic.get();
                }
                boolean viewModelMediaInfoPicJavaLangObjectNull = viewModelMediaInfoPicGet4 == null;
                if ((dirtyFlags & 16781312) != 0) {
                    if (viewModelMediaInfoPicJavaLangObjectNull) {
                        dirtyFlags |= 1125899906842624L;
                    } else {
                        dirtyFlags |= 562949953421312L;
                    }
                }
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE4 = viewModelMediaInfoPicJavaLangObjectNull ? 8 : 0;
            }
            if ((16793600 & dirtyFlags) != 0) {
                if (viewModelMediaInfo != null) {
                    viewModelMediaInfoProgress = viewModelMediaInfo.progress;
                } else {
                    viewModelMediaInfoProgress = null;
                }
                updateRegistration(14, viewModelMediaInfoProgress);
                if (viewModelMediaInfoProgress != null) {
                    viewModelMediaInfoProgressGet4 = viewModelMediaInfoProgress.get();
                }
            }
            if ((16908288 & dirtyFlags) != 0) {
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
            if ((dirtyFlags & 17039360) != 0) {
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
                if ((dirtyFlags & 17039360) == 0) {
                    viewModelMediaInfoProgressGet = viewModelMediaInfoProgressGet4;
                    viewModelMediaInfoPicGet = viewModelMediaInfoPicGet4;
                    dirtyFlags_1 = dirtyFlags_12;
                    viewModelMediaInfoTotalTimeGet = viewModelMediaInfoTotalTimeGet4;
                    viewModelMediaInfoMaxProgressGet = viewModelMediaInfoMaxProgressGet3;
                    viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = 0;
                    z = false;
                    viewModelMediaInfoCurrentTimeGet = viewModelMediaInfoCurrentTimeGet5;
                    viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE4;
                } else if (viewModelMediaInfoMusicNameJavaLangObjectNull) {
                    dirtyFlags |= 17179869184L;
                    viewModelMediaInfoProgressGet = viewModelMediaInfoProgressGet4;
                    viewModelMediaInfoPicGet = viewModelMediaInfoPicGet4;
                    dirtyFlags_1 = dirtyFlags_12;
                    viewModelMediaInfoTotalTimeGet = viewModelMediaInfoTotalTimeGet4;
                    viewModelMediaInfoMaxProgressGet = viewModelMediaInfoMaxProgressGet3;
                    viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = 0;
                    z = false;
                    viewModelMediaInfoCurrentTimeGet = viewModelMediaInfoCurrentTimeGet5;
                    viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE4;
                } else {
                    dirtyFlags |= 8589934592L;
                    viewModelMediaInfoProgressGet = viewModelMediaInfoProgressGet4;
                    viewModelMediaInfoPicGet = viewModelMediaInfoPicGet4;
                    dirtyFlags_1 = dirtyFlags_12;
                    viewModelMediaInfoTotalTimeGet = viewModelMediaInfoTotalTimeGet4;
                    viewModelMediaInfoMaxProgressGet = viewModelMediaInfoMaxProgressGet3;
                    viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = 0;
                    z = false;
                    viewModelMediaInfoCurrentTimeGet = viewModelMediaInfoCurrentTimeGet5;
                    viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE4;
                }
            } else {
                viewModelMediaInfoProgressGet = viewModelMediaInfoProgressGet4;
                viewModelMediaInfoPicGet = viewModelMediaInfoPicGet4;
                dirtyFlags_1 = dirtyFlags_12;
                viewModelMediaInfoTotalTimeGet = viewModelMediaInfoTotalTimeGet4;
                viewModelMediaInfoMaxProgressGet = viewModelMediaInfoMaxProgressGet3;
                viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = 0;
                z = false;
                viewModelMediaInfoCurrentTimeGet = viewModelMediaInfoCurrentTimeGet5;
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE4;
            }
        } else {
            viewModelMediaInfoProgressGet = 0;
            viewModelMediaInfoPicGet = null;
            viewModelMediaInfoTotalTimeGet = null;
            viewModelMediaInfoMaxProgressGet = 0;
            viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE = 0;
            z = false;
            viewModelMediaInfoCurrentTimeGet = null;
            viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE = 0;
        }
        if ((dirtyFlags & 24715768) != 0) {
            CarInfo viewModelCarInfo = DashboardViewModel.carInfo;
            if ((dirtyFlags & 16777224) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoCarImage = viewModelCarInfo.carImage;
                } else {
                    viewModelCarInfoCarImage = null;
                }
                viewModelWeatherInfoNtg6v3TemperatureGet2 = viewModelWeatherInfoNtg6v3TemperatureGet;
                updateRegistration(3, viewModelCarInfoCarImage);
                if (viewModelCarInfoCarImage != null) {
                    viewModelCarInfoCarImageGet = viewModelCarInfoCarImage.get();
                }
                if ((dirtyFlags & 16777224) != 0) {
                    if (viewModelCarInfoCarImageGet) {
                        dirtyFlags |= 17592186044416L;
                    } else {
                        dirtyFlags |= 8796093022208L;
                    }
                }
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3 = viewModelCarInfoCarImageGet ? 0 : 4;
            } else {
                viewModelWeatherInfoNtg6v3TemperatureGet2 = viewModelWeatherInfoNtg6v3TemperatureGet;
                viewModelCarInfoCarImage = null;
            }
            if ((dirtyFlags & 16777232) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoNtg6v3SevenMode = viewModelCarInfo.ntg6v3SevenMode;
                } else {
                    viewModelCarInfoNtg6v3SevenMode = null;
                }
                viewModelCarInfoCarImage2 = viewModelCarInfoCarImage;
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
                viewModelMediaInfoMaxProgressGet2 = viewModelMediaInfoMaxProgressGet;
                boolean viewModelCarInfoNtg6v3SevenModeInt4 = viewModelCarInfoNtg6v3SevenModeGet2 == 4;
                if ((dirtyFlags & 16777232) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt2) {
                        dirtyFlags |= 288230376151711744L;
                    } else {
                        dirtyFlags |= 144115188075855872L;
                    }
                }
                if ((dirtyFlags & 16777232) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt5) {
                        dirtyFlags |= 4294967296L;
                    } else {
                        dirtyFlags |= 2147483648L;
                    }
                }
                if ((dirtyFlags & 16777232) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt0) {
                        dirtyFlags_1 |= 4;
                    } else {
                        dirtyFlags_1 |= 2;
                    }
                }
                if ((dirtyFlags & 16777232) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt3) {
                        dirtyFlags |= 268435456;
                    } else {
                        dirtyFlags |= 134217728;
                    }
                }
                if ((dirtyFlags & 16777232) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt1) {
                        dirtyFlags |= 1099511627776L;
                    } else {
                        dirtyFlags |= 549755813888L;
                    }
                }
                if ((dirtyFlags & 16777232) != 0) {
                    if (viewModelCarInfoNtg6v3SevenModeInt4) {
                        dirtyFlags |= 281474976710656L;
                    } else {
                        dirtyFlags |= 140737488355328L;
                    }
                }
                Drawable viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt2 ? AppCompatResources.getDrawable(this.mboundView34.getContext(), R.drawable.ntg6v3_color_checkbox_sel) : AppCompatResources.getDrawable(this.mboundView34.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                if (viewModelCarInfoNtg6v3SevenModeInt5) {
                    viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN2 = viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN3;
                    viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView37.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN2 = viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN3;
                    viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView37.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                if (viewModelCarInfoNtg6v3SevenModeInt0) {
                    viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView32.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView32.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                if (viewModelCarInfoNtg6v3SevenModeInt3) {
                    viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView35.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView35.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                if (viewModelCarInfoNtg6v3SevenModeInt1) {
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView33.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN3 = viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2 = AppCompatResources.getDrawable(this.mboundView33.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                if (viewModelCarInfoNtg6v3SevenModeInt4) {
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN4 = viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN3 = AppCompatResources.getDrawable(this.mboundView36.getContext(), R.drawable.ntg6v3_color_checkbox_sel);
                } else {
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN4 = viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN2;
                    viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN3 = AppCompatResources.getDrawable(this.mboundView36.getContext(), R.drawable.ntg6v3_color_checkbox_n);
                }
                viewModelCarInfoNtg6v3SevenModeInt4MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN2 = viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN3;
                viewModelCarInfoNtg6v3SevenModeGet3 = viewModelCarInfoNtg6v3SevenModeGet2;
                viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN5 = viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN3;
                viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN4 = viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN2;
            } else {
                viewModelWeatherInfoImageGet2 = viewModelWeatherInfoImageGet;
                viewModelMediaInfoProgressGet2 = viewModelMediaInfoProgressGet;
                viewModelMediaInfoTotalTimeGet2 = viewModelMediaInfoTotalTimeGet;
                viewModelMediaInfoMaxProgressGet2 = viewModelMediaInfoMaxProgressGet;
                viewModelCarInfoCarImage2 = viewModelCarInfoCarImage;
            }
            if ((dirtyFlags & 16777248) != 0) {
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
                if ((dirtyFlags & 16777248) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet) {
                        dirtyFlags_1 |= 64;
                    } else {
                        dirtyFlags_1 |= 32;
                    }
                }
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE4 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 16777280) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoRrDoorState = viewModelCarInfo.rrDoorState;
                } else {
                    viewModelCarInfoRrDoorState = null;
                }
                updateRegistration(6, viewModelCarInfoRrDoorState);
                if (viewModelCarInfoRrDoorState != null) {
                    viewModelCarInfoRrDoorStateGet = viewModelCarInfoRrDoorState.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoRrDoorStateGet);
                if ((dirtyFlags & 16777280) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet) {
                        dirtyFlags |= 1073741824;
                    } else {
                        dirtyFlags |= 536870912;
                    }
                }
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet ? 0 : 4;
            }
            if ((16777344 & dirtyFlags) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoTempStr = viewModelCarInfo.tempStr;
                } else {
                    viewModelCarInfoTempStr = null;
                }
                updateRegistration(7, viewModelCarInfoTempStr);
                if (viewModelCarInfoTempStr != null) {
                    viewModelCarInfoTempStrGet3 = viewModelCarInfoTempStr.get();
                }
            }
            if ((dirtyFlags & 16777472) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSeatBeltpValue = viewModelCarInfo.seatBeltpValue;
                } else {
                    viewModelCarInfoSeatBeltpValue = null;
                }
                i = 8;
                updateRegistration(8, viewModelCarInfoSeatBeltpValue);
                if (viewModelCarInfoSeatBeltpValue != null) {
                    viewModelCarInfoSeatBeltpValueGet = viewModelCarInfoSeatBeltpValue.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet = ViewDataBinding.safeUnbox(viewModelCarInfoSeatBeltpValueGet);
                if ((dirtyFlags & 16777472) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet) {
                        dirtyFlags |= 70368744177664L;
                    } else {
                        dirtyFlags |= 35184372088832L;
                    }
                }
                viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE3 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet ? 8 : 0;
            } else {
                i = 8;
            }
            if ((16785408 & dirtyFlags) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoTurnSpeed = viewModelCarInfo.turnSpeed;
                } else {
                    viewModelCarInfoTurnSpeed = null;
                }
                updateRegistration(13, viewModelCarInfoTurnSpeed);
                if (viewModelCarInfoTurnSpeed != null) {
                    viewModelCarInfoTurnSpeedGet2 = viewModelCarInfoTurnSpeed.get();
                }
                stringValueOfViewModelCarInfoTurnSpeed3 = String.valueOf(viewModelCarInfoTurnSpeedGet2);
            }
            if ((dirtyFlags & 16842752) != 0) {
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
                if ((dirtyFlags & 16842752) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoUnitEnImgGet) {
                        dirtyFlags |= 1152921504606846976L;
                        dirtyFlags_1 |= 1;
                    } else {
                        dirtyFlags = dirtyFlags | 576460752303423488L | Long.MIN_VALUE;
                    }
                }
                viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn2 = this.speedUnitTextView.getResources().getString(androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoUnitEnImgGet ? R.string.speed_unit_en : R.string.speed_unit_cn);
                viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax3 = this.speedTvMax.getResources().getString(androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoUnitEnImgGet ? R.string.speed_unit_en_max : R.string.speed_unit_cn_max);
            }
            if ((dirtyFlags & 17301504) != 0) {
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
                if ((dirtyFlags & 17301504) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet) {
                        dirtyFlags |= 68719476736L;
                    } else {
                        dirtyFlags |= 34359738368L;
                    }
                }
                viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 17825792) != 0) {
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
                if ((dirtyFlags & 17825792) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet) {
                        dirtyFlags |= 4611686018427387904L;
                    } else {
                        dirtyFlags |= 2305843009213693952L;
                    }
                }
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE3 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet ? 0 : 4;
            }
            if ((18874368 & dirtyFlags) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSpeed = viewModelCarInfo.speed;
                } else {
                    viewModelCarInfoSpeed = null;
                }
                updateRegistration(21, viewModelCarInfoSpeed);
                if (viewModelCarInfoSpeed != null) {
                    viewModelCarInfoSpeedGet3 = viewModelCarInfoSpeed.get();
                }
                stringValueOfViewModelCarInfoSpeed2 = String.valueOf(viewModelCarInfoSpeedGet3);
            }
            if ((dirtyFlags & 20971520) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoBrakeValue2 = viewModelCarInfo.brakeValue;
                } else {
                    viewModelCarInfoBrakeValue2 = viewModelCarInfoBrakeValue;
                }
                updateRegistration(22, viewModelCarInfoBrakeValue2);
                if (viewModelCarInfoBrakeValue2 != null) {
                    viewModelCarInfoBrakeValueGet = viewModelCarInfoBrakeValue2.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet = ViewDataBinding.safeUnbox(viewModelCarInfoBrakeValueGet);
                if ((dirtyFlags & 20971520) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet) {
                        dirtyFlags |= 72057594037927936L;
                    } else {
                        dirtyFlags |= 36028797018963968L;
                    }
                }
                viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN3;
                viewModelCarInfoNtg6v3SevenModeGet = viewModelCarInfoNtg6v3SevenModeGet3;
                viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE2 = viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE3;
                viewModelCarInfoNtg6v3SevenModeInt4MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt4MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN2;
                viewModelCarInfoSpeedGet = viewModelCarInfoSpeedGet3;
                viewModelCarInfoTurnSpeedGet = viewModelCarInfoTurnSpeedGet2;
                viewModelCarInfoBrakeValueViewVISIBLEViewGONE = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet ? 0 : i;
                viewModelCarInfoTempStrGet = viewModelCarInfoTempStrGet3;
                viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn = viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn2;
                viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax = viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax3;
                viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN5;
                stringValueOfViewModelCarInfoTurnSpeed = stringValueOfViewModelCarInfoTurnSpeed3;
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE4;
                viewModelMediaInfoPicGet2 = viewModelMediaInfoPicGet;
                viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE = viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN4;
                stringValueOfViewModelCarInfoSpeed = stringValueOfViewModelCarInfoSpeed2;
                viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN4;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3;
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2 = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3 = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE3;
                viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN3;
            } else {
                viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN3;
                viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN3;
                viewModelCarInfoNtg6v3SevenModeGet = viewModelCarInfoNtg6v3SevenModeGet3;
                viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE2 = viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE3;
                viewModelCarInfoNtg6v3SevenModeInt4MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt4MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN2;
                viewModelCarInfoSpeedGet = viewModelCarInfoSpeedGet3;
                viewModelCarInfoTurnSpeedGet = viewModelCarInfoTurnSpeedGet2;
                viewModelCarInfoBrakeValueViewVISIBLEViewGONE = 0;
                viewModelCarInfoTempStrGet = viewModelCarInfoTempStrGet3;
                viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn = viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn2;
                viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax = viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax3;
                viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN5;
                stringValueOfViewModelCarInfoTurnSpeed = stringValueOfViewModelCarInfoTurnSpeed3;
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE4;
                viewModelMediaInfoPicGet2 = viewModelMediaInfoPicGet;
                viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE = viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN4;
                stringValueOfViewModelCarInfoSpeed = stringValueOfViewModelCarInfoSpeed2;
                viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN = viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN4;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE3;
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2 = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3 = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE3;
            }
        } else {
            viewModelWeatherInfoNtg6v3TemperatureGet2 = viewModelWeatherInfoNtg6v3TemperatureGet;
            viewModelWeatherInfoImageGet2 = viewModelWeatherInfoImageGet;
            viewModelMediaInfoProgressGet2 = viewModelMediaInfoProgressGet;
            viewModelMediaInfoTotalTimeGet2 = viewModelMediaInfoTotalTimeGet;
            viewModelMediaInfoMaxProgressGet2 = viewModelMediaInfoMaxProgressGet;
            viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN = null;
            viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN = null;
            viewModelCarInfoNtg6v3SevenModeGet = 0;
            viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE2 = 0;
            viewModelCarInfoNtg6v3SevenModeInt4MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN = null;
            viewModelCarInfoSpeedGet = 0;
            viewModelCarInfoTurnSpeedGet = 0;
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE = 0;
            viewModelCarInfoTempStrGet = null;
            viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn = null;
            viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax = null;
            viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN = null;
            stringValueOfViewModelCarInfoTurnSpeed = null;
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = 0;
            viewModelMediaInfoPicGet2 = viewModelMediaInfoPicGet;
            viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE = 0;
            viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN = null;
            stringValueOfViewModelCarInfoSpeed = null;
            viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN = null;
            viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = 0;
            viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2 = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE;
            viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = 0;
            viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3 = 0;
        }
        if ((dirtyFlags & 25168896) != 0) {
            if ((dirtyFlags & 25166848) != 0) {
                if (viewModel != null) {
                    viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
                    viewModelNtg6v3showSevenMenu = viewModel.ntg6v3showSevenMenu;
                } else {
                    viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
                    viewModelNtg6v3showSevenMenu = null;
                }
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3;
                updateRegistration(10, viewModelNtg6v3showSevenMenu);
                if (viewModelNtg6v3showSevenMenu != null) {
                    viewModelNtg6v3showSevenMenuGet = viewModelNtg6v3showSevenMenu.get();
                }
                if ((dirtyFlags & 25166848) != 0) {
                    if (viewModelNtg6v3showSevenMenuGet) {
                        dirtyFlags = dirtyFlags | 274877906944L | 4503599627370496L;
                    } else {
                        dirtyFlags = dirtyFlags | 137438953472L | 2251799813685248L;
                    }
                }
                viewModelNtg6v3showSevenMenuViewGONEViewVISIBLE2 = viewModelNtg6v3showSevenMenuGet ? 8 : 0;
                viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE2 = viewModelNtg6v3showSevenMenuGet ? 0 : 8;
            } else {
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3;
            }
            if ((dirtyFlags & 25167872) != 0) {
                if (viewModel != null) {
                    viewModelNtg6v3MiddleViewModel = viewModel.ntg6v3MiddleViewModel;
                } else {
                    viewModelNtg6v3MiddleViewModel = null;
                }
                updateRegistration(11, viewModelNtg6v3MiddleViewModel);
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
                if ((dirtyFlags & 25167872) != 0) {
                    if (viewModelNtg6v3MiddleViewModelInt0) {
                        dirtyFlags |= 4398046511104L;
                    } else {
                        dirtyFlags |= 2199023255552L;
                    }
                }
                if ((dirtyFlags & 25167872) != 0) {
                    if (viewModelNtg6v3MiddleViewModelInt2) {
                        dirtyFlags |= 18014398509481984L;
                    } else {
                        dirtyFlags |= 9007199254740992L;
                    }
                }
                if ((dirtyFlags & 25167872) != 0) {
                    if (viewModelNtg6v3MiddleViewModelInt1) {
                        dirtyFlags |= 67108864;
                    } else {
                        dirtyFlags |= 33554432;
                    }
                }
                viewModelNtg6v3showSevenMenuViewGONEViewVISIBLE = viewModelNtg6v3showSevenMenuViewGONEViewVISIBLE2;
                viewModelNtg6v3MiddleViewModelGet = viewModelNtg6v3MiddleViewModelInt0 ? 0 : 8;
                viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE = viewModelNtg6v3MiddleViewModelInt2 ? 0 : 8;
                viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelInt1 ? 0 : 8;
                viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE = viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE2;
            } else {
                viewModelNtg6v3showSevenMenuViewGONEViewVISIBLE = viewModelNtg6v3showSevenMenuViewGONEViewVISIBLE2;
                viewModelNtg6v3MiddleViewModelGet = 0;
                viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE = viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE2;
                viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE = 0;
                viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE;
            }
        } else {
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
            viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE3;
            viewModelNtg6v3showSevenMenuViewGONEViewVISIBLE = 0;
            viewModelNtg6v3MiddleViewModelGet = 0;
            viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE = 0;
            viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE = 0;
            viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE;
        }
        if ((dirtyFlags & 17039360) == 0) {
            viewModelMediaInfoCurrentTimeGet2 = viewModelMediaInfoCurrentTimeGet;
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE = viewModelNtg6v3MiddleViewModelGet;
            viewModelMediaInfoCurrentTimeGet3 = null;
        } else if (viewModelMediaInfoMusicNameJavaLangObjectNull) {
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE = viewModelNtg6v3MiddleViewModelGet;
            viewModelMediaInfoCurrentTimeGet2 = viewModelMediaInfoCurrentTimeGet;
            viewModelMediaInfoCurrentTimeGet3 = this.musicNameTv.getResources().getString(R.string.ksw_idf7_unkonw_soung);
        } else {
            viewModelMediaInfoCurrentTimeGet2 = viewModelMediaInfoCurrentTimeGet;
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE = viewModelNtg6v3MiddleViewModelGet;
            viewModelMediaInfoCurrentTimeGet3 = viewModelMediaInfoMusicNameGet;
        }
        if ((dirtyFlags & 16777218) == 0) {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName = viewModelMediaInfoCurrentTimeGet3;
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2 = null;
        } else if (viewModelMediaInfoMusicAtistJavaLangObjectNull) {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName = viewModelMediaInfoCurrentTimeGet3;
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2 = this.musicArtistTv.getResources().getString(R.string.ksw_idf7_unknow_artis);
        } else {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName = viewModelMediaInfoCurrentTimeGet3;
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2 = viewModelMediaInfoMusicAtistGet;
        }
        if ((dirtyFlags & 25166848) != 0) {
            this.alsMenu.setVisibility(viewModelNtg6v3showSevenMenuViewVISIBLEViewGONE);
            this.mboundView30.setVisibility(viewModelNtg6v3showSevenMenuViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 16777472) != 0) {
            this.batteryImageView.setVisibility(viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE2);
        }
        if ((dirtyFlags & 16777232) != 0) {
            this.batteryImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.mboundView1.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView32, viewModelCarInfoNtg6v3SevenModeInt0MboundView32AndroidDrawableNtg6v3ColorCheckboxSelMboundView32AndroidDrawableNtg6v3ColorCheckboxN);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView33, viewModelCarInfoNtg6v3SevenModeInt1MboundView33AndroidDrawableNtg6v3ColorCheckboxSelMboundView33AndroidDrawableNtg6v3ColorCheckboxN);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView34, viewModelCarInfoNtg6v3SevenModeInt2MboundView34AndroidDrawableNtg6v3ColorCheckboxSelMboundView34AndroidDrawableNtg6v3ColorCheckboxN);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView35, viewModelCarInfoNtg6v3SevenModeInt3MboundView35AndroidDrawableNtg6v3ColorCheckboxSelMboundView35AndroidDrawableNtg6v3ColorCheckboxN);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView36, viewModelCarInfoNtg6v3SevenModeInt4MboundView36AndroidDrawableNtg6v3ColorCheckboxSelMboundView36AndroidDrawableNtg6v3ColorCheckboxN);
            TextViewBindingAdapter.setDrawableLeft(this.mboundView37, viewModelCarInfoNtg6v3SevenModeInt5MboundView37AndroidDrawableNtg6v3ColorCheckboxSelMboundView37AndroidDrawableNtg6v3ColorCheckboxN);
            this.ntg6v3MusicBkPic.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.oilImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.outerRingImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.outerRingTachometer.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            BaseBindingModel.setNtg6v3ProgressDrawable(this.seekBar, viewModelCarInfoNtg6v3SevenModeGet);
            this.speedometerImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
            this.tachometerImageView.setImageLevel(viewModelCarInfoNtg6v3SevenModeGet);
        }
        if ((dirtyFlags & 16777224) != 0) {
            this.carImageView.setVisibility(viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2);
        }
        if ((dirtyFlags & 16777728) != 0) {
            viewModelMediaInfoCurrentTimeGet4 = viewModelMediaInfoCurrentTimeGet2;
            TextViewBindingAdapter.setText(this.currentTimeTextView, viewModelMediaInfoCurrentTimeGet4);
        } else {
            viewModelMediaInfoCurrentTimeGet4 = viewModelMediaInfoCurrentTimeGet2;
        }
        if ((dirtyFlags & 17825792) != 0) {
            viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE;
            this.dorrLeftFlImageView.setVisibility(viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2);
        } else {
            viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2 = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE;
        }
        if ((dirtyFlags & 16777248) != 0) {
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE3 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
            this.dorrLeftFrImageView.setVisibility(viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE3);
        } else {
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE3 = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
        }
        if ((dirtyFlags & 17301504) != 0) {
            viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE;
            this.dorrLeftRlImageView.setVisibility(viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE);
        } else {
            viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoSeatBeltpValueViewGONEViewVISIBLE;
        }
        if ((dirtyFlags & 16777280) != 0) {
            viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE;
            this.imageView19.setVisibility(viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE);
        } else {
            viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE;
        }
        if ((dirtyFlags & 16777216) != 0) {
            this.mboundView12.setOnClickListener(this.mCallback455);
            this.mboundView18.setOnClickListener(this.mCallback456);
            this.mboundView20.setOnClickListener(this.mCallback457);
            this.mboundView32.setOnClickListener(this.mCallback458);
            this.mboundView33.setOnClickListener(this.mCallback459);
            this.mboundView34.setOnClickListener(this.mCallback460);
            this.mboundView35.setOnClickListener(this.mCallback461);
            this.mboundView36.setOnClickListener(this.mCallback462);
            this.mboundView37.setOnClickListener(this.mCallback463);
            ImageViewBindingAdapter.setImageDrawable(this.ntg6v3MusicBkPic, AppCompatResources.getDrawable(this.ntg6v3MusicBkPic.getContext(), R.drawable.ntg6v3_color_music_pic_level));
            ImageViewBindingAdapter.setImageDrawable(this.outerRingImageView, AppCompatResources.getDrawable(this.outerRingImageView.getContext(), R.drawable.ntg6v3_color_speed_outer_ring_level));
            ImageViewBindingAdapter.setImageDrawable(this.outerRingTachometer, AppCompatResources.getDrawable(this.outerRingTachometer.getContext(), R.drawable.ntg6v3_color_tachometer_outer_ring_level));
            ImageViewBindingAdapter.setImageDrawable(this.speedometerImageView, AppCompatResources.getDrawable(this.speedometerImageView.getContext(), R.drawable.ntg6v3_color_speed_mp_wtach_level));
        }
        if ((dirtyFlags & 25167872) != 0) {
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE;
            this.mboundView12.setVisibility(viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2);
            this.mboundView18.setVisibility(viewModelNtg6v3MiddleViewModelInt1ViewVISIBLEViewGONE2);
            this.mboundView20.setVisibility(viewModelNtg6v3MiddleViewModelInt2ViewVISIBLEViewGONE);
            this.textView18.setVisibility(viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2);
            this.time.setVisibility(viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2);
        } else {
            viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE2 = viewModelNtg6v3MiddleViewModelInt0ViewVISIBLEViewGONE;
        }
        if ((dirtyFlags & 16777218) != 0) {
            TextViewBindingAdapter.setText(this.musicArtistTv, viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName2);
        }
        if ((dirtyFlags & 17039360) != 0) {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName3 = viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName;
            TextViewBindingAdapter.setText(this.musicNameTv, viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName3);
        } else {
            viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName3 = viewModelMediaInfoMusicNameJavaLangObjectNullMusicNameTvAndroidStringKswIdf7UnkonwSoungViewModelMediaInfoMusicName;
        }
        if ((dirtyFlags & 16781312) != 0) {
            this.ntg6v3MusicPic.setVisibility(viewModelMediaInfoPicJavaLangObjectNullViewGONEViewVISIBLE2);
            viewModelMediaInfoPicGet3 = viewModelMediaInfoPicGet2;
            BaseBindingModel.setAlbumIcon(this.ntg6v3MusicPic, viewModelMediaInfoPicGet3);
        } else {
            viewModelMediaInfoPicGet3 = viewModelMediaInfoPicGet2;
        }
        if ((dirtyFlags & 20971520) != 0) {
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE2 = viewModelCarInfoBrakeValueViewVISIBLEViewGONE;
            this.oilImageView.setVisibility(viewModelCarInfoBrakeValueViewVISIBLEViewGONE2);
        } else {
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE2 = viewModelCarInfoBrakeValueViewVISIBLEViewGONE;
        }
        if ((dirtyFlags & 16777220) != 0) {
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE3 = viewModelMediaInfoMaxProgressGet2;
            this.seekBar.setMax(viewModelCarInfoBrakeValueViewVISIBLEViewGONE3);
        } else {
            viewModelCarInfoBrakeValueViewVISIBLEViewGONE3 = viewModelMediaInfoMaxProgressGet2;
        }
        if ((dirtyFlags & 16793600) != 0) {
            viewModelMediaInfoProgressGet3 = viewModelMediaInfoProgressGet2;
            SeekBarBindingAdapter.setProgress(this.seekBar, viewModelMediaInfoProgressGet3);
        } else {
            viewModelMediaInfoProgressGet3 = viewModelMediaInfoProgressGet2;
        }
        if ((dirtyFlags & 18874368) != 0) {
            TextViewBindingAdapter.setText(this.speedPointerTextView, stringValueOfViewModelCarInfoSpeed);
            viewModelCarInfoSpeedGet2 = viewModelCarInfoSpeedGet;
            BaseBindingModel.setNtg6v3ArcProgressBarValue(this.speedProgressBar, viewModelCarInfoSpeedGet2);
        } else {
            viewModelCarInfoSpeedGet2 = viewModelCarInfoSpeedGet;
        }
        if ((dirtyFlags & 16842752) != 0) {
            TextViewBindingAdapter.setText(this.speedTvMax, viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax);
            viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax2 = viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn;
            TextViewBindingAdapter.setText(this.speedUnitTextView, viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax2);
        } else {
            viewModelCarInfoUnitEnImgSpeedTvMaxAndroidStringSpeedUnitEnMaxSpeedTvMaxAndroidStringSpeedUnitCnMax2 = viewModelCarInfoUnitEnImgSpeedUnitTextViewAndroidStringSpeedUnitEnSpeedUnitTextViewAndroidStringSpeedUnitCn;
        }
        if ((dirtyFlags & 16777344) != 0) {
            viewModelCarInfoTempStrGet2 = viewModelCarInfoTempStrGet;
            TextViewBindingAdapter.setText(this.textView18, viewModelCarInfoTempStrGet2);
        } else {
            viewModelCarInfoTempStrGet2 = viewModelCarInfoTempStrGet;
        }
        if ((dirtyFlags & 16908288) != 0) {
            viewModelMediaInfoTotalTimeGet3 = viewModelMediaInfoTotalTimeGet2;
            TextViewBindingAdapter.setText(this.totalTimeTextView, viewModelMediaInfoTotalTimeGet3);
        } else {
            viewModelMediaInfoTotalTimeGet3 = viewModelMediaInfoTotalTimeGet2;
        }
        if ((dirtyFlags & 16785408) != 0) {
            BaseBindingModel.setNtg6v3ArcProgressBarValue(this.turnSpeedProgressBar, viewModelCarInfoTurnSpeedGet);
            stringValueOfViewModelCarInfoTurnSpeed2 = stringValueOfViewModelCarInfoTurnSpeed;
            TextViewBindingAdapter.setText(this.zspeedPointerTextView, stringValueOfViewModelCarInfoTurnSpeed2);
        } else {
            stringValueOfViewModelCarInfoTurnSpeed2 = stringValueOfViewModelCarInfoTurnSpeed;
        }
        if ((dirtyFlags & 16777217) != 0) {
            TextViewBindingAdapter.setDrawableLeft(this.weatherTv, viewModelWeatherInfoImageGet2);
        }
        if ((dirtyFlags & 16809984) != 0) {
            TextViewBindingAdapter.setText(this.weatherTv, viewModelWeatherInfoNtg6v3TemperatureGet2);
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
