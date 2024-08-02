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

public abstract class ViewId9AlsAddCardBinding extends ViewDataBinding {
    public final ConstraintLayout id9CardView;
    public final TextView id9HomeVideoTitleTv;
    @Bindable
    protected LauncherViewModel mId9ViewModel;

    public abstract void setId9ViewModel(LauncherViewModel launcherViewModel);

    protected ViewId9AlsAddCardBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout id9CardView2, TextView id9HomeVideoTitleTv2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id9CardView = id9CardView2;
        this.id9HomeVideoTitleTv = id9HomeVideoTitleTv2;
    }

    public LauncherViewModel getId9ViewModel() {
        return this.mId9ViewModel;
    }

    public static ViewId9AlsAddCardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsAddCardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewId9AlsAddCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_add_card, root, attachToRoot, component);
    }

    public static ViewId9AlsAddCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsAddCardBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewId9AlsAddCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_add_card, null, false, component);
    }

    public static ViewId9AlsAddCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsAddCardBinding bind(View view, Object component) {
        return (ViewId9AlsAddCardBinding) bind(component, view, R.layout.view_id9_als_add_card);
    }
}
