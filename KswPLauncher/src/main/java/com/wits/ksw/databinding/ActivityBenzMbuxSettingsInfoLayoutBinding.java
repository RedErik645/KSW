package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class ActivityBenzMbuxSettingsInfoLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RelativeLayout mbuxInfoCpu;
    public final RelativeLayout mbuxInfoMcuUpgrade;
    public final RelativeLayout mbuxInfoMcuVer;
    public final RelativeLayout mbuxInfoSystemRecovery;
    public final RelativeLayout mbuxInfoSystemUpdate;
    public final RelativeLayout mbuxInfoSystemVersion;
    public final ScrollView mbuxSettingsInfoLay;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected ActivityBenzMbuxSettingsInfoLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout mbuxInfoCpu2, RelativeLayout mbuxInfoMcuUpgrade2, RelativeLayout mbuxInfoMcuVer2, RelativeLayout mbuxInfoSystemRecovery2, RelativeLayout mbuxInfoSystemUpdate2, RelativeLayout mbuxInfoSystemVersion2, ScrollView mbuxSettingsInfoLay2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxInfoCpu = mbuxInfoCpu2;
        this.mbuxInfoMcuUpgrade = mbuxInfoMcuUpgrade2;
        this.mbuxInfoMcuVer = mbuxInfoMcuVer2;
        this.mbuxInfoSystemRecovery = mbuxInfoSystemRecovery2;
        this.mbuxInfoSystemUpdate = mbuxInfoSystemUpdate2;
        this.mbuxInfoSystemVersion = mbuxInfoSystemVersion2;
        this.mbuxSettingsInfoLay = mbuxSettingsInfoLay2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBenzMbuxSettingsInfoLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsInfoLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBenzMbuxSettingsInfoLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_info_layout, root, attachToRoot, component);
    }

    public static ActivityBenzMbuxSettingsInfoLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsInfoLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBenzMbuxSettingsInfoLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_info_layout, null, false, component);
    }

    public static ActivityBenzMbuxSettingsInfoLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsInfoLayoutBinding bind(View view, Object component) {
        return (ActivityBenzMbuxSettingsInfoLayoutBinding) bind(component, view, R.layout.activity_benz_mbux_settings_info_layout);
    }
}
