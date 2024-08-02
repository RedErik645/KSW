package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class AlsLayoutSetVocModelBinding implements ViewBinding {
    public final RtlRadioButton rdbVocmd1;
    public final RtlRadioButton rdbVocmd2;
    public final RtlRadioButton rdbVocmd3;
    public final RtlRadioButton rdbVocmd4;
    public final RtlRadioButton rdbVocmd5;
    public final RtlRadioButton rdbVocmd6;
    public final RadioGroup rdgVocmd;
    private final ScrollView rootView;

    private AlsLayoutSetVocModelBinding(ScrollView rootView2, RtlRadioButton rdbVocmd12, RtlRadioButton rdbVocmd22, RtlRadioButton rdbVocmd32, RtlRadioButton rdbVocmd42, RtlRadioButton rdbVocmd52, RtlRadioButton rdbVocmd62, RadioGroup rdgVocmd2) {
        this.rootView = rootView2;
        this.rdbVocmd1 = rdbVocmd12;
        this.rdbVocmd2 = rdbVocmd22;
        this.rdbVocmd3 = rdbVocmd32;
        this.rdbVocmd4 = rdbVocmd42;
        this.rdbVocmd5 = rdbVocmd52;
        this.rdbVocmd6 = rdbVocmd62;
        this.rdgVocmd = rdgVocmd2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static AlsLayoutSetVocModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlsLayoutSetVocModelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.als_layout_set_voc_model, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AlsLayoutSetVocModelBinding bind(View rootView2) {
        int id = R.id.rdb_vocmd1;
        RtlRadioButton rdbVocmd12 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd1);
        if (rdbVocmd12 != null) {
            id = R.id.rdb_vocmd2;
            RtlRadioButton rdbVocmd22 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd2);
            if (rdbVocmd22 != null) {
                id = R.id.rdb_vocmd3;
                RtlRadioButton rdbVocmd32 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd3);
                if (rdbVocmd32 != null) {
                    id = R.id.rdb_vocmd4;
                    RtlRadioButton rdbVocmd42 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd4);
                    if (rdbVocmd42 != null) {
                        id = R.id.rdb_vocmd5;
                        RtlRadioButton rdbVocmd52 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd5);
                        if (rdbVocmd52 != null) {
                            id = R.id.rdb_vocmd6;
                            RtlRadioButton rdbVocmd62 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd6);
                            if (rdbVocmd62 != null) {
                                id = R.id.rdg_vocmd;
                                RadioGroup rdgVocmd2 = (RadioGroup) rootView2.findViewById(R.id.rdg_vocmd);
                                if (rdgVocmd2 != null) {
                                    return new AlsLayoutSetVocModelBinding((ScrollView) rootView2, rdbVocmd12, rdbVocmd22, rdbVocmd32, rdbVocmd42, rdbVocmd52, rdbVocmd62, rdgVocmd2);
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
