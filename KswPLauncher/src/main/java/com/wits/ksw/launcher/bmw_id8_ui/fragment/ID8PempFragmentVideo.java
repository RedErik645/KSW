package com.wits.ksw.launcher.bmw_id8_ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.databinding.VideoEditorPempDataBinding;
import com.wits.ksw.launcher.bmw_id8_ui.ID8PempEditActivity;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnClickListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnDragListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.DragClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ID8PempFragmentVideo extends Fragment {
    private static final String TAG = "ID8PempFragmentVideo";
    public static final int iconResId = 2131169650;
    public static final String name = "VIDEO";
    public static final int nameResId = 2131493234;
    private VideoEditorPempDataBinding mEditBinding;
    private LauncherViewModel mViewModel;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        VideoEditorPempDataBinding videoEditorPempDataBinding = (VideoEditorPempDataBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_pemp_video_edit, container, false);
        this.mEditBinding = videoEditorPempDataBinding;
        videoEditorPempDataBinding.setMediaViewModel(this.mViewModel);
        View view = this.mEditBinding.getRoot();
        view.setOnDragListener(new CardId8PempOnDragListener(TAG, this, (ID8PempEditActivity) getActivity()));
        view.setOnLongClickListener(new DragClickListener(view, "VIDEO", R.drawable.pemp_id8_main_left_icon_video, R.string.ksw_id8_abbr_hd_video));
        view.setOnClickListener(new CardId8PempOnClickListener((ID8PempEditActivity) getActivity()));
        view.setTag("VIDEO");
        return view;
    }
}
