package com.wits.ksw.launcher.view;

import android.animation.ObjectAnimator;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextClock;
import com.wits.ksw.MainActivity;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ALSDasoardBind;
import com.wits.ksw.databinding.ActivityDashBoardAudiBinding;
import com.wits.ksw.databinding.ActivityDashBoardAudiMib3Binding;
import com.wits.ksw.databinding.ActivityDashBoardAudiMib3FyBinding;
import com.wits.ksw.databinding.ActivityDashBoardLcBinding;
import com.wits.ksw.databinding.ActivityDashBoardLexusBinding;
import com.wits.ksw.databinding.ActivityNtg6DashBoardBinding;
import com.wits.ksw.databinding.BmwId8DashboardLayoutNewBinding;
import com.wits.ksw.databinding.BmwId9DashboardLayoutNewBinding;
import com.wits.ksw.databinding.DasoardBind;
import com.wits.ksw.databinding.NTG6V3DashBoardBind;
import com.wits.ksw.databinding.SevenDasoardBind;
import com.wits.ksw.launcher.base.BaseThemeActivity;
import com.wits.ksw.launcher.model.DashboardViewModel;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.model.McuImpl;
import com.wits.ksw.launcher.utils.KeyUtils;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.Locale;
import skin.support.content.res.SkinCompatResources;

