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

public abstract class Ntg6v3ChangeWallpaperItemBinding extends ViewDataBinding {
    @Bindable
    protected Ntg6v3ThemeChangeViewModel mThemeWallpaperViewModel;
    public final ImageView wallpaperCustomIv;
    public final ImageView wallpaperMapIv;
    public final ImageView wallpaperNormalIv;

    public abstract void setThemeWallpaperViewModel(Ntg6v3ThemeChangeViewModel ntg6v3ThemeChangeViewModel);

    protected Ntg6v3ChangeWallpaperItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView wallpaperCustomIv2, ImageView wallpaperMapIv2, ImageView wallpaperNormalIv2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.wallpaperCustomIv = wallpaperCustomIv2;
        this.wallpaperMapIv = wallpaperMapIv2;
        this.wallpaperNormalIv = wallpaperNormalIv2;
    }

    public Ntg6v3ThemeChangeViewModel getThemeWallpaperViewModel() {
        return this.mThemeWallpaperViewModel;
    }

    public static Ntg6v3ChangeWallpaperItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3ChangeWallpaperItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Ntg6v3ChangeWallpaperItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_change_wallpaper_item, root, attachToRoot, component);
    }

    public static Ntg6v3ChangeWallpaperItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3ChangeWallpaperItemBinding inflate(LayoutInflater inflater, Object component) {
        return (Ntg6v3ChangeWallpaperItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_change_wallpaper_item, null, false, component);
    }

    public static Ntg6v3ChangeWallpaperItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3ChangeWallpaperItemBinding bind(View view, Object component) {
        return (Ntg6v3ChangeWallpaperItemBinding) bind(component, view, R.layout.ntg6v3_change_wallpaper_item);
    }
}
