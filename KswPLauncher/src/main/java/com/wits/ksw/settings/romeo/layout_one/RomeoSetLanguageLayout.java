package com.wits.ksw.settings.romeo.layout_one;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.FixLinearSnapHelper;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.settings.id7.bean.FunctionBean;
import com.wits.ksw.settings.romeo.adapter.LanguageAdapter;
import com.wits.ksw.settings.romeo.interfaces.IUpdateListBg;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RomeoSetLanguageLayout extends RelativeLayout {
    private LanguageAdapter adapter;
    private Context context;
    private List<FunctionBean> data;
    private int defLanguage = 0;
    private LinearLayoutManager layoutManager;
    private List<Locale> locales;
    private RecyclerView recyclerView;
    private IUpdateListBg updateListBg;

    public RomeoSetLanguageLayout(Context context2) {
        super(context2);
        this.context = context2;
        View view = LayoutInflater.from(context2).inflate(R.layout.romeo_layout_set_language, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        LocaleList();
        initData();
        initView(view);
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    public void registIUpdateListBg(IUpdateListBg updateListBg2) {
        this.updateListBg = updateListBg2;
        this.adapter.setIUpdateListBg(updateListBg2);
    }

    private void initData() {
        try {
            this.defLanguage = PowerManagerApp.getSettingsInt(KeyConfig.LANGUAGE_DEFUAL);
            this.data = new ArrayList();
            List<String> languags = PowerManagerApp.getDataListFromJsonKey(KeyConfig.LANGUAGE_LIST);
            for (String lang : languags) {
                Log.d("SettingSetLaung", "=====:" + lang);
                FunctionBean fb = new FunctionBean();
                fb.setTitle(lang);
                this.data.add(fb);
            }
            this.data.get(this.defLanguage).setIscheck(true);
            Locale sysLanguage = Locale.getDefault();
            boolean ishave = false;
            int checkInex = -1;
            Log.d("SystemLa", "21 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
            for (int i = 0; i < languags.size(); i++) {
                Log.d("SystemLa", "language:" + this.locales.get(i).getLanguage() + "country:" + this.locales.get(i).getCountry());
                Log.d("SystemLa", "22 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
                if (TextUtils.equals(this.locales.get(i).getLanguage(), "zh")) {
                    if (!TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hans-HK") && !TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hans-TW") && !TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hans-MO")) {
                        if (!TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hans-CN")) {
                            if (!TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hant-HK") && !TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hant-TW") && !TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hant-MO")) {
                                if (!TextUtils.equals(sysLanguage.toLanguageTag(), "zh-Hant-CN")) {
                                    if (TextUtils.equals(sysLanguage.getCountry(), "CN")) {
                                        ishave = true;
                                        checkInex = 0;
                                    } else if (TextUtils.equals(sysLanguage.getCountry(), "TW")) {
                                        ishave = true;
                                        checkInex = 1;
                                    }
                                }
                            }
                            ishave = true;
                            checkInex = 1;
                        }
                    }
                    ishave = true;
                    checkInex = 0;
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
        }
    }

    private void initView(View view) {
        this.recyclerView = (RecyclerView) view.findViewById(R.id.language_recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setItemViewCacheSize(0);
        new FixLinearSnapHelper().attachToRecyclerView(this.recyclerView);
        LanguageAdapter languageAdapter = new LanguageAdapter(this.context, this.data);
        this.adapter = languageAdapter;
        this.recyclerView.setAdapter(languageAdapter);
        this.adapter.setIUpdateListBg(this.updateListBg);
        new DividerItemDecoration(this.context, 1).setDrawable(ContextCompat.getDrawable(this.context, R.drawable.lexus_settings_line_left));
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetLanguageLayout.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                    int pad = KswUtils.calculateTranslate(recyclerView.getChildAt(i).getTop(), KswUtils.dip2px(RomeoSetLanguageLayout.this.getContext(), 428.0f), i, RomeoSetLanguageLayout.this.getContext());
                    recyclerView.getChildAt(i).setPadding(pad, 0, pad, 0);
                }
            }
        });
        this.adapter.registOnFunctionClickListener(new LanguageAdapter.OnFunctionClickListener() {
            /* class com.wits.ksw.settings.romeo.layout_one.RomeoSetLanguageLayout.AnonymousClass2 */

            @Override // com.wits.ksw.settings.romeo.adapter.LanguageAdapter.OnFunctionClickListener
            public void functonClick(int pos) {
                for (FunctionBean fb : RomeoSetLanguageLayout.this.data) {
                    fb.setIscheck(false);
                }
                ((FunctionBean) RomeoSetLanguageLayout.this.data.get(pos)).setIscheck(true);
                try {
                    PowerManagerApp.setSettingsInt(KeyConfig.LANGUAGE_DEFUAL, pos);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        });
    }

    private void LocaleList() {
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
}