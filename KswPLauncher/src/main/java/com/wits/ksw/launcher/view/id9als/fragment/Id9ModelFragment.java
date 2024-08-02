package com.wits.ksw.launcher.view.id9als.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FragmentId9ChangeModelBinding;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.Id9ChangeModelBean;
import com.wits.ksw.launcher.view.id9als.adapter.Id9ModelChangeBaseAdapter;
import com.wits.ksw.launcher.view.id9als.viewmodel.WallpaperSelectViewModel;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;

public class Id9ModelFragment extends Fragment {
    public static final String TAG = Id9ModelFragment.class.getName();
    private FragmentId9ChangeModelBinding binding;
    private WallpaperSelectViewModel viewModel;

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

    private void initView() {
        List<Id9ChangeModelBean> modelBeanList = new ArrayList<>();
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_mode_left_pic_1, getString(R.string.id9_model_noble), "1", Id9ChangeModelBean.ITEM_TYPE_MODEL));
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_mode_left_pic_2, getString(R.string.id9_model_passion), "2", Id9ChangeModelBean.ITEM_TYPE_MODEL));
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_mode_left_pic_3, getString(R.string.id9_model_comfort), "3", Id9ChangeModelBean.ITEM_TYPE_MODEL));
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_mode_left_pic_4, getString(R.string.id9_model_elegant), "4", Id9ChangeModelBean.ITEM_TYPE_MODEL));
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_mode_left_pic_5, getString(R.string.id9_model_vitality), Id9AlsConstants.ID9ALS_SELECT_MODEL_VITALITY, Id9ChangeModelBean.ITEM_TYPE_MODEL));
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_mode_left_pic_6, getString(R.string.id9_model_myste), Id9AlsConstants.ID9ALS_SELECT_MODEL_MYSTERIOUS, Id9ChangeModelBean.ITEM_TYPE_MODEL));
        modelBeanList.add(new Id9ChangeModelBean(R.drawable.id9_home_mode_left_pic_7, getString(R.string.id9_model_steady), Id9AlsConstants.ID9ALS_SELECT_MODEL_STEADY, Id9ChangeModelBean.ITEM_TYPE_MODEL));
        Id9ModelChangeBaseAdapter baseAdapter = new Id9ModelChangeBaseAdapter();
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.binding.recyclerView.setAdapter(baseAdapter);
        baseAdapter.setNewData(modelBeanList);
        baseAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            /* class com.wits.ksw.launcher.view.id9als.fragment.$$Lambda$Id9ModelFragment$90fO8qKe39WD427QPa_ZLps83OU */

            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Id9ModelFragment.lambda$initView$0(Id9ModelChangeBaseAdapter.this, baseQuickAdapter, view, i);
            }
        });
    }

    static /* synthetic */ void lambda$initView$0(Id9ModelChangeBaseAdapter baseAdapter, BaseQuickAdapter adapter, View view, int position) {
        Id9ChangeModelBean modelBean;
        if (view.getId() == R.id.picIv && (modelBean = (Id9ChangeModelBean) adapter.getItem(position)) != null) {
            try {
                PowerManagerApp.setSettingsString(Id9AlsConstants.ID9ALS_SKIN_MODEL, modelBean.getModelId());
                baseAdapter.setSelectPosition(position);
                baseAdapter.notifyDataSetChanged();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