public class DashboardActivity extends BaseThemeActivity {
    private static final String TAG = DashboardActivity.class.getSimpleName();
    private int carManufacturer;
    private BmwId8DashboardLayoutNewBinding mBmwId8NewBinding;
    private BmwId9DashboardLayoutNewBinding mBmwId9NewBinding;
    String screenFile = "";
    private Handler screenHandler = new Handler() {
        /* class com.wits.ksw.launcher.view.DashboardActivity.AnonymousClass7 */

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 666:
                    DashboardActivity dashboardActivity = DashboardActivity.this;
                    dashboardActivity.screenFile = MainActivity.screenShotByShell(dashboardActivity);
                    Log.d(DashboardActivity.TAG, DashboardActivity.this.screenFile);
                    return;
                default:
                    return;
            }
        }
    };
    private DashboardViewModel viewMode;

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, com.wits.ksw.launcher.base.BaseThemeActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        Log.d(TAG, "onCreate: width = " + width + "height=" + getWindowManager().getDefaultDisplay().getHeight());
        DashboardViewModel dashboardViewModel = (DashboardViewModel) ViewModelProviders.of(this).get(DashboardViewModel.class);
        this.viewMode = dashboardViewModel;
        dashboardViewModel.initData();
        initCarManufacturer();
        KeyUtils.pressKey(391);
        super.onCreate(savedInstanceState);
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initUIKSWID7View() {
        initBmwid7UiView();
    }

    private void initCarManufacturer() {
        this.carManufacturer = 0;
        try {
            this.carManufacturer = PowerManagerApp.getSettingsInt(KeyConfig.CarManufacturer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        int i = this.carManufacturer;
        if (i == 0 || i > 3) {
            this.carManufacturer = UiThemeUtils.getCarManufacturer(this);
        }
        Log.d(TAG, "initCarManufacturer: " + this.carManufacturer);
        int i2 = this.carManufacturer;
        if (i2 == 2 || i2 == 3) {
            this.viewMode.hideOil.set(true);
        } else {
            this.viewMode.hideOil.set(false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid5UiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid6UiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid6CuspUiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwEvoId6GS() {
        initBmwid6UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid7UiView() {
        initUI();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBcUiView() {
        initUI();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenzGSView() {
        initBcUiView();
    }

    private void initSevenDashBoard() {
        SevenDasoardBind binding = (SevenDasoardBind) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_seven);
        DashboardViewModel.carInfo.sevenmode.set(this.viewMode.getSevenModel());
        binding.setViewModel(this.viewMode);
        binding.getRoot().setOnTouchListener(new View.OnTouchListener() {
            /* class com.wits.ksw.launcher.view.DashboardActivity.AnonymousClass1 */

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 0) {
                    DashboardActivity.this.viewMode.showSevenMenu.set(event.getX() < 252.0f);
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initGSUiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initCommonUIGSUGView() {
        initBmwid6UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenzMBUXView() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_View() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_KSW_View() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_KSW_View_new() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_KSW_View_V2() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_View2() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_NTG6_FY_View() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initUI_NTG6_FY_ViewV2() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initUI_NTG6_FY_ViewV3() {
        Log.i(TAG, "initUI_NTG6_FY_ViewV3");
        setActivityFull();
        setFull();
        setStatusBarTranslucent();
        initNTG6V3DashBoard();
        this.viewMode.hideOil.set(true);
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initEVOID8_UG() {
        initBmwId8UiView();
    }

    private void initNTG6V3DashBoard() {
        NTG6V3DashBoardBind binding = (NTG6V3DashBoardBind) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_ntg6_v3);
        DashboardViewModel.carInfo.ntg6v3SevenMode.set(this.viewMode.getNtg6v3SevenModel());
        binding.setViewModel(this.viewMode);
        this.viewMode.initNtg6v3MiddleViewModel();
        try {
            binding.speedProgressBar.setMaxValues(Boolean.TRUE.equals(LauncherViewModel.carInfo.unitEnImg.get()) ? 210.0f : 330.0f);
            ObjectAnimator animator = ObjectAnimator.ofFloat(binding.outerRingImageView, "rotation", 0.0f, -360.0f);
            animator.setDuration(2500L);
            animator.setRepeatCount(0);
            animator.start();
            ObjectAnimator animatorTachometer = ObjectAnimator.ofFloat(binding.outerRingTachometer, "rotation", 0.0f, 360.0f);
            animatorTachometer.setDuration(2500L);
            animatorTachometer.setRepeatCount(0);
            animatorTachometer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = "EEEE MMM dd日";
        binding.textClock1.setFormat12Hour(isChinese() ? str : "EE MMM dd");
        TextClock textClock = binding.textClock1;
        if (!isChinese()) {
            str = "EE MMM dd";
        }
        textClock.setFormat24Hour(str);
        binding.getRoot().setOnTouchListener(new View.OnTouchListener() {
            /* class com.wits.ksw.launcher.view.DashboardActivity.AnonymousClass2 */

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 0) {
                    DashboardActivity.this.viewMode.ntg6v3showSevenMenu.set(event.getY() > 600.0f);
                }
                return false;
            }
        });
    }

    private boolean isChinese() {
        if (Locale.getDefault().getLanguage().contains("zh")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_NTG6_FY_View_new() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudiView() {
        initUI();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudiMbi3View() {
        initAudiMib3UI();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudiMbi3ViewV2() {
        initAudiMib3UI();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenzNTG5View() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAlsView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBwmNbt() {
        Log.d("zgy", "---initBwmNbt()--BBB--");
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLexus() {
        ActivityDashBoardLexusBinding binding = (ActivityDashBoardLexusBinding) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_lexus);
        binding.setViewModel(this.viewMode);
        AnimationDrawable animationDrawableL = (AnimationDrawable) binding.lexusIvLeft.getBackground();
        AnimationDrawable animationDrawableR = (AnimationDrawable) binding.lexusIvRight.getBackground();
        if (!animationDrawableL.isRunning()) {
            animationDrawableL.setOneShot(true);
            animationDrawableL.start();
        }
        if (!animationDrawableR.isRunning()) {
            animationDrawableR.setOneShot(true);
            animationDrawableR.start();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLexusLs() {
        initLexus();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLexusLsDrag() {
        initLexus();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLexusLsDragV2() {
        initLexus();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBwmID7Hicar() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initRomeo() {
        initSevenDashBoard();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initRomeo_V2() {
        initSevenDashBoard();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initCommonUIGSUG1024View() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initCommonUIKSWMBUX1024View() {
        initBcUiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAlsId7UI() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAlsId7UI_V2() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLandRover() {
        initBmwid7UiView();
        View tempAndoil = findViewById(R.id.constraintLayout);
        if (tempAndoil != null) {
            tempAndoil.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAlsId7UiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudi_mib3_FyUiView() {
        initAudiMib3FyUI();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudi_mib3_Fy_V2_UiView() {
        initAudiMib3FyUI();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudiMib3Ty() {
        initAudiMib3UI();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwId8UiView() {
        setActivityFull();
        BmwId8DashboardLayoutNewBinding bmwId8DashboardLayoutNewBinding = (BmwId8DashboardLayoutNewBinding) DataBindingUtil.setContentView(this, R.layout.bmw_id8_dashboard_layout_new);
        this.mBmwId8NewBinding = bmwId8DashboardLayoutNewBinding;
        bmwId8DashboardLayoutNewBinding.setViewModel(this.viewMode);
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwId8GsUiView() {
        setActivityFull();
        BmwId8DashboardLayoutNewBinding bmwId8DashboardLayoutNewBinding = (BmwId8DashboardLayoutNewBinding) DataBindingUtil.setContentView(this, R.layout.bmw_id8_dashboard_layout_new);
        this.mBmwId8NewBinding = bmwId8DashboardLayoutNewBinding;
        bmwId8DashboardLayoutNewBinding.setViewModel(this.viewMode);
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwId8PempUiView() {
        setActivityFull();
        BmwId8DashboardLayoutNewBinding bmwId8DashboardLayoutNewBinding = (BmwId8DashboardLayoutNewBinding) DataBindingUtil.setContentView(this, R.layout.bmw_id8_dashboard_layout_new);
        this.mBmwId8NewBinding = bmwId8DashboardLayoutNewBinding;
        bmwId8DashboardLayoutNewBinding.setViewModel(this.viewMode);
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid7V2UiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initEVOID9_ALSUIView() {
        setActivityFull();
        BmwId9DashboardLayoutNewBinding bmwId9DashboardLayoutNewBinding = (BmwId9DashboardLayoutNewBinding) DataBindingUtil.setContentView(this, R.layout.bmw_id9_dashboard_layout_new);
        this.mBmwId9NewBinding = bmwId9DashboardLayoutNewBinding;
        bmwId9DashboardLayoutNewBinding.setViewModel(this.viewMode);
    }

    private void initAudiMib3FyUI() {
        if (this.viewMode.isSevenModel()) {
            setActivityFull();
            initSevenDashBoard();
        } else if (this.viewMode.isLCModel()) {
            setFull();
            ((ActivityDashBoardLcBinding) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_lc)).setViewModel(this.viewMode);
        } else {
            setFull();
            initAudiMib3FyDashBoard();
        }
    }

    private void initAudiMib3FyDashBoard() {
        final ActivityDashBoardAudiMib3FyBinding binding = (ActivityDashBoardAudiMib3FyBinding) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_audi_mib3_fy);
        DashboardViewModel dashboardViewModel = this.viewMode;
        dashboardViewModel.setAlsModel(dashboardViewModel.getAlsModel());
        binding.setViewModel(this.viewMode);
        if (this.viewMode.getAlsModel() == 0) {
            binding.modeRg.check(binding.energyConservationRb.getId());
            setAudiMib3FyRes(0, binding);
        } else if (this.viewMode.getAlsModel() == 1) {
            binding.modeRg.check(binding.comfortableRb.getId());
            setAudiMib3FyRes(1, binding);
        } else if (this.viewMode.getAlsModel() == 2) {
            binding.modeRg.check(binding.motionRb.getId());
            setAudiMib3FyRes(2, binding);
        }
        binding.showModeIv.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.$$Lambda$DashboardActivity$Bi0r8X10Riu0JqVRyOMuUdbrCmw */

            public final void onClick(View view) {
                DashboardActivity.this.lambda$initAudiMib3FyDashBoard$0$DashboardActivity(view);
            }
        });
        binding.modeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.wits.ksw.launcher.view.DashboardActivity.AnonymousClass3 */

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == binding.energyConservationRb.getId()) {
                    DashboardActivity.this.viewMode.setAlsModel(0);
                    DashboardActivity.this.setAudiMib3FyRes(0, binding);
                } else if (checkedId == binding.comfortableRb.getId()) {
                    DashboardActivity.this.viewMode.setAlsModel(1);
                    DashboardActivity.this.setAudiMib3FyRes(1, binding);
                } else if (checkedId == binding.motionRb.getId()) {
                    DashboardActivity.this.viewMode.setAlsModel(2);
                    DashboardActivity.this.setAudiMib3FyRes(2, binding);
                }
                DashboardActivity.this.viewMode.showAls.set(false);
            }
        });
        binding.getRoot().setOnTouchListener(new View.OnTouchListener() {
            /* class com.wits.ksw.launcher.view.DashboardActivity.AnonymousClass4 */

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 0 && DashboardActivity.this.viewMode != null && DashboardActivity.this.viewMode.isAlsModel() && DashboardActivity.this.viewMode.showAls.get()) {
                    DashboardActivity.this.viewMode.showAls.set(false);
                }
                return false;
            }
        });
    }

    public /* synthetic */ void lambda$initAudiMib3FyDashBoard$0$DashboardActivity(View v) {
        this.viewMode.showAls.set(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setAudiMib3FyRes(int mode, ActivityDashBoardAudiMib3FyBinding binding) {
        if (binding != null) {
            switch (mode) {
                case 0:
                    binding.linearLayout2.setBackgroundResource(R.drawable.ec_audi_mib3_dashboard_bk);
                    binding.speedometerImageView.setImageResource(R.drawable.ec_audi_mib3_fy_speed_wtach_level);
                    binding.tachometerImageView.setImageResource(R.drawable.ec_audi_mib3_dashboard_8);
                    return;
                case 1:
                    binding.linearLayout2.setBackgroundResource(R.drawable.comfortable_audi_mib3_dashboard_bk);
                    binding.speedometerImageView.setImageResource(R.drawable.comfortable_audi_mib3_fy_speed_wtach_level);
                    binding.tachometerImageView.setImageResource(R.drawable.comfortable_audi_mib3_dashboard_8);
                    return;
                case 2:
                    binding.linearLayout2.setBackgroundResource(R.drawable.motion_audi_mib3_dashboard_bk);
                    binding.speedometerImageView.setImageResource(R.drawable.motion_audi_mib3_fy_speed_wtach_level);
                    binding.tachometerImageView.setImageResource(R.drawable.motion_audi_mib3_dashboard_8);
                    return;
                default:
                    return;
            }
        }
    }

    private void initAlsDashboard() {
        final ALSDasoardBind binding = (ALSDasoardBind) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_als);
        DashboardViewModel dashboardViewModel = this.viewMode;
        dashboardViewModel.setAlsModel(dashboardViewModel.getAlsModel());
        binding.setViewModel(this.viewMode);
        if (this.viewMode.getAlsModel() == 0) {
            binding.alsRadioGroup.check(binding.alsRadioButton1.getId());
        } else if (this.viewMode.getAlsModel() == 1) {
            binding.alsRadioGroup.check(binding.alsRadioButton2.getId());
        } else if (this.viewMode.getAlsModel() == 2) {
            binding.alsRadioGroup.check(binding.alsRadioButton3.getId());
        }
        binding.alsCloseView.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.$$Lambda$DashboardActivity$V64oXRIPCz5HLFOg660VSxTx0Hg */

            public final void onClick(View view) {
                DashboardActivity.this.lambda$initAlsDashboard$1$DashboardActivity(view);
            }
        });
        binding.alsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.wits.ksw.launcher.view.DashboardActivity.AnonymousClass5 */

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == binding.alsRadioButton1.getId()) {
                    DashboardActivity.this.viewMode.setAlsModel(0);
                } else if (checkedId == binding.alsRadioButton2.getId()) {
                    DashboardActivity.this.viewMode.setAlsModel(1);
                } else if (checkedId == binding.alsRadioButton3.getId()) {
                    DashboardActivity.this.viewMode.setAlsModel(2);
                }
                DashboardActivity.this.viewMode.showAls.set(false);
            }
        });
        binding.getRoot().setOnTouchListener(new View.OnTouchListener() {
            /* class com.wits.ksw.launcher.view.DashboardActivity.AnonymousClass6 */

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 0 && DashboardActivity.this.viewMode != null && DashboardActivity.this.viewMode.isAlsModel()) {
                    DashboardActivity.this.viewMode.showAls.set(event.getX() < 235.0f);
                }
                return false;
            }
        });
    }

    public /* synthetic */ void lambda$initAlsDashboard$1$DashboardActivity(View v) {
        this.viewMode.showAls.set(false);
    }

    @Override // android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 66) {
            DashboardViewModel dashboardViewModel = this.viewMode;
            if (dashboardViewModel != null && dashboardViewModel.isAlsModel()) {
                this.viewMode.showAls.set(true);
            } else if (this.viewMode.isSevenModel()) {
                this.viewMode.showSevenMenu.set(true);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initUI() {
        int i = this.carManufacturer;
        if (i == 1) {
            initBwmUI();
        } else if (i == 2) {
            initBzUI();
        } else if (i == 3) {
            initAudiUI();
        } else {
            initBwmUI();
        }
    }

    private void initAudiMib3UI() {
        if (this.viewMode.isSevenModel()) {
            setActivityFull();
            initSevenDashBoard();
        } else if (this.viewMode.isLCModel()) {
            setFull();
            ((ActivityDashBoardLcBinding) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_lc)).setViewModel(this.viewMode);
        } else {
            setFull();
            setStatusBarTranslucent();
            ((ActivityDashBoardAudiMib3Binding) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_audi_mib3)).setViewModel(this.viewMode);
        }
    }

    private void initBwmUI() {
        setActivityFull();
        if (this.viewMode.isAlsModel()) {
            initAlsDashboard();
        } else if (this.viewMode.isSevenModel()) {
            initSevenDashBoard();
        } else {
            ((DasoardBind) DataBindingUtil.setContentView(this, R.layout.activity_dash_board)).setViewModel(this.viewMode);
        }
    }

    private void initBzUI() {
        if (this.viewMode.isAlsModel()) {
            setActivityFull();
            setFull();
            setStatusBarTranslucent();
            initAlsDashboard();
        } else if (this.viewMode.isSevenModel()) {
            setActivityFull();
            setFull();
            setStatusBarTranslucent();
            initSevenDashBoard();
        } else {
            setFull();
            setStatusBarTranslucent();
            ((ActivityNtg6DashBoardBinding) DataBindingUtil.setContentView(this, R.layout.activity_ntg6_dash_board)).setViewModel(this.viewMode);
        }
        this.viewMode.hideOil.set(true);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        try {
            if (UiThemeUtils.isLEXUS_LS_UI(this) || UiThemeUtils.isLEXUS_LS_UI_V2(this)) {
                this.screenHandler.sendEmptyMessageDelayed(666, 1800);
            }
            if (UiThemeUtils.isLEXUS_UI(this)) {
                McuImpl.getInstance().getCarInfo().unitEnImg.set(Boolean.valueOf(KswUtils.ismph()));
            }
            if (UiThemeUtils.isBMW_ID8_UI(this) || UiThemeUtils.isUI_GS_ID8(this) || UiThemeUtils.isUI_PEMP_ID8(this) || UiThemeUtils.isUI_EVOID9_ALS(this)) {
                BmwId8DashboardLayoutNewBinding bmwId8DashboardLayoutNewBinding = this.mBmwId8NewBinding;
                if (bmwId8DashboardLayoutNewBinding != null) {
                    bmwId8DashboardLayoutNewBinding.bmwId8DashboardLay.setBackground(SkinCompatResources.getDrawable(this, R.drawable.id8_dashboard_bg_new));
                    this.mBmwId8NewBinding.bmwId8DashboardMusicLay.bmwId8DashboardMusicName.setTextColor(SkinCompatResources.getColor(this, R.color.id8_main_style_color));
                    this.mBmwId8NewBinding.bmwId8DashboardLeftBg.setBackground(SkinCompatResources.getDrawable(this, R.drawable.id8_dashboard_bg_l_new));
                    this.mBmwId8NewBinding.bmwId8DashboardRightBg.setBackground(SkinCompatResources.getDrawable(this, R.drawable.id8_dashboard_bg_r_new));
                }
                BmwId9DashboardLayoutNewBinding bmwId9DashboardLayoutNewBinding = this.mBmwId9NewBinding;
                if (bmwId9DashboardLayoutNewBinding != null) {
                    bmwId9DashboardLayoutNewBinding.bmwId9DashboardLay.setBackground(SkinCompatResources.getDrawable(this, R.drawable.id9_dashboard_bg_new));
                    this.mBmwId9NewBinding.bmwId9DashboardMusicLay.bmwId9DashboardMusicName.setTextColor(SkinCompatResources.getColor(this, R.color.id9_main_style_color));
                    this.mBmwId9NewBinding.bmwId9DashboardSpeedProgress.setBackground(SkinCompatResources.getDrawable(this, R.drawable.id9_dashboard_bg_l_new));
                    this.mBmwId9NewBinding.bmwId9DashboardRotateProgress.setBackground(SkinCompatResources.getDrawable(this, R.drawable.id9_dashboard_bg_r_new));
                }
                boolean isPlay = PowerManagerApp.getManager().getStatusBoolean("play");
                int lastMode = PowerManagerApp.getStatusInt("lastMode");
                Log.e(TAG, " isPlay " + isPlay + " lastMode " + lastMode);
                if (lastMode == 1 && isPlay) {
                    this.viewMode.dashBoardMusicShow.set(Boolean.valueOf(isPlay));
                }
            }
            if (KswUtils.ismph()) {
                McuImpl.getInstance().getCarInfo().speedUnit.set("mph");
            } else {
                McuImpl.getInstance().getCarInfo().speedUnit.set("km/h");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        if (UiThemeUtils.isLEXUS_LS_UI(this) || UiThemeUtils.isLEXUS_LS_UI_V2(this)) {
            this.screenHandler.removeMessages(666);
        }
    }

    private void initAudiUI() {
        if (this.viewMode.isSevenModel()) {
            setActivityFull();
            initSevenDashBoard();
        } else if (this.viewMode.isLCModel()) {
            setFull();
            ((ActivityDashBoardLcBinding) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_lc)).setViewModel(this.viewMode);
        } else {
            setFull();
            ((ActivityDashBoardAudiBinding) DataBindingUtil.setContentView(this, R.layout.activity_dash_board_audi)).setViewModel(this.viewMode);
        }
    }
}