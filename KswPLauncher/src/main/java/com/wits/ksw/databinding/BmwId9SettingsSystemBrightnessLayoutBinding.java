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
import com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class BmwId9SettingsSystemBrightnessLayoutBinding extends ViewDataBinding {
    public final ImageButton bmwId9SettingsBrightnessAddBtn;
    public final LinearLayout bmwId9SettingsBrightnessLay;
    public final BmwId9ProgressBar bmwId9SettingsBrightnessSeekbar;
    public final ImageButton bmwId9SettingsBrightnessSubBtn;
    public final TextView bmwId9SettingsBrightnessText;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsSystemBrightnessLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageButton bmwId9SettingsBrightnessAddBtn2, LinearLayout bmwId9SettingsBrightnessLay2, BmwId9ProgressBar bmwId9SettingsBrightnessSeekbar2, ImageButton bmwId9SettingsBrightnessSubBtn2, TextView bmwId9SettingsBrightnessText2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsBrightnessAddBtn = bmwId9SettingsBrightnessAddBtn2;
        this.bmwId9SettingsBrightnessLay = bmwId9SettingsBrightnessLay2;
        this.bmwId9SettingsBrightnessSeekbar = bmwId9SettingsBrightnessSeekbar2;
        this.bmwId9SettingsBrightnessSubBtn = bmwId9SettingsBrightnessSubBtn2;
        this.bmwId9SettingsBrightnessText = bmwId9SettingsBrightnessText2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsSystemBrightnessLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemBrightnessLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsSystemBrightnessLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_brightness_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsSystemBrightnessLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemBrightnessLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsSystemBrightnessLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_brightness_layout, null, false, component);
    }

    public static BmwId9SettingsSystemBrightnessLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemBrightnessLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsSystemBrightnessLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_system_brightness_layout);
    }
}
