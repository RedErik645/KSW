package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class LexusLayoutSetTimeTwoBinding implements ViewBinding {
    public final RtlRadioButton rdbSync1;
    public final RtlRadioButton rdbSync2;
    public final RtlRadioButton rdbZhis1;
    public final RtlRadioButton rdbZhis2;
    public final RadioGroup rdgTimeSy;
    public final RadioGroup rdgTimeZhis;
    public final RelativeLayout relateTimeSync;
    public final RelativeLayout relateTimeZhis;
    private final ScrollView rootView;

    private LexusLayoutSetTimeTwoBinding(ScrollView rootView2, RtlRadioButton rdbSync12, RtlRadioButton rdbSync22, RtlRadioButton rdbZhis12, RtlRadioButton rdbZhis22, RadioGroup rdgTimeSy2, RadioGroup rdgTimeZhis2, RelativeLayout relateTimeSync2, RelativeLayout relateTimeZhis2) {
        this.rootView = rootView2;
        this.rdbSync1 = rdbSync12;
        this.rdbSync2 = rdbSync22;
        this.rdbZhis1 = rdbZhis12;
        this.rdbZhis2 = rdbZhis22;
        this.rdgTimeSy = rdgTimeSy2;
        this.rdgTimeZhis = rdgTimeZhis2;
        this.relateTimeSync = relateTimeSync2;
        this.relateTimeZhis = relateTimeZhis2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static LexusLayoutSetTimeTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LexusLayoutSetTimeTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.lexus_layout_set_time_two, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LexusLayoutSetTimeTwoBinding bind(View rootView2) {
        int id = R.id.rdb_sync1;
        RtlRadioButton rdbSync12 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_sync1);
        if (rdbSync12 != null) {
            id = R.id.rdb_sync2;
            RtlRadioButton rdbSync22 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_sync2);
            if (rdbSync22 != null) {
                id = R.id.rdb_zhis1;
                RtlRadioButton rdbZhis12 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_zhis1);
                if (rdbZhis12 != null) {
                    id = R.id.rdb_zhis2;
                    RtlRadioButton rdbZhis22 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_zhis2);
                    if (rdbZhis22 != null) {
                        id = R.id.rdg_timeSy;
                        RadioGroup rdgTimeSy2 = (RadioGroup) rootView2.findViewById(R.id.rdg_timeSy);
                        if (rdgTimeSy2 != null) {
                            id = R.id.rdg_timeZhis;
                            RadioGroup rdgTimeZhis2 = (RadioGroup) rootView2.findViewById(R.id.rdg_timeZhis);
                            if (rdgTimeZhis2 != null) {
                                id = R.id.relate_timeSync;
                                RelativeLayout relateTimeSync2 = (RelativeLayout) rootView2.findViewById(R.id.relate_timeSync);
                                if (relateTimeSync2 != null) {
                                    id = R.id.relate_timeZhis;
                                    RelativeLayout relateTimeZhis2 = (RelativeLayout) rootView2.findViewById(R.id.relate_timeZhis);
                                    if (relateTimeZhis2 != null) {
                                        return new LexusLayoutSetTimeTwoBinding((ScrollView) rootView2, rdbSync12, rdbSync22, rdbZhis12, rdbZhis22, rdgTimeSy2, rdgTimeZhis2, relateTimeSync2, relateTimeZhis2);
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
