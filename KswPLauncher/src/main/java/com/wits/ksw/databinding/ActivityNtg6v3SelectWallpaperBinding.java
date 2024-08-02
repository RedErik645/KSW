package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3WallpaperSelectViewModel;

public abstract class ActivityNtg6v3SelectWallpaperBinding extends ViewDataBinding {
    @Bindable
    protected Ntg6v3WallpaperSelectViewModel mThemeViewModel;
    public final LinearLayout menuLl;
    public final RelativeLayout ntg6v3ChangeThemeMainBg;
    public final LinearLayout ntg6v3DevicesLlAll;
    public final LinearLayout ntg6v3DevicesLlLoc;
    public final LinearLayout ntg6v3DevicesLlSd;
    public final LinearLayout ntg6v3DevicesLlUsb1;
    public final LinearLayout ntg6v3DevicesLlUsb2;
    public final TextView ntg6v3DevicesTvAll;
    public final ImageView ntg6v3DevicesTvLoc;
    public final ImageView ntg6v3DevicesTvSd;
    public final ImageView ntg6v3DevicesTvUsb1;
    public final ImageView ntg6v3DevicesTvUsb2;
    public final ImageView ntg6v3WallpaperBgIv;
    public final RecyclerView recyclerView;

    public abstract void setThemeViewModel(Ntg6v3WallpaperSelectViewModel ntg6v3WallpaperSelectViewModel);

    protected ActivityNtg6v3SelectWallpaperBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout menuLl2, RelativeLayout ntg6v3ChangeThemeMainBg2, LinearLayout ntg6v3DevicesLlAll2, LinearLayout ntg6v3DevicesLlLoc2, LinearLayout ntg6v3DevicesLlSd2, LinearLayout ntg6v3DevicesLlUsb12, LinearLayout ntg6v3DevicesLlUsb22, TextView ntg6v3DevicesTvAll2, ImageView ntg6v3DevicesTvLoc2, ImageView ntg6v3DevicesTvSd2, ImageView ntg6v3DevicesTvUsb12, ImageView ntg6v3DevicesTvUsb22, ImageView ntg6v3WallpaperBgIv2, RecyclerView recyclerView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.menuLl = menuLl2;
        this.ntg6v3ChangeThemeMainBg = ntg6v3ChangeThemeMainBg2;
        this.ntg6v3DevicesLlAll = ntg6v3DevicesLlAll2;
        this.ntg6v3DevicesLlLoc = ntg6v3DevicesLlLoc2;
        this.ntg6v3DevicesLlSd = ntg6v3DevicesLlSd2;
        this.ntg6v3DevicesLlUsb1 = ntg6v3DevicesLlUsb12;
        this.ntg6v3DevicesLlUsb2 = ntg6v3DevicesLlUsb22;
        this.ntg6v3DevicesTvAll = ntg6v3DevicesTvAll2;
        this.ntg6v3DevicesTvLoc = ntg6v3DevicesTvLoc2;
        this.ntg6v3DevicesTvSd = ntg6v3DevicesTvSd2;
        this.ntg6v3DevicesTvUsb1 = ntg6v3DevicesTvUsb12;
        this.ntg6v3DevicesTvUsb2 = ntg6v3DevicesTvUsb22;
        this.ntg6v3WallpaperBgIv = ntg6v3WallpaperBgIv2;
        this.recyclerView = recyclerView2;
    }

    public Ntg6v3WallpaperSelectViewModel getThemeViewModel() {
        return this.mThemeViewModel;
    }

    public static ActivityNtg6v3SelectWallpaperBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtg6v3SelectWallpaperBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityNtg6v3SelectWallpaperBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_select_wallpaper_activity, root, attachToRoot, component);
    }

    public static ActivityNtg6v3SelectWallpaperBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtg6v3SelectWallpaperBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityNtg6v3SelectWallpaperBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_select_wallpaper_activity, null, false, component);
    }

    public static ActivityNtg6v3SelectWallpaperBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtg6v3SelectWallpaperBinding bind(View view, Object component) {
        return (ActivityNtg6v3SelectWallpaperBinding) bind(component, view, R.layout.ntg6v3_select_wallpaper_activity);
    }
}
