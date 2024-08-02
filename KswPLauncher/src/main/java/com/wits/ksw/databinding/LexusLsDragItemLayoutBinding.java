package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.lexusls.drag.DraggableLayout;

public final class LexusLsDragItemLayoutBinding implements ViewBinding {
    public final DraggableLayout draggableLayout;
    public final ImageView icon;
    public final RelativeLayout layoutLL;
    private final RelativeLayout rootView;
    public final TextView tvTitle;

    private LexusLsDragItemLayoutBinding(RelativeLayout rootView2, DraggableLayout draggableLayout2, ImageView icon2, RelativeLayout layoutLL2, TextView tvTitle2) {
        this.rootView = rootView2;
        this.draggableLayout = draggableLayout2;
        this.icon = icon2;
        this.layoutLL = layoutLL2;
        this.tvTitle = tvTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LexusLsDragItemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LexusLsDragItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.lexus_ls_drag_item_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LexusLsDragItemLayoutBinding bind(View rootView2) {
        int id = R.id.draggable_layout;
        DraggableLayout draggableLayout2 = (DraggableLayout) rootView2.findViewById(R.id.draggable_layout);
        if (draggableLayout2 != null) {
            id = R.id.icon;
            ImageView icon2 = (ImageView) rootView2.findViewById(R.id.icon);
            if (icon2 != null) {
                RelativeLayout layoutLL2 = (RelativeLayout) rootView2;
                id = R.id.tv_title;
                TextView tvTitle2 = (TextView) rootView2.findViewById(R.id.tv_title);
                if (tvTitle2 != null) {
                    return new LexusLsDragItemLayoutBinding((RelativeLayout) rootView2, draggableLayout2, icon2, layoutLL2, tvTitle2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
