package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import com.wits.ksw.R;

public final class FactoryUiConfigBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RecyclerView uiRecycle;

    private FactoryUiConfigBinding(LinearLayout rootView2, RecyclerView uiRecycle2) {
        this.rootView = rootView2;
        this.uiRecycle = uiRecycle2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FactoryUiConfigBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FactoryUiConfigBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.factory_ui_config, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FactoryUiConfigBinding bind(View rootView2) {
        RecyclerView uiRecycle2 = (RecyclerView) rootView2.findViewById(R.id.ui_recycle);
        if (uiRecycle2 != null) {
            return new FactoryUiConfigBinding((LinearLayout) rootView2, uiRecycle2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.ui_recycle)));
    }
}
