package com.wits.ksw.launcher.view.id8ug.fragment;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.viewbinding.ViewBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FragmentEvoid8MainNavigationBinding;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import com.wits.ksw.launcher.view.id8ug.Id8UgViewManager;
import com.wits.ksw.launcher.view.id8ug.adapter.Id8GsMainNaviAdapter;
import com.wits.ksw.settings.BaseActivity;
import com.wits.ksw.settings.id7.bean.MapBean;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.ksw.settings.utlis_view.ScanNaviList;
import java.util.List;

public class Id8UgCarNaviFragment extends Id8UgBaseFragment implements ScanNaviList.OnMapListScanListener {
    private FragmentEvoid8MainNavigationBinding binding;
    public ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarNaviFragment.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            Id8UgCarNaviFragment.this.setNaviChangeLayoutBg();
        }
    };
    Handler handler = new Handler(Looper.getMainLooper()) {
        /* class com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarNaviFragment.AnonymousClass2 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 3:
                    if (Id8UgCarNaviFragment.this.naviAdapter != null) {
                        Id8UgCarNaviFragment.this.naviAdapter.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private CountDownTimer mAutoPlayTimer;
    private List<MapBean> mapBanList;
    private Id8GsMainNaviAdapter naviAdapter;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public String setFragmentTag() {
        return Id8UgConstants.ID8UG_FRAGMENT_CAR_NAVI;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public ViewBinding createDataBinding(LayoutInflater inflater, ViewGroup container) {
        this.binding = FragmentEvoid8MainNavigationBinding.inflate(inflater, container, false);
        setNaviChangeLayoutBg();
        return this.binding;
    }

    private void setListener() {
        ScanNaviList.getInstance().setMapListScanListener(this);
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarNaviFragment$kxEZtylINKyM45wEHkhKzk8h8 */

            public final void onClick(View view) {
                Id8UgCarNaviFragment.this.lambda$setListener$0$Id8UgCarNaviFragment(view);
            }
        });
        this.binding.id8UgNaviChange.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarNaviFragment$QdhQChUIyGPxhivSrGkCXLVv2mc */

            public final void onClick(View view) {
                Id8UgCarNaviFragment.this.lambda$setListener$1$Id8UgCarNaviFragment(view);
            }
        });
        this.naviAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarNaviFragment$jv6eMm_cbva3_jE51WNai0q5jrU */

            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Id8UgCarNaviFragment.this.lambda$setListener$2$Id8UgCarNaviFragment(baseQuickAdapter, view, i);
            }
        });
        if (getContext() != null) {
            getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor(Id8UgConstants.ID8UG_SKIN_MODEL), true, this.contentObserver);
        }
    }

    public /* synthetic */ void lambda$setListener$0$Id8UgCarNaviFragment(View v) {
        if (this.binding.id8UgNaviChangeLayout.getVisibility() == 0) {
            hideCarChangeLayout();
            return;
        }
        Id8UgViewManager.getInstance().setOnClickLastRequestView(this.fragmentTag);
        this.mViewModel.openNaviApp(v);
    }

    public /* synthetic */ void lambda$setListener$1$Id8UgCarNaviFragment(View view) {
        showCarChangeLayout();
    }

    public /* synthetic */ void lambda$setListener$2$Id8UgCarNaviFragment(BaseQuickAdapter adapter, View view, int position) {
        MapBean mapBean = this.mapBanList.get(position);
        if (mapBean != null) {
            FileUtils.savaStringData(KeyConfig.NAVI_DEFUAL, mapBean.getPackageName());
            mapBean.setCheck(true);
            Settings.System.putString(getContext().getContentResolver(), "wits_freedom_pkg", mapBean.getPackageName());
            BaseActivity.forceStopPackage(getContext(), mapBean.getPackageName());
            this.naviAdapter.notifyDataSetChanged();
            hideCarChangeLayout();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            if (getContext() != null) {
                getContext().getContentResolver().unregisterContentObserver(this.contentObserver);
            }
            cancelAutoTimer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setNaviChangeLayoutBg() {
        this.binding.id8UgNaviChangeLayout.setBackground(ContextCompat.getDrawable(KswApplication.appContext, TextUtils.equals(Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT, Settings.System.getString(KswApplication.appContext.getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL)) ? R.drawable.evoid8_navi_change_shape_night : R.drawable.evoid8_navi_change_shape));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hideCarChangeLayout() {
        if (this.binding.id8UgNaviChangeLayout.getVisibility() == 0) {
            this.binding.id8UgNaviChangeLayout.setVisibility(8);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(400);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(400);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            this.binding.id8UgNaviChangeLayout.startAnimation(animationSet);
        }
    }

    private void showCarChangeLayout() {
        this.binding.id8UgNaviChangeLayout.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(400);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(400);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.binding.id8UgNaviChangeLayout.startAnimation(animationSet);
        startAutoTimer();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public void initMainActivityData() {
        super.initMainActivityData();
        this.mapBanList = ScanNaviList.getInstance().getMapList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.naviAdapter = new Id8GsMainNaviAdapter(this.mapBanList);
        this.binding.recyclerView.setLayoutManager(gridLayoutManager);
        this.binding.recyclerView.setAdapter(this.naviAdapter);
        setListener();
    }

    @Override // com.wits.ksw.settings.utlis_view.ScanNaviList.OnMapListScanListener
    public void onScanFinish(List<MapBean> mapList) {
        this.mapBanList = mapList;
        this.handler.removeCallbacksAndMessages(null);
        this.handler.sendEmptyMessage(3);
    }

    public void startAutoTimer() {
        Log.d(TAG, "startAutoTimer");
        cancelAutoTimer();
        if (this.mAutoPlayTimer == null) {
            this.mAutoPlayTimer = new CountDownTimer(10000, 1000) {
                /* class com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarNaviFragment.AnonymousClass3 */

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    Log.i(Id8UgBaseFragment.TAG, "startAutoTimer onFinish: ");
                    Id8UgCarNaviFragment.this.hideCarChangeLayout();
                }
            };
        }
        this.mAutoPlayTimer.start();
    }

    public void cancelAutoTimer() {
        Log.d(TAG, "cancelAutoTimer");
        CountDownTimer countDownTimer = this.mAutoPlayTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
