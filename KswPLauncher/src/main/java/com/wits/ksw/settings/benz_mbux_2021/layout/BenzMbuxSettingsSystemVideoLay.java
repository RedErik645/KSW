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
import com.wits.ksw.databinding.BenzMbuxSettingsSystemVideoLayoutBinding;
import com.wits.ksw.launcher.bean.lexusls.LexusLsAppSelBean;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.AppInfoUtils;
import com.wits.ksw.launcher.utils.ScreenUtil;
import com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsAppListAdapter;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import java.util.List;

public class BenzMbuxSettingsSystemVideoLay extends RelativeLayout {
    private final String TAG = "BenzMbuxSettingsSystemVideoLay";
    private Context context;
    private BenzMbuxSettingsSystemVideoLayoutBinding mBinding;
    private LinearLayoutManager mLinearLayoutManager;
    private BenzMbuxSettingsViewModel mViewModel;

    public BenzMbuxSettingsSystemVideoLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsSystemVideoLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_system_video_layout, null, false);
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
            final List<LexusLsAppSelBean> listVideo = AppInfoUtils.findAllAppsByExclude(AppInfoUtils.ATYS_DISMISS_MUSIC, 2, this.context);
            final BenzMbuxSettingsAppListAdapter adapterMusic = new BenzMbuxSettingsAppListAdapter(listVideo);
            adapterMusic.setHasStableIds(true);
            this.mBinding.mbuxSettingsVideoRecycle.setAdapter(adapterMusic);
            this.mBinding.mbuxSettingsVideoRecycle.setItemAnimator(null);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
            this.mLinearLayoutManager = linearLayoutManager;
            linearLayoutManager.setOrientation(1);
            this.mBinding.mbuxSettingsVideoRecycle.setLayoutManager(this.mLinearLayoutManager);
            this.mBinding.mbuxSettingsVideoRecycle.addItemDecoration(new RecyclerView.ItemDecoration() {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemVideoLay.AnonymousClass1 */

                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    super.getItemOffsets(outRect, view, parent, state);
                    int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                    Log.i("BenzMbuxSettingsSystemVideoLay", " getItemOffsets position " + position);
                    if (position != listVideo.size() - 1) {
                        outRect.bottom = -ScreenUtil.dip2px(4.5f);
                    }
                }
            });
            adapterMusic.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemVideoLay.AnonymousClass2 */

                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Log.i("BenzMbuxSettingsSystemVideoLay", " position " + position);
                    for (LexusLsAppSelBean bean : listVideo) {
                        bean.setChecked(false);
                    }
                    ((LexusLsAppSelBean) listVideo.get(position)).setChecked(true);
                    adapterMusic.notifyDataSetChanged();
                    String pkg = ((LexusLsAppSelBean) listVideo.get(position)).getAppPkg();
                    String cls = ((LexusLsAppSelBean) listVideo.get(position)).getAppMainAty();
                    Settings.System.putString(BenzMbuxSettingsSystemVideoLay.this.context.getContentResolver(), KeyConfig.KEY_THIRD_APP_VIDEO_PKG, pkg);
                    Settings.System.putString(BenzMbuxSettingsSystemVideoLay.this.context.getContentResolver(), KeyConfig.KEY_THIRD_APP_VIDEO_CLS, cls);
                    if (cls.equals(KeyConfig.CLS_LOCAL_VIDEO)) {
                        LauncherViewModel.setThirdVideo(false);
                    } else {
                        LauncherViewModel.setThirdVideo(true);
                    }
                }
            });
            this.mBinding.mbuxSettingsVideoRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemVideoLay.AnonymousClass3 */

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState == 0 && BenzMbuxSettingsSystemVideoLay.this.mBinding.mbuxSettingsVideoRecycle.hasFocus()) {
                        int first = BenzMbuxSettingsSystemVideoLay.this.mLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
                        int focusIndex = BenzMbuxSettingsSystemVideoLay.this.mBinding.mbuxSettingsVideoRecycle.getChildAdapterPosition(BenzMbuxSettingsSystemVideoLay.this.mBinding.mbuxSettingsVideoRecycle.getFocusedChild());
                        Log.e("BenzMbuxSettingsSystemVideoLay", "onScrollStateChanged: focusIndex " + focusIndex + " first " + first);
                        if (focusIndex < 0 && first > -1) {
                            BenzMbuxSettingsSystemVideoLay.this.mLinearLayoutManager.findViewByPosition(first).requestFocus();
                        }
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                }
            });
            this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemVideoLay.AnonymousClass4 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BenzMbuxSettingsSystemVideoLay", "onGlobalFocusChanged: " + BenzMbuxSettingsSystemVideoLay.this.mBinding.mbuxSettingsVideoRecycle.hasFocus());
                    if (BenzMbuxSettingsSystemVideoLay.this.mBinding.mbuxSettingsVideoRecycle.hasFocus()) {
                        BenzMbuxSettingsSystemVideoLay.this.mViewModel.systemBgShow.set(false);
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
