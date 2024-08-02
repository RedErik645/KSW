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

public abstract class BenzNtg6v3FyFragmentOneCls extends ViewDataBinding {
    @Bindable
    protected Ntg6v3ThemeChangeViewModel mThemeViewModel;
    public final ImageView ntg6v3Item11;
    public final ImageView ntg6v3Item12;
    public final ImageView ntg6v3Item13;
    public final ImageView ntg6v3Item14;

    public abstract void setThemeViewModel(Ntg6v3ThemeChangeViewModel ntg6v3ThemeChangeViewModel);

    protected BenzNtg6v3FyFragmentOneCls(Object _bindingComponent, View _root, int _localFieldCount, ImageView ntg6v3Item112, ImageView ntg6v3Item122, ImageView ntg6v3Item132, ImageView ntg6v3Item142) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ntg6v3Item11 = ntg6v3Item112;
        this.ntg6v3Item12 = ntg6v3Item122;
        this.ntg6v3Item13 = ntg6v3Item132;
        this.ntg6v3Item14 = ntg6v3Item142;
    }

    public Ntg6v3ThemeChangeViewModel getThemeViewModel() {
        return this.mThemeViewModel;
    }

    public static BenzNtg6v3FyFragmentOneCls inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtg6v3FyFragmentOneCls inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzNtg6v3FyFragmentOneCls) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_change_theme_item1, root, attachToRoot, component);
    }

    public static BenzNtg6v3FyFragmentOneCls inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtg6v3FyFragmentOneCls inflate(LayoutInflater inflater, Object component) {
        return (BenzNtg6v3FyFragmentOneCls) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_change_theme_item1, null, false, component);
    }

    public static BenzNtg6v3FyFragmentOneCls bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtg6v3FyFragmentOneCls bind(View view, Object component) {
        return (BenzNtg6v3FyFragmentOneCls) bind(component, view, R.layout.ntg6v3_change_theme_item1);
    }
}
