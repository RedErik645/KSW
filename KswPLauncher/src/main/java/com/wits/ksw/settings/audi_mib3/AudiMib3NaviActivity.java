package com.wits.ksw.settings.audi_mib3;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiMib3NaviBinding;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3NaviVm;
import com.wits.ksw.settings.id7.bean.MapBean;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import java.util.Iterator;
import java.util.List;

public class AudiMib3NaviActivity extends AudiMib3SubActivity {
    private static final String TAG = ("KswApplication." + AudiMib3NaviActivity.class.getSimpleName());
    private NaviAdpater adpater;
    private AudiMib3NaviBinding binding;
    private AudiMib3NaviVm naviVm;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi_mib3.AudiMib3SubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (AudiMib3NaviBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_mib3_navi, null, false);
        this.contentLayout.addView(this.binding.getRoot(), -1, -1);
        this.naviVm = (AudiMib3NaviVm) ViewModelProviders.of(this).get(AudiMib3NaviVm.class);
        this.tv_title_set.setText(getResources().getString(R.string.item2));
        this.adpater = new NaviAdpater(this, null);
        this.binding.naviListView.setAdapter((ListAdapter) this.adpater);
        this.binding.naviListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.wits.ksw.settings.audi_mib3.AudiMib3NaviActivity.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                MapBean mapBean = (MapBean) parent.getItemAtPosition(position);
                FileUtils.savaStringData(KeyConfig.NAVI_DEFUAL, mapBean.getPackageName());
                Log.i(AudiMib3NaviActivity.TAG, "NaviApp: " + mapBean.getPackageName());
                List<MapBean> mapBeans = AudiMib3NaviActivity.this.naviVm.naviList.getValue();
                if (mapBeans != null && !mapBeans.isEmpty()) {
                    Iterator<MapBean> it = mapBeans.iterator();
                    while (it.hasNext()) {
                        MapBean mMapBean = it.next();
                        mMapBean.setCheck(mapBean == mMapBean);
                    }
                    AudiMib3NaviActivity.this.adpater.setMapBeans(mapBeans);
                    AudiMib3NaviActivity.this.adpater.notifyDataSetChanged();
                }
                Settings.System.putString(KswApplication.appContext.getContentResolver(), "wits_freedom_pkg", mapBean.getPackageName());
            }
        });
        this.naviVm.naviList.observe(this, new Observer<List<MapBean>>() {
            /* class com.wits.ksw.settings.audi_mib3.AudiMib3NaviActivity.AnonymousClass2 */

            public void onChanged(final List<MapBean> mapBeans) {
                Log.i(AudiMib3NaviActivity.TAG, "run: " + mapBeans.size());
                new Handler().post(new Runnable() {
                    /* class com.wits.ksw.settings.audi_mib3.AudiMib3NaviActivity.AnonymousClass2.AnonymousClass1 */

                    public void run() {
                        AudiMib3NaviActivity.this.adpater.setMapBeans(mapBeans);
                        AudiMib3NaviActivity.this.adpater.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public class NaviAdpater extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<MapBean> mapBeans;

        public NaviAdpater(Context context, List<MapBean> mapBeans2) {
            this.mapBeans = mapBeans2;
            this.layoutInflater = LayoutInflater.from(context);
        }

        public void setMapBeans(List<MapBean> mapBeans2) {
            this.mapBeans = mapBeans2;
        }

        public int getCount() {
            List<MapBean> list = this.mapBeans;
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return this.mapBeans.size();
        }

        public Object getItem(int position) {
            List<MapBean> list = this.mapBeans;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return this.mapBeans.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = this.layoutInflater.inflate(R.layout.audi_mib3_navi_item, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.radioButton = (RadioButton) convertView.findViewById(R.id.naviItemTitle);
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.naviItemIcon);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            MapBean mapBean = this.mapBeans.get(position);
            viewHolder.icon.setImageDrawable(mapBean.getMapicon());
            viewHolder.radioButton.setText(mapBean.getName());
            viewHolder.radioButton.setChecked(mapBean.isCheck());
            Log.i(AudiMib3NaviActivity.TAG, "getView: " + mapBean.getName());
            return convertView;
        }

        class ViewHolder {
            ImageView icon;
            RadioButton radioButton;

            ViewHolder() {
            }
        }
    }
}