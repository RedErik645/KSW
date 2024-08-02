package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.wits.ksw.R;

public final class BenzNtg6FyThemeSetLayoutBinding implements ViewBinding {
    public final RadioButton rbBenzFyBg1;
    public final RadioButton rbBenzFyBg2;
    public final RadioButton rbBenzFyBg3;
    public final RadioButton rbBenzFyBg4;
    public final RadioButton rbBenzFyBg5;
    public final RadioButton rbBenzFyBg6;
    public final RadioButton rbBenzFyBg7;
    public final RadioButton rbBenzFyBg8;
    private final LinearLayout rootView;
    public final TextView tvBg1;
    public final TextView tvBg2;
    public final TextView tvBg3;
    public final TextView tvBg4;
    public final TextView tvBg5;
    public final TextView tvBg6;
    public final TextView tvBg7;
    public final TextView tvBg8;

    private BenzNtg6FyThemeSetLayoutBinding(LinearLayout rootView2, RadioButton rbBenzFyBg12, RadioButton rbBenzFyBg22, RadioButton rbBenzFyBg32, RadioButton rbBenzFyBg42, RadioButton rbBenzFyBg52, RadioButton rbBenzFyBg62, RadioButton rbBenzFyBg72, RadioButton rbBenzFyBg82, TextView tvBg12, TextView tvBg22, TextView tvBg32, TextView tvBg42, TextView tvBg52, TextView tvBg62, TextView tvBg72, TextView tvBg82) {
        this.rootView = rootView2;
        this.rbBenzFyBg1 = rbBenzFyBg12;
        this.rbBenzFyBg2 = rbBenzFyBg22;
        this.rbBenzFyBg3 = rbBenzFyBg32;
        this.rbBenzFyBg4 = rbBenzFyBg42;
        this.rbBenzFyBg5 = rbBenzFyBg52;
        this.rbBenzFyBg6 = rbBenzFyBg62;
        this.rbBenzFyBg7 = rbBenzFyBg72;
        this.rbBenzFyBg8 = rbBenzFyBg82;
        this.tvBg1 = tvBg12;
        this.tvBg2 = tvBg22;
        this.tvBg3 = tvBg32;
        this.tvBg4 = tvBg42;
        this.tvBg5 = tvBg52;
        this.tvBg6 = tvBg62;
        this.tvBg7 = tvBg72;
        this.tvBg8 = tvBg82;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BenzNtg6FyThemeSetLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BenzNtg6FyThemeSetLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.benz_ntg6_fy_theme_set_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BenzNtg6FyThemeSetLayoutBinding bind(View rootView2) {
        int id = R.id.rb_benz_fy_bg1;
        RadioButton rbBenzFyBg12 = (RadioButton) rootView2.findViewById(R.id.rb_benz_fy_bg1);
        if (rbBenzFyBg12 != null) {
            id = R.id.rb_benz_fy_bg2;
            RadioButton rbBenzFyBg22 = (RadioButton) rootView2.findViewById(R.id.rb_benz_fy_bg2);
            if (rbBenzFyBg22 != null) {
                id = R.id.rb_benz_fy_bg3;
                RadioButton rbBenzFyBg32 = (RadioButton) rootView2.findViewById(R.id.rb_benz_fy_bg3);
                if (rbBenzFyBg32 != null) {
                    id = R.id.rb_benz_fy_bg4;
                    RadioButton rbBenzFyBg42 = (RadioButton) rootView2.findViewById(R.id.rb_benz_fy_bg4);
                    if (rbBenzFyBg42 != null) {
                        id = R.id.rb_benz_fy_bg5;
                        RadioButton rbBenzFyBg52 = (RadioButton) rootView2.findViewById(R.id.rb_benz_fy_bg5);
                        if (rbBenzFyBg52 != null) {
                            id = R.id.rb_benz_fy_bg6;
                            RadioButton rbBenzFyBg62 = (RadioButton) rootView2.findViewById(R.id.rb_benz_fy_bg6);
                            if (rbBenzFyBg62 != null) {
                                id = R.id.rb_benz_fy_bg7;
                                RadioButton rbBenzFyBg72 = (RadioButton) rootView2.findViewById(R.id.rb_benz_fy_bg7);
                                if (rbBenzFyBg72 != null) {
                                    id = R.id.rb_benz_fy_bg8;
                                    RadioButton rbBenzFyBg82 = (RadioButton) rootView2.findViewById(R.id.rb_benz_fy_bg8);
                                    if (rbBenzFyBg82 != null) {
                                        id = R.id.tv_bg1;
                                        TextView tvBg12 = (TextView) rootView2.findViewById(R.id.tv_bg1);
                                        if (tvBg12 != null) {
                                            id = R.id.tv_bg2;
                                            TextView tvBg22 = (TextView) rootView2.findViewById(R.id.tv_bg2);
                                            if (tvBg22 != null) {
                                                id = R.id.tv_bg3;
                                                TextView tvBg32 = (TextView) rootView2.findViewById(R.id.tv_bg3);
                                                if (tvBg32 != null) {
                                                    id = R.id.tv_bg4;
                                                    TextView tvBg42 = (TextView) rootView2.findViewById(R.id.tv_bg4);
                                                    if (tvBg42 != null) {
                                                        id = R.id.tv_bg5;
                                                        TextView tvBg52 = (TextView) rootView2.findViewById(R.id.tv_bg5);
                                                        if (tvBg52 != null) {
                                                            id = R.id.tv_bg6;
                                                            TextView tvBg62 = (TextView) rootView2.findViewById(R.id.tv_bg6);
                                                            if (tvBg62 != null) {
                                                                id = R.id.tv_bg7;
                                                                TextView tvBg72 = (TextView) rootView2.findViewById(R.id.tv_bg7);
                                                                if (tvBg72 != null) {
                                                                    id = R.id.tv_bg8;
                                                                    TextView tvBg82 = (TextView) rootView2.findViewById(R.id.tv_bg8);
                                                                    if (tvBg82 != null) {
                                                                        return new BenzNtg6FyThemeSetLayoutBinding((LinearLayout) rootView2, rbBenzFyBg12, rbBenzFyBg22, rbBenzFyBg32, rbBenzFyBg42, rbBenzFyBg52, rbBenzFyBg62, rbBenzFyBg72, rbBenzFyBg82, tvBg12, tvBg22, tvBg32, tvBg42, tvBg52, tvBg62, tvBg72, tvBg82);
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
