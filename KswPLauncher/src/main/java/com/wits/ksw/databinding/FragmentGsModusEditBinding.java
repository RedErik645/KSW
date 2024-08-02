package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class FragmentGsModusEditBinding implements ViewBinding {
    public final ImageView gsId8IconEditBg;
    private final RelativeLayout rootView;

    private FragmentGsModusEditBinding(RelativeLayout rootView2, ImageView gsId8IconEditBg2) {
        this.rootView = rootView2;
        this.gsId8IconEditBg = gsId8IconEditBg2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentGsModusEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentGsModusEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_gs_modus_edit, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentGsModusEditBinding bind(View rootView2) {
        ImageView gsId8IconEditBg2 = (ImageView) rootView2.findViewById(R.id.gs_id8_icon_edit_bg);
        if (gsId8IconEditBg2 != null) {
            return new FragmentGsModusEditBinding((RelativeLayout) rootView2, gsId8IconEditBg2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.gs_id8_icon_edit_bg)));
    }
}
