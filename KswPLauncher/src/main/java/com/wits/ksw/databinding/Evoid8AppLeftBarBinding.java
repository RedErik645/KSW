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

public abstract class Evoid8AppLeftBarBinding extends ViewDataBinding {
    public final ImageView ivLeft1;
    public final ImageView ivLeft2;
    public final ImageView ivLeft3;
    public final ImageView ivLeft4;
    public final ImageView ivLeft5;
    public final ImageView llLeftBarContainer;
    @Bindable
    protected LauncherViewModel mLeftViewModel;

    public abstract void setLeftViewModel(LauncherViewModel launcherViewModel);

    protected Evoid8AppLeftBarBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivLeft12, ImageView ivLeft22, ImageView ivLeft32, ImageView ivLeft42, ImageView ivLeft52, ImageView llLeftBarContainer2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivLeft1 = ivLeft12;
        this.ivLeft2 = ivLeft22;
        this.ivLeft3 = ivLeft32;
        this.ivLeft4 = ivLeft42;
        this.ivLeft5 = ivLeft52;
        this.llLeftBarContainer = llLeftBarContainer2;
    }

    public LauncherViewModel getLeftViewModel() {
        return this.mLeftViewModel;
    }

    public static Evoid8AppLeftBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Evoid8AppLeftBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Evoid8AppLeftBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.evoid8_app_left_bar, root, attachToRoot, component);
    }

    public static Evoid8AppLeftBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Evoid8AppLeftBarBinding inflate(LayoutInflater inflater, Object component) {
        return (Evoid8AppLeftBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.evoid8_app_left_bar, null, false, component);
    }

    public static Evoid8AppLeftBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Evoid8AppLeftBarBinding bind(View view, Object component) {
        return (Evoid8AppLeftBarBinding) bind(component, view, R.layout.evoid8_app_left_bar);
    }
}
