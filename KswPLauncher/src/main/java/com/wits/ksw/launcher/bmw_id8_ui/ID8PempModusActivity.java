package com.wits.ksw.launcher.bmw_id8_ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BmwId8PempModusLayoutBinding;
import com.wits.ksw.launcher.bmw_id8_ui.listener.OnID8SkinChangeListener;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.settings.BaseSkinActivity;

public class ID8PempModusActivity extends BaseSkinActivity {
    private final String TAG = "ID8PempModusActivity";
    private LauncherViewModel bmwId8PempViewModel;
    private String id8CacheLeftIcon3;
    private String id8CacheLeftIcon4;
    private String id8CacheLeftIcon5;
    private BmwId8PempModusLayoutBinding mBinding;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ID8PempModusActivity", " onCreate ");
        setFull();
        setStatusBarTranslucent();
        this.mBinding = (BmwId8PempModusLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_id8_pemp_modus_layout);
        LauncherViewModel launcherViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        this.bmwId8PempViewModel = launcherViewModel;
        launcherViewModel.setActivity(this);
        this.mBinding.setLauncherViewModel(this.bmwId8PempViewModel);
        this.bmwId8PempViewModel.initSkinData(new OnID8SkinChangeListener() {
            /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass1 */

            @Override // com.wits.ksw.launcher.bmw_id8_ui.listener.OnID8SkinChangeListener
            public void onSkinChangeLeftBar(int drawableId) {
                if (ID8PempModusActivity.this.mBinding != null) {
                    ID8PempModusActivity.this.mBinding.bmwId8PempModusMainLeftBar.llLeft4.setBackground(ID8PempModusActivity.this.getDrawable(drawableId));
                    ID8PempModusActivity.this.mBinding.bmwId8PempModusMainLeftBar.llLeft1.setBackground(ID8PempModusActivity.this.getDrawable(drawableId));
                    ID8PempModusActivity.this.mBinding.bmwId8PempModusMainLeftBar.llLeft2.setBackground(ID8PempModusActivity.this.getDrawable(drawableId));
                    ID8PempModusActivity.this.mBinding.bmwId8PempModusMainLeftBar.llLeft3.setBackground(ID8PempModusActivity.this.getDrawable(drawableId));
                    ID8PempModusActivity.this.mBinding.bmwId8PempModusMainLeftBar.llLeft5.setBackground(ID8PempModusActivity.this.getDrawable(drawableId));
                }
            }

            @Override // com.wits.ksw.launcher.bmw_id8_ui.listener.OnID8SkinChangeListener
            public void onSkinChangeCardBGSelector(String skinName) {
            }

            @Override // com.wits.ksw.launcher.bmw_id8_ui.listener.OnID8SkinChangeListener
            public void onSkinChangeMusicAlbum(int drawableId) {
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("ID8PempModusActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("ID8PempModusActivity", " onResume ");
        beforeRefreshLeftBarIcon();
        BmwId8PempModusLayoutBinding bmwId8PempModusLayoutBinding = this.mBinding;
        if (bmwId8PempModusLayoutBinding != null) {
            bmwId8PempModusLayoutBinding.bmwId8PempModusMainLeftBar.llLeft1.setFocusedByDefault(true);
        }
    }

    private void beforeRefreshLeftBarIcon() {
        Log.w("ID8PempModusActivity", "beforeRefreshLeftBarIcon: ");
        if (checkLeftIconHasChange()) {
            refreshLeftBarIcon();
        }
    }

    private boolean checkLeftIconHasChange() {
        return !PempID8LauncherConstants.leftIcon3.equals(this.id8CacheLeftIcon3) || !PempID8LauncherConstants.leftIcon4.equals(this.id8CacheLeftIcon4) || !PempID8LauncherConstants.leftIcon5.equals(this.id8CacheLeftIcon5);
    }

    private void refreshLeftBarIcon() {
        this.id8CacheLeftIcon3 = PempID8LauncherConstants.leftIcon3;
        this.id8CacheLeftIcon4 = PempID8LauncherConstants.leftIcon4;
        this.id8CacheLeftIcon5 = PempID8LauncherConstants.leftIcon5;
        initLeftIcon(this.mBinding.bmwId8PempModusMainLeftBar.llLeft3, this.mBinding.bmwId8PempModusMainLeftBar.ivLeft3, this.mBinding.bmwId8PempModusMainLeftBar.tvLeft3, this.id8CacheLeftIcon3);
        initLeftIcon(this.mBinding.bmwId8PempModusMainLeftBar.llLeft4, this.mBinding.bmwId8PempModusMainLeftBar.ivLeft4, this.mBinding.bmwId8PempModusMainLeftBar.tvLeft4, this.id8CacheLeftIcon4);
        initLeftIcon(this.mBinding.bmwId8PempModusMainLeftBar.llLeft5, this.mBinding.bmwId8PempModusMainLeftBar.ivLeft5, this.mBinding.bmwId8PempModusMainLeftBar.tvLeft5, this.id8CacheLeftIcon5);
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
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 73725445:
                if (name.equals("MUSIC")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 76105038:
                if (name.equals("PHONE")) {
                    c = 3;
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
                    c = 2;
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
                    c = 4;
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
                iconRes = R.drawable.pemp_id8_main_left_icon_navi;
                nameRes = R.string.ksw_id8_abbr_tel_navigate;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass2 */

                    public void onClick(View view) {
                        ID8PempModusActivity.this.bmwId8PempViewModel.openNaviApp();
                    }
                });
                break;
            case 1:
                iconRes = R.drawable.pemp_id8_main_left_icon_music;
                nameRes = R.string.ksw_id8_music;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass3 */

                    public void onClick(View view) {
                        ID8PempModusActivity.this.bmwId8PempViewModel.openMusicMulti(view);
                    }
                });
                break;
            case 2:
                iconRes = R.drawable.pemp_id8_main_left_icon_car;
                nameRes = R.string.ksw_id7_car;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass4 */

                    public void onClick(View view) {
                        ID8PempModusActivity.this.bmwId8PempViewModel.openCar(view);
                    }
                });
                break;
            case 3:
                iconRes = R.drawable.pemp_id8_main_left_icon_bt;
                nameRes = R.string.ksw_id8_abbr_tel;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass5 */

