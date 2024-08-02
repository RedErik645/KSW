package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class BenzMbuxSettingsSystemAuxLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final ImageButton mbuxSettingsAux1AddBtn;
    public final BenzMbuxProgressBar mbuxSettingsAux1Seekbar;
    public final ImageButton mbuxSettingsAux1SubBtn;
    public final TextView mbuxSettingsAux1TextName;
    public final TextView mbuxSettingsAux1TextValue;
    public final ImageButton mbuxSettingsAux2AddBtn;
    public final BenzMbuxProgressBar mbuxSettingsAux2Seekbar;
    public final ImageButton mbuxSettingsAux2SubBtn;
    public final TextView mbuxSettingsAux2TextName;
    public final TextView mbuxSettingsAux2TextValue;
    public final LinearLayout mbuxSettingsAuxLay;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsSystemAuxLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageButton mbuxSettingsAux1AddBtn2, BenzMbuxProgressBar mbuxSettingsAux1Seekbar2, ImageButton mbuxSettingsAux1SubBtn2, TextView mbuxSettingsAux1TextName2, TextView mbuxSettingsAux1TextValue2, ImageButton mbuxSettingsAux2AddBtn2, BenzMbuxProgressBar mbuxSettingsAux2Seekbar2, ImageButton mbuxSettingsAux2SubBtn2, TextView mbuxSettingsAux2TextName2, TextView mbuxSettingsAux2TextValue2, LinearLayout mbuxSettingsAuxLay2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxSettingsAux1AddBtn = mbuxSettingsAux1AddBtn2;
        this.mbuxSettingsAux1Seekbar = mbuxSettingsAux1Seekbar2;
        this.mbuxSettingsAux1SubBtn = mbuxSettingsAux1SubBtn2;
        this.mbuxSettingsAux1TextName = mbuxSettingsAux1TextName2;
        this.mbuxSettingsAux1TextValue = mbuxSettingsAux1TextValue2;
        this.mbuxSettingsAux2AddBtn = mbuxSettingsAux2AddBtn2;
        this.mbuxSettingsAux2Seekbar = mbuxSettingsAux2Seekbar2;
        this.mbuxSettingsAux2SubBtn = mbuxSettingsAux2SubBtn2;
        this.mbuxSettingsAux2TextName = mbuxSettingsAux2TextName2;
        this.mbuxSettingsAux2TextValue = mbuxSettingsAux2TextValue2;
        this.mbuxSettingsAuxLay = mbuxSettingsAuxLay2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsSystemAuxLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemAuxLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsSystemAuxLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_aux_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsSystemAuxLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemAuxLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsSystemAuxLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_system_aux_layout, null, false, component);
    }

    public static BenzMbuxSettingsSystemAuxLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsSystemAuxLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsSystemAuxLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_system_aux_layout);
    }
}
