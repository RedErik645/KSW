package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class AlsId7UiFactoryCanBusBinding implements ViewBinding {
    public final RecyclerView rawCarRecycle;
    private final ScrollView rootView;
    public final TextView tvRawCarSele;
    public final TextView tvRawSeleTitle;

    private AlsId7UiFactoryCanBusBinding(ScrollView rootView2, RecyclerView rawCarRecycle2, TextView tvRawCarSele2, TextView tvRawSeleTitle2) {
        this.rootView = rootView2;
        this.rawCarRecycle = rawCarRecycle2;
        this.tvRawCarSele = tvRawCarSele2;
        this.tvRawSeleTitle = tvRawSeleTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static AlsId7UiFactoryCanBusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlsId7UiFactoryCanBusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.als_id7_ui_factory_can_bus, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AlsId7UiFactoryCanBusBinding bind(View rootView2) {
        int id = R.id.rawCar_recycle;
        RecyclerView rawCarRecycle2 = (RecyclerView) rootView2.findViewById(R.id.rawCar_recycle);
        if (rawCarRecycle2 != null) {
            id = R.id.tv_rawCarSele;
            TextView tvRawCarSele2 = (TextView) rootView2.findViewById(R.id.tv_rawCarSele);
            if (tvRawCarSele2 != null) {
                id = R.id.tv_rawSeleTitle;
                TextView tvRawSeleTitle2 = (TextView) rootView2.findViewById(R.id.tv_rawSeleTitle);
                if (tvRawSeleTitle2 != null) {
                    return new AlsId7UiFactoryCanBusBinding((ScrollView) rootView2, rawCarRecycle2, tvRawCarSele2, tvRawSeleTitle2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
