package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class ActivityBmwId9SettingsNaviLayoutBinding extends ViewDataBinding {
    public final ImageView bmwId8SettingsHomeback;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;
    public final RecyclerView naviRecycle;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected ActivityBmwId9SettingsNaviLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView bmwId8SettingsHomeback2, RecyclerView naviRecycle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId8SettingsHomeback = bmwId8SettingsHomeback2;
        this.naviRecycle = naviRecycle2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBmwId9SettingsNaviLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsNaviLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBmwId9SettingsNaviLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_navi_layout, root, attachToRoot, component);
    }

    public static ActivityBmwId9SettingsNaviLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsNaviLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBmwId9SettingsNaviLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_navi_layout, null, false, component);
    }

    public static ActivityBmwId9SettingsNaviLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsNaviLayoutBinding bind(View view, Object component) {
        return (ActivityBmwId9SettingsNaviLayoutBinding) bind(component, view, R.layout.activity_bmw_id9_settings_navi_layout);
    }
}
