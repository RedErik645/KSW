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
import com.wits.ksw.settings.utlis_view.CustomRadioButton;

public final class AlsId7UiLayoutSetNaviTwoBinding implements ViewBinding {
    public final RecyclerView naviRecycle;
    public final CustomRadioButton rdbNaviv1;
    public final CustomRadioButton rdbNaviv2;
    public final CustomRadioButton rdbNaviv3;
    public final CustomRadioButton rdbNaviv4;
    public final CustomRadioButton rdbNaviv5;
    public final CustomRadioButton rdbNaviv6;
    public final RadioGroup rdgNaviv;
    public final RelativeLayout relateApp;
    public final RelativeLayout relateNaviv;
    private final ScrollView rootView;

    private AlsId7UiLayoutSetNaviTwoBinding(ScrollView rootView2, RecyclerView naviRecycle2, CustomRadioButton rdbNaviv12, CustomRadioButton rdbNaviv22, CustomRadioButton rdbNaviv32, CustomRadioButton rdbNaviv42, CustomRadioButton rdbNaviv52, CustomRadioButton rdbNaviv62, RadioGroup rdgNaviv2, RelativeLayout relateApp2, RelativeLayout relateNaviv2) {
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

    public static AlsId7UiLayoutSetNaviTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlsId7UiLayoutSetNaviTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.als_id7_ui_layout_set_navi_two, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AlsId7UiLayoutSetNaviTwoBinding bind(View rootView2) {
        int id = R.id.navi_recycle;
        RecyclerView naviRecycle2 = (RecyclerView) rootView2.findViewById(R.id.navi_recycle);
        if (naviRecycle2 != null) {
            id = R.id.rdb_naviv1;
            CustomRadioButton rdbNaviv12 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_naviv1);
            if (rdbNaviv12 != null) {
                id = R.id.rdb_naviv2;
                CustomRadioButton rdbNaviv22 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_naviv2);
                if (rdbNaviv22 != null) {
                    id = R.id.rdb_naviv3;
                    CustomRadioButton rdbNaviv32 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_naviv3);
                    if (rdbNaviv32 != null) {
                        id = R.id.rdb_naviv4;
                        CustomRadioButton rdbNaviv42 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_naviv4);
                        if (rdbNaviv42 != null) {
                            id = R.id.rdb_naviv5;
                            CustomRadioButton rdbNaviv52 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_naviv5);
                            if (rdbNaviv52 != null) {
                                id = R.id.rdb_naviv6;
                                CustomRadioButton rdbNaviv62 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_naviv6);
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
                                                return new AlsId7UiLayoutSetNaviTwoBinding((ScrollView) rootView2, naviRecycle2, rdbNaviv12, rdbNaviv22, rdbNaviv32, rdbNaviv42, rdbNaviv52, rdbNaviv62, rdgNaviv2, relateApp2, relateNaviv2);
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
