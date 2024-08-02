package com.wits.ksw.launcher.view.id9als.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityId9EditCardBinding;
import com.wits.ksw.databinding.ActivityId9EditCardRtlBinding;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.Id9AlsViewManager;
import com.wits.ksw.launcher.view.id9als.listener.Id9CardSortChangeListener;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class Id9EditCardActivity extends AppCompatActivity {
    private String TAG = Id9EditCardActivity.class.getName();
    private View changeModelToLeft;
    private View changeModelToRight;
    public ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.id9als.activity.Id9EditCardActivity.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            try {
                String freeWindowName = PowerManagerApp.getSettingsString(Id9AlsConstants.ID9ALS_FREE_WINDOW_NAME);
                Log.i(Id9EditCardActivity.this.TAG, "windowNameObserver: " + freeWindowName);
                Id9EditCardActivity.this.setFreeWindowImage(freeWindowName);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };
    private ImageView id9FreeWindowIv;
    private LauncherViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        View layoutView;
        LinearLayout linearLayout;
        ViewPager viewPager;
        super.onCreate(savedInstanceState);
        Log.i(this.TAG, "onCreate");
        setFull();
        setStatusBarTranslucent();
        String layoutModel = Id9AlsConstants.ID9ALS_LAYOUT_MODEL_LTR;
        try {
            layoutModel = PowerManagerApp.getSettingsString(Id9AlsConstants.ID9ALS_LAYOUT_MODEL);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (Id9AlsConstants.ID9ALS_LAYOUT_MODEL_RTL.equals(layoutModel)) {
            ActivityId9EditCardRtlBinding rtlBinding = ActivityId9EditCardRtlBinding.inflate(getLayoutInflater());
            layoutView = rtlBinding.getRoot();
            viewPager = rtlBinding.viewpager;
            linearLayout = rtlBinding.point;
            this.id9FreeWindowIv = rtlBinding.id9FreeWindow;
            this.changeModelToLeft = rtlBinding.id9EditModelLeft;
            this.changeModelToRight = rtlBinding.id9EditModelRight;
        } else {
            ActivityId9EditCardBinding ltrBinding = ActivityId9EditCardBinding.inflate(getLayoutInflater());
            layoutView = ltrBinding.getRoot();
            viewPager = ltrBinding.viewpager;
            linearLayout = ltrBinding.point;
            this.id9FreeWindowIv = ltrBinding.id9FreeWindow;
            this.changeModelToLeft = ltrBinding.id9EditModelLeft;
            this.changeModelToRight = ltrBinding.id9EditModelRight;
        }
        this.changeModelToLeft.setSelected(!Id9AlsConstants.ID9ALS_LAYOUT_MODEL_RTL.equals(layoutModel));
        this.changeModelToRight.setSelected(Id9AlsConstants.ID9ALS_LAYOUT_MODEL_RTL.equals(layoutModel));
        setContentView(layoutView);
        this.viewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        Id9AlsViewManager.getInstance().initData(this, viewPager, linearLayout, this.viewModel);
        initData();
        Id9AlsViewManager.getInstance().setCardSortChangeListener(new Id9CardSortChangeListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9EditCardActivity$tbknWF1OOK_cR1iBQXkohg3VZVE */

            @Override // com.wits.ksw.launcher.view.id9als.listener.Id9CardSortChangeListener
            public final void isSortChange(boolean z) {
                Id9EditCardActivity.this.lambda$onCreate$0$Id9EditCardActivity(z);
            }
        });
        String freeWindowName = null;
        try {
            freeWindowName = PowerManagerApp.getSettingsString(Id9AlsConstants.ID9ALS_FREE_WINDOW_NAME);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(freeWindowName)) {
            freeWindowName = Id9AlsConstants.ID9ALS_FREE_WINDOW_EMPTY;
        }
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Id9AlsConstants.ID9ALS_FREE_WINDOW_NAME), true, this.contentObserver);
        setFreeWindowImage(freeWindowName);
        this.changeModelToLeft.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9EditCardActivity$FjX5gK10wZuL8C8_86FDUtwyKgk */

            public final void onClick(View view) {
                Id9EditCardActivity.this.lambda$onCreate$1$Id9EditCardActivity(view);
            }
        });
        this.changeModelToRight.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9EditCardActivity$MNq4gulCsFOIIsP7aU1Br6SgHsQ */

            public final void onClick(View view) {
                Id9EditCardActivity.this.lambda$onCreate$2$Id9EditCardActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$Id9EditCardActivity(boolean isChange) {
        initData();
    }

    public /* synthetic */ void lambda$onCreate$1$Id9EditCardActivity(View view) {
        try {
            PowerManagerApp.setSettingsString(Id9AlsConstants.ID9ALS_LAYOUT_MODEL, Id9AlsConstants.ID9ALS_LAYOUT_MODEL_LTR);
            Id9AlsConstants.setLayoutModel();
            recreate();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$onCreate$2$Id9EditCardActivity(View view) {
        try {
            PowerManagerApp.setSettingsString(Id9AlsConstants.ID9ALS_LAYOUT_MODEL, Id9AlsConstants.ID9ALS_LAYOUT_MODEL_RTL);
            Id9AlsConstants.setLayoutModel();
            recreate();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setFreeWindowImage(String freeWindowName) {
        if (!TextUtils.isEmpty(freeWindowName)) {
            if (freeWindowName.startsWith("freeWindow:music,")) {
                this.id9FreeWindowIv.setImageResource(R.drawable.id9_home_music_pic);
            } else if (freeWindowName.startsWith("freeWindow:video,")) {
                this.id9FreeWindowIv.setImageResource(R.drawable.id9_home_video_icon);
            } else if (freeWindowName.startsWith("freeWindow:bt,")) {
                this.id9FreeWindowIv.setImageResource(R.drawable.id9_home_music_pic);
            } else if (freeWindowName.startsWith("freeWindow:navi,")) {
                this.id9FreeWindowIv.setImageResource(R.drawable.id9_nac_pic);
            } else {
                this.id9FreeWindowIv.setImageResource(R.drawable.id9_home_edit_add);
            }
        }
    }

    private void initData() {
        Id9AlsViewManager.getInstance().notifyDataChanged(true);
    }

    public void setFull() {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
            getWindow().addFlags(1048576);
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

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i(this.TAG, "onDestroy");
        getContentResolver().unregisterContentObserver(this.contentObserver);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i(this.TAG, "onStop");
    }
}
