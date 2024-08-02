package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class BmwId9SettingsSystemAppItemBinding implements ViewBinding {
    public final RadioButton bmwId9SettingsSystemAppItemBtn;
    public final MarqueeTextView bmwId9SettingsSystemAppItemTitle;
    private final RelativeLayout rootView;

    private BmwId9SettingsSystemAppItemBinding(RelativeLayout rootView2, RadioButton bmwId9SettingsSystemAppItemBtn2, MarqueeTextView bmwId9SettingsSystemAppItemTitle2) {
        this.rootView = rootView2;
        this.bmwId9SettingsSystemAppItemBtn = bmwId9SettingsSystemAppItemBtn2;
        this.bmwId9SettingsSystemAppItemTitle = bmwId9SettingsSystemAppItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BmwId9SettingsSystemAppItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BmwId9SettingsSystemAppItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bmw_id9_settings_system_app_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BmwId9SettingsSystemAppItemBinding bind(View rootView2) {
        int id = R.id.bmw_id9_settings_system_app_item_btn;
        RadioButton bmwId9SettingsSystemAppItemBtn2 = (RadioButton) rootView2.findViewById(R.id.bmw_id9_settings_system_app_item_btn);
        if (bmwId9SettingsSystemAppItemBtn2 != null) {
            id = R.id.bmw_id9_settings_system_app_item_title;
            MarqueeTextView bmwId9SettingsSystemAppItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id9_settings_system_app_item_title);
            if (bmwId9SettingsSystemAppItemTitle2 != null) {
                return new BmwId9SettingsSystemAppItemBinding((RelativeLayout) rootView2, bmwId9SettingsSystemAppItemBtn2, bmwId9SettingsSystemAppItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
