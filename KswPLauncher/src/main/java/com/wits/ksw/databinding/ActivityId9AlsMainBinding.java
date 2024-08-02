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
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.id9als.Id9VerticalViewPager;

public abstract class ActivityId9AlsMainBinding extends ViewDataBinding {
    public final ImageView id9AlsMainSetting;
    public final ImageView id9FocusBottomIv;
    public final ImageView id9FocusLeftIv;
    public final ImageView id9FocusRightIv;
    public final ImageView id9FreeWindow;
    public final ImageView id9FreeWindowFocus;
    @Bindable
    protected LauncherViewModel mLauncherViewModel;
    public final LinearLayout point;
    public final Id9VerticalViewPager viewPager;

    public abstract void setLauncherViewModel(LauncherViewModel launcherViewModel);

    protected ActivityId9AlsMainBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView id9AlsMainSetting2, ImageView id9FocusBottomIv2, ImageView id9FocusLeftIv2, ImageView id9FocusRightIv2, ImageView id9FreeWindow2, ImageView id9FreeWindowFocus2, LinearLayout point2, Id9VerticalViewPager viewPager2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id9AlsMainSetting = id9AlsMainSetting2;
        this.id9FocusBottomIv = id9FocusBottomIv2;
        this.id9FocusLeftIv = id9FocusLeftIv2;
        this.id9FocusRightIv = id9FocusRightIv2;
        this.id9FreeWindow = id9FreeWindow2;
        this.id9FreeWindowFocus = id9FreeWindowFocus2;
        this.point = point2;
        this.viewPager = viewPager2;
    }

    public LauncherViewModel getLauncherViewModel() {
        return this.mLauncherViewModel;
    }

    public static ActivityId9AlsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityId9AlsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityId9AlsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_id9_als_main, root, attachToRoot, component);
    }

    public static ActivityId9AlsMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityId9AlsMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityId9AlsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_id9_als_main, null, false, component);
    }

    public static ActivityId9AlsMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityId9AlsMainBinding bind(View view, Object component) {
        return (ActivityId9AlsMainBinding) bind(component, view, R.layout.activity_id9_als_main);
    }
}
