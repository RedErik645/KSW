package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class Ntg6v3SelectWallpapaerDialogLoadingBinding implements ViewBinding {
    public final ImageView ntg6v3LoadingIv;
    private final RelativeLayout rootView;

    private Ntg6v3SelectWallpapaerDialogLoadingBinding(RelativeLayout rootView2, ImageView ntg6v3LoadingIv2) {
        this.rootView = rootView2;
        this.ntg6v3LoadingIv = ntg6v3LoadingIv2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Ntg6v3SelectWallpapaerDialogLoadingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Ntg6v3SelectWallpapaerDialogLoadingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.ntg6v3_select_wallpapaer_dialog_loading, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static Ntg6v3SelectWallpapaerDialogLoadingBinding bind(View rootView2) {
        ImageView ntg6v3LoadingIv2 = (ImageView) rootView2.findViewById(R.id.ntg6v3_loading_iv);
        if (ntg6v3LoadingIv2 != null) {
            return new Ntg6v3SelectWallpapaerDialogLoadingBinding((RelativeLayout) rootView2, ntg6v3LoadingIv2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.ntg6v3_loading_iv)));
    }
}
