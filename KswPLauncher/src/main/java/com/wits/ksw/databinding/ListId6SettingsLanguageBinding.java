package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class ListId6SettingsLanguageBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RtlRadioButton tvFunctionItem;

    private ListId6SettingsLanguageBinding(RelativeLayout rootView2, RtlRadioButton tvFunctionItem2) {
        this.rootView = rootView2;
        this.tvFunctionItem = tvFunctionItem2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ListId6SettingsLanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ListId6SettingsLanguageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.list_id6_settings_language, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ListId6SettingsLanguageBinding bind(View rootView2) {
        RtlRadioButton tvFunctionItem2 = (RtlRadioButton) rootView2.findViewById(R.id.tv_functionItem);
        if (tvFunctionItem2 != null) {
            return new ListId6SettingsLanguageBinding((RelativeLayout) rootView2, tvFunctionItem2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.tv_functionItem)));
    }
}
