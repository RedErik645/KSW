package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.AppInfo;

public abstract class ItemEvoid8AppRoundBinding extends ViewDataBinding {
    public final ConstraintLayout BcItemConstraintLayout;
    public final FrameLayout appIconView;
    public final TextView badgeNumber;
    @Bindable
    protected AppInfo mListItem;
    public final ImageView nameImageView;
    public final TextView textView;

    public abstract void setListItem(AppInfo appInfo);

    protected ItemEvoid8AppRoundBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout BcItemConstraintLayout2, FrameLayout appIconView2, TextView badgeNumber2, ImageView nameImageView2, TextView textView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.BcItemConstraintLayout = BcItemConstraintLayout2;
        this.appIconView = appIconView2;
        this.badgeNumber = badgeNumber2;
        this.nameImageView = nameImageView2;
        this.textView = textView2;
    }

    public AppInfo getListItem() {
        return this.mListItem;
    }

    public static ItemEvoid8AppRoundBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEvoid8AppRoundBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ItemEvoid8AppRoundBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_evoid8_app_round, root, attachToRoot, component);
    }

    public static ItemEvoid8AppRoundBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEvoid8AppRoundBinding inflate(LayoutInflater inflater, Object component) {
        return (ItemEvoid8AppRoundBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_evoid8_app_round, null, false, component);
    }

    public static ItemEvoid8AppRoundBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEvoid8AppRoundBinding bind(View view, Object component) {
        return (ItemEvoid8AppRoundBinding) bind(component, view, R.layout.item_evoid8_app_round);
    }
}
