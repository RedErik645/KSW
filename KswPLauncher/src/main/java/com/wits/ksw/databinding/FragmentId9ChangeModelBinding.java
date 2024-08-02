package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import com.wits.ksw.R;

public final class FragmentId9ChangeModelBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private FragmentId9ChangeModelBinding(ConstraintLayout rootView2, RecyclerView recyclerView2) {
        this.rootView = rootView2;
        this.recyclerView = recyclerView2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentId9ChangeModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentId9ChangeModelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_id9_change_model, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentId9ChangeModelBinding bind(View rootView2) {
        RecyclerView recyclerView2 = (RecyclerView) rootView2.findViewById(R.id.recyclerView);
        if (recyclerView2 != null) {
            return new FragmentId9ChangeModelBinding((ConstraintLayout) rootView2, recyclerView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.recyclerView)));
    }
}
