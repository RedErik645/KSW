package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class BmwId9SettingsSystemVideoLayoutBinding extends ViewDataBinding {
    public final RecyclerView bmwId9SettingsVideoRecycle;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsSystemVideoLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView bmwId9SettingsVideoRecycle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsVideoRecycle = bmwId9SettingsVideoRecycle2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsSystemVideoLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemVideoLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsSystemVideoLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_video_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsSystemVideoLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemVideoLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsSystemVideoLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_video_layout, null, false, component);
    }

    public static BmwId9SettingsSystemVideoLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemVideoLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsSystemVideoLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_system_video_layout);
    }
}
