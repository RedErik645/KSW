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

public abstract class ViewId9MainSettingsUnitBinding extends ViewDataBinding {
    public final RadioButton bmwId8SettingsSystemFuelL;
    public final RadioButton bmwId8SettingsSystemFuelUk;
    public final RadioButton bmwId8SettingsSystemFuelUs;
    public final RadioButton bmwId8SettingsSystemTempC;
    public final RadioButton bmwId8SettingsSystemTempF;
    public final TextView id9SettingsTempTitle;
    public final RadioGroup id9SettingsTimeFormatRg;
    public final RadioGroup id9SettingsTimeRg;
    public final TextView id9SettingsUnitTitle;
    @Bindable
    protected Id9AlsConstants mID9Constants;
    @Bindable
    protected BmwId8SettingsViewModel mViewModel;

    public abstract void setID9Constants(Id9AlsConstants id9AlsConstants);

    public abstract void setViewModel(BmwId8SettingsViewModel bmwId8SettingsViewModel);

    protected ViewId9MainSettingsUnitBinding(Object _bindingComponent, View _root, int _localFieldCount, RadioButton bmwId8SettingsSystemFuelL2, RadioButton bmwId8SettingsSystemFuelUk2, RadioButton bmwId8SettingsSystemFuelUs2, RadioButton bmwId8SettingsSystemTempC2, RadioButton bmwId8SettingsSystemTempF2, TextView id9SettingsTempTitle2, RadioGroup id9SettingsTimeFormatRg2, RadioGroup id9SettingsTimeRg2, TextView id9SettingsUnitTitle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId8SettingsSystemFuelL = bmwId8SettingsSystemFuelL2;
        this.bmwId8SettingsSystemFuelUk = bmwId8SettingsSystemFuelUk2;
        this.bmwId8SettingsSystemFuelUs = bmwId8SettingsSystemFuelUs2;
        this.bmwId8SettingsSystemTempC = bmwId8SettingsSystemTempC2;
        this.bmwId8SettingsSystemTempF = bmwId8SettingsSystemTempF2;
        this.id9SettingsTempTitle = id9SettingsTempTitle2;
        this.id9SettingsTimeFormatRg = id9SettingsTimeFormatRg2;
        this.id9SettingsTimeRg = id9SettingsTimeRg2;
        this.id9SettingsUnitTitle = id9SettingsUnitTitle2;
    }

    public Id9AlsConstants getID9Constants() {
        return this.mID9Constants;
    }

    public BmwId8SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ViewId9MainSettingsUnitBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9MainSettingsUnitBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewId9MainSettingsUnitBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_main_settings_unit, root, attachToRoot, component);
    }

    public static ViewId9MainSettingsUnitBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9MainSettingsUnitBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewId9MainSettingsUnitBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_main_settings_unit, null, false, component);
    }

    public static ViewId9MainSettingsUnitBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9MainSettingsUnitBinding bind(View view, Object component) {
        return (ViewId9MainSettingsUnitBinding) bind(component, view, R.layout.view_id9_main_settings_unit);
    }
}
