package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.MarqueeTextView;

public abstract class MusicPempDataBinding extends ViewDataBinding {
    public final ImageView ivMask;
    public final ImageView ivMusicAlbum;
    public final RelativeLayout llContainer;
    @Bindable
    protected LauncherViewModel mMediaViewModel;
    public final ImageView pempId8MusicNext;
    public final ImageView pempId8MusicPlay;
    public final ImageView pempId8MusicPrev;
    public final TextView tvSinger;
    public final MarqueeTextView tvSongTitle;

    public abstract void setMediaViewModel(LauncherViewModel launcherViewModel);

    protected MusicPempDataBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivMask2, ImageView ivMusicAlbum2, RelativeLayout llContainer2, ImageView pempId8MusicNext2, ImageView pempId8MusicPlay2, ImageView pempId8MusicPrev2, TextView tvSinger2, MarqueeTextView tvSongTitle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivMask = ivMask2;
        this.ivMusicAlbum = ivMusicAlbum2;
        this.llContainer = llContainer2;
        this.pempId8MusicNext = pempId8MusicNext2;
        this.pempId8MusicPlay = pempId8MusicPlay2;
        this.pempId8MusicPrev = pempId8MusicPrev2;
        this.tvSinger = tvSinger2;
        this.tvSongTitle = tvSongTitle2;
    }

    public LauncherViewModel getMediaViewModel() {
        return this.mMediaViewModel;
    }

    public static MusicPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MusicPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (MusicPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_music, root, attachToRoot, component);
    }

    public static MusicPempDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MusicPempDataBinding inflate(LayoutInflater inflater, Object component) {
        return (MusicPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_music, null, false, component);
    }

    public static MusicPempDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MusicPempDataBinding bind(View view, Object component) {
        return (MusicPempDataBinding) bind(component, view, R.layout.fragment_pemp_music);
    }
}
