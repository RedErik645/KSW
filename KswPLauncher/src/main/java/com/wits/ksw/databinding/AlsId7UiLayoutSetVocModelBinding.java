package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.CustomRadioButton;

public final class AlsId7UiLayoutSetVocModelBinding implements ViewBinding {
    public final CustomRadioButton rdbVocmd1;
    public final CustomRadioButton rdbVocmd2;
    public final CustomRadioButton rdbVocmd3;
    public final CustomRadioButton rdbVocmd4;
    public final CustomRadioButton rdbVocmd5;
    public final CustomRadioButton rdbVocmd6;
    public final RadioGroup rdgVocmd;
    private final ScrollView rootView;

    private AlsId7UiLayoutSetVocModelBinding(ScrollView rootView2, CustomRadioButton rdbVocmd12, CustomRadioButton rdbVocmd22, CustomRadioButton rdbVocmd32, CustomRadioButton rdbVocmd42, CustomRadioButton rdbVocmd52, CustomRadioButton rdbVocmd62, RadioGroup rdgVocmd2) {
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

    public static AlsId7UiLayoutSetVocModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlsId7UiLayoutSetVocModelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.als_id7_ui_layout_set_voc_model, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AlsId7UiLayoutSetVocModelBinding bind(View rootView2) {
        int id = R.id.rdb_vocmd1;
        CustomRadioButton rdbVocmd12 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_vocmd1);
        if (rdbVocmd12 != null) {
            id = R.id.rdb_vocmd2;
            CustomRadioButton rdbVocmd22 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_vocmd2);
            if (rdbVocmd22 != null) {
                id = R.id.rdb_vocmd3;
                CustomRadioButton rdbVocmd32 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_vocmd3);
                if (rdbVocmd32 != null) {
                    id = R.id.rdb_vocmd4;
                    CustomRadioButton rdbVocmd42 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_vocmd4);
                    if (rdbVocmd42 != null) {
                        id = R.id.rdb_vocmd5;
                        CustomRadioButton rdbVocmd52 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_vocmd5);
                        if (rdbVocmd52 != null) {
                            id = R.id.rdb_vocmd6;
                            CustomRadioButton rdbVocmd62 = (CustomRadioButton) rootView2.findViewById(R.id.rdb_vocmd6);
                            if (rdbVocmd62 != null) {
                                id = R.id.rdg_vocmd;
                                RadioGroup rdgVocmd2 = (RadioGroup) rootView2.findViewById(R.id.rdg_vocmd);
                                if (rdgVocmd2 != null) {
                                    return new AlsId7UiLayoutSetVocModelBinding((ScrollView) rootView2, rdbVocmd12, rdbVocmd22, rdbVocmd32, rdbVocmd42, rdbVocmd52, rdbVocmd62, rdgVocmd2);
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
