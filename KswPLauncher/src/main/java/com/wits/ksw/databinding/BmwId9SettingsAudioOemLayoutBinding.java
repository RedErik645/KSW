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

public abstract class BmwId9SettingsAudioOemLayoutBinding extends ViewDataBinding {
    public final LinearLayout bmwId9SettingsAudioOemLay;
    public final ImageButton bmwId9SettingsNaviAddBtn;
    public final BmwId9ProgressBar bmwId9SettingsNaviSeekbar;
    public final ImageButton bmwId9SettingsNaviSubBtn;
    public final ImageButton bmwId9SettingsOemCallAddBtn;
    public final BmwId9ProgressBar bmwId9SettingsOemCallSeekbar;
    public final ImageButton bmwId9SettingsOemCallSubBtn;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected BmwId9SettingsAudioOemLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout bmwId9SettingsAudioOemLay2, ImageButton bmwId9SettingsNaviAddBtn2, BmwId9ProgressBar bmwId9SettingsNaviSeekbar2, ImageButton bmwId9SettingsNaviSubBtn2, ImageButton bmwId9SettingsOemCallAddBtn2, BmwId9ProgressBar bmwId9SettingsOemCallSeekbar2, ImageButton bmwId9SettingsOemCallSubBtn2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9SettingsAudioOemLay = bmwId9SettingsAudioOemLay2;
        this.bmwId9SettingsNaviAddBtn = bmwId9SettingsNaviAddBtn2;
        this.bmwId9SettingsNaviSeekbar = bmwId9SettingsNaviSeekbar2;
        this.bmwId9SettingsNaviSubBtn = bmwId9SettingsNaviSubBtn2;
        this.bmwId9SettingsOemCallAddBtn = bmwId9SettingsOemCallAddBtn2;
        this.bmwId9SettingsOemCallSeekbar = bmwId9SettingsOemCallSeekbar2;
        this.bmwId9SettingsOemCallSubBtn = bmwId9SettingsOemCallSubBtn2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9SettingsAudioOemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsAudioOemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9SettingsAudioOemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_audio_oem_layout, root, attachToRoot, component);
    }

    public static BmwId9SettingsAudioOemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsAudioOemLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9SettingsAudioOemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_settings_audio_oem_layout, null, false, component);
    }

    public static BmwId9SettingsAudioOemLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9SettingsAudioOemLayoutBinding bind(View view, Object component) {
        return (BmwId9SettingsAudioOemLayoutBinding) bind(component, view, R.layout.bmw_id9_settings_audio_oem_layout);
    }
}
