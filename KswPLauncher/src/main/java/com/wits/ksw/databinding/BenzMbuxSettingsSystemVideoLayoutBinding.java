package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class BenzMbuxSettingsSystemVideoLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RecyclerView mbuxSettingsVideoRecycle;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsSystemVideoLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView mbuxSettingsVideoRecycle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsVideoRecycle = mbuxSettingsVideoRecycle2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsSystemVideoLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemVideoLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsSystemVideoLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_video_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsSystemVideoLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemVideoLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsSystemVideoLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_video_layout, null, false, component);
    }

    public static BenzMbuxSettingsSystemVideoLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemVideoLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsSystemVideoLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_system_video_layout);
    }
}
