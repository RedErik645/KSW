package com.wits.ksw.launcher.view.bmwevoid6gs;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FraBmwEvoId6GsOneBinding;
import java.util.ArrayList;
import java.util.List;

public class Bmwid6gsFragmentOne extends Fragment {
    private static final String TAG = ("KswApplication." + Bmwid6gsFragmentOne.class.getSimpleName());
    private FraBmwEvoId6GsOneBinding binding;
    private List<View> childViews = null;
    private BmwId6gsViewMode viewModel;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FraBmwEvoId6GsOneBinding fraBmwEvoId6GsOneBinding = (FraBmwEvoId6GsOneBinding) DataBindingUtil.inflate(inflater, R.layout.fra_bmw_evo_id6_gs_one, null, false);
        this.binding = fraBmwEvoId6GsOneBinding;
        View view = fraBmwEvoId6GsOneBinding.getRoot();
        this.childViews = getAllChildViews(view);
        return view;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BmwId6gsViewMode bmwId6gsViewMode = (BmwId6gsViewMode) ViewModelProviders.of(getActivity()).get(BmwId6gsViewMode.class);
        this.viewModel = bmwId6gsViewMode;
        this.binding.setVm(bmwId6gsViewMode);
        for (final int i = 0; i < this.childViews.size(); i++) {
            Log.i(TAG, "onActivityCreated: " + i);
            this.childViews.get(i).setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.bmwevoid6gs.Bmwid6gsFragmentOne.AnonymousClass1 */

                public void onClick(View v) {
                    Bmwid6gsFragmentOne.this.viewModel.setIndex(i);
                    Bmwid6gsFragmentOne.this.viewModel.onClick(v, i);
                }
            });
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