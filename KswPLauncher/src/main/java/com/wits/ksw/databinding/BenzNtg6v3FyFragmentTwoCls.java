package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3ThemeChangeViewModel;

public abstract class BenzNtg6v3FyFragmentTwoCls extends ViewDataBinding {
    @Bindable
    protected Ntg6v3ThemeChangeViewModel mThemeViewModel;
    public final ImageView ntg6v3Item21;
    public final ImageView ntg6v3Item22;
    public final ImageView ntg6v3Item23;
    public final ImageView ntg6v3Item24;

    public abstract void setThemeViewModel(Ntg6v3ThemeChangeViewModel ntg6v3ThemeChangeViewModel);

    protected BenzNtg6v3FyFragmentTwoCls(Object _bindingComponent, View _root, int _localFieldCount, ImageView ntg6v3Item212, ImageView ntg6v3Item222, ImageView ntg6v3Item232, ImageView ntg6v3Item242) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ntg6v3Item21 = ntg6v3Item212;
        this.ntg6v3Item22 = ntg6v3Item222;
        this.ntg6v3Item23 = ntg6v3Item232;
        this.ntg6v3Item24 = ntg6v3Item242;
    }

    public Ntg6v3ThemeChangeViewModel getThemeViewModel() {
        return this.mThemeViewModel;
    }

    public static BenzNtg6v3FyFragmentTwoCls inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtg6v3FyFragmentTwoCls inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzNtg6v3FyFragmentTwoCls) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_change_theme_item2, root, attachToRoot, component);
    }

    public static BenzNtg6v3FyFragmentTwoCls inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtg6v3FyFragmentTwoCls inflate(LayoutInflater inflater, Object component) {
        return (BenzNtg6v3FyFragmentTwoCls) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_change_theme_item2, null, false, component);
    }

    public static BenzNtg6v3FyFragmentTwoCls bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtg6v3FyFragmentTwoCls bind(View view, Object component) {
        return (BenzNtg6v3FyFragmentTwoCls) bind(component, view, R.layout.ntg6v3_change_theme_item2);
    }
}
