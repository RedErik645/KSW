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
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class ActivityBmwId9SettingsMainBinding extends ViewDataBinding {
    public final RecyclerView bmwId9SettingsMainRecycle;
    @Bindable
    protected LauncherViewModel mLauncherViewModel;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setLauncherViewModel(LauncherViewModel launcherViewModel);

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected ActivityBmwId9SettingsMainBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView bmwId9SettingsMainRecycle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsMainRecycle = bmwId9SettingsMainRecycle2;
    }

    public LauncherViewModel getLauncherViewModel() {
        return this.mLauncherViewModel;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBmwId9SettingsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBmwId9SettingsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_main, root, attachToRoot, component);
    }

    public static ActivityBmwId9SettingsMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBmwId9SettingsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_main, null, false, component);
    }

    public static ActivityBmwId9SettingsMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsMainBinding bind(View view, Object component) {
        return (ActivityBmwId9SettingsMainBinding) bind(component, view, R.layout.activity_bmw_id9_settings_main);
    }
}
