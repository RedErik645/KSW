package com.wits.ksw.settings.bmw_id9.layout;

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
import com.wits.ksw.databinding.BmwId9SettingsLanguageLayoutBinding;
import com.wits.ksw.launcher.utils.ScreenUtil;
import com.wits.ksw.settings.bmw_id9.adapter.BmwId9SettingsLanguageAdapter;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.id7.bean.FunctionBean;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BmwId9SettingsSystemLanguageLay extends RelativeLayout {
    private final String TAG = "BmwId9SettingsSystemLanguageLay";
    private Context context;
    private List<FunctionBean> data;
    private int defLanguage = 0;
    private LinearLayoutManager layoutManager;
    private List<Locale> locales;
    private BmwId9SettingsLanguageAdapter mAdapter;
    private BmwId9SettingsLanguageLayoutBinding mBinding;
    private BaseQuickAdapter.OnItemClickListener mOnItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemLanguageLay.AnonymousClass3 */

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Log.i("BmwId9SettingsSystemLanguageLay", " position " + position);
            for (FunctionBean fb : BmwId9SettingsSystemLanguageLay.this.data) {
                fb.setIscheck(false);
            }
            ((FunctionBean) BmwId9SettingsSystemLanguageLay.this.data.get(position)).setIscheck(true);
            BmwId9SettingsSystemLanguageLay.this.mAdapter.notifyDataSetChanged();
            BmwId9SettingsSystemLanguageLay.this.layoutManager.findViewByPosition(position).requestFocus();
            try {
                PowerManagerApp.setSettingsInt(KeyConfig.LANGUAGE_DEFUAL, position);
            } catch (Exception e) {
                e.getStackTrace();
            }
            MainActivity.settingLanguage = true;
        }
    };
    private BmwId9SettingsViewModel mViewModel;

    public BmwId9SettingsSystemLanguageLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BmwId9SettingsLanguageLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.bmw_id9_settings_language_layout, null, false);
        this.mBinding.getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BmwId9SettingsViewModel instance = BmwId9SettingsViewModel.getInstance();
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
                Log.d("BmwId9SettingsSystemLanguageLay", "=====:" + lang);
                FunctionBean fb = new FunctionBean();
                fb.setTitle(lang);
                this.data.add(fb);
            }
            this.data.get(this.defLanguage).setIscheck(true);
            Locale sysLanguage = Locale.getDefault();
            boolean ishave = false;
            int checkInex = -1;
            Log.d("BmwId9SettingsSystemLanguageLay", "21 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
            for (int i = 0; i < languags.size(); i++) {
                Log.d("BmwId9SettingsSystemLanguageLay", "language:" + this.locales.get(i).getLanguage() + "country:" + this.locales.get(i).getCountry());
                Log.d("BmwId9SettingsSystemLanguageLay", "22 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
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
        this.mBinding.bmwId9LanguageRecycle.setLayoutManager(this.layoutManager);
        this.mAdapter = new BmwId9SettingsLanguageAdapter(this.data);
        this.mBinding.bmwId9LanguageRecycle.setAdapter(this.mAdapter);
        this.mBinding.bmwId9LanguageRecycle.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemLanguageLay.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                Log.i("BmwId9SettingsSystemLanguageLay", " getItemOffsets position " + position);
                if (position != BmwId9SettingsSystemLanguageLay.this.data.size() - 1) {
                    outRect.bottom = -ScreenUtil.dip2px(4.5f);
                }
            }
        });
        this.mAdapter.setOnItemClickListener(this.mOnItemClickListener);
        this.mBinding.bmwId9LanguageRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemLanguageLay.AnonymousClass2 */

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0 && BmwId9SettingsSystemLanguageLay.this.mBinding.bmwId9LanguageRecycle.hasFocus()) {
                    int first = BmwId9SettingsSystemLanguageLay.this.layoutManager.findFirstCompletelyVisibleItemPosition();
                    int focusIndex = BmwId9SettingsSystemLanguageLay.this.mBinding.bmwId9LanguageRecycle.getChildAdapterPosition(BmwId9SettingsSystemLanguageLay.this.mBinding.bmwId9LanguageRecycle.getFocusedChild());
                    Log.e("BmwId9SettingsSystemLanguageLay", "onScrollStateChanged: focusIndex " + focusIndex + " first " + first);
                    if (focusIndex < 0 && first > -1) {
                        BmwId9SettingsSystemLanguageLay.this.layoutManager.findViewByPosition(first).requestFocus();
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
