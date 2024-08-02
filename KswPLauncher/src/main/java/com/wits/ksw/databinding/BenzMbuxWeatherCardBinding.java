package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;

public abstract class BenzMbuxWeatherCardBinding extends ViewDataBinding {
    public final AppCompatImageView benzMbuxLocalCardBg;
    public final AppCompatTextView benzMbuxLocalCardContent;
    public final AppCompatTextView benzMbuxLocalCardTitle;
    @Bindable
    protected BcVieModel mViewModel;

    public abstract void setViewModel(BcVieModel bcVieModel);

    protected BenzMbuxWeatherCardBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageView benzMbuxLocalCardBg2, AppCompatTextView benzMbuxLocalCardContent2, AppCompatTextView benzMbuxLocalCardTitle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.benzMbuxLocalCardBg = benzMbuxLocalCardBg2;
        this.benzMbuxLocalCardContent = benzMbuxLocalCardContent2;
        this.benzMbuxLocalCardTitle = benzMbuxLocalCardTitle2;
    }

    public BcVieModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxWeatherCardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxWeatherCardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxWeatherCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_weather_card, root, attachToRoot, component);
    }

    public static BenzMbuxWeatherCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxWeatherCardBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxWeatherCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_weather_card, null, false, component);
    }

    public static BenzMbuxWeatherCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxWeatherCardBinding bind(View view, Object component) {
        return (BenzMbuxWeatherCardBinding) bind(component, view, R.layout.benz_mbux_weather_card);
    }
}
