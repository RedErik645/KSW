package com.wits.ksw.launcher.view.id8ug.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import com.wits.ksw.databinding.FragmentEvoid8MainDashBoardBinding;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import com.wits.ksw.launcher.view.id8ug.Id8UgViewManager;

public class Id8UgCarDashboardFragment extends Id8UgBaseFragment {
    private FragmentEvoid8MainDashBoardBinding binding;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public String setFragmentTag() {
        return Id8UgConstants.ID8UG_FRAGMENT_CAR_DASHBOARD;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public ViewBinding createDataBinding(LayoutInflater inflater, ViewGroup container) {
        FragmentEvoid8MainDashBoardBinding inflate = FragmentEvoid8MainDashBoardBinding.inflate(inflater, container, false);
        this.binding = inflate;
        return inflate;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public void initMainActivityData() {
        super.initMainActivityData();
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarDashboardFragment$IymLnjLY0MAetioVaFFOaqL6eU */

            public final void onClick(View view) {
                Id8UgCarDashboardFragment.this.lambda$initMainActivityData$0$Id8UgCarDashboardFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initMainActivityData$0$Id8UgCarDashboardFragment(View v) {
        Id8UgViewManager.getInstance().setOnClickLastRequestView(this.fragmentTag);
        this.mViewModel.openDashboard(v);
    }
}
