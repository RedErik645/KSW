package com.wits.ksw.settings.bmw_id9.activity;

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
import com.wits.ksw.databinding.ActivityBmwId9SettingsNaviLayoutBinding;
import com.wits.ksw.launcher.utils.ScreenUtil;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.bmw_id9.adapter.BmwId9SettingsNaviAdapter;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.id7.bean.MapBean;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.ksw.settings.utlis_view.ScanNaviList;
import java.util.List;

public class BmwId9SettingsNaviActivity extends BaseSkinActivity implements ScanNaviList.OnMapListScanListener {
    private final String TAG = "BmwId9SettingsNaviActivity";
    Handler handler = new Handler() {
        /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsNaviActivity.AnonymousClass3 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 3:
                    if (BmwId9SettingsNaviActivity.this.mAdapter != null) {
                        BmwId9SettingsNaviActivity.this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private LinearLayoutManager layoutManager;
    private BmwId9SettingsNaviAdapter mAdapter;
    private ActivityBmwId9SettingsNaviLayoutBinding mBinding;
    private BaseQuickAdapter.OnItemClickListener mOnItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsNaviActivity.AnonymousClass2 */

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Log.i("BmwId9SettingsNaviActivity", " position " + position);
            for (MapBean mpb : BmwId9SettingsNaviActivity.this.mapBanList) {
                mpb.setCheck(false);
            }
            MapBean mapBean = (MapBean) BmwId9SettingsNaviActivity.this.mapBanList.get(position);
            if (mapBean != null) {
                FileUtils.savaStringData(KeyConfig.NAVI_DEFUAL, mapBean.getPackageName());
                mapBean.setCheck(true);
                Settings.System.putString(BmwId9SettingsNaviActivity.this.getContentResolver(), "wits_freedom_pkg", mapBean.getPackageName());
                BaseSkinActivity.forceStopPackage(BmwId9SettingsNaviActivity.this, mapBean.getPackageName());
            }
            BmwId9SettingsNaviActivity.this.mAdapter.notifyDataSetChanged();
        }
    };
    private BmwId9SettingsViewModel mViewModel;
    private List<MapBean> mapBanList;

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BmwId9SettingsNaviActivity", " onCreate ");
        this.mBinding = (ActivityBmwId9SettingsNaviLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_bmw_id9_settings_navi_layout);
        BmwId9SettingsViewModel instance = BmwId9SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        initData();
        initView();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BmwId9SettingsNaviActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BmwId9SettingsNaviActivity", " onResume ");
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
        this.mAdapter = new BmwId9SettingsNaviAdapter(this.mapBanList);
        this.mBinding.naviRecycle.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemClickListener(this.mOnItemClickListener);
        this.mBinding.naviRecycle.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsNaviActivity.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                Log.i("BmwId9SettingsNaviActivity", " getItemOffsets position " + position);
                if (position != BmwId9SettingsNaviActivity.this.mapBanList.size() - 1) {
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
        Log.i("BmwId9SettingsNaviActivity", " onStop ");
        ScanNaviList.getInstance().setMapListScanListener(null);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BmwId9SettingsNaviActivity", " onDestroy ");
    }
}
