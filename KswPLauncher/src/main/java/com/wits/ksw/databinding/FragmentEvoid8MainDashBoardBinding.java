package com.wits.ksw.databinding;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import com.wits.ksw.R;

public final class FragmentEvoid8MainDashBoardBinding implements ViewBinding {
    private final CardView rootView;

    private FragmentEvoid8MainDashBoardBinding(CardView rootView2) {
        this.rootView = rootView2;
    }

    @Override // android.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static FragmentEvoid8MainDashBoardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentEvoid8MainDashBoardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_evoid8_main_dash_board, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentEvoid8MainDashBoardBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new FragmentEvoid8MainDashBoardBinding((CardView) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}
