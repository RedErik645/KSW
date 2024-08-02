package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class ActivityBenzMbuxSettingsMainBinding extends ViewDataBinding {
    public final RecyclerView benzSettingsMainRecycle;
    @Bindable
    protected LauncherViewModel mLauncherViewModel;
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;

    public abstract void setLauncherViewModel(LauncherViewModel launcherViewModel);

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected ActivityBenzMbuxSettingsMainBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView benzSettingsMainRecycle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.benzSettingsMainRecycle = benzSettingsMainRecycle2;
    }

    public LauncherViewModel getLauncherViewModel() {
        return this.mLauncherViewModel;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBenzMbuxSettingsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBenzMbuxSettingsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_main, root, attachToRoot, component);
    }

    public static ActivityBenzMbuxSettingsMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBenzMbuxSettingsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_main, null, false, component);
    }

    public static ActivityBenzMbuxSettingsMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsMainBinding bind(View view, Object component) {
        return (ActivityBenzMbuxSettingsMainBinding) bind(component, view, R.layout.activity_benz_mbux_settings_main);
    }
}
