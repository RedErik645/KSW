package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FragmentPempSettingBinding implements ViewBinding {
    public final ImageView ivMask;
    public final RelativeLayout llContainer;
    private final RelativeLayout rootView;
    public final TextView tvDesc;

    private FragmentPempSettingBinding(RelativeLayout rootView2, ImageView ivMask2, RelativeLayout llContainer2, TextView tvDesc2) {
        this.rootView = rootView2;
        this.ivMask = ivMask2;
        this.llContainer = llContainer2;
        this.tvDesc = tvDesc2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPempSettingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentPempSettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_pemp_setting, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentPempSettingBinding bind(View rootView2) {
        int id = R.id.iv_mask;
        ImageView ivMask2 = (ImageView) rootView2.findViewById(R.id.iv_mask);
        if (ivMask2 != null) {
            RelativeLayout llContainer2 = (RelativeLayout) rootView2;
            id = R.id.tv_desc;
            TextView tvDesc2 = (TextView) rootView2.findViewById(R.id.tv_desc);
            if (tvDesc2 != null) {
                return new FragmentPempSettingBinding((RelativeLayout) rootView2, ivMask2, llContainer2, tvDesc2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
