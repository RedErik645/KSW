package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlTextView;

public final class ListTvLayoutBinding implements ViewBinding {
    public final RelativeLayout relatListTv;
    private final RelativeLayout rootView;
    public final RtlTextView tvMgs;

    private ListTvLayoutBinding(RelativeLayout rootView2, RelativeLayout relatListTv2, RtlTextView tvMgs2) {
        this.rootView = rootView2;
        this.relatListTv = relatListTv2;
        this.tvMgs = tvMgs2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ListTvLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ListTvLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.list_tv_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ListTvLayoutBinding bind(View rootView2) {
        RelativeLayout relatListTv2 = (RelativeLayout) rootView2;
        RtlTextView tvMgs2 = (RtlTextView) rootView2.findViewById(R.id.tv_mgs);
        if (tvMgs2 != null) {
            return new ListTvLayoutBinding((RelativeLayout) rootView2, relatListTv2, tvMgs2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.tv_mgs)));
    }
}
