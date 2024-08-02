package com.wits.ksw.launcher.view.benzntg6fy;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityNtg6v3ChangeThemeMainBinding;
import java.util.ArrayList;
import java.util.List;

public class BenzNtg6v3FyThemeActivity extends AppCompatActivity {
    private static String TAG = "BenzNtg6v3FyThemeActivity";
    private List<Fragment> fragmentList;
    public BenzNtg6v3FyFragmentOne fragmentPage1;
    public BenzNtg6v3FyFragmentTwo fragmentPage2;
    private ActivityNtg6v3ChangeThemeMainBinding themeMainBinding;
    private BenzNtg6v3FyViewPagerAdapter themePagerAdapter;
    public ViewPager themeViewPager;
    private Ntg6v3ThemeChangeViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFull();
        setStatusBarTranslucent();
        this.viewModel = (Ntg6v3ThemeChangeViewModel) ViewModelProviders.of(this).get(Ntg6v3ThemeChangeViewModel.class);
        ActivityNtg6v3ChangeThemeMainBinding activityNtg6v3ChangeThemeMainBinding = (ActivityNtg6v3ChangeThemeMainBinding) DataBindingUtil.setContentView(this, R.layout.activity_ntg6v3_change_theme);
        this.themeMainBinding = activityNtg6v3ChangeThemeMainBinding;
        activityNtg6v3ChangeThemeMainBinding.setThemeViewModel(this.viewModel);
        this.viewModel.initData(this.themeMainBinding, this);
        this.fragmentList = new ArrayList();
        this.fragmentPage1 = new BenzNtg6v3FyFragmentOne();
        this.fragmentPage2 = new BenzNtg6v3FyFragmentTwo();
        this.fragmentList.add(this.fragmentPage1);
        this.fragmentList.add(this.fragmentPage2);
        this.themePagerAdapter = new BenzNtg6v3FyViewPagerAdapter(getSupportFragmentManager(), this.fragmentList);
        ViewPager viewPager = this.themeMainBinding.themeViewPager;
        this.themeViewPager = viewPager;
        viewPager.setAdapter(this.themePagerAdapter);
        this.themeViewPager.setCurrentItem(0);
        this.themeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.BenzNtg6v3FyThemeActivity.AnonymousClass1 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int pageIndex) {
                BenzNtg6v3FyThemeActivity.this.setPageSelect();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        setPageSelect();
        setFocusChangeListener();
        this.themeMainBinding.themeChangeTv.requestFocus();
    }

    public void setFull() {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
        }
    }

    public void setStatusBarTranslucent() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPageSelect() {
        int pageIndex = this.themeViewPager.getCurrentItem();
        boolean z = false;
        this.themeMainBinding.pageTv1.setSelected(pageIndex == 0);
        TextView textView = this.themeMainBinding.pageTv2;
        if (pageIndex == 1) {
            z = true;
        }
        textView.setSelected(z);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    private void setFocusChangeListener() {
        this.themeMainBinding.wallpaperChangeTv.setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$BenzNtg6v3FyThemeActivity$bt5Dh6muGI9G7m02Ff46eVabug */

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return BenzNtg6v3FyThemeActivity.this.lambda$setFocusChangeListener$0$BenzNtg6v3FyThemeActivity(view, i, keyEvent);
            }
        });
        this.themeMainBinding.themeChangeTv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.BenzNtg6v3FyThemeActivity.AnonymousClass2 */

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    BenzNtg6v3FyThemeActivity.this.themeMainBinding.wallpaperChangeTv.setSelected(false);
                }
            }
        });
        this.themeMainBinding.wallpaperChangeTv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.BenzNtg6v3FyThemeActivity.AnonymousClass3 */

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    BenzNtg6v3FyThemeActivity.this.themeMainBinding.themeChangeTv.setSelected(false);
                }
            }
        });
    }

    public /* synthetic */ boolean lambda$setFocusChangeListener$0$BenzNtg6v3FyThemeActivity(View view, int keyCode, KeyEvent event) {
        if ((keyCode != 20 && keyCode != 22) || event.getAction() != 0) {
            return false;
        }
        if (Boolean.TRUE.equals(Boolean.valueOf(Ntg6v3ThemeChangeViewModel.isThemeModeSelect.get()))) {
            this.fragmentPage1.setItem1RequestFocus();
            return true;
        }
        findViewById(R.id.wallpaperNormalIv).requestFocus();
        return true;
    }
}
