package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class ItemId9ChangeModelBinding implements ViewBinding {
    public final ImageView modelLineIv;
    public final TextView modelStatusTv;
    public final TextView modelTitleTv;
    public final ImageView picIv;
    private final ConstraintLayout rootView;
    public final TextView wallpaperTipsTv;

    private ItemId9ChangeModelBinding(ConstraintLayout rootView2, ImageView modelLineIv2, TextView modelStatusTv2, TextView modelTitleTv2, ImageView picIv2, TextView wallpaperTipsTv2) {
        this.rootView = rootView2;
        this.modelLineIv = modelLineIv2;
        this.modelStatusTv = modelStatusTv2;
        this.modelTitleTv = modelTitleTv2;
        this.picIv = picIv2;
        this.wallpaperTipsTv = wallpaperTipsTv2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemId9ChangeModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemId9ChangeModelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_id9_change_model, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemId9ChangeModelBinding bind(View rootView2) {
        int id = R.id.model_line_iv;
        ImageView modelLineIv2 = (ImageView) rootView2.findViewById(R.id.model_line_iv);
        if (modelLineIv2 != null) {
            id = R.id.model_status_tv;
            TextView modelStatusTv2 = (TextView) rootView2.findViewById(R.id.model_status_tv);
            if (modelStatusTv2 != null) {
                id = R.id.model_title_tv;
                TextView modelTitleTv2 = (TextView) rootView2.findViewById(R.id.model_title_tv);
                if (modelTitleTv2 != null) {
                    id = R.id.picIv;
                    ImageView picIv2 = (ImageView) rootView2.findViewById(R.id.picIv);
                    if (picIv2 != null) {
                        id = R.id.wallpaper_tips_tv;
                        TextView wallpaperTipsTv2 = (TextView) rootView2.findViewById(R.id.wallpaper_tips_tv);
                        if (wallpaperTipsTv2 != null) {
                            return new ItemId9ChangeModelBinding((ConstraintLayout) rootView2, modelLineIv2, modelStatusTv2, modelTitleTv2, picIv2, wallpaperTipsTv2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
