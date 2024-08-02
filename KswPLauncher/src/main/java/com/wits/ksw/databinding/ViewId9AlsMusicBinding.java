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
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.MarqueeTextView;

public abstract class ViewId9AlsMusicBinding extends ViewDataBinding {
    public final ConstraintLayout id9CardView;
    public final TextView id9HomeMusicTitleTv;
    public final ImageView id9MusicIcon;
    public final ImageView id9MusicNext;
    public final ImageView id9MusicPrev;
    @Bindable
    protected LauncherViewModel mId9ViewModel;
    public final MarqueeTextView tvTitle;
    public final TextView tvTotalTime;

    public abstract void setId9ViewModel(LauncherViewModel launcherViewModel);

    protected ViewId9AlsMusicBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout id9CardView2, TextView id9HomeMusicTitleTv2, ImageView id9MusicIcon2, ImageView id9MusicNext2, ImageView id9MusicPrev2, MarqueeTextView tvTitle2, TextView tvTotalTime2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id9CardView = id9CardView2;
        this.id9HomeMusicTitleTv = id9HomeMusicTitleTv2;
        this.id9MusicIcon = id9MusicIcon2;
        this.id9MusicNext = id9MusicNext2;
        this.id9MusicPrev = id9MusicPrev2;
        this.tvTitle = tvTitle2;
        this.tvTotalTime = tvTotalTime2;
    }

    public LauncherViewModel getId9ViewModel() {
        return this.mId9ViewModel;
    }

    public static ViewId9AlsMusicBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsMusicBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewId9AlsMusicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_music, root, attachToRoot, component);
    }

    public static ViewId9AlsMusicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsMusicBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewId9AlsMusicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_id9_als_music, null, false, component);
    }

    public static ViewId9AlsMusicBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewId9AlsMusicBinding bind(View view, Object component) {
        return (ViewId9AlsMusicBinding) bind(component, view, R.layout.view_id9_als_music);
    }
}
