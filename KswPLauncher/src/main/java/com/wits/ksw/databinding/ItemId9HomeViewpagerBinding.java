package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.wits.ksw.R;

public final class ItemId9HomeViewpagerBinding implements ViewBinding {
    public final FrameLayout frameOneLayout;
    public final FrameLayout frameTwoLayout;
    private final LinearLayout rootView;

    private ItemId9HomeViewpagerBinding(LinearLayout rootView2, FrameLayout frameOneLayout2, FrameLayout frameTwoLayout2) {
        this.rootView = rootView2;
        this.frameOneLayout = frameOneLayout2;
        this.frameTwoLayout = frameTwoLayout2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemId9HomeViewpagerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemId9HomeViewpagerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_id9_home_viewpager, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemId9HomeViewpagerBinding bind(View rootView2) {
        int id = R.id.frame_OneLayout;
        FrameLayout frameOneLayout2 = (FrameLayout) rootView2.findViewById(R.id.frame_OneLayout);
        if (frameOneLayout2 != null) {
            id = R.id.frame_TwoLayout;
            FrameLayout frameTwoLayout2 = (FrameLayout) rootView2.findViewById(R.id.frame_TwoLayout);
            if (frameTwoLayout2 != null) {
                return new ItemId9HomeViewpagerBinding((LinearLayout) rootView2, frameOneLayout2, frameTwoLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
