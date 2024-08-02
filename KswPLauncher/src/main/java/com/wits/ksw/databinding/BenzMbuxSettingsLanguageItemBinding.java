package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class BenzMbuxSettingsLanguageItemBinding implements ViewBinding {
    public final RadioButton mbuxSettingsLanguageItemBtn;
    public final RelativeLayout mbuxSettingsLanguageItemLay;
    public final MarqueeTextView mbuxSettingsLanguageItemTitle;
    private final RelativeLayout rootView;

    private BenzMbuxSettingsLanguageItemBinding(RelativeLayout rootView2, RadioButton mbuxSettingsLanguageItemBtn2, RelativeLayout mbuxSettingsLanguageItemLay2, MarqueeTextView mbuxSettingsLanguageItemTitle2) {
        this.rootView = rootView2;
        this.mbuxSettingsLanguageItemBtn = mbuxSettingsLanguageItemBtn2;
        this.mbuxSettingsLanguageItemLay = mbuxSettingsLanguageItemLay2;
        this.mbuxSettingsLanguageItemTitle = mbuxSettingsLanguageItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BenzMbuxSettingsLanguageItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BenzMbuxSettingsLanguageItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.benz_mbux_settings_language_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BenzMbuxSettingsLanguageItemBinding bind(View rootView2) {
        int id = R.id.mbux_settings_language_item_btn;
        RadioButton mbuxSettingsLanguageItemBtn2 = (RadioButton) rootView2.findViewById(R.id.mbux_settings_language_item_btn);
        if (mbuxSettingsLanguageItemBtn2 != null) {
            RelativeLayout mbuxSettingsLanguageItemLay2 = (RelativeLayout) rootView2;
            id = R.id.mbux_settings_language_item_title;
            MarqueeTextView mbuxSettingsLanguageItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.mbux_settings_language_item_title);
            if (mbuxSettingsLanguageItemTitle2 != null) {
                return new BenzMbuxSettingsLanguageItemBinding((RelativeLayout) rootView2, mbuxSettingsLanguageItemBtn2, mbuxSettingsLanguageItemLay2, mbuxSettingsLanguageItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
