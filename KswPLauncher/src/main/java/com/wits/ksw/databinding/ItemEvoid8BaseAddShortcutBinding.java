package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class ItemEvoid8BaseAddShortcutBinding implements ViewBinding {
    public final ImageView nameImageView;
    private final RelativeLayout rootView;
    public final TextView textView;

    private ItemEvoid8BaseAddShortcutBinding(RelativeLayout rootView2, ImageView nameImageView2, TextView textView2) {
        this.rootView = rootView2;
        this.nameImageView = nameImageView2;
        this.textView = textView2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemEvoid8BaseAddShortcutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemEvoid8BaseAddShortcutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_evoid8_base_add_shortcut, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemEvoid8BaseAddShortcutBinding bind(View rootView2) {
        int id = R.id.nameImageView;
        ImageView nameImageView2 = (ImageView) rootView2.findViewById(R.id.nameImageView);
        if (nameImageView2 != null) {
            id = R.id.textView;
            TextView textView2 = (TextView) rootView2.findViewById(R.id.textView);
            if (textView2 != null) {
                return new ItemEvoid8BaseAddShortcutBinding((RelativeLayout) rootView2, nameImageView2, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
