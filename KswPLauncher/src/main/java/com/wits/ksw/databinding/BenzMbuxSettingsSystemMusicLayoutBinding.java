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

public abstract class BenzMbuxSettingsSystemMusicLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RecyclerView mbuxSettingsMusicRecycle;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsSystemMusicLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView mbuxSettingsMusicRecycle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsMusicRecycle = mbuxSettingsMusicRecycle2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsSystemMusicLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemMusicLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsSystemMusicLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_music_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsSystemMusicLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemMusicLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsSystemMusicLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_music_layout, null, false, component);
    }

    public static BenzMbuxSettingsSystemMusicLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemMusicLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsSystemMusicLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_system_music_layout);
    }
}
