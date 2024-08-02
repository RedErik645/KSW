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
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class BenzMbuxSettingsSystemTimeLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final LinearLayout mbuxSettingsSystemTimeLay;
    public final RadioButton mbuxSettingsTimeAndroid;
    public final RadioButton mbuxSettingsTimeCar;
    public final RadioGroup mbuxSettingsTimeFormat;
    public final RadioGroup mbuxSettingsTimeSync;
    public final RadioButton mbuxTimeFormat12;
    public final RadioButton mbuxTimeFormat24;
    public final TextView timeSystemTitle;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsSystemTimeLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout mbuxSettingsSystemTimeLay2, RadioButton mbuxSettingsTimeAndroid2, RadioButton mbuxSettingsTimeCar2, RadioGroup mbuxSettingsTimeFormat2, RadioGroup mbuxSettingsTimeSync2, RadioButton mbuxTimeFormat122, RadioButton mbuxTimeFormat242, TextView timeSystemTitle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsSystemTimeLay = mbuxSettingsSystemTimeLay2;
        this.mbuxSettingsTimeAndroid = mbuxSettingsTimeAndroid2;
        this.mbuxSettingsTimeCar = mbuxSettingsTimeCar2;
        this.mbuxSettingsTimeFormat = mbuxSettingsTimeFormat2;
        this.mbuxSettingsTimeSync = mbuxSettingsTimeSync2;
        this.mbuxTimeFormat12 = mbuxTimeFormat122;
        this.mbuxTimeFormat24 = mbuxTimeFormat242;
        this.timeSystemTitle = timeSystemTitle2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsSystemTimeLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemTimeLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsSystemTimeLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_time_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsSystemTimeLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemTimeLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsSystemTimeLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_time_layout, null, false, component);
    }

    public static BenzMbuxSettingsSystemTimeLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemTimeLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsSystemTimeLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_system_time_layout);
    }
}
