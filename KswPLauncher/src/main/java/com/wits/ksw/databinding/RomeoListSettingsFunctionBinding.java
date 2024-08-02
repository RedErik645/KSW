package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;

public final class RomeoListSettingsFunctionBinding implements ViewBinding {
    public final LinearLayout relatFunctionItem;
    private final LinearLayout rootView;
    public final ImageView tvFunctionItem;

    private RomeoListSettingsFunctionBinding(LinearLayout rootView2, LinearLayout relatFunctionItem2, ImageView tvFunctionItem2) {
        this.rootView = rootView2;
        this.relatFunctionItem = relatFunctionItem2;
        this.tvFunctionItem = tvFunctionItem2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RomeoListSettingsFunctionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RomeoListSettingsFunctionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.romeo_list_settings_function, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RomeoListSettingsFunctionBinding bind(View rootView2) {
        LinearLayout relatFunctionItem2 = (LinearLayout) rootView2;
        ImageView tvFunctionItem2 = (ImageView) rootView2.findViewById(R.id.tv_functionItem);
        if (tvFunctionItem2 != null) {
            return new RomeoListSettingsFunctionBinding((LinearLayout) rootView2, relatFunctionItem2, tvFunctionItem2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.tv_functionItem)));
    }
}
