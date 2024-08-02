package com.wits.ksw.settings.benz_mbux_2021.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.database.ContentObserver;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityBenzMbuxSettingsMainBinding;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsMainAdapter;
import com.wits.ksw.settings.benz_mbux_2021.bean.BenzMbuxSettingsMainBean;
import java.util.ArrayList;
import java.util.List;

public class BenzMbuxSettingsMainActivity extends BaseSkinActivity {
    private final String TAG = "BenzMbuxSettingsMainActivity";
    private ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsMainActivity.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.i("BenzMbuxSettingsMainActivity", "benzSkin Change");
            if (BenzMbuxSettingsMainActivity.this.mAdapter != null) {
                BenzMbuxSettingsMainActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    };
    private LauncherViewModel launcherViewModel;
    private BenzMbuxSettingsMainAdapter mAdapter;
    private List<BenzMbuxSettingsMainBean> mBeanList = new ArrayList();
    private ActivityBenzMbuxSettingsMainBinding mBinding;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BenzMbuxSettingsMainActivity", " onCreate ");
        this.mBinding = (ActivityBenzMbuxSettingsMainBinding) DataBindingUtil.setContentView(this, R.layout.activity_benz_mbux_settings_main);
        LauncherViewModel launcherViewModel2 = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        this.launcherViewModel = launcherViewModel2;
        launcherViewModel2.setActivity(this);
        this.mBinding.setLauncherViewModel(this.launcherViewModel);
        initData();
        initView();
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL), true, this.contentObserver);
    }

    private void initData() {
        this.mBeanList.clear();
        this.mBeanList.add(new BenzMbuxSettingsMainBean(getResources().getString(R.string.item1), R.drawable.mbux_settings_left_icon_system, R.drawable.benz_mbux_settings_main_btn_sel, R.drawable.mbux_settings_divider));
        this.mBeanList.add(new BenzMbuxSettingsMainBean(getResources().getString(R.string.item3), R.drawable.mbux_settings_left_icon_vol, R.drawable.benz_mbux_settings_main_btn_sel, R.drawable.mbux_settings_divider));
        this.mBeanList.add(new BenzMbuxSettingsMainBean(getResources().getString(R.string.item2), R.drawable.mbux_settings_left_icon_nav, R.drawable.benz_mbux_settings_main_btn_sel, R.drawable.mbux_settings_divider));
        this.mBeanList.add(new BenzMbuxSettingsMainBean(getResources().getString(R.string.item9), R.drawable.mbux_settings_left_icon_factory, R.drawable.benz_mbux_settings_main_btn_sel, R.drawable.mbux_settings_divider));
        this.mBeanList.add(new BenzMbuxSettingsMainBean(getResources().getString(R.string.item8), R.drawable.mbux_settings_left_icon_android, R.drawable.benz_mbux_settings_main_btn_sel, R.drawable.mbux_settings_divider));
        this.mBeanList.add(new BenzMbuxSettingsMainBean(getResources().getString(R.string.item7), R.drawable.mbux_settings_left_icon_info, R.drawable.benz_mbux_settings_main_btn_sel, R.color.transparent));
    }

    private void initView() {
        this.mAdapter = new BenzMbuxSettingsMainAdapter(this.mBeanList);
        this.mBinding.benzSettingsMainRecycle.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mBinding.benzSettingsMainRecycle.setAdapter(this.mAdapter);
        this.mAdapter.setItemClickListener(new BenzMbuxSettingsMainAdapter.ItemClickListener() {
            /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsMainActivity.AnonymousClass2 */

            @Override // com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsMainAdapter.ItemClickListener
            public void onItemClick(View v, int position, BenzMbuxSettingsMainBean item) {
                Log.i("BenzMbuxSettingsMainActivity", "onKeyChanged position " + position);
                BenzMbuxSettingsMainActivity.this.startActivityByTitle(item.getTitle());
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startActivityByTitle(String title) {
        if (TextUtils.equals(title, getResources().getString(R.string.item1))) {
            startActivity(new Intent(getApplicationContext(), BenzMbuxSettingsSystemActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.item2))) {
            startActivity(new Intent(getApplicationContext(), BenzMbuxSettingsNaviActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.item3))) {
            startActivity(new Intent(getApplicationContext(), BenzMbuxSettingsAudioActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.item8))) {
            startActivity(new Intent("android.settings.SETTINGS"));
            overridePendingTransition(0, 0);
        } else if (TextUtils.equals(title, getResources().getString(R.string.item9))) {
            startActivity(new Intent(getApplicationContext(), BenzMbuxSettingsFactoryActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.item7))) {
            startActivity(new Intent(getApplicationContext(), BenzMbuxSettingsInfoActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BenzMbuxSettingsMainActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BenzMbuxSettingsMainActivity", " onResume ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        Log.i("BenzMbuxSettingsMainActivity", " onPause ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BenzMbuxSettingsMainActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BenzMbuxSettingsMainActivity", " onDestroy ");
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("BenzMbuxSettingsMainActivity", " dispatchKeyEvent ");
        return super.dispatchKeyEvent(event);
    }
}
