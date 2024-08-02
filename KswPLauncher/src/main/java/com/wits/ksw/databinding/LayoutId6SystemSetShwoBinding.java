package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlCheckBox;

public final class LayoutId6SystemSetShwoBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RtlCheckBox scboxSysDcgj;
    public final RtlCheckBox scboxSysDcld;
    public final RtlCheckBox scboxSysHjs;
    public final RtlCheckBox scboxSysXcjz;

    private LayoutId6SystemSetShwoBinding(RelativeLayout rootView2, RtlCheckBox scboxSysDcgj2, RtlCheckBox scboxSysDcld2, RtlCheckBox scboxSysHjs2, RtlCheckBox scboxSysXcjz2) {
        this.rootView = rootView2;
        this.scboxSysDcgj = scboxSysDcgj2;
        this.scboxSysDcld = scboxSysDcld2;
        this.scboxSysHjs = scboxSysHjs2;
        this.scboxSysXcjz = scboxSysXcjz2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutId6SystemSetShwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6SystemSetShwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_system_set_shwo, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6SystemSetShwoBinding bind(View rootView2) {
        int id = R.id.scbox_sysDcgj;
        RtlCheckBox scboxSysDcgj2 = (RtlCheckBox) rootView2.findViewById(R.id.scbox_sysDcgj);
        if (scboxSysDcgj2 != null) {
            id = R.id.scbox_sysDcld;
            RtlCheckBox scboxSysDcld2 = (RtlCheckBox) rootView2.findViewById(R.id.scbox_sysDcld);
            if (scboxSysDcld2 != null) {
                id = R.id.scbox_sysHjs;
                RtlCheckBox scboxSysHjs2 = (RtlCheckBox) rootView2.findViewById(R.id.scbox_sysHjs);
                if (scboxSysHjs2 != null) {
                    id = R.id.scbox_sysXcjz;
                    RtlCheckBox scboxSysXcjz2 = (RtlCheckBox) rootView2.findViewById(R.id.scbox_sysXcjz);
                    if (scboxSysXcjz2 != null) {
                        return new LayoutId6SystemSetShwoBinding((RelativeLayout) rootView2, scboxSysDcgj2, scboxSysDcld2, scboxSysHjs2, scboxSysXcjz2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
