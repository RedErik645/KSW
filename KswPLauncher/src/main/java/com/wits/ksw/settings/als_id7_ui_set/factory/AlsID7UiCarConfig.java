package com.wits.ksw.settings.als_id7_ui_set.factory;

import android.content.Context;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class AlsID7UiCarConfig extends FrameLayout implements RadioGroup.OnCheckedChangeListener {
    private static final String TAG = ("KswApplication." + AlsID7UiCarConfig.class.getSimpleName());
    private RadioGroup audiHomeLeftRadioGroup;
    private RadioGroup audiHomeRightRadioGroup;
    private int audiLeftLogoIndex;
    private int audiRightWidgetIndex;
    private TextView audi_home_left_widget_textview;
    private TextView audi_home_right_widget_textview;
    private int auxsw = 0;
    private int benzpane = 0;
    private int canS = 0;
    private int carManufacturer = 0;
    private int cardoor = 0;
    private int carseep = 0;
    private CheckBox cbox_ac_control;
    private CheckBox cbox_air_con;
    private CheckBox cbox_bencAux;
    private CheckBox cbox_bencPank;
    private RadioGroup cbox_bencPank_rgd;
    private View cbox_bencPank_root;
    private CheckBox cbox_canBus;
    private CheckBox cbox_dcld;
    private CheckBox cbox_oem_fm;
    private TextView ccciDTextView;
    private int cccid = 0;
    private int doornumb = 0;
    private int gears = 0;
    private int isOldBmwx = 0;
    private FrameLayout.LayoutParams layoutParams;
    private Context m_con;
    private int mapkey = 0;
    private int modekey = 0;
    private int nbauxsw = 0;
    private RadioGroup rdg_Nbtauxsw;
    private RadioGroup rdg_auxsw;
    private RadioGroup rdg_can;
    private RadioGroup rdg_cardoor;
    private RadioGroup rdg_ccciD;
    private RadioGroup rdg_factory_carseep;
    private RadioGroup rdg_factory_gears;
    private RadioGroup rdg_factory_mapkey;
    private RadioGroup rdg_factory_modekey;
    private RadioGroup rdg_factory_yuyinkey;
    private RadioGroup rdg_numdoor;
    private RadioGroup rdg_track;
    private int track = 0;
    private View view;
    private int yuyinkey = 0;

    public AlsID7UiCarConfig(Context context) {
        super(context);
        this.m_con = context;
        this.view = LayoutInflater.from(context).inflate(R.layout.als_id7_ui_factory_car_config, (ViewGroup) null);
        this.layoutParams = new FrameLayout.LayoutParams(-1, -1);
        initData();
        initView();
        this.view.setLayoutParams(this.layoutParams);
        addView(this.view);
    }

    private void initData() {
        try {
            this.isOldBmwx = PowerManagerApp.getSettingsInt(KeyConfig.BAO_MA_DISPLAY);
            this.auxsw = PowerManagerApp.getSettingsInt(KeyConfig.CAR_AUX_SW);
            this.nbauxsw = PowerManagerApp.getSettingsInt(KeyConfig.NBT_AUX_SW);
            this.cccid = PowerManagerApp.getSettingsInt(KeyConfig.CCC_ID);
            this.cardoor = PowerManagerApp.getSettingsInt(KeyConfig.CAR_DOOR_SELECT);
            this.carseep = PowerManagerApp.getSettingsInt(KeyConfig.DASH_MAX_SPEED);
            this.gears = PowerManagerApp.getSettingsInt(KeyConfig.HAND_SET_AUTOMATIC);
            this.doornumb = PowerManagerApp.getSettingsInt(KeyConfig.CAR_DOOR_NUM);
            this.yuyinkey = PowerManagerApp.getSettingsInt(KeyConfig.VOICE_KEY);
            this.mapkey = PowerManagerApp.getSettingsInt(KeyConfig.MAP_KEY);
            this.modekey = PowerManagerApp.getSettingsInt(KeyConfig.MODE_KEY);
            this.benzpane = PowerManagerApp.getSettingsInt(KeyConfig.BENZPANE);
            this.audiLeftLogoIndex = PowerManagerApp.getSettingsInt(KeyConfig.AUDI_UI_LEFT_ID);
            this.audiRightWidgetIndex = PowerManagerApp.getSettingsInt(KeyConfig.AUDI_UI_RIGHT_ID);
            this.carManufacturer = PowerManagerApp.getSettingsInt(KeyConfig.CarManufacturer);
            this.canS = PowerManagerApp.getSettingsInt(KeyConfig.CAN_BUS_TYPE);
            this.track = PowerManagerApp.getSettingsInt(KeyConfig.DRIVE_TRACK);
            Log.d(TAG, "initData: " + this.carManufacturer + " " + this.canS + " " + this.track);
            if (this.carManufacturer == 0) {
                this.carManufacturer = UiThemeUtils.getCarManufacturer(this.m_con);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void initView() {
        int airCon;
        this.cbox_dcld = (CheckBox) this.view.findViewById(R.id.cbox_dcld);
        this.cbox_canBus = (CheckBox) this.view.findViewById(R.id.cbox_canBus);
        this.cbox_bencAux = (CheckBox) this.view.findViewById(R.id.cbox_bencAux);
        this.cbox_air_con = (CheckBox) this.view.findViewById(R.id.cbox_air_con);
        this.cbox_ac_control = (CheckBox) this.view.findViewById(R.id.cbox_ac_control);
        this.cbox_oem_fm = (CheckBox) this.view.findViewById(R.id.cbox_oem_fm);
        int i = 0;
        this.cbox_canBus.setChecked(false);
        boolean isAudi = true;
        this.cbox_dcld.setChecked(this.isOldBmwx == 0);
        this.cbox_dcld.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass1 */

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    FileUtils.savaIntData(KeyConfig.BAO_MA_DISPLAY, 0);
                } else {
                    FileUtils.savaIntData(KeyConfig.BAO_MA_DISPLAY, 1);
                }
            }
        });
        this.cbox_bencAux.setChecked(false);
        try {
            this.cbox_bencAux.setChecked(PowerManagerApp.getSettingsInt("benz_aux_switch") == 1);
        } catch (RemoteException e) {
        }
        this.cbox_bencAux.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FileUtils.savaIntData("benz_aux_switch", isChecked ? 1 : 0);
            }
        });
        int i2 = this.carManufacturer;
        if (i2 == 1 || i2 == 3) {
            airCon = Settings.System.getInt(this.m_con.getContentResolver(), "air_conditioner", 0);
        } else {
            airCon = Settings.System.getInt(this.m_con.getContentResolver(), "air_conditioner", 1);
        }
        int acControl = Settings.System.getInt(this.m_con.getContentResolver(), KeyConfig.AC_CONTROL, 0);
        int oemFM = Settings.System.getInt(this.m_con.getContentResolver(), KeyConfig.OEM_FM, 0);
        this.cbox_air_con.setChecked(airCon == 1);
        this.cbox_air_con.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass3 */

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FileUtils.savaIntData("air_conditioner", isChecked ? 1 : 0);
            }
        });
        this.cbox_ac_control.setChecked(acControl == 1);
        this.cbox_ac_control.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass4 */

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FileUtils.savaIntData(KeyConfig.AC_CONTROL, isChecked ? 1 : 0);
            }
        });
        this.cbox_oem_fm.setChecked(oemFM == 1);
        this.cbox_oem_fm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass5 */

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FileUtils.savaIntData(KeyConfig.OEM_FM, isChecked ? 1 : 0);
            }
        });
        CheckBox checkBox = (CheckBox) this.view.findViewById(R.id.cbox_bencPank);
        this.cbox_bencPank = checkBox;
        checkBox.setChecked(this.benzpane != 0);
        this.cbox_bencPank.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass6 */

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    FileUtils.savaIntData(KeyConfig.BENZPANE, 1);
                } else {
                    FileUtils.savaIntData(KeyConfig.BENZPANE, 0);
                }
            }
        });
        this.cbox_bencPank_root = this.view.findViewById(R.id.cbox_bencPank_root);
        RadioGroup radioGroup = (RadioGroup) this.view.findViewById(R.id.cbox_bencPank_rgd);
        this.cbox_bencPank_rgd = radioGroup;
        int count = radioGroup.getChildCount();
        int i3 = 0;
        while (i3 < count) {
            ((RadioButton) this.cbox_bencPank_rgd.getChildAt(i3)).setChecked(this.benzpane == i3);
            i3++;
        }
        this.cbox_bencPank_rgd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass7 */

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count = AlsID7UiCarConfig.this.cbox_bencPank_rgd.getChildCount();
                for (int i = 0; i < count; i++) {
                    if (checkedId == AlsID7UiCarConfig.this.cbox_bencPank_rgd.getChildAt(i).getId()) {
                        FileUtils.savaIntData(KeyConfig.BENZPANE, i);
                        Log.i(AlsID7UiCarConfig.TAG, "save BenzPanelEnable : " + i);
                    }
                }
            }
        });
        try {
            this.cbox_canBus.setChecked(PowerManagerApp.getSettingsInt("can_bus_switch") == 1);
        } catch (RemoteException e2) {
        }
        this.cbox_canBus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass8 */

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    PowerManagerApp.setSettingsInt("can_bus_switch", isChecked ? 1 : 0);
                    if (isChecked) {
                        AlsID7UiCarConfig.this.rdg_can.setEnabled(false);
                        AlsID7UiCarConfig.this.rdg_can.findViewById(R.id.rdg_can1).setEnabled(false);
                        AlsID7UiCarConfig.this.rdg_can.findViewById(R.id.rdg_can2).setEnabled(false);
                        return;
                    }
                    AlsID7UiCarConfig.this.rdg_can.setEnabled(true);
                    AlsID7UiCarConfig.this.rdg_can.findViewById(R.id.rdg_can1).setEnabled(true);
                    AlsID7UiCarConfig.this.rdg_can.findViewById(R.id.rdg_can2).setEnabled(true);
                } catch (RemoteException e) {
                }
            }
        });
        RadioGroup radioGroup2 = (RadioGroup) this.view.findViewById(R.id.rdg_auxsw);
        this.rdg_auxsw = radioGroup2;
        switch (this.auxsw) {
            case 0:
                radioGroup2.check(R.id.rdb_auxsw1);
                break;
            case 1:
                radioGroup2.check(R.id.rdb_auxsw2);
                break;
        }
        RadioGroup radioGroup3 = (RadioGroup) this.view.findViewById(R.id.rdg_Nbtauxsw);
        this.rdg_Nbtauxsw = radioGroup3;
        switch (this.nbauxsw) {
            case 1:
                radioGroup3.check(R.id.rdb_Nbtauxsw1);
                break;
            case 2:
                radioGroup3.check(R.id.rdb_Nbtauxsw2);
                break;
            case 3:
                radioGroup3.check(R.id.rdb_Nbtauxsw3);
                break;
        }
        RadioGroup radioGroup4 = (RadioGroup) this.view.findViewById(R.id.rdg_ccciD);
        this.rdg_ccciD = radioGroup4;
        switch (this.cccid) {
            case 0:
                radioGroup4.check(R.id.rdb_ccciD1);
                break;
            case 1:
                radioGroup4.check(R.id.rdb_ccciD2);
                break;
        }
        RadioGroup radioGroup5 = (RadioGroup) this.view.findViewById(R.id.rdg_cardoor);
        this.rdg_cardoor = radioGroup5;
        switch (this.cardoor) {
            case 0:
            case 2:
                radioGroup5.check(R.id.rdg_cardoor1);
                break;
            case 1:
                radioGroup5.check(R.id.rdg_cardoor2);
                break;
        }
        RadioGroup radioGroup6 = (RadioGroup) this.view.findViewById(R.id.rdg_factory_carseep);
        this.rdg_factory_carseep = radioGroup6;
        switch (this.carseep) {
            case 0:
                radioGroup6.check(R.id.rdg_factory_carseep1);
                break;
            case 1:
                radioGroup6.check(R.id.rdg_factory_carseep2);
                break;
            case 2:
                radioGroup6.check(R.id.rdg_factory_carseep3);
                break;
            case 3:
                radioGroup6.check(R.id.rdg_factory_carseep4);
                break;
        }
        RadioGroup radioGroup7 = (RadioGroup) this.view.findViewById(R.id.rdg_factory_gear);
        this.rdg_factory_gears = radioGroup7;
        switch (this.gears) {
            case 0:
                radioGroup7.check(R.id.rdg_factory_gear1);
                break;
            case 1:
                radioGroup7.check(R.id.rdg_factory_gear2);
                break;
            case 2:
                radioGroup7.check(R.id.rdg_factory_gear3);
                break;
        }
        RadioGroup radioGroup8 = (RadioGroup) this.view.findViewById(R.id.rdg_numdoor);
        this.rdg_numdoor = radioGroup8;
        switch (this.doornumb) {
            case 0:
                radioGroup8.check(R.id.rdg_numdoor1);
                break;
            case 1:
                radioGroup8.check(R.id.rdg_numdoor2);
                break;
            case 2:
                radioGroup8.check(R.id.rdg_cardoor3);
                break;
        }
        this.rdg_factory_mapkey = (RadioGroup) this.view.findViewById(R.id.rdg_factory_mapkey);
        Log.d("CarConfig", "mapkey====get====>" + this.mapkey);
        switch (this.mapkey) {
            case 0:
                this.rdg_factory_mapkey.check(R.id.rdg_factory_mapkey1);
                break;
            case 1:
                this.rdg_factory_mapkey.check(R.id.rdg_factory_mapkey2);
                break;
        }
        RadioGroup radioGroup9 = (RadioGroup) this.view.findViewById(R.id.rdg_factory_modekey);
        this.rdg_factory_modekey = radioGroup9;
        switch (this.modekey) {
            case 0:
                radioGroup9.check(R.id.rdg_factory_modekey1);
                break;
            case 1:
                radioGroup9.check(R.id.rdg_factory_modekey2);
                break;
        }
        RadioGroup radioGroup10 = (RadioGroup) this.view.findViewById(R.id.rdg_factory_yuyinkey);
        this.rdg_factory_yuyinkey = radioGroup10;
        switch (this.yuyinkey) {
            case 0:
                radioGroup10.check(R.id.rdg_factory_yuyinkey1);
                break;
            case 1:
                radioGroup10.check(R.id.rdg_factory_yuyinkey2);
                break;
            case 2:
                radioGroup10.check(R.id.rdg_factory_yuyinkey3);
                break;
            case 3:
                radioGroup10.check(R.id.rdg_factory_yuyinkey4);
                break;
        }
        RadioGroup radioGroup11 = (RadioGroup) this.view.findViewById(R.id.rdg_can);
        this.rdg_can = radioGroup11;
        switch (this.canS) {
            case 1:
                radioGroup11.check(R.id.rdg_can1);
                break;
            case 2:
                radioGroup11.check(R.id.rdg_can2);
                break;
        }
        if (this.cbox_canBus.isChecked()) {
            this.rdg_can.setEnabled(false);
            this.rdg_can.findViewById(R.id.rdg_can1).setEnabled(false);
            this.rdg_can.findViewById(R.id.rdg_can2).setEnabled(false);
        }
        RadioGroup radioGroup12 = (RadioGroup) this.view.findViewById(R.id.rdg_track);
        this.rdg_track = radioGroup12;
        switch (this.track) {
            case 0:
                radioGroup12.check(R.id.rdg_track1);
                break;
            case 1:
                radioGroup12.check(R.id.rdg_track2);
                break;
        }
        this.rdg_can.setOnCheckedChangeListener(this);
        this.rdg_track.setOnCheckedChangeListener(this);
        this.rdg_auxsw.setOnCheckedChangeListener(this);
        this.rdg_Nbtauxsw.setOnCheckedChangeListener(this);
        this.rdg_ccciD.setOnCheckedChangeListener(this);
        this.rdg_cardoor.setOnCheckedChangeListener(this);
        this.rdg_numdoor.setOnCheckedChangeListener(this);
        this.rdg_factory_carseep.setOnCheckedChangeListener(this);
        this.rdg_factory_gears.setOnCheckedChangeListener(this);
        this.rdg_factory_yuyinkey.setOnCheckedChangeListener(this);
        this.rdg_factory_mapkey.setOnCheckedChangeListener(this);
        this.rdg_factory_modekey.setOnCheckedChangeListener(this);
        this.ccciDTextView = (TextView) this.view.findViewById(R.id.ccciDTextView);
        int i4 = this.carManufacturer;
        boolean enableAux = i4 == 2;
        boolean enableAirCondition = i4 == 4;
        this.cbox_bencAux.setVisibility(enableAux ? 0 : 8);
        this.cbox_bencPank.setVisibility(enableAux ? 0 : 8);
        this.cbox_bencPank_root.setVisibility(enableAux ? 0 : 8);
        this.cbox_air_con.setVisibility((!enableAux && !enableAirCondition) ? 8 : 0);
        this.cbox_ac_control.setVisibility(enableAirCondition ? 0 : 8);
        this.cbox_oem_fm.setVisibility(enableAirCondition ? 0 : 8);
        this.audi_home_left_widget_textview = (TextView) this.view.findViewById(R.id.audi_home_left_widget_textview);
        this.audi_home_right_widget_textview = (TextView) this.view.findViewById(R.id.audi_home_right_widget_textview);
        this.audiHomeLeftRadioGroup = (RadioGroup) this.view.findViewById(R.id.audiHomeLeftRadioGroup);
        this.audiHomeRightRadioGroup = (RadioGroup) this.view.findViewById(R.id.audiHomeRightRadioGroup);
        String str = TAG;
        Log.i(str, "audiLeftLogoIndex: " + this.audiLeftLogoIndex);
        Log.i(str, "audiRightWidgetIndex: " + this.audiRightWidgetIndex);
        int i5 = 0;
        while (i5 < this.audiHomeLeftRadioGroup.getChildCount()) {
            ((RadioButton) this.audiHomeLeftRadioGroup.getChildAt(i5)).setChecked(this.audiLeftLogoIndex == i5);
            i5++;
        }
        int i6 = 0;
        while (i6 < this.audiHomeRightRadioGroup.getChildCount()) {
            ((RadioButton) this.audiHomeRightRadioGroup.getChildAt(i6)).setChecked(this.audiRightWidgetIndex == i6);
            i6++;
        }
        this.audiHomeLeftRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass9 */

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count = AlsID7UiCarConfig.this.audiHomeLeftRadioGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    if (checkedId == AlsID7UiCarConfig.this.audiHomeLeftRadioGroup.getChildAt(i).getId()) {
                        FileUtils.savaIntData(KeyConfig.AUDI_UI_LEFT_ID, i);
                        Log.i(AlsID7UiCarConfig.TAG, "save Audi_Logo_Left : " + i);
                    }
                }
            }
        });
        this.audiHomeRightRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.als_id7_ui_set.factory.AlsID7UiCarConfig.AnonymousClass10 */

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count = AlsID7UiCarConfig.this.audiHomeRightRadioGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    if (checkedId == AlsID7UiCarConfig.this.audiHomeRightRadioGroup.getChildAt(i).getId()) {
                        FileUtils.savaIntData(KeyConfig.AUDI_UI_RIGHT_ID, i);
                        Log.i(AlsID7UiCarConfig.TAG, "save Audi_Logo_Right : " + i);
                    }
                }
            }
        });
        if (this.carManufacturer != 3) {
            isAudi = false;
        }
        this.audi_home_left_widget_textview.setVisibility(isAudi ? 0 : 8);
        this.audi_home_right_widget_textview.setVisibility(isAudi ? 0 : 8);
        this.audiHomeLeftRadioGroup.setVisibility(isAudi ? 0 : 8);
        RadioGroup radioGroup13 = this.audiHomeRightRadioGroup;
        if (!isAudi) {
            i = 8;
        }
        radioGroup13.setVisibility(i);
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rdb_Nbtauxsw1 /*{ENCODED_INT: 2131232300}*/:
                FileUtils.savaIntData(KeyConfig.NBT_AUX_SW, 1);
                return;
            case R.id.rdb_Nbtauxsw2 /*{ENCODED_INT: 2131232301}*/:
                FileUtils.savaIntData(KeyConfig.NBT_AUX_SW, 2);
                return;
            case R.id.rdb_Nbtauxsw3 /*{ENCODED_INT: 2131232302}*/:
                FileUtils.savaIntData(KeyConfig.NBT_AUX_SW, 3);
                return;
            case R.id.rdb_auxsw1 /*{ENCODED_INT: 2131232303}*/:
                FileUtils.savaIntData(KeyConfig.CAR_AUX_SW, 0);
                return;
            case R.id.rdb_auxsw2 /*{ENCODED_INT: 2131232304}*/:
                FileUtils.savaIntData(KeyConfig.CAR_AUX_SW, 1);
                return;
            case R.id.rdb_ccciD1 /*{ENCODED_INT: 2131232305}*/:
                FileUtils.savaIntData(KeyConfig.CCC_ID, 0);
                return;
            case R.id.rdb_ccciD2 /*{ENCODED_INT: 2131232306}*/:
                FileUtils.savaIntData(KeyConfig.CCC_ID, 1);
                return;
            case R.id.rdg_can1 /*{ENCODED_INT: 2131232352}*/:
                FileUtils.savaIntData(KeyConfig.CAN_BUS_TYPE, 1);
                return;
            case R.id.rdg_can2 /*{ENCODED_INT: 2131232353}*/:
                FileUtils.savaIntData(KeyConfig.CAN_BUS_TYPE, 2);
                return;
            case R.id.rdg_cardoor1 /*{ENCODED_INT: 2131232355}*/:
                FileUtils.savaIntData(KeyConfig.CAR_DOOR_SELECT, 0);
                return;
            case R.id.rdg_cardoor2 /*{ENCODED_INT: 2131232356}*/:
                FileUtils.savaIntData(KeyConfig.CAR_DOOR_SELECT, 1);
                return;
            case R.id.rdg_cardoor3 /*{ENCODED_INT: 2131232357}*/:
                FileUtils.savaIntData(KeyConfig.CAR_DOOR_NUM, 2);
                return;
            case R.id.rdg_factory_carseep1 /*{ENCODED_INT: 2131232363}*/:
                FileUtils.savaIntData(KeyConfig.DASH_MAX_SPEED, 0);
                return;
            case R.id.rdg_factory_carseep2 /*{ENCODED_INT: 2131232364}*/:
                FileUtils.savaIntData(KeyConfig.DASH_MAX_SPEED, 1);
                return;
            case R.id.rdg_factory_carseep3 /*{ENCODED_INT: 2131232365}*/:
                FileUtils.savaIntData(KeyConfig.DASH_MAX_SPEED, 2);
                return;
            case R.id.rdg_factory_carseep4 /*{ENCODED_INT: 2131232366}*/:
                FileUtils.savaIntData(KeyConfig.DASH_MAX_SPEED, 3);
                return;
            case R.id.rdg_factory_gear1 /*{ENCODED_INT: 2131232371}*/:
                FileUtils.savaIntData(KeyConfig.HAND_SET_AUTOMATIC, 0);
                return;
            case R.id.rdg_factory_gear2 /*{ENCODED_INT: 2131232372}*/:
                FileUtils.savaIntData(KeyConfig.HAND_SET_AUTOMATIC, 1);
                return;
            case R.id.rdg_factory_gear3 /*{ENCODED_INT: 2131232373}*/:
                FileUtils.savaIntData(KeyConfig.HAND_SET_AUTOMATIC, 2);
                return;
            case R.id.rdg_factory_mapkey1 /*{ENCODED_INT: 2131232375}*/:
                FileUtils.savaIntData(KeyConfig.MAP_KEY, 0);
                Log.d("CarConfig", "mapkey====sava==0000===>");
                return;
            case R.id.rdg_factory_mapkey2 /*{ENCODED_INT: 2131232376}*/:
                FileUtils.savaIntData(KeyConfig.MAP_KEY, 1);
                Log.d("CarConfig", "mapkey====sava===1111===>");
                return;
            case R.id.rdg_factory_modekey1 /*{ENCODED_INT: 2131232378}*/:
                FileUtils.savaIntData(KeyConfig.MODE_KEY, 0);
                return;
            case R.id.rdg_factory_modekey2 /*{ENCODED_INT: 2131232379}*/:
                FileUtils.savaIntData(KeyConfig.MODE_KEY, 1);
                return;
            case R.id.rdg_factory_yuyinkey1 /*{ENCODED_INT: 2131232388}*/:
                FileUtils.savaIntData(KeyConfig.VOICE_KEY, 0);
                return;
            case R.id.rdg_factory_yuyinkey2 /*{ENCODED_INT: 2131232389}*/:
                FileUtils.savaIntData(KeyConfig.VOICE_KEY, 1);
                return;
            case R.id.rdg_factory_yuyinkey3 /*{ENCODED_INT: 2131232390}*/:
                FileUtils.savaIntData(KeyConfig.VOICE_KEY, 2);
                return;
            case R.id.rdg_factory_yuyinkey4 /*{ENCODED_INT: 2131232391}*/:
                FileUtils.savaIntData(KeyConfig.VOICE_KEY, 3);
                return;
            case R.id.rdg_numdoor1 /*{ENCODED_INT: 2131232406}*/:
                FileUtils.savaIntData(KeyConfig.CAR_DOOR_NUM, 0);
                return;
            case R.id.rdg_numdoor2 /*{ENCODED_INT: 2131232407}*/:
                FileUtils.savaIntData(KeyConfig.CAR_DOOR_NUM, 1);
                return;
            case R.id.rdg_track1 /*{ENCODED_INT: 2131232422}*/:
                FileUtils.savaIntData(KeyConfig.DRIVE_TRACK, 0);
                return;
            case R.id.rdg_track2 /*{ENCODED_INT: 2131232423}*/:
                FileUtils.savaIntData(KeyConfig.DRIVE_TRACK, 1);
                return;
            default:
                return;
        }
    }
}
