package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class BmwId8SettingsMainItemBinding implements ViewBinding {
    public final RelativeLayout bmwId8SettingsMainItemBg;
    public final MarqueeTextView bmwId8SettingsMainItemContent;
    public final ImageView bmwId8SettingsMainItemIcon;
    public final MarqueeTextView bmwId8SettingsMainItemTitle;
    private final RelativeLayout rootView;

    private BmwId8SettingsMainItemBinding(RelativeLayout rootView2, RelativeLayout bmwId8SettingsMainItemBg2, MarqueeTextView bmwId8SettingsMainItemContent2, ImageView bmwId8SettingsMainItemIcon2, MarqueeTextView bmwId8SettingsMainItemTitle2) {
        this.rootView = rootView2;
        this.bmwId8SettingsMainItemBg = bmwId8SettingsMainItemBg2;
        this.bmwId8SettingsMainItemContent = bmwId8SettingsMainItemContent2;
        this.bmwId8SettingsMainItemIcon = bmwId8SettingsMainItemIcon2;
        this.bmwId8SettingsMainItemTitle = bmwId8SettingsMainItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BmwId8SettingsMainItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BmwId8SettingsMainItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bmw_id8_settings_main_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BmwId8SettingsMainItemBinding bind(View rootView2) {
        int id = R.id.bmw_id8_settings_main_item_bg;
        RelativeLayout bmwId8SettingsMainItemBg2 = (RelativeLayout) rootView2.findViewById(R.id.bmw_id8_settings_main_item_bg);
        if (bmwId8SettingsMainItemBg2 != null) {
            id = R.id.bmw_id8_settings_main_item_content;
            MarqueeTextView bmwId8SettingsMainItemContent2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id8_settings_main_item_content);
            if (bmwId8SettingsMainItemContent2 != null) {
                id = R.id.bmw_id8_settings_main_item_icon;
                ImageView bmwId8SettingsMainItemIcon2 = (ImageView) rootView2.findViewById(R.id.bmw_id8_settings_main_item_icon);
                if (bmwId8SettingsMainItemIcon2 != null) {
                    id = R.id.bmw_id8_settings_main_item_title;
                    MarqueeTextView bmwId8SettingsMainItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id8_settings_main_item_title);
                    if (bmwId8SettingsMainItemTitle2 != null) {
                        return new BmwId8SettingsMainItemBinding((RelativeLayout) rootView2, bmwId8SettingsMainItemBg2, bmwId8SettingsMainItemContent2, bmwId8SettingsMainItemIcon2, bmwId8SettingsMainItemTitle2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
