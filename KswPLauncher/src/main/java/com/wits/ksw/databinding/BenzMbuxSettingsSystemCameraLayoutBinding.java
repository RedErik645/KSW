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

public abstract class BenzMbuxSettingsSystemCameraLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RelativeLayout mbuxSettingsSystemCamera360;
    public final RelativeLayout mbuxSettingsSystemCamera360Built;
    public final RelativeLayout mbuxSettingsSystemCameraAfter;
    public final LinearLayout mbuxSettingsSystemCameraLay;
    public final RelativeLayout mbuxSettingsSystemCameraOem;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsSystemCameraLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout mbuxSettingsSystemCamera3602, RelativeLayout mbuxSettingsSystemCamera360Built2, RelativeLayout mbuxSettingsSystemCameraAfter2, LinearLayout mbuxSettingsSystemCameraLay2, RelativeLayout mbuxSettingsSystemCameraOem2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsSystemCamera360 = mbuxSettingsSystemCamera3602;
        this.mbuxSettingsSystemCamera360Built = mbuxSettingsSystemCamera360Built2;
        this.mbuxSettingsSystemCameraAfter = mbuxSettingsSystemCameraAfter2;
        this.mbuxSettingsSystemCameraLay = mbuxSettingsSystemCameraLay2;
        this.mbuxSettingsSystemCameraOem = mbuxSettingsSystemCameraOem2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsSystemCameraLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemCameraLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsSystemCameraLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_camera_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsSystemCameraLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemCameraLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsSystemCameraLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_camera_layout, null, false, component);
    }

    public static BenzMbuxSettingsSystemCameraLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemCameraLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsSystemCameraLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_system_camera_layout);
    }
}
