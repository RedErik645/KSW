package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class ActivityBmwId9SettingsNaviItemBinding implements ViewBinding {
    public final RadioButton bmwId9SettingsNaviItemBtn;
    public final RelativeLayout bmwId9SettingsNaviItemLay;
    public final MarqueeTextView bmwId9SettingsNaviItemTitle;
    private final RelativeLayout rootView;

    private ActivityBmwId9SettingsNaviItemBinding(RelativeLayout rootView2, RadioButton bmwId9SettingsNaviItemBtn2, RelativeLayout bmwId9SettingsNaviItemLay2, MarqueeTextView bmwId9SettingsNaviItemTitle2) {
        this.rootView = rootView2;
        this.bmwId9SettingsNaviItemBtn = bmwId9SettingsNaviItemBtn2;
        this.bmwId9SettingsNaviItemLay = bmwId9SettingsNaviItemLay2;
        this.bmwId9SettingsNaviItemTitle = bmwId9SettingsNaviItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBmwId9SettingsNaviItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityBmwId9SettingsNaviItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_bmw_id9_settings_navi_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityBmwId9SettingsNaviItemBinding bind(View rootView2) {
        int id = R.id.bmw_id9_settings_navi_item_btn;
        RadioButton bmwId9SettingsNaviItemBtn2 = (RadioButton) rootView2.findViewById(R.id.bmw_id9_settings_navi_item_btn);
        if (bmwId9SettingsNaviItemBtn2 != null) {
            RelativeLayout bmwId9SettingsNaviItemLay2 = (RelativeLayout) rootView2;
            id = R.id.bmw_id9_settings_navi_item_title;
            MarqueeTextView bmwId9SettingsNaviItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id9_settings_navi_item_title);
            if (bmwId9SettingsNaviItemTitle2 != null) {
                return new ActivityBmwId9SettingsNaviItemBinding((RelativeLayout) rootView2, bmwId9SettingsNaviItemBtn2, bmwId9SettingsNaviItemLay2, bmwId9SettingsNaviItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
