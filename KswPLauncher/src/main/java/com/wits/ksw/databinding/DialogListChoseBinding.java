package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import com.wits.ksw.R;

public final class DialogListChoseBinding implements ViewBinding {
    public final RecyclerView naviRecycle;
    private final LinearLayout rootView;

    private DialogListChoseBinding(LinearLayout rootView2, RecyclerView naviRecycle2) {
        this.rootView = rootView2;
        this.naviRecycle = naviRecycle2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogListChoseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogListChoseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_list_chose, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogListChoseBinding bind(View rootView2) {
        RecyclerView naviRecycle2 = (RecyclerView) rootView2.findViewById(R.id.navi_recycle);
        if (naviRecycle2 != null) {
            return new DialogListChoseBinding((LinearLayout) rootView2, naviRecycle2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.navi_recycle)));
    }
}
