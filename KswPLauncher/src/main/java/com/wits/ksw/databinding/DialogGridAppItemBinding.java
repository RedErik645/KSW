package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class DialogGridAppItemBinding implements ViewBinding {
    public final ImageView ivAppIcon;
    public final LinearLayout layoutLL;
    private final LinearLayout rootView;
    public final MarqueeTextView tvAppName;

    private DialogGridAppItemBinding(LinearLayout rootView2, ImageView ivAppIcon2, LinearLayout layoutLL2, MarqueeTextView tvAppName2) {
        this.rootView = rootView2;
        this.ivAppIcon = ivAppIcon2;
        this.layoutLL = layoutLL2;
        this.tvAppName = tvAppName2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogGridAppItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogGridAppItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_grid_app_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogGridAppItemBinding bind(View rootView2) {
        int id = R.id.iv_app_icon;
        ImageView ivAppIcon2 = (ImageView) rootView2.findViewById(R.id.iv_app_icon);
        if (ivAppIcon2 != null) {
            LinearLayout layoutLL2 = (LinearLayout) rootView2;
            id = R.id.tv_app_name;
            MarqueeTextView tvAppName2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_app_name);
            if (tvAppName2 != null) {
                return new DialogGridAppItemBinding((LinearLayout) rootView2, ivAppIcon2, layoutLL2, tvAppName2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
