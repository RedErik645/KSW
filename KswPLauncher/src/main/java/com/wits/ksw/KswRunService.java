package com.wits.ksw;

import android.app.Service;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.model.McuImpl;
import com.wits.ksw.launcher.model.MediaImpl;
import com.wits.ksw.launcher.utils.ExceptionPrint;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.ICmdListener;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.McuStatus;
import com.wits.pms.statuscontrol.MusicStatus;
import com.wits.pms.statuscontrol.PowerManagerApp;
import com.wits.pms.statuscontrol.VideoStatus;
import com.wits.pms.statuscontrol.WitsStatus;

public class KswRunService extends Service {
    private static final String TAG = KswRunService.class.getName();
    private ContentObserver auxContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswRunService.AnonymousClass9 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int aux_state = 0;
            try {
                aux_state = PowerManagerApp.getSettingsInt("AUX_Type");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(KswRunService.TAG, "onChange: aux_state " + aux_state);
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };
    private ICmdListener cmdListener = new ICmdListener.Stub() {
        /* class com.wits.ksw.KswRunService.AnonymousClass3 */

        @Override // com.wits.pms.ICmdListener
        public boolean handleCommand(String s) throws RemoteException {
            return false;
        }

        @Override // com.wits.pms.ICmdListener
        public void updateStatusInfo(String mcuMssage) throws RemoteException {
            if (TextUtils.isEmpty(mcuMssage)) {
                Log.e(KswRunService.TAG, "updateStatusInfo: mcuMssage is null");
                return;
            }
            WitsStatus status1 = WitsStatus.getWitsStatusFormJson(mcuMssage);
            if (status1 == null) {
                Log.e(KswRunService.TAG, "updateStatusInfo: WitsStatus is null");
                return;
            }
            Log.i(KswRunService.TAG, "updateStatusInfo: WitsStatus:" + status1.type + " , type : " + status1.jsonArg);
            switch (status1.getType()) {
                case 5:
                    Log.i(KswRunService.TAG, "updateStatusInfo: TYPE_MCU_STATUS");
                    KswRunService.this.handleCarinfo(McuStatus.getStatusFromJson(status1.jsonArg), 0);
                    return;
                case 21:
                    Log.i(KswRunService.TAG, "updateStatusInfo: TYPE_MUSIC_STATUS");
                    MusicStatus musicStatus = MusicStatus.getStatusFromJson(status1.jsonArg);
                    if (musicStatus == null) {
                        Log.e(KswRunService.TAG, "updateStatusInfo: MusicStatus is null");
                        return;
                    }
                    int postion = musicStatus.position;
                    String path = musicStatus.path;
                    MediaImpl.getInstance().setMusicPlayStatus(musicStatus.isPlay());
                    MediaImpl.getInstance().handleMediaPlaySeekbarAndCurrentime(postion);
                    MediaImpl.getInstance().handleMediaInfo(path);
                    return;
                case 22:
                    Log.e(KswRunService.TAG, "updateStatusInfo: TYPE_VIDEO_STATUS json : " + status1.jsonArg);
                    VideoStatus videoStatus = VideoStatus.getStatusFromJson(status1.jsonArg);
                    if (TextUtils.isEmpty(videoStatus.getPath())) {
                        Log.i(KswRunService.TAG, "updateStatusInfo: videoStatus getPath == null");
                        return;
                    } else if (UiThemeUtils.isUI_GS_ID8(KswApplication.appContext) || UiThemeUtils.isUI_PEMP_ID8(KswApplication.appContext)) {
                        MediaImpl.getInstance().handleVideoInfoSetPlayStatus(videoStatus, videoStatus.getPath());
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    };
    private ContentObserver dtvContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswRunService.AnonymousClass10 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int dtv_state = 0;
            try {
                dtv_state = PowerManagerApp.getSettingsInt("DTV_Type");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(KswRunService.TAG, "onChange: dtv_state " + dtv_state);
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };
    private ContentObserver dvrContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswRunService.AnonymousClass12 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int dvr_state = 0;
            try {
                dvr_state = PowerManagerApp.getSettingsInt("DVR_Type");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(KswRunService.TAG, "onChange: dvr_state " + dvr_state);
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };
    private ContentObserver ecarContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswRunService.AnonymousClass6 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int ecar_state = 0;
            try {
                ecar_state = PowerManagerApp.getSettingsInt(KeyConfig.E_CAR);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(KswRunService.TAG, "onChange: ecar_state " + ecar_state);
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };
    private ContentObserver eqContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswRunService.AnonymousClass7 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int eq_state = 0;
            try {
                eq_state = PowerManagerApp.getSettingsInt(KeyConfig.EQ_APP);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(KswRunService.TAG, "onChange: eq_state " + eq_state);
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };
    private ContentObserver frontContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswRunService.AnonymousClass11 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int front_state = 0;
            try {
                front_state = PowerManagerApp.getSettingsInt("Front_view_camera");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(KswRunService.TAG, "onChange: front_state " + front_state);
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };
    private ContentObserver googleContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswRunService.AnonymousClass5 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int google_state = 0;
            try {
                google_state = PowerManagerApp.getSettingsInt(KeyConfig.GOOGLE_APP);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(KswRunService.TAG, "onChange: google_state " + google_state);
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };
    private IContentObserver.Stub musicContentObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.KswRunService.AnonymousClass2 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            if (!UiThemeUtils.isBMW_ID8_UI(KswRunService.this) && !UiThemeUtils.isUI_GS_ID8(KswRunService.this) && !UiThemeUtils.isUI_PEMP_ID8(KswRunService.this)) {
                try {
                    String path = PowerManagerApp.getManager().getStatusString("path");
                    Log.i(KswRunService.TAG, "musicContentObserver onChange: " + path);
                    MediaImpl.getInstance().handleMediaInfo(path);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(KswRunService.TAG, "musicContentObserver: " + e.getMessage());
                }
            }
        }
    };
    private ContentObserver txzContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswRunService.AnonymousClass4 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int txz_state = 0;
            try {
                txz_state = PowerManagerApp.getSettingsInt(KeyConfig.TXZ);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(KswRunService.TAG, "onChange: txz_state " + txz_state);
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };
    private ContentObserver weatherContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswRunService.AnonymousClass8 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int weather_state = 0;
            try {
                weather_state = PowerManagerApp.getSettingsInt(KeyConfig.GLOBAL_WEATHER_APP);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(KswRunService.TAG, "onChange: weather_state " + weather_state);
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };

    class KswMcuBinder extends Binder {
        KswMcuBinder() {
        }

        public KswRunService getService() {
            return KswRunService.this;
        }
    }

    public IBinder onBind(Intent intent) {
        return new KswMcuBinder();
    }

    public void onCreate() {
        super.onCreate();
        String str = TAG;
        Log.i(str, "onCreate: MCU服务已启动   -----  ");
        registerMusicPlayCurrentTime();
        getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.TXZ), false, this.txzContentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.GOOGLE_APP), false, this.googleContentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.E_CAR), false, this.ecarContentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.EQ_APP), false, this.eqContentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.GLOBAL_WEATHER_APP), false, this.weatherContentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor("AUX_Type"), false, this.auxContentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor("DTV_Type"), false, this.dtvContentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor("Front_view_camera"), false, this.frontContentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor("DVR_Type"), false, this.dvrContentObserver);
        Log.i(str, "onCreate: registerMusicPlayCurrentTime");
        PowerManagerApp.registerICmdListener(this.cmdListener);
        PowerManagerApp.registerIContentObserver("mcuJson", new IContentObserver.Stub() {
            /* class com.wits.ksw.KswRunService.AnonymousClass1 */
            long time;

            @Override // com.wits.pms.IContentObserver
            public void onChange() throws RemoteException {
                int delay = 0;
                if (this.time != 0) {
                    delay = (int) (System.currentTimeMillis() - this.time);
                }
                this.time = System.currentTimeMillis();
                KswRunService.this.handleCarinfo(McuStatus.getStatusFromJson(PowerManagerApp.getStatusString("mcuJson")), delay);
            }
        });
        Log.i(str, "onCreate: registerICmdListener");
    }

    private void registerMusicPlayCurrentTime() {
        try {
            PowerManagerApp.registerIContentObserver("path", this.musicContentObserver);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "registerMusicPlayCurrentTime: " + e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleCarinfo(McuStatus mcuStatus, int delay) {
        Log.i(TAG, "handleCarinfo: ");
        if (mcuStatus == null) {
            ExceptionPrint.print("handleCarinfo: McuStatus is null");
            return;
        }
        McuStatus.CarData carDatam = mcuStatus.carData;
        if (carDatam == null) {
            ExceptionPrint.print("handleCarinfo: McuStatus.CarData is null");
        } else {
            McuImpl.getInstance().setCarData(carDatam, delay);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onCreate: -------------------------------MCU服务已关闭");
        getContentResolver().unregisterContentObserver(this.txzContentObserver);
        getContentResolver().unregisterContentObserver(this.googleContentObserver);
        getContentResolver().unregisterContentObserver(this.ecarContentObserver);
        getContentResolver().unregisterContentObserver(this.eqContentObserver);
        getContentResolver().unregisterContentObserver(this.weatherContentObserver);
        getContentResolver().unregisterContentObserver(this.auxContentObserver);
        getContentResolver().unregisterContentObserver(this.dtvContentObserver);
        getContentResolver().unregisterContentObserver(this.frontContentObserver);
        getContentResolver().unregisterContentObserver(this.dvrContentObserver);
    }
}
