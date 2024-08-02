package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.MarqueeTextView;

public abstract class MusicEditorPempDataBinding extends ViewDataBinding {
    public final ImageView ivMainIconMusic;
    public final LinearLayout layout;
    @Bindable
    protected LauncherViewModel mMediaViewModel;
    public final ImageView pempId8MusicPlay;
    public final TextView tvSinger;
    public final MarqueeTextView tvSongTitle;

    public abstract void setMediaViewModel(LauncherViewModel launcherViewModel);

    protected MusicEditorPempDataBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivMainIconMusic2, LinearLayout layout2, ImageView pempId8MusicPlay2, TextView tvSinger2, MarqueeTextView tvSongTitle2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivMainIconMusic = ivMainIconMusic2;
        this.layout = layout2;
        this.pempId8MusicPlay = pempId8MusicPlay2;
        this.tvSinger = tvSinger2;
        this.tvSongTitle = tvSongTitle2;
    }

    public LauncherViewModel getMediaViewModel() {
        return this.mMediaViewModel;
    }

    public static MusicEditorPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MusicEditorPempDataBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (MusicEditorPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_music_edit, root, attachToRoot, component);
    }

    public static MusicEditorPempDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MusicEditorPempDataBinding inflate(LayoutInflater inflater, Object component) {
        return (MusicEditorPempDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pemp_music_edit, null, false, component);
    }

    public static MusicEditorPempDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MusicEditorPempDataBinding bind(View view, Object component) {
        return (MusicEditorPempDataBinding) bind(component, view, R.layout.fragment_pemp_music_edit);
    }
}
