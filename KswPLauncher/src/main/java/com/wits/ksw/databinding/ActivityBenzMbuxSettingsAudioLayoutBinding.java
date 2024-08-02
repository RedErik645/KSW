package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class ActivityBenzMbuxSettingsAudioLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RelativeLayout mbuxSettingsAudioAndroidItem;
    public final FrameLayout mbuxSettingsAudioFramelay;
    public final ImageView mbuxSettingsAudioImg;
    public final LinearLayout mbuxSettingsAudioLay;
    public final RelativeLayout mbuxSettingsAudioOemItem;
    public final RelativeLayout mbuxSettingsAudioSoundItem;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected ActivityBenzMbuxSettingsAudioLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout mbuxSettingsAudioAndroidItem2, FrameLayout mbuxSettingsAudioFramelay2, ImageView mbuxSettingsAudioImg2, LinearLayout mbuxSettingsAudioLay2, RelativeLayout mbuxSettingsAudioOemItem2, RelativeLayout mbuxSettingsAudioSoundItem2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsAudioAndroidItem = mbuxSettingsAudioAndroidItem2;
        this.mbuxSettingsAudioFramelay = mbuxSettingsAudioFramelay2;
        this.mbuxSettingsAudioImg = mbuxSettingsAudioImg2;
        this.mbuxSettingsAudioLay = mbuxSettingsAudioLay2;
        this.mbuxSettingsAudioOemItem = mbuxSettingsAudioOemItem2;
        this.mbuxSettingsAudioSoundItem = mbuxSettingsAudioSoundItem2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBenzMbuxSettingsAudioLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsAudioLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBenzMbuxSettingsAudioLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_audio_layout, root, attachToRoot, component);
    }

    public static ActivityBenzMbuxSettingsAudioLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsAudioLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBenzMbuxSettingsAudioLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_audio_layout, null, false, component);
    }

    public static ActivityBenzMbuxSettingsAudioLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsAudioLayoutBinding bind(View view, Object component) {
        return (ActivityBenzMbuxSettingsAudioLayoutBinding) bind(component, view, R.layout.activity_benz_mbux_settings_audio_layout);
    }
}
