package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class AlsId7UiFactoryLogoSelectBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;
    public final RecyclerView siRenRecyclerView;
    public final TextView tvInput;
    public final TextView tvOne;
    public final TextView tvTwo;

    private AlsId7UiFactoryLogoSelectBinding(RelativeLayout rootView2, RecyclerView recyclerView2, RecyclerView siRenRecyclerView2, TextView tvInput2, TextView tvOne2, TextView tvTwo2) {
        this.rootView = rootView2;
        this.recyclerView = recyclerView2;
        this.siRenRecyclerView = siRenRecyclerView2;
        this.tvInput = tvInput2;
        this.tvOne = tvOne2;
        this.tvTwo = tvTwo2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AlsId7UiFactoryLogoSelectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlsId7UiFactoryLogoSelectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.als_id7_ui_factory_logo_select, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AlsId7UiFactoryLogoSelectBinding bind(View rootView2) {
        int id = R.id.recyclerView;
        RecyclerView recyclerView2 = (RecyclerView) rootView2.findViewById(R.id.recyclerView);
        if (recyclerView2 != null) {
            id = R.id.siRen_recyclerView;
            RecyclerView siRenRecyclerView2 = (RecyclerView) rootView2.findViewById(R.id.siRen_recyclerView);
            if (siRenRecyclerView2 != null) {
                id = R.id.tv_Input;
                TextView tvInput2 = (TextView) rootView2.findViewById(R.id.tv_Input);
                if (tvInput2 != null) {
                    id = R.id.tvOne;
                    TextView tvOne2 = (TextView) rootView2.findViewById(R.id.tvOne);
                    if (tvOne2 != null) {
                        id = R.id.tvTwo;
                        TextView tvTwo2 = (TextView) rootView2.findViewById(R.id.tvTwo);
                        if (tvTwo2 != null) {
                            return new AlsId7UiFactoryLogoSelectBinding((RelativeLayout) rootView2, recyclerView2, siRenRecyclerView2, tvInput2, tvOne2, tvTwo2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
