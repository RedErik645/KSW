package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlId6SetBgLayout;

public final class ActivityId6SettingsBinding implements ViewBinding {
    public final ImageView imgBack;
    public final ImageView imgSetIcon;
    public final RecyclerView recyclerView;
    public final RelativeLayout relatOne;
    public final RelativeLayout relatShow;
    public final RelativeLayout relatTwo;
    private final RtlId6SetBgLayout rootView;
    public final TextView tvId6SetTitle;

    private ActivityId6SettingsBinding(RtlId6SetBgLayout rootView2, ImageView imgBack2, ImageView imgSetIcon2, RecyclerView recyclerView2, RelativeLayout relatOne2, RelativeLayout relatShow2, RelativeLayout relatTwo2, TextView tvId6SetTitle2) {
        this.rootView = rootView2;
        this.imgBack = imgBack2;
        this.imgSetIcon = imgSetIcon2;
        this.recyclerView = recyclerView2;
        this.relatOne = relatOne2;
        this.relatShow = relatShow2;
        this.relatTwo = relatTwo2;
        this.tvId6SetTitle = tvId6SetTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RtlId6SetBgLayout getRoot() {
        return this.rootView;
    }

    public static ActivityId6SettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityId6SettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_id6_settings, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityId6SettingsBinding bind(View rootView2) {
        int id = R.id.img_Back;
        ImageView imgBack2 = (ImageView) rootView2.findViewById(R.id.img_Back);
        if (imgBack2 != null) {
            id = R.id.img_SetIcon;
            ImageView imgSetIcon2 = (ImageView) rootView2.findViewById(R.id.img_SetIcon);
            if (imgSetIcon2 != null) {
                id = R.id.recyclerView;
                RecyclerView recyclerView2 = (RecyclerView) rootView2.findViewById(R.id.recyclerView);
                if (recyclerView2 != null) {
                    id = R.id.relat_One;
                    RelativeLayout relatOne2 = (RelativeLayout) rootView2.findViewById(R.id.relat_One);
                    if (relatOne2 != null) {
                        id = R.id.relat_Show;
                        RelativeLayout relatShow2 = (RelativeLayout) rootView2.findViewById(R.id.relat_Show);
                        if (relatShow2 != null) {
                            id = R.id.relat_Two;
                            RelativeLayout relatTwo2 = (RelativeLayout) rootView2.findViewById(R.id.relat_Two);
                            if (relatTwo2 != null) {
                                id = R.id.tv_id6SetTitle;
                                TextView tvId6SetTitle2 = (TextView) rootView2.findViewById(R.id.tv_id6SetTitle);
                                if (tvId6SetTitle2 != null) {
                                    return new ActivityId6SettingsBinding((RtlId6SetBgLayout) rootView2, imgBack2, imgSetIcon2, recyclerView2, relatOne2, relatShow2, relatTwo2, tvId6SetTitle2);
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
