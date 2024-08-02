package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.RomeoViewModelV2;

public abstract class ActivityRomeoV2Binding extends ViewDataBinding {
    public final TextView dateTv;
    public final ImageView ivIcon;
    @Bindable
    protected RomeoViewModelV2 mViewModel;
    public final ImageView pageIndicator1;
    public final ImageView pageIndicator2;
    public final ImageView romeoApp;
    public final ImageView romeoIndicator1;
    public final ImageView romeoIndicator2;
    public final ImageView romeoIndicator3;
    public final ImageView romeoIndicator4;
    public final ImageView romeoIndicator5;
    public final ImageView romeoIndicator6;
    public final RecyclerView romeoMainRv;
    public final ImageView romeoMusic;
    public final ImageView romeoNavi;
    public final ImageView romeoPhone;
    public final ImageView romeoSetting;
    public final ImageView romeoVideo;
    public final TextView temperatureTv;
    public final TextView unitWeather;
    public final ConstraintLayout videoConstraintLayout;
    public final ImageView weatherImageView;

    public abstract void setViewModel(RomeoViewModelV2 romeoViewModelV2);

    protected ActivityRomeoV2Binding(Object _bindingComponent, View _root, int _localFieldCount, TextView dateTv2, ImageView ivIcon2, ImageView pageIndicator12, ImageView pageIndicator22, ImageView romeoApp2, ImageView romeoIndicator12, ImageView romeoIndicator22, ImageView romeoIndicator32, ImageView romeoIndicator42, ImageView romeoIndicator52, ImageView romeoIndicator62, RecyclerView romeoMainRv2, ImageView romeoMusic2, ImageView romeoNavi2, ImageView romeoPhone2, ImageView romeoSetting2, ImageView romeoVideo2, TextView temperatureTv2, TextView unitWeather2, ConstraintLayout videoConstraintLayout2, ImageView weatherImageView2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dateTv = dateTv2;
        this.ivIcon = ivIcon2;
        this.pageIndicator1 = pageIndicator12;
        this.pageIndicator2 = pageIndicator22;
        this.romeoApp = romeoApp2;
        this.romeoIndicator1 = romeoIndicator12;
        this.romeoIndicator2 = romeoIndicator22;
        this.romeoIndicator3 = romeoIndicator32;
        this.romeoIndicator4 = romeoIndicator42;
        this.romeoIndicator5 = romeoIndicator52;
        this.romeoIndicator6 = romeoIndicator62;
        this.romeoMainRv = romeoMainRv2;
        this.romeoMusic = romeoMusic2;
        this.romeoNavi = romeoNavi2;
        this.romeoPhone = romeoPhone2;
        this.romeoSetting = romeoSetting2;
        this.romeoVideo = romeoVideo2;
        this.temperatureTv = temperatureTv2;
        this.unitWeather = unitWeather2;
        this.videoConstraintLayout = videoConstraintLayout2;
        this.weatherImageView = weatherImageView2;
    }

    public RomeoViewModelV2 getViewModel() {
        return this.mViewModel;
    }

    public static ActivityRomeoV2Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRomeoV2Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityRomeoV2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_romeo_v2, root, attachToRoot, component);
    }

    public static ActivityRomeoV2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRomeoV2Binding inflate(LayoutInflater inflater, Object component) {
        return (ActivityRomeoV2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_romeo_v2, null, false, component);
    }

    public static ActivityRomeoV2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRomeoV2Binding bind(View view, Object component) {
        return (ActivityRomeoV2Binding) bind(component, view, R.layout.activity_romeo_v2);
    }
}
