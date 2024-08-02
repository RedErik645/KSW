package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public abstract class BenzMbuxSettingsLanguageLayoutBinding extends ViewDataBinding {
    @Bindable
    protected BenzMbuxSettingsViewModel mViewModel;
    public final RecyclerView mbuxLanguageRecycle;
    public final LinearLayout mbuxSettingsSystemLanguageLay;

    public abstract void setViewModel(BenzMbuxSettingsViewModel benzMbuxSettingsViewModel);

    protected BenzMbuxSettingsLanguageLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView mbuxLanguageRecycle2, LinearLayout mbuxSettingsSystemLanguageLay2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.mbuxLanguageRecycle = mbuxLanguageRecycle2;
        this.mbuxSettingsSystemLanguageLay = mbuxSettingsSystemLanguageLay2;
    }

    public BenzMbuxSettingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxSettingsLanguageLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsLanguageLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxSettingsLanguageLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_language_layout, root, attachToRoot, component);
    }

    public static BenzMbuxSettingsLanguageLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsLanguageLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxSettingsLanguageLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_settings_language_layout, null, false, component);
    }

    public static BenzMbuxSettingsLanguageLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxSettingsLanguageLayoutBinding bind(View view, Object component) {
        return (BenzMbuxSettingsLanguageLayoutBinding) bind(component, view, R.layout.benz_mbux_settings_language_layout);
    }
}
