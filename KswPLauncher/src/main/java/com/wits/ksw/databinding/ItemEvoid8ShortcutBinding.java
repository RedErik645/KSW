package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class ItemEvoid8ShortcutBinding implements ViewBinding {
    public final ImageView nameImageView;
    private final RelativeLayout rootView;

    private ItemEvoid8ShortcutBinding(RelativeLayout rootView2, ImageView nameImageView2) {
        this.rootView = rootView2;
        this.nameImageView = nameImageView2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemEvoid8ShortcutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemEvoid8ShortcutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_evoid8_shortcut, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemEvoid8ShortcutBinding bind(View rootView2) {
        ImageView nameImageView2 = (ImageView) rootView2.findViewById(R.id.nameImageView);
        if (nameImageView2 != null) {
            return new ItemEvoid8ShortcutBinding((RelativeLayout) rootView2, nameImageView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.nameImageView)));
    }
}
