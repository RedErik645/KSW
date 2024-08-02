package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.ColorArcProgressBar;

public final class Ntg6ControlBrightnessPopupBinding implements ViewBinding {
    public final TextView brightness;
    public final ColorArcProgressBar brightnessSeekBar;
    public final ImageView closeControl;
    public final ImageView imageView2;
    public final ConstraintLayout linearLayout;
    private final ConstraintLayout rootView;

    private Ntg6ControlBrightnessPopupBinding(ConstraintLayout rootView2, TextView brightness2, ColorArcProgressBar brightnessSeekBar2, ImageView closeControl2, ImageView imageView22, ConstraintLayout linearLayout2) {
        this.rootView = rootView2;
        this.brightness = brightness2;
        this.brightnessSeekBar = brightnessSeekBar2;
        this.closeControl = closeControl2;
        this.imageView2 = imageView22;
        this.linearLayout = linearLayout2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Ntg6ControlBrightnessPopupBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Ntg6ControlBrightnessPopupBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.ntg6_control_brightness_popup, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static Ntg6ControlBrightnessPopupBinding bind(View rootView2) {
        int id = R.id.brightness;
        TextView brightness2 = (TextView) rootView2.findViewById(R.id.brightness);
        if (brightness2 != null) {
            id = R.id.brightnessSeekBar;
            ColorArcProgressBar brightnessSeekBar2 = (ColorArcProgressBar) rootView2.findViewById(R.id.brightnessSeekBar);
            if (brightnessSeekBar2 != null) {
                id = R.id.closeControl;
                ImageView closeControl2 = (ImageView) rootView2.findViewById(R.id.closeControl);
                if (closeControl2 != null) {
                    id = R.id.imageView2;
                    ImageView imageView22 = (ImageView) rootView2.findViewById(R.id.imageView2);
                    if (imageView22 != null) {
                        return new Ntg6ControlBrightnessPopupBinding((ConstraintLayout) rootView2, brightness2, brightnessSeekBar2, closeControl2, imageView22, (ConstraintLayout) rootView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
