package com.wits.ksw.launcher.view.audimib3fyv2;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.BuildConfig;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiMib3FyV2OneDataCls;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.model.MediaImpl;
import com.wits.ksw.launcher.utils.KeyUtils;
import com.wits.ksw.launcher.view.audimib3fy.AudiMib3FyBaseFragment;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class AudiMib3FyV2FragmentOne extends AudiMib3FyBaseFragment implements View.OnKeyListener {
    public static final String TAG = AudiMib3FyV2FragmentOne.class.getSimpleName();
    public static AudiMib3FyV2OneDataCls bindingOne;
    private AnimationDrawable animDrawBt;
    private AnimationDrawable animDrawCar;
    private AnimationDrawable animDrawMusic;
    private AnimationDrawable animDrawNavi;
    private AnimationDrawable animDrawPhonelink;
    private AnimationDrawable animDrawSet;
    private AnimationDrawable animDrawVideo;
    private AnimationDrawable animDrawWeather;
    private View.OnFocusChangeListener mFocusChangeListener = new View.OnFocusChangeListener() {
        /* class com.wits.ksw.launcher.view.audimib3fyv2.AudiMib3FyV2FragmentOne.AnonymousClass2 */

        public void onFocusChange(View v, boolean hasFocus) {
            AudiMib3FyV2FragmentOne.this.viewModel.clearLastSel();
            switch (v.getId()) {
                case R.id.bt_itemview /*{ENCODED_INT: 2131231264}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyV2FragmentOne.this.animDrawBt.isRunning()) {
                            AudiMib3FyV2FragmentOne.this.animDrawBt.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyV2FragmentOne.this.animDrawBt.isRunning()) {
                        AudiMib3FyV2FragmentOne.this.animDrawBt.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.car_itemview /*{ENCODED_INT: 2131231298}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyV2FragmentOne.this.animDrawCar.isRunning()) {
                            AudiMib3FyV2FragmentOne.this.animDrawCar.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyV2FragmentOne.this.animDrawCar.isRunning()) {
                        AudiMib3FyV2FragmentOne.this.animDrawCar.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.music_itemview /*{ENCODED_INT: 2131232151}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyV2FragmentOne.this.animDrawMusic.isRunning()) {
                            AudiMib3FyV2FragmentOne.this.animDrawMusic.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyV2FragmentOne.this.animDrawMusic.isRunning()) {
                        AudiMib3FyV2FragmentOne.this.animDrawMusic.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.navi_itemview /*{ENCODED_INT: 2131232174}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyV2FragmentOne.this.animDrawNavi.isRunning()) {
                            AudiMib3FyV2FragmentOne.this.animDrawNavi.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyV2FragmentOne.this.animDrawNavi.isRunning()) {
                        AudiMib3FyV2FragmentOne.this.animDrawNavi.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.phonelink_itemview /*{ENCODED_INT: 2131232261}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyV2FragmentOne.this.animDrawPhonelink.isRunning()) {
                            AudiMib3FyV2FragmentOne.this.animDrawPhonelink.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyV2FragmentOne.this.animDrawPhonelink.isRunning()) {
                        AudiMib3FyV2FragmentOne.this.animDrawPhonelink.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.set_itemview /*{ENCODED_INT: 2131232566}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyV2FragmentOne.this.animDrawSet.isRunning()) {
                            AudiMib3FyV2FragmentOne.this.animDrawSet.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyV2FragmentOne.this.animDrawSet.isRunning()) {
                        AudiMib3FyV2FragmentOne.this.animDrawSet.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.video_itemview /*{ENCODED_INT: 2131232848}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyV2FragmentOne.this.animDrawVideo.isRunning()) {
                            AudiMib3FyV2FragmentOne.this.animDrawVideo.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyV2FragmentOne.this.animDrawVideo.isRunning()) {
                        AudiMib3FyV2FragmentOne.this.animDrawVideo.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.weather_itemview /*{ENCODED_INT: 2131232877}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyV2FragmentOne.this.animDrawWeather.isRunning()) {
                            AudiMib3FyV2FragmentOne.this.animDrawWeather.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyV2FragmentOne.this.animDrawWeather.isRunning()) {
                        AudiMib3FyV2FragmentOne.this.animDrawWeather.stop();
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    };
    private View.OnClickListener mItemClickListener = new View.OnClickListener() {
        /* class com.wits.ksw.launcher.view.audimib3fyv2.AudiMib3FyV2FragmentOne.AnonymousClass3 */

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_itemview /*{ENCODED_INT: 2131231264}*/:
                    BcVieModel unused = AudiMib3FyV2FragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyV2FragmentOne.bindingOne.btItemview;
                    AudiMib3FyV2FragmentOne.setItemSelected(AudiMib3FyV2FragmentOne.bindingOne.btItemview);
                    AudiMib3FyV2FragmentOne.this.viewModel.openBtApp(v);
                    return;
                case R.id.car_itemview /*{ENCODED_INT: 2131231298}*/:
                    BcVieModel unused2 = AudiMib3FyV2FragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyV2FragmentOne.bindingOne.carItemview;
                    AudiMib3FyV2FragmentOne.setItemSelected(AudiMib3FyV2FragmentOne.bindingOne.carItemview);
                    AudiMib3FyV2FragmentOne.this.viewModel.openCar(v);
                    return;
                case R.id.music_itemview /*{ENCODED_INT: 2131232151}*/:
                    AudiMib3FyV2FragmentOne.setItemSelected(AudiMib3FyV2FragmentOne.bindingOne.musicItemview);
                    BcVieModel unused3 = AudiMib3FyV2FragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyV2FragmentOne.bindingOne.musicItemview;
                    AudiMib3FyV2FragmentOne.this.viewModel.openMusicMulti(v);
                    return;
                case R.id.navi_itemview /*{ENCODED_INT: 2131232174}*/:
                    BcVieModel unused4 = AudiMib3FyV2FragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyV2FragmentOne.bindingOne.naviItemview;
                    AudiMib3FyV2FragmentOne.setItemSelected(AudiMib3FyV2FragmentOne.bindingOne.naviItemview);
                    AudiMib3FyV2FragmentOne.this.viewModel.openNaviApp(v);
                    return;
                case R.id.phonelink_itemview /*{ENCODED_INT: 2131232261}*/:
                    BcVieModel unused5 = AudiMib3FyV2FragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyV2FragmentOne.bindingOne.phonelinkItemview;
                    AudiMib3FyV2FragmentOne.setItemSelected(AudiMib3FyV2FragmentOne.bindingOne.phonelinkItemview);
                    AudiMib3FyV2FragmentOne.this.viewModel.openPhoneLink2021(v);
                    return;
                case R.id.set_itemview /*{ENCODED_INT: 2131232566}*/:
                    BcVieModel unused6 = AudiMib3FyV2FragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyV2FragmentOne.bindingOne.setItemview;
                    AudiMib3FyV2FragmentOne.setItemSelected(AudiMib3FyV2FragmentOne.bindingOne.setItemview);
                    AudiMib3FyV2FragmentOne.this.viewModel.openSettings(v);
                    return;
                case R.id.video_itemview /*{ENCODED_INT: 2131232848}*/:
                    AudiMib3FyV2FragmentOne.setItemSelected(AudiMib3FyV2FragmentOne.bindingOne.videoItemview);
                    BcVieModel unused7 = AudiMib3FyV2FragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyV2FragmentOne.bindingOne.videoItemview;
                    AudiMib3FyV2FragmentOne.this.viewModel.openVideoMulti(v);
                    return;
                case R.id.weather_itemview /*{ENCODED_INT: 2131232877}*/:
                    BcVieModel unused8 = AudiMib3FyV2FragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyV2FragmentOne.bindingOne.weatherItemview;
                    AudiMib3FyV2FragmentOne.setItemSelected(AudiMib3FyV2FragmentOne.bindingOne.weatherItemview);
                    AudiMib3FyV2FragmentOne.this.viewModel.openWeatherApp(v);
                    return;
                default:
                    return;
            }
        }
    };
    private IContentObserver.Stub topAppContentObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.audimib3fyv2.AudiMib3FyV2FragmentOne.AnonymousClass4 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                String topApp = PowerManagerApp.getStatusString("topApp");
                Log.i(AudiMib3FyV2FragmentOne.TAG, "onChange: topApp=" + topApp);
                if (TextUtils.equals(topApp, BuildConfig.APPLICATION_ID)) {
                    MediaImpl.getInstance().initData();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override // com.wits.ksw.launcher.view.audimib3fy.AudiMib3FyBaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AudiMib3FyV2OneDataCls audiMib3FyV2OneDataCls = (AudiMib3FyV2OneDataCls) DataBindingUtil.inflate(inflater, R.layout.fragment_audi_mib3_fy_v2_one, null, false);
        bindingOne = audiMib3FyV2OneDataCls;
        return audiMib3FyV2OneDataCls.getRoot();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()  1111111111111");
        this.viewModel.refreshLastSel();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindingOne.setViewModel(this.viewModel);
        PowerManagerApp.registerIContentObserver("topApp", this.topAppContentObserver);
        Log.e(TAG, "isSmooth = " + isSmooth);
        bindingOne.setItemview.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.wits.ksw.launcher.view.audimib3fyv2.AudiMib3FyV2FragmentOne.AnonymousClass1 */

            public void onFocusChange(View v, boolean hasFocus) {
                Log.e(AudiMib3FyV2FragmentOne.TAG, "isSmooth 0000000000 hasFocus = " + hasFocus);
                if (hasFocus && AudiMib3FyV2FragmentOne.this.mainActivity.viewpagerAudiMib3Fy != null && AudiMib3FyV2FragmentOne.this.mainActivity.viewpagerAudiMib3Fy.getCurrentItem() != 0) {
                    AudiMib3FyV2FragmentOne.this.mainActivity.viewpagerAudiMib3Fy.setCurrentItem(0);
                }
            }
        });
        bindingOne.videoItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.videoIv.setOnClickListener(this.mItemClickListener);
        bindingOne.videoTv.setOnClickListener(this.mItemClickListener);
        bindingOne.musicItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.musicIv.setOnClickListener(this.mItemClickListener);
        bindingOne.musicTv.setOnClickListener(this.mItemClickListener);
        bindingOne.btItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.btTv.setOnClickListener(this.mItemClickListener);
        bindingOne.btIv.setOnClickListener(this.mItemClickListener);
        bindingOne.naviItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.naviTv.setOnClickListener(this.mItemClickListener);
        bindingOne.naviIv.setOnClickListener(this.mItemClickListener);
        bindingOne.phonelinkItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.phonelinkIv.setOnClickListener(this.mItemClickListener);
        bindingOne.phonelinkTv.setOnClickListener(this.mItemClickListener);
        bindingOne.carItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.carTv.setOnClickListener(this.mItemClickListener);
        bindingOne.carIv.setOnClickListener(this.mItemClickListener);
        bindingOne.weatherItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.weatherIv.setOnClickListener(this.mItemClickListener);
        bindingOne.weatherTv.setOnClickListener(this.mItemClickListener);
        bindingOne.setItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.setIv.setOnClickListener(this.mItemClickListener);
        bindingOne.setTv.setOnClickListener(this.mItemClickListener);
        bindingOne.videoItemview.setOnKeyListener(this);
        bindingOne.musicItemview.setOnKeyListener(this);
        bindingOne.btItemview.setOnKeyListener(this);
        bindingOne.naviItemview.setOnKeyListener(this);
        bindingOne.phonelinkItemview.setOnKeyListener(this);
        bindingOne.carItemview.setOnKeyListener(this);
        bindingOne.weatherItemview.setOnKeyListener(this);
        bindingOne.setItemview.setOnKeyListener(this);
        this.animDrawVideo = (AnimationDrawable) bindingOne.videoItemview.getDrawable();
        this.animDrawMusic = (AnimationDrawable) bindingOne.musicItemview.getDrawable();
        this.animDrawBt = (AnimationDrawable) bindingOne.btItemview.getDrawable();
        this.animDrawNavi = (AnimationDrawable) bindingOne.naviItemview.getDrawable();
        this.animDrawPhonelink = (AnimationDrawable) bindingOne.phonelinkItemview.getDrawable();
        this.animDrawCar = (AnimationDrawable) bindingOne.carItemview.getDrawable();
        this.animDrawWeather = (AnimationDrawable) bindingOne.weatherItemview.getDrawable();
        this.animDrawSet = (AnimationDrawable) bindingOne.setItemview.getDrawable();
        bindingOne.videoItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.musicItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.btItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.naviItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.phonelinkItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.carItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.weatherItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.setItemview.setOnFocusChangeListener(this.mFocusChangeListener);
    }

    public static void setItemSelected(View view) {
        boolean z = true;
        bindingOne.videoItemview.setSelected(bindingOne.videoItemview == view);
        bindingOne.musicItemview.setSelected(bindingOne.musicItemview == view);
        bindingOne.btItemview.setSelected(bindingOne.btItemview == view);
        bindingOne.naviItemview.setSelected(bindingOne.naviItemview == view);
        bindingOne.phonelinkItemview.setSelected(bindingOne.phonelinkItemview == view);
        bindingOne.carItemview.setSelected(bindingOne.carItemview == view);
        bindingOne.weatherItemview.setSelected(bindingOne.weatherItemview == view);
        BenzMbuxItemView benzMbuxItemView = bindingOne.setItemview;
        if (bindingOne.setItemview != view) {
            z = false;
        }
        benzMbuxItemView.setSelected(z);
    }

    public void setDefaultSelected() {
        try {
            setItemSelected(bindingOne.videoItemview);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        String str = TAG;
        Log.i(str, "Audimib3_Fy onKey: " + keyCode);
        if (keyCode == 22) {
            if (v == bindingOne.setItemview && this.mainActivity.viewpagerAudiMib3Fy.getCurrentItem() != 1) {
                this.mainActivity.viewpagerAudiMib3Fy.setCurrentItem(1);
                return true;
            } else if (v != bindingOne.naviItemview) {
                return false;
            } else {
                Log.e(str, "isAudi_mib3_Fy 22222222222");
                KeyUtils.pressKey(20);
                return true;
            }
        } else if (keyCode != 20 || v != bindingOne.setItemview || this.mainActivity.viewpagerAudiMib3Fy.getCurrentItem() == 1) {
            return false;
        } else {
            this.mainActivity.viewpagerAudiMib3Fy.setCurrentItem(1);
            return true;
        }
    }

    public void refreshLastSel(View view) {
        setItemSelected(view);
    }
}
