package com.wits.ksw.settings.audi_mib3;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import com.wits.ksw.R;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3LanguageViewModel;
import com.wits.ksw.settings.id7.bean.FunctionBean;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.List;

public class AudiMib3LanguageActivity extends AudiMib3SubActivity {
    private static final String TAG = ("KswApplication." + AudiMib3LanguageActivity.class.getSimpleName());
    private LanguageAdpater adpater;
    private ListView audiLanguageListView;
    private AudiMib3LanguageViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi_mib3.AudiMib3SubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = LayoutInflater.from(this).inflate(R.layout.audi_mib3_language, (ViewGroup) null);
        this.contentLayout.addView(root, -1, -1);
        this.audiLanguageListView = (ListView) root.findViewById(R.id.audiLanguageListView);
        this.tv_title_set.setText(getResources().getString(R.string.audi_set_item_language_text));
        LanguageAdpater languageAdpater = new LanguageAdpater(this, null);
        this.adpater = languageAdpater;
        this.audiLanguageListView.setAdapter((ListAdapter) languageAdpater);
        AudiMib3LanguageViewModel audiMib3LanguageViewModel = (AudiMib3LanguageViewModel) ViewModelProviders.of(this).get(AudiMib3LanguageViewModel.class);
        this.viewModel = audiMib3LanguageViewModel;
        audiMib3LanguageViewModel.languageDatas.observe(this, new Observer<List<FunctionBean>>() {
            /* class com.wits.ksw.settings.audi_mib3.AudiMib3LanguageActivity.AnonymousClass1 */

            public void onChanged(List<FunctionBean> functionBeans) {
                Log.i(AudiMib3LanguageActivity.TAG, "onChanged: " + functionBeans);
                AudiMib3LanguageActivity.this.adpater.setLanguags(functionBeans);
                AudiMib3LanguageActivity.this.adpater.notifyDataSetChanged();
            }
        });
        this.audiLanguageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.wits.ksw.settings.audi_mib3.$$Lambda$AudiMib3LanguageActivity$IeEWpCNj4F6TN6l1OfTn9kHfMAI */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                AudiMib3LanguageActivity.this.lambda$onCreate$0$AudiMib3LanguageActivity(adapterView, view, i, j);
            }
        });
        this.viewModel.updataLanguage();
        Log.i(TAG, "onCreate: ");
    }

    public /* synthetic */ void lambda$onCreate$0$AudiMib3LanguageActivity(AdapterView parent, View view, final int position, long id) {
        new Handler().postDelayed(new Runnable() {
            /* class com.wits.ksw.settings.audi_mib3.AudiMib3LanguageActivity.AnonymousClass2 */

            public void run() {
                try {
                    Log.i(AudiMib3LanguageActivity.TAG, "setLanguage:" + position);
                    PowerManagerApp.setSettingsInt(KeyConfig.LANGUAGE_DEFUAL, position);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }, 260);
    }

    /* access modifiers changed from: package-private */
    public class LanguageAdpater extends BaseAdapter {
        private List<FunctionBean> languags;
        private LayoutInflater layoutInflater;

        public LanguageAdpater(Context context, List<FunctionBean> datas) {
            this.languags = datas;
            this.layoutInflater = LayoutInflater.from(context);
        }

        public void setLanguags(List<FunctionBean> languags2) {
            this.languags = languags2;
        }

        public int getCount() {
            List<FunctionBean> list = this.languags;
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return this.languags.size();
        }

        public Object getItem(int position) {
            List<FunctionBean> list = this.languags;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return this.languags.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = this.layoutInflater.inflate(R.layout.audi_mib3_language_item, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.radioButton = (RadioButton) convertView.findViewById(R.id.languageRadioButton);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            FunctionBean functionBean = this.languags.get(position);
            viewHolder.radioButton.setChecked(functionBean.isIscheck());
            viewHolder.radioButton.setText(functionBean.getTitle());
            return convertView;
        }

        class ViewHolder {
            public RadioButton radioButton;

            ViewHolder() {
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AudiMib3LanguageViewModel audiMib3LanguageViewModel = this.viewModel;
        if (audiMib3LanguageViewModel != null) {
            audiMib3LanguageViewModel.languageDatas.removeObservers(this);
        }
        super.onDestroy();
    }
}
