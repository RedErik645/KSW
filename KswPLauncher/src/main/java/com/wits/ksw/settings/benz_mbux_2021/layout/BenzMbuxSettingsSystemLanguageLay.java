package com.wits.ksw.settings.benz_mbux_2021.layout;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.MainActivity;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BenzMbuxSettingsLanguageLayoutBinding;
import com.wits.ksw.launcher.utils.ScreenUtil;
import com.wits.ksw.settings.benz_mbux_2021.adater.BenzMbuxSettingsLanguageAdapter;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.id7.bean.FunctionBean;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BenzMbuxSettingsSystemLanguageLay extends RelativeLayout {
    private final String TAG = "BenzMbuxSettingsSystemLanguageLay";
    private Context context;
    private List<FunctionBean> data;
    private int defLanguage = 0;
    private LinearLayoutManager layoutManager;
    private List<Locale> locales;
    private BenzMbuxSettingsLanguageAdapter mAdapter;
    private BenzMbuxSettingsLanguageLayoutBinding mBinding;
    private BaseQuickAdapter.OnItemClickListener mOnItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemLanguageLay.AnonymousClass3 */

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Log.i("BenzMbuxSettingsSystemLanguageLay", " position " + position);
            for (FunctionBean fb : BenzMbuxSettingsSystemLanguageLay.this.data) {
                fb.setIscheck(false);
            }
            ((FunctionBean) BenzMbuxSettingsSystemLanguageLay.this.data.get(position)).setIscheck(true);
            BenzMbuxSettingsSystemLanguageLay.this.mAdapter.notifyDataSetChanged();
            BenzMbuxSettingsSystemLanguageLay.this.layoutManager.findViewByPosition(position).requestFocus();
            try {
                PowerManagerApp.setSettingsInt(KeyConfig.LANGUAGE_DEFUAL, position);
            } catch (Exception e) {
                e.getStackTrace();
            }
            MainActivity.settingLanguage = true;
        }
    };
    private BenzMbuxSettingsViewModel mViewModel;

    public BenzMbuxSettingsSystemLanguageLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsLanguageLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_language_layout, null, false);
        this.mBinding.getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BenzMbuxSettingsViewModel instance = BenzMbuxSettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        addView(this.mBinding.getRoot());
        initLanguages();
        initData();
        initView();
    }

    public void initLanguages() {
        ArrayList arrayList = new ArrayList();
        this.locales = arrayList;
        arrayList.add(new Locale("zh", "CN"));
        this.locales.add(new Locale("zh", "TW"));
        this.locales.add(new Locale("en"));
        this.locales.add(new Locale("de"));
        this.locales.add(new Locale("es"));
        this.locales.add(Locale.KOREA);
        this.locales.add(new Locale("it"));
        this.locales.add(new Locale("nl"));
        this.locales.add(new Locale("ru"));
        this.locales.add(new Locale("fr"));
        this.locales.add(new Locale("pt"));
        this.locales.add(new Locale("tr"));
        this.locales.add(new Locale("vi"));
        this.locales.add(new Locale("pl"));
        this.locales.add(new Locale("ar"));
        this.locales.add(new Locale("ja"));
        this.locales.add(new Locale("iw", "IL"));
        this.locales.add(new Locale("el"));
        this.locales.add(new Locale("th"));
        this.locales.add(new Locale("hr"));
        this.locales.add(new Locale("cs"));
    }

    private void initData() {
        try {
            this.defLanguage = PowerManagerApp.getSettingsInt(KeyConfig.LANGUAGE_DEFUAL);
            this.data = new ArrayList();
            List<String> languags = PowerManagerApp.getDataListFromJsonKey(KeyConfig.LANGUAGE_LIST);
            for (String lang : languags) {
                Log.d("BenzMbuxSettingsSystemLanguageLay", "=====:" + lang);
                FunctionBean fb = new FunctionBean();
                fb.setTitle(lang);
                this.data.add(fb);
            }
            this.data.get(this.defLanguage).setIscheck(true);
            Locale sysLanguage = Locale.getDefault();
            boolean ishave = false;
            int checkInex = -1;
            Log.d("BenzMbuxSettingsSystemLanguageLay", "21 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
            for (int i = 0; i < languags.size(); i++) {
                Log.d("BenzMbuxSettingsSystemLanguageLay", "language:" + this.locales.get(i).getLanguage() + "country:" + this.locales.get(i).getCountry());
                Log.d("BenzMbuxSettingsSystemLanguageLay", "22 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
                if (TextUtils.equals(this.locales.get(i).getLanguage(), "zh")) {
                    if (TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hans-HK") || TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hans-TW") || TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hans-MO") || TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hans-CN")) {
                        ishave = true;
                        checkInex = 0;
                    } else if (TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hant-HK") || TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hant-TW") || TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hant-MO") || TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hant-CN")) {
                        ishave = true;
                        checkInex = 1;
                    } else if (TextUtils.equals(sysLanguage.getCountry(), "CN")) {
                        ishave = true;
                        checkInex = 0;
                    } else if (TextUtils.equals(sysLanguage.getCountry(), "TW")) {
                        ishave = true;
                        checkInex = 1;
                    }
                } else if (TextUtils.equals(this.locales.get(i).getLanguage(), sysLanguage.getLanguage())) {
                    ishave = true;
                    checkInex = i;
                }
            }
            if (ishave) {
                for (FunctionBean lsg : this.data) {
                    lsg.setIscheck(false);
                }
                this.data.get(checkInex).setIscheck(true);
                return;
            }
            for (FunctionBean lsg2 : this.data) {
                lsg2.setIscheck(false);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.mBinding.mbuxLanguageRecycle.setLayoutManager(this.layoutManager);
        this.mAdapter = new BenzMbuxSettingsLanguageAdapter(this.data);
        this.mBinding.mbuxLanguageRecycle.setAdapter(this.mAdapter);
        this.mBinding.mbuxLanguageRecycle.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemLanguageLay.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                Log.i("BenzMbuxSettingsSystemLanguageLay", " getItemOffsets position " + position);
                if (position != BenzMbuxSettingsSystemLanguageLay.this.data.size() - 1) {
                    outRect.bottom = -ScreenUtil.dip2px(4.5f);
                }
            }
        });
        this.mAdapter.setOnItemClickListener(this.mOnItemClickListener);
        this.mBinding.mbuxLanguageRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemLanguageLay.AnonymousClass2 */

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0 && BenzMbuxSettingsSystemLanguageLay.this.mBinding.mbuxLanguageRecycle.hasFocus()) {
                    int first = BenzMbuxSettingsSystemLanguageLay.this.layoutManager.findFirstCompletelyVisibleItemPosition();
                    int focusIndex = BenzMbuxSettingsSystemLanguageLay.this.mBinding.mbuxLanguageRecycle.getChildAdapterPosition(BenzMbuxSettingsSystemLanguageLay.this.mBinding.mbuxLanguageRecycle.getFocusedChild());
                    Log.e("BenzMbuxSettingsSystemLanguageLay", "onScrollStateChanged: focusIndex " + focusIndex + " first " + first);
                    if (focusIndex < 0 && first > -1) {
                        BenzMbuxSettingsSystemLanguageLay.this.layoutManager.findViewByPosition(first).requestFocus();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
