package com.wits.ksw.databinding;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FragmentEvoid8MainFavouriteBinding implements ViewBinding {
    public final ImageView id8UgCardViewBgIv;
    public final TextView id8UgCardViewTitle;
    public final RecyclerView recyclerView;
    private final CardView rootView;

    private FragmentEvoid8MainFavouriteBinding(CardView rootView2, ImageView id8UgCardViewBgIv2, TextView id8UgCardViewTitle2, RecyclerView recyclerView2) {
        this.rootView = rootView2;
        this.id8UgCardViewBgIv = id8UgCardViewBgIv2;
        this.id8UgCardViewTitle = id8UgCardViewTitle2;
        this.recyclerView = recyclerView2;
    }

    @Override // android.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static FragmentEvoid8MainFavouriteBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentEvoid8MainFavouriteBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_evoid8_main_favourite, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentEvoid8MainFavouriteBinding bind(View rootView2) {
        int id = R.id.id8_ug_card_view_bg_iv;
        ImageView id8UgCardViewBgIv2 = (ImageView) rootView2.findViewById(R.id.id8_ug_card_view_bg_iv);
        if (id8UgCardViewBgIv2 != null) {
            id = R.id.id8_ug_card_view_title;
            TextView id8UgCardViewTitle2 = (TextView) rootView2.findViewById(R.id.id8_ug_card_view_title);
            if (id8UgCardViewTitle2 != null) {
                id = R.id.recyclerView;
                RecyclerView recyclerView2 = (RecyclerView) rootView2.findViewById(R.id.recyclerView);
                if (recyclerView2 != null) {
                    return new FragmentEvoid8MainFavouriteBinding((CardView) rootView2, id8UgCardViewBgIv2, id8UgCardViewTitle2, recyclerView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
