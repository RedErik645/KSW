package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public abstract class NtgFyV3LauncherLeftBarBinding extends ViewDataBinding {
    public final ImageView ivLeft1;
    public final ImageView ivLeft2;
    public final ImageView ivLeft3;
    public final ImageView ivLeft4;
    public final LinearLayout llLeft1;
    public final LinearLayout llLeft2;
    public final LinearLayout llLeft3;
    public final LinearLayout llLeft4;
    public final LinearLayout llLeftBarContainer;
    @Bindable
    protected Ntg6v3LauncherViewModel mLeftViewModel;

    public abstract void setLeftViewModel(Ntg6v3LauncherViewModel ntg6v3LauncherViewModel);

    protected NtgFyV3LauncherLeftBarBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivLeft12, ImageView ivLeft22, ImageView ivLeft32, ImageView ivLeft42, LinearLayout llLeft12, LinearLayout llLeft22, LinearLayout llLeft32, LinearLayout llLeft42, LinearLayout llLeftBarContainer2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivLeft1 = ivLeft12;
        this.ivLeft2 = ivLeft22;
        this.ivLeft3 = ivLeft32;
        this.ivLeft4 = ivLeft42;
        this.llLeft1 = llLeft12;
        this.llLeft2 = llLeft22;
        this.llLeft3 = llLeft32;
        this.llLeft4 = llLeft42;
        this.llLeftBarContainer = llLeftBarContainer2;
    }

    public Ntg6v3LauncherViewModel getLeftViewModel() {
        return this.mLeftViewModel;
    }

    public static NtgFyV3LauncherLeftBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NtgFyV3LauncherLeftBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (NtgFyV3LauncherLeftBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg_fy_v3_launcher_left_bar, root, attachToRoot, component);
    }

    public static NtgFyV3LauncherLeftBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NtgFyV3LauncherLeftBarBinding inflate(LayoutInflater inflater, Object component) {
        return (NtgFyV3LauncherLeftBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg_fy_v3_launcher_left_bar, null, false, component);
    }

    public static NtgFyV3LauncherLeftBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NtgFyV3LauncherLeftBarBinding bind(View view, Object component) {
        return (NtgFyV3LauncherLeftBarBinding) bind(component, view, R.layout.ntg_fy_v3_launcher_left_bar);
    }
}
