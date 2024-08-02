package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public abstract class ViewId9AlsModelBinding extends ViewDataBinding {
    public final ConstraintLayout id9CardView;
    public final ImageView id9HomeVideoIv;
    public final TextView id9HomeVideoTipsTv;
    public final TextView id9HomeVideoTitleTv;
    @Bindable
    protected LauncherViewModel mId9ViewModel;

    public abstract void setId9ViewModel(LauncherViewModel launcherViewModel);

    protected ViewId9AlsModelBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout id9CardView2, ImageView id9HomeVideoIv2, TextView id9HomeVideoTipsTv2, TextView id9HomeVideoTitleTv2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id9CardView = id9CardView2;
        this.id9HomeVideoIv = id9HomeVideoIv2;
        this.id9HomeVideoTipsTv = id9HomeVideoTipsTv2;
        this.id9HomeVideoTitleTv = id9HomeVideoTitleTv2;
    }

    public LauncherViewModel getId9ViewModel() {
        return this.mId9ViewModel;
    }

    public static ViewId9AlsModelBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsModelBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewId9AlsModelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_model, root, attachToRoot, component);
    }

    public static ViewId9AlsModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsModelBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewId9AlsModelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_model, null, false, component);
    }

    public static ViewId9AlsModelBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsModelBinding bind(View view, Object component) {
        return (ViewId9AlsModelBinding) bind(component, view, R.layout.view_id9_als_model);
    }
}
