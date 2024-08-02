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

public abstract class BenzNtgFyThirdCardBinding extends ViewDataBinding {
    public final AppCompatImageView benzMbuxThirdCardBg;
    public final AppCompatTextView benzMbuxThirdCardContent;
    public final AppCompatImageView benzMbuxThirdCardIcon;
    public final AppCompatTextView benzMbuxThirdCardTitle;
    @Bindable
    protected BcVieModel mViewModel;

    public abstract void setViewModel(BcVieModel bcVieModel);

    protected BenzNtgFyThirdCardBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageView benzMbuxThirdCardBg2, AppCompatTextView benzMbuxThirdCardContent2, AppCompatImageView benzMbuxThirdCardIcon2, AppCompatTextView benzMbuxThirdCardTitle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.benzMbuxThirdCardBg = benzMbuxThirdCardBg2;
        this.benzMbuxThirdCardContent = benzMbuxThirdCardContent2;
        this.benzMbuxThirdCardIcon = benzMbuxThirdCardIcon2;
        this.benzMbuxThirdCardTitle = benzMbuxThirdCardTitle2;
    }

    public BcVieModel getViewModel() {
        return this.mViewModel;
    }

    public static BenzNtgFyThirdCardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtgFyThirdCardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BenzNtgFyThirdCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_ntg_fy_third_card, root, attachToRoot, component);
    }

    public static BenzNtgFyThirdCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtgFyThirdCardBinding inflate(LayoutInflater inflater, Object component) {
        return (BenzNtgFyThirdCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.benz_ntg_fy_third_card, null, false, component);
    }

    public static BenzNtgFyThirdCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BenzNtgFyThirdCardBinding bind(View view, Object component) {
        return (BenzNtgFyThirdCardBinding) bind(component, view, R.layout.benz_ntg_fy_third_card);
    }
}
