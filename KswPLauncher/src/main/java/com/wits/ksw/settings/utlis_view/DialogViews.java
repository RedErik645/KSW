package com.wits.ksw.settings.utlis_view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.wits.ksw.KswApplication;
import com.wits.ksw.MainActivity;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.settings.id7.bean.DevBean;
import com.wits.ksw.settings.view_adapter.ListChoseAdapter;
import com.wits.pms.ksw.OnMcuUpdateProgressListener;
import com.wits.pms.statuscontrol.McuUpdater;
import com.wits.pms.statuscontrol.WitsCommand;
import java.io.File;
import java.util.List;

public class DialogViews extends Dialog {
    private Handler dialogHandler = new Handler() {
        /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass14 */
        Intent intent_recv = new Intent("com.ksw.mcu.recv");

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    DialogViews.this.mcuProgBar.setProgress(DialogViews.this.size);
                    DialogViews.this.mcuTvPro.setText(DialogViews.this.size + "%");
                    return;
                case 1:
                    if (((double) DialogViews.this.size) < 0.5d) {
                        Log.d("FactoryMcuUpdate", "dialogHandler:handleMessage size=" + DialogViews.this.size);
                        ToastUtils.showToastShort(DialogViews.this.m_con, DialogViews.this.m_con.getString(R.string.dialog_update7));
                        DialogViews.this.dismiss();
                        return;
                    }
                    return;
                case 2:
                    DialogViews.this.dismiss();
                    return;
                case 3:
                    DialogViews.this.dialogHandler.removeMessages(3);
                    if (DialogViews.this.errorFlag == -1) {
                        this.intent_recv.putExtra("action", "ready2update");
                        this.intent_recv.putExtra("value", "NO");
                        DialogViews.this.m_con.sendBroadcast(this.intent_recv);
                        DialogViews.this.tv_prossToast.setText(DialogViews.this.m_con.getString(R.string.app_not_update));
                    } else {
                        this.intent_recv.putExtra("action", "update.end");
                        this.intent_recv.putExtra("value", "FAIL");
                        DialogViews.this.m_con.sendBroadcast(this.intent_recv);
                        DialogViews.this.tv_prossToast.setText(DialogViews.this.m_con.getString(R.string.mcu_file_corrupted));
                    }
                    DialogViews.this.dialogHandler.sendEmptyMessageDelayed(2, 2000);
                    return;
                case 4:
                    if (UiThemeUtils.isUI_GS_ID8(DialogViews.this.m_con)) {
                        Settings.System.putInt(DialogViews.this.m_con.getContentResolver(), "memory_mode_for_freedom", 1);
                    }
                    System.exit(0);
                    return;
                default:
                    return;
            }
        }
    };
    private int errorFlag = -1;
    private String fileName;
    private String logoPath = "";
    private String logoZipName = "mylogo.zip";
    private WindowManager.LayoutParams lp;
    private Context m_con;
    private ProgressBar mcuProgBar;
    private TextView mcuTvPro;
    private Boolean mcu_start;
    public int size = 0;
    private TextView tv_prossToast;
    private String updateDirPath = "";
    private String updateFilePath = "";
    private Window window;

    public DialogViews(Context context) {
        super(context);
        this.m_con = context;
        Window window2 = getWindow();
        this.window = window2;
        this.lp = window2.getAttributes();
        this.mcu_start = true;
    }

    public void qrCode(Bitmap bitmap) {
        Log.d("qrCode", "show qrCode");
        View view = LayoutInflater.from(this.m_con).inflate(R.layout.dialog_qrcode, (ViewGroup) null);
        setContentView(view);
        this.window.setGravity(17);
        view.findViewById(R.id.qr_root).setBackground(new BitmapDrawable((Resources) null, bitmap));
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 300.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 300.0f);
        this.window.setAttributes(this.lp);
        show();
    }

    public void isQuestView(String msgToast, final Handler handler) {
        setContentView(LayoutInflater.from(this.m_con).inflate(R.layout.dialog_file_list, (ViewGroup) null));
        this.window.setGravity(17);
        this.window.setSoftInputMode(2);
        ((TextView) findViewById(R.id.dlg_msg)).setText(msgToast);
        ((TextView) findViewById(R.id.dlg_ok)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass1 */

            public void onClick(View view) {
                handler.sendEmptyMessage(1);
                DialogViews.this.dismiss();
            }
        });
        ((TextView) findViewById(R.id.dlg_cancel)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass2 */

            public void onClick(View view) {
                DialogViews.this.dismiss();
            }
        });
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 200.0f);
        this.window.setAttributes(this.lp);
        show();
    }

    public void isBmwId9QuestView(String msgToast, final Handler handler) {
        setContentView(LayoutInflater.from(this.m_con).inflate(R.layout.dialog_bmw_id9_settings_restore, (ViewGroup) null));
        this.window.setGravity(17);
        this.window.setSoftInputMode(2);
        ((TextView) findViewById(R.id.dlg_msg)).setText(msgToast);
        ((TextView) findViewById(R.id.dlg_ok)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass3 */

            public void onClick(View view) {
                handler.sendEmptyMessage(1);
                DialogViews.this.dismiss();
            }
        });
        ((TextView) findViewById(R.id.dlg_cancel)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass4 */

            public void onClick(View view) {
                DialogViews.this.dismiss();
            }
        });
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 420.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 230.0f);
        this.window.setAttributes(this.lp);
        show();
    }

    public void isUpdateLogo(String msgToast, final String path) {
        Log.d("UiSelect", "updateLogo path : " + path);
        setContentView(LayoutInflater.from(this.m_con).inflate(R.layout.dialog_file_list, (ViewGroup) null));
        this.window.setGravity(17);
        this.window.setSoftInputMode(2);
        ((TextView) findViewById(R.id.dlg_msg)).setText(msgToast);
        ((TextView) findViewById(R.id.dlg_ok)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass5 */

            public void onClick(View view) {
                WitsCommand.sendCommand(1, 124, path);
                DialogViews.this.dismiss();
                ToastUtils.showToastShort(DialogViews.this.m_con, DialogViews.this.m_con.getResources().getString(R.string.string_set_logo_over));
            }
        });
        ((TextView) findViewById(R.id.dlg_cancel)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass6 */

            public void onClick(View view) {
                DialogViews.this.dismiss();
            }
        });
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 200.0f);
        this.window.setAttributes(this.lp);
        show();
    }

    public void isSelecUi(String msg, final Handler handler) {
        setContentView(LayoutInflater.from(this.m_con).inflate(R.layout.dialog_select_ui, (ViewGroup) null));
        this.window.setGravity(17);
        ((TextView) findViewById(R.id.upText_msg)).setText(msg);
        ((TextView) findViewById(R.id.dlg_ok)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass7 */

            public void onClick(View view) {
                handler.sendEmptyMessage(0);
            }
        });
        ((TextView) findViewById(R.id.dlg_cancel)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass8 */

            public void onClick(View view) {
                DialogViews.this.dismiss();
            }
        });
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 200.0f);
        this.window.setAttributes(this.lp);
        show();
    }

    public void showUpdateIng() {
        setContentView(LayoutInflater.from(this.m_con).inflate(R.layout.dialog_update_pro, (ViewGroup) null));
        this.window.setGravity(17);
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 200.0f);
        this.window.setAttributes(this.lp);
        show();
    }

    public void fileListView(String msgToast) {
        this.fileName = "factory_config.xml";
        setContentView(LayoutInflater.from(this.m_con).inflate(R.layout.dialog_file_list, (ViewGroup) null));
        this.window.setGravity(17);
        this.window.setSoftInputMode(2);
        ((TextView) findViewById(R.id.dlg_msg)).setText(msgToast);
        ((TextView) findViewById(R.id.dlg_ok)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass9 */

            public void onClick(View view) {
                DialogViews.this.updateDefXml();
                DialogViews.this.dismiss();
            }
        });
        ((TextView) findViewById(R.id.dlg_cancel)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass10 */

            public void onClick(View view) {
                DialogViews.this.dismiss();
            }
        });
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 200.0f);
        this.window.setAttributes(this.lp);
        show();
    }

    public void updateDefXml() {
        File[] itemFile;
        List<String> rootList = FileUtils.getSDPath(getContext());
        if (new File("/sdcard/ksw_files/factory_config.xml").exists()) {
            this.updateFilePath = "/sdcard/ksw_files/factory_config.xml";
        } else {
            try {
                for (String sp : rootList) {
                    File[] files = new File(sp).listFiles();
                    for (File fs : files) {
                        if (fs.isDirectory() && fs.getName().toLowerCase().equals("oem") && (itemFile = fs.listFiles()) != null && itemFile.length > 0) {
                            int length = itemFile.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                File is = itemFile[i];
                                if (this.fileName.equals(is.getName())) {
                                    this.updateFilePath = is.getAbsolutePath();
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(KswApplication.TAG, "updateDefXml: error" + e.toString());
            }
        }
        Intent intent_recv = new Intent("com.ksw.mcu.recv");
        if (TextUtils.isEmpty(this.updateFilePath)) {
            intent_recv.putExtra("action", "update.factory_config.end");
            intent_recv.putExtra("value", "FAIL");
            this.m_con.sendBroadcast(intent_recv);
            Context context = this.m_con;
            ToastUtils.showToastShort(context, context.getString(R.string.dialog_update2));
            return;
        }
        Log.d("FactoryUpdate", "====factory path======:" + this.updateFilePath);
        WitsCommand.sendCommand(1, 200, this.updateFilePath);
        intent_recv.putExtra("action", "update.factory_config.end");
        intent_recv.putExtra("value", "SUCCESS");
        this.m_con.sendBroadcast(intent_recv);
        MainActivity.mainActivity.finish();
        Intent intent = new Intent();
        intent.setClass(KswApplication.appContext, MainActivity.class);
        intent.addFlags(268435456);
        KswApplication.appContext.startActivity(intent);
        if (UiThemeUtils.isUI_GS_ID8(this.m_con)) {
            Settings.System.putInt(this.m_con.getContentResolver(), "memory_mode_for_freedom", 1);
        }
        System.exit(0);
    }

    public void inputLogoFile(String msgToast) {
        setContentView(LayoutInflater.from(this.m_con).inflate(R.layout.dialog_file_list, (ViewGroup) null));
        this.window.setGravity(17);
        this.window.setSoftInputMode(2);
        ((TextView) findViewById(R.id.dlg_msg)).setText(msgToast);
        ((TextView) findViewById(R.id.dlg_ok)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass11 */

            public void onClick(View view) {
                DialogViews.this.updateLogoFile();
                DialogViews.this.dismiss();
            }
        });
        ((TextView) findViewById(R.id.dlg_cancel)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass12 */

            public void onClick(View view) {
                DialogViews.this.dismiss();
            }
        });
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 200.0f);
        this.window.setAttributes(this.lp);
        show();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateLogoFile() {
        List<String> rootList = FileUtils.getSDPath(getContext());
        if (Build.VERSION.RELEASE.equals("12")) {
            this.logoZipName = "mylogo12.zip";
        } else if (Build.VERSION.RELEASE.equals("13")) {
            this.logoZipName = "mylogo13.zip";
        }
        for (String sp : rootList) {
            File[] files = new File(sp).listFiles();
            if (files != null) {
                for (File fs : files) {
                    if (fs.getName().toLowerCase().equals(this.logoZipName)) {
                        this.logoPath = fs.getAbsolutePath();
                    }
                }
            }
        }
        if (TextUtils.isEmpty(this.logoPath)) {
            Context context = this.m_con;
            ToastUtils.showToastShort(context, context.getString(R.string.text_logo_input_non));
            return;
        }
        Log.d("logoUpdate", "====logo path======:" + this.logoPath);
        try {
            if (FileUtils.copyFile(this.logoPath, this.m_con)) {
                Context context2 = this.m_con;
                ToastUtils.showToastShort(context2, context2.getResources().getString(R.string.text_logo_input_ok));
            }
            this.dialogHandler.sendEmptyMessageDelayed(4, 1000);
        } catch (Exception e) {
            Log.d("logoUpdate", e.getLocalizedMessage());
        }
    }

    public void setMcuView() {
        View view = LayoutInflater.from(this.m_con).inflate(R.layout.dialog_mcu_upinfo, (ViewGroup) null);
        setContentView(view);
        this.window.setGravity(17);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.tv_prossToast = (TextView) view.findViewById(R.id.tv_prossToast);
        this.window.setSoftInputMode(2);
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 230.0f);
        this.window.setAttributes(this.lp);
        this.mcuProgBar = (ProgressBar) findViewById(R.id.mcuProgBar);
        this.mcuTvPro = (TextView) findViewById(R.id.mcuTvPro);
        this.mcuProgBar.setMax(100);
        show();
        this.dialogHandler.sendEmptyMessageDelayed(1, 5000);
        final Intent intent_recv = new Intent("com.ksw.mcu.recv");
        try {
            McuUpdater.registerMcuUpdateListener(new OnMcuUpdateProgressListener.Stub() {
                /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass13 */

                @Override // com.wits.pms.ksw.OnMcuUpdateProgressListener
                public void success() throws RemoteException {
                    intent_recv.putExtra("action", "update.end");
                    intent_recv.putExtra("value", "SUCCESS");
                    DialogViews.this.m_con.sendBroadcast(intent_recv);
                    Log.d("FactoryMcuUpdate", "McuUpdater:success");
                    DialogViews.this.dismiss();
                    ToastUtils.showToastShort(DialogViews.this.m_con, DialogViews.this.m_con.getString(R.string.dialog_update3));
                }

                @Override // com.wits.pms.ksw.OnMcuUpdateProgressListener
                public void failed(int i) throws RemoteException {
                    DialogViews.this.errorFlag = i;
                    Log.d("FactoryMcuUpdate", "McuUpdater:failed  errorFlag=" + DialogViews.this.errorFlag);
                    DialogViews.this.dialogHandler.removeMessages(1);
                    DialogViews.this.dialogHandler.sendEmptyMessage(3);
                }

                @Override // com.wits.pms.ksw.OnMcuUpdateProgressListener
                public void progress(int i) throws RemoteException {
                    Log.d("FactoryMcuUpdate", "McuUpdater:progress i=" + i);
                    DialogViews.this.size = i;
                    DialogViews.this.dialogHandler.sendEmptyMessage(0);
                    if (DialogViews.this.mcu_start.booleanValue()) {
                        intent_recv.putExtra("action", "ready2update");
                        intent_recv.putExtra("value", "YES");
                        intent_recv.putExtra("action", "update.start");
                        DialogViews.this.m_con.sendBroadcast(intent_recv);
                        DialogViews.this.mcu_start = false;
                    }
                }
            });
            McuUpdater.mcuUpdate(this.updateFilePath);
        } catch (Exception e) {
            dismiss();
        }
    }

    public void updateMcu(String msgToast) {
        File[] itemFile;
        this.fileName = "ksw_mcu.bin";
        for (String sp : FileUtils.getSDPath(getContext())) {
            File file = new File(sp);
            Log.i("FileUtil", " file.read = " + file.canRead());
            File[] files = file.listFiles();
            int length = files.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                File fs = files[i];
                if (this.fileName.equals(fs.getName().toLowerCase())) {
                    this.updateFilePath = fs.getAbsolutePath();
                    break;
                }
                if (fs.isDirectory() && (itemFile = fs.listFiles()) != null && itemFile.length > 0) {
                    int length2 = itemFile.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        File is = itemFile[i2];
                        if (this.fileName.equals(is.getName().toLowerCase())) {
                            this.updateFilePath = is.getAbsolutePath();
                            break;
                        }
                        i2++;
                    }
                }
                i++;
            }
        }
        if (new File("/sdcard/ksw_mcu.bin").exists()) {
            this.updateFilePath = "/sdcard/ksw_mcu.bin";
        }
        if (TextUtils.isEmpty(this.updateFilePath)) {
            Context context = this.m_con;
            ToastUtils.showToastShort(context, context.getString(R.string.dialog_update2));
            return;
        }
        setContentView(LayoutInflater.from(this.m_con).inflate(R.layout.dialog_mcu_up, (ViewGroup) null));
        this.window.setGravity(17);
        setCanceledOnTouchOutside(false);
        this.window.setSoftInputMode(2);
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 200.0f);
        this.window.setAttributes(this.lp);
        show();
        ((TextView) findViewById(R.id.dlg_msg)).setText(msgToast);
        ((TextView) findViewById(R.id.dlg_ok)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass15 */

            public void onClick(View view) {
                DialogViews.this.dismiss();
                DialogViews.this.setMcuView();
            }
        });
        ((TextView) findViewById(R.id.dlg_cancel)).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass16 */

            public void onClick(View view) {
                DialogViews.this.dismiss();
            }
        });
    }

    public void KswAPPupdateMcu(String msgToast) {
        File[] itemFile;
        this.fileName = "ksw_mcu.bin";
        List<String> rootList = FileUtils.getSDPath(getContext());
        if (!new File("/sdcard/ksw_files/ksw_mcu.bin").exists()) {
            for (String sp : rootList) {
                File file = new File(sp);
                Log.i("FileUtil", " file.read = " + file.canRead());
                File[] files = file.listFiles();
                int length = files.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    File fs = files[i];
                    if (this.fileName.equals(fs.getName().toLowerCase())) {
                        this.updateFilePath = fs.getAbsolutePath();
                        break;
                    }
                    if (fs.isDirectory() && (itemFile = fs.listFiles()) != null && itemFile.length > 0) {
                        int length2 = itemFile.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length2) {
                                break;
                            }
                            File is = itemFile[i2];
                            if (this.fileName.equals(is.getName().toLowerCase())) {
                                this.updateFilePath = is.getAbsolutePath();
                                break;
                            }
                            i2++;
                        }
                    }
                    i++;
                }
            }
        } else {
            this.updateFilePath = "/sdcard/ksw_files/ksw_mcu.bin";
        }
        if (new File("/sdcard/ksw_mcu.bin").exists()) {
            this.updateFilePath = "/sdcard/ksw_mcu.bin";
        }
        Intent intent_recv = new Intent("com.ksw.mcu.recv");
        if (TextUtils.isEmpty(this.updateFilePath)) {
            intent_recv.putExtra("action", "ready2update");
            intent_recv.putExtra("value", "NO");
            this.m_con.sendBroadcast(intent_recv);
            Context context = this.m_con;
            ToastUtils.showToastShort(context, context.getString(R.string.dialog_update2));
            return;
        }
        setMcuView();
    }

    public void listChoseApk(final List<DevBean> devBanList) {
        View view = LayoutInflater.from(this.m_con).inflate(R.layout.dialog_list_chose, (ViewGroup) null);
        setContentView(view);
        this.window.setGravity(17);
        this.window.setSoftInputMode(2);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.navi_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.m_con);
        layoutManager.setOrientation(1);
        rv.setLayoutManager(layoutManager);
        ListChoseAdapter adapter = new ListChoseAdapter(this.m_con, devBanList);
        rv.setAdapter(adapter);
        adapter.registCheckListener(new ListChoseAdapter.IrbtCheckListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass17 */

            @Override // com.wits.ksw.settings.view_adapter.ListChoseAdapter.IrbtCheckListener
            public void checkListener(int pos) {
                FileUtils.savaStringData(KeyConfig.DEF_DVRAPK, ((DevBean) devBanList.get(pos)).getPackageName());
                Log.d("DialogSava", "savPackage:" + ((DevBean) devBanList.get(pos)).getPackageName());
                DialogViews.this.dismiss();
            }
        });
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.window.setAttributes(this.lp);
        show();
    }

    public void listPlayApk(final List<DevBean> playAppList) {
        View view = LayoutInflater.from(this.m_con).inflate(R.layout.dialog_list_chose, (ViewGroup) null);
        setContentView(view);
        this.window.setGravity(17);
        this.window.setSoftInputMode(2);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.navi_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.m_con);
        layoutManager.setOrientation(1);
        rv.setLayoutManager(layoutManager);
        ListChoseAdapter adapter = new ListChoseAdapter(this.m_con, playAppList);
        rv.setAdapter(adapter);
        adapter.registCheckListener(new ListChoseAdapter.IrbtCheckListener() {
            /* class com.wits.ksw.settings.utlis_view.DialogViews.AnonymousClass18 */

            @Override // com.wits.ksw.settings.view_adapter.ListChoseAdapter.IrbtCheckListener
            public void checkListener(int pos) {
                Settings.System.putString(DialogViews.this.m_con.getContentResolver(), "defPlayApp", ((DevBean) playAppList.get(pos)).getPackageName());
                Log.d("DialogSava", "palyAPP:" + ((DevBean) playAppList.get(pos)).getPackageName());
                DialogViews.this.dismiss();
            }
        });
        this.lp.x = 10;
        this.lp.y = 10;
        this.lp.width = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.lp.height = UtilsInfo.dip2px(this.m_con, 400.0f);
        this.window.setAttributes(this.lp);
        show();
    }
}
