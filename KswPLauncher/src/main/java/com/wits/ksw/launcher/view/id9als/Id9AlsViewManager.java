package com.wits.ksw.launcher.view.id9als;

import android.app.Activity;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ViewId9AlsAddCardBinding;
import com.wits.ksw.databinding.ViewId9AlsBoardBinding;
import com.wits.ksw.databinding.ViewId9AlsBtBinding;
import com.wits.ksw.databinding.ViewId9AlsCarInfoBinding;
import com.wits.ksw.databinding.ViewId9AlsModelBinding;
import com.wits.ksw.databinding.ViewId9AlsMusicBinding;
import com.wits.ksw.databinding.ViewId9AlsNaviBinding;
import com.wits.ksw.databinding.ViewId9AlsSettingBinding;
import com.wits.ksw.databinding.ViewId9AlsThirdBinding;
import com.wits.ksw.databinding.ViewId9AlsVideoBinding;
import com.wits.ksw.databinding.ViewId9AlsWeatherBinding;
import com.wits.ksw.launcher.bmw_id8_ui.ID8LauncherConstants;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.AppInfoUtils;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.id9als.activity.Id9ChangeModelOrWallpaperActivity;
import com.wits.ksw.launcher.view.id9als.adapter.Id9AlsViewPagerAdapter;
import com.wits.ksw.launcher.view.id9als.fragment.Id9MainSettingDialog;
import com.wits.ksw.launcher.view.id9als.listener.Id9CardSortChangeListener;
import com.wits.ksw.launcher.view.id9als.listener.Id9DialogFocusLeaveListener;
import com.wits.ksw.launcher.view.id9als.listener.Id9LongClickListener;
import com.wits.ksw.launcher.view.id9als.listener.Id9OnDragListener;
import com.wits.ksw.launcher.view.ug.WiewFocusUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Id9AlsViewManager {
    public static String TAG = Id9AlsViewManager.class.getName();
    public static List<String> id9CardSortList = new ArrayList();
    private static volatile Id9AlsViewManager instance;
    private View freedomFocusView;
    IContentObserver illObserver = new IContentObserver.Stub() {
        /* class com.wits.ksw.launcher.view.id9als.Id9AlsViewManager.AnonymousClass2 */

        @Override // com.wits.pms.IContentObserver
        public void onChange() throws RemoteException {
            Id9AlsViewManager.this.setAmapAutoDayNightMode();
            Id9AlsViewManager.this.changeNormalWallpaper(false);
        }
    };
    private boolean isEdit = false;
    private boolean isLayoutModelRtl = false;
    private ImageView[] ivWitstekIndicator;
    private View lastRequestView;
    private long lastScrollTime = 0;
    private ImageView leftFocusView;
    private Id9CardSortChangeListener listener;
    private Activity mActivity;
    private Context mContext;
    private List<View> mListViewData;
    private int mPagePosition = 0;
    private ViewPager mViewpager;
    private View mainSettingView;
    private LinearLayout pointLayout;
    private ImageView rightFocusView;
    private Id9MainSettingDialog settingDialog;
    private int totalPage = 0;
    private ImageView upperFocusView;
    private LauncherViewModel viewModel;

    public static Id9AlsViewManager getInstance() {
        if (instance == null) {
            synchronized (Id9AlsViewManager.class) {
                if (instance == null) {
                    instance = new Id9AlsViewManager();
                }
            }
        }
        return instance;
    }

    public void initData(Context mContext2, ViewPager mViewpager2, LinearLayout pointLayout2, LauncherViewModel viewModel2) {
        this.viewModel = viewModel2;
        this.mViewpager = mViewpager2;
        this.mContext = mContext2;
        this.pointLayout = pointLayout2;
        try {
            this.isLayoutModelRtl = Id9AlsConstants.ID9ALS_LAYOUT_MODEL_RTL.equals(PowerManagerApp.getSettingsString(Id9AlsConstants.ID9ALS_LAYOUT_MODEL));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Id9AlsConstants.setLayoutModel();
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void notifyDataChanged(boolean isEdit2) {
        this.isEdit = isEdit2;
        getId9CardSortString();
        List<View> id9CardViewList = getId9CardViewList();
        this.mListViewData = id9CardViewList;
        int totalDataSize = id9CardViewList.size();
        this.totalPage = (int) Math.ceil((((double) totalDataSize) * 1.0d) / 2.0d);
        LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        List<View> viewPagerList = new ArrayList<>();
        for (int i = 0; i < this.totalPage; i++) {
            View viewPagerItemView = inflater.inflate(R.layout.item_id9_home_viewpager, (ViewGroup) null, false);
            int count = Math.min((i + 1) * 2, totalDataSize);
            FrameLayout oneLayout = (FrameLayout) viewPagerItemView.findViewById(R.id.frame_OneLayout);
            FrameLayout twoLayout = (FrameLayout) viewPagerItemView.findViewById(R.id.frame_TwoLayout);
            for (int j = i * 2; j < count; j++) {
                if (j < this.mListViewData.size()) {
                    if (j % 2 == 0) {
                        oneLayout.addView(this.mListViewData.get(j));
                    } else {
                        twoLayout.addView(this.mListViewData.get(j));
                    }
                }
            }
            viewPagerList.add(viewPagerItemView);
        }
        this.mViewpager.setAdapter(new Id9AlsViewPagerAdapter(viewPagerList));
        this.mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.wits.ksw.launcher.view.id9als.Id9AlsViewManager.AnonymousClass1 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                try {
                    Id9AlsViewManager.this.mPagePosition = position;
                    Id9AlsViewManager.this.initIndicator();
                    Log.i(Id9AlsViewManager.TAG, "firstViewRequestFocus: position = " + position);
                    Id9AlsViewManager id9AlsViewManager = Id9AlsViewManager.this;
                    id9AlsViewManager.viewRequestFocus(((View) id9AlsViewManager.mListViewData.get(position * 2)).findViewById(R.id.id9_card_view));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }
        });
        int i2 = this.mPagePosition;
        int i3 = this.totalPage;
        if (i2 >= i3 && i3 > 0) {
            this.mPagePosition = i3 - 1;
        }
        this.mViewpager.setCurrentItem(this.mPagePosition);
        initIndicator();
    }

    public List<View> getId9CardViewList() {
        List<View> viewList = new ArrayList<>();
        for (String card : id9CardSortList) {
            View cardView = null;
            Log.i(TAG, "getId9CardViewList card: " + card);
            if (card.startsWith("3rd")) {
                viewList.add(getThirdView(card));
            } else {
                char c = 65535;
                switch (card.hashCode()) {
                    case -1967068853:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_NAVI)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1864579729:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_CAR)) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1307073737:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_BT)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -921292785:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_WEATHER)) {
                            c = 6;
                            break;
                        }
                        break;
                    case -860277311:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_BOARD)) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -850116092:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_MODEL)) {
                            c = 7;
                            break;
                        }
                        break;
                    case -841983146:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_VIDEO)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -621760553:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_MUSIC)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -158792085:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_SETTING)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1002925438:
                        if (card.equals(Id9AlsConstants.ID9ALS_VIEW_ADD_APP)) {
                            c = '\t';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        cardView = getId9MusicView();
                        break;
                    case 1:
                        cardView = getId9BtView();
                        break;
                    case 2:
                        cardView = getId9VideoView();
                        break;
                    case 3:
                        cardView = getId9NaviView();
                        break;
                    case 4:
                        cardView = getId9CarInfoView();
                        break;
                    case 5:
                        cardView = getId9SettingView();
                        break;
                    case 6:
                        cardView = getId9WeatherView();
                        break;
                    case 7:
                        cardView = getId9ModelView();
                        break;
                    case '\b':
                        cardView = getId9BoardView();
                        break;
                    case '\t':
                        if (!this.isEdit) {
                            cardView = getId9AddCardView();
                            break;
                        }
                        break;
                }
                if (cardView != null) {
                    viewList.add(cardView);
                }
            }
        }
        return viewList;
    }

    private View getId9MusicView() {
        ViewId9AlsMusicBinding binding = ViewId9AlsMusicBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, Id9AlsConstants.ID9ALS_VIEW_MUSIC);
        if (LauncherViewModel.bThirdMusic != null && Boolean.TRUE.equals(LauncherViewModel.bThirdMusic.get())) {
            String pkg = Settings.System.getString(this.mContext.getContentResolver(), KeyConfig.KEY_THIRD_APP_MUSIC_PKG);
            String cls = Settings.System.getString(this.mContext.getContentResolver(), KeyConfig.KEY_THIRD_APP_MUSIC_CLS);
            ResolveInfo resolveInfo = AppInfoUtils.findAppByPkgAndCls(KswApplication.appContext, pkg, cls);
            PackageManager pm = KswApplication.appContext.getPackageManager();
            Log.w(TAG, "get3rdAppView: resolveInfo == null" + (resolveInfo == null) + ", pkg : " + pkg + ", cls : " + cls);
            if (resolveInfo == null) {
                binding.id9HomeMusicTitleTv.setText(cls);
            } else {
                binding.id9HomeMusicTitleTv.setText(resolveInfo.loadLabel(pm).toString());
            }
        }
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$YBz1ZAgSox3KMgZ9H9sx92tcK9Y */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9MusicView$0$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_MUSIC);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9MusicView$0$Id9AlsViewManager(View view1) {
        this.viewModel.openMusicMulti(view1);
    }

    private void setDragListener(View view, String fragmentTag) {
        view.setOnDragListener(new Id9OnDragListener(fragmentTag));
        view.setOnLongClickListener(new Id9LongClickListener(view, fragmentTag, this.isEdit));
    }

    private View getId9BtView() {
        ViewId9AlsBtBinding binding = ViewId9AlsBtBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, Id9AlsConstants.ID9ALS_VIEW_BT);
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$_4rTH5UWHN07MG_Jhrl42jP6Jw0 */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9BtView$1$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_BT);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9BtView$1$Id9AlsViewManager(View view1) {
        this.viewModel.openBtApp(view1);
    }

    private View getId9VideoView() {
        ViewId9AlsVideoBinding binding = ViewId9AlsVideoBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, Id9AlsConstants.ID9ALS_VIEW_VIDEO);
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$9coJnjHetrwPIkxhsWno0z5FJ_o */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9VideoView$2$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_VIDEO);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9VideoView$2$Id9AlsViewManager(View view1) {
        this.viewModel.openVideoMulti(view1);
    }

    private View getId9ModelView() {
        ViewId9AlsModelBinding binding = ViewId9AlsModelBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, Id9AlsConstants.ID9ALS_VIEW_MODEL);
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$AZDSvqZmx1hRhO_gRS04nIErHs */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9ModelView$3$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_MODEL);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9ModelView$3$Id9AlsViewManager(View view1) {
        this.mContext.startActivity(new Intent(this.mContext, Id9ChangeModelOrWallpaperActivity.class));
    }

    private View getId9WeatherView() {
        ViewId9AlsWeatherBinding binding = ViewId9AlsWeatherBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, Id9AlsConstants.ID9ALS_VIEW_WEATHER);
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$QXOZbhJl5PjuMHCzMS_f2N14Ic */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9WeatherView$4$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_WEATHER);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9WeatherView$4$Id9AlsViewManager(View view1) {
        this.viewModel.openWeatherApp(view1);
    }

    private View getId9NaviView() {
        ViewId9AlsNaviBinding binding = ViewId9AlsNaviBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, Id9AlsConstants.ID9ALS_VIEW_NAVI);
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$M8NQqvmOSZziHOK61tQnOgPx8 */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9NaviView$5$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_NAVI);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9NaviView$5$Id9AlsViewManager(View view1) {
        this.viewModel.openNaviApp(view1);
    }

    private View getId9CarInfoView() {
        ViewId9AlsCarInfoBinding binding = ViewId9AlsCarInfoBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, Id9AlsConstants.ID9ALS_VIEW_CAR);
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$RZee6uZEXSjENMFrqdcC8oHeEKw */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9CarInfoView$6$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_CAR);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9CarInfoView$6$Id9AlsViewManager(View view1) {
        this.viewModel.openCar(view1);
    }

    private View getId9SettingView() {
        ViewId9AlsSettingBinding binding = ViewId9AlsSettingBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, Id9AlsConstants.ID9ALS_VIEW_SETTING);
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$c8Wv08afJ2O5cXlEf_pjCpIu3rs */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9SettingView$7$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_SETTING);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9SettingView$7$Id9AlsViewManager(View view1) {
        this.viewModel.openSettings(view1);
    }

    private View getId9AddCardView() {
        ViewId9AlsAddCardBinding binding = ViewId9AlsAddCardBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        if (!this.isEdit) {
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$XzZ8RCYaqrF93IMOZC3cH6OsIr8 */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9AddCardView$8$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_ADD_APP);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9AddCardView$8$Id9AlsViewManager(View view1) {
        this.viewModel.addWidget(view1);
    }

    private View getId9BoardView() {
        ViewId9AlsBoardBinding binding = ViewId9AlsBoardBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, Id9AlsConstants.ID9ALS_VIEW_BOARD);
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$7aGhFJbTc0z_flZpOfLQ1MoM41Q */

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getId9BoardView$9$Id9AlsViewManager(view);
                }
            });
            int index = id9CardSortList.indexOf(Id9AlsConstants.ID9ALS_VIEW_BOARD);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        }
        return binding.getRoot();
    }

    public /* synthetic */ void lambda$getId9BoardView$9$Id9AlsViewManager(View view1) {
        this.viewModel.openDashboard(view1);
    }

    private View getThirdView(String data) {
        Log.i(TAG, "getThirdView data: " + data);
        ViewId9AlsThirdBinding binding = ViewId9AlsThirdBinding.inflate(LayoutInflater.from(this.mContext));
        binding.setId9ViewModel(this.viewModel);
        View view = binding.getRoot();
        setDragListener(view, data);
        String[] split = data.substring(4).split(",");
        boolean z = false;
        String pkg = split[0];
        String cls = split[1];
        binding.id9HomeDeleteLl.setVisibility(this.isEdit ? 0 : 8);
        if (!this.isEdit) {
            view.setOnClickListener(new View.OnClickListener(pkg, cls) {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$tIt3l7F7aX1vCzmOIYChiNRsfJc */
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getThirdView$10$Id9AlsViewManager(this.f$1, this.f$2, view);
                }
            });
            int index = id9CardSortList.indexOf(data);
            Log.i(TAG, "getThirdView index: " + index + " data: " + data);
            if (index >= 0) {
                binding.id9CardView.setTag("TagCard:" + index);
            }
        } else {
            binding.id9HomeDeleteLl.setOnClickListener(new View.OnClickListener(data) {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$1Kb5Bm7JKe1PkgOT6FhvLcAuCS4 */
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    Id9AlsViewManager.this.lambda$getThirdView$11$Id9AlsViewManager(this.f$1, view);
                }
            });
        }
        if (setFactoryAppCardView(pkg, binding.id9HomeThirdTitleTv, binding.id9HomeVideoTipsTv, binding.id9HomeThirdIv)) {
            return view;
        }
        ResolveInfo resolveInfo = AppInfoUtils.findAppByPkgAndCls(KswApplication.appContext, pkg, cls);
        PackageManager pm = KswApplication.appContext.getPackageManager();
        String str = TAG;
        StringBuilder append = new StringBuilder().append("get3rdAppView: resolveInfo == null");
        if (resolveInfo == null) {
            z = true;
        }
        Log.w(str, append.append(z).append(", pkg : ").append(pkg).append(", cls : ").append(cls).toString());
        if (resolveInfo == null) {
            binding.id9HomeThirdTitleTv.setText(cls);
            binding.id9HomeThirdIv.setImageDrawable(null);
        } else {
            Drawable roundIcon = Id9AlsConstants.getIcon(pkg, resolveInfo.loadIcon(pm));
            binding.id9HomeThirdTitleTv.setText(resolveInfo.loadLabel(pm).toString());
            binding.id9HomeThirdIv.setImageDrawable(roundIcon);
        }
        return view;
    }

    public /* synthetic */ void lambda$getThirdView$10$Id9AlsViewManager(String pkg, String cls, View view1) {
        Log.i(TAG, "getThirdView: " + pkg + ", " + cls);
        this.viewModel.onItemClick(pkg, cls);
    }

    public /* synthetic */ void lambda$getThirdView$11$Id9AlsViewManager(String data, View view1) {
        removeCard(data);
    }

    private boolean setFactoryAppCardView(String pkg, TextView titleView, TextView tipsView, ImageView iconImg) {
        if ("DTV_Type".equals(pkg)) {
            titleView.setText(AppsLoaderTask.dtvLable);
            iconImg.setImageDrawable(AppsLoaderTask.dtvIcon);
            tipsView.setVisibility(4);
            return true;
        } else if ("Front_view_camera".equals(pkg)) {
            titleView.setText(AppsLoaderTask.fcamLable);
            iconImg.setImageDrawable(AppsLoaderTask.fcamIcon);
            tipsView.setVisibility(4);
            return true;
        } else if ("AUX_Type".equals(pkg)) {
            titleView.setText(AppsLoaderTask.auxLable);
            iconImg.setImageDrawable(AppsLoaderTask.auxIcon);
            tipsView.setVisibility(4);
            return true;
        } else if ("DVR_Type".equals(pkg)) {
            titleView.setText(AppsLoaderTask.dvrLable);
            iconImg.setImageDrawable(AppsLoaderTask.dvrIcon);
            tipsView.setVisibility(4);
            return true;
        } else if (!Id9AlsConstants.THEME_TYPE.equals(pkg)) {
            return false;
        } else {
            titleView.setText(Id9AlsConstants.id9Theme);
            iconImg.setImageDrawable(Id9AlsConstants.id9ThemeIcon);
            tipsView.setVisibility(4);
            return true;
        }
    }

    public void getId9CardSortString() {
        String id9CardSortStr = SpfUtils.getString(Id9AlsConstants.ID9ALS_VIEW_CARD_SORT_LIST, "");
        Log.i(TAG, "getId9CardSortString id9CardSortStr: " + id9CardSortStr);
        List<String> list = id9CardSortList;
        if (list == null) {
            id9CardSortList = new ArrayList();
        } else {
            list.clear();
        }
        if (TextUtils.isEmpty(id9CardSortStr)) {
            id9CardSortList.add(Id9AlsConstants.ID9ALS_VIEW_MUSIC);
            id9CardSortList.add(Id9AlsConstants.ID9ALS_VIEW_BT);
            id9CardSortList.add(Id9AlsConstants.ID9ALS_VIEW_VIDEO);
            id9CardSortList.add(Id9AlsConstants.ID9ALS_VIEW_NAVI);
            id9CardSortList.add(Id9AlsConstants.ID9ALS_VIEW_CAR);
            id9CardSortList.add(Id9AlsConstants.ID9ALS_VIEW_SETTING);
            id9CardSortList.add(Id9AlsConstants.ID9ALS_VIEW_BOARD);
            id9CardSortList.add(Id9AlsConstants.ID9ALS_VIEW_ADD_APP);
            saveSystemCardSeq();
        } else {
            id9CardSortList.addAll(Arrays.asList(id9CardSortStr.split(";")));
            ID8LauncherConstants.IteratorNameList(id9CardSortList);
            checkDisplayAppsHasUninstall();
        }
        if (this.isEdit || isThirdViewOverMaxSize()) {
            id9CardSortList.remove(Id9AlsConstants.ID9ALS_VIEW_ADD_APP);
        }
    }

    private boolean isThirdViewOverMaxSize() {
        int thirdNum = 0;
        for (String card : id9CardSortList) {
            if (card.startsWith("3rd")) {
                thirdNum++;
            }
        }
        return thirdNum >= 5;
    }

    private void checkDisplayAppsHasUninstall() {
        Iterator<String> it = id9CardSortList.iterator();
        boolean isChange = false;
        while (it.hasNext()) {
            String cardName = it.next();
            if (cardName.startsWith("3rd")) {
                String pkg = cardName.substring(4).split(",")[0];
                if (!"DTV_Type".equals(pkg) && !"Front_view_camera".equals(pkg) && !"AUX_Type".equals(pkg) && !"DVR_Type".equals(pkg) && !Id9AlsConstants.THEME_TYPE.equals(pkg) && !AppInfoUtils.isAppPakExist(KswApplication.appContext, pkg)) {
                    it.remove();
                    isChange = true;
                }
            }
        }
        if (isChange) {
            saveSystemCardSeq();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initIndicator() {
        if (this.totalPage >= 1) {
            this.pointLayout.removeAllViews();
            this.ivWitstekIndicator = new ImageView[this.totalPage];
            for (int i = 0; i < this.totalPage; i++) {
                ImageView imageView = new ImageView(this.mContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
                layoutParams.topMargin = 10;
                if (i == this.mPagePosition) {
                    imageView.setBackgroundResource(R.drawable.id9_home_paging_f);
                    layoutParams.width = 6;
                    layoutParams.height = 24;
                } else {
                    imageView.setBackgroundResource(R.drawable.ntg6_fy_v3_allapp_gray);
                    layoutParams.width = 12;
                    layoutParams.height = 12;
                }
                this.ivWitstekIndicator[i] = imageView;
                this.pointLayout.addView(imageView, layoutParams);
                this.pointLayout.setGravity(17);
            }
        }
    }

    public void addTrdApp(String pkg, String cls) {
        Log.d(TAG, "addTrdApp: ");
        String pkgInfo = "3rd:" + pkg + "," + cls;
        if (!id9CardSortList.contains(pkgInfo)) {
            id9CardSortList.add(id9CardSortList.size() - 1, pkgInfo);
        }
        saveSystemCardSeq();
    }

    public void removeCard(String tag) {
        Log.i(TAG, "removeCard: " + tag);
        id9CardSortList.remove(tag);
        saveSystemCardSeq();
        notifyDataChanged(this.isEdit);
    }

    private void saveSystemCardSeq() {
        if (!id9CardSortList.contains(Id9AlsConstants.ID9ALS_VIEW_ADD_APP)) {
            id9CardSortList.add(Id9AlsConstants.ID9ALS_VIEW_ADD_APP);
        }
        String id9CardSortStr = Id9AlsViewManager$$ExternalSynthetic0.m0(";", id9CardSortList);
        Log.i(TAG, "saveSystemCardSeq: id9CardSortStr = " + id9CardSortStr);
        SpfUtils.saveData(Id9AlsConstants.ID9ALS_VIEW_CARD_SORT_LIST, id9CardSortStr);
    }

    public void checkAutoScroll(float fingerX, String mFragmentTag) {
        int sortInd = id9CardSortList.indexOf(mFragmentTag);
        if (sortInd > 0) {
            if (fingerX >= 60.0f || this.mPagePosition <= 0 || sortInd % 2 != 0) {
                if (fingerX > 265.0f && this.mPagePosition < this.totalPage - 1 && sortInd % 2 == 1 && SystemClock.uptimeMillis() - this.lastScrollTime > 150) {
                    this.lastScrollTime = SystemClock.uptimeMillis();
                    this.mViewpager.setCurrentItem(this.mPagePosition + 1);
                }
            } else if (SystemClock.uptimeMillis() - this.lastScrollTime > 150) {
                this.lastScrollTime = SystemClock.uptimeMillis();
                this.mViewpager.setCurrentItem(this.mPagePosition - 1);
            }
        }
    }

    public void sort(String dragName, String releaseName) {
        if (!dragName.equals(releaseName)) {
            int dragPosition = id9CardSortList.indexOf(dragName);
            int releasePosition = id9CardSortList.indexOf(releaseName);
            Log.i(TAG, "sort: dragName = " + dragName + " releaseName = " + releaseName + " releasePosition = " + releasePosition + " dragPosition = " + dragPosition);
            if (dragPosition != -1 && releasePosition != -1) {
                Collections.swap(id9CardSortList, dragPosition, releasePosition);
                saveSystemCardSeq();
                Id9CardSortChangeListener id9CardSortChangeListener = this.listener;
                if (id9CardSortChangeListener != null) {
                    id9CardSortChangeListener.isSortChange(true);
                }
            }
        }
    }

    public void setCardSortChangeListener(Id9CardSortChangeListener listener2) {
        this.listener = listener2;
    }

    public void setMActivity(Activity mActivity2, View freedomFocusView2, ImageView leftFocusView2, ImageView rightFocusView2, ImageView upperFocusView2, View mainSettingView2) {
        this.mActivity = mActivity2;
        this.freedomFocusView = freedomFocusView2;
        this.leftFocusView = leftFocusView2;
        this.rightFocusView = rightFocusView2;
        this.upperFocusView = upperFocusView2;
        this.mainSettingView = mainSettingView2;
    }

    public void showId9SettingDialogView() {
        Id9MainSettingDialog id9MainSettingDialog = this.settingDialog;
        if (id9MainSettingDialog != null && id9MainSettingDialog.isShowing()) {
            this.settingDialog.dismiss();
        }
        Id9MainSettingDialog id9MainSettingDialog2 = new Id9MainSettingDialog(this.mActivity);
        this.settingDialog = id9MainSettingDialog2;
        id9MainSettingDialog2.show();
        this.settingDialog.setId9DialogFocusLeaveListener(new Id9DialogFocusLeaveListener() {
            /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$1icRM6IT3ft3i7BGfAHVqHCF74 */

            @Override // com.wits.ksw.launcher.view.id9als.listener.Id9DialogFocusLeaveListener
            public final void onFocusLeaveListener(View view) {
                Id9AlsViewManager.this.lambda$showId9SettingDialogView$12$Id9AlsViewManager(view);
            }
        });
    }

    public /* synthetic */ void lambda$showId9SettingDialogView$12$Id9AlsViewManager(View view) {
        viewRequestFocus(this.freedomFocusView);
    }

    public void dismissId9SettingDialog() {
        Log.i(TAG, "dismissId9SettingDialog");
        Id9MainSettingDialog id9MainSettingDialog = this.settingDialog;
        if (id9MainSettingDialog != null && id9MainSettingDialog.isShowing()) {
            this.settingDialog.dismiss();
        }
    }

    public void dispatchKeyEvent(String keyString) {
        if (!TextUtils.isEmpty(keyString)) {
            char c = 65535;
            switch (keyString.hashCode()) {
                case -418852507:
                    if (keyString.equals("KEYCODE_ENTER")) {
                        c = 4;
                        break;
                    }
                    break;
                case -207426337:
                    if (keyString.equals("KEYCODE_DPAD_RIGHT")) {
                        c = 3;
                        break;
                    }
                    break;
                case -145649313:
                    if (keyString.equals("KEYCODE_DPAD_DOWN")) {
                        c = 1;
                        break;
                    }
                    break;
                case -145421116:
                    if (keyString.equals("KEYCODE_DPAD_LEFT")) {
                        c = 2;
                        break;
                    }
                    break;
                case -40674373:
                    if (keyString.equals("KEYCODE_691")) {
                        c = 5;
                        break;
                    }
                    break;
                case -40674372:
                    if (keyString.equals("KEYCODE_692")) {
                        c = 6;
                        break;
                    }
                    break;
                case 361859736:
                    if (keyString.equals("KEYCODE_DPAD_UP")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    keyControlView(19);
                    return;
                case 1:
                    keyControlView(20);
                    return;
                case 2:
                    keyControlView(21);
                    return;
                case 3:
                    keyControlView(22);
                    return;
                case 4:
                    Id9MainSettingDialog id9MainSettingDialog = this.settingDialog;
                    if (id9MainSettingDialog == null || !id9MainSettingDialog.isShowing()) {
                        setViewClickEvent();
                        return;
                    } else {
                        this.settingDialog.dispatchKeyEvent(new KeyEvent(0, 66));
                        return;
                    }
                case 5:
                    lastMemoryFocusView();
                    return;
                case 6:
                    clearActivityFocus();
                    return;
                default:
                    return;
            }
        }
    }

    private void clearActivityFocus() {
        Log.i(TAG, "clearActivityFocus");
        View currentFocus = this.mActivity.getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            goneFocusView();
            return;
        }
        View view = this.lastRequestView;
        if (view != null) {
            view.clearFocus();
            goneFocusView();
        }
    }

    public void saveViewTag(String viewTag) {
        SpfUtils.saveData(Id9AlsConstants.ID9_FOCUS_VIEW_TAG, viewTag);
    }

    public String getViewTag() {
        return SpfUtils.getString(Id9AlsConstants.ID9_FOCUS_VIEW_TAG, "");
    }

    private void keyControlView(int type) {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isDestroyed() && !this.mActivity.isFinishing()) {
            Id9MainSettingDialog id9MainSettingDialog = this.settingDialog;
            if (id9MainSettingDialog == null || !id9MainSettingDialog.isShowing()) {
                View currentFocus = this.mActivity.getCurrentFocus();
                if (currentFocus == null) {
                    firstViewRequestFocus();
                    return;
                }
                currentFocus.clearFocus();
                String viewTag = getViewTag();
                if (TextUtils.isEmpty(viewTag)) {
                    firstViewRequestFocus();
                    return;
                }
                Log.i(TAG, "keyControlView: view = " + viewTag);
                String[] viewTags = viewTag.split(":");
                if (viewTags.length < 2) {
                    firstViewRequestFocus();
                    return;
                }
                int index = -1;
                try {
                    index = Integer.parseInt(viewTags[1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                String tagStr = viewTags[0];
                View requesView = currentFocus;
                switch (type) {
                    case 19:
                        if (Id9AlsConstants.ID9_FOCUS_VIEW_TAG_CARD.equals(tagStr) && index > 0) {
                            int nextIndex = index - 1;
                            int nextPage = nextIndex / 2;
                            if (nextIndex % 2 == 1 && nextPage != this.mViewpager.getCurrentItem()) {
                                this.mViewpager.setCurrentItem(nextPage);
                            }
                            requesView = this.mListViewData.get(nextIndex).findViewById(R.id.id9_card_view);
                            break;
                        }
                    case 20:
                        if (Id9AlsConstants.ID9_FOCUS_VIEW_TAG_CARD.equals(tagStr) && index < this.mListViewData.size() - 1) {
                            int nextIndex2 = index + 1;
                            int nextPage2 = nextIndex2 / 2;
                            if (nextIndex2 % 2 == 0 && nextPage2 != this.mViewpager.getCurrentItem()) {
                                this.mViewpager.setCurrentItem(nextPage2);
                            }
                            requesView = this.mListViewData.get(nextIndex2).findViewById(R.id.id9_card_view);
                            break;
                        }
                    case 21:
                        if (this.isLayoutModelRtl) {
                            if (!Id9AlsConstants.ID9_FOCUS_VIEW_TAG_CARD.equals(tagStr)) {
                                if (Id9AlsConstants.ID9_FOCUS_VIEW_TAG_FREEDOM.equals(tagStr)) {
                                    requesView = this.mainSettingView;
                                    break;
                                }
                            } else {
                                requesView = this.freedomFocusView;
                                break;
                            }
                        } else if (!Id9AlsConstants.ID9_FOCUS_VIEW_TAG_FREEDOM.equals(tagStr)) {
                            if (Id9AlsConstants.ID9_FOCUS_VIEW_TAG_MAIN_SETTING.equals(tagStr)) {
                                requesView = this.freedomFocusView;
                                break;
                            }
                        } else {
                            firstViewRequestFocus();
                            return;
                        }
                        break;
                    case 22:
                        if (this.isLayoutModelRtl) {
                            if (!Id9AlsConstants.ID9_FOCUS_VIEW_TAG_MAIN_SETTING.equals(tagStr)) {
                                if (Id9AlsConstants.ID9_FOCUS_VIEW_TAG_FREEDOM.equals(tagStr)) {
                                    requesView = this.mListViewData.get(this.mViewpager.getCurrentItem() * 2).findViewById(R.id.id9_card_view);
                                    break;
                                }
                            } else {
                                requesView = this.freedomFocusView;
                                break;
                            }
                        } else if (!Id9AlsConstants.ID9_FOCUS_VIEW_TAG_FREEDOM.equals(tagStr)) {
                            if (Id9AlsConstants.ID9_FOCUS_VIEW_TAG_CARD.equals(tagStr)) {
                                requesView = this.freedomFocusView;
                                break;
                            }
                        } else {
                            requesView = this.mainSettingView;
                            break;
                        }
                        break;
                }
                viewRequestFocus(requesView);
                return;
            }
            this.settingDialog.dispatchKeyEvent(new KeyEvent(0, type));
        }
    }

    public void lastMemoryFocusView() {
        View view = this.lastRequestView;
        if (view != null) {
            viewRequestFocus(view);
            return;
        }
        LauncherViewModel launcherViewModel = this.viewModel;
        if (launcherViewModel == null || launcherViewModel.lastViewFocused == null) {
            firstViewRequestFocus();
            return;
        }
        View view2 = this.viewModel.lastViewFocused.findViewById(R.id.id9_card_view);
        viewRequestFocus(view2 != null ? view2 : this.viewModel.lastViewFocused);
    }

    public void firstViewRequestFocus() {
        View view;
        if (this.isLayoutModelRtl) {
            view = this.freedomFocusView;
        } else {
            int currentItem = this.mViewpager.getCurrentItem();
            Log.i(TAG, "firstViewRequestFocus: currentItem = " + currentItem);
            view = this.mListViewData.get(currentItem * 2).findViewById(R.id.id9_card_view);
        }
        viewRequestFocus(view);
    }

    private void goneFocusView() {
        ImageView imageView = this.leftFocusView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.rightFocusView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.upperFocusView;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        View view = this.freedomFocusView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void showFocusView(View view, String tag) {
        goneFocusView();
        if (view != null && !TextUtils.isEmpty(tag)) {
            if (tag.contains(Id9AlsConstants.ID9_FOCUS_VIEW_TAG_FREEDOM)) {
                View view2 = this.freedomFocusView;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ImageView imageView = this.leftFocusView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    this.leftFocusView.setImageResource(R.drawable.id9_arrow_left_icon);
                }
                ImageView imageView2 = this.rightFocusView;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    this.rightFocusView.setImageResource(R.drawable.id9_arrow_right_icon);
                }
            } else if (tag.contains(Id9AlsConstants.ID9_FOCUS_VIEW_TAG_CARD)) {
                if (this.isLayoutModelRtl) {
                    ImageView imageView3 = this.rightFocusView;
                    if (imageView3 != null) {
                        imageView3.setVisibility(0);
                        this.rightFocusView.setImageResource(R.drawable.id9_arrow_left_icon);
                        return;
                    }
                    return;
                }
                ImageView imageView4 = this.leftFocusView;
                if (imageView4 != null) {
                    imageView4.setVisibility(0);
                    this.leftFocusView.setImageResource(R.drawable.id9_arrow_right_icon);
                }
            } else if (!tag.contains(Id9AlsConstants.ID9_FOCUS_VIEW_TAG_MAIN_SETTING)) {
            } else {
                if (this.isLayoutModelRtl) {
                    ImageView imageView5 = this.leftFocusView;
                    if (imageView5 != null) {
                        imageView5.setVisibility(0);
                        this.leftFocusView.setImageResource(R.drawable.id9_arrow_right_icon);
                        return;
                    }
                    return;
                }
                ImageView imageView6 = this.rightFocusView;
                if (imageView6 != null) {
                    imageView6.setVisibility(0);
                    this.rightFocusView.setImageResource(R.drawable.id9_arrow_left_icon);
                }
            }
        }
    }

    public void viewRequestFocus(View requesView) {
        if (requesView != null) {
            Object objectTag = requesView.getTag();
            String tag = null;
            if (objectTag != null) {
                tag = objectTag.toString();
            }
            Log.i(TAG, "viewRequestFocus: " + tag);
            showFocusView(requesView, tag);
            WiewFocusUtils.setViewRequestFocus(requesView);
            this.lastRequestView = requesView;
            LauncherViewModel launcherViewModel = this.viewModel;
            if (launcherViewModel != null) {
                launcherViewModel.lastViewFocused = requesView;
            }
            if (!TextUtils.isEmpty(tag)) {
                saveViewTag(tag);
            }
        }
    }

    private void setViewClickEvent() {
        View currentFocus;
        LauncherViewModel launcherViewModel;
        Activity activity = this.mActivity;
        if (activity != null && !activity.isDestroyed() && !this.mActivity.isFinishing() && (currentFocus = this.mActivity.getCurrentFocus()) != null) {
            Object obTag = currentFocus.getTag();
            if (obTag != null) {
                String tag = obTag.toString();
                if (!TextUtils.isEmpty(tag) && tag.contains(Id9AlsConstants.ID9_FOCUS_VIEW_TAG_FREEDOM) && (launcherViewModel = this.viewModel) != null) {
                    launcherViewModel.openNaviApp(currentFocus);
                    return;
                }
            }
            long downTime = SystemClock.uptimeMillis();
            int[] ints = new int[2];
            MotionEvent downEvent = MotionEvent.obtain(downTime, downTime, 0, (float) (ints[0] + 5), (float) (ints[1] + 5), 0);
            long downTime2 = downTime + 1000;
            MotionEvent upEvent = MotionEvent.obtain(downTime2, downTime2, 1, (float) (ints[0] + 5), (float) (ints[1] + 5), 0);
            currentFocus.onTouchEvent(downEvent);
            currentFocus.onTouchEvent(upEvent);
            downEvent.recycle();
            upEvent.recycle();
        }
    }

    public void registerObserver() {
        PowerManagerApp.registerIContentObserver("ill", this.illObserver);
        setAmapAutoDayNightMode();
        changeNormalWallpaper(true);
    }

    public void unRegisterObserver() {
        PowerManagerApp.unRegisterIContentObserver(this.illObserver);
    }

    public void setAmapAutoDayNightMode() {
        try {
            int type = 1;
            if (PowerManagerApp.getStatusInt("ill") == 1) {
                type = 2;
            }
            Intent intent = new Intent();
            intent.setAction("AUTONAVI_STANDARD_BROADCAST_RECV");
            intent.putExtra("KEY_TYPE", 10048);
            intent.putExtra("EXTRA_DAY_NIGHT_MODE", type);
            this.mContext.sendBroadcast(intent);
            Log.d(TAG, "setAmapAutoDayNightMode " + type + " ok");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "setAmapAutoDayNightMode failed: " + e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changeNormalWallpaper(boolean isOnCreate) {
        try {
            boolean isIllOn = true;
            if (PowerManagerApp.getStatusInt("ill") != 1) {
                isIllOn = false;
            }
            String wallpaper = PowerManagerApp.getSettingsString(Id9AlsConstants.ID9ALS_SKIN_WALLPAPER);
            if ("1".equals(wallpaper) || TextUtils.isEmpty(wallpaper)) {
                new Handler().postDelayed(new Runnable(isIllOn) {
                    /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$qg0LnkDw_UjERjAQpJa6OdZb4Mc */
                    public final /* synthetic */ boolean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        Id9AlsViewManager.this.lambda$changeNormalWallpaper$13$Id9AlsViewManager(this.f$1);
                    }
                }, isOnCreate ? 1500 : 0);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$changeNormalWallpaper$13$Id9AlsViewManager(boolean isIllOn) {
        setWallpaperPic(isIllOn ? R.drawable.id9_nav_bg : R.drawable.id9_nav_bg_white);
    }

    public void setWallpaperPic(int drawableId) {
        if (drawableId > 0 && this.mContext != null) {
            new Thread(new Runnable(drawableId) {
                /* class com.wits.ksw.launcher.view.id9als.$$Lambda$Id9AlsViewManager$wDsYnixAR8URG1PgcyqpMqHqPZY */
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    Id9AlsViewManager.this.lambda$setWallpaperPic$14$Id9AlsViewManager(this.f$1);
                }
            }).start();
        }
    }

    public /* synthetic */ void lambda$setWallpaperPic$14$Id9AlsViewManager(int drawableId) {
        try {
            WallpaperManager.getInstance(this.mContext).setResource(drawableId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeDarkTheme() {
        try {
            boolean isIllOn = PowerManagerApp.getStatusInt("ill") == 1;
            UiModeManager uiModeManager = (UiModeManager) this.mContext.getSystemService("uimode");
            if (isIllOn) {
                uiModeManager.setNightMode(2);
                AppCompatDelegate.setDefaultNightMode(2);
                return;
            }
            uiModeManager.setNightMode(1);
            AppCompatDelegate.setDefaultNightMode(1);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
