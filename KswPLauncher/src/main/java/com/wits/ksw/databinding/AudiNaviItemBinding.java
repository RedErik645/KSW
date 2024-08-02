package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class AudiNaviItemBinding implements ViewBinding {
    public final ImageView naviItemIcon;
    public final RadioButton naviItemTitle;
    private final RelativeLayout rootView;

    private AudiNaviItemBinding(RelativeLayout rootView2, ImageView naviItemIcon2, RadioButton naviItemTitle2) {
        this.rootView = rootView2;
        this.naviItemIcon = naviItemIcon2;
        this.naviItemTitle = naviItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AudiNaviItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AudiNaviItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.audi_navi_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AudiNaviItemBinding bind(View rootView2) {
        int id = R.id.naviItemIcon;
        ImageView naviItemIcon2 = (ImageView) rootView2.findViewById(R.id.naviItemIcon);
        if (naviItemIcon2 != null) {
            id = R.id.naviItemTitle;
            RadioButton naviItemTitle2 = (RadioButton) rootView2.findViewById(R.id.naviItemTitle);
            if (naviItemTitle2 != null) {
                return new AudiNaviItemBinding((RelativeLayout) rootView2, naviItemIcon2, naviItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
