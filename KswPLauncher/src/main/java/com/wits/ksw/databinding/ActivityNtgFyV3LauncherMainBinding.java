package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public abstract class ActivityNtgFyV3LauncherMainBinding extends ViewDataBinding {
    public final ImageView controlBtn;
    public final NtgFyV3LauncherBottomBarBinding llBottomContainer;
    public final NtgFyV3LauncherLeftBarBinding llLeftContainer;
    public final NtgFyV3AllappsPopLayoutBinding llPopwindowContainer;
    @Bindable
    protected Ntg6v3LauncherViewModel mLauncherViewModel;
    public final RelativeLayout ntg6v3LauncherMainBg;

    public abstract void setLauncherViewModel(Ntg6v3LauncherViewModel ntg6v3LauncherViewModel);

    protected ActivityNtgFyV3LauncherMainBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView controlBtn2, NtgFyV3LauncherBottomBarBinding llBottomContainer2, NtgFyV3LauncherLeftBarBinding llLeftContainer2, NtgFyV3AllappsPopLayoutBinding llPopwindowContainer2, RelativeLayout ntg6v3LauncherMainBg2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.controlBtn = controlBtn2;
        this.llBottomContainer = llBottomContainer2;
        this.llLeftContainer = llLeftContainer2;
        this.llPopwindowContainer = llPopwindowContainer2;
        this.ntg6v3LauncherMainBg = ntg6v3LauncherMainBg2;
    }

    public Ntg6v3LauncherViewModel getLauncherViewModel() {
        return this.mLauncherViewModel;
    }

    public static ActivityNtgFyV3LauncherMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtgFyV3LauncherMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityNtgFyV3LauncherMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_ntg_fy_v3_launcher_main, root, attachToRoot, component);
    }

    public static ActivityNtgFyV3LauncherMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtgFyV3LauncherMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityNtgFyV3LauncherMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_ntg_fy_v3_launcher_main, null, false, component);
    }

    public static ActivityNtgFyV3LauncherMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityNtgFyV3LauncherMainBinding bind(View view, Object component) {
        return (ActivityNtgFyV3LauncherMainBinding) bind(component, view, R.layout.activity_ntg_fy_v3_launcher_main);
    }
}
