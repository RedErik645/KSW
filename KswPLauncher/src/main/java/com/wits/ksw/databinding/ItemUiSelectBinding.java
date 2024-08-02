package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class ItemUiSelectBinding implements ViewBinding {
    public final ImageView imgUiSelct;
    private final RelativeLayout rootView;

    private ItemUiSelectBinding(RelativeLayout rootView2, ImageView imgUiSelct2) {
        this.rootView = rootView2;
        this.imgUiSelct = imgUiSelct2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemUiSelectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemUiSelectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_ui_select, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemUiSelectBinding bind(View rootView2) {
        ImageView imgUiSelct2 = (ImageView) rootView2.findViewById(R.id.img_UiSelct);
        if (imgUiSelct2 != null) {
            return new ItemUiSelectBinding((RelativeLayout) rootView2, imgUiSelct2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.img_UiSelct)));
    }
}
