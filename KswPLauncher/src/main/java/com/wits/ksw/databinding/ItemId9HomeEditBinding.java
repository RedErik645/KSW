package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.wits.ksw.R;

public final class ItemId9HomeEditBinding implements ViewBinding {
    public final FrameLayout frameOneLayout;
    private final LinearLayout rootView;

    private ItemId9HomeEditBinding(LinearLayout rootView2, FrameLayout frameOneLayout2) {
        this.rootView = rootView2;
        this.frameOneLayout = frameOneLayout2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemId9HomeEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemId9HomeEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_id9_home_edit, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemId9HomeEditBinding bind(View rootView2) {
        FrameLayout frameOneLayout2 = (FrameLayout) rootView2.findViewById(R.id.frame_OneLayout);
        if (frameOneLayout2 != null) {
            return new ItemId9HomeEditBinding((LinearLayout) rootView2, frameOneLayout2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.frame_OneLayout)));
    }
}
