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
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;

public abstract class DialogId9MainSettingRtlBinding extends ViewDataBinding {
    public final TextView id9SettingCamera;
    public final ConstraintLayout id9SettingCl;
    public final FrameLayout id9SettingFl;
    public final ImageView id9SettingIv;
    public final TextView id9SettingTime;
    public final TextView id9SettingUnit;
    @Bindable
    protected Id9AlsConstants mId9Constants;

    public abstract void setId9Constants(Id9AlsConstants id9AlsConstants);

    protected DialogId9MainSettingRtlBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView id9SettingCamera2, ConstraintLayout id9SettingCl2, FrameLayout id9SettingFl2, ImageView id9SettingIv2, TextView id9SettingTime2, TextView id9SettingUnit2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id9SettingCamera = id9SettingCamera2;
        this.id9SettingCl = id9SettingCl2;
        this.id9SettingFl = id9SettingFl2;
        this.id9SettingIv = id9SettingIv2;
        this.id9SettingTime = id9SettingTime2;
        this.id9SettingUnit = id9SettingUnit2;
    }

    public Id9AlsConstants getId9Constants() {
        return this.mId9Constants;
    }

    public static DialogId9MainSettingRtlBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogId9MainSettingRtlBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogId9MainSettingRtlBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_id9_main_setting_rtl, root, attachToRoot, component);
    }

    public static DialogId9MainSettingRtlBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogId9MainSettingRtlBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogId9MainSettingRtlBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_id9_main_setting_rtl, null, false, component);
    }

    public static DialogId9MainSettingRtlBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogId9MainSettingRtlBinding bind(View view, Object component) {
        return (DialogId9MainSettingRtlBinding) bind(component, view, R.layout.dialog_id9_main_setting_rtl);
    }
}
