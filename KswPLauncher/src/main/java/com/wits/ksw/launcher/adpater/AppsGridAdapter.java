package com.wits.ksw.launcher.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.lexusls.LexusLsAppSelBean;
import java.util.List;

public class AppsGridAdapter extends BaseAdapter {
    private Context context;
    private IAppsCheckListener iAppsCheckListener;
    private int layoutRes;
    private List<LexusLsAppSelBean> list;
    private LayoutInflater mInflater = null;

    public interface IAppsCheckListener {
        void checkedListener(String str, String str2, int i);
    }

    public AppsGridAdapter(List<LexusLsAppSelBean> list2, Context context2, int res) {
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

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = this.mInflater.inflate(this.layoutRes, (ViewGroup) null);
            holder.iv_app_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
            holder.tv_app_name = (TextView) convertView.findViewById(R.id.tv_app_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.iv_app_icon.setBackground(this.list.get(position).getAppIcon());
        holder.tv_app_name.setText(this.list.get(position).getAppName());
        return convertView;
    }

    static class ViewHolder {
        public ImageView iv_app_icon;
        public TextView tv_app_name;

        ViewHolder() {
        }
    }

    public void setAppsCheckListener(IAppsCheckListener listener) {
        this.iAppsCheckListener = listener;
    }
}
