package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LexusLsAddAppItemBinding implements ViewBinding {
    public final CheckBox cbLexuslsSelApp;
    public final ImageView ivLexuslsAppIcon;
    public final LinearLayout layoutLL;
    private final LinearLayout rootView;
    public final TextView tvLexuslsAppName;

    private LexusLsAddAppItemBinding(LinearLayout rootView2, CheckBox cbLexuslsSelApp2, ImageView ivLexuslsAppIcon2, LinearLayout layoutLL2, TextView tvLexuslsAppName2) {
        this.rootView = rootView2;
        this.cbLexuslsSelApp = cbLexuslsSelApp2;
        this.ivLexuslsAppIcon = ivLexuslsAppIcon2;
        this.layoutLL = layoutLL2;
        this.tvLexuslsAppName = tvLexuslsAppName2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LexusLsAddAppItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LexusLsAddAppItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.lexus_ls_add_app_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LexusLsAddAppItemBinding bind(View rootView2) {
        int id = R.id.cb_lexusls_sel_app;
        CheckBox cbLexuslsSelApp2 = (CheckBox) rootView2.findViewById(R.id.cb_lexusls_sel_app);
        if (cbLexuslsSelApp2 != null) {
            id = R.id.iv_lexusls_app_icon;
            ImageView ivLexuslsAppIcon2 = (ImageView) rootView2.findViewById(R.id.iv_lexusls_app_icon);
            if (ivLexuslsAppIcon2 != null) {
                LinearLayout layoutLL2 = (LinearLayout) rootView2;
                id = R.id.tv_lexusls_app_name;
                TextView tvLexuslsAppName2 = (TextView) rootView2.findViewById(R.id.tv_lexusls_app_name);
                if (tvLexuslsAppName2 != null) {
                    return new LexusLsAddAppItemBinding((LinearLayout) rootView2, cbLexuslsSelApp2, ivLexuslsAppIcon2, layoutLL2, tvLexuslsAppName2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
