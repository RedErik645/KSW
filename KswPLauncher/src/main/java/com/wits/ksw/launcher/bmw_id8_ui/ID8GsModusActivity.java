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
import com.wits.ksw.databinding.BmwId8gsModusLayoutBinding;
import com.wits.ksw.launcher.bmw_id8_ui.listener.OnID8SkinChangeListener;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.settings.BaseSkinActivity;

public class ID8GsModusActivity extends BaseSkinActivity {
    private final String TAG = "ID8GsModusActivity";
    private LauncherViewModel bmwId8GsViewModel;
    private String id8CacheLeftIcon3;
    private String id8CacheLeftIcon4;
    private String id8CacheLeftIcon5;
    private BmwId8gsModusLayoutBinding mBinding;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ID8GsModusActivity", " onCreate ");
        setFull();
        setStatusBarTranslucent();
        this.mBinding = (BmwId8gsModusLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_id8_gs_modus_layout);
        LauncherViewModel launcherViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        this.bmwId8GsViewModel = launcherViewModel;
        launcherViewModel.setActivity(this);
        this.mBinding.setLauncherViewModel(this.bmwId8GsViewModel);
        this.bmwId8GsViewModel.initSkinData(new OnID8SkinChangeListener() {
            /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass1 */

            @Override // com.wits.ksw.launcher.bmw_id8_ui.listener.OnID8SkinChangeListener
            public void onSkinChangeLeftBar(int drawableId) {
                if (ID8GsModusActivity.this.mBinding != null) {
                    ID8GsModusActivity.this.mBinding.bmwId8GsModusMainLeftBar.llLeft4.setBackground(ID8GsModusActivity.this.getDrawable(drawableId));
                    ID8GsModusActivity.this.mBinding.bmwId8GsModusMainLeftBar.llLeft1.setBackground(ID8GsModusActivity.this.getDrawable(drawableId));
                    ID8GsModusActivity.this.mBinding.bmwId8GsModusMainLeftBar.llLeft2.setBackground(ID8GsModusActivity.this.getDrawable(drawableId));
                    ID8GsModusActivity.this.mBinding.bmwId8GsModusMainLeftBar.llLeft3.setBackground(ID8GsModusActivity.this.getDrawable(drawableId));
                    ID8GsModusActivity.this.mBinding.bmwId8GsModusMainLeftBar.llLeft5.setBackground(ID8GsModusActivity.this.getDrawable(drawableId));
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
        Log.i("ID8GsModusActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("ID8GsModusActivity", " onResume ");
        beforeRefreshLeftBarIcon();
        BmwId8gsModusLayoutBinding bmwId8gsModusLayoutBinding = this.mBinding;
        if (bmwId8gsModusLayoutBinding != null) {
            bmwId8gsModusLayoutBinding.bmwId8GsModusMainLeftBar.llLeft1.setFocusedByDefault(true);
        }
    }

    private void beforeRefreshLeftBarIcon() {
        Log.w("ID8GsModusActivity", "beforeRefreshLeftBarIcon: ");
        if (checkLeftIconHasChange()) {
            refreshLeftBarIcon();
        }
    }

    private boolean checkLeftIconHasChange() {
        if (!GSID8LauncherConstants.leftIcon3.equals(this.id8CacheLeftIcon3) || !GSID8LauncherConstants.leftIcon4.equals(this.id8CacheLeftIcon4) || !GSID8LauncherConstants.leftIcon5.equals(this.id8CacheLeftIcon5)) {
            return true;
        }
        return false;
    }

    private void refreshLeftBarIcon() {
        this.id8CacheLeftIcon3 = GSID8LauncherConstants.leftIcon3;
        this.id8CacheLeftIcon4 = GSID8LauncherConstants.leftIcon4;
        this.id8CacheLeftIcon5 = GSID8LauncherConstants.leftIcon5;
        initLeftIcon(this.mBinding.bmwId8GsModusMainLeftBar.llLeft3, this.mBinding.bmwId8GsModusMainLeftBar.ivLeft3, this.mBinding.bmwId8GsModusMainLeftBar.tvLeft3, this.id8CacheLeftIcon3);
        initLeftIcon(this.mBinding.bmwId8GsModusMainLeftBar.llLeft4, this.mBinding.bmwId8GsModusMainLeftBar.ivLeft4, this.mBinding.bmwId8GsModusMainLeftBar.tvLeft4, this.id8CacheLeftIcon4);
        initLeftIcon(this.mBinding.bmwId8GsModusMainLeftBar.llLeft5, this.mBinding.bmwId8GsModusMainLeftBar.ivLeft5, this.mBinding.bmwId8GsModusMainLeftBar.tvLeft5, this.id8CacheLeftIcon5);
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
                iconRes = R.drawable.id8_gs_main_left_icon_navi;
                nameRes = R.string.ksw_id8_abbr_tel_navigate;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass2 */

                    public void onClick(View view) {
                        ID8GsModusActivity.this.bmwId8GsViewModel.openNaviApp();
                    }
                });
                break;
            case 1:
                iconRes = R.drawable.id8_gs_main_left_icon_music;
                nameRes = R.string.ksw_id8_music;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass3 */

                    public void onClick(View view) {
                        ID8GsModusActivity.this.bmwId8GsViewModel.openMusicMulti(view);
                    }
                });
                break;
            case 2:
                iconRes = R.drawable.id8_gs_main_left_icon_car;
                nameRes = R.string.ksw_id7_car;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass4 */

                    public void onClick(View view) {
                        ID8GsModusActivity.this.bmwId8GsViewModel.openCar(view);
                    }
                });
                break;
            case 3:
                iconRes = R.drawable.id8_gs_main_left_icon_bt;
                nameRes = R.string.ksw_id8_abbr_tel;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass5 */

                    public void onClick(View view) {
                        ID8GsModusActivity.this.bmwId8GsViewModel.openBtApp(view);
                    }
                });
                break;
            case 4:
                iconRes = R.drawable.id8_main_left_icon_weather;
                nameRes = R.string.ksw_id8_weather;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass6 */

                    public void onClick(View view) {
                        ID8GsModusActivity.this.bmwId8GsViewModel.openWeatherApp(view);
                    }
                });
                break;
            case 5:
                iconRes = R.drawable.id8_main_left_icon_modus;
                nameRes = R.string.ksw_id8_modus;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass7 */

                    public void onClick(View view) {
                        ID8GsModusActivity.this.bmwId8GsViewModel.enterGsChangeModus(view);
                    }
                });
                break;
            case 6:
                iconRes = R.drawable.id8_main_left_icon_dashboard;
                nameRes = R.string.ksw_id8_dashboard;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass8 */

                    public void onClick(View view) {
                        ID8GsModusActivity.this.bmwId8GsViewModel.openDashboard(view);
                    }
                });
                break;
            case 7:
                iconRes = R.drawable.id8_main_left_icon_set;
                nameRes = R.string.ksw_id8_abbr_setting;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass9 */

                    public void onClick(View view) {
                        ID8GsModusActivity.this.bmwId8GsViewModel.openSettings(view);
                    }
                });
                break;
            case '\b':
                iconRes = R.drawable.id8_main_left_icon_video;
                nameRes = R.string.ksw_id8_abbr_hd_video;
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.launcher.bmw_id8_ui.ID8GsModusActivity.AnonymousClass10 */

                    public void onClick(View view) {
                        ID8GsModusActivity.this.bmwId8GsViewModel.openVideoMulti(view);
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
        Log.i("ID8GsModusActivity", " onPause ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("ID8GsModusActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("ID8GsModusActivity", " onDestroy ");
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("ID8GsModusActivity", " dispatchKeyEvent ");
        return super.dispatchKeyEvent(event);
    }
}
