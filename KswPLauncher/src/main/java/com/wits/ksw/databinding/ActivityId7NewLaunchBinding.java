package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.id7_new.view.MySeepViewPage;

public final class ActivityId7NewLaunchBinding implements ViewBinding {
    public final ImageView imgIndexLeft;
    public final ImageView imgIndexRight;
    private final RelativeLayout rootView;
    public final MySeepViewPage vpIndex;

    private ActivityId7NewLaunchBinding(RelativeLayout rootView2, ImageView imgIndexLeft2, ImageView imgIndexRight2, MySeepViewPage vpIndex2) {
        this.rootView = rootView2;
        this.imgIndexLeft = imgIndexLeft2;
        this.imgIndexRight = imgIndexRight2;
        this.vpIndex = vpIndex2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityId7NewLaunchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityId7NewLaunchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_id7_new_launch, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityId7NewLaunchBinding bind(View rootView2) {
        int id = R.id.img_IndexLeft;
        ImageView imgIndexLeft2 = (ImageView) rootView2.findViewById(R.id.img_IndexLeft);
        if (imgIndexLeft2 != null) {
            id = R.id.img_IndexRight;
            ImageView imgIndexRight2 = (ImageView) rootView2.findViewById(R.id.img_IndexRight);
            if (imgIndexRight2 != null) {
                id = R.id.vpIndex;
                MySeepViewPage vpIndex2 = (MySeepViewPage) rootView2.findViewById(R.id.vpIndex);
                if (vpIndex2 != null) {
                    return new ActivityId7NewLaunchBinding((RelativeLayout) rootView2, imgIndexLeft2, imgIndexRight2, vpIndex2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
