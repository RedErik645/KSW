package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class BmwId8SettingsSystemVideoItemBinding implements ViewBinding {
    public final RadioButton bmwId8SettingsSystemVideoItemBtn;
    public final MarqueeTextView bmwId8SettingsSystemVideoItemTitle;
    private final RelativeLayout rootView;

    private BmwId8SettingsSystemVideoItemBinding(RelativeLayout rootView2, RadioButton bmwId8SettingsSystemVideoItemBtn2, MarqueeTextView bmwId8SettingsSystemVideoItemTitle2) {
        this.rootView = rootView2;
        this.bmwId8SettingsSystemVideoItemBtn = bmwId8SettingsSystemVideoItemBtn2;
        this.bmwId8SettingsSystemVideoItemTitle = bmwId8SettingsSystemVideoItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BmwId8SettingsSystemVideoItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BmwId8SettingsSystemVideoItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bmw_id8_settings_system_video_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BmwId8SettingsSystemVideoItemBinding bind(View rootView2) {
        int id = R.id.bmw_id8_settings_system_video_item_btn;
        RadioButton bmwId8SettingsSystemVideoItemBtn2 = (RadioButton) rootView2.findViewById(R.id.bmw_id8_settings_system_video_item_btn);
        if (bmwId8SettingsSystemVideoItemBtn2 != null) {
            id = R.id.bmw_id8_settings_system_video_item_title;
            MarqueeTextView bmwId8SettingsSystemVideoItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id8_settings_system_video_item_title);
            if (bmwId8SettingsSystemVideoItemTitle2 != null) {
                return new BmwId8SettingsSystemVideoItemBinding((RelativeLayout) rootView2, bmwId8SettingsSystemVideoItemBtn2, bmwId8SettingsSystemVideoItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
