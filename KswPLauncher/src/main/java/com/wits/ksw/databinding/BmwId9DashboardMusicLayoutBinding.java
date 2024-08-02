package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.DashboardViewModel;
import com.wits.ksw.launcher.view.CustomizeSeekBar;

public abstract class BmwId9DashboardMusicLayoutBinding extends ViewDataBinding {
    public final TextView bmwId9DashboardMusicName;
    public final CustomizeSeekBar bmwId9DashboardMusicSeekbar;
    @Bindable
    protected DashboardViewModel mViewModel;

    public abstract void setViewModel(DashboardViewModel dashboardViewModel);

    protected BmwId9DashboardMusicLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView bmwId9DashboardMusicName2, CustomizeSeekBar bmwId9DashboardMusicSeekbar2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bmwId9DashboardMusicName = bmwId9DashboardMusicName2;
        this.bmwId9DashboardMusicSeekbar = bmwId9DashboardMusicSeekbar2;
    }

    public DashboardViewModel getViewModel() {
        return this.mViewModel;
    }

    public static BmwId9DashboardMusicLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9DashboardMusicLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BmwId9DashboardMusicLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_dashboard_music_layout, root, attachToRoot, component);
    }

    public static BmwId9DashboardMusicLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9DashboardMusicLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BmwId9DashboardMusicLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bmw_id9_dashboard_music_layout, null, false, component);
    }

    public static BmwId9DashboardMusicLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BmwId9DashboardMusicLayoutBinding bind(View view, Object component) {
        return (BmwId9DashboardMusicLayoutBinding) bind(component, view, R.layout.bmw_id9_dashboard_music_layout);
    }
}
