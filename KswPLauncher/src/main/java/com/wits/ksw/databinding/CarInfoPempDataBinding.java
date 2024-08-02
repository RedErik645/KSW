package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public abstract class CarInfoPempDataBinding extends ViewDataBinding {
    public final ImageView ivMask;
    public final RelativeLayout llContainer;
    @Bindable
    protected LauncherViewModel mCarViewModel;
    public final TextView tvDesc;

    public abstract void setCarViewModel(LauncherViewModel launcherViewModel);

    protected CarInfoPempDataBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivMask2, RelativeLayout llContainer2, TextView tvDesc2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivMask = ivMask2;
        this.llContainer = llContainer2;
        this.tvDesc = tvDesc2;
    }

    public LauncherViewModel getCarViewModel() {
        return this.mCarViewModel;
    }

    public static CarInfoPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CarInfoPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CarInfoPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_car_info, root, attachToRoot, component);
    }

    public static CarInfoPempDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CarInfoPempDataBinding inflate(LayoutInflater inflater, Object component) {
        return (CarInfoPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_car_info, null, false, component);
    }

    public static CarInfoPempDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CarInfoPempDataBinding bind(View view, Object component) {
        return (CarInfoPempDataBinding) bind(component, view, R.layout.fragment_pemp_car_info);
    }
}
