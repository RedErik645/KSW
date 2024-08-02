package com.wits.ksw.settings.bmw_id9.layout;

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
import com.wits.ksw.databinding.BmwId9SettingsSystemBrightnessLayoutBinding;
import com.wits.ksw.settings.BrightnessUtils;
import com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import java.text.NumberFormat;

public class BmwId9SettingsSystemBrightnessLay extends RelativeLayout implements View.OnClickListener, BmwId9ProgressBar.OnValueChangeListener, BmwId9ProgressBar.OnTouchChangeListener {
    private final String TAG = "BmwId9SettingsSystemBrightnessLay";
    private int beiguangValue;
    private Context context;
    private int[] imageButtonId = {R.id.bmw_id9_settings_brightness_sub_btn, R.id.bmw_id9_settings_brightness_add_btn};
    private Handler mBackgroundHandler;
    private BmwId9SettingsSystemBrightnessLayoutBinding mBinding;
    private BrightnessObserver mBrightnessObserver;
    private int mMaxBrightness = 255;
    private int mMinBrightness = 10;
    private final Runnable mUpdateSliderRunnable = new Runnable() {
        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemBrightnessLay.AnonymousClass3 */

        public void run() {
            int brightness = Settings.System.getInt(BmwId9SettingsSystemBrightnessLay.this.context.getContentResolver(), "screen_brightness", 255);
            BmwId9SettingsSystemBrightnessLay.this.setProgressText(brightness);
            BmwId9SettingsSystemBrightnessLay.this.setProgress(brightness);
        }
    };
    private BmwId9SettingsViewModel mViewModel;

    public BmwId9SettingsSystemBrightnessLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BmwId9SettingsSystemBrightnessLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.bmw_id9_settings_system_brightness_layout, null, false);
        this.mBinding.getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BmwId9SettingsViewModel instance = BmwId9SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        addView(this.mBinding.getRoot());
        initView();
        initData();
    }

    private void initView() {
        try {
            this.mBinding.bmwId9SettingsBrightnessSeekbar.setOnValueChangeListener(this);
            this.mBinding.bmwId9SettingsBrightnessSeekbar.setOnTouchChangeListener(this);
            int i = 0;
            while (true) {
                int[] iArr = this.imageButtonId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnClickListener(this);
                    findViewById(this.imageButtonId[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemBrightnessLay.AnonymousClass1 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BmwId9SettingsSystemBrightnessLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
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
                        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemBrightnessLay.AnonymousClass2 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BmwId9SettingsSystemBrightnessLay", "onGlobalFocusChanged: " + BmwId9SettingsSystemBrightnessLay.this.mBinding.bmwId9SettingsBrightnessLay.hasFocus());
                            if (BmwId9SettingsSystemBrightnessLay.this.mBinding.bmwId9SettingsBrightnessLay.hasFocus()) {
                                BmwId9SettingsSystemBrightnessLay.this.mViewModel.systemBgShow.set(false);
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
        Log.i("BmwId9SettingsSystemBrightnessLay", " setSystemBrightness=" + brightness);
        Settings.System.putInt(this.context.getContentResolver(), "screen_brightness", brightness);
    }

    public void setBrightnessValueBg(Context context2, int key) {
        try {
            Class.forName("android.hardware.display.DisplayManager").getMethod("setTemporaryBrightness", Integer.TYPE).invoke((DisplayManager) context2.getSystemService("display"), Integer.valueOf(key));
            Log.i("BmwId9SettingsSystemBrightnessLay", "setBrightnessValueBg: " + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmw_id9_settings_brightness_add_btn /*{ENCODED_INT: 2131231159}*/:
                this.mBinding.bmwId9SettingsBrightnessSeekbar.setValue(this.mBinding.bmwId9SettingsBrightnessSeekbar.getValue() + 1);
                return;
            case R.id.bmw_id9_settings_brightness_sub_btn /*{ENCODED_INT: 2131231162}*/:
                this.mBinding.bmwId9SettingsBrightnessSeekbar.setValue(this.mBinding.bmwId9SettingsBrightnessSeekbar.getValue() - 1);
                return;
            default:
                return;
        }
    }

    @Override // com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar.OnValueChangeListener
    public void onValueChange(BmwId9ProgressBar progressBar, int value, float progress) {
        int temp = BrightnessUtils.convertGammaToLinearBmwId8(value, 10, 255);
        Log.i("BmwId9SettingsSystemBrightnessLay", " value " + temp);
        setBrightnessValueBg(this.context, temp);
        setSystemBrightness(temp);
    }

    @Override // com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar.OnTouchChangeListener
    public void onStartTrackingTouch(BmwId9ProgressBar progressBar) {
        this.mViewModel.systemBgShow.set(false);
        progressBar.requestFocus();
    }

    @Override // com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar.OnTouchChangeListener
    public void onStopTrackingTouch(BmwId9ProgressBar progressBar) {
    }

    /* access modifiers changed from: private */
    public class BrightnessObserver extends ContentObserver {
        private Uri BRIGHTNESS_URI = Settings.System.getUriFor("screen_brightness");

        public BrightnessObserver(Handler handler) {
            super(handler);
        }

        public void startObserving() {
            BmwId9SettingsSystemBrightnessLay.this.context.getContentResolver().unregisterContentObserver(this);
            BmwId9SettingsSystemBrightnessLay.this.context.getContentResolver().registerContentObserver(this.BRIGHTNESS_URI, false, this);
            Log.i("BmwId9SettingsSystemBrightnessLay", "startObserving: registerContentObserver uri=" + this.BRIGHTNESS_URI);
        }

        public void stopObserving() {
            BmwId9SettingsSystemBrightnessLay.this.context.getContentResolver().unregisterContentObserver(this);
            Log.i("BmwId9SettingsSystemBrightnessLay", "stopObserving: unregisterContentObserver");
        }

        public void onChange(boolean selfChange) {
            onChange(selfChange, null);
        }

        public void onChange(boolean selfChange, Uri uri) {
            if (!selfChange && this.BRIGHTNESS_URI.equals(uri)) {
                Log.i("BmwId9SettingsSystemBrightnessLay", "onChange: " + uri);
                BmwId9SettingsSystemBrightnessLay.this.mBackgroundHandler.post(BmwId9SettingsSystemBrightnessLay.this.mUpdateSliderRunnable);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setProgressText(int progress) {
        int value = BrightnessUtils.convertLinearToGammaBmwId8(progress, this.mMinBrightness, this.mMaxBrightness);
        double b = BrightnessUtils.getPercentage((double) value, 0, 100);
        Log.i("BmwId9SettingsSystemBrightnessLay", "setProgressText run: brightness=" + progress + " : mMinBrightness=" + this.mMinBrightness + " mMaxBrightness=" + this.mMaxBrightness + " value=" + value + " b=" + b + " aaa=" + NumberFormat.getPercentInstance().format(b));
        this.mBinding.bmwId9SettingsBrightnessText.setText("" + ((int) Math.round(100.0d * b)));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setProgress(int brightness) {
        int value = BrightnessUtils.convertLinearToGammaBmwId8(brightness, this.mMinBrightness, this.mMaxBrightness);
        double b = BrightnessUtils.getPercentage((double) value, 0, 100);
        Log.i("BmwId9SettingsSystemBrightnessLay", "run: brightness=" + brightness + " : mMinBrightness=" + this.mMinBrightness + " mMaxBrightness=" + this.mMaxBrightness + " value=" + value + " b=" + b + " aaa=" + NumberFormat.getPercentInstance().format(b));
        this.mBinding.bmwId9SettingsBrightnessSeekbar.setValue(value);
    }
}
