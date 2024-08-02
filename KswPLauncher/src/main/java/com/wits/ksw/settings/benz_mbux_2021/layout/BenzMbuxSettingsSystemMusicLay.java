package com.wits.ksw.settings.benz_mbux_2021.layout;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BenzMbuxSettingsSystemMusicLayoutBinding;
import com.wits.ksw.launcher.bean.lexusls.LexusLsAppSelBean;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.AppInfoUtils;
import com.wits.ksw.launcher.utils.ScreenUtil;
import com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsAppListAdapter;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import java.util.List;

public class BenzMbuxSettingsSystemMusicLay extends RelativeLayout {
    private final String TAG = "BenzMbuxSettingsSystemMusicLay";
    private Context context;
    private BenzMbuxSettingsSystemMusicLayoutBinding mBinding;
    private LinearLayoutManager mLinearLayoutManager;
    private BenzMbuxSettingsViewModel mViewModel;

    public BenzMbuxSettingsSystemMusicLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsSystemMusicLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_system_music_layout, null, false);
        this.mBinding.getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BenzMbuxSettingsViewModel instance = BenzMbuxSettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        addView(this.mBinding.getRoot());
        initView();
        initData();
    }

    private void initView() {
        try {
            final List<LexusLsAppSelBean> listMusic = AppInfoUtils.findAllAppsByExclude(AppInfoUtils.ATYS_DISMISS_MUSIC, 1, this.context);
            final BenzMbuxSettingsAppListAdapter adapterMusic = new BenzMbuxSettingsAppListAdapter(listMusic);
            adapterMusic.setHasStableIds(true);
            this.mBinding.mbuxSettingsMusicRecycle.setAdapter(adapterMusic);
            this.mBinding.mbuxSettingsMusicRecycle.setItemAnimator(null);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
            this.mLinearLayoutManager = linearLayoutManager;
            linearLayoutManager.setOrientation(1);
            this.mBinding.mbuxSettingsMusicRecycle.setLayoutManager(this.mLinearLayoutManager);
            this.mBinding.mbuxSettingsMusicRecycle.addItemDecoration(new RecyclerView.ItemDecoration() {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemMusicLay.AnonymousClass1 */

                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    super.getItemOffsets(outRect, view, parent, state);
                    int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                    Log.i("BenzMbuxSettingsSystemMusicLay", " getItemOffsets position " + position);
                    if (position != listMusic.size() - 1) {
                        outRect.bottom = -ScreenUtil.dip2px(4.5f);
                    }
                }
            });
            adapterMusic.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemMusicLay.AnonymousClass2 */

                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Log.i("BenzMbuxSettingsSystemMusicLay", "onItemClick position " + position);
                    for (LexusLsAppSelBean bean : listMusic) {
                        bean.setChecked(false);
                    }
                    ((LexusLsAppSelBean) listMusic.get(position)).setChecked(true);
                    adapterMusic.notifyDataSetChanged();
                    String pkg = ((LexusLsAppSelBean) listMusic.get(position)).getAppPkg();
                    String cls = ((LexusLsAppSelBean) listMusic.get(position)).getAppMainAty();
                    Settings.System.putString(BenzMbuxSettingsSystemMusicLay.this.context.getContentResolver(), KeyConfig.KEY_THIRD_APP_MUSIC_PKG, pkg);
                    Settings.System.putString(BenzMbuxSettingsSystemMusicLay.this.context.getContentResolver(), KeyConfig.KEY_THIRD_APP_MUSIC_CLS, cls);
                    Settings.System.putString(BenzMbuxSettingsSystemMusicLay.this.context.getContentResolver(), "KEY_SHORTCUT_PKG_1", pkg);
                    Settings.System.putString(BenzMbuxSettingsSystemMusicLay.this.context.getContentResolver(), "KEY_SHORTCUT_CLS_1", cls);
                    if (cls.equals(KeyConfig.CLS_LOCAL_MUSIC)) {
                        LauncherViewModel.setThirdMusic(false);
                    } else {
                        LauncherViewModel.setThirdMusic(true);
                    }
                }
            });
            this.mBinding.mbuxSettingsMusicRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemMusicLay.AnonymousClass3 */

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState == 0 && BenzMbuxSettingsSystemMusicLay.this.mBinding.mbuxSettingsMusicRecycle.hasFocus()) {
                        int first = BenzMbuxSettingsSystemMusicLay.this.mLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
                        int focusIndex = BenzMbuxSettingsSystemMusicLay.this.mBinding.mbuxSettingsMusicRecycle.getChildAdapterPosition(BenzMbuxSettingsSystemMusicLay.this.mBinding.mbuxSettingsMusicRecycle.getFocusedChild());
                        Log.e("BenzMbuxSettingsSystemMusicLay", "onScrollStateChanged: focusIndex " + focusIndex + " first " + first);
                        if (focusIndex < 0 && first > -1) {
                            BenzMbuxSettingsSystemMusicLay.this.mLinearLayoutManager.findViewByPosition(first).requestFocus();
                        }
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                }
            });
            this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemMusicLay.AnonymousClass4 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BenzMbuxSettingsSystemMusicLay", "onGlobalFocusChanged: " + BenzMbuxSettingsSystemMusicLay.this.mBinding.mbuxSettingsMusicRecycle.hasFocus());
                    if (BenzMbuxSettingsSystemMusicLay.this.mBinding.mbuxSettingsMusicRecycle.hasFocus()) {
                        BenzMbuxSettingsSystemMusicLay.this.mViewModel.systemBgShow.set(false);
                    }
                }
            });
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void initData() {
    }
}
