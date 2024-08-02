package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class ListSettingsId6FunctionBinding implements ViewBinding {
    public final RelativeLayout relatId6functionItem;
    private final RelativeLayout rootView;
    public final TextView tvFunctionItem;

    private ListSettingsId6FunctionBinding(RelativeLayout rootView2, RelativeLayout relatId6functionItem2, TextView tvFunctionItem2) {
        this.rootView = rootView2;
        this.relatId6functionItem = relatId6functionItem2;
        this.tvFunctionItem = tvFunctionItem2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ListSettingsId6FunctionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ListSettingsId6FunctionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.list_settings_id6_function, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ListSettingsId6FunctionBinding bind(View rootView2) {
        RelativeLayout relatId6functionItem2 = (RelativeLayout) rootView2;
        TextView tvFunctionItem2 = (TextView) rootView2.findViewById(R.id.tv_functionItem);
        if (tvFunctionItem2 != null) {
            return new ListSettingsId6FunctionBinding((RelativeLayout) rootView2, relatId6functionItem2, tvFunctionItem2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.tv_functionItem)));
    }
}
