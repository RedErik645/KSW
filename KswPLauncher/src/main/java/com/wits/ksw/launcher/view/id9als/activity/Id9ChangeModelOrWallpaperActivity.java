package com.wits.ksw.launcher.view.id9als.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityId9ChangeModelBinding;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.fragment.Id9ModelFragment;
import com.wits.ksw.launcher.view.id9als.fragment.Id9WallpaperFragment;
import com.wits.ksw.launcher.view.id9als.listener.FocusTouchListener;

public class Id9ChangeModelOrWallpaperActivity extends AppCompatActivity {
    private String TAG = Id9ChangeModelOrWallpaperActivity.class.getName();
    private ActivityId9ChangeModelBinding activityBinding;
    private FocusTouchListener mOnTouchListener = new FocusTouchListener();
    private Id9ModelFragment modelFragment;
    private String selectModel;
    private View[] views = new View[2];
    private Id9WallpaperFragment wallpaperFragment;
    private int wallpaperSelectPosition = -1;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(this.TAG, "onCreate");
        setFull();
        setStatusBarTranslucent();
        ActivityId9ChangeModelBinding inflate = ActivityId9ChangeModelBinding.inflate(LayoutInflater.from(this));
        this.activityBinding = inflate;
        setContentView(inflate.getRoot());
        this.wallpaperSelectPosition = getIntent().getIntExtra("wallpaperSelectPosition", -1);
        this.modelFragment = new Id9ModelFragment();
        this.wallpaperFragment = new Id9WallpaperFragment();
        this.views[0] = this.activityBinding.id9ChangeTitleModel;
        this.views[1] = this.activityBinding.id9ChangeTitleWallpaper;
        this.selectModel = getIntent().getStringExtra("selectModel");
        Log.i(this.TAG, "onCreate selectModel: " + this.selectModel);
        if (TextUtils.isEmpty(this.selectModel)) {
            this.selectModel = Id9AlsConstants.ID9ALS_SKIN_MODEL;
        }
        replaceFragment(Id9AlsConstants.ID9ALS_SKIN_MODEL.equals(this.selectModel) ? this.modelFragment : this.wallpaperFragment, this.selectModel);
        setListener();
    }

    private void setListener() {
        this.activityBinding.id9ChangeTitleModel.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9ChangeModelOrWallpaperActivity$N3D3bCy3w8hXX6Cgzt0jheztDk */

            public final void onClick(View view) {
                Id9ChangeModelOrWallpaperActivity.this.lambda$setListener$0$Id9ChangeModelOrWallpaperActivity(view);
            }
        });
        this.activityBinding.id9ChangeTitleWallpaper.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9ChangeModelOrWallpaperActivity$J5F3sWQgerjDsn7enPbZCRNVts */

            public final void onClick(View view) {
                Id9ChangeModelOrWallpaperActivity.this.lambda$setListener$1$Id9ChangeModelOrWallpaperActivity(view);
            }
        });
        this.activityBinding.id9ChangeTitleModel.setOnTouchListener(this.mOnTouchListener);
        this.activityBinding.id9ChangeTitleWallpaper.setOnTouchListener(this.mOnTouchListener);
    }

    public /* synthetic */ void lambda$setListener$0$Id9ChangeModelOrWallpaperActivity(View view) {
        replaceFragment(this.modelFragment, Id9AlsConstants.ID9ALS_SKIN_MODEL);
    }

    public /* synthetic */ void lambda$setListener$1$Id9ChangeModelOrWallpaperActivity(View view) {
        replaceFragment(this.wallpaperFragment, Id9AlsConstants.ID9ALS_SKIN_WALLPAPER);
    }

    private void setModelTitle(int stringRes) {
        this.activityBinding.modelTitleTv.setText(stringRes);
    }

    public void setButtonSelected(View view) {
        View[] viewArr = this.views;
        int length = viewArr.length;
        for (int i = 0; i < length; i++) {
            View mView = viewArr[i];
            mView.setSelected(view == mView);
            if (mView instanceof TextView) {
                TextView tv = (TextView) mView;
                tv.setTextColor(getResources().getColor(tv.isSelected() ? R.color.id9_card_title : R.color.id9_font_gay));
                if (view == mView) {
                    tv.requestFocus();
                }
            }
        }
    }

    public void replaceFragment(Fragment fragment, String type) {
        Log.i(this.TAG, "replaceFragment type: " + type);
        this.selectModel = type;
        if (Id9AlsConstants.ID9ALS_SKIN_MODEL.equals(type)) {
            setModelTitle(R.string.id9_model_change);
            setButtonSelected(this.activityBinding.id9ChangeTitleModel);
        } else {
            setModelTitle(R.string.id9_personal_wallpaper);
            setButtonSelected(this.activityBinding.id9ChangeTitleWallpaper);
        }
        if (!fragment.isVisible()) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commitAllowingStateLoss();
        }
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
        Id9WallpaperFragment id9WallpaperFragment;
        super.onResume();
        int i = this.wallpaperSelectPosition;
        if (i > -1 && (id9WallpaperFragment = this.wallpaperFragment) != null) {
            id9WallpaperFragment.setAdapterSelectPosition(i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i(this.TAG, "onDestroy");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle outState) {
        Log.i(this.TAG, "onSaveInstanceState");
        Intent intent = getIntent();
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("selectModel", this.selectModel);
        Id9WallpaperFragment id9WallpaperFragment = this.wallpaperFragment;
        if (id9WallpaperFragment != null) {
            intent.putExtra("wallpaperSelectPosition", id9WallpaperFragment.getAdapterPosition());
        }
        super.onSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i(this.TAG, "onStop");
    }
}
