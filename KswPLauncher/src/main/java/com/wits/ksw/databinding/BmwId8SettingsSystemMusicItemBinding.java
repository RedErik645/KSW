package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class BmwId8SettingsSystemMusicItemBinding implements ViewBinding {
    public final RadioButton bmwId8SettingsSystemMusicItemBtn;
    public final MarqueeTextView bmwId8SettingsSystemMusicItemTitle;
    private final RelativeLayout rootView;

    private BmwId8SettingsSystemMusicItemBinding(RelativeLayout rootView2, RadioButton bmwId8SettingsSystemMusicItemBtn2, MarqueeTextView bmwId8SettingsSystemMusicItemTitle2) {
        this.rootView = rootView2;
        this.bmwId8SettingsSystemMusicItemBtn = bmwId8SettingsSystemMusicItemBtn2;
        this.bmwId8SettingsSystemMusicItemTitle = bmwId8SettingsSystemMusicItemTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BmwId8SettingsSystemMusicItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BmwId8SettingsSystemMusicItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bmw_id8_settings_system_music_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BmwId8SettingsSystemMusicItemBinding bind(View rootView2) {
        int id = R.id.bmw_id8_settings_system_music_item_btn;
        RadioButton bmwId8SettingsSystemMusicItemBtn2 = (RadioButton) rootView2.findViewById(R.id.bmw_id8_settings_system_music_item_btn);
        if (bmwId8SettingsSystemMusicItemBtn2 != null) {
            id = R.id.bmw_id8_settings_system_music_item_title;
            MarqueeTextView bmwId8SettingsSystemMusicItemTitle2 = (MarqueeTextView) rootView2.findViewById(R.id.bmw_id8_settings_system_music_item_title);
            if (bmwId8SettingsSystemMusicItemTitle2 != null) {
                return new BmwId8SettingsSystemMusicItemBinding((RelativeLayout) rootView2, bmwId8SettingsSystemMusicItemBtn2, bmwId8SettingsSystemMusicItemTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
