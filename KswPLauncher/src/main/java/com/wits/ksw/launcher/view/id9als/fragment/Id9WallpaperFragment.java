package com.wits.ksw.launcher.view.id9als.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FragmentId9ChangeModelBinding;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.Id9ChangeModelBean;
import com.wits.ksw.launcher.view.id9als.activity.Id9SelectWallpaperActivity;
import com.wits.ksw.launcher.view.id9als.adapter.Id9ModelChangeBaseAdapter;
import com.wits.ksw.launcher.view.id9als.viewmodel.WallpaperSelectViewModel;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;

public class Id9WallpaperFragment extends Fragment {
    public static final String TAG = Id9WallpaperFragment.class.getName();
    private Id9ModelChangeBaseAdapter baseAdapter;
    private FragmentId9ChangeModelBinding binding;
    private WallpaperSelectViewModel viewModel;

    public void setAdapterSelectPosition(int wallpaperSelectPosition) {
        Id9ModelChangeBaseAdapter id9ModelChangeBaseAdapter = this.baseAdapter;
        if (id9ModelChangeBaseAdapter != null) {
            id9ModelChangeBaseAdapter.setSelectPosition(wallpaperSelectPosition);
            this.baseAdapter.notifyItemChanged(wallpaperSelectPosition);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentId9ChangeModelBinding inflate = FragmentId9ChangeModelBinding.inflate(inflater, container, false);
        this.binding = inflate;
        return inflate.getRoot();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        WallpaperSelectViewModel wallpaperSelectViewModel = (WallpaperSelectViewModel) ViewModelProviders.of(this).get(WallpaperSelectViewModel.class);
        this.viewModel = wallpaperSelectViewModel;
        wallpaperSelectViewModel.initData(getContext());
        initView();
    }

    public int getAdapterPosition() {
        Id9ModelChangeBaseAdapter id9ModelChangeBaseAdapter = this.baseAdapter;
        if (id9ModelChangeBaseAdapter != null) {
            return id9ModelChangeBaseAdapter.getSelectPosition();
        }
        return -1;
    }

    private void initView() {
        List<Id9ChangeModelBean> modelBeanList = new ArrayList<>();
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_wall_pic_1, getString(R.string.default_wallpaper), "1", Id9ChangeModelBean.ITEM_TYPE_WALLPAPER));
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_wall_pic_2, getString(R.string.ntg6v3_wallpaper_name_2), "2", Id9ChangeModelBean.ITEM_TYPE_WALLPAPER));
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_wall_pic_3, getString(R.string.id9_select_wallpaper_3), "3", Id9ChangeModelBean.ITEM_TYPE_WALLPAPER));
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_wall_pic_add, getString(R.string.ntg6v3_wallpaper_name_custom), "4", Id9ChangeModelBean.ITEM_TYPE_WALLPAPER));
        this.baseAdapter = new Id9ModelChangeBaseAdapter();
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.binding.recyclerView.setAdapter(this.baseAdapter);
        this.baseAdapter.setNewData(modelBeanList);
        this.baseAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9WallpaperFragment$4uU5yxXZNxFj9d9ftqwdktmG13M */

            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Id9WallpaperFragment.this.lambda$initView$0$Id9WallpaperFragment(baseQuickAdapter, view, i);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$Id9WallpaperFragment(BaseQuickAdapter adapter, View view, int position) {
        Id9ChangeModelBean modelBean;
        if (view.getId() == R.id.picIv && (modelBean = (Id9ChangeModelBean) adapter.getItem(position)) != null) {
            try {
                if (!"4".equals(modelBean.getModelId())) {
                    PowerManagerApp.setSettingsString(Id9AlsConstants.ID9ALS_SKIN_WALLPAPER, modelBean.getModelId());
                    this.baseAdapter.setSelectPosition(position);
                    this.baseAdapter.notifyDataSetChanged();
                    int ill = PowerManagerApp.getStatusInt("ill");
                    if ("1".equals(modelBean.getModelId())) {
                        this.viewModel.setWallpaperPic(ill == 1 ? R.drawable.id9_nav_bg : R.drawable.id9_nav_bg_white);
                    } else if ("2".equals(modelBean.getModelId())) {
                        this.viewModel.setWallpaperPic(R.drawable.id9_bg);
                    } else if ("3".equals(modelBean.getModelId())) {
                        this.viewModel.setWallpaperPic(R.drawable.id9_bg);
                    }
                    return;
                }
                startActivity(new Intent(getContext(), Id9SelectWallpaperActivity.class));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
        this.viewModel.onActivityStop();
    }
}
