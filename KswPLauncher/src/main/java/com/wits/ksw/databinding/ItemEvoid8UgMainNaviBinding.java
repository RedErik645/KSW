package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class ItemEvoid8UgMainNaviBinding implements ViewBinding {
    public final ImageView iconIv;
    public final ImageView picCheckIv;
    private final RelativeLayout rootView;

    private ItemEvoid8UgMainNaviBinding(RelativeLayout rootView2, ImageView iconIv2, ImageView picCheckIv2) {
        this.rootView = rootView2;
        this.iconIv = iconIv2;
        this.picCheckIv = picCheckIv2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemEvoid8UgMainNaviBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemEvoid8UgMainNaviBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_evoid8_ug_main_navi, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemEvoid8UgMainNaviBinding bind(View rootView2) {
        int id = R.id.icon_iv;
        ImageView iconIv2 = (ImageView) rootView2.findViewById(R.id.icon_iv);
        if (iconIv2 != null) {
            id = R.id.picCheckIv;
            ImageView picCheckIv2 = (ImageView) rootView2.findViewById(R.id.picCheckIv);
            if (picCheckIv2 != null) {
                return new ItemEvoid8UgMainNaviBinding((RelativeLayout) rootView2, iconIv2, picCheckIv2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
