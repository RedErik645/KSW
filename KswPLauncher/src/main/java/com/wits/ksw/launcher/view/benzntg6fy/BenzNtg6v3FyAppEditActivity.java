package com.wits.ksw.launcher.view.benzntg6fy;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityNtg6v3AppEditMainBinding;
import com.wits.ksw.launcher.model.AppsLoaderTask;

public class BenzNtg6v3FyAppEditActivity extends AppCompatActivity {
    private static String TAG = "BenzNtg6v3FyAppEditActivity";
    private ActivityNtg6v3AppEditMainBinding appEditMainBinding;
    public BenzNtg6v3FyFragmentOne fragmentPage1;
    public BenzNtg6v3FyFragmentTwo fragmentPage2;
    private Ntg6v3AppEditViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFull();
        setStatusBarTranslucent();
        this.viewModel = (Ntg6v3AppEditViewModel) ViewModelProviders.of(this).get(Ntg6v3AppEditViewModel.class);
        ActivityNtg6v3AppEditMainBinding activityNtg6v3AppEditMainBinding = (ActivityNtg6v3AppEditMainBinding) DataBindingUtil.setContentView(this, R.layout.activity_ntg6v3_app_edit);
        this.appEditMainBinding = activityNtg6v3AppEditMainBinding;
        activityNtg6v3AppEditMainBinding.setAppEditViewModel(this.viewModel);
        this.viewModel.initData(this.appEditMainBinding, this);
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

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.viewModel.getIsNeedRefresh()) {
            Log.i(TAG, "can Refresh");
            AppsLoaderTask.getInstance().queryAllApps();
        }
        Log.i(TAG, "onDestroy");
    }
}
