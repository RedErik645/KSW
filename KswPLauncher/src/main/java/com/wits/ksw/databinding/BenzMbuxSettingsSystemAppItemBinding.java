package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class BenzMbuxSettingsSystemAppItemBinding implements ViewBinding {
    public final RadioButton mbuxSettingsSystemAppItemBtn;
    public final MarqueeTextView mbuxSettingsSystemAppItemTitle;
    private final RelativeLayout rootView;

    private BenzMbuxSettingsSystemAppItemBinding(RelativeLayout rootView2, RadioButton mbuxSettingsSystemAppItemBtn2, MarqueeTextView mbuxSettingsSystemAppItemTitle2) {
        this.rootView = rootView2;
        this.mbuxSettingsSystemAppItemBtn = mbuxSettingsSystemAppItemBtn2;
        this.mbuxSettingsSystemAppItemTitle = mbuxSettingsSystemAppItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BenzMbuxSettingsSystemAppItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BenzMbuxSettingsSystemAppItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.benz_mbux_settings_system_app_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BenzMbuxSettingsSystemAppItemBinding bind(View rootView2) {
        int id = R.id.mbux_settings_system_app_item_btn;
        RadioButton mbuxSettingsSystemAppItemBtn2 = (RadioButton) rootView2.findViewById(R.id.mbux_settings_system_app_item_btn);
        if (mbuxSettingsSystemAppItemBtn2 != null) {
            id = R.id.mbux_settings_system_app_item_title;
            MarqueeTextView mbuxSettingsSystemAppItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.mbux_settings_system_app_item_title);
            if (mbuxSettingsSystemAppItemTitle2 != null) {
                return new BenzMbuxSettingsSystemAppItemBinding((RelativeLayout) rootView2, mbuxSettingsSystemAppItemBtn2, mbuxSettingsSystemAppItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
