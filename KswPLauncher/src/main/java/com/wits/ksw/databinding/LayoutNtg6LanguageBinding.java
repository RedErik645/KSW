package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class LayoutNtg6LanguageBinding implements ViewBinding {
    public final ImageView imgTwoBack;
    public final RecyclerView languageRecycle;
    public final ImageView layoutNtg6LanguagBg;
    private final RelativeLayout rootView;

    private LayoutNtg6LanguageBinding(RelativeLayout rootView2, ImageView imgTwoBack2, RecyclerView languageRecycle2, ImageView layoutNtg6LanguagBg2) {
        this.rootView = rootView2;
        this.imgTwoBack = imgTwoBack2;
        this.languageRecycle = languageRecycle2;
        this.layoutNtg6LanguagBg = layoutNtg6LanguagBg2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutNtg6LanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutNtg6LanguageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_ntg6_language, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutNtg6LanguageBinding bind(View rootView2) {
        int id = R.id.img_TwoBack;
        ImageView imgTwoBack2 = (ImageView) rootView2.findViewById(R.id.img_TwoBack);
        if (imgTwoBack2 != null) {
            id = R.id.language_recycle;
            RecyclerView languageRecycle2 = (RecyclerView) rootView2.findViewById(R.id.language_recycle);
            if (languageRecycle2 != null) {
                id = R.id.layout_ntg6_languag_bg;
                ImageView layoutNtg6LanguagBg2 = (ImageView) rootView2.findViewById(R.id.layout_ntg6_languag_bg);
                if (layoutNtg6LanguagBg2 != null) {
                    return new LayoutNtg6LanguageBinding((RelativeLayout) rootView2, imgTwoBack2, languageRecycle2, layoutNtg6LanguagBg2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
