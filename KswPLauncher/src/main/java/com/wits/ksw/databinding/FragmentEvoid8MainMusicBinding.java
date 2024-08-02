package com.wits.ksw.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.id8ug.Id8UgLauncherViewModel;

public abstract class FragmentEvoid8MainMusicBinding extends ViewDataBinding {
    public final ImageView id8MusicIcon;
    public final ImageView id8MusicIcon1;
    public final SeekBar id8MusicSeekBar;
    public final TextView id8UgCardViewTitle;
    public final ImageView id8UgChangeBtIv;
    public final ImageView id8UgChangeBtUp;
    public final LinearLayout id8UgChangeLl;
    public final ImageView id8UgChangeMusicIv;
    public final ConstraintLayout id8UgMusicBottomCl;
    public final ConstraintLayout id8UgMusicView;
    public final ImageView id9MusicNext;
    public final ImageView id9MusicPrev;
    @Bindable
    protected Id8UgLauncherViewModel mId8ViewModel;

    public abstract void setId8ViewModel(Id8UgLauncherViewModel id8UgLauncherViewModel);

    protected FragmentEvoid8MainMusicBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView id8MusicIcon2, ImageView id8MusicIcon12, SeekBar id8MusicSeekBar2, TextView id8UgCardViewTitle2, ImageView id8UgChangeBtIv2, ImageView id8UgChangeBtUp2, LinearLayout id8UgChangeLl2, ImageView id8UgChangeMusicIv2, ConstraintLayout id8UgMusicBottomCl2, ConstraintLayout id8UgMusicView2, ImageView id9MusicNext2, ImageView id9MusicPrev2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.id8MusicIcon = id8MusicIcon2;
        this.id8MusicIcon1 = id8MusicIcon12;
        this.id8MusicSeekBar = id8MusicSeekBar2;
        this.id8UgCardViewTitle = id8UgCardViewTitle2;
        this.id8UgChangeBtIv = id8UgChangeBtIv2;
        this.id8UgChangeBtUp = id8UgChangeBtUp2;
        this.id8UgChangeLl = id8UgChangeLl2;
        this.id8UgChangeMusicIv = id8UgChangeMusicIv2;
        this.id8UgMusicBottomCl = id8UgMusicBottomCl2;
        this.id8UgMusicView = id8UgMusicView2;
        this.id9MusicNext = id9MusicNext2;
        this.id9MusicPrev = id9MusicPrev2;
    }

    public Id8UgLauncherViewModel getId8ViewModel() {
        return this.mId8ViewModel;
    }

    public static FragmentEvoid8MainMusicBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEvoid8MainMusicBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentEvoid8MainMusicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_evoid8_main_music, root, attachToRoot, component);
    }

    public static FragmentEvoid8MainMusicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEvoid8MainMusicBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentEvoid8MainMusicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_evoid8_main_music, null, false, component);
    }

    public static FragmentEvoid8MainMusicBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEvoid8MainMusicBinding bind(View view, Object component) {
        return (FragmentEvoid8MainMusicBinding) bind(component, view, R.layout.fragment_evoid8_main_music);
    }
}
