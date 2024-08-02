package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import com.wits.ksw.R;

public final class Ntg6BrightnessControlPopupBinding implements ViewBinding {
    public final ImageView addBrImageView;
    public final ImageView closeImage;
    public final ConstraintLayout linearLayout;
    public final ImageView ntg6BrightnessGb;
    private final ConstraintLayout rootView;
    public final ImageView subBrImageView;

    private Ntg6BrightnessControlPopupBinding(ConstraintLayout rootView2, ImageView addBrImageView2, ImageView closeImage2, ConstraintLayout linearLayout2, ImageView ntg6BrightnessGb2, ImageView subBrImageView2) {
        this.rootView = rootView2;
        this.addBrImageView = addBrImageView2;
        this.closeImage = closeImage2;
        this.linearLayout = linearLayout2;
        this.ntg6BrightnessGb = ntg6BrightnessGb2;
        this.subBrImageView = subBrImageView2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Ntg6BrightnessControlPopupBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Ntg6BrightnessControlPopupBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.ntg6_brightness_control_popup, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static Ntg6BrightnessControlPopupBinding bind(View rootView2) {
        int id = R.id.addBrImageView;
        ImageView addBrImageView2 = (ImageView) rootView2.findViewById(R.id.addBrImageView);
        if (addBrImageView2 != null) {
            id = R.id.closeImage;
            ImageView closeImage2 = (ImageView) rootView2.findViewById(R.id.closeImage);
            if (closeImage2 != null) {
                ConstraintLayout linearLayout2 = (ConstraintLayout) rootView2;
                id = R.id.ntg6_brightness_gb;
                ImageView ntg6BrightnessGb2 = (ImageView) rootView2.findViewById(R.id.ntg6_brightness_gb);
                if (ntg6BrightnessGb2 != null) {
                    id = R.id.subBrImageView;
                    ImageView subBrImageView2 = (ImageView) rootView2.findViewById(R.id.subBrImageView);
                    if (subBrImageView2 != null) {
                        return new Ntg6BrightnessControlPopupBinding((ConstraintLayout) rootView2, addBrImageView2, closeImage2, linearLayout2, ntg6BrightnessGb2, subBrImageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
