package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class ActivityBenzMbuxSettingsFactoryLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final LinearLayout mbuxFactoryInput;
    public final ImageView mbuxSettingsFactory0Btn;
    public final ImageView mbuxSettingsFactory1Btn;
    public final ImageView mbuxSettingsFactory2Btn;
    public final ImageView mbuxSettingsFactory3Btn;
    public final ImageView mbuxSettingsFactory4Btn;
    public final ImageView mbuxSettingsFactory5Btn;
    public final ImageView mbuxSettingsFactory6Btn;
    public final ImageView mbuxSettingsFactory7Btn;
    public final ImageView mbuxSettingsFactory8Btn;
    public final ImageView mbuxSettingsFactory9Btn;
    public final ImageView mbuxSettingsFactoryDelBtn;
    public final ImageView mbuxSettingsFactoryEnterBtn;
    public final TextView mbuxSettingsFactoryPsw;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected ActivityBenzMbuxSettingsFactoryLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout mbuxFactoryInput2, ImageView mbuxSettingsFactory0Btn2, ImageView mbuxSettingsFactory1Btn2, ImageView mbuxSettingsFactory2Btn2, ImageView mbuxSettingsFactory3Btn2, ImageView mbuxSettingsFactory4Btn2, ImageView mbuxSettingsFactory5Btn2, ImageView mbuxSettingsFactory6Btn2, ImageView mbuxSettingsFactory7Btn2, ImageView mbuxSettingsFactory8Btn2, ImageView mbuxSettingsFactory9Btn2, ImageView mbuxSettingsFactoryDelBtn2, ImageView mbuxSettingsFactoryEnterBtn2, TextView mbuxSettingsFactoryPsw2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxFactoryInput = mbuxFactoryInput2;
        this.mbuxSettingsFactory0Btn = mbuxSettingsFactory0Btn2;
        this.mbuxSettingsFactory1Btn = mbuxSettingsFactory1Btn2;
        this.mbuxSettingsFactory2Btn = mbuxSettingsFactory2Btn2;
        this.mbuxSettingsFactory3Btn = mbuxSettingsFactory3Btn2;
        this.mbuxSettingsFactory4Btn = mbuxSettingsFactory4Btn2;
        this.mbuxSettingsFactory5Btn = mbuxSettingsFactory5Btn2;
        this.mbuxSettingsFactory6Btn = mbuxSettingsFactory6Btn2;
        this.mbuxSettingsFactory7Btn = mbuxSettingsFactory7Btn2;
        this.mbuxSettingsFactory8Btn = mbuxSettingsFactory8Btn2;
        this.mbuxSettingsFactory9Btn = mbuxSettingsFactory9Btn2;
        this.mbuxSettingsFactoryDelBtn = mbuxSettingsFactoryDelBtn2;
        this.mbuxSettingsFactoryEnterBtn = mbuxSettingsFactoryEnterBtn2;
        this.mbuxSettingsFactoryPsw = mbuxSettingsFactoryPsw2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBenzMbuxSettingsFactoryLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsFactoryLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBenzMbuxSettingsFactoryLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_factory_layout, root, attachToRoot, component);
    }

    public static ActivityBenzMbuxSettingsFactoryLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsFactoryLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBenzMbuxSettingsFactoryLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_benz_mbux_settings_factory_layout, null, false, component);
    }

    public static ActivityBenzMbuxSettingsFactoryLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBenzMbuxSettingsFactoryLayoutBinding bind(View view, Object component) {
        return (ActivityBenzMbuxSettingsFactoryLayoutBinding) bind(component, view, R.layout.activity_benz_mbux_settings_factory_layout);
    }
}
