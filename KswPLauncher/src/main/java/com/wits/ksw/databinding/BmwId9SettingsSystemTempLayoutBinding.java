package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class BmwId9SettingsSystemTempLayoutBinding extends ViewDataBinding {
    public final RelativeLayout bmwId9SettingsSystemTempC;
    public final RelativeLayout bmwId9SettingsSystemTempF;
    public final LinearLayout bmwId9SettingsSystemTempLay;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsSystemTempLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout bmwId9SettingsSystemTempC2, RelativeLayout bmwId9SettingsSystemTempF2, LinearLayout bmwId9SettingsSystemTempLay2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsSystemTempC = bmwId9SettingsSystemTempC2;
        this.bmwId9SettingsSystemTempF = bmwId9SettingsSystemTempF2;
        this.bmwId9SettingsSystemTempLay = bmwId9SettingsSystemTempLay2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsSystemTempLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemTempLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsSystemTempLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_temp_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsSystemTempLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemTempLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsSystemTempLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_temp_layout, null, false, component);
    }

    public static BmwId9SettingsSystemTempLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemTempLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsSystemTempLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_system_temp_layout);
    }
}
