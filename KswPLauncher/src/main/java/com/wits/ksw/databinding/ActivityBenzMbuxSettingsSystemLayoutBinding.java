package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class ActivityBenzMbuxSettingsSystemLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RelativeLayout mbuxSettingsSystemAux;
    public final RelativeLayout mbuxSettingsSystemBrightness;
    public final RelativeLayout mbuxSettingsSystemCamera;
    public final FrameLayout mbuxSettingsSystemFramelay;
    public final RelativeLayout mbuxSettingsSystemFuel;
    public final RelativeLayout mbuxSettingsSystemLanguage;
    public final RelativeLayout mbuxSettingsSystemLines;
    public final RelativeLayout mbuxSettingsSystemMirror;
    public final RelativeLayout mbuxSettingsSystemMotion;
    public final RelativeLayout mbuxSettingsSystemMusic;
    public final RelativeLayout mbuxSettingsSystemMute;
    public final RelativeLayout mbuxSettingsSystemRadar;
    public final ScrollView mbuxSettingsSystemScroll;
    public final RelativeLayout mbuxSettingsSystemTemp;
    public final RelativeLayout mbuxSettingsSystemTime;
    public final RelativeLayout mbuxSettingsSystemVideo;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected ActivityBenzMbuxSettingsSystemLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout mbuxSettingsSystemAux2, RelativeLayout mbuxSettingsSystemBrightness2, RelativeLayout mbuxSettingsSystemCamera2, FrameLayout mbuxSettingsSystemFramelay2, RelativeLayout mbuxSettingsSystemFuel2, RelativeLayout mbuxSettingsSystemLanguage2, RelativeLayout mbuxSettingsSystemLines2, RelativeLayout mbuxSettingsSystemMirror2, RelativeLayout mbuxSettingsSystemMotion2, RelativeLayout mbuxSettingsSystemMusic2, RelativeLayout mbuxSettingsSystemMute2, RelativeLayout mbuxSettingsSystemRadar2, ScrollView mbuxSettingsSystemScroll2, RelativeLayout mbuxSettingsSystemTemp2, RelativeLayout mbuxSettingsSystemTime2, RelativeLayout mbuxSettingsSystemVideo2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsSystemAux = mbuxSettingsSystemAux2;
        this.mbuxSettingsSystemBrightness = mbuxSettingsSystemBrightness2;
        this.mbuxSettingsSystemCamera = mbuxSettingsSystemCamera2;
        this.mbuxSettingsSystemFramelay = mbuxSettingsSystemFramelay2;
        this.mbuxSettingsSystemFuel = mbuxSettingsSystemFuel2;
        this.mbuxSettingsSystemLanguage = mbuxSettingsSystemLanguage2;
        this.mbuxSettingsSystemLines = mbuxSettingsSystemLines2;
        this.mbuxSettingsSystemMirror = mbuxSettingsSystemMirror2;
        this.mbuxSettingsSystemMotion = mbuxSettingsSystemMotion2;
        this.mbuxSettingsSystemMusic = mbuxSettingsSystemMusic2;
        this.mbuxSettingsSystemMute = mbuxSettingsSystemMute2;
        this.mbuxSettingsSystemRadar = mbuxSettingsSystemRadar2;
        this.mbuxSettingsSystemScroll = mbuxSettingsSystemScroll2;
        this.mbuxSettingsSystemTemp = mbuxSettingsSystemTemp2;
        this.mbuxSettingsSystemTime = mbuxSettingsSystemTime2;
        this.mbuxSettingsSystemVideo = mbuxSettingsSystemVideo2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBenzMbuxSettingsSystemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsSystemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBenzMbuxSettingsSystemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_system_layout, root, attachToRoot, component);
    }

    public static ActivityBenzMbuxSettingsSystemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsSystemLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBenzMbuxSettingsSystemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_system_layout, null, false, component);
    }

    public static ActivityBenzMbuxSettingsSystemLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsSystemLayoutBinding bind(View view, Object component) {
        return (ActivityBenzMbuxSettingsSystemLayoutBinding) bind(component, view, R.layout.activity_benz_mbux_settings_system_layout);
    }
}
