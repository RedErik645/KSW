package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public abstract class NtgFyV3AllappsPopLayoutBinding extends ViewDataBinding {
    public final RelativeLayout llEdit;
    @Bindable
    protected Ntg6v3LauncherViewModel mPopwindowViewModel;
    public final ConstraintLayout ntgFyV3PopwindowBg;
    public final LinearLayout point;
    public final ViewPager viewpager;

    public abstract void setPopwindowViewModel(Ntg6v3LauncherViewModel ntg6v3LauncherViewModel);

    protected NtgFyV3AllappsPopLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout llEdit2, ConstraintLayout ntgFyV3PopwindowBg2, LinearLayout point2, ViewPager viewpager2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.llEdit = llEdit2;
        this.ntgFyV3PopwindowBg = ntgFyV3PopwindowBg2;
        this.point = point2;
        this.viewpager = viewpager2;
    }

    public Ntg6v3LauncherViewModel getPopwindowViewModel() {
        return this.mPopwindowViewModel;
    }

    public static NtgFyV3AllappsPopLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NtgFyV3AllappsPopLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (NtgFyV3AllappsPopLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg_fy_v3_allapps_pop_layout, root, attachToRoot, component);
    }

    public static NtgFyV3AllappsPopLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NtgFyV3AllappsPopLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (NtgFyV3AllappsPopLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg_fy_v3_allapps_pop_layout, null, false, component);
    }

    public static NtgFyV3AllappsPopLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NtgFyV3AllappsPopLayoutBinding bind(View view, Object component) {
        return (NtgFyV3AllappsPopLayoutBinding) bind(component, view, R.layout.ntg_fy_v3_allapps_pop_layout);
    }
}
