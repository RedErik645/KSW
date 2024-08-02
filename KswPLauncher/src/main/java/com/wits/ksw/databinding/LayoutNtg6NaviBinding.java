package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LayoutNtg6NaviBinding implements ViewBinding {
    public final ImageView imgTwoBack;
    public final ImageView naviImageView;
    public final RelativeLayout relateShext;
    private final RelativeLayout rootView;
    public final TextView tvNaviapp;
    public final TextView tvNavihy;
    public final View tvTwoMsg;

    private LayoutNtg6NaviBinding(RelativeLayout rootView2, ImageView imgTwoBack2, ImageView naviImageView2, RelativeLayout relateShext2, TextView tvNaviapp2, TextView tvNavihy2, View tvTwoMsg2) {
        this.rootView = rootView2;
        this.imgTwoBack = imgTwoBack2;
        this.naviImageView = naviImageView2;
        this.relateShext = relateShext2;
        this.tvNaviapp = tvNaviapp2;
        this.tvNavihy = tvNavihy2;
        this.tvTwoMsg = tvTwoMsg2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutNtg6NaviBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutNtg6NaviBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_ntg6_navi, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutNtg6NaviBinding bind(View rootView2) {
        int id = R.id.img_TwoBack;
        ImageView imgTwoBack2 = (ImageView) rootView2.findViewById(R.id.img_TwoBack);
        if (imgTwoBack2 != null) {
            id = R.id.naviImageView;
            ImageView naviImageView2 = (ImageView) rootView2.findViewById(R.id.naviImageView);
            if (naviImageView2 != null) {
                id = R.id.relate_shext;
                RelativeLayout relateShext2 = (RelativeLayout) rootView2.findViewById(R.id.relate_shext);
                if (relateShext2 != null) {
                    id = R.id.tv_naviapp;
                    TextView tvNaviapp2 = (TextView) rootView2.findViewById(R.id.tv_naviapp);
                    if (tvNaviapp2 != null) {
                        id = R.id.tv_navihy;
                        TextView tvNavihy2 = (TextView) rootView2.findViewById(R.id.tv_navihy);
                        if (tvNavihy2 != null) {
                            id = R.id.tv_TwoMsg;
                            View tvTwoMsg2 = rootView2.findViewById(R.id.tv_TwoMsg);
                            if (tvTwoMsg2 != null) {
                                return new LayoutNtg6NaviBinding((RelativeLayout) rootView2, imgTwoBack2, naviImageView2, relateShext2, tvNaviapp2, tvNavihy2, tvTwoMsg2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
