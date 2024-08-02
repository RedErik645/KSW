package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import com.wits.ksw.R;

public final class Ntg6v3RecyclerviewLayoutBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final RecyclerView rootView;

    private Ntg6v3RecyclerviewLayoutBinding(RecyclerView rootView2, RecyclerView recyclerView2) {
        this.rootView = rootView2;
        this.recyclerView = recyclerView2;
    }

    @Override // android.viewbinding.ViewBinding
    public RecyclerView getRoot() {
        return this.rootView;
    }

    public static Ntg6v3RecyclerviewLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Ntg6v3RecyclerviewLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.ntg6v3_recyclerview_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static Ntg6v3RecyclerviewLayoutBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new Ntg6v3RecyclerviewLayoutBinding((RecyclerView) rootView2, (RecyclerView) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}
