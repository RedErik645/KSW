package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class FragmentAddWidgetBinding implements ViewBinding {
    public final ImageView ivMask;
    public final RelativeLayout llContainer;
    private final RelativeLayout rootView;

    private FragmentAddWidgetBinding(RelativeLayout rootView2, ImageView ivMask2, RelativeLayout llContainer2) {
        this.rootView = rootView2;
        this.ivMask = ivMask2;
        this.llContainer = llContainer2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAddWidgetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAddWidgetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_add_widget, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentAddWidgetBinding bind(View rootView2) {
        ImageView ivMask2 = (ImageView) rootView2.findViewById(R.id.iv_mask);
        if (ivMask2 != null) {
            return new FragmentAddWidgetBinding((RelativeLayout) rootView2, ivMask2, (RelativeLayout) rootView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.iv_mask)));
    }
}
