package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class LexusListSettingsFunctionBinding implements ViewBinding {
    public final RelativeLayout relatFunctionItem;
    private final RelativeLayout rootView;
    public final ImageView tvFunctionItem;

    private LexusListSettingsFunctionBinding(RelativeLayout rootView2, RelativeLayout relatFunctionItem2, ImageView tvFunctionItem2) {
        this.rootView = rootView2;
        this.relatFunctionItem = relatFunctionItem2;
        this.tvFunctionItem = tvFunctionItem2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LexusListSettingsFunctionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LexusListSettingsFunctionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.lexus_list_settings_function, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LexusListSettingsFunctionBinding bind(View rootView2) {
        RelativeLayout relatFunctionItem2 = (RelativeLayout) rootView2;
        ImageView tvFunctionItem2 = (ImageView) rootView2.findViewById(R.id.tv_functionItem);
        if (tvFunctionItem2 != null) {
            return new LexusListSettingsFunctionBinding((RelativeLayout) rootView2, relatFunctionItem2, tvFunctionItem2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.tv_functionItem)));
    }
}
