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
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class BenzMbuxSettingsSystemTempLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RelativeLayout mbuxSettingsSystemTempC;
    public final RelativeLayout mbuxSettingsSystemTempF;
    public final LinearLayout mbuxSettingsSystemTempLay;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsSystemTempLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout mbuxSettingsSystemTempC2, RelativeLayout mbuxSettingsSystemTempF2, LinearLayout mbuxSettingsSystemTempLay2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsSystemTempC = mbuxSettingsSystemTempC2;
        this.mbuxSettingsSystemTempF = mbuxSettingsSystemTempF2;
        this.mbuxSettingsSystemTempLay = mbuxSettingsSystemTempLay2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsSystemTempLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemTempLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsSystemTempLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_temp_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsSystemTempLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemTempLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsSystemTempLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_temp_layout, null, false, component);
    }

    public static BenzMbuxSettingsSystemTempLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemTempLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsSystemTempLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_system_temp_layout);
    }
}
