package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public abstract class Ntg6v3AppDialogBinding extends ViewDataBinding {
    public final ListView dialogListview;
    @Bindable
    protected Ntg6v3LauncherViewModel mBottomViewModel;
    public final TextView title;

    public abstract void setBottomViewModel(Ntg6v3LauncherViewModel ntg6v3LauncherViewModel);

    protected Ntg6v3AppDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, ListView dialogListview2, TextView title2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dialogListview = dialogListview2;
        this.title = title2;
    }

    public Ntg6v3LauncherViewModel getBottomViewModel() {
        return this.mBottomViewModel;
    }

    public static Ntg6v3AppDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3AppDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Ntg6v3AppDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_app_dialog, root, attachToRoot, component);
    }

    public static Ntg6v3AppDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3AppDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (Ntg6v3AppDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_app_dialog, null, false, component);
    }

    public static Ntg6v3AppDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3AppDialogBinding bind(View view, Object component) {
        return (Ntg6v3AppDialogBinding) bind(component, view, R.layout.ntg6v3_app_dialog);
    }
}
