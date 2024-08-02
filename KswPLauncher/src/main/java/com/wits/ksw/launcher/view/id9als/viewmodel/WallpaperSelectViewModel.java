package com.wits.ksw.launcher.view.id9als.viewmodel;

import android.app.Activity;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.arch.lifecycle.ViewModel;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.blankj.utilcode.util.ImageUtils;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.WallpaperPicBean;
import com.wits.ksw.launcher.utils.DevicesUtils;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.adapter.WallpaperAdapter;
import com.wits.ksw.launcher.view.id9als.listener.WallpaperSelectDataChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class WallpaperSelectViewModel extends ViewModel {
    private static String TAG = WallpaperSelectViewModel.class.getName();
    private WallpaperSelectDataChangeListener changeListener;
    private Context context;
    BroadcastReceiver devicesReceiver = new BroadcastReceiver() {
        /* class com.wits.ksw.launcher.view.id9als.viewmodel.WallpaperSelectViewModel.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String path = intent.getData().getPath();
            Log.i(WallpaperSelectViewModel.TAG, "devicesReceiver action: " + action);
            if (!TextUtils.equals("android.intent.action.MEDIA_MOUNTED", action) || TextUtils.isEmpty(path)) {
                if (TextUtils.equals("android.intent.action.MEDIA_EJECT", action) && !TextUtils.isEmpty(path) && path.lastIndexOf("emulated") <= -1) {
                    WallpaperSelectViewModel.this.removeDevicesField(path);
                }
            } else if (path.lastIndexOf("emulated") <= -1) {
                WallpaperSelectViewModel.this.addDevicesField(path);
            }
        }
    };
    Handler handler = new Handler(Looper.getMainLooper()) {
        /* class com.wits.ksw.launcher.view.id9als.viewmodel.WallpaperSelectViewModel.AnonymousClass3 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (WallpaperSelectViewModel.this.wallpaperAdapter != null) {
                    WallpaperSelectViewModel.this.wallpaperAdapter.isUseEmpty(true);
                    WallpaperSelectViewModel.this.wallpaperAdapter.setNewData((List) msg.obj);
                }
                if (WallpaperSelectViewModel.this.changeListener != null) {
                    WallpaperSelectViewModel.this.changeListener.onWallpaperSelectDataChange();
                }
            } else if (msg.what == 1) {
                WallpaperSelectViewModel.this.dismissLoadingDialog();
            }
        }
    };
    private boolean isRegister;
    private Dialog loadDialog;
    public ObservableField<String> sdStorageField = new ObservableField<>();
    public ObservableField<String> usb1StorageField = new ObservableField<>();
    public ObservableField<String> usb2StorageField = new ObservableField<>();
    private WallpaperAdapter wallpaperAdapter;
    public ObservableInt wallpaperLeftModel = new ObservableInt(0);

    /* renamed from: lambda$XCnZWBmXrq8iB-g5FalIGaxG-Nk  reason: not valid java name */
    public static /* synthetic */ File m4lambda$XCnZWBmXrq8iBg5FalIGaxGNk(String str) {
        return new File(str);
    }

    public void initData(Context context2, WallpaperAdapter wallpaperAdapter2, boolean isHasAllDevices) {
        this.context = context2;
        this.wallpaperAdapter = wallpaperAdapter2;
        if (!isHasAllDevices) {
            this.wallpaperLeftModel.set(Id9AlsConstants.DEVICES_MODEL_LOC);
        }
        getAllExternalPath();
        if (!this.isRegister) {
            this.isRegister = true;
            registerKswBroadcastReceiver();
        }
    }

    public void setWallpaperSelectDataChangeListener(WallpaperSelectDataChangeListener changeListener2) {
        this.changeListener = changeListener2;
    }

    public void initData(Context context2) {
        this.context = context2;
    }

    private void registerKswBroadcastReceiver() {
        IntentFilter iFilterFile = new IntentFilter();
        iFilterFile.addAction("android.intent.action.MEDIA_EJECT");
        iFilterFile.addAction("android.intent.action.MEDIA_MOUNTED");
        iFilterFile.addDataScheme("file");
        iFilterFile.setPriority(Integer.MAX_VALUE);
        this.context.registerReceiver(this.devicesReceiver, iFilterFile);
    }

    public void onActivityDestroy() {
        Context context2;
        try {
            Log.i(TAG, "onActivityDestroy");
            if (this.isRegister && (context2 = this.context) != null) {
                context2.unregisterReceiver(this.devicesReceiver);
                this.isRegister = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setWallpaperPic(int drawableId) {
        if (drawableId > 0 && this.context != null) {
            showLoadingDialog();
            new Thread(new Runnable(drawableId) {
                /* class com.wits.ksw.launcher.view.id9als.viewmodel.$$Lambda$WallpaperSelectViewModel$gKn46cqO395ocZbC9ZaflEv29fM */
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WallpaperSelectViewModel.this.lambda$setWallpaperPic$0$WallpaperSelectViewModel(this.f$1);
                }
            }).start();
        }
    }

    public /* synthetic */ void lambda$setWallpaperPic$0$WallpaperSelectViewModel(int drawableId) {
        try {
            WallpaperManager.getInstance(this.context).setResource(drawableId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.handler.sendEmptyMessage(1);
            throw th;
        }
        this.handler.sendEmptyMessage(1);
    }

    public void setWallpaperPic(String picPath) {
        Log.i(TAG, "setWallpaperPic: " + picPath);
        if (DevicesUtils.isPathExist(picPath) && this.context != null) {
            showLoadingDialog();
            new Thread(new Runnable(picPath) {
                /* class com.wits.ksw.launcher.view.id9als.viewmodel.$$Lambda$WallpaperSelectViewModel$KGADU3Hn9s9g1BqWzrjU9zN5Rv4 */
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WallpaperSelectViewModel.this.lambda$setWallpaperPic$1$WallpaperSelectViewModel(this.f$1);
                }
            }).start();
        }
    }

    public /* synthetic */ void lambda$setWallpaperPic$1$WallpaperSelectViewModel(String picPath) {
        File srcFile = new File(picPath);
        InputStream is = null;
        Bitmap bmp = null;
        try {
            WallpaperManager manager = WallpaperManager.getInstance(this.context);
            if (Build.VERSION.SDK_INT >= 26) {
                is = Files.newInputStream(srcFile.toPath(), new OpenOption[0]);
            }
            Bitmap bmp2 = BitmapFactory.decodeFile(srcFile.getAbsolutePath());
            manager.setStream(is, new Rect(0, 0, bmp2.getWidth(), bmp2.getHeight()), false, 1);
            this.handler.sendEmptyMessage(1);
            if (bmp2 != null) {
                bmp2.recycle();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(this.context, "设置壁纸失败", 0).show();
            this.handler.sendEmptyMessage(1);
            if (0 != 0) {
                bmp.recycle();
            }
            if (0 != 0) {
                is.close();
            }
        } catch (Throwable th) {
            this.handler.sendEmptyMessage(1);
            if (0 != 0) {
                bmp.recycle();
            }
            if (0 != 0) {
                try {
                    is.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    private void getAllExternalPath() {
        List<String> list = DevicesUtils.getAllExternalSdcardPath(false);
        if (list.isEmpty()) {
            this.usb1StorageField.set("");
            this.usb2StorageField.set("");
            this.sdStorageField.set("");
            return;
        }
        for (String string : list) {
            addDevicesField(string);
        }
    }

    public void addDevicesField(String serialId) {
        if (!TextUtils.isEmpty(serialId)) {
            if (serialId.lastIndexOf("TF-KSW-") > -1) {
                this.sdStorageField.set(serialId);
            } else if (TextUtils.isEmpty(this.usb1StorageField.get())) {
                this.usb1StorageField.set(serialId);
                this.usb2StorageField.set("");
            } else {
                this.usb2StorageField.set(serialId);
            }
        }
    }

    public void removeDevicesField(String serialId) {
        WallpaperSelectDataChangeListener wallpaperSelectDataChangeListener;
        if (!TextUtils.isEmpty(serialId)) {
            boolean needJumpToAll = false;
            if (TextUtils.equals(this.sdStorageField.get(), serialId)) {
                this.sdStorageField.set("");
                if (Objects.equals(Integer.valueOf(this.wallpaperLeftModel.get()), Integer.valueOf(Id9AlsConstants.DEVICES_MODEL_SD))) {
                    needJumpToAll = true;
                }
            } else if (TextUtils.equals(this.usb1StorageField.get(), serialId)) {
                this.usb1StorageField.set("");
                if (Objects.equals(Integer.valueOf(this.wallpaperLeftModel.get()), Integer.valueOf(Id9AlsConstants.DEVICES_MODEL_USB1))) {
                    needJumpToAll = true;
                }
                String devicesId = this.usb2StorageField.get();
                if (!TextUtils.isEmpty(devicesId)) {
                    this.usb1StorageField.set(devicesId);
                    this.usb2StorageField.set("");
                }
            } else if (TextUtils.equals(this.usb2StorageField.get(), serialId)) {
                this.usb2StorageField.set("");
                if (Objects.equals(Integer.valueOf(this.wallpaperLeftModel.get()), Integer.valueOf(Id9AlsConstants.DEVICES_MODEL_USB2))) {
                    needJumpToAll = true;
                }
            }
            if (needJumpToAll && (wallpaperSelectDataChangeListener = this.changeListener) != null) {
                wallpaperSelectDataChangeListener.onDevicesRemove();
            }
        }
    }

    public static void setWallpaperLeftSelect(View view, boolean isSelect) {
        view.setSelected(isSelect);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(ContextCompat.getColor(KswApplication.appContext, isSelect ? R.color.id8_main_style_color_yellow : R.color.white));
        }
    }

    public void onWallpaperModelIvClick(int model) {
        Log.i(TAG, "onWallpaperModelIvClick model: " + model);
        this.wallpaperLeftModel.set(model);
        List<String> list = new ArrayList<>();
        if (model == Id9AlsConstants.DEVICES_MODEL_ALL) {
            list.add("/storage/emulated/0/wallpaper");
            if (!TextUtils.isEmpty(this.usb1StorageField.get())) {
                list.add(this.usb1StorageField.get() + "/wallpaper");
            }
            if (!TextUtils.isEmpty(this.usb2StorageField.get())) {
                list.add(this.usb2StorageField.get() + "/wallpaper");
            }
            if (!TextUtils.isEmpty(this.sdStorageField.get())) {
                list.add(this.sdStorageField.get() + "/wallpaper");
            }
        } else if (model == Id9AlsConstants.DEVICES_MODEL_LOC) {
            list.add("/storage/emulated/0/wallpaper");
        } else if (model == Id9AlsConstants.DEVICES_MODEL_SD) {
            if (!TextUtils.isEmpty(this.sdStorageField.get())) {
                list.add(this.sdStorageField.get() + "/wallpaper");
            }
        } else if (model == Id9AlsConstants.DEVICES_MODEL_USB1) {
            if (!TextUtils.isEmpty(this.usb1StorageField.get())) {
                list.add(this.usb1StorageField.get() + "/wallpaper");
            }
        } else if (model == Id9AlsConstants.DEVICES_MODEL_USB2 && !TextUtils.isEmpty(this.usb2StorageField.get())) {
            list.add(this.usb2StorageField.get() + "/wallpaper");
        }
        if (list.isEmpty()) {
            this.wallpaperAdapter.setNewData(new ArrayList());
            return;
        }
        this.wallpaperAdapter.isUseEmpty(false);
        this.wallpaperAdapter.replaceData(new ArrayList());
        if (isLargeFile(list)) {
            showLoadingDialog();
        }
        new Thread(new Runnable(list) {
            /* class com.wits.ksw.launcher.view.id9als.viewmodel.$$Lambda$WallpaperSelectViewModel$WnSiTo1iOLX8R17JXfSW8TOcRcs */
            public final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                WallpaperSelectViewModel.this.lambda$onWallpaperModelIvClick$2$WallpaperSelectViewModel(this.f$1);
            }
        }).start();
    }

    private boolean isLargeFile(List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        long totalFileLength = 0;
        List<String> devicesPaths = DevicesUtils.getAllExternalSdcardPath(true);
        for (String path : list) {
            if (TextUtils.isEmpty(path)) {
                Log.i(TAG, "isLargeFile path is empty");
            } else {
                boolean isExist = false;
                Iterator<String> it = devicesPaths.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (path.contains(it.next())) {
                            isExist = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!isExist) {
                    Log.i(TAG, "isLargeFile path is not exist: " + path);
                } else {
                    long length = new File(path).length();
                    totalFileLength += length;
                    Log.i(TAG, "isLargeFile length: " + length + " totalFileLength:" + totalFileLength + " file path: " + path);
                }
            }
        }
        if (totalFileLength > 314572800) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissLoadingDialog() {
        try {
            Dialog dialog = this.loadDialog;
            if (dialog != null && dialog.isShowing()) {
                this.loadDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showLoadingDialog() {
        dismissLoadingDialog();
        Activity activity = Id9AlsConstants.scanForActivity(this.context);
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            View view = LayoutInflater.from(this.context).inflate(R.layout.dialog_select_wallpapaer_loading, (ViewGroup) null, false);
            RotateAnimation animation = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
            animation.setRepeatCount(-1);
            animation.setDuration(1300);
            ((ImageView) view.findViewById(R.id.loading_iv)).startAnimation(animation);
            Dialog dialog = new Dialog(this.context);
            this.loadDialog = dialog;
            dialog.setContentView(view);
            Window window = this.loadDialog.getWindow();
            window.setBackgroundDrawableResource(17170445);
            WindowManager.LayoutParams params = window.getAttributes();
            params.height = KswUtils.dip2px(KswApplication.appContext, 130.0f);
            params.width = KswUtils.dip2px(KswApplication.appContext, 250.0f);
            params.gravity = 17;
            window.setAttributes(params);
            this.loadDialog.setCancelable(true);
            this.loadDialog.setCanceledOnTouchOutside(false);
            this.loadDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public Observable<File> listFiles(File file) {
        if (file == null || !file.exists()) {
            return Observable.empty();
        }
        if (!file.isDirectory()) {
            return Observable.just(file);
        }
        File[] files = file.listFiles();
        if (files == null) {
            return Observable.empty();
        }
        return Observable.from(files).flatMap(new Func1() {
            /* class com.wits.ksw.launcher.view.id9als.viewmodel.$$Lambda$WallpaperSelectViewModel$UMhQMcj_52gTEJucc4B3DiUX2M */

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return WallpaperSelectViewModel.this.listFiles((File) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: scanWallpaperData */
    public void lambda$onWallpaperModelIvClick$2$WallpaperSelectViewModel(List<String> list) {
        Log.i(TAG, "scanWallpaperData");
        Observable.from(list).map($$Lambda$WallpaperSelectViewModel$XCnZWBmXrq8iBg5FalIGaxGNk.INSTANCE).flatMap(new Func1() {
            /* class com.wits.ksw.launcher.view.id9als.viewmodel.$$Lambda$WallpaperSelectViewModel$UMhQMcj_52gTEJucc4B3DiUX2M */

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return WallpaperSelectViewModel.this.listFiles((File) obj);
            }
        }).filter($$Lambda$WallpaperSelectViewModel$x8n1FVPV7gWNBka_ONG38_1YJsg.INSTANCE).filter($$Lambda$WallpaperSelectViewModel$qH7R16ZNQuixnD9JDxdviJa_SsI.INSTANCE).map($$Lambda$WallpaperSelectViewModel$xXx4ct9FR3Jju_UgUf0KNOXzWvc.INSTANCE).observeOn(Schedulers.newThread()).toList().subscribe(new Observer<List<WallpaperPicBean>>() {
            /* class com.wits.ksw.launcher.view.id9als.viewmodel.WallpaperSelectViewModel.AnonymousClass2 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                WallpaperSelectViewModel.this.dismissLoadingDialogHandel();
            }

            public void onNext(List<WallpaperPicBean> s) {
                Log.i(WallpaperSelectViewModel.TAG, "scanWallpaperData s: " + s.size());
                WallpaperSelectViewModel.this.dismissLoadingDialogHandel();
                WallpaperSelectViewModel.this.sendWallpaperHandMessage(s);
            }
        });
    }

    static /* synthetic */ Boolean lambda$scanWallpaperData$3(File file) {
        return Boolean.valueOf(file.toString().toLowerCase().endsWith(".png") || file.toString().toLowerCase().endsWith(".jpg") || file.toString().toLowerCase().endsWith(".jpeg") || file.toString().toLowerCase().endsWith(".webp") || file.toString().toLowerCase().endsWith(".svg") || file.toString().toLowerCase().endsWith(".bmp"));
    }

    static /* synthetic */ Boolean lambda$scanWallpaperData$4(File file) {
        int[] size = ImageUtils.getSize(file);
        boolean z = false;
        if (size[0] == 0 || size[1] == 0) {
            return false;
        }
        if (size[0] <= 3000 && size[1] <= 3000) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static /* synthetic */ WallpaperPicBean lambda$scanWallpaperData$5(File childFile) {
        WallpaperPicBean mb = new WallpaperPicBean();
        String fileName = childFile.getName();
        mb.setPicName(fileName);
        mb.setPath(childFile.getAbsolutePath());
        mb.setPicFormat(fileName.substring(fileName.lastIndexOf(".")));
        return mb;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendWallpaperHandMessage(List<WallpaperPicBean> list) {
        this.handler.removeMessages(0);
        Message message = new Message();
        message.obj = list;
        message.what = 0;
        this.handler.sendMessage(message);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissLoadingDialogHandel() {
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessage(1);
    }

    public void onActivityStop() {
        dismissLoadingDialogHandel();
    }
}