                    public void onClick(View view) {
                        ID8PempModusActivity.this.bmwId8PempViewModel.openBtApp(view);
                    }
                });
                break;
            case 4:
                iconRes = R.drawable.pemp_id8_main_left_icon_weather;
                nameRes = R.string.ksw_id8_weather;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass6 */

                    public void onClick(View view) {
                        ID8PempModusActivity.this.bmwId8PempViewModel.openWeatherApp(view);
                    }
                });
                break;
            case 5:
                iconRes = R.drawable.pemp_id8_main_left_icon_modus;
                nameRes = R.string.ksw_id8_modus;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass7 */

                    public void onClick(View view) {
                        ID8PempModusActivity.this.bmwId8PempViewModel.enterPempChangeModus(view);
                    }
                });
                break;
            case 6:
                iconRes = R.drawable.pemp_id8_main_left_icon_dashboard;
                nameRes = R.string.ksw_id8_dashboard;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass8 */

                    public void onClick(View view) {
                        ID8PempModusActivity.this.bmwId8PempViewModel.openDashboard(view);
                    }
                });
                break;
            case 7:
                iconRes = R.drawable.pemp_id8_main_left_icon_set;
                nameRes = R.string.ksw_id8_abbr_setting;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass9 */

                    public void onClick(View view) {
                        ID8PempModusActivity.this.bmwId8PempViewModel.openSettings(view);
                    }
                });
                break;
            case '\b':
                iconRes = R.drawable.pemp_id8_main_left_icon_video;
                nameRes = R.string.ksw_id8_abbr_hd_video;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8PempModusActivity.AnonymousClass10 */

                    public void onClick(View view) {
                        ID8PempModusActivity.this.bmwId8PempViewModel.openVideoMulti(view);
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
        Log.i("ID8PempModusActivity", " onPause ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("ID8PempModusActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("ID8PempModusActivity", " onDestroy ");
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("ID8PempModusActivity", " dispatchKeyEvent ");
        return super.dispatchKeyEvent(event);
    }
}
