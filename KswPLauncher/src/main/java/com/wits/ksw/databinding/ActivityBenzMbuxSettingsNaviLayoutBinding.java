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

public abstract class ActivityBenzMbuxSettingsNaviLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RecyclerView naviRecycle;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected ActivityBenzMbuxSettingsNaviLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView naviRecycle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.naviRecycle = naviRecycle2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBenzMbuxSettingsNaviLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsNaviLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBenzMbuxSettingsNaviLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_navi_layout, root, attachToRoot, component);
    }

    public static ActivityBenzMbuxSettingsNaviLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsNaviLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBenzMbuxSettingsNaviLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_navi_layout, null, false, component);
    }

    public static ActivityBenzMbuxSettingsNaviLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsNaviLayoutBinding bind(View view, Object component) {
        return (ActivityBenzMbuxSettingsNaviLayoutBinding) bind(component, view, R.layout.activity_benz_mbux_settings_navi_layout);
    }
}
