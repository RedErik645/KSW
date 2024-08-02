package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class Ntg6v3AllAppItemBinding implements ViewBinding {
    public final ImageView nameImageView;
    public final RelativeLayout ntgfyv3ItemIv;
    public final RelativeLayout ntgfyv3ItemRl;
    private final RelativeLayout rootView;
    public final TextView textView;

    private Ntg6v3AllAppItemBinding(RelativeLayout rootView2, ImageView nameImageView2, RelativeLayout ntgfyv3ItemIv2, RelativeLayout ntgfyv3ItemRl2, TextView textView2) {
        this.rootView = rootView2;
        this.nameImageView = nameImageView2;
        this.ntgfyv3ItemIv = ntgfyv3ItemIv2;
        this.ntgfyv3ItemRl = ntgfyv3ItemRl2;
        this.textView = textView2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Ntg6v3AllAppItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Ntg6v3AllAppItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.ntg6v3_all_app_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static Ntg6v3AllAppItemBinding bind(View rootView2) {
        int id = R.id.nameImageView;
        ImageView nameImageView2 = (ImageView) rootView2.findViewById(R.id.nameImageView);
        if (nameImageView2 != null) {
            id = R.id.ntgfyv3_item_iv;
            RelativeLayout ntgfyv3ItemIv2 = (RelativeLayout) rootView2.findViewById(R.id.ntgfyv3_item_iv);
            if (ntgfyv3ItemIv2 != null) {
                RelativeLayout ntgfyv3ItemRl2 = (RelativeLayout) rootView2;
                id = R.id.textView;
                TextView textView2 = (TextView) rootView2.findViewById(R.id.textView);
                if (textView2 != null) {
                    return new Ntg6v3AllAppItemBinding((RelativeLayout) rootView2, nameImageView2, ntgfyv3ItemIv2, ntgfyv3ItemRl2, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
