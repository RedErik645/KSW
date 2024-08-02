package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public abstract class DashboardPempDataBinding extends ViewDataBinding {
    public final ImageView divider;
    public final ImageView ivMask;
    public final FrameLayout ivSpeed;
    public final RelativeLayout llContainer;
    @Bindable
    protected LauncherViewModel mDashboardViewModel;
    public final TextView tvDashboard;

    public abstract void setDashboardViewModel(LauncherViewModel launcherViewModel);

    protected DashboardPempDataBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView divider2, ImageView ivMask2, FrameLayout ivSpeed2, RelativeLayout llContainer2, TextView tvDashboard2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.divider = divider2;
        this.ivMask = ivMask2;
        this.ivSpeed = ivSpeed2;
        this.llContainer = llContainer2;
        this.tvDashboard = tvDashboard2;
    }

    public LauncherViewModel getDashboardViewModel() {
        return this.mDashboardViewModel;
    }

    public static DashboardPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DashboardPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DashboardPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_dashboard, root, attachToRoot, component);
    }

    public static DashboardPempDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DashboardPempDataBinding inflate(LayoutInflater inflater, Object component) {
        return (DashboardPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_dashboard, null, false, component);
    }

    public static DashboardPempDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DashboardPempDataBinding bind(View view, Object component) {
        return (DashboardPempDataBinding) bind(component, view, R.layout.fragment_pemp_dashboard);
    }
}
