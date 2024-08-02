package com.wits.ksw.launcher.view.id8ug;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityEvoid8LauncherMainBinding;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarAutoPlayFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarDashboardFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarDevicesFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarFavouriteFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarModelFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarMusicFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarNaviFragment;
import com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarSpeedFragment;
import com.wits.ksw.launcher.view.ug.WiewFocusUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Id8UgViewManager {
    private static final String TAG = "Id8UgViewManager";
    private static volatile Id8UgViewManager instance;
    private FragmentActivity activity;
    private ActivityEvoid8LauncherMainBinding binding;
    private int cardItemWidth;
    private List<String> cardNameList;
    public ContentObserver contentObserver;
    private int currentScrollX;
    private List<Fragment> fragmentList;
    private List<Integer> fragmentResIds;
    private boolean isRightCarDoor;
    private View lastRequestView;
    private LauncherViewModel viewModel;

    public static Id8UgViewManager getInstance() {
        if (instance == null) {
            synchronized (Id8UgViewManager.class) {
                if (instance == null) {
                    instance = new Id8UgViewManager();
                }
            }
        }
        return instance;
    }

    public Id8UgViewManager() {
        this.cardItemWidth = 0;
        this.fragmentResIds = new ArrayList();
        this.cardNameList = new ArrayList();
        this.fragmentList = new ArrayList();
        this.currentScrollX = 0;
        this.contentObserver = new ContentObserver(new Handler()) {
            /* class com.wits.ksw.launcher.view.id8ug.Id8UgViewManager.AnonymousClass1 */

            public void onChange(boolean selfChange, Uri uri) {
                Id8UgViewManager.this.setLayoutBg();
            }
        };
        this.cardItemWidth = ((KswApplication.appContext.getResources().getDisplayMetrics().widthPixels - 120) / 4) - 20;
    }

    public void resumeMainViewData() {
        this.fragmentResIds.clear();
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content1));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content2));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content3));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content4));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content5));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content6));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content7));
        this.fragmentResIds.add(Integer.valueOf((int) R.id.fl_content8));
        try {
            this.isRightCarDoor = PowerManagerApp.getSettingsInt(KeyConfig.CAR_DOOR_SELECT) == 1;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        addCardNameList();
        initFragmentView();
        this.activity.getContentResolver().registerContentObserver(Settings.System.getUriFor(Id8UgConstants.ID8UG_SKIN_MODEL), true, this.contentObserver);
        setLayoutBg();
    }

    public void initView(FragmentActivity activity2, ActivityEvoid8LauncherMainBinding binding2, LauncherViewModel viewModel2) {
        this.activity = activity2;
        this.binding = binding2;
        this.viewModel = viewModel2;
        binding2.scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$8yQq0aOFNiUMk6EvMe1swSuPPRA */

            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                Id8UgViewManager.this.lambda$initView$0$Id8UgViewManager(view, i, i2, i3, i4);
            }
        });
        binding2.llLeftContainer.ivLeft1.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$qqoglKfRjgoA3uMNuEU5WmKzvs */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$1$Id8UgViewManager(this.f$1, view);
            }
        });
        binding2.llLeftContainer.ivLeft2.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$EbbQAllfHMedtWxkBTncLai2IaA */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$2$Id8UgViewManager(this.f$1, view);
            }
        });
        binding2.llLeftContainer.ivLeft3.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$XBxrV1R_yXc4GRyxKUhjVMWzBbE */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$3$Id8UgViewManager(this.f$1, view);
            }
        });
        binding2.llLeftContainer.ivLeft4.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$p_fSjpu68tnKEk0lusfBzXpJzo */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$4$Id8UgViewManager(this.f$1, view);
            }
        });
        binding2.llLeftContainer.ivLeft5.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$1wPCQqlfrLt6ExsduonRE0bsn4 */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$5$Id8UgViewManager(this.f$1, view);
            }
        });
        binding2.llRightContainer.ivRight1.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$fpKTgqvKD_B_66Po5SuHNKqTXlM */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$6$Id8UgViewManager(this.f$1, view);
            }
        });
        binding2.llRightContainer.ivRight2.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$AW_dz4u2jay6q5TPjCbS2o89IU */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$7$Id8UgViewManager(this.f$1, view);
            }
        });
        binding2.llRightContainer.ivRight3.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$XoOyrxjYm91bS45z98P0U0ZgyKo */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$8$Id8UgViewManager(this.f$1, view);
            }
        });
        binding2.llRightContainer.ivRight4.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$26I9H3HrnIvxO7lM8eyf719UCs0 */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$9$Id8UgViewManager(this.f$1, view);
            }
        });
        binding2.llRightContainer.ivRight5.setOnClickListener(new View.OnClickListener(viewModel2) {
            /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$HDqAhmN0bpAXA4v2mlJxCEgE86s */
            public final /* synthetic */ LauncherViewModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                Id8UgViewManager.this.lambda$initView$10$Id8UgViewManager(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$Id8UgViewManager(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        this.currentScrollX = scrollX;
        Log.i(TAG, "setOnScrollChangeListener scrollX: " + scrollX);
    }

    public /* synthetic */ void lambda$initView$1$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openNaviApp(v);
    }

    public /* synthetic */ void lambda$initView$2$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openShouJiHuLian(v);
    }

    public /* synthetic */ void lambda$initView$3$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openBtApp(v);
    }

    public /* synthetic */ void lambda$initView$4$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openAllApp(v);
    }

    public /* synthetic */ void lambda$initView$5$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openSettings(v);
    }

    public /* synthetic */ void lambda$initView$6$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openNaviApp(v);
    }

    public /* synthetic */ void lambda$initView$7$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openShouJiHuLian(v);
    }

    public /* synthetic */ void lambda$initView$8$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openBtApp(v);
    }

    public /* synthetic */ void lambda$initView$9$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openAllApp(v);
    }

    public /* synthetic */ void lambda$initView$10$Id8UgViewManager(LauncherViewModel viewModel2, View v) {
        setLastRequestView(v);
        viewModel2.openSettings(v);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setLayoutBg() {
        boolean isNightModel = TextUtils.equals(Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT, Settings.System.getString(this.activity.getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL));
        this.binding.id8UgMain.setBackgroundResource(isNightModel ? R.drawable.evoid8_main_bg_shape_night : R.drawable.evoid8_main_bg_shape);
        try {
            boolean z = true;
            if (PowerManagerApp.getSettingsInt(KeyConfig.CAR_DOOR_SELECT) != 1) {
                z = false;
            }
            this.isRightCarDoor = z;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        boolean z2 = this.isRightCarDoor;
        int i = R.drawable.bmw_evoid8_main_icon_settings_night;
        int i2 = R.drawable.bmw_evoid8_main_icon_apps_night;
        int i3 = R.drawable.bmw_evoid8_main_icon_bluetooth_night;
        int i4 = R.drawable.bmw_evoid8_main_icon_carplay_night;
        int i5 = R.drawable.bmw_evoid8_main_icon_nvai_night;
        if (z2) {
            this.binding.llRightContainer.llRightBarContainer.setImageResource(isNightModel ? R.drawable.evoid8_main_right_bg_night : R.drawable.evoid8_main_right_bg);
            ImageView imageView = this.binding.llRightContainer.ivRight1;
            if (!isNightModel) {
                i5 = R.drawable.bmw_evoid8_main_icon_nvai;
            }
            imageView.setImageResource(i5);
            ImageView imageView2 = this.binding.llRightContainer.ivRight2;
            if (!isNightModel) {
                i4 = R.drawable.bmw_evoid8_main_icon_carplay;
            }
            imageView2.setImageResource(i4);
            ImageView imageView3 = this.binding.llRightContainer.ivRight3;
            if (!isNightModel) {
                i3 = R.drawable.bmw_evoid8_main_icon_bluetooth;
            }
            imageView3.setImageResource(i3);
            ImageView imageView4 = this.binding.llRightContainer.ivRight4;
            if (!isNightModel) {
                i2 = R.drawable.bmw_evoid8_main_icon_apps;
            }
            imageView4.setImageResource(i2);
            ImageView imageView5 = this.binding.llRightContainer.ivRight5;
            if (!isNightModel) {
                i = R.drawable.bmw_evoid8_main_icon_settings;
            }
            imageView5.setImageResource(i);
            return;
        }
        this.binding.llLeftContainer.llLeftBarContainer.setImageResource(isNightModel ? R.drawable.evoid8_main_left_bg_night : R.drawable.evoid8_main_left_bg);
        ImageView imageView6 = this.binding.llLeftContainer.ivLeft1;
        if (!isNightModel) {
            i5 = R.drawable.bmw_evoid8_main_icon_nvai;
        }
        imageView6.setImageResource(i5);
        ImageView imageView7 = this.binding.llLeftContainer.ivLeft2;
        if (!isNightModel) {
            i4 = R.drawable.bmw_evoid8_main_icon_carplay;
        }
        imageView7.setImageResource(i4);
        ImageView imageView8 = this.binding.llLeftContainer.ivLeft3;
        if (!isNightModel) {
            i3 = R.drawable.bmw_evoid8_main_icon_bluetooth;
        }
        imageView8.setImageResource(i3);
        ImageView imageView9 = this.binding.llLeftContainer.ivLeft4;
        if (!isNightModel) {
            i2 = R.drawable.bmw_evoid8_main_icon_apps;
        }
        imageView9.setImageResource(i2);
        ImageView imageView10 = this.binding.llLeftContainer.ivLeft5;
        if (!isNightModel) {
            i = R.drawable.bmw_evoid8_main_icon_settings;
        }
        imageView10.setImageResource(i);
    }

    public void onActivityStop() {
        try {
            FragmentActivity fragmentActivity = this.activity;
            if (fragmentActivity != null) {
                fragmentActivity.getContentResolver().unregisterContentObserver(this.contentObserver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addCardNameList() {
        this.cardNameList.clear();
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
        FragmentTransaction transaction = this.activity.getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < this.cardNameList.size(); i++) {
            Fragment fragment = null;
            Log.i(TAG, "initFragmentView: " + this.cardNameList.get(i) + " position: " + i);
            String cardName = this.cardNameList.get(i);
            View view = this.activity.findViewById(this.fragmentResIds.get(i).intValue());
            if (Id8UgConstants.ID8UG_FRAGMENT_CAR_SPEED.equals(cardName)) {
                fragment = new Id8UgCarSpeedFragment();
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_AUTO_PLAY.equals(cardName)) {
                fragment = new Id8UgCarAutoPlayFragment();
                view.setTag(Id8UgConstants.ID8_UG_CARD_TAG_AUTO_PLAY);
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_MUSIC.equals(cardName)) {
                fragment = new Id8UgCarMusicFragment();
                view.setTag(Id8UgConstants.ID8_UG_CARD_TAG_MUSIC);
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_MODEL.equals(cardName)) {
                fragment = new Id8UgCarModelFragment();
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_DEVICES.equals(cardName)) {
                fragment = new Id8UgCarDevicesFragment();
                view.setTag(Id8UgConstants.ID8_UG_CARD_TAG_DEVICE);
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_DASHBOARD.equals(cardName)) {
                fragment = new Id8UgCarDashboardFragment();
                view.setTag(Id8UgConstants.ID8_UG_CARD_TAG_DASHBOARD);
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_NAVI.equals(cardName)) {
                fragment = new Id8UgCarNaviFragment();
                view.setTag(Id8UgConstants.ID8_UG_CARD_TAG_NAVI);
            } else if (Id8UgConstants.ID8UG_FRAGMENT_CAR_FAVOUR.equals(cardName)) {
                fragment = new Id8UgCarFavouriteFragment();
            }
            if (fragment != null && i < this.fragmentResIds.size()) {
                this.fragmentList.add(fragment);
                transaction.replace(this.fragmentResIds.get(i).intValue(), fragment);
            }
        }
        transaction.commitNow();
        ActivityEvoid8LauncherMainBinding activityEvoid8LauncherMainBinding = this.binding;
        if (activityEvoid8LauncherMainBinding != null) {
            activityEvoid8LauncherMainBinding.scrollView.scrollTo(this.currentScrollX, 0);
            this.binding.scrollView.postDelayed(new Runnable() {
                /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgViewManager$akaAKG23FDDDumAxTRaGRrRRRwY */

                public final void run() {
                    Id8UgViewManager.this.lambda$initFragmentView$11$Id8UgViewManager();
                }
            }, 300);
        }
    }

    public /* synthetic */ void lambda$initFragmentView$11$Id8UgViewManager() {
        View view = this.lastRequestView;
        if (view != null) {
            setLastRequestView(view);
        } else if (this.isRightCarDoor) {
            setLastRequestView(this.binding.llRightContainer.ivRight1);
        } else {
            setLastRequestView(this.binding.llLeftContainer.ivLeft1);
        }
    }

    public void setLastRequestView(View lastRequestView2) {
        this.lastRequestView = lastRequestView2;
        WiewFocusUtils.setViewRequestFocus(lastRequestView2);
    }

    public void setOnClickLastRequestView(String fragmentTag) {
        View requestView;
        int position = this.cardNameList.indexOf(fragmentTag);
        if (position != -1 && position < this.fragmentResIds.size() && (requestView = this.activity.findViewById(this.fragmentResIds.get(position).intValue())) != null) {
            setLastRequestView(requestView);
        }
    }

    public boolean dispatchMainKeyEvent(KeyEvent event) {
        View requestView;
        int scrollPosition;
        int scrollPosition2;
        boolean isBtMusicModel = false;
        if (event.getAction() == 0) {
            int type = event.getKeyCode();
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus == null) {
                return false;
            }
            int requestViewId = -1;
            switch (type) {
                case 19:
                    requestViewId = currentFocus.getNextFocusUpId();
                    break;
                case 20:
                    requestViewId = currentFocus.getNextFocusDownId();
                    break;
                case 21:
                    Object tagObjLeft = currentFocus.getTag();
                    requestViewId = currentFocus.getNextFocusRightId();
                    if (tagObjLeft != null) {
                        String tag = tagObjLeft.toString();
                        if (!TextUtils.isEmpty(tag) && tag.contains("Id8ugRight") && (scrollPosition = this.currentScrollX / this.cardItemWidth) > 0 && scrollPosition <= this.fragmentResIds.size()) {
                            requestViewId = this.fragmentResIds.get(scrollPosition).intValue();
                            break;
                        }
                    }
                    break;
                case 22:
                    Object tagObjRight = currentFocus.getTag();
                    requestViewId = currentFocus.getNextFocusRightId();
                    if (tagObjRight != null) {
                        String tag2 = tagObjRight.toString();
                        if (!TextUtils.isEmpty(tag2) && tag2.contains("Id8ugLeft") && (scrollPosition2 = this.currentScrollX / this.cardItemWidth) > 0 && scrollPosition2 <= this.fragmentResIds.size()) {
                            requestViewId = this.fragmentResIds.get(scrollPosition2).intValue();
                            break;
                        }
                    }
                    break;
                case 66:
                    Object tagObj = currentFocus.getTag();
                    if (tagObj != null) {
                        String tag3 = tagObj.toString();
                        if (Id8UgConstants.ID8_UG_CARD_TAG_AUTO_PLAY.equals(tag3)) {
                            this.viewModel.openShouJiHuLian(currentFocus);
                            return true;
                        } else if (Id8UgConstants.ID8_UG_CARD_TAG_MUSIC.equals(tag3)) {
                            if (SpfUtils.getInt(Id8UgConstants.ID8UG_MUSIC_SELECT_MODEL, 0) == 1) {
                                isBtMusicModel = true;
                            }
                            if (isBtMusicModel) {
                                this.viewModel.openBtApp(currentFocus);
                            } else {
                                this.viewModel.openMusicMulti(currentFocus);
                            }
                            return true;
                        } else if (Id8UgConstants.ID8_UG_CARD_TAG_DEVICE.equals(tag3)) {
                            this.viewModel.openCar(currentFocus);
                            return true;
                        } else if (Id8UgConstants.ID8_UG_CARD_TAG_DASHBOARD.equals(tag3)) {
                            this.viewModel.openDashboard(currentFocus);
                            return true;
                        } else if (Id8UgConstants.ID8_UG_CARD_TAG_NAVI.equals(tag3)) {
                            this.viewModel.openNaviApp(currentFocus);
                            return true;
                        }
                    }
                    break;
            }
            if (!(requestViewId == -1 || (requestView = this.activity.findViewById(requestViewId)) == null)) {
                setLastRequestView(requestView);
                return true;
            }
        }
        return false;
    }
}
