package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class ItemId9WallpaperSelectPicBinding implements ViewBinding {
    public final RelativeLayout BcItemConstraintLayout;
    public final ImageView picCheckIv;
    public final ImageView picIv;
    private final RelativeLayout rootView;

    private ItemId9WallpaperSelectPicBinding(RelativeLayout rootView2, RelativeLayout BcItemConstraintLayout2, ImageView picCheckIv2, ImageView picIv2) {
        this.rootView = rootView2;
        this.BcItemConstraintLayout = BcItemConstraintLayout2;
        this.picCheckIv = picCheckIv2;
        this.picIv = picIv2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemId9WallpaperSelectPicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemId9WallpaperSelectPicBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_id9_wallpaper_select_pic, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemId9WallpaperSelectPicBinding bind(View rootView2) {
        RelativeLayout BcItemConstraintLayout2 = (RelativeLayout) rootView2;
        int id = R.id.picCheckIv;
        ImageView picCheckIv2 = (ImageView) rootView2.findViewById(R.id.picCheckIv);
        if (picCheckIv2 != null) {
            id = R.id.picIv;
            ImageView picIv2 = (ImageView) rootView2.findViewById(R.id.picIv);
            if (picIv2 != null) {
                return new ItemId9WallpaperSelectPicBinding((RelativeLayout) rootView2, BcItemConstraintLayout2, picCheckIv2, picIv2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
