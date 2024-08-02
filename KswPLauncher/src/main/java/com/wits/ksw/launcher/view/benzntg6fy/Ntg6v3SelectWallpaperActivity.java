package com.wits.ksw.launcher.view.benzntg6fy;

import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.blankj.utilcode.util.FileIOUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityNtg6v3SelectWallpaperBinding;
import com.wits.ksw.launcher.bean.WallpaperPicBean;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.launcher.view.benzntg6fy.SelectWallpaperAdapter;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Ntg6v3SelectWallpaperActivity extends AppCompatActivity {
    private String TAG = "Ntg6v3SelectWallpaperActivity";
    BroadcastReceiver devicesReceiver = new BroadcastReceiver() {
        /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3SelectWallpaperActivity.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String path = intent.getData().getPath();
            if (!TextUtils.isEmpty(path)) {
                if (TextUtils.equals("android.intent.action.MEDIA_MOUNTED", action)) {
                    if (path.lastIndexOf("emulated") <= -1) {
                        Ntg6v3SelectWallpaperActivity.this.viewModel.addDevicesField(path);
                    }
                } else if (TextUtils.equals("android.intent.action.MEDIA_EJECT", action) && path.lastIndexOf("emulated") <= -1) {
                    Ntg6v3SelectWallpaperActivity.this.viewModel.removeDevicesField(path);
                }
            }
        }
    };
    private GridLayoutManager layoutManager;
    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3SelectWallpaperActivity.AnonymousClass1 */

        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() != 1) {
                return false;
            }
            v.performClick();
            return true;
        }
    };
    private Ntg6v3WallpaperSelectViewModel viewModel;
    private SelectWallpaperAdapter wallpaperAdapter;
    private ActivityNtg6v3SelectWallpaperBinding wallpaperBinding;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFull();
        setStatusBarTranslucent();
        this.wallpaperBinding = (ActivityNtg6v3SelectWallpaperBinding) DataBindingUtil.setContentView(this, R.layout.ntg6v3_select_wallpaper_activity);
        this.viewModel = (Ntg6v3WallpaperSelectViewModel) ViewModelProviders.of(this).get(Ntg6v3WallpaperSelectViewModel.class);
        this.layoutManager = new GridLayoutManager(this, 4);
        SelectWallpaperAdapter selectWallpaperAdapter = new SelectWallpaperAdapter(this.layoutManager, new ArrayList());
        this.wallpaperAdapter = selectWallpaperAdapter;
        this.viewModel.initData(this.wallpaperBinding, this, selectWallpaperAdapter);
        this.wallpaperBinding.setThemeViewModel(this.viewModel);
        this.wallpaperBinding.recyclerView.setLayoutManager(this.layoutManager);
        this.wallpaperBinding.recyclerView.setAdapter(this.wallpaperAdapter);
        this.wallpaperAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.ntg6v3_select_wallpaper_empt_view, (ViewGroup) null, false));
        this.viewModel.onWallpaperModelIvClick(null, Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_ALL);
        this.wallpaperAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3SelectWallpaperActivity$KwSITEPabWcz1SHmdu5aIOc76C0 */

            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Ntg6v3SelectWallpaperActivity.this.lambda$onCreate$0$Ntg6v3SelectWallpaperActivity(baseQuickAdapter, view, i);
            }
        });
        registerKswBroadcastReceiver();
        setViewKeyListener();
        this.wallpaperAdapter.setAdapterItemRequestFocus(new SelectWallpaperAdapter.AdapterItemRequestFocusListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3SelectWallpaperActivity$F3v1jGTM2z0Pu9Uj8LUluhEFlvA */

            @Override // com.wits.ksw.launcher.view.benzntg6fy.SelectWallpaperAdapter.AdapterItemRequestFocusListener
            public final void hasRequestFocus(boolean z) {
                Ntg6v3SelectWallpaperActivity.this.lambda$onCreate$1$Ntg6v3SelectWallpaperActivity(z);
            }
        });
        this.wallpaperBinding.recyclerView.postDelayed(new Runnable() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3SelectWallpaperActivity$GlwW0wWFAWpxVAjeOTwKGkqtztM */

            public final void run() {
                Ntg6v3SelectWallpaperActivity.this.lambda$onCreate$2$Ntg6v3SelectWallpaperActivity();
            }
        }, 100);
        setMainBg();
    }

    public /* synthetic */ void lambda$onCreate$0$Ntg6v3SelectWallpaperActivity(BaseQuickAdapter adapter, View view, int position) {
        setWallpaperPic(position);
    }

    public /* synthetic */ void lambda$onCreate$1$Ntg6v3SelectWallpaperActivity(boolean hasFocus) {
        if (!hasFocus) {
            int selectPosition = this.viewModel.wallpaperLeftModel.get();
            View selectView = this.wallpaperBinding.ntg6v3DevicesLlAll;
            if (selectPosition == Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_LOC) {
                selectView = this.wallpaperBinding.ntg6v3DevicesLlLoc;
            } else if (selectPosition == Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB1) {
                selectView = this.wallpaperBinding.ntg6v3DevicesLlUsb1;
            } else if (selectPosition == Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB2) {
                selectView = this.wallpaperBinding.ntg6v3DevicesLlUsb2;
            } else if (selectPosition == Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_SD) {
                selectView = this.wallpaperBinding.ntg6v3DevicesLlSd;
            }
            selectView.setFocusable(true);
            selectView.setFocusableInTouchMode(true);
            selectView.requestFocus();
        }
    }

    public /* synthetic */ void lambda$onCreate$2$Ntg6v3SelectWallpaperActivity() {
        this.wallpaperBinding.ntg6v3DevicesLlAll.setFocusable(true);
        this.wallpaperBinding.ntg6v3DevicesLlAll.setFocusableInTouchMode(true);
        this.wallpaperBinding.ntg6v3DevicesLlAll.requestFocus();
    }

    private void setMainBg() {
        try {
            int themeModel = PowerManagerApp.getSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL);
            int wallpaperModel = PowerManagerApp.getSettingsInt(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL);
            int bgRes = R.drawable.ntg6v3_main_bg_blue;
            if (wallpaperModel == Constants.NTG6V3_THEME_WALLPAPER_MODEL_MAP) {
                bgRes = R.drawable.ntg6v3_main_bg_map;
            } else if (themeModel == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
                bgRes = R.drawable.ntg6v3_main_bg_blue2;
            } else if (themeModel == Constants.NTG6V3_THEME_COLOR_GAY) {
                bgRes = R.drawable.ntg6v3_main_bg_gay;
            } else if (themeModel == Constants.NTG6V3_THEME_COLOR_ORANGE) {
                bgRes = R.drawable.ntg6v3_main_bg_orange;
            } else if (themeModel == Constants.NTG6V3_THEME_COLOR_YELLOW) {
                bgRes = R.drawable.ntg6v3_main_bg_yellow;
            } else if (themeModel == Constants.NTG6V3_THEME_COLOR_RED) {
                bgRes = R.drawable.ntg6v3_main_bg_red;
            } else if (themeModel == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
                bgRes = R.drawable.ntg6v3_main_bg_purple;
            } else if (themeModel == Constants.NTG6V3_THEME_COLOR_PURPLE) {
                bgRes = R.drawable.ntg6v3_main_bg_purple2;
            }
            if (wallpaperModel == Constants.NTG6V3_THEME_WALLPAPER_MODEL_CUSTOM) {
                ((RequestBuilder) Glide.with((FragmentActivity) this).load(PowerManagerApp.getSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_PATH)).error(bgRes)).into(this.wallpaperBinding.ntg6v3WallpaperBgIv);
                return;
            }
            ((RequestBuilder) Glide.with((FragmentActivity) this).load(Integer.valueOf(bgRes)).error(bgRes)).into(this.wallpaperBinding.ntg6v3WallpaperBgIv);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setFull() {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
        }
    }

    public void setStatusBarTranslucent() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
    }

    private void setWallpaperPic(int position) {
        try {
            WallpaperPicBean picBean = (WallpaperPicBean) this.wallpaperAdapter.getItem(position);
            if (picBean != null) {
                String picPath = picBean.getPath();
                Log.i(this.TAG, "setWallpaperPic: " + picPath);
                File srcFile = new File(picPath);
                if (srcFile.exists()) {
                    PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL, Constants.NTG6V3_THEME_WALLPAPER_MODEL_CUSTOM);
                    PowerManagerApp.setSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_PATH, "");
                    PowerManagerApp.setSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_PATH, picPath);
                    PowerManagerApp.setSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_ORIGINAL_PATH, picPath);
                    setMainBg();
                    this.wallpaperAdapter.notifyDataSetChanged();
                    new Thread(new Runnable(picBean, srcFile, picPath) {
                        /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3SelectWallpaperActivity$4HUC9qykz4Tfs5aCMTzq3OpuOck */
                        public final /* synthetic */ WallpaperPicBean f$1;
                        public final /* synthetic */ File f$2;
                        public final /* synthetic */ String f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            Ntg6v3SelectWallpaperActivity.this.lambda$setWallpaperPic$4$Ntg6v3SelectWallpaperActivity(this.f$1, this.f$2, this.f$3);
                        }
                    }).start();
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$setWallpaperPic$4$Ntg6v3SelectWallpaperActivity(WallpaperPicBean picBean, File srcFile, String picPath) {
        try {
            File destFile = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath(), "ntg6v3Wallpaper" + picBean.getPicFormat());
            FileIOUtils.writeFileFromIS(destFile, new FileInputStream(srcFile), new FileIOUtils.OnProgressUpdateListener(destFile, picPath) {
                /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3SelectWallpaperActivity$AJ8KWIfToj65UzcwxSbiJG4ic */
                public final /* synthetic */ File f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                @Override // com.blankj.utilcode.util.FileIOUtils.OnProgressUpdateListener
                public final void onProgressUpdate(double d) {
                    Ntg6v3SelectWallpaperActivity.this.lambda$setWallpaperPic$3$Ntg6v3SelectWallpaperActivity(this.f$1, this.f$2, d);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$setWallpaperPic$3$Ntg6v3SelectWallpaperActivity(File destFile, String picPath, double progress) {
        if (progress == 1.0d) {
            try {
                Log.i(this.TAG, "setWallpaperPic Thread: " + destFile.getAbsolutePath());
                PowerManagerApp.setSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_PATH, "");
                PowerManagerApp.setSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_PATH, destFile.getAbsolutePath());
                PowerManagerApp.setSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_ORIGINAL_PATH, picPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setViewKeyListener() {
        this.wallpaperBinding.ntg6v3DevicesLlAll.setOnTouchListener(this.touchListener);
        this.wallpaperBinding.ntg6v3DevicesLlLoc.setOnTouchListener(this.touchListener);
        this.wallpaperBinding.ntg6v3DevicesLlUsb1.setOnTouchListener(this.touchListener);
        this.wallpaperBinding.ntg6v3DevicesLlUsb2.setOnTouchListener(this.touchListener);
        this.wallpaperBinding.ntg6v3DevicesLlSd.setOnTouchListener(this.touchListener);
        this.wallpaperBinding.ntg6v3DevicesLlLoc.setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3SelectWallpaperActivity$4OTF5J4XO_ljO9SQ0W9bckPF2UY */

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return Ntg6v3SelectWallpaperActivity.this.lambda$setViewKeyListener$5$Ntg6v3SelectWallpaperActivity(view, i, keyEvent);
            }
        });
        this.wallpaperBinding.ntg6v3DevicesLlUsb1.setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3SelectWallpaperActivity$jBfb9BNs1z6a8obaGPoTUbYQk */

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return Ntg6v3SelectWallpaperActivity.this.lambda$setViewKeyListener$6$Ntg6v3SelectWallpaperActivity(view, i, keyEvent);
            }
        });
        this.wallpaperBinding.ntg6v3DevicesLlUsb2.setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3SelectWallpaperActivity$X2dmNdkVKMKxBOmT7jyeR1wY2w */

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return Ntg6v3SelectWallpaperActivity.this.lambda$setViewKeyListener$7$Ntg6v3SelectWallpaperActivity(view, i, keyEvent);
            }
        });
        this.wallpaperBinding.ntg6v3DevicesLlSd.setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3SelectWallpaperActivity$I2YRqBqt6XyftEm6isyKhOufkk */

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return Ntg6v3SelectWallpaperActivity.this.lambda$setViewKeyListener$8$Ntg6v3SelectWallpaperActivity(view, i, keyEvent);
            }
        });
    }

    public /* synthetic */ boolean lambda$setViewKeyListener$5$Ntg6v3SelectWallpaperActivity(View v, int keyCode, KeyEvent event) {
        if (keyCode != 20 || event.getAction() != 0) {
            return false;
        }
        if (!TextUtils.isEmpty(this.viewModel.usb1StorageField.get())) {
            return this.wallpaperBinding.ntg6v3DevicesLlUsb1.requestFocus();
        }
        if (!TextUtils.isEmpty(this.viewModel.usb2StorageField.get())) {
            return this.wallpaperBinding.ntg6v3DevicesLlUsb2.requestFocus();
        }
        if (!TextUtils.isEmpty(this.viewModel.sdStorageField.get())) {
            return this.wallpaperBinding.ntg6v3DevicesLlSd.requestFocus();
        }
        return true;
    }

    public /* synthetic */ boolean lambda$setViewKeyListener$6$Ntg6v3SelectWallpaperActivity(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != 0 || keyCode != 20) {
            return false;
        }
        if (!TextUtils.isEmpty(this.viewModel.usb2StorageField.get())) {
            return this.wallpaperBinding.ntg6v3DevicesLlUsb2.requestFocus();
        }
        if (!TextUtils.isEmpty(this.viewModel.sdStorageField.get())) {
            return this.wallpaperBinding.ntg6v3DevicesLlSd.requestFocus();
        }
        return true;
    }

    public /* synthetic */ boolean lambda$setViewKeyListener$7$Ntg6v3SelectWallpaperActivity(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        if (keyCode == 20) {
            if (!TextUtils.isEmpty(this.viewModel.sdStorageField.get())) {
                return this.wallpaperBinding.ntg6v3DevicesLlSd.requestFocus();
            }
            return true;
        } else if (keyCode != 19) {
            return false;
        } else {
            if (!TextUtils.isEmpty(this.viewModel.usb1StorageField.get())) {
                return this.wallpaperBinding.ntg6v3DevicesLlUsb1.requestFocus();
            }
            return this.wallpaperBinding.ntg6v3DevicesLlLoc.requestFocus();
        }
    }

    public /* synthetic */ boolean lambda$setViewKeyListener$8$Ntg6v3SelectWallpaperActivity(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        if (keyCode == 20) {
            return true;
        }
        if (keyCode != 19) {
            return false;
        }
        if (!TextUtils.isEmpty(this.viewModel.usb2StorageField.get())) {
            return this.wallpaperBinding.ntg6v3DevicesLlUsb2.requestFocus();
        }
        if (!TextUtils.isEmpty(this.viewModel.usb1StorageField.get())) {
            return this.wallpaperBinding.ntg6v3DevicesLlUsb1.requestFocus();
        }
        return this.wallpaperBinding.ntg6v3DevicesLlLoc.requestFocus();
    }

    private void registerKswBroadcastReceiver() {
        IntentFilter iFilterFile = new IntentFilter();
        iFilterFile.addAction("android.intent.action.MEDIA_EJECT");
        iFilterFile.addAction("android.intent.action.MEDIA_MOUNTED");
        iFilterFile.addDataScheme("file");
        iFilterFile.setPriority(Integer.MAX_VALUE);
        registerReceiver(this.devicesReceiver, iFilterFile);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.devicesReceiver);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        this.viewModel.onActivityStop();
    }
}
