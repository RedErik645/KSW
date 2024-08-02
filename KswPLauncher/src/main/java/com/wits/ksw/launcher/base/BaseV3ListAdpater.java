package com.wits.ksw.launcher.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.wits.ksw.KswApplication;
import java.util.List;

public class BaseV3ListAdpater<T> extends BaseAdapter {
    public LayoutInflater mInflater = LayoutInflater.from(KswApplication.appContext);
    public List<T> mlist;
    public int resId;

    public BaseV3ListAdpater(List<T> mlist2, int resId2) {
        Log.d("listadata", "BaseListAdpater() = " + mlist2.size() + " resId = " + resId2);
        this.mlist = mlist2;
        this.resId = resId2;
    }

    public void setData(List<T> mlist2) {
        this.mlist = mlist2;
    }

    public int getCount() {
        Log.d("listadata", "getCount() = " + this.mlist.size());
        List<T> list = this.mlist;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.mlist.size();
    }

    public Object getItem(int i) {
        Log.d("listadata", "getItem() = " + ((Object) this.mlist.get(i)));
        List<T> list = this.mlist;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.mlist.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewDataBinding binding;
        Log.d("listadata", "getView() 00000 ");
        if (convertView == null) {
            binding = DataBindingUtil.inflate(this.mInflater, this.resId, viewGroup, false);
            binding.getRoot().setTag(binding);
        } else {
            binding = (ViewDataBinding) convertView.getTag();
        }
        binding.setVariable(34, this.mlist.get(position));
        return binding.getRoot();
    }
}
