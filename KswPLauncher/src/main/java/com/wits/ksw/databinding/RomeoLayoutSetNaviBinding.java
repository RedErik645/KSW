package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class RomeoLayoutSetNaviBinding implements ViewBinding {
    public final RecyclerView naviRecycle;
    public final RtlRadioButton rdbNaviv1;
    public final RtlRadioButton rdbNaviv2;
    public final RtlRadioButton rdbNaviv3;
    public final RtlRadioButton rdbNaviv4;
    public final RtlRadioButton rdbNaviv5;
    public final RtlRadioButton rdbNaviv6;
    public final RadioGroup rdgNaviv;
    public final RelativeLayout relateApp;
    public final RelativeLayout relateNaviv;
    private final ScrollView rootView;

    private RomeoLayoutSetNaviBinding(ScrollView rootView2, RecyclerView naviRecycle2, RtlRadioButton rdbNaviv12, RtlRadioButton rdbNaviv22, RtlRadioButton rdbNaviv32, RtlRadioButton rdbNaviv42, RtlRadioButton rdbNaviv52, RtlRadioButton rdbNaviv62, RadioGroup rdgNaviv2, RelativeLayout relateApp2, RelativeLayout relateNaviv2) {
        this.rootView = rootView2;
        this.naviRecycle = naviRecycle2;
        this.rdbNaviv1 = rdbNaviv12;
        this.rdbNaviv2 = rdbNaviv22;
        this.rdbNaviv3 = rdbNaviv32;
        this.rdbNaviv4 = rdbNaviv42;
        this.rdbNaviv5 = rdbNaviv52;
        this.rdbNaviv6 = rdbNaviv62;
        this.rdgNaviv = rdgNaviv2;
        this.relateApp = relateApp2;
        this.relateNaviv = relateNaviv2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static RomeoLayoutSetNaviBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RomeoLayoutSetNaviBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.romeo_layout_set_navi, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RomeoLayoutSetNaviBinding bind(View rootView2) {
        int id = R.id.navi_recycle;
        RecyclerView naviRecycle2 = (RecyclerView) rootView2.findViewById(R.id.navi_recycle);
        if (naviRecycle2 != null) {
            id = R.id.rdb_naviv1;
            RtlRadioButton rdbNaviv12 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_naviv1);
            if (rdbNaviv12 != null) {
                id = R.id.rdb_naviv2;
                RtlRadioButton rdbNaviv22 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_naviv2);
                if (rdbNaviv22 != null) {
                    id = R.id.rdb_naviv3;
                    RtlRadioButton rdbNaviv32 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_naviv3);
                    if (rdbNaviv32 != null) {
                        id = R.id.rdb_naviv4;
                        RtlRadioButton rdbNaviv42 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_naviv4);
                        if (rdbNaviv42 != null) {
                            id = R.id.rdb_naviv5;
                            RtlRadioButton rdbNaviv52 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_naviv5);
                            if (rdbNaviv52 != null) {
                                id = R.id.rdb_naviv6;
                                RtlRadioButton rdbNaviv62 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_naviv6);
                                if (rdbNaviv62 != null) {
                                    id = R.id.rdg_naviv;
                                    RadioGroup rdgNaviv2 = (RadioGroup) rootView2.findViewById(R.id.rdg_naviv);
                                    if (rdgNaviv2 != null) {
                                        id = R.id.relate_app;
                                        RelativeLayout relateApp2 = (RelativeLayout) rootView2.findViewById(R.id.relate_app);
                                        if (relateApp2 != null) {
                                            id = R.id.relate_naviv;
                                            RelativeLayout relateNaviv2 = (RelativeLayout) rootView2.findViewById(R.id.relate_naviv);
                                            if (relateNaviv2 != null) {
                                                return new RomeoLayoutSetNaviBinding((ScrollView) rootView2, naviRecycle2, rdbNaviv12, rdbNaviv22, rdbNaviv32, rdbNaviv42, rdbNaviv52, rdbNaviv62, rdgNaviv2, relateApp2, relateNaviv2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
