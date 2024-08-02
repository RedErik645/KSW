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
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class BenzMbuxSettingsAudioAndroidLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final ImageButton mbuxSettingsAndroidCallAddBtn;
    public final BenzMbuxProgressBar mbuxSettingsAndroidCallSeekbar;
    public final ImageButton mbuxSettingsAndroidCallSubBtn;
    public final LinearLayout mbuxSettingsAudioAndroidLay;
    public final ImageButton mbuxSettingsMeidaAddBtn;
    public final BenzMbuxProgressBar mbuxSettingsMeidaSeekbar;
    public final ImageButton mbuxSettingsMeidaSubBtn;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsAudioAndroidLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageButton mbuxSettingsAndroidCallAddBtn2, BenzMbuxProgressBar mbuxSettingsAndroidCallSeekbar2, ImageButton mbuxSettingsAndroidCallSubBtn2, LinearLayout mbuxSettingsAudioAndroidLay2, ImageButton mbuxSettingsMeidaAddBtn2, BenzMbuxProgressBar mbuxSettingsMeidaSeekbar2, ImageButton mbuxSettingsMeidaSubBtn2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsAndroidCallAddBtn = mbuxSettingsAndroidCallAddBtn2;
        this.mbuxSettingsAndroidCallSeekbar = mbuxSettingsAndroidCallSeekbar2;
        this.mbuxSettingsAndroidCallSubBtn = mbuxSettingsAndroidCallSubBtn2;
        this.mbuxSettingsAudioAndroidLay = mbuxSettingsAudioAndroidLay2;
        this.mbuxSettingsMeidaAddBtn = mbuxSettingsMeidaAddBtn2;
        this.mbuxSettingsMeidaSeekbar = mbuxSettingsMeidaSeekbar2;
        this.mbuxSettingsMeidaSubBtn = mbuxSettingsMeidaSubBtn2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsAudioAndroidLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsAudioAndroidLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsAudioAndroidLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_audio_android_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsAudioAndroidLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsAudioAndroidLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsAudioAndroidLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_audio_android_layout, null, false, component);
    }

    public static BenzMbuxSettingsAudioAndroidLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsAudioAndroidLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsAudioAndroidLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_audio_android_layout);
    }
}
