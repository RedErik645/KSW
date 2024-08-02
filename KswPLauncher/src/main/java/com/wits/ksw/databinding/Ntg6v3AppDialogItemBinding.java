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
import com.wits.ksw.launcher.bean.AppInfo;

public abstract class Ntg6v3AppDialogItemBinding extends ViewDataBinding {
    public final ConstraintLayout BcItemConstraintLayout;
    @Bindable
    protected AppInfo mNtg6v3listItem;
    public final ImageView nameImageView;
    public final TextView textView;

    public abstract void setNtg6v3listItem(AppInfo appInfo);

    protected Ntg6v3AppDialogItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout BcItemConstraintLayout2, ImageView nameImageView2, TextView textView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.BcItemConstraintLayout = BcItemConstraintLayout2;
        this.nameImageView = nameImageView2;
        this.textView = textView2;
    }

    public AppInfo getNtg6v3listItem() {
        return this.mNtg6v3listItem;
    }

    public static Ntg6v3AppDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3AppDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Ntg6v3AppDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_app_dialog_item, root, attachToRoot, component);
    }

    public static Ntg6v3AppDialogItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3AppDialogItemBinding inflate(LayoutInflater inflater, Object component) {
        return (Ntg6v3AppDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntg6v3_app_dialog_item, null, false, component);
    }

    public static Ntg6v3AppDialogItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntg6v3AppDialogItemBinding bind(View view, Object component) {
        return (Ntg6v3AppDialogItemBinding) bind(component, view, R.layout.ntg6v3_app_dialog_item);
    }
}
