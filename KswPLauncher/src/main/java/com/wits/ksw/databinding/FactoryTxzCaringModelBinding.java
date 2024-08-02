package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FactoryTxzCaringModelBinding implements ViewBinding {
    public final TextView oilFinalTxt;
    private final ConstraintLayout rootView;
    public final SeekBar seekOil;
    public final SeekBar seekSpeed;
    public final SeekBar seekTemp;
    public final TextView speedFinalTxt;
    public final TextView tempFinalTxt;
    public final TextView tvOil;
    public final TextView tvOilValue;
    public final TextView tvSpeed;
    public final TextView tvSpeedValue;
    public final TextView tvTemp;
    public final TextView tvTempValue;

    private FactoryTxzCaringModelBinding(ConstraintLayout rootView2, TextView oilFinalTxt2, SeekBar seekOil2, SeekBar seekSpeed2, SeekBar seekTemp2, TextView speedFinalTxt2, TextView tempFinalTxt2, TextView tvOil2, TextView tvOilValue2, TextView tvSpeed2, TextView tvSpeedValue2, TextView tvTemp2, TextView tvTempValue2) {
        this.rootView = rootView2;
        this.oilFinalTxt = oilFinalTxt2;
        this.seekOil = seekOil2;
        this.seekSpeed = seekSpeed2;
        this.seekTemp = seekTemp2;
        this.speedFinalTxt = speedFinalTxt2;
        this.tempFinalTxt = tempFinalTxt2;
        this.tvOil = tvOil2;
        this.tvOilValue = tvOilValue2;
        this.tvSpeed = tvSpeed2;
        this.tvSpeedValue = tvSpeedValue2;
        this.tvTemp = tvTemp2;
        this.tvTempValue = tvTempValue2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FactoryTxzCaringModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FactoryTxzCaringModelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.factory_txz_caring_model, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FactoryTxzCaringModelBinding bind(View rootView2) {
        int id = R.id.oil_final_txt;
        TextView oilFinalTxt2 = (TextView) rootView2.findViewById(R.id.oil_final_txt);
        if (oilFinalTxt2 != null) {
            id = R.id.seek_oil;
            SeekBar seekOil2 = (SeekBar) rootView2.findViewById(R.id.seek_oil);
            if (seekOil2 != null) {
                id = R.id.seek_speed;
                SeekBar seekSpeed2 = (SeekBar) rootView2.findViewById(R.id.seek_speed);
                if (seekSpeed2 != null) {
                    id = R.id.seek_temp;
                    SeekBar seekTemp2 = (SeekBar) rootView2.findViewById(R.id.seek_temp);
                    if (seekTemp2 != null) {
                        id = R.id.speed_final_txt;
                        TextView speedFinalTxt2 = (TextView) rootView2.findViewById(R.id.speed_final_txt);
                        if (speedFinalTxt2 != null) {
                            id = R.id.temp_final_txt;
                            TextView tempFinalTxt2 = (TextView) rootView2.findViewById(R.id.temp_final_txt);
                            if (tempFinalTxt2 != null) {
                                id = R.id.tv_oil;
                                TextView tvOil2 = (TextView) rootView2.findViewById(R.id.tv_oil);
                                if (tvOil2 != null) {
                                    id = R.id.tv_oil_value;
                                    TextView tvOilValue2 = (TextView) rootView2.findViewById(R.id.tv_oil_value);
                                    if (tvOilValue2 != null) {
                                        id = R.id.tv_speed;
                                        TextView tvSpeed2 = (TextView) rootView2.findViewById(R.id.tv_speed);
                                        if (tvSpeed2 != null) {
                                            id = R.id.tv_speed_value;
                                            TextView tvSpeedValue2 = (TextView) rootView2.findViewById(R.id.tv_speed_value);
                                            if (tvSpeedValue2 != null) {
                                                id = R.id.tv_temp;
                                                TextView tvTemp2 = (TextView) rootView2.findViewById(R.id.tv_temp);
                                                if (tvTemp2 != null) {
                                                    id = R.id.tv_temp_value;
                                                    TextView tvTempValue2 = (TextView) rootView2.findViewById(R.id.tv_temp_value);
                                                    if (tvTempValue2 != null) {
                                                        return new FactoryTxzCaringModelBinding((ConstraintLayout) rootView2, oilFinalTxt2, seekOil2, seekSpeed2, seekTemp2, speedFinalTxt2, tempFinalTxt2, tvOil2, tvOilValue2, tvSpeed2, tvSpeedValue2, tvTemp2, tvTempValue2);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
