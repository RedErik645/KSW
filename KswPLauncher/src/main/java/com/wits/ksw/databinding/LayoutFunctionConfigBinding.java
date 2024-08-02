package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlCheckBox;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class LayoutFunctionConfigBinding implements ViewBinding {
    public final RtlRadioButton bootRecordModeRadio1;
    public final RtlRadioButton bootRecordModeRadio2;
    public final RtlRadioButton bootRecordModeRadio3;
    public final RadioGroup bootRecordModeRadiogroup;
    public final RtlCheckBox cboxApk360;
    public final RtlCheckBox cboxBt;
    public final RtlCheckBox cboxEqApp;
    public final RtlCheckBox cboxFrontView;
    public final RtlCheckBox cboxFunction1;
    public final RtlCheckBox cboxFunction3;
    public final RtlCheckBox cboxFunction4;
    public final RtlCheckBox cboxFunction5;
    public final RtlCheckBox cboxFunction6;
    public final RtlCheckBox cboxFunction7;
    public final RtlCheckBox cboxFunctionFcam;
    public final RtlCheckBox cboxFunctionGoogleOff;
    public final RtlCheckBox cboxGlobalWeather;
    public final RtlCheckBox cboxHicar;
    public final RtlCheckBox cboxSreencast;
    public final RtlCheckBox cboxSysXcjz;
    public final RtlCheckBox cboxTouchSend;
    public final RtlRadioButton rdbFunbt1;
    public final RtlRadioButton rdbFunbt2;
    public final RtlRadioButton rdbFunxcjl1;
    public final RtlRadioButton rdbFunxcjl2;
    public final RtlRadioButton rdbFunxcjl3;
    public final RadioGroup rdg360sx;
    public final RtlRadioButton rdg360sx1;
    public final RtlRadioButton rdg360sx2;
    public final RadioGroup rdgAhd;
    public final RtlRadioButton rdgAhd0;
    public final RtlRadioButton rdgAhd1;
    public final RtlRadioButton rdgAhd2;
    public final RtlRadioButton rdgAhd3;
    public final RtlRadioButton rdgAhd4;
    public final RtlRadioButton rdgAhd5;
    public final RtlRadioButton rdgAhd6;
    public final RtlRadioButton rdgAhd7;
    public final RadioGroup rdgBgkz;
    public final RtlRadioButton rdgBgkz1;
    public final RtlRadioButton rdgBgkz2;
    public final RadioGroup rdgDawei;
    public final RtlRadioButton rdgDawei1;
    public final RtlRadioButton rdgDawei2;
    public final RadioGroup rdgFunbt;
    public final RadioGroup rdgFungf;
    public final RtlRadioButton rdgFungf1;
    public final RtlRadioButton rdgFungf2;
    public final RadioGroup rdgFunxcjl;
    private final ScrollView rootView;
    public final TextView tvSeleAPk;
    public final TextView tvSelePlayAPk;

    private LayoutFunctionConfigBinding(ScrollView rootView2, RtlRadioButton bootRecordModeRadio12, RtlRadioButton bootRecordModeRadio22, RtlRadioButton bootRecordModeRadio32, RadioGroup bootRecordModeRadiogroup2, RtlCheckBox cboxApk3602, RtlCheckBox cboxBt2, RtlCheckBox cboxEqApp2, RtlCheckBox cboxFrontView2, RtlCheckBox cboxFunction12, RtlCheckBox cboxFunction32, RtlCheckBox cboxFunction42, RtlCheckBox cboxFunction52, RtlCheckBox cboxFunction62, RtlCheckBox cboxFunction72, RtlCheckBox cboxFunctionFcam2, RtlCheckBox cboxFunctionGoogleOff2, RtlCheckBox cboxGlobalWeather2, RtlCheckBox cboxHicar2, RtlCheckBox cboxSreencast2, RtlCheckBox cboxSysXcjz2, RtlCheckBox cboxTouchSend2, RtlRadioButton rdbFunbt12, RtlRadioButton rdbFunbt22, RtlRadioButton rdbFunxcjl12, RtlRadioButton rdbFunxcjl22, RtlRadioButton rdbFunxcjl32, RadioGroup rdg360sx3, RtlRadioButton rdg360sx12, RtlRadioButton rdg360sx22, RadioGroup rdgAhd8, RtlRadioButton rdgAhd02, RtlRadioButton rdgAhd12, RtlRadioButton rdgAhd22, RtlRadioButton rdgAhd32, RtlRadioButton rdgAhd42, RtlRadioButton rdgAhd52, RtlRadioButton rdgAhd62, RtlRadioButton rdgAhd72, RadioGroup rdgBgkz3, RtlRadioButton rdgBgkz12, RtlRadioButton rdgBgkz22, RadioGroup rdgDawei3, RtlRadioButton rdgDawei12, RtlRadioButton rdgDawei22, RadioGroup rdgFunbt2, RadioGroup rdgFungf3, RtlRadioButton rdgFungf12, RtlRadioButton rdgFungf22, RadioGroup rdgFunxcjl2, TextView tvSeleAPk2, TextView tvSelePlayAPk2) {
        this.rootView = rootView2;
        this.bootRecordModeRadio1 = bootRecordModeRadio12;
        this.bootRecordModeRadio2 = bootRecordModeRadio22;
        this.bootRecordModeRadio3 = bootRecordModeRadio32;
        this.bootRecordModeRadiogroup = bootRecordModeRadiogroup2;
        this.cboxApk360 = cboxApk3602;
        this.cboxBt = cboxBt2;
        this.cboxEqApp = cboxEqApp2;
        this.cboxFrontView = cboxFrontView2;
        this.cboxFunction1 = cboxFunction12;
        this.cboxFunction3 = cboxFunction32;
        this.cboxFunction4 = cboxFunction42;
        this.cboxFunction5 = cboxFunction52;
        this.cboxFunction6 = cboxFunction62;
        this.cboxFunction7 = cboxFunction72;
        this.cboxFunctionFcam = cboxFunctionFcam2;
        this.cboxFunctionGoogleOff = cboxFunctionGoogleOff2;
        this.cboxGlobalWeather = cboxGlobalWeather2;
        this.cboxHicar = cboxHicar2;
        this.cboxSreencast = cboxSreencast2;
        this.cboxSysXcjz = cboxSysXcjz2;
        this.cboxTouchSend = cboxTouchSend2;
        this.rdbFunbt1 = rdbFunbt12;
        this.rdbFunbt2 = rdbFunbt22;
        this.rdbFunxcjl1 = rdbFunxcjl12;
        this.rdbFunxcjl2 = rdbFunxcjl22;
        this.rdbFunxcjl3 = rdbFunxcjl32;
        this.rdg360sx = rdg360sx3;
        this.rdg360sx1 = rdg360sx12;
        this.rdg360sx2 = rdg360sx22;
        this.rdgAhd = rdgAhd8;
        this.rdgAhd0 = rdgAhd02;
        this.rdgAhd1 = rdgAhd12;
        this.rdgAhd2 = rdgAhd22;
        this.rdgAhd3 = rdgAhd32;
        this.rdgAhd4 = rdgAhd42;
        this.rdgAhd5 = rdgAhd52;
        this.rdgAhd6 = rdgAhd62;
        this.rdgAhd7 = rdgAhd72;
        this.rdgBgkz = rdgBgkz3;
        this.rdgBgkz1 = rdgBgkz12;
        this.rdgBgkz2 = rdgBgkz22;
        this.rdgDawei = rdgDawei3;
        this.rdgDawei1 = rdgDawei12;
        this.rdgDawei2 = rdgDawei22;
        this.rdgFunbt = rdgFunbt2;
        this.rdgFungf = rdgFungf3;
        this.rdgFungf1 = rdgFungf12;
        this.rdgFungf2 = rdgFungf22;
        this.rdgFunxcjl = rdgFunxcjl2;
        this.tvSeleAPk = tvSeleAPk2;
        this.tvSelePlayAPk = tvSelePlayAPk2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static LayoutFunctionConfigBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutFunctionConfigBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_function_config, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutFunctionConfigBinding bind(View rootView2) {
        int id = R.id.boot_record_mode_radio1;
        RtlRadioButton bootRecordModeRadio12 = (RtlRadioButton) rootView2.findViewById(R.id.boot_record_mode_radio1);
        if (bootRecordModeRadio12 != null) {
            id = R.id.boot_record_mode_radio2;
            RtlRadioButton bootRecordModeRadio22 = (RtlRadioButton) rootView2.findViewById(R.id.boot_record_mode_radio2);
            if (bootRecordModeRadio22 != null) {
                id = R.id.boot_record_mode_radio3;
                RtlRadioButton bootRecordModeRadio32 = (RtlRadioButton) rootView2.findViewById(R.id.boot_record_mode_radio3);
                if (bootRecordModeRadio32 != null) {
                    id = R.id.boot_record_mode_radiogroup;
                    RadioGroup bootRecordModeRadiogroup2 = (RadioGroup) rootView2.findViewById(R.id.boot_record_mode_radiogroup);
                    if (bootRecordModeRadiogroup2 != null) {
                        id = R.id.cbox_apk360;
                        RtlCheckBox cboxApk3602 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_apk360);
                        if (cboxApk3602 != null) {
                            id = R.id.cbox_bt;
                            RtlCheckBox cboxBt2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_bt);
                            if (cboxBt2 != null) {
                                id = R.id.cbox_eq_app;
                                RtlCheckBox cboxEqApp2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_eq_app);
                                if (cboxEqApp2 != null) {
                                    id = R.id.cbox_front_view;
                                    RtlCheckBox cboxFrontView2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_front_view);
                                    if (cboxFrontView2 != null) {
                                        id = R.id.cbox_function1;
                                        RtlCheckBox cboxFunction12 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_function1);
                                        if (cboxFunction12 != null) {
                                            id = R.id.cbox_function3;
                                            RtlCheckBox cboxFunction32 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_function3);
                                            if (cboxFunction32 != null) {
                                                id = R.id.cbox_function4;
                                                RtlCheckBox cboxFunction42 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_function4);
                                                if (cboxFunction42 != null) {
                                                    id = R.id.cbox_function5;
                                                    RtlCheckBox cboxFunction52 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_function5);
                                                    if (cboxFunction52 != null) {
                                                        id = R.id.cbox_function6;
                                                        RtlCheckBox cboxFunction62 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_function6);
                                                        if (cboxFunction62 != null) {
                                                            id = R.id.cbox_function7;
                                                            RtlCheckBox cboxFunction72 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_function7);
                                                            if (cboxFunction72 != null) {
                                                                id = R.id.cbox_function_fcam;
                                                                RtlCheckBox cboxFunctionFcam2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_function_fcam);
                                                                if (cboxFunctionFcam2 != null) {
                                                                    id = R.id.cbox_function_google_off;
                                                                    RtlCheckBox cboxFunctionGoogleOff2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_function_google_off);
                                                                    if (cboxFunctionGoogleOff2 != null) {
                                                                        id = R.id.cbox_global_weather;
                                                                        RtlCheckBox cboxGlobalWeather2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_global_weather);
                                                                        if (cboxGlobalWeather2 != null) {
                                                                            id = R.id.cbox_hicar;
                                                                            RtlCheckBox cboxHicar2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_hicar);
                                                                            if (cboxHicar2 != null) {
                                                                                id = R.id.cbox_sreencast;
                                                                                RtlCheckBox cboxSreencast2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_sreencast);
                                                                                if (cboxSreencast2 != null) {
                                                                                    id = R.id.cbox_sysXcjz;
                                                                                    RtlCheckBox cboxSysXcjz2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_sysXcjz);
                                                                                    if (cboxSysXcjz2 != null) {
                                                                                        id = R.id.cbox_touch_send;
                                                                                        RtlCheckBox cboxTouchSend2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_touch_send);
                                                                                        if (cboxTouchSend2 != null) {
                                                                                            id = R.id.rdb_funbt1;
                                                                                            RtlRadioButton rdbFunbt12 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_funbt1);
                                                                                            if (rdbFunbt12 != null) {
                                                                                                id = R.id.rdb_funbt2;
                                                                                                RtlRadioButton rdbFunbt22 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_funbt2);
                                                                                                if (rdbFunbt22 != null) {
                                                                                                    id = R.id.rdb_funxcjl1;
                                                                                                    RtlRadioButton rdbFunxcjl12 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_funxcjl1);
                                                                                                    if (rdbFunxcjl12 != null) {
                                                                                                        id = R.id.rdb_funxcjl2;
                                                                                                        RtlRadioButton rdbFunxcjl22 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_funxcjl2);
                                                                                                        if (rdbFunxcjl22 != null) {
                                                                                                            id = R.id.rdb_funxcjl3;
                                                                                                            RtlRadioButton rdbFunxcjl32 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_funxcjl3);
                                                                                                            if (rdbFunxcjl32 != null) {
                                                                                                                id = R.id.rdg_360sx;
                                                                                                                RadioGroup rdg360sx3 = (RadioGroup) rootView2.findViewById(R.id.rdg_360sx);
                                                                                                                if (rdg360sx3 != null) {
                                                                                                                    id = R.id.rdg_360sx1;
                                                                                                                    RtlRadioButton rdg360sx12 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_360sx1);
                                                                                                                    if (rdg360sx12 != null) {
                                                                                                                        id = R.id.rdg_360sx2;
                                                                                                                        RtlRadioButton rdg360sx22 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_360sx2);
                                                                                                                        if (rdg360sx22 != null) {
                                                                                                                            id = R.id.rdg_Ahd;
                                                                                                                            RadioGroup rdgAhd8 = (RadioGroup) rootView2.findViewById(R.id.rdg_Ahd);
                                                                                                                            if (rdgAhd8 != null) {
                                                                                                                                id = R.id.rdg_ahd0;
                                                                                                                                RtlRadioButton rdgAhd02 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_ahd0);
                                                                                                                                if (rdgAhd02 != null) {
                                                                                                                                    id = R.id.rdg_ahd1;
                                                                                                                                    RtlRadioButton rdgAhd12 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_ahd1);
                                                                                                                                    if (rdgAhd12 != null) {
                                                                                                                                        id = R.id.rdg_ahd2;
                                                                                                                                        RtlRadioButton rdgAhd22 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_ahd2);
                                                                                                                                        if (rdgAhd22 != null) {
                                                                                                                                            id = R.id.rdg_ahd3;
                                                                                                                                            RtlRadioButton rdgAhd32 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_ahd3);
                                                                                                                                            if (rdgAhd32 != null) {
                                                                                                                                                id = R.id.rdg_ahd4;
                                                                                                                                                RtlRadioButton rdgAhd42 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_ahd4);
                                                                                                                                                if (rdgAhd42 != null) {
                                                                                                                                                    id = R.id.rdg_ahd5;
                                                                                                                                                    RtlRadioButton rdgAhd52 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_ahd5);
                                                                                                                                                    if (rdgAhd52 != null) {
                                                                                                                                                        id = R.id.rdg_ahd6;
                                                                                                                                                        RtlRadioButton rdgAhd62 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_ahd6);
                                                                                                                                                        if (rdgAhd62 != null) {
                                                                                                                                                            id = R.id.rdg_ahd7;
                                                                                                                                                            RtlRadioButton rdgAhd72 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_ahd7);
                                                                                                                                                            if (rdgAhd72 != null) {
                                                                                                                                                                id = R.id.rdg_bgkz;
                                                                                                                                                                RadioGroup rdgBgkz3 = (RadioGroup) rootView2.findViewById(R.id.rdg_bgkz);
                                                                                                                                                                if (rdgBgkz3 != null) {
                                                                                                                                                                    id = R.id.rdg_bgkz1;
                                                                                                                                                                    RtlRadioButton rdgBgkz12 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_bgkz1);
                                                                                                                                                                    if (rdgBgkz12 != null) {
                                                                                                                                                                        id = R.id.rdg_bgkz2;
                                                                                                                                                                        RtlRadioButton rdgBgkz22 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_bgkz2);
                                                                                                                                                                        if (rdgBgkz22 != null) {
                                                                                                                                                                            id = R.id.rdg_dawei;
                                                                                                                                                                            RadioGroup rdgDawei3 = (RadioGroup) rootView2.findViewById(R.id.rdg_dawei);
                                                                                                                                                                            if (rdgDawei3 != null) {
                                                                                                                                                                                id = R.id.rdg_dawei1;
                                                                                                                                                                                RtlRadioButton rdgDawei12 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_dawei1);
                                                                                                                                                                                if (rdgDawei12 != null) {
                                                                                                                                                                                    id = R.id.rdg_dawei2;
                                                                                                                                                                                    RtlRadioButton rdgDawei22 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_dawei2);
                                                                                                                                                                                    if (rdgDawei22 != null) {
                                                                                                                                                                                        id = R.id.rdg_funbt;
                                                                                                                                                                                        RadioGroup rdgFunbt2 = (RadioGroup) rootView2.findViewById(R.id.rdg_funbt);
                                                                                                                                                                                        if (rdgFunbt2 != null) {
                                                                                                                                                                                            id = R.id.rdg_fungf;
                                                                                                                                                                                            RadioGroup rdgFungf3 = (RadioGroup) rootView2.findViewById(R.id.rdg_fungf);
                                                                                                                                                                                            if (rdgFungf3 != null) {
                                                                                                                                                                                                id = R.id.rdg_fungf1;
                                                                                                                                                                                                RtlRadioButton rdgFungf12 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_fungf1);
                                                                                                                                                                                                if (rdgFungf12 != null) {
                                                                                                                                                                                                    id = R.id.rdg_fungf2;
                                                                                                                                                                                                    RtlRadioButton rdgFungf22 = (RtlRadioButton) rootView2.findViewById(R.id.rdg_fungf2);
                                                                                                                                                                                                    if (rdgFungf22 != null) {
                                                                                                                                                                                                        id = R.id.rdg_funxcjl;
                                                                                                                                                                                                        RadioGroup rdgFunxcjl2 = (RadioGroup) rootView2.findViewById(R.id.rdg_funxcjl);
                                                                                                                                                                                                        if (rdgFunxcjl2 != null) {
                                                                                                                                                                                                            id = R.id.tv_seleAPk;
                                                                                                                                                                                                            TextView tvSeleAPk2 = (TextView) rootView2.findViewById(R.id.tv_seleAPk);
                                                                                                                                                                                                            if (tvSeleAPk2 != null) {
                                                                                                                                                                                                                id = R.id.tv_selePlayAPk;
                                                                                                                                                                                                                TextView tvSelePlayAPk2 = (TextView) rootView2.findViewById(R.id.tv_selePlayAPk);
                                                                                                                                                                                                                if (tvSelePlayAPk2 != null) {
                                                                                                                                                                                                                    return new LayoutFunctionConfigBinding((ScrollView) rootView2, bootRecordModeRadio12, bootRecordModeRadio22, bootRecordModeRadio32, bootRecordModeRadiogroup2, cboxApk3602, cboxBt2, cboxEqApp2, cboxFrontView2, cboxFunction12, cboxFunction32, cboxFunction42, cboxFunction52, cboxFunction62, cboxFunction72, cboxFunctionFcam2, cboxFunctionGoogleOff2, cboxGlobalWeather2, cboxHicar2, cboxSreencast2, cboxSysXcjz2, cboxTouchSend2, rdbFunbt12, rdbFunbt22, rdbFunxcjl12, rdbFunxcjl22, rdbFunxcjl32, rdg360sx3, rdg360sx12, rdg360sx22, rdgAhd8, rdgAhd02, rdgAhd12, rdgAhd22, rdgAhd32, rdgAhd42, rdgAhd52, rdgAhd62, rdgAhd72, rdgBgkz3, rdgBgkz12, rdgBgkz22, rdgDawei3, rdgDawei12, rdgDawei22, rdgFunbt2, rdgFungf3, rdgFungf12, rdgFungf22, rdgFunxcjl2, tvSeleAPk2, tvSelePlayAPk2);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
