package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class LexusLayoutSetImageTwoBinding implements ViewBinding {
    public final ImageView imgTwoDefaulRight;
    private final RelativeLayout rootView;

    private LexusLayoutSetImageTwoBinding(RelativeLayout rootView2, ImageView imgTwoDefaulRight2) {
        this.rootView = rootView2;
        this.imgTwoDefaulRight = imgTwoDefaulRight2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LexusLayoutSetImageTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LexusLayoutSetImageTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.lexus_layout_set_image_two, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LexusLayoutSetImageTwoBinding bind(View rootView2) {
        ImageView imgTwoDefaulRight2 = (ImageView) rootView2.findViewById(R.id.img_twoDefaul_right);
        if (imgTwoDefaulRight2 != null) {
            return new LexusLayoutSetImageTwoBinding((RelativeLayout) rootView2, imgTwoDefaulRight2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.img_twoDefaul_right)));
    }
}
