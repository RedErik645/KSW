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

public abstract class BenzMbuxSettingsAudioOemLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final LinearLayout mbuxSettingsAudioOemLay;
    public final ImageButton mbuxSettingsNaviAddBtn;
    public final BenzMbuxProgressBar mbuxSettingsNaviSeekbar;
    public final ImageButton mbuxSettingsNaviSubBtn;
    public final ImageButton mbuxSettingsOemCallAddBtn;
    public final BenzMbuxProgressBar mbuxSettingsOemCallSeekbar;
    public final ImageButton mbuxSettingsOemCallSubBtn;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsAudioOemLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout mbuxSettingsAudioOemLay2, ImageButton mbuxSettingsNaviAddBtn2, BenzMbuxProgressBar mbuxSettingsNaviSeekbar2, ImageButton mbuxSettingsNaviSubBtn2, ImageButton mbuxSettingsOemCallAddBtn2, BenzMbuxProgressBar mbuxSettingsOemCallSeekbar2, ImageButton mbuxSettingsOemCallSubBtn2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsAudioOemLay = mbuxSettingsAudioOemLay2;
        this.mbuxSettingsNaviAddBtn = mbuxSettingsNaviAddBtn2;
        this.mbuxSettingsNaviSeekbar = mbuxSettingsNaviSeekbar2;
        this.mbuxSettingsNaviSubBtn = mbuxSettingsNaviSubBtn2;
        this.mbuxSettingsOemCallAddBtn = mbuxSettingsOemCallAddBtn2;
        this.mbuxSettingsOemCallSeekbar = mbuxSettingsOemCallSeekbar2;
        this.mbuxSettingsOemCallSubBtn = mbuxSettingsOemCallSubBtn2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsAudioOemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsAudioOemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsAudioOemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_audio_oem_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsAudioOemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsAudioOemLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsAudioOemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_audio_oem_layout, null, false, component);
    }

    public static BenzMbuxSettingsAudioOemLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsAudioOemLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsAudioOemLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_audio_oem_layout);
    }
}
