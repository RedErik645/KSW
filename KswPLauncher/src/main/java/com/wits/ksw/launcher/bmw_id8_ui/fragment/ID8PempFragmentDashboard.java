package com.wits.ksw.launcher.bmw_id8_ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FragmentPempDashboardEditBinding;
import com.wits.ksw.launcher.bmw_id8_ui.ID8PempEditActivity;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnClickListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.CardId8PempOnDragListener;
import com.wits.ksw.launcher.bmw_id8_ui.listener.DragClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ID8PempFragmentDashboard extends Fragment {
    private static final String TAG = "ID8PempFragmentDashboard";
    public static final int iconResId = 2131169645;
    public static final String name = "DASHBOARD";
    public static final int nameResId = 2131493242;
    private FragmentPempDashboardEditBinding mEditBinding;
    private LauncherViewModel mViewModel;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        FragmentPempDashboardEditBinding fragmentPempDashboardEditBinding = (FragmentPempDashboardEditBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_pemp_dashboard_edit, container, false);
        this.mEditBinding = fragmentPempDashboardEditBinding;
        fragmentPempDashboardEditBinding.setDashboardViewModel(this.mViewModel);
        View view = this.mEditBinding.getRoot();
        view.setOnDragListener(new CardId8PempOnDragListener(TAG, this, (ID8PempEditActivity) getActivity()));
        view.setOnLongClickListener(new DragClickListener(view, "DASHBOARD", R.drawable.pemp_id8_main_left_icon_dashboard, R.string.ksw_id8_dashboard));
        view.setOnClickListener(new CardId8PempOnClickListener((ID8PempEditActivity) getActivity()));
        view.setTag("DASHBOARD");
        return view;
    }
}
