package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.DashboardViewModel;
import com.wits.ksw.launcher.view.LinearGradientID9Progress;

public abstract class BmwId9DashboardLayoutNewBinding extends ViewDataBinding {
    public final RelativeLayout bmwId9DashboardLay;
    public final RelativeLayout bmwId9DashboardMidLay;
    public final BmwId9DashboardMusicLayoutBinding bmwId9DashboardMusicLay;
    public final LinearGradientID9Progress bmwId9DashboardRotateProgress;
    public final LinearGradientID9Progress bmwId9DashboardSpeedProgress;
    public final BmwId8DashboardWeatherLayoutBinding bmwId9DashboardWeatherLay;
    @Bindable
    protected DashboardViewModel mViewModel;

    public abstract void setViewModel(DashboardViewModel dashboardViewModel);

    protected BmwId9DashboardLayoutNewBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout bmwId9DashboardLay2, RelativeLayout bmwId9DashboardMidLay2, BmwId9DashboardMusicLayoutBinding bmwId9DashboardMusicLay2, LinearGradientID9Progress bmwId9DashboardRotateProgress2, LinearGradientID9Progress bmwId9DashboardSpeedProgress2, BmwId8DashboardWeatherLayoutBinding bmwId9DashboardWeatherLay2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9DashboardLay = bmwId9DashboardLay2;
        this.bmwId9DashboardMidLay = bmwId9DashboardMidLay2;
        this.bmwId9DashboardMusicLay = bmwId9DashboardMusicLay2;
        this.bmwId9DashboardRotateProgress = bmwId9DashboardRotateProgress2;
        this.bmwId9DashboardSpeedProgress = bmwId9DashboardSpeedProgress2;
        this.bmwId9DashboardWeatherLay = bmwId9DashboardWeatherLay2;
    }

    public DashboardViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9DashboardLayoutNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9DashboardLayoutNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9DashboardLayoutNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_dashboard_layout_new, root, attachToRoot, component);
    }

    public static BmwId9DashboardLayoutNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9DashboardLayoutNewBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9DashboardLayoutNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_dashboard_layout_new, null, false, component);
    }

    public static BmwId9DashboardLayoutNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9DashboardLayoutNewBinding bind(View view, Object component) {
        return (BmwId9DashboardLayoutNewBinding) bind(component, view, R.layout.bmw_id9_dashboard_layout_new);
    }
}
