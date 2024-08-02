package com.wits.ksw.launcher.view.lexus;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityLexusOemFmBinding;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.McuStatus;
import com.wits.pms.statuscontrol.PowerManagerApp;
import com.wits.pms.statuscontrol.WitsCommand;

public class OEMFMActivity extends AppCompatActivity {
    public static final int DISMISS_EQ = 120;
    public static final int DISMISS_VOLUME = 110;
    public static final String TAG = OEMFMActivity.class.getSimpleName();
    private IContentObserver.Stub acObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass2 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                McuStatus.ACData acData = McuStatus.ACData.getStatusFromJson(PowerManagerApp.getStatusString("acData"));
                Log.i(OEMFMActivity.TAG, "onChange: acData=" + acData.getJson());
                OEMFMActivity.this.update(acData);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(OEMFMActivity.TAG, "onChange: Exception " + e.getMessage());
            }
        }
    };
    private IContentObserver.Stub btObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass4 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                Log.d(OEMFMActivity.TAG, "btObserver onChange ");
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(OEMFMActivity.TAG, "onChange: Exception " + e.getMessage());
            }
        }
    };
    private IContentObserver.Stub discObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass9 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                OEMFMActivity.this.setDisc();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(OEMFMActivity.TAG, "onChange: Exception " + e.getMessage());
            }
        }
    };
    private IContentObserver.Stub eqObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass7 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                Log.d(OEMFMActivity.TAG, "eqObserver onChange ");
                OEMFMActivity.this.setEq();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(OEMFMActivity.TAG, "onChange: Exception " + e.getMessage());
            }
        }
    };
    private IContentObserver.Stub mediaObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass3 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                McuStatus.MediaData mediaData = McuStatus.MediaData.parseDataFromJson(PowerManagerApp.getStatusString("mcuMediaJson"));
                Log.i(OEMFMActivity.TAG, "onChange: acData=" + mediaData);
                OEMFMActivity.this.updateMedia(mediaData);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(OEMFMActivity.TAG, "onChange: Exception " + e.getMessage());
            }
        }
    };
    private IContentObserver.Stub muteObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass5 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                OEMFMActivity.this.displayVolumeProgress();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(OEMFMActivity.TAG, "onChange: Exception " + e.getMessage());
            }
        }
    };
    private ActivityLexusOemFmBinding oemFmBinding;
    private int tempUnit = 0;
    private LexusUiParams uiParams = new LexusUiParams();
    private IContentObserver.Stub usbInfoObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass8 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                OEMFMActivity.this.updateUsbInfo();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(OEMFMActivity.TAG, "onChange: Exception " + e.getMessage());
            }
        }
    };
    private IContentObserver.Stub usbStatusObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass10 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                OEMFMActivity.this.updateUsbInfo();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(OEMFMActivity.TAG, "onChange: Exception " + e.getMessage());
            }
        }
    };
    private LexusOEMFMViewModel viewModel;
    private Handler volumeHandler = new Handler() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass1 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 110:
                    OEMFMActivity.this.dismissVolumeProgress();
                    return;
                case 120:
                    OEMFMActivity.this.viewModel.eq.set(false);
                    return;
                default:
                    return;
            }
        }
    };
    private IContentObserver.Stub volumeObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.lexus.OEMFMActivity.AnonymousClass6 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                OEMFMActivity.this.displayVolumeProgress();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(OEMFMActivity.TAG, "onChange: Exception " + e.getMessage());
            }
        }
    };

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLexusOemFmBinding activityLexusOemFmBinding = (ActivityLexusOemFmBinding) DataBindingUtil.setContentView(this, R.layout.activity_lexus_oem_fm);
        this.oemFmBinding = activityLexusOemFmBinding;
        activityLexusOemFmBinding.setMUiParams(this.uiParams);
        LexusOEMFMViewModel lexusOEMFMViewModel = (LexusOEMFMViewModel) ViewModelProviders.of(this).get(LexusOEMFMViewModel.class);
        this.viewModel = lexusOEMFMViewModel;
        lexusOEMFMViewModel.setActivity(this);
        this.oemFmBinding.setVm(this.viewModel);
        setFull();
        registerIContentObserver();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        PowerManagerApp.unRegisterIContentObserver(this.acObserver);
        PowerManagerApp.unRegisterIContentObserver(this.mediaObserver);
        PowerManagerApp.unRegisterIContentObserver(this.usbStatusObserver);
        PowerManagerApp.unRegisterIContentObserver(this.usbInfoObserver);
        PowerManagerApp.unRegisterIContentObserver(this.discObserver);
        PowerManagerApp.unRegisterIContentObserver(this.muteObserver);
        PowerManagerApp.unRegisterIContentObserver(this.volumeObserver);
        PowerManagerApp.unRegisterIContentObserver(this.eqObserver);
        PowerManagerApp.unRegisterIContentObserver(this.btObserver);
    }

    public void setFull() {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
        }
    }

    public String getFormatMMSS(int min, int sec) {
        Log.d(TAG, "time: " + min + " " + sec);
        return min + ":" + sec;
    }

    private void registerIContentObserver() {
        Log.i(TAG, "onCreate: registerIContentObserver");
        PowerManagerApp.registerIContentObserver("mcuEqData", this.eqObserver);
        PowerManagerApp.registerIContentObserver("acData", this.acObserver);
        PowerManagerApp.registerIContentObserver("mcuMediaStringInfo", this.usbInfoObserver);
        PowerManagerApp.registerIContentObserver("mcuMediaPlayStatus", this.usbStatusObserver);
        PowerManagerApp.registerIContentObserver("mcuMediaJson", this.mediaObserver);
        PowerManagerApp.registerIContentObserver("mcuDiscStatus", this.discObserver);
        PowerManagerApp.registerIContentObserver("mcu_volume_level", this.volumeObserver);
        PowerManagerApp.registerIContentObserver("mcu_volume_mute", this.muteObserver);
        PowerManagerApp.registerIContentObserver("mcuBluetoothStatus", this.btObserver);
        try {
            update(McuStatus.ACData.getStatusFromJson(PowerManagerApp.getStatusString("acData")));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateMedia(McuStatus.MediaData mediaData) {
        String str = TAG;
        Log.d(str, "update media 14 " + mediaData.type + " mode " + mediaData.mode);
        if (mediaData.type == 1) {
            this.viewModel.fm.set(true);
            this.viewModel.cd.set(false);
            this.viewModel.usb.set(false);
            this.viewModel.mp3.set(false);
            this.viewModel.bt.set(false);
            this.viewModel.aux.set(false);
            this.viewModel.fmBand.set(mediaData.fm.name);
            this.viewModel.fmFrequency.set(mediaData.fm.freq);
            switch (mediaData.fm.preFreq) {
                case 0:
                    this.viewModel.ch.set("");
                    break;
                case 1:
                    this.viewModel.ch.set("CH1");
                    break;
                case 2:
                    this.viewModel.ch.set("CH2");
                    break;
                case 3:
                    this.viewModel.ch.set("CH3");
                    break;
                case 4:
                    this.viewModel.ch.set("CH4");
                    break;
                case 5:
                    this.viewModel.ch.set("CH5");
                    break;
                case 6:
                    this.viewModel.ch.set("CH6");
                    break;
            }
        }
        if (mediaData.type == 16) {
            this.viewModel.fm.set(false);
            this.viewModel.cd.set(true);
            this.viewModel.usb.set(false);
            this.viewModel.mp3.set(false);
            this.viewModel.bt.set(false);
            this.viewModel.aux.set(false);
            if (mediaData.disc.number < 0) {
                this.viewModel.disc.set("-");
            } else {
                this.viewModel.disc.set(mediaData.disc.number + "");
            }
            if (mediaData.disc.track < 0) {
                this.viewModel.track.set("-");
            } else {
                this.viewModel.track.set(mediaData.disc.track + "");
            }
            if (mediaData.disc.min < 0 || mediaData.disc.sec < 0) {
                this.viewModel.time.set("--:--");
            } else {
                this.viewModel.time.set(getFormatMMSS(mediaData.disc.min, mediaData.disc.sec));
            }
        }
        if (mediaData.type == 17) {
            this.viewModel.fm.set(false);
            this.viewModel.cd.set(false);
            this.viewModel.usb.set(true);
            this.viewModel.mp3.set(false);
            this.viewModel.bt.set(false);
            this.viewModel.aux.set(false);
            Log.d(str, "update usb min " + mediaData.usb.min + " sec " + mediaData.usb.sec);
            Log.d(str, "update usb name " + mediaData.usb.name + " artist " + mediaData.usb.artist + " album " + mediaData.usb.album);
            if (mediaData.usb.min < 0 || mediaData.usb.sec < 0) {
                this.viewModel.usbMusicTime.set("--:--");
            } else {
                this.viewModel.usbMusicTime.set(getFormatMMSS(mediaData.usb.min, mediaData.usb.sec));
            }
            if (TextUtils.isEmpty(mediaData.usb.name) || mediaData.usb.name.equals("null")) {
                this.viewModel.musicName.set(getString(R.string.ksw_idf7_unkonw_soung));
            } else {
                this.viewModel.musicName.set(mediaData.usb.name);
            }
            this.oemFmBinding.usbMusicName.requestFocus();
            if (TextUtils.isEmpty(mediaData.usb.artist) || mediaData.usb.artist.equals("null")) {
                this.viewModel.artist.set(getString(R.string.ksw_idf7_unknow_artis));
            } else {
                this.viewModel.artist.set(mediaData.usb.artist);
            }
            if (TextUtils.isEmpty(mediaData.usb.album) || mediaData.usb.album.equals("null")) {
                this.viewModel.album.set(getString(R.string.ksw_idf7_unkonw_album));
            } else {
                this.viewModel.album.set(mediaData.usb.album);
            }
            Log.d(str, "update usb folderName " + mediaData.usb.folderName + " fileNumber " + mediaData.usb.fileNumber + " folderNumber " + mediaData.usb.folderNumber);
            if (mediaData.usb.fileNumber < 0 || mediaData.usb.folderNumber < 0) {
                this.viewModel.index.set(mediaData.usb.folderName);
            } else {
                this.viewModel.index.set(mediaData.usb.folderName + "  " + mediaData.usb.folderNumber + " / " + mediaData.usb.fileNumber);
            }
        }
        if (mediaData.type == 18) {
            this.viewModel.fm.set(false);
            this.viewModel.cd.set(false);
            this.viewModel.usb.set(false);
            this.viewModel.mp3.set(true);
            this.viewModel.bt.set(false);
            this.viewModel.aux.set(false);
            Log.d(str, "update mp3 min " + mediaData.mp3.min + " sec " + mediaData.mp3.sec);
            if (mediaData.mp3.min < 0 || mediaData.mp3.sec < 0) {
                this.viewModel.usbMusicTime.set("--:--");
            } else {
                this.viewModel.usbMusicTime.set(getFormatMMSS(mediaData.mp3.min, mediaData.mp3.sec));
            }
            Log.d(str, "update mp3 name " + mediaData.mp3.name + " artist " + mediaData.mp3.artist + " album " + mediaData.mp3.album);
            Log.d(str, "update mp3 folderName " + mediaData.mp3.folderName + " fileNumber " + mediaData.mp3.fileNumber + " folderNumber " + mediaData.mp3.folderNumber);
            if (TextUtils.isEmpty(mediaData.mp3.name) || mediaData.mp3.name.equals("null")) {
                this.viewModel.musicName.set(getString(R.string.unkonw));
            } else {
                this.viewModel.musicName.set(mediaData.mp3.name);
            }
            this.oemFmBinding.mp3MusicName.requestFocus();
            if (TextUtils.isEmpty(mediaData.mp3.artist) || mediaData.mp3.artist.equals("null")) {
                this.viewModel.artist.set(getString(R.string.unkonw));
            } else {
                this.viewModel.artist.set(mediaData.mp3.artist);
            }
            if (TextUtils.isEmpty(mediaData.mp3.album) || mediaData.mp3.album.equals("null")) {
                this.viewModel.album.set(getString(R.string.unkonw));
            } else {
                this.viewModel.album.set(mediaData.mp3.album);
            }
            if (mediaData.mp3.fileNumber < 0 || mediaData.mp3.folderNumber < 0) {
                this.viewModel.index.set(mediaData.mp3.folderName);
            } else {
                this.viewModel.index.set(mediaData.mp3.folderName + "  " + mediaData.mp3.folderNumber + " / " + mediaData.mp3.fileNumber);
            }
        }
        if (mediaData.type == 21) {
            this.viewModel.fm.set(false);
            this.viewModel.cd.set(false);
            this.viewModel.usb.set(false);
            this.viewModel.mp3.set(false);
            this.viewModel.bt.set(true);
            this.viewModel.aux.set(false);
            setBt();
        }
        if (mediaData.type == 20) {
            this.viewModel.fm.set(false);
            this.viewModel.cd.set(false);
            this.viewModel.usb.set(false);
            this.viewModel.mp3.set(false);
            this.viewModel.bt.set(false);
            this.viewModel.aux.set(true);
        }
        try {
            McuStatus.MediaPlayStatus mcuMediaPlayStatus = McuStatus.MediaPlayStatus.parseInfoFromJson(PowerManagerApp.getStatusString("mcuMediaPlayStatus"));
            if (mcuMediaPlayStatus != null) {
                this.viewModel.asl.set(Boolean.valueOf(mcuMediaPlayStatus.ALS));
                this.viewModel.st.set(Boolean.valueOf(mcuMediaPlayStatus.ST));
                this.viewModel.rand.set(Boolean.valueOf(mcuMediaPlayStatus.RAND));
                this.viewModel.scan.set(Boolean.valueOf(mcuMediaPlayStatus.SCAN));
                this.viewModel.rpt.set(Boolean.valueOf(mcuMediaPlayStatus.RPT));
                if (mcuMediaPlayStatus.status.equals("PLAY")) {
                    this.viewModel.usbStatus.set("");
                } else {
                    this.viewModel.usbStatus.set(mcuMediaPlayStatus.status);
                }
                Log.d(str, "mcuMediaPlayStatus ASL " + mcuMediaPlayStatus.ALS + " ST " + mcuMediaPlayStatus.ST + " Rand " + mcuMediaPlayStatus.RAND + " Scan " + mcuMediaPlayStatus.SCAN + " Rpt " + mcuMediaPlayStatus.RPT + " status " + this.viewModel.usbStatus.get());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        updateAudioOff();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateUsbInfo() {
        try {
            McuStatus.MediaData mediaData = McuStatus.MediaData.parseDataFromJson(PowerManagerApp.getStatusString("mcuMediaJson"));
            McuStatus.MediaPlayStatus mcuMediaPlayStatus = McuStatus.MediaPlayStatus.parseInfoFromJson(PowerManagerApp.getStatusString("mcuMediaPlayStatus"));
            if (mcuMediaPlayStatus != null) {
                String str = TAG;
                Log.d(str, "PlayStatus type: " + mcuMediaPlayStatus.type);
                if (mediaData.type == 17) {
                    this.viewModel.fm.set(false);
                    this.viewModel.cd.set(false);
                    this.viewModel.usb.set(true);
                    this.viewModel.mp3.set(false);
                    this.viewModel.bt.set(false);
                    this.viewModel.aux.set(false);
                } else if (mediaData.type == 16) {
                    this.viewModel.fm.set(false);
                    this.viewModel.cd.set(true);
                    this.viewModel.usb.set(false);
                    this.viewModel.mp3.set(false);
                    this.viewModel.bt.set(false);
                    this.viewModel.aux.set(false);
                } else if (mediaData.type == 1) {
                    this.viewModel.fm.set(true);
                    this.viewModel.cd.set(false);
                    this.viewModel.usb.set(false);
                    this.viewModel.mp3.set(false);
                    this.viewModel.bt.set(false);
                    this.viewModel.aux.set(false);
                } else if (mediaData.type == 18) {
                    this.viewModel.fm.set(false);
                    this.viewModel.cd.set(false);
                    this.viewModel.usb.set(false);
                    this.viewModel.mp3.set(true);
                    this.viewModel.bt.set(false);
                    this.viewModel.aux.set(false);
                } else if (mediaData.type == 21) {
                    this.viewModel.fm.set(false);
                    this.viewModel.cd.set(false);
                    this.viewModel.usb.set(false);
                    this.viewModel.mp3.set(false);
                    this.viewModel.bt.set(true);
                    this.viewModel.aux.set(false);
                } else if (mediaData.type == 20) {
                    this.viewModel.fm.set(false);
                    this.viewModel.cd.set(false);
                    this.viewModel.usb.set(false);
                    this.viewModel.mp3.set(false);
                    this.viewModel.bt.set(false);
                    this.viewModel.aux.set(true);
                }
                this.viewModel.asl.set(Boolean.valueOf(mcuMediaPlayStatus.ALS));
                this.viewModel.st.set(Boolean.valueOf(mcuMediaPlayStatus.ST));
                this.viewModel.scan.set(Boolean.valueOf(mcuMediaPlayStatus.SCAN));
                this.viewModel.rand.set(Boolean.valueOf(mcuMediaPlayStatus.RAND));
                this.viewModel.rpt.set(Boolean.valueOf(mcuMediaPlayStatus.RPT));
                if (mcuMediaPlayStatus.status.equals("PLAY")) {
                    this.viewModel.usbStatus.set("");
                } else {
                    this.viewModel.usbStatus.set(mcuMediaPlayStatus.status);
                }
                Log.d(str, "PlayStatus ASL " + mcuMediaPlayStatus.ALS + " ST " + mcuMediaPlayStatus.ST + " Rand " + mcuMediaPlayStatus.RAND + " Scan " + mcuMediaPlayStatus.SCAN + " Rpt " + mcuMediaPlayStatus.RPT + " Pause " + mcuMediaPlayStatus.status);
            }
            updateAudioOff();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        try {
            WitsCommand.sendCommand(1, WitsCommand.SystemCommand.AIR_DATA_REQ);
            WitsCommand.sendMcuCommand(new McuStatus.KswMcuMsg(103, 14));
            if (Settings.System.getInt(getContentResolver(), KeyConfig.OEM_FM, 0) == 0) {
                WitsCommand.sendCommand(1, WitsCommand.SystemCommand.CAR_MODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        if (Settings.System.getInt(getContentResolver(), KeyConfig.OEM_FM, 0) == 0) {
            WitsCommand.sendMcuCommand(new McuStatus.KswMcuMsg(103, 0));
        }
    }

    private void updateAudioOff() {
        try {
            McuStatus.MediaPlayStatus mcuMediaPlayStatus = McuStatus.MediaPlayStatus.parseInfoFromJson(PowerManagerApp.getStatusString("mcuMediaPlayStatus"));
            if (mcuMediaPlayStatus == null || !mcuMediaPlayStatus.status.equals("AUDIO OFF")) {
                this.viewModel.audioOff.set(false);
                return;
            }
            Log.d(TAG, "updateAudioOff " + mcuMediaPlayStatus.status);
            this.viewModel.fm.set(false);
            this.viewModel.cd.set(false);
            this.viewModel.usb.set(false);
            this.viewModel.mp3.set(false);
            this.viewModel.bt.set(false);
            this.viewModel.aux.set(false);
            this.viewModel.eq.set(false);
            this.viewModel.showVolume.set(false);
            this.viewModel.audioOff.set(true);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setDisc() {
        try {
            McuStatus.DiscStatus disc = McuStatus.DiscStatus.parseInfoFromJson(PowerManagerApp.getStatusString("mcuDiscStatus"));
            String str = TAG;
            Log.d(str, "setDisc: " + disc.discInsert.length + " " + disc);
            if (disc != null) {
                this.viewModel.cd1.set(Boolean.valueOf(disc.discInsert[0]));
                this.viewModel.cd2.set(Boolean.valueOf(disc.discInsert[1]));
                this.viewModel.cd3.set(Boolean.valueOf(disc.discInsert[2]));
                this.viewModel.cd4.set(Boolean.valueOf(disc.discInsert[3]));
                this.viewModel.cd5.set(Boolean.valueOf(disc.discInsert[4]));
                this.viewModel.cd6.set(Boolean.valueOf(disc.discInsert[5]));
                Log.d(str, "setDisc cd1 " + disc.discInsert[0] + " cd2 " + disc.discInsert[1] + " cd3 " + disc.discInsert[2] + " cd4 " + disc.discInsert[3] + " cd5 " + disc.discInsert[4] + " cd6 " + disc.discInsert[5]);
                this.viewModel.cdMode.set(disc.status);
                this.oemFmBinding.cd1.setSelected(false);
                this.oemFmBinding.cd2.setSelected(false);
                this.oemFmBinding.cd3.setSelected(false);
                this.oemFmBinding.cd4.setSelected(false);
                this.oemFmBinding.cd5.setSelected(false);
                this.oemFmBinding.cd6.setSelected(false);
                switch (disc.range) {
                    case 1:
                        this.oemFmBinding.cd1.setSelected(true);
                        break;
                    case 2:
                        this.oemFmBinding.cd2.setSelected(true);
                        break;
                    case 3:
                        this.oemFmBinding.cd3.setSelected(true);
                        break;
                    case 4:
                        this.oemFmBinding.cd4.setSelected(true);
                        break;
                    case 5:
                        this.oemFmBinding.cd5.setSelected(true);
                        break;
                    case 6:
                        this.oemFmBinding.cd6.setSelected(true);
                        break;
                }
            } else {
                this.viewModel.cd1.set(false);
                this.viewModel.cd2.set(false);
                this.viewModel.cd3.set(false);
                this.viewModel.cd4.set(false);
                this.viewModel.cd5.set(false);
                this.viewModel.cd6.set(false);
                this.viewModel.cdMode.set("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.viewModel.cd1.set(false);
            this.viewModel.cd2.set(false);
            this.viewModel.cd3.set(false);
            this.viewModel.cd4.set(false);
            this.viewModel.cd5.set(false);
            this.viewModel.cd6.set(false);
            this.viewModel.cdMode.set("");
        }
        updateAudioOff();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void update(McuStatus.ACData acData) {
        this.uiParams.setOpen(acData.isOpen);
        this.uiParams.setAutoSwitch(acData.autoSwitch);
        this.uiParams.setLoopMode(acData.loop);
        this.uiParams.setACStatus(acData.AC_Switch);
        this.uiParams.setBackMistSwitch(acData.backMistSwitch);
        this.uiParams.setFrontMistSwitch(acData.frontMistSwitch);
        this.uiParams.setWindSpeed((int) acData.speed);
        try {
            this.tempUnit = PowerManagerApp.getSettingsInt(KeyConfig.TempUnit);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (acData.leftTmp == 0.0f) {
            this.uiParams.setLeftTempStr("LO");
        } else if (acData.leftTmp == -1.0f) {
            this.uiParams.setLeftTempStr("HI");
        } else if (this.tempUnit == 1) {
            this.uiParams.setLeftTempStr(String.valueOf(tempToF(acData.leftTmp)) + "°F");
        } else {
            this.uiParams.setLeftTempStr(String.valueOf(acData.leftTmp) + "℃");
        }
        if (acData.rightTmp == 0.0f) {
            this.uiParams.setRightTempStr("LO");
        } else if (acData.rightTmp == -1.0f) {
            this.uiParams.setRightTempStr("HI");
        } else if (this.tempUnit == 1) {
            this.uiParams.setRightTempStr(String.valueOf(tempToF(acData.rightTmp)) + "°F");
        } else {
            this.uiParams.setRightTempStr(String.valueOf(acData.rightTmp) + "℃");
        }
        this.uiParams.setLoopMode(acData.loop);
        boolean above = acData.isOpen(8);
        boolean front = acData.isOpen(4);
        boolean below = acData.isOpen(2);
        if (!above && !front && !below) {
            this.uiParams.setBlowingMode(0);
        } else if (!above && front && !below) {
            this.uiParams.setBlowingMode(1);
        } else if (!above && !front && below) {
            this.uiParams.setBlowingMode(2);
        } else if (above && !front && below) {
            this.uiParams.setBlowingMode(3);
        } else if (!above && front && below) {
            this.uiParams.setBlowingMode(4);
        }
        Log.d(TAG, "blowing mode right_above " + above + " right_front " + front + " right_below " + below);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setEq() {
        try {
            McuStatus.EqData eqData = McuStatus.EqData.parseDataFromJson(PowerManagerApp.getStatusString("mcuEqData"));
            if (eqData != null) {
                Log.d(TAG, "setEq " + eqData.toString());
                this.volumeHandler.removeMessages(120);
                this.volumeHandler.sendEmptyMessageDelayed(120, 3500);
                if (eqData.changeVol.startsWith("ASL")) {
                    this.viewModel.eqMode.set(eqData.changeVol);
                } else {
                    this.viewModel.eqMode.set(eqData.changeVol + ":" + eqData.volume);
                }
                this.viewModel.eq.set(true);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void setBt() {
        try {
            McuStatus.CarBluetoothStatus carBluetoothStatus = McuStatus.CarBluetoothStatus.parseInfoFromJson(PowerManagerApp.getStatusString("mcuBluetoothStatus"));
            if (carBluetoothStatus != null) {
                Log.d(TAG, " connect " + carBluetoothStatus.isCalling + " name " + carBluetoothStatus.name + " setUp " + carBluetoothStatus.settingsInfo + " signal " + carBluetoothStatus.callSignal + " play " + carBluetoothStatus.playingMusic + " min " + carBluetoothStatus.min + " sec " + carBluetoothStatus.sec);
                if (carBluetoothStatus.isCalling) {
                    this.viewModel.btConnectInfo.set(carBluetoothStatus.name + getString(R.string.gs_phone_connected_bt_mess));
                } else {
                    this.viewModel.btConnectInfo.set(getString(R.string.gs_phone_unconnected_bt_mess));
                }
                this.viewModel.btSetUp.set(carBluetoothStatus.settingsInfo);
                this.viewModel.btSignal.set(carBluetoothStatus.callSignal);
                this.viewModel.btConnect.set(Boolean.valueOf(carBluetoothStatus.isCalling));
                this.viewModel.btPlay.set(Boolean.valueOf(carBluetoothStatus.playingMusic));
                this.viewModel.btTime.set(getFormatMMSS(carBluetoothStatus.min, carBluetoothStatus.sec));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void displayVolumeProgress() {
        this.volumeHandler.removeMessages(110);
        this.volumeHandler.sendEmptyMessageDelayed(110, 3000);
        try {
            int level = PowerManagerApp.getStatusInt("mcu_volume_level");
            boolean mute = PowerManagerApp.getStatusBoolean("mcu_volume_mute");
            Log.d(TAG, "mute: " + mute);
            this.viewModel.mute.set(mute);
            this.oemFmBinding.volumeBar.setProgress(level);
            this.viewModel.mediaVolume.set(level + "");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.viewModel.showVolume.set(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissVolumeProgress() {
        this.viewModel.showVolume.set(false);
    }

    public static int tempToF(float tmep) {
        return Math.round(((9.0f * tmep) / 5.0f) + 32.0f);
    }
}
