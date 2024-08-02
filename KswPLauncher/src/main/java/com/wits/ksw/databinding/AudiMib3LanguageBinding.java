package com.wits.ksw.databinding;

import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class AudiMib3LanguageBinding implements ViewBinding {
    public final ListView audiLanguageListView;
    private final RelativeLayout rootView;
    public final AppCompatTextView title;
    public final View titleDivider;
    public final View vDivider;

    private AudiMib3LanguageBinding(RelativeLayout rootView2, ListView audiLanguageListView2, AppCompatTextView title2, View titleDivider2, View vDivider2) {
        this.rootView = rootView2;
        this.audiLanguageListView = audiLanguageListView2;
        this.title = title2;
        this.titleDivider = titleDivider2;
        this.vDivider = vDivider2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AudiMib3LanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AudiMib3LanguageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.audi_mib3_language, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AudiMib3LanguageBinding bind(View rootView2) {
        int id = R.id.audiLanguageListView;
        ListView audiLanguageListView2 = (ListView) rootView2.findViewById(R.id.audiLanguageListView);
        if (audiLanguageListView2 != null) {
            id = R.id.title;
            AppCompatTextView title2 = (AppCompatTextView) rootView2.findViewById(R.id.title);
            if (title2 != null) {
                id = R.id.title_divider;
                View titleDivider2 = rootView2.findViewById(R.id.title_divider);
                if (titleDivider2 != null) {
                    id = R.id.v_divider;
                    View vDivider2 = rootView2.findViewById(R.id.v_divider);
                    if (vDivider2 != null) {
                        return new AudiMib3LanguageBinding((RelativeLayout) rootView2, audiLanguageListView2, title2, titleDivider2, vDivider2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
