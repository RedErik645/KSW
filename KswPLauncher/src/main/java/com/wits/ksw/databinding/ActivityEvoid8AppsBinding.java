package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.AppViewModel;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.CustomGridView;

public abstract class ActivityEvoid8AppsBinding extends ViewDataBinding {
    public final CustomGridView appGridView;
    public final ConstraintLayout id8UgMain;
    public final LinearLayout leftLinearLayout;
    public final Evoid8AppLeftBarBinding llLeftContainer;
    public final Evoid8AppRightBarBinding llRightContainer;
    @Bindable
    protected AppViewModel mAppViewModel;
    @Bindable
    protected LauncherViewModel mLauncherViewModel;
    public final LinearLayout rightLinearLayout;

    public abstract void setAppViewModel(AppViewModel appViewModel);

    public abstract void setLauncherViewModel(LauncherViewModel launcherViewModel);

    protected ActivityEvoid8AppsBinding(Object _bindingComponent, View _root, int _localFieldCount, CustomGridView appGridView2, ConstraintLayout id8UgMain2, LinearLayout leftLinearLayout2, Evoid8AppLeftBarBinding llLeftContainer2, Evoid8AppRightBarBinding llRightContainer2, LinearLayout rightLinearLayout2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appGridView = appGridView2;
        this.id8UgMain = id8UgMain2;
        this.leftLinearLayout = leftLinearLayout2;
        this.llLeftContainer = llLeftContainer2;
        this.llRightContainer = llRightContainer2;
        this.rightLinearLayout = rightLinearLayout2;
    }

    public LauncherViewModel getLauncherViewModel() {
        return this.mLauncherViewModel;
    }

    public AppViewModel getAppViewModel() {
        return this.mAppViewModel;
    }

    public static ActivityEvoid8AppsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEvoid8AppsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityEvoid8AppsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_evoid8_apps, root, attachToRoot, component);
    }

    public static ActivityEvoid8AppsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEvoid8AppsBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityEvoid8AppsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_evoid8_apps, null, false, component);
    }

    public static ActivityEvoid8AppsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEvoid8AppsBinding bind(View view, Object component) {
        return (ActivityEvoid8AppsBinding) bind(component, view, R.layout.activity_evoid8_apps);
    }
}
