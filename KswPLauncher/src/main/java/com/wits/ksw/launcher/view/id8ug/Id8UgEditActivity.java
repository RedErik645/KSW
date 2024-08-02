package com.wits.ksw.launcher.view.id8ug;

import android.arch.lifecycle.ViewModelProviders;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.SkinAppCompatDelegateImpl;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.HorizontalScrollView;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityEvoid8MainEditBinding;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarAutoPlayFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarDashboardFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarDevicesFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarFavouriteFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarModelFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarMusicFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarNaviFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarSpeedFragment;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Id8UgEditActivity extends AppCompatActivity {
    private static final String TAG = Id8UgEditActivity.class.getName();
    private float autoScrollLeftPosition;
    private float autoScrollRightPosition;
    private ActivityEvoid8MainEditBinding binding;
    private List<String> cardNameList = new ArrayList();
    public ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.id8ug.Id8UgEditActivity.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            Id8UgEditActivity.this.setLayoutBg();
        }
    };
    private int currentScrollX;
    private int currentScrollY;
    private List<Fragment> fragmentList = new ArrayList();
    private List<Integer> fragmentResIds = new ArrayList();
    private boolean isRightCarDoor = false;
    private int mScreenWidth;
    private int offsetX = 20;
    private HorizontalScrollView scrollView;
    private LauncherViewModel viewModel;

    public void setStatusBarTranslucent() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        KswUtils.setFull(getWindow());
        setStatusBarTranslucent();
        super.onCreate(savedInstanceState);
        ActivityEvoid8MainEditBinding inflate = ActivityEvoid8MainEditBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView(inflate.getRoot());
        LauncherViewModel launcherViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        this.viewModel = launcherViewModel;
        launcherViewModel.setActivity(this);
        this.viewModel.initData();
        this.binding.setLauncherViewModel(this.viewModel);
        try {
            this.isRightCarDoor = PowerManagerApp.getSettingsInt(KeyConfig.CAR_DOOR_SELECT) == 1;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.scrollView = this.binding.scrollView;
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content1));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content2));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content3));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content4));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content5));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content6));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content7));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content8));
        addCardNameList();
        initFragmentView();
        initListener();
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Id8UgConstants.ID8UG_SKIN_MODEL), true, this.contentObserver);
        setLayoutBg();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setLayoutBg() {
        this.binding.id8UgMain.setBackgroundResource(TextUtils.equals(Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT, Settings.System.getString(getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL)) ? R.drawable.evoid8_main_bg_shape_night : R.drawable.evoid8_main_bg_shape);
    }

    private void addCardNameList() {
        String cardStr = SpfUtils.getString(Id8UgConstants.ID8UG_FRAGMENT_CARD_SORT_LIST, "");
        if (TextUtils.isEmpty(cardStr)) {
            this.cardNameList.add(Id8UgConstants.ID8UG_FRAGMENT_CAR_SPEED);
            this.cardNameList.add(Id8UgConstants.ID8UG_FRAGMENT_CAR_AUTO_PLAY);
            this.cardNameList.add(Id8UgConstants.ID8UG_FRAGMENT_CAR_MUSIC);
            this.cardNameList.add(Id8UgConstants.ID8UG_FRAGMENT_CAR_MODEL);
            this.cardNameList.add(Id8UgConstants.ID8UG_FRAGMENT_CAR_DEVICES);
            this.cardNameList.add(Id8UgConstants.ID8UG_FRAGMENT_CAR_DASHBOARD);
            this.cardNameList.add(Id8UgConstants.ID8UG_FRAGMENT_CAR_NAVI);
            this.cardNameList.add(Id8UgConstants.ID8UG_FRAGMENT_CAR_FAVOUR);
            SpfUtils.saveData(Id8UgConstants.ID8UG_FRAGMENT_CARD_SORT_LIST, Id8UgEditActivity$$ExternalSynthetic0.m0(";", this.cardNameList));
            return;
        }
        this.cardNameList.addAll(Arrays.asList(cardStr.split(";")));
    }

    private void initFragmentView() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < this.cardNameList.size(); i++) {
            Fragment fragment = null;
            Log.i("Id8UgViewManager", "initFragmentView: " + this.cardNameList.get(i) + " position: " + i);
            String cardName = this.cardNameList.get(i);
            if (Id8UgConstants.ID8UG_FRAGMENT_CAR_SPEED.equals(cardName)) {
                fragment = new Id8UgCarSpeedFragment();
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_AUTO_PLAY.equals(cardName)) {
                fragment = new Id8UgCarAutoPlayFragment();
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_MUSIC.equals(cardName)) {
                fragment = new Id8UgCarMusicFragment();
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_MODEL.equals(cardName)) {
                fragment = new Id8UgCarModelFragment();
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_DEVICES.equals(cardName)) {
                fragment = new Id8UgCarDevicesFragment();
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_DASHBOARD.equals(cardName)) {
                fragment = new Id8UgCarDashboardFragment();
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_NAVI.equals(cardName)) {
                fragment = new Id8UgCarNaviFragment();
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_FAVOUR.equals(cardName)) {
                fragment = new Id8UgCarFavouriteFragment();
            }
            if (fragment != null && i < this.fragmentResIds.size()) {
                this.fragmentList.add(fragment);
                transaction.replace(this.fragmentResIds.get(i).intValue(), fragment);
            }
        }
        transaction.commitNow();
    }

    private void initListener() {
        int i = getResources().getDisplayMetrics().widthPixels;
        this.mScreenWidth = i;
        this.autoScrollLeftPosition = ((float) i) * 0.2f;
        this.autoScrollRightPosition = ((float) i) * 0.9f;
        this.scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgEditActivity$45QyUng_7vAuLLXWTJlxIGX1K8 */

            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                Id8UgEditActivity.this.lambda$initListener$0$Id8UgEditActivity(view, i, i2, i3, i4);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$Id8UgEditActivity(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        this.currentScrollX = scrollX;
        this.currentScrollY = scrollY;
    }

    public void checkAutoScroll(float fingerX) {
        if (this.autoScrollLeftPosition >= fingerX) {
            if (fingerX >= 0.0f) {
                int i = this.currentScrollX - this.offsetX;
                this.currentScrollX = i;
                this.scrollView.scrollTo(i, this.currentScrollY);
            }
        } else if (fingerX >= this.autoScrollRightPosition && fingerX <= ((float) this.mScreenWidth)) {
            int i2 = this.currentScrollX + this.offsetX;
            this.currentScrollX = i2;
            this.scrollView.scrollTo(i2, this.currentScrollY);
        }
    }

    public void sort(String dragName, String releaseName) {
        if (!dragName.equals(releaseName)) {
            int dragPosition = this.cardNameList.indexOf(dragName);
            int releasePosition = this.cardNameList.indexOf(releaseName);
            Log.i(TAG, "sort: dragName = " + dragName + " releaseName = " + releaseName + " releasePosition = " + releasePosition + " dragPosition = " + dragPosition);
            if (dragPosition != -1 && releasePosition != -1) {
                Collections.swap(this.cardNameList, dragPosition, releasePosition);
                int tempX = this.currentScrollX;
                int tempY = this.currentScrollY;
                SpfUtils.saveData(Id8UgConstants.ID8UG_FRAGMENT_CARD_SORT_LIST, Id8UgEditActivity$$ExternalSynthetic0.m0(";", this.cardNameList));
                initFragmentView();
                this.scrollView.scrollTo(tempX, tempY);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatActivity
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }
}
