package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import com.wits.ksw.R;

public final class ActivityMainId6Binding implements ViewBinding {
    public final ImageView id6LeftBtn;
    public final ViewPager id6MainViewPager;
    public final ImageView id6RightBtn;
    private final ConstraintLayout rootView;

    private ActivityMainId6Binding(ConstraintLayout rootView2, ImageView id6LeftBtn2, ViewPager id6MainViewPager2, ImageView id6RightBtn2) {
        this.rootView = rootView2;
        this.id6LeftBtn = id6LeftBtn2;
        this.id6MainViewPager = id6MainViewPager2;
        this.id6RightBtn = id6RightBtn2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainId6Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMainId6Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_main_id6, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMainId6Binding bind(View rootView2) {
        int id = R.id.id6_left_btn;
        ImageView id6LeftBtn2 = (ImageView) rootView2.findViewById(R.id.id6_left_btn);
        if (id6LeftBtn2 != null) {
            id = R.id.id6_main_view_pager;
            ViewPager id6MainViewPager2 = (ViewPager) rootView2.findViewById(R.id.id6_main_view_pager);
            if (id6MainViewPager2 != null) {
                id = R.id.id6_right_btn;
                ImageView id6RightBtn2 = (ImageView) rootView2.findViewById(R.id.id6_right_btn);
                if (id6RightBtn2 != null) {
                    return new ActivityMainId6Binding((ConstraintLayout) rootView2, id6LeftBtn2, id6MainViewPager2, id6RightBtn2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
