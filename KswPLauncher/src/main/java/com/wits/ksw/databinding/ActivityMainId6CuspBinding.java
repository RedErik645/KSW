package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import com.wits.ksw.R;

public final class ActivityMainId6CuspBinding implements ViewBinding {
    public final ImageView id6CuspLeftBtn;
    public final ViewPager id6CuspMainViewPager;
    public final ImageView id6CuspRightBtn;
    private final ConstraintLayout rootView;

    private ActivityMainId6CuspBinding(ConstraintLayout rootView2, ImageView id6CuspLeftBtn2, ViewPager id6CuspMainViewPager2, ImageView id6CuspRightBtn2) {
        this.rootView = rootView2;
        this.id6CuspLeftBtn = id6CuspLeftBtn2;
        this.id6CuspMainViewPager = id6CuspMainViewPager2;
        this.id6CuspRightBtn = id6CuspRightBtn2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainId6CuspBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMainId6CuspBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_main_id6_cusp, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMainId6CuspBinding bind(View rootView2) {
        int id = R.id.id6_cusp_left_btn;
        ImageView id6CuspLeftBtn2 = (ImageView) rootView2.findViewById(R.id.id6_cusp_left_btn);
        if (id6CuspLeftBtn2 != null) {
            id = R.id.id6_cusp_main_view_pager;
            ViewPager id6CuspMainViewPager2 = (ViewPager) rootView2.findViewById(R.id.id6_cusp_main_view_pager);
            if (id6CuspMainViewPager2 != null) {
                id = R.id.id6_cusp_right_btn;
                ImageView id6CuspRightBtn2 = (ImageView) rootView2.findViewById(R.id.id6_cusp_right_btn);
                if (id6CuspRightBtn2 != null) {
                    return new ActivityMainId6CuspBinding((ConstraintLayout) rootView2, id6CuspLeftBtn2, id6CuspMainViewPager2, id6CuspRightBtn2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
