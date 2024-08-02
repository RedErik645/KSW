package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.wits.ksw.R;

public final class LayoutSetImageTwoBinding implements ViewBinding {
    public final ImageView imgTwoDefaul;
    private final ScrollView rootView;

    private LayoutSetImageTwoBinding(ScrollView rootView2, ImageView imgTwoDefaul2) {
        this.rootView = rootView2;
        this.imgTwoDefaul = imgTwoDefaul2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static LayoutSetImageTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutSetImageTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_set_image_two, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutSetImageTwoBinding bind(View rootView2) {
        ImageView imgTwoDefaul2 = (ImageView) rootView2.findViewById(R.id.img_twoDefaul);
        if (imgTwoDefaul2 != null) {
            return new LayoutSetImageTwoBinding((ScrollView) rootView2, imgTwoDefaul2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.img_twoDefaul)));
    }
}
