package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class FragmentSettingGsBinding implements ViewBinding {
    public final ImageView ivMask;
    public final RelativeLayout llContainerGs;
    private final RelativeLayout rootView;

    private FragmentSettingGsBinding(RelativeLayout rootView2, ImageView ivMask2, RelativeLayout llContainerGs2) {
        this.rootView = rootView2;
        this.ivMask = ivMask2;
        this.llContainerGs = llContainerGs2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSettingGsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentSettingGsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_setting_gs, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentSettingGsBinding bind(View rootView2) {
        ImageView ivMask2 = (ImageView) rootView2.findViewById(R.id.iv_mask);
        if (ivMask2 != null) {
            return new FragmentSettingGsBinding((RelativeLayout) rootView2, ivMask2, (RelativeLayout) rootView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.iv_mask)));
    }
}
