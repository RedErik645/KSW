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

public abstract class BmwId9SettingsSystemCameraLayoutBinding extends ViewDataBinding {
    public final RelativeLayout bmwId9SettingsSystemCamera360;
    public final RelativeLayout bmwId9SettingsSystemCamera360Built;
    public final RelativeLayout bmwId9SettingsSystemCameraAfter;
    public final LinearLayout bmwId9SettingsSystemCameraLay;
    public final RelativeLayout bmwId9SettingsSystemCameraOem;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsSystemCameraLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout bmwId9SettingsSystemCamera3602, RelativeLayout bmwId9SettingsSystemCamera360Built2, RelativeLayout bmwId9SettingsSystemCameraAfter2, LinearLayout bmwId9SettingsSystemCameraLay2, RelativeLayout bmwId9SettingsSystemCameraOem2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsSystemCamera360 = bmwId9SettingsSystemCamera3602;
        this.bmwId9SettingsSystemCamera360Built = bmwId9SettingsSystemCamera360Built2;
        this.bmwId9SettingsSystemCameraAfter = bmwId9SettingsSystemCameraAfter2;
        this.bmwId9SettingsSystemCameraLay = bmwId9SettingsSystemCameraLay2;
        this.bmwId9SettingsSystemCameraOem = bmwId9SettingsSystemCameraOem2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsSystemCameraLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemCameraLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsSystemCameraLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_camera_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsSystemCameraLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemCameraLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsSystemCameraLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_camera_layout, null, false, component);
    }

    public static BmwId9SettingsSystemCameraLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemCameraLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsSystemCameraLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_system_camera_layout);
    }
}
