package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;

public abstract class BenzMbuxThirdCardBinding extends ViewDataBinding {
    public final AppCompatImageView benzMbuxThirdCardBg;
    public final AppCompatTextView benzMbuxThirdCardContent;
    public final AppCompatImageView benzMbuxThirdCardIcon;
    public final AppCompatTextView benzMbuxThirdCardTitle;
    @Bindable
    protected BcVieModel mViewModel;

    public abstract void setViewModel(BcVieModel bcVieModel);

    protected BenzMbuxThirdCardBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageView benzMbuxThirdCardBg2, AppCompatTextView benzMbuxThirdCardContent2, AppCompatImageView benzMbuxThirdCardIcon2, AppCompatTextView benzMbuxThirdCardTitle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.benzMbuxThirdCardBg = benzMbuxThirdCardBg2;
        this.benzMbuxThirdCardContent = benzMbuxThirdCardContent2;
        this.benzMbuxThirdCardIcon = benzMbuxThirdCardIcon2;
        this.benzMbuxThirdCardTitle = benzMbuxThirdCardTitle2;
    }

    public BcVieModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzMbuxThirdCardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxThirdCardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzMbuxThirdCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_third_card, root, attachToRoot, component);
    }

    public static BenzMbuxThirdCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxThirdCardBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzMbuxThirdCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_mbux_third_card, null, false, component);
    }

    public static BenzMbuxThirdCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzMbuxThirdCardBinding bind(View view, Object component) {
        return (BenzMbuxThirdCardBinding) bind(component, view, R.layout.benz_mbux_third_card);
    }
}
