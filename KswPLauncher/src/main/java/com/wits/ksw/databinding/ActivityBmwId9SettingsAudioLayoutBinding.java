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
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class ActivityBmwId9SettingsAudioLayoutBinding extends ViewDataBinding {
    public final ImageView bmwId8SettingsHomeback;
    public final RelativeLayout bmwId9SettingsAudioAndroidItem;
    public final FrameLayout bmwId9SettingsAudioFramelay;
    public final LinearLayout bmwId9SettingsAudioLay;
    public final RelativeLayout bmwId9SettingsAudioOemItem;
    public final RelativeLayout bmwId9SettingsAudioSoundItem;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected ActivityBmwId9SettingsAudioLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView bmwId8SettingsHomeback2, RelativeLayout bmwId9SettingsAudioAndroidItem2, FrameLayout bmwId9SettingsAudioFramelay2, LinearLayout bmwId9SettingsAudioLay2, RelativeLayout bmwId9SettingsAudioOemItem2, RelativeLayout bmwId9SettingsAudioSoundItem2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId8SettingsHomeback = bmwId8SettingsHomeback2;
        this.bmwId9SettingsAudioAndroidItem = bmwId9SettingsAudioAndroidItem2;
        this.bmwId9SettingsAudioFramelay = bmwId9SettingsAudioFramelay2;
        this.bmwId9SettingsAudioLay = bmwId9SettingsAudioLay2;
        this.bmwId9SettingsAudioOemItem = bmwId9SettingsAudioOemItem2;
        this.bmwId9SettingsAudioSoundItem = bmwId9SettingsAudioSoundItem2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBmwId9SettingsAudioLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsAudioLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBmwId9SettingsAudioLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_audio_layout, root, attachToRoot, component);
    }

    public static ActivityBmwId9SettingsAudioLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsAudioLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBmwId9SettingsAudioLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_audio_layout, null, false, component);
    }

    public static ActivityBmwId9SettingsAudioLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsAudioLayoutBinding bind(View view, Object component) {
        return (ActivityBmwId9SettingsAudioLayoutBinding) bind(component, view, R.layout.activity_bmw_id9_settings_audio_layout);
    }
}
