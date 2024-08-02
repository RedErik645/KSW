package com.wits.ksw.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;

public abstract class Ntg6v3SelectWallpaperEmptViewBinding extends ViewDataBinding {
    protected Ntg6v3SelectWallpaperEmptViewBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static Ntg6v3SelectWallpaperEmptViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3SelectWallpaperEmptViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Ntg6v3SelectWallpaperEmptViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_select_wallpaper_empt_view, root, attachToRoot, component);
    }

    public static Ntg6v3SelectWallpaperEmptViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3SelectWallpaperEmptViewBinding inflate(LayoutInflater inflater, Object component) {
        return (Ntg6v3SelectWallpaperEmptViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_select_wallpaper_empt_view, null, false, component);
    }

    public static Ntg6v3SelectWallpaperEmptViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3SelectWallpaperEmptViewBinding bind(View view, Object component) {
        return (Ntg6v3SelectWallpaperEmptViewBinding) bind(component, view, R.layout.ntg6v3_select_wallpaper_empt_view);
    }
}
