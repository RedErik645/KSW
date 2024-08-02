package com.wits.ksw.launcher.view.id9als.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityId9SelectWallpaperBinding;
import com.wits.ksw.launcher.bean.WallpaperPicBean;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.adapter.WallpaperAdapter;
import com.wits.ksw.launcher.view.id9als.listener.FocusTouchListener;
import com.wits.ksw.launcher.view.id9als.listener.WallpaperSelectDataChangeListener;
import com.wits.ksw.launcher.view.id9als.viewmodel.WallpaperSelectViewModel;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class Id9SelectWallpaperActivity extends AppCompatActivity {
    private String TAG = Id9SelectWallpaperActivity.class.getName();
    private ActivityId9SelectWallpaperBinding activityBinding;
    private int adapterSelectPosition = 0;
    private boolean isFirstDataChange = true;
    private GridLayoutManager layoutManager;
    private FocusTouchListener mOnTouchListener = new FocusTouchListener();
    private int scrollY = 0;
    private int storageScrollY = 0;
    private WallpaperSelectViewModel viewModel;
    private View[] views = new View[4];
    private WallpaperAdapter wallpaperAdapter;

    static /* synthetic */ int access$012(Id9SelectWallpaperActivity x0, int x1) {
        int i = x0.scrollY + x1;
        x0.scrollY = i;
        return i;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(this.TAG, "onCreate");
        setFull();
        setStatusBarTranslucent();
        ActivityId9SelectWallpaperBinding inflate = ActivityId9SelectWallpaperBinding.inflate(LayoutInflater.from(this));
        this.activityBinding = inflate;
        setContentView(inflate.getRoot());
        this.viewModel = (WallpaperSelectViewModel) ViewModelProviders.of(this).get(WallpaperSelectViewModel.class);
        this.layoutManager = new GridLayoutManager(this, 4);
        WallpaperAdapter wallpaperAdapter2 = new WallpaperAdapter(this.layoutManager, R.layout.item_id9_wallpaper_select_pic);
        this.wallpaperAdapter = wallpaperAdapter2;
        this.viewModel.initData(this, wallpaperAdapter2, false);
        this.activityBinding.setThemeViewModel(this.viewModel);
        this.activityBinding.recyclerView.setLayoutManager(this.layoutManager);
        this.activityBinding.recyclerView.setAdapter(this.wallpaperAdapter);
        this.wallpaperAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.ntg6v3_select_wallpaper_empt_view, (ViewGroup) null, false));
        int selectDevices = getIntent().getIntExtra("selectDevices", Id9AlsConstants.DEVICES_MODEL_LOC);
        this.storageScrollY = getIntent().getIntExtra("scrollY", 0);
        this.scrollY = 0;
        this.adapterSelectPosition = getIntent().getIntExtra("adapterSelectPosition", -1);
        View selectView = this.activityBinding.id9DevicesLocIb;
        if (selectDevices == Id9AlsConstants.DEVICES_MODEL_USB1) {
            selectView = this.activityBinding.id9DevicesUsb1Ib;
        } else if (selectDevices == Id9AlsConstants.DEVICES_MODEL_USB2) {
            selectView = this.activityBinding.id9DevicesUsb2Ib;
        } else if (selectDevices == Id9AlsConstants.DEVICES_MODEL_SD) {
            selectView = this.activityBinding.id9DevicesSdIb;
        }
        setListener();
        setButtonSelected(selectView, selectDevices);
        this.wallpaperAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9SelectWallpaperActivity$EVm1qzLmpqUJifhccoIQYRezsxg */

            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Id9SelectWallpaperActivity.this.lambda$onCreate$0$Id9SelectWallpaperActivity(baseQuickAdapter, view, i);
            }
        });
        this.activityBinding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.Id9SelectWallpaperActivity.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Id9SelectWallpaperActivity.access$012(Id9SelectWallpaperActivity.this, dy);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$Id9SelectWallpaperActivity(BaseQuickAdapter adapter, View view, int position) {
        WallpaperPicBean picBean;
        try {
            if (view.getId() == R.id.picIv && (picBean = (WallpaperPicBean) this.wallpaperAdapter.getItem(position)) != null) {
                PowerManagerApp.setSettingsString(Id9AlsConstants.ID9ALS_SKIN_WALLPAPER, "4");
                SpfUtils.saveData(Id9AlsConstants.ID9ALS_SKIN_WALLPAPER_PATH, picBean.getPath());
                this.wallpaperAdapter.setSelectPosition(position);
                this.viewModel.setWallpaperPic(picBean.getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setListener() {
        this.views[0] = this.activityBinding.id9DevicesLocIb;
        this.views[1] = this.activityBinding.id9DevicesUsb1Ib;
        this.views[2] = this.activityBinding.id9DevicesUsb2Ib;
        this.views[3] = this.activityBinding.id9DevicesSdIb;
        this.activityBinding.id9DevicesLocIb.setOnTouchListener(this.mOnTouchListener);
        this.activityBinding.id9DevicesUsb1Ib.setOnTouchListener(this.mOnTouchListener);
        this.activityBinding.id9DevicesUsb2Ib.setOnTouchListener(this.mOnTouchListener);
        this.activityBinding.id9DevicesSdIb.setOnTouchListener(this.mOnTouchListener);
        this.activityBinding.id9DevicesLocIb.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9SelectWallpaperActivity$sUd_ynedepn02xbnbbeSTqrU28 */

            public final void onClick(View view) {
                Id9SelectWallpaperActivity.this.lambda$setListener$1$Id9SelectWallpaperActivity(view);
            }
        });
        this.activityBinding.id9DevicesUsb1Ib.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9SelectWallpaperActivity$swlw501QH4Xfe1m7waErstWPzgw */

            public final void onClick(View view) {
                Id9SelectWallpaperActivity.this.lambda$setListener$2$Id9SelectWallpaperActivity(view);
            }
        });
        this.activityBinding.id9DevicesUsb2Ib.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9SelectWallpaperActivity$mwBONYPoVdgyn5Ovo8ASNX5vQKo */

            public final void onClick(View view) {
                Id9SelectWallpaperActivity.this.lambda$setListener$3$Id9SelectWallpaperActivity(view);
            }
        });
        this.activityBinding.id9DevicesSdIb.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.$$Lambda$Id9SelectWallpaperActivity$8BlGLBwqWnpVqmlmQ2FV8sq9rOQ */

            public final void onClick(View view) {
                Id9SelectWallpaperActivity.this.lambda$setListener$4$Id9SelectWallpaperActivity(view);
            }
        });
        this.viewModel.setWallpaperSelectDataChangeListener(new WallpaperSelectDataChangeListener() {
            /* class com.wits.ksw.launcher.view.id9als.activity.Id9SelectWallpaperActivity.AnonymousClass2 */

            @Override // com.wits.ksw.launcher.view.id9als.listener.WallpaperSelectDataChangeListener
            public void onWallpaperSelectDataChange() {
                if (Id9SelectWallpaperActivity.this.isFirstDataChange) {
                    Id9SelectWallpaperActivity.this.isFirstDataChange = false;
                    if (Id9SelectWallpaperActivity.this.adapterSelectPosition > 0) {
                        Id9SelectWallpaperActivity.this.wallpaperAdapter.setSelectPosition(Id9SelectWallpaperActivity.this.adapterSelectPosition);
                        Id9SelectWallpaperActivity.this.wallpaperAdapter.notifyItemChanged(Id9SelectWallpaperActivity.this.adapterSelectPosition);
                    }
                    Log.i(Id9SelectWallpaperActivity.this.TAG, "onWallpaperSelectDataChange storageScrollY: " + Id9SelectWallpaperActivity.this.storageScrollY);
                    if (Id9SelectWallpaperActivity.this.storageScrollY > 0) {
                        Id9SelectWallpaperActivity.this.activityBinding.recyclerView.scrollBy(0, Id9SelectWallpaperActivity.this.storageScrollY);
                    }
                }
            }

            @Override // com.wits.ksw.launcher.view.id9als.listener.WallpaperSelectDataChangeListener
            public void onDevicesRemove() {
                Id9SelectWallpaperActivity id9SelectWallpaperActivity = Id9SelectWallpaperActivity.this;
                id9SelectWallpaperActivity.setButtonSelected(id9SelectWallpaperActivity.activityBinding.id9DevicesLocIb, Id9AlsConstants.DEVICES_MODEL_LOC);
            }
        });
    }

    public /* synthetic */ void lambda$setListener$1$Id9SelectWallpaperActivity(View view) {
        setButtonSelected(view, Id9AlsConstants.DEVICES_MODEL_LOC);
    }

    public /* synthetic */ void lambda$setListener$2$Id9SelectWallpaperActivity(View view) {
        setButtonSelected(view, Id9AlsConstants.DEVICES_MODEL_USB1);
    }

    public /* synthetic */ void lambda$setListener$3$Id9SelectWallpaperActivity(View view) {
        setButtonSelected(view, Id9AlsConstants.DEVICES_MODEL_USB2);
    }

    public /* synthetic */ void lambda$setListener$4$Id9SelectWallpaperActivity(View view) {
        setButtonSelected(view, Id9AlsConstants.DEVICES_MODEL_SD);
    }

    public void setButtonSelected(View view, int deviceModel) {
        boolean z = false;
        this.views[0].setSelected(deviceModel == Id9AlsConstants.DEVICES_MODEL_LOC);
        this.views[1].setSelected(deviceModel == Id9AlsConstants.DEVICES_MODEL_USB1);
        this.views[2].setSelected(deviceModel == Id9AlsConstants.DEVICES_MODEL_USB2);
        View view2 = this.views[3];
        if (deviceModel == Id9AlsConstants.DEVICES_MODEL_SD) {
            z = true;
        }
        view2.setSelected(z);
        view.requestFocus();
        this.viewModel.onWallpaperModelIvClick(deviceModel);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle outState) {
        Log.i(this.TAG, "onSaveInstanceState");
        Intent intent = getIntent();
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("selectDevices", this.viewModel.wallpaperLeftModel.get());
        intent.putExtra("scrollY", this.scrollY);
        intent.putExtra("adapterSelectPosition", this.wallpaperAdapter.getSelectPosition());
        super.onSaveInstanceState(outState);
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
        this.viewModel.onActivityDestroy();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i(this.TAG, "onStop");
        this.viewModel.onActivityStop();
    }
}
