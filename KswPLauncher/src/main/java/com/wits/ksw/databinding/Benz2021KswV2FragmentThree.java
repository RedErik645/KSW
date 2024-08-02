package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;

public abstract class Benz2021KswV2FragmentThree extends ViewDataBinding {
    public final BenzMbuxItemView appItemview;
    public final RelativeLayout appRl;
    public final TextView appTip;
    public final TextView appTv;
    public final BenzMbuxItemView carItemview;
    public final RelativeLayout carRl;
    public final TextView carTip;
    public final TextView carTv;
    public final BenzMbuxItemView dashboardItemview;
    public final RelativeLayout dashboardRl;
    public final TextView dashboardTip;
    public final TextView dashboardTv;
    public final LinearLayout fragmentTwoLl;
    public final ImageView ivApps1;
    public final ImageView ivApps2;
    public final ImageView ivCar1;
    public final ImageView ivCar2;
    public final ImageView ivDash1;
    public final ImageView ivDash2;
    @Bindable
    protected BcVieModel mViewModel;

    public abstract void setViewModel(BcVieModel bcVieModel);

    protected Benz2021KswV2FragmentThree(Object _bindingComponent, View _root, int _localFieldCount, BenzMbuxItemView appItemview2, RelativeLayout appRl2, TextView appTip2, TextView appTv2, BenzMbuxItemView carItemview2, RelativeLayout carRl2, TextView carTip2, TextView carTv2, BenzMbuxItemView dashboardItemview2, RelativeLayout dashboardRl2, TextView dashboardTip2, TextView dashboardTv2, LinearLayout fragmentTwoLl2, ImageView ivApps12, ImageView ivApps22, ImageView ivCar12, ImageView ivCar22, ImageView ivDash12, ImageView ivDash22) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appItemview = appItemview2;
        this.appRl = appRl2;
        this.appTip = appTip2;
        this.appTv = appTv2;
        this.carItemview = carItemview2;
        this.carRl = carRl2;
        this.carTip = carTip2;
        this.carTv = carTv2;
        this.dashboardItemview = dashboardItemview2;
        this.dashboardRl = dashboardRl2;
        this.dashboardTip = dashboardTip2;
        this.dashboardTv = dashboardTv2;
        this.fragmentTwoLl = fragmentTwoLl2;
        this.ivApps1 = ivApps12;
        this.ivApps2 = ivApps22;
        this.ivCar1 = ivCar12;
        this.ivCar2 = ivCar22;
        this.ivDash1 = ivDash12;
        this.ivDash2 = ivDash22;
    }

    public BcVieModel getViewModel() {
        return this.mViewModel;
    }

    public static Benz2021KswV2FragmentThree inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Benz2021KswV2FragmentThree inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Benz2021KswV2FragmentThree) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_benz_mbux2021_ksw_v2_three, root, attachToRoot, component);
    }

    public static Benz2021KswV2FragmentThree inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Benz2021KswV2FragmentThree inflate(LayoutInflater inflater, Object component) {
        return (Benz2021KswV2FragmentThree) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_benz_mbux2021_ksw_v2_three, null, false, component);
    }

    public static Benz2021KswV2FragmentThree bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Benz2021KswV2FragmentThree bind(View view, Object component) {
        return (Benz2021KswV2FragmentThree) bind(component, view, R.layout.fragment_benz_mbux2021_ksw_v2_three);
    }
}
