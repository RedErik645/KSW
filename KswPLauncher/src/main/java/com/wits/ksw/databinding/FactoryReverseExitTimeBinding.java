package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class FactoryReverseExitTimeBinding implements ViewBinding {
    public final RtlRadioButton bootRecordModeCustom;
    public final RtlRadioButton reverseExitTimeAgreement;
    public final RadioGroup reverseExitTimeRadiogroup;
    private final LinearLayout rootView;
    public final SeekBar seekExit;
    public final TextView tvExit;
    public final TextView tvExitValue;

    private FactoryReverseExitTimeBinding(LinearLayout rootView2, RtlRadioButton bootRecordModeCustom2, RtlRadioButton reverseExitTimeAgreement2, RadioGroup reverseExitTimeRadiogroup2, SeekBar seekExit2, TextView tvExit2, TextView tvExitValue2) {
        this.rootView = rootView2;
        this.bootRecordModeCustom = bootRecordModeCustom2;
        this.reverseExitTimeAgreement = reverseExitTimeAgreement2;
        this.reverseExitTimeRadiogroup = reverseExitTimeRadiogroup2;
        this.seekExit = seekExit2;
        this.tvExit = tvExit2;
        this.tvExitValue = tvExitValue2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FactoryReverseExitTimeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FactoryReverseExitTimeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.factory_reverse_exit_time, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FactoryReverseExitTimeBinding bind(View rootView2) {
        int id = R.id.boot_record_mode_custom;
        RtlRadioButton bootRecordModeCustom2 = (RtlRadioButton) rootView2.findViewById(R.id.boot_record_mode_custom);
        if (bootRecordModeCustom2 != null) {
            id = R.id.reverse_exit_time_agreement;
            RtlRadioButton reverseExitTimeAgreement2 = (RtlRadioButton) rootView2.findViewById(R.id.reverse_exit_time_agreement);
            if (reverseExitTimeAgreement2 != null) {
                id = R.id.reverse_exit_time_radiogroup;
                RadioGroup reverseExitTimeRadiogroup2 = (RadioGroup) rootView2.findViewById(R.id.reverse_exit_time_radiogroup);
                if (reverseExitTimeRadiogroup2 != null) {
                    id = R.id.seek_exit;
                    SeekBar seekExit2 = (SeekBar) rootView2.findViewById(R.id.seek_exit);
                    if (seekExit2 != null) {
                        id = R.id.tv_exit;
                        TextView tvExit2 = (TextView) rootView2.findViewById(R.id.tv_exit);
                        if (tvExit2 != null) {
                            id = R.id.tv_exit_value;
                            TextView tvExitValue2 = (TextView) rootView2.findViewById(R.id.tv_exit_value);
                            if (tvExitValue2 != null) {
                                return new FactoryReverseExitTimeBinding((LinearLayout) rootView2, bootRecordModeCustom2, reverseExitTimeAgreement2, reverseExitTimeRadiogroup2, seekExit2, tvExit2, tvExitValue2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
