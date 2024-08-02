package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public abstract class PhoneEditorPempDataBinding extends ViewDataBinding {
    public final LinearLayout layout;
    @Bindable
    protected LauncherViewModel mBtViewModel;
    public final TextView tvDesc;

    public abstract void setBtViewModel(LauncherViewModel launcherViewModel);

    protected PhoneEditorPempDataBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout layout2, TextView tvDesc2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.layout = layout2;
        this.tvDesc = tvDesc2;
    }

    public LauncherViewModel getBtViewModel() {
        return this.mBtViewModel;
    }

    public static PhoneEditorPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneEditorPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (PhoneEditorPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_phone_edit, root, attachToRoot, component);
    }

    public static PhoneEditorPempDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneEditorPempDataBinding inflate(LayoutInflater inflater, Object component) {
        return (PhoneEditorPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_phone_edit, null, false, component);
    }

    public static PhoneEditorPempDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneEditorPempDataBinding bind(View view, Object component) {
        return (PhoneEditorPempDataBinding) bind(component, view, R.layout.fragment_pemp_phone_edit);
    }
}
