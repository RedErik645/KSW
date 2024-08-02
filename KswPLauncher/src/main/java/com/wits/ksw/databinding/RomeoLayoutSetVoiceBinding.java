package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class RomeoLayoutSetVoiceBinding implements ViewBinding {
    public final LinearLayout romeoVoiceLl;
    private final ScrollView rootView;
    public final TextView tvEq;
    public final TextView tvHouzvoc;
    public final TextView tvYuancvoc;

    private RomeoLayoutSetVoiceBinding(ScrollView rootView2, LinearLayout romeoVoiceLl2, TextView tvEq2, TextView tvHouzvoc2, TextView tvYuancvoc2) {
        this.rootView = rootView2;
        this.romeoVoiceLl = romeoVoiceLl2;
        this.tvEq = tvEq2;
        this.tvHouzvoc = tvHouzvoc2;
        this.tvYuancvoc = tvYuancvoc2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static RomeoLayoutSetVoiceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RomeoLayoutSetVoiceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.romeo_layout_set_voice, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RomeoLayoutSetVoiceBinding bind(View rootView2) {
        int id = R.id.romeo_voice_ll;
        LinearLayout romeoVoiceLl2 = (LinearLayout) rootView2.findViewById(R.id.romeo_voice_ll);
        if (romeoVoiceLl2 != null) {
            id = R.id.tv_eq;
            TextView tvEq2 = (TextView) rootView2.findViewById(R.id.tv_eq);
            if (tvEq2 != null) {
                id = R.id.tv_houzvoc;
                TextView tvHouzvoc2 = (TextView) rootView2.findViewById(R.id.tv_houzvoc);
                if (tvHouzvoc2 != null) {
                    id = R.id.tv_yuancvoc;
                    TextView tvYuancvoc2 = (TextView) rootView2.findViewById(R.id.tv_yuancvoc);
                    if (tvYuancvoc2 != null) {
                        return new RomeoLayoutSetVoiceBinding((ScrollView) rootView2, romeoVoiceLl2, tvEq2, tvHouzvoc2, tvYuancvoc2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
