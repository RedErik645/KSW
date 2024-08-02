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
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public abstract class ActivityBmwId9SettingsFactoryLayoutBinding extends ViewDataBinding {
    public final ImageView bmwId8SettingsHomeback;
    public final LinearLayout bmwId9FactoryInput;
    public final ImageView bmwId9SettingsFactory0Btn;
    public final ImageView bmwId9SettingsFactory1Btn;
    public final ImageView bmwId9SettingsFactory2Btn;
    public final ImageView bmwId9SettingsFactory3Btn;
    public final ImageView bmwId9SettingsFactory4Btn;
    public final ImageView bmwId9SettingsFactory5Btn;
    public final ImageView bmwId9SettingsFactory6Btn;
    public final ImageView bmwId9SettingsFactory7Btn;
    public final ImageView bmwId9SettingsFactory8Btn;
    public final ImageView bmwId9SettingsFactory9Btn;
    public final ImageView bmwId9SettingsFactoryDelBtn;
    public final ImageView bmwId9SettingsFactoryEnterBtn;
    public final TextView bmwId9SettingsFactoryPsw;
    @Bindable
    protected BmwId9SettingsViewModel mViewModel;

    public abstract void setViewModel(BmwId9SettingsViewModel bmwId9SettingsViewModel);

    protected ActivityBmwId9SettingsFactoryLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView bmwId8SettingsHomeback2, LinearLayout bmwId9FactoryInput2, ImageView bmwId9SettingsFactory0Btn2, ImageView bmwId9SettingsFactory1Btn2, ImageView bmwId9SettingsFactory2Btn2, ImageView bmwId9SettingsFactory3Btn2, ImageView bmwId9SettingsFactory4Btn2, ImageView bmwId9SettingsFactory5Btn2, ImageView bmwId9SettingsFactory6Btn2, ImageView bmwId9SettingsFactory7Btn2, ImageView bmwId9SettingsFactory8Btn2, ImageView bmwId9SettingsFactory9Btn2, ImageView bmwId9SettingsFactoryDelBtn2, ImageView bmwId9SettingsFactoryEnterBtn2, TextView bmwId9SettingsFactoryPsw2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId8SettingsHomeback = bmwId8SettingsHomeback2;
        this.bmwId9FactoryInput = bmwId9FactoryInput2;
        this.bmwId9SettingsFactory0Btn = bmwId9SettingsFactory0Btn2;
        this.bmwId9SettingsFactory1Btn = bmwId9SettingsFactory1Btn2;
        this.bmwId9SettingsFactory2Btn = bmwId9SettingsFactory2Btn2;
        this.bmwId9SettingsFactory3Btn = bmwId9SettingsFactory3Btn2;
        this.bmwId9SettingsFactory4Btn = bmwId9SettingsFactory4Btn2;
        this.bmwId9SettingsFactory5Btn = bmwId9SettingsFactory5Btn2;
        this.bmwId9SettingsFactory6Btn = bmwId9SettingsFactory6Btn2;
        this.bmwId9SettingsFactory7Btn = bmwId9SettingsFactory7Btn2;
        this.bmwId9SettingsFactory8Btn = bmwId9SettingsFactory8Btn2;
        this.bmwId9SettingsFactory9Btn = bmwId9SettingsFactory9Btn2;
        this.bmwId9SettingsFactoryDelBtn = bmwId9SettingsFactoryDelBtn2;
        this.bmwId9SettingsFactoryEnterBtn = bmwId9SettingsFactoryEnterBtn2;
        this.bmwId9SettingsFactoryPsw = bmwId9SettingsFactoryPsw2;
    }

    public BmwId9SettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityBmwId9SettingsFactoryLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsFactoryLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityBmwId9SettingsFactoryLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_factory_layout, root, attachToRoot, component);
    }

    public static ActivityBmwId9SettingsFactoryLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsFactoryLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityBmwId9SettingsFactoryLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_bmw_id9_settings_factory_layout, null, false, component);
    }

    public static ActivityBmwId9SettingsFactoryLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBmwId9SettingsFactoryLayoutBinding bind(View view, Object component) {
        return (ActivityBmwId9SettingsFactoryLayoutBinding) bind(component, view, R.layout.activity_bmw_id9_settings_factory_layout);
    }
}
