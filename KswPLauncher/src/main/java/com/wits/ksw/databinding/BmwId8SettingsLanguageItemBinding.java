package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.CustomRadioButton;

public final class BmwId8SettingsLanguageItemBinding implements ViewBinding {
    public final CustomRadioButton bmwId8SettingsLanguageItemBtn;
    public final RelativeLayout bmwId8SettingsLanguageItemLay;
    private final RelativeLayout rootView;

    private BmwId8SettingsLanguageItemBinding(RelativeLayout rootView2, CustomRadioButton bmwId8SettingsLanguageItemBtn2, RelativeLayout bmwId8SettingsLanguageItemLay2) {
        this.rootView = rootView2;
        this.bmwId8SettingsLanguageItemBtn = bmwId8SettingsLanguageItemBtn2;
        this.bmwId8SettingsLanguageItemLay = bmwId8SettingsLanguageItemLay2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BmwId8SettingsLanguageItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BmwId8SettingsLanguageItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bmw_id8_settings_language_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BmwId8SettingsLanguageItemBinding bind(View rootView2) {
        CustomRadioButton bmwId8SettingsLanguageItemBtn2 = (CustomRadioButton) rootView2.findViewById(R.id.bmw_id8_settings_language_item_btn);
        if (bmwId8SettingsLanguageItemBtn2 != null) {
            return new BmwId8SettingsLanguageItemBinding((RelativeLayout) rootView2, bmwId8SettingsLanguageItemBtn2, (RelativeLayout) rootView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.bmw_id8_settings_language_item_btn)));
    }
}
