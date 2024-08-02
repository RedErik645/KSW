package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FragmentPemp3rdBinding implements ViewBinding {
    public final ImageView iv;
    public final ImageView iv3rdBg;
    public final ImageView iv3rdDivider;
    public final ImageView ivMask;
    public final RelativeLayout llContainer;
    private final RelativeLayout rootView;
    public final TextView tvName;

    private FragmentPemp3rdBinding(RelativeLayout rootView2, ImageView iv2, ImageView iv3rdBg2, ImageView iv3rdDivider2, ImageView ivMask2, RelativeLayout llContainer2, TextView tvName2) {
        this.rootView = rootView2;
        this.iv = iv2;
        this.iv3rdBg = iv3rdBg2;
        this.iv3rdDivider = iv3rdDivider2;
        this.ivMask = ivMask2;
        this.llContainer = llContainer2;
        this.tvName = tvName2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPemp3rdBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentPemp3rdBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_pemp_3rd, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentPemp3rdBinding bind(View rootView2) {
        int id = R.id.iv;
        ImageView iv2 = (ImageView) rootView2.findViewById(R.id.iv);
        if (iv2 != null) {
            id = R.id.iv_3rd_bg;
            ImageView iv3rdBg2 = (ImageView) rootView2.findViewById(R.id.iv_3rd_bg);
            if (iv3rdBg2 != null) {
                id = R.id.iv_3rd_divider;
                ImageView iv3rdDivider2 = (ImageView) rootView2.findViewById(R.id.iv_3rd_divider);
                if (iv3rdDivider2 != null) {
                    id = R.id.iv_mask;
                    ImageView ivMask2 = (ImageView) rootView2.findViewById(R.id.iv_mask);
                    if (ivMask2 != null) {
                        RelativeLayout llContainer2 = (RelativeLayout) rootView2;
                        id = R.id.tv_name;
                        TextView tvName2 = (TextView) rootView2.findViewById(R.id.tv_name);
                        if (tvName2 != null) {
                            return new FragmentPemp3rdBinding((RelativeLayout) rootView2, iv2, iv3rdBg2, iv3rdDivider2, ivMask2, llContainer2, tvName2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
