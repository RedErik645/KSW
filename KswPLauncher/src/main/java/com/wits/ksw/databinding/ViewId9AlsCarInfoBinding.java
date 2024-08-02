package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public abstract class ViewId9AlsCarInfoBinding extends ViewDataBinding {
    public final ConstraintLayout id9CardView;
    public final TextView id9HomeVideoTipsTv;
    public final TextView id9HomeVideoTitleTv;
    @Bindable
    protected LauncherViewModel mId9ViewModel;

    public abstract void setId9ViewModel(LauncherViewModel launcherViewModel);

    protected ViewId9AlsCarInfoBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout id9CardView2, TextView id9HomeVideoTipsTv2, TextView id9HomeVideoTitleTv2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id9CardView = id9CardView2;
        this.id9HomeVideoTipsTv = id9HomeVideoTipsTv2;
        this.id9HomeVideoTitleTv = id9HomeVideoTitleTv2;
    }

    public LauncherViewModel getId9ViewModel() {
        return this.mId9ViewModel;
    }

    public static ViewId9AlsCarInfoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsCarInfoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewId9AlsCarInfoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_car_info, root, attachToRoot, component);
    }

    public static ViewId9AlsCarInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsCarInfoBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewId9AlsCarInfoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_car_info, null, false, component);
    }

    public static ViewId9AlsCarInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsCarInfoBinding bind(View view, Object component) {
        return (ViewId9AlsCarInfoBinding) bind(component, view, R.layout.view_id9_als_car_info);
    }
}
