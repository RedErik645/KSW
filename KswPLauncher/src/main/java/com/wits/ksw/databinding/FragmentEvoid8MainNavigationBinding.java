package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FragmentEvoid8MainNavigationBinding implements ViewBinding {
    public final TextView id8UgCardViewTitle;
    public final RelativeLayout id8UgNaviChange;
    public final ConstraintLayout id8UgNaviChangeLayout;
    public final RecyclerView recyclerView;
    private final CardView rootView;

    private FragmentEvoid8MainNavigationBinding(CardView rootView2, TextView id8UgCardViewTitle2, RelativeLayout id8UgNaviChange2, ConstraintLayout id8UgNaviChangeLayout2, RecyclerView recyclerView2) {
        this.rootView = rootView2;
        this.id8UgCardViewTitle = id8UgCardViewTitle2;
        this.id8UgNaviChange = id8UgNaviChange2;
        this.id8UgNaviChangeLayout = id8UgNaviChangeLayout2;
        this.recyclerView = recyclerView2;
    }

    @Override // android.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static FragmentEvoid8MainNavigationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentEvoid8MainNavigationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_evoid8_main_navigation, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentEvoid8MainNavigationBinding bind(View rootView2) {
        int id = R.id.id8_ug_card_view_title;
        TextView id8UgCardViewTitle2 = (TextView) rootView2.findViewById(R.id.id8_ug_card_view_title);
        if (id8UgCardViewTitle2 != null) {
            id = R.id.id8_ug_navi_change;
            RelativeLayout id8UgNaviChange2 = (RelativeLayout) rootView2.findViewById(R.id.id8_ug_navi_change);
            if (id8UgNaviChange2 != null) {
                id = R.id.id8_ug_navi_change_layout;
                ConstraintLayout id8UgNaviChangeLayout2 = (ConstraintLayout) rootView2.findViewById(R.id.id8_ug_navi_change_layout);
                if (id8UgNaviChangeLayout2 != null) {
                    id = R.id.recyclerView;
                    RecyclerView recyclerView2 = (RecyclerView) rootView2.findViewById(R.id.recyclerView);
                    if (recyclerView2 != null) {
                        return new FragmentEvoid8MainNavigationBinding((CardView) rootView2, id8UgCardViewTitle2, id8UgNaviChange2, id8UgNaviChangeLayout2, recyclerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
