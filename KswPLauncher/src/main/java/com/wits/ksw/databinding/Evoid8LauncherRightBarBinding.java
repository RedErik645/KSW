package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public abstract class Evoid8LauncherRightBarBinding extends ViewDataBinding {
    public final ImageView ivRight1;
    public final ImageView ivRight2;
    public final ImageView ivRight3;
    public final ImageView ivRight4;
    public final ImageView ivRight5;
    public final ImageView llRightBarContainer;
    @Bindable
    protected LauncherViewModel mLeftViewModel;

    public abstract void setLeftViewModel(LauncherViewModel launcherViewModel);

    protected Evoid8LauncherRightBarBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivRight12, ImageView ivRight22, ImageView ivRight32, ImageView ivRight42, ImageView ivRight52, ImageView llRightBarContainer2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivRight1 = ivRight12;
        this.ivRight2 = ivRight22;
        this.ivRight3 = ivRight32;
        this.ivRight4 = ivRight42;
        this.ivRight5 = ivRight52;
        this.llRightBarContainer = llRightBarContainer2;
    }

    public LauncherViewModel getLeftViewModel() {
        return this.mLeftViewModel;
    }

    public static Evoid8LauncherRightBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Evoid8LauncherRightBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Evoid8LauncherRightBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.evoid8_launcher_right_bar, root, attachToRoot, component);
    }

    public static Evoid8LauncherRightBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Evoid8LauncherRightBarBinding inflate(LayoutInflater inflater, Object component) {
        return (Evoid8LauncherRightBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.evoid8_launcher_right_bar, null, false, component);
    }

    public static Evoid8LauncherRightBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Evoid8LauncherRightBarBinding bind(View view, Object component) {
        return (Evoid8LauncherRightBarBinding) bind(component, view, R.layout.evoid8_launcher_right_bar);
    }
}
