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
import com.wits.ksw.settings.bmw_id8.vm.BmwId8SettingsViewModel;

public abstract class BmwPempId8SettingsMainLayoutBinding extends ViewDataBinding {
    public final Id8PempLauncherLeftBarBinding bmwId8SettingsMainLeftBar;
    public final RecyclerView bmwId8SettingsMainRecycle;
    @Bindable
    protected LauncherViewModel mLauncherViewModel;
    @Bindable
    protected BmwId8SettingsViewModel mViewModel;

    public abstract void setLauncherViewModel(LauncherViewModel launcherViewModel);

    public abstract void setViewModel(BmwId8SettingsViewModel bmwId8SettingsViewModel);

    protected BmwPempId8SettingsMainLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, Id8PempLauncherLeftBarBinding bmwId8SettingsMainLeftBar2, RecyclerView bmwId8SettingsMainRecycle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId8SettingsMainLeftBar = bmwId8SettingsMainLeftBar2;
        this.bmwId8SettingsMainRecycle = bmwId8SettingsMainRecycle2;
    }

    public LauncherViewModel getLauncherViewModel() {
        return this.mLauncherViewModel;
    }

    public BmwId8SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwPempId8SettingsMainLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwPempId8SettingsMainLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwPempId8SettingsMainLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_pemp_id8_settings_main_layout, root, attachToRoot, component);
    }

    public static BmwPempId8SettingsMainLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwPempId8SettingsMainLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwPempId8SettingsMainLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_pemp_id8_settings_main_layout, null, false, component);
    }

    public static BmwPempId8SettingsMainLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwPempId8SettingsMainLayoutBinding bind(View view, Object component) {
        return (BmwPempId8SettingsMainLayoutBinding) bind(component, view, R.layout.bmw_pemp_id8_settings_main_layout);
    }
}
