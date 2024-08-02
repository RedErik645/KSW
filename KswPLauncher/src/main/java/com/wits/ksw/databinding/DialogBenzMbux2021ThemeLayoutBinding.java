package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.wits.ksw.R;

public final class DialogBenzMbux2021ThemeLayoutBinding implements ViewBinding {
    public final RadioButton rbBenzMbux2021CoatBg1;
    public final RadioButton rbBenzMbux2021CoatBg2;
    public final RadioButton rbBenzMbux2021CoatBg3;
    public final RadioButton rbBenzMbux2021CoatBg4;
    public final RadioButton rbBenzMbux2021CoatBg5;
    public final RadioButton rbBenzMbux2021CoatBg6;
    public final RadioButton rbBenzMbux2021CoatBg7;
    public final RadioButton rbIconSelClassical;
    public final RadioButton rbIconSelModern;
    private final LinearLayout rootView;
    public final TextView tvIconSelClassical;
    public final TextView tvIconSelModern;

    private DialogBenzMbux2021ThemeLayoutBinding(LinearLayout rootView2, RadioButton rbBenzMbux2021CoatBg12, RadioButton rbBenzMbux2021CoatBg22, RadioButton rbBenzMbux2021CoatBg32, RadioButton rbBenzMbux2021CoatBg42, RadioButton rbBenzMbux2021CoatBg52, RadioButton rbBenzMbux2021CoatBg62, RadioButton rbBenzMbux2021CoatBg72, RadioButton rbIconSelClassical2, RadioButton rbIconSelModern2, TextView tvIconSelClassical2, TextView tvIconSelModern2) {
        this.rootView = rootView2;
        this.rbBenzMbux2021CoatBg1 = rbBenzMbux2021CoatBg12;
        this.rbBenzMbux2021CoatBg2 = rbBenzMbux2021CoatBg22;
        this.rbBenzMbux2021CoatBg3 = rbBenzMbux2021CoatBg32;
        this.rbBenzMbux2021CoatBg4 = rbBenzMbux2021CoatBg42;
        this.rbBenzMbux2021CoatBg5 = rbBenzMbux2021CoatBg52;
        this.rbBenzMbux2021CoatBg6 = rbBenzMbux2021CoatBg62;
        this.rbBenzMbux2021CoatBg7 = rbBenzMbux2021CoatBg72;
        this.rbIconSelClassical = rbIconSelClassical2;
        this.rbIconSelModern = rbIconSelModern2;
        this.tvIconSelClassical = tvIconSelClassical2;
        this.tvIconSelModern = tvIconSelModern2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogBenzMbux2021ThemeLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBenzMbux2021ThemeLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_benz_mbux_2021_theme_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogBenzMbux2021ThemeLayoutBinding bind(View rootView2) {
        int id = R.id.rb_benz_mbux_2021_coat_bg_1;
        RadioButton rbBenzMbux2021CoatBg12 = (RadioButton) rootView2.findViewById(R.id.rb_benz_mbux_2021_coat_bg_1);
        if (rbBenzMbux2021CoatBg12 != null) {
            id = R.id.rb_benz_mbux_2021_coat_bg_2;
            RadioButton rbBenzMbux2021CoatBg22 = (RadioButton) rootView2.findViewById(R.id.rb_benz_mbux_2021_coat_bg_2);
            if (rbBenzMbux2021CoatBg22 != null) {
                id = R.id.rb_benz_mbux_2021_coat_bg_3;
                RadioButton rbBenzMbux2021CoatBg32 = (RadioButton) rootView2.findViewById(R.id.rb_benz_mbux_2021_coat_bg_3);
                if (rbBenzMbux2021CoatBg32 != null) {
                    id = R.id.rb_benz_mbux_2021_coat_bg_4;
                    RadioButton rbBenzMbux2021CoatBg42 = (RadioButton) rootView2.findViewById(R.id.rb_benz_mbux_2021_coat_bg_4);
                    if (rbBenzMbux2021CoatBg42 != null) {
                        id = R.id.rb_benz_mbux_2021_coat_bg_5;
                        RadioButton rbBenzMbux2021CoatBg52 = (RadioButton) rootView2.findViewById(R.id.rb_benz_mbux_2021_coat_bg_5);
                        if (rbBenzMbux2021CoatBg52 != null) {
                            id = R.id.rb_benz_mbux_2021_coat_bg_6;
                            RadioButton rbBenzMbux2021CoatBg62 = (RadioButton) rootView2.findViewById(R.id.rb_benz_mbux_2021_coat_bg_6);
                            if (rbBenzMbux2021CoatBg62 != null) {
                                id = R.id.rb_benz_mbux_2021_coat_bg_7;
                                RadioButton rbBenzMbux2021CoatBg72 = (RadioButton) rootView2.findViewById(R.id.rb_benz_mbux_2021_coat_bg_7);
                                if (rbBenzMbux2021CoatBg72 != null) {
                                    id = R.id.rb_icon_sel_classical;
                                    RadioButton rbIconSelClassical2 = (RadioButton) rootView2.findViewById(R.id.rb_icon_sel_classical);
                                    if (rbIconSelClassical2 != null) {
                                        id = R.id.rb_icon_sel_modern;
                                        RadioButton rbIconSelModern2 = (RadioButton) rootView2.findViewById(R.id.rb_icon_sel_modern);
                                        if (rbIconSelModern2 != null) {
                                            id = R.id.tv_icon_sel_classical;
                                            TextView tvIconSelClassical2 = (TextView) rootView2.findViewById(R.id.tv_icon_sel_classical);
                                            if (tvIconSelClassical2 != null) {
                                                id = R.id.tv_icon_sel_modern;
                                                TextView tvIconSelModern2 = (TextView) rootView2.findViewById(R.id.tv_icon_sel_modern);
                                                if (tvIconSelModern2 != null) {
                                                    return new DialogBenzMbux2021ThemeLayoutBinding((LinearLayout) rootView2, rbBenzMbux2021CoatBg12, rbBenzMbux2021CoatBg22, rbBenzMbux2021CoatBg32, rbBenzMbux2021CoatBg42, rbBenzMbux2021CoatBg52, rbBenzMbux2021CoatBg62, rbBenzMbux2021CoatBg72, rbIconSelClassical2, rbIconSelModern2, tvIconSelClassical2, tvIconSelModern2);
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
