package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.settings.bmw_id8.vm.BmwId8SettingsViewModel;

public abstract class ViewId9MainSettingsCameraBinding extends ViewDataBinding {
    public final RadioButton bmwId8SettingsSystemCamera360;
    public final RadioButton bmwId8SettingsSystemCamera360Built;
    public final RadioButton bmwId8SettingsSystemCameraAfter;
    public final RadioButton bmwId8SettingsSystemCameraOem;
    public final RadioGroup id9SettingsTimeRg;
    public final TextView id9SettingsUnitTitle;
    @Bindable
    protected Id9AlsConstants mID9Constants;
    @Bindable
    protected BmwId8SettingsViewModel mViewModel;

    public abstract void setID9Constants(Id9AlsConstants id9AlsConstants);

    public abstract void setViewModel(BmwId8SettingsViewModel bmwId8SettingsViewModel);

    protected ViewId9MainSettingsCameraBinding(Object _bindingComponent, View _root, int _localFieldCount, RadioButton bmwId8SettingsSystemCamera3602, RadioButton bmwId8SettingsSystemCamera360Built2, RadioButton bmwId8SettingsSystemCameraAfter2, RadioButton bmwId8SettingsSystemCameraOem2, RadioGroup id9SettingsTimeRg2, TextView id9SettingsUnitTitle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId8SettingsSystemCamera360 = bmwId8SettingsSystemCamera3602;
        this.bmwId8SettingsSystemCamera360Built = bmwId8SettingsSystemCamera360Built2;
        this.bmwId8SettingsSystemCameraAfter = bmwId8SettingsSystemCameraAfter2;
        this.bmwId8SettingsSystemCameraOem = bmwId8SettingsSystemCameraOem2;
        this.id9SettingsTimeRg = id9SettingsTimeRg2;
        this.id9SettingsUnitTitle = id9SettingsUnitTitle2;
    }

    public Id9AlsConstants getID9Constants() {
        return this.mID9Constants;
    }

    public BmwId8SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ViewId9MainSettingsCameraBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9MainSettingsCameraBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewId9MainSettingsCameraBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_main_settings_camera, root, attachToRoot, component);
    }

    public static ViewId9MainSettingsCameraBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9MainSettingsCameraBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewId9MainSettingsCameraBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_main_settings_camera, null, false, component);
    }

    public static ViewId9MainSettingsCameraBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9MainSettingsCameraBinding bind(View view, Object component) {
        return (ViewId9MainSettingsCameraBinding) bind(component, view, R.layout.view_id9_main_settings_camera);
    }
}
