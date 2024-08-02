package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class Alsid7ListSettingsLanguageBinding implements ViewBinding {
    public final ImageView imgFunctionItem;
    private final RelativeLayout rootView;
    public final RtlRadioButton tvFunctionItem;

    private Alsid7ListSettingsLanguageBinding(RelativeLayout rootView2, ImageView imgFunctionItem2, RtlRadioButton tvFunctionItem2) {
        this.rootView = rootView2;
        this.imgFunctionItem = imgFunctionItem2;
        this.tvFunctionItem = tvFunctionItem2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Alsid7ListSettingsLanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Alsid7ListSettingsLanguageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.alsid7_list_settings_language, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static Alsid7ListSettingsLanguageBinding bind(View rootView2) {
        int id = R.id.img_functionItem;
        ImageView imgFunctionItem2 = (ImageView) rootView2.findViewById(R.id.img_functionItem);
        if (imgFunctionItem2 != null) {
            id = R.id.tv_functionItem;
            RtlRadioButton tvFunctionItem2 = (RtlRadioButton) rootView2.findViewById(R.id.tv_functionItem);
            if (tvFunctionItem2 != null) {
                return new Alsid7ListSettingsLanguageBinding((RelativeLayout) rootView2, imgFunctionItem2, tvFunctionItem2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
