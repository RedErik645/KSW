package com.wits.ksw.settings.bmw_id9.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.database.ContentObserver;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityBmwId9SettingsMainBinding;
import com.wits.ksw.launcher.bmw_id8_ui.ID8LauncherConstants;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.bmw_id9.adapter.BmwId9SettingsMainAdapter;
import com.wits.ksw.settings.bmw_id9.bean.BmwId9SettingsMainBean;
import com.wits.ksw.settings.bmw_id9.view.BmwId9SpacingItemDecoration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BmwId9SettingsMainActivity extends BaseSkinActivity {
    private final String TAG = "BmwId9SettingsMainActivity";
    private LauncherViewModel bmwId9ViewModel;
    private ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsMainActivity.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.i("BmwId9SettingsMainActivity", "skin nChange");
            if (BmwId9SettingsMainActivity.this.mAdapter != null) {
                BmwId9SettingsMainActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    };
    private BmwId9SettingsMainAdapter mAdapter;
    private List<BmwId9SettingsMainBean> mBeanList = new ArrayList();
    private ActivityBmwId9SettingsMainBinding mBinding;
    private ItemTouchHelper mItemTouchHelper;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BmwId9SettingsMainActivity", " onCreate ");
        this.mBinding = (ActivityBmwId9SettingsMainBinding) DataBindingUtil.setContentView(this, R.layout.activity_bmw_id9_settings_main);
        LauncherViewModel launcherViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        this.bmwId9ViewModel = launcherViewModel;
        launcherViewModel.setActivity(this);
        this.mBinding.setLauncherViewModel(this.bmwId9ViewModel);
        initData();
        initView();
        getContentResolver().registerContentObserver(Settings.System.getUriFor(ID8LauncherConstants.ID8_SKIN), true, this.contentObserver);
    }

    private void initData() {
        this.mBeanList.clear();
        this.mBeanList.add(new BmwId9SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_system), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id9_settings_main_bg, R.drawable.id9_settings_icon_system));
        this.mBeanList.add(new BmwId9SettingsMainBean(getResources().getString(R.string.item3), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id9_settings_main_bg, R.drawable.id9_settings_icon_audio));
        this.mBeanList.add(new BmwId9SettingsMainBean(getResources().getString(R.string.id8_settings_navigate_title), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id9_settings_main_bg, R.drawable.id9_settings_icon_navi));
        this.mBeanList.add(new BmwId9SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_factory), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id9_settings_main_bg, R.drawable.id9_settings_icon_factory));
        this.mBeanList.add(new BmwId9SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_android), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id9_settings_main_bg, R.drawable.id9_settings_icon_android));
        this.mBeanList.add(new BmwId9SettingsMainBean(getResources().getString(R.string.item7), getResources().getString(R.string.item7), R.drawable.bmw_id9_settings_main_bg, R.drawable.id9_settings_icon_info));
    }

    private void initView() {
        this.mAdapter = new BmwId9SettingsMainAdapter(this.mBeanList);
        this.mBinding.bmwId9SettingsMainRecycle.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.mBinding.bmwId9SettingsMainRecycle.setAdapter(this.mAdapter);
        this.mBinding.bmwId9SettingsMainRecycle.addItemDecoration(new BmwId9SpacingItemDecoration(new int[]{30, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 50}));
        this.mAdapter.setItemClickListener(new BmwId9SettingsMainAdapter.ItemClickListener() {
            /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsMainActivity.AnonymousClass2 */

            @Override // com.wits.ksw.settings.bmw_id9.adapter.BmwId9SettingsMainAdapter.ItemClickListener
            public void onItemClick(View v, int position, BmwId9SettingsMainBean item) {
                Log.i("BmwId9SettingsMainActivity", "onKeyChanged position " + position);
                BmwId9SettingsMainActivity.this.startActivityByTitle(item.getTitle());
            }
        });
        this.mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsMainActivity.AnonymousClass3 */

            @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeMovementFlags(15, 0);
            }

            @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = viewHolder1.getAdapterPosition();
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(BmwId9SettingsMainActivity.this.mBeanList, i, i + 1);
                    }
                } else {
                    for (int i2 = fromPosition; i2 > toPosition; i2--) {
                        Collections.swap(BmwId9SettingsMainActivity.this.mBeanList, i2, i2 - 1);
                    }
                }
                BmwId9SettingsMainActivity.this.mAdapter.notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
            }

            @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);
            }

            @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
            }

            @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
            public boolean isLongPressDragEnabled() {
                return super.isLongPressDragEnabled();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startActivityByTitle(String title) {
        if (TextUtils.equals(title, getResources().getString(R.string.ksw_id8_settings_title_system))) {
            startActivity(new Intent(getApplicationContext(), BmwId9SettingsSystemActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.fragment_navigate_title))) {
            startActivity(new Intent(getApplicationContext(), BmwId9SettingsNaviActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.item3))) {
            startActivity(new Intent(getApplicationContext(), BmwId9SettingsAudioActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.ksw_id8_settings_title_android))) {
            startActivity(new Intent("android.settings.SETTINGS"));
            overridePendingTransition(0, 0);
        } else if (TextUtils.equals(title, getResources().getString(R.string.ksw_id8_settings_title_factory))) {
            startActivity(new Intent(getApplicationContext(), BmwId9SettingsFactoryActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.item7))) {
            startActivity(new Intent(getApplicationContext(), BmwId9SettingsInfoActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BmwId9SettingsMainActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BmwId9SettingsMainActivity", " onResume ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        Log.i("BmwId9SettingsMainActivity", " onPause ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BmwId9SettingsMainActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BmwId9SettingsMainActivity", " onDestroy ");
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("BmwId9SettingsMainActivity", " dispatchKeyEvent ");
        return super.dispatchKeyEvent(event);
    }
}
