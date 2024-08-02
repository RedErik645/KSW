package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;

public final class BenzMbux2021ThemeItemBgBinding implements ViewBinding {
    public final ImageView ivThemeSelBg;
    private final LinearLayout rootView;

    private BenzMbux2021ThemeItemBgBinding(LinearLayout rootView2, ImageView ivThemeSelBg2) {
        this.rootView = rootView2;
        this.ivThemeSelBg = ivThemeSelBg2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BenzMbux2021ThemeItemBgBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BenzMbux2021ThemeItemBgBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.benz_mbux_2021_theme_item_bg, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BenzMbux2021ThemeItemBgBinding bind(View rootView2) {
        ImageView ivThemeSelBg2 = (ImageView) rootView2.findViewById(R.id.iv_theme_sel_bg);
        if (ivThemeSelBg2 != null) {
            return new BenzMbux2021ThemeItemBgBinding((LinearLayout) rootView2, ivThemeSelBg2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.iv_theme_sel_bg)));
    }
}
