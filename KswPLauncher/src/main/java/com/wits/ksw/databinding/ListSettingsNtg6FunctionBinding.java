package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class ListSettingsNtg6FunctionBinding implements ViewBinding {
    public final RelativeLayout relatNtg6functionItem;
    private final RelativeLayout rootView;
    public final MarqueeTextView tvFunctionItem;

    private ListSettingsNtg6FunctionBinding(RelativeLayout rootView2, RelativeLayout relatNtg6functionItem2, MarqueeTextView tvFunctionItem2) {
        this.rootView = rootView2;
        this.relatNtg6functionItem = relatNtg6functionItem2;
        this.tvFunctionItem = tvFunctionItem2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ListSettingsNtg6FunctionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ListSettingsNtg6FunctionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.list_settings_ntg6_function, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ListSettingsNtg6FunctionBinding bind(View rootView2) {
        RelativeLayout relatNtg6functionItem2 = (RelativeLayout) rootView2;
        MarqueeTextView tvFunctionItem2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_functionItem);
        if (tvFunctionItem2 != null) {
            return new ListSettingsNtg6FunctionBinding((RelativeLayout) rootView2, relatNtg6functionItem2, tvFunctionItem2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.tv_functionItem)));
    }
}
