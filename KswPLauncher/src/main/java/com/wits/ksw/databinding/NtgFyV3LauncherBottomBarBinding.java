package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public abstract class NtgFyV3LauncherBottomBarBinding extends ViewDataBinding {
    public final TextView carinfoTv;
    public final RelativeLayout llBottom3;
    public final LinearLayout llBottomBarContainer;
    @Bindable
    protected Ntg6v3LauncherViewModel mBottomViewModel;
    public final RelativeLayout ntg3v6MainBottomCarRl;
    public final RelativeLayout ntg3v6MainBottomNavRl;
    public final LinearLayout ntg3v6MainBottomShoujihlRl;
    public final LinearLayout ntg3v6MainBottomThemeRl;
    public final LinearLayout ntg3v6MainBottomVideoRl;
    public final RelativeLayout ntg3v6MainBottomWeatherRl;
    public final ImageView ntgFyV3Apps1;
    public final ImageView ntgFyV3Apps2;
    public final ImageView ntgFyV3Apps3;
    public final TextView weatherTvSymbol;
    public final View weatherView;

    public abstract void setBottomViewModel(Ntg6v3LauncherViewModel ntg6v3LauncherViewModel);

    protected NtgFyV3LauncherBottomBarBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView carinfoTv2, RelativeLayout llBottom32, LinearLayout llBottomBarContainer2, RelativeLayout ntg3v6MainBottomCarRl2, RelativeLayout ntg3v6MainBottomNavRl2, LinearLayout ntg3v6MainBottomShoujihlRl2, LinearLayout ntg3v6MainBottomThemeRl2, LinearLayout ntg3v6MainBottomVideoRl2, RelativeLayout ntg3v6MainBottomWeatherRl2, ImageView ntgFyV3Apps12, ImageView ntgFyV3Apps22, ImageView ntgFyV3Apps32, TextView weatherTvSymbol2, View weatherView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.carinfoTv = carinfoTv2;
        this.llBottom3 = llBottom32;
        this.llBottomBarContainer = llBottomBarContainer2;
        this.ntg3v6MainBottomCarRl = ntg3v6MainBottomCarRl2;
        this.ntg3v6MainBottomNavRl = ntg3v6MainBottomNavRl2;
        this.ntg3v6MainBottomShoujihlRl = ntg3v6MainBottomShoujihlRl2;
        this.ntg3v6MainBottomThemeRl = ntg3v6MainBottomThemeRl2;
        this.ntg3v6MainBottomVideoRl = ntg3v6MainBottomVideoRl2;
        this.ntg3v6MainBottomWeatherRl = ntg3v6MainBottomWeatherRl2;
        this.ntgFyV3Apps1 = ntgFyV3Apps12;
        this.ntgFyV3Apps2 = ntgFyV3Apps22;
        this.ntgFyV3Apps3 = ntgFyV3Apps32;
        this.weatherTvSymbol = weatherTvSymbol2;
        this.weatherView = weatherView2;
    }

    public Ntg6v3LauncherViewModel getBottomViewModel() {
        return this.mBottomViewModel;
    }

    public static NtgFyV3LauncherBottomBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NtgFyV3LauncherBottomBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (NtgFyV3LauncherBottomBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg_fy_v3_launcher_bottom_bar, root, attachToRoot, component);
    }

    public static NtgFyV3LauncherBottomBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NtgFyV3LauncherBottomBarBinding inflate(LayoutInflater inflater, Object component) {
        return (NtgFyV3LauncherBottomBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg_fy_v3_launcher_bottom_bar, null, false, component);
    }

    public static NtgFyV3LauncherBottomBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NtgFyV3LauncherBottomBarBinding bind(View view, Object component) {
        return (NtgFyV3LauncherBottomBarBinding) bind(component, view, R.layout.ntg_fy_v3_launcher_bottom_bar);
    }
}
