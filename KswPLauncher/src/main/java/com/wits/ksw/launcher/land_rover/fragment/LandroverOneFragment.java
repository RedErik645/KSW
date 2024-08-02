package com.wits.ksw.launcher.land_rover.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.launcher.land_rover.model.LandroverViewModel;

public class LandroverOneFragment extends Fragment {
    private com.wits.ksw.databinding.LandroverOneFragment binding;
    private LandroverViewModel viewModel;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("CarFragment", "onCreate: CarFragment");
        this.viewModel = (LandroverViewModel) ViewModelProviders.of(getActivity()).get(LandroverViewModel.class);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.viewModel.hicar.set(false);
        com.wits.ksw.databinding.LandroverOneFragment landroverOneFragment = (com.wits.ksw.databinding.LandroverOneFragment) DataBindingUtil.inflate(inflater, R.layout.landrover_main_fragment_one, null, false);
        this.binding = landroverOneFragment;
        return landroverOneFragment.getRoot();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        com.wits.ksw.databinding.LandroverOneFragment landroverOneFragment = this.binding;
        if (landroverOneFragment != null) {
            landroverOneFragment.setViewModel(this.viewModel);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}