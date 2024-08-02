package com.wits.ksw.settings.lexus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wits.ksw.R;
import com.wits.ksw.settings.id7.bean.UiSelectBean;
import java.util.List;

public class UiSelectAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = UiSelectAdapter.class.getName();
    private Context context;
    private List<UiSelectBean> data;
    private OnFunctionClickListener functionClickListener;

    public interface OnFunctionClickListener {
        void functonClick(int i);
    }

    public void registOnFunctionClickListener(OnFunctionClickListener clickListener) {
        this.functionClickListener = clickListener;
    }

    public UiSelectAdapter(Context context2, List<UiSelectBean> appInfoList) {
        this.context = context2;
        this.data = appInfoList;
        Log.i(TAG, "FunctionAdapter: ");
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_ui_select, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.context).load(this.data.get(position).getUiPath()).skipMemoryCache(true)).diskCacheStrategy(DiskCacheStrategy.NONE)).into(holder.img_UiSelct);
        if (this.functionClickListener != null) {
            holder.img_UiSelct.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.settings.lexus.adapter.UiSelectAdapter.AnonymousClass1 */

                public void onClick(View v) {
                    UiSelectAdapter.this.functionClickListener.functonClick(position);
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<UiSelectBean> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_UiSelct;

        public ViewHolder(View itemView) {
            super(itemView);
            this.img_UiSelct = (ImageView) itemView.findViewById(R.id.img_UiSelct);
        }
    }
}
