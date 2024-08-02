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

public abstract class RoundAppItemBinding extends ViewDataBinding {
    public final ConstraintLayout BcItemConstraintLayout;
    @Bindable
    protected AppInfo mListItem;
    public final ImageView nameImageView;
    public final TextView textView;

    public abstract void setListItem(AppInfo appInfo);

    protected RoundAppItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout BcItemConstraintLayout2, ImageView nameImageView2, TextView textView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.BcItemConstraintLayout = BcItemConstraintLayout2;
        this.nameImageView = nameImageView2;
        this.textView = textView2;
    }

    public AppInfo getListItem() {
        return this.mListItem;
    }

    public static RoundAppItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RoundAppItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (RoundAppItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.round_app_item, root, attachToRoot, component);
    }

    public static RoundAppItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RoundAppItemBinding inflate(LayoutInflater inflater, Object component) {
        return (RoundAppItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.round_app_item, null, false, component);
    }

    public static RoundAppItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RoundAppItemBinding bind(View view, Object component) {
        return (RoundAppItemBinding) bind(component, view, R.layout.round_app_item);
    }
}
