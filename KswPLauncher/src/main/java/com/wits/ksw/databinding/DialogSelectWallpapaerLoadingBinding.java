package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class DialogSelectWallpapaerLoadingBinding implements ViewBinding {
    public final ImageView loadingIv;
    private final RelativeLayout rootView;

    private DialogSelectWallpapaerLoadingBinding(RelativeLayout rootView2, ImageView loadingIv2) {
        this.rootView = rootView2;
        this.loadingIv = loadingIv2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogSelectWallpapaerLoadingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogSelectWallpapaerLoadingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_select_wallpapaer_loading, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogSelectWallpapaerLoadingBinding bind(View rootView2) {
        ImageView loadingIv2 = (ImageView) rootView2.findViewById(R.id.loading_iv);
        if (loadingIv2 != null) {
            return new DialogSelectWallpapaerLoadingBinding((RelativeLayout) rootView2, loadingIv2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.loading_iv)));
    }
}
