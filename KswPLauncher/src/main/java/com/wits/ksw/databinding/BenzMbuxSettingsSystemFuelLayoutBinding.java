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

public abstract class BenzMbuxSettingsSystemFuelLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RelativeLayout mbuxSettingsSystemFuelL;
    public final LinearLayout mbuxSettingsSystemFuelLay;
    public final RelativeLayout mbuxSettingsSystemFuelUk;
    public final RelativeLayout mbuxSettingsSystemFuelUs;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsSystemFuelLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout mbuxSettingsSystemFuelL2, LinearLayout mbuxSettingsSystemFuelLay2, RelativeLayout mbuxSettingsSystemFuelUk2, RelativeLayout mbuxSettingsSystemFuelUs2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsSystemFuelL = mbuxSettingsSystemFuelL2;
        this.mbuxSettingsSystemFuelLay = mbuxSettingsSystemFuelLay2;
        this.mbuxSettingsSystemFuelUk = mbuxSettingsSystemFuelUk2;
        this.mbuxSettingsSystemFuelUs = mbuxSettingsSystemFuelUs2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsSystemFuelLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemFuelLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsSystemFuelLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_fuel_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsSystemFuelLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemFuelLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsSystemFuelLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_fuel_layout, null, false, component);
    }

    public static BenzMbuxSettingsSystemFuelLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemFuelLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsSystemFuelLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_system_fuel_layout);
    }
}
