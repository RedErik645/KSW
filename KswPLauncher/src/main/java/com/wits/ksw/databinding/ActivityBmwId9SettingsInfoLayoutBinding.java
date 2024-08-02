package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class ActivityBmwId9SettingsInfoLayoutBinding extends ViewDataBinding {
    public final ImageView bmwId8SettingsHomeback;
    public final RelativeLayout bmwId9InfoCpu;
    public final RelativeLayout bmwId9InfoMcuUpgrade;
    public final RelativeLayout bmwId9InfoMcuVer;
    public final RelativeLayout bmwId9InfoSystemRecovery;
    public final RelativeLayout bmwId9InfoSystemUpdate;
    public final RelativeLayout bmwId9InfoSystemVersion;
    public final ScrollView bmwId9SettingsInfoLay;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected ActivityBmwId9SettingsInfoLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView bmwId8SettingsHomeback2, RelativeLayout bmwId9InfoCpu2, RelativeLayout bmwId9InfoMcuUpgrade2, RelativeLayout bmwId9InfoMcuVer2, RelativeLayout bmwId9InfoSystemRecovery2, RelativeLayout bmwId9InfoSystemUpdate2, RelativeLayout bmwId9InfoSystemVersion2, ScrollView bmwId9SettingsInfoLay2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId8SettingsHomeback = bmwId8SettingsHomeback2;
        this.bmwId9InfoCpu = bmwId9InfoCpu2;
        this.bmwId9InfoMcuUpgrade = bmwId9InfoMcuUpgrade2;
        this.bmwId9InfoMcuVer = bmwId9InfoMcuVer2;
        this.bmwId9InfoSystemRecovery = bmwId9InfoSystemRecovery2;
        this.bmwId9InfoSystemUpdate = bmwId9InfoSystemUpdate2;
        this.bmwId9InfoSystemVersion = bmwId9InfoSystemVersion2;
        this.bmwId9SettingsInfoLay = bmwId9SettingsInfoLay2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBmwId9SettingsInfoLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsInfoLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBmwId9SettingsInfoLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_info_layout, root, attachToRoot, component);
    }

    public static ActivityBmwId9SettingsInfoLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsInfoLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBmwId9SettingsInfoLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_info_layout, null, false, component);
    }

    public static ActivityBmwId9SettingsInfoLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsInfoLayoutBinding bind(View view, Object component) {
        return (ActivityBmwId9SettingsInfoLayoutBinding) bind(component, view, R.layout.activity_bmw_id9_settings_info_layout);
    }
}
