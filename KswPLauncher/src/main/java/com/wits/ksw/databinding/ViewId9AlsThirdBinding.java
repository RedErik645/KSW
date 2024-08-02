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

public abstract class ViewId9AlsThirdBinding extends ViewDataBinding {
    public final ConstraintLayout id9CardView;
    public final LinearLayout id9HomeDeleteLl;
    public final ImageView id9HomeThirdIv;
    public final TextView id9HomeThirdTitleTv;
    public final TextView id9HomeVideoTipsTv;
    @Bindable
    protected LauncherViewModel mId9ViewModel;

    public abstract void setId9ViewModel(LauncherViewModel launcherViewModel);

    protected ViewId9AlsThirdBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout id9CardView2, LinearLayout id9HomeDeleteLl2, ImageView id9HomeThirdIv2, TextView id9HomeThirdTitleTv2, TextView id9HomeVideoTipsTv2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id9CardView = id9CardView2;
        this.id9HomeDeleteLl = id9HomeDeleteLl2;
        this.id9HomeThirdIv = id9HomeThirdIv2;
        this.id9HomeThirdTitleTv = id9HomeThirdTitleTv2;
        this.id9HomeVideoTipsTv = id9HomeVideoTipsTv2;
    }

    public LauncherViewModel getId9ViewModel() {
        return this.mId9ViewModel;
    }

    public static ViewId9AlsThirdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsThirdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewId9AlsThirdBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_third, root, attachToRoot, component);
    }

    public static ViewId9AlsThirdBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsThirdBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewId9AlsThirdBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_third, null, false, component);
    }

    public static ViewId9AlsThirdBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsThirdBinding bind(View view, Object component) {
        return (ViewId9AlsThirdBinding) bind(component, view, R.layout.view_id9_als_third);
    }
}
