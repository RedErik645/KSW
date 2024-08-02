package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LexusLsDesktopAppItemBinding implements ViewBinding {
    public final ImageView ivLexusMainAppicon;
    public final LinearLayout layoutLLAppMain;
    private final LinearLayout rootView;
    public final TextView tvLexusMainAppname;

    private LexusLsDesktopAppItemBinding(LinearLayout rootView2, ImageView ivLexusMainAppicon2, LinearLayout layoutLLAppMain2, TextView tvLexusMainAppname2) {
        this.rootView = rootView2;
        this.ivLexusMainAppicon = ivLexusMainAppicon2;
        this.layoutLLAppMain = layoutLLAppMain2;
        this.tvLexusMainAppname = tvLexusMainAppname2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LexusLsDesktopAppItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LexusLsDesktopAppItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.lexus_ls_desktop_app_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LexusLsDesktopAppItemBinding bind(View rootView2) {
        int id = R.id.iv_lexus_main_appicon;
        ImageView ivLexusMainAppicon2 = (ImageView) rootView2.findViewById(R.id.iv_lexus_main_appicon);
        if (ivLexusMainAppicon2 != null) {
            LinearLayout layoutLLAppMain2 = (LinearLayout) rootView2;
            id = R.id.tv_lexus_main_appname;
            TextView tvLexusMainAppname2 = (TextView) rootView2.findViewById(R.id.tv_lexus_main_appname);
            if (tvLexusMainAppname2 != null) {
                return new LexusLsDesktopAppItemBinding((LinearLayout) rootView2, ivLexusMainAppicon2, layoutLLAppMain2, tvLexusMainAppname2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
