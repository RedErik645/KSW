package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.id9als.viewmodel.WallpaperSelectViewModel;

public abstract class ActivityId9SelectWallpaperBinding extends ViewDataBinding {
    public final ImageButton id9DevicesLocIb;
    public final ImageButton id9DevicesSdIb;
    public final ImageButton id9DevicesUsb1Ib;
    public final ImageButton id9DevicesUsb2Ib;
    public final LinearLayout id9MenuLl;
    @Bindable
    protected WallpaperSelectViewModel mThemeViewModel;
    public final TextView modelTitleTv;
    public final RecyclerView recyclerView;
    public final RelativeLayout themeMainBg;

    public abstract void setThemeViewModel(WallpaperSelectViewModel wallpaperSelectViewModel);

    protected ActivityId9SelectWallpaperBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageButton id9DevicesLocIb2, ImageButton id9DevicesSdIb2, ImageButton id9DevicesUsb1Ib2, ImageButton id9DevicesUsb2Ib2, LinearLayout id9MenuLl2, TextView modelTitleTv2, RecyclerView recyclerView2, RelativeLayout themeMainBg2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id9DevicesLocIb = id9DevicesLocIb2;
        this.id9DevicesSdIb = id9DevicesSdIb2;
        this.id9DevicesUsb1Ib = id9DevicesUsb1Ib2;
        this.id9DevicesUsb2Ib = id9DevicesUsb2Ib2;
        this.id9MenuLl = id9MenuLl2;
        this.modelTitleTv = modelTitleTv2;
        this.recyclerView = recyclerView2;
        this.themeMainBg = themeMainBg2;
    }

    public WallpaperSelectViewModel getThemeViewModel() {
        return this.mThemeViewModel;
    }

    public static ActivityId9SelectWallpaperBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityId9SelectWallpaperBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityId9SelectWallpaperBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_id9_select_wallpaper, root, attachToRoot, component);
    }

    public static ActivityId9SelectWallpaperBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityId9SelectWallpaperBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityId9SelectWallpaperBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_id9_select_wallpaper, null, false, component);
    }

    public static ActivityId9SelectWallpaperBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityId9SelectWallpaperBinding bind(View view, Object component) {
        return (ActivityId9SelectWallpaperBinding) bind(component, view, R.layout.activity_id9_select_wallpaper);
    }
}
