package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public abstract class ActivityEvoid8MainEditBinding extends ViewDataBinding {
    public final FrameLayout flContent1;
    public final FrameLayout flContent2;
    public final FrameLayout flContent3;
    public final FrameLayout flContent4;
    public final FrameLayout flContent5;
    public final FrameLayout flContent6;
    public final FrameLayout flContent7;
    public final FrameLayout flContent8;
    public final ConstraintLayout id8UgMain;
    public final ImageView id8UgTop;
    public final LinearLayout llContainer;
    @Bindable
    protected LauncherViewModel mLauncherViewModel;
    public final HorizontalScrollView scrollView;

    public abstract void setLauncherViewModel(LauncherViewModel launcherViewModel);

    protected ActivityEvoid8MainEditBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flContent12, FrameLayout flContent22, FrameLayout flContent32, FrameLayout flContent42, FrameLayout flContent52, FrameLayout flContent62, FrameLayout flContent72, FrameLayout flContent82, ConstraintLayout id8UgMain2, ImageView id8UgTop2, LinearLayout llContainer2, HorizontalScrollView scrollView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.flContent1 = flContent12;
        this.flContent2 = flContent22;
        this.flContent3 = flContent32;
        this.flContent4 = flContent42;
        this.flContent5 = flContent52;
        this.flContent6 = flContent62;
        this.flContent7 = flContent72;
        this.flContent8 = flContent82;
        this.id8UgMain = id8UgMain2;
        this.id8UgTop = id8UgTop2;
        this.llContainer = llContainer2;
        this.scrollView = scrollView2;
    }

    public LauncherViewModel getLauncherViewModel() {
        return this.mLauncherViewModel;
    }

    public static ActivityEvoid8MainEditBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEvoid8MainEditBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityEvoid8MainEditBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_evoid8_main_edit, root, attachToRoot, component);
    }

    public static ActivityEvoid8MainEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEvoid8MainEditBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityEvoid8MainEditBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_evoid8_main_edit, null, false, component);
    }

    public static ActivityEvoid8MainEditBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEvoid8MainEditBinding bind(View view, Object component) {
        return (ActivityEvoid8MainEditBinding) bind(component, view, R.layout.activity_evoid8_main_edit);
    }
}
