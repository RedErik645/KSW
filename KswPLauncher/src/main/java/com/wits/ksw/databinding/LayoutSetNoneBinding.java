package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LayoutSetNoneBinding implements ViewBinding {
    private final ScrollView rootView;
    public final TextView tvOneDefaul;

    private LayoutSetNoneBinding(ScrollView rootView2, TextView tvOneDefaul2) {
        this.rootView = rootView2;
        this.tvOneDefaul = tvOneDefaul2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static LayoutSetNoneBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutSetNoneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_set_none, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutSetNoneBinding bind(View rootView2) {
        TextView tvOneDefaul2 = (TextView) rootView2.findViewById(R.id.tv_oneDefaul);
        if (tvOneDefaul2 != null) {
            return new LayoutSetNoneBinding((ScrollView) rootView2, tvOneDefaul2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.tv_oneDefaul)));
    }
}
