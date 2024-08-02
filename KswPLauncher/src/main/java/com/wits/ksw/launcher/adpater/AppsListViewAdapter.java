package com.wits.ksw.launcher.adpater;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.lexusls.LexusLsAppSelBean;
import com.wits.ksw.settings.utlis_view.RtlNaviRadioButton;
import java.util.List;

public class AppsListViewAdapter extends BaseAdapter {
    private Context context;
    private IAppsCheckListener iAppsCheckListener;
    private int layoutRes;
    private List<LexusLsAppSelBean> list;
    private LayoutInflater mInflater = null;

    public interface IAppsCheckListener {
        void checkedListener(String str, String str2, int i);
    }

    public AppsListViewAdapter(Context context2, List<LexusLsAppSelBean> list2, int res) {
        this.list = list2;
        this.context = context2;
        this.mInflater = LayoutInflater.from(context2);
        this.layoutRes = res;
    }

    public int getCount() {
        List<LexusLsAppSelBean> list2 = this.list;
        if (list2 == null) {
            return 0;
        }
        return list2.size();
    }

    public Object getItem(int position) {
        return this.list.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Drawable drawable;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = this.mInflater.inflate(this.layoutRes, (ViewGroup) null);
            holder.rbt_apps = (RtlNaviRadioButton) convertView.findViewById(R.id.rbt_apps);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (this.list.get(position).getAppIcon() == null) {
            drawable = this.context.getDrawable(R.mipmap.ic_launcher);
        } else {
            drawable = this.list.get(position).getAppIcon();
        }
        drawable.setBounds(0, 0, 50, 50);
        holder.rbt_apps.setCompoundDrawables(drawable, null, null, null);
        holder.rbt_apps.setText(this.list.get(position).getAppName());
        holder.rbt_apps.setCompoundDrawablePadding(10);
        holder.rbt_apps.setEnabled(true);
        holder.rbt_apps.setTextColor(ContextCompat.getColor(this.context, R.color.color1));
        holder.rbt_apps.setChecked(this.list.get(position).isChecked());
        if (position == 0) {
            holder.rbt_apps.requestFocus();
        }
        holder.rbt_apps.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.adpater.AppsListViewAdapter.AnonymousClass1 */

            public void onClick(View view) {
                for (LexusLsAppSelBean bean : AppsListViewAdapter.this.list) {
                    bean.setChecked(false);
                }
                ((LexusLsAppSelBean) AppsListViewAdapter.this.list.get(position)).setChecked(true);
                AppsListViewAdapter.this.notifyDataSetChanged();
                if (AppsListViewAdapter.this.iAppsCheckListener != null) {
                    AppsListViewAdapter.this.iAppsCheckListener.checkedListener(((LexusLsAppSelBean) AppsListViewAdapter.this.list.get(position)).getAppPkg(), ((LexusLsAppSelBean) AppsListViewAdapter.this.list.get(position)).getAppMainAty(), position);
                }
            }
        });
        holder.rbt_apps.setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.launcher.adpater.AppsListViewAdapter.AnonymousClass2 */

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode != 20 || position != AppsListViewAdapter.this.getCount() - 1) {
                    return false;
                }
                Log.i("AppListAdapter", "onBindViewHolder: position" + position + ", count:" + AppsListViewAdapter.this.getCount());
                return true;
            }
        });
        return convertView;
    }

    static class ViewHolder {
        public RtlNaviRadioButton rbt_apps;

        ViewHolder() {
        }
    }

    public void setAppsCheckListener(IAppsCheckListener listener) {
        this.iAppsCheckListener = listener;
    }
}
