package com.wits.ksw.settings.benz_mbux_2021.layout;

import android.content.Context;
import android.database.ContentObserver;
import android.databinding.DataBindingUtil;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BenzMbuxSettingsSystemBrightnessLayoutBinding;
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.BrightnessUtils;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import java.text.NumberFormat;

public class BenzMbuxSettingsSystemBrightnessLay extends RelativeLayout implements View.OnClickListener, BenzMbuxProgressBar.OnValueChangeListener, BenzMbuxProgressBar.OnTouchChangeListener {
    private final String TAG = "BenzMbuxSettingsSystemBrightnessLay";
    private int beiguangValue;
    private Context context;
    private int[] imageButtonId = {R.id.mbux_settings_brightness_sub_btn, R.id.mbux_settings_brightness_add_btn};
    private Handler mBackgroundHandler;
    private BenzMbuxSettingsSystemBrightnessLayoutBinding mBinding;
    private BrightnessObserver mBrightnessObserver;
    private int mMaxBrightness = 255;
    private int mMinBrightness = 10;
    private final Runnable mUpdateSliderRunnable = new Runnable() {
        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemBrightnessLay.AnonymousClass3 */

        public void run() {
            int brightness = Settings.System.getInt(BenzMbuxSettingsSystemBrightnessLay.this.context.getContentResolver(), "screen_brightness", 255);
            BenzMbuxSettingsSystemBrightnessLay.this.setProgressText(brightness);
            BenzMbuxSettingsSystemBrightnessLay.this.setProgress(brightness);
        }
    };
    private BenzMbuxSettingsViewModel mViewModel;

