package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.NtgFyV3Item;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public abstract class Ntgfyv3ItemBinding extends ViewDataBinding {
    @Bindable
    protected NtgFyV3Item mListItem;
    @Bindable
    protected Ntg6v3LauncherViewModel mMappsVieModel;
    public final LinearLayout naviCusLinearLayout;
    public final LinearLayout ntgfyv3ItemIv;

    public abstract void setListItem(NtgFyV3Item ntgFyV3Item);

    public abstract void setMappsVieModel(Ntg6v3LauncherViewModel ntg6v3LauncherViewModel);

    protected Ntgfyv3ItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout naviCusLinearLayout2, LinearLayout ntgfyv3ItemIv2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.naviCusLinearLayout = naviCusLinearLayout2;
        this.ntgfyv3ItemIv = ntgfyv3ItemIv2;
    }

    public NtgFyV3Item getListItem() {
        return this.mListItem;
    }

    public Ntg6v3LauncherViewModel getMappsVieModel() {
        return this.mMappsVieModel;
    }

    public static Ntgfyv3ItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntgfyv3ItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Ntgfyv3ItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntgfyv3_item, root, attachToRoot, component);
    }

    public static Ntgfyv3ItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntgfyv3ItemBinding inflate(LayoutInflater inflater, Object component) {
        return (Ntgfyv3ItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ntgfyv3_item, null, false, component);
    }

    public static Ntgfyv3ItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Ntgfyv3ItemBinding bind(View view, Object component) {
        return (Ntgfyv3ItemBinding) bind(component, view, R.layout.ntgfyv3_item);
    }
}
