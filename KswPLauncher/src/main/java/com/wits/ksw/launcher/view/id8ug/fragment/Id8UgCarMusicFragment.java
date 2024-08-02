package com.wits.ksw.launcher.view.id8ug.fragment;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.viewbinding.ViewBinding;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FragmentEvoid8MainMusicBinding;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.AppInfoUtils;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import com.wits.ksw.launcher.view.id8ug.Id8UgViewManager;
import com.wits.ksw.settings.utlis_view.KeyConfig;

public class Id8UgCarMusicFragment extends Id8UgBaseFragment {
    private static final String TAG = Id8UgCarMusicFragment.class.getName();
    private FragmentEvoid8MainMusicBinding binding;
    public ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarMusicFragment.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            String skinName = Settings.System.getString(KswApplication.appContext.getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL);
            if (LauncherViewModel.mediaInfo.pic == null || LauncherViewModel.mediaInfo.pic.get() == null || Boolean.TRUE.equals(LauncherViewModel.bThirdMusic.get())) {
                Id8UgCarMusicFragment.this.binding.id8MusicIcon.setImageDrawable(ContextCompat.getDrawable(KswApplication.appContext, TextUtils.equals(Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT, skinName) ? R.drawable.evoid8_music_icon_bg_night : R.drawable.evoid8_music_icon_bg));
            }
        }
    };

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public String setFragmentTag() {
        return Id8UgConstants.ID8UG_FRAGMENT_CAR_MUSIC;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public ViewBinding createDataBinding(LayoutInflater inflater, ViewGroup container) {
        FragmentEvoid8MainMusicBinding inflate = FragmentEvoid8MainMusicBinding.inflate(inflater, container, false);
        this.binding = inflate;
        return inflate;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public void initMainActivityData() {
        super.initMainActivityData();
        this.binding.setId8ViewModel(this.mViewModel);
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarMusicFragment$azaSGSJCPBkOfeQcUxMr8B8V7w */

            public final void onClick(View view) {
                Id8UgCarMusicFragment.this.lambda$initMainActivityData$0$Id8UgCarMusicFragment(view);
            }
        });
        this.binding.id8UgCardViewTitle.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarMusicFragment$Bjjvf4vo8Bk2uCkAjLsaC29NeKU */

            public final void onClick(View view) {
                Id8UgCarMusicFragment.this.lambda$initMainActivityData$1$Id8UgCarMusicFragment(view);
            }
        });
        this.binding.id8UgChangeMusicIv.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarMusicFragment$ccZz9WE0YIWqRTVxwuoKngk1c9g */

            public final void onClick(View view) {
                Id8UgCarMusicFragment.this.lambda$initMainActivityData$2$Id8UgCarMusicFragment(view);
            }
        });
        this.binding.id8UgChangeBtIv.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarMusicFragment$OXGsX5DRnaYsd9Uoijy8qtuwqCk */

            public final void onClick(View view) {
                Id8UgCarMusicFragment.this.lambda$initMainActivityData$3$Id8UgCarMusicFragment(view);
            }
        });
        if (this.mViewModel.btMusicName.get() == null || TextUtils.isEmpty(this.mViewModel.btMusicName.get())) {
            this.mViewModel.btMusicName.set(getString(R.string.evoid8_music_not_play));
        }
        setMusicData();
        if (getContext() != null) {
            getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor(Id8UgConstants.ID8UG_SKIN_MODEL), true, this.contentObserver);
        }
    }

    public /* synthetic */ void lambda$initMainActivityData$0$Id8UgCarMusicFragment(View view) {
        if (this.binding.id8UgChangeLl.getVisibility() == 0) {
            hideCarChangeLayout();
            return;
        }
        Id8UgViewManager.getInstance().setOnClickLastRequestView(this.fragmentTag);
        if (!this.mViewModel.id8BtMusicType.get()) {
            this.mViewModel.openMusicMulti(view);
        } else if (Boolean.TRUE.equals(this.mViewModel.btStateBoolean.get())) {
            this.mViewModel.openAppTask(new ComponentName(Id8UgConstants.OWN_BT_APP_NAME, "com.wits.ksw.bt.id8.bmw.activity.ID8MusicActivity"));
        } else {
            this.mViewModel.openBtApp(view);
        }
    }

    public /* synthetic */ void lambda$initMainActivityData$1$Id8UgCarMusicFragment(View view) {
        if (this.binding.id8UgChangeLl.getVisibility() != 0) {
            showCarChangeLayout();
        }
    }

    public /* synthetic */ void lambda$initMainActivityData$2$Id8UgCarMusicFragment(View view) {
        hideCarChangeLayout();
        changeMusicModelType(0);
    }

    public /* synthetic */ void lambda$initMainActivityData$3$Id8UgCarMusicFragment(View view) {
        hideCarChangeLayout();
        changeMusicModelType(1);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            if (getContext() != null) {
                getContext().getContentResolver().unregisterContentObserver(this.contentObserver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeMusicModelType(int type) {
        SpfUtils.saveData(Id8UgConstants.ID8UG_MUSIC_SELECT_MODEL, type);
        setMusicData();
    }

    private void hideCarChangeLayout() {
        if (this.binding.id8UgChangeLl.getVisibility() == 0) {
            this.binding.id8UgChangeLl.setVisibility(8);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(400);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(400);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            this.binding.id8UgChangeLl.startAnimation(animationSet);
        }
    }

    private void showCarChangeLayout() {
        this.binding.id8UgChangeLl.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(400);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(400);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.binding.id8UgChangeLl.startAnimation(animationSet);
    }

    private void setMusicData() {
        if (this.mViewModel != null) {
            boolean z = false;
            this.mViewModel.id8BtMusicType.set(SpfUtils.getInt(Id8UgConstants.ID8UG_MUSIC_SELECT_MODEL, 0) == 1);
            String musicCardName = getString(R.string.evoid8_title_music);
            if (this.mViewModel.id8BtMusicType.get()) {
                musicCardName = getString(R.string.evoid8_title_bt_music);
            } else {
                String clsMusic = Settings.System.getString(getContext().getContentResolver(), KeyConfig.KEY_THIRD_APP_MUSIC_CLS);
                if (!TextUtils.isEmpty(clsMusic) && !KeyConfig.CLS_LOCAL_MUSIC.equals(clsMusic)) {
                    String pkg = Settings.System.getString(getContext().getContentResolver(), KeyConfig.KEY_THIRD_APP_MUSIC_PKG);
                    ResolveInfo resolveInfo = AppInfoUtils.findAppByPkgAndCls(KswApplication.appContext, pkg, clsMusic);
                    PackageManager pm = KswApplication.appContext.getPackageManager();
                    String str = TAG;
                    StringBuilder append = new StringBuilder().append("get3rdAppView: resolveInfo == null");
                    if (resolveInfo == null) {
                        z = true;
                    }
                    Log.w(str, append.append(z).append(", pkg : ").append(pkg).append(", cls : ").append(clsMusic).toString());
                    musicCardName = resolveInfo == null ? getString(R.string.unkonw) : resolveInfo.loadLabel(pm).toString();
                }
            }
            this.mViewModel.id8MusicCardName.set(musicCardName);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        this.mViewModel.updateShortcutAdapterData();
    }
}
