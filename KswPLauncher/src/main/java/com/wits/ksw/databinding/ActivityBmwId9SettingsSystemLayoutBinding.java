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
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class ActivityBmwId9SettingsSystemLayoutBinding extends ViewDataBinding {
    public final ImageView bmwId8SettingsHomeback;
    public final RelativeLayout bmwId9SettingsSystemBrightness;
    public final RelativeLayout bmwId9SettingsSystemCamera;
    public final FrameLayout bmwId9SettingsSystemFramelay;
    public final RelativeLayout bmwId9SettingsSystemFuel;
    public final RelativeLayout bmwId9SettingsSystemLanguage;
    public final RelativeLayout bmwId9SettingsSystemLines;
    public final RelativeLayout bmwId9SettingsSystemMirror;
    public final RelativeLayout bmwId9SettingsSystemMotion;
    public final RelativeLayout bmwId9SettingsSystemMusic;
    public final RelativeLayout bmwId9SettingsSystemMute;
    public final RelativeLayout bmwId9SettingsSystemRadar;
    public final ScrollView bmwId9SettingsSystemScroll;
    public final RelativeLayout bmwId9SettingsSystemTemp;
    public final RelativeLayout bmwId9SettingsSystemTime;
    public final RelativeLayout bmwId9SettingsSystemVideo;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected ActivityBmwId9SettingsSystemLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView bmwId8SettingsHomeback2, RelativeLayout bmwId9SettingsSystemBrightness2, RelativeLayout bmwId9SettingsSystemCamera2, FrameLayout bmwId9SettingsSystemFramelay2, RelativeLayout bmwId9SettingsSystemFuel2, RelativeLayout bmwId9SettingsSystemLanguage2, RelativeLayout bmwId9SettingsSystemLines2, RelativeLayout bmwId9SettingsSystemMirror2, RelativeLayout bmwId9SettingsSystemMotion2, RelativeLayout bmwId9SettingsSystemMusic2, RelativeLayout bmwId9SettingsSystemMute2, RelativeLayout bmwId9SettingsSystemRadar2, ScrollView bmwId9SettingsSystemScroll2, RelativeLayout bmwId9SettingsSystemTemp2, RelativeLayout bmwId9SettingsSystemTime2, RelativeLayout bmwId9SettingsSystemVideo2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId8SettingsHomeback = bmwId8SettingsHomeback2;
        this.bmwId9SettingsSystemBrightness = bmwId9SettingsSystemBrightness2;
        this.bmwId9SettingsSystemCamera = bmwId9SettingsSystemCamera2;
        this.bmwId9SettingsSystemFramelay = bmwId9SettingsSystemFramelay2;
        this.bmwId9SettingsSystemFuel = bmwId9SettingsSystemFuel2;
        this.bmwId9SettingsSystemLanguage = bmwId9SettingsSystemLanguage2;
        this.bmwId9SettingsSystemLines = bmwId9SettingsSystemLines2;
        this.bmwId9SettingsSystemMirror = bmwId9SettingsSystemMirror2;
        this.bmwId9SettingsSystemMotion = bmwId9SettingsSystemMotion2;
        this.bmwId9SettingsSystemMusic = bmwId9SettingsSystemMusic2;
        this.bmwId9SettingsSystemMute = bmwId9SettingsSystemMute2;
        this.bmwId9SettingsSystemRadar = bmwId9SettingsSystemRadar2;
        this.bmwId9SettingsSystemScroll = bmwId9SettingsSystemScroll2;
        this.bmwId9SettingsSystemTemp = bmwId9SettingsSystemTemp2;
        this.bmwId9SettingsSystemTime = bmwId9SettingsSystemTime2;
        this.bmwId9SettingsSystemVideo = bmwId9SettingsSystemVideo2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBmwId9SettingsSystemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsSystemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBmwId9SettingsSystemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_system_layout, root, attachToRoot, component);
    }

    public static ActivityBmwId9SettingsSystemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsSystemLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBmwId9SettingsSystemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_system_layout, null, false, component);
    }

    public static ActivityBmwId9SettingsSystemLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsSystemLayoutBinding bind(View view, Object component) {
        return (ActivityBmwId9SettingsSystemLayoutBinding) bind(component, view, R.layout.activity_bmw_id9_settings_system_layout);
    }
}
