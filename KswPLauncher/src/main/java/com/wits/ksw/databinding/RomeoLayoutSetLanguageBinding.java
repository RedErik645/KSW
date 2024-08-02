package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import com.wits.ksw.R;

public final class RomeoLayoutSetLanguageBinding implements ViewBinding {
    public final RecyclerView languageRecycle;
    private final LinearLayout rootView;

    private RomeoLayoutSetLanguageBinding(LinearLayout rootView2, RecyclerView languageRecycle2) {
        this.rootView = rootView2;
        this.languageRecycle = languageRecycle2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RomeoLayoutSetLanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RomeoLayoutSetLanguageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.romeo_layout_set_language, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RomeoLayoutSetLanguageBinding bind(View rootView2) {
        RecyclerView languageRecycle2 = (RecyclerView) rootView2.findViewById(R.id.language_recycle);
        if (languageRecycle2 != null) {
            return new RomeoLayoutSetLanguageBinding((LinearLayout) rootView2, languageRecycle2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.language_recycle)));
    }
}