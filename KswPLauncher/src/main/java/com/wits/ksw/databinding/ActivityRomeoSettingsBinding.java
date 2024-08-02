package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class ActivityRomeoSettingsBinding implements ViewBinding {
    public final FrameLayout frameOneLayout;
    public final FrameLayout frameTwoLayout;
    public final TextView lexusSetTitle;
    public final RecyclerView recyclerView;
    public final ImageView romeoIndicator1;
    public final ImageView romeoIndicator2;
    public final ImageView romeoIndicator3;
    public final ImageView romeoIndicator4;
    public final ImageView romeoIndicator5;
    public final ImageView romeoIndicator6;
    public final ImageView romeoLeft1;
    public final ImageView romeoLeft2;
    public final ImageView romeoLeft3;
    public final ImageView romeoLeft4;
    public final ImageView romeoLeft5;
    public final ImageView romeoLeft6;
    public final ImageView romeoSettingsIndicator1;
    public final ImageView romeoSettingsIndicator2;
    public final ImageView romeoSettingsIndicator3;
    public final ImageView romeoSettingsIndicator4;
    public final ImageView romeoSettingsIndicator5;
    public final ImageView romeoSettingsIndicator6;
    public final ImageView romeoSettingsList1;
    public final ImageView romeoSettingsList2;
    public final ImageView romeoSettingsList3;
    public final ImageView romeoSettingsList4;
    public final ImageView romeoSettingsList5;
    public final ImageView romeoSettingsList6;
    private final FrameLayout rootView;

    private ActivityRomeoSettingsBinding(FrameLayout rootView2, FrameLayout frameOneLayout2, FrameLayout frameTwoLayout2, TextView lexusSetTitle2, RecyclerView recyclerView2, ImageView romeoIndicator12, ImageView romeoIndicator22, ImageView romeoIndicator32, ImageView romeoIndicator42, ImageView romeoIndicator52, ImageView romeoIndicator62, ImageView romeoLeft12, ImageView romeoLeft22, ImageView romeoLeft32, ImageView romeoLeft42, ImageView romeoLeft52, ImageView romeoLeft62, ImageView romeoSettingsIndicator12, ImageView romeoSettingsIndicator22, ImageView romeoSettingsIndicator32, ImageView romeoSettingsIndicator42, ImageView romeoSettingsIndicator52, ImageView romeoSettingsIndicator62, ImageView romeoSettingsList12, ImageView romeoSettingsList22, ImageView romeoSettingsList32, ImageView romeoSettingsList42, ImageView romeoSettingsList52, ImageView romeoSettingsList62) {
        this.rootView = rootView2;
        this.frameOneLayout = frameOneLayout2;
        this.frameTwoLayout = frameTwoLayout2;
        this.lexusSetTitle = lexusSetTitle2;
        this.recyclerView = recyclerView2;
        this.romeoIndicator1 = romeoIndicator12;
        this.romeoIndicator2 = romeoIndicator22;
        this.romeoIndicator3 = romeoIndicator32;
        this.romeoIndicator4 = romeoIndicator42;
        this.romeoIndicator5 = romeoIndicator52;
        this.romeoIndicator6 = romeoIndicator62;
        this.romeoLeft1 = romeoLeft12;
        this.romeoLeft2 = romeoLeft22;
        this.romeoLeft3 = romeoLeft32;
        this.romeoLeft4 = romeoLeft42;
        this.romeoLeft5 = romeoLeft52;
        this.romeoLeft6 = romeoLeft62;
        this.romeoSettingsIndicator1 = romeoSettingsIndicator12;
        this.romeoSettingsIndicator2 = romeoSettingsIndicator22;
        this.romeoSettingsIndicator3 = romeoSettingsIndicator32;
        this.romeoSettingsIndicator4 = romeoSettingsIndicator42;
        this.romeoSettingsIndicator5 = romeoSettingsIndicator52;
        this.romeoSettingsIndicator6 = romeoSettingsIndicator62;
        this.romeoSettingsList1 = romeoSettingsList12;
        this.romeoSettingsList2 = romeoSettingsList22;
        this.romeoSettingsList3 = romeoSettingsList32;
        this.romeoSettingsList4 = romeoSettingsList42;
        this.romeoSettingsList5 = romeoSettingsList52;
        this.romeoSettingsList6 = romeoSettingsList62;
    }

    @Override // android.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRomeoSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityRomeoSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_romeo_settings, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityRomeoSettingsBinding bind(View rootView2) {
        int id = R.id.frame_OneLayout;
        FrameLayout frameOneLayout2 = (FrameLayout) rootView2.findViewById(R.id.frame_OneLayout);
        if (frameOneLayout2 != null) {
            id = R.id.frame_TwoLayout;
            FrameLayout frameTwoLayout2 = (FrameLayout) rootView2.findViewById(R.id.frame_TwoLayout);
            if (frameTwoLayout2 != null) {
                id = R.id.lexus_set_title;
                TextView lexusSetTitle2 = (TextView) rootView2.findViewById(R.id.lexus_set_title);
                if (lexusSetTitle2 != null) {
                    id = R.id.recyclerView;
                    RecyclerView recyclerView2 = (RecyclerView) rootView2.findViewById(R.id.recyclerView);
                    if (recyclerView2 != null) {
                        id = R.id.romeo_indicator_1;
                        ImageView romeoIndicator12 = (ImageView) rootView2.findViewById(R.id.romeo_indicator_1);
                        if (romeoIndicator12 != null) {
                            id = R.id.romeo_indicator_2;
                            ImageView romeoIndicator22 = (ImageView) rootView2.findViewById(R.id.romeo_indicator_2);
                            if (romeoIndicator22 != null) {
                                id = R.id.romeo_indicator_3;
                                ImageView romeoIndicator32 = (ImageView) rootView2.findViewById(R.id.romeo_indicator_3);
                                if (romeoIndicator32 != null) {
                                    id = R.id.romeo_indicator_4;
                                    ImageView romeoIndicator42 = (ImageView) rootView2.findViewById(R.id.romeo_indicator_4);
                                    if (romeoIndicator42 != null) {
                                        id = R.id.romeo_indicator_5;
                                        ImageView romeoIndicator52 = (ImageView) rootView2.findViewById(R.id.romeo_indicator_5);
                                        if (romeoIndicator52 != null) {
                                            id = R.id.romeo_indicator_6;
                                            ImageView romeoIndicator62 = (ImageView) rootView2.findViewById(R.id.romeo_indicator_6);
                                            if (romeoIndicator62 != null) {
                                                id = R.id.romeo_left1;
                                                ImageView romeoLeft12 = (ImageView) rootView2.findViewById(R.id.romeo_left1);
                                                if (romeoLeft12 != null) {
                                                    id = R.id.romeo_left2;
                                                    ImageView romeoLeft22 = (ImageView) rootView2.findViewById(R.id.romeo_left2);
                                                    if (romeoLeft22 != null) {
                                                        id = R.id.romeo_left3;
                                                        ImageView romeoLeft32 = (ImageView) rootView2.findViewById(R.id.romeo_left3);
                                                        if (romeoLeft32 != null) {
                                                            id = R.id.romeo_left4;
                                                            ImageView romeoLeft42 = (ImageView) rootView2.findViewById(R.id.romeo_left4);
                                                            if (romeoLeft42 != null) {
                                                                id = R.id.romeo_left5;
                                                                ImageView romeoLeft52 = (ImageView) rootView2.findViewById(R.id.romeo_left5);
                                                                if (romeoLeft52 != null) {
                                                                    id = R.id.romeo_left6;
                                                                    ImageView romeoLeft62 = (ImageView) rootView2.findViewById(R.id.romeo_left6);
                                                                    if (romeoLeft62 != null) {
                                                                        id = R.id.romeo_settings_indicator1;
                                                                        ImageView romeoSettingsIndicator12 = (ImageView) rootView2.findViewById(R.id.romeo_settings_indicator1);
                                                                        if (romeoSettingsIndicator12 != null) {
                                                                            id = R.id.romeo_settings_indicator2;
                                                                            ImageView romeoSettingsIndicator22 = (ImageView) rootView2.findViewById(R.id.romeo_settings_indicator2);
                                                                            if (romeoSettingsIndicator22 != null) {
                                                                                id = R.id.romeo_settings_indicator3;
                                                                                ImageView romeoSettingsIndicator32 = (ImageView) rootView2.findViewById(R.id.romeo_settings_indicator3);
                                                                                if (romeoSettingsIndicator32 != null) {
                                                                                    id = R.id.romeo_settings_indicator4;
                                                                                    ImageView romeoSettingsIndicator42 = (ImageView) rootView2.findViewById(R.id.romeo_settings_indicator4);
                                                                                    if (romeoSettingsIndicator42 != null) {
                                                                                        id = R.id.romeo_settings_indicator5;
                                                                                        ImageView romeoSettingsIndicator52 = (ImageView) rootView2.findViewById(R.id.romeo_settings_indicator5);
                                                                                        if (romeoSettingsIndicator52 != null) {
                                                                                            id = R.id.romeo_settings_indicator6;
                                                                                            ImageView romeoSettingsIndicator62 = (ImageView) rootView2.findViewById(R.id.romeo_settings_indicator6);
                                                                                            if (romeoSettingsIndicator62 != null) {
                                                                                                id = R.id.romeo_settings_list1;
                                                                                                ImageView romeoSettingsList12 = (ImageView) rootView2.findViewById(R.id.romeo_settings_list1);
                                                                                                if (romeoSettingsList12 != null) {
                                                                                                    id = R.id.romeo_settings_list2;
                                                                                                    ImageView romeoSettingsList22 = (ImageView) rootView2.findViewById(R.id.romeo_settings_list2);
                                                                                                    if (romeoSettingsList22 != null) {
                                                                                                        id = R.id.romeo_settings_list3;
                                                                                                        ImageView romeoSettingsList32 = (ImageView) rootView2.findViewById(R.id.romeo_settings_list3);
                                                                                                        if (romeoSettingsList32 != null) {
                                                                                                            id = R.id.romeo_settings_list4;
                                                                                                            ImageView romeoSettingsList42 = (ImageView) rootView2.findViewById(R.id.romeo_settings_list4);
                                                                                                            if (romeoSettingsList42 != null) {
                                                                                                                id = R.id.romeo_settings_list5;
                                                                                                                ImageView romeoSettingsList52 = (ImageView) rootView2.findViewById(R.id.romeo_settings_list5);
                                                                                                                if (romeoSettingsList52 != null) {
                                                                                                                    id = R.id.romeo_settings_list6;
                                                                                                                    ImageView romeoSettingsList62 = (ImageView) rootView2.findViewById(R.id.romeo_settings_list6);
                                                                                                                    if (romeoSettingsList62 != null) {
                                                                                                                        return new ActivityRomeoSettingsBinding((FrameLayout) rootView2, frameOneLayout2, frameTwoLayout2, lexusSetTitle2, recyclerView2, romeoIndicator12, romeoIndicator22, romeoIndicator32, romeoIndicator42, romeoIndicator52, romeoIndicator62, romeoLeft12, romeoLeft22, romeoLeft32, romeoLeft42, romeoLeft52, romeoLeft62, romeoSettingsIndicator12, romeoSettingsIndicator22, romeoSettingsIndicator32, romeoSettingsIndicator42, romeoSettingsIndicator52, romeoSettingsIndicator62, romeoSettingsList12, romeoSettingsList22, romeoSettingsList32, romeoSettingsList42, romeoSettingsList52, romeoSettingsList62);
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
