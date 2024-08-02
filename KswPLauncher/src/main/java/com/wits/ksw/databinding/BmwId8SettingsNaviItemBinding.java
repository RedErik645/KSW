package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class BmwId8SettingsNaviItemBinding implements ViewBinding {
    public final RadioButton bmwId8SettingsNaviItemBtn;
    public final RelativeLayout bmwId8SettingsNaviItemLay;
    public final MarqueeTextView bmwId8SettingsNaviItemTitle;
    private final RelativeLayout rootView;

    private BmwId8SettingsNaviItemBinding(RelativeLayout rootView2, RadioButton bmwId8SettingsNaviItemBtn2, RelativeLayout bmwId8SettingsNaviItemLay2, MarqueeTextView bmwId8SettingsNaviItemTitle2) {
        this.rootView = rootView2;
        this.bmwId8SettingsNaviItemBtn = bmwId8SettingsNaviItemBtn2;
        this.bmwId8SettingsNaviItemLay = bmwId8SettingsNaviItemLay2;
        this.bmwId8SettingsNaviItemTitle = bmwId8SettingsNaviItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BmwId8SettingsNaviItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BmwId8SettingsNaviItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bmw_id8_settings_navi_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BmwId8SettingsNaviItemBinding bind(View rootView2) {
        int id = R.id.bmw_id8_settings_navi_item_btn;
        RadioButton bmwId8SettingsNaviItemBtn2 = (RadioButton) rootView2.findViewById(R.id.bmw_id8_settings_navi_item_btn);
        if (bmwId8SettingsNaviItemBtn2 != null) {
            RelativeLayout bmwId8SettingsNaviItemLay2 = (RelativeLayout) rootView2;
            id = R.id.bmw_id8_settings_navi_item_title;
            MarqueeTextView bmwId8SettingsNaviItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id8_settings_navi_item_title);
            if (bmwId8SettingsNaviItemTitle2 != null) {
                return new BmwId8SettingsNaviItemBinding((RelativeLayout) rootView2, bmwId8SettingsNaviItemBtn2, bmwId8SettingsNaviItemLay2, bmwId8SettingsNaviItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
