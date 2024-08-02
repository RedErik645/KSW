package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3ThemeChangeViewModel;

public abstract class ActivityNtg6v3ChangeThemeMainBinding extends ViewDataBinding {
    public final LinearLayout indicatorLl;
    @Bindable
    protected Ntg6v3ThemeChangeViewModel mThemeViewModel;
    public final RelativeLayout ntg6v3ChangeThemeMainBg;
    public final TextView pageTv1;
    public final TextView pageTv2;
    public final TextView themeChangeTv;
    public final ViewPager themeViewPager;
    public final LinearLayout titleLl;
    public final TextView wallpaperChangeTv;
    public final Ntg6v3ChangeWallpaperItemBinding wallpaperIncludeView;

    public abstract void setThemeViewModel(Ntg6v3ThemeChangeViewModel ntg6v3ThemeChangeViewModel);

    protected ActivityNtg6v3ChangeThemeMainBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout indicatorLl2, RelativeLayout ntg6v3ChangeThemeMainBg2, TextView pageTv12, TextView pageTv22, TextView themeChangeTv2, ViewPager themeViewPager2, LinearLayout titleLl2, TextView wallpaperChangeTv2, Ntg6v3ChangeWallpaperItemBinding wallpaperIncludeView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.indicatorLl = indicatorLl2;
        this.ntg6v3ChangeThemeMainBg = ntg6v3ChangeThemeMainBg2;
        this.pageTv1 = pageTv12;
        this.pageTv2 = pageTv22;
        this.themeChangeTv = themeChangeTv2;
        this.themeViewPager = themeViewPager2;
        this.titleLl = titleLl2;
        this.wallpaperChangeTv = wallpaperChangeTv2;
        this.wallpaperIncludeView = wallpaperIncludeView2;
    }

    public Ntg6v3ThemeChangeViewModel getThemeViewModel() {
        return this.mThemeViewModel;
    }

    public static ActivityNtg6v3ChangeThemeMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtg6v3ChangeThemeMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityNtg6v3ChangeThemeMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_ntg6v3_change_theme, root, attachToRoot, component);
    }

    public static ActivityNtg6v3ChangeThemeMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtg6v3ChangeThemeMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityNtg6v3ChangeThemeMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_ntg6v3_change_theme, null, false, component);
    }

    public static ActivityNtg6v3ChangeThemeMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtg6v3ChangeThemeMainBinding bind(View view, Object component) {
        return (ActivityNtg6v3ChangeThemeMainBinding) bind(component, view, R.layout.activity_ntg6v3_change_theme);
    }
}
