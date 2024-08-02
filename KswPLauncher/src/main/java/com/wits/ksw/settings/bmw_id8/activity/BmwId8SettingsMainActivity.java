package com.wits.ksw.settings.bmw_id8.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.database.ContentObserver;
import android.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BmwId8SettingsMainLayoutBinding;
import com.wits.ksw.launcher.bmw_id8_ui.ID8LauncherConstants;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.bmw_id8.adapter.BmwId8SettingsMainAdapter;
import com.wits.ksw.settings.bmw_id8.bean.BmwId8SettingsMainBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BmwId8SettingsMainActivity extends BaseSkinActivity {
    private final String TAG = "BmwId8SettingsMainActivity";
    private LauncherViewModel bmwId8ViewModel;
    private ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.i("BmwId8SettingsMainActivity", "skin nChange");
            if (BmwId8SettingsMainActivity.this.mAdapter != null) {
                BmwId8SettingsMainActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    };
    private String id8CacheLeftIcon2;
    private String id8CacheLeftIcon3;
    private String id8CacheLeftIcon4;
    private BmwId8SettingsMainAdapter mAdapter;
    private List<BmwId8SettingsMainBean> mBeanList = new ArrayList();
    private BmwId8SettingsMainLayoutBinding mBinding;
    private ItemTouchHelper mItemTouchHelper;
    private BaseQuickAdapter.OnItemClickListener mOnItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass4 */

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            String title = ((BmwId8SettingsMainBean) adapter.getData().get(position)).getTitle();
            Log.i("BmwId8SettingsMainActivity", " position " + position + " title " + title);
            BmwId8SettingsMainActivity.this.startActivityByTitle(title);
        }
    };

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BmwId8SettingsMainActivity", " onCreate ");
        this.mBinding = (BmwId8SettingsMainLayoutBinding) DataBindingUtil.setContentView(this, R.layout.bmw_id8_settings_main_layout);
        LauncherViewModel launcherViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        this.bmwId8ViewModel = launcherViewModel;
        launcherViewModel.setActivity(this);
        this.mBinding.setLauncherViewModel(this.bmwId8ViewModel);
        initData();
        initView();
        getContentResolver().registerContentObserver(Settings.System.getUriFor(ID8LauncherConstants.ID8_SKIN), true, this.contentObserver);
    }

    private void initData() {
        this.mBeanList.clear();
        this.mBeanList.add(new BmwId8SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_system), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id8_settings_main_bg, R.drawable.id8_settings_icon_system));
        this.mBeanList.add(new BmwId8SettingsMainBean(getResources().getString(R.string.id8_settings_navigate_title), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id8_settings_main_bg, R.drawable.id8_settings_icon_navi));
        this.mBeanList.add(new BmwId8SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_audio), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id8_settings_main_bg, R.drawable.id8_settings_icon_audio));
        this.mBeanList.add(new BmwId8SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_language), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id8_settings_main_bg, R.drawable.id8_settings_icon_language));
        this.mBeanList.add(new BmwId8SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_time), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id8_settings_main_bg, R.drawable.id8_settings_icon_time));
        this.mBeanList.add(new BmwId8SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_android), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id8_settings_main_bg, R.drawable.id8_settings_icon_android));
        this.mBeanList.add(new BmwId8SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_factory), getResources().getString(R.string.ksw_id8_settings_content), R.drawable.bmw_id8_settings_main_bg, R.drawable.id8_settings_icon_factory));
        this.mBeanList.add(new BmwId8SettingsMainBean(getResources().getString(R.string.ksw_id8_settings_title_info), getResources().getString(R.string.item7), R.drawable.bmw_id8_settings_main_bg, R.drawable.id8_settings_icon_info));
    }

    private void initView() {
        this.mAdapter = new BmwId8SettingsMainAdapter(this.mBeanList);
        this.mBinding.bmwId8SettingsMainRecycle.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.mBinding.bmwId8SettingsMainRecycle.setAdapter(this.mAdapter);
        this.mAdapter.setItemClickListener(new BmwId8SettingsMainAdapter.ItemClickListener() {
            /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass2 */

            @Override // com.wits.ksw.settings.bmw_id8.adapter.BmwId8SettingsMainAdapter.ItemClickListener
            public void onItemClick(View v, int position, BmwId8SettingsMainBean item) {
                Log.i("BmwId8SettingsMainActivity", "onKeyChanged position " + position);
                BmwId8SettingsMainActivity.this.startActivityByTitle(item.getTitle());
            }
        });
        this.mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass3 */

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
                        Collections.swap(BmwId8SettingsMainActivity.this.mBeanList, i, i + 1);
                    }
                } else {
                    for (int i2 = fromPosition; i2 > toPosition; i2--) {
                        Collections.swap(BmwId8SettingsMainActivity.this.mBeanList, i2, i2 - 1);
                    }
                }
                BmwId8SettingsMainActivity.this.mAdapter.notifyItemMoved(fromPosition, toPosition);
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
            startActivity(new Intent(getApplicationContext(), BmwId8SettingsSystemActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.fragment_navigate_title))) {
            startActivity(new Intent(getApplicationContext(), BmwId8SettingsNaviActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.ksw_id8_settings_title_audio))) {
            startActivity(new Intent(getApplicationContext(), BmwId8SettingsAudioActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.ksw_id8_settings_title_language))) {
            startActivity(new Intent(getApplicationContext(), BmwId8SettingsLanguageActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.ksw_id8_settings_title_time))) {
            startActivity(new Intent(getApplicationContext(), BmwId8SettingsTimeActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.ksw_id8_settings_title_android))) {
            startActivity(new Intent("android.settings.SETTINGS"));
            overridePendingTransition(0, 0);
        } else if (TextUtils.equals(title, getResources().getString(R.string.ksw_id8_settings_title_factory))) {
            startActivity(new Intent(getApplicationContext(), BmwId8SettingsFactoryActivity.class));
        } else if (TextUtils.equals(title, getResources().getString(R.string.ksw_id8_settings_title_info))) {
            startActivity(new Intent(getApplicationContext(), BmwId8SettingsInfoActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BmwId8SettingsMainActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BmwId8SettingsMainActivity", " onResume ");
        beforeRefreshLeftBarIcon();
        String skinName = ID8LauncherConstants.loadCurrentSkin();
        if (TextUtils.equals(skinName, ID8LauncherConstants.ID8_SKIN_SPORT)) {
            refreshLeftBackground(R.drawable.bmw_id8_main_left_btn_red);
        } else if (TextUtils.equals(skinName, "blue")) {
            refreshLeftBackground(R.drawable.bmw_id8_main_left_btn_blue);
        } else {
            refreshLeftBackground(R.drawable.bmw_id8_main_left_btn_yellow);
        }
        this.mBinding.bmwId8SettingsMainLeftBar.llLeft1.setFocusedByDefault(true);
    }

    private void refreshLeftBackground(int backGroundId) {
        try {
            this.mBinding.bmwId8SettingsMainLeftBar.llLeft1.setBackground(getDrawable(backGroundId));
            this.mBinding.bmwId8SettingsMainLeftBar.llLeft2.setBackground(getDrawable(backGroundId));
            this.mBinding.bmwId8SettingsMainLeftBar.llLeft3.setBackground(getDrawable(backGroundId));
            this.mBinding.bmwId8SettingsMainLeftBar.llLeft4.setBackground(getDrawable(backGroundId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void beforeRefreshLeftBarIcon() {
        Log.w("BmwId8SettingsMainActivity", "beforeRefreshLeftBarIcon: ");
        if (checkLeftIconHasChange()) {
            refreshLeftBarIcon();
        }
    }

    private boolean checkLeftIconHasChange() {
        if (!ID8LauncherConstants.leftIcon2.equals(this.id8CacheLeftIcon2) || !ID8LauncherConstants.leftIcon3.equals(this.id8CacheLeftIcon3) || !ID8LauncherConstants.leftIcon4.equals(this.id8CacheLeftIcon4)) {
            return true;
        }
        return false;
    }

    private void refreshLeftBarIcon() {
        this.id8CacheLeftIcon2 = ID8LauncherConstants.leftIcon2;
        this.id8CacheLeftIcon3 = ID8LauncherConstants.leftIcon3;
        this.id8CacheLeftIcon4 = ID8LauncherConstants.leftIcon4;
        initLeftIcon(this.mBinding.bmwId8SettingsMainLeftBar.llLeft2, this.mBinding.bmwId8SettingsMainLeftBar.ivLeft2, this.mBinding.bmwId8SettingsMainLeftBar.tvLeft2, this.id8CacheLeftIcon2);
        initLeftIcon(this.mBinding.bmwId8SettingsMainLeftBar.llLeft3, this.mBinding.bmwId8SettingsMainLeftBar.ivLeft3, this.mBinding.bmwId8SettingsMainLeftBar.tvLeft3, this.id8CacheLeftIcon3);
        initLeftIcon(this.mBinding.bmwId8SettingsMainLeftBar.llLeft4, this.mBinding.bmwId8SettingsMainLeftBar.ivLeft4, this.mBinding.bmwId8SettingsMainLeftBar.tvLeft4, this.id8CacheLeftIcon4);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void initLeftIcon(LinearLayout linearLayout, ImageView iv, TextView tv, String name) {
        char c;
        int iconRes = -1;
        int nameRes = -1;
        switch (name.hashCode()) {
            case -1591043536:
                if (name.equals("SETTING")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1409845903:
                if (name.equals("NAVIGATE")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 73532672:
                if (name.equals("MODUS")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 73725445:
                if (name.equals("MUSIC")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 76105038:
                if (name.equals("PHONE")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 81665115:
                if (name.equals("VIDEO")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 741767578:
                if (name.equals("CAR INFO")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1738734196:
                if (name.equals("DASHBOARD")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1941423060:
                if (name.equals("WEATHER")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                iconRes = R.drawable.id8_main_left_icon_navi;
                nameRes = R.string.ksw_id8_abbr_tel_navigate;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass5 */

                    public void onClick(View view) {
                        BmwId8SettingsMainActivity.this.bmwId8ViewModel.openNaviApp();
                    }
                });
                break;
            case 1:
                iconRes = R.drawable.id8_main_left_icon_weather;
                nameRes = R.string.ksw_id8_weather;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass6 */

                    public void onClick(View view) {
                        BmwId8SettingsMainActivity.this.bmwId8ViewModel.openWeatherApp(view);
                    }
                });
                break;
            case 2:
                iconRes = R.drawable.id8_main_left_icon_music;
                nameRes = R.string.ksw_id8_music;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass7 */

                    public void onClick(View view) {
                        BmwId8SettingsMainActivity.this.bmwId8ViewModel.openMusicMulti(view);
                    }
                });
                break;
            case 3:
                iconRes = R.drawable.id8_main_left_icon_car;
                nameRes = R.string.ksw_id8_abbr_car_info;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass8 */

                    public void onClick(View view) {
                        BmwId8SettingsMainActivity.this.bmwId8ViewModel.openCar(view);
                    }
                });
                break;
            case 4:
                iconRes = R.drawable.id8_main_left_icon_modus;
                nameRes = R.string.ksw_id8_modus;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass9 */

                    public void onClick(View view) {
                        BmwId8SettingsMainActivity.this.bmwId8ViewModel.enterChangeModus(view);
                        BmwId8SettingsMainActivity.this.finish();
                    }
                });
                break;
            case 5:
                iconRes = R.drawable.id8_main_left_icon_bt;
                nameRes = R.string.ksw_id8_abbr_tel;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass10 */

                    public void onClick(View view) {
                        BmwId8SettingsMainActivity.this.bmwId8ViewModel.openBtApp(view);
                    }
                });
                break;
            case 6:
                iconRes = R.drawable.id8_main_left_icon_dashboard;
                nameRes = R.string.ksw_id8_dashboard;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass11 */

                    public void onClick(View view) {
                        BmwId8SettingsMainActivity.this.bmwId8ViewModel.openDashboard(view);
                    }
                });
                break;
            case 7:
                iconRes = R.drawable.id8_main_left_icon_set;
                nameRes = R.string.ksw_id8_abbr_setting;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass12 */

                    public void onClick(View view) {
                        BmwId8SettingsMainActivity.this.bmwId8ViewModel.openSettings(view);
                    }
                });
                break;
            case '\b':
                iconRes = R.drawable.id8_main_left_icon_video;
                nameRes = R.string.ksw_id8_abbr_hd_video;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsMainActivity.AnonymousClass13 */

                    public void onClick(View view) {
                        BmwId8SettingsMainActivity.this.bmwId8ViewModel.openVideoMulti(view);
                    }
                });
                break;
        }
        if (iconRes != -1) {
            tv.setText(getString(nameRes));
            iv.setImageBitmap(BitmapFactory.decodeResource(getResources(), iconRes));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        Log.i("BmwId8SettingsMainActivity", " onPause ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BmwId8SettingsMainActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BmwId8SettingsMainActivity", " onDestroy ");
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("BmwId8SettingsMainActivity", " dispatchKeyEvent ");
        return super.dispatchKeyEvent(event);
    }
}
