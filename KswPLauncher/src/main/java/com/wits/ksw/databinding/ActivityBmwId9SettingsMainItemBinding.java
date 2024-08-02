package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class ActivityBmwId9SettingsMainItemBinding implements ViewBinding {
    public final RelativeLayout bmwId9SettingsMainItemBg;
    public final MarqueeTextView bmwId9SettingsMainItemContent;
    public final ImageView bmwId9SettingsMainItemIcon;
    public final ImageView bmwId9SettingsMainItemLine;
    public final MarqueeTextView bmwId9SettingsMainItemTitle;
    private final RelativeLayout rootView;

    private ActivityBmwId9SettingsMainItemBinding(RelativeLayout rootView2, RelativeLayout bmwId9SettingsMainItemBg2, MarqueeTextView bmwId9SettingsMainItemContent2, ImageView bmwId9SettingsMainItemIcon2, ImageView bmwId9SettingsMainItemLine2, MarqueeTextView bmwId9SettingsMainItemTitle2) {
        this.rootView = rootView2;
        this.bmwId9SettingsMainItemBg = bmwId9SettingsMainItemBg2;
        this.bmwId9SettingsMainItemContent = bmwId9SettingsMainItemContent2;
        this.bmwId9SettingsMainItemIcon = bmwId9SettingsMainItemIcon2;
        this.bmwId9SettingsMainItemLine = bmwId9SettingsMainItemLine2;
        this.bmwId9SettingsMainItemTitle = bmwId9SettingsMainItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBmwId9SettingsMainItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityBmwId9SettingsMainItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_bmw_id9_settings_main_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityBmwId9SettingsMainItemBinding bind(View rootView2) {
        int id = R.id.bmw_id9_settings_main_item_bg;
        RelativeLayout bmwId9SettingsMainItemBg2 = (RelativeLayout) rootView2.findViewById(R.id.bmw_id9_settings_main_item_bg);
        if (bmwId9SettingsMainItemBg2 != null) {
            id = R.id.bmw_id9_settings_main_item_content;
            MarqueeTextView bmwId9SettingsMainItemContent2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id9_settings_main_item_content);
            if (bmwId9SettingsMainItemContent2 != null) {
                id = R.id.bmw_id9_settings_main_item_icon;
                ImageView bmwId9SettingsMainItemIcon2 = (ImageView) rootView2.findViewById(R.id.bmw_id9_settings_main_item_icon);
                if (bmwId9SettingsMainItemIcon2 != null) {
                    id = R.id.bmw_id9_settings_main_item_line;
                    ImageView bmwId9SettingsMainItemLine2 = (ImageView) rootView2.findViewById(R.id.bmw_id9_settings_main_item_line);
                    if (bmwId9SettingsMainItemLine2 != null) {
                        id = R.id.bmw_id9_settings_main_item_title;
                        MarqueeTextView bmwId9SettingsMainItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id9_settings_main_item_title);
                        if (bmwId9SettingsMainItemTitle2 != null) {
                            return new ActivityBmwId9SettingsMainItemBinding((RelativeLayout) rootView2, bmwId9SettingsMainItemBg2, bmwId9SettingsMainItemContent2, bmwId9SettingsMainItemIcon2, bmwId9SettingsMainItemLine2, bmwId9SettingsMainItemTitle2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
