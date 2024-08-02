package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class BenzMbuxSettingsMainItemBinding implements ViewBinding {
    public final RelativeLayout benzSettingsMainItemBg;
    public final View benzSettingsMainItemDivider;
    public final ImageView benzSettingsMainItemIcon;
    public final MarqueeTextView benzSettingsMainItemTitle;
    private final RelativeLayout rootView;

    private BenzMbuxSettingsMainItemBinding(RelativeLayout rootView2, RelativeLayout benzSettingsMainItemBg2, View benzSettingsMainItemDivider2, ImageView benzSettingsMainItemIcon2, MarqueeTextView benzSettingsMainItemTitle2) {
        this.rootView = rootView2;
        this.benzSettingsMainItemBg = benzSettingsMainItemBg2;
        this.benzSettingsMainItemDivider = benzSettingsMainItemDivider2;
        this.benzSettingsMainItemIcon = benzSettingsMainItemIcon2;
        this.benzSettingsMainItemTitle = benzSettingsMainItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BenzMbuxSettingsMainItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BenzMbuxSettingsMainItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.benz_mbux_settings_main_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BenzMbuxSettingsMainItemBinding bind(View rootView2) {
        int id = R.id.benz_settings_main_item_bg;
        RelativeLayout benzSettingsMainItemBg2 = (RelativeLayout) rootView2.findViewById(R.id.benz_settings_main_item_bg);
        if (benzSettingsMainItemBg2 != null) {
            id = R.id.benz_settings_main_item_divider;
            View benzSettingsMainItemDivider2 = rootView2.findViewById(R.id.benz_settings_main_item_divider);
            if (benzSettingsMainItemDivider2 != null) {
                id = R.id.benz_settings_main_item_icon;
                ImageView benzSettingsMainItemIcon2 = (ImageView) rootView2.findViewById(R.id.benz_settings_main_item_icon);
                if (benzSettingsMainItemIcon2 != null) {
                    id = R.id.benz_settings_main_item_title;
                    MarqueeTextView benzSettingsMainItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.benz_settings_main_item_title);
                    if (benzSettingsMainItemTitle2 != null) {
                        return new BenzMbuxSettingsMainItemBinding((RelativeLayout) rootView2, benzSettingsMainItemBg2, benzSettingsMainItemDivider2, benzSettingsMainItemIcon2, benzSettingsMainItemTitle2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
