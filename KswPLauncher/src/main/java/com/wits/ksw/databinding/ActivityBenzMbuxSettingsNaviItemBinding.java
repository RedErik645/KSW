package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class ActivityBenzMbuxSettingsNaviItemBinding implements ViewBinding {
    public final RadioButton mbuxSettingsNaviItemBtn;
    public final RelativeLayout mbuxSettingsNaviItemLay;
    public final MarqueeTextView mbuxSettingsNaviItemTitle;
    private final RelativeLayout rootView;

    private ActivityBenzMbuxSettingsNaviItemBinding(RelativeLayout rootView2, RadioButton mbuxSettingsNaviItemBtn2, RelativeLayout mbuxSettingsNaviItemLay2, MarqueeTextView mbuxSettingsNaviItemTitle2) {
        this.rootView = rootView2;
        this.mbuxSettingsNaviItemBtn = mbuxSettingsNaviItemBtn2;
        this.mbuxSettingsNaviItemLay = mbuxSettingsNaviItemLay2;
        this.mbuxSettingsNaviItemTitle = mbuxSettingsNaviItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBenzMbuxSettingsNaviItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityBenzMbuxSettingsNaviItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_benz_mbux_settings_navi_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityBenzMbuxSettingsNaviItemBinding bind(View rootView2) {
        int id = R.id.mbux_settings_navi_item_btn;
        RadioButton mbuxSettingsNaviItemBtn2 = (RadioButton) rootView2.findViewById(R.id.mbux_settings_navi_item_btn);
        if (mbuxSettingsNaviItemBtn2 != null) {
            RelativeLayout mbuxSettingsNaviItemLay2 = (RelativeLayout) rootView2;
            id = R.id.mbux_settings_navi_item_title;
            MarqueeTextView mbuxSettingsNaviItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.mbux_settings_navi_item_title);
            if (mbuxSettingsNaviItemTitle2 != null) {
                return new ActivityBenzMbuxSettingsNaviItemBinding((RelativeLayout) rootView2, mbuxSettingsNaviItemBtn2, mbuxSettingsNaviItemLay2, mbuxSettingsNaviItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
