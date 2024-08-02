package com.wits.ksw.launcher.view.benzntg6fy;

import android.app.Dialog;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
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
import com.blankj.utilcode.util.ImageUtils;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityNtg6v3SelectWallpaperBinding;
import com.wits.ksw.launcher.bean.WallpaperPicBean;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.launcher.utils.DevicesUtils;
import com.wits.ksw.launcher.utils.KswUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class Ntg6v3WallpaperSelectViewModel extends ViewModel {
    private static String TAG = "Ntg6v3WallpaperSelectViewModel";
    private Context context;
    Handler handler = new Handler(Looper.getMainLooper()) {
        /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3WallpaperSelectViewModel.AnonymousClass2 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (Ntg6v3WallpaperSelectViewModel.this.wallpaperAdapter != null) {
                    Ntg6v3WallpaperSelectViewModel.this.wallpaperAdapter.isUseEmpty(true);
                    Ntg6v3WallpaperSelectViewModel.this.wallpaperAdapter.setNewData((List) msg.obj);
                }
            } else if (msg.what == 1) {
                Ntg6v3WallpaperSelectViewModel.this.dismissLoadingDialog();
            }
        }
    };
    private Dialog loadDialog;
    public ObservableField<String> sdStorageField = new ObservableField<>();
    private ActivityNtg6v3SelectWallpaperBinding themeMainBinding;
    public ObservableField<String> usb1StorageField = new ObservableField<>();
    public ObservableField<String> usb2StorageField = new ObservableField<>();
    private SelectWallpaperAdapter wallpaperAdapter;
    public ObservableInt wallpaperLeftModel = new ObservableInt(0);

    /* renamed from: lambda$XCnZWBmXrq8iB-g5FalIGaxG-Nk  reason: not valid java name */
    public static /* synthetic */ File m2lambda$XCnZWBmXrq8iBg5FalIGaxGNk(String str) {
        return new File(str);
    }

    public void initData(ActivityNtg6v3SelectWallpaperBinding themeMainBinding2, Context context2, SelectWallpaperAdapter wallpaperAdapter2) {
        this.themeMainBinding = themeMainBinding2;
        this.context = context2;
        this.wallpaperAdapter = wallpaperAdapter2;
        getAllExternalPath();
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
        if (!TextUtils.isEmpty(serialId)) {
            boolean needJumpToAll = false;
            if (serialId.lastIndexOf("TF-KSW-") > -1) {
                this.sdStorageField.set("");
                if (Objects.equals(Integer.valueOf(this.wallpaperLeftModel.get()), Integer.valueOf(Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_SD))) {
                    needJumpToAll = true;
                }
            } else if (!TextUtils.isEmpty(this.usb1StorageField.get()) && Objects.equals(this.usb1StorageField.get(), serialId)) {
                this.usb1StorageField.set("");
                if (Objects.equals(Integer.valueOf(this.wallpaperLeftModel.get()), Integer.valueOf(Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB1))) {
                    needJumpToAll = true;
                }
                String devicesId = this.usb2StorageField.get();
                if (!TextUtils.isEmpty(devicesId)) {
                    this.usb1StorageField.set(devicesId);
                    this.usb2StorageField.set("");
                }
            } else if (!TextUtils.isEmpty(this.usb2StorageField.get()) && Objects.equals(this.usb2StorageField.get(), serialId)) {
                this.usb2StorageField.set("");
                if (Objects.equals(Integer.valueOf(this.wallpaperLeftModel.get()), Integer.valueOf(Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB2))) {
                    needJumpToAll = true;
                }
            }
            if (needJumpToAll) {
                this.handler.postDelayed(new Runnable() {
                    /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3WallpaperSelectViewModel$8ZL9Q68R7jWXj1uIdNh9LZldi30 */

                    public final void run() {
                        Ntg6v3WallpaperSelectViewModel.this.lambda$removeDevicesField$0$Ntg6v3WallpaperSelectViewModel();
                    }
                }, 100);
            }
        }
    }

    public /* synthetic */ void lambda$removeDevicesField$0$Ntg6v3WallpaperSelectViewModel() {
        onWallpaperModelIvClick(null, Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_ALL);
    }

    public static void setWallpaperLeftViewSelect(View view, boolean isSelect) {
        view.setSelected(isSelect);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(ContextCompat.getColor(KswApplication.appContext, isSelect ? R.color.id8_main_style_color_yellow : R.color.white));
        }
    }

    public void onWallpaperModelIvClick(View view, int model) {
        Log.i(TAG, "onWallpaperModelIvClick model: " + model);
        this.wallpaperLeftModel.set(model);
        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        }
        List<String> list = new ArrayList<>();
        if (model == Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_ALL) {
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
        } else if (model == Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_LOC) {
            list.add("/storage/emulated/0/wallpaper");
        } else if (model == Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_SD) {
            if (!TextUtils.isEmpty(this.sdStorageField.get())) {
                list.add(this.sdStorageField.get() + "/wallpaper");
            }
        } else if (model == Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB1) {
            if (!TextUtils.isEmpty(this.usb1StorageField.get())) {
                list.add(this.usb1StorageField.get() + "/wallpaper");
            }
        } else if (model == Constants.NTG6V3_THEME_WALLPAPER_DEVICES_MODEL_USB2 && !TextUtils.isEmpty(this.usb2StorageField.get())) {
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
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3WallpaperSelectViewModel$y5NQWXcWTa5JU4lpispz31GRrZA */
            public final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Ntg6v3WallpaperSelectViewModel.this.lambda$onWallpaperModelIvClick$1$Ntg6v3WallpaperSelectViewModel(this.f$1);
            }
        }).start();
    }

    private boolean isLargeFile(List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        long totalFileLength = 0;
        for (String path : list) {
            File file = new File(path);
            if (file.exists()) {
                long length = file.length();
                totalFileLength += length;
                Log.i(TAG, "isLargeFile length: " + length + " totalFileLength:" + totalFileLength + " file path: " + path);
            }
        }
        return totalFileLength > 314572800;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissLoadingDialog() {
        Dialog dialog = this.loadDialog;
        if (dialog != null && dialog.isShowing()) {
            this.loadDialog.dismiss();
        }
    }

    private void showLoadingDialog() {
        dismissLoadingDialog();
        View view = LayoutInflater.from(this.context).inflate(R.layout.ntg6v3_select_wallpapaer_dialog_loading, (ViewGroup) null, false);
        RotateAnimation animation = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
        animation.setRepeatCount(-1);
        animation.setDuration(1300);
        ((ImageView) view.findViewById(R.id.ntg6v3_loading_iv)).startAnimation(animation);
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
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3WallpaperSelectViewModel$efPGk0atmILIaCRpmJqjnKyifc4 */

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return Ntg6v3WallpaperSelectViewModel.this.listFiles((File) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: scanWallpaperData */
    public void lambda$onWallpaperModelIvClick$1$Ntg6v3WallpaperSelectViewModel(List<String> list) {
        Log.i(TAG, "scanWallpaperData");
        Observable.from(list).map($$Lambda$Ntg6v3WallpaperSelectViewModel$XCnZWBmXrq8iBg5FalIGaxGNk.INSTANCE).flatMap(new Func1() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$Ntg6v3WallpaperSelectViewModel$efPGk0atmILIaCRpmJqjnKyifc4 */

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return Ntg6v3WallpaperSelectViewModel.this.listFiles((File) obj);
            }
        }).filter($$Lambda$Ntg6v3WallpaperSelectViewModel$zWIMQsh6yW8i2kWCol1j13D7FO4.INSTANCE).filter($$Lambda$Ntg6v3WallpaperSelectViewModel$a12tuSiF3hNYcCOjJuUtq3jGUn0.INSTANCE).map($$Lambda$Ntg6v3WallpaperSelectViewModel$hCUS8GRVoEWNnni6LOAyHmGWSc.INSTANCE).observeOn(Schedulers.newThread()).toList().subscribe(new Observer<List<WallpaperPicBean>>() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3WallpaperSelectViewModel.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable e) {
                Ntg6v3WallpaperSelectViewModel.this.dismissLoadingDialogHandel();
            }

            public void onNext(List<WallpaperPicBean> s) {
                Log.i(Ntg6v3WallpaperSelectViewModel.TAG, "scanWallpaperData s: " + s.size());
                Ntg6v3WallpaperSelectViewModel.this.dismissLoadingDialogHandel();
                Ntg6v3WallpaperSelectViewModel.this.sendWallpaperHandMessage(s);
            }
        });
    }

    static /* synthetic */ Boolean lambda$scanWallpaperData$2(File file) {
        return Boolean.valueOf(file.toString().toLowerCase().endsWith(".png") || file.toString().toLowerCase().endsWith(".jpg") || file.toString().toLowerCase().endsWith(".jpeg") || file.toString().toLowerCase().endsWith(".webp") || file.toString().toLowerCase().endsWith(".svg") || file.toString().toLowerCase().endsWith(".bmp"));
    }

    static /* synthetic */ Boolean lambda$scanWallpaperData$3(File file) {
        int[] size = ImageUtils.getSize(file);
        boolean z = false;
        if (size[0] == 0 || size[1] == 0) {
            return false;
        }
        if (size[0] <= 3000 && size[1] <= 1500) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static /* synthetic */ WallpaperPicBean lambda$scanWallpaperData$4(File childFile) {
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
