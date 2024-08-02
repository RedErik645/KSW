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

public abstract class BmwId9SettingsSystemFuelLayoutBinding extends ViewDataBinding {
    public final RelativeLayout bmwId9SettingsSystemFuelL;
    public final LinearLayout bmwId9SettingsSystemFuelLay;
    public final RelativeLayout bmwId9SettingsSystemFuelUk;
    public final RelativeLayout bmwId9SettingsSystemFuelUs;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsSystemFuelLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout bmwId9SettingsSystemFuelL2, LinearLayout bmwId9SettingsSystemFuelLay2, RelativeLayout bmwId9SettingsSystemFuelUk2, RelativeLayout bmwId9SettingsSystemFuelUs2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsSystemFuelL = bmwId9SettingsSystemFuelL2;
        this.bmwId9SettingsSystemFuelLay = bmwId9SettingsSystemFuelLay2;
        this.bmwId9SettingsSystemFuelUk = bmwId9SettingsSystemFuelUk2;
        this.bmwId9SettingsSystemFuelUs = bmwId9SettingsSystemFuelUs2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsSystemFuelLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemFuelLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsSystemFuelLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_fuel_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsSystemFuelLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemFuelLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsSystemFuelLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_fuel_layout, null, false, component);
    }

    public static BmwId9SettingsSystemFuelLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemFuelLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsSystemFuelLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_system_fuel_layout);
    }
}
