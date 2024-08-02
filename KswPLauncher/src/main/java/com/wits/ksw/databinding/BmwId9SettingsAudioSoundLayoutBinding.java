package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class BmwId9SettingsAudioSoundLayoutBinding extends ViewDataBinding {
    public final SeekBar bmwId9SettingsAudioLow;
    public final SeekBar bmwId9SettingsAudioMid;
    public final RelativeLayout bmwId9SettingsAudioSoundClass;
    public final RelativeLayout bmwId9SettingsAudioSoundDance;
    public final RelativeLayout bmwId9SettingsAudioSoundJazz;
    public final LinearLayout bmwId9SettingsAudioSoundLay;
    public final RelativeLayout bmwId9SettingsAudioSoundPop;
    public final RelativeLayout bmwId9SettingsAudioSoundRock;
    public final RelativeLayout bmwId9SettingsAudioSoundUser;
    public final SeekBar bmwId9SettingsAudioTre;
    public final ImageButton bmwId9SettingsBassAddBtn;
    public final ImageButton bmwId9SettingsBassSubBtn;
    public final ImageButton bmwId9SettingsMidAddBtn;
    public final ImageButton bmwId9SettingsMidSubBtn;
    public final ImageButton bmwId9SettingsTreAddBtn;
    public final ImageButton bmwId9SettingsTreSubBtn;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsAudioSoundLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, SeekBar bmwId9SettingsAudioLow2, SeekBar bmwId9SettingsAudioMid2, RelativeLayout bmwId9SettingsAudioSoundClass2, RelativeLayout bmwId9SettingsAudioSoundDance2, RelativeLayout bmwId9SettingsAudioSoundJazz2, LinearLayout bmwId9SettingsAudioSoundLay2, RelativeLayout bmwId9SettingsAudioSoundPop2, RelativeLayout bmwId9SettingsAudioSoundRock2, RelativeLayout bmwId9SettingsAudioSoundUser2, SeekBar bmwId9SettingsAudioTre2, ImageButton bmwId9SettingsBassAddBtn2, ImageButton bmwId9SettingsBassSubBtn2, ImageButton bmwId9SettingsMidAddBtn2, ImageButton bmwId9SettingsMidSubBtn2, ImageButton bmwId9SettingsTreAddBtn2, ImageButton bmwId9SettingsTreSubBtn2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsAudioLow = bmwId9SettingsAudioLow2;
        this.bmwId9SettingsAudioMid = bmwId9SettingsAudioMid2;
        this.bmwId9SettingsAudioSoundClass = bmwId9SettingsAudioSoundClass2;
        this.bmwId9SettingsAudioSoundDance = bmwId9SettingsAudioSoundDance2;
        this.bmwId9SettingsAudioSoundJazz = bmwId9SettingsAudioSoundJazz2;
        this.bmwId9SettingsAudioSoundLay = bmwId9SettingsAudioSoundLay2;
        this.bmwId9SettingsAudioSoundPop = bmwId9SettingsAudioSoundPop2;
        this.bmwId9SettingsAudioSoundRock = bmwId9SettingsAudioSoundRock2;
        this.bmwId9SettingsAudioSoundUser = bmwId9SettingsAudioSoundUser2;
        this.bmwId9SettingsAudioTre = bmwId9SettingsAudioTre2;
        this.bmwId9SettingsBassAddBtn = bmwId9SettingsBassAddBtn2;
        this.bmwId9SettingsBassSubBtn = bmwId9SettingsBassSubBtn2;
        this.bmwId9SettingsMidAddBtn = bmwId9SettingsMidAddBtn2;
        this.bmwId9SettingsMidSubBtn = bmwId9SettingsMidSubBtn2;
        this.bmwId9SettingsTreAddBtn = bmwId9SettingsTreAddBtn2;
        this.bmwId9SettingsTreSubBtn = bmwId9SettingsTreSubBtn2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsAudioSoundLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsAudioSoundLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsAudioSoundLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_audio_sound_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsAudioSoundLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsAudioSoundLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsAudioSoundLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_audio_sound_layout, null, false, component);
    }

    public static BmwId9SettingsAudioSoundLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsAudioSoundLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsAudioSoundLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_audio_sound_layout);
    }
}