    public BenzMbuxSettingsSystemBrightnessLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsSystemBrightnessLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_system_brightness_layout, null, false);
        this.mBinding.getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BenzMbuxSettingsViewModel instance = BenzMbuxSettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        addView(this.mBinding.getRoot());
        initView();
        initData();
    }

    private void initView() {
        try {
            this.mBinding.mbuxSettingsBrightnessSeekbar.setOnValueChangeListener(this);
            this.mBinding.mbuxSettingsBrightnessSeekbar.setOnTouchChangeListener(this);
            int i = 0;
            while (true) {
                int[] iArr = this.imageButtonId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnClickListener(this);
                    findViewById(this.imageButtonId[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemBrightnessLay.AnonymousClass1 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BenzMbuxSettingsSystemBrightnessLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                            if (event.getAction() != 1 || v.isFocused()) {
                                return false;
                            }
                            v.requestFocus();
                            return false;
                        }
                    });
                    i++;
                } else {
                    this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemBrightnessLay.AnonymousClass2 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BenzMbuxSettingsSystemBrightnessLay", "onGlobalFocusChanged: " + BenzMbuxSettingsSystemBrightnessLay.this.mBinding.mbuxSettingsBrightnessLay.hasFocus());
                            if (BenzMbuxSettingsSystemBrightnessLay.this.mBinding.mbuxSettingsBrightnessLay.hasFocus()) {
                                BenzMbuxSettingsSystemBrightnessLay.this.mViewModel.systemBgShow.set(false);
                            }
                        }
                    });
                    return;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void initData() {
        try {
            this.mBackgroundHandler = new Handler(Looper.getMainLooper());
            BrightnessObserver brightnessObserver = new BrightnessObserver(new Handler());
            this.mBrightnessObserver = brightnessObserver;
            brightnessObserver.startObserving();
            int i = Settings.System.getInt(this.context.getContentResolver(), "screen_brightness", 255);
            this.beiguangValue = i;
            setProgress(i);
            setProgressText(this.beiguangValue);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void setSystemBrightness(int brightness) {
        Log.i("BenzMbuxSettingsSystemBrightnessLay", " setSystemBrightness=" + brightness);
        Settings.System.putInt(this.context.getContentResolver(), "screen_brightness", brightness);
    }

    public void setBrightnessValueBg(Context context2, int key) {
        try {
            Class.forName("android.hardware.display.DisplayManager").getMethod("setTemporaryBrightness", Integer.TYPE).invoke((DisplayManager) context2.getSystemService("display"), Integer.valueOf(key));
            Log.i("BenzMbuxSettingsSystemBrightnessLay", "setBrightnessValueBg: " + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mbux_settings_brightness_add_btn /*{ENCODED_INT: 2131232029}*/:
                this.mBinding.mbuxSettingsBrightnessSeekbar.setValue(this.mBinding.mbuxSettingsBrightnessSeekbar.getValue() + 1);
                return;
            case R.id.mbux_settings_brightness_sub_btn /*{ENCODED_INT: 2131232032}*/:
                this.mBinding.mbuxSettingsBrightnessSeekbar.setValue(this.mBinding.mbuxSettingsBrightnessSeekbar.getValue() - 1);
                return;
            default:
                return;
        }
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnValueChangeListener
    public void onValueChange(BenzMbuxProgressBar progressBar, int value, float progress) {
        int temp = BrightnessUtils.convertGammaToLinearBmwId8(value, 10, 255);
        Log.i("BenzMbuxSettingsSystemBrightnessLay", " value " + temp);
        setBrightnessValueBg(this.context, temp);
        setSystemBrightness(temp);
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnTouchChangeListener
    public void onStartTrackingTouch(BenzMbuxProgressBar progressBar) {
        this.mViewModel.systemBgShow.set(false);
        progressBar.requestFocus();
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnTouchChangeListener
    public void onStopTrackingTouch(BenzMbuxProgressBar progressBar) {
    }

    /* access modifiers changed from: private */
    public class BrightnessObserver extends ContentObserver {
        private Uri BRIGHTNESS_URI = Settings.System.getUriFor("screen_brightness");

        public BrightnessObserver(Handler handler) {
            super(handler);
        }

        public void startObserving() {
            BenzMbuxSettingsSystemBrightnessLay.this.context.getContentResolver().unregisterContentObserver(this);
            BenzMbuxSettingsSystemBrightnessLay.this.context.getContentResolver().registerContentObserver(this.BRIGHTNESS_URI, false, this);
            Log.i("BenzMbuxSettingsSystemBrightnessLay", "startObserving: registerContentObserver uri=" + this.BRIGHTNESS_URI);
        }

        public void stopObserving() {
            BenzMbuxSettingsSystemBrightnessLay.this.context.getContentResolver().unregisterContentObserver(this);
            Log.i("BenzMbuxSettingsSystemBrightnessLay", "stopObserving: unregisterContentObserver");
        }

        public void onChange(boolean selfChange) {
            onChange(selfChange, null);
        }

        public void onChange(boolean selfChange, Uri uri) {
            if (!selfChange && this.BRIGHTNESS_URI.equals(uri)) {
                Log.i("BenzMbuxSettingsSystemBrightnessLay", "onChange: " + uri);
                BenzMbuxSettingsSystemBrightnessLay.this.mBackgroundHandler.post(BenzMbuxSettingsSystemBrightnessLay.this.mUpdateSliderRunnable);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setProgressText(int progress) {
        int value = BrightnessUtils.convertLinearToGammaBmwId8(progress, this.mMinBrightness, this.mMaxBrightness);
        double b = BrightnessUtils.getPercentage((double) value, 0, 100);
        Log.i("BenzMbuxSettingsSystemBrightnessLay", "setProgressText run: brightness=" + progress + " : mMinBrightness=" + this.mMinBrightness + " mMaxBrightness=" + this.mMaxBrightness + " value=" + value + " b=" + b + " aaa=" + NumberFormat.getPercentInstance().format(b));
        this.mBinding.mbuxSettingsBrightnessText.setText("" + ((int) Math.round(100.0d * b)));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setProgress(int brightness) {
        int value = BrightnessUtils.convertLinearToGammaBmwId8(brightness, this.mMinBrightness, this.mMaxBrightness);
        double b = BrightnessUtils.getPercentage((double) value, 0, 100);
        Log.i("BenzMbuxSettingsSystemBrightnessLay", "run: brightness=" + brightness + " : mMinBrightness=" + this.mMinBrightness + " mMaxBrightness=" + this.mMaxBrightness + " value=" + value + " b=" + b + " aaa=" + NumberFormat.getPercentInstance().format(b));
        this.mBinding.mbuxSettingsBrightnessSeekbar.setValue(value);
    }
}
