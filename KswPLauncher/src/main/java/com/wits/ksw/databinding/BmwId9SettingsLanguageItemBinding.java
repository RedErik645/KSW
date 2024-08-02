package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class BmwId9SettingsLanguageItemBinding implements ViewBinding {
    public final RadioButton bmwId9SettingsLanguageItemBtn;
    public final RelativeLayout bmwId9SettingsLanguageItemLay;
    public final MarqueeTextView bmwId9SettingsLanguageItemTitle;
    private final RelativeLayout rootView;

    private BmwId9SettingsLanguageItemBinding(RelativeLayout rootView2, RadioButton bmwId9SettingsLanguageItemBtn2, RelativeLayout bmwId9SettingsLanguageItemLay2, MarqueeTextView bmwId9SettingsLanguageItemTitle2) {
        this.rootView = rootView2;
        this.bmwId9SettingsLanguageItemBtn = bmwId9SettingsLanguageItemBtn2;
        this.bmwId9SettingsLanguageItemLay = bmwId9SettingsLanguageItemLay2;
        this.bmwId9SettingsLanguageItemTitle = bmwId9SettingsLanguageItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BmwId9SettingsLanguageItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BmwId9SettingsLanguageItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bmw_id9_settings_language_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BmwId9SettingsLanguageItemBinding bind(View rootView2) {
        int id = R.id.bmw_id9_settings_language_item_btn;
        RadioButton bmwId9SettingsLanguageItemBtn2 = (RadioButton) rootView2.findViewById(R.id.bmw_id9_settings_language_item_btn);
        if (bmwId9SettingsLanguageItemBtn2 != null) {
            RelativeLayout bmwId9SettingsLanguageItemLay2 = (RelativeLayout) rootView2;
            id = R.id.bmw_id9_settings_language_item_title;
            MarqueeTextView bmwId9SettingsLanguageItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id9_settings_language_item_title);
            if (bmwId9SettingsLanguageItemTitle2 != null) {
                return new BmwId9SettingsLanguageItemBinding((RelativeLayout) rootView2, bmwId9SettingsLanguageItemBtn2, bmwId9SettingsLanguageItemLay2, bmwId9SettingsLanguageItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
