package com.wits.ksw.settings.benz_mbux_2021.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityBenzMbuxSettingsNaviLayoutBinding;
import com.wits.ksw.launcher.utils.ScreenUtil;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsNaviAdapter;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.id7.bean.MapBean;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.ksw.settings.utlis_view.ScanNaviList;
import java.util.List;

public class BenzMbuxSettingsNaviActivity extends BaseSkinActivity implements ScanNaviList.OnMapListScanListener {
    private final String TAG = "BenzMbuxSettingsNaviActivity";
    Handler handler = new Handler() {
        /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsNaviActivity.AnonymousClass3 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 3:
                    if (BenzMbuxSettingsNaviActivity.this.mAdapter != null) {
                        BenzMbuxSettingsNaviActivity.this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private LinearLayoutManager layoutManager;
    private BenzMbuxSettingsNaviAdapter mAdapter;
    private ActivityBenzMbuxSettingsNaviLayoutBinding mBinding;
    private BaseQuickAdapter.OnItemClickListener mOnItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsNaviActivity.AnonymousClass2 */

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Log.i("BenzMbuxSettingsNaviActivity", " position " + position);
            for (MapBean mpb : BenzMbuxSettingsNaviActivity.this.mapBanList) {
                mpb.setCheck(false);
            }
            MapBean mapBean = (MapBean) BenzMbuxSettingsNaviActivity.this.mapBanList.get(position);
            if (mapBean != null) {
                FileUtils.savaStringData(KeyConfig.NAVI_DEFUAL, mapBean.getPackageName());
                mapBean.setCheck(true);
                Settings.System.putString(BenzMbuxSettingsNaviActivity.this.getContentResolver(), "wits_freedom_pkg", mapBean.getPackageName());
                BaseSkinActivity.forceStopPackage(BenzMbuxSettingsNaviActivity.this, mapBean.getPackageName());
            }
            BenzMbuxSettingsNaviActivity.this.mAdapter.notifyDataSetChanged();
        }
    };
    private BenzMbuxSettingsViewModel mViewModel;
    private List<MapBean> mapBanList;

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BenzMbuxSettingsNaviActivity", " onCreate ");
        this.mBinding = (ActivityBenzMbuxSettingsNaviLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_benz_mbux_settings_navi_layout);
        BenzMbuxSettingsViewModel instance = BenzMbuxSettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        initData();
        initView();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BenzMbuxSettingsNaviActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BenzMbuxSettingsNaviActivity", " onResume ");
    }

    private void initData() {
        try {
            ScanNaviList.getInstance().setMapListScanListener(this);
            if (getCurrentFocus() == null) {
                this.mBinding.naviRecycle.requestFocus();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void initView() {
        this.mapBanList = ScanNaviList.getInstance().getMapList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.mBinding.naviRecycle.setLayoutManager(this.layoutManager);
        this.mAdapter = new BenzMbuxSettingsNaviAdapter(this.mapBanList);
        this.mBinding.naviRecycle.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemClickListener(this.mOnItemClickListener);
        this.mBinding.naviRecycle.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsNaviActivity.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                Log.i("BenzMbuxSettingsNaviActivity", " getItemOffsets position " + position);
                if (position != BenzMbuxSettingsNaviActivity.this.mapBanList.size() - 1) {
                    outRect.bottom = -ScreenUtil.dip2px(4.5f);
                }
            }
        });
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override // com.wits.ksw.settings.utlis_view.ScanNaviList.OnMapListScanListener
    public void onScanFinish(List<MapBean> mapList) {
        this.mapBanList = mapList;
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.handler.sendEmptyMessage(3);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BenzMbuxSettingsNaviActivity", " onStop ");
        ScanNaviList.getInstance().setMapListScanListener(null);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BenzMbuxSettingsNaviActivity", " onDestroy ");
    }
}
