package com.wits.ksw.launcher.view.benzgs;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FraBenzgsTwoBinding;
import java.util.ArrayList;
import java.util.List;

public class BenzGsFrametTwo extends Fragment {
    private FraBenzgsTwoBinding binding;
    private List<View> childViews = null;
    private BenzGsViewMoel viewModel;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FraBenzgsTwoBinding fraBenzgsTwoBinding = (FraBenzgsTwoBinding) DataBindingUtil.inflate(inflater, R.layout.fra_benzgs_two, null, false);
        this.binding = fraBenzgsTwoBinding;
        View view = fraBenzgsTwoBinding.getRoot();
        this.childViews = getAllChildViews(view);
        return view;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BenzGsViewMoel benzGsViewMoel = (BenzGsViewMoel) ViewModelProviders.of(getActivity()).get(BenzGsViewMoel.class);
        this.viewModel = benzGsViewMoel;
        this.binding.setVm(benzGsViewMoel);
        for (final int i = 0; i < this.childViews.size(); i++) {
            this.childViews.get(i).setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.benzgs.BenzGsFrametTwo.AnonymousClass1 */

                public void onClick(View v) {
                    BenzGsFrametTwo.this.viewModel.onClick(i + 5);
                    BenzGsFrametTwo.this.setSelected(i);
                }
            });
        }
    }

    public void setSelected(int index) {
        int i = 0;
        while (i < this.childViews.size()) {
            this.childViews.get(i).setSelected(i == index);
            i++;
        }
    }

    private List<View> getAllChildViews(View view) {
        List<View> allchildren = new ArrayList<>();
        if (view instanceof LinearLayout) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                allchildren.add(viewchild);
                allchildren.addAll(getAllChildViews(viewchild));
            }
        }
        return allchildren;
    }
}