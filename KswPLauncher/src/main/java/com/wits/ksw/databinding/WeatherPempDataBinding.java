package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public abstract class WeatherPempDataBinding extends ViewDataBinding {
    public final TextView btA;
    public final TextView btB;
    public final TextView btC;
    public final ImageView ivDivider;
    public final ImageView ivIcon;
    public final ImageView ivMask;
    public final RelativeLayout llContainer;
    @Bindable
    protected LauncherViewModel mWeatherViewModel;
    public final RelativeLayout temperature;
    public final FrameLayout temperatureRange;
    public final TextView temperatureTv;
    public final TextView tvCity;
    public final TextView tvTitle;
    public final TextView unitWeather;
    public final TextView weatherTv;

    public abstract void setWeatherViewModel(LauncherViewModel launcherViewModel);

    protected WeatherPempDataBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView btA2, TextView btB2, TextView btC2, ImageView ivDivider2, ImageView ivIcon2, ImageView ivMask2, RelativeLayout llContainer2, RelativeLayout temperature2, FrameLayout temperatureRange2, TextView temperatureTv2, TextView tvCity2, TextView tvTitle2, TextView unitWeather2, TextView weatherTv2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btA = btA2;
        this.btB = btB2;
        this.btC = btC2;
        this.ivDivider = ivDivider2;
        this.ivIcon = ivIcon2;
        this.ivMask = ivMask2;
        this.llContainer = llContainer2;
        this.temperature = temperature2;
        this.temperatureRange = temperatureRange2;
        this.temperatureTv = temperatureTv2;
        this.tvCity = tvCity2;
        this.tvTitle = tvTitle2;
        this.unitWeather = unitWeather2;
        this.weatherTv = weatherTv2;
    }

    public LauncherViewModel getWeatherViewModel() {
        return this.mWeatherViewModel;
    }

    public static WeatherPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WeatherPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (WeatherPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_weather, root, attachToRoot, component);
    }

    public static WeatherPempDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WeatherPempDataBinding inflate(LayoutInflater inflater, Object component) {
        return (WeatherPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_weather, null, false, component);
    }

    public static WeatherPempDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WeatherPempDataBinding bind(View view, Object component) {
        return (WeatherPempDataBinding) bind(component, view, R.layout.fragment_pemp_weather);
    }
}
