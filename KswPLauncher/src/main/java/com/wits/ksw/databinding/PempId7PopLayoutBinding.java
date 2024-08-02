package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class PempId7PopLayoutBinding implements ViewBinding {
    public final GridView gridView;
    private final RelativeLayout rootView;

    private PempId7PopLayoutBinding(RelativeLayout rootView2, GridView gridView2) {
        this.rootView = rootView2;
        this.gridView = gridView2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PempId7PopLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PempId7PopLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.pemp_id7_pop_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static PempId7PopLayoutBinding bind(View rootView2) {
        GridView gridView2 = (GridView) rootView2.findViewById(R.id.gridView);
        if (gridView2 != null) {
            return new PempId7PopLayoutBinding((RelativeLayout) rootView2, gridView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.gridView)));
    }
}
