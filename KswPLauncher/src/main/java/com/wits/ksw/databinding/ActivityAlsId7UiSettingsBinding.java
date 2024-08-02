package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class ActivityAlsId7UiSettingsBinding implements ViewBinding {
    public final ImageView ImgSetBack;
    public final FrameLayout frameOneLayout;
    public final FrameLayout frameTwoLayout;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;

    private ActivityAlsId7UiSettingsBinding(RelativeLayout rootView2, ImageView ImgSetBack2, FrameLayout frameOneLayout2, FrameLayout frameTwoLayout2, RecyclerView recyclerView2) {
        this.rootView = rootView2;
        this.ImgSetBack = ImgSetBack2;
        this.frameOneLayout = frameOneLayout2;
        this.frameTwoLayout = frameTwoLayout2;
        this.recyclerView = recyclerView2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAlsId7UiSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAlsId7UiSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_als_id7_ui_settings, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityAlsId7UiSettingsBinding bind(View rootView2) {
        int id = R.id.Img_SetBack;
        ImageView ImgSetBack2 = (ImageView) rootView2.findViewById(R.id.Img_SetBack);
        if (ImgSetBack2 != null) {
            id = R.id.frame_OneLayout;
            FrameLayout frameOneLayout2 = (FrameLayout) rootView2.findViewById(R.id.frame_OneLayout);
            if (frameOneLayout2 != null) {
                id = R.id.frame_TwoLayout;
                FrameLayout frameTwoLayout2 = (FrameLayout) rootView2.findViewById(R.id.frame_TwoLayout);
                if (frameTwoLayout2 != null) {
                    id = R.id.recyclerView;
                    RecyclerView recyclerView2 = (RecyclerView) rootView2.findViewById(R.id.recyclerView);
                    if (recyclerView2 != null) {
                        return new ActivityAlsId7UiSettingsBinding((RelativeLayout) rootView2, ImgSetBack2, frameOneLayout2, frameTwoLayout2, recyclerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
