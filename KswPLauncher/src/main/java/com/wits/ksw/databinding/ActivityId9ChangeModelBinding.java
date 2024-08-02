package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class ActivityId9ChangeModelBinding implements ViewBinding {
    public final FrameLayout frameLayout;
    public final TextView id9ChangeTitleModel;
    public final TextView id9ChangeTitleWallpaper;
    public final LinearLayout id9MenuLl;
    public final TextView modelTitleTv;
    private final ConstraintLayout rootView;

    private ActivityId9ChangeModelBinding(ConstraintLayout rootView2, FrameLayout frameLayout2, TextView id9ChangeTitleModel2, TextView id9ChangeTitleWallpaper2, LinearLayout id9MenuLl2, TextView modelTitleTv2) {
        this.rootView = rootView2;
        this.frameLayout = frameLayout2;
        this.id9ChangeTitleModel = id9ChangeTitleModel2;
        this.id9ChangeTitleWallpaper = id9ChangeTitleWallpaper2;
        this.id9MenuLl = id9MenuLl2;
        this.modelTitleTv = modelTitleTv2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityId9ChangeModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityId9ChangeModelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_id9_change_model, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityId9ChangeModelBinding bind(View rootView2) {
        int id = R.id.frameLayout;
        FrameLayout frameLayout2 = (FrameLayout) rootView2.findViewById(R.id.frameLayout);
        if (frameLayout2 != null) {
            id = R.id.id9_change_title_model;
            TextView id9ChangeTitleModel2 = (TextView) rootView2.findViewById(R.id.id9_change_title_model);
            if (id9ChangeTitleModel2 != null) {
                id = R.id.id9_change_title_wallpaper;
                TextView id9ChangeTitleWallpaper2 = (TextView) rootView2.findViewById(R.id.id9_change_title_wallpaper);
                if (id9ChangeTitleWallpaper2 != null) {
                    id = R.id.id9_menu_ll;
                    LinearLayout id9MenuLl2 = (LinearLayout) rootView2.findViewById(R.id.id9_menu_ll);
                    if (id9MenuLl2 != null) {
                        id = R.id.model_title_tv;
                        TextView modelTitleTv2 = (TextView) rootView2.findViewById(R.id.model_title_tv);
                        if (modelTitleTv2 != null) {
                            return new ActivityId9ChangeModelBinding((ConstraintLayout) rootView2, frameLayout2, id9ChangeTitleModel2, id9ChangeTitleWallpaper2, id9MenuLl2, modelTitleTv2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
