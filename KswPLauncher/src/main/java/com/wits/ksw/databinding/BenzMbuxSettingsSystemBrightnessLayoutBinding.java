package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class BenzMbuxSettingsSystemBrightnessLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final ImageButton mbuxSettingsBrightnessAddBtn;
    public final LinearLayout mbuxSettingsBrightnessLay;
    public final BenzMbuxProgressBar mbuxSettingsBrightnessSeekbar;
    public final ImageButton mbuxSettingsBrightnessSubBtn;
    public final TextView mbuxSettingsBrightnessText;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsSystemBrightnessLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageButton mbuxSettingsBrightnessAddBtn2, LinearLayout mbuxSettingsBrightnessLay2, BenzMbuxProgressBar mbuxSettingsBrightnessSeekbar2, ImageButton mbuxSettingsBrightnessSubBtn2, TextView mbuxSettingsBrightnessText2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsBrightnessAddBtn = mbuxSettingsBrightnessAddBtn2;
        this.mbuxSettingsBrightnessLay = mbuxSettingsBrightnessLay2;
        this.mbuxSettingsBrightnessSeekbar = mbuxSettingsBrightnessSeekbar2;
        this.mbuxSettingsBrightnessSubBtn = mbuxSettingsBrightnessSubBtn2;
        this.mbuxSettingsBrightnessText = mbuxSettingsBrightnessText2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsSystemBrightnessLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemBrightnessLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsSystemBrightnessLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_brightness_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsSystemBrightnessLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemBrightnessLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsSystemBrightnessLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_brightness_layout, null, false, component);
    }

    public static BenzMbuxSettingsSystemBrightnessLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemBrightnessLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsSystemBrightnessLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_system_brightness_layout);
    }
}
