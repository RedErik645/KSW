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

public abstract class BmwId9SettingsSystemMusicLayoutBinding extends ViewDataBinding {
    public final RecyclerView bmwId9SettingsMusicRecycle;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsSystemMusicLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView bmwId9SettingsMusicRecycle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsMusicRecycle = bmwId9SettingsMusicRecycle2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsSystemMusicLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemMusicLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsSystemMusicLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_music_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsSystemMusicLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemMusicLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsSystemMusicLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_system_music_layout, null, false, component);
    }

    public static BmwId9SettingsSystemMusicLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsSystemMusicLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsSystemMusicLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_system_music_layout);
    }
}
