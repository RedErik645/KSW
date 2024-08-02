package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.DashboardViewModel;
import com.wits.ksw.launcher.view.ColorArcProgressBar;
import com.wits.ksw.launcher.view.ID7SpeedImageView;

public abstract class NTG6V3DashBoardBind extends ViewDataBinding {
    public final ConstraintLayout alsMenu;
    public final LinearLayout alsRadioGroup;
    public final ID7SpeedImageView batteryImageView;
    public final ImageView carImageView;
    public final TextView currentTimeTextView;
    public final ImageView dorrLeftFlImageView;
    public final ImageView dorrLeftFrImageView;
    public final ImageView dorrLeftRlImageView;
    public final ImageView imageView19;
    public final ConstraintLayout linearLayout2;
    @Bindable
    protected DashboardViewModel mViewModel;
    public final TextView musicArtistTv;
    public final TextView musicNameTv;
    public final ID7SpeedImageView ntg6v3MusicBkPic;
    public final ImageView ntg6v3MusicPic;
    public final ID7SpeedImageView oilImageView;
    public final ID7SpeedImageView outerRingImageView;
    public final ID7SpeedImageView outerRingTachometer;
    public final SeekBar seekBar;
    public final TextView speedPointerTextView;
    public final ColorArcProgressBar speedProgressBar;
    public final TextView speedTvMax;
    public final TextView speedTvMin;
    public final TextView speedUnitTextView;
    public final ID7SpeedImageView speedometerImageView;
    public final ID7SpeedImageView tachometerImageView;
    public final TextClock textClock1;
    public final TextClock textClock2;
    public final TextClock textClock3;
    public final TextView textView18;
    public final TextClock time;
    public final TextView totalTimeTextView;
    public final ColorArcProgressBar turnSpeedProgressBar;
    public final TextView weatherTv;
    public final TextView zspeedPointerTextView;
    public final TextView zspeedUnitTextView;

    public abstract void setViewModel(DashboardViewModel dashboardViewModel);

    protected NTG6V3DashBoardBind(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout alsMenu2, LinearLayout alsRadioGroup2, ID7SpeedImageView batteryImageView2, ImageView carImageView2, TextView currentTimeTextView2, ImageView dorrLeftFlImageView2, ImageView dorrLeftFrImageView2, ImageView dorrLeftRlImageView2, ImageView imageView192, ConstraintLayout linearLayout22, TextView musicArtistTv2, TextView musicNameTv2, ID7SpeedImageView ntg6v3MusicBkPic2, ImageView ntg6v3MusicPic2, ID7SpeedImageView oilImageView2, ID7SpeedImageView outerRingImageView2, ID7SpeedImageView outerRingTachometer2, SeekBar seekBar2, TextView speedPointerTextView2, ColorArcProgressBar speedProgressBar2, TextView speedTvMax2, TextView speedTvMin2, TextView speedUnitTextView2, ID7SpeedImageView speedometerImageView2, ID7SpeedImageView tachometerImageView2, TextClock textClock12, TextClock textClock22, TextClock textClock32, TextView textView182, TextClock time2, TextView totalTimeTextView2, ColorArcProgressBar turnSpeedProgressBar2, TextView weatherTv2, TextView zspeedPointerTextView2, TextView zspeedUnitTextView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.alsMenu = alsMenu2;
        this.alsRadioGroup = alsRadioGroup2;
        this.batteryImageView = batteryImageView2;
        this.carImageView = carImageView2;
        this.currentTimeTextView = currentTimeTextView2;
        this.dorrLeftFlImageView = dorrLeftFlImageView2;
        this.dorrLeftFrImageView = dorrLeftFrImageView2;
        this.dorrLeftRlImageView = dorrLeftRlImageView2;
        this.imageView19 = imageView192;
        this.linearLayout2 = linearLayout22;
        this.musicArtistTv = musicArtistTv2;
        this.musicNameTv = musicNameTv2;
        this.ntg6v3MusicBkPic = ntg6v3MusicBkPic2;
        this.ntg6v3MusicPic = ntg6v3MusicPic2;
        this.oilImageView = oilImageView2;
        this.outerRingImageView = outerRingImageView2;
        this.outerRingTachometer = outerRingTachometer2;
        this.seekBar = seekBar2;
        this.speedPointerTextView = speedPointerTextView2;
        this.speedProgressBar = speedProgressBar2;
        this.speedTvMax = speedTvMax2;
        this.speedTvMin = speedTvMin2;
        this.speedUnitTextView = speedUnitTextView2;
        this.speedometerImageView = speedometerImageView2;
        this.tachometerImageView = tachometerImageView2;
        this.textClock1 = textClock12;
        this.textClock2 = textClock22;
        this.textClock3 = textClock32;
        this.textView18 = textView182;
        this.time = time2;
        this.totalTimeTextView = totalTimeTextView2;
        this.turnSpeedProgressBar = turnSpeedProgressBar2;
        this.weatherTv = weatherTv2;
        this.zspeedPointerTextView = zspeedPointerTextView2;
        this.zspeedUnitTextView = zspeedUnitTextView2;
    }

    public DashboardViewModel getViewModel() {
        return this.mViewModel;
    }

    public static NTG6V3DashBoardBind inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NTG6V3DashBoardBind inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (NTG6V3DashBoardBind) ViewDataBinding.inflateInternal(inflater, R.layout.activity_dash_board_ntg6_v3, root, attachToRoot, component);
    }

    public static NTG6V3DashBoardBind inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NTG6V3DashBoardBind inflate(LayoutInflater inflater, Object component) {
        return (NTG6V3DashBoardBind) ViewDataBinding.inflateInternal(inflater, R.layout.activity_dash_board_ntg6_v3, null, false, component);
    }

    public static NTG6V3DashBoardBind bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NTG6V3DashBoardBind bind(View view, Object component) {
        return (NTG6V3DashBoardBind) bind(component, view, R.layout.activity_dash_board_ntg6_v3);
    }
}
