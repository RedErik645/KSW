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
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class BenzMbuxSettingsAudioSoundLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final SeekBar mbuxSettingsAudioLow;
    public final SeekBar mbuxSettingsAudioMid;
    public final RelativeLayout mbuxSettingsAudioSoundClass;
    public final RelativeLayout mbuxSettingsAudioSoundDance;
    public final RelativeLayout mbuxSettingsAudioSoundJazz;
    public final LinearLayout mbuxSettingsAudioSoundLay;
    public final RelativeLayout mbuxSettingsAudioSoundPop;
    public final RelativeLayout mbuxSettingsAudioSoundRock;
    public final RelativeLayout mbuxSettingsAudioSoundUser;
    public final SeekBar mbuxSettingsAudioTre;
    public final ImageButton mbuxSettingsBassAddBtn;
    public final ImageButton mbuxSettingsBassSubBtn;
    public final ImageButton mbuxSettingsMidAddBtn;
    public final ImageButton mbuxSettingsMidSubBtn;
    public final ImageButton mbuxSettingsTreAddBtn;
    public final ImageButton mbuxSettingsTreSubBtn;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsAudioSoundLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, SeekBar mbuxSettingsAudioLow2, SeekBar mbuxSettingsAudioMid2, RelativeLayout mbuxSettingsAudioSoundClass2, RelativeLayout mbuxSettingsAudioSoundDance2, RelativeLayout mbuxSettingsAudioSoundJazz2, LinearLayout mbuxSettingsAudioSoundLay2, RelativeLayout mbuxSettingsAudioSoundPop2, RelativeLayout mbuxSettingsAudioSoundRock2, RelativeLayout mbuxSettingsAudioSoundUser2, SeekBar mbuxSettingsAudioTre2, ImageButton mbuxSettingsBassAddBtn2, ImageButton mbuxSettingsBassSubBtn2, ImageButton mbuxSettingsMidAddBtn2, ImageButton mbuxSettingsMidSubBtn2, ImageButton mbuxSettingsTreAddBtn2, ImageButton mbuxSettingsTreSubBtn2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsAudioLow = mbuxSettingsAudioLow2;
        this.mbuxSettingsAudioMid = mbuxSettingsAudioMid2;
        this.mbuxSettingsAudioSoundClass = mbuxSettingsAudioSoundClass2;
        this.mbuxSettingsAudioSoundDance = mbuxSettingsAudioSoundDance2;
        this.mbuxSettingsAudioSoundJazz = mbuxSettingsAudioSoundJazz2;
        this.mbuxSettingsAudioSoundLay = mbuxSettingsAudioSoundLay2;
        this.mbuxSettingsAudioSoundPop = mbuxSettingsAudioSoundPop2;
        this.mbuxSettingsAudioSoundRock = mbuxSettingsAudioSoundRock2;
        this.mbuxSettingsAudioSoundUser = mbuxSettingsAudioSoundUser2;
        this.mbuxSettingsAudioTre = mbuxSettingsAudioTre2;
        this.mbuxSettingsBassAddBtn = mbuxSettingsBassAddBtn2;
        this.mbuxSettingsBassSubBtn = mbuxSettingsBassSubBtn2;
        this.mbuxSettingsMidAddBtn = mbuxSettingsMidAddBtn2;
        this.mbuxSettingsMidSubBtn = mbuxSettingsMidSubBtn2;
        this.mbuxSettingsTreAddBtn = mbuxSettingsTreAddBtn2;
        this.mbuxSettingsTreSubBtn = mbuxSettingsTreSubBtn2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsAudioSoundLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsAudioSoundLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsAudioSoundLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_audio_sound_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsAudioSoundLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsAudioSoundLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsAudioSoundLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_audio_sound_layout, null, false, component);
    }

    public static BenzMbuxSettingsAudioSoundLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsAudioSoundLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsAudioSoundLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_audio_sound_layout);
    }
}
