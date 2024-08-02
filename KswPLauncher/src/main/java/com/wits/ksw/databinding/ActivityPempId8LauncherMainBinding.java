package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public abstract class ActivityPempId8LauncherMainBinding extends ViewDataBinding {
    public final LinearLayout llContainer;
    public final Id8PempLauncherLeftBarBinding llLeftContainer;
    @Bindable
    protected LauncherViewModel mLauncherViewModel;
    public final HorizontalScrollView scrollView;

    public abstract void setLauncherViewModel(LauncherViewModel launcherViewModel);

    protected ActivityPempId8LauncherMainBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout llContainer2, Id8PempLauncherLeftBarBinding llLeftContainer2, HorizontalScrollView scrollView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.llContainer = llContainer2;
        this.llLeftContainer = llLeftContainer2;
        this.scrollView = scrollView2;
    }

    public LauncherViewModel getLauncherViewModel() {
        return this.mLauncherViewModel;
    }

    public static ActivityPempId8LauncherMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPempId8LauncherMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityPempId8LauncherMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_pemp_id8_launcher_main, root, attachToRoot, component);
    }

    public static ActivityPempId8LauncherMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPempId8LauncherMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityPempId8LauncherMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_pemp_id8_launcher_main, null, false, component);
    }

    public static ActivityPempId8LauncherMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPempId8LauncherMainBinding bind(View view, Object component) {
        return (ActivityPempId8LauncherMainBinding) bind(component, view, R.layout.activity_pemp_id8_launcher_main);
    }
}
