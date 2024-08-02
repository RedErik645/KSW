package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;

public abstract class BenzNtgFyActivityNewBinding extends ViewDataBinding {
    public final RecyclerView benzMbux2021KswNewRecycle;
    public final ViewPager benzMbux2021Viewpager;
    public final ImageView controlBtn;
    public final LinearLayout indicatorBenzNtg6Fy;
    public final ImageView ivCoatFy;
    public final LinearLayout layoutCoatBenzFy;
    public final LinearLayout layoutMainNtgFy;
    @Bindable
    protected BcVieModel mViewModel;
    public final TextView tvCoatFyTip;

    public abstract void setViewModel(BcVieModel bcVieModel);

    protected BenzNtgFyActivityNewBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView benzMbux2021KswNewRecycle2, ViewPager benzMbux2021Viewpager2, ImageView controlBtn2, LinearLayout indicatorBenzNtg6Fy2, ImageView ivCoatFy2, LinearLayout layoutCoatBenzFy2, LinearLayout layoutMainNtgFy2, TextView tvCoatFyTip2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.benzMbux2021KswNewRecycle = benzMbux2021KswNewRecycle2;
        this.benzMbux2021Viewpager = benzMbux2021Viewpager2;
        this.controlBtn = controlBtn2;
        this.indicatorBenzNtg6Fy = indicatorBenzNtg6Fy2;
        this.ivCoatFy = ivCoatFy2;
        this.layoutCoatBenzFy = layoutCoatBenzFy2;
        this.layoutMainNtgFy = layoutMainNtgFy2;
        this.tvCoatFyTip = tvCoatFyTip2;
    }

    public BcVieModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzNtgFyActivityNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtgFyActivityNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzNtgFyActivityNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_ntg_fy_activity_new, root, attachToRoot, component);
    }

    public static BenzNtgFyActivityNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtgFyActivityNewBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzNtgFyActivityNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_ntg_fy_activity_new, null, false, component);
    }

    public static BenzNtgFyActivityNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtgFyActivityNewBinding bind(View view, Object component) {
        return (BenzNtgFyActivityNewBinding) bind(component, view, R.layout.benz_ntg_fy_activity_new);
    }
}
