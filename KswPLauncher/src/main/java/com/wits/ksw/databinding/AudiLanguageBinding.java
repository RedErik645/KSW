package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ListView;
import com.wits.ksw.R;

public final class AudiLanguageBinding implements ViewBinding {
    public final ListView audiLanguageListView;
    private final ListView rootView;

    private AudiLanguageBinding(ListView rootView2, ListView audiLanguageListView2) {
        this.rootView = rootView2;
        this.audiLanguageListView = audiLanguageListView2;
    }

    @Override // android.viewbinding.ViewBinding
    public ListView getRoot() {
        return this.rootView;
    }

    public static AudiLanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AudiLanguageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.audi_language, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AudiLanguageBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new AudiLanguageBinding((ListView) rootView2, (ListView) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}
