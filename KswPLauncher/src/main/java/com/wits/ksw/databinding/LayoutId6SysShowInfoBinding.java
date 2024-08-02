package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LayoutId6SysShowInfoBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView tvInfoAppv;
    public final TextView tvInfoMcuv;
    public final TextView tvInfoSysv;

    private LayoutId6SysShowInfoBinding(RelativeLayout rootView2, TextView tvInfoAppv2, TextView tvInfoMcuv2, TextView tvInfoSysv2) {
        this.rootView = rootView2;
        this.tvInfoAppv = tvInfoAppv2;
        this.tvInfoMcuv = tvInfoMcuv2;
        this.tvInfoSysv = tvInfoSysv2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutId6SysShowInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6SysShowInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_sys_show_info, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6SysShowInfoBinding bind(View rootView2) {
        int id = R.id.tv_infoAppv;
        TextView tvInfoAppv2 = (TextView) rootView2.findViewById(R.id.tv_infoAppv);
        if (tvInfoAppv2 != null) {
            id = R.id.tv_infoMcuv;
            TextView tvInfoMcuv2 = (TextView) rootView2.findViewById(R.id.tv_infoMcuv);
            if (tvInfoMcuv2 != null) {
                id = R.id.tv_infoSysv;
                TextView tvInfoSysv2 = (TextView) rootView2.findViewById(R.id.tv_infoSysv);
                if (tvInfoSysv2 != null) {
                    return new LayoutId6SysShowInfoBinding((RelativeLayout) rootView2, tvInfoAppv2, tvInfoMcuv2, tvInfoSysv2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
