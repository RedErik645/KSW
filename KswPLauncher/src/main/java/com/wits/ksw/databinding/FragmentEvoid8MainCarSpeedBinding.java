package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FragmentEvoid8MainCarSpeedBinding implements ViewBinding {
    public final RelativeLayout id8UgCarChange;
    public final ImageView id8UgCarChangeBlack;
    public final ConstraintLayout id8UgCarChangeLayout;
    public final ImageView id8UgCarChangeRed;
    public final ImageView id8UgCarChangeWhite;
    public final ImageView id8UgCarModel;
    public final ImageView id8UgCarStatusBlack;
    public final ImageView id8UgCarStatusRed;
    public final ImageView id8UgCarStatusWhite;
    public final ImageView ivCarSpeed;
    private final CardView rootView;
    public final TextView speedTv;
    public final TextView speedUnitTv;

    private FragmentEvoid8MainCarSpeedBinding(CardView rootView2, RelativeLayout id8UgCarChange2, ImageView id8UgCarChangeBlack2, ConstraintLayout id8UgCarChangeLayout2, ImageView id8UgCarChangeRed2, ImageView id8UgCarChangeWhite2, ImageView id8UgCarModel2, ImageView id8UgCarStatusBlack2, ImageView id8UgCarStatusRed2, ImageView id8UgCarStatusWhite2, ImageView ivCarSpeed2, TextView speedTv2, TextView speedUnitTv2) {
        this.rootView = rootView2;
        this.id8UgCarChange = id8UgCarChange2;
        this.id8UgCarChangeBlack = id8UgCarChangeBlack2;
        this.id8UgCarChangeLayout = id8UgCarChangeLayout2;
        this.id8UgCarChangeRed = id8UgCarChangeRed2;
        this.id8UgCarChangeWhite = id8UgCarChangeWhite2;
        this.id8UgCarModel = id8UgCarModel2;
        this.id8UgCarStatusBlack = id8UgCarStatusBlack2;
        this.id8UgCarStatusRed = id8UgCarStatusRed2;
        this.id8UgCarStatusWhite = id8UgCarStatusWhite2;
        this.ivCarSpeed = ivCarSpeed2;
        this.speedTv = speedTv2;
        this.speedUnitTv = speedUnitTv2;
    }

    @Override // android.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static FragmentEvoid8MainCarSpeedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentEvoid8MainCarSpeedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_evoid8_main_car_speed, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentEvoid8MainCarSpeedBinding bind(View rootView2) {
        int id = R.id.id8_ug_car_change;
        RelativeLayout id8UgCarChange2 = (RelativeLayout) rootView2.findViewById(R.id.id8_ug_car_change);
        if (id8UgCarChange2 != null) {
            id = R.id.id8_ug_car_change_black;
            ImageView id8UgCarChangeBlack2 = (ImageView) rootView2.findViewById(R.id.id8_ug_car_change_black);
            if (id8UgCarChangeBlack2 != null) {
                id = R.id.id8_ug_car_change_layout;
                ConstraintLayout id8UgCarChangeLayout2 = (ConstraintLayout) rootView2.findViewById(R.id.id8_ug_car_change_layout);
                if (id8UgCarChangeLayout2 != null) {
                    id = R.id.id8_ug_car_change_red;
                    ImageView id8UgCarChangeRed2 = (ImageView) rootView2.findViewById(R.id.id8_ug_car_change_red);
                    if (id8UgCarChangeRed2 != null) {
                        id = R.id.id8_ug_car_change_white;
                        ImageView id8UgCarChangeWhite2 = (ImageView) rootView2.findViewById(R.id.id8_ug_car_change_white);
                        if (id8UgCarChangeWhite2 != null) {
                            id = R.id.id8_ug_car_model;
                            ImageView id8UgCarModel2 = (ImageView) rootView2.findViewById(R.id.id8_ug_car_model);
                            if (id8UgCarModel2 != null) {
                                id = R.id.id8_ug_car_status_black;
                                ImageView id8UgCarStatusBlack2 = (ImageView) rootView2.findViewById(R.id.id8_ug_car_status_black);
                                if (id8UgCarStatusBlack2 != null) {
                                    id = R.id.id8_ug_car_status_red;
                                    ImageView id8UgCarStatusRed2 = (ImageView) rootView2.findViewById(R.id.id8_ug_car_status_red);
                                    if (id8UgCarStatusRed2 != null) {
                                        id = R.id.id8_ug_car_status_white;
                                        ImageView id8UgCarStatusWhite2 = (ImageView) rootView2.findViewById(R.id.id8_ug_car_status_white);
                                        if (id8UgCarStatusWhite2 != null) {
                                            id = R.id.iv_car_speed;
                                            ImageView ivCarSpeed2 = (ImageView) rootView2.findViewById(R.id.iv_car_speed);
                                            if (ivCarSpeed2 != null) {
                                                id = R.id.speed_tv;
                                                TextView speedTv2 = (TextView) rootView2.findViewById(R.id.speed_tv);
                                                if (speedTv2 != null) {
                                                    id = R.id.speed_unit_tv;
                                                    TextView speedUnitTv2 = (TextView) rootView2.findViewById(R.id.speed_unit_tv);
                                                    if (speedUnitTv2 != null) {
                                                        return new FragmentEvoid8MainCarSpeedBinding((CardView) rootView2, id8UgCarChange2, id8UgCarChangeBlack2, id8UgCarChangeLayout2, id8UgCarChangeRed2, id8UgCarChangeWhite2, id8UgCarModel2, id8UgCarStatusBlack2, id8UgCarStatusRed2, id8UgCarStatusWhite2, ivCarSpeed2, speedTv2, speedUnitTv2);
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
