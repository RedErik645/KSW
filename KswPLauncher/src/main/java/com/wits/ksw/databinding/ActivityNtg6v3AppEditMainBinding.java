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
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3AppEditViewModel;

public abstract class ActivityNtg6v3AppEditMainBinding extends ViewDataBinding {
    public final ImageView ivLeft1;
    public final LinearLayout llLeft1;
    public final LinearLayout llLeftBarContainer;
    @Bindable
    protected Ntg6v3AppEditViewModel mAppEditViewModel;
    public final RelativeLayout ntg6v3ChangeThemeMainBg;
    public final RelativeLayout ntgFyV3PopwindowBg;
    public final RecyclerView rvList;

    public abstract void setAppEditViewModel(Ntg6v3AppEditViewModel ntg6v3AppEditViewModel);

    protected ActivityNtg6v3AppEditMainBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivLeft12, LinearLayout llLeft12, LinearLayout llLeftBarContainer2, RelativeLayout ntg6v3ChangeThemeMainBg2, RelativeLayout ntgFyV3PopwindowBg2, RecyclerView rvList2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivLeft1 = ivLeft12;
        this.llLeft1 = llLeft12;
        this.llLeftBarContainer = llLeftBarContainer2;
        this.ntg6v3ChangeThemeMainBg = ntg6v3ChangeThemeMainBg2;
        this.ntgFyV3PopwindowBg = ntgFyV3PopwindowBg2;
        this.rvList = rvList2;
    }

    public Ntg6v3AppEditViewModel getAppEditViewModel() {
        return this.mAppEditViewModel;
    }

    public static ActivityNtg6v3AppEditMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtg6v3AppEditMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityNtg6v3AppEditMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_ntg6v3_app_edit, root, attachToRoot, component);
    }

    public static ActivityNtg6v3AppEditMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtg6v3AppEditMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityNtg6v3AppEditMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_ntg6v3_app_edit, null, false, component);
    }

    public static ActivityNtg6v3AppEditMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtg6v3AppEditMainBinding bind(View view, Object component) {
        return (ActivityNtg6v3AppEditMainBinding) bind(component, view, R.layout.activity_ntg6v3_app_edit);
    }
}
