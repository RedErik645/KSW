package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class BmwId9SettingsSystemTimeLayoutBinding extends ViewDataBinding {
    public final LinearLayout bmwId9SettingsSystemTimeLay;
    public final RadioButton bmwId9SettingsTimeAndroid;
    public final RadioButton bmwId9SettingsTimeCar;
    public final RadioGroup bmwId9SettingsTimeFormat;
    public final RadioGroup bmwId9SettingsTimeSync;
    public final RadioButton bmwId9TimeFormat12;
    public final RadioButton bmwId9TimeFormat24;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;
    public final TextView timeSystemTitle;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsSystemTimeLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout bmwId9SettingsSystemTimeLay2, RadioButton bmwId9SettingsTimeAndroid2, RadioButton bmwId9SettingsTimeCar2, RadioGroup bmwId9SettingsTimeFormat2, RadioGroup bmwId9SettingsTimeSync2, RadioButton bmwId9TimeFormat122, RadioButton bmwId9TimeFormat242, TextView timeSystemTitle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsSystemTimeLay = bmwId9SettingsSystemTimeLay2;
        this.bmwId9SettingsTimeAndroid = bmwId9SettingsTimeAndroid2;
        this.bmwId9SettingsTimeCar = bmwId9SettingsTimeCar2;
        this.bmwId9SettingsTimeFormat = bmwId9SettingsTimeFormat2;
        this.bmwId9SettingsTimeSync = bmwId9SettingsTimeSync2;
        this.bmwId9TimeFormat12 = bmwId9TimeFormat122;
        this.bmwId9TimeFormat24 = bmwId9TimeFormat242;
        this.timeSystemTitle = timeSystemTitle2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsSystemTimeLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemTimeLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsSystemTimeLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_time_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsSystemTimeLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemTimeLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsSystemTimeLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_time_layout, null, false, component);
    }

    public static BmwId9SettingsSystemTimeLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemTimeLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsSystemTimeLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_system_time_layout);
    }
}
