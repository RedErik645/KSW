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

public abstract class ViewId9MainSettingsTimeBinding extends ViewDataBinding {
    public final RadioButton bmwId8SettingsTime12;
    public final RadioButton bmwId8SettingsTime24;
    public final RadioButton bmwId8SettingsTimeAndroid;
    public final RadioButton bmwId8SettingsTimeCar;
    public final RadioGroup id9SettingsTimeFormatRg;
    public final RadioGroup id9SettingsTimeRg;
    public final TextView id9SettingsTimeTitle;
    public final TextView id9SettingsTimeTitleFormat;
    @Bindable
    protected Id9AlsConstants mID9Constants;
    @Bindable
    protected BmwId8SettingsViewModel mViewModel;

    public abstract void setID9Constants(Id9AlsConstants id9AlsConstants);

    public abstract void setViewModel(BmwId8SettingsViewModel bmwId8SettingsViewModel);

    protected ViewId9MainSettingsTimeBinding(Object _bindingComponent, View _root, int _localFieldCount, RadioButton bmwId8SettingsTime122, RadioButton bmwId8SettingsTime242, RadioButton bmwId8SettingsTimeAndroid2, RadioButton bmwId8SettingsTimeCar2, RadioGroup id9SettingsTimeFormatRg2, RadioGroup id9SettingsTimeRg2, TextView id9SettingsTimeTitle2, TextView id9SettingsTimeTitleFormat2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId8SettingsTime12 = bmwId8SettingsTime122;
        this.bmwId8SettingsTime24 = bmwId8SettingsTime242;
        this.bmwId8SettingsTimeAndroid = bmwId8SettingsTimeAndroid2;
        this.bmwId8SettingsTimeCar = bmwId8SettingsTimeCar2;
        this.id9SettingsTimeFormatRg = id9SettingsTimeFormatRg2;
        this.id9SettingsTimeRg = id9SettingsTimeRg2;
        this.id9SettingsTimeTitle = id9SettingsTimeTitle2;
        this.id9SettingsTimeTitleFormat = id9SettingsTimeTitleFormat2;
    }

    public Id9AlsConstants getID9Constants() {
        return this.mID9Constants;
    }

    public BmwId8SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ViewId9MainSettingsTimeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9MainSettingsTimeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewId9MainSettingsTimeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_main_settings_time, root, attachToRoot, component);
    }

    public static ViewId9MainSettingsTimeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9MainSettingsTimeBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewId9MainSettingsTimeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_main_settings_time, null, false, component);
    }

    public static ViewId9MainSettingsTimeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9MainSettingsTimeBinding bind(View view, Object component) {
        return (ViewId9MainSettingsTimeBinding) bind(component, view, R.layout.view_id9_main_settings_time);
    }
}
