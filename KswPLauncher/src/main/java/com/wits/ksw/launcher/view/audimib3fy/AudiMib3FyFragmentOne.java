package com.wits.ksw.launcher.view.audimib3fy;

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
import com.wits.ksw.databinding.AudiMib3FyOneDataCls;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.model.MediaImpl;
import com.wits.ksw.launcher.utils.KeyUtils;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class AudiMib3FyFragmentOne extends AudiMib3FyBaseFragment implements View.OnKeyListener {
    public static final String TAG = "AudiMib3FyFragmentOne - One";
    public static AudiMib3FyOneDataCls bindingOne;
    private AnimationDrawable animDrawApps;
    private AnimationDrawable animDrawBt;
    private AnimationDrawable animDrawCar;
    private AnimationDrawable animDrawMusic;
    private AnimationDrawable animDrawNavi;
    private AnimationDrawable animDrawPhonelink;
    private AnimationDrawable animDrawSet;
    private AnimationDrawable animDrawVideo;
    private View.OnFocusChangeListener mFocusChangeListener = new View.OnFocusChangeListener() {
        /* class com.wits.ksw.launcher.view.audimib3fy.AudiMib3FyFragmentOne.AnonymousClass2 */

        public void onFocusChange(View v, boolean hasFocus) {
            AudiMib3FyFragmentOne.this.viewModel.clearLastSel();
            switch (v.getId()) {
                case R.id.app_itemview /*{ENCODED_INT: 2131230806}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyFragmentOne.this.animDrawApps.isRunning()) {
                            AudiMib3FyFragmentOne.this.animDrawApps.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyFragmentOne.this.animDrawApps.isRunning()) {
                        AudiMib3FyFragmentOne.this.animDrawApps.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.bt_itemview /*{ENCODED_INT: 2131231264}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyFragmentOne.this.animDrawBt.isRunning()) {
                            AudiMib3FyFragmentOne.this.animDrawBt.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyFragmentOne.this.animDrawBt.isRunning()) {
                        AudiMib3FyFragmentOne.this.animDrawBt.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.car_itemview /*{ENCODED_INT: 2131231298}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyFragmentOne.this.animDrawCar.isRunning()) {
                            AudiMib3FyFragmentOne.this.animDrawCar.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyFragmentOne.this.animDrawCar.isRunning()) {
                        AudiMib3FyFragmentOne.this.animDrawCar.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.music_itemview /*{ENCODED_INT: 2131232151}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyFragmentOne.this.animDrawMusic.isRunning()) {
                            AudiMib3FyFragmentOne.this.animDrawMusic.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyFragmentOne.this.animDrawMusic.isRunning()) {
                        AudiMib3FyFragmentOne.this.animDrawMusic.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.navi_itemview /*{ENCODED_INT: 2131232174}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyFragmentOne.this.animDrawNavi.isRunning()) {
                            AudiMib3FyFragmentOne.this.animDrawNavi.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyFragmentOne.this.animDrawNavi.isRunning()) {
                        AudiMib3FyFragmentOne.this.animDrawNavi.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.phonelink_itemview /*{ENCODED_INT: 2131232261}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyFragmentOne.this.animDrawPhonelink.isRunning()) {
                            AudiMib3FyFragmentOne.this.animDrawPhonelink.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyFragmentOne.this.animDrawPhonelink.isRunning()) {
                        AudiMib3FyFragmentOne.this.animDrawPhonelink.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.set_itemview /*{ENCODED_INT: 2131232566}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyFragmentOne.this.animDrawSet.isRunning()) {
                            AudiMib3FyFragmentOne.this.animDrawSet.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyFragmentOne.this.animDrawSet.isRunning()) {
                        AudiMib3FyFragmentOne.this.animDrawSet.stop();
                        return;
                    } else {
                        return;
                    }
                case R.id.video_itemview /*{ENCODED_INT: 2131232848}*/:
                    if (hasFocus) {
                        if (!AudiMib3FyFragmentOne.this.animDrawVideo.isRunning()) {
                            AudiMib3FyFragmentOne.this.animDrawVideo.start();
                            return;
                        }
                        return;
                    } else if (AudiMib3FyFragmentOne.this.animDrawVideo.isRunning()) {
                        AudiMib3FyFragmentOne.this.animDrawVideo.stop();
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
        /* class com.wits.ksw.launcher.view.audimib3fy.AudiMib3FyFragmentOne.AnonymousClass3 */

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.app_itemview /*{ENCODED_INT: 2131230806}*/:
                    BcVieModel bcVieModel = AudiMib3FyFragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyFragmentOne.bindingOne.appItemview;
                    AudiMib3FyFragmentOne.setItemSelected(AudiMib3FyFragmentOne.bindingOne.appItemview);
                    AudiMib3FyFragmentOne.this.viewModel.openApps(v);
                    return;
                case R.id.bt_itemview /*{ENCODED_INT: 2131231264}*/:
                    BcVieModel bcVieModel2 = AudiMib3FyFragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyFragmentOne.bindingOne.btItemview;
                    AudiMib3FyFragmentOne.setItemSelected(AudiMib3FyFragmentOne.bindingOne.btItemview);
                    AudiMib3FyFragmentOne.this.viewModel.openBtApp(v);
                    return;
                case R.id.car_itemview /*{ENCODED_INT: 2131231298}*/:
                    BcVieModel bcVieModel3 = AudiMib3FyFragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyFragmentOne.bindingOne.carItemview;
                    AudiMib3FyFragmentOne.setItemSelected(AudiMib3FyFragmentOne.bindingOne.carItemview);
                    AudiMib3FyFragmentOne.this.viewModel.openCar(v);
                    return;
                case R.id.music_itemview /*{ENCODED_INT: 2131232151}*/:
                    AudiMib3FyFragmentOne.setItemSelected(AudiMib3FyFragmentOne.bindingOne.musicItemview);
                    BcVieModel bcVieModel4 = AudiMib3FyFragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyFragmentOne.bindingOne.musicItemview;
                    AudiMib3FyFragmentOne.this.viewModel.openMusicMulti(v);
                    return;
                case R.id.navi_itemview /*{ENCODED_INT: 2131232174}*/:
                    BcVieModel bcVieModel5 = AudiMib3FyFragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyFragmentOne.bindingOne.naviItemview;
                    AudiMib3FyFragmentOne.setItemSelected(AudiMib3FyFragmentOne.bindingOne.naviItemview);
                    AudiMib3FyFragmentOne.this.viewModel.openNaviApp(v);
                    return;
                case R.id.phonelink_itemview /*{ENCODED_INT: 2131232261}*/:
                    BcVieModel bcVieModel6 = AudiMib3FyFragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyFragmentOne.bindingOne.phonelinkItemview;
                    AudiMib3FyFragmentOne.setItemSelected(AudiMib3FyFragmentOne.bindingOne.phonelinkItemview);
                    AudiMib3FyFragmentOne.this.viewModel.openPhoneLink2021(v);
                    return;
                case R.id.set_itemview /*{ENCODED_INT: 2131232566}*/:
                    BcVieModel bcVieModel7 = AudiMib3FyFragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyFragmentOne.bindingOne.setItemview;
                    AudiMib3FyFragmentOne.setItemSelected(AudiMib3FyFragmentOne.bindingOne.setItemview);
                    AudiMib3FyFragmentOne.this.viewModel.openSettings(v);
                    return;
                case R.id.video_itemview /*{ENCODED_INT: 2131232848}*/:
                    AudiMib3FyFragmentOne.setItemSelected(AudiMib3FyFragmentOne.bindingOne.videoItemview);
                    BcVieModel bcVieModel8 = AudiMib3FyFragmentOne.this.viewModel;
                    BcVieModel.viewLastSel = AudiMib3FyFragmentOne.bindingOne.videoItemview;
                    AudiMib3FyFragmentOne.this.viewModel.openVideoMulti(v);
                    return;
                default:
                    return;
            }
        }
    };
    private IContentObserver.Stub topAppContentObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.audimib3fy.AudiMib3FyFragmentOne.AnonymousClass4 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            try {
                String topApp = PowerManagerApp.getStatusString("topApp");
                Log.i(AudiMib3FyFragmentOne.TAG, "onChange: topApp=" + topApp);
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
        AudiMib3FyOneDataCls audiMib3FyOneDataCls = (AudiMib3FyOneDataCls) DataBindingUtil.inflate(inflater, R.layout.fragment_audi_mib3_fy_one, null, false);
        bindingOne = audiMib3FyOneDataCls;
        return audiMib3FyOneDataCls.getRoot();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Log.d("AudiMib3FragmentOne", "onResume()  1111111111111");
        this.viewModel.refreshLastSel();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindingOne.setViewModel(this.viewModel);
        PowerManagerApp.registerIContentObserver("topApp", this.topAppContentObserver);
        Log.e("liuhao", "isSmooth = " + isSmooth);
        bindingOne.setItemview.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.wits.ksw.launcher.view.audimib3fy.AudiMib3FyFragmentOne.AnonymousClass1 */

            public void onFocusChange(View v, boolean hasFocus) {
                Log.e("liuhao bindingOne.setItemview", "isSmooth 0000000000 hasFocus = " + hasFocus);
                if (hasFocus && AudiMib3FyFragmentOne.this.mainActivity.viewpagerAudiMib3Fy != null && AudiMib3FyFragmentOne.this.mainActivity.viewpagerAudiMib3Fy.getCurrentItem() != 0) {
                    AudiMib3FyFragmentOne.this.mainActivity.viewpagerAudiMib3Fy.setCurrentItem(0);
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
        bindingOne.appItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.appIv.setOnClickListener(this.mItemClickListener);
        bindingOne.appIv.setOnClickListener(this.mItemClickListener);
        bindingOne.setItemview.setOnClickListener(this.mItemClickListener);
        bindingOne.setIv.setOnClickListener(this.mItemClickListener);
        bindingOne.setTv.setOnClickListener(this.mItemClickListener);
        bindingOne.videoItemview.setOnKeyListener(this);
        bindingOne.musicItemview.setOnKeyListener(this);
        bindingOne.btItemview.setOnKeyListener(this);
        bindingOne.naviItemview.setOnKeyListener(this);
        bindingOne.phonelinkItemview.setOnKeyListener(this);
        bindingOne.carItemview.setOnKeyListener(this);
        bindingOne.appItemview.setOnKeyListener(this);
        bindingOne.setItemview.setOnKeyListener(this);
        this.animDrawVideo = (AnimationDrawable) bindingOne.videoItemview.getDrawable();
        this.animDrawMusic = (AnimationDrawable) bindingOne.musicItemview.getDrawable();
        this.animDrawBt = (AnimationDrawable) bindingOne.btItemview.getDrawable();
        this.animDrawNavi = (AnimationDrawable) bindingOne.naviItemview.getDrawable();
        this.animDrawPhonelink = (AnimationDrawable) bindingOne.phonelinkItemview.getDrawable();
        this.animDrawCar = (AnimationDrawable) bindingOne.carItemview.getDrawable();
        this.animDrawApps = (AnimationDrawable) bindingOne.appItemview.getDrawable();
        this.animDrawSet = (AnimationDrawable) bindingOne.setItemview.getDrawable();
        bindingOne.videoItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.musicItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.btItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.naviItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.phonelinkItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.carItemview.setOnFocusChangeListener(this.mFocusChangeListener);
        bindingOne.appItemview.setOnFocusChangeListener(this.mFocusChangeListener);
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
        bindingOne.appItemview.setSelected(bindingOne.appItemview == view);
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
        Log.i(TAG, "Audimib3_Fy onKey: " + keyCode);
        if (keyCode == 22) {
            if (v == bindingOne.setItemview && this.mainActivity.viewpagerAudiMib3Fy.getCurrentItem() != 1) {
                this.mainActivity.viewpagerAudiMib3Fy.setCurrentItem(1);
                return true;
            } else if (v != bindingOne.naviItemview) {
                return false;
            } else {
                Log.e("liuhao", "isAudi_mib3_Fy 22222222222");
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
