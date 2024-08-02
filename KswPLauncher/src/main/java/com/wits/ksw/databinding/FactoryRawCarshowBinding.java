package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FactoryRawCarshowBinding implements ViewBinding {
    public final CheckBox cboxDcld;
    public final RecyclerView rawCarRecycle;
    private final ScrollView rootView;
    public final TextView tvRawCarSele;
    public final TextView tvrawCarTite;

    private FactoryRawCarshowBinding(ScrollView rootView2, CheckBox cboxDcld2, RecyclerView rawCarRecycle2, TextView tvRawCarSele2, TextView tvrawCarTite2) {
        this.rootView = rootView2;
        this.cboxDcld = cboxDcld2;
        this.rawCarRecycle = rawCarRecycle2;
        this.tvRawCarSele = tvRawCarSele2;
        this.tvrawCarTite = tvrawCarTite2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FactoryRawCarshowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FactoryRawCarshowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.factory_raw_carshow, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FactoryRawCarshowBinding bind(View rootView2) {
        int id = R.id.cbox_dcld;
        CheckBox cboxDcld2 = (CheckBox) rootView2.findViewById(R.id.cbox_dcld);
        if (cboxDcld2 != null) {
            id = R.id.rawCar_recycle;
            RecyclerView rawCarRecycle2 = (RecyclerView) rootView2.findViewById(R.id.rawCar_recycle);
            if (rawCarRecycle2 != null) {
                id = R.id.tv_rawCarSele;
                TextView tvRawCarSele2 = (TextView) rootView2.findViewById(R.id.tv_rawCarSele);
                if (tvRawCarSele2 != null) {
                    id = R.id.tvrawCarTite;
                    TextView tvrawCarTite2 = (TextView) rootView2.findViewById(R.id.tvrawCarTite);
                    if (tvrawCarTite2 != null) {
                        return new FactoryRawCarshowBinding((ScrollView) rootView2, cboxDcld2, rawCarRecycle2, tvRawCarSele2, tvrawCarTite2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
