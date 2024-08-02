package com.wits.ksw.launcher.bmw_id8_ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.databinding.MusicEditorPempDataBinding;
import com.wits.ksw.launcher.bmw_id8_ui.ID8PempEditActivity;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnClickListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnDragListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.DragClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ID8PempFragmentMusic extends Fragment {
    private static final String TAG = "ID8PempFragmentMusic";
    public static final int iconResId = 2131169647;
    public static final String name = "MUSIC";
    public static final int nameResId = 2131493247;
    private MusicEditorPempDataBinding mEditBinding;
    private LauncherViewModel mViewModel;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        MusicEditorPempDataBinding musicEditorPempDataBinding = (MusicEditorPempDataBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_pemp_music_edit, container, false);
        this.mEditBinding = musicEditorPempDataBinding;
        musicEditorPempDataBinding.setMediaViewModel(this.mViewModel);
        View view = this.mEditBinding.getRoot();
        view.setOnDragListener(new CardId8PempOnDragListener(TAG, this, (ID8PempEditActivity) getActivity()));
        view.setOnLongClickListener(new DragClickListener(view, "MUSIC", R.drawable.pemp_id8_main_left_icon_music, R.string.ksw_id8_music));
        view.setOnClickListener(new CardId8PempOnClickListener((ID8PempEditActivity) getActivity()));
        view.setTag("MUSIC");
        return view;
    }
}
