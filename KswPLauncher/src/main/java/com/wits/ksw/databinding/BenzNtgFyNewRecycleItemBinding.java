package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import com.wits.ksw.R;

public final class BenzNtgFyNewRecycleItemBinding implements ViewBinding {
    public final AppCompatImageView benzMbux2021KswNewItemBg;
    public final AppCompatTextView benzMbux2021KswNewItemContent;
    public final AppCompatImageView benzMbux2021KswNewItemImg;
    public final AppCompatImageView benzMbux2021KswNewItemLeftIcon;
    public final AppCompatImageView benzMbux2021KswNewItemRightIcon;
    public final AppCompatTextView benzMbux2021KswNewItemTitle;
    public final ConstraintLayout benzMbuxEditLay;
    public final AppCompatImageView benzMbuxEditLeftBtn;
    public final AppCompatImageView benzMbuxEditOkBtn;
    public final AppCompatImageView benzMbuxEditRightBtn;
    private final ConstraintLayout rootView;

    private BenzNtgFyNewRecycleItemBinding(ConstraintLayout rootView2, AppCompatImageView benzMbux2021KswNewItemBg2, AppCompatTextView benzMbux2021KswNewItemContent2, AppCompatImageView benzMbux2021KswNewItemImg2, AppCompatImageView benzMbux2021KswNewItemLeftIcon2, AppCompatImageView benzMbux2021KswNewItemRightIcon2, AppCompatTextView benzMbux2021KswNewItemTitle2, ConstraintLayout benzMbuxEditLay2, AppCompatImageView benzMbuxEditLeftBtn2, AppCompatImageView benzMbuxEditOkBtn2, AppCompatImageView benzMbuxEditRightBtn2) {
        this.rootView = rootView2;
        this.benzMbux2021KswNewItemBg = benzMbux2021KswNewItemBg2;
        this.benzMbux2021KswNewItemContent = benzMbux2021KswNewItemContent2;
        this.benzMbux2021KswNewItemImg = benzMbux2021KswNewItemImg2;
        this.benzMbux2021KswNewItemLeftIcon = benzMbux2021KswNewItemLeftIcon2;
        this.benzMbux2021KswNewItemRightIcon = benzMbux2021KswNewItemRightIcon2;
        this.benzMbux2021KswNewItemTitle = benzMbux2021KswNewItemTitle2;
        this.benzMbuxEditLay = benzMbuxEditLay2;
        this.benzMbuxEditLeftBtn = benzMbuxEditLeftBtn2;
        this.benzMbuxEditOkBtn = benzMbuxEditOkBtn2;
        this.benzMbuxEditRightBtn = benzMbuxEditRightBtn2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BenzNtgFyNewRecycleItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BenzNtgFyNewRecycleItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.benz_ntg_fy_new_recycle_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BenzNtgFyNewRecycleItemBinding bind(View rootView2) {
        int id = R.id.benz_mbux_2021_ksw_new_item_bg;
        AppCompatImageView benzMbux2021KswNewItemBg2 = (AppCompatImageView) rootView2.findViewById(R.id.benz_mbux_2021_ksw_new_item_bg);
        if (benzMbux2021KswNewItemBg2 != null) {
            id = R.id.benz_mbux_2021_ksw_new_item_content;
            AppCompatTextView benzMbux2021KswNewItemContent2 = (AppCompatTextView) rootView2.findViewById(R.id.benz_mbux_2021_ksw_new_item_content);
            if (benzMbux2021KswNewItemContent2 != null) {
                id = R.id.benz_mbux_2021_ksw_new_item_img;
                AppCompatImageView benzMbux2021KswNewItemImg2 = (AppCompatImageView) rootView2.findViewById(R.id.benz_mbux_2021_ksw_new_item_img);
                if (benzMbux2021KswNewItemImg2 != null) {
                    id = R.id.benz_mbux_2021_ksw_new_item_left_icon;
                    AppCompatImageView benzMbux2021KswNewItemLeftIcon2 = (AppCompatImageView) rootView2.findViewById(R.id.benz_mbux_2021_ksw_new_item_left_icon);
                    if (benzMbux2021KswNewItemLeftIcon2 != null) {
                        id = R.id.benz_mbux_2021_ksw_new_item_right_icon;
                        AppCompatImageView benzMbux2021KswNewItemRightIcon2 = (AppCompatImageView) rootView2.findViewById(R.id.benz_mbux_2021_ksw_new_item_right_icon);
                        if (benzMbux2021KswNewItemRightIcon2 != null) {
                            id = R.id.benz_mbux_2021_ksw_new_item_title;
                            AppCompatTextView benzMbux2021KswNewItemTitle2 = (AppCompatTextView) rootView2.findViewById(R.id.benz_mbux_2021_ksw_new_item_title);
                            if (benzMbux2021KswNewItemTitle2 != null) {
                                id = R.id.benz_mbux_edit_lay;
                                ConstraintLayout benzMbuxEditLay2 = (ConstraintLayout) rootView2.findViewById(R.id.benz_mbux_edit_lay);
                                if (benzMbuxEditLay2 != null) {
                                    id = R.id.benz_mbux_edit_left_btn;
                                    AppCompatImageView benzMbuxEditLeftBtn2 = (AppCompatImageView) rootView2.findViewById(R.id.benz_mbux_edit_left_btn);
                                    if (benzMbuxEditLeftBtn2 != null) {
                                        id = R.id.benz_mbux_edit_ok_btn;
                                        AppCompatImageView benzMbuxEditOkBtn2 = (AppCompatImageView) rootView2.findViewById(R.id.benz_mbux_edit_ok_btn);
                                        if (benzMbuxEditOkBtn2 != null) {
                                            id = R.id.benz_mbux_edit_right_btn;
                                            AppCompatImageView benzMbuxEditRightBtn2 = (AppCompatImageView) rootView2.findViewById(R.id.benz_mbux_edit_right_btn);
                                            if (benzMbuxEditRightBtn2 != null) {
                                                return new BenzNtgFyNewRecycleItemBinding((ConstraintLayout) rootView2, benzMbux2021KswNewItemBg2, benzMbux2021KswNewItemContent2, benzMbux2021KswNewItemImg2, benzMbux2021KswNewItemLeftIcon2, benzMbux2021KswNewItemRightIcon2, benzMbux2021KswNewItemTitle2, benzMbuxEditLay2, benzMbuxEditLeftBtn2, benzMbuxEditOkBtn2, benzMbuxEditRightBtn2);
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
