package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.id9als.Id9VerticalViewPager;

public abstract class ActivityId9EditCardRtlBinding extends ViewDataBinding {
    public final ConstraintLayout id9EditBottom;
    public final ImageView id9EditModelLeft;
    public final ImageView id9EditModelRight;
    public final ImageView id9FreeWindow;
    @Bindable
    protected LauncherViewModel mLauncherViewModel;
    public final TextView modelTitleTv;
    public final LinearLayout point;
    public final Id9VerticalViewPager viewpager;

    public abstract void setLauncherViewModel(LauncherViewModel launcherViewModel);

    protected ActivityId9EditCardRtlBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout id9EditBottom2, ImageView id9EditModelLeft2, ImageView id9EditModelRight2, ImageView id9FreeWindow2, TextView modelTitleTv2, LinearLayout point2, Id9VerticalViewPager viewpager2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id9EditBottom = id9EditBottom2;
        this.id9EditModelLeft = id9EditModelLeft2;
        this.id9EditModelRight = id9EditModelRight2;
        this.id9FreeWindow = id9FreeWindow2;
        this.modelTitleTv = modelTitleTv2;
        this.point = point2;
        this.viewpager = viewpager2;
    }

    public LauncherViewModel getLauncherViewModel() {
        return this.mLauncherViewModel;
    }

    public static ActivityId9EditCardRtlBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityId9EditCardRtlBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityId9EditCardRtlBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_id9_edit_card_rtl, root, attachToRoot, component);
    }

    public static ActivityId9EditCardRtlBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityId9EditCardRtlBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityId9EditCardRtlBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_id9_edit_card_rtl, null, false, component);
    }

    public static ActivityId9EditCardRtlBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityId9EditCardRtlBinding bind(View view, Object component) {
        return (ActivityId9EditCardRtlBinding) bind(component, view, R.layout.activity_id9_edit_card_rtl);
    }
}
