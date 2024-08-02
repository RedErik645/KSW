package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class BmwId9SettingsAudioAndroidLayoutBinding extends ViewDataBinding {
    public final ImageButton bmwId9SettingsAndroidCallAddBtn;
    public final BmwId9ProgressBar bmwId9SettingsAndroidCallSeekbar;
    public final ImageButton bmwId9SettingsAndroidCallSubBtn;
    public final LinearLayout bmwId9SettingsAudioAndroidLay;
    public final ImageButton bmwId9SettingsMeidaAddBtn;
    public final BmwId9ProgressBar bmwId9SettingsMeidaSeekbar;
    public final ImageButton bmwId9SettingsMeidaSubBtn;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsAudioAndroidLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageButton bmwId9SettingsAndroidCallAddBtn2, BmwId9ProgressBar bmwId9SettingsAndroidCallSeekbar2, ImageButton bmwId9SettingsAndroidCallSubBtn2, LinearLayout bmwId9SettingsAudioAndroidLay2, ImageButton bmwId9SettingsMeidaAddBtn2, BmwId9ProgressBar bmwId9SettingsMeidaSeekbar2, ImageButton bmwId9SettingsMeidaSubBtn2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsAndroidCallAddBtn = bmwId9SettingsAndroidCallAddBtn2;
        this.bmwId9SettingsAndroidCallSeekbar = bmwId9SettingsAndroidCallSeekbar2;
        this.bmwId9SettingsAndroidCallSubBtn = bmwId9SettingsAndroidCallSubBtn2;
        this.bmwId9SettingsAudioAndroidLay = bmwId9SettingsAudioAndroidLay2;
        this.bmwId9SettingsMeidaAddBtn = bmwId9SettingsMeidaAddBtn2;
        this.bmwId9SettingsMeidaSeekbar = bmwId9SettingsMeidaSeekbar2;
        this.bmwId9SettingsMeidaSubBtn = bmwId9SettingsMeidaSubBtn2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsAudioAndroidLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsAudioAndroidLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsAudioAndroidLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_audio_android_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsAudioAndroidLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsAudioAndroidLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsAudioAndroidLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_audio_android_layout, null, false, component);
    }

    public static BmwId9SettingsAudioAndroidLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsAudioAndroidLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsAudioAndroidLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_audio_android_layout);
    }
}
