package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class LayoutId6ShowTimeBinding implements ViewBinding {
    public final RtlRadioButton rdbSync1;
    public final RtlRadioButton rdbSync2;
    public final RtlRadioButton rdbZhis1;
    public final RtlRadioButton rdbZhis2;
    public final RadioGroup rdgTimeSy;
    public final RadioGroup rdgTimeZhis;
    private final RelativeLayout rootView;
    public final TextView tvTimeSync;
    public final TextView tvTimeZhis;

    private LayoutId6ShowTimeBinding(RelativeLayout rootView2, RtlRadioButton rdbSync12, RtlRadioButton rdbSync22, RtlRadioButton rdbZhis12, RtlRadioButton rdbZhis22, RadioGroup rdgTimeSy2, RadioGroup rdgTimeZhis2, TextView tvTimeSync2, TextView tvTimeZhis2) {
        this.rootView = rootView2;
        this.rdbSync1 = rdbSync12;
        this.rdbSync2 = rdbSync22;
        this.rdbZhis1 = rdbZhis12;
        this.rdbZhis2 = rdbZhis22;
        this.rdgTimeSy = rdgTimeSy2;
        this.rdgTimeZhis = rdgTimeZhis2;
        this.tvTimeSync = tvTimeSync2;
        this.tvTimeZhis = tvTimeZhis2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutId6ShowTimeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6ShowTimeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_show_time, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6ShowTimeBinding bind(View rootView2) {
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
                                id = R.id.tv_timeSync;
                                TextView tvTimeSync2 = (TextView) rootView2.findViewById(R.id.tv_timeSync);
                                if (tvTimeSync2 != null) {
                                    id = R.id.tv_timeZhis;
                                    TextView tvTimeZhis2 = (TextView) rootView2.findViewById(R.id.tv_timeZhis);
                                    if (tvTimeZhis2 != null) {
                                        return new LayoutId6ShowTimeBinding((RelativeLayout) rootView2, rdbSync12, rdbSync22, rdbZhis12, rdbZhis22, rdgTimeSy2, rdgTimeZhis2, tvTimeSync2, tvTimeZhis2);
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
