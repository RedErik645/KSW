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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;

public abstract class BenzMbuxKswActivityNewBinding extends ViewDataBinding {
    public final RecyclerView benzMbux2021KswNewRecycle;
    public final ViewPager benzMbux2021Viewpager;
    public final ImageView controlBtn;
    public final LinearLayout indicatorBenzMbux2021;
    public final ImageView ivCoat2021;
    public final LinearLayout layoutCoatBenzMbux2021;
    public final ImageView layoutMain2021;
    public final RelativeLayout layoutMain20212;
    @Bindable
    protected BcVieModel mVieModel;
    public final TextView tvCoat2021Tip;

    public abstract void setVieModel(BcVieModel bcVieModel);

    protected BenzMbuxKswActivityNewBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView benzMbux2021KswNewRecycle2, ViewPager benzMbux2021Viewpager2, ImageView controlBtn2, LinearLayout indicatorBenzMbux20212, ImageView ivCoat20212, LinearLayout layoutCoatBenzMbux20212, ImageView layoutMain20213, RelativeLayout layoutMain202122, TextView tvCoat2021Tip2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.benzMbux2021KswNewRecycle = benzMbux2021KswNewRecycle2;
        this.benzMbux2021Viewpager = benzMbux2021Viewpager2;
        this.controlBtn = controlBtn2;
        this.indicatorBenzMbux2021 = indicatorBenzMbux20212;
        this.ivCoat2021 = ivCoat20212;
        this.layoutCoatBenzMbux2021 = layoutCoatBenzMbux20212;
        this.layoutMain2021 = layoutMain20213;
        this.layoutMain20212 = layoutMain202122;
        this.tvCoat2021Tip = tvCoat2021Tip2;
    }

    public BcVieModel getVieModel() {
        return this.mVieModel;
    }

    public static BenzMbuxKswActivityNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxKswActivityNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxKswActivityNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_ksw_activity_new, root, attachToRoot, component);
    }

    public static BenzMbuxKswActivityNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxKswActivityNewBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxKswActivityNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_ksw_activity_new, null, false, component);
    }

    public static BenzMbuxKswActivityNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxKswActivityNewBinding bind(View view, Object component) {
        return (BenzMbuxKswActivityNewBinding) bind(component, view, R.layout.benz_mbux_ksw_activity_new);
    }
}
