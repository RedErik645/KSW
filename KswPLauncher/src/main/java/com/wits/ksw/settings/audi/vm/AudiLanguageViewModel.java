package com.wits.ksw.settings.audi.vm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.settings.id7.bean.FunctionBean;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AudiLanguageViewModel extends AndroidViewModel {
    private static final String TAG = ("KswApplication." + AudiLanguageViewModel.class.getSimpleName());
    private ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.settings.audi.vm.AudiLanguageViewModel.AnonymousClass1 */

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            AudiLanguageViewModel.this.languageChange.setValue(Locale.getDefault());
        }
    };
    private Context context;
    public MutableLiveData<Locale> languageChange = new MutableLiveData<>();
    public MutableLiveData<List<FunctionBean>> languageDatas = new MutableLiveData<>();
    private List<Locale> locales;

    public AudiLanguageViewModel(Application application) {
        super(application);
        Log.i(TAG, "AudiLanguageViewModel: ");
        Context applicationContext = application.getApplicationContext();
        this.context = applicationContext;
        applicationContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.LANGUAGE_DEFUAL), false, this.contentObserver);
        LocaleList();
    }

    public void updataLanguage() {
        try {
            int defLanguage = PowerManagerApp.getSettingsInt(KeyConfig.LANGUAGE_DEFUAL);
            Log.i(TAG, "defLanguage: " + defLanguage);
            List<FunctionBean> data = new ArrayList<>();
            List<String> languags = PowerManagerApp.getDataListFromJsonKey(KeyConfig.LANGUAGE_LIST);
            for (String lang : languags) {
                Log.d(TAG, "factory Language：" + lang);
                FunctionBean fb = new FunctionBean();
                fb.setTitle(lang);
                data.add(fb);
            }
            this.languageDatas.setValue(data);
            data.get(defLanguage).setIscheck(true);
            Locale sysLanguage = Locale.getDefault();
            Log.i(TAG, "System Language：" + sysLanguage.getDisplayName());
            boolean ishave = false;
            int checkInex = -1;
            Log.d("SystemLa", "11 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
            for (int i = 0; i < languags.size(); i++) {
                Log.d("SystemLa", "language:" + this.locales.get(i).getLanguage() + "country:" + this.locales.get(i).getCountry());
                Log.d("SystemLa", "12 la:" + sysLanguage.getLanguage() + "dw:" + sysLanguage.getCountry());
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
                for (FunctionBean lsg : data) {
                    lsg.setIscheck(false);
                }
                data.get(checkInex).setIscheck(true);
                return;
            }
            for (FunctionBean lsg2 : data) {
                lsg2.setIscheck(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.ViewModel
    public void onCleared() {
        this.context.getContentResolver().unregisterContentObserver(this.contentObserver);
        super.onCleared();
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
